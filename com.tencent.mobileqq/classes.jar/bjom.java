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

public class bjom
{
  protected static bjom a;
  protected bjoo a;
  protected QQNotificationManager a;
  protected final ConcurrentHashMap<String, bjon> a;
  
  protected bjom()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
  }
  
  private int a(String paramString)
  {
    bjko.b("AppNotificationManager", ">genNextNotificationId key:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 378;
    }
    int i = Math.abs(paramString.hashCode()) % 99;
    bjko.b("AppNotificationManager", ">genNextNotificationId mod:" + i);
    i += 378;
    bjko.b("AppNotificationManager", ">genNextNotificationId id:" + i);
    return i;
  }
  
  public static bjom a()
  {
    if (jdField_a_of_type_Bjom == null) {
      jdField_a_of_type_Bjom = new bjom();
    }
    return jdField_a_of_type_Bjom;
  }
  
  public int a(String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      bjko.e("AppNotificationManager", ">getNotificationId param error, return invalid id.");
      return -1;
    }
    bjko.b("AppNotificationManager", ">getNotificationId " + paramString1 + ", " + paramString2);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramString1 = new bjon(this);
      paramString1.jdField_a_of_type_JavaLangString = str;
      paramString1.jdField_a_of_type_Int = a(str);
      paramString1.jdField_b_of_type_Int = paramInt;
      paramString1.jdField_b_of_type_JavaLangString = paramString2;
      paramString1.jdField_a_of_type_Long = (System.currentTimeMillis() + paramString1.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
    }
    return ((bjon)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).jdField_a_of_type_Int;
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    bjko.b("AppNotificationManager", ">getNotificationWhen " + paramString1 + ", " + paramString2);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      bjon localbjon = new bjon(this);
      localbjon.jdField_a_of_type_JavaLangString = paramString1;
      localbjon.jdField_a_of_type_Int = a(paramString1);
      localbjon.jdField_b_of_type_Int = paramInt;
      localbjon.jdField_b_of_type_JavaLangString = paramString2;
      localbjon.jdField_a_of_type_Long = (System.currentTimeMillis() + localbjon.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localbjon);
    }
    return ((bjon)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).jdField_a_of_type_Long;
  }
  
  public Notification a(NoticeParam paramNoticeParam)
  {
    if ((bizw.a().a() == null) || (paramNoticeParam == null))
    {
      bjko.e("AppNotificationManager", "getNotification context == null");
      return null;
    }
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNoticeParam.jdField_b_of_type_JavaLangString;
    localNotification.when = paramNoticeParam.jdField_a_of_type_Long;
    RemoteViews localRemoteViews = new RemoteViews(bizw.a().a().getPackageName(), 2131559696);
    Object localObject = bjoq.a(1, paramNoticeParam);
    a(localRemoteViews);
    localRemoteViews.setInt(2131372117, "setBackgroundColor", -1);
    localRemoteViews.setInt(2131372119, "setTextColor", -16777216);
    localRemoteViews.setInt(2131372113, "setTextColor", -12303292);
    localRemoteViews.setInt(2131372107, "setTextColor", -12303292);
    localRemoteViews.setTextViewText(2131372119, bjkr.a(paramNoticeParam.jdField_b_of_type_JavaLangString, 18, true, true));
    if (paramNoticeParam.jdField_b_of_type_Int == 1)
    {
      localNotification.icon = 2130844340;
      localRemoteViews.setImageViewResource(2131372108, 2130844336);
      localRemoteViews.setViewVisibility(2131372107, 8);
      localRemoteViews.setViewVisibility(2131372102, 0);
      if (Build.VERSION.SDK_INT > 10) {
        localRemoteViews.setOnClickPendingIntent(2131372117, (PendingIntent)localObject);
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
        localNotification.icon = 2130844340;
        if (paramNoticeParam.jdField_b_of_type_Int == 0)
        {
          localRemoteViews.setTextViewText(2131372107, bizw.a().a().getString(2131694331));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131372108, 2130844336);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 2)
        {
          localRemoteViews.setTextViewText(2131372107, bizw.a().a().getString(2131694334));
          localObject = bjlo.a(paramNoticeParam.d);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131372108, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = bjoq.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 3)
        {
          localRemoteViews.setTextViewText(2131372107, bizw.a().a().getString(2131694331));
          localObject = bjoq.a(4, paramNoticeParam);
          Bitmap localBitmap = bjkm.a(paramNoticeParam.jdField_a_of_type_JavaLangString);
          if (localBitmap == null) {
            break label476;
          }
          localRemoteViews.setImageViewBitmap(2131372108, localBitmap);
        }
        for (;;)
        {
          if (paramNoticeParam.jdField_b_of_type_Int == 0)
          {
            if (Build.VERSION.SDK_INT > 10)
            {
              localRemoteViews.setOnClickPendingIntent(2131372117, (PendingIntent)localObject);
              break;
              label476:
              bjko.b("AppNotificationManager", ">>download icon fail,so we use default notification icon");
              localRemoteViews.setImageViewResource(2131372108, 2130844336);
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
        localNotification.icon = 2130844340;
        localRemoteViews.setImageViewResource(2131372108, 2130844336);
        localRemoteViews.setTextViewText(2131372107, bizw.a().a().getString(2131694330));
        localRemoteViews.setViewVisibility(2131372107, 0);
        localRemoteViews.setViewVisibility(2131372102, 8);
        paramNoticeParam = bjoq.a(5, paramNoticeParam);
        localNotification.flags |= 0x10;
        localNotification.contentIntent = paramNoticeParam;
      }
      else
      {
        localNotification.icon = 2130841900;
        localRemoteViews.setImageViewResource(2131372108, 2130841901);
        localRemoteViews.setTextViewText(2131372107, paramNoticeParam.c);
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
    }
  }
  
  public ConcurrentHashMap<String, bjon> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {}
    try
    {
      bkxs.a(bizw.a().a(), 0, paramNotification);
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify2", paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      bjko.c("AppNotificationManager", "notify>>>", paramNotification);
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    if ((this.jdField_a_of_type_Bjoo == null) || (this.jdField_a_of_type_Bjoo.a() == null)) {
      this.jdField_a_of_type_Bjoo = new bjoo(this, bizw.a().a());
    }
    bjko.b("notificationtest", "title color:" + this.jdField_a_of_type_Bjoo.b());
    if (this.jdField_a_of_type_Bjoo.b() != null) {
      paramRemoteViews.setTextColor(2131372119, this.jdField_a_of_type_Bjoo.b().intValue());
    }
    bjko.b("notificationtest", "text color:" + this.jdField_a_of_type_Bjoo.a());
    if (this.jdField_a_of_type_Bjoo.a() != null) {
      paramRemoteViews.setTextColor(2131372107, this.jdField_a_of_type_Bjoo.a().intValue());
    }
    if (this.jdField_a_of_type_Bjoo.a() != null) {
      paramRemoteViews.setTextColor(2131372113, this.jdField_a_of_type_Bjoo.a().intValue());
    }
    bjko.b("notificationtest", "text size:" + this.jdField_a_of_type_Bjoo.a());
    if (this.jdField_a_of_type_Bjoo.a() > 0.0F) {
      paramRemoteViews.setFloat(2131372107, "setTextSize", this.jdField_a_of_type_Bjoo.a());
    }
    if (this.jdField_a_of_type_Bjoo.a() > 0.0F) {
      paramRemoteViews.setFloat(2131372113, "setTextSize", this.jdField_a_of_type_Bjoo.a());
    }
    if (this.jdField_a_of_type_Bjoo.b() > 0.0F) {
      paramRemoteViews.setFloat(2131372119, "setTextSize", this.jdField_a_of_type_Bjoo.b());
    }
    ApplicationInfo localApplicationInfo = bizw.a().a().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.jdField_a_of_type_Bjoo.b().intValue();
      paramRemoteViews.setInt(2131372117, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
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
        bkxs.a(bizw.a().a(), 0, localNotification);
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify1", a(paramNoticeParam.f, paramNoticeParam.jdField_b_of_type_Int, paramNoticeParam.jdField_a_of_type_JavaLangString), localNotification);
      }
    }
  }
  
  public void a(String paramString)
  {
    bjko.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
    {
      bjon localbjon = (bjon)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localbjon != null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelBySendTime", localbjon.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void b(String paramString)
  {
    bjko.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelNotRemoveId", ((bjon)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjom
 * JD-Core Version:    0.7.0.1
 */