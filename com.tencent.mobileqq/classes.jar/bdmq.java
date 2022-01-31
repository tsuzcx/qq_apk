import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.open.downloadnew.common.NoticeParam;
import java.util.concurrent.ConcurrentHashMap;

public class bdmq
{
  protected static bdmq a;
  protected bdms a;
  protected QQNotificationManager a;
  protected final ConcurrentHashMap<String, bdmr> a;
  
  protected bdmq()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
  }
  
  private int a(String paramString)
  {
    bdii.b("AppNotificationManager", ">genNextNotificationId key:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 378;
    }
    int i = Math.abs(paramString.hashCode()) % 99;
    bdii.b("AppNotificationManager", ">genNextNotificationId mod:" + i);
    i += 378;
    bdii.b("AppNotificationManager", ">genNextNotificationId id:" + i);
    return i;
  }
  
  public static bdmq a()
  {
    if (jdField_a_of_type_Bdmq == null) {
      jdField_a_of_type_Bdmq = new bdmq();
    }
    return jdField_a_of_type_Bdmq;
  }
  
  public int a(String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      bdii.e("AppNotificationManager", ">getNotificationId param error, return invalid id.");
      return -1;
    }
    bdii.b("AppNotificationManager", ">getNotificationId " + paramString1 + ", " + paramString2);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramString1 = new bdmr(this);
      paramString1.jdField_a_of_type_JavaLangString = str;
      paramString1.jdField_a_of_type_Int = a(str);
      paramString1.jdField_b_of_type_Int = paramInt;
      paramString1.jdField_b_of_type_JavaLangString = paramString2;
      paramString1.jdField_a_of_type_Long = (System.currentTimeMillis() + paramString1.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
    }
    return ((bdmr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).jdField_a_of_type_Int;
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    bdii.b("AppNotificationManager", ">getNotificationWhen " + paramString1 + ", " + paramString2);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      bdmr localbdmr = new bdmr(this);
      localbdmr.jdField_a_of_type_JavaLangString = paramString1;
      localbdmr.jdField_a_of_type_Int = a(paramString1);
      localbdmr.jdField_b_of_type_Int = paramInt;
      localbdmr.jdField_b_of_type_JavaLangString = paramString2;
      localbdmr.jdField_a_of_type_Long = (System.currentTimeMillis() + localbdmr.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localbdmr);
    }
    return ((bdmr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).jdField_a_of_type_Long;
  }
  
  public Notification a(NoticeParam paramNoticeParam)
  {
    if ((bcyb.a().a() == null) || (paramNoticeParam == null))
    {
      bdii.e("AppNotificationManager", "getNotification context == null");
      return null;
    }
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNoticeParam.jdField_b_of_type_JavaLangString;
    localNotification.when = paramNoticeParam.jdField_a_of_type_Long;
    RemoteViews localRemoteViews = new RemoteViews(bcyb.a().a().getPackageName(), 2131559466);
    Object localObject = bdmu.a(1, paramNoticeParam);
    a(localRemoteViews);
    localRemoteViews.setInt(2131370956, "setBackgroundColor", -1);
    localRemoteViews.setInt(2131370958, "setTextColor", -16777216);
    localRemoteViews.setInt(2131370952, "setTextColor", -12303292);
    localRemoteViews.setInt(2131370948, "setTextColor", -12303292);
    localRemoteViews.setTextViewText(2131370958, bdio.a(paramNoticeParam.jdField_b_of_type_JavaLangString, 18, true, true));
    if (paramNoticeParam.jdField_b_of_type_Int == 1)
    {
      localNotification.icon = 2130843549;
      localRemoteViews.setImageViewResource(2131370949, 2130843545);
      localRemoteViews.setViewVisibility(2131370948, 8);
      localRemoteViews.setViewVisibility(2131370944, 0);
      if (Build.VERSION.SDK_INT > 10) {
        localRemoteViews.setOnClickPendingIntent(2131370956, (PendingIntent)localObject);
      }
    }
    for (;;)
    {
      localNotification.contentView = localRemoteViews;
      QQNotificationManager.addChannelIfNeed(localNotification, "CHANNEL_ID_HIDE_BADGE");
      return localNotification;
      localNotification.contentIntent = ((PendingIntent)localObject);
      continue;
      if ((paramNoticeParam.jdField_b_of_type_Int == 0) || (paramNoticeParam.jdField_b_of_type_Int == 2) || (paramNoticeParam.jdField_b_of_type_Int == 3))
      {
        localNotification.icon = 2130843549;
        if (paramNoticeParam.jdField_b_of_type_Int == 0)
        {
          localRemoteViews.setTextViewText(2131370948, bcyb.a().a().getString(2131694714));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131370949, 2130843545);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 2)
        {
          localRemoteViews.setTextViewText(2131370948, bcyb.a().a().getString(2131694717));
          localObject = bdjl.a(paramNoticeParam.d);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131370949, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = bdmu.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 3)
        {
          localRemoteViews.setTextViewText(2131370948, bcyb.a().a().getString(2131694714));
          localObject = bdmu.a(4, paramNoticeParam);
          Bitmap localBitmap = bdig.a(paramNoticeParam.jdField_a_of_type_JavaLangString);
          if (localBitmap == null) {
            break label476;
          }
          localRemoteViews.setImageViewBitmap(2131370949, localBitmap);
        }
        for (;;)
        {
          if (paramNoticeParam.jdField_b_of_type_Int == 0)
          {
            if (Build.VERSION.SDK_INT > 10)
            {
              localRemoteViews.setOnClickPendingIntent(2131370956, (PendingIntent)localObject);
              break;
              label476:
              bdii.b("AppNotificationManager", ">>download icon fail,so we use default notification icon");
              localRemoteViews.setImageViewResource(2131370949, 2130843545);
              continue;
            }
            localNotification.contentIntent = ((PendingIntent)localObject);
            break;
          }
        }
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
      else if (paramNoticeParam.jdField_b_of_type_Int == 4)
      {
        localNotification.icon = 2130843549;
        localRemoteViews.setImageViewResource(2131370949, 2130843545);
        localRemoteViews.setTextViewText(2131370948, bcyb.a().a().getString(2131694713));
        localRemoteViews.setViewVisibility(2131370948, 0);
        localRemoteViews.setViewVisibility(2131370944, 8);
        paramNoticeParam = bdmu.a(5, paramNoticeParam);
        localNotification.flags |= 0x10;
        localNotification.contentIntent = paramNoticeParam;
      }
      else
      {
        localNotification.icon = 2130841369;
        localRemoteViews.setImageViewResource(2131370949, 2130841370);
        localRemoteViews.setTextViewText(2131370948, paramNoticeParam.c);
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
    }
  }
  
  public ConcurrentHashMap<String, bdmr> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {}
    try
    {
      bfnb.a(bcyb.a().a(), 0, paramNotification);
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify2", paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      bdii.c("AppNotificationManager", "notify>>>", paramNotification);
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    if ((this.jdField_a_of_type_Bdms == null) || (this.jdField_a_of_type_Bdms.a() == null)) {
      this.jdField_a_of_type_Bdms = new bdms(this, bcyb.a().a());
    }
    bdii.b("notificationtest", "title color:" + this.jdField_a_of_type_Bdms.b());
    if (this.jdField_a_of_type_Bdms.b() != null) {
      paramRemoteViews.setTextColor(2131370958, this.jdField_a_of_type_Bdms.b().intValue());
    }
    bdii.b("notificationtest", "text color:" + this.jdField_a_of_type_Bdms.a());
    if (this.jdField_a_of_type_Bdms.a() != null) {
      paramRemoteViews.setTextColor(2131370948, this.jdField_a_of_type_Bdms.a().intValue());
    }
    if (this.jdField_a_of_type_Bdms.a() != null) {
      paramRemoteViews.setTextColor(2131370952, this.jdField_a_of_type_Bdms.a().intValue());
    }
    bdii.b("notificationtest", "text size:" + this.jdField_a_of_type_Bdms.a());
    if (this.jdField_a_of_type_Bdms.a() > 0.0F) {
      paramRemoteViews.setFloat(2131370948, "setTextSize", this.jdField_a_of_type_Bdms.a());
    }
    if (this.jdField_a_of_type_Bdms.a() > 0.0F) {
      paramRemoteViews.setFloat(2131370952, "setTextSize", this.jdField_a_of_type_Bdms.a());
    }
    if (this.jdField_a_of_type_Bdms.b() > 0.0F) {
      paramRemoteViews.setFloat(2131370958, "setTextSize", this.jdField_a_of_type_Bdms.b());
    }
    ApplicationInfo localApplicationInfo = bcyb.a().a().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.jdField_a_of_type_Bdms.b().intValue();
      paramRemoteViews.setInt(2131370956, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
      return;
    }
    catch (Exception paramRemoteViews) {}
  }
  
  public void a(NoticeParam paramNoticeParam)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null)
    {
      Notification localNotification = a(paramNoticeParam);
      if (localNotification != null)
      {
        bfnb.a(bcyb.a().a(), 0, localNotification);
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify1", a(paramNoticeParam.f, paramNoticeParam.jdField_b_of_type_Int, paramNoticeParam.jdField_a_of_type_JavaLangString), localNotification);
      }
    }
  }
  
  public void a(String paramString)
  {
    bdii.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
    {
      bdmr localbdmr = (bdmr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localbdmr != null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelBySendTime", localbdmr.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void b(String paramString)
  {
    bdii.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelNotRemoveId", ((bdmr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdmq
 * JD-Core Version:    0.7.0.1
 */