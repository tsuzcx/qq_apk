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
import msf.msgcomm.msg_comm.MsgHead;
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
  private static int jdField_e_of_type_Int = 0;
  private static int f = 0;
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
  private boolean jdField_e_of_type_Boolean = false;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler = new PrinterHandler(paramQQAppInterface);
    this.jdField_a_of_type_ComDatalineDataPrinterManager = new PrinterManager(paramQQAppInterface);
    this.jdField_a_of_type_ComDatalineCoreDirectForwarder = new DirectForwarder(paramQQAppInterface);
    this.g = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296846);
    this.h = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296845);
    k();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new DataLineHandler.1(this);
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new DataLineHandler.2(this, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new DataLineHandler.3(this);
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper = new ProtocolHelper(paramQQAppInterface, 0);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + paramQQAppInterface.getApp().getPackageName());
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
    switch (paramInt)
    {
    case 3: 
    default: 
      return -2005;
    case 1: 
      return -2000;
    }
    return -2009;
  }
  
  private int a(MsgHeader paramMsgHeader)
  {
    if (paramMsgHeader == null) {
      return 65793;
    }
    switch (paramMsgHeader.uint32_src_ter_type)
    {
    default: 
      return 65793;
    case 2: 
      return 67586;
    }
    return 68361;
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    int j = 255;
    if (paramFileManagerEntity == null)
    {
      QLog.i("DataLineHandler", 2, "转发文件, FileManagerEntity为空");
      return j;
    }
    int i;
    if ((!TextUtils.isEmpty(paramFileManagerEntity.getFilePath())) && (new File(paramFileManagerEntity.getFilePath()).exists())) {
      i = 0;
    }
    for (;;)
    {
      j = i;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("DataLineHandler", 4, "是否可以转发到数据线, [" + paramFileManagerEntity.peerType + "]， name[" + paramFileManagerEntity.fileName + "], LocalPath[" + paramFileManagerEntity.getFilePath() + "], FileSize[" + paramFileManagerEntity.fileSize + "], fileFrom[" + i + "], peerType[" + paramFileManagerEntity.peerType + "], peerUin[" + paramFileManagerEntity.peerUin + "], cloudType[" + paramFileManagerEntity.getCloudType());
      return i;
      i = j;
      switch (paramFileManagerEntity.getCloudType())
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("dataline", 2, "FileManagerEntity->cloudType 转 ForwardFileInfo->type， 未识别的cloudType[" + paramFileManagerEntity.getCloudType());
          i = j;
        }
        break;
      case 1: 
        switch (paramFileManagerEntity.peerType)
        {
        default: 
          if (QLog.isColorLevel())
          {
            QLog.i("DataLineHandler", 2, "转发文件, 未知的文件来源默认为C2C, peerType[" + paramFileManagerEntity.peerType + "]， name[" + paramFileManagerEntity.fileName + "], LocalPath[" + paramFileManagerEntity.getFilePath() + "], FileSize[" + paramFileManagerEntity.fileSize + "], fileFrom[" + 1 + "], peerUin[" + paramFileManagerEntity.peerUin + "], cloudType[" + paramFileManagerEntity.getCloudType());
            i = 1;
          }
          break;
        case 0: 
          i = 1;
          break;
        case 3000: 
          i = 3;
          break;
        case 1: 
          i = 2;
          break;
        case 6000: 
          i = 5;
        }
        break;
      case 2: 
        i = 4;
        break;
      case 4: 
        i = 2;
        break;
      case 10: 
        i = 6;
        continue;
        i = 1;
      }
    }
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    switch (FileManagerUtil.a(paramString))
    {
    default: 
      if (!paramBoolean) {
        break;
      }
    case 0: 
      return 1;
    case 1: 
      return 3;
    case 2: 
      return 2;
    }
    return 0;
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
    }
    for (;;)
    {
      if (QFileAssistantUtils.a(paramFileManagerEntity.peerUin)) {
        localSession.isFileAssist = true;
      }
      localSession.strFilePathSrc = FilePathUtil.c(paramFileManagerEntity.strFilePath);
      localSession.strFilePathThumb = paramFileManagerEntity.strThumbPath;
      localSession.uFileSizeSrc = paramFileManagerEntity.fileSize;
      localSession.vFileMD5Src = HexUtil.hexStr2Bytes(paramFileManagerEntity.strFileMd5);
      if ((QLog.isDevelopLevel()) && (paramFileManagerEntity.strFileMd5 != null)) {
        QLog.d("DataLineHandler.NFRV", 4, "getSessionFromMsgRecord, uSessionID[" + paramFileManagerEntity.nSessionId + "], strMR[" + paramFileManagerEntity.strFileMd5 + "], filesize[" + paramFileManagerEntity.fileSize);
      }
      localSession.actionInfo = null;
      return localSession;
      if (paramFileManagerEntity.nFileType == 0) {
        localSession.emFileType = 1;
      } else {
        localSession.emFileType = 0;
      }
    }
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
    VFSFile localVFSFile;
    if (i >= 0)
    {
      str2 = paramString.substring(0, i);
      str1 = paramString.substring(i);
      i = 1;
      localVFSFile = new VFSFile(paramString);
    }
    int j;
    for (;;)
    {
      if (i > 512)
      {
        return str2 + "(" + System.currentTimeMillis() + ")" + str1;
        str1 = "";
        str2 = paramString;
        break;
      }
      j = i;
      if (!localVFSFile.exists()) {
        break label209;
      }
      paramString = str2 + "(" + i + ")" + str1;
      localVFSFile = new VFSFile(paramString);
      i += 1;
    }
    while (c(paramString))
    {
      paramString = str2 + "(" + j + ")" + str1;
      j += 1;
      label209:
      if (j > 512) {
        return str2 + "(" + System.currentTimeMillis() + ")" + str1;
      }
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
    paramInt1 = 1;
    if (paramInt2 == 3) {
      paramInt1 = 1001;
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
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        return;
        if (paramInt != 0) {
          break;
        }
        localDataLineMsgRecord.thumbPath = paramString;
      } while (localDataLineMsgRecord.isSend());
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "uSessionID[" + paramLong + "]OnSessionThumbUpdate: update");
      }
      a(10, true, new Object[] { Long.valueOf(paramLong) });
      return;
      if (paramInt == 1)
      {
        localDataLineMsgRecord.serverPath = paramString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(localDataLineMsgRecord.msgId, localDataLineMsgRecord.serverPath, localDataLineMsgRecord.md5);
        return;
      }
    } while (paramInt != 2);
    localDataLineMsgRecord.md5 = HexUtil.hexStr2Bytes(paramString);
    if ((QLog.isDevelopLevel()) && (localDataLineMsgRecord.md5 != null)) {
      QLog.d("DataLineHandler", 4, "SessionUpdateType_FileMD5, uSessionID[" + paramLong + "], strValuebuf[" + paramString + "], strMD5MR[" + HexUtil.bytes2HexStr(localDataLineMsgRecord.md5) + "], strMD5Notify" + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(localDataLineMsgRecord.msgId, localDataLineMsgRecord.serverPath, localDataLineMsgRecord.md5);
  }
  
  private void a(int paramInt1, FTNNotify paramFTNNotify, long paramLong, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFTNNotify(paramFTNNotify, paramLong, this.jdField_a_of_type_JavaLangString, paramInt2);
    a(paramInt1, 1004, localMsgBody, paramFTNNotify.uint64_sessionid);
  }
  
  private void a(int paramInt1, FileControl paramFileControl, long paramLong, int paramInt2)
  {
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      return;
    }
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFileControl(paramFileControl, paramLong, this.jdField_a_of_type_JavaLangString, paramInt2);
    a(paramInt1, 1005, localMsgBody, paramFileControl.uint64_sessionid);
  }
  
  private void a(int paramInt, MsgCSBody0x211 paramMsgCSBody0x211)
  {
    switch (paramMsgCSBody0x211.uMsgSubType)
    {
    default: 
      QLog.d("DataLineHandler", 1, "SendPbMsg: cannot recognize the pb msg form 0X211");
      return;
    }
    a(paramInt, paramMsgCSBody0x211.msgBody0x211_0x7);
  }
  
  private void a(int paramInt, MsgCSBody0x211_0x7 paramMsgCSBody0x211_0x7)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i = 0;
    long l = paramMsgCSBody0x211_0x7.msgHeader.uint64_dst_uin;
    switch (paramMsgCSBody0x211_0x7.uMsgSubCmd)
    {
    }
    for (;;)
    {
      QLog.d("DataLineHandler", 1, "SendPbMsg: cannot recognize the pb msg form 0X211_0x7");
      for (;;)
      {
        return;
        while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc.length)
        {
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc[i], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          i += 1;
        }
        continue;
        while (j < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc.length)
        {
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc[j], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          j += 1;
        }
        continue;
        while (k < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl.length)
        {
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl[k], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          k += 1;
        }
        continue;
        while (m < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb.length)
        {
          paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[m].bytes_originfile_md5 = null;
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[m], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          m += 1;
        }
        continue;
        while (n < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb.length)
        {
          paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[n].bytes_originfile_md5 = null;
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[n], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          n += 1;
        }
      }
      while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x8_RFCInfoNotiy.length)
      {
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x8_RFCInfoNotiy[i1], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
        i1 += 1;
      }
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
    if (paramDataLineMsgRecord.isSend()) {
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
        if ((paramDataLineMsgRecord.nSessionState == 2) && (com.tencent.mobileqq.filemanager.util.FileUtil.a(paramDataLineMsgRecord.path))) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).b(paramDataLineMsgRecord.msgId, paramDataLineMsgRecord.path);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006223", "0X8006223", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      paramDataLineMsgRecord.nSessionState = 1;
      return;
      if ((paramInt2 == 32) || (paramInt2 == 11) || (paramInt2 == 8))
      {
        paramDataLineMsgRecord.fileMsgStatus = 2L;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).d(paramDataLineMsgRecord.msgId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).c(paramDataLineMsgRecord.msgId);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006224", "0X8006224", 0, 0, "", "", "", "");
      }
      else
      {
        paramDataLineMsgRecord.fileMsgStatus = 0L;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).d(paramDataLineMsgRecord.msgId);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).c(paramDataLineMsgRecord.msgId);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006224", "0X8006224", 0, 0, "", "", "", "");
        continue;
        if (paramInt2 == 2)
        {
          paramDataLineMsgRecord.fileMsgStatus = 0L;
          e(paramDataLineMsgRecord);
          if (!TextUtils.isEmpty(paramDataLineMsgRecord.thumbPath)) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).a(paramDataLineMsgRecord.msgId, paramDataLineMsgRecord.thumbPath);
          }
          String str = FilePathUtil.a(paramDataLineMsgRecord.path);
          if (str != null)
          {
            FileUtils.e(paramDataLineMsgRecord.path);
            paramDataLineMsgRecord.path = str;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).b(paramDataLineMsgRecord.msgId, str);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).d(paramDataLineMsgRecord.msgId);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).b(paramDataLineMsgRecord.msgId);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).c();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006226", "0X8006226", 0, 0, "", "", "", "");
        }
        else if ((paramInt2 == 32) || (paramInt2 == 11) || (paramInt2 == 8))
        {
          paramDataLineMsgRecord.fileMsgStatus = 2L;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).d(paramDataLineMsgRecord.msgId);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).c(paramDataLineMsgRecord.msgId);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006227", "0X8006227", 0, 0, "", "", "", "");
        }
        else
        {
          if ((paramInt2 == 41) && (paramDataLineMsgRecord.fileMsgStatus == 1L) && (!paramDataLineMsgRecord.bIsTransfering))
          {
            QLog.w("DataLineHandler", 1, "uSessionID[" + paramDataLineMsgRecord.sessionid + "]_onSessionComplete. net fail. but comingfile is no start transfer");
            return;
          }
          paramDataLineMsgRecord.fileMsgStatus = 0L;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).d(paramDataLineMsgRecord.msgId);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt1).c(paramDataLineMsgRecord.msgId);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006227", "0X8006227", 0, 0, "", "", "", "");
        }
      }
    }
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
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        return;
        if ((!localDataLineMsgRecord.isSend()) || (localDataLineMsgRecord.fileFrom != 0)) {
          break label266;
        }
        if (paramInt != 2) {
          break;
        }
        a(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Float.valueOf(1.0F) });
        a(2, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      } while (paramLong <= 0L);
      FileManagerEntity localFileManagerEntity = localDataLineMsgRecord.trans2Entity();
      if ((localFileManagerEntity != null) && (localFileManagerEntity.fileSize <= 20971520L))
      {
        ((DataLineMessageSpreadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER_DATALINE)).a(localDataLineMsgRecord, i);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AIOMessageSpreadManager", 1, "can't find File Msg sID:");
    return;
    if ((paramInt == 32) || (paramInt == 11) || (paramInt == 8))
    {
      a(2, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      return;
    }
    a(2, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
    return;
    label266:
    if (paramInt == 2)
    {
      a(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Float.valueOf(1.0F) });
      a(3, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      return;
    }
    if ((paramInt == 32) || (paramInt == 11) || (paramInt == 8))
    {
      a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      return;
    }
    a(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 == 0L) {}
    for (float f1 = 0.0F;; f1 = (float)paramLong2 / (float)paramLong3)
    {
      int i = DataLineMsgRecord.getDevTypeBySeId(paramLong1);
      DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(paramLong1);
      if (localDataLineMsgRecord != null) {
        localDataLineMsgRecord.progress = f1;
      }
      a(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong1), Float.valueOf(f1) });
      return;
    }
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramSession.uSessionID);
    if (localFileManagerEntity == null)
    {
      localFileManagerEntity = new FileManagerEntity();
      localFileManagerEntity.nSessionId = paramSession.uSessionID;
      localFileManagerEntity.strFilePath = paramSession.strFilePathSrc;
      localFileManagerEntity.strMiddleThumPath = paramSession.strFilePathThumb;
      localFileManagerEntity.fileName = paramSession.strFileNameSrc;
      localFileManagerEntity.strFileMd5 = HexUtil.bytes2HexStr(paramSession.vFileMD5Src);
      localFileManagerEntity.fileSize = paramSession.uFileSizeSrc;
      localFileManagerEntity.uniseq = FileManagerUtil.a().longValue();
      localFileManagerEntity.msgSeq = FileManagerUtil.a();
      localFileManagerEntity.peerUin = QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localFileManagerEntity.peerType = 0;
      localFileManagerEntity.bDelInFM = true;
      localFileManagerEntity.bSend = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
    }
    for (;;)
    {
      localFileManagerEntity.dlGourpIndex = paramSession.dwGroupIndex;
      localFileManagerEntity.dlGroupCount = paramSession.dwGroupSize;
      localFileManagerEntity.dlGroupId = paramSession.dwGroupID;
      localFileManagerEntity.nfcServerIP = paramNFCInfo.dwServerIP;
      localFileManagerEntity.nfcServerPort = paramNFCInfo.wServerPort;
      localFileManagerEntity.nfcTokenKey = ((byte[])paramNFCInfo.vTokenKey.clone());
      localFileManagerEntity.nfcUrlNotify = ((byte[])paramNFCInfo.vUrlNotify.clone());
      localFileManagerEntity.cloudType = 11;
      localFileManagerEntity.status = 2;
      localFileManagerEntity.mContext = Integer.valueOf(a(paramSession.msgHeader));
      QLog.i("DataLineHandler.NFRV", 1, "recvByNewFileassistant:" + localFileManagerEntity.nSessionId + ",gip:" + localFileManagerEntity.nfcServerIP + ",gport:" + localFileManagerEntity.nfcServerPort);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().c(localFileManagerEntity);
      return;
    }
  }
  
  private void a(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo, boolean paramBoolean)
  {
    if (paramSession == null) {}
    int j;
    DataLineMsgRecord localDataLineMsgRecord;
    int i;
    label105:
    label122:
    do
    {
      return;
      j = DataLineMsgRecord.getDevTypeBySeId(paramSession.uSessionID);
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(j).a(paramSession.uSessionID);
      if (localDataLineMsgRecord != null) {
        break label609;
      }
      localDataLineMsgRecord = new DataLineMsgRecord();
      localDataLineMsgRecord.msg = "";
      localDataLineMsgRecord.msgtype = a(paramSession.emFileType);
      localDataLineMsgRecord.sessionid = paramSession.uSessionID;
      if (!paramSession.bSend) {
        break;
      }
      i = 1;
      localDataLineMsgRecord.issend = i;
      if (!paramSession.bSend) {
        break label536;
      }
      bool = true;
      localDataLineMsgRecord.isread = bool;
      if (!paramSession.bSend) {
        break label542;
      }
      i = 0;
      localDataLineMsgRecord.nOpType = i;
      localDataLineMsgRecord.path = paramSession.strFilePathSrc;
      localDataLineMsgRecord.fileFrom = paramSession.emFileFrom;
      if (paramSession.vOfflineFileUUID != null) {
        localDataLineMsgRecord.fileUuid = new String(paramSession.vOfflineFileUUID);
      }
      localDataLineMsgRecord.uOwnerUin = paramSession.uOwnerUin;
      localDataLineMsgRecord.thumbPath = paramSession.strFilePathThumb;
      localDataLineMsgRecord.md5 = paramSession.vFileMD5Src;
      if (paramNFCInfo != null)
      {
        localDataLineMsgRecord.nServerIp = paramNFCInfo.dwServerIP;
        localDataLineMsgRecord.nServerPort = paramNFCInfo.wServerPort;
        localDataLineMsgRecord.vUrlNotify = paramNFCInfo.vUrlNotify;
        localDataLineMsgRecord.vTokenKey = paramNFCInfo.vTokenKey;
      }
      if (paramFTNInfo != null) {
        localDataLineMsgRecord.serverPath = paramFTNInfo.strFileIndex;
      }
    } while (localDataLineMsgRecord.path == null);
    if ((paramSession.strFileNameSrc != null) && (paramSession.strFileNameSrc.length() > 0))
    {
      localDataLineMsgRecord.filename = paramSession.strFileNameSrc;
      label286:
      localDataLineMsgRecord.filesize = paramSession.uFileSizeSrc;
      localDataLineMsgRecord.issuc = false;
      localDataLineMsgRecord.vipBubbleID = b();
      localDataLineMsgRecord.time = paramSession.uMsgTime;
      localDataLineMsgRecord.groupId = paramSession.dwGroupID;
      localDataLineMsgRecord.groupSize = paramSession.dwGroupSize;
      localDataLineMsgRecord.groupIndex = paramSession.dwGroupIndex;
      localDataLineMsgRecord.progress = 0.0F;
      if (!paramBoolean) {
        break label579;
      }
      localDataLineMsgRecord.fileMsgStatus = 0L;
      label365:
      paramNFCInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(j);
      if (paramSession.bSend) {
        break label603;
      }
    }
    label536:
    label542:
    label579:
    label603:
    for (boolean bool = true;; bool = false)
    {
      for (;;)
      {
        paramNFCInfo.a(localDataLineMsgRecord, bool);
        paramNFCInfo = localDataLineMsgRecord;
        paramNFCInfo.issuc = true;
        paramNFCInfo.bIsTransfering = paramBoolean;
        if ((paramBoolean) && (paramNFCInfo.nSessionState != 1) && ((!paramNFCInfo.isSend()) || (!FileManagerUtil.b(paramNFCInfo.path)))) {
          b(paramNFCInfo.path);
        }
        if (!paramSession.bSend) {
          break label677;
        }
        a(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramSession.uSessionID), paramSession.strFilePathSrc, Byte.valueOf((byte)paramSession.emFileType), Boolean.valueOf(false), Boolean.valueOf(paramBoolean), Long.valueOf(paramNFCInfo.filesize) });
        return;
        i = 0;
        break;
        bool = false;
        break label105;
        i = 1;
        break label122;
        try
        {
          localDataLineMsgRecord.filename = new File(localDataLineMsgRecord.path).getName();
        }
        catch (Exception paramNFCInfo)
        {
          paramNFCInfo.printStackTrace();
        }
      }
      break label286;
      localDataLineMsgRecord.fileMsgStatus = 2L;
      if (paramSession.bSend) {
        break label365;
      }
      localDataLineMsgRecord.fileMsgStatus = 1L;
      break label365;
    }
    label609:
    if (paramBoolean) {}
    for (localDataLineMsgRecord.fileMsgStatus = 0L;; localDataLineMsgRecord.fileMsgStatus = 2L)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(j).d(localDataLineMsgRecord.msgId);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(j).c(localDataLineMsgRecord.msgId);
      paramNFCInfo = localDataLineMsgRecord;
      break;
    }
    label677:
    if (!paramBoolean)
    {
      paramFTNInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(j).b(paramSession.uSessionID);
      if ((paramFTNInfo == null) || (!DataLineMsgSet.isSingle(paramFTNInfo))) {
        break label788;
      }
      j();
    }
    for (;;)
    {
      a(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramSession.uSessionID), paramSession.strFilePathSrc, Byte.valueOf((byte)paramSession.emFileType), Boolean.valueOf(false), Boolean.valueOf(paramBoolean), Long.valueOf(paramNFCInfo.filesize) });
      return;
      label788:
      paramFTNInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(j).a(paramSession.dwGroupID);
      if ((paramFTNInfo == null) || (paramFTNInfo.getComeCount() == 1)) {
        j();
      }
    }
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
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 1329	java/io/BufferedWriter
    //   8: dup
    //   9: new 1331	java/io/OutputStreamWriter
    //   12: dup
    //   13: new 1333	java/io/FileOutputStream
    //   16: dup
    //   17: aload_2
    //   18: iconst_0
    //   19: invokespecial 1336	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   22: invokespecial 1339	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   25: invokespecial 1342	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   28: astore_2
    //   29: aload_2
    //   30: astore_3
    //   31: aload_2
    //   32: aload_1
    //   33: invokevirtual 1345	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   36: aload_2
    //   37: ifnull +7 -> 44
    //   40: aload_2
    //   41: invokevirtual 1348	java/io/BufferedWriter:close	()V
    //   44: return
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual 1349	java/io/IOException:printStackTrace	()V
    //   50: return
    //   51: astore_1
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: astore_3
    //   56: ldc_w 304
    //   59: iconst_1
    //   60: ldc_w 1351
    //   63: invokestatic 379	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_2
    //   67: astore_3
    //   68: aload_1
    //   69: invokevirtual 1352	java/io/FileNotFoundException:printStackTrace	()V
    //   72: aload_2
    //   73: ifnull -29 -> 44
    //   76: aload_2
    //   77: invokevirtual 1348	java/io/BufferedWriter:close	()V
    //   80: return
    //   81: astore_1
    //   82: aload_1
    //   83: invokevirtual 1349	java/io/IOException:printStackTrace	()V
    //   86: return
    //   87: astore_2
    //   88: aload 4
    //   90: astore_1
    //   91: aload_1
    //   92: astore_3
    //   93: ldc_w 304
    //   96: iconst_1
    //   97: ldc_w 1354
    //   100: invokestatic 379	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_1
    //   104: astore_3
    //   105: aload_2
    //   106: invokevirtual 1349	java/io/IOException:printStackTrace	()V
    //   109: aload_1
    //   110: ifnull -66 -> 44
    //   113: aload_1
    //   114: invokevirtual 1348	java/io/BufferedWriter:close	()V
    //   117: return
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 1349	java/io/IOException:printStackTrace	()V
    //   123: return
    //   124: astore_1
    //   125: aload_3
    //   126: ifnull +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 1348	java/io/BufferedWriter:close	()V
    //   133: aload_1
    //   134: athrow
    //   135: astore_2
    //   136: aload_2
    //   137: invokevirtual 1349	java/io/IOException:printStackTrace	()V
    //   140: goto -7 -> 133
    //   143: astore_1
    //   144: goto -19 -> 125
    //   147: astore_3
    //   148: aload_2
    //   149: astore_1
    //   150: aload_3
    //   151: astore_2
    //   152: goto -61 -> 91
    //   155: astore_1
    //   156: goto -102 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	DataLineHandler
    //   0	159	1	paramString	String
    //   0	159	2	paramFile	File
    //   1	129	3	localObject1	Object
    //   147	4	3	localIOException	java.io.IOException
    //   3	86	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	44	45	java/io/IOException
    //   5	29	51	java/io/FileNotFoundException
    //   76	80	81	java/io/IOException
    //   5	29	87	java/io/IOException
    //   113	117	118	java/io/IOException
    //   5	29	124	finally
    //   93	103	124	finally
    //   105	109	124	finally
    //   129	133	135	java/io/IOException
    //   31	36	143	finally
    //   56	66	143	finally
    //   68	72	143	finally
    //   31	36	147	java/io/IOException
    //   31	36	155	java/io/FileNotFoundException
  }
  
  private void a(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.FileControl> paramList)
  {
    paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromFileControl(paramMsgHeader, paramList);
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
  }
  
  public static void a(SubMsgType0x7.MsgBody paramMsgBody, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    if (!QFileAssistantUtils.a()) {
      QLog.i("DataLineHandler", 1, "isNot new FileAssistant");
    }
    label129:
    for (;;)
    {
      return;
      int i;
      if (paramMsgBody.uint32_sub_cmd.has())
      {
        i = paramMsgBody.uint32_sub_cmd.get();
        if (i != 1) {
          break label66;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label129;
        }
        paramPbSendMsgReq.routing_head.trans_0x211.dataline_flag.set(1);
        return;
        i = -1;
        break;
        label66:
        if ((i == 4) && (((SubMsgType0x7.MsgBody.GenericSubCmd)paramMsgBody.msg_subcmd_0x4_generic.get()).uint32_type.has()) && (((SubMsgType0x7.MsgBody.GenericSubCmd)paramMsgBody.msg_subcmd_0x4_generic.get()).uint32_type.get() == 1)) {
          i = 1;
        } else if (i == 9) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
  }
  
  static boolean a(Session paramSession, String paramString)
  {
    if (paramSession != null) {
      if ((paramString == null) || (paramString.length() == 0))
      {
        if ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.length() != 0)) {}
      }
      else {
        while ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.equals(paramString))) {
          return true;
        }
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
    int j = 0;
    int i = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    int m = paramTextMsgTask.a(localStringBuffer);
    if (m == -1) {
      return false;
    }
    int k;
    if (this.jdField_a_of_type_Int == 0) {
      while (i < localStringBuffer.length())
      {
        j = i;
        if (localStringBuffer.charAt(i) == '\024')
        {
          j = i;
          if (i < localStringBuffer.length() - 1)
          {
            k = QQSysFaceUtil.convertToServer(localStringBuffer.charAt(i + 1));
            j = i;
            if (k >= 0)
            {
              localStringBuffer.setCharAt(i + 1, (char)k);
              j = i + 1;
            }
          }
        }
        i = j + 1;
      }
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      i = j;
      for (;;)
      {
        if (i < localStringBuffer.length())
        {
          k = i;
          String str;
          if (localStringBuffer.charAt(i) == '\024')
          {
            k = i;
            if (i < localStringBuffer.length() - 1)
            {
              k = localStringBuffer.charAt(i + 1);
              j = k;
              if (k == 250) {
                j = 10;
              }
              k = i;
              if (j >= 0)
              {
                k = i;
                if (j < EmotcationConstants.SYS_EMOTICON_SYMBOL.length) {
                  str = EmotcationConstants.SYS_EMOTICON_SYMBOL[j];
                }
              }
            }
          }
          try
          {
            localStringBuffer.replace(i + 1, i + 2, str);
            k = i + str.length();
            i = k + 1;
          }
          catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
          {
            for (;;)
            {
              localStringIndexOutOfBoundsException.printStackTrace();
              QLog.d("DataLineHandler", 2, "SendSubText ipad emoj fail", localStringIndexOutOfBoundsException);
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
    switch (paramInt)
    {
    default: 
      return 0;
    case -2000: 
      return 1;
    }
    return 2;
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "";
      return paramString;
    }
    int i = paramString.lastIndexOf(".");
    String str1;
    String str2;
    if (i >= 0)
    {
      str1 = paramString.substring(0, i);
      str2 = paramString.substring(i);
      paramString = str1;
    }
    for (;;)
    {
      paramString.replace('\\', '_');
      paramString.replace('/', '_');
      paramString.replace(':', '_');
      paramString.replace('*', '_');
      paramString.replace('?', '_');
      paramString.replace('"', '_');
      paramString.replace('<', '_');
      paramString.replace('>', '_');
      paramString.replace('|', '_');
      str1 = paramString;
      if (paramString.length() > 53) {
        str1 = paramString.substring(0, 53);
      }
      paramString = str1;
      if (TextUtils.isEmpty(str2)) {
        break;
      }
      return str1 + "." + str2;
      str2 = "";
    }
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
        QLog.i("DataLineHandler", 1, "addRecvingFilePath[" + paramString + " size:" + this.jdField_a_of_type_JavaUtilSet.size());
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
    boolean bool = true;
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.showNoNetworkDialog();
    }
    while (paramArrayList.size() == 0) {
      return;
    }
    LiteTransferWrapper localLiteTransferWrapper = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
    if (paramArrayList.size() == 1) {
      bool = false;
    }
    localLiteTransferWrapper.SendGroup(paramArrayList, paramBoolean, bool);
  }
  
  private void c(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if ((paramDataLineMsgRecord == null) || (!TextUtils.isEmpty(paramDataLineMsgRecord.path))) {
      return;
    }
    String str2 = b(paramDataLineMsgRecord.filename);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      long l = System.currentTimeMillis();
      str1 = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(l));
    }
    str2 = FMSettings.a().b();
    str2 = str2 + str1;
    str1 = str2;
    if (FileUtils.a(str2)) {
      str1 = a(str2);
    }
    paramDataLineMsgRecord.path = str1;
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
    paramToServiceMsg.path = (AppConstants.SDCARD_FILE_SAVE_PATH + paramToServiceMsg.filename);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (int i = 2;; i = 36)
    {
      a(j, paramToServiceMsg, i);
      new Handler(Looper.getMainLooper()).post(new DataLineHandler.8(this, l, i));
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    paramObject = new MsgSCBody();
    paramObject.uMsgType = 529;
    paramObject.msgBody0x211 = new MsgSCBody0x211();
    paramObject.msgBody0x211.uMsgSubType = 7;
    paramObject.msgBody0x211.msgBody0x211_0x7 = new MsgSCBody0x211_0x7();
    Long localLong = (Long)paramToServiceMsg.getAttribute("cookie");
    MsgSCBody0x211_0x7 localMsgSCBody0x211_0x7;
    if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "handleFTNNotify " + localLong.intValue() + " 发送信令，发送失败");
      }
      paramObject.bTimeOut = true;
      if (paramFromServiceMsg != null)
      {
        localMsgSCBody0x211_0x7 = paramObject.msgBody0x211.msgBody0x211_0x7;
        if (!paramFromServiceMsg.isSuccess()) {
          break label235;
        }
      }
    }
    for (;;)
    {
      localMsgSCBody0x211_0x7.uResult = i;
      if (!((Boolean)paramToServiceMsg.getAttribute("sendFromNative", Boolean.valueOf(true))).booleanValue()) {
        break label241;
      }
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(localLong.intValue(), paramObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "handleFTNNotify " + localLong.intValue() + " 发送信令，发送成功");
      }
      paramObject.bTimeOut = false;
      break;
      label235:
      i = 1;
    }
    label241:
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void c(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString)))
      {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
        QLog.i("DataLineHandler", 1, "remRecvingFilePath[" + paramString + " size:" + this.jdField_a_of_type_JavaUtilSet.size());
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
    paramList = paramList.iterator();
    Object localObject;
    DataLineMsgRecord localDataLineMsgRecord;
    int i;
    while (paramList.hasNext())
    {
      localObject = (SubMsgType0x7.MsgBody.MoloNotify)paramList.next();
      if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).bytes_buf.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "应用宝消息  moloHandler SubCmd0x5 do not has bytes_buf");
        }
      }
      else
      {
        localDataLineMsgRecord = this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(((SubMsgType0x7.MsgBody.MoloNotify)localObject).bytes_buf.get().toByteArray());
        if (localDataLineMsgRecord == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "应用宝消息 moloHandler dealWith return null");
          }
        }
        else
        {
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_id.has()) {
            break label357;
          }
          i = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_id.get();
          localDataLineMsgRecord.groupId = i;
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_size.has()) {
            break label362;
          }
          i = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_size.get();
          label147:
          localDataLineMsgRecord.groupSize = i;
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_curindex.has()) {
            break label367;
          }
          i = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_curindex.get();
          label173:
          localDataLineMsgRecord.groupIndex = i;
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "应用宝消息 groupId[" + localDataLineMsgRecord.groupId + "],size[" + localDataLineMsgRecord.groupSize + "],index[" + localDataLineMsgRecord.groupIndex + "], sessionid[" + localDataLineMsgRecord.sessionid + "], key[" + localDataLineMsgRecord.strMoloKey);
          }
          if (localDataLineMsgRecord.groupSize == 1)
          {
            localDataLineMsgRecord.groupId = 0;
            localDataLineMsgRecord.groupSize = 0;
            localDataLineMsgRecord.groupIndex = 0;
          }
          if ((DataLineMsgSet.isSingle(localDataLineMsgRecord)) || (!c(localDataLineMsgRecord.groupId))) {
            break label372;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "应用宝消息msg record in deleted group, sessionid[" + localDataLineMsgRecord.sessionid);
          }
        }
      }
    }
    label357:
    label362:
    label367:
    label372:
    int j;
    do
    {
      return;
      i = 0;
      break;
      i = 0;
      break label147;
      i = 0;
      break label173;
      j = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
      a().getMessageFacade().a(j).a(localDataLineMsgRecord, true);
      if ((DataLineMsgSet.isSingle(localDataLineMsgRecord)) || (!c(localDataLineMsgRecord.groupId))) {
        break label484;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "应用宝消息 msg record in deleted group 2, sessionid[" + localDataLineMsgRecord.sessionid);
      }
      paramList = a().getDataLineMsgProxy(j).a(localDataLineMsgRecord.sessionid);
    } while (paramList == null);
    a(paramList);
    return;
    label484:
    label503:
    boolean bool;
    if (DataLineMsgSet.isSingle(localDataLineMsgRecord))
    {
      DataLineReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      j();
      bool = false;
      if (!a(localDataLineMsgRecord.sessionid, localDataLineMsgRecord.groupId)) {
        break label644;
      }
    }
    for (;;)
    {
      a(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(bool), Long.valueOf(localDataLineMsgRecord.filesize) });
      break;
      localObject = a().getDataLineMsgProxy(j).a(localDataLineMsgRecord.groupId);
      if ((localObject != null) && (((DataLineMsgSet)localObject).getComeCount() != 1)) {
        break label503;
      }
      DataLineReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      j();
      break label503;
      label644:
      localDataLineMsgRecord.issuc = true;
      localDataLineMsgRecord.fileMsgStatus = 1L;
      bool = NetworkUtil.h(BaseApplication.getContext());
      if (localDataLineMsgRecord.filesize <= 3145728L)
      {
        i = 1;
        label678:
        if ((!bool) && ((!getAutoDownload()) || (i == 0))) {
          break label761;
        }
        bool = true;
        if (bool) {
          localDataLineMsgRecord.fileMsgStatus = 0L;
        }
      }
      try
      {
        b(111);
        this.jdField_a_of_type_ComDatalineCoreMoloHandler.a(localDataLineMsgRecord.strMoloKey);
        DataLineReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        label734:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(j).d(localDataLineMsgRecord.msgId);
        continue;
        i = 0;
        break label678;
        label761:
        bool = false;
      }
      catch (Exception localException)
      {
        break label734;
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
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((TextMsgTask)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a().equals(paramToServiceMsg)) {}
    }
    for (paramToServiceMsg = (TextMsgTask)this.jdField_a_of_type_JavaUtilArrayList.get(i);; paramToServiceMsg = null)
    {
      if (paramToServiceMsg == null) {}
      do
      {
        return;
        i += 1;
        break;
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
      } while (a(paramToServiceMsg));
      paramToServiceMsg.a().issuc = false;
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramToServiceMsg);
      a(1, false, new Object[] { paramToServiceMsg.a(), paramToServiceMsg.a() });
      return;
    }
  }
  
  public static boolean d(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return false;
    }
    return true;
  }
  
  private void e(DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str = paramDataLineMsgRecord.path;
    if (FileManagerUtil.a(str) != 0) {}
    do
    {
      do
      {
        return;
      } while (FileUtils.b(paramDataLineMsgRecord.thumbPath));
      str = FileManagerUtil.a(str, 384, 384, null);
    } while (TextUtils.isEmpty(str));
    paramDataLineMsgRecord.thumbPath = str;
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
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_PC_STATE";
    if (localSharedPreferences.contains(str))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Long = localSharedPreferences.getLong(str, 0L);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void i()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_IPAD_STATE";
    if (localSharedPreferences.contains(str))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_Long = localSharedPreferences.getLong(str, 0L);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Boolean == true) {}
    for (boolean bool = false;; bool = true)
    {
      a().handleReceivedMessage(1, bool, false);
      return;
    }
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
    if ((localFile == null) || (!localFile.exists()))
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
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "uGroupID[" + paramInt1 + "]OnGroupComplete 分组结束 emGroupStatus[" + paramInt2 + "]");
    }
    if (paramInt1 == 0) {}
    DataLineMsgSet localDataLineMsgSet1;
    do
    {
      return;
      DataLineMsgSet localDataLineMsgSet2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(0).a(paramInt1);
      localDataLineMsgSet1 = localDataLineMsgSet2;
      if (localDataLineMsgSet2 == null) {
        localDataLineMsgSet1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(1).a(paramInt1);
      }
    } while (localDataLineMsgSet1 == null);
    localDataLineMsgSet1.setTimeOut();
    a(11, true, null);
  }
  
  public void OnGroupStart(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "uGroupID[" + paramInt + "]OnGroupStart 分组开始");
    }
    a(11, true, null);
  }
  
  public boolean OnQueryAutoDownload(long paramLong, byte paramByte)
  {
    boolean bool1;
    boolean bool2;
    if (paramByte == 2)
    {
      bool1 = NetworkUtil.h(BaseApplication.getContext());
      bool2 = QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
    }
    return (bool1) || ((bool2) && (getAutoDownload()));
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
    if (paramInt1 == 2) {}
    for (boolean bool = true;; bool = false)
    {
      a(16, bool, localObject);
      return;
    }
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
    if (paramSession.bSend)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006222", "0X8006222", 0, 0, "", "", "", "");
      if ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.length() != 0)) {
        break label257;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "uSessionID[" + paramSession.uSessionID + "]OnSessionNew Session创建");
      }
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() == localLooper.getThread()) {
        break label246;
      }
      new Handler(localLooper).post(new DataLineHandler.11(this, paramSession, paramNFCInfo, paramFTNInfo));
    }
    for (;;)
    {
      a(paramSession);
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006225", "0X8006225", 0, 0, "", "", "", "");
      break;
      label246:
      a(paramSession, paramNFCInfo, paramFTNInfo, false);
    }
    label257:
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramSession.uSessionID), paramSession);
    a(17, true, paramSession);
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
    a(15, true, new Object[] { localObject, Float.valueOf((float)((float)paramLong2 * 1.0D / (float)paramLong3)) });
  }
  
  public void OnSessionStart(long paramLong)
  {
    Object localObject = (Session)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "uSessionID[" + paramLong + "], OnSessionStart, Session开始");
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
    QLog.d("DataLineHandler", 1, "SendPbMsg: msgBody.uMsgType " + paramMsgCSBody.uMsgType);
    switch (paramMsgCSBody.uMsgType)
    {
    default: 
      QLog.d("DataLineHandler", 1, "SendPbMsg: cannot recognize the pb msg form JNI, cmd[" + paramMsgCSBody.uMsgType);
      return;
    case 529: 
      a(paramInt, paramMsgCSBody.msgBody0x211);
      return;
    case 838: 
      a(paramInt, paramMsgCSBody.msgBody0x346, null);
      return;
    }
    a(paramInt, paramMsgCSBody.msgBody0x345);
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
      QLog.e("DataLineHandler", 1, "native genGroupId failed");
      return 0;
    }
    catch (Exception localException) {}
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
    String str = paramFileManagerEntity.fileName + "\n";
    paramFileManagerEntity = str + paramFileManagerEntity.Uuid + "\n";
    return a(paramFileManagerEntity + "来自:腾讯文档", 0).longValue();
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
    boolean bool = true;
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = a().getMessageFacade().a(i).a(paramLong);
    if (localDataLineMsgRecord == null) {
      return null;
    }
    Session localSession = new Session();
    localSession.uSessionID = localDataLineMsgRecord.sessionid;
    if (localDataLineMsgRecord.issend == 1) {}
    for (;;)
    {
      localSession.bSend = bool;
      i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
      localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), i);
      localSession.dwGroupID = localDataLineMsgRecord.groupId;
      localSession.dwGroupSize = localDataLineMsgRecord.groupSize;
      localSession.dwGroupIndex = localDataLineMsgRecord.groupIndex;
      localSession.emFileType = b(localDataLineMsgRecord.msgtype);
      localSession.strFilePathSrc = FilePathUtil.c(localDataLineMsgRecord.path);
      localSession.strFilePathThumb = localDataLineMsgRecord.thumbPath;
      localSession.uFileSizeSrc = localDataLineMsgRecord.filesize;
      localSession.vFileMD5Src = localDataLineMsgRecord.md5;
      if ((QLog.isDevelopLevel()) && (localDataLineMsgRecord.md5 != null)) {
        QLog.d("DataLineHandler", 4, "getSessionFromMsgRecord, uSessionID[" + localDataLineMsgRecord.sessionid + "], strMR[" + HexUtil.bytes2HexStr(localDataLineMsgRecord.md5) + "], filesize[" + localDataLineMsgRecord.filesize);
      }
      localSession.actionInfo = null;
      return localSession;
      bool = false;
    }
  }
  
  public Session a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    int i = 0;
    if (paramFileManagerEntity.nFileType == 0) {
      i = 1;
    }
    ArrayList localArrayList;
    Object localObject;
    for (;;)
    {
      localArrayList = new ArrayList();
      localObject = paramFileManagerEntity.fileName;
      localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.strMiddleThumPath, (String)localObject, i, 1, paramFileManagerEntity.nSessionId, paramFileManagerEntity.dlGroupId, paramFileManagerEntity.dlGroupCount, paramFileManagerEntity.dlGourpIndex);
      if (localObject != null) {
        break;
      }
      return null;
      if (paramFileManagerEntity.nFileType == 2) {
        i = 2;
      }
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
    QLog.i("FileAssistantSender<FileAssistant>", 1, "doWlanSend[" + paramFileManagerEntity.nSessionId + "],Send fro Wlan target:" + this.jdField_c_of_type_Int);
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
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "send0x211C2CDatalineMsg DataLineMsgRecord:" + paramLong);
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
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "send0x211C2CDatalineMsg DataLineMsgRecord:" + paramLong2);
    }
    localObject = a((String)localObject, 7, arrayOfByte, paramLong2, i);
    a(paramMsgBody, (msg_svc.PbSendMsgReq)localObject);
    return a(true, paramInt, paramLong1, (msg_svc.PbSendMsgReq)localObject);
  }
  
  public ToServiceMsg a(long paramLong, MsgCSBody0x345 paramMsgCSBody0x345)
  {
    Object localObject = null;
    byte[] arrayOfByte = null;
    cmd0x345.ReqBody localReqBody = new cmd0x345.ReqBody();
    localReqBody.uint32_sub_cmd.set(paramMsgCSBody0x345.uMsgSubType);
    switch (paramMsgCSBody0x345.uMsgSubType)
    {
    default: 
      localObject = arrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "send0x345Req, unknwon nCmdType:" + paramMsgCSBody0x345.uMsgSubType);
      }
      break;
    }
    for (localObject = arrayOfByte;; localObject = createToServiceMsg("GTalkFileAppSvr.CMD_DISCUSS_FILE", null))
    {
      paramMsgCSBody0x345 = (MsgCSBody0x345)localObject;
      if (localObject != null)
      {
        paramMsgCSBody0x345 = localReqBody.toByteArray();
        arrayOfByte = new byte[paramMsgCSBody0x345.length + 4];
        PkgTools.DWord2Byte(arrayOfByte, 0, paramMsgCSBody0x345.length + 4);
        PkgTools.copyData(arrayOfByte, 4, paramMsgCSBody0x345, paramMsgCSBody0x345.length);
        ((ToServiceMsg)localObject).putWupBuffer(arrayOfByte);
        ((ToServiceMsg)localObject).addAttribute("cookie", Long.valueOf(paramLong));
        ((ToServiceMsg)localObject).extraData.putInt("DATALINE_TRYINDEX", 0);
        a((ToServiceMsg)localObject);
        paramMsgCSBody0x345 = (MsgCSBody0x345)localObject;
      }
      do
      {
        return paramMsgCSBody0x345;
        if (paramMsgCSBody0x345.subCmd0x6ReqBody != null) {
          break;
        }
        paramMsgCSBody0x345 = (MsgCSBody0x345)localObject;
      } while (!QLog.isColorLevel());
      QLog.d("DataLineHandler", 2, "send0x345Req, subCmd0x6ReqBody is empty");
      return null;
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
    }
  }
  
  public ToServiceMsg a(long paramLong, MsgCSBody0x346 paramMsgCSBody0x346, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(paramMsgCSBody0x346.uMsgSubType);
    localReqBody.uint32_business_id.set(paramMsgCSBody0x346.uint32_business_id);
    if (paramMsgCSBody0x346.uint32_business_id == 0) {
      localReqBody.uint32_business_id.set(38);
    }
    localReqBody.uint32_client_type.set(104);
    PBUInt32Field localPBUInt32Field = localReqBody.uint32_seq;
    int i = f;
    f = i + 1;
    localPBUInt32Field.set(i);
    if (!this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.FillReqBody(paramMsgCSBody0x346, localReqBody))
    {
      paramMsgCSBody0x346 = (MsgCSBody0x346)localObject1;
      return paramMsgCSBody0x346;
    }
    switch (paramMsgCSBody0x346.uMsgSubType)
    {
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("DataLineHandler", 2, "send0x346Req, unknwon nCmdType:" + paramMsgCSBody0x346.uMsgSubType);
        localObject1 = localObject2;
      }
      for (;;)
      {
        paramMsgCSBody0x346 = localReqBody.toByteArray();
        localObject2 = new byte[paramMsgCSBody0x346.length + 4];
        PkgTools.DWord2Byte((byte[])localObject2, 0, paramMsgCSBody0x346.length + 4);
        PkgTools.copyData((byte[])localObject2, 4, paramMsgCSBody0x346, paramMsgCSBody0x346.length);
        paramMsgCSBody0x346 = (MsgCSBody0x346)localObject1;
        if (localObject1 == null) {
          break;
        }
        ((ToServiceMsg)localObject1).putWupBuffer((byte[])localObject2);
        ((ToServiceMsg)localObject1).addAttribute("cookie", Long.valueOf(paramLong));
        ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_TRYINDEX", 0);
        if (paramBundle != null)
        {
          ((ToServiceMsg)localObject1).addAttribute("data", paramBundle);
          ((ToServiceMsg)localObject1).addAttribute("sendFromNative", Boolean.valueOf(false));
        }
        a((ToServiceMsg)localObject1);
        return localObject1;
        localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600", null);
        continue;
        localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", null);
        continue;
        localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800", null);
        continue;
        localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", null);
        continue;
        localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400", null);
      }
      localObject2 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", null);
    }
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
    PkgTools.DWord2Byte((byte[])localObject2, 0, localObject1.length + 4);
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
      QLog.e("DataLineHandler", 1, "genSessionId failed");
      return Long.valueOf(0L);
    }
    catch (Exception localException) {}
    return Long.valueOf(0L);
  }
  
  public Long a(String paramString, int paramInt)
  {
    if (paramString.length() == 0) {
      return Long.valueOf(0L);
    }
    Long localLong = a(0, paramInt);
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgId = localLong.longValue();
    localDataLineMsgRecord.sessionid = localLong.longValue();
    localDataLineMsgRecord.msg = paramString;
    localDataLineMsgRecord.msgtype = -1000;
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localDataLineMsgRecord);
    localDataLineMsgRecord.time = MessageCache.a();
    localDataLineMsgRecord.sessionid = localLong.longValue();
    localDataLineMsgRecord.progress = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramInt).a(localDataLineMsgRecord, false);
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      return Long.valueOf(0L);
    }
    localDataLineMsgRecord.issuc = true;
    paramString = new TextMsgTask(paramString, localLong, localDataLineMsgRecord);
    if (!a(paramString)) {
      return Long.valueOf(0L);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    return localLong;
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
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "manually cancel a file . session =" + paramLong);
    }
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(paramInt, paramLong, 32, paramBoolean);
      return;
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = a().getMessageFacade().a(i).a(paramLong);
    if (localDataLineMsgRecord == null)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(paramInt, paramLong, 32, paramBoolean);
      return;
    }
    localDataLineMsgRecord.fileMsgStatus = 2L;
    localDataLineMsgRecord.bIsTransfering = false;
    c(localDataLineMsgRecord.path);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).d(localDataLineMsgRecord.msgId);
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      this.jdField_a_of_type_ComDatalineCoreMoloHandler.c(localDataLineMsgRecord.strMoloKey);
      return;
    }
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(localDataLineMsgRecord.groupId, paramLong, 32, paramBoolean);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelAll(paramInt, paramBoolean);
    this.jdField_a_of_type_ComDatalineCoreMoloHandler.a();
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (((paramInt == 3) || (paramInt == 2) || (paramInt == 1) || (paramInt == 8)) && (!this.jdField_d_of_type_Boolean)) {}
    try
    {
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new DataLineHandler.4(this), 20000L);
      notifyUI(paramInt, paramBoolean, paramObject);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        localIllegalStateException.printStackTrace();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void a(long paramLong1, long paramLong2, SubMsgType0x7.MsgBody.GenericSubCmd paramGenericSubCmd, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader)
  {
    for (;;)
    {
      TextMsgPush localTextMsgPush;
      Object localObject1;
      try
      {
        if (!paramGenericSubCmd.uint32_type.has()) {
          return;
        }
        switch (paramGenericSubCmd.uint32_type.get())
        {
        case 1: 
          if (!paramGenericSubCmd.uint64_sessionid.has()) {
            break label697;
          }
          switch (paramMsgHeader.uint32_src_ter_type.get())
          {
          default: 
            long l = paramGenericSubCmd.uint64_sessionid.get();
            if (i != 1) {
              break label694;
            }
            l |= 0x0;
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(l)))
            {
              localTextMsgPush = new TextMsgPush(Long.valueOf(paramGenericSubCmd.uint32_size.get()), Long.valueOf(l));
              this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localTextMsgPush);
              if (!paramGenericSubCmd.bytes_buf.has()) {
                break label697;
              }
              paramMsgHeader = new String();
              localObject1 = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg();
              ((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg)localObject1).mergeFrom(paramGenericSubCmd.bytes_buf.get().toByteArray());
              localObject1 = ((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg)localObject1).rpt_msg_item.get().iterator();
              if (((Iterator)localObject1).hasNext())
              {
                Object localObject2 = (SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)((Iterator)localObject1).next();
                if ((!((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).uint32_type.has()) || (((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).uint32_type.get() != 1) || (!((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).bytes_text.has())) {
                  break label691;
                }
                localObject2 = new String(((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).bytes_text.get().toByteArray());
                paramMsgHeader = paramMsgHeader + (String)localObject2;
                break label705;
              }
            }
            else
            {
              localTextMsgPush = (TextMsgPush)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
              continue;
            }
            if (!paramGenericSubCmd.uint32_index.has()) {
              break label697;
            }
            localTextMsgPush.a(paramGenericSubCmd.uint32_index.get(), paramMsgHeader);
            if (!localTextMsgPush.a()) {
              break label697;
            }
            this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(l));
            localObject1 = new DataLineMsgRecord();
            ((DataLineMsgRecord)localObject1).msgId = l;
            ((DataLineMsgRecord)localObject1).sessionid = l;
            if (i == 1)
            {
              paramGenericSubCmd = localTextMsgPush.a();
              i = 0;
              if (i < EmotcationConstants.SYS_EMOTICON_SYMBOL.length)
              {
                paramMsgHeader = paramGenericSubCmd;
                if (paramGenericSubCmd.indexOf('\024' + EmotcationConstants.SYS_EMOTICON_SYMBOL[i]) == -1) {
                  break label714;
                }
                paramMsgHeader = paramGenericSubCmd.replace('\024' + EmotcationConstants.SYS_EMOTICON_SYMBOL[i], "\024" + (char)i);
                break label714;
              }
              ((DataLineMsgRecord)localObject1).msg = paramGenericSubCmd;
              ((DataLineMsgRecord)localObject1).msgtype = -1000;
              ((DataLineMsgRecord)localObject1).issend = 0;
              ((DataLineMsgRecord)localObject1).isread = false;
              ((DataLineMsgRecord)localObject1).time = paramLong1;
              ((DataLineMsgRecord)localObject1).issuc = true;
              ((DataLineMsgRecord)localObject1).sessionid = ((DataLineMsgRecord)localObject1).msgId;
              ((DataLineMsgRecord)localObject1).shmsgseq = paramLong2;
              i = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject1).sessionid);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a((DataLineMsgRecord)localObject1, true);
              j();
              a(8, true, new Object[] { Integer.valueOf((int)paramLong1), localTextMsgPush.a(), Long.valueOf(((DataLineMsgRecord)localObject1).sessionid) });
              return;
            }
            break;
          }
          break;
        }
      }
      catch (Exception paramGenericSubCmd)
      {
        paramGenericSubCmd.printStackTrace();
        return;
      }
      ((DataLineMsgRecord)localObject1).msg = localTextMsgPush.a();
      continue;
      MsgBackupPushHandler.a().a(paramGenericSubCmd);
      return;
      label691:
      break label705;
      label694:
      continue;
      label697:
      return;
      return;
      int i = 0;
      continue;
      label705:
      continue;
      i = 1;
      continue;
      label714:
      i += 1;
      paramGenericSubCmd = paramMsgHeader;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    a(1004, a(paramDataLineMsgRecord, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue()), paramDataLineMsgRecord.sessionid);
    OnSessionProgress(paramDataLineMsgRecord.sessionid, (paramDataLineMsgRecord.filesize * 0.8D), paramDataLineMsgRecord.filesize, 0);
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    if (paramDataLineMsgRecord == null) {}
    ArrayList localArrayList;
    Session localSession;
    do
    {
      return;
      localArrayList = new ArrayList();
      localSession = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(paramDataLineMsgRecord);
    } while (localSession == null);
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
      FileUtils.d(paramFileManagerEntity.strThumbPath, localDataLineMsgRecord.thumbPath);
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
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localDataLineMsgRecord);
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
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localDataLineMsgRecord);
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
    int i;
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      i = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX", -1);
      if (i >= 0) {}
    }
    do
    {
      do
      {
        return;
        if (i < 3)
        {
          paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i + 1);
          a(paramToServiceMsg);
          return;
        }
      } while ((paramFromServiceMsg == null) || (paramFromServiceMsg.getServiceCmd() == null));
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
    } while (!QLog.isColorLevel());
    QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handle0x346Rsp, unknown cmd:" + paramFromServiceMsg.getServiceCmd());
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new DataLineHandler.6(this, paramToServiceMsg, paramFromServiceMsg, paramInt));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "received a cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if (paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PbSendMsg"))
    {
      if (!paramToServiceMsg.extraData.getBoolean("exit_push_0x211_key", false)) {
        break label73;
      }
      MsgBackupPushHandler.a().a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    label73:
    while ((paramToServiceMsg.extraData.getInt("ROUNTING_TYPE") != 13) || (!paramToServiceMsg.extraData.getBoolean("ISFROM_DATALINE"))) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      int i = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX");
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handle0x211C2CMessageError, retry = " + i);
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
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("DataLineHandler", 1, "msg is null!");
      return;
    }
    paramString = new QQText(paramString, 13, 32, 0).toPlainText(true);
    String str = FMSettings.a().b() + FileManagerUtil.a() + ".txt";
    a(paramString, new File(str));
    a(str, null, 0, FileManagerUtil.a().longValue(), 0, 0, 0, false);
  }
  
  public void a(ArrayList<FileInfo> paramArrayList)
  {
    a(paramArrayList, null, null, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
  }
  
  public void a(ArrayList<FileInfo> paramArrayList, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayList == null) {}
    int j;
    int i;
    ArrayList localArrayList;
    Object localObject;
    String str;
    for (;;)
    {
      return;
      j = paramArrayList.size();
      if (j > 3) {
        break;
      }
      i = 0;
      while (i < j)
      {
        localArrayList = new ArrayList();
        localObject = ((FileInfo)paramArrayList.get(i)).c();
        str = ((FileInfo)paramArrayList.get(i)).b();
        localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject, null, str, 0, 0, 0L, 0, 0, 0);
        if (localObject != null)
        {
          localArrayList.add(localObject);
          ((Session)localObject).uSessionID = a(0, this.jdField_a_of_type_Int).longValue();
          ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, paramString, paramArrayOfByte);
        }
        if (localArrayList.size() > 0) {
          b(localArrayList, false);
        }
        i += 1;
      }
    }
    if ((j > 3) && (j < 50))
    {
      localArrayList = new ArrayList();
      int k = a();
      i = 0;
      label199:
      if (i < j)
      {
        localObject = ((FileInfo)paramArrayList.get(i)).c();
        str = ((FileInfo)paramArrayList.get(i)).b();
        localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject, null, str, 0, 0, 0L, k, j, i);
        if (localObject == null) {
          break label634;
        }
        localArrayList.add(localObject);
        ((Session)localObject).uSessionID = a(k, this.jdField_a_of_type_Int).longValue();
        ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, paramString, paramArrayOfByte);
        if (!DataLineMsgSet.isSingle(0, k)) {
          break label634;
        }
        ((Session)localObject).dwGroupID = 0;
        ((Session)localObject).dwGroupIndex = 0;
        ((Session)localObject).dwGroupSize = 0;
        if (localArrayList.size() > 0) {
          b(localArrayList, false);
        }
        localArrayList = new ArrayList();
      }
    }
    label412:
    label631:
    label634:
    for (;;)
    {
      i += 1;
      break label199;
      if (localArrayList.size() <= 0) {
        break;
      }
      b(localArrayList, false);
      return;
      j = a();
      localArrayList = new ArrayList();
      i = 0;
      if (i < 50)
      {
        localObject = ((FileInfo)paramArrayList.get(i)).c();
        str = ((FileInfo)paramArrayList.get(i)).b();
        localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject, null, str, 0, 0, 0L, j, 50, i);
        if (localObject == null) {
          break label631;
        }
        localArrayList.add(localObject);
        ((Session)localObject).uSessionID = a(j, this.jdField_a_of_type_Int).longValue();
        ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, paramString, paramArrayOfByte);
        if (!DataLineMsgSet.isSingle(0, j)) {
          break label631;
        }
        ((Session)localObject).dwGroupID = 0;
        ((Session)localObject).dwGroupIndex = 0;
        ((Session)localObject).dwGroupSize = 0;
        if (localArrayList.size() > 0) {
          b(localArrayList, false);
        }
        localArrayList = new ArrayList();
      }
      for (;;)
      {
        i += 1;
        break label412;
        if (localArrayList.size() > 0) {
          b(localArrayList, false);
        }
        i = 0;
        while (i < 50)
        {
          paramArrayList.remove(0);
          i += 1;
        }
        break;
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
    if ((paramList == null) || (paramList.size() < 0)) {}
    for (;;)
    {
      return;
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
  
  public void a(msg_comm.Msg paramMsg, SubMsgType0x7.MsgBody paramMsgBody)
  {
    this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a(paramMsg, paramMsgBody);
    DataLineMsgRecord localDataLineMsgRecord;
    try
    {
      localDataLineMsgRecord = new DataLineMsgRecord();
      localDataLineMsgRecord.shmsgseq = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
      localDataLineMsgRecord.time = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
      localDataLineMsgRecord.msgId = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
      if (!paramMsgBody.msg_header.has()) {
        throw new Exception("msgBody do not has msg_header");
      }
    }
    catch (Exception paramMsg)
    {
      paramMsg = paramMsg;
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "<<<<<<<<<<handleDataLinePushMsg_PB_0x211 Exception:" + paramMsg.toString() + ">>>>>>>>>>");
      }
      return;
      if (!paramMsgBody.msg_header.uint32_src_app_id.has()) {
        throw new Exception("msgBody do not has uint32_src_app_id");
      }
    }
    finally {}
    if (!paramMsgBody.msg_header.uint32_src_inst_id.has()) {
      throw new Exception("msgBody do not has uint32_src_inst_id");
    }
    if (!paramMsgBody.msg_header.uint32_dst_app_id.has()) {
      throw new Exception("msgBody do not has uint32_dst_app_id");
    }
    if (!paramMsgBody.msg_header.uint32_dst_inst_id.has()) {
      throw new Exception("msgBody do not has uint32_dst_inst_id");
    }
    if (a(paramMsgBody.msg_header.uint32_src_app_id.get(), paramMsgBody.msg_header.uint32_src_inst_id.get())) {
      throw new Exception("msgBody command from android");
    }
    if ((paramMsgBody.uint32_sub_cmd.get() != 5) && (!b(paramMsgBody.msg_header.uint32_dst_app_id.get(), paramMsgBody.msg_header.uint32_dst_inst_id.get()))) {
      throw new Exception("msgBody command not for android");
    }
    Object localObject = (im_msg_head.InstInfo)((im_msg_head.InstCtrl)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_inst_ctrl.get()).msg_from_inst.get();
    paramMsgBody.msg_header.uint32_src_ter_type.set(((im_msg_head.InstInfo)localObject).enum_device_type.get());
    QLog.d("DataLineHandler", 2, "DoCCPush msg time[" + localDataLineMsgRecord.time + "] mr.shmsgseq[" + localDataLineMsgRecord.shmsgseq + "] uint32_sub_cmd[" + paramMsgBody.uint32_sub_cmd.get() + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMsgBody.msg_header.uint32_src_ter_type.get()).e(localDataLineMsgRecord.time);
    if (a(localDataLineMsgRecord, paramMsgBody.msg_header.uint32_src_ter_type.get()))
    {
      QLog.d("DataLineHandler", 2, "DoCCPush msg time[" + localDataLineMsgRecord.time + "] is repeated mr.shmsgseq[" + localDataLineMsgRecord.shmsgseq + "] uint32_sub_cmd[" + paramMsgBody.uint32_sub_cmd.get() + "]");
      return;
    }
    localObject = (RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    if ((localObject != null) && (((RegisterProxySvcPackHandler)localObject).d() != 1)) {
      ((RegisterProxySvcPackHandler)localObject).e(1);
    }
    if (!paramMsgBody.uint32_sub_cmd.has()) {
      throw new Exception("msgBody do not has uint32_sub_cmd");
    }
    QLog.d("DataLineHandler", 2, "DoCCPush msg time[" + localDataLineMsgRecord.time + "]  mr.shmsgseq[" + localDataLineMsgRecord.shmsgseq + "] uint32_sub_cmd[" + paramMsgBody.uint32_sub_cmd.get() + "]");
    switch (paramMsgBody.uint32_sub_cmd.get())
    {
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x1 文件原图中转通知");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
    case 4: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x4 通用协议");
      }
      if (!paramMsgBody.msg_subcmd_0x4_generic.has()) {
        throw new Exception("msgBody do not has msg_subcmd_0x4_generic");
      }
      a(localDataLineMsgRecord.time, localDataLineMsgRecord.shmsgseq, paramMsgBody.msg_subcmd_0x4_generic, paramMsgBody.msg_header);
      return;
      a(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x1_ftn_notify.get(), false);
      return;
    case 2: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x2 文件原图近场通知");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
      b(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x2_nfc_notify.get(), false);
      return;
    case 3: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x3 文件控制命令");
      }
      a(paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x3_filecontrol.get());
      return;
    case 5: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x5 应用宝通知");
      }
      c(paramMsgBody.rpt_msg_subcmd_0x5_molo_notify.get());
      return;
    case 11: 
      b(paramMsgBody.rpt_msg_subcmd_0xb_mpfile_notify.get());
      return;
    case 9: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x9 文件缩略图中转通知");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
      a(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x9_ftn_thumb_notify.get(), true);
      return;
    case 10: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0xa 文件缩略图近场通知");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
      b(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0xa_nfc_thumb_notify.get(), true);
      return;
    case 8: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x8 rfc信令");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
      a(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x8_rnfc_notify.get());
      return;
    }
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
    SharedPreferences localSharedPreferences;
    String str;
    if (!QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_PC_STATE";
      if (this.jdField_b_of_type_Boolean) {
        localSharedPreferences.edit().putLong(str, this.jdField_a_of_type_Long).commit();
      }
    }
    else
    {
      return;
    }
    localSharedPreferences.edit().remove(str).commit();
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
    if ((paramInt1 == 1001) && (paramInt2 == i) && (QLog.isColorLevel())) {
      QLog.d("DataLineHandler", 2, "msgBody command from android" + paramInt2 + " " + i);
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
    boolean bool = false;
    OnSessionProgress(paramDataLineMsgRecord.sessionid, (paramDataLineMsgRecord.filesize * 0.4D), paramDataLineMsgRecord.filesize, 0);
    if ((0L != paramDataLineMsgRecord.filesize) && (paramDataLineMsgRecord.path != null) && (paramDataLineMsgRecord.path.length() != 0) && (paramDataLineMsgRecord.md5 != null) && (paramDataLineMsgRecord.md5.length != 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      bool = true;
      return bool;
    }
    Object localObject2 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject2).uint32_cmd.set(1400);
    ((cmd0x346.ReqBody)localObject2).uint32_client_type.set(104);
    Object localObject1 = ((cmd0x346.ReqBody)localObject2).uint32_seq;
    i = f;
    f = i + 1;
    ((PBUInt32Field)localObject1).set(i);
    ((cmd0x346.ReqBody)localObject2).msg_file_query_req.setHasFlag(true);
    ((cmd0x346.ReqBody)localObject2).msg_file_query_req.uint64_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
    if ((2 == paramDataLineMsgRecord.fileFrom) || (4 == paramDataLineMsgRecord.fileFrom) || (6 == paramDataLineMsgRecord.fileFrom))
    {
      ((cmd0x346.ReqBody)localObject2).msg_file_query_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.serverPath.getBytes()));
      ((cmd0x346.ReqBody)localObject2).uint32_business_id.set(38);
    }
    for (;;)
    {
      localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400", null);
      ((ToServiceMsg)localObject1).addAttribute("sendFromNative", Boolean.valueOf(false));
      localObject2 = ((cmd0x346.ReqBody)localObject2).toByteArray();
      byte[] arrayOfByte = new byte[localObject2.length + 4];
      PkgTools.DWord2Byte(arrayOfByte, 0, localObject2.length + 4);
      PkgTools.copyData(arrayOfByte, 4, (byte[])localObject2, localObject2.length);
      if (localObject1 == null) {
        break;
      }
      ((ToServiceMsg)localObject1).putWupBuffer(arrayOfByte);
      ((ToServiceMsg)localObject1).addAttribute("cookie", Long.valueOf(paramDataLineMsgRecord.sessionid));
      ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_TRYINDEX", 0);
      a((ToServiceMsg)localObject1);
      return false;
      ((cmd0x346.ReqBody)localObject2).msg_file_query_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.fileUuid.getBytes()));
      ((cmd0x346.ReqBody)localObject2).uint32_business_id.set(3);
    }
  }
  
  public boolean a(DataLineMsgRecord paramDataLineMsgRecord, int paramInt)
  {
    Object localObject;
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
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Long)((Iterator)localObject).next()).longValue() != paramDataLineMsgRecord.shmsgseq);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.jdField_b_of_type_JavaUtilList.add(Long.valueOf(paramDataLineMsgRecord.shmsgseq));
        bool2 = bool1;
        if (this.jdField_b_of_type_JavaUtilList.size() > 120)
        {
          this.jdField_b_of_type_JavaUtilList.remove(0);
          bool2 = bool1;
        }
      }
      return bool2;
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
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Long)((Iterator)localObject).next()).longValue() != paramDataLineMsgRecord.shmsgseq);
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(paramDataLineMsgRecord.shmsgseq));
        bool2 = bool1;
        if (this.jdField_a_of_type_JavaUtilList.size() <= 120) {
          break;
        }
        this.jdField_a_of_type_JavaUtilList.remove(0);
        return bool1;
      }
    }
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
        List localList = a().getDataLineMsgProxy(i).a(localDataLineMsgRecord.strMoloKey);
        if ((localList == null) || (localList.size() == 1))
        {
          this.jdField_a_of_type_ComDatalineCoreMoloHandler.d(localDataLineMsgRecord.strMoloKey);
          if (QLog.isDevelopLevel()) {
            QLog.d("DataLineHandler", 4, "删除应用宝消息 sessionid[" + localDataLineMsgRecord.sessionid);
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
    int i;
    if (((Iterator)localObject1).hasNext())
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
      for (;;)
      {
        break;
        localArrayList1.add(localObject2);
      }
    }
    ArrayList localArrayList2 = new ArrayList();
    boolean bool2 = bool1;
    DataLineMsgRecord localDataLineMsgRecord;
    if (localArrayList1.size() > 0)
    {
      localObject2 = null;
      Iterator localIterator = paramList.iterator();
      localObject3 = null;
      localObject1 = null;
      paramList = (List<Long>)localObject2;
      if (!localIterator.hasNext()) {
        break label575;
      }
      localObject2 = (Long)localIterator.next();
      i = DataLineMsgRecord.getDevTypeBySeId(((Long)localObject2).longValue());
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(((Long)localObject2).longValue());
      if (localDataLineMsgRecord == null)
      {
        QLog.e("DataLineHandler", 1, "uSessionID[" + localObject2 + "], prepareMsg: session not found");
        bool2 = false;
      }
    }
    else
    {
      label291:
      return bool2;
    }
    localArrayList2.add(localDataLineMsgRecord);
    if ((localDataLineMsgRecord.filename == null) || (localDataLineMsgRecord.filesize == 0L) || ((localDataLineMsgRecord.md5 == null) && (TextUtils.isEmpty(localDataLineMsgRecord.serverPath))))
    {
      QLog.e("DataLineHandler", 1, "uSessionID[" + localObject2 + "], receive param err.filename:" + localDataLineMsgRecord.filename + " filesize;" + localDataLineMsgRecord.filesize);
      return false;
    }
    c(localDataLineMsgRecord);
    Object localObject4 = a(localDataLineMsgRecord.sessionid);
    Object localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new ArrayList();
    }
    ((List)localObject2).add(localObject4);
    localObject4 = new FTNInfo();
    ((FTNInfo)localObject4).strFileIndex = localDataLineMsgRecord.serverPath;
    Object localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = new ArrayList();
    }
    ((List)localObject3).add(localObject4);
    localObject1 = new NFCInfo();
    ((NFCInfo)localObject1).dwServerIP = ((int)localDataLineMsgRecord.nServerIp);
    ((NFCInfo)localObject1).wServerPort = ((short)(int)localDataLineMsgRecord.nServerPort);
    ((NFCInfo)localObject1).vTokenKey = localDataLineMsgRecord.vTokenKey;
    ((NFCInfo)localObject1).vUrlNotify = localDataLineMsgRecord.vUrlNotify;
    if (paramList == null) {
      paramList = new ArrayList();
    }
    for (;;)
    {
      paramList.add(localObject1);
      localObject1 = localObject3;
      localObject3 = localObject2;
      break;
      label575:
      bool2 = bool1;
      if (localObject3 == null) {
        break label291;
      }
      localObject2 = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
      localObject3 = (Session[])((List)localObject3).toArray(new Session[((List)localObject3).size()]);
      paramList = (NFCInfo[])paramList.toArray(new NFCInfo[paramList.size()]);
      localObject1 = (FTNInfo[])((List)localObject1).toArray(new FTNInfo[((List)localObject1).size()]);
      if (localArrayList1.size() == 1) {}
      for (bool1 = false;; bool1 = true)
      {
        ((LiteTransferWrapper)localObject2).RecvGroup((Session[])localObject3, paramList, (FTNInfo[])localObject1, bool1);
        paramList = localArrayList2.iterator();
        while (paramList.hasNext())
        {
          localObject1 = (DataLineMsgRecord)paramList.next();
          ((DataLineMsgRecord)localObject1).bIsTransfering = true;
          ((DataLineMsgRecord)localObject1).nSessionState = 2;
          b(((DataLineMsgRecord)localObject1).path);
        }
      }
      return true;
    }
  }
  
  public int b()
  {
    return ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b();
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
    if ((TextUtils.isEmpty(paramDataLineMsgRecord.strWeiyunId)) || (TextUtils.isEmpty(paramDataLineMsgRecord.filename)))
    {
      QLog.e("DatalineHandler", 1, "reSendWeiYunFile keyinfo=null");
      return;
    }
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
    int i = 0;
    MsgSCBody localMsgSCBody = new MsgSCBody();
    cmd0x345.RspBody localRspBody = new cmd0x345.RspBody();
    localMsgSCBody.uMsgType = 837;
    localMsgSCBody.bTimeOut = false;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      localMsgSCBody.bTimeOut = true;
    }
    if (paramFromServiceMsg == null) {}
    label121:
    long l;
    label192:
    label199:
    int j;
    do
    {
      localMsgSCBody.msgBody0x345 = new MsgSCBody0x345();
      paramFromServiceMsg = localMsgSCBody.msgBody0x345;
      if (localRspBody.uint32_sub_cmd.has()) {
        i = localRspBody.uint32_sub_cmd.get();
      }
      paramFromServiceMsg.uMsgSubType = i;
      paramFromServiceMsg = localMsgSCBody.msgBody0x345;
      if (!localRspBody.uint32_return_code.has()) {
        break;
      }
      i = localRspBody.uint32_return_code.get();
      paramFromServiceMsg.uint32_return_code = i;
      switch (localMsgSCBody.msgBody0x345.uMsgSubType)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.e("DataLineHandler", 2, "PBToMsgSCBody : msgtype is not cmd0x345[" + localMsgSCBody.msgBody0x345.uMsgSubType);
        }
        if (paramToServiceMsg != null) {
          break label373;
        }
        l = 0L;
        this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(Long.valueOf(l).intValue(), localMsgSCBody);
        return;
        if (paramFromServiceMsg.getWupBuffer() == null) {
          break label391;
        }
        j = paramFromServiceMsg.getWupBuffer().length - 4;
      }
    } while (j < 0);
    byte[] arrayOfByte = new byte[j];
    PkgTools.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, j);
    label391:
    for (paramFromServiceMsg = arrayOfByte; paramFromServiceMsg != null; paramFromServiceMsg = null)
    {
      try
      {
        localRspBody.mergeFrom(paramFromServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      break;
      i = -1;
      break label121;
      if (localRspBody.msg_subcmd_0x6_rsp_body.has()) {}
      for (paramFromServiceMsg = (cmd0x345.RspBody.SubCmd0x6RspBody)localRspBody.msg_subcmd_0x6_rsp_body.get();; paramFromServiceMsg = null)
      {
        if (paramFromServiceMsg == null) {
          break label371;
        }
        localMsgSCBody.msgBody0x345.subCmd0x6RspBody = new SubCmd0x6RspBody();
        localMsgSCBody.msgBody0x345.subCmd0x6RspBody.str_file_id = paramFromServiceMsg.str_file_id.get();
        localMsgSCBody.msgBody0x345.subCmd0x6RspBody.str_ret_msg = paramFromServiceMsg.str_ret_msg.get();
        break;
      }
      label371:
      break label192;
      label373:
      l = ((Long)paramToServiceMsg.getAttribute("cookie")).longValue();
      break label199;
    }
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
    try
    {
      localPbSendMsgResp = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
      if ((localPbSendMsgResp == null) || (!localPbSendMsgResp.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DataLineHandler", 2, "handle0x211C2CMessageResp::server did not return a valid result code, use 4 instead.");
        }
        i = 4;
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handle0x211C2CMessageResp: ---ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "----replyCode:" + i);
        }
        switch (paramToServiceMsg.extraData.getInt("DATALINE_CMD"))
        {
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel()) {
          QLog.e("DataLineHandler", 2, "<---handle0x211C2CMessageResp::invalid.", localException);
        }
        Object localObject = null;
        continue;
        if (localObject.result.get() != 0)
        {
          i = localObject.result.get();
          continue;
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          paramToServiceMsg = (Long)paramToServiceMsg.getAttribute("cookie");
          if ((a(paramToServiceMsg.longValue()) == null) && (QLog.isColorLevel())) {
            QLog.d("DataLineHandler", 2, "uSessionID[" + paramToServiceMsg + "]handleFileOperate: session not found");
          }
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  public void b(ArrayList<InstanceInfo> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if (paramArrayList == null) {}
    do
    {
      return;
      paramArrayList = paramArrayList.iterator();
    } while (!paramArrayList.hasNext());
    int i;
    switch ((int)((InstanceInfo)paramArrayList.next()).iClientType)
    {
    default: 
      i = -1;
    }
    while (i != -1)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
      break;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  protected void b(List<SubMsgType0x7.MsgBody.MpFileNotify> paramList) {}
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    SharedPreferences localSharedPreferences;
    String str;
    if (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_IPAD_STATE";
      if (this.jdField_c_of_type_Boolean) {
        localSharedPreferences.edit().putLong(str, this.jdField_b_of_type_Long).commit();
      }
    }
    else
    {
      return;
    }
    localSharedPreferences.edit().remove(str).commit();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("dl_ipad_online_notify", true);
  }
  
  public boolean b(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.isEmpty())) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt));
  }
  
  protected boolean b(int paramInt1, int paramInt2)
  {
    int i = AppSetting.a();
    if ((paramInt1 == 1001) && ((paramInt2 == i) || (paramInt2 == 0))) {}
    while (!QLog.isColorLevel()) {
      return true;
    }
    QLog.d("DataLineHandler", 2, "msgBody command not for android" + paramInt2 + " " + i);
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
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_b_of_type_Int = i;
      return;
    }
  }
  
  public boolean c()
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      boolean bool1 = localSharedPreferences.getBoolean("auto_receive_files", false);
      boolean bool2 = localSharedPreferences.getBoolean("auto_receive_files_ipad", false);
      if ((!bool1) && (!bool2)) {
        break label60;
      }
    }
    label60:
    for (this.jdField_b_of_type_Int = 1; this.jdField_b_of_type_Int == 1; this.jdField_b_of_type_Int = 2) {
      return true;
    }
    return false;
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
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(String.valueOf(AppConstants.DATALINE_PC_UIN), 6000).time;
    QLog.d("DataLineHandler", 2, "sendDatalineReadConfirm last time[" + l + "]");
    ArrayList localArrayList;
    if ((l != 0L) && (l != this.jdField_c_of_type_Long))
    {
      localArrayList = new ArrayList();
      localArrayList.add(new Pair(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), Long.valueOf(l)));
      ((C2CMessageProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a("c2c_processor")).a(localArrayList);
      this.jdField_c_of_type_Long = l;
    }
    l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(String.valueOf(AppConstants.DATALINE_IPAD_UIN), 6003).time;
    if ((l != 0L) && (l != this.jdField_d_of_type_Long))
    {
      localArrayList = new ArrayList();
      localArrayList.add(new Pair(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), Long.valueOf(l)));
      ((C2CMessageProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a("c2c_processor")).a(localArrayList);
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
      if (this.jdField_e_of_type_Boolean) {
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
    boolean bool2 = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null) && (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null) || (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null)
        {
          AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
          this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "--->>close cancel all task");
        }
        d(32);
        boolean bool1 = bool2;
        Object localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(0) != null)
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
        bool2 = bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          bool2 = bool1;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(1) != null)
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
        if (this.jdField_a_of_type_JavaUtilTimer != null)
        {
          this.jdField_a_of_type_JavaUtilTimer.cancel();
          this.jdField_a_of_type_JavaUtilTimer = null;
        }
        this.jdField_d_of_type_Boolean = true;
        return;
        localException1 = localException1;
        QLog.e("DataLineHandler", 1, "onDestroy fail unregisterReceiver exitReceiver:" + localException1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("DataLineHandler", 1, "onDestroy fail unregisterReceiver sdCardReceiver:" + localException2);
        }
      }
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler
 * JD-Core Version:    0.7.0.1
 */