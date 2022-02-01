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

public class bidk
{
  protected static bidk a;
  protected bidm a;
  protected QQNotificationManager a;
  protected final ConcurrentHashMap<String, bidl> a;
  
  protected bidk()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
  }
  
  private int a(String paramString)
  {
    bhzm.b("AppNotificationManager", ">genNextNotificationId key:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 378;
    }
    int i = Math.abs(paramString.hashCode()) % 99;
    bhzm.b("AppNotificationManager", ">genNextNotificationId mod:" + i);
    i += 378;
    bhzm.b("AppNotificationManager", ">genNextNotificationId id:" + i);
    return i;
  }
  
  public static bidk a()
  {
    if (jdField_a_of_type_Bidk == null) {
      jdField_a_of_type_Bidk = new bidk();
    }
    return jdField_a_of_type_Bidk;
  }
  
  public int a(String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      bhzm.e("AppNotificationManager", ">getNotificationId param error, return invalid id.");
      return -1;
    }
    bhzm.b("AppNotificationManager", ">getNotificationId " + paramString1 + ", " + paramString2);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramString1 = new bidl(this);
      paramString1.jdField_a_of_type_JavaLangString = str;
      paramString1.jdField_a_of_type_Int = a(str);
      paramString1.jdField_b_of_type_Int = paramInt;
      paramString1.jdField_b_of_type_JavaLangString = paramString2;
      paramString1.jdField_a_of_type_Long = (System.currentTimeMillis() + paramString1.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
    }
    return ((bidl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).jdField_a_of_type_Int;
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    bhzm.b("AppNotificationManager", ">getNotificationWhen " + paramString1 + ", " + paramString2);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      bidl localbidl = new bidl(this);
      localbidl.jdField_a_of_type_JavaLangString = paramString1;
      localbidl.jdField_a_of_type_Int = a(paramString1);
      localbidl.jdField_b_of_type_Int = paramInt;
      localbidl.jdField_b_of_type_JavaLangString = paramString2;
      localbidl.jdField_a_of_type_Long = (System.currentTimeMillis() + localbidl.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localbidl);
    }
    return ((bidl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).jdField_a_of_type_Long;
  }
  
  public Notification a(NoticeParam paramNoticeParam)
  {
    if ((bhpc.a().a() == null) || (paramNoticeParam == null))
    {
      bhzm.e("AppNotificationManager", "getNotification context == null");
      return null;
    }
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNoticeParam.jdField_b_of_type_JavaLangString;
    localNotification.when = paramNoticeParam.jdField_a_of_type_Long;
    RemoteViews localRemoteViews = new RemoteViews(bhpc.a().a().getPackageName(), 2131559661);
    Object localObject = bido.a(1, paramNoticeParam);
    a(localRemoteViews);
    localRemoteViews.setInt(2131371926, "setBackgroundColor", -1);
    localRemoteViews.setInt(2131371928, "setTextColor", -16777216);
    localRemoteViews.setInt(2131371922, "setTextColor", -12303292);
    localRemoteViews.setInt(2131371916, "setTextColor", -12303292);
    localRemoteViews.setTextViewText(2131371928, bhzp.a(paramNoticeParam.jdField_b_of_type_JavaLangString, 18, true, true));
    if (paramNoticeParam.jdField_b_of_type_Int == 1)
    {
      localNotification.icon = 2130844273;
      localRemoteViews.setImageViewResource(2131371917, 2130844269);
      localRemoteViews.setViewVisibility(2131371916, 8);
      localRemoteViews.setViewVisibility(2131371911, 0);
      if (Build.VERSION.SDK_INT > 10) {
        localRemoteViews.setOnClickPendingIntent(2131371926, (PendingIntent)localObject);
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
        localNotification.icon = 2130844273;
        if (paramNoticeParam.jdField_b_of_type_Int == 0)
        {
          localRemoteViews.setTextViewText(2131371916, bhpc.a().a().getString(2131694134));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131371917, 2130844269);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 2)
        {
          localRemoteViews.setTextViewText(2131371916, bhpc.a().a().getString(2131694137));
          localObject = biam.a(paramNoticeParam.d);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131371917, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = bido.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 3)
        {
          localRemoteViews.setTextViewText(2131371916, bhpc.a().a().getString(2131694134));
          localObject = bido.a(4, paramNoticeParam);
          Bitmap localBitmap = bhzk.a(paramNoticeParam.jdField_a_of_type_JavaLangString);
          if (localBitmap == null) {
            break label476;
          }
          localRemoteViews.setImageViewBitmap(2131371917, localBitmap);
        }
        for (;;)
        {
          if (paramNoticeParam.jdField_b_of_type_Int == 0)
          {
            if (Build.VERSION.SDK_INT > 10)
            {
              localRemoteViews.setOnClickPendingIntent(2131371926, (PendingIntent)localObject);
              break;
              label476:
              bhzm.b("AppNotificationManager", ">>download icon fail,so we use default notification icon");
              localRemoteViews.setImageViewResource(2131371917, 2130844269);
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
        localNotification.icon = 2130844273;
        localRemoteViews.setImageViewResource(2131371917, 2130844269);
        localRemoteViews.setTextViewText(2131371916, bhpc.a().a().getString(2131694133));
        localRemoteViews.setViewVisibility(2131371916, 0);
        localRemoteViews.setViewVisibility(2131371911, 8);
        paramNoticeParam = bido.a(5, paramNoticeParam);
        localNotification.flags |= 0x10;
        localNotification.contentIntent = paramNoticeParam;
      }
      else
      {
        localNotification.icon = 2130841887;
        localRemoteViews.setImageViewResource(2131371917, 2130841888);
        localRemoteViews.setTextViewText(2131371916, paramNoticeParam.c);
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
    }
  }
  
  public ConcurrentHashMap<String, bidl> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {}
    try
    {
      bjmf.a(bhpc.a().a(), 0, paramNotification);
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify2", paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      bhzm.c("AppNotificationManager", "notify>>>", paramNotification);
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    if ((this.jdField_a_of_type_Bidm == null) || (this.jdField_a_of_type_Bidm.a() == null)) {
      this.jdField_a_of_type_Bidm = new bidm(this, bhpc.a().a());
    }
    bhzm.b("notificationtest", "title color:" + this.jdField_a_of_type_Bidm.b());
    if (this.jdField_a_of_type_Bidm.b() != null) {
      paramRemoteViews.setTextColor(2131371928, this.jdField_a_of_type_Bidm.b().intValue());
    }
    bhzm.b("notificationtest", "text color:" + this.jdField_a_of_type_Bidm.a());
    if (this.jdField_a_of_type_Bidm.a() != null) {
      paramRemoteViews.setTextColor(2131371916, this.jdField_a_of_type_Bidm.a().intValue());
    }
    if (this.jdField_a_of_type_Bidm.a() != null) {
      paramRemoteViews.setTextColor(2131371922, this.jdField_a_of_type_Bidm.a().intValue());
    }
    bhzm.b("notificationtest", "text size:" + this.jdField_a_of_type_Bidm.a());
    if (this.jdField_a_of_type_Bidm.a() > 0.0F) {
      paramRemoteViews.setFloat(2131371916, "setTextSize", this.jdField_a_of_type_Bidm.a());
    }
    if (this.jdField_a_of_type_Bidm.a() > 0.0F) {
      paramRemoteViews.setFloat(2131371922, "setTextSize", this.jdField_a_of_type_Bidm.a());
    }
    if (this.jdField_a_of_type_Bidm.b() > 0.0F) {
      paramRemoteViews.setFloat(2131371928, "setTextSize", this.jdField_a_of_type_Bidm.b());
    }
    ApplicationInfo localApplicationInfo = bhpc.a().a().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.jdField_a_of_type_Bidm.b().intValue();
      paramRemoteViews.setInt(2131371926, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
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
        bjmf.a(bhpc.a().a(), 0, localNotification);
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify1", a(paramNoticeParam.f, paramNoticeParam.jdField_b_of_type_Int, paramNoticeParam.jdField_a_of_type_JavaLangString), localNotification);
      }
    }
  }
  
  public void a(String paramString)
  {
    bhzm.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
    {
      bidl localbidl = (bidl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localbidl != null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelBySendTime", localbidl.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void b(String paramString)
  {
    bhzm.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelNotRemoveId", ((bidl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidk
 * JD-Core Version:    0.7.0.1
 */