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

public class bcia
{
  protected static bcia a;
  protected bcic a;
  protected QQNotificationManager a;
  protected final ConcurrentHashMap<String, bcib> a;
  
  protected bcia()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
  }
  
  private int a(String paramString)
  {
    bcds.b("AppNotificationManager", ">genNextNotificationId key:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 378;
    }
    int i = Math.abs(paramString.hashCode()) % 99;
    bcds.b("AppNotificationManager", ">genNextNotificationId mod:" + i);
    i += 378;
    bcds.b("AppNotificationManager", ">genNextNotificationId id:" + i);
    return i;
  }
  
  public static bcia a()
  {
    if (jdField_a_of_type_Bcia == null) {
      jdField_a_of_type_Bcia = new bcia();
    }
    return jdField_a_of_type_Bcia;
  }
  
  public int a(String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      bcds.e("AppNotificationManager", ">getNotificationId param error, return invalid id.");
      return -1;
    }
    bcds.b("AppNotificationManager", ">getNotificationId " + paramString1 + ", " + paramString2);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramString1 = new bcib(this);
      paramString1.jdField_a_of_type_JavaLangString = str;
      paramString1.jdField_a_of_type_Int = a(str);
      paramString1.jdField_b_of_type_Int = paramInt;
      paramString1.jdField_b_of_type_JavaLangString = paramString2;
      paramString1.jdField_a_of_type_Long = (System.currentTimeMillis() + paramString1.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
    }
    return ((bcib)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).jdField_a_of_type_Int;
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    bcds.b("AppNotificationManager", ">getNotificationWhen " + paramString1 + ", " + paramString2);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      bcib localbcib = new bcib(this);
      localbcib.jdField_a_of_type_JavaLangString = paramString1;
      localbcib.jdField_a_of_type_Int = a(paramString1);
      localbcib.jdField_b_of_type_Int = paramInt;
      localbcib.jdField_b_of_type_JavaLangString = paramString2;
      localbcib.jdField_a_of_type_Long = (System.currentTimeMillis() + localbcib.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localbcib);
    }
    return ((bcib)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).jdField_a_of_type_Long;
  }
  
  public Notification a(NoticeParam paramNoticeParam)
  {
    if ((bbtm.a().a() == null) || (paramNoticeParam == null))
    {
      bcds.e("AppNotificationManager", "getNotification context == null");
      return null;
    }
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNoticeParam.jdField_b_of_type_JavaLangString;
    localNotification.when = paramNoticeParam.jdField_a_of_type_Long;
    RemoteViews localRemoteViews = new RemoteViews(bbtm.a().a().getPackageName(), 2131493898);
    Object localObject = bcie.a(1, paramNoticeParam);
    a(localRemoteViews);
    localRemoteViews.setInt(2131305281, "setBackgroundColor", -1);
    localRemoteViews.setInt(2131305283, "setTextColor", -16777216);
    localRemoteViews.setInt(2131305277, "setTextColor", -12303292);
    localRemoteViews.setInt(2131305273, "setTextColor", -12303292);
    localRemoteViews.setTextViewText(2131305283, bcdy.a(paramNoticeParam.jdField_b_of_type_JavaLangString, 18, true, true));
    if (paramNoticeParam.jdField_b_of_type_Int == 1)
    {
      localNotification.icon = 2130843464;
      localRemoteViews.setImageViewResource(2131305274, 2130843460);
      localRemoteViews.setViewVisibility(2131305273, 8);
      localRemoteViews.setViewVisibility(2131305269, 0);
      if (Build.VERSION.SDK_INT > 10) {
        localRemoteViews.setOnClickPendingIntent(2131305281, (PendingIntent)localObject);
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
        localNotification.icon = 2130843464;
        if (paramNoticeParam.jdField_b_of_type_Int == 0)
        {
          localRemoteViews.setTextViewText(2131305273, bbtm.a().a().getString(2131629049));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131305274, 2130843460);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 2)
        {
          localRemoteViews.setTextViewText(2131305273, bbtm.a().a().getString(2131629052));
          localObject = bcev.a(paramNoticeParam.d);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131305274, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = bcie.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 3)
        {
          localRemoteViews.setTextViewText(2131305273, bbtm.a().a().getString(2131629049));
          localObject = bcie.a(4, paramNoticeParam);
          Bitmap localBitmap = bcdq.a(paramNoticeParam.jdField_a_of_type_JavaLangString);
          if (localBitmap == null) {
            break label476;
          }
          localRemoteViews.setImageViewBitmap(2131305274, localBitmap);
        }
        for (;;)
        {
          if (paramNoticeParam.jdField_b_of_type_Int == 0)
          {
            if (Build.VERSION.SDK_INT > 10)
            {
              localRemoteViews.setOnClickPendingIntent(2131305281, (PendingIntent)localObject);
              break;
              label476:
              bcds.b("AppNotificationManager", ">>download icon fail,so we use default notification icon");
              localRemoteViews.setImageViewResource(2131305274, 2130843460);
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
        localNotification.icon = 2130843464;
        localRemoteViews.setImageViewResource(2131305274, 2130843460);
        localRemoteViews.setTextViewText(2131305273, bbtm.a().a().getString(2131629048));
        localRemoteViews.setViewVisibility(2131305273, 0);
        localRemoteViews.setViewVisibility(2131305269, 8);
        paramNoticeParam = bcie.a(5, paramNoticeParam);
        localNotification.flags |= 0x10;
        localNotification.contentIntent = paramNoticeParam;
      }
      else
      {
        localNotification.icon = 2130841292;
        localRemoteViews.setImageViewResource(2131305274, 2130841293);
        localRemoteViews.setTextViewText(2131305273, paramNoticeParam.c);
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
    }
  }
  
  public ConcurrentHashMap<String, bcib> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {}
    try
    {
      beeq.a(bbtm.a().a(), 0, paramNotification);
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify2", paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      bcds.c("AppNotificationManager", "notify>>>", paramNotification);
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    if ((this.jdField_a_of_type_Bcic == null) || (this.jdField_a_of_type_Bcic.a() == null)) {
      this.jdField_a_of_type_Bcic = new bcic(this, bbtm.a().a());
    }
    bcds.b("notificationtest", "title color:" + this.jdField_a_of_type_Bcic.b());
    if (this.jdField_a_of_type_Bcic.b() != null) {
      paramRemoteViews.setTextColor(2131305283, this.jdField_a_of_type_Bcic.b().intValue());
    }
    bcds.b("notificationtest", "text color:" + this.jdField_a_of_type_Bcic.a());
    if (this.jdField_a_of_type_Bcic.a() != null) {
      paramRemoteViews.setTextColor(2131305273, this.jdField_a_of_type_Bcic.a().intValue());
    }
    if (this.jdField_a_of_type_Bcic.a() != null) {
      paramRemoteViews.setTextColor(2131305277, this.jdField_a_of_type_Bcic.a().intValue());
    }
    bcds.b("notificationtest", "text size:" + this.jdField_a_of_type_Bcic.a());
    if (this.jdField_a_of_type_Bcic.a() > 0.0F) {
      paramRemoteViews.setFloat(2131305273, "setTextSize", this.jdField_a_of_type_Bcic.a());
    }
    if (this.jdField_a_of_type_Bcic.a() > 0.0F) {
      paramRemoteViews.setFloat(2131305277, "setTextSize", this.jdField_a_of_type_Bcic.a());
    }
    if (this.jdField_a_of_type_Bcic.b() > 0.0F) {
      paramRemoteViews.setFloat(2131305283, "setTextSize", this.jdField_a_of_type_Bcic.b());
    }
    ApplicationInfo localApplicationInfo = bbtm.a().a().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.jdField_a_of_type_Bcic.b().intValue();
      paramRemoteViews.setInt(2131305281, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
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
        beeq.a(bbtm.a().a(), 0, localNotification);
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify1", a(paramNoticeParam.f, paramNoticeParam.jdField_b_of_type_Int, paramNoticeParam.jdField_a_of_type_JavaLangString), localNotification);
      }
    }
  }
  
  public void a(String paramString)
  {
    bcds.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
    {
      bcib localbcib = (bcib)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localbcib != null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelBySendTime", localbcib.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void b(String paramString)
  {
    bcds.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelNotRemoveId", ((bcib)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcia
 * JD-Core Version:    0.7.0.1
 */