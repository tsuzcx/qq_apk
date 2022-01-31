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
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
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
import com.tencent.mobileqq.util.Utils;
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
import qbg;
import qbh;
import qbi;
import qbj;

public class DeviceMsgHandle
  extends BusinessHandler
{
  public static final String a;
  public static String b;
  public static HashMap b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new qbh(this);
  public DeviceAVFileMsgObserver a;
  private DeviceFileObserver jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver = new qbg(this);
  public DevSingleStructMsgProcessor a;
  private DeviceComnFileMsgProcessor jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor;
  public DeviceGroupChatMsgProcessor a;
  SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new qbj(this);
  public HashMap a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public ConcurrentHashMap a;
  private List b;
  public ConcurrentHashMap b;
  
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
    paramQQAppInterface = (SecSvcHandler)paramQQAppInterface.a(34);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.c();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "DeviceMsgHandle init success!");
    }
  }
  
  public static MessageRecord a(String paramString, long paramLong)
  {
    List localList = (List)jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if (localList == null) {
      return null;
    }
    paramString = null;
    int i = 0;
    for (;;)
    {
      if (i < localList.size())
      {
        paramString = (MessageRecord)localList.get(i);
        if (paramString.uniseq == paramLong) {
          localList.remove(i);
        }
      }
      else
      {
        return paramString;
      }
      i += 1;
    }
  }
  
  private void a(long paramLong1, String paramString1, String paramString2, long paramLong2, boolean paramBoolean)
  {
    MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)MessageRecordFactory.a(-4508);
    localMessageForDeviceText.msgtype = -4508;
    localMessageForDeviceText.istroop = 9501;
    localMessageForDeviceText.issend = 0;
    localMessageForDeviceText.isread = false;
    localMessageForDeviceText.selfuin = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
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
    String str = "我在这里，点击查看：http://maps.google.com/maps?q=" + paramString2 + "," + paramString3 + "&iwloc=A&hl=zh-CN (" + paramString5 + ")";
    if (!paramContext.getResources().getString(2131430559).equals(paramString4)) {}
    for (paramContext = paramContext.getResources().getString(2131435571) + " " + paramString4;; paramContext = paramContext.getResources().getString(2131435571))
    {
      paramString2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + paramString2 + "&lon=" + paramString3 + "&title=" + paramString4 + "&loc=" + paramString5 + "&dpid=" + paramString6;
      paramContext = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(32).a(paramContext).b(str).a("plugin", paramString2, paramString2, paramString2, paramString2).a();
      paramString2 = StructMsgElementFactory.a(2);
      paramString2.a("http://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramString4, paramString5);
      paramContext.addItem(paramString2);
      paramContext = MessageRecordFactory.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 9501, 100L, paramContext);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    }
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
    new Handler(Looper.getMainLooper()).postDelayed(new qbi(this, paramString), 0L);
  }
  
  private void a(List paramList)
  {
    long l = System.currentTimeMillis();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramList, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "cost:" + (System.currentTimeMillis() - l));
    }
  }
  
  private void b()
  {
    DeviceInfo[] arrayOfDeviceInfo = ((SmartDeviceProxyMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a();
    if ((arrayOfDeviceInfo != null) && (arrayOfDeviceInfo.length > 0)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
    }
  }
  
  private void b(String paramString, long paramLong)
  {
    paramString = a(paramString, paramLong);
    if (paramString == null) {
      return;
    }
    paramString.extraflag = 32768;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString.frienduin, paramString.istroop, paramString.uniseq);
    String str = paramString.frienduin;
    int i = paramString.istroop;
    paramLong = paramString.uniseq;
    ((MessageHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).a(MessageHandler.c(paramString.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(paramLong) });
  }
  
  private boolean b(String paramString)
  {
    bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramString).optInt("nodisturb", 0);
        if (i != 1) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        bool = false;
        continue;
      }
      return bool;
      bool = false;
    }
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
  
  protected Class a()
  {
    return BusinessObserver.class;
  }
  
  public void a()
  {
    super.a();
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
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor = null;
    this.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor = null;
    this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver = null;
    this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceGroupChatMsgProcessor = null;
  }
  
  public void a(DataPoint paramDataPoint)
  {
    try
    {
      Object localObject = new JSONObject(paramDataPoint.mValue);
      long l = ((JSONObject)localObject).optLong("msg_time", MessageCache.a());
      localObject = ((JSONObject)localObject).optString("text", " ");
      a(Long.toString(paramDataPoint.mDin), (String)localObject, l, null);
      return;
    }
    catch (Exception paramDataPoint)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvRawTextMsg parse from json error:" + paramDataPoint.getMessage());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForDeviceText paramMessageForDeviceText)
  {
    paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramMessageForDeviceText.uniseq);
    if ("device_groupchat".equals(paramMessageForDeviceText.extStr)) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramQQAppInterface, paramSessionInfo, paramMessageForDeviceText.msg, bool);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = Utils.a(paramString, 560, 20, null, new ArrayList());
    int i = 0;
    if (i < localArrayList.size())
    {
      String str1 = (String)localArrayList.get(i);
      paramString = "";
      if (str1 != null) {
        paramString = MessageUtils.a(str1, true, null);
      }
      int j = (int)MessageCache.a();
      str1 = paramQQAppInterface.getCurrentAccountUin();
      String str2 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      long l = MessageUtils.a(i);
      MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)MessageRecordFactory.a(-4508);
      localMessageForDeviceText.init(str1, paramSessionInfo.jdField_a_of_type_JavaLangString, str2, paramString, j, -4508, paramSessionInfo.jdField_a_of_type_Int, i);
      localMessageForDeviceText.longMsgCount = localArrayList.size();
      localMessageForDeviceText.longMsgIndex = ((byte)i);
      localMessageForDeviceText.longMsgId = i;
      localMessageForDeviceText.isread = true;
      localMessageForDeviceText.msgUid = l;
      localMessageForDeviceText.shmsgseq = MessageUtils.a(i, paramSessionInfo.jdField_a_of_type_Int);
      localMessageForDeviceText.issend = 1;
      localMessageForDeviceText.mAnimFlag = true;
      if (paramBoolean) {
        localMessageForDeviceText.extStr = "device_groupchat";
      }
      if (!NetworkUtil.g(BaseApplicationImpl.getContext())) {
        localMessageForDeviceText.extraflag = 32768;
      }
      paramQQAppInterface.a().a(localMessageForDeviceText, str1);
      a(localMessageForDeviceText);
      if (localMessageForDeviceText.extraflag == 32768) {}
      for (;;)
      {
        if (localMessageForDeviceText.extraflag != 32768)
        {
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          ((SmartDeviceProxyMgr)paramQQAppInterface.a(51)).a(localMessageForDeviceText.msg, Long.parseLong(localMessageForDeviceText.frienduin), l, localMessageForDeviceText.msgseq);
        }
        i += 1;
        break;
        paramQQAppInterface.a().d(localMessageForDeviceText);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)MessageRecordFactory.a(-4508);
    localMessageForDeviceText.msgtype = -4508;
    localMessageForDeviceText.istroop = 9501;
    localMessageForDeviceText.issend = 0;
    localMessageForDeviceText.isread = false;
    localMessageForDeviceText.selfuin = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
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
    if (paramInt == -1) {
      return;
    }
    int i = 0;
    MessageForGrayTips localMessageForGrayTips;
    switch (paramInt)
    {
    default: 
      paramInt = i;
      localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(paramInt);
      localMessageForGrayTips.init(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramString2, paramLong, paramInt, 9501, paramLong);
      localMessageForGrayTips.isread = paramBoolean1;
      if (!paramBoolean2) {
        break;
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      localMessageForGrayTips.issend = paramInt;
      paramString1 = new ArrayList();
      paramString1.add(localMessageForGrayTips);
      a(paramString1);
      return;
      paramInt = -4505;
      break;
      paramInt = -4507;
      break;
      paramInt = -4506;
      break;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    MessageForNewGrayTips localMessageForNewGrayTips;
    if (paramBoolean3)
    {
      i = -5001;
      localMessageForNewGrayTips = (MessageForNewGrayTips)MessageRecordFactory.a(i);
      localMessageForNewGrayTips.init(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramString2, paramLong, i, 9501, paramLong);
      localMessageForNewGrayTips.isread = paramBoolean1;
      if (!paramBoolean2) {
        break label104;
      }
    }
    label104:
    for (int i = 1;; i = 0)
    {
      localMessageForNewGrayTips.issend = i;
      localMessageForNewGrayTips.spans = null;
      localMessageForNewGrayTips.updateMsgData();
      paramString1 = new ArrayList();
      paramString1.add(localMessageForNewGrayTips);
      a(paramString1);
      return;
      i = -5000;
      break;
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceMsgHandle
 * JD-Core Version:    0.7.0.1
 */