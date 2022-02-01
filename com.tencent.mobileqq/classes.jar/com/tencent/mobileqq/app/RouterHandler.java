package com.tencent.mobileqq.app;

import aara;
import aavi;
import aavk;
import abdn;
import abwz;
import amqk;
import android.content.ContentValues;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import anuv;
import anuz;
import aszt;
import bbko;
import bbli;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
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
import com.tencent.litetransfersdk.MsgSCBody0x211;
import com.tencent.litetransfersdk.MsgSCBody0x211_0x7;
import com.tencent.litetransfersdk.MsgSCBody0x346;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.NFCNotify;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ez;
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
  private RouterHandler.NotifyReceiver jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver;
  protected String a;
  public ArrayList<RouterMsgRecord> a;
  private int jdField_b_of_type_Int;
  QQAppInterface jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = null;
  protected HashMap<Long, RouterMsgRecord> d = new HashMap();
  public HashMap<Long, Session> e = new HashMap();
  
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
    paramQQAppInterface.addAction("mqq.intent.action.EXIT_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
    paramQQAppInterface.addAction("mqq.intent.action.LOGOUT");
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver = new RouterHandler.NotifyReceiver(this);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver, paramQQAppInterface);
  }
  
  public static int a(int paramInt)
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
  
  public static long a()
  {
    return ((aara)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(51)).a();
  }
  
  private void a(int paramInt, FTNNotify paramFTNNotify, long paramLong)
  {
    paramFTNNotify = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFTNNotify(paramFTNNotify, paramLong, AppConstants.DATALINE_PC_UIN, 1).toByteArray();
    ((aara)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51)).a(paramLong, paramInt, paramFTNNotify);
  }
  
  private void a(int paramInt, FileControl paramFileControl, long paramLong)
  {
    paramFileControl = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFileControl(paramFileControl, paramLong, AppConstants.DATALINE_PC_UIN, 3).toByteArray();
    ((aara)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51)).a(paramLong, paramInt, paramFileControl);
  }
  
  private void a(int paramInt, MsgCSBody0x211 paramMsgCSBody0x211)
  {
    switch (paramMsgCSBody0x211.uMsgSubType)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Router", 2, "SendPbMsg: cannot recognize the pb msg form 0X211");
      }
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
    int i = 0;
    long l = paramMsgCSBody0x211_0x7.msgHeader.uint64_dst_uin;
    switch (paramMsgCSBody0x211_0x7.uMsgSubCmd)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Router", 2, "SendPbMsg: cannot recognize the pb msg form 0X211_0x7");
      }
      break;
    }
    for (;;)
    {
      return;
      while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc.length)
      {
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc[i], l);
        i += 1;
      }
      while (j < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc.length)
      {
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc[j], l);
        j += 1;
      }
      continue;
      while (k < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl.length)
      {
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl[k], l);
        k += 1;
      }
      continue;
      while (m < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb.length)
      {
        paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[m].bytes_originfile_md5 = null;
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[m], l);
        m += 1;
      }
      continue;
      while (n < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb.length)
      {
        paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[n].bytes_originfile_md5 = null;
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[n], l);
        n += 1;
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
    ((aara)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51)).a(paramMsgCSBody0x346.uMsgSubType, paramInt, localReqBody.toByteArray());
  }
  
  private void a(int paramInt, NFCNotify paramNFCNotify, long paramLong)
  {
    paramNFCNotify = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromNFCNotify(paramNFCNotify, paramLong, AppConstants.DATALINE_PC_UIN, 2).toByteArray();
    ((aara)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51)).a(paramLong, paramInt, paramNFCNotify);
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    paramArrayOfByte1 = new MsgSCBody();
    paramArrayOfByte1.uMsgType = 529;
    paramArrayOfByte1.msgBody0x211 = new MsgSCBody0x211();
    paramArrayOfByte1.msgBody0x211.uMsgSubType = 7;
    paramArrayOfByte1.msgBody0x211.msgBody0x211_0x7 = new MsgSCBody0x211_0x7();
    paramArrayOfByte1.bTimeOut = paramBoolean;
    paramArrayOfByte2 = paramArrayOfByte1.msgBody0x211.msgBody0x211_0x7;
    if (!paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      paramArrayOfByte2.uResult = i;
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Router", 2, "DoCCReply : nCookie[" + paramInt + "], isTimeout[" + paramBoolean);
      }
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(paramInt, paramArrayOfByte1);
      return;
    }
  }
  
  private void a(long paramLong, SubMsgType0x7.MsgBody.GenericSubCmd paramGenericSubCmd)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals("router")) {}
    for (;;)
    {
      return;
      try
      {
        if (paramGenericSubCmd.uint32_type.has())
        {
          paramGenericSubCmd.uint32_type.get();
          return;
        }
      }
      catch (Exception paramGenericSubCmd)
      {
        paramGenericSubCmd.printStackTrace();
      }
    }
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (SubMsgType0x7.MsgBody)localMsgBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte.msg_header.uint32_src_app_id.set(1001);
        paramArrayOfByte.msg_header.uint32_src_inst_id.set(0);
        paramArrayOfByte.msg_header.uint32_dst_app_id.set(AppSetting.a());
        paramArrayOfByte.msg_header.uint32_dst_inst_id.set(0);
        paramArrayOfByte.msg_header.uint64_src_uin.set(paramLong);
        paramArrayOfByte.msg_header.setHasFlag(true);
        if (paramArrayOfByte.uint32_sub_cmd.has())
        {
          i = paramArrayOfByte.uint32_sub_cmd.get();
          switch (i)
          {
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          default: 
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("dataline.Router", 2, "onRecvRouterMsg : subMsgType[0x7] failed", paramArrayOfByte);
        return;
      }
      int i = 0;
    }
    b(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0x1_ftn_notify.get(), false);
    return;
    a(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0x2_nfc_notify.get(), false);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("dataline.Router", 2, "app 文件控制命令");
    }
    a(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0x3_filecontrol.get());
    return;
    a(paramLong, paramArrayOfByte.msg_subcmd_0x4_generic);
    return;
    b(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0x9_ftn_thumb_notify.get(), true);
    return;
    a(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0xa_nfc_thumb_notify.get(), true);
  }
  
  private void a(RouterMsgRecord paramRouterMsgRecord, boolean paramBoolean)
  {
    String str = abwz.a(String.valueOf(paramRouterMsgRecord.peerDin), 6002);
    boolean bool = false;
    QQMessageFacade localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localQQMessageFacade == null) {}
    do
    {
      return;
      if (localQQMessageFacade.cachedMsg.containsKey(str))
      {
        bool = ((QQMessageFacade.Message)localQQMessageFacade.cachedMsg.get(str)).hasReply;
        localQQMessageFacade.cachedMsg.remove(str);
      }
      paramRouterMsgRecord.frienduin = String.valueOf(paramRouterMsgRecord.peerDin);
      QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
      MessageRecord.copyMessageRecordBaseField(localMessage, paramRouterMsgRecord);
      localMessage.emoRecentMsg = null;
      localMessage.hasReply = bool;
      localQQMessageFacade.decodeMsg(localMessage);
      localQQMessageFacade.cachedMsg.put(str, localMessage);
    } while (!paramBoolean);
    a(String.valueOf(paramRouterMsgRecord.peerDin));
  }
  
  private void a(String paramString)
  {
    QQMessageFacade localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localQQMessageFacade == null) {}
    do
    {
      return;
      EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramString = (RecentUser)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().findRecentUserByUin(paramString, 6002);
      localEntityManager.close();
    } while (paramString == null);
    localQQMessageFacade.setChangeAndNotify(paramString);
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
    return ((aara)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(51)).a(paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public static boolean a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    return ((aara)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(51)).a(paramLong, paramInt, paramArrayOfByte);
  }
  
  private int b(int paramInt)
  {
    if (paramInt == 3) {}
    do
    {
      return -2005;
      if (paramInt == 1) {
        return -2000;
      }
    } while (paramInt != 2);
    return -2005;
  }
  
  private void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
        if (QLog.isColorLevel()) {
          QLog.e("dataline.Router", 2, "DoCSReply : reqBuff is null");
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
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
          catch (InvalidProtocolBufferMicroException paramArrayOfByte1) {}
        } while (!QLog.isColorLevel());
        QLog.e("dataline.Router", 2, "DoCSReply : cmd0x346.ReqBody prase failed", paramArrayOfByte1);
        return;
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("dataline.Router", 2, "DoCSReply : rspBuff is null");
      return;
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
      catch (InvalidProtocolBufferMicroException paramArrayOfByte1) {}
    } while (!QLog.isColorLevel());
    QLog.e("dataline.Router", 2, "DoCSReply : cmd0x346.rspBody prase failed", paramArrayOfByte1);
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
    anuz localanuz = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    localObject = (RecentUser)localanuz.findRecentUserByUin((String)localObject, 6002);
    ((RecentUser)localObject).setType(6002);
    ((RecentUser)localObject).lastmsgtime = bbko.a();
    ((RecentUser)localObject).displayName = str;
    ((RecentUser)localObject).msgType = paramRouterMsgRecord.msgtype;
    localanuz.saveRecentUser((BaseRecentUser)localObject);
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
    ez.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramReportItem, ez.d);
  }
  
  public void OnGroupComplete(int paramInt1, int paramInt2) {}
  
  public void OnGroupStart(int paramInt) {}
  
  public boolean OnQueryAutoDownload(long paramLong, byte paramByte)
  {
    boolean bool2 = false;
    if (paramByte == 2)
    {
      boolean bool1 = NetworkUtil.isWifiConnected(BaseApplication.getContext());
      if (paramLong <= 3145728L) {}
      for (paramByte = 1;; paramByte = 0)
      {
        if (!bool1)
        {
          bool1 = bool2;
          if (getAutoDownload())
          {
            bool1 = bool2;
            if (paramByte == 0) {}
          }
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
    }
    return true;
  }
  
  public void OnSessionComplete(long paramLong, int paramInt1, int paramInt2)
  {
    QLog.d("dataline.Router", 1, "OnSessionComplete uSessionID=" + paramLong + " retCode=" + paramInt2 + " TaskStatus=" + paramInt1);
    new Handler(Looper.getMainLooper()).post(new RouterHandler.7(this, paramLong, paramInt1));
  }
  
  public void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo)
  {
    new Handler(Looper.getMainLooper()).post(new RouterHandler.4(this, paramSession));
  }
  
  public void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    new Handler(Looper.getMainLooper()).post(new RouterHandler.6(this, paramLong1, paramLong2, paramLong3));
  }
  
  public void OnSessionStart(long paramLong)
  {
    new Handler(Looper.getMainLooper()).post(new RouterHandler.5(this, paramLong));
  }
  
  public void OnSessionUpdate(int paramInt, long paramLong, String paramString) {}
  
  public void SendPbMsg(int paramInt, MsgCSBody paramMsgCSBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.Router", 2, "SendPbMsg: msgBody.uMsgType[" + paramMsgCSBody.uMsgType + "], nCookie[" + paramInt);
    }
    switch (paramMsgCSBody.uMsgType)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Router", 2, "SendPbMsg: cannot recognize the pb msg form JNI");
      }
      return;
    case 529: 
      a(paramInt, paramMsgCSBody.msgBody0x211);
      return;
    }
    a(paramInt, paramMsgCSBody.msgBody0x346);
  }
  
  public QQMessageFacade.Message a(String paramString)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    ProxyManager localProxyManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
    EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (anuv.a(localProxyManager, RouterMsgRecord.sBasicTableName + paramString)) {
      localProxyManager.transSaveToDatabase(localEntityManager);
    }
    paramString = localEntityManager.rawQuery(RouterMsgRecord.class, "select * from " + RouterMsgRecord.sBasicTableName + paramString + " order by msgid desc", null);
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
    ActionInfo localActionInfo = null;
    if (paramMessageForDeviceFile != null)
    {
      localActionInfo = new ActionInfo();
      localActionInfo.strServiceName = paramMessageForDeviceFile.strServiceName;
      localActionInfo.vServiceInfo = paramMessageForDeviceFile.vServiceInfo;
    }
    return localActionInfo;
  }
  
  public MsgHeader a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    MsgHeader localMsgHeader = null;
    if (paramMessageForDeviceFile != null)
    {
      localMsgHeader = new MsgHeader();
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
    }
    return localMsgHeader;
  }
  
  public Session a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    boolean bool = true;
    if (paramMessageForDeviceFile == null) {
      return null;
    }
    Session localSession = new Session();
    localSession.uSessionID = paramMessageForDeviceFile.uSessionID;
    if (paramMessageForDeviceFile.issend == 1) {}
    for (;;)
    {
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
      if ((QLog.isDevelopLevel()) && (paramMessageForDeviceFile.md5 != null)) {
        QLog.d("dataline.Router", 4, "getSessionFromMsgRecord, uSessionID[" + paramMessageForDeviceFile.uSessionID + "], strMR[" + HexUtil.bytes2HexStr(paramMessageForDeviceFile.md5) + "], filesize[" + paramMessageForDeviceFile.fileSize);
      }
      localSession.actionInfo = a(paramMessageForDeviceFile);
      return localSession;
      bool = false;
    }
  }
  
  public String a(long paramLong)
  {
    DeviceInfo localDeviceInfo = ((aara)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51)).a(paramLong);
    if (localDeviceInfo == null) {
      return BaseApplication.getContext().getString(2131691286);
    }
    return abdn.a(localDeviceInfo);
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
    if (paramSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Router", 2, "updateSession时，session为空, updateType[" + paramInt1 + "], fProgress[" + paramDouble + "], emTaskStatus[" + paramInt2);
      }
      return;
    }
    switch (paramInt1)
    {
    }
    Object localObject;
    label168:
    label461:
    label466:
    do
    {
      paramInt1 = 0;
      bool = false;
      paramSession = null;
      for (;;)
      {
        notifyUI(paramInt1, bool, paramSession);
        return;
        long l = this.jdField_a_of_type_Long + 1L;
        this.jdField_a_of_type_Long = l;
        localObject = new RouterMsgRecord(l);
        aara localaara = (aara)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51);
        if (paramSession.msgHeader.uint64_src_uin == localaara.a())
        {
          l = paramSession.msgHeader.uint64_dst_uin;
          ((RouterMsgRecord)localObject).setTableName(String.valueOf(l));
          ((RouterMsgRecord)localObject).uSessionID = paramSession.uSessionID;
          if (QLog.isColorLevel()) {
            QLog.d("dataline.Router", 2, "获得sessionID=" + ((RouterMsgRecord)localObject).uSessionID + ", path=" + paramSession.strFilePathSrc + "din:" + l);
          }
          ((RouterMsgRecord)localObject).filename = paramSession.strFilePathSrc;
          ((RouterMsgRecord)localObject).fileSize = paramSession.uFileSizeSrc;
          if (!paramSession.bSend) {
            break label461;
          }
          paramInt1 = 1;
          ((RouterMsgRecord)localObject).issend = paramInt1;
          ((RouterMsgRecord)localObject).peerDin = l;
          ((RouterMsgRecord)localObject).msg = "file";
          ((RouterMsgRecord)localObject).msgtype = b(paramSession.emFileType);
          ((RouterMsgRecord)localObject).extInt = 1;
          ((RouterMsgRecord)localObject).time = bbko.a();
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          a((RouterMsgRecord)localObject);
          this.d.put(Long.valueOf(((RouterMsgRecord)localObject).uSessionID), localObject);
          if (!paramSession.bSend) {
            break label466;
          }
        }
        for (paramInt1 = 7;; paramInt1 = 6)
        {
          bool = true;
          localObject = new Object[7];
          localObject[0] = Long.valueOf(0L);
          localObject[1] = Long.valueOf(paramSession.uSessionID);
          localObject[2] = paramSession.strFilePathSrc;
          localObject[3] = Byte.valueOf((byte)paramSession.emFileType);
          localObject[4] = Boolean.valueOf(false);
          localObject[5] = Boolean.valueOf(false);
          localObject[6] = Long.valueOf(paramSession.uFileSizeSrc);
          paramSession = (Session)localObject;
          break;
          l = paramSession.msgHeader.uint64_src_uin;
          break label168;
          paramInt1 = 0;
          break label274;
        }
        localObject = (RouterMsgRecord)this.d.get(Long.valueOf(paramSession.uSessionID));
        if (localObject == null) {
          break;
        }
        ((RouterMsgRecord)localObject).status = 2;
        ((RouterMsgRecord)localObject).progress = paramDouble;
        if (paramSession.bSend) {}
        for (paramInt1 = 7;; paramInt1 = 6)
        {
          bool = true;
          localObject = new Object[7];
          localObject[0] = Long.valueOf(0L);
          localObject[1] = Long.valueOf(paramSession.uSessionID);
          localObject[2] = paramSession.strFilePathSrc;
          localObject[3] = Byte.valueOf((byte)paramSession.emFileType);
          localObject[4] = Boolean.valueOf(false);
          localObject[5] = Boolean.valueOf(true);
          localObject[6] = Long.valueOf(paramSession.uFileSizeSrc);
          paramSession = (Session)localObject;
          break;
        }
        localObject = (RouterMsgRecord)this.d.get(Long.valueOf(paramSession.uSessionID));
        if (localObject == null) {
          break;
        }
        ((RouterMsgRecord)localObject).status = 2;
        ((RouterMsgRecord)localObject).progress = ((float)paramDouble);
        paramInt1 = 4;
        bool = true;
        localObject = new Object[3];
        localObject[0] = Long.valueOf(0L);
        localObject[1] = Long.valueOf(paramSession.uSessionID);
        localObject[2] = Float.valueOf((float)paramDouble);
        paramSession = (Session)localObject;
      }
      localObject = (RouterMsgRecord)this.d.get(Long.valueOf(paramSession.uSessionID));
    } while (localObject == null);
    label274:
    if (paramInt2 == 2)
    {
      ((RouterMsgRecord)localObject).progress = 1.0D;
      ((RouterMsgRecord)localObject).status = 3;
      label732:
      ((RouterMsgRecord)localObject).msgtype = b(paramSession.emFileType);
      ((RouterMsgRecord)localObject).msg = "file";
      ((RouterMsgRecord)localObject).extInt = ((RouterMsgRecord)localObject).status;
      ((RouterMsgRecord)localObject).time = bbko.a();
      b((RouterMsgRecord)localObject);
      if (((RouterMsgRecord)localObject).status != 5) {
        this.d.remove(Long.valueOf(paramSession.uSessionID));
      }
      if (!paramSession.bSend) {
        break label897;
      }
      paramInt1 = 2;
      label810:
      if (paramInt2 != 2) {
        break label902;
      }
    }
    label897:
    label902:
    for (boolean bool = true;; bool = false)
    {
      localObject = new Object[3];
      localObject[0] = Long.valueOf(0L);
      localObject[1] = Long.valueOf(paramSession.uSessionID);
      localObject[2] = paramSession.strFilePathSrc;
      paramSession = (Session)localObject;
      break;
      if ((paramInt2 == 32) || (paramInt2 == 11) || (paramInt2 == 8))
      {
        ((RouterMsgRecord)localObject).status = 5;
        break label732;
      }
      ((RouterMsgRecord)localObject).status = 4;
      break label732;
      paramInt1 = 3;
      break label810;
    }
  }
  
  public void a(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    long l;
    MessageForDeviceFile localMessageForDeviceFile;
    int i;
    if (paramSession.msgHeader.uint64_src_uin == a())
    {
      l = paramSession.msgHeader.uint64_dst_uin;
      localMessageForDeviceFile = (MessageForDeviceFile)bbli.a(-4500);
      localMessageForDeviceFile.uniseq = paramSession.uSessionID;
      localMessageForDeviceFile.msgtype = -4500;
      localMessageForDeviceFile.istroop = 9501;
      localMessageForDeviceFile.filePath = paramSession.strFilePathSrc;
      localMessageForDeviceFile.fileSize = paramSession.uFileSizeSrc;
      localMessageForDeviceFile.issend = 0;
      localMessageForDeviceFile.srcFileName = aszt.a(paramSession.strFilePathSrc);
      localMessageForDeviceFile.msgStatus = 3;
      localMessageForDeviceFile.nFileStatus = -1;
      localMessageForDeviceFile.time = bbko.a();
      localMessageForDeviceFile.msg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691168);
      if (!paramSession.bSend) {
        break label616;
      }
      i = 0;
      label151:
      localMessageForDeviceFile.nOpType = i;
      localMessageForDeviceFile.selfuin = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localMessageForDeviceFile.senderuin = Long.toString(l);
      localMessageForDeviceFile.frienduin = Long.toString(l);
      if (!aavk.d.equalsIgnoreCase(paramSession.actionInfo.strServiceName)) {
        break label622;
      }
      localMessageForDeviceFile.nFileMsgType = 2;
      localMessageForDeviceFile.msg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691172);
    }
    for (;;)
    {
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
      ((aavk)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(49)).a().a(paramSession.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(localMessageForDeviceFile, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
      l = paramSession.msgHeader.uint64_src_uin;
      break;
      label616:
      i = 1;
      break label151;
      label622:
      if (aavk.h.equalsIgnoreCase(paramSession.actionInfo.strServiceName))
      {
        localMessageForDeviceFile.nFileMsgType = 1;
        localMessageForDeviceFile.msg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691168);
      }
      else if (aavk.b.equalsIgnoreCase(paramSession.actionInfo.strServiceName))
      {
        localMessageForDeviceFile.nFileMsgType = 1;
        localMessageForDeviceFile.msg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691168);
      }
    }
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
    if (paramArrayList == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      int j = paramArrayList.size();
      localArrayList = new ArrayList();
      int i = 0;
      if (i < j)
      {
        Object localObject = ((FileInfo)paramArrayList.get(i)).c();
        localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject, null, 0, 0, 0L, 0, 0, 0);
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localArrayList.add(localObject);
          ((Session)localObject).uSessionID = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
          ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong);
          this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, paramString, paramArrayOfByte);
        }
      }
    } while (localArrayList.size() <= 0);
    a(localArrayList, false);
  }
  
  protected void a(ArrayList<Session> paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.showNoNetworkDialog();
    }
    do
    {
      return;
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
    } while (localArrayList.size() == 0);
    paramArrayList = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
    if (localArrayList.size() == 1) {}
    for (boolean bool = false;; bool = true)
    {
      paramArrayList.SendGroup(localArrayList, paramBoolean, bool);
      return;
    }
  }
  
  public boolean a(List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.Router", 2, "manually receives a file . sessionlist");
    }
    Object localObject2;
    Object localObject1;
    Object localObject4;
    Object localObject3;
    MessageForDeviceFile localMessageForDeviceFile;
    Object localObject5;
    if (paramList.size() > 0)
    {
      localObject2 = null;
      localObject1 = null;
      localObject4 = paramList.iterator();
      localObject3 = null;
      if (((Iterator)localObject4).hasNext())
      {
        localMessageForDeviceFile = (MessageForDeviceFile)((Iterator)localObject4).next();
        if ((localMessageForDeviceFile.srcFileName == null) || (localMessageForDeviceFile.fileSize == 0L) || (localMessageForDeviceFile.md5 == null)) {
          return false;
        }
        localObject5 = a(localMessageForDeviceFile);
        if (localObject2 != null) {
          break label420;
        }
        localObject2 = new ArrayList();
      }
    }
    label420:
    for (;;)
    {
      ((List)localObject2).add(localObject5);
      ((aavk)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(49)).a().a(localMessageForDeviceFile.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
      ((DeviceFileHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(50)).a((Session)localObject5);
      localObject5 = new FTNInfo();
      ((FTNInfo)localObject5).strFileIndex = localMessageForDeviceFile.serverPath;
      if (localObject3 == null) {
        localObject3 = new ArrayList();
      }
      for (;;)
      {
        ((List)localObject3).add(localObject5);
        localObject5 = new NFCInfo();
        ((NFCInfo)localObject5).dwServerIP = ((int)localMessageForDeviceFile.nServerIp);
        ((NFCInfo)localObject5).wServerPort = ((short)(int)localMessageForDeviceFile.nServerPort);
        ((NFCInfo)localObject5).vTokenKey = localMessageForDeviceFile.vTokenKey;
        ((NFCInfo)localObject5).vUrlNotify = localMessageForDeviceFile.vUrlNotify;
        if (localObject1 == null) {
          localObject1 = new ArrayList();
        }
        for (;;)
        {
          ((List)localObject1).add(localObject5);
          break;
          if (localObject2 != null)
          {
            localObject4 = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
            localObject2 = (Session[])((List)localObject2).toArray(new Session[((List)localObject2).size()]);
            localObject1 = (NFCInfo[])((List)localObject1).toArray(new NFCInfo[((List)localObject1).size()]);
            localObject3 = (FTNInfo[])((List)localObject3).toArray(new FTNInfo[((List)localObject3).size()]);
            if (paramList.size() == 1) {}
            for (boolean bool = false;; bool = true)
            {
              ((LiteTransferWrapper)localObject4).RecvGroup((Session[])localObject2, (NFCInfo[])localObject1, (FTNInfo[])localObject3, bool);
              return true;
            }
          }
          return false;
        }
      }
    }
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
    return amqk.class;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver);
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver = null;
    }
    a(32);
    LiteTransferWrapper localLiteTransferWrapper = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
    if (this.d.size() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localLiteTransferWrapper.endLiteTransfer(bool);
      return;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler
 * JD-Core Version:    0.7.0.1
 */