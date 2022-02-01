package com.tencent.mobileqq.app;

import android.content.ContentValues;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.dataline.util.QualityReportUtil;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
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
import com.tencent.litetransfersdk.MsgCSBody0x346;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.MsgSCBody;
import com.tencent.litetransfersdk.MsgSCBody0x346;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.NFCNotify;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FTNNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FileControl;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.NFCNotify;

public class RouterHandler
  extends BusinessHandler
  implements LiteTransferListenerCallback, LiteTransferOperatorCallback
{
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  protected LiteTransferWrapper a;
  protected ProtocolHelper a;
  private RouterHandler.NotifyReceiver jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver = null;
  protected String a;
  public ArrayList<RouterMsgRecord> a;
  private int jdField_b_of_type_Int;
  QQAppInterface jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = null;
  protected HashMap<Long, RouterMsgRecord> d = new HashMap();
  protected HashMap<Long, Session> e = new HashMap();
  
  public RouterHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = "router";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper = new ProtocolHelper(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper = new LiteTransferWrapper(this, this);
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("SmartDevice_receiveDatalineCSReply");
    paramQQAppInterface.addAction("SmartDevice_receiveDatalineCCReply");
    paramQQAppInterface.addAction("SmartDevice_receiveDatalineCCPush");
    paramQQAppInterface.addAction("com.tencent.mobileqq.intent.logout");
    paramQQAppInterface.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    paramQQAppInterface.addAction("mqq.intent.action.ACCOUNT_KICKED");
    paramQQAppInterface.addAction("mqq.intent.action.FORCE_LOGOUT");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqq.intent.action.EXIT_");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
    paramQQAppInterface.addAction(localStringBuilder.toString());
    paramQQAppInterface.addAction("mqq.intent.action.LOGOUT");
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver = new RouterHandler.NotifyReceiver(this);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver, paramQQAppInterface);
  }
  
  public static int a(int paramInt)
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
  
  public static long a()
  {
    return ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a();
  }
  
  private void a(int paramInt, FTNNotify paramFTNNotify, long paramLong)
  {
    paramFTNNotify = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFTNNotify(paramFTNNotify, paramLong, AppConstants.DATALINE_PC_UIN, 1).toByteArray();
    ((SmartDeviceProxyMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramLong, paramInt, paramFTNNotify);
  }
  
  private void a(int paramInt, FileControl paramFileControl, long paramLong)
  {
    paramFileControl = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFileControl(paramFileControl, paramLong, AppConstants.DATALINE_PC_UIN, 3).toByteArray();
    ((SmartDeviceProxyMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramLong, paramInt, paramFileControl);
  }
  
  private void a(int paramInt, MsgCSBody0x211 paramMsgCSBody0x211)
  {
    if (paramMsgCSBody0x211.uMsgSubType != 7)
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Router", 2, "SendPbMsg: cannot recognize the pb msg form 0X211");
      }
    }
    else {
      a(paramInt, paramMsgCSBody0x211.msgBody0x211_0x7);
    }
  }
  
  private void a(int paramInt, MsgCSBody0x211_0x7 paramMsgCSBody0x211_0x7)
  {
    long l = paramMsgCSBody0x211_0x7.msgHeader.uint64_dst_uin;
    int i1 = paramMsgCSBody0x211_0x7.uMsgSubCmd;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    int j = 0;
    if (i1 != 1)
    {
      i = n;
      if (i1 != 2)
      {
        i = m;
        if (i1 != 3)
        {
          i = k;
          if (i1 != 9)
          {
            i = j;
            if (i1 != 10)
            {
              if (QLog.isColorLevel()) {
                QLog.d("dataline.Router", 2, "SendPbMsg: cannot recognize the pb msg form 0X211_0x7");
              }
            }
            else {
              while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb.length)
              {
                paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[i].bytes_originfile_md5 = null;
                a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[i], l);
                i += 1;
              }
            }
          }
          else
          {
            while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb.length)
            {
              paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[i].bytes_originfile_md5 = null;
              a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[i], l);
              i += 1;
            }
          }
        }
        else
        {
          while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl.length)
          {
            a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl[i], l);
            i += 1;
          }
        }
      }
      else
      {
        while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc.length)
        {
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc[i], l);
          i += 1;
        }
      }
    }
    else
    {
      while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc.length)
      {
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc[i], l);
        i += 1;
      }
    }
  }
  
  private void a(int paramInt, MsgCSBody0x346 paramMsgCSBody0x346)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.Router", 2, "SendPbMsg: _handleCSMsg0x346");
    }
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(paramMsgCSBody0x346.uMsgSubType);
    localReqBody.uint32_seq.set(paramInt);
    localReqBody.uint32_business_id.set(56);
    localReqBody.uint32_client_type.set(310);
    if (!this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.FillReqBody(paramMsgCSBody0x346, localReqBody)) {
      return;
    }
    ((SmartDeviceProxyMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramMsgCSBody0x346.uMsgSubType, paramInt, localReqBody.toByteArray());
  }
  
  private void a(int paramInt, NFCNotify paramNFCNotify, long paramLong)
  {
    paramNFCNotify = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromNFCNotify(paramNFCNotify, paramLong, AppConstants.DATALINE_PC_UIN, 2).toByteArray();
    ((SmartDeviceProxyMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramLong, paramInt, paramNFCNotify);
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(long paramLong, SubMsgType0x7.MsgBody.GenericSubCmd paramGenericSubCmd)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals("router")) {
      return;
    }
    try
    {
      if (!paramGenericSubCmd.uint32_type.has()) {
        return;
      }
      paramGenericSubCmd.uint32_type.get();
      return;
    }
    catch (Exception paramGenericSubCmd)
    {
      paramGenericSubCmd.printStackTrace();
    }
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    try
    {
      paramArrayOfByte = (SubMsgType0x7.MsgBody)localMsgBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte.msg_header.uint32_src_app_id.set(1001);
      paramArrayOfByte.msg_header.uint32_src_inst_id.set(0);
      paramArrayOfByte.msg_header.uint32_dst_app_id.set(AppSetting.a());
      paramArrayOfByte.msg_header.uint32_dst_inst_id.set(0);
      paramArrayOfByte.msg_header.uint64_src_uin.set(paramLong);
      paramArrayOfByte.msg_header.setHasFlag(true);
      int i;
      if (paramArrayOfByte.uint32_sub_cmd.has()) {
        i = paramArrayOfByte.uint32_sub_cmd.get();
      } else {
        i = 0;
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                if (i != 9)
                {
                  if (i != 10) {
                    return;
                  }
                  a(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0xa_nfc_thumb_notify.get(), true);
                  return;
                }
                b(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0x9_ftn_thumb_notify.get(), true);
              }
            }
            else {
              a(paramLong, paramArrayOfByte.msg_subcmd_0x4_generic);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("dataline.Router", 2, "app 文件控制命令");
            }
            a(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0x3_filecontrol.get());
          }
        }
        else {
          a(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0x2_nfc_notify.get(), false);
        }
      }
      else {
        b(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0x1_ftn_notify.get(), false);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("dataline.Router", 2, "onRecvRouterMsg : subMsgType[0x7] failed", paramArrayOfByte);
      }
    }
  }
  
  private void a(RouterMsgRecord paramRouterMsgRecord, boolean paramBoolean)
  {
    String str = UinTypeUtil.a(String.valueOf(paramRouterMsgRecord.peerDin), 6002);
    QQMessageFacade localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localQQMessageFacade == null) {
      return;
    }
    boolean bool;
    if (localQQMessageFacade.a.containsKey(str))
    {
      bool = ((Message)localQQMessageFacade.a.get(str)).hasReply;
      localQQMessageFacade.a.remove(str);
    }
    else
    {
      bool = false;
    }
    paramRouterMsgRecord.frienduin = String.valueOf(paramRouterMsgRecord.peerDin);
    Message localMessage = new Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramRouterMsgRecord);
    localMessage.emoRecentMsg = null;
    localMessage.hasReply = bool;
    localQQMessageFacade.a(localMessage);
    localQQMessageFacade.a.put(str, localMessage);
    if (paramBoolean) {
      a(String.valueOf(paramRouterMsgRecord.peerDin));
    }
  }
  
  private void a(String paramString)
  {
    QQMessageFacade localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localQQMessageFacade == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramString, 6002);
    localEntityManager.close();
    if (paramString != null) {
      localQQMessageFacade.a(paramString);
    }
  }
  
  private void a(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.FileControl> paramList)
  {
    paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromFileControl(paramMsgHeader, paramList);
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
  }
  
  private void a(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.NFCNotify> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.NFCNotify localNFCNotify = (SubMsgType0x7.MsgBody.NFCNotify)paramList.next();
      if ((localNFCNotify.uint64_sessionid.has()) && (localNFCNotify.uint32_originfiletype.has()) && (localNFCNotify.str_file_name.has()) && (localNFCNotify.uint64_file_len.has()) && (localNFCNotify.bytes_file_md5.has()) && (localNFCNotify.fixed32_ip.has()) && (localNFCNotify.uint32_port.has()) && (localNFCNotify.bytes_url_notify.has()) && (localNFCNotify.bytes_tokenkey.has()) && (this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.CheckActionInfo(localNFCNotify, this.jdField_a_of_type_JavaLangString))) {
        localArrayList.add(localNFCNotify);
      }
    }
    if (localArrayList.size() > 0) {
      new Handler(Looper.getMainLooper()).post(new RouterHandler.1(this, paramMsgHeader, localArrayList, paramBoolean));
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    return ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public static boolean a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    return ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramLong, paramInt, paramArrayOfByte);
  }
  
  private int b(int paramInt)
  {
    if (paramInt == 3) {
      return -2005;
    }
    if (paramInt == 1) {
      return -2000;
    }
    if (paramInt == 2) {}
    return -2005;
  }
  
  private void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0))
      {
        paramArrayOfByte2 = new cmd0x346.ReqBody();
        try
        {
          paramArrayOfByte2.mergeFrom(paramArrayOfByte1);
          paramArrayOfByte1 = new MsgSCBody();
          paramArrayOfByte1.bTimeOut = true;
          paramArrayOfByte1.uMsgType = 838;
          paramArrayOfByte1.msgBody0x346 = new MsgSCBody0x346();
          paramArrayOfByte1.msgBody0x346.uMsgSubType = paramArrayOfByte2.uint32_cmd.get();
          this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(paramInt, paramArrayOfByte1);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("dataline.Router", 2, "DoCSReply : cmd0x346.ReqBody prase failed", paramArrayOfByte1);
          }
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("dataline.Router", 2, "DoCSReply : reqBuff is null");
      }
      return;
    }
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0))
    {
      paramArrayOfByte1 = new cmd0x346.RspBody();
      try
      {
        paramArrayOfByte1.mergeFrom(paramArrayOfByte2);
        paramArrayOfByte2 = new MsgSCBody();
        paramArrayOfByte2.uMsgType = 838;
        paramArrayOfByte2.bTimeOut = false;
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.FillMsgSCBody(paramArrayOfByte2, paramArrayOfByte1, paramArrayOfByte1.uint32_cmd.get());
        this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(paramInt, paramArrayOfByte2);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("dataline.Router", 2, "DoCSReply : cmd0x346.rspBody prase failed", paramArrayOfByte1);
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("dataline.Router", 2, "DoCSReply : rspBuff is null");
    }
  }
  
  private void b(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.FTNNotify> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = (SubMsgType0x7.MsgBody.FTNNotify)paramList.next();
      if ((localFTNNotify.uint64_sessionid.has()) && (localFTNNotify.uint32_originfiletype.has()) && (localFTNNotify.str_file_name.has()) && (localFTNNotify.uint64_file_len.has()) && (localFTNNotify.bytes_file_md5.has()) && (localFTNNotify.str_file_index.has()) && (this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.CheckActionInfo(localFTNNotify, this.jdField_a_of_type_JavaLangString))) {
        localArrayList.add(localFTNNotify);
      }
    }
    if (localArrayList.size() > 0) {
      new Handler(Looper.getMainLooper()).post(new RouterHandler.2(this, paramMsgHeader, localArrayList, paramBoolean));
    }
  }
  
  private void c(RouterMsgRecord paramRouterMsgRecord)
  {
    Object localObject = Long.toString(paramRouterMsgRecord.peerDin);
    String str = a(paramRouterMsgRecord.peerDin);
    RecentUserProxy localRecentUserProxy = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    localObject = localRecentUserProxy.a((String)localObject, 6002);
    ((RecentUser)localObject).setType(6002);
    ((RecentUser)localObject).lastmsgtime = MessageCache.a();
    ((RecentUser)localObject).displayName = str;
    ((RecentUser)localObject).msgType = paramRouterMsgRecord.msgtype;
    localRecentUserProxy.b((RecentUser)localObject);
  }
  
  public void GetThumbFilePath(int paramInt, Session paramSession) {}
  
  public void HandleSession(int paramInt1, long paramLong, int paramInt2, MsgHeader paramMsgHeader)
  {
    if (paramInt2 == 5) {
      new Handler(Looper.getMainLooper()).post(new RouterHandler.3(this, paramLong, paramMsgHeader));
    }
  }
  
  public void InvokeReport(ReportItem paramReportItem)
  {
    QualityReportUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramReportItem, QualityReportUtil.d);
  }
  
  public void OnGroupComplete(int paramInt1, int paramInt2) {}
  
  public void OnGroupStart(int paramInt) {}
  
  public boolean OnQueryAutoDownload(long paramLong, byte paramByte)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramByte == 2)
    {
      boolean bool3 = NetworkUtil.isWifiConnected(BaseApplication.getContext());
      if (paramLong <= 3145728L) {
        paramByte = 1;
      } else {
        paramByte = 0;
      }
      bool1 = bool2;
      if (!bool3)
      {
        if ((getAutoDownload()) && (paramByte != 0)) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void OnSessionComplete(long paramLong, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnSessionComplete uSessionID=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" retCode=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" TaskStatus=");
    localStringBuilder.append(paramInt1);
    QLog.d("dataline.Router", 1, localStringBuilder.toString());
    new Handler(Looper.getMainLooper()).post(new RouterHandler.7(this, paramLong, paramInt1));
  }
  
  public void OnSessionConnected(long paramLong, int paramInt1, int paramInt2) {}
  
  public void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo)
  {
    new Handler(Looper.getMainLooper()).post(new RouterHandler.4(this, paramSession));
  }
  
  public void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new RouterHandler.6(this, paramLong1, paramLong2, paramLong3));
  }
  
  public void OnSessionStart(long paramLong)
  {
    new Handler(Looper.getMainLooper()).post(new RouterHandler.5(this, paramLong));
  }
  
  public void OnSessionStartRun(long paramLong) {}
  
  public void OnSessionUpdate(int paramInt, long paramLong, String paramString) {}
  
  public void SendPbMsg(int paramInt, MsgCSBody paramMsgCSBody)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SendPbMsg: msgBody.uMsgType[");
      localStringBuilder.append(paramMsgCSBody.uMsgType);
      localStringBuilder.append("], nCookie[");
      localStringBuilder.append(paramInt);
      QLog.d("dataline.Router", 2, localStringBuilder.toString());
    }
    int i = paramMsgCSBody.uMsgType;
    if (i != 529)
    {
      if (i != 838)
      {
        if (QLog.isColorLevel()) {
          QLog.d("dataline.Router", 2, "SendPbMsg: cannot recognize the pb msg form JNI");
        }
      }
      else {
        a(paramInt, paramMsgCSBody.msgBody0x346);
      }
    }
    else {
      a(paramInt, paramMsgCSBody.msgBody0x211);
    }
  }
  
  public Message a(String paramString)
  {
    Message localMessage = new Message();
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
    EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(RouterMsgRecord.sBasicTableName);
    localStringBuilder.append(paramString);
    if (DataLineMsgProxy.a((BaseProxyManager)localObject, localStringBuilder.toString())) {
      ((ProxyManager)localObject).transSaveToDatabase(localEntityManager);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(RouterMsgRecord.sBasicTableName);
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" order by msgid desc");
    paramString = localEntityManager.rawQuery(RouterMsgRecord.class, ((StringBuilder)localObject).toString(), null);
    localEntityManager.close();
    if (paramString == null) {
      return null;
    }
    paramString = (RouterMsgRecord)paramString.get(0);
    localMessage.extInt = paramString.status;
    localMessage.extStr = paramString.extStr;
    localMessage.msgtype = paramString.msgtype;
    localMessage.time = paramString.time;
    return localMessage;
  }
  
  public ActionInfo a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null)
    {
      ActionInfo localActionInfo = new ActionInfo();
      localActionInfo.strServiceName = paramMessageForDeviceFile.strServiceName;
      localActionInfo.vServiceInfo = paramMessageForDeviceFile.vServiceInfo;
      return localActionInfo;
    }
    return null;
  }
  
  public MsgHeader a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null)
    {
      MsgHeader localMsgHeader = new MsgHeader();
      localMsgHeader.uint32_src_app_id = paramMessageForDeviceFile.uint32_src_app_id;
      localMsgHeader.uint32_src_inst_id = paramMessageForDeviceFile.uint32_src_inst_id;
      localMsgHeader.uint32_dst_app_id = paramMessageForDeviceFile.uint32_dst_app_id;
      localMsgHeader.uint32_dst_inst_id = paramMessageForDeviceFile.uint32_dst_inst_id;
      localMsgHeader.uint64_dst_uin = paramMessageForDeviceFile.uint64_dst_uin;
      localMsgHeader.uint64_src_uin = paramMessageForDeviceFile.uint64_src_uin;
      localMsgHeader.uint32_src_uin_type = paramMessageForDeviceFile.uint32_src_uin_type;
      localMsgHeader.uint32_dst_uin_type = paramMessageForDeviceFile.uint32_dst_uin_type;
      localMsgHeader.uint32_src_ter_type = paramMessageForDeviceFile.uint32_src_ter_type;
      localMsgHeader.uint32_dst_ter_type = paramMessageForDeviceFile.uint32_dst_ter_type;
      return localMsgHeader;
    }
    return null;
  }
  
  public Session a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      return null;
    }
    Session localSession = new Session();
    localSession.uSessionID = paramMessageForDeviceFile.uSessionID;
    int i = paramMessageForDeviceFile.issend;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localSession.bSend = bool;
    localSession.msgHeader = a(paramMessageForDeviceFile);
    localSession.dwGroupID = paramMessageForDeviceFile.groupId;
    localSession.dwGroupSize = paramMessageForDeviceFile.groupSize;
    localSession.dwGroupIndex = paramMessageForDeviceFile.groupIndex;
    localSession.emFileType = a(paramMessageForDeviceFile.msgtype);
    localSession.strFilePathSrc = paramMessageForDeviceFile.filePath;
    localSession.strFilePathThumb = paramMessageForDeviceFile.thumbPath;
    localSession.uFileSizeSrc = paramMessageForDeviceFile.fileSize;
    localSession.vFileMD5Src = paramMessageForDeviceFile.md5;
    localSession.uOwnerUin = paramMessageForDeviceFile.uOwnerUin;
    localSession.vOfflineFileUUID = paramMessageForDeviceFile.vOfflineFileUUID;
    localSession.uChannelType = paramMessageForDeviceFile.uChannelType;
    if ((QLog.isDevelopLevel()) && (paramMessageForDeviceFile.md5 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSessionFromMsgRecord, uSessionID[");
      localStringBuilder.append(paramMessageForDeviceFile.uSessionID);
      localStringBuilder.append("], strMR[");
      localStringBuilder.append(HexUtil.bytes2HexStr(paramMessageForDeviceFile.md5));
      localStringBuilder.append("], filesize[");
      localStringBuilder.append(paramMessageForDeviceFile.fileSize);
      QLog.d("dataline.Router", 4, localStringBuilder.toString());
    }
    localSession.actionInfo = a(paramMessageForDeviceFile);
    return localSession;
  }
  
  public String a(long paramLong)
  {
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramLong);
    if (localDeviceInfo == null) {
      return BaseApplication.getContext().getString(2131691403);
    }
    return SmartDeviceUtil.a(localDeviceInfo);
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.Router", 2, "--->>logout cancel all task");
    }
    a(32);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelAll(paramInt, false);
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(paramInt, paramLong, 32, paramBoolean);
  }
  
  public void a(int paramInt1, Session paramSession, double paramDouble, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    long l;
    if (paramSession.msgHeader.uint64_src_uin == a()) {
      l = paramSession.msgHeader.uint64_dst_uin;
    } else {
      l = paramSession.msgHeader.uint64_src_uin;
    }
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)MessageRecordFactory.a(-4500);
    localMessageForDeviceFile.uniseq = paramSession.uSessionID;
    localMessageForDeviceFile.msgtype = -4500;
    localMessageForDeviceFile.istroop = 9501;
    localMessageForDeviceFile.filePath = paramSession.strFilePathSrc;
    localMessageForDeviceFile.fileSize = paramSession.uFileSizeSrc;
    localMessageForDeviceFile.issend = 0;
    localMessageForDeviceFile.srcFileName = FileManagerUtil.a(paramSession.strFilePathSrc);
    localMessageForDeviceFile.msgStatus = 3;
    localMessageForDeviceFile.nFileStatus = -1;
    localMessageForDeviceFile.time = MessageCache.a();
    localMessageForDeviceFile.msg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691282);
    localMessageForDeviceFile.nOpType = (paramSession.bSend ^ true);
    localMessageForDeviceFile.selfuin = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageForDeviceFile.senderuin = Long.toString(l);
    localMessageForDeviceFile.frienduin = Long.toString(l);
    if (DeviceMsgHandle.d.equalsIgnoreCase(paramSession.actionInfo.strServiceName))
    {
      localMessageForDeviceFile.nFileMsgType = 2;
      localMessageForDeviceFile.msg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691286);
    }
    else if (DeviceMsgHandle.h.equalsIgnoreCase(paramSession.actionInfo.strServiceName))
    {
      localMessageForDeviceFile.nFileMsgType = 1;
      localMessageForDeviceFile.msg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691282);
    }
    else if (DeviceMsgHandle.b.equalsIgnoreCase(paramSession.actionInfo.strServiceName))
    {
      localMessageForDeviceFile.nFileMsgType = 1;
      localMessageForDeviceFile.msg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691282);
    }
    localMessageForDeviceFile.uSessionID = paramSession.uSessionID;
    localMessageForDeviceFile.fileFrom = paramSession.emFileFrom;
    if (paramSession.vOfflineFileUUID != null) {
      localMessageForDeviceFile.fileUuid = new String(paramSession.vOfflineFileUUID);
    }
    localMessageForDeviceFile.thumbPath = paramSession.strFilePathThumb;
    localMessageForDeviceFile.md5 = paramSession.vFileMD5Src;
    if (paramNFCInfo != null)
    {
      localMessageForDeviceFile.nServerIp = paramNFCInfo.dwServerIP;
      localMessageForDeviceFile.nServerPort = paramNFCInfo.wServerPort;
      localMessageForDeviceFile.vUrlNotify = paramNFCInfo.vUrlNotify;
      localMessageForDeviceFile.vTokenKey = paramNFCInfo.vTokenKey;
    }
    if (paramFTNInfo != null) {
      localMessageForDeviceFile.serverPath = paramFTNInfo.strFileIndex;
    }
    localMessageForDeviceFile.groupId = paramSession.dwGroupID;
    localMessageForDeviceFile.groupSize = paramSession.dwGroupSize;
    localMessageForDeviceFile.groupIndex = paramSession.dwGroupIndex;
    localMessageForDeviceFile.uOwnerUin = paramSession.uOwnerUin;
    localMessageForDeviceFile.vOfflineFileUUID = paramSession.vOfflineFileUUID;
    localMessageForDeviceFile.uChannelType = paramSession.uChannelType;
    localMessageForDeviceFile.strServiceName = paramSession.actionInfo.strServiceName;
    localMessageForDeviceFile.vServiceInfo = paramSession.actionInfo.vServiceInfo;
    localMessageForDeviceFile.uint32_src_app_id = paramSession.msgHeader.uint32_src_app_id;
    localMessageForDeviceFile.uint32_src_inst_id = paramSession.msgHeader.uint32_src_inst_id;
    localMessageForDeviceFile.uint32_dst_app_id = paramSession.msgHeader.uint32_dst_app_id;
    localMessageForDeviceFile.uint32_dst_inst_id = paramSession.msgHeader.uint32_dst_inst_id;
    localMessageForDeviceFile.uint64_dst_uin = paramSession.msgHeader.uint64_dst_uin;
    localMessageForDeviceFile.uint64_src_uin = paramSession.msgHeader.uint64_src_uin;
    localMessageForDeviceFile.uint32_src_uin_type = paramSession.msgHeader.uint32_src_uin_type;
    localMessageForDeviceFile.uint32_dst_uin_type = paramSession.msgHeader.uint32_dst_uin_type;
    localMessageForDeviceFile.uint32_src_ter_type = paramSession.msgHeader.uint32_src_ter_type;
    localMessageForDeviceFile.uint32_dst_ter_type = paramSession.msgHeader.uint32_dst_ter_type;
    localMessageForDeviceFile.serial();
    ((DeviceMsgHandle)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramSession.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForDeviceFile, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void a(RouterMsgRecord paramRouterMsgRecord)
  {
    ProxyManager localProxyManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
    RouterMsgRecord localRouterMsgRecord = paramRouterMsgRecord.clone();
    localProxyManager.addMsgQueue(String.valueOf(0), 0, paramRouterMsgRecord.getTableName(), localRouterMsgRecord, 0, null);
    c(paramRouterMsgRecord);
    a(paramRouterMsgRecord, true);
  }
  
  public void a(ArrayList<FileInfo> paramArrayList, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayList == null) {
      return;
    }
    int j = paramArrayList.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      Object localObject = ((FileInfo)paramArrayList.get(i)).c();
      localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject, null, 0, 0, 0L, 0, 0, 0);
      if (localObject != null)
      {
        localArrayList.add(localObject);
        ((Session)localObject).uSessionID = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
        ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, paramString, paramArrayOfByte);
      }
      i += 1;
    }
    if (localArrayList.size() > 0) {
      a(localArrayList, false);
    }
  }
  
  protected void a(ArrayList<Session> paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.showNoNetworkDialog();
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Session localSession = (Session)paramArrayList.next();
      File localFile = new File(localSession.strFilePathSrc);
      if ((!paramBoolean) && (!localFile.exists())) {
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.showFileNotExistDialog(localFile.getName());
      } else if ((!paramBoolean) && (localFile.length() == 0L)) {
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.showFileIsEmptyDialog(localFile.getName());
      } else if ((!paramBoolean) && (localFile.length() > 2147483648L)) {
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.showFileTooLargeDialog(localFile.getName());
      } else {
        localArrayList.add(localSession);
      }
    }
    if (localArrayList.size() == 0) {
      return;
    }
    paramArrayList = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
    int i = localArrayList.size();
    boolean bool = true;
    if (i == 1) {
      bool = false;
    }
    paramArrayList.SendGroup(localArrayList, paramBoolean, bool);
  }
  
  public boolean a(List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.Router", 2, "manually receives a file . sessionlist");
    }
    int i = paramList.size();
    boolean bool = false;
    if (i > 0)
    {
      Iterator localIterator = paramList.iterator();
      Object localObject5 = null;
      Object localObject1 = null;
      Object localObject2 = localObject1;
      Object localObject4;
      Object localObject3;
      while (localIterator.hasNext())
      {
        MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)localIterator.next();
        if ((localMessageForDeviceFile.srcFileName != null) && (localMessageForDeviceFile.fileSize != 0L))
        {
          if (localMessageForDeviceFile.md5 == null) {
            return false;
          }
          localObject4 = a(localMessageForDeviceFile);
          localObject3 = localObject5;
          if (localObject5 == null) {
            localObject3 = new ArrayList();
          }
          ((List)localObject3).add(localObject4);
          ((DeviceMsgHandle)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
          ((DeviceFileHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a((Session)localObject4);
          localObject5 = new FTNInfo();
          ((FTNInfo)localObject5).strFileIndex = localMessageForDeviceFile.serverPath;
          localObject4 = localObject2;
          if (localObject2 == null) {
            localObject4 = new ArrayList();
          }
          ((List)localObject4).add(localObject5);
          localObject5 = new NFCInfo();
          ((NFCInfo)localObject5).dwServerIP = ((int)localMessageForDeviceFile.nServerIp);
          ((NFCInfo)localObject5).wServerPort = ((short)(int)localMessageForDeviceFile.nServerPort);
          ((NFCInfo)localObject5).vTokenKey = localMessageForDeviceFile.vTokenKey;
          ((NFCInfo)localObject5).vUrlNotify = localMessageForDeviceFile.vUrlNotify;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((List)localObject2).add(localObject5);
          localObject5 = localObject3;
          localObject1 = localObject2;
          localObject2 = localObject4;
        }
        else
        {
          return false;
        }
      }
      if (localObject5 != null)
      {
        localObject3 = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
        localObject4 = (Session[])((List)localObject5).toArray(new Session[((List)localObject5).size()]);
        localObject1 = (NFCInfo[])((List)localObject1).toArray(new NFCInfo[((List)localObject1).size()]);
        localObject2 = (FTNInfo[])((List)localObject2).toArray(new FTNInfo[((List)localObject2).size()]);
        if (paramList.size() != 1) {
          bool = true;
        }
        ((LiteTransferWrapper)localObject3).RecvGroup((Session[])localObject4, (NFCInfo[])localObject1, (FTNInfo[])localObject2, bool);
        return true;
      }
    }
    return false;
  }
  
  public void b(Session paramSession)
  {
    String str = paramSession.strFilePathSrc;
    if ((paramSession.dwGroupID == 0) && (paramSession.bSend) && (paramSession.emFileType == 1) && (str != null) && (new File(str).exists())) {
      URLDrawable.getDrawable(AsyncImageView.a(str, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, true), null, null, false).downloadImediatly();
    }
  }
  
  public void b(RouterMsgRecord paramRouterMsgRecord)
  {
    ProxyManager localProxyManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(paramRouterMsgRecord.status));
    localProxyManager.addMsgQueue(String.valueOf(0), 0, paramRouterMsgRecord.getTableName(), localContentValues, "msgId=?", new String[] { String.valueOf(paramRouterMsgRecord.msgId) }, 1, null);
    a(paramRouterMsgRecord, true);
  }
  
  public boolean getAutoDownload()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("auto_receive_files", false);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return DataLineObserver.class;
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localObject != null) && (((QQAppInterface)localObject).getApp() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver);
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver = null;
    }
    a(32);
    localObject = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
    boolean bool;
    if (this.d.size() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((LiteTransferWrapper)localObject).endLiteTransfer(bool);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler
 * JD-Core Version:    0.7.0.1
 */