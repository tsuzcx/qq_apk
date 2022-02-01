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
  private static int jdField_e_of_type_Int;
  private static int f;
  public int a;
  private long jdField_a_of_type_Long = 0L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private DirectForwarder jdField_a_of_type_ComDatalineCoreDirectForwarder = null;
  private MoloHandler jdField_a_of_type_ComDatalineCoreMoloHandler = new MoloHandler(this);
  public PrinterManager a;
  private LoginDevicesManager jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevicesManager;
  protected LiteTransferWrapper a;
  protected ProtocolHelper a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new DataLineHandler.9(this);
  public PrinterHandler a;
  public QQAppInterface a;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
  private DatalineRemoteManager jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager;
  public String a;
  private ArrayList<TextMsgTask> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected HashMap<Long, TextMsgPush> a;
  private List<Long> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private Timer jdField_a_of_type_JavaUtilTimer;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = null;
  private ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Long, Session> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private List<Long> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = -1L;
  private List<Integer> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long = -1L;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean jdField_e_of_type_Boolean;
  private int g;
  private int h;
  
  public DataLineHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = AppConstants.DATALINE_PC_UIN;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper = new LiteTransferWrapper(this, this);
    this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler = null;
    this.jdField_a_of_type_Boolean = false;
    this.e = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler = new PrinterHandler(paramQQAppInterface);
    this.jdField_a_of_type_ComDatalineDataPrinterManager = new PrinterManager(paramQQAppInterface);
    this.jdField_a_of_type_ComDatalineCoreDirectForwarder = new DirectForwarder(paramQQAppInterface);
    this.g = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296826);
    this.h = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296825);
    k();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new DataLineHandler.1(this);
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new DataLineHandler.2(this, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new DataLineHandler.3(this);
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper = new ProtocolHelper(paramQQAppInterface, 0);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqq.intent.action.EXIT_");
    localStringBuilder.append(paramQQAppInterface.getApp().getPackageName());
    localIntentFilter.addAction(localStringBuilder.toString());
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    paramQQAppInterface.getApp().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
    localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addDataScheme("file");
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    a(paramQQAppInterface);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager = new DatalineRemoteManager(paramQQAppInterface);
    h();
    i();
    this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevicesManager = ((LoginDevicesManager)paramQQAppInterface.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER));
    this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevicesManager.a(this);
    this.jdField_d_of_type_Boolean = false;
  }
  
  public static int a(int paramInt)
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
  
  private int a(MsgHeader paramMsgHeader)
  {
    if (paramMsgHeader == null) {
      return 65793;
    }
    int i = paramMsgHeader.uint32_src_ter_type;
    if (i != 2)
    {
      if (i != 3) {
        return 65793;
      }
      return 68361;
    }
    return 67586;
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    int j = 2;
    if (paramFileManagerEntity == null)
    {
      QLog.i("DataLineHandler", 2, "转发文件, FileManagerEntity为空");
      return 255;
    }
    int i;
    StringBuilder localStringBuilder;
    if ((!TextUtils.isEmpty(paramFileManagerEntity.getFilePath())) && (new File(paramFileManagerEntity.getFilePath()).exists()))
    {
      i = 0;
    }
    else
    {
      int k = paramFileManagerEntity.getCloudType();
      if (k != 10) {
        i = j;
      }
      switch (k)
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
        i = 255;
        break;
      case 2: 
        i = 4;
        break;
      case 1: 
        k = paramFileManagerEntity.peerType;
        if (k != 0)
        {
          i = j;
          if (k == 1) {
            break label371;
          }
          if (k == 3000) {
            break label363;
          }
          if (k == 6000) {
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
        i = 1;
        break label371;
        label358:
        i = 5;
        break label371;
        label363:
        i = 3;
        break label371;
        i = 6;
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
      localStringBuilder.append(i);
      localStringBuilder.append("], peerType[");
      localStringBuilder.append(paramFileManagerEntity.peerType);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(paramFileManagerEntity.peerUin);
      localStringBuilder.append("], cloudType[");
      localStringBuilder.append(paramFileManagerEntity.getCloudType());
      QLog.i("DataLineHandler", 4, localStringBuilder.toString());
    }
    return i;
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    int j = FileManagerUtil.a(paramString);
    int i = 2;
    if (j != 0) {
      if (j != 1)
      {
        if (j == 2) {
          return i;
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
    i = 1;
    return i;
  }
  
  private Session a(FileManagerEntity paramFileManagerEntity)
  {
    Session localSession = new Session();
    localSession.uSessionID = paramFileManagerEntity.nSessionId;
    localSession.bSend = paramFileManagerEntity.bSend;
    int i = DataLineMsgRecord.getDevTypeBySeId(paramFileManagerEntity.nSessionId);
    localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), i);
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
  
  private String a(String paramString)
  {
    int i = paramString.lastIndexOf(".");
    String str2;
    String str1;
    if (i >= 0)
    {
      str2 = paramString.substring(0, i);
      str1 = paramString.substring(i);
    }
    else
    {
      str1 = "";
      str2 = paramString;
    }
    VFSFile localVFSFile = new VFSFile(paramString);
    i = 1;
    int j;
    for (;;)
    {
      if (i > 512)
      {
        paramString = new StringBuilder();
        paramString.append(str2);
        paramString.append("(");
        paramString.append(System.currentTimeMillis());
        paramString.append(")");
        paramString.append(str1);
        return paramString.toString();
      }
      j = i;
      if (!localVFSFile.exists()) {
        break;
      }
      paramString = new StringBuilder();
      paramString.append(str2);
      paramString.append("(");
      paramString.append(i);
      paramString.append(")");
      paramString.append(str1);
      paramString = paramString.toString();
      localVFSFile = new VFSFile(paramString);
      i += 1;
    }
    for (;;)
    {
      if (j > 512)
      {
        paramString = new StringBuilder();
        paramString.append(str2);
        paramString.append("(");
        paramString.append(System.currentTimeMillis());
        paramString.append(")");
        paramString.append(str1);
        return paramString.toString();
      }
      if (!c(paramString)) {
        break;
      }
      paramString = new StringBuilder();
      paramString.append(str2);
      paramString.append("(");
      paramString.append(j);
      paramString.append(")");
      paramString.append(str1);
      paramString = paramString.toString();
      j += 1;
    }
    return paramString;
  }
  
  private msg_svc.PbSendMsgReq a(int paramInt1, String paramString, TransMsgContext paramTransMsgContext, long paramLong1, int paramInt2, long paramLong2)
  {
    return MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramString, paramTransMsgContext, paramLong1, paramInt2);
  }
  
  private msg_svc.PbSendMsgReq a(String paramString, int paramInt1, byte[] paramArrayOfByte, long paramLong, int paramInt2)
  {
    long l1 = FileManagerUtil.b();
    long l2 = FileManagerUtil.a();
    TransMsgContext localTransMsgContext = new TransMsgContext();
    localTransMsgContext.jdField_a_of_type_Int = paramInt1;
    localTransMsgContext.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
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
    paramArrayOfByte.uint32_instid.set(AppSetting.a());
    paramArrayOfByte.enum_device_type.set(2);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.msg_from_inst = paramArrayOfByte;
    paramString.routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    return paramString;
  }
  
  private void a(int paramInt, long paramLong, String paramString)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(paramLong);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(localDataLineMsgRecord.msgId, localDataLineMsgRecord.serverPath, localDataLineMsgRecord.md5);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(localDataLineMsgRecord.msgId, localDataLineMsgRecord.serverPath, localDataLineMsgRecord.md5);
      }
    }
  }
  
  private void a(int paramInt1, FTNNotify paramFTNNotify, long paramLong, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFTNNotify(paramFTNNotify, paramLong, this.jdField_a_of_type_JavaLangString, paramInt2);
    a(paramInt1, 1004, localMsgBody, paramFTNNotify.uint64_sessionid);
  }
  
  private void a(int paramInt1, FileControl paramFileControl, long paramLong, int paramInt2)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      return;
    }
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFileControl(paramFileControl, paramLong, this.jdField_a_of_type_JavaLangString, paramInt2);
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
    long l = paramMsgCSBody0x211_0x7.msgHeader.uint64_dst_uin;
    int i = paramMsgCSBody0x211_0x7.uMsgSubCmd;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          switch (i)
          {
          default: 
            break;
          case 10: 
            i = 0;
            while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb.length)
            {
              paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[i].bytes_originfile_md5 = null;
              a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[i], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
              i += 1;
            }
          case 9: 
            i = 0;
            while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb.length)
            {
              paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[i].bytes_originfile_md5 = null;
              a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[i], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
              i += 1;
            }
          case 8: 
            i = 0;
            while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x8_RFCInfoNotiy.length)
            {
              a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x8_RFCInfoNotiy[i], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
              i += 1;
            }
          }
          QLog.d("DataLineHandler", 1, "SendPbMsg: cannot recognize the pb msg form 0X211_0x7");
          return;
        }
        i = 0;
        while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl.length)
        {
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl[i], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          i += 1;
        }
      }
      i = 0;
      while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc.length)
      {
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc[i], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
        i += 1;
      }
    }
    i = 0;
    while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc.length)
    {
      a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc[i], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
      i += 1;
    }
  }
  
  private void a(int paramInt1, NFCNotify paramNFCNotify, long paramLong, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromNFCNotify(paramNFCNotify, paramLong, this.jdField_a_of_type_JavaLangString, paramInt2);
    a(paramInt1, 1003, localMsgBody, paramNFCNotify.uint64_sessionid);
  }
  
  private void a(int paramInt1, RFCInfoNotify paramRFCInfoNotify, long paramLong, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgBodyFromRFCInfoNotify(paramRFCInfoNotify, paramLong, this.jdField_a_of_type_JavaLangString, paramInt2);
    a(paramInt1, 1008, localMsgBody, paramRFCInfoNotify.uSessionId);
  }
  
  private void a(int paramInt1, DataLineMsgRecord paramDataLineMsgRecord, int paramInt2)
  {
    paramDataLineMsgRecord.bIsTransfering = false;
    c(paramDataLineMsgRecord.path);
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
        e(paramDataLineMsgRecord);
        if (!TextUtils.isEmpty(paramDataLineMsgRecord.thumbPath)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).a(paramDataLineMsgRecord.msgId, paramDataLineMsgRecord.thumbPath);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).d(paramDataLineMsgRecord.msgId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).c();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).b(paramDataLineMsgRecord.msgId);
        if ((paramDataLineMsgRecord.nSessionState == 2) && (com.tencent.mobileqq.filemanager.util.FileUtil.b(paramDataLineMsgRecord.path))) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).b(paramDataLineMsgRecord.msgId, paramDataLineMsgRecord.path);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006223", "0X8006223", 0, 0, "", "", "", "");
      }
      else if ((paramInt2 != 32) && (paramInt2 != 11) && (paramInt2 != 8))
      {
        paramDataLineMsgRecord.fileMsgStatus = 0L;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).d(paramDataLineMsgRecord.msgId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).c(paramDataLineMsgRecord.msgId);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006224", "0X8006224", 0, 0, "", "", "", "");
      }
      else
      {
        paramDataLineMsgRecord.fileMsgStatus = 2L;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).d(paramDataLineMsgRecord.msgId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).c(paramDataLineMsgRecord.msgId);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006224", "0X8006224", 0, 0, "", "", "", "");
      }
    }
    else
    {
      Object localObject;
      if (paramInt2 == 2)
      {
        paramDataLineMsgRecord.fileMsgStatus = 0L;
        e(paramDataLineMsgRecord);
        if (!TextUtils.isEmpty(paramDataLineMsgRecord.thumbPath)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).a(paramDataLineMsgRecord.msgId, paramDataLineMsgRecord.thumbPath);
        }
        localObject = FilePathUtil.c(paramDataLineMsgRecord.path);
        if (localObject != null)
        {
          FileUtils.deleteFile(paramDataLineMsgRecord.path);
          paramDataLineMsgRecord.path = ((String)localObject);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).b(paramDataLineMsgRecord.msgId, (String)localObject);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).d(paramDataLineMsgRecord.msgId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).b(paramDataLineMsgRecord.msgId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).c();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006226", "0X8006226", 0, 0, "", "", "", "");
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).d(paramDataLineMsgRecord.msgId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).c(paramDataLineMsgRecord.msgId);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006227", "0X8006227", 0, 0, "", "", "", "");
      }
      else
      {
        paramDataLineMsgRecord.fileMsgStatus = 2L;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).d(paramDataLineMsgRecord.msgId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).c(paramDataLineMsgRecord.msgId);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006227", "0X8006227", 0, 0, "", "", "", "");
      }
    }
    paramDataLineMsgRecord.nSessionState = 1;
  }
  
  private void a(int paramInt, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.RNFCNotify> paramList)
  {
    paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromRFCInfoNotify(paramInt, paramMsgHeader, paramList);
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
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
      paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromFTNNotify(paramInt, paramMsgHeader, localArrayList, paramBoolean);
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
    }
  }
  
  private void a(long paramLong, int paramInt)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(paramLong);
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
            ((DataLineMessageSpreadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER_DATALINE)).a(localDataLineMsgRecord, i);
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
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    float f1;
    if (paramLong3 == 0L) {
      f1 = 0.0F;
    } else {
      f1 = (float)paramLong2 / (float)paramLong3;
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong1);
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(paramLong1);
    if (localDataLineMsgRecord != null) {
      localDataLineMsgRecord.progress = f1;
    }
    a(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong1), Float.valueOf(f1) });
  }
  
  private void a(Session paramSession)
  {
    String str = paramSession.strFilePathSrc;
    if ((paramSession.dwGroupID == 0) && (paramSession.bSend) && (paramSession.emFileType == 1) && (str != null) && (new File(str).exists())) {
      URLDrawable.getDrawable(AsyncImageView.a(str, this.g, this.h, true), null, null, false).downloadImediatly();
    }
  }
  
  private void a(Session paramSession, NFCInfo paramNFCInfo)
  {
    FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramSession.uSessionID);
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
      localFileManagerEntity1.msgSeq = FileManagerUtil.a();
      localFileManagerEntity1.peerUin = QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localFileManagerEntity1.peerType = 0;
      localFileManagerEntity1.bDelInFM = true;
      localFileManagerEntity1.bSend = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity1);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().c(localFileManagerEntity1);
  }
  
  private void a(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, WeiYunFileInfo paramWeiYunFileInfo)
  {
    long l = paramDataLineMsgRecord.sessionid;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(paramWeiYunFileInfo, new DataLineHandler.17(this, l));
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), DataLineServlet.class);
    localNewIntent.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    long l = System.currentTimeMillis();
    paramToServiceMsg.extraData.putLong("datalineSendTimekey", l);
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
    //   8: new 1218	java/io/BufferedWriter
    //   11: dup
    //   12: new 1220	java/io/OutputStreamWriter
    //   15: dup
    //   16: new 1222	java/io/FileOutputStream
    //   19: dup
    //   20: aload_2
    //   21: iconst_0
    //   22: invokespecial 1225	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   25: invokespecial 1228	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   28: invokespecial 1231	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   31: astore_2
    //   32: aload_2
    //   33: aload_1
    //   34: invokevirtual 1234	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   37: aload_2
    //   38: invokevirtual 1237	java/io/BufferedWriter:close	()V
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
    //   74: ldc_w 300
    //   77: iconst_1
    //   78: ldc_w 1239
    //   81: invokestatic 341	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: aload_1
    //   85: astore_3
    //   86: aload_2
    //   87: invokevirtual 1242	java/io/IOException:printStackTrace	()V
    //   90: aload_1
    //   91: ifnull +44 -> 135
    //   94: aload_1
    //   95: invokevirtual 1237	java/io/BufferedWriter:close	()V
    //   98: return
    //   99: astore_2
    //   100: aload 5
    //   102: astore_1
    //   103: aload_1
    //   104: astore_3
    //   105: ldc_w 300
    //   108: iconst_1
    //   109: ldc_w 1244
    //   112: invokestatic 341	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_1
    //   116: astore_3
    //   117: aload_2
    //   118: invokevirtual 1245	java/io/FileNotFoundException:printStackTrace	()V
    //   121: aload_1
    //   122: ifnull +13 -> 135
    //   125: aload_1
    //   126: invokevirtual 1237	java/io/BufferedWriter:close	()V
    //   129: return
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 1242	java/io/IOException:printStackTrace	()V
    //   135: return
    //   136: aload_3
    //   137: ifnull +15 -> 152
    //   140: aload_3
    //   141: invokevirtual 1237	java/io/BufferedWriter:close	()V
    //   144: goto +8 -> 152
    //   147: astore_2
    //   148: aload_2
    //   149: invokevirtual 1242	java/io/IOException:printStackTrace	()V
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
    paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromFileControl(paramMsgHeader, paramList);
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
  }
  
  public static void a(SubMsgType0x7.MsgBody paramMsgBody, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    if (!QFileAssistantUtils.a())
    {
      QLog.i("DataLineHandler", 1, "isNot new FileAssistant");
      return;
    }
    int i;
    if (paramMsgBody.uint32_sub_cmd.has()) {
      i = paramMsgBody.uint32_sub_cmd.get();
    } else {
      i = -1;
    }
    if ((i == 1) || ((i == 4) && (((SubMsgType0x7.MsgBody.GenericSubCmd)paramMsgBody.msg_subcmd_0x4_generic.get()).uint32_type.has()) && (((SubMsgType0x7.MsgBody.GenericSubCmd)paramMsgBody.msg_subcmd_0x4_generic.get()).uint32_type.get() == 1)) || (i == 9)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
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
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return d(a(paramFileManagerEntity));
  }
  
  private boolean a(TextMsgTask paramTextMsgTask)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int m = paramTextMsgTask.a(localStringBuffer);
    int j = 0;
    int i = 0;
    if (m == -1) {
      return false;
    }
    int k = this.jdField_a_of_type_Int;
    int n;
    if (k == 0) {
      while (i < localStringBuffer.length())
      {
        j = i;
        if (localStringBuffer.charAt(i) == '\024')
        {
          j = i;
          if (i < localStringBuffer.length() - 1)
          {
            k = i + 1;
            n = QQSysFaceUtil.convertToServer(localStringBuffer.charAt(k));
            j = i;
            if (n >= 0)
            {
              localStringBuffer.setCharAt(k, (char)n);
              j = k;
            }
          }
        }
        i = j + 1;
      }
    }
    if (k == 1) {
      for (i = j; i < localStringBuffer.length(); i = k + 1)
      {
        k = i;
        if (localStringBuffer.charAt(i) == '\024')
        {
          k = i;
          if (i < localStringBuffer.length() - 1)
          {
            n = i + 1;
            k = localStringBuffer.charAt(n);
            j = k;
            if (k == 250) {
              j = 10;
            }
            k = i;
            if (j >= 0)
            {
              k = i;
              if (j < EmotcationConstants.SYS_EMOTICON_SYMBOL.length)
              {
                String str = EmotcationConstants.SYS_EMOTICON_SYMBOL[j];
                try
                {
                  localStringBuffer.replace(n, i + 2, str);
                }
                catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
                {
                  localStringIndexOutOfBoundsException.printStackTrace();
                  QLog.d("DataLineHandler", 2, "SendSubText ipad emoj fail", localStringIndexOutOfBoundsException);
                }
                k = i + str.length();
              }
            }
          }
        }
      }
    }
    paramTextMsgTask.a(a(paramTextMsgTask.a().longValue(), 1001, paramTextMsgTask.a(), m, localStringBuffer.toString().getBytes()));
    return true;
  }
  
  public static int b(int paramInt)
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
  
  private String b(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if (bool) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    Object localObject = paramString;
    if (i >= 0)
    {
      localObject = paramString.substring(0, i);
      str = paramString.substring(i);
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
      paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromNFCNotify(paramInt, paramMsgHeader, localArrayList, paramBoolean);
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
    }
  }
  
  private void b(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString)))
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addRecvingFilePath[");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" size:");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilSet.size());
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
  
  private void b(ArrayList<Session> paramArrayList, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.showNoNetworkDialog();
      return;
    }
    if (paramArrayList.size() == 0) {
      return;
    }
    LiteTransferWrapper localLiteTransferWrapper = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
    int i = paramArrayList.size();
    boolean bool = true;
    if (i == 1) {
      bool = false;
    }
    localLiteTransferWrapper.SendGroup(paramArrayList, paramBoolean, bool);
  }
  
  private void c(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord != null)
    {
      if (!TextUtils.isEmpty(paramDataLineMsgRecord.path)) {
        return;
      }
      String str2 = b(paramDataLineMsgRecord.filename);
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        long l = System.currentTimeMillis();
        str1 = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(l));
      }
      str2 = FMSettings.a().getDefaultRecvPath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append(str1);
      str2 = localStringBuilder.toString();
      str1 = str2;
      if (FileUtils.fileExists(str2)) {
        str1 = a(str2);
      }
      paramDataLineMsgRecord.path = str1;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l = ((Long)paramToServiceMsg.getAttribute("cookie")).longValue();
    int j = DataLineMsgRecord.getDevTypeBySeId(l);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(j).a(l);
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
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      i = 2;
    } else {
      i = 36;
    }
    a(j, paramToServiceMsg, i);
    new Handler(Looper.getMainLooper()).post(new DataLineHandler.8(this, l, i));
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
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(localLong.intValue(), paramObject);
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void c(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString)))
      {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("remRecvingFilePath[");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" size:");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilSet.size());
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
  
  private void c(List<SubMsgType0x7.MsgBody.MoloNotify> paramList)
  {
    Object localObject1 = paramList.iterator();
    for (;;)
    {
      int j;
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
        paramList = this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(((SubMsgType0x7.MsgBody.MoloNotify)localObject2).bytes_buf.get().toByteArray());
        if (paramList == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DataLineHandler", 2, "应用宝消息 moloHandler dealWith return null");
          continue;
        }
        int i;
        if (((SubMsgType0x7.MsgBody.MoloNotify)localObject2).uint32_group_id.has()) {
          i = ((SubMsgType0x7.MsgBody.MoloNotify)localObject2).uint32_group_id.get();
        } else {
          i = 0;
        }
        paramList.groupId = i;
        if (((SubMsgType0x7.MsgBody.MoloNotify)localObject2).uint32_group_size.has()) {
          i = ((SubMsgType0x7.MsgBody.MoloNotify)localObject2).uint32_group_size.get();
        } else {
          i = 0;
        }
        paramList.groupSize = i;
        if (((SubMsgType0x7.MsgBody.MoloNotify)localObject2).uint32_group_curindex.has()) {
          i = ((SubMsgType0x7.MsgBody.MoloNotify)localObject2).uint32_group_curindex.get();
        } else {
          i = 0;
        }
        paramList.groupIndex = i;
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
        if ((!DataLineMsgSet.isSingle(paramList)) && (c(paramList.groupId)))
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
        j = DataLineMsgRecord.getDevTypeBySeId(paramList.sessionid);
        a().getMessageFacade().a(j).a(paramList, true);
        if ((!DataLineMsgSet.isSingle(paramList)) && (c(paramList.groupId)))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("应用宝消息 msg record in deleted group 2, sessionid[");
            ((StringBuilder)localObject1).append(paramList.sessionid);
            QLog.d("DataLineHandler", 2, ((StringBuilder)localObject1).toString());
          }
          paramList = a().getDataLineMsgProxy(j).a(paramList.sessionid);
          if (paramList != null) {
            a(paramList);
          }
          return;
        }
        if (DataLineMsgSet.isSingle(paramList))
        {
          DataLineReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          j();
        }
        else
        {
          localObject2 = a().getDataLineMsgProxy(j).a(paramList.groupId);
          if ((localObject2 == null) || (((DataLineMsgSet)localObject2).getComeCount() == 1))
          {
            DataLineReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            j();
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
            i = 1;
          } else {
            i = 0;
          }
          if ((!bool) && ((!getAutoDownload()) || (i == 0))) {
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
        b(111);
        this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(paramList.strMoloKey);
        DataLineReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        label701:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(j).d(paramList.msgId);
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
  
  private boolean c(String paramString)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilSet.contains(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void d(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord.fileMsgStatus = 0L;
    int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).d(paramDataLineMsgRecord.msgId);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).c(paramDataLineMsgRecord.msgId);
    a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramDataLineMsgRecord.sessionid), paramDataLineMsgRecord.path });
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((TextMsgTask)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a().equals(paramToServiceMsg))
      {
        paramToServiceMsg = (TextMsgTask)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        break label64;
      }
      i += 1;
    }
    paramToServiceMsg = null;
    label64:
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.a().progress = 1.0F;
    i = DataLineMsgRecord.getDevTypeBySeId(paramToServiceMsg.a().longValue());
    if (!paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg.a().issuc = false;
      a(1, false, new Object[] { paramToServiceMsg.a(), paramToServiceMsg.a() });
      return;
    }
    if (paramToServiceMsg.a())
    {
      paramToServiceMsg.a().issuc = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).b(paramToServiceMsg.a().msgId);
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramToServiceMsg);
      a(1, true, new Object[] { paramToServiceMsg.a(), paramToServiceMsg.a() });
      return;
    }
    if (!a(paramToServiceMsg))
    {
      paramToServiceMsg.a().issuc = false;
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramToServiceMsg);
      a(1, false, new Object[] { paramToServiceMsg.a(), paramToServiceMsg.a() });
    }
  }
  
  public static boolean d(int paramInt)
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
  
  private void e(DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str = paramDataLineMsgRecord.path;
    if (FileManagerUtil.a(str) != 0) {
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
  
  private void f(int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new DataLineHandler.19(this, paramInt));
  }
  
  private void f(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if ((paramDataLineMsgRecord != null) && (!paramDataLineMsgRecord.isSendFromLocal()) && (DataLineMsgSet.isSingle(paramDataLineMsgRecord)) && (paramDataLineMsgRecord.msgtype == -2000) && (paramDataLineMsgRecord.path != null) && (new File(paramDataLineMsgRecord.path).exists())) {
      URLDrawable.getDrawable(AsyncImageView.a(paramDataLineMsgRecord.path, this.g, this.h, true), null, null, false).downloadImediatly();
    }
  }
  
  private void h()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject).append("_PC_STATE");
    localObject = ((StringBuilder)localObject).toString();
    if (localSharedPreferences.contains((String)localObject))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Long = localSharedPreferences.getLong((String)localObject, 0L);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void i()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject).append("_IPAD_STATE");
    localObject = ((StringBuilder)localObject).toString();
    if (localSharedPreferences.contains((String)localObject))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_Long = localSharedPreferences.getLong((String)localObject, 0L);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void j()
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean == true) {
      bool = false;
    } else {
      bool = true;
    }
    a().handleReceivedMessage(1, bool, false);
  }
  
  private void k()
  {
    ThreadManager.getFileThreadHandler().post(new DataLineHandler.18(this));
  }
  
  public void GetThumbFilePath(int paramInt, Session paramSession)
  {
    QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePath ");
    Object localObject = (RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    if ((localObject != null) && (((RegisterProxySvcPackHandler)localObject).a() == 0))
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
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnGetThumbFilePathReply(paramInt, (String)localObject);
      return;
    }
    QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 777 MinSize_for_CreateThumb e ");
    localFile.delete();
  }
  
  public void HandleSession(int paramInt1, long paramLong, int paramInt2, MsgHeader paramMsgHeader) {}
  
  public void InvokeReport(ReportItem paramReportItem)
  {
    QualityReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramReportItem, QualityReportUtil.jdField_b_of_type_Int);
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
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(0).a(paramInt1);
    Object localObject = localDataLineMsgSet;
    if (localDataLineMsgSet == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(1).a(paramInt1);
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
      boolean bool4 = QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
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
    Object localObject = (Session)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((paramInt1 == 2) && (localObject != null)) {
      this.jdField_b_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (localObject == null)
    {
      localObject = Looper.getMainLooper();
      DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(paramLong);
      if (localDataLineMsgRecord == null)
      {
        if (Thread.currentThread() != ((Looper)localObject).getThread()) {
          new Handler((Looper)localObject).post(new DataLineHandler.14(this, paramLong, paramInt1, paramInt2));
        }
        return;
      }
      if (paramInt1 == 2) {
        f(localDataLineMsgRecord);
      }
      a(i, localDataLineMsgRecord, paramInt1);
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new DataLineHandler.15(this, paramLong, paramInt1));
        return;
      }
      a(paramLong, paramInt1);
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
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramSession.uSessionID), paramSession);
      a(17, true, paramSession);
      return;
    }
    if (paramSession.bSend) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006222", "0X8006222", 0, 0, "", "", "", "");
    } else {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006225", "0X8006225", 0, 0, "", "", "", "");
    }
    if ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.length() != 0))
    {
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramSession.uSessionID), paramSession);
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
    Object localObject = (Session)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
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
    Object localObject = (Session)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
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
    int i = paramMsgCSBody.uMsgType;
    if (i != 529)
    {
      if (i != 837)
      {
        if (i != 838)
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
  
  public int a()
  {
    try
    {
      int i = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateGroupID();
      return i;
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
  
  public int a(String paramString)
  {
    if (paramString == null) {
      return 1;
    }
    return this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(paramString);
  }
  
  public long a()
  {
    return a(0, this.jdField_c_of_type_Int).longValue();
  }
  
  public long a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_Long;
    }
    return this.jdField_b_of_type_Long;
  }
  
  public long a(FileManagerEntity paramFileManagerEntity)
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
  
  public long a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    return a(paramString1, paramString2, null, paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramBoolean);
  }
  
  public long a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, paramString1, paramString2, paramString3, paramInt1, 0, paramLong, paramInt2, paramInt3, paramInt4);
    if (paramString1 == null) {
      return 0L;
    }
    localArrayList.add(paramString1);
    if (0L == paramLong) {
      paramString1.uSessionID = a(0, this.jdField_a_of_type_Int).longValue();
    }
    paramString1.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), this.jdField_a_of_type_Int);
    b(localArrayList, paramBoolean);
    return paramString1.uSessionID;
  }
  
  public DirectForwarder a()
  {
    return this.jdField_a_of_type_ComDatalineCoreDirectForwarder;
  }
  
  public Session a(long paramLong)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = a().getMessageFacade().a(i).a(paramLong);
    if (localDataLineMsgRecord == null) {
      return null;
    }
    Session localSession = new Session();
    localSession.uSessionID = localDataLineMsgRecord.sessionid;
    i = localDataLineMsgRecord.issend;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localSession.bSend = bool;
    i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
    localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), i);
    localSession.dwGroupID = localDataLineMsgRecord.groupId;
    localSession.dwGroupSize = localDataLineMsgRecord.groupSize;
    localSession.dwGroupIndex = localDataLineMsgRecord.groupIndex;
    localSession.emFileType = b(localDataLineMsgRecord.msgtype);
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
    int i;
    if (paramFileManagerEntity.nFileType == 0) {
      i = 1;
    } else if (paramFileManagerEntity.nFileType == 2) {
      i = 2;
    } else {
      i = 0;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramFileManagerEntity.fileName;
    localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.strMiddleThumPath, (String)localObject, i, 1, paramFileManagerEntity.nSessionId, paramFileManagerEntity.dlGroupId, paramFileManagerEntity.dlGroupCount, paramFileManagerEntity.dlGourpIndex);
    if (localObject == null) {
      return null;
    }
    ((Session)localObject).uChannelType = 1;
    ((Session)localObject).isFileAssist = true;
    localArrayList.add(localObject);
    if (((Session)localObject).uSessionID == 0L)
    {
      long l = a(0).longValue();
      ((Session)localObject).uSessionID = l;
      paramFileManagerEntity.nSessionId = l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWlanSend[");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    localStringBuilder.append("],Send fro Wlan target:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    QLog.i("FileAssistantSender<FileAssistant>", 1, localStringBuilder.toString());
    ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), this.jdField_c_of_type_Int);
    b(localArrayList, paramBoolean);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((Session)localObject).uSessionID), localObject);
    return localObject;
  }
  
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public ToServiceMsg a(int paramInt, SubMsgType0x7.MsgBody paramMsgBody, long paramLong)
  {
    int i = paramMsgBody.msg_header.uint32_dst_ter_type.get();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    byte[] arrayOfByte = paramMsgBody.toByteArray();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send0x211C2CDatalineMsg DataLineMsgRecord:");
      localStringBuilder.append(paramLong);
      QLog.d("DataLineHandler", 2, localStringBuilder.toString());
    }
    localObject = a((String)localObject, 7, arrayOfByte, paramLong, i);
    a(paramMsgBody, (msg_svc.PbSendMsgReq)localObject);
    return a(false, paramInt, paramLong, (msg_svc.PbSendMsgReq)localObject);
  }
  
  public ToServiceMsg a(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(4);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillMsgHeader(localMsgBody.msg_header, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), i);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int i = paramMsgBody.msg_header.uint32_dst_ter_type.get();
    byte[] arrayOfByte = paramMsgBody.toByteArray();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send0x211C2CDatalineMsg DataLineMsgRecord:");
      localStringBuilder.append(paramLong2);
      QLog.d("DataLineHandler", 2, localStringBuilder.toString());
    }
    localObject = a((String)localObject, 7, arrayOfByte, paramLong2, i);
    a(paramMsgBody, (msg_svc.PbSendMsgReq)localObject);
    return a(true, paramInt, paramLong1, (msg_svc.PbSendMsgReq)localObject);
  }
  
  public ToServiceMsg a(long paramLong, MsgCSBody0x345 paramMsgCSBody0x345)
  {
    cmd0x345.ReqBody localReqBody = new cmd0x345.ReqBody();
    localReqBody.uint32_sub_cmd.set(paramMsgCSBody0x345.uMsgSubType);
    int i = paramMsgCSBody0x345.uMsgSubType;
    byte[] arrayOfByte = null;
    Object localObject;
    if (i != 7)
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
    int i = f;
    f = i + 1;
    ((PBUInt32Field)localObject1).set(i);
    boolean bool = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.FillReqBody(paramMsgCSBody0x346, localReqBody);
    Object localObject2 = null;
    if (!bool) {
      return null;
    }
    i = paramMsgCSBody0x346.uMsgSubType;
    if (i != 1200)
    {
      if (i != 1400)
      {
        if (i != 1600)
        {
          if (i != 1700)
          {
            if (i != 1800)
            {
              if (i == 60100) {
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
    ((cmd0x346.ApplyDownloadReq)localObject2).uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    ((cmd0x346.ApplyDownloadReq)localObject2).bytes_uuid.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.serverPath.getBytes()));
    ((cmd0x346.ApplyDownloadReq)localObject2).uint32_owner_type.set(2);
    ((cmd0x346.ReqBody)localObject1).msg_apply_download_req.set((MessageMicro)localObject2);
    ((cmd0x346.ReqBody)localObject1).uint32_business_id.set(38);
    ((cmd0x346.ReqBody)localObject1).uint32_client_type.set(104);
    paramDataLineMsgRecord = ((cmd0x346.ReqBody)localObject1).uint32_seq;
    int i = f;
    f = i + 1;
    paramDataLineMsgRecord.set(i);
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
    return this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager;
  }
  
  public Long a(int paramInt)
  {
    return Long.valueOf(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(paramInt));
  }
  
  public Long a(int paramInt1, int paramInt2)
  {
    try
    {
      long l = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionIDByDev(paramInt1, paramInt2);
      return Long.valueOf(l);
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
    int i = paramString.length();
    Long localLong1 = Long.valueOf(0L);
    if (i == 0) {
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
    ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localDataLineMsgRecord);
    localDataLineMsgRecord.time = MessageCache.a();
    localDataLineMsgRecord.sessionid = localLong2.longValue();
    localDataLineMsgRecord.progress = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt).a(localDataLineMsgRecord, false);
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      return localLong1;
    }
    localDataLineMsgRecord.issuc = true;
    paramString = new TextMsgTask(paramString, localLong2, localDataLineMsgRecord);
    if (!a(paramString)) {
      return localLong1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    return localLong2;
  }
  
  public SubMsgType0x7.MsgBody a(DataLineMsgRecord paramDataLineMsgRecord, long paramLong)
  {
    String str = paramDataLineMsgRecord.filename;
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(1);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
    ProtocolHelper.fillMsgHeader(localMsgBody.msg_header, paramLong, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), i);
    SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = new SubMsgType0x7.MsgBody.FTNNotify();
    localFTNNotify.uint64_sessionid.set(paramDataLineMsgRecord.sessionid);
    localFTNNotify.str_file_name.set(str);
    localFTNNotify.str_file_index.set(paramDataLineMsgRecord.serverPath);
    localFTNNotify.bytes_file_md5.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.md5));
    localFTNNotify.uint64_file_len.set(paramDataLineMsgRecord.filesize);
    localFTNNotify.bytes_originfile_md5.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.md5));
    localFTNNotify.uint32_originfiletype.set(b(paramDataLineMsgRecord.msgtype));
    localFTNNotify.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0x1_ftn_notify.add(localFTNNotify);
    localMsgBody.setHasFlag(true);
    return localMsgBody;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "--->>logout cancel all task");
    }
    this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevicesManager.b(this);
    d(32);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.b(paramInt);
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
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(paramInt, paramLong, 32, paramBoolean);
      return;
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    Object localObject = a().getMessageFacade().a(i).a(paramLong);
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(paramInt, paramLong, 32, paramBoolean);
      return;
    }
    ((DataLineMsgRecord)localObject).fileMsgStatus = 2L;
    ((DataLineMsgRecord)localObject).bIsTransfering = false;
    c(((DataLineMsgRecord)localObject).path);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).d(((DataLineMsgRecord)localObject).msgId);
    if (((DataLineMsgRecord)localObject).strMoloKey != null)
    {
      this.jdField_a_of_type_ComDatalineCoreMoloHandler.c(((DataLineMsgRecord)localObject).strMoloKey);
      return;
    }
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(((DataLineMsgRecord)localObject).groupId, paramLong, 32, paramBoolean);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelAll(paramInt, paramBoolean);
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.a();
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (((paramInt == 3) || (paramInt == 2) || (paramInt == 1) || (paramInt == 8)) && (!this.jdField_d_of_type_Boolean)) {
      try
      {
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
        this.jdField_a_of_type_JavaUtilTimer.schedule(new DataLineHandler.4(this), 20000L);
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
        i = paramGenericSubCmd.uint32_type.get();
        if (i != 1)
        {
          if (i != 7) {
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
        i = 0;
        long l2 = paramGenericSubCmd.uint64_sessionid.get();
        long l1 = l2;
        if (i == 1) {
          l1 = l2 | 0x0;
        }
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(l1)))
        {
          paramMsgHeader = new TextMsgPush(Long.valueOf(paramGenericSubCmd.uint32_size.get()), Long.valueOf(l1));
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l1), paramMsgHeader);
        }
        else
        {
          paramMsgHeader = (TextMsgPush)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l1));
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
          this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(l1));
          localObject2 = new DataLineMsgRecord();
          ((DataLineMsgRecord)localObject2).msgId = l1;
          ((DataLineMsgRecord)localObject2).sessionid = l1;
          if (i == 1)
          {
            paramGenericSubCmd = paramMsgHeader.a();
            i = 0;
            if (i < EmotcationConstants.SYS_EMOTICON_SYMBOL.length)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append('\024');
              ((StringBuilder)localObject3).append(EmotcationConstants.SYS_EMOTICON_SYMBOL[i]);
              localObject1 = paramGenericSubCmd;
              if (paramGenericSubCmd.indexOf(((StringBuilder)localObject3).toString()) == -1) {
                break label729;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append('\024');
              ((StringBuilder)localObject1).append(EmotcationConstants.SYS_EMOTICON_SYMBOL[i]);
              localObject1 = ((StringBuilder)localObject1).toString();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("\024");
              ((StringBuilder)localObject3).append((char)i);
              localObject1 = paramGenericSubCmd.replace((CharSequence)localObject1, ((StringBuilder)localObject3).toString());
              break label729;
            }
            ((DataLineMsgRecord)localObject2).msg = paramGenericSubCmd;
          }
          else
          {
            ((DataLineMsgRecord)localObject2).msg = paramMsgHeader.a();
          }
          ((DataLineMsgRecord)localObject2).msgtype = -1000;
          ((DataLineMsgRecord)localObject2).issend = 0;
          ((DataLineMsgRecord)localObject2).isread = false;
          ((DataLineMsgRecord)localObject2).time = paramLong1;
          ((DataLineMsgRecord)localObject2).issuc = true;
          ((DataLineMsgRecord)localObject2).sessionid = ((DataLineMsgRecord)localObject2).msgId;
          ((DataLineMsgRecord)localObject2).shmsgseq = paramLong2;
          i = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject2).sessionid);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a((DataLineMsgRecord)localObject2, true);
          j();
          a(8, true, new Object[] { Integer.valueOf((int)paramLong1), paramMsgHeader.a(), Long.valueOf(((DataLineMsgRecord)localObject2).sessionid) });
          return;
        }
      }
      catch (Exception paramGenericSubCmd)
      {
        paramGenericSubCmd.printStackTrace();
      }
      return;
      label723:
      int i = 1;
      continue;
      label729:
      i += 1;
      paramGenericSubCmd = (SubMsgType0x7.MsgBody.GenericSubCmd)localObject1;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    a(1004, a(paramDataLineMsgRecord, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue()), paramDataLineMsgRecord.sessionid);
    long l = paramDataLineMsgRecord.sessionid;
    double d1 = paramDataLineMsgRecord.filesize;
    Double.isNaN(d1);
    OnSessionProgress(l, (d1 * 0.8D), paramDataLineMsgRecord.filesize, 0);
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    if (paramDataLineMsgRecord == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Session localSession = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(paramDataLineMsgRecord);
    if (localSession == null) {
      return;
    }
    if (0L == paramDataLineMsgRecord.sessionid) {
      localSession.uSessionID = a(0, this.jdField_a_of_type_Int).longValue();
    }
    localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), this.jdField_a_of_type_Int);
    localArrayList.add(localSession);
    b(localArrayList, paramBoolean);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.e("DatalineHandler", 1, "sendWeiYunFile weiyunEntity=null");
      return;
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localDataLineMsgRecord.filename = paramFileManagerEntity.fileName;
    if (paramFileManagerEntity.strThumbPath != null)
    {
      localDataLineMsgRecord.thumbPath = com.tencent.mobileqq.filemanager.util.FileUtil.a(com.tencent.mobileqq.filemanager.util.FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()), FileManagerUtil.a(paramFileManagerEntity.strThumbPath));
      FileUtils.copyFile(paramFileManagerEntity.strThumbPath, localDataLineMsgRecord.thumbPath);
    }
    localDataLineMsgRecord.filesize = paramFileManagerEntity.fileSize;
    localDataLineMsgRecord.busId = 25;
    localDataLineMsgRecord.fileFrom = 4;
    localDataLineMsgRecord.nOpType = 35;
    localDataLineMsgRecord.istroop = 0;
    Object localObject = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    localDataLineMsgRecord.sessionid = ((DataLineHandler)localObject).a(0, 0).longValue();
    localDataLineMsgRecord.msg = "";
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localDataLineMsgRecord);
    localDataLineMsgRecord.time = MessageCache.a();
    localDataLineMsgRecord.progress = 0.2F;
    localDataLineMsgRecord.fileMsgStatus = 0L;
    localDataLineMsgRecord.msgtype = a(0);
    localDataLineMsgRecord.bIsTransfering = true;
    localDataLineMsgRecord.bNoInsertFm = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid)).a(localDataLineMsgRecord, true);
    ((DataLineHandler)localObject).a(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)b(localDataLineMsgRecord.msgtype)), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(localDataLineMsgRecord.filesize) });
    localObject = new WeiYunFileInfo();
    ((WeiYunFileInfo)localObject).c = paramFileManagerEntity.fileName;
    ((WeiYunFileInfo)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    ((WeiYunFileInfo)localObject).b = paramFileManagerEntity.WeiYunDirKey;
    ((WeiYunFileInfo)localObject).jdField_a_of_type_JavaLangString = paramFileManagerEntity.WeiYunFileId;
    ((WeiYunFileInfo)localObject).jdField_a_of_type_Int = paramFileManagerEntity.nWeiYunSrcType;
    ((WeiYunFileInfo)localObject).i = paramFileManagerEntity.strFileMd5;
    ((WeiYunFileInfo)localObject).j = paramFileManagerEntity.strFileSHA;
    localDataLineMsgRecord.strWeiyunId = ((WeiYunFileInfo)localObject).jdField_a_of_type_JavaLangString;
    localDataLineMsgRecord.strWeiyunDir = ((WeiYunFileInfo)localObject).b;
    localDataLineMsgRecord.nWeiyunSrcType = ((WeiYunFileInfo)localObject).jdField_a_of_type_Int;
    localDataLineMsgRecord.strWeiyunMd5 = ((WeiYunFileInfo)localObject).i;
    localDataLineMsgRecord.strWeiyunSha = ((WeiYunFileInfo)localObject).j;
    a(localDataLineMsgRecord, (WeiYunFileInfo)localObject);
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (paramWeiYunFileInfo == null)
    {
      QLog.e("DatalineHandler", 1, "sendWeiYunFile weiYunFileInfo=null");
      return;
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    localDataLineMsgRecord.filename = paramWeiYunFileInfo.c;
    localDataLineMsgRecord.filesize = paramWeiYunFileInfo.jdField_a_of_type_Long;
    localDataLineMsgRecord.busId = 25;
    localDataLineMsgRecord.fileFrom = 4;
    localDataLineMsgRecord.nOpType = 35;
    localDataLineMsgRecord.istroop = 0;
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    localDataLineMsgRecord.sessionid = localDataLineHandler.a(0, 0).longValue();
    localDataLineMsgRecord.msg = "";
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localDataLineMsgRecord);
    localDataLineMsgRecord.time = MessageCache.a();
    localDataLineMsgRecord.progress = 0.2F;
    localDataLineMsgRecord.fileMsgStatus = 0L;
    localDataLineMsgRecord.msgtype = a(0);
    localDataLineMsgRecord.bIsTransfering = true;
    localDataLineMsgRecord.bNoInsertFm = true;
    localDataLineMsgRecord.strWeiyunId = paramWeiYunFileInfo.jdField_a_of_type_JavaLangString;
    localDataLineMsgRecord.strWeiyunDir = paramWeiYunFileInfo.b;
    localDataLineMsgRecord.nWeiyunSrcType = paramWeiYunFileInfo.jdField_a_of_type_Int;
    localDataLineMsgRecord.strWeiyunMd5 = paramWeiYunFileInfo.i;
    localDataLineMsgRecord.strWeiyunSha = paramWeiYunFileInfo.j;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid)).a(localDataLineMsgRecord, true);
    localDataLineHandler.a(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)b(localDataLineMsgRecord.msgtype)), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(localDataLineMsgRecord.filesize) });
    a(localDataLineMsgRecord, paramWeiYunFileInfo);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      int i = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX", -1);
      if (i < 0) {
        return;
      }
      if (i < 3)
      {
        paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i + 1);
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
          int i = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX");
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("<PbSendMsg><R><---handle0x211C2CMessageError, retry = ");
            localStringBuilder.append(i);
            QLog.d("DataLineHandler", 2, localStringBuilder.toString());
          }
          if (i < 3)
          {
            paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i + 1);
            sendPbReq(paramToServiceMsg);
            return;
          }
        }
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public void a(String paramString)
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
  
  public void a(ArrayList<FileInfo> paramArrayList)
  {
    a(paramArrayList, null, null, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
  }
  
  public void a(ArrayList<FileInfo> paramArrayList, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayList == null) {
      return;
    }
    for (;;)
    {
      int j = paramArrayList.size();
      Object localObject2;
      Object localObject3;
      if (j <= 3)
      {
        i = 0;
        while (i < j)
        {
          localObject1 = new ArrayList();
          localObject2 = ((FileInfo)paramArrayList.get(i)).c();
          localObject3 = ((FileInfo)paramArrayList.get(i)).b();
          localObject2 = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject2, null, (String)localObject3, 0, 0, 0L, 0, 0, 0);
          if (localObject2 != null)
          {
            ((ArrayList)localObject1).add(localObject2);
            ((Session)localObject2).uSessionID = a(0, this.jdField_a_of_type_Int).longValue();
            ((Session)localObject2).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.jdField_a_of_type_Int);
            this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject2, paramString, paramArrayOfByte);
          }
          if (((ArrayList)localObject1).size() > 0) {
            b((ArrayList)localObject1, false);
          }
          i += 1;
        }
      }
      if ((j > 3) && (j < 50))
      {
        localObject1 = new ArrayList();
        i = a();
        int k = 0;
        while (k < j)
        {
          localObject2 = ((FileInfo)paramArrayList.get(k)).c();
          localObject3 = ((FileInfo)paramArrayList.get(k)).b();
          localObject3 = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject2, null, (String)localObject3, 0, 0, 0L, i, j, k);
          if (localObject3 != null)
          {
            localObject2 = localObject1;
            ((ArrayList)localObject2).add(localObject3);
            int n = this.jdField_a_of_type_Int;
            int m = i;
            ((Session)localObject3).uSessionID = a(m, n).longValue();
            ((Session)localObject3).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.jdField_a_of_type_Int);
            this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject3, paramString, paramArrayOfByte);
            if (DataLineMsgSet.isSingle(0, m))
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
          k += 1;
        }
        if (((ArrayList)localObject1).size() > 0) {
          b((ArrayList)localObject1, false);
        }
        return;
      }
      j = a();
      Object localObject1 = new ArrayList();
      int i = 0;
      while (i < 50)
      {
        localObject3 = ((FileInfo)paramArrayList.get(i)).c();
        String str = ((FileInfo)paramArrayList.get(i)).b();
        ProtocolHelper localProtocolHelper = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper;
        localObject2 = localObject1;
        localObject3 = localProtocolHelper.genSession(0, (String)localObject3, null, str, 0, 0, 0L, j, 50, i);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          ((ArrayList)localObject2).add(localObject3);
          ((Session)localObject3).uSessionID = a(j, this.jdField_a_of_type_Int).longValue();
          ((Session)localObject3).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject3, paramString, paramArrayOfByte);
          localObject1 = localObject2;
          if (DataLineMsgSet.isSingle(0, j))
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
        i += 1;
      }
      if (((ArrayList)localObject1).size() > 0) {
        b((ArrayList)localObject1, false);
      }
      i = 0;
      while (i < 50)
      {
        paramArrayList.remove(0);
        i += 1;
      }
    }
  }
  
  public void a(ArrayList<DataLineMsgRecord> paramArrayList, boolean paramBoolean)
  {
    a(paramArrayList, paramBoolean, null, null, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
  }
  
  public void a(ArrayList<DataLineMsgRecord> paramArrayList, boolean paramBoolean, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramArrayList.next();
      Session localSession = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(localDataLineMsgRecord);
      if (localSession != null)
      {
        if (0L == localSession.uSessionID) {
          localSession.uSessionID = a(localDataLineMsgRecord.groupId, this.jdField_a_of_type_Int).longValue();
        }
        localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, paramString, paramArrayOfByte);
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
        if (LoginDevicesUtils.b(localLoginDevItem.jdField_a_of_type_Int))
        {
          b(true);
          this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(1));
          QLog.i("FileAssistantSender<FileAssistant>", 1, "ipad is online!");
        }
        else if (LoginDevicesUtils.a(localLoginDevItem.jdField_a_of_type_Int))
        {
          a(true);
          this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(0));
          QLog.i("FileAssistantSender<FileAssistant>", 1, "pc is online!");
        }
      }
    }
  }
  
  public void a(msg_comm.Msg paramMsg)
  {
    this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a(paramMsg);
  }
  
  /* Error */
  public void a(msg_comm.Msg paramMsg, SubMsgType0x7.MsgBody paramMsgBody)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 265	com/tencent/mobileqq/app/DataLineHandler:jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager	Lcooperation/qqdataline/ipc/DatalineRemoteManager;
    //   4: aload_1
    //   5: aload_2
    //   6: invokevirtual 2519	cooperation/qqdataline/ipc/DatalineRemoteManager:a	(Lmsf/msgcomm/msg_comm$Msg;Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody;)V
    //   9: new 400	com/tencent/mobileqq/data/DataLineMsgRecord
    //   12: dup
    //   13: invokespecial 2175	com/tencent/mobileqq/data/DataLineMsgRecord:<init>	()V
    //   16: astore 4
    //   18: aload 4
    //   20: aload_1
    //   21: getfield 2525	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   24: invokevirtual 2528	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: checkcast 2527	msf/msgcomm/msg_comm$MsgHead
    //   30: getfield 2531	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   33: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   36: i2l
    //   37: putfield 2307	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   40: aload 4
    //   42: aload_1
    //   43: getfield 2525	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   46: invokevirtual 2528	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   49: checkcast 2527	msf/msgcomm/msg_comm$MsgHead
    //   52: getfield 2534	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   55: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   58: i2l
    //   59: putfield 2195	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   62: aload 4
    //   64: aload_1
    //   65: getfield 2525	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   68: invokevirtual 2528	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   71: checkcast 2527	msf/msgcomm/msg_comm$MsgHead
    //   74: getfield 2537	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   77: invokevirtual 2269	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   80: putfield 720	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   83: aload_2
    //   84: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   87: invokevirtual 2538	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:has	()Z
    //   90: ifeq +1173 -> 1263
    //   93: aload_2
    //   94: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   97: getfield 2541	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   100: invokevirtual 962	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   103: ifeq +1149 -> 1252
    //   106: aload_2
    //   107: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   110: getfield 2544	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_inst_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   113: invokevirtual 962	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   116: ifeq +1125 -> 1241
    //   119: aload_2
    //   120: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   123: getfield 2547	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_dst_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 962	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   129: ifeq +1101 -> 1230
    //   132: aload_2
    //   133: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   136: getfield 2550	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_dst_inst_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   139: invokevirtual 962	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   142: ifeq +1077 -> 1219
    //   145: aload_0
    //   146: aload_2
    //   147: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   150: getfield 2541	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   153: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   156: aload_2
    //   157: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   160: getfield 2544	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_inst_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   163: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   166: invokevirtual 2552	com/tencent/mobileqq/app/DataLineHandler:a	(II)Z
    //   169: ifne +1039 -> 1208
    //   172: aload_2
    //   173: getfield 1261	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   176: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   179: iconst_5
    //   180: if_icmpeq +44 -> 224
    //   183: aload_0
    //   184: aload_2
    //   185: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   188: getfield 2547	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_dst_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   191: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   194: aload_2
    //   195: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   198: getfield 2550	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_dst_inst_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   201: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   204: invokevirtual 2554	com/tencent/mobileqq/app/DataLineHandler:b	(II)Z
    //   207: ifeq +6 -> 213
    //   210: goto +14 -> 224
    //   213: new 1540	java/lang/Exception
    //   216: dup
    //   217: ldc_w 2556
    //   220: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   223: athrow
    //   224: aload_1
    //   225: getfield 2525	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   228: invokevirtual 2528	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   231: checkcast 2527	msf/msgcomm/msg_comm$MsgHead
    //   234: getfield 2560	msf/msgcomm/msg_comm$MsgHead:msg_inst_ctrl	Ltencent/im/msg/im_msg_head$InstCtrl;
    //   237: invokevirtual 2561	tencent/im/msg/im_msg_head$InstCtrl:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   240: checkcast 665	tencent/im/msg/im_msg_head$InstCtrl
    //   243: getfield 683	tencent/im/msg/im_msg_head$InstCtrl:msg_from_inst	Ltencent/im/msg/im_msg_head$InstInfo;
    //   246: invokevirtual 2562	tencent/im/msg/im_msg_head$InstInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   249: checkcast 622	tencent/im/msg/im_msg_head$InstInfo
    //   252: astore 5
    //   254: aload_2
    //   255: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   258: getfield 2267	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_ter_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   261: aload 5
    //   263: getfield 640	tencent/im/msg/im_msg_head$InstInfo:enum_device_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   266: invokevirtual 2563	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   269: invokevirtual 633	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   272: new 215	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   279: astore 5
    //   281: aload 5
    //   283: ldc_w 2565
    //   286: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 5
    //   292: aload 4
    //   294: getfield 2195	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   297: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 5
    //   303: ldc_w 2567
    //   306: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 5
    //   312: aload 4
    //   314: getfield 2307	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   317: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 5
    //   323: ldc_w 2569
    //   326: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 5
    //   332: aload_2
    //   333: getfield 1261	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: invokevirtual 337	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 5
    //   345: ldc_w 1788
    //   348: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: ldc_w 300
    //   355: iconst_2
    //   356: aload 5
    //   358: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload_0
    //   365: getfield 142	com/tencent/mobileqq/app/DataLineHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   368: invokevirtual 689	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   371: aload_2
    //   372: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   375: getfield 2267	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_ter_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   378: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   381: invokevirtual 694	com/tencent/imcore/message/QQMessageFacade:a	(I)Lcom/tencent/mobileqq/app/message/DatalineMessageManager;
    //   384: aload 4
    //   386: getfield 2195	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   389: invokevirtual 2571	com/tencent/mobileqq/app/message/DatalineMessageManager:e	(J)V
    //   392: aload_0
    //   393: aload 4
    //   395: aload_2
    //   396: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   399: getfield 2267	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint32_src_ter_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   402: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   405: invokevirtual 2574	com/tencent/mobileqq/app/DataLineHandler:a	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;I)Z
    //   408: ifeq +87 -> 495
    //   411: new 215	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   418: astore_1
    //   419: aload_1
    //   420: ldc_w 2565
    //   423: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_1
    //   428: aload 4
    //   430: getfield 2195	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   433: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload_1
    //   438: ldc_w 2576
    //   441: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_1
    //   446: aload 4
    //   448: getfield 2307	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   451: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload_1
    //   456: ldc_w 2569
    //   459: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload_1
    //   464: aload_2
    //   465: getfield 1261	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   468: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   471: invokevirtual 337	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload_1
    //   476: ldc_w 1788
    //   479: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: ldc_w 300
    //   486: iconst_2
    //   487: aload_1
    //   488: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: return
    //   495: aload_0
    //   496: getfield 142	com/tencent/mobileqq/app/DataLineHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   499: getstatic 1735	com/tencent/mobileqq/app/BusinessHandlerFactory:REGPRXYSVCPACK_HANDLER	Ljava/lang/String;
    //   502: invokevirtual 1739	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   505: checkcast 1741	com/tencent/mobileqq/app/RegisterProxySvcPackHandler
    //   508: astore 5
    //   510: aload 5
    //   512: ifnull +18 -> 530
    //   515: aload 5
    //   517: invokevirtual 2578	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:d	()I
    //   520: iconst_1
    //   521: if_icmpeq +9 -> 530
    //   524: aload 5
    //   526: iconst_1
    //   527: invokevirtual 2580	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:e	(I)V
    //   530: aload_2
    //   531: getfield 1261	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   534: invokevirtual 962	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   537: ifeq +660 -> 1197
    //   540: new 215	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   547: astore 5
    //   549: aload 5
    //   551: ldc_w 2565
    //   554: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 5
    //   560: aload 4
    //   562: getfield 2195	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   565: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload 5
    //   571: ldc_w 2582
    //   574: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload 5
    //   580: aload 4
    //   582: getfield 2307	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   585: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 5
    //   591: ldc_w 2569
    //   594: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload 5
    //   600: aload_2
    //   601: getfield 1261	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   604: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   607: invokevirtual 337	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload 5
    //   613: ldc_w 1788
    //   616: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: ldc_w 300
    //   623: iconst_2
    //   624: aload 5
    //   626: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: aload_2
    //   633: getfield 1261	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   636: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   639: istore_3
    //   640: iload_3
    //   641: tableswitch	default:+59 -> 700, 1:+483->1124, 2:+410->1051, 3:+378->1019, 4:+318->959, 5:+290->931, 6:+59->700, 7:+59->700, 8:+218->859, 9:+145->786, 10:+72->713, 11:+60->701
    //   701: aload_0
    //   702: aload_2
    //   703: getfield 2585	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0xb_mpfile_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   706: invokevirtual 2287	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   709: invokevirtual 2587	com/tencent/mobileqq/app/DataLineHandler:b	(Ljava/util/List;)V
    //   712: return
    //   713: invokestatic 332	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   716: ifeq +13 -> 729
    //   719: ldc_w 300
    //   722: iconst_2
    //   723: ldc_w 2589
    //   726: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   729: aload_2
    //   730: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   733: getfield 2590	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   736: invokevirtual 958	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   739: ifeq +36 -> 775
    //   742: aload_0
    //   743: aload_1
    //   744: getfield 2525	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   747: invokevirtual 2528	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   750: checkcast 2527	msf/msgcomm/msg_comm$MsgHead
    //   753: getfield 2534	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   756: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   759: aload_2
    //   760: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   763: aload_2
    //   764: getfield 2593	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0xa_nfc_thumb_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   767: invokevirtual 2287	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   770: iconst_1
    //   771: invokespecial 2595	com/tencent/mobileqq/app/DataLineHandler:b	(ILtencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;Ljava/util/List;Z)V
    //   774: return
    //   775: new 1540	java/lang/Exception
    //   778: dup
    //   779: ldc_w 2597
    //   782: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   785: athrow
    //   786: invokestatic 332	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   789: ifeq +13 -> 802
    //   792: ldc_w 300
    //   795: iconst_2
    //   796: ldc_w 2599
    //   799: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   802: aload_2
    //   803: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   806: getfield 2590	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   809: invokevirtual 958	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   812: ifeq +36 -> 848
    //   815: aload_0
    //   816: aload_1
    //   817: getfield 2525	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   820: invokevirtual 2528	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   823: checkcast 2527	msf/msgcomm/msg_comm$MsgHead
    //   826: getfield 2534	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   829: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   832: aload_2
    //   833: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   836: aload_2
    //   837: getfield 2602	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0x9_ftn_thumb_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   840: invokevirtual 2287	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   843: iconst_1
    //   844: invokespecial 2604	com/tencent/mobileqq/app/DataLineHandler:a	(ILtencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;Ljava/util/List;Z)V
    //   847: return
    //   848: new 1540	java/lang/Exception
    //   851: dup
    //   852: ldc_w 2597
    //   855: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   858: athrow
    //   859: invokestatic 332	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   862: ifeq +13 -> 875
    //   865: ldc_w 300
    //   868: iconst_2
    //   869: ldc_w 2606
    //   872: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   875: aload_2
    //   876: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   879: getfield 2590	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   882: invokevirtual 958	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   885: ifeq +35 -> 920
    //   888: aload_0
    //   889: aload_1
    //   890: getfield 2525	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   893: invokevirtual 2528	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   896: checkcast 2527	msf/msgcomm/msg_comm$MsgHead
    //   899: getfield 2534	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   902: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   905: aload_2
    //   906: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   909: aload_2
    //   910: getfield 2609	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0x8_rnfc_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   913: invokevirtual 2287	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   916: invokespecial 2611	com/tencent/mobileqq/app/DataLineHandler:a	(ILtencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;Ljava/util/List;)V
    //   919: return
    //   920: new 1540	java/lang/Exception
    //   923: dup
    //   924: ldc_w 2597
    //   927: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   930: athrow
    //   931: invokestatic 332	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   934: ifeq +13 -> 947
    //   937: ldc_w 300
    //   940: iconst_2
    //   941: ldc_w 2613
    //   944: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   947: aload_0
    //   948: aload_2
    //   949: getfield 2616	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0x5_molo_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   952: invokevirtual 2287	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   955: invokespecial 2618	com/tencent/mobileqq/app/DataLineHandler:c	(Ljava/util/List;)V
    //   958: return
    //   959: invokestatic 332	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   962: ifeq +13 -> 975
    //   965: ldc_w 300
    //   968: iconst_2
    //   969: ldc_w 2620
    //   972: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   975: aload_2
    //   976: getfield 1267	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_subcmd_0x4_generic	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$GenericSubCmd;
    //   979: invokevirtual 2621	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$GenericSubCmd:has	()Z
    //   982: ifeq +26 -> 1008
    //   985: aload_0
    //   986: aload 4
    //   988: getfield 2195	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   991: aload 4
    //   993: getfield 2307	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   996: aload_2
    //   997: getfield 1267	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_subcmd_0x4_generic	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$GenericSubCmd;
    //   1000: aload_2
    //   1001: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   1004: invokevirtual 2623	com/tencent/mobileqq/app/DataLineHandler:a	(JJLtencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$GenericSubCmd;Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;)V
    //   1007: return
    //   1008: new 1540	java/lang/Exception
    //   1011: dup
    //   1012: ldc_w 2625
    //   1015: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1018: athrow
    //   1019: invokestatic 332	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1022: ifeq +13 -> 1035
    //   1025: ldc_w 300
    //   1028: iconst_2
    //   1029: ldc_w 2627
    //   1032: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1035: aload_0
    //   1036: aload_2
    //   1037: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   1040: aload_2
    //   1041: getfield 2630	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0x3_filecontrol	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1044: invokevirtual 2287	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1047: invokespecial 2632	com/tencent/mobileqq/app/DataLineHandler:a	(Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;Ljava/util/List;)V
    //   1050: return
    //   1051: invokestatic 332	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1054: ifeq +13 -> 1067
    //   1057: ldc_w 300
    //   1060: iconst_2
    //   1061: ldc_w 2634
    //   1064: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1067: aload_2
    //   1068: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   1071: getfield 2590	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1074: invokevirtual 958	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1077: ifeq +36 -> 1113
    //   1080: aload_0
    //   1081: aload_1
    //   1082: getfield 2525	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1085: invokevirtual 2528	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1088: checkcast 2527	msf/msgcomm/msg_comm$MsgHead
    //   1091: getfield 2534	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1094: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1097: aload_2
    //   1098: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   1101: aload_2
    //   1102: getfield 2637	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0x2_nfc_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1105: invokevirtual 2287	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1108: iconst_0
    //   1109: invokespecial 2595	com/tencent/mobileqq/app/DataLineHandler:b	(ILtencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;Ljava/util/List;Z)V
    //   1112: return
    //   1113: new 1540	java/lang/Exception
    //   1116: dup
    //   1117: ldc_w 2597
    //   1120: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1123: athrow
    //   1124: invokestatic 332	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1127: ifeq +13 -> 1140
    //   1130: ldc_w 300
    //   1133: iconst_2
    //   1134: ldc_w 2639
    //   1137: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1140: aload_2
    //   1141: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   1144: getfield 2590	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1147: invokevirtual 958	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1150: ifeq +36 -> 1186
    //   1153: aload_0
    //   1154: aload_1
    //   1155: getfield 2525	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1158: invokevirtual 2528	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1161: checkcast 2527	msf/msgcomm/msg_comm$MsgHead
    //   1164: getfield 2534	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1167: invokevirtual 1263	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1170: aload_2
    //   1171: getfield 1960	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:msg_header	Ltencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;
    //   1174: aload_2
    //   1175: getfield 2209	tencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody:rpt_msg_subcmd_0x1_ftn_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1178: invokevirtual 2287	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1181: iconst_0
    //   1182: invokespecial 2604	com/tencent/mobileqq/app/DataLineHandler:a	(ILtencent/im/s2c/msgtype0x211/submsgtype0x7/SubMsgType0x7$MsgBody$MsgHeader;Ljava/util/List;Z)V
    //   1185: return
    //   1186: new 1540	java/lang/Exception
    //   1189: dup
    //   1190: ldc_w 2597
    //   1193: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1196: athrow
    //   1197: new 1540	java/lang/Exception
    //   1200: dup
    //   1201: ldc_w 2641
    //   1204: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1207: athrow
    //   1208: new 1540	java/lang/Exception
    //   1211: dup
    //   1212: ldc_w 2643
    //   1215: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1218: athrow
    //   1219: new 1540	java/lang/Exception
    //   1222: dup
    //   1223: ldc_w 2645
    //   1226: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1229: athrow
    //   1230: new 1540	java/lang/Exception
    //   1233: dup
    //   1234: ldc_w 2647
    //   1237: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1240: athrow
    //   1241: new 1540	java/lang/Exception
    //   1244: dup
    //   1245: ldc_w 2649
    //   1248: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1251: athrow
    //   1252: new 1540	java/lang/Exception
    //   1255: dup
    //   1256: ldc_w 2651
    //   1259: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1262: athrow
    //   1263: new 1540	java/lang/Exception
    //   1266: dup
    //   1267: ldc_w 2653
    //   1270: invokespecial 2557	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1273: athrow
    //   1274: astore_1
    //   1275: goto +55 -> 1330
    //   1278: astore_1
    //   1279: invokestatic 332	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1282: ifeq +47 -> 1329
    //   1285: new 215	java/lang/StringBuilder
    //   1288: dup
    //   1289: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   1292: astore_2
    //   1293: aload_2
    //   1294: ldc_w 2655
    //   1297: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: pop
    //   1301: aload_2
    //   1302: aload_1
    //   1303: invokevirtual 2656	java/lang/Exception:toString	()Ljava/lang/String;
    //   1306: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1309: pop
    //   1310: aload_2
    //   1311: ldc_w 2658
    //   1314: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: pop
    //   1318: ldc_w 300
    //   1321: iconst_2
    //   1322: aload_2
    //   1323: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1326: invokestatic 499	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1329: return
    //   1330: aload_1
    //   1331: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1332	0	this	DataLineHandler
    //   0	1332	1	paramMsg	msg_comm.Msg
    //   0	1332	2	paramMsgBody	SubMsgType0x7.MsgBody
    //   639	2	3	i	int
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
    this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a(this, paramMsg, paramMsgBody);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_PC_STATE");
      localObject = ((StringBuilder)localObject).toString();
      if (this.jdField_b_of_type_Boolean)
      {
        localSharedPreferences.edit().putLong((String)localObject, this.jdField_a_of_type_Long).commit();
        return;
      }
      localSharedPreferences.edit().remove((String)localObject).commit();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("dl_pc_online_notify", true);
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_b_of_type_Boolean;
    }
    return this.jdField_c_of_type_Boolean;
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    int i = AppSetting.a();
    if ((paramInt1 == 1001) && (paramInt2 == i) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgBody command from android");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" ");
      localStringBuilder.append(i);
      QLog.d("DataLineHandler", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(i).b(paramLong);
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(i).a(paramInt);
    if ((localDataLineMsgSet != null) && (localDataLineMsgSet.isPaused()))
    {
      if (localDataLineMsgRecord != null)
      {
        localDataLineMsgRecord.issuc = true;
        localDataLineMsgRecord.fileMsgStatus = 2L;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).d(localDataLineMsgRecord.msgId);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    long l = paramDataLineMsgRecord.sessionid;
    double d1 = paramDataLineMsgRecord.filesize;
    Double.isNaN(d1);
    OnSessionProgress(l, (d1 * 0.4D), paramDataLineMsgRecord.filesize, 0);
    if ((0L != paramDataLineMsgRecord.filesize) && (paramDataLineMsgRecord.path != null) && (paramDataLineMsgRecord.path.length() != 0) && (paramDataLineMsgRecord.md5 != null) && (paramDataLineMsgRecord.md5.length != 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return true;
    }
    Object localObject2 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject2).uint32_cmd.set(1400);
    ((cmd0x346.ReqBody)localObject2).uint32_client_type.set(104);
    Object localObject1 = ((cmd0x346.ReqBody)localObject2).uint32_seq;
    int i = f;
    f = i + 1;
    ((PBUInt32Field)localObject1).set(i);
    ((cmd0x346.ReqBody)localObject2).msg_file_query_req.setHasFlag(true);
    ((cmd0x346.ReqBody)localObject2).msg_file_query_req.uint64_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
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
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_b_of_type_JavaUtilList.isEmpty())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(1).a();
        if ((localObject != null) && (((DataLineMsgSetList)localObject).size() > 0))
        {
          localObject = ((DataLineMsgSetList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localIterator = ((DataLineMsgSet)((Iterator)localObject).next()).values().iterator();
            while (localIterator.hasNext())
            {
              localMessageRecord = (MessageRecord)localIterator.next();
              this.jdField_b_of_type_JavaUtilList.add(Long.valueOf(localMessageRecord.shmsgseq));
            }
          }
        }
      }
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Long)((Iterator)localObject).next()).longValue() == paramDataLineMsgRecord.shmsgseq) {
          break label191;
        }
      }
      bool1 = false;
      label191:
      if (!bool1)
      {
        this.jdField_b_of_type_JavaUtilList.add(Long.valueOf(paramDataLineMsgRecord.shmsgseq));
        if (this.jdField_b_of_type_JavaUtilList.size() > 120) {
          this.jdField_b_of_type_JavaUtilList.remove(0);
        }
      }
      return bool1;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(0).a();
      if ((localObject != null) && (((DataLineMsgSetList)localObject).size() > 0))
      {
        localObject = ((DataLineMsgSetList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localIterator = ((DataLineMsgSet)((Iterator)localObject).next()).values().iterator();
          while (localIterator.hasNext())
          {
            localMessageRecord = (MessageRecord)localIterator.next();
            this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localMessageRecord.shmsgseq));
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
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
      this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(paramDataLineMsgRecord.shmsgseq));
      if (this.jdField_a_of_type_JavaUtilList.size() > 120) {
        this.jdField_a_of_type_JavaUtilList.remove(0);
      }
    }
    return bool1;
  }
  
  public boolean a(DataLineMsgSet paramDataLineMsgSet)
  {
    if (!paramDataLineMsgSet.isSingle()) {
      c(paramDataLineMsgSet.getGroupId());
    }
    int i = DataLineMsgRecord.getDevTypeBySet(paramDataLineMsgSet);
    Iterator localIterator = paramDataLineMsgSet.values().iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if (localDataLineMsgRecord.strMoloKey != null)
      {
        Object localObject = a().getDataLineMsgProxy(i).a(localDataLineMsgRecord.strMoloKey);
        if ((localObject == null) || (((List)localObject).size() == 1))
        {
          this.jdField_a_of_type_ComDatalineCoreMoloHandler.d(localDataLineMsgRecord.strMoloKey);
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
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(paramDataLineMsgSet) >= 0;
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.jdField_a_of_type_ComDatalineCoreMoloHandler.e(paramString);
  }
  
  public boolean a(List<Long> paramList)
  {
    QLog.i("DataLineHandler", 1, "manually receives a file . sessionlist");
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = paramList.iterator();
    boolean bool1 = false;
    Object localObject2;
    int i;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      i = DataLineMsgRecord.getDevTypeBySeId(((Long)localObject2).longValue());
      localObject3 = a().getMessageFacade().a(i).a(((Long)localObject2).longValue());
      if (localObject3 != null)
      {
        ((DataLineMsgRecord)localObject3).fileMsgStatus = 0L;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).d(((DataLineMsgRecord)localObject3).msgId);
      }
      if ((localObject3 != null) && (((DataLineMsgRecord)localObject3).strMoloKey != null))
      {
        this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(((DataLineMsgRecord)localObject3).strMoloKey);
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
        i = DataLineMsgRecord.getDevTypeBySeId(((Long)localObject2).longValue());
        DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(((Long)localObject2).longValue());
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
          c(localDataLineMsgRecord);
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
        localObject2 = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
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
          b(((DataLineMsgRecord)localObject1).path);
        }
        return true;
      }
    }
    return bool1;
  }
  
  public int b()
  {
    return ((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b();
  }
  
  protected void b() {}
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(paramInt);
  }
  
  public void b(DataLineMsgRecord paramDataLineMsgRecord)
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
      localWeiYunFileInfo.jdField_a_of_type_Long = paramDataLineMsgRecord.filesize;
      localWeiYunFileInfo.b = paramDataLineMsgRecord.strWeiyunDir;
      localWeiYunFileInfo.jdField_a_of_type_JavaLangString = paramDataLineMsgRecord.strWeiyunId;
      localWeiYunFileInfo.jdField_a_of_type_Int = paramDataLineMsgRecord.nWeiyunSrcType;
      localWeiYunFileInfo.i = paramDataLineMsgRecord.strWeiyunMd5;
      localWeiYunFileInfo.j = paramDataLineMsgRecord.strWeiyunSha;
      paramDataLineMsgRecord.bNoInsertFm = true;
      a(paramDataLineMsgRecord, localWeiYunFileInfo);
      return;
    }
    QLog.e("DatalineHandler", 1, "reSendWeiYunFile keyinfo=null");
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = a(paramFileManagerEntity);
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
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.RecvGroup((Session[])localArrayList.toArray(new Session[localArrayList.size()]), (NFCInfo[])((List)localObject).toArray(new NFCInfo[((List)localObject).size()]), (FTNInfo[])paramFileManagerEntity.toArray(new FTNInfo[paramFileManagerEntity.size()]), false);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MsgSCBody localMsgSCBody = new MsgSCBody();
    cmd0x345.RspBody localRspBody = new cmd0x345.RspBody();
    localMsgSCBody.uMsgType = 837;
    int i = 0;
    localMsgSCBody.bTimeOut = false;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      localMsgSCBody.bTimeOut = true;
    }
    Object localObject = null;
    if (paramFromServiceMsg != null)
    {
      if (paramFromServiceMsg.getWupBuffer() != null)
      {
        int j = paramFromServiceMsg.getWupBuffer().length - 4;
        if (j < 0) {
          break label128;
        }
        byte[] arrayOfByte = new byte[j];
        PkgTools.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, j);
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
      i = localRspBody.uint32_sub_cmd.get();
    }
    paramFromServiceMsg.uMsgSubType = i;
    paramFromServiceMsg = localMsgSCBody.msgBody0x345;
    if (localRspBody.uint32_return_code.has()) {
      i = localRspBody.uint32_return_code.get();
    } else {
      i = -1;
    }
    paramFromServiceMsg.uint32_return_code = i;
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
    long l;
    if (paramToServiceMsg == null) {
      l = 0L;
    } else {
      l = ((Long)paramToServiceMsg.getAttribute("cookie")).longValue();
    }
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(Long.valueOf(l).intValue(), localMsgSCBody);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    long l = ((Long)paramToServiceMsg.getAttribute("cookie")).longValue();
    paramInt = DataLineMsgRecord.getDevTypeBySeId(l);
    new Handler(Looper.getMainLooper()).post(new DataLineHandler.7(this, paramFromServiceMsg, paramInt, l, paramToServiceMsg));
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
    int i;
    if ((localStringBuilder != null) && (localStringBuilder.result.has()))
    {
      if (localStringBuilder.result.get() != 0) {
        i = localStringBuilder.result.get();
      } else {
        i = 0;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("DataLineHandler", 2, "handle0x211C2CMessageResp::server did not return a valid result code, use 4 instead.");
      }
      i = 4;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<PbSendMsg><R><---handle0x211C2CMessageResp: ---ServiceCmd:");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      localStringBuilder.append("----replyCode:");
      localStringBuilder.append(i);
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
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if (paramArrayList == null) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      int i;
      switch ((int)((InstanceInfo)paramArrayList.next()).iClientType)
      {
      default: 
        i = -1;
        break;
      case 65805: 
      case 68104: 
      case 68361: 
      case 72194: 
        i = 1;
        break;
      case 65793: 
      case 66818: 
      case 66831: 
      case 77313: 
      case 81154: 
        i = 0;
      }
      if (i != -1) {
        this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
      }
    }
  }
  
  protected void b(List<SubMsgType0x7.MsgBody.MpFileNotify> paramList) {}
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_IPAD_STATE");
      localObject = ((StringBuilder)localObject).toString();
      if (this.jdField_c_of_type_Boolean)
      {
        localSharedPreferences.edit().putLong((String)localObject, this.jdField_b_of_type_Long).commit();
        return;
      }
      localSharedPreferences.edit().remove((String)localObject).commit();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("dl_ipad_online_notify", true);
  }
  
  public boolean b(int paramInt)
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      return this.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  protected boolean b(int paramInt1, int paramInt2)
  {
    int i = AppSetting.a();
    if ((paramInt1 == 1001) && ((paramInt2 == i) || (paramInt2 == 0))) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgBody command not for android");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" ");
      localStringBuilder.append(i);
      QLog.d("DataLineHandler", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.jdField_a_of_type_ComDatalineCoreMoloHandler.b(paramString);
  }
  
  public int c()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)
    {
      int i = this.jdField_d_of_type_Int;
      return i;
    }
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "--->>wifi lost cancel all task");
    }
    d(41);
  }
  
  public void c(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      if (!this.jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(paramInt)))
      {
        this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
        if (this.jdField_c_of_type_JavaUtilList.size() > 256) {
          this.jdField_c_of_type_JavaUtilList.remove(0);
        }
      }
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    localEditor.putBoolean("auto_receive_files", paramBoolean);
    localEditor.putBoolean("auto_receive_files_ipad", paramBoolean);
    localEditor.apply();
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    this.jdField_b_of_type_Int = i;
  }
  
  public boolean c()
  {
    int i = this.jdField_b_of_type_Int;
    boolean bool1 = false;
    if (i == 0)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      boolean bool2 = localSharedPreferences.getBoolean("auto_receive_files", false);
      boolean bool3 = localSharedPreferences.getBoolean("auto_receive_files_ipad", false);
      if ((!bool2) && (!bool3)) {
        this.jdField_b_of_type_Int = 2;
      } else {
        this.jdField_b_of_type_Int = 1;
      }
    }
    if (this.jdField_b_of_type_Int == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean c(int paramInt)
  {
    return this.jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(paramInt));
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void d()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(String.valueOf(AppConstants.DATALINE_PC_UIN), 6000).time;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendDatalineReadConfirm last time[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    QLog.d("DataLineHandler", 2, ((StringBuilder)localObject).toString());
    if ((l != 0L) && (l != this.jdField_c_of_type_Long))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(new Pair(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), Long.valueOf(l)));
      ((C2CMessageProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a("c2c_processor")).a((ArrayList)localObject);
      this.jdField_c_of_type_Long = l;
    }
    l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(String.valueOf(AppConstants.DATALINE_IPAD_UIN), 6003).time;
    if ((l != 0L) && (l != this.jdField_d_of_type_Long))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(new Pair(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), Long.valueOf(l)));
      ((C2CMessageProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a("c2c_processor")).a((ArrayList)localObject);
      this.jdField_d_of_type_Long = l;
    }
  }
  
  public void d(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(0).a();
    DataLineMsgSet localDataLineMsgSet;
    if (localObject != null)
    {
      localObject = ((DataLineMsgSetList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject).next();
        if (!localDataLineMsgSet.isSingle()) {
          c(localDataLineMsgSet.getGroupId());
        }
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(0).a(false);
    if (localObject != null)
    {
      localObject = ((DataLineMsgSetList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject).next();
        if (!localDataLineMsgSet.isSingle()) {
          c(localDataLineMsgSet.getGroupId());
        }
      }
    }
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.b();
  }
  
  public void e(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void f()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)
    {
      this.jdField_d_of_type_Int += 1;
      if (this.e) {
        f(this.jdField_d_of_type_Int);
      }
      return;
    }
  }
  
  public void g()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)
    {
      if (this.jdField_d_of_type_Int == 0) {
        return;
      }
      this.jdField_d_of_type_Int = 0;
      f(this.jdField_d_of_type_Int);
      return;
    }
  }
  
  public boolean getAutoDownload()
  {
    return a().getPreferences().getBoolean("auto_receive_files", false);
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
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return DataLineObserver.class;
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    StringBuilder localStringBuilder;
    if ((localQQAppInterface1 != null) && (localQQAppInterface1.getApp() != null) && (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null))
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      }
      catch (Exception localException1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy fail unregisterReceiver exitReceiver:");
        localStringBuilder.append(localException1);
        QLog.e("DataLineHandler", 1, localStringBuilder.toString());
      }
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
    }
    QQAppInterface localQQAppInterface2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localQQAppInterface2 != null) && (localQQAppInterface2.getApp() != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      catch (Exception localException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy fail unregisterReceiver sdCardReceiver:");
        localStringBuilder.append(localException2);
        QLog.e("DataLineHandler", 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localObject != null) && (((QQAppInterface)localObject).getApp() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)localObject);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
    if (localObject != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "--->>close cancel all task");
    }
    d(32);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((QQAppInterface)localObject).getDataLineMsgProxy(0) != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(0).a();
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((QQAppInterface)localObject).getDataLineMsgProxy(1) != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(1).a();
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
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.endLiteTransfer(bool2);
    this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a();
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a();
    this.jdField_a_of_type_ComDatalineCoreDirectForwarder.a();
    localObject = this.jdField_a_of_type_JavaUtilTimer;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler
 * JD-Core Version:    0.7.0.1
 */