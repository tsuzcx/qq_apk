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
  public static final String a = MessageForDeviceFile.class.getSimpleName();
  public static String b = "FileMsg";
  public static String c = "CloudPrintMsg";
  public static String d = "ImgMsg";
  public static String e = "VideoMsg";
  public static String f = "AudioMsg";
  public static String g = "Device";
  public static String h = "7000-NASDevPushFile";
  public static HashMap<String, List<MessageRecord>> o = new HashMap();
  public HashMap<String, List<DeviceFileObserver>> i = new HashMap();
  public DevSingleStructMsgProcessor j;
  public DeviceAVFileMsgObserver k;
  public DeviceGroupChatMsgProcessor l;
  public ConcurrentHashMap<Long, MessageRecord> m = new ConcurrentHashMap(10);
  public ConcurrentHashMap<Long, MessageRecord> n = new ConcurrentHashMap(10);
  SecSvcObserver p = new DeviceMsgHandle.4(this);
  private List<Long> q = new ArrayList();
  private List<Long> r = new ArrayList();
  private DeviceComnFileMsgProcessor s;
  private QQAppInterface t;
  private DeviceFileObserver u = new DeviceMsgHandle.1(this);
  private BroadcastReceiver v = new DeviceMsgHandle.2(this);
  
  public DeviceMsgHandle(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.t = paramQQAppInterface;
    paramQQAppInterface.addObserver(this.u);
    this.s = new DeviceComnFileMsgProcessor(paramQQAppInterface);
    this.j = new DevSingleStructMsgProcessor(paramQQAppInterface);
    this.k = new DeviceAVFileMsgObserver();
    this.l = new DeviceGroupChatMsgProcessor(paramQQAppInterface);
    a(f, this.k);
    a(e, this.k);
    a(g, this.k);
    a(g, this.j);
    a(g, this.l);
    a(b, this.s);
    a(c, this.s);
    a(d, this.s);
    a(h, this.s);
    a("8000-NASDevMusicFile", this.s);
    a("8001-NASDevVideoFile", this.s);
    a("8002-NASDevDocumentFile", this.s);
    a("8003-NASDevCommonFile", this.s);
    a("", this.s);
    a("", this.k);
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
    paramQQAppInterface.getApp().registerReceiver(this.v, localIntentFilter, "com.tencent.smartdevice.permission.broadcast", null);
    paramQQAppInterface.addObserver(this.p);
    paramQQAppInterface = (SecSvcHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "DeviceMsgHandle init success!");
    }
  }
  
  public static MessageRecord a(String paramString, long paramLong)
  {
    List localList = (List)o.get(paramString);
    paramString = null;
    if (localList == null) {
      return null;
    }
    int i1 = 0;
    while (i1 < localList.size())
    {
      paramString = (MessageRecord)localList.get(i1);
      if (paramString.uniseq == paramLong)
      {
        localList.remove(i1);
        return paramString;
      }
      i1 += 1;
    }
    return paramString;
  }
  
  private void a(long paramLong1, String paramString1, String paramString2, long paramLong2, boolean paramBoolean)
  {
    MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)MessageRecordFactory.a(-4508);
    localMessageForDeviceText.msgtype = -4508;
    localMessageForDeviceText.istroop = 9501;
    localMessageForDeviceText.issend = 0;
    localMessageForDeviceText.isread = false;
    localMessageForDeviceText.selfuin = this.t.getCurrentAccountUin();
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
    ((StringBuilder)localObject).append(ChatActivityConstants.a);
    ((StringBuilder)localObject).append("http://maps.google.com/maps?q=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("&iwloc=A&hl=zh-CN (");
    ((StringBuilder)localObject).append(paramString5);
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    if (!paramContext.getResources().getString(2131893857).equals(paramString4))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getResources().getString(2131888235));
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString4);
      paramContext = localStringBuilder.toString();
    }
    else
    {
      paramContext = paramContext.getResources().getString(2131888235);
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
    paramString2 = this.t;
    paramContext = MessageRecordFactory.c(paramString2, paramString2.getCurrentAccountUin(), paramString1, this.t.getCurrentAccountUin(), 9501, 100L, paramContext);
    this.t.getMessageFacade().a(paramContext, this.t.getCurrentAccountUin());
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    Object localObject = (List)o.get(paramMessageRecord.frienduin);
    if (localObject == null)
    {
      localObject = new ArrayList();
      ((List)localObject).add(paramMessageRecord);
      o.put(paramMessageRecord.frienduin, localObject);
      return;
    }
    ((List)localObject).add(paramMessageRecord);
  }
  
  private void a(List<MessageRecord> paramList)
  {
    long l1 = System.currentTimeMillis();
    this.t.getMessageFacade().a(paramList, this.t.getCurrentAccountUin());
    if (QLog.isDevelopLevel())
    {
      paramList = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cost:");
      localStringBuilder.append(System.currentTimeMillis() - l1);
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
      int i1 = new JSONObject(paramString).optInt("nodisturb", 0);
      if (i1 == 1) {
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
    new Handler(Looper.getMainLooper()).postDelayed(new DeviceMsgHandle.3(this, paramString), 0L);
  }
  
  private void c(String paramString, long paramLong)
  {
    paramString = a(paramString, paramLong);
    if (paramString == null) {
      return;
    }
    paramString.extraflag = 32768;
    this.t.getMsgCache().b(paramString.frienduin, paramString.istroop, paramString.uniseq);
    String str = paramString.frienduin;
    int i1 = paramString.istroop;
    paramLong = paramString.uniseq;
    ((MessageHandler)this.t.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.b(paramString.istroop), false, new Object[] { str, Integer.valueOf(i1), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(paramLong) });
  }
  
  private void e()
  {
    DeviceInfo[] arrayOfDeviceInfo = ((SmartDeviceProxyMgr)this.t.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).e();
    if ((arrayOfDeviceInfo != null) && (arrayOfDeviceInfo.length > 0)) {
      this.t.handleReceivedMessage(1, true, true);
    }
  }
  
  public DeviceAVFileMsgObserver a()
  {
    return this.k;
  }
  
  public void a(DataPoint paramDataPoint)
  {
    try
    {
      localObject = new JSONObject(paramDataPoint.mValue);
      long l1 = ((JSONObject)localObject).optLong("msg_time", MessageCache.c());
      localObject = ((JSONObject)localObject).optString("text", " ");
      a(Long.toString(paramDataPoint.mDin), (String)localObject, l1, null);
      return;
    }
    catch (Exception paramDataPoint)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRecvRawTextMsg parse from json error:");
        localStringBuilder.append(paramDataPoint.getMessage());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForDeviceText paramMessageForDeviceText)
  {
    paramQQAppInterface.getMessageFacade().h(paramSessionInfo.b, paramSessionInfo.a, paramMessageForDeviceText.uniseq);
    boolean bool = "device_groupchat".equals(paramMessageForDeviceText.extStr);
    a(paramQQAppInterface, paramSessionInfo, paramMessageForDeviceText.msg, bool);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList = BusinessUtils.a(paramString, 560, 20, null, new ArrayList());
    int i1 = 0;
    while (i1 < localArrayList.size())
    {
      paramString = (String)localArrayList.get(i1);
      if (paramString != null) {
        paramString = MessageUtils.a(paramString, true, null);
      } else {
        paramString = "";
      }
      int i2 = (int)MessageCache.c();
      String str1 = paramQQAppInterface.getCurrentAccountUin();
      String str2 = paramBaseSessionInfo.b;
      long l1 = MessageUtils.a(i1);
      MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)MessageRecordFactory.a(-4508);
      String str3 = paramBaseSessionInfo.b;
      long l2 = i2;
      i2 = paramBaseSessionInfo.a;
      long l3 = i1;
      localMessageForDeviceText.init(str1, str3, str2, paramString, l2, -4508, i2, l3);
      localMessageForDeviceText.longMsgCount = localArrayList.size();
      localMessageForDeviceText.longMsgIndex = ((byte)i1);
      localMessageForDeviceText.longMsgId = i1;
      localMessageForDeviceText.isread = true;
      localMessageForDeviceText.msgUid = l1;
      localMessageForDeviceText.shmsgseq = MessageUtils.a(l3, paramBaseSessionInfo.a);
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
        paramQQAppInterface.getMsgCache().e(localMessageForDeviceText);
      }
      if (localMessageForDeviceText.extraflag != 32768)
      {
        l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        ((SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(localMessageForDeviceText.msg, Long.parseLong(localMessageForDeviceText.frienduin), l1, localMessageForDeviceText.msgseq);
      }
      i1 += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    MessageForDeviceText localMessageForDeviceText = (MessageForDeviceText)MessageRecordFactory.a(-4508);
    localMessageForDeviceText.msgtype = -4508;
    localMessageForDeviceText.istroop = 9501;
    localMessageForDeviceText.issend = 0;
    localMessageForDeviceText.isread = false;
    localMessageForDeviceText.selfuin = this.t.getCurrentAccountUin();
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
    List localList = (List)this.i.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.i.put(paramString, localObject);
    }
    if (!((List)localObject).contains(paramDeviceFileObserver)) {
      ((List)localObject).add(paramDeviceFileObserver);
    }
    return true;
  }
  
  public DeviceComnFileMsgProcessor b()
  {
    return this.s;
  }
  
  public boolean b(String paramString, DeviceFileObserver paramDeviceFileObserver)
  {
    paramString = (List)this.i.get(paramString);
    if (paramString != null) {
      paramString.remove(paramDeviceFileObserver);
    }
    return true;
  }
  
  public DevSingleStructMsgProcessor c()
  {
    return this.j;
  }
  
  public DeviceGroupChatMsgProcessor d()
  {
    return this.l;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return BusinessObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b(f, this.k);
    b(e, this.k);
    b(g, this.k);
    b(g, this.j);
    b(b, this.s);
    b(c, this.s);
    b(d, this.s);
    b(h, this.s);
    b("8000-NASDevMusicFile", this.s);
    b("8001-NASDevVideoFile", this.s);
    b("8002-NASDevDocumentFile", this.s);
    b("8003-NASDevCommonFile", this.s);
    b("", this.s);
    b("", this.k);
    this.t.removeObserver(this.u);
    this.t.getApp().unregisterReceiver(this.v);
    this.t.removeObserver(this.p);
    this.s = null;
    this.j = null;
    this.k = null;
    this.l = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceMsgHandle
 * JD-Core Version:    0.7.0.1
 */