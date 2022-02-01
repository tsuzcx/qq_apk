package com.tencent.mobileqq.app;

import QQService.InstanceInfo;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.dataline.compatible.IDatalineFileReqCallback;
import com.dataline.core.DirectForwarder;
import com.dataline.core.MoloHandler;
import com.dataline.data.PrinterManager;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.QualityReportUtil;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.biz.qrcode.logindev.LoginDevItem;
import com.tencent.biz.qrcode.logindev.LoginDevicesManager;
import com.tencent.biz.qrcode.logindev.LoginDevicesManager.IDevListRefreshListener;
import com.tencent.biz.qrcode.logindev.LoginDevicesUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.C2CMessageProcessor;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.FTNNotify;
import com.tencent.litetransfersdk.FileControl;
import com.tencent.litetransfersdk.LiteTransferListenerCallback;
import com.tencent.litetransfersdk.LiteTransferOperatorCallback;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.litetransfersdk.MsgCSBody0x211;
import com.tencent.litetransfersdk.MsgCSBody0x211_0x7;
import com.tencent.litetransfersdk.MsgCSBody0x345;
import com.tencent.litetransfersdk.MsgCSBody0x346;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.MsgSCBody;
import com.tencent.litetransfersdk.MsgSCBody0x211;
import com.tencent.litetransfersdk.MsgSCBody0x211_0x7;
import com.tencent.litetransfersdk.MsgSCBody0x345;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.NFCNotify;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.RFCInfoNotify;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.litetransfersdk.Session;
import com.tencent.litetransfersdk.SubCmd0x6ReqBody;
import com.tencent.litetransfersdk.SubCmd0x6RspBody;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePathUtil;
import com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupPushHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.TextMsgPush;
import com.tencent.mobileqq.service.TextMsgTask;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.Long;>;
import java.util.Locale;
import java.util.Set;
import java.util.Timer;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x6RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.FileQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FTNNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FileControl;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MoloNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MpFileNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.NFCNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.RNFCNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;

public class DataLineHandler
  extends BusinessHandler
  implements LoginDevicesManager.IDevListRefreshListener, LiteTransferListenerCallback, LiteTransferOperatorCallback
{
  private static int H;
  private static int J;
  private Set<String> A = new HashSet();
  private int B = 0;
  private boolean C = false;
  private int D = 0;
  private LoginDevicesManager E;
  private long F = -1L;
  private long G = -1L;
  private Timer I;
  private MessageObserver K = new DataLineHandler.9(this);
  private HashMap<Long, Session> L = new HashMap();
  private int M;
  private int N;
  protected HashMap<Long, TextMsgPush> a = new HashMap();
  public String b = AppConstants.DATALINE_PC_UIN;
  public int c = 0;
  protected LiteTransferWrapper d = new LiteTransferWrapper(this, this);
  public PrinterHandler e = null;
  public boolean f = false;
  protected ProtocolHelper g;
  public PrinterManager h;
  public QQAppInterface i;
  private ArrayList<TextMsgTask> j = new ArrayList();
  private int k = 0;
  private MoloHandler l = new MoloHandler(this);
  private DirectForwarder m = null;
  private List<Long> n;
  private List<Long> o;
  private BroadcastReceiver p = null;
  private BroadcastReceiver q = null;
  private INetInfoHandler r = null;
  private boolean s = false;
  private boolean t = false;
  private long u = 0L;
  private long v = 0L;
  private ArrayList<Integer> w = new ArrayList();
  private List<Integer> x = new ArrayList();
  private DatalineRemoteManager y;
  private boolean z = false;
  
  public DataLineHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.i = paramQQAppInterface;
    this.e = new PrinterHandler(paramQQAppInterface);
    this.h = new PrinterManager(paramQQAppInterface);
    this.m = new DirectForwarder(paramQQAppInterface);
    this.M = BaseApplication.getContext().getResources().getDimensionPixelSize(2131297157);
    this.N = BaseApplication.getContext().getResources().getDimensionPixelSize(2131297156);
    v();
    this.p = new DataLineHandler.1(this);
    this.q = new DataLineHandler.2(this, paramQQAppInterface);
    this.r = new DataLineHandler.3(this);
    this.g = new ProtocolHelper(paramQQAppInterface, 0);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqq.intent.action.EXIT_");
    localStringBuilder.append(paramQQAppInterface.getApp().getPackageName());
    localIntentFilter.addAction(localStringBuilder.toString());
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    paramQQAppInterface.getApp().registerReceiver(this.q, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
    localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addDataScheme("file");
    paramQQAppInterface.getApp().registerReceiver(this.p, localIntentFilter);
    a(paramQQAppInterface);
    paramQQAppInterface.addObserver(this.K);
    this.y = new DatalineRemoteManager(paramQQAppInterface);
    s();
    t();
    this.E = ((LoginDevicesManager)paramQQAppInterface.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER));
    this.E.a(this);
    this.z = false;
  }
  
  private int a(MsgHeader paramMsgHeader)
  {
    if (paramMsgHeader == null) {
      return 65793;
    }
    int i1 = paramMsgHeader.uint32_src_ter_type;
    if (i1 != 2)
    {
      if (i1 != 3) {
        return 65793;
      }
      return 68361;
    }
    return 67586;
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    int i2 = 2;
    if (paramFileManagerEntity == null)
    {
      QLog.i("DataLineHandler", 2, "转发文件, FileManagerEntity为空");
      return 255;
    }
    int i1;
    StringBuilder localStringBuilder;
    if ((!TextUtils.isEmpty(paramFileManagerEntity.getFilePath())) && (new File(paramFileManagerEntity.getFilePath()).exists()))
    {
      i1 = 0;
    }
    else
    {
      int i3 = paramFileManagerEntity.getCloudType();
      if (i3 != 10) {
        i1 = i2;
      }
      switch (i3)
      {
      default: 
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("FileManagerEntity->cloudType 转 ForwardFileInfo->type， 未识别的cloudType[");
          localStringBuilder.append(paramFileManagerEntity.getCloudType());
          QLog.e("dataline", 2, localStringBuilder.toString());
        }
      case 3: 
      case 5: 
      case 6: 
      case 7: 
        i1 = 255;
        break;
      case 2: 
        i1 = 4;
        break;
      case 1: 
        i3 = paramFileManagerEntity.peerType;
        if (i3 != 0)
        {
          i1 = i2;
          if (i3 == 1) {
            break label371;
          }
          if (i3 == 3000) {
            break label363;
          }
          if (i3 == 6000) {
            break label358;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("转发文件, 未知的文件来源默认为C2C, peerType[");
            localStringBuilder.append(paramFileManagerEntity.peerType);
            localStringBuilder.append("]， name[");
            localStringBuilder.append(paramFileManagerEntity.fileName);
            localStringBuilder.append("], LocalPath[");
            localStringBuilder.append(paramFileManagerEntity.getFilePath());
            localStringBuilder.append("], FileSize[");
            localStringBuilder.append(paramFileManagerEntity.fileSize);
            localStringBuilder.append("], fileFrom[");
            localStringBuilder.append(1);
            localStringBuilder.append("], peerUin[");
            localStringBuilder.append(paramFileManagerEntity.peerUin);
            localStringBuilder.append("], cloudType[");
            localStringBuilder.append(paramFileManagerEntity.getCloudType());
            QLog.i("DataLineHandler", 2, localStringBuilder.toString());
          }
        }
        i1 = 1;
        break label371;
        label358:
        i1 = 5;
        break label371;
        label363:
        i1 = 3;
        break label371;
        i1 = 6;
      }
    }
    label371:
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("是否可以转发到数据线, [");
      localStringBuilder.append(paramFileManagerEntity.peerType);
      localStringBuilder.append("]， name[");
      localStringBuilder.append(paramFileManagerEntity.fileName);
      localStringBuilder.append("], LocalPath[");
      localStringBuilder.append(paramFileManagerEntity.getFilePath());
      localStringBuilder.append("], FileSize[");
      localStringBuilder.append(paramFileManagerEntity.fileSize);
      localStringBuilder.append("], fileFrom[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], peerType[");
      localStringBuilder.append(paramFileManagerEntity.peerType);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(paramFileManagerEntity.peerUin);
      localStringBuilder.append("], cloudType[");
      localStringBuilder.append(paramFileManagerEntity.getCloudType());
      QLog.i("DataLineHandler", 4, localStringBuilder.toString());
    }
    return i1;
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    int i2 = FileManagerUtil.c(paramString);
    int i1 = 2;
    if (i2 != 0) {
      if (i2 != 1)
      {
        if (i2 == 2) {
          return i1;
        }
        if (!paramBoolean) {
          return 0;
        }
      }
      else
      {
        return 3;
      }
    }
    i1 = 1;
    return i1;
  }
  
  private ToServiceMsg a(boolean paramBoolean, int paramInt, long paramLong, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putBoolean("ISFROM_DATALINE", true);
    localToServiceMsg.extraData.putInt("DATALINE_CMD", paramInt);
    localToServiceMsg.addAttribute("cookie", Long.valueOf(paramLong));
    localToServiceMsg.addAttribute("sendFromNative", Boolean.valueOf(paramBoolean));
    localToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", 0);
    localToServiceMsg.putWupBuffer(paramPbSendMsgReq.toByteArray());
    sendPbReq(localToServiceMsg);
    return localToServiceMsg;
  }
  
  private msg_svc.PbSendMsgReq a(int paramInt1, String paramString, TransMsgContext paramTransMsgContext, long paramLong1, int paramInt2, long paramLong2)
  {
    return MessageProtoCodec.a(this.i, paramInt1, paramString, paramTransMsgContext, paramLong1, paramInt2);
  }
  
  private msg_svc.PbSendMsgReq a(String paramString, int paramInt1, byte[] paramArrayOfByte, long paramLong, int paramInt2)
  {
    long l1 = FileManagerUtil.g();
    long l2 = FileManagerUtil.f();
    TransMsgContext localTransMsgContext = new TransMsgContext();
    localTransMsgContext.a = paramInt1;
    localTransMsgContext.b = paramArrayOfByte;
    paramString = a(13, paramString, localTransMsgContext, l2, MessageUtils.b(l1), paramLong);
    paramArrayOfByte = new im_msg_head.InstInfo();
    if (paramInt2 == 3) {
      paramInt1 = 1001;
    } else {
      paramInt1 = 1;
    }
    paramArrayOfByte.uint32_apppid.set(paramInt1);
    paramArrayOfByte.uint32_instid.set(0);
    paramArrayOfByte.enum_device_type.set(paramInt2);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(paramArrayOfByte);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(1001);
    paramArrayOfByte.uint32_instid.set(AppSetting.d());
    paramArrayOfByte.enum_device_type.set(2);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.msg_from_inst = paramArrayOfByte;
    paramString.routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    return paramString;
  }
  
  private void a(int paramInt, long paramLong, String paramString)
  {
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.i.getMessageFacade().d(i1).a(paramLong);
    if (localDataLineMsgRecord == null) {
      return;
    }
    if (paramInt == 0)
    {
      localDataLineMsgRecord.thumbPath = paramString;
      if (!localDataLineMsgRecord.isSend())
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("uSessionID[");
          paramString.append(paramLong);
          paramString.append("]OnSessionThumbUpdate: update");
          QLog.d("DataLineHandler", 2, paramString.toString());
        }
        a(10, true, new Object[] { Long.valueOf(paramLong) });
      }
    }
    else
    {
      if (paramInt == 1)
      {
        localDataLineMsgRecord.serverPath = paramString;
        this.i.getMessageFacade().d(i1).a(localDataLineMsgRecord.msgId, localDataLineMsgRecord.serverPath, localDataLineMsgRecord.md5);
        return;
      }
      if (paramInt == 2)
      {
        localDataLineMsgRecord.md5 = HexUtil.hexStr2Bytes(paramString);
        if ((QLog.isDevelopLevel()) && (localDataLineMsgRecord.md5 != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("SessionUpdateType_FileMD5, uSessionID[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("], strValuebuf[");
          localStringBuilder.append(paramString);
          localStringBuilder.append("], strMD5MR[");
          localStringBuilder.append(HexUtil.bytes2HexStr(localDataLineMsgRecord.md5));
          localStringBuilder.append("], strMD5Notify");
          localStringBuilder.append(paramString);
          QLog.d("DataLineHandler", 4, localStringBuilder.toString());
        }
        this.i.getMessageFacade().d(i1).a(localDataLineMsgRecord.msgId, localDataLineMsgRecord.serverPath, localDataLineMsgRecord.md5);
      }
    }
  }
  
  private void a(int paramInt1, FTNNotify paramFTNNotify, long paramLong, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.g.MsgBodyFromFTNNotify(paramFTNNotify, paramLong, this.b, paramInt2);
    a(paramInt1, 1004, localMsgBody, paramFTNNotify.uint64_sessionid);
  }
  
  private void a(int paramInt1, FileControl paramFileControl, long paramLong, int paramInt2)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      return;
    }
    SubMsgType0x7.MsgBody localMsgBody = this.g.MsgBodyFromFileControl(paramFileControl, paramLong, this.b, paramInt2);
    a(paramInt1, 1005, localMsgBody, paramFileControl.uint64_sessionid);
  }
  
  private void a(int paramInt, MsgCSBody0x211 paramMsgCSBody0x211)
  {
    if (paramMsgCSBody0x211.uMsgSubType != 7)
    {
      QLog.d("DataLineHandler", 1, "SendPbMsg: cannot recognize the pb msg form 0X211");
      return;
    }
    a(paramInt, paramMsgCSBody0x211.msgBody0x211_0x7);
  }
  
  private void a(int paramInt, MsgCSBody0x211_0x7 paramMsgCSBody0x211_0x7)
  {
    long l1 = paramMsgCSBody0x211_0x7.msgHeader.uint64_dst_uin;
    int i1 = paramMsgCSBody0x211_0x7.uMsgSubCmd;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          switch (i1)
          {
          default: 
            break;
          case 10: 
            i1 = 0;
            while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb.length)
            {
              paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[i1].bytes_originfile_md5 = null;
              a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[i1], l1, paramMsgCSBody0x211_0x7.uMsgSubCmd);
              i1 += 1;
            }
          case 9: 
            i1 = 0;
            while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb.length)
            {
              paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[i1].bytes_originfile_md5 = null;
              a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[i1], l1, paramMsgCSBody0x211_0x7.uMsgSubCmd);
              i1 += 1;
            }
          case 8: 
            i1 = 0;
            while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x8_RFCInfoNotiy.length)
            {
              a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x8_RFCInfoNotiy[i1], l1, paramMsgCSBody0x211_0x7.uMsgSubCmd);
              i1 += 1;
            }
          }
          QLog.d("DataLineHandler", 1, "SendPbMsg: cannot recognize the pb msg form 0X211_0x7");
          return;
        }
        i1 = 0;
        while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl.length)
        {
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl[i1], l1, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          i1 += 1;
        }
      }
      i1 = 0;
      while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc.length)
      {
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc[i1], l1, paramMsgCSBody0x211_0x7.uMsgSubCmd);
        i1 += 1;
      }
    }
    i1 = 0;
    while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc.length)
    {
      a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc[i1], l1, paramMsgCSBody0x211_0x7.uMsgSubCmd);
      i1 += 1;
    }
  }
  
  private void a(int paramInt1, NFCNotify paramNFCNotify, long paramLong, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.g.MsgBodyFromNFCNotify(paramNFCNotify, paramLong, this.b, paramInt2);
    a(paramInt1, 1003, localMsgBody, paramNFCNotify.uint64_sessionid);
  }
  
  private void a(int paramInt1, RFCInfoNotify paramRFCInfoNotify, long paramLong, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.g.msgBodyFromRFCInfoNotify(paramRFCInfoNotify, paramLong, this.b, paramInt2);
    a(paramInt1, 1008, localMsgBody, paramRFCInfoNotify.uSessionId);
  }
  
  private void a(int paramInt1, DataLineMsgRecord paramDataLineMsgRecord, int paramInt2)
  {
    paramDataLineMsgRecord.bIsTransfering = false;
    g(paramDataLineMsgRecord.path);
    if (paramDataLineMsgRecord.isSend())
    {
      if (paramInt2 == 2)
      {
        paramDataLineMsgRecord.fileMsgStatus = 0L;
        paramDataLineMsgRecord.bIsSended = true;
        if ((TextUtils.isEmpty(paramDataLineMsgRecord.path)) || (!new File(paramDataLineMsgRecord.path).exists()))
        {
          paramDataLineMsgRecord.nOpType = 1;
          paramDataLineMsgRecord.progress = 0.0F;
        }
        f(paramDataLineMsgRecord);
        if (!TextUtils.isEmpty(paramDataLineMsgRecord.thumbPath)) {
          this.i.getMessageFacade().d(paramInt1).a(paramDataLineMsgRecord.msgId, paramDataLineMsgRecord.thumbPath);
        }
        this.i.getMessageFacade().d(paramInt1).f(paramDataLineMsgRecord.msgId);
        this.i.getMessageFacade().d(paramInt1).e();
        this.i.getMessageFacade().d(paramInt1).d(paramDataLineMsgRecord.msgId);
        if ((paramDataLineMsgRecord.nSessionState == 2) && (com.tencent.mobileqq.filemanager.util.FileUtil.d(paramDataLineMsgRecord.path))) {
          this.i.getMessageFacade().d(paramInt1).b(paramDataLineMsgRecord.msgId, paramDataLineMsgRecord.path);
        }
        ReportController.b(this.i, "CliOper", "", "", "0X8006223", "0X8006223", 0, 0, "", "", "", "");
      }
      else if ((paramInt2 != 32) && (paramInt2 != 11) && (paramInt2 != 8))
      {
        paramDataLineMsgRecord.fileMsgStatus = 0L;
        this.i.getMessageFacade().d(paramInt1).f(paramDataLineMsgRecord.msgId);
        this.i.getMessageFacade().d(paramInt1).e(paramDataLineMsgRecord.msgId);
        ReportController.b(this.i, "CliOper", "", "", "0X8006224", "0X8006224", 0, 0, "", "", "", "");
      }
      else
      {
        paramDataLineMsgRecord.fileMsgStatus = 2L;
        this.i.getMessageFacade().d(paramInt1).f(paramDataLineMsgRecord.msgId);
        this.i.getMessageFacade().d(paramInt1).e(paramDataLineMsgRecord.msgId);
        ReportController.b(this.i, "CliOper", "", "", "0X8006224", "0X8006224", 0, 0, "", "", "", "");
      }
    }
    else
    {
      Object localObject;
      if (paramInt2 == 2)
      {
        paramDataLineMsgRecord.fileMsgStatus = 0L;
        f(paramDataLineMsgRecord);
        if (!TextUtils.isEmpty(paramDataLineMsgRecord.thumbPath)) {
          this.i.getMessageFacade().d(paramInt1).a(paramDataLineMsgRecord.msgId, paramDataLineMsgRecord.thumbPath);
        }
        localObject = FilePathUtil.c(paramDataLineMsgRecord.path);
        if (localObject != null)
        {
          FileUtils.deleteFile(paramDataLineMsgRecord.path);
          paramDataLineMsgRecord.path = ((String)localObject);
          this.i.getMessageFacade().d(paramInt1).b(paramDataLineMsgRecord.msgId, (String)localObject);
        }
        this.i.getMessageFacade().d(paramInt1).f(paramDataLineMsgRecord.msgId);
        this.i.getMessageFacade().d(paramInt1).d(paramDataLineMsgRecord.msgId);
        this.i.getMessageFacade().d(paramInt1).e();
        ReportController.b(this.i, "CliOper", "", "", "0X8006226", "0X8006226", 0, 0, "", "", "", "");
      }
      else if ((paramInt2 != 32) && (paramInt2 != 11) && (paramInt2 != 8))
      {
        if ((paramInt2 == 41) && (paramDataLineMsgRecord.fileMsgStatus == 1L) && (!paramDataLineMsgRecord.bIsTransfering))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("uSessionID[");
          ((StringBuilder)localObject).append(paramDataLineMsgRecord.sessionid);
          ((StringBuilder)localObject).append("]_onSessionComplete. net fail. but comingfile is no start transfer");
          QLog.w("DataLineHandler", 1, ((StringBuilder)localObject).toString());
          return;
        }
        paramDataLineMsgRecord.fileMsgStatus = 0L;
        this.i.getMessageFacade().d(paramInt1).f(paramDataLineMsgRecord.msgId);
        this.i.getMessageFacade().d(paramInt1).e(paramDataLineMsgRecord.msgId);
        ReportController.b(this.i, "CliOper", "", "", "0X8006227", "0X8006227", 0, 0, "", "", "", "");
      }
      else
      {
        paramDataLineMsgRecord.fileMsgStatus = 2L;
        this.i.getMessageFacade().d(paramInt1).f(paramDataLineMsgRecord.msgId);
        this.i.getMessageFacade().d(paramInt1).e(paramDataLineMsgRecord.msgId);
        ReportController.b(this.i, "CliOper", "", "", "0X8006227", "0X8006227", 0, 0, "", "", "", "");
      }
    }
    paramDataLineMsgRecord.nSessionState = 1;
  }
  
  private void a(int paramInt, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.RNFCNotify> paramList)
  {
    paramMsgHeader = this.g.MsgCSBodyFromRFCInfoNotify(paramInt, paramMsgHeader, paramList);
    this.d.OnPbMsgReceive(paramMsgHeader);
  }
  
  private void a(int paramInt, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.FTNNotify> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = (SubMsgType0x7.MsgBody.FTNNotify)paramList.next();
      if ((localFTNNotify.uint64_sessionid.has()) && (localFTNNotify.uint32_originfiletype.has()) && (localFTNNotify.str_file_name.has()) && (localFTNNotify.uint64_file_len.has()) && (localFTNNotify.bytes_file_md5.has()) && (localFTNNotify.str_file_index.has()))
      {
        String str1 = localFTNNotify.str_file_name.get();
        if (str1 != null)
        {
          String str2 = FileManagerUtil.a(str1);
          if ((!TextUtils.isEmpty(str2)) && (!str1.equalsIgnoreCase(str2))) {
            localFTNNotify.str_file_name.set(str2);
          }
        }
        localArrayList.add(localFTNNotify);
      }
    }
    if (localArrayList.size() > 0)
    {
      paramMsgHeader = this.g.MsgCSBodyFromFTNNotify(paramInt, paramMsgHeader, localArrayList, paramBoolean);
      this.d.OnPbMsgReceive(paramMsgHeader);
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    float f1;
    if (paramLong3 == 0L) {
      f1 = 0.0F;
    } else {
      f1 = (float)paramLong2 / (float)paramLong3;
    }
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong1);
    DataLineMsgRecord localDataLineMsgRecord = this.i.getMessageFacade().d(i1).a(paramLong1);
    if (localDataLineMsgRecord != null) {
      localDataLineMsgRecord.progress = f1;
    }
    a(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong1), Float.valueOf(f1) });
  }
  
  private void a(Session paramSession)
  {
    String str = paramSession.strFilePathSrc;
    if ((paramSession.dwGroupID == 0) && (paramSession.bSend) && (paramSession.emFileType == 1) && (str != null) && (new File(str).exists())) {
      URLDrawable.getDrawable(AsyncImageView.a(str, this.M, this.N, true), null, null, false).downloadImediatly();
    }
  }
  
  private void a(Session paramSession, NFCInfo paramNFCInfo)
  {
    FileManagerEntity localFileManagerEntity2 = this.i.getFileManagerDataCenter().a(paramSession.uSessionID);
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
    if (localFileManagerEntity2 == null)
    {
      localFileManagerEntity1 = new FileManagerEntity();
      localFileManagerEntity1.nSessionId = paramSession.uSessionID;
      localFileManagerEntity1.strFilePath = paramSession.strFilePathSrc;
      localFileManagerEntity1.strMiddleThumPath = paramSession.strFilePathThumb;
      localFileManagerEntity1.fileName = paramSession.strFileNameSrc;
      localFileManagerEntity1.strFileMd5 = HexUtil.bytes2HexStr(paramSession.vFileMD5Src);
      localFileManagerEntity1.fileSize = paramSession.uFileSizeSrc;
      localFileManagerEntity1.uniseq = FileManagerUtil.a().longValue();
      localFileManagerEntity1.msgSeq = FileManagerUtil.f();
      localFileManagerEntity1.peerUin = QFileAssistantUtils.b(this.i);
      localFileManagerEntity1.peerType = 0;
      localFileManagerEntity1.bDelInFM = true;
      localFileManagerEntity1.bSend = false;
      this.i.getFileManagerDataCenter().a(localFileManagerEntity1);
    }
    localFileManagerEntity1.dlGourpIndex = paramSession.dwGroupIndex;
    localFileManagerEntity1.dlGroupCount = paramSession.dwGroupSize;
    localFileManagerEntity1.dlGroupId = paramSession.dwGroupID;
    localFileManagerEntity1.nfcServerIP = paramNFCInfo.dwServerIP;
    localFileManagerEntity1.nfcServerPort = paramNFCInfo.wServerPort;
    localFileManagerEntity1.nfcTokenKey = ((byte[])paramNFCInfo.vTokenKey.clone());
    localFileManagerEntity1.nfcUrlNotify = ((byte[])paramNFCInfo.vUrlNotify.clone());
    localFileManagerEntity1.cloudType = 11;
    localFileManagerEntity1.status = 2;
    localFileManagerEntity1.mContext = Integer.valueOf(a(paramSession.msgHeader));
    paramSession = new StringBuilder();
    paramSession.append("recvByNewFileassistant:");
    paramSession.append(localFileManagerEntity1.nSessionId);
    paramSession.append(",gip:");
    paramSession.append(localFileManagerEntity1.nfcServerIP);
    paramSession.append(",gport:");
    paramSession.append(localFileManagerEntity1.nfcServerPort);
    QLog.i("DataLineHandler.NFRV", 1, paramSession.toString());
    this.i.getFileManagerDataCenter().c(localFileManagerEntity1);
    this.i.getFileManagerEngine().h(localFileManagerEntity1);
  }
  
  private void a(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, WeiYunFileInfo paramWeiYunFileInfo)
  {
    long l1 = paramDataLineMsgRecord.sessionid;
    this.i.getFileManagerEngine().d().a(paramWeiYunFileInfo, new DataLineHandler.17(this, l1));
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    NewIntent localNewIntent = new NewIntent(this.i.getApplication(), DataLineServlet.class);
    localNewIntent.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
    this.i.startServlet(localNewIntent);
    long l1 = System.currentTimeMillis();
    paramToServiceMsg.extraData.putLong("datalineSendTimekey", l1);
  }
  
  /* Error */
  private void a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: new 1169	java/io/BufferedWriter
    //   11: dup
    //   12: new 1171	java/io/OutputStreamWriter
    //   15: dup
    //   16: new 1173	java/io/FileOutputStream
    //   19: dup
    //   20: aload_2
    //   21: iconst_0
    //   22: invokespecial 1176	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   25: invokespecial 1179	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   28: invokespecial 1182	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   31: astore_2
    //   32: aload_2
    //   33: aload_1
    //   34: invokevirtual 1185	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   37: aload_2
    //   38: invokevirtual 1188	java/io/BufferedWriter:close	()V
    //   41: return
    //   42: astore_1
    //   43: aload_2
    //   44: astore_3
    //   45: goto +91 -> 136
    //   48: astore_3
    //   49: aload_2
    //   50: astore_1
    //   51: aload_3
    //   52: astore_2
    //   53: goto +19 -> 72
    //   56: astore_3
    //   57: aload_2
    //   58: astore_1
    //   59: aload_3
    //   60: astore_2
    //   61: goto +42 -> 103
    //   64: astore_1
    //   65: goto +71 -> 136
    //   68: astore_2
    //   69: aload 4
    //   71: astore_1
    //   72: aload_1
    //   73: astore_3
    //   74: ldc_w 328
    //   77: iconst_1
    //   78: ldc_w 1190
    //   81: invokestatic 369	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: aload_1
    //   85: astore_3
    //   86: aload_2
    //   87: invokevirtual 1193	java/io/IOException:printStackTrace	()V
    //   90: aload_1
    //   91: ifnull +44 -> 135
    //   94: aload_1
    //   95: invokevirtual 1188	java/io/BufferedWriter:close	()V
    //   98: return
    //   99: astore_2
    //   100: aload 5
    //   102: astore_1
    //   103: aload_1
    //   104: astore_3
    //   105: ldc_w 328
    //   108: iconst_1
    //   109: ldc_w 1195
    //   112: invokestatic 369	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_1
    //   116: astore_3
    //   117: aload_2
    //   118: invokevirtual 1196	java/io/FileNotFoundException:printStackTrace	()V
    //   121: aload_1
    //   122: ifnull +13 -> 135
    //   125: aload_1
    //   126: invokevirtual 1188	java/io/BufferedWriter:close	()V
    //   129: return
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 1193	java/io/IOException:printStackTrace	()V
    //   135: return
    //   136: aload_3
    //   137: ifnull +15 -> 152
    //   140: aload_3
    //   141: invokevirtual 1188	java/io/BufferedWriter:close	()V
    //   144: goto +8 -> 152
    //   147: astore_2
    //   148: aload_2
    //   149: invokevirtual 1193	java/io/IOException:printStackTrace	()V
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	DataLineHandler
    //   0	154	1	paramString	String
    //   0	154	2	paramFile	File
    //   7	38	3	localFile	File
    //   48	4	3	localIOException	java.io.IOException
    //   56	4	3	localFileNotFoundException	java.io.FileNotFoundException
    //   73	68	3	str	String
    //   1	69	4	localObject1	Object
    //   4	97	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	37	42	finally
    //   32	37	48	java/io/IOException
    //   32	37	56	java/io/FileNotFoundException
    //   8	32	64	finally
    //   74	84	64	finally
    //   86	90	64	finally
    //   105	115	64	finally
    //   117	121	64	finally
    //   8	32	68	java/io/IOException
    //   8	32	99	java/io/FileNotFoundException
    //   37	41	130	java/io/IOException
    //   94	98	130	java/io/IOException
    //   125	129	130	java/io/IOException
    //   140	144	147	java/io/IOException
  }
  
  private void a(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.FileControl> paramList)
  {
    paramMsgHeader = this.g.MsgCSBodyFromFileControl(paramMsgHeader, paramList);
    this.d.OnPbMsgReceive(paramMsgHeader);
  }
  
  public static void a(SubMsgType0x7.MsgBody paramMsgBody, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    if (!QFileAssistantUtils.b())
    {
      QLog.i("DataLineHandler", 1, "isNot new FileAssistant");
      return;
    }
    int i1;
    if (paramMsgBody.uint32_sub_cmd.has()) {
      i1 = paramMsgBody.uint32_sub_cmd.get();
    } else {
      i1 = -1;
    }
    if ((i1 == 1) || ((i1 == 4) && (((SubMsgType0x7.MsgBody.GenericSubCmd)paramMsgBody.msg_subcmd_0x4_generic.get()).uint32_type.has()) && (((SubMsgType0x7.MsgBody.GenericSubCmd)paramMsgBody.msg_subcmd_0x4_generic.get()).uint32_type.get() == 1)) || (i1 == 9)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      paramPbSendMsgReq.routing_head.trans_0x211.dataline_flag.set(1);
    }
  }
  
  static boolean a(Session paramSession, String paramString)
  {
    if (paramSession != null) {
      if ((paramString != null) && (paramString.length() != 0))
      {
        if ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.equals(paramString))) {
          return true;
        }
      }
      else if ((paramSession.actionInfo == null) || (paramSession.actionInfo.strServiceName == null) || (paramSession.actionInfo.strServiceName.length() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(TextMsgTask paramTextMsgTask)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i4 = paramTextMsgTask.a(localStringBuffer);
    int i2 = 0;
    int i1 = 0;
    if (i4 == -1) {
      return false;
    }
    int i3 = this.c;
    int i5;
    if (i3 == 0) {
      while (i1 < localStringBuffer.length())
      {
        i2 = i1;
        if (localStringBuffer.charAt(i1) == '\024')
        {
          i2 = i1;
          if (i1 < localStringBuffer.length() - 1)
          {
            i3 = i1 + 1;
            i5 = QQSysFaceUtil.convertToServer(localStringBuffer.charAt(i3));
            i2 = i1;
            if (i5 >= 0)
            {
              localStringBuffer.setCharAt(i3, (char)i5);
              i2 = i3;
            }
          }
        }
        i1 = i2 + 1;
      }
    }
    if (i3 == 1) {
      for (i1 = i2; i1 < localStringBuffer.length(); i1 = i3 + 1)
      {
        i3 = i1;
        if (localStringBuffer.charAt(i1) == '\024')
        {
          i3 = i1;
          if (i1 < localStringBuffer.length() - 1)
          {
            i5 = i1 + 1;
            i3 = localStringBuffer.charAt(i5);
            i2 = i3;
            if (i3 == 250) {
              i2 = 10;
            }
            i3 = i1;
            if (i2 >= 0)
            {
              i3 = i1;
              if (i2 < EmotcationConstants.SYS_EMOTICON_SYMBOL.length)
              {
                String str = EmotcationConstants.SYS_EMOTICON_SYMBOL[i2];
                try
                {
                  localStringBuffer.replace(i5, i1 + 2, str);
                }
                catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
                {
                  localStringIndexOutOfBoundsException.printStackTrace();
                  QLog.d("DataLineHandler", 2, "SendSubText ipad emoj fail", localStringIndexOutOfBoundsException);
                }
                i3 = i1 + str.length();
              }
            }
          }
        }
      }
    }
    paramTextMsgTask.a(a(paramTextMsgTask.a().longValue(), 1001, paramTextMsgTask.d(), i4, localStringBuffer.toString().getBytes()));
    return true;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return -2005;
      }
      return -2009;
    }
    return -2000;
  }
  
  private void b(int paramInt, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.NFCNotify> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.NFCNotify localNFCNotify = (SubMsgType0x7.MsgBody.NFCNotify)paramList.next();
      if ((localNFCNotify.uint64_sessionid.has()) && (localNFCNotify.uint32_originfiletype.has()) && (localNFCNotify.str_file_name.has()) && (localNFCNotify.uint64_file_len.has()) && (localNFCNotify.bytes_file_md5.has()) && (localNFCNotify.fixed32_ip.has()) && (localNFCNotify.uint32_port.has()) && (localNFCNotify.bytes_url_notify.has()) && (localNFCNotify.bytes_tokenkey.has()))
      {
        String str1 = localNFCNotify.str_file_name.get();
        if (str1 != null)
        {
          String str2 = FileManagerUtil.a(str1);
          if ((!TextUtils.isEmpty(str2)) && (!str1.equalsIgnoreCase(str2))) {
            localNFCNotify.str_file_name.set(str2);
          }
        }
        localArrayList.add(localNFCNotify);
      }
    }
    if (localArrayList.size() > 0)
    {
      paramMsgHeader = this.g.MsgCSBodyFromNFCNotify(paramInt, paramMsgHeader, localArrayList, paramBoolean);
      this.d.OnPbMsgReceive(paramMsgHeader);
    }
  }
  
  private void b(long paramLong, int paramInt)
  {
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.i.getMessageFacade().d(i1).a(paramLong);
    if (localDataLineMsgRecord == null) {
      return;
    }
    if ((localDataLineMsgRecord.isSend()) && (localDataLineMsgRecord.fileFrom == 0))
    {
      if (paramInt == 2)
      {
        a(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Float.valueOf(1.0F) });
        a(2, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
        if (paramLong > 0L)
        {
          FileManagerEntity localFileManagerEntity = localDataLineMsgRecord.trans2Entity();
          if ((localFileManagerEntity != null) && (localFileManagerEntity.fileSize <= 20971520L))
          {
            ((DataLineMessageSpreadManager)this.i.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER_DATALINE)).a(localDataLineMsgRecord, i1);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.e("AIOMessageSpreadManager", 1, "can't find File Msg sID:");
          }
        }
      }
      else
      {
        if ((paramInt != 32) && (paramInt != 11) && (paramInt != 8))
        {
          a(2, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
          return;
        }
        a(2, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      }
    }
    else
    {
      if (paramInt == 2)
      {
        a(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Float.valueOf(1.0F) });
        a(3, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
        return;
      }
      if ((paramInt != 32) && (paramInt != 11) && (paramInt != 8))
      {
        a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
        return;
      }
      a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
    }
  }
  
  private void b(ArrayList<Session> paramArrayList, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.g.showNoNetworkDialog();
      return;
    }
    if (paramArrayList.size() == 0) {
      return;
    }
    LiteTransferWrapper localLiteTransferWrapper = this.d;
    int i1 = paramArrayList.size();
    boolean bool = true;
    if (i1 == 1) {
      bool = false;
    }
    localLiteTransferWrapper.SendGroup(paramArrayList, paramBoolean, bool);
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    return l(a(paramFileManagerEntity));
  }
  
  public static int c(int paramInt)
  {
    if (paramInt != -2009)
    {
      if (paramInt != -2000) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = ((Long)paramToServiceMsg.getAttribute("cookie")).longValue();
    int i2 = DataLineMsgRecord.getDevTypeBySeId(l1);
    paramToServiceMsg = this.i.getMessageFacade().d(i2).a(l1);
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.fileUuid = null;
    paramToServiceMsg.uOwnerUin = 0L;
    paramToServiceMsg.busId = 38;
    paramToServiceMsg.forwardTroopFileEntrance = 0;
    paramToServiceMsg.nOpType = 0;
    paramToServiceMsg.fileFrom = 5;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_FILE_SAVE_PATH);
    localStringBuilder.append(paramToServiceMsg.filename);
    paramToServiceMsg.path = localStringBuilder.toString();
    int i1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      i1 = 2;
    } else {
      i1 = 36;
    }
    a(i2, paramToServiceMsg, i1);
    new Handler(Looper.getMainLooper()).post(new DataLineHandler.8(this, l1, i1));
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = new MsgSCBody();
    paramObject.uMsgType = 529;
    paramObject.msgBody0x211 = new MsgSCBody0x211();
    paramObject.msgBody0x211.uMsgSubType = 7;
    paramObject.msgBody0x211.msgBody0x211_0x7 = new MsgSCBody0x211_0x7();
    Long localLong = (Long)paramToServiceMsg.getAttribute("cookie");
    StringBuilder localStringBuilder;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleFTNNotify ");
        localStringBuilder.append(localLong.intValue());
        localStringBuilder.append(" 发送信令，发送成功");
        QLog.d("DataLineHandler", 2, localStringBuilder.toString());
      }
      paramObject.bTimeOut = false;
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleFTNNotify ");
        localStringBuilder.append(localLong.intValue());
        localStringBuilder.append(" 发送信令，发送失败");
        QLog.d("DataLineHandler", 2, localStringBuilder.toString());
      }
      paramObject.bTimeOut = true;
    }
    if (paramFromServiceMsg != null) {
      paramObject.msgBody0x211.msgBody0x211_0x7.uResult = (paramFromServiceMsg.isSuccess() ^ true);
    }
    if (((Boolean)paramToServiceMsg.getAttribute("sendFromNative", Boolean.valueOf(true))).booleanValue())
    {
      this.d.OnPbMsgReply(localLong.intValue(), paramObject);
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void d(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord != null)
    {
      if (!TextUtils.isEmpty(paramDataLineMsgRecord.path)) {
        return;
      }
      String str2 = i(paramDataLineMsgRecord.filename);
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        long l1 = System.currentTimeMillis();
        str1 = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(l1));
      }
      str2 = FMSettings.a().getDefaultRecvPath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append(str1);
      str2 = localStringBuilder.toString();
      str1 = str2;
      if (FileUtils.fileExists(str2)) {
        str1 = e(str2);
      }
      paramDataLineMsgRecord.path = str1;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 0;
    while (i1 < this.j.size())
    {
      if (((TextMsgTask)this.j.get(i1)).e().equals(paramToServiceMsg))
      {
        paramToServiceMsg = (TextMsgTask)this.j.get(i1);
        break label64;
      }
      i1 += 1;
    }
    paramToServiceMsg = null;
    label64:
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.b().progress = 1.0F;
    i1 = DataLineMsgRecord.getDevTypeBySeId(paramToServiceMsg.a().longValue());
    if (!paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg.b().issuc = false;
      a(1, false, new Object[] { paramToServiceMsg.a(), paramToServiceMsg.c() });
      return;
    }
    if (paramToServiceMsg.f())
    {
      paramToServiceMsg.b().issuc = true;
      this.i.getMessageFacade().d(i1).d(paramToServiceMsg.b().msgId);
      this.j.remove(paramToServiceMsg);
      a(1, true, new Object[] { paramToServiceMsg.a(), paramToServiceMsg.c() });
      return;
    }
    if (!a(paramToServiceMsg))
    {
      paramToServiceMsg.b().issuc = false;
      this.j.remove(paramToServiceMsg);
      a(1, false, new Object[] { paramToServiceMsg.a(), paramToServiceMsg.c() });
    }
  }
  
  private void d(List<SubMsgType0x7.MsgBody.MoloNotify> paramList)
  {
    Object localObject1 = paramList.iterator();
    for (;;)
    {
      int i2;
      boolean bool;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (SubMsgType0x7.MsgBody.MoloNotify)((Iterator)localObject1).next();
        if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject2).bytes_buf.has())
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DataLineHandler", 2, "应用宝消息  moloHandler SubCmd0x5 do not has bytes_buf");
          continue;
        }
        paramList = this.l.a(((SubMsgType0x7.MsgBody.MoloNotify)localObject2).bytes_buf.get().toByteArray());
        if (paramList == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DataLineHandler", 2, "应用宝消息 moloHandler dealWith return null");
          continue;
        }
        int i1;
        if (((SubMsgType0x7.MsgBody.MoloNotify)localObject2).uint32_group_id.has()) {
          i1 = ((SubMsgType0x7.MsgBody.MoloNotify)localObject2).uint32_group_id.get();
        } else {
          i1 = 0;
        }
        paramList.groupId = i1;
        if (((SubMsgType0x7.MsgBody.MoloNotify)localObject2).uint32_group_size.has()) {
          i1 = ((SubMsgType0x7.MsgBody.MoloNotify)localObject2).uint32_group_size.get();
        } else {
          i1 = 0;
        }
        paramList.groupSize = i1;
        if (((SubMsgType0x7.MsgBody.MoloNotify)localObject2).uint32_group_curindex.has()) {
          i1 = ((SubMsgType0x7.MsgBody.MoloNotify)localObject2).uint32_group_curindex.get();
        } else {
          i1 = 0;
        }
        paramList.groupIndex = i1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("应用宝消息 groupId[");
          ((StringBuilder)localObject2).append(paramList.groupId);
          ((StringBuilder)localObject2).append("],size[");
          ((StringBuilder)localObject2).append(paramList.groupSize);
          ((StringBuilder)localObject2).append("],index[");
          ((StringBuilder)localObject2).append(paramList.groupIndex);
          ((StringBuilder)localObject2).append("], sessionid[");
          ((StringBuilder)localObject2).append(paramList.sessionid);
          ((StringBuilder)localObject2).append("], key[");
          ((StringBuilder)localObject2).append(paramList.strMoloKey);
          QLog.d("DataLineHandler", 2, ((StringBuilder)localObject2).toString());
        }
        if (paramList.groupSize == 1)
        {
          paramList.groupId = 0;
          paramList.groupSize = 0;
          paramList.groupIndex = 0;
        }
        if ((!DataLineMsgSet.isSingle(paramList)) && (j(paramList.groupId)))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("应用宝消息msg record in deleted group, sessionid[");
            ((StringBuilder)localObject1).append(paramList.sessionid);
            QLog.d("DataLineHandler", 2, ((StringBuilder)localObject1).toString());
          }
          return;
        }
        i2 = DataLineMsgRecord.getDevTypeBySeId(paramList.sessionid);
        h().getMessageFacade().d(i2).a(paramList, true);
        if ((!DataLineMsgSet.isSingle(paramList)) && (j(paramList.groupId)))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("应用宝消息 msg record in deleted group 2, sessionid[");
            ((StringBuilder)localObject1).append(paramList.sessionid);
            QLog.d("DataLineHandler", 2, ((StringBuilder)localObject1).toString());
          }
          paramList = h().getDataLineMsgProxy(i2).c(paramList.sessionid);
          if (paramList != null) {
            a(paramList);
          }
          return;
        }
        if (DataLineMsgSet.isSingle(paramList))
        {
          DataLineReportUtil.a(this.i);
          u();
        }
        else
        {
          localObject2 = h().getDataLineMsgProxy(i2).a(paramList.groupId);
          if ((localObject2 == null) || (((DataLineMsgSet)localObject2).getComeCount() == 1))
          {
            DataLineReportUtil.b(this.i);
            u();
          }
        }
        if (a(paramList.sessionid, paramList.groupId))
        {
          bool = false;
        }
        else
        {
          paramList.issuc = true;
          paramList.fileMsgStatus = 1L;
          bool = NetworkUtil.isWifiConnected(BaseApplication.getContext());
          if (paramList.filesize <= 3145728L) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if ((!bool) && ((!getAutoDownload()) || (i1 == 0))) {
            bool = false;
          } else {
            bool = true;
          }
          if (bool) {
            paramList.fileMsgStatus = 0L;
          }
        }
      }
      try
      {
        e(111);
        this.l.a(paramList.strMoloKey);
        DataLineReportUtil.c(this.i);
        label701:
        this.i.getMessageFacade().d(i2).f(paramList.msgId);
        a(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramList.sessionid), paramList.path, Byte.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(bool), Long.valueOf(paramList.filesize) });
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label701;
      }
    }
  }
  
  private String e(String paramString)
  {
    int i1 = paramString.lastIndexOf(".");
    String str2;
    String str1;
    if (i1 >= 0)
    {
      str2 = paramString.substring(0, i1);
      str1 = paramString.substring(i1);
    }
    else
    {
      str1 = "";
      str2 = paramString;
    }
    VFSFile localVFSFile = new VFSFile(paramString);
    i1 = 1;
    int i2;
    for (;;)
    {
      if (i1 > 512)
      {
        paramString = new StringBuilder();
        paramString.append(str2);
        paramString.append("(");
        paramString.append(System.currentTimeMillis());
        paramString.append(")");
        paramString.append(str1);
        return paramString.toString();
      }
      i2 = i1;
      if (!localVFSFile.exists()) {
        break;
      }
      paramString = new StringBuilder();
      paramString.append(str2);
      paramString.append("(");
      paramString.append(i1);
      paramString.append(")");
      paramString.append(str1);
      paramString = paramString.toString();
      localVFSFile = new VFSFile(paramString);
      i1 += 1;
    }
    for (;;)
    {
      if (i2 > 512)
      {
        paramString = new StringBuilder();
        paramString.append(str2);
        paramString.append("(");
        paramString.append(System.currentTimeMillis());
        paramString.append(")");
        paramString.append(str1);
        return paramString.toString();
      }
      if (!h(paramString)) {
        break;
      }
      paramString = new StringBuilder();
      paramString.append(str2);
      paramString.append("(");
      paramString.append(i2);
      paramString.append(")");
      paramString.append(str1);
      paramString = paramString.toString();
      i2 += 1;
    }
    return paramString;
  }
  
  private void e(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord.fileMsgStatus = 0L;
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
    this.i.getMessageFacade().d(i1).f(paramDataLineMsgRecord.msgId);
    this.i.getMessageFacade().d(i1).e(paramDataLineMsgRecord.msgId);
    a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramDataLineMsgRecord.sessionid), paramDataLineMsgRecord.path });
  }
  
  private Session f(FileManagerEntity paramFileManagerEntity)
  {
    Session localSession = new Session();
    localSession.uSessionID = paramFileManagerEntity.nSessionId;
    localSession.bSend = paramFileManagerEntity.bSend;
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramFileManagerEntity.nSessionId);
    localSession.msgHeader = this.g.msgHeader(Long.valueOf(this.i.getCurrentAccountUin()).longValue(), i1);
    localSession.dwGroupID = paramFileManagerEntity.dlGroupId;
    localSession.dwGroupSize = paramFileManagerEntity.dlGroupCount;
    localSession.dwGroupIndex = paramFileManagerEntity.dlGourpIndex;
    if (paramFileManagerEntity.nFileType == 2) {
      localSession.emFileType = 2;
    } else if (paramFileManagerEntity.nFileType == 0) {
      localSession.emFileType = 1;
    } else {
      localSession.emFileType = 0;
    }
    if (QFileAssistantUtils.a(paramFileManagerEntity.peerUin)) {
      localSession.isFileAssist = true;
    }
    localSession.strFilePathSrc = FilePathUtil.b(paramFileManagerEntity.strFilePath);
    localSession.strFilePathThumb = paramFileManagerEntity.strThumbPath;
    localSession.uFileSizeSrc = paramFileManagerEntity.fileSize;
    localSession.vFileMD5Src = HexUtil.hexStr2Bytes(paramFileManagerEntity.strFileMd5);
    if ((QLog.isDevelopLevel()) && (paramFileManagerEntity.strFileMd5 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSessionFromMsgRecord, uSessionID[");
      localStringBuilder.append(paramFileManagerEntity.nSessionId);
      localStringBuilder.append("], strMR[");
      localStringBuilder.append(paramFileManagerEntity.strFileMd5);
      localStringBuilder.append("], filesize[");
      localStringBuilder.append(paramFileManagerEntity.fileSize);
      QLog.d("DataLineHandler.NFRV", 4, localStringBuilder.toString());
    }
    localSession.actionInfo = null;
    return localSession;
  }
  
  private void f(DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str = paramDataLineMsgRecord.path;
    if (FileManagerUtil.c(str) != 0) {
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramDataLineMsgRecord.thumbPath)) {
      return;
    }
    str = FileManagerUtil.a(str, 384, 384, null);
    if (!TextUtils.isEmpty(str)) {
      paramDataLineMsgRecord.thumbPath = str;
    }
  }
  
  private void f(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (!this.A.contains(paramString)))
      {
        this.A.add(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addRecvingFilePath[");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" size:");
        localStringBuilder.append(this.A.size());
        QLog.i("DataLineHandler", 1, localStringBuilder.toString());
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void g(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if ((paramDataLineMsgRecord != null) && (!paramDataLineMsgRecord.isSendFromLocal()) && (DataLineMsgSet.isSingle(paramDataLineMsgRecord)) && (paramDataLineMsgRecord.msgtype == -2000) && (paramDataLineMsgRecord.path != null) && (new File(paramDataLineMsgRecord.path).exists())) {
      URLDrawable.getDrawable(AsyncImageView.a(paramDataLineMsgRecord.path, this.M, this.N, true), null, null, false).downloadImediatly();
    }
  }
  
  private void g(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (this.A.contains(paramString)))
      {
        this.A.remove(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("remRecvingFilePath[");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" size:");
        localStringBuilder.append(this.A.size());
        QLog.i("DataLineHandler", 1, localStringBuilder.toString());
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean h(String paramString)
  {
    try
    {
      boolean bool = this.A.contains(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private String i(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if (bool) {
      return "";
    }
    int i1 = paramString.lastIndexOf(".");
    Object localObject = paramString;
    if (i1 >= 0)
    {
      localObject = paramString.substring(0, i1);
      str = paramString.substring(i1);
    }
    ((String)localObject).replace('\\', '_');
    ((String)localObject).replace('/', '_');
    ((String)localObject).replace(':', '_');
    ((String)localObject).replace('*', '_');
    ((String)localObject).replace('?', '_');
    ((String)localObject).replace('"', '_');
    ((String)localObject).replace('<', '_');
    ((String)localObject).replace('>', '_');
    ((String)localObject).replace('|', '_');
    paramString = (String)localObject;
    if (((String)localObject).length() > 53) {
      paramString = ((String)localObject).substring(0, 53);
    }
    localObject = paramString;
    if (!TextUtils.isEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static boolean l(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        bool1 = bool2;
        if (paramInt != 2)
        {
          bool1 = bool2;
          if (paramInt != 3)
          {
            bool1 = bool2;
            if (paramInt != 5) {
              bool1 = false;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void n(int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new DataLineHandler.19(this, paramInt));
  }
  
  private void s()
  {
    SharedPreferences localSharedPreferences = this.i.getPreferences();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.i.getCurrentAccountUin());
    ((StringBuilder)localObject).append("_PC_STATE");
    localObject = ((StringBuilder)localObject).toString();
    if (localSharedPreferences.contains((String)localObject))
    {
      this.s = true;
      this.u = localSharedPreferences.getLong((String)localObject, 0L);
      return;
    }
    this.s = false;
  }
  
  private void t()
  {
    SharedPreferences localSharedPreferences = this.i.getPreferences();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.i.getCurrentAccountUin());
    ((StringBuilder)localObject).append("_IPAD_STATE");
    localObject = ((StringBuilder)localObject).toString();
    if (localSharedPreferences.contains((String)localObject))
    {
      this.t = true;
      this.v = localSharedPreferences.getLong((String)localObject, 0L);
      return;
    }
    this.t = false;
  }
  
  private void u()
  {
    boolean bool;
    if (this.f == true) {
      bool = false;
    } else {
      bool = true;
    }
    h().handleReceivedMessage(1, bool, false);
  }
  
  private void v()
  {
    ThreadManager.getFileThreadHandler().post(new DataLineHandler.18(this));
  }
  
  public void GetThumbFilePath(int paramInt, Session paramSession)
  {
    QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePath ");
    Object localObject = (RegisterProxySvcPackHandler)this.i.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    if ((localObject != null) && (((RegisterProxySvcPackHandler)localObject).d() == 0))
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePath pc not line ");
      return;
    }
    if (paramSession.uFileSizeSrc < 51200L)
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 333 MinSize_for_CreateThumb e ");
      return;
    }
    localObject = com.dataline.util.file.FileUtil.a(BaseApplication.getContext(), paramSession.strFilePathSrc);
    if (localObject == null)
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 444 MinSize_for_CreateThumb e ");
      return;
    }
    File localFile = new File((String)localObject);
    if (!localFile.exists())
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 555 MinSize_for_CreateThumb e ");
      return;
    }
    if (localFile.length() + 51200L < paramSession.uFileSizeSrc)
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 666 MinSize_for_CreateThumb e ");
      this.d.OnGetThumbFilePathReply(paramInt, (String)localObject);
      return;
    }
    QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 777 MinSize_for_CreateThumb e ");
    localFile.delete();
  }
  
  public void HandleSession(int paramInt1, long paramLong, int paramInt2, MsgHeader paramMsgHeader) {}
  
  public void InvokeReport(ReportItem paramReportItem)
  {
    QualityReportUtil.a(this.i, paramReportItem, QualityReportUtil.b);
  }
  
  public void OnGroupComplete(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uGroupID[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("]OnGroupComplete 分组结束 emGroupStatus[");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      QLog.d("DataLineHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 0) {
      return;
    }
    DataLineMsgSet localDataLineMsgSet = this.i.getDataLineMsgProxy(0).a(paramInt1);
    Object localObject = localDataLineMsgSet;
    if (localDataLineMsgSet == null) {
      localObject = this.i.getDataLineMsgProxy(1).a(paramInt1);
    }
    if (localObject == null) {
      return;
    }
    ((DataLineMsgSet)localObject).setTimeOut();
    a(11, true, null);
  }
  
  public void OnGroupStart(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uGroupID[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]OnGroupStart 分组开始");
      QLog.d("DataLineHandler", 2, localStringBuilder.toString());
    }
    a(11, true, null);
  }
  
  public boolean OnQueryAutoDownload(long paramLong, byte paramByte)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramByte == 2)
    {
      boolean bool3 = NetworkUtil.isWifiConnected(BaseApplication.getContext());
      boolean bool4 = QFileAssistantUtils.a(this.i, paramLong);
      bool1 = bool2;
      if (!bool3)
      {
        if ((bool4) && (getAutoDownload())) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void OnSessionComplete(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = (Session)this.L.get(Long.valueOf(paramLong));
    if ((paramInt1 == 2) && (localObject != null)) {
      this.L.remove(Long.valueOf(paramLong));
    }
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (localObject == null)
    {
      localObject = Looper.getMainLooper();
      DataLineMsgRecord localDataLineMsgRecord = this.i.getMessageFacade().d(i1).a(paramLong);
      if (localDataLineMsgRecord == null)
      {
        if (Thread.currentThread() != ((Looper)localObject).getThread()) {
          new Handler((Looper)localObject).post(new DataLineHandler.14(this, paramLong, paramInt1, paramInt2));
        }
        return;
      }
      if (paramInt1 == 2) {
        g(localDataLineMsgRecord);
      }
      a(i1, localDataLineMsgRecord, paramInt1);
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new DataLineHandler.15(this, paramLong, paramInt1));
        return;
      }
      b(paramLong, paramInt1);
      return;
    }
    boolean bool;
    if (paramInt1 == 2) {
      bool = true;
    } else {
      bool = false;
    }
    a(16, bool, localObject);
  }
  
  public void OnSessionConnected(long paramLong, int paramInt1, int paramInt2)
  {
    a(20, true, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo)
  {
    if (paramSession.isFileAssist)
    {
      if (paramSession.bSend) {
        return;
      }
      a(paramSession, paramNFCInfo);
      this.L.put(Long.valueOf(paramSession.uSessionID), paramSession);
      a(17, true, paramSession);
      return;
    }
    if (paramSession.bSend) {
      ReportController.b(this.i, "CliOper", "", "", "0X8006222", "0X8006222", 0, 0, "", "", "", "");
    } else {
      ReportController.b(this.i, "CliOper", "", "", "0X8006225", "0X8006225", 0, 0, "", "", "", "");
    }
    if ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.length() != 0))
    {
      this.L.put(Long.valueOf(paramSession.uSessionID), paramSession);
      a(17, true, paramSession);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uSessionID[");
      ((StringBuilder)localObject).append(paramSession.uSessionID);
      ((StringBuilder)localObject).append("]OnSessionNew Session创建");
      QLog.d("DataLineHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread()) {
      new Handler((Looper)localObject).post(new DataLineHandler.11(this, paramSession, paramNFCInfo, paramFTNInfo));
    } else {
      a(paramSession, paramNFCInfo, paramFTNInfo, false);
    }
    a(paramSession);
  }
  
  public void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    Object localObject = (Session)this.L.get(Long.valueOf(paramLong1));
    if (localObject == null)
    {
      localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new DataLineHandler.13(this, paramLong1, paramLong2, paramLong3));
        return;
      }
      a(paramLong1, paramLong2, paramLong3);
      return;
    }
    double d1 = (float)paramLong2;
    Double.isNaN(d1);
    double d2 = (float)paramLong3;
    Double.isNaN(d2);
    a(15, true, new Object[] { localObject, Float.valueOf((float)(d1 * 1.0D / d2)) });
  }
  
  public void OnSessionStart(long paramLong)
  {
    Object localObject = (Session)this.L.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uSessionID[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("], OnSessionStart, Session开始");
        QLog.d("DataLineHandler", 2, ((StringBuilder)localObject).toString());
      }
      localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new DataLineHandler.12(this, paramLong));
        return;
      }
      a(a(paramLong), null, null, true);
      return;
    }
    a(14, true, localObject);
  }
  
  public void OnSessionStartRun(long paramLong)
  {
    a(21, true, new Object[] { Long.valueOf(paramLong) });
  }
  
  public void OnSessionUpdate(int paramInt, long paramLong, String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DataLineHandler.16(this, paramInt, paramLong, paramString));
      return;
    }
    a(paramInt, paramLong, paramString);
  }
  
  public void SendPbMsg(int paramInt, MsgCSBody paramMsgCSBody)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SendPbMsg: msgBody.uMsgType ");
    localStringBuilder.append(paramMsgCSBody.uMsgType);
    QLog.d("DataLineHandler", 1, localStringBuilder.toString());
    int i1 = paramMsgCSBody.uMsgType;
    if (i1 != 529)
    {
      if (i1 != 837)
      {
        if (i1 != 838)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("SendPbMsg: cannot recognize the pb msg form JNI, cmd[");
          localStringBuilder.append(paramMsgCSBody.uMsgType);
          QLog.d("DataLineHandler", 1, localStringBuilder.toString());
          return;
        }
        a(paramInt, paramMsgCSBody.msgBody0x346, null);
        return;
      }
      a(paramInt, paramMsgCSBody.msgBody0x345);
      return;
    }
    a(paramInt, paramMsgCSBody.msgBody0x211);
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    return a(paramString1, paramString2, null, paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramBoolean);
  }
  
  public long a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = this.g.genSession(0, paramString1, paramString2, paramString3, paramInt1, 0, paramLong, paramInt2, paramInt3, paramInt4);
    if (paramString1 == null) {
      return 0L;
    }
    localArrayList.add(paramString1);
    if (0L == paramLong) {
      paramString1.uSessionID = a(0, this.c).longValue();
    }
    paramString1.msgHeader = this.g.msgHeader(Long.valueOf(this.i.getCurrentAccountUin()).longValue(), this.c);
    b(localArrayList, paramBoolean);
    return paramString1.uSessionID;
  }
  
  public Session a(long paramLong)
  {
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = h().getMessageFacade().d(i1).a(paramLong);
    if (localDataLineMsgRecord == null) {
      return null;
    }
    Session localSession = new Session();
    localSession.uSessionID = localDataLineMsgRecord.sessionid;
    i1 = localDataLineMsgRecord.issend;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    localSession.bSend = bool;
    i1 = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
    localSession.msgHeader = this.g.msgHeader(Long.valueOf(this.i.getCurrentAccountUin()).longValue(), i1);
    localSession.dwGroupID = localDataLineMsgRecord.groupId;
    localSession.dwGroupSize = localDataLineMsgRecord.groupSize;
    localSession.dwGroupIndex = localDataLineMsgRecord.groupIndex;
    localSession.emFileType = c(localDataLineMsgRecord.msgtype);
    localSession.strFilePathSrc = FilePathUtil.b(localDataLineMsgRecord.path);
    localSession.strFilePathThumb = localDataLineMsgRecord.thumbPath;
    localSession.uFileSizeSrc = localDataLineMsgRecord.filesize;
    localSession.vFileMD5Src = localDataLineMsgRecord.md5;
    if ((QLog.isDevelopLevel()) && (localDataLineMsgRecord.md5 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSessionFromMsgRecord, uSessionID[");
      localStringBuilder.append(localDataLineMsgRecord.sessionid);
      localStringBuilder.append("], strMR[");
      localStringBuilder.append(HexUtil.bytes2HexStr(localDataLineMsgRecord.md5));
      localStringBuilder.append("], filesize[");
      localStringBuilder.append(localDataLineMsgRecord.filesize);
      QLog.d("DataLineHandler", 4, localStringBuilder.toString());
    }
    localSession.actionInfo = null;
    return localSession;
  }
  
  public Session a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    int i1;
    if (paramFileManagerEntity.nFileType == 0) {
      i1 = 1;
    } else if (paramFileManagerEntity.nFileType == 2) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramFileManagerEntity.fileName;
    localObject = this.g.genSession(0, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.strMiddleThumPath, (String)localObject, i1, 1, paramFileManagerEntity.nSessionId, paramFileManagerEntity.dlGroupId, paramFileManagerEntity.dlGroupCount, paramFileManagerEntity.dlGourpIndex);
    if (localObject == null) {
      return null;
    }
    ((Session)localObject).uChannelType = 1;
    ((Session)localObject).isFileAssist = true;
    localArrayList.add(localObject);
    if (((Session)localObject).uSessionID == 0L)
    {
      long l1 = a(0).longValue();
      ((Session)localObject).uSessionID = l1;
      paramFileManagerEntity.nSessionId = l1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWlanSend[");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    localStringBuilder.append("],Send fro Wlan target:");
    localStringBuilder.append(this.B);
    QLog.i("FileAssistantSender<FileAssistant>", 1, localStringBuilder.toString());
    ((Session)localObject).msgHeader = this.g.msgHeader(Long.valueOf(this.i.getCurrentAccountUin()).longValue(), this.B);
    b(localArrayList, paramBoolean);
    this.L.put(Long.valueOf(((Session)localObject).uSessionID), localObject);
    return localObject;
  }
  
  public ToServiceMsg a(int paramInt, SubMsgType0x7.MsgBody paramMsgBody, long paramLong)
  {
    int i1 = paramMsgBody.msg_header.uint32_dst_ter_type.get();
    Object localObject = this.i.getCurrentAccountUin();
    byte[] arrayOfByte = paramMsgBody.toByteArray();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send0x211C2CDatalineMsg DataLineMsgRecord:");
      localStringBuilder.append(paramLong);
      QLog.d("DataLineHandler", 2, localStringBuilder.toString());
    }
    localObject = a((String)localObject, 7, arrayOfByte, paramLong, i1);
    a(paramMsgBody, (msg_svc.PbSendMsgReq)localObject);
    return a(false, paramInt, paramLong, (msg_svc.PbSendMsgReq)localObject);
  }
  
  public ToServiceMsg a(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(4);
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    this.g.fillMsgHeader(localMsgBody.msg_header, Long.valueOf(this.i.getCurrentAccountUin()).longValue(), i1);
    localMsgBody.msg_subcmd_0x4_generic.uint64_sessionid.set(paramLong);
    localMsgBody.msg_subcmd_0x4_generic.uint32_size.set(paramInt2);
    localMsgBody.msg_subcmd_0x4_generic.uint32_index.set(paramInt3);
    localMsgBody.msg_subcmd_0x4_generic.uint32_type.set(1);
    SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg localQQDataTextMsg = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg();
    SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem localMsgItem = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem();
    localMsgItem.uint32_type.set(1);
    localMsgItem.bytes_text.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localMsgItem.setHasFlag(true);
    localQQDataTextMsg.rpt_msg_item.add(localMsgItem);
    localQQDataTextMsg.setHasFlag(true);
    localMsgBody.msg_subcmd_0x4_generic.bytes_buf.set(ByteStringMicro.copyFrom(localQQDataTextMsg.toByteArray()));
    localMsgBody.msg_subcmd_0x4_generic.setHasFlag(true);
    localMsgBody.setHasFlag(true);
    return a(paramLong, paramInt1, localMsgBody, paramLong);
  }
  
  public ToServiceMsg a(long paramLong1, int paramInt, SubMsgType0x7.MsgBody paramMsgBody, long paramLong2)
  {
    Object localObject = this.i.getCurrentAccountUin();
    int i1 = paramMsgBody.msg_header.uint32_dst_ter_type.get();
    byte[] arrayOfByte = paramMsgBody.toByteArray();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send0x211C2CDatalineMsg DataLineMsgRecord:");
      localStringBuilder.append(paramLong2);
      QLog.d("DataLineHandler", 2, localStringBuilder.toString());
    }
    localObject = a((String)localObject, 7, arrayOfByte, paramLong2, i1);
    a(paramMsgBody, (msg_svc.PbSendMsgReq)localObject);
    return a(true, paramInt, paramLong1, (msg_svc.PbSendMsgReq)localObject);
  }
  
  public ToServiceMsg a(long paramLong, MsgCSBody0x345 paramMsgCSBody0x345)
  {
    cmd0x345.ReqBody localReqBody = new cmd0x345.ReqBody();
    localReqBody.uint32_sub_cmd.set(paramMsgCSBody0x345.uMsgSubType);
    int i1 = paramMsgCSBody0x345.uMsgSubType;
    byte[] arrayOfByte = null;
    Object localObject;
    if (i1 != 7)
    {
      localObject = arrayOfByte;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("send0x345Req, unknwon nCmdType:");
        ((StringBuilder)localObject).append(paramMsgCSBody0x345.uMsgSubType);
        QLog.d("DataLineHandler", 2, ((StringBuilder)localObject).toString());
        localObject = arrayOfByte;
      }
    }
    else
    {
      if (paramMsgCSBody0x345.subCmd0x6ReqBody == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "send0x345Req, subCmd0x6ReqBody is empty");
        }
        return null;
      }
      localObject = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint32_dst_bus_id.set(paramMsgCSBody0x345.subCmd0x6ReqBody.uint32_dst_bus_id);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint64_src_uin.set(paramMsgCSBody0x345.subCmd0x6ReqBody.uint64_src_uin);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramMsgCSBody0x345.subCmd0x6ReqBody.bytes_uuid));
      if (paramMsgCSBody0x345.subCmd0x6ReqBody.bytes_file_md5 != null) {
        ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(paramMsgCSBody0x345.subCmd0x6ReqBody.bytes_file_md5));
      }
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint64_dst_uin.set(paramMsgCSBody0x345.subCmd0x6ReqBody.uint64_dst_uin);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint64_file_size.set(paramMsgCSBody0x345.subCmd0x6ReqBody.uint64_file_size);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).str_file_name.set(paramMsgCSBody0x345.subCmd0x6ReqBody.str_file_name);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).str_src_file_path.set(paramMsgCSBody0x345.subCmd0x6ReqBody.str_src_file_path);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).str_src_parent_folder.set(paramMsgCSBody0x345.subCmd0x6ReqBody.str_src_parent_folder);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint32_client_type.set(104);
      localReqBody.msg_subcmd_0x6_req_body.set((MessageMicro)localObject);
      localObject = createToServiceMsg("GTalkFileAppSvr.CMD_DISCUSS_FILE", null);
    }
    if (localObject != null)
    {
      paramMsgCSBody0x345 = localReqBody.toByteArray();
      arrayOfByte = new byte[paramMsgCSBody0x345.length + 4];
      PkgTools.dWord2Byte(arrayOfByte, 0, paramMsgCSBody0x345.length + 4);
      PkgTools.copyData(arrayOfByte, 4, paramMsgCSBody0x345, paramMsgCSBody0x345.length);
      ((ToServiceMsg)localObject).putWupBuffer(arrayOfByte);
      ((ToServiceMsg)localObject).addAttribute("cookie", Long.valueOf(paramLong));
      ((ToServiceMsg)localObject).extraData.putInt("DATALINE_TRYINDEX", 0);
      a((ToServiceMsg)localObject);
    }
    return localObject;
  }
  
  public ToServiceMsg a(long paramLong, MsgCSBody0x346 paramMsgCSBody0x346, Bundle paramBundle)
  {
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(paramMsgCSBody0x346.uMsgSubType);
    localReqBody.uint32_business_id.set(paramMsgCSBody0x346.uint32_business_id);
    if (paramMsgCSBody0x346.uint32_business_id == 0) {
      localReqBody.uint32_business_id.set(38);
    }
    localReqBody.uint32_client_type.set(104);
    Object localObject1 = localReqBody.uint32_seq;
    int i1 = J;
    J = i1 + 1;
    ((PBUInt32Field)localObject1).set(i1);
    boolean bool = this.g.FillReqBody(paramMsgCSBody0x346, localReqBody);
    Object localObject2 = null;
    if (!bool) {
      return null;
    }
    i1 = paramMsgCSBody0x346.uMsgSubType;
    if (i1 != 1200)
    {
      if (i1 != 1400)
      {
        if (i1 != 1600)
        {
          if (i1 != 1700)
          {
            if (i1 != 1800)
            {
              if (i1 == 60100) {
                localObject2 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", null);
              }
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("send0x346Req, unknwon nCmdType:");
                ((StringBuilder)localObject1).append(paramMsgCSBody0x346.uMsgSubType);
                QLog.d("DataLineHandler", 2, ((StringBuilder)localObject1).toString());
                localObject1 = localObject2;
              }
            }
            else
            {
              localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800", null);
            }
          }
          else {
            localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", null);
          }
        }
        else {
          localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600", null);
        }
      }
      else {
        localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400", null);
      }
    }
    else {
      localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", null);
    }
    paramMsgCSBody0x346 = localReqBody.toByteArray();
    localObject2 = new byte[paramMsgCSBody0x346.length + 4];
    PkgTools.dWord2Byte((byte[])localObject2, 0, paramMsgCSBody0x346.length + 4);
    PkgTools.copyData((byte[])localObject2, 4, paramMsgCSBody0x346, paramMsgCSBody0x346.length);
    if (localObject1 != null)
    {
      ((ToServiceMsg)localObject1).putWupBuffer((byte[])localObject2);
      ((ToServiceMsg)localObject1).addAttribute("cookie", Long.valueOf(paramLong));
      ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_TRYINDEX", 0);
      if (paramBundle != null)
      {
        ((ToServiceMsg)localObject1).addAttribute("data", paramBundle);
        ((ToServiceMsg)localObject1).addAttribute("sendFromNative", Boolean.valueOf(false));
      }
      a((ToServiceMsg)localObject1);
    }
    return localObject1;
  }
  
  public ToServiceMsg a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
  {
    return a(true, paramInt3, paramLong1, a(paramString, paramInt2, paramArrayOfByte, paramLong2, 1));
  }
  
  public ToServiceMsg a(DataLineMsgRecord paramDataLineMsgRecord, IDatalineFileReqCallback paramIDatalineFileReqCallback)
  {
    Object localObject1 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject1).uint32_cmd.set(1200);
    ((cmd0x346.ReqBody)localObject1).uint32_business_id.set(38);
    Object localObject2 = new cmd0x346.ApplyDownloadReq();
    ((cmd0x346.ApplyDownloadReq)localObject2).uint64_uin.set(Long.parseLong(this.i.getCurrentAccountUin()));
    ((cmd0x346.ApplyDownloadReq)localObject2).bytes_uuid.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.serverPath.getBytes()));
    ((cmd0x346.ApplyDownloadReq)localObject2).uint32_owner_type.set(2);
    ((cmd0x346.ReqBody)localObject1).msg_apply_download_req.set((MessageMicro)localObject2);
    ((cmd0x346.ReqBody)localObject1).uint32_business_id.set(38);
    ((cmd0x346.ReqBody)localObject1).uint32_client_type.set(104);
    paramDataLineMsgRecord = ((cmd0x346.ReqBody)localObject1).uint32_seq;
    int i1 = J;
    J = i1 + 1;
    paramDataLineMsgRecord.set(i1);
    paramDataLineMsgRecord = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", null);
    localObject1 = ((cmd0x346.ReqBody)localObject1).toByteArray();
    localObject2 = new byte[localObject1.length + 4];
    PkgTools.dWord2Byte((byte[])localObject2, 0, localObject1.length + 4);
    PkgTools.copyData((byte[])localObject2, 4, (byte[])localObject1, localObject1.length);
    if (paramDataLineMsgRecord != null)
    {
      paramDataLineMsgRecord.putWupBuffer((byte[])localObject2);
      if (paramIDatalineFileReqCallback != null) {
        paramDataLineMsgRecord.addAttribute("callback", paramIDatalineFileReqCallback);
      }
      a(paramDataLineMsgRecord);
    }
    return paramDataLineMsgRecord;
  }
  
  public DatalineRemoteManager a()
  {
    return this.y;
  }
  
  public Long a(int paramInt)
  {
    return Long.valueOf(this.d.generateSessionID(paramInt));
  }
  
  public Long a(int paramInt1, int paramInt2)
  {
    try
    {
      long l1 = this.d.generateSessionIDByDev(paramInt1, paramInt2);
      return Long.valueOf(l1);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label20;
    }
    catch (Exception localException)
    {
      label15:
      label20:
      break label15;
    }
    return Long.valueOf(0L);
    QLog.e("DataLineHandler", 1, "genSessionId failed");
    return Long.valueOf(0L);
  }
  
  public Long a(String paramString, int paramInt)
  {
    int i1 = paramString.length();
    Long localLong1 = Long.valueOf(0L);
    if (i1 == 0) {
      return localLong1;
    }
    Long localLong2 = a(0, paramInt);
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgId = localLong2.longValue();
    localDataLineMsgRecord.sessionid = localLong2.longValue();
    localDataLineMsgRecord.msg = paramString;
    localDataLineMsgRecord.msgtype = -1000;
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    ((ISVIPHandler)this.i.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localDataLineMsgRecord);
    localDataLineMsgRecord.time = MessageCache.c();
    localDataLineMsgRecord.sessionid = localLong2.longValue();
    localDataLineMsgRecord.progress = 0.0F;
    this.i.getMessageFacade().d(paramInt).a(localDataLineMsgRecord, false);
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      return localLong1;
    }
    localDataLineMsgRecord.issuc = true;
    paramString = new TextMsgTask(paramString, localLong2, localDataLineMsgRecord);
    if (!a(paramString)) {
      return localLong1;
    }
    this.j.add(paramString);
    return localLong2;
  }
  
  public SubMsgType0x7.MsgBody a(DataLineMsgRecord paramDataLineMsgRecord, long paramLong)
  {
    String str = paramDataLineMsgRecord.filename;
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(1);
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
    ProtocolHelper.fillMsgHeader(localMsgBody.msg_header, paramLong, Long.valueOf(this.i.getCurrentAccountUin()).longValue(), i1);
    SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = new SubMsgType0x7.MsgBody.FTNNotify();
    localFTNNotify.uint64_sessionid.set(paramDataLineMsgRecord.sessionid);
    localFTNNotify.str_file_name.set(str);
    localFTNNotify.str_file_index.set(paramDataLineMsgRecord.serverPath);
    localFTNNotify.bytes_file_md5.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.md5));
    localFTNNotify.uint64_file_len.set(paramDataLineMsgRecord.filesize);
    localFTNNotify.bytes_originfile_md5.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.md5));
    localFTNNotify.uint32_originfiletype.set(c(paramDataLineMsgRecord.msgtype));
    localFTNNotify.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0x1_ftn_notify.add(localFTNNotify);
    localMsgBody.setHasFlag(true);
    return localMsgBody;
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("manually cancel a file . session =");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("DataLineHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLong == 0L)
    {
      this.d.CancelGroup(paramInt, paramLong, 32, paramBoolean);
      return;
    }
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    Object localObject = h().getMessageFacade().d(i1).a(paramLong);
    if (localObject == null)
    {
      this.d.CancelGroup(paramInt, paramLong, 32, paramBoolean);
      return;
    }
    ((DataLineMsgRecord)localObject).fileMsgStatus = 2L;
    ((DataLineMsgRecord)localObject).bIsTransfering = false;
    g(((DataLineMsgRecord)localObject).path);
    this.i.getMessageFacade().d(i1).f(((DataLineMsgRecord)localObject).msgId);
    if (((DataLineMsgRecord)localObject).strMoloKey != null)
    {
      this.l.c(((DataLineMsgRecord)localObject).strMoloKey);
      return;
    }
    this.d.CancelGroup(((DataLineMsgRecord)localObject).groupId, paramLong, 32, paramBoolean);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.d.CancelAll(paramInt, paramBoolean);
    this.l.b();
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Timer localTimer = this.I;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.I = null;
    }
    if (((paramInt == 3) || (paramInt == 2) || (paramInt == 1) || (paramInt == 8)) && (!this.z)) {
      try
      {
        this.I = new Timer();
        this.I.schedule(new DataLineHandler.4(this), 20000L);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localIllegalStateException.printStackTrace();
      }
    }
    notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  protected void a(long paramLong1, long paramLong2, SubMsgType0x7.MsgBody.GenericSubCmd paramGenericSubCmd, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        if (!paramGenericSubCmd.uint32_type.has()) {
          return;
        }
        i1 = paramGenericSubCmd.uint32_type.get();
        if (i1 != 1)
        {
          if (i1 != 7) {
            return;
          }
          MsgBackupPushHandler.a().a(paramGenericSubCmd);
          return;
        }
        if (!paramGenericSubCmd.uint64_sessionid.has()) {
          return;
        }
        if (paramMsgHeader.uint32_src_ter_type.get() == 3) {
          break label723;
        }
        i1 = 0;
        long l2 = paramGenericSubCmd.uint64_sessionid.get();
        long l1 = l2;
        if (i1 == 1) {
          l1 = l2 | 0x0;
        }
        if (!this.a.containsKey(Long.valueOf(l1)))
        {
          paramMsgHeader = new TextMsgPush(Long.valueOf(paramGenericSubCmd.uint32_size.get()), Long.valueOf(l1));
          this.a.put(Long.valueOf(l1), paramMsgHeader);
        }
        else
        {
          paramMsgHeader = (TextMsgPush)this.a.get(Long.valueOf(l1));
        }
        if (!paramGenericSubCmd.bytes_buf.has()) {
          return;
        }
        localObject1 = new String();
        Object localObject2 = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg();
        ((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg)localObject2).mergeFrom(paramGenericSubCmd.bytes_buf.get().toByteArray());
        localObject2 = ((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg)localObject2).rpt_msg_item.get().iterator();
        Object localObject3;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)((Iterator)localObject2).next();
          if ((!((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject3).uint32_type.has()) || (((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject3).uint32_type.get() != 1) || (!((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject3).bytes_text.has())) {
            continue;
          }
          localObject3 = new String(((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject3).bytes_text.get().toByteArray());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append((String)localObject3);
          localObject1 = localStringBuilder.toString();
          continue;
        }
        if (!paramGenericSubCmd.uint32_index.has()) {
          return;
        }
        paramMsgHeader.a(paramGenericSubCmd.uint32_index.get(), (String)localObject1);
        if (paramMsgHeader.a())
        {
          this.a.remove(Long.valueOf(l1));
          localObject2 = new DataLineMsgRecord();
          ((DataLineMsgRecord)localObject2).msgId = l1;
          ((DataLineMsgRecord)localObject2).sessionid = l1;
          if (i1 == 1)
          {
            paramGenericSubCmd = paramMsgHeader.b();
            i1 = 0;
            if (i1 < EmotcationConstants.SYS_EMOTICON_SYMBOL.length)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append('\024');
              ((StringBuilder)localObject3).append(EmotcationConstants.SYS_EMOTICON_SYMBOL[i1]);
              localObject1 = paramGenericSubCmd;
              if (paramGenericSubCmd.indexOf(((StringBuilder)localObject3).toString()) == -1) {
                break label729;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append('\024');
              ((StringBuilder)localObject1).append(EmotcationConstants.SYS_EMOTICON_SYMBOL[i1]);
              localObject1 = ((StringBuilder)localObject1).toString();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("\024");
              ((StringBuilder)localObject3).append((char)i1);
              localObject1 = paramGenericSubCmd.replace((CharSequence)localObject1, ((StringBuilder)localObject3).toString());
              break label729;
            }
            ((DataLineMsgRecord)localObject2).msg = paramGenericSubCmd;
          }
          else
          {
            ((DataLineMsgRecord)localObject2).msg = paramMsgHeader.b();
          }
          ((DataLineMsgRecord)localObject2).msgtype = -1000;
          ((DataLineMsgRecord)localObject2).issend = 0;
          ((DataLineMsgRecord)localObject2).isread = false;
          ((DataLineMsgRecord)localObject2).time = paramLong1;
          ((DataLineMsgRecord)localObject2).issuc = true;
          ((DataLineMsgRecord)localObject2).sessionid = ((DataLineMsgRecord)localObject2).msgId;
          ((DataLineMsgRecord)localObject2).shmsgseq = paramLong2;
          i1 = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject2).sessionid);
          this.i.getMessageFacade().d(i1).a((DataLineMsgRecord)localObject2, true);
          u();
          a(8, true, new Object[] { Integer.valueOf((int)paramLong1), paramMsgHeader.b(), Long.valueOf(((DataLineMsgRecord)localObject2).sessionid) });
          return;
        }
      }
      catch (Exception paramGenericSubCmd)
      {
        paramGenericSubCmd.printStackTrace();
      }
      return;
      label723:
      int i1 = 1;
      continue;
      label729:
      i1 += 1;
      paramGenericSubCmd = (SubMsgType0x7.MsgBody.GenericSubCmd)localObject1;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this.r);
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    if (paramDataLineMsgRecord == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Session localSession = this.g.genSession(paramDataLineMsgRecord);
    if (localSession == null) {
      return;
    }
    if (0L == paramDataLineMsgRecord.sessionid) {
      localSession.uSessionID = a(0, this.c).longValue();
    }
    localSession.msgHeader = this.g.msgHeader(Long.valueOf(this.i.getCurrentAccountUin()).longValue(), this.c);
    localArrayList.add(localSession);
    b(localArrayList, paramBoolean);
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (paramWeiYunFileInfo == null)
    {
      QLog.e("DatalineHandler", 1, "sendWeiYunFile weiYunFileInfo=null");
      return;
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.selfuin = this.i.getCurrentUin();
    localDataLineMsgRecord.filename = paramWeiYunFileInfo.c;
    localDataLineMsgRecord.filesize = paramWeiYunFileInfo.d;
    localDataLineMsgRecord.busId = 25;
    localDataLineMsgRecord.fileFrom = 4;
    localDataLineMsgRecord.nOpType = 35;
    localDataLineMsgRecord.istroop = 0;
    DataLineHandler localDataLineHandler = (DataLineHandler)this.i.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    localDataLineMsgRecord.sessionid = localDataLineHandler.a(0, 0).longValue();
    localDataLineMsgRecord.msg = "";
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    ((ISVIPHandler)this.i.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localDataLineMsgRecord);
    localDataLineMsgRecord.time = MessageCache.c();
    localDataLineMsgRecord.progress = 0.2F;
    localDataLineMsgRecord.fileMsgStatus = 0L;
    localDataLineMsgRecord.msgtype = b(0);
    localDataLineMsgRecord.bIsTransfering = true;
    localDataLineMsgRecord.bNoInsertFm = true;
    localDataLineMsgRecord.strWeiyunId = paramWeiYunFileInfo.a;
    localDataLineMsgRecord.strWeiyunDir = paramWeiYunFileInfo.b;
    localDataLineMsgRecord.nWeiyunSrcType = paramWeiYunFileInfo.f;
    localDataLineMsgRecord.strWeiyunMd5 = paramWeiYunFileInfo.m;
    localDataLineMsgRecord.strWeiyunSha = paramWeiYunFileInfo.n;
    this.i.getMessageFacade().d(DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid)).a(localDataLineMsgRecord, true);
    localDataLineHandler.a(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)c(localDataLineMsgRecord.msgtype)), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(localDataLineMsgRecord.filesize) });
    a(localDataLineMsgRecord, paramWeiYunFileInfo);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      int i1 = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX", -1);
      if (i1 < 0) {
        return;
      }
      if (i1 < 3)
      {
        paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i1 + 1);
        a(paramToServiceMsg);
        return;
      }
    }
    if (paramFromServiceMsg != null)
    {
      if (paramFromServiceMsg.getServiceCmd() == null) {
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, 1610);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, 1710);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, 1810);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, 1210);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400"))
      {
        if (((Boolean)paramToServiceMsg.getAttribute("sendFromNative", Boolean.valueOf(true))).booleanValue())
        {
          a(paramToServiceMsg, paramFromServiceMsg, 1410);
          return;
        }
        b(paramToServiceMsg, paramFromServiceMsg, 1410);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100"))
      {
        a(paramToServiceMsg, paramFromServiceMsg, 60110);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("GTalkFileAppSvr.CMD_DISCUSS_FILE"))
      {
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("<PbSendMsg><R><---handle0x346Rsp, unknown cmd:");
        paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
        QLog.d("DataLineHandler", 2, paramToServiceMsg.toString());
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new DataLineHandler.6(this, paramToServiceMsg, paramFromServiceMsg, paramInt));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("received a cmd=");
      localStringBuilder.append(paramFromServiceMsg.getServiceCmd());
      QLog.d("DataLineHandler", 2, localStringBuilder.toString());
    }
    if (paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PbSendMsg"))
    {
      if (paramToServiceMsg.extraData.getBoolean("exit_push_0x211_key", false))
      {
        MsgBackupPushHandler.a().a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getInt("ROUNTING_TYPE") == 13)
      {
        if (!paramToServiceMsg.extraData.getBoolean("ISFROM_DATALINE")) {
          return;
        }
        if (paramFromServiceMsg.getResultCode() != 1000)
        {
          int i1 = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX");
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("<PbSendMsg><R><---handle0x211C2CMessageError, retry = ");
            localStringBuilder.append(i1);
            QLog.d("DataLineHandler", 2, localStringBuilder.toString());
          }
          if (i1 < 3)
          {
            paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i1 + 1);
            sendPbReq(paramToServiceMsg);
            return;
          }
        }
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public void a(ArrayList<FileInfo> paramArrayList)
  {
    a(paramArrayList, null, null, Long.valueOf(this.i.getCurrentAccountUin()).longValue());
  }
  
  public void a(ArrayList<FileInfo> paramArrayList, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayList == null) {
      return;
    }
    for (;;)
    {
      int i2 = paramArrayList.size();
      Object localObject2;
      Object localObject3;
      if (i2 <= 3)
      {
        i1 = 0;
        while (i1 < i2)
        {
          localObject1 = new ArrayList();
          localObject2 = ((FileInfo)paramArrayList.get(i1)).d();
          localObject3 = ((FileInfo)paramArrayList.get(i1)).b();
          localObject2 = this.g.genSession(0, (String)localObject2, null, (String)localObject3, 0, 0, 0L, 0, 0, 0);
          if (localObject2 != null)
          {
            ((ArrayList)localObject1).add(localObject2);
            ((Session)localObject2).uSessionID = a(0, this.c).longValue();
            ((Session)localObject2).msgHeader = this.g.msgHeader(paramLong, this.c);
            this.g.fillService((Session)localObject2, paramString, paramArrayOfByte);
          }
          if (((ArrayList)localObject1).size() > 0) {
            b((ArrayList)localObject1, false);
          }
          i1 += 1;
        }
      }
      if ((i2 > 3) && (i2 < 50))
      {
        localObject1 = new ArrayList();
        i1 = g();
        int i3 = 0;
        while (i3 < i2)
        {
          localObject2 = ((FileInfo)paramArrayList.get(i3)).d();
          localObject3 = ((FileInfo)paramArrayList.get(i3)).b();
          localObject3 = this.g.genSession(0, (String)localObject2, null, (String)localObject3, 0, 0, 0L, i1, i2, i3);
          if (localObject3 != null)
          {
            localObject2 = localObject1;
            ((ArrayList)localObject2).add(localObject3);
            int i5 = this.c;
            int i4 = i1;
            ((Session)localObject3).uSessionID = a(i4, i5).longValue();
            ((Session)localObject3).msgHeader = this.g.msgHeader(paramLong, this.c);
            this.g.fillService((Session)localObject3, paramString, paramArrayOfByte);
            if (DataLineMsgSet.isSingle(0, i4))
            {
              ((Session)localObject3).dwGroupID = 0;
              ((Session)localObject3).dwGroupIndex = 0;
              ((Session)localObject3).dwGroupSize = 0;
              if (((ArrayList)localObject2).size() > 0) {
                b((ArrayList)localObject2, false);
              }
              localObject1 = new ArrayList();
            }
          }
          i3 += 1;
        }
        if (((ArrayList)localObject1).size() > 0) {
          b((ArrayList)localObject1, false);
        }
        return;
      }
      i2 = g();
      Object localObject1 = new ArrayList();
      int i1 = 0;
      while (i1 < 50)
      {
        localObject3 = ((FileInfo)paramArrayList.get(i1)).d();
        String str = ((FileInfo)paramArrayList.get(i1)).b();
        ProtocolHelper localProtocolHelper = this.g;
        localObject2 = localObject1;
        localObject3 = localProtocolHelper.genSession(0, (String)localObject3, null, str, 0, 0, 0L, i2, 50, i1);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          ((ArrayList)localObject2).add(localObject3);
          ((Session)localObject3).uSessionID = a(i2, this.c).longValue();
          ((Session)localObject3).msgHeader = this.g.msgHeader(paramLong, this.c);
          this.g.fillService((Session)localObject3, paramString, paramArrayOfByte);
          localObject1 = localObject2;
          if (DataLineMsgSet.isSingle(0, i2))
          {
            ((Session)localObject3).dwGroupID = 0;
            ((Session)localObject3).dwGroupIndex = 0;
            ((Session)localObject3).dwGroupSize = 0;
            if (((ArrayList)localObject2).size() > 0) {
              b((ArrayList)localObject2, false);
            }
            localObject1 = new ArrayList();
          }
        }
        i1 += 1;
      }
      if (((ArrayList)localObject1).size() > 0) {
        b((ArrayList)localObject1, false);
      }
      i1 = 0;
      while (i1 < 50)
      {
        paramArrayList.remove(0);
        i1 += 1;
      }
    }
  }
  
  public void a(ArrayList<DataLineMsgRecord> paramArrayList, boolean paramBoolean)
  {
    a(paramArrayList, paramBoolean, null, null, Long.valueOf(this.i.getCurrentAccountUin()).longValue());
  }
  
  public void a(ArrayList<DataLineMsgRecord> paramArrayList, boolean paramBoolean, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramArrayList.next();
      Session localSession = this.g.genSession(localDataLineMsgRecord);
      if (localSession != null)
      {
        if (0L == localSession.uSessionID) {
          localSession.uSessionID = a(localDataLineMsgRecord.groupId, this.c).longValue();
        }
        localSession.msgHeader = this.g.msgHeader(paramLong, this.c);
        this.g.fillService(localSession, paramString, paramArrayOfByte);
        localArrayList.add(localSession);
      }
    }
    if (localArrayList.size() > 0) {
      b(localArrayList, paramBoolean);
    }
  }
  
  public void a(List<LoginDevItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() < 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LoginDevItem localLoginDevItem = (LoginDevItem)paramList.next();
        if (LoginDevicesUtils.b(localLoginDevItem.b))
        {
          b(true);
          this.w.add(Integer.valueOf(1));
          QLog.i("FileAssistantSender<FileAssistant>", 1, "ipad is online!");
        }
        else if (LoginDevicesUtils.a(localLoginDevItem.b))
        {
          a(true);
          this.w.add(Integer.valueOf(0));
          QLog.i("FileAssistantSender<FileAssistant>", 1, "pc is online!");
        }
      }
    }
  }
  
  public void a(msg_comm.Msg paramMsg)
  {
    this.y.a(paramMsg);
  }
  
  /* Error */
  public void a(msg_comm.Msg paramMsg, SubMsgType0x7.MsgBody paramMsgBody)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 294	com/tencent/mobileqq/app/DataLineHandler:y	Lcooperation/qqdataline/ipc/DatalineRemoteManager;
    //   4: aload_1
    //   5: aload_2
    //   6: invokevirtual 2479	cooperation/qqdataline/ipc/DatalineRemoteManager:a	(Lmsf/msgcomm/msg_comm$Msg;Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody;)V
    //   9: new 572	com/tencent/mobileqq/data/DataLineMsgRecord
    //   12: dup
    //   13: invokespecial 2189	com/tencent/mobileqq/data/DataLineMsgRecord:<init>	()V
    //   16: astore 4
    //   18: aload 4
    //   20: aload_1
    //   21: getfield 2485	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   24: invokevirtual 2488	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: checkcast 2487	msf/msgcomm/msg_comm$MsgHead
    //   30: getfield 2491	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   33: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   36: i2l
    //   37: putfield 2318	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   40: aload 4
    //   42: aload_1
    //   43: getfield 2485	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   46: invokevirtual 2488	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   49: checkcast 2487	msf/msgcomm/msg_comm$MsgHead
    //   52: getfield 2494	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   55: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   58: i2l
    //   59: putfield 2210	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   62: aload 4
    //   64: aload_1
    //   65: getfield 2485	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   68: invokevirtual 2488	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   71: checkcast 2487	msf/msgcomm/msg_comm$MsgHead
    //   74: getfield 2497	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   77: invokevirtual 2278	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   80: putfield 612	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   83: aload_2
    //   84: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   87: invokevirtual 2498	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:has	()Z
    //   90: ifeq +1173 -> 1263
    //   93: aload_2
    //   94: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   97: getfield 2501	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   100: invokevirtual 867	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   103: ifeq +1149 -> 1252
    //   106: aload_2
    //   107: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   110: getfield 2504	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_inst_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   113: invokevirtual 867	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   116: ifeq +1125 -> 1241
    //   119: aload_2
    //   120: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   123: getfield 2507	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_dst_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 867	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   129: ifeq +1101 -> 1230
    //   132: aload_2
    //   133: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   136: getfield 2510	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_dst_inst_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   139: invokevirtual 867	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   142: ifeq +1077 -> 1219
    //   145: aload_0
    //   146: aload_2
    //   147: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   150: getfield 2501	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   153: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   156: aload_2
    //   157: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   160: getfield 2504	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_inst_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   163: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   166: invokevirtual 2512	com/tencent/mobileqq/app/DataLineHandler:b	(II)Z
    //   169: ifne +1039 -> 1208
    //   172: aload_2
    //   173: getfield 1212	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   176: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   179: iconst_5
    //   180: if_icmpeq +44 -> 224
    //   183: aload_0
    //   184: aload_2
    //   185: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   188: getfield 2507	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_dst_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   191: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   194: aload_2
    //   195: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   198: getfield 2510	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_dst_inst_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   201: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   204: invokevirtual 2514	com/tencent/mobileqq/app/DataLineHandler:c	(II)Z
    //   207: ifeq +6 -> 213
    //   210: goto +14 -> 224
    //   213: new 1521	java/lang/Exception
    //   216: dup
    //   217: ldc_w 2516
    //   220: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   223: athrow
    //   224: aload_1
    //   225: getfield 2485	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   228: invokevirtual 2488	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   231: checkcast 2487	msf/msgcomm/msg_comm$MsgHead
    //   234: getfield 2520	msf/msgcomm/msg_comm$MsgHead:msg_inst_ctrl	Ltencent/im/msg/im_msg_head$InstCtrl;
    //   237: invokevirtual 2521	tencent/im/msg/im_msg_head$InstCtrl:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   240: checkcast 550	tencent/im/msg/im_msg_head$InstCtrl
    //   243: getfield 568	tencent/im/msg/im_msg_head$InstCtrl:msg_from_inst	Ltencent/im/msg/im_msg_head$InstInfo;
    //   246: invokevirtual 2522	tencent/im/msg/im_msg_head$InstInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   249: checkcast 507	tencent/im/msg/im_msg_head$InstInfo
    //   252: astore 5
    //   254: aload_2
    //   255: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   258: getfield 2276	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_ter_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   261: aload 5
    //   263: getfield 525	tencent/im/msg/im_msg_head$InstInfo:enum_device_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   266: invokevirtual 2523	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   269: invokevirtual 518	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   272: new 244	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   279: astore 5
    //   281: aload 5
    //   283: ldc_w 2525
    //   286: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 5
    //   292: aload 4
    //   294: getfield 2210	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   297: invokevirtual 389	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 5
    //   303: ldc_w 2527
    //   306: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 5
    //   312: aload 4
    //   314: getfield 2318	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   317: invokevirtual 389	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 5
    //   323: ldc_w 2529
    //   326: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 5
    //   332: aload_2
    //   333: getfield 1212	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: invokevirtual 365	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 5
    //   345: ldc_w 1819
    //   348: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: ldc_w 328
    //   355: iconst_2
    //   356: aload 5
    //   358: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 601	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload_0
    //   365: getfield 172	com/tencent/mobileqq/app/DataLineHandler:i	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   368: invokevirtual 579	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   371: aload_2
    //   372: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   375: getfield 2276	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_ter_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   378: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   381: invokevirtual 584	com/tencent/imcore/message/QQMessageFacade:d	(I)Lcom/tencent/mobileqq/app/message/DatalineMessageManager;
    //   384: aload 4
    //   386: getfield 2210	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   389: invokevirtual 2531	com/tencent/mobileqq/app/message/DatalineMessageManager:g	(J)V
    //   392: aload_0
    //   393: aload 4
    //   395: aload_2
    //   396: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   399: getfield 2276	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_ter_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   402: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   405: invokevirtual 2534	com/tencent/mobileqq/app/DataLineHandler:a	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;I)Z
    //   408: ifeq +87 -> 495
    //   411: new 244	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   418: astore_1
    //   419: aload_1
    //   420: ldc_w 2525
    //   423: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_1
    //   428: aload 4
    //   430: getfield 2210	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   433: invokevirtual 389	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload_1
    //   438: ldc_w 2536
    //   441: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_1
    //   446: aload 4
    //   448: getfield 2318	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   451: invokevirtual 389	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload_1
    //   456: ldc_w 2529
    //   459: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload_1
    //   464: aload_2
    //   465: getfield 1212	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   468: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   471: invokevirtual 365	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload_1
    //   476: ldc_w 1819
    //   479: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: ldc_w 328
    //   486: iconst_2
    //   487: aload_1
    //   488: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 601	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: return
    //   495: aload_0
    //   496: getfield 172	com/tencent/mobileqq/app/DataLineHandler:i	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   499: getstatic 1765	com/tencent/mobileqq/app/BusinessHandlerFactory:REGPRXYSVCPACK_HANDLER	Ljava/lang/String;
    //   502: invokevirtual 1769	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   505: checkcast 1771	com/tencent/mobileqq/app/RegisterProxySvcPackHandler
    //   508: astore 5
    //   510: aload 5
    //   512: ifnull +18 -> 530
    //   515: aload 5
    //   517: invokevirtual 2537	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:g	()I
    //   520: iconst_1
    //   521: if_icmpeq +9 -> 530
    //   524: aload 5
    //   526: iconst_1
    //   527: invokevirtual 2538	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:e	(I)V
    //   530: aload_2
    //   531: getfield 1212	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   534: invokevirtual 867	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   537: ifeq +660 -> 1197
    //   540: new 244	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   547: astore 5
    //   549: aload 5
    //   551: ldc_w 2525
    //   554: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 5
    //   560: aload 4
    //   562: getfield 2210	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   565: invokevirtual 389	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload 5
    //   571: ldc_w 2540
    //   574: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload 5
    //   580: aload 4
    //   582: getfield 2318	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   585: invokevirtual 389	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 5
    //   591: ldc_w 2529
    //   594: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload 5
    //   600: aload_2
    //   601: getfield 1212	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   604: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   607: invokevirtual 365	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload 5
    //   613: ldc_w 1819
    //   616: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: ldc_w 328
    //   623: iconst_2
    //   624: aload 5
    //   626: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 601	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: aload_2
    //   633: getfield 1212	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   636: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   639: istore_3
    //   640: iload_3
    //   641: tableswitch	default:+59 -> 700, 1:+483->1124, 2:+410->1051, 3:+378->1019, 4:+318->959, 5:+290->931, 6:+59->700, 7:+59->700, 8:+218->859, 9:+145->786, 10:+72->713, 11:+60->701
    //   701: aload_0
    //   702: aload_2
    //   703: getfield 2543	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0xb_mpfile_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   706: invokevirtual 2296	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   709: invokevirtual 2545	com/tencent/mobileqq/app/DataLineHandler:c	(Ljava/util/List;)V
    //   712: return
    //   713: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   716: ifeq +13 -> 729
    //   719: ldc_w 328
    //   722: iconst_2
    //   723: ldc_w 2547
    //   726: invokestatic 601	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   729: aload_2
    //   730: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   733: getfield 2548	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   736: invokevirtual 863	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   739: ifeq +36 -> 775
    //   742: aload_0
    //   743: aload_1
    //   744: getfield 2485	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   747: invokevirtual 2488	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   750: checkcast 2487	msf/msgcomm/msg_comm$MsgHead
    //   753: getfield 2494	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   756: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   759: aload_2
    //   760: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   763: aload_2
    //   764: getfield 2551	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0xa_nfc_thumb_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   767: invokevirtual 2296	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   770: iconst_1
    //   771: invokespecial 2553	com/tencent/mobileqq/app/DataLineHandler:b	(ILtencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;Ljava/util/List;Z)V
    //   774: return
    //   775: new 1521	java/lang/Exception
    //   778: dup
    //   779: ldc_w 2555
    //   782: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   785: athrow
    //   786: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   789: ifeq +13 -> 802
    //   792: ldc_w 328
    //   795: iconst_2
    //   796: ldc_w 2557
    //   799: invokestatic 601	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   802: aload_2
    //   803: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   806: getfield 2548	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   809: invokevirtual 863	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   812: ifeq +36 -> 848
    //   815: aload_0
    //   816: aload_1
    //   817: getfield 2485	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   820: invokevirtual 2488	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   823: checkcast 2487	msf/msgcomm/msg_comm$MsgHead
    //   826: getfield 2494	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   829: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   832: aload_2
    //   833: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   836: aload_2
    //   837: getfield 2560	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0x9_ftn_thumb_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   840: invokevirtual 2296	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   843: iconst_1
    //   844: invokespecial 2562	com/tencent/mobileqq/app/DataLineHandler:a	(ILtencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;Ljava/util/List;Z)V
    //   847: return
    //   848: new 1521	java/lang/Exception
    //   851: dup
    //   852: ldc_w 2555
    //   855: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   858: athrow
    //   859: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   862: ifeq +13 -> 875
    //   865: ldc_w 328
    //   868: iconst_2
    //   869: ldc_w 2564
    //   872: invokestatic 601	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   875: aload_2
    //   876: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   879: getfield 2548	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   882: invokevirtual 863	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   885: ifeq +35 -> 920
    //   888: aload_0
    //   889: aload_1
    //   890: getfield 2485	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   893: invokevirtual 2488	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   896: checkcast 2487	msf/msgcomm/msg_comm$MsgHead
    //   899: getfield 2494	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   902: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   905: aload_2
    //   906: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   909: aload_2
    //   910: getfield 2567	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0x8_rnfc_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   913: invokevirtual 2296	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   916: invokespecial 2569	com/tencent/mobileqq/app/DataLineHandler:a	(ILtencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;Ljava/util/List;)V
    //   919: return
    //   920: new 1521	java/lang/Exception
    //   923: dup
    //   924: ldc_w 2555
    //   927: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   930: athrow
    //   931: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   934: ifeq +13 -> 947
    //   937: ldc_w 328
    //   940: iconst_2
    //   941: ldc_w 2571
    //   944: invokestatic 601	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   947: aload_0
    //   948: aload_2
    //   949: getfield 2574	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0x5_molo_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   952: invokevirtual 2296	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   955: invokespecial 2576	com/tencent/mobileqq/app/DataLineHandler:d	(Ljava/util/List;)V
    //   958: return
    //   959: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   962: ifeq +13 -> 975
    //   965: ldc_w 328
    //   968: iconst_2
    //   969: ldc_w 2578
    //   972: invokestatic 601	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   975: aload_2
    //   976: getfield 1218	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_subcmd_0x4_generic	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$GenericSubCmd;
    //   979: invokevirtual 2579	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$GenericSubCmd:has	()Z
    //   982: ifeq +26 -> 1008
    //   985: aload_0
    //   986: aload 4
    //   988: getfield 2210	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   991: aload 4
    //   993: getfield 2318	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   996: aload_2
    //   997: getfield 1218	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_subcmd_0x4_generic	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$GenericSubCmd;
    //   1000: aload_2
    //   1001: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   1004: invokevirtual 2581	com/tencent/mobileqq/app/DataLineHandler:a	(JJLtencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$GenericSubCmd;Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;)V
    //   1007: return
    //   1008: new 1521	java/lang/Exception
    //   1011: dup
    //   1012: ldc_w 2583
    //   1015: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1018: athrow
    //   1019: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1022: ifeq +13 -> 1035
    //   1025: ldc_w 328
    //   1028: iconst_2
    //   1029: ldc_w 2585
    //   1032: invokestatic 601	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1035: aload_0
    //   1036: aload_2
    //   1037: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   1040: aload_2
    //   1041: getfield 2588	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0x3_filecontrol	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1044: invokevirtual 2296	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1047: invokespecial 2590	com/tencent/mobileqq/app/DataLineHandler:a	(Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;Ljava/util/List;)V
    //   1050: return
    //   1051: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1054: ifeq +13 -> 1067
    //   1057: ldc_w 328
    //   1060: iconst_2
    //   1061: ldc_w 2592
    //   1064: invokestatic 601	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1067: aload_2
    //   1068: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   1071: getfield 2548	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1074: invokevirtual 863	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1077: ifeq +36 -> 1113
    //   1080: aload_0
    //   1081: aload_1
    //   1082: getfield 2485	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1085: invokevirtual 2488	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1088: checkcast 2487	msf/msgcomm/msg_comm$MsgHead
    //   1091: getfield 2494	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1094: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1097: aload_2
    //   1098: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   1101: aload_2
    //   1102: getfield 2595	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0x2_nfc_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1105: invokevirtual 2296	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1108: iconst_0
    //   1109: invokespecial 2553	com/tencent/mobileqq/app/DataLineHandler:b	(ILtencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;Ljava/util/List;Z)V
    //   1112: return
    //   1113: new 1521	java/lang/Exception
    //   1116: dup
    //   1117: ldc_w 2555
    //   1120: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1123: athrow
    //   1124: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1127: ifeq +13 -> 1140
    //   1130: ldc_w 328
    //   1133: iconst_2
    //   1134: ldc_w 2597
    //   1137: invokestatic 601	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1140: aload_2
    //   1141: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   1144: getfield 2548	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1147: invokevirtual 863	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1150: ifeq +36 -> 1186
    //   1153: aload_0
    //   1154: aload_1
    //   1155: getfield 2485	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1158: invokevirtual 2488	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1161: checkcast 2487	msf/msgcomm/msg_comm$MsgHead
    //   1164: getfield 2494	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1167: invokevirtual 1214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1170: aload_2
    //   1171: getfield 1970	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   1174: aload_2
    //   1175: getfield 2224	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0x1_ftn_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1178: invokevirtual 2296	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1181: iconst_0
    //   1182: invokespecial 2562	com/tencent/mobileqq/app/DataLineHandler:a	(ILtencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;Ljava/util/List;Z)V
    //   1185: return
    //   1186: new 1521	java/lang/Exception
    //   1189: dup
    //   1190: ldc_w 2555
    //   1193: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1196: athrow
    //   1197: new 1521	java/lang/Exception
    //   1200: dup
    //   1201: ldc_w 2599
    //   1204: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1207: athrow
    //   1208: new 1521	java/lang/Exception
    //   1211: dup
    //   1212: ldc_w 2601
    //   1215: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1218: athrow
    //   1219: new 1521	java/lang/Exception
    //   1222: dup
    //   1223: ldc_w 2603
    //   1226: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1229: athrow
    //   1230: new 1521	java/lang/Exception
    //   1233: dup
    //   1234: ldc_w 2605
    //   1237: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1240: athrow
    //   1241: new 1521	java/lang/Exception
    //   1244: dup
    //   1245: ldc_w 2607
    //   1248: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1251: athrow
    //   1252: new 1521	java/lang/Exception
    //   1255: dup
    //   1256: ldc_w 2609
    //   1259: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1262: athrow
    //   1263: new 1521	java/lang/Exception
    //   1266: dup
    //   1267: ldc_w 2611
    //   1270: invokespecial 2517	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1273: athrow
    //   1274: astore_1
    //   1275: goto +55 -> 1330
    //   1278: astore_1
    //   1279: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1282: ifeq +47 -> 1329
    //   1285: new 244	java/lang/StringBuilder
    //   1288: dup
    //   1289: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1292: astore_2
    //   1293: aload_2
    //   1294: ldc_w 2613
    //   1297: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: pop
    //   1301: aload_2
    //   1302: aload_1
    //   1303: invokevirtual 2614	java/lang/Exception:toString	()Ljava/lang/String;
    //   1306: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1309: pop
    //   1310: aload_2
    //   1311: ldc_w 2616
    //   1314: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: pop
    //   1318: ldc_w 328
    //   1321: iconst_2
    //   1322: aload_2
    //   1323: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1326: invokestatic 601	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1329: return
    //   1330: aload_1
    //   1331: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1332	0	this	DataLineHandler
    //   0	1332	1	paramMsg	msg_comm.Msg
    //   0	1332	2	paramMsgBody	SubMsgType0x7.MsgBody
    //   639	2	3	i1	int
    //   16	976	4	localDataLineMsgRecord	DataLineMsgRecord
    //   252	373	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	210	1274	finally
    //   213	224	1274	finally
    //   224	494	1274	finally
    //   495	510	1274	finally
    //   515	530	1274	finally
    //   530	640	1274	finally
    //   701	712	1274	finally
    //   713	729	1274	finally
    //   729	774	1274	finally
    //   775	786	1274	finally
    //   786	802	1274	finally
    //   802	847	1274	finally
    //   848	859	1274	finally
    //   859	875	1274	finally
    //   875	919	1274	finally
    //   920	931	1274	finally
    //   931	947	1274	finally
    //   947	958	1274	finally
    //   959	975	1274	finally
    //   975	1007	1274	finally
    //   1008	1019	1274	finally
    //   1019	1035	1274	finally
    //   1035	1050	1274	finally
    //   1051	1067	1274	finally
    //   1067	1112	1274	finally
    //   1113	1124	1274	finally
    //   1124	1140	1274	finally
    //   1140	1185	1274	finally
    //   1186	1197	1274	finally
    //   1197	1208	1274	finally
    //   1208	1219	1274	finally
    //   1219	1230	1274	finally
    //   1230	1241	1274	finally
    //   1241	1252	1274	finally
    //   1252	1263	1274	finally
    //   1263	1274	1274	finally
    //   1279	1329	1274	finally
    //   9	210	1278	java/lang/Exception
    //   213	224	1278	java/lang/Exception
    //   224	494	1278	java/lang/Exception
    //   495	510	1278	java/lang/Exception
    //   515	530	1278	java/lang/Exception
    //   530	640	1278	java/lang/Exception
    //   701	712	1278	java/lang/Exception
    //   713	729	1278	java/lang/Exception
    //   729	774	1278	java/lang/Exception
    //   775	786	1278	java/lang/Exception
    //   786	802	1278	java/lang/Exception
    //   802	847	1278	java/lang/Exception
    //   848	859	1278	java/lang/Exception
    //   859	875	1278	java/lang/Exception
    //   875	919	1278	java/lang/Exception
    //   920	931	1278	java/lang/Exception
    //   931	947	1278	java/lang/Exception
    //   947	958	1278	java/lang/Exception
    //   959	975	1278	java/lang/Exception
    //   975	1007	1278	java/lang/Exception
    //   1008	1019	1278	java/lang/Exception
    //   1019	1035	1278	java/lang/Exception
    //   1035	1050	1278	java/lang/Exception
    //   1051	1067	1278	java/lang/Exception
    //   1067	1112	1278	java/lang/Exception
    //   1113	1124	1278	java/lang/Exception
    //   1124	1140	1278	java/lang/Exception
    //   1140	1185	1278	java/lang/Exception
    //   1186	1197	1278	java/lang/Exception
    //   1197	1208	1278	java/lang/Exception
    //   1208	1219	1278	java/lang/Exception
    //   1219	1230	1278	java/lang/Exception
    //   1230	1241	1278	java/lang/Exception
    //   1241	1252	1278	java/lang/Exception
    //   1252	1263	1278	java/lang/Exception
    //   1263	1274	1278	java/lang/Exception
  }
  
  public void a(msg_comm.Msg paramMsg, C2CType0x211_SubC2CType0x9.MsgBody paramMsgBody)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new MqqHandler(localLooper).post(new DataLineHandler.10(this, this, paramMsg, paramMsgBody));
      return;
    }
    this.e.a(this, paramMsg, paramMsgBody);
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
    if (!QFileAssistantUtils.a(this.i))
    {
      SharedPreferences localSharedPreferences = this.i.getPreferences();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.i.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_PC_STATE");
      localObject = ((StringBuilder)localObject).toString();
      if (this.s)
      {
        localSharedPreferences.edit().putLong((String)localObject, this.u).commit();
        return;
      }
      localSharedPreferences.edit().remove((String)localObject).commit();
    }
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    int i1 = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.i.getDataLineMsgProxy(i1).b(paramLong);
    DataLineMsgSet localDataLineMsgSet = this.i.getDataLineMsgProxy(i1).a(paramInt);
    if ((localDataLineMsgSet != null) && (localDataLineMsgSet.isPaused()))
    {
      if (localDataLineMsgRecord != null)
      {
        localDataLineMsgRecord.issuc = true;
        localDataLineMsgRecord.fileMsgStatus = 2L;
        this.i.getMessageFacade().d(i1).f(localDataLineMsgRecord.msgId);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    long l1 = paramDataLineMsgRecord.sessionid;
    double d1 = paramDataLineMsgRecord.filesize;
    Double.isNaN(d1);
    OnSessionProgress(l1, (d1 * 0.4D), paramDataLineMsgRecord.filesize, 0);
    if ((0L != paramDataLineMsgRecord.filesize) && (paramDataLineMsgRecord.path != null) && (paramDataLineMsgRecord.path.length() != 0) && (paramDataLineMsgRecord.md5 != null) && (paramDataLineMsgRecord.md5.length != 0)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      return true;
    }
    Object localObject2 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject2).uint32_cmd.set(1400);
    ((cmd0x346.ReqBody)localObject2).uint32_client_type.set(104);
    Object localObject1 = ((cmd0x346.ReqBody)localObject2).uint32_seq;
    int i1 = J;
    J = i1 + 1;
    ((PBUInt32Field)localObject1).set(i1);
    ((cmd0x346.ReqBody)localObject2).msg_file_query_req.setHasFlag(true);
    ((cmd0x346.ReqBody)localObject2).msg_file_query_req.uint64_uin.set(Long.valueOf(this.i.getCurrentAccountUin()).longValue());
    if ((2 != paramDataLineMsgRecord.fileFrom) && (4 != paramDataLineMsgRecord.fileFrom) && (6 != paramDataLineMsgRecord.fileFrom))
    {
      ((cmd0x346.ReqBody)localObject2).msg_file_query_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.fileUuid.getBytes()));
      ((cmd0x346.ReqBody)localObject2).uint32_business_id.set(3);
    }
    else
    {
      ((cmd0x346.ReqBody)localObject2).msg_file_query_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.serverPath.getBytes()));
      ((cmd0x346.ReqBody)localObject2).uint32_business_id.set(38);
    }
    localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400", null);
    ((ToServiceMsg)localObject1).addAttribute("sendFromNative", Boolean.valueOf(false));
    localObject2 = ((cmd0x346.ReqBody)localObject2).toByteArray();
    byte[] arrayOfByte = new byte[localObject2.length + 4];
    PkgTools.dWord2Byte(arrayOfByte, 0, localObject2.length + 4);
    PkgTools.copyData(arrayOfByte, 4, (byte[])localObject2, localObject2.length);
    if (localObject1 != null)
    {
      ((ToServiceMsg)localObject1).putWupBuffer(arrayOfByte);
      ((ToServiceMsg)localObject1).addAttribute("cookie", Long.valueOf(paramDataLineMsgRecord.sessionid));
      ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_TRYINDEX", 0);
      a((ToServiceMsg)localObject1);
    }
    return false;
  }
  
  public boolean a(DataLineMsgRecord paramDataLineMsgRecord, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Iterator localIterator;
    MessageRecord localMessageRecord;
    if (paramInt == 3)
    {
      if (this.o == null) {
        this.o = new ArrayList();
      }
      if (this.o.isEmpty())
      {
        localObject = this.i.getDataLineMsgProxy(1).a();
        if ((localObject != null) && (((DataLineMsgSetList)localObject).size() > 0))
        {
          localObject = ((DataLineMsgSetList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localIterator = ((DataLineMsgSet)((Iterator)localObject).next()).values().iterator();
            while (localIterator.hasNext())
            {
              localMessageRecord = (MessageRecord)localIterator.next();
              this.o.add(Long.valueOf(localMessageRecord.shmsgseq));
            }
          }
        }
      }
      localObject = this.o.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Long)((Iterator)localObject).next()).longValue() == paramDataLineMsgRecord.shmsgseq) {
          break label191;
        }
      }
      bool1 = false;
      label191:
      if (!bool1)
      {
        this.o.add(Long.valueOf(paramDataLineMsgRecord.shmsgseq));
        if (this.o.size() > 120) {
          this.o.remove(0);
        }
      }
      return bool1;
    }
    if (this.n == null) {
      this.n = new ArrayList();
    }
    if (this.n.isEmpty())
    {
      localObject = this.i.getDataLineMsgProxy(0).a();
      if ((localObject != null) && (((DataLineMsgSetList)localObject).size() > 0))
      {
        localObject = ((DataLineMsgSetList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localIterator = ((DataLineMsgSet)((Iterator)localObject).next()).values().iterator();
          while (localIterator.hasNext())
          {
            localMessageRecord = (MessageRecord)localIterator.next();
            this.n.add(Long.valueOf(localMessageRecord.shmsgseq));
          }
        }
      }
    }
    Object localObject = this.n.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((Long)((Iterator)localObject).next()).longValue() == paramDataLineMsgRecord.shmsgseq)
      {
        bool1 = bool2;
        break label423;
      }
    }
    bool1 = false;
    label423:
    if (!bool1)
    {
      this.n.add(Long.valueOf(paramDataLineMsgRecord.shmsgseq));
      if (this.n.size() > 120) {
        this.n.remove(0);
      }
    }
    return bool1;
  }
  
  public boolean a(DataLineMsgSet paramDataLineMsgSet)
  {
    if (!paramDataLineMsgSet.isSingle()) {
      i(paramDataLineMsgSet.getGroupId());
    }
    int i1 = DataLineMsgRecord.getDevTypeBySet(paramDataLineMsgSet);
    Iterator localIterator = paramDataLineMsgSet.values().iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if (localDataLineMsgRecord.strMoloKey != null)
      {
        Object localObject = h().getDataLineMsgProxy(i1).a(localDataLineMsgRecord.strMoloKey);
        if ((localObject == null) || (((List)localObject).size() == 1))
        {
          this.l.d(localDataLineMsgRecord.strMoloKey);
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("删除应用宝消息 sessionid[");
            ((StringBuilder)localObject).append(localDataLineMsgRecord.sessionid);
            QLog.d("DataLineHandler", 4, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    return this.i.getMessageFacade().d(i1).a(paramDataLineMsgSet) >= 0;
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.l.f(paramString);
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "--->>logout cancel all task");
    }
    this.E.b(this);
    k(32);
  }
  
  public void b(DataLineMsgRecord paramDataLineMsgRecord)
  {
    a(1004, a(paramDataLineMsgRecord, Long.valueOf(this.i.getCurrentAccountUin()).longValue()), paramDataLineMsgRecord.sessionid);
    long l1 = paramDataLineMsgRecord.sessionid;
    double d1 = paramDataLineMsgRecord.filesize;
    Double.isNaN(d1);
    OnSessionProgress(l1, (d1 * 0.8D), paramDataLineMsgRecord.filesize, 0);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MsgSCBody localMsgSCBody = new MsgSCBody();
    cmd0x345.RspBody localRspBody = new cmd0x345.RspBody();
    localMsgSCBody.uMsgType = 837;
    int i1 = 0;
    localMsgSCBody.bTimeOut = false;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      localMsgSCBody.bTimeOut = true;
    }
    Object localObject = null;
    if (paramFromServiceMsg != null)
    {
      if (paramFromServiceMsg.getWupBuffer() != null)
      {
        int i2 = paramFromServiceMsg.getWupBuffer().length - 4;
        if (i2 < 0) {
          break label128;
        }
        byte[] arrayOfByte = new byte[i2];
        PkgTools.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i2);
        paramFromServiceMsg = arrayOfByte;
      }
      else
      {
        paramFromServiceMsg = null;
      }
      if (paramFromServiceMsg != null) {
        try
        {
          localRspBody.mergeFrom(paramFromServiceMsg);
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
        }
      }
    }
    label128:
    localMsgSCBody.msgBody0x345 = new MsgSCBody0x345();
    paramFromServiceMsg = localMsgSCBody.msgBody0x345;
    if (localRspBody.uint32_sub_cmd.has()) {
      i1 = localRspBody.uint32_sub_cmd.get();
    }
    paramFromServiceMsg.uMsgSubType = i1;
    paramFromServiceMsg = localMsgSCBody.msgBody0x345;
    if (localRspBody.uint32_return_code.has()) {
      i1 = localRspBody.uint32_return_code.get();
    } else {
      i1 = -1;
    }
    paramFromServiceMsg.uint32_return_code = i1;
    if (localMsgSCBody.msgBody0x345.uMsgSubType != 7)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("PBToMsgSCBody : msgtype is not cmd0x345[");
        paramFromServiceMsg.append(localMsgSCBody.msgBody0x345.uMsgSubType);
        QLog.e("DataLineHandler", 2, paramFromServiceMsg.toString());
      }
    }
    else
    {
      paramFromServiceMsg = localObject;
      if (localRspBody.msg_subcmd_0x6_rsp_body.has()) {
        paramFromServiceMsg = (cmd0x345.RspBody.SubCmd0x6RspBody)localRspBody.msg_subcmd_0x6_rsp_body.get();
      }
      if (paramFromServiceMsg != null)
      {
        localMsgSCBody.msgBody0x345.subCmd0x6RspBody = new SubCmd0x6RspBody();
        localMsgSCBody.msgBody0x345.subCmd0x6RspBody.str_file_id = paramFromServiceMsg.str_file_id.get();
        localMsgSCBody.msgBody0x345.subCmd0x6RspBody.str_ret_msg = paramFromServiceMsg.str_ret_msg.get();
      }
    }
    long l1;
    if (paramToServiceMsg == null) {
      l1 = 0L;
    } else {
      l1 = ((Long)paramToServiceMsg.getAttribute("cookie")).longValue();
    }
    this.d.OnPbMsgReply(Long.valueOf(l1).intValue(), localMsgSCBody);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    long l1 = ((Long)paramToServiceMsg.getAttribute("cookie")).longValue();
    paramInt = DataLineMsgRecord.getDevTypeBySeId(l1);
    new Handler(Looper.getMainLooper()).post(new DataLineHandler.7(this, paramFromServiceMsg, paramInt, l1, paramToServiceMsg));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    StringBuilder localStringBuilder;
    try
    {
      localPbSendMsgResp = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DataLineHandler", 2, "<---handle0x211C2CMessageResp::invalid.", localException);
      }
      localStringBuilder = null;
    }
    int i1;
    if ((localStringBuilder != null) && (localStringBuilder.result.has()))
    {
      if (localStringBuilder.result.get() != 0) {
        i1 = localStringBuilder.result.get();
      } else {
        i1 = 0;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("DataLineHandler", 2, "handle0x211C2CMessageResp::server did not return a valid result code, use 4 instead.");
      }
      i1 = 4;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<PbSendMsg><R><---handle0x211C2CMessageResp: ---ServiceCmd:");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      localStringBuilder.append("----replyCode:");
      localStringBuilder.append(i1);
      QLog.d("DataLineHandler", 2, localStringBuilder.toString());
    }
    switch (paramToServiceMsg.extraData.getInt("DATALINE_CMD"))
    {
    case 1002: 
    default: 
    case 1005: 
      paramToServiceMsg = (Long)paramToServiceMsg.getAttribute("cookie");
      if (a(paramToServiceMsg.longValue()) == null)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("uSessionID[");
          paramFromServiceMsg.append(paramToServiceMsg);
          paramFromServiceMsg.append("]handleFileOperate: session not found");
          QLog.d("DataLineHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
      break;
    case 1004: 
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 1003: 
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 1001: 
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void b(ArrayList<InstanceInfo> paramArrayList)
  {
    this.w.clear();
    if (paramArrayList == null) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      int i1;
      switch ((int)((InstanceInfo)paramArrayList.next()).iClientType)
      {
      default: 
        i1 = -1;
        break;
      case 65805: 
      case 68104: 
      case 68361: 
      case 72194: 
        i1 = 1;
        break;
      case 65793: 
      case 66818: 
      case 66831: 
      case 77313: 
      case 81154: 
        i1 = 0;
      }
      if (i1 != -1) {
        this.w.add(Integer.valueOf(i1));
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.t = paramBoolean;
    if (QFileAssistantUtils.a(this.i))
    {
      SharedPreferences localSharedPreferences = this.i.getPreferences();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.i.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_IPAD_STATE");
      localObject = ((StringBuilder)localObject).toString();
      if (this.t)
      {
        localSharedPreferences.edit().putLong((String)localObject, this.v).commit();
        return;
      }
      localSharedPreferences.edit().remove((String)localObject).commit();
    }
  }
  
  protected boolean b(int paramInt1, int paramInt2)
  {
    int i1 = AppSetting.d();
    if ((paramInt1 == 1001) && (paramInt2 == i1) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgBody command from android");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" ");
      localStringBuilder.append(i1);
      QLog.d("DataLineHandler", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.l.b(paramString);
  }
  
  public boolean b(List<Long> paramList)
  {
    QLog.i("DataLineHandler", 1, "manually receives a file . sessionlist");
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = paramList.iterator();
    boolean bool1 = false;
    Object localObject2;
    int i1;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      i1 = DataLineMsgRecord.getDevTypeBySeId(((Long)localObject2).longValue());
      localObject3 = h().getMessageFacade().d(i1).a(((Long)localObject2).longValue());
      if (localObject3 != null)
      {
        ((DataLineMsgRecord)localObject3).fileMsgStatus = 0L;
        this.i.getMessageFacade().d(i1).f(((DataLineMsgRecord)localObject3).msgId);
      }
      if ((localObject3 != null) && (((DataLineMsgRecord)localObject3).strMoloKey != null))
      {
        this.l.a(((DataLineMsgRecord)localObject3).strMoloKey);
        bool1 = true;
      }
      else
      {
        localArrayList1.add(localObject2);
      }
    }
    ArrayList localArrayList2 = new ArrayList();
    if (localArrayList1.size() > 0)
    {
      Iterator localIterator = paramList.iterator();
      localObject3 = null;
      paramList = null;
      localObject1 = paramList;
      while (localIterator.hasNext())
      {
        localObject2 = (Long)localIterator.next();
        i1 = DataLineMsgRecord.getDevTypeBySeId(((Long)localObject2).longValue());
        DataLineMsgRecord localDataLineMsgRecord = this.i.getMessageFacade().d(i1).a(((Long)localObject2).longValue());
        if (localDataLineMsgRecord == null)
        {
          paramList = new StringBuilder();
          paramList.append("uSessionID[");
          paramList.append(localObject2);
          paramList.append("], prepareMsg: session not found");
          QLog.e("DataLineHandler", 1, paramList.toString());
          return false;
        }
        localArrayList2.add(localDataLineMsgRecord);
        if ((localDataLineMsgRecord.filename != null) && (localDataLineMsgRecord.filesize != 0L) && ((localDataLineMsgRecord.md5 != null) || (!TextUtils.isEmpty(localDataLineMsgRecord.serverPath))))
        {
          d(localDataLineMsgRecord);
          Object localObject4 = a(localDataLineMsgRecord.sessionid);
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = new ArrayList();
          }
          ((List)localObject2).add(localObject4);
          localObject3 = new FTNInfo();
          ((FTNInfo)localObject3).strFileIndex = localDataLineMsgRecord.serverPath;
          localObject4 = localObject1;
          if (localObject1 == null) {
            localObject4 = new ArrayList();
          }
          ((List)localObject4).add(localObject3);
          localObject3 = new NFCInfo();
          ((NFCInfo)localObject3).dwServerIP = ((int)localDataLineMsgRecord.nServerIp);
          ((NFCInfo)localObject3).wServerPort = ((short)(int)localDataLineMsgRecord.nServerPort);
          ((NFCInfo)localObject3).vTokenKey = localDataLineMsgRecord.vTokenKey;
          ((NFCInfo)localObject3).vUrlNotify = localDataLineMsgRecord.vUrlNotify;
          localObject1 = paramList;
          if (paramList == null) {
            localObject1 = new ArrayList();
          }
          ((List)localObject1).add(localObject3);
          localObject3 = localObject2;
          paramList = (List<Long>)localObject1;
          localObject1 = localObject4;
        }
        else
        {
          paramList = new StringBuilder();
          paramList.append("uSessionID[");
          paramList.append(localObject2);
          paramList.append("], receive param err.filename:");
          paramList.append(localDataLineMsgRecord.filename);
          paramList.append(" filesize;");
          paramList.append(localDataLineMsgRecord.filesize);
          QLog.e("DataLineHandler", 1, paramList.toString());
          return false;
        }
      }
      boolean bool2 = false;
      if (localObject3 != null)
      {
        localObject2 = this.d;
        localObject3 = (Session[])((List)localObject3).toArray(new Session[((List)localObject3).size()]);
        paramList = (NFCInfo[])paramList.toArray(new NFCInfo[paramList.size()]);
        localObject1 = (FTNInfo[])((List)localObject1).toArray(new FTNInfo[((List)localObject1).size()]);
        if (localArrayList1.size() == 1) {
          bool1 = bool2;
        } else {
          bool1 = true;
        }
        ((LiteTransferWrapper)localObject2).RecvGroup((Session[])localObject3, paramList, (FTNInfo[])localObject1, bool1);
        paramList = localArrayList2.iterator();
        while (paramList.hasNext())
        {
          localObject1 = (DataLineMsgRecord)paramList.next();
          ((DataLineMsgRecord)localObject1).bIsTransfering = true;
          ((DataLineMsgRecord)localObject1).nSessionState = 2;
          f(((DataLineMsgRecord)localObject1).path);
        }
        return true;
      }
    }
    return bool1;
  }
  
  public int c(String paramString)
  {
    if (paramString == null) {
      return 1;
    }
    return this.l.e(paramString);
  }
  
  public long c(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFileManagerEntity.fileName);
    ((StringBuilder)localObject).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramFileManagerEntity.Uuid);
    localStringBuilder.append("\n");
    paramFileManagerEntity = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFileManagerEntity);
    ((StringBuilder)localObject).append("来自:腾讯文档");
    return a(((StringBuilder)localObject).toString(), 0).longValue();
  }
  
  protected void c() {}
  
  public void c(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord == null)
    {
      QLog.e("DatalineHandler", 1, "reSendWeiYunFile entity=null");
      return;
    }
    if ((!TextUtils.isEmpty(paramDataLineMsgRecord.strWeiyunId)) && (!TextUtils.isEmpty(paramDataLineMsgRecord.filename)))
    {
      WeiYunFileInfo localWeiYunFileInfo = new WeiYunFileInfo();
      localWeiYunFileInfo.c = paramDataLineMsgRecord.filename;
      localWeiYunFileInfo.d = paramDataLineMsgRecord.filesize;
      localWeiYunFileInfo.b = paramDataLineMsgRecord.strWeiyunDir;
      localWeiYunFileInfo.a = paramDataLineMsgRecord.strWeiyunId;
      localWeiYunFileInfo.f = paramDataLineMsgRecord.nWeiyunSrcType;
      localWeiYunFileInfo.m = paramDataLineMsgRecord.strWeiyunMd5;
      localWeiYunFileInfo.n = paramDataLineMsgRecord.strWeiyunSha;
      paramDataLineMsgRecord.bNoInsertFm = true;
      a(paramDataLineMsgRecord, localWeiYunFileInfo);
      return;
    }
    QLog.e("DatalineHandler", 1, "reSendWeiYunFile keyinfo=null");
  }
  
  protected void c(List<SubMsgType0x7.MsgBody.MpFileNotify> paramList) {}
  
  public void c(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.i.getPreferences().edit();
    localEditor.putBoolean("auto_receive_files", paramBoolean);
    localEditor.putBoolean("auto_receive_files_ipad", paramBoolean);
    localEditor.apply();
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    this.k = i1;
  }
  
  protected boolean c(int paramInt1, int paramInt2)
  {
    int i1 = AppSetting.d();
    if ((paramInt1 == 1001) && ((paramInt2 == i1) || (paramInt2 == 0))) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgBody command not for android");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" ");
      localStringBuilder.append(i1);
      QLog.d("DataLineHandler", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "--->>wifi lost cancel all task");
    }
    k(41);
  }
  
  public void d(int paramInt)
  {
    this.l.b(paramInt);
  }
  
  public void d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.e("DatalineHandler", 1, "sendWeiYunFile weiyunEntity=null");
      return;
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.selfuin = this.i.getCurrentUin();
    localDataLineMsgRecord.filename = paramFileManagerEntity.fileName;
    if (paramFileManagerEntity.strThumbPath != null)
    {
      localDataLineMsgRecord.thumbPath = com.tencent.mobileqq.filemanager.util.FileUtil.a(com.tencent.mobileqq.filemanager.util.FileUtil.a(this.i.getApplication()), FileManagerUtil.a(paramFileManagerEntity.strThumbPath));
      FileUtils.copyFile(paramFileManagerEntity.strThumbPath, localDataLineMsgRecord.thumbPath);
    }
    localDataLineMsgRecord.filesize = paramFileManagerEntity.fileSize;
    localDataLineMsgRecord.busId = 25;
    localDataLineMsgRecord.fileFrom = 4;
    localDataLineMsgRecord.nOpType = 35;
    localDataLineMsgRecord.istroop = 0;
    Object localObject = (DataLineHandler)this.i.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    localDataLineMsgRecord.sessionid = ((DataLineHandler)localObject).a(0, 0).longValue();
    localDataLineMsgRecord.msg = "";
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    ((ISVIPHandler)this.i.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localDataLineMsgRecord);
    localDataLineMsgRecord.time = MessageCache.c();
    localDataLineMsgRecord.progress = 0.2F;
    localDataLineMsgRecord.fileMsgStatus = 0L;
    localDataLineMsgRecord.msgtype = b(0);
    localDataLineMsgRecord.bIsTransfering = true;
    localDataLineMsgRecord.bNoInsertFm = true;
    this.i.getMessageFacade().d(DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid)).a(localDataLineMsgRecord, true);
    ((DataLineHandler)localObject).a(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)c(localDataLineMsgRecord.msgtype)), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(localDataLineMsgRecord.filesize) });
    localObject = new WeiYunFileInfo();
    ((WeiYunFileInfo)localObject).c = paramFileManagerEntity.fileName;
    ((WeiYunFileInfo)localObject).d = paramFileManagerEntity.fileSize;
    ((WeiYunFileInfo)localObject).b = paramFileManagerEntity.WeiYunDirKey;
    ((WeiYunFileInfo)localObject).a = paramFileManagerEntity.WeiYunFileId;
    ((WeiYunFileInfo)localObject).f = paramFileManagerEntity.nWeiYunSrcType;
    ((WeiYunFileInfo)localObject).m = paramFileManagerEntity.strFileMd5;
    ((WeiYunFileInfo)localObject).n = paramFileManagerEntity.strFileSHA;
    localDataLineMsgRecord.strWeiyunId = ((WeiYunFileInfo)localObject).a;
    localDataLineMsgRecord.strWeiyunDir = ((WeiYunFileInfo)localObject).b;
    localDataLineMsgRecord.nWeiyunSrcType = ((WeiYunFileInfo)localObject).f;
    localDataLineMsgRecord.strWeiyunMd5 = ((WeiYunFileInfo)localObject).m;
    localDataLineMsgRecord.strWeiyunSha = ((WeiYunFileInfo)localObject).n;
    a(localDataLineMsgRecord, (WeiYunFileInfo)localObject);
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("DataLineHandler", 1, "msg is null!");
      return;
    }
    paramString = new QQText(paramString, 13, 32, 0).toPlainText(true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FMSettings.a().getDefaultRecvPath());
    ((StringBuilder)localObject).append(FileManagerUtil.a());
    ((StringBuilder)localObject).append(".txt");
    localObject = ((StringBuilder)localObject).toString();
    a(paramString, new File((String)localObject));
    a((String)localObject, null, 0, FileManagerUtil.a().longValue(), 0, 0, 0, false);
  }
  
  public void e()
  {
    long l1 = this.i.getMessageFacade().getLastMessage(String.valueOf(AppConstants.DATALINE_PC_UIN), 6000).time;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendDatalineReadConfirm last time[");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("]");
    QLog.d("DataLineHandler", 2, ((StringBuilder)localObject).toString());
    if ((l1 != 0L) && (l1 != this.F))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(new Pair(Long.valueOf(this.i.getCurrentAccountUin()), Long.valueOf(l1)));
      ((C2CMessageProcessor)this.i.getMsgHandler().a("c2c_processor")).a((ArrayList)localObject);
      this.F = l1;
    }
    l1 = this.i.getMessageFacade().getLastMessage(String.valueOf(AppConstants.DATALINE_IPAD_UIN), 6003).time;
    if ((l1 != 0L) && (l1 != this.G))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(new Pair(Long.valueOf(this.i.getCurrentAccountUin()), Long.valueOf(l1)));
      ((C2CMessageProcessor)this.i.getMsgHandler().a("c2c_processor")).a((ArrayList)localObject);
      this.G = l1;
    }
  }
  
  public void e(int paramInt)
  {
    this.l.a(paramInt);
  }
  
  public void e(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = f(paramFileManagerEntity);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new ArrayList();
    NFCInfo localNFCInfo = new NFCInfo();
    localNFCInfo.dwServerIP = paramFileManagerEntity.nfcServerIP;
    localNFCInfo.wServerPort = paramFileManagerEntity.nfcServerPort;
    localNFCInfo.vTokenKey = paramFileManagerEntity.nfcTokenKey;
    localNFCInfo.vUrlNotify = paramFileManagerEntity.nfcUrlNotify;
    ((List)localObject).add(localNFCInfo);
    paramFileManagerEntity = new ArrayList();
    paramFileManagerEntity.add(new FTNInfo());
    this.d.RecvGroup((Session[])localArrayList.toArray(new Session[localArrayList.size()]), (NFCInfo[])((List)localObject).toArray(new NFCInfo[((List)localObject).size()]), (FTNInfo[])paramFileManagerEntity.toArray(new FTNInfo[paramFileManagerEntity.size()]), false);
  }
  
  public long f()
  {
    return a(0, this.B).longValue();
  }
  
  public boolean f(int paramInt)
  {
    if (paramInt == 0) {
      return this.s;
    }
    return this.t;
  }
  
  public int g()
  {
    try
    {
      int i1 = this.d.generateGroupID();
      return i1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label10:
      break label10;
    }
    catch (Exception localException) {}
    QLog.e("DataLineHandler", 1, "native genGroupId failed");
    return 0;
    return 0;
  }
  
  public boolean g(int paramInt)
  {
    ArrayList localArrayList = this.w;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      return this.w.contains(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public boolean getAutoDownload()
  {
    return h().getPreferences().getBoolean("auto_receive_files", false);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("MessageSvc.PbSendMsg");
    }
    return this.allowCmdSet;
  }
  
  public long h(int paramInt)
  {
    if (paramInt == 0) {
      return this.u;
    }
    return this.v;
  }
  
  public final QQAppInterface h()
  {
    return this.i;
  }
  
  public void i(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    synchronized (this.x)
    {
      if (!this.x.contains(Integer.valueOf(paramInt)))
      {
        this.x.add(Integer.valueOf(paramInt));
        if (this.x.size() > 256) {
          this.x.remove(0);
        }
      }
      return;
    }
  }
  
  public boolean i()
  {
    return this.i.getPreferences().getBoolean("dl_pc_online_notify", true);
  }
  
  public boolean j()
  {
    return this.i.getPreferences().getBoolean("dl_ipad_online_notify", true);
  }
  
  public boolean j(int paramInt)
  {
    return this.x.contains(Integer.valueOf(paramInt));
  }
  
  public void k(int paramInt)
  {
    a(paramInt, false);
  }
  
  public boolean k()
  {
    int i1 = this.k;
    boolean bool1 = false;
    if (i1 == 0)
    {
      SharedPreferences localSharedPreferences = this.i.getPreferences();
      boolean bool2 = localSharedPreferences.getBoolean("auto_receive_files", false);
      boolean bool3 = localSharedPreferences.getBoolean("auto_receive_files_ipad", false);
      if ((!bool2) && (!bool3)) {
        this.k = 2;
      } else {
        this.k = 1;
      }
    }
    if (this.k == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void l()
  {
    Object localObject = this.i.getDataLineMsgProxy(0).a();
    DataLineMsgSet localDataLineMsgSet;
    if (localObject != null)
    {
      localObject = ((DataLineMsgSetList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject).next();
        if (!localDataLineMsgSet.isSingle()) {
          i(localDataLineMsgSet.getGroupId());
        }
      }
    }
    localObject = this.i.getDataLineMsgProxy(0).a(false);
    if (localObject != null)
    {
      localObject = ((DataLineMsgSetList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject).next();
        if (!localDataLineMsgSet.isSingle()) {
          i(localDataLineMsgSet.getGroupId());
        }
      }
    }
    this.l.c();
  }
  
  public int m()
  {
    return ((ISVIPHandler)this.i.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).d();
  }
  
  public void m(int paramInt)
  {
    this.B = paramInt;
  }
  
  public DirectForwarder n()
  {
    return this.m;
  }
  
  public void o()
  {
    synchronized (this.i)
    {
      this.D += 1;
      if (this.C) {
        n(this.D);
      }
      return;
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return DataLineObserver.class;
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface1 = this.i;
    StringBuilder localStringBuilder;
    if ((localQQAppInterface1 != null) && (localQQAppInterface1.getApp() != null) && (this.q != null))
    {
      try
      {
        this.i.getApp().unregisterReceiver(this.q);
      }
      catch (Exception localException1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy fail unregisterReceiver exitReceiver:");
        localStringBuilder.append(localException1);
        QLog.e("DataLineHandler", 1, localStringBuilder.toString());
      }
      this.q = null;
    }
    QQAppInterface localQQAppInterface2 = this.i;
    if ((localQQAppInterface2 != null) && (localQQAppInterface2.getApp() != null) && (this.p != null))
    {
      try
      {
        this.i.getApp().unregisterReceiver(this.p);
      }
      catch (Exception localException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy fail unregisterReceiver sdCardReceiver:");
        localStringBuilder.append(localException2);
        QLog.e("DataLineHandler", 1, localStringBuilder.toString());
      }
      this.p = null;
    }
    Object localObject = this.i;
    if ((localObject != null) && (((QQAppInterface)localObject).getApp() != null))
    {
      localObject = this.K;
      if (localObject != null)
      {
        this.i.removeObserver((BusinessObserver)localObject);
        this.K = null;
      }
    }
    localObject = this.r;
    if (localObject != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
      this.r = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "--->>close cancel all task");
    }
    k(32);
    localObject = this.i;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((QQAppInterface)localObject).getDataLineMsgProxy(0) != null)
      {
        localObject = this.i.getDataLineMsgProxy(0).a();
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((DataLineMsgSetList)localObject).size() > 0)
          {
            localObject = ((DataLineMsgSetList)localObject).iterator();
            do
            {
              bool1 = bool2;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
            } while (!((DataLineMsgSet)((Iterator)localObject).next()).hasSendingOrRecving());
            bool1 = true;
          }
        }
      }
    }
    localObject = this.i;
    bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((QQAppInterface)localObject).getDataLineMsgProxy(1) != null)
      {
        localObject = this.i.getDataLineMsgProxy(1).a();
        bool2 = bool1;
        if (localObject != null)
        {
          bool2 = bool1;
          if (((DataLineMsgSetList)localObject).size() > 0)
          {
            localObject = ((DataLineMsgSetList)localObject).iterator();
            do
            {
              bool2 = bool1;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
            } while (!((DataLineMsgSet)((Iterator)localObject).next()).hasSendingOrRecving());
            bool2 = true;
          }
        }
      }
    }
    this.d.endLiteTransfer(bool2);
    this.y.a();
    this.l.a();
    this.e.a();
    this.m.a();
    localObject = this.I;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.I = null;
    }
    this.z = true;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.y.a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
        QLog.d("DataLineHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DataLineHandler.5(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public int p()
  {
    synchronized (this.i)
    {
      int i1 = this.D;
      return i1;
    }
  }
  
  public void q()
  {
    synchronized (this.i)
    {
      if (this.D == 0) {
        return;
      }
      this.D = 0;
      n(this.D);
      return;
    }
  }
  
  public int r()
  {
    return this.B;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler
 * JD-Core Version:    0.7.0.1
 */