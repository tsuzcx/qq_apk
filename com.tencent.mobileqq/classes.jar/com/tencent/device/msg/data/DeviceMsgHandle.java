package com.tencent.device.msg.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.common.util.SubString;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class DeviceMsgHandle
  extends BusinessHandler
{
  public static final String a;
  public static String b;
  public static HashMap<String, List<MessageRecord>> b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new DeviceMsgHandle.2(this);
  public DeviceAVFileMsgObserver a;
  private DeviceFileObserver jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver = new DeviceMsgHandle.1(this);
  public DevSingleStructMsgProcessor a;
  private DeviceComnFileMsgProcessor jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor;
  public DeviceGroupChatMsgProcessor a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new DeviceMsgHandle.4(this);
  public HashMap<String, List<DeviceFileObserver>> a;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  public ConcurrentHashMap<Long, MessageRecord> a;
  private List<Long> b;
  public ConcurrentHashMap<Long, MessageRecord> b;
  
  static
  {
    jdField_a_of_type_JavaLangString = MessageForDeviceFile.class.getSimpleName();
    jdField_b_of_type_JavaLangString = "FileMsg";
    c = "CloudPrintMsg";
    d = "ImgMsg";
    e = "VideoMsg";
    f = "AudioMsg";
    g = "Device";
    h = "7000-NASDevPushFile";
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public DeviceMsgHandle(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver);
    this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor = new DeviceComnFileMsgProcessor(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor = new DevSingleStructMsgProcessor(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver = new DeviceAVFileMsgObserver();
    this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceGroupChatMsgProcessor = new DeviceGroupChatMsgProcessor(paramQQAppInterface);
    a(f, this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    a(e, this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    a(g, this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    a(g, this.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor);
    a(g, this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceGroupChatMsgProcessor);
    a(jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    a(c, this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    a(d, this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    a(h, this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    a("8000-NASDevMusicFile", this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    a("8001-NASDevVideoFile", this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    a("8002-NASDevDocumentFile", this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    a("8003-NASDevCommonFile", this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    a("", this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    a("", this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("SmartDevice_DeviceUnBindRst");
    localIntentFilter.addAction("SmartDevice_DeviceAdminUnbind");
    localIntentFilter.addAction("DeviceSomebodyJoin");
    localIntentFilter.addAction("DeviceSomebodyQuit");
    localIntentFilter.addAction("DeviceSomebodyReject");
    localIntentFilter.addAction("SmartDevice_receiveDPMsg");
    localIntentFilter.addAction("SmartDevice_DeviceVasFlagChange");
    localIntentFilter.addAction("SmartDevice_QueryIsDeviceBinded");
    localIntentFilter.addAction("SmartDevice_sendCCDataPointMsgResult");
    localIntentFilter.addAction("SmartDevice_OnMiniFileTransferProgress");
    localIntentFilter.addAction("SmartDevice_OnMiniFileTransferComplete");
    localIntentFilter.addAction("SmartDevice_OnDataPointFileMsgProgress");
    localIntentFilter.addAction("SmartDevice_OnDataPointFileMsgSendRet");
    localIntentFilter.addAction("SmartDevice_DeviceBindRst");
    localIntentFilter.addAction("On_OccupyMicrophoneNotify_Push");
    localIntentFilter.addAction("SmartDevice_sendToAIO_Capture");
    localIntentFilter.addAction("SmartDevice_sendToAIO_Mp4");
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.smartdevice.permission.broadcast", null);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    paramQQAppInterface = (SecSvcHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "DeviceMsgHandle init success!");
    }
  }
  
  public static MessageRecord a(String paramString, long paramLong)
  {
    List localList = (List)jdField_b_of_type_JavaUtilHashMap.get(paramString);
    paramString = null;
    if (localList == null) {
      return null;
    }
    int i = 0;
    while (i < localList.size())
    {
      paramString = (MessageRecord)localList.get(i);
      if (paramString.uniseq == paramLong)
      {
        localList.remove(i);
        return paramString;
      }
      i += 1;
    }
    return paramString;
  }
  
  private void a()
  {
    DeviceInfo[] arrayOfDeviceInfo = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a();
    if ((arrayOfDeviceInfo != null) && (arrayOfDeviceInfo.length > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.handleReceivedMessage(1, true, true);
    }
  }
  
  private void a(long paramLong1, String paramString1, String paramString2, long paramLong2, boolean paramBoolean)
  {
    MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)MessageRecordFactory.a(-4508);
    localMessageForDeviceText.msgtype = -4508;
    localMessageForDeviceText.istroop = 9501;
    localMessageForDeviceText.issend = 0;
    localMessageForDeviceText.isread = false;
    localMessageForDeviceText.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageForDeviceText.senderuin = String.valueOf(paramLong1);
    localMessageForDeviceText.frienduin = paramString1;
    localMessageForDeviceText.msg = paramString2;
    localMessageForDeviceText.time = paramLong2;
    if (paramBoolean) {
      localMessageForDeviceText.extStr = "device_groupchat";
    }
    paramString1 = new ArrayList();
    paramString1.add(localMessageForDeviceText);
    a(paramString1);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
  {
    paramString4 = SubString.a(paramString4, 45, "UTF-8", "...");
    paramString5 = SubString.a(paramString5, 90, "UTF-8", "...");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ChatActivityConstants.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("http://maps.google.com/maps?q=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("&iwloc=A&hl=zh-CN (");
    ((StringBuilder)localObject).append(paramString5);
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    if (!paramContext.getResources().getString(2131696092).equals(paramString4))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getResources().getString(2131691285));
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString4);
      paramContext = localStringBuilder.toString();
    }
    else
    {
      paramContext = paramContext.getResources().getString(2131691285);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&lon=");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("&title=");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("&loc=");
    localStringBuilder.append(paramString5);
    localStringBuilder.append("&dpid=");
    localStringBuilder.append(paramString6);
    paramString2 = localStringBuilder.toString();
    paramContext = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(32).a(paramContext).d((String)localObject).a("plugin", paramString2, paramString2, paramString2, paramString2).a();
    paramString2 = StructMsgElementFactory.a(2);
    paramString2.a("https://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramString4, paramString5);
    paramContext.addItem(paramString2);
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramContext = MessageRecordFactory.a(paramString2, paramString2.getCurrentAccountUin(), paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 9501, 100L, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    Object localObject = (List)jdField_b_of_type_JavaUtilHashMap.get(paramMessageRecord.frienduin);
    if (localObject == null)
    {
      localObject = new ArrayList();
      ((List)localObject).add(paramMessageRecord);
      jdField_b_of_type_JavaUtilHashMap.put(paramMessageRecord.frienduin, localObject);
      return;
    }
    ((List)localObject).add(paramMessageRecord);
  }
  
  private void a(String paramString, long paramLong)
  {
    paramString = a(paramString, paramLong);
    if (paramString == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).postDelayed(new DeviceMsgHandle.3(this, paramString), 0L);
  }
  
  private void a(List<MessageRecord> paramList)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (QLog.isDevelopLevel())
    {
      paramList = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cost:");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.d(paramList, 4, localStringBuilder.toString());
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("nodisturb", 0);
      if (i == 1) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private void b(String paramString, long paramLong)
  {
    paramString = a(paramString, paramLong);
    if (paramString == null) {
      return;
    }
    paramString.extraflag = 32768;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramString.frienduin, paramString.istroop, paramString.uniseq);
    String str = paramString.frienduin;
    int i = paramString.istroop;
    paramLong = paramString.uniseq;
    ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.a(paramString.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(paramLong) });
  }
  
  public DeviceAVFileMsgObserver a()
  {
    return this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver;
  }
  
  public DevSingleStructMsgProcessor a()
  {
    return this.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor;
  }
  
  public DeviceComnFileMsgProcessor a()
  {
    return this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor;
  }
  
  public DeviceGroupChatMsgProcessor a()
  {
    return this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceGroupChatMsgProcessor;
  }
  
  public void a(DataPoint paramDataPoint)
  {
    try
    {
      localObject = new JSONObject(paramDataPoint.mValue);
      long l = ((JSONObject)localObject).optLong("msg_time", MessageCache.a());
      localObject = ((JSONObject)localObject).optString("text", " ");
      a(Long.toString(paramDataPoint.mDin), (String)localObject, l, null);
      return;
    }
    catch (Exception paramDataPoint)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRecvRawTextMsg parse from json error:");
        localStringBuilder.append(paramDataPoint.getMessage());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForDeviceText paramMessageForDeviceText)
  {
    paramQQAppInterface.getMessageFacade().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramMessageForDeviceText.uniseq);
    boolean bool = "device_groupchat".equals(paramMessageForDeviceText.extStr);
    a(paramQQAppInterface, paramSessionInfo, paramMessageForDeviceText.msg, bool);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = BusinessUtils.a(paramString, 560, 20, null, new ArrayList());
    int i = 0;
    while (i < localArrayList.size())
    {
      paramString = (String)localArrayList.get(i);
      if (paramString != null) {
        paramString = MessageUtils.a(paramString, true, null);
      } else {
        paramString = "";
      }
      int j = (int)MessageCache.a();
      String str1 = paramQQAppInterface.getCurrentAccountUin();
      String str2 = paramBaseSessionInfo.jdField_a_of_type_JavaLangString;
      long l1 = MessageUtils.a(i);
      MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)MessageRecordFactory.a(-4508);
      String str3 = paramBaseSessionInfo.jdField_a_of_type_JavaLangString;
      long l2 = j;
      j = paramBaseSessionInfo.jdField_a_of_type_Int;
      long l3 = i;
      localMessageForDeviceText.init(str1, str3, str2, paramString, l2, -4508, j, l3);
      localMessageForDeviceText.longMsgCount = localArrayList.size();
      localMessageForDeviceText.longMsgIndex = ((byte)i);
      localMessageForDeviceText.longMsgId = i;
      localMessageForDeviceText.isread = true;
      localMessageForDeviceText.msgUid = l1;
      localMessageForDeviceText.shmsgseq = MessageUtils.a(l3, paramBaseSessionInfo.jdField_a_of_type_Int);
      localMessageForDeviceText.issend = 1;
      localMessageForDeviceText.mAnimFlag = true;
      localMessageForDeviceText.mNewAnimFlag = true;
      if (paramBoolean) {
        localMessageForDeviceText.extStr = "device_groupchat";
      }
      if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) {
        localMessageForDeviceText.extraflag = 32768;
      }
      paramQQAppInterface.getMessageFacade().a(localMessageForDeviceText, str1);
      a(localMessageForDeviceText);
      if (localMessageForDeviceText.extraflag != 32768) {
        paramQQAppInterface.getMsgCache().a(localMessageForDeviceText);
      }
      if (localMessageForDeviceText.extraflag != 32768)
      {
        l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        ((SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(localMessageForDeviceText.msg, Long.parseLong(localMessageForDeviceText.frienduin), l1, localMessageForDeviceText.msgseq);
      }
      i += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)MessageRecordFactory.a(-4508);
    localMessageForDeviceText.msgtype = -4508;
    localMessageForDeviceText.istroop = 9501;
    localMessageForDeviceText.issend = 0;
    localMessageForDeviceText.isread = false;
    localMessageForDeviceText.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageForDeviceText.senderuin = paramString1;
    localMessageForDeviceText.frienduin = paramString1;
    localMessageForDeviceText.msg = paramString2;
    localMessageForDeviceText.time = paramLong;
    localMessageForDeviceText.extStr = paramString3;
    paramString1 = new ArrayList();
    paramString1.add(localMessageForDeviceText);
    a(paramString1);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a(String paramString, DeviceFileObserver paramDeviceFileObserver)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    if (!((List)localObject).contains(paramDeviceFileObserver)) {
      ((List)localObject).add(paramDeviceFileObserver);
    }
    return true;
  }
  
  public boolean b(String paramString, DeviceFileObserver paramDeviceFileObserver)
  {
    paramString = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      paramString.remove(paramDeviceFileObserver);
    }
    return true;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return BusinessObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b(f, this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    b(e, this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    b(g, this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    b(g, this.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor);
    b(jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    b(c, this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    b(d, this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    b(h, this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    b("8000-NASDevMusicFile", this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    b("8001-NASDevVideoFile", this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    b("8002-NASDevDocumentFile", this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    b("8003-NASDevCommonFile", this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    b("", this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    b("", this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor = null;
    this.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor = null;
    this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver = null;
    this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceGroupChatMsgProcessor = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceMsgHandle
 * JD-Core Version:    0.7.0.1
 */