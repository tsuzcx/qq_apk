import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_UNDEAL_COUNT.feed_info;
import QzoneCombine.PushInfo;
import QzoneCombine.SingleMsg;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.servlet.CliNotifyPush.1;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sc.qzonepush.QQService.SvcMsgPush;
import com.tencent.upload.common.UploadConfiguration;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class azbg
  extends MSFServlet
  implements bjqx
{
  public static int a;
  public static volatile HashMap<Integer, azcl> a;
  public static volatile List<bjqi> a;
  public static volatile boolean a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "baseSdk.Msf.NotifyResp", "CliNotifySvc.SvcReqPush", "MessageSvc.WNSQzone" };
  public static int b;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new azbh(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new CliNotifyPush.1(this);
  private volatile ArrayList<azcl> jdField_a_of_type_JavaUtilArrayList;
  private volatile ArrayList<azcl> b;
  private int c;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString);
    if (paramContext != null) {
      return paramContext.versionCode;
    }
    return -1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, 0);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("QZONE_PUSH_ST", 0);
      paramQQAppInterface = paramQQAppInterface.getAccount();
      l1 = l2;
      if (paramQQAppInterface != null)
      {
        l1 = l2;
        if (paramQQAppInterface.length() > 0) {
          l1 = localSharedPreferences.getLong(paramQQAppInterface + ":" + paramInt, 0L);
        }
      }
    }
    return l1;
  }
  
  private static PackageInfo a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 16384);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private String a(ArrayList<azcl> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      azcl localazcl;
      JSONObject localJSONObject;
      if (paramArrayList.hasNext())
      {
        localazcl = (azcl)paramArrayList.next();
        if ((localazcl != null) && (localazcl.jdField_a_of_type_JavaUtilMap != null)) {
          localJSONObject = new JSONObject();
        }
      }
      else
      {
        try
        {
          localJSONObject.put("addTime", localazcl.jdField_a_of_type_Long);
          localJSONObject.put("opUin", localazcl.jdField_b_of_type_Long);
          Iterator localIterator = localazcl.jdField_a_of_type_JavaUtilMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject.put(str, localazcl.jdField_a_of_type_JavaUtilMap.get(str));
          }
          localJSONArray.put(localJSONObject);
        }
        catch (Exception localException) {}
        return localJSONArray.toString();
      }
    }
  }
  
  private void a()
  {
    QLog.e("CliNotifyPush", 1, "show()");
    ArrayList localArrayList;
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    for (;;)
    {
      Iterator localIterator;
      if (jdField_a_of_type_Boolean)
      {
        QLog.e("CliNotifyPush", 1, "call qzone timeout, show in qq");
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext()) {
            b((azcl)localIterator.next());
          }
        }
        if (localArrayList != null)
        {
          localIterator = localArrayList.iterator();
          while (localIterator.hasNext()) {
            b((azcl)localIterator.next());
          }
        }
        this.c = 2010;
        jdField_b_of_type_Int += 1;
      }
      for (;;)
      {
        a(this.c);
        jdField_a_of_type_Boolean = false;
        if (((this.c == 0) || (this.c == 10000)) && (localArrayList != null)) {
          a(localArrayList, (QQAppInterface)getAppRuntime());
        }
        return;
        if ((this.c == 0) || (this.c == 10000))
        {
          QLog.e("CliNotifyPush", 1, "call qzone success, show in qzone");
          if (this.jdField_a_of_type_JavaUtilArrayList != null)
          {
            localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext())
            {
              azcl localazcl = (azcl)localIterator.next();
              a(localazcl, (QQAppInterface)getAppRuntime(), 2L);
              a(localazcl, true);
              a(localazcl);
            }
          }
        }
        else
        {
          QLog.e("CliNotifyPush", 1, "call qzone failed, show in qq");
          if (this.jdField_a_of_type_JavaUtilArrayList != null)
          {
            localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (localIterator.hasNext()) {
              b((azcl)localIterator.next());
            }
          }
          if (localArrayList != null)
          {
            localIterator = localArrayList.iterator();
            while (localIterator.hasNext()) {
              b((azcl)localIterator.next());
            }
          }
        }
      }
      localArrayList = null;
    }
  }
  
  private void a(int paramInt)
  {
    QLog.e("CliNotifyPush", 1, "report resultCode:" + paramInt);
    b(paramInt);
    bjdt.a((QQAppInterface)getAppRuntime(), "qzonenewservice.callqzonev2", paramInt, "CliNotifyPush", 1, System.currentTimeMillis());
  }
  
  private void a(azcl paramazcl)
  {
    QLog.e("CliNotifyPush", 1, "dispathQzonePushMsg()");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {}
    while ((paramazcl == null) || (paramazcl.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    Object localObject;
    if ((paramazcl.jdField_a_of_type_JavaUtilMap != null) && (paramazcl.jdField_a_of_type_JavaUtilMap.get("utime") != null) && (LocalMultiProcConfig.getInt4Uin("qzone_preget_passive_open", 0, localQQAppInterface.getLongAccountUin()) == 1))
    {
      localObject = (String)paramazcl.jdField_a_of_type_JavaUtilMap.get("utime");
      if (!LocalMultiProcConfig.getString4Uin("qzone_passive_undealtime", "", localQQAppInterface.getLongAccountUin()).equals(localObject))
      {
        paramazcl.jdField_a_of_type_Boolean = true;
        int i = bjqu.a().a().a(localQQAppInterface.getLongAccountUin());
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), paramazcl);
      }
    }
    if (a(localQQAppInterface, paramazcl))
    {
      if (jdField_a_of_type_Boolean)
      {
        if (this.jdField_b_of_type_JavaUtilArrayList == null) {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_b_of_type_JavaUtilArrayList.add(paramazcl);
        return;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramazcl);
      a((ArrayList)localObject, localQQAppInterface);
      return;
    }
    b(paramazcl);
  }
  
  public static void a(azcl paramazcl, QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramazcl == null) {
      return;
    }
    if (paramQQAppInterface != null) {}
    for (long l1 = Long.parseLong(paramQQAppInterface.getAccount());; l1 = 0L)
    {
      long l2 = paramLong;
      NewIntent localNewIntent;
      if (paramazcl.jdField_a_of_type_Long != 0L)
      {
        l2 = paramLong;
        if (l1 != 0L)
        {
          localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), azcb.class);
          localNewIntent.putExtra("timestamp", paramazcl.jdField_a_of_type_Long);
          localNewIntent.putExtra("hostuin", l1);
          if (!paramazcl.jdField_b_of_type_Boolean) {
            break label230;
          }
        }
      }
      label230:
      for (paramLong = 1L | paramLong;; paramLong = 0xFFFFFFFE & paramLong)
      {
        String str2 = paramazcl.jdField_a_of_type_JavaLangString;
        String str1;
        if (!TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (!str2.equals("0")) {}
        }
        else
        {
          str1 = str2;
          if (paramazcl.jdField_a_of_type_JavaUtilMap != null) {
            str1 = (String)paramazcl.jdField_a_of_type_JavaUtilMap.get("pushstatkey");
          }
        }
        localNewIntent.putExtra("mark", str1);
        localNewIntent.putExtra("flag", paramLong);
        paramQQAppInterface.startServlet(localNewIntent);
        l2 = paramLong;
        QLog.e("CliNotifyPush", 1, "sentQzoneMsfPushAck: localTimeStamp=" + paramazcl.jdField_a_of_type_Long + " uin=" + l1 + " flag=" + l2);
        return;
      }
    }
  }
  
  private void a(azcl paramazcl, boolean paramBoolean)
  {
    if ((paramazcl == null) || (paramazcl.jdField_a_of_type_JavaUtilMap == null)) {
      QLog.e("CliNotifyPush", 1, "showRedTouch failed sm=null");
    }
    Object localObject1;
    azbw localazbw;
    do
    {
      return;
      localObject1 = (QQAppInterface)getAppRuntime();
      if (localObject1 == null)
      {
        QLog.e("CliNotifyPush", 1, "showRedTouch failed app=null");
        return;
      }
      localazbw = (azbw)((QQAppInterface)localObject1).getManager(10);
    } while (localazbw == null);
    for (;;)
    {
      int m;
      try
      {
        int k = Integer.parseInt((String)paramazcl.jdField_a_of_type_JavaUtilMap.get("pushtype"));
        QLog.i("CliNotifyPush", 1, "showRedTouch type:" + k + ",uin:" + paramazcl.jdField_b_of_type_Long + ",isBackground_Pause:" + ((QQAppInterface)localObject1).isBackground_Pause);
        if ((k != 1) && (k != 300) && (k != 302)) {
          break;
        }
        localObject1 = (String)paramazcl.jdField_a_of_type_JavaUtilMap.get("conent");
        m = Integer.parseInt((String)paramazcl.jdField_a_of_type_JavaUtilMap.get("count"));
        l = paramazcl.jdField_b_of_type_Long;
        int i = 0;
        try
        {
          boolean bool = paramazcl.jdField_a_of_type_JavaUtilMap.containsKey("opuin_qzoneVipLevel");
          if (!bool) {
            break label673;
          }
          i = 1;
          ArrayList localArrayList;
          Object localObject3;
          Object localObject4;
          QZoneCountUserInfo localQZoneCountUserInfo;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label644;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            j = Integer.parseInt((String)paramazcl.jdField_a_of_type_JavaUtilMap.get("opuin_qzoneVipLevel"));
            i = 1;
            localArrayList = new ArrayList();
            localObject2 = new QZoneCountUserInfo();
            ((QZoneCountUserInfo)localObject2).jdField_a_of_type_Long = l;
            ((QZoneCountUserInfo)localObject2).jdField_b_of_type_Int = j;
            ((QZoneCountUserInfo)localObject2).jdField_a_of_type_Int = i;
            paramazcl.jdField_a_of_type_ArrayOfByte = bjuf.a(paramazcl.jdField_a_of_type_ArrayOfByte);
            if (paramazcl.jdField_a_of_type_ArrayOfByte != null)
            {
              localObject3 = (PassiveFeedsPush)bjuf.a(PassiveFeedsPush.class, paramazcl.jdField_a_of_type_ArrayOfByte);
              if ((localObject3 != null) && (((PassiveFeedsPush)localObject3).stBubbleSkin != null) && (((PassiveFeedsPush)localObject3).stBubbleSkin.lUin == l)) {
                ((QZoneCountUserInfo)localObject2).jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush = ((PassiveFeedsPush)localObject3);
              }
            }
            localArrayList.add(localObject2);
            localObject2 = (String)paramazcl.jdField_a_of_type_JavaUtilMap.get("shcemaUrlAnd");
          }
          catch (Exception localException2)
          {
            Object localObject2;
            continue;
          }
          try
          {
            paramazcl = (String)paramazcl.jdField_a_of_type_JavaUtilMap.get("psv_tab_textlist");
            if (!TextUtils.isEmpty(paramazcl))
            {
              paramazcl = new JSONObject(paramazcl);
              paramazcl.getJSONObject("psv_tab_list");
              paramazcl = paramazcl.getJSONObject("psv_tab_list").getJSONArray("text_data");
              i = 0;
              if (i < paramazcl.length())
              {
                localObject4 = (JSONObject)paramazcl.get(i);
                l = ((JSONObject)localObject4).getLong("uin");
                localObject3 = ((JSONObject)localObject4).getString("nk");
                localObject4 = new feed_info(0L, 0L, 0L, ((JSONObject)localObject4).getString("text"));
                localQZoneCountUserInfo = new QZoneCountUserInfo();
                localQZoneCountUserInfo.jdField_a_of_type_JavaLangString = ((String)localObject3);
                localQZoneCountUserInfo.jdField_a_of_type_Long = l;
                localObject3 = new ArrayList();
                ((ArrayList)localObject3).add(localObject4);
                localQZoneCountUserInfo.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
                localArrayList.add(localQZoneCountUserInfo);
                i += 1;
                continue;
                localException1 = localException1;
                i = 0;
                QLog.i("CliNotifyPush", 2, "parse vip level error");
                j = 0;
              }
            }
          }
          catch (Exception paramazcl)
          {
            QLog.e("CliNotifyPush", 1, "psv_tab_textlist failed" + paramazcl);
            if (k != 302) {
              break label644;
            }
          }
        }
        localazbw.a(1, m, localException1, (String)localObject1, paramBoolean, true, (String)localObject2);
        return;
      }
      catch (Exception paramazcl)
      {
        QLog.e("CliNotifyPush", 1, "showRedTouch failed");
        return;
      }
      label644:
      long l = m;
      localazbw.a(1, l, localException1, (String)localObject1, paramBoolean, true, "");
      return;
      label673:
      int j = 0;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    QLog.i("CliNotifyPush", 1, "handleQQCirclePush " + paramQQAppInterface.isBackground_Pause + ", " + paramQQAppInterface.isBackground_Stop);
    if ((paramQQAppInterface.isBackground_Pause) && (paramQQAppInterface.isBackground_Stop))
    {
      paramQQAppInterface = (ambm)paramQQAppInterface.a(87);
      if (paramQQAppInterface != null)
      {
        QLog.i("CliNotifyPush", 1, "handleQQCirclePush sendRedpointReq");
        paramQQAppInterface.a(true, false);
      }
    }
    paramQQAppInterface = new Intent();
    paramQQAppInterface.setAction("action_receive_message_push");
    BaseApplication.getContext().sendBroadcast(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    if (paramQQAppInterface != null)
    {
      SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("QZONE_PUSH_ST", 0).edit();
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        localEditor.putLong(paramQQAppInterface + ":" + paramInt, paramLong);
      }
      localEditor.commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    a(paramQQAppInterface, 0, paramLong);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Map<String, String> paramMap)
  {
    if (paramMap == null) {
      QLog.e("CliNotifyPush", 1, "processMiniAppRedDotPush, data is null.");
    }
    for (;;)
    {
      return;
      try
      {
        String str = (String)paramMap.get("maappid");
        int i = Integer.valueOf((String)paramMap.get("reddotcount")).intValue();
        if ((!TextUtils.isEmpty(str)) && (i > 0))
        {
          paramMap = new MiniAppRedDotEntity(str, 0, i);
          paramQQAppInterface = (amru)paramQQAppInterface.a(148);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface.notifyUI(9, true, paramMap);
            return;
          }
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("CliNotifyPush", 1, "processMiniAppRedDotPush, exception: " + paramQQAppInterface.toString());
      }
    }
  }
  
  private void a(ArrayList<azcl> paramArrayList, QQAppInterface paramQQAppInterface)
  {
    QLog.e("CliNotifyPush", 1, "callQZone()");
    String str = a(paramArrayList);
    if (TextUtils.isEmpty(str))
    {
      QLog.e("CliNotifyPush", 1, "call qzone param error");
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((azcl)paramArrayList.next());
      }
    }
    try
    {
      jdField_a_of_type_Boolean = true;
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        ((azcl)localIterator.next()).a(true);
      }
      return;
    }
    catch (Exception localException)
    {
      jdField_a_of_type_Boolean = false;
      paramQQAppInterface.getHandler(azbg.class).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      QLog.e("CliNotifyPush", 1, localException, new Object[] { "call qzone param error" });
      a(2009);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((azcl)paramArrayList.next());
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      paramQQAppInterface.getHandler(azbg.class).postDelayed(this.jdField_a_of_type_JavaLangRunnable, QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushTimeout", 20000));
      UploadConfiguration.checkVaildConnection(paramQQAppInterface.getApp(), Long.valueOf(paramQQAppInterface.getLongAccountUin()), localException);
      QLog.e("CliNotifyPush", 1, "calling qzone, the msg is: " + localException);
      a(2007);
    }
  }
  
  private void a(Map<String, String> paramMap)
  {
    Intent localIntent = new Intent("com.qzone.live.MicLogic.processMicMsg");
    if ((paramMap != null) && ((paramMap instanceof HashMap))) {
      localIntent.putExtra("mic_msg", (HashMap)paramMap);
    }
    BaseApplication.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  private void a(Map<String, String> paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    try
    {
      bjuy localbjuy = new bjuy();
      localbjuy.jdField_a_of_type_Int = Integer.parseInt((String)paramMap.get("key_ctrl_cmd"));
      localbjuy.jdField_a_of_type_JavaUtilMap.putAll(paramMap);
      bjux.a(paramString).a(localbjuy);
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        if (paramContext != null) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  private boolean a(azcl paramazcl)
  {
    boolean bool = false;
    int i = Integer.parseInt((String)paramazcl.jdField_a_of_type_JavaUtilMap.get("pushtype"));
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    Object localObject;
    bjqi localbjqi2;
    if (i == 301) {
      if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject = (String)paramazcl.jdField_a_of_type_JavaUtilMap.get("live_roomid");
        if (localObject != null)
        {
          localbjqi2 = (bjqi)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
          if ((localbjqi2 == null) || (!((String)localObject).equals(localbjqi2.jdField_a_of_type_JavaLangString))) {
            break label257;
          }
          jdField_a_of_type_JavaUtilList.remove(localbjqi2);
          if (jdField_a_of_type_JavaUtilList.size() != 0) {
            break label187;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = QQNotificationManager.getInstance();
        if (localObject != null) {
          ((QQNotificationManager)localObject).cancel("CliNotifyPush.clearLivePush", 242);
        }
      }
      catch (Exception localException)
      {
        QLog.e("CliNotifyPush", 1, "NotificationManager cancel exception");
        continue;
      }
      a(paramazcl, localQQAppInterface, 16L);
      bool = true;
      return bool;
      label187:
      bjqi localbjqi1 = (bjqi)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
      if (localbjqi1 != null)
      {
        bjqg.a().a(localQQAppInterface, 0, null, localbjqi1.b, null, null, localbjqi1.jdField_a_of_type_Boolean, localbjqi1.jdField_a_of_type_Int, localbjqi1.c, localbjqi1.d, false, false);
        continue;
        label257:
        if (jdField_a_of_type_JavaUtilList.size() > 1)
        {
          i = 0;
          while (i < jdField_a_of_type_JavaUtilList.size() - 1)
          {
            localbjqi2 = (bjqi)jdField_a_of_type_JavaUtilList.get(i);
            if ((localbjqi2 != null) && (localbjqi1.equals(localbjqi2.jdField_a_of_type_JavaLangString))) {
              jdField_a_of_type_JavaUtilList.remove(localbjqi2);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 10000) {}
    do
    {
      return false;
      if ((8 == paramInt) || (4 == paramInt) || (366 == paramInt)) {
        return true;
      }
      if (paramInt == 2) {
        return true;
      }
    } while ((paramInt != 1) && (paramInt != 300));
    return LocalMultiProcConfig.getBool(paramQQAppInterface.getApp().getApplicationContext().getString(2131719346) + paramQQAppInterface.getAccount(), true);
  }
  
  private void b(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("resultcode", String.valueOf(paramInt));
    localHashMap.put("time", String.valueOf(System.currentTimeMillis()));
    azri.a(BaseApplication.getContext()).a(localQQAppInterface.getAccount(), "callqzonefrompushv2", true, 0L, 0L, localHashMap, null, true);
  }
  
  private void b(azcl paramazcl)
  {
    QLog.e("CliNotifyPush", 1, "showPush()");
    if ((paramazcl.jdField_a_of_type_Boolean) && (paramazcl.jdField_a_of_type_Int == 0)) {
      paramazcl.jdField_a_of_type_Int += 1;
    }
    QQAppInterface localQQAppInterface;
    int m;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)getAppRuntime();
      m = Integer.parseInt((String)paramazcl.jdField_a_of_type_JavaUtilMap.get("pushtype"));
      QLog.e("CliNotifyPush", 1, "pushType:" + m);
      if (m == 10000)
      {
        a(paramazcl.jdField_a_of_type_JavaUtilMap, localQQAppInterface.getAccount());
        a(paramazcl, localQQAppInterface, 16L);
        return;
      }
      if (m == 350)
      {
        a(paramazcl, localQQAppInterface, 16L);
        c(paramazcl);
        return;
      }
    } while (a(paramazcl));
    if (m == 100)
    {
      d(paramazcl);
      a(paramazcl, localQQAppInterface, 16L);
      return;
    }
    String str1 = (String)paramazcl.jdField_a_of_type_JavaUtilMap.get("conent");
    String str2 = (String)paramazcl.jdField_a_of_type_JavaUtilMap.get("pushstatkey");
    String str3 = (String)paramazcl.jdField_a_of_type_JavaUtilMap.get("shcemaUrlAnd");
    String str4 = (String)paramazcl.jdField_a_of_type_JavaUtilMap.get("title");
    String str5 = (String)paramazcl.jdField_a_of_type_JavaUtilMap.get("fake_push");
    String str6 = (String)paramazcl.jdField_a_of_type_JavaUtilMap.get("icon_type");
    String str7 = (String)paramazcl.jdField_a_of_type_JavaUtilMap.get("icon_url");
    if (QLog.isColorLevel()) {
      QLog.d("CliNotifyPush", 2, new Object[] { "showPush: invoked. ", " iconType: ", str6, " title: ", str4, " message: ", str1 });
    }
    long l = paramazcl.jdField_b_of_type_Long;
    if (paramazcl.jdField_a_of_type_JavaUtilMap.get("count") != null) {
      QLog.i("CliNotifyPush", 1, "showPush receive push time:" + paramazcl.jdField_a_of_type_Long + ",unreadCount=" + 1 + ",uin=" + l + ",type=" + m);
    }
    for (;;)
    {
      boolean bool1;
      try
      {
        int j = Integer.parseInt((String)paramazcl.jdField_a_of_type_JavaUtilMap.get("count"));
        i = j;
        if (j < 1) {
          i = 1;
        }
        int k;
        bool3 = localQQAppInterface.f();
      }
      catch (Exception localException2)
      {
        try
        {
          j = Integer.parseInt((String)paramazcl.jdField_a_of_type_JavaUtilMap.get("CtrlFlag"));
          if (QLog.isColorLevel())
          {
            QLog.i("CliNotifyPush", 2, "qzone redtypeinfo:receive push time:" + paramazcl.jdField_a_of_type_Long + "=unreadCount=" + i + "=uin=" + l + "=type=" + m + "=CtrlFlag=" + j + "=message=" + str1);
            if (j != 1) {
              continue;
            }
            bool1 = true;
            a(paramazcl, bool1);
          }
        }
        catch (Exception localException2)
        {
          try
          {
            k = Integer.parseInt((String)paramazcl.jdField_a_of_type_JavaUtilMap.get("show_level"));
            if ((!localQQAppInterface.isBackground_Pause) && (!a(k, 1))) {
              break label1034;
            }
            if (!a(localQQAppInterface, m))
            {
              a(paramazcl, localQQAppInterface, 16L);
              return;
              localException1 = localException1;
              i = 1;
              continue;
              localException2 = localException2;
              j = 0;
              continue;
              QLog.i("CliNotifyPush", 1, "qzone redtypeinfo:receive push time:" + paramazcl.jdField_a_of_type_Long + "=unreadCount=" + i + "=uin=" + l + "=type=" + m + "=CtrlFlag=" + j);
              continue;
              bool1 = false;
            }
          }
          catch (Exception localException3)
          {
            k = 4;
            continue;
            if (j == 1)
            {
              QLog.e("CliNotifyPush", 1, "not show push, existDL = " + j);
              a(paramazcl, localQQAppInterface, 128L);
              return;
            }
            if ((!bdmh.a(localQQAppInterface.getApp())) && (a(localQQAppInterface)) && (!a(k, 0)))
            {
              a(paramazcl, localQQAppInterface, 64L);
              return;
            }
            if (!QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext()))
            {
              a(paramazcl, localQQAppInterface, 512L);
              return;
            }
            if (str1 == null) {
              break label1024;
            }
          }
        }
      }
      boolean bool3;
      if (!bool3) {
        str1 = localQQAppInterface.getApp().getApplicationContext().getString(2131718523) + i + localQQAppInterface.getApp().getApplicationContext().getString(2131718524);
      }
      for (;;)
      {
        boolean bool2 = true;
        bool1 = bool2;
        if (paramazcl.jdField_a_of_type_JavaUtilMap != null)
        {
          bool1 = bool2;
          if (paramazcl.jdField_a_of_type_JavaUtilMap.get("daemonShow") != null) {
            bool1 = "1".equals(paramazcl.jdField_a_of_type_JavaUtilMap.get("daemonShow"));
          }
        }
        if (bool1)
        {
          bjqg.a().a(localQQAppInterface, 1, str4, str1, str6, str7, bool3, m, str3, str2, true, "1".equals(str5));
          a(paramazcl, localQQAppInterface, 4L);
        }
        QLog.e("CliNotifyPush", 1, "show push: XXX");
        return;
        label1024:
        a(paramazcl, localQQAppInterface, 256L);
        return;
        label1034:
        a(paramazcl, localQQAppInterface, 32L);
        return;
      }
      int i = 1;
    }
  }
  
  private void c(azcl paramazcl)
  {
    if (paramazcl == null) {
      return;
    }
    QLog.e("CliNotifyPush", 1, "recv Qzone Push: Feed实时更新Push");
    Intent localIntent = new Intent("com.qzone.push_feed_update");
    if ((paramazcl.jdField_a_of_type_ArrayOfByte != null) && (paramazcl.jdField_a_of_type_ArrayOfByte.length > 0)) {
      localIntent.putExtra("update_feeds_buffer", paramazcl.jdField_a_of_type_ArrayOfByte);
    }
    for (;;)
    {
      BaseApplication.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
      if ((paramazcl.jdField_a_of_type_JavaUtilMap != null) && ((paramazcl.jdField_a_of_type_JavaUtilMap instanceof HashMap))) {
        localIntent.putExtra("update_feeds", (HashMap)paramazcl.jdField_a_of_type_JavaUtilMap);
      }
    }
  }
  
  /* Error */
  private void d(azcl paramazcl)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: aload_1
    //   3: ifnull +10 -> 13
    //   6: aload_1
    //   7: getfield 159	azcl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: getfield 159	azcl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   18: ldc_w 883
    //   21: invokeinterface 188 2 0
    //   26: checkcast 24	java/lang/String
    //   29: astore 6
    //   31: aload_1
    //   32: getfield 159	azcl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   35: ldc_w 885
    //   38: invokeinterface 188 2 0
    //   43: checkcast 24	java/lang/String
    //   46: astore 7
    //   48: aload 6
    //   50: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifne +11 -> 64
    //   56: aload 7
    //   58: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: ifeq +83 -> 144
    //   64: ldc 199
    //   66: ldc_w 887
    //   69: invokestatic 892	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_1
    //   73: istore_2
    //   74: aload_0
    //   75: invokevirtual 233	azbg:getAppRuntime	()Lmqq/app/AppRuntime;
    //   78: checkcast 72	com/tencent/mobileqq/app/QQAppInterface
    //   81: astore 6
    //   83: aload 6
    //   85: ifnull -72 -> 13
    //   88: new 34	java/util/HashMap
    //   91: dup
    //   92: invokespecial 37	java/util/HashMap:<init>	()V
    //   95: astore 7
    //   97: aload 7
    //   99: aload_1
    //   100: getfield 159	azcl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   103: invokevirtual 893	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   106: aload 7
    //   108: ldc_w 895
    //   111: iload_2
    //   112: invokestatic 754	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   115: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   118: pop
    //   119: invokestatic 546	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   122: invokestatic 764	azri:a	(Landroid/content/Context;)Lazri;
    //   125: aload 6
    //   127: invokevirtual 88	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   130: ldc_w 897
    //   133: iconst_1
    //   134: lconst_0
    //   135: lconst_0
    //   136: aload 7
    //   138: aconst_null
    //   139: iconst_1
    //   140: invokevirtual 769	azri:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   143: return
    //   144: invokestatic 546	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   147: aload 6
    //   149: invokestatic 899	azbg:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   152: istore 5
    //   154: iload 5
    //   156: ifeq +212 -> 368
    //   159: aload_1
    //   160: getfield 159	azcl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   163: ldc_w 901
    //   166: invokeinterface 188 2 0
    //   171: checkcast 24	java/lang/String
    //   174: astore 8
    //   176: aload 8
    //   178: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +214 -> 395
    //   184: aload 8
    //   186: invokestatic 406	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   189: istore_2
    //   190: iload_2
    //   191: istore_3
    //   192: aload_1
    //   193: getfield 159	azcl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   196: ldc_w 903
    //   199: invokeinterface 188 2 0
    //   204: checkcast 24	java/lang/String
    //   207: astore 8
    //   209: aload 8
    //   211: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   214: ifne +97 -> 311
    //   217: aload 8
    //   219: invokestatic 406	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   222: istore_2
    //   223: invokestatic 546	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   226: aload 6
    //   228: invokestatic 905	azbg:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   231: istore 4
    //   233: iload 4
    //   235: iload_3
    //   236: if_icmplt +101 -> 337
    //   239: iload 4
    //   241: iload_2
    //   242: if_icmpgt +95 -> 337
    //   245: aload_0
    //   246: aload_1
    //   247: getfield 159	azcl:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   250: aload 6
    //   252: aload 7
    //   254: invokevirtual 908	azbg:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V
    //   257: iconst_0
    //   258: istore_2
    //   259: goto +133 -> 392
    //   262: astore 8
    //   264: ldc 199
    //   266: ldc_w 910
    //   269: aload 8
    //   271: invokestatic 913	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   274: goto -82 -> 192
    //   277: astore 6
    //   279: invokestatic 914	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   282: ifeq +24 -> 306
    //   285: ldc 199
    //   287: iconst_2
    //   288: iconst_2
    //   289: anewarray 618	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: ldc_w 916
    //   297: aastore
    //   298: dup
    //   299: iconst_1
    //   300: aload 6
    //   302: aastore
    //   303: invokestatic 918	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   306: iconst_4
    //   307: istore_2
    //   308: goto -234 -> 74
    //   311: ldc_w 919
    //   314: istore_2
    //   315: goto -92 -> 223
    //   318: astore 8
    //   320: ldc 199
    //   322: ldc_w 921
    //   325: aload 8
    //   327: invokestatic 913	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   330: ldc_w 919
    //   333: istore_2
    //   334: goto -111 -> 223
    //   337: iconst_3
    //   338: istore_3
    //   339: iload_3
    //   340: istore_2
    //   341: invokestatic 914	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   344: ifeq +48 -> 392
    //   347: ldc 199
    //   349: iconst_2
    //   350: iconst_1
    //   351: anewarray 618	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: ldc_w 923
    //   359: aastore
    //   360: invokestatic 918	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   363: iload_3
    //   364: istore_2
    //   365: goto +27 -> 392
    //   368: invokestatic 914	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   371: ifeq +19 -> 390
    //   374: ldc 199
    //   376: iconst_2
    //   377: iconst_1
    //   378: anewarray 618	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: ldc_w 925
    //   386: aastore
    //   387: invokestatic 918	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   390: iconst_2
    //   391: istore_2
    //   392: goto -318 -> 74
    //   395: iconst_m1
    //   396: istore_2
    //   397: goto -207 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	azbg
    //   0	400	1	paramazcl	azcl
    //   73	324	2	i	int
    //   1	363	3	j	int
    //   231	12	4	k	int
    //   152	3	5	bool	boolean
    //   29	222	6	localObject1	Object
    //   277	24	6	localException1	Exception
    //   46	207	7	localObject2	Object
    //   174	44	8	str	String
    //   262	8	8	localException2	Exception
    //   318	8	8	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   159	190	262	java/lang/Exception
    //   144	154	277	java/lang/Exception
    //   223	233	277	java/lang/Exception
    //   245	257	277	java/lang/Exception
    //   264	274	277	java/lang/Exception
    //   320	330	277	java/lang/Exception
    //   341	363	277	java/lang/Exception
    //   368	390	277	java/lang/Exception
    //   192	223	318	java/lang/Exception
  }
  
  public Map<Integer, azcl> a(FromServiceMsg paramFromServiceMsg)
  {
    QLog.e("CliNotifyPush", 1, "decodeQzonePushMsgs()");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return null;
    }
    Object localObject1 = paramFromServiceMsg.getWupBuffer();
    System.arraycopy(localObject1, 4, localObject1, 0, localObject1.length - 4);
    paramFromServiceMsg = new PushInfo();
    localObject1 = new JceInputStream((byte[])localObject1);
    ((JceInputStream)localObject1).setServerEncoding("utf-8");
    paramFromServiceMsg.readFrom((JceInputStream)localObject1);
    Object localObject2 = paramFromServiceMsg.vecMsg;
    localObject1 = new HashMap();
    long l3 = a(localQQAppInterface);
    localObject2 = ((ArrayList)localObject2).iterator();
    long l1 = l3;
    SingleMsg localSingleMsg;
    int i;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localSingleMsg = (SingleMsg)((Iterator)localObject2).next();
        if (localSingleMsg != null) {
          if (localSingleMsg.data.containsKey("pushtype")) {
            i = Integer.parseInt((String)localSingleMsg.data.get("pushtype"));
          }
        }
      }
    }
    for (;;)
    {
      long l2;
      if ((i == 1) || (i == 2) || (i == 4) || (i == 301) || (i == 8) || (i == 300) || (i == 10000) || (i == 302) || (i == 350) || (i == 100) || (i == 366))
      {
        l2 = a(localQQAppInterface, i);
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "PushDeduplication", 1) == 1)
        {
          if (localSingleMsg.addTime > l2) {
            break label549;
          }
          QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
          a(new azcl(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 8L);
          a(2014);
          break;
          if (!localSingleMsg.data.containsKey("type")) {
            break label1012;
          }
          i = Integer.parseInt((String)localSingleMsg.data.get("type"));
          continue;
        }
        if (localSingleMsg.addTime < l2)
        {
          QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
          a(new azcl(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 8L);
          a(2014);
          break;
        }
        label549:
        if (((Map)localObject1).containsKey(Integer.valueOf(i)))
        {
          azcl localazcl = (azcl)((Map)localObject1).get(Integer.valueOf(i));
          if ((localazcl != null) && (localazcl.jdField_a_of_type_Long < localSingleMsg.addTime))
          {
            ((Map)localObject1).put(Integer.valueOf(i), new azcl(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark, localSingleMsg.extBuffer));
            QLog.e("CliNotifyPush", 1, "PushDeduplication: msg localTimeStap:" + localSingleMsg.addTime + " sm newTimeStap:" + localazcl.jdField_a_of_type_Long + " msg:" + (String)localazcl.jdField_a_of_type_JavaUtilMap.get("conent"));
            a(localazcl, localQQAppInterface, 8L);
            label720:
            a(localQQAppInterface, i, localSingleMsg.addTime);
            l2 = l1;
            if (l1 < localSingleMsg.addTime) {
              l2 = localSingleMsg.addTime;
            }
            if (i == 366) {
              a(localQQAppInterface);
            }
            l1 = l2;
          }
        }
      }
      for (;;)
      {
        break;
        QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
        a(new azcl(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 8L);
        break;
        ((Map)localObject1).put(Integer.valueOf(i), new azcl(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark, localSingleMsg.extBuffer));
        break label720;
        if (i == 7066) {
          a(localSingleMsg.data);
        } else if (i == 200) {
          a(localQQAppInterface, localSingleMsg.data);
        } else {
          a(new azcl(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 256L);
        }
      }
      if (l3 < l1) {
        a(localQQAppInterface, l1);
      }
      return localObject1;
      label1012:
      i = 0;
    }
  }
  
  public void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramString1, paramString2);
    paramString1 = paramMap.keySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      if (!TextUtils.isEmpty(paramString2)) {
        localIntent.putExtra(paramString2, (String)paramMap.get(paramString2));
      }
    }
    try
    {
      BaseApplication.getContext().startService(localIntent);
      QZLog.d("CliNotifyPush", 1, "arouseThirdApp success");
      return;
    }
    catch (Throwable paramMap)
    {
      QZLog.d("CliNotifyPush", 1, "arouseThirdApp fail", paramMap);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((1 << paramInt2 & paramInt1) != 0) {}
    for (;;)
    {
      if (QZLog.isColorLevel()) {
        QZLog.i("CliNotifyPush", 2, "checkForegroundShowEnabled showLevel: " + paramInt1 + ",result: " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    paramQQAppInterface = ((ActivityManager)paramQQAppInterface.getApp().getSystemService("activity")).getRunningTasks(1);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramQQAppInterface.size() > 0)
      {
        paramQQAppInterface = ((ActivityManager.RunningTaskInfo)paramQQAppInterface.get(0)).topActivity.getClassName();
        if ((!"cooperation.qzone.QzoneGPUPluginProxyActivity".equals(paramQQAppInterface)) && (!"cooperation.qzone.QzonePluginProxyActivity".equals(paramQQAppInterface)) && (!"cooperation.qzone.QzoneFeedsPluginProxyActivity".equals(paramQQAppInterface))) {
          break label88;
        }
      }
    }
    label88:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, azcl paramazcl)
  {
    QLog.e("CliNotifyPush", 1, "supportJumpToQzone()");
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushReport", 0) == 1) {
      a(2000);
    }
    try
    {
      if ((paramazcl.jdField_a_of_type_JavaUtilMap.containsKey("CtrlFlag")) && (Integer.parseInt((String)paramazcl.jdField_a_of_type_JavaUtilMap.get("CtrlFlag")) == 1))
      {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushCtrlFlag2", 1) == 1)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("param_scene", 11);
          localIntent.setClassName("com.qzone", "com.tencent.wns.export.EmptyService");
          paramQQAppInterface.getApp().startService(localIntent);
          QLog.e("CliNotifyPush", 1, "call qzone empty, CtrlFlag = 1");
          a(2012);
          return false;
        }
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushCtrlFlag", 1) == 1)
        {
          QLog.e("CliNotifyPush", 1, "not call qzone, CtrlFlag = 1");
          a(2002);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("CliNotifyPush", 1, localException, new Object[0]);
      int j = Integer.parseInt((String)paramazcl.jdField_a_of_type_JavaUtilMap.get("pushtype"));
      if ((j != 1) && (j != 2) && (j != 4) && (j != 301))
      {
        QLog.e("CliNotifyPush", 1, "not call qzone, pushType = " + j);
        a(2001);
        return false;
      }
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPush", 0) != 1)
      {
        QLog.e("CliNotifyPush", 1, "not call qzone, CALL_QZONE_WNS_FROM_PUSH = 0");
        a(2003);
        return false;
      }
      if (jdField_a_of_type_Int >= QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushFailCnt", 1000))
      {
        QLog.e("CliNotifyPush", 1, "not call qzone,  mCntCallQzoneFailure = " + jdField_a_of_type_Int);
        a(2004);
        return false;
      }
      if (jdField_b_of_type_Int >= QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushTimeoutCnt", 3))
      {
        QLog.e("CliNotifyPush", 1, "not call qzone,  mCntCallQzoneTimeout = " + jdField_b_of_type_Int);
        a(2011);
        return false;
      }
      if (a(paramQQAppInterface.getApp(), "com.qzone"))
      {
        int k = QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromPushVersion", 87);
        int m = QzoneConfig.getInstance().getConfig("QZoneSetting", "CallQZoneWNSFromLivePushVersion", 89);
        int i;
        try
        {
          paramQQAppInterface = paramQQAppInterface.getApp().getPackageManager().getApplicationInfo("com.qzone", 128);
          if ((paramQQAppInterface == null) || (paramQQAppInterface.metaData == null)) {
            break label557;
          }
          i = paramQQAppInterface.metaData.getInt("com.qzone.versioncode");
        }
        catch (PackageManager.NameNotFoundException paramQQAppInterface)
        {
          for (;;)
          {
            paramQQAppInterface.printStackTrace();
            i = 0;
          }
          if (j == 4) {
            break label576;
          }
        }
        if (i < k)
        {
          QLog.e("CliNotifyPush", 1, "not call qzone, versionCode = " + i);
          a(2006);
          return false;
        }
        label557:
        label576:
        if ((j == 301) && (i < m))
        {
          QLog.e("CliNotifyPush", 1, "specialpush not call qzone, versionCode = " + i);
          a(2006);
          return false;
        }
      }
      else
      {
        QLog.e("CliNotifyPush", 1, "not call qzone,  qzone not installed");
        a(2005);
        return false;
      }
    }
    QLog.e("CliNotifyPush", 1, "call qzone");
    a(2008);
    return true;
  }
  
  public String[] getPreferSSOCommands()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public void onCreate()
  {
    super.onCreate();
    bjqu.a().a(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.qzone.ACTION_CALL_QZONE_WNS");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface != null) {}
    try
    {
      localQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CliNotifyPush", 1, "registerreceiver fail:" + localException);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bjqu.a().b(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface != null) {}
    try
    {
      localQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CliNotifyPush", 1, "unregisterreceiver fail:" + localException);
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify begin");
    }
    if ((paramFromServiceMsg.getServiceCmd().equals("CliNotifySvc.SvcReqPush")) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify");
      }
      paramIntent = (byte[])paramFromServiceMsg.attributes.get("pushMsgs");
      SvcMsgPush localSvcMsgPush = new SvcMsgPush();
      localSvcMsgPush.readFrom(new JceInputStream(paramIntent));
      ((MessageHandler)((QQAppInterface)getAppRuntime()).a(0)).onReceive(null, paramFromServiceMsg, localSvcMsgPush);
    }
    for (;;)
    {
      return;
      if ((!paramFromServiceMsg.getServiceCmd().equals("MessageSvc.WNSQzone")) || (!paramFromServiceMsg.isSuccess())) {
        break;
      }
      QLog.e("CliNotifyPush", 1, "get qzone push begin");
      paramIntent = a(paramFromServiceMsg);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.values().iterator();
        while (paramIntent.hasNext()) {
          a((azcl)paramIntent.next());
        }
      }
    }
    QLog.e("CliNotifyPush", 1, "get qzone push error");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((!paramString.equals("cmd.pre.getpassivefeeds")) || (paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    int i;
    do
    {
      return;
      paramString = paramBundle.getBundle("data");
      i = paramString.getInt("param.preget_seqid");
      paramString = Long.valueOf(paramString.getLong("param.preget_undealcount", -1L));
    } while (jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)) == null);
    paramBundle = (azcl)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    if (paramString.longValue() != -1L) {
      paramBundle.jdField_a_of_type_JavaUtilMap.put("count", paramString + "");
    }
    QLog.e("CliNotifyPush", 1, "onWebEvent showPush count:" + paramString);
    b((azcl)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbg
 * JD-Core Version:    0.7.0.1
 */