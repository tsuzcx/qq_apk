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

public class bixd
{
  protected static bixd a;
  protected bixf a;
  protected QQNotificationManager a;
  protected final ConcurrentHashMap<String, bixe> a;
  
  protected bixd()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
  }
  
  private int a(String paramString)
  {
    bisy.b("AppNotificationManager", ">genNextNotificationId key:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 378;
    }
    int i = Math.abs(paramString.hashCode()) % 99;
    bisy.b("AppNotificationManager", ">genNextNotificationId mod:" + i);
    i += 378;
    bisy.b("AppNotificationManager", ">genNextNotificationId id:" + i);
    return i;
  }
  
  public static bixd a()
  {
    if (jdField_a_of_type_Bixd == null) {
      jdField_a_of_type_Bixd = new bixd();
    }
    return jdField_a_of_type_Bixd;
  }
  
  public int a(String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      bisy.e("AppNotificationManager", ">getNotificationId param error, return invalid id.");
      return -1;
    }
    bisy.b("AppNotificationManager", ">getNotificationId " + paramString1 + ", " + paramString2);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramString1 = new bixe(this);
      paramString1.jdField_a_of_type_JavaLangString = str;
      paramString1.jdField_a_of_type_Int = a(str);
      paramString1.jdField_b_of_type_Int = paramInt;
      paramString1.jdField_b_of_type_JavaLangString = paramString2;
      paramString1.jdField_a_of_type_Long = (System.currentTimeMillis() + paramString1.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
    }
    return ((bixe)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).jdField_a_of_type_Int;
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    bisy.b("AppNotificationManager", ">getNotificationWhen " + paramString1 + ", " + paramString2);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      bixe localbixe = new bixe(this);
      localbixe.jdField_a_of_type_JavaLangString = paramString1;
      localbixe.jdField_a_of_type_Int = a(paramString1);
      localbixe.jdField_b_of_type_Int = paramInt;
      localbixe.jdField_b_of_type_JavaLangString = paramString2;
      localbixe.jdField_a_of_type_Long = (System.currentTimeMillis() + localbixe.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localbixe);
    }
    return ((bixe)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).jdField_a_of_type_Long;
  }
  
  public Notification a(NoticeParam paramNoticeParam)
  {
    if ((biip.a().a() == null) || (paramNoticeParam == null))
    {
      bisy.e("AppNotificationManager", "getNotification context == null");
      return null;
    }
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNoticeParam.jdField_b_of_type_JavaLangString;
    localNotification.when = paramNoticeParam.jdField_a_of_type_Long;
    RemoteViews localRemoteViews = new RemoteViews(biip.a().a().getPackageName(), 2131559653);
    Object localObject = bixh.a(1, paramNoticeParam);
    a(localRemoteViews);
    localRemoteViews.setInt(2131371853, "setBackgroundColor", -1);
    localRemoteViews.setInt(2131371855, "setTextColor", -16777216);
    localRemoteViews.setInt(2131371849, "setTextColor", -12303292);
    localRemoteViews.setInt(2131371843, "setTextColor", -12303292);
    localRemoteViews.setTextViewText(2131371855, bite.a(paramNoticeParam.jdField_b_of_type_JavaLangString, 18, true, true));
    if (paramNoticeParam.jdField_b_of_type_Int == 1)
    {
      localNotification.icon = 2130844374;
      localRemoteViews.setImageViewResource(2131371844, 2130844370);
      localRemoteViews.setViewVisibility(2131371843, 8);
      localRemoteViews.setViewVisibility(2131371838, 0);
      if (Build.VERSION.SDK_INT > 10) {
        localRemoteViews.setOnClickPendingIntent(2131371853, (PendingIntent)localObject);
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
        localNotification.icon = 2130844374;
        if (paramNoticeParam.jdField_b_of_type_Int == 0)
        {
          localRemoteViews.setTextViewText(2131371843, biip.a().a().getString(2131694015));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131371844, 2130844370);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 2)
        {
          localRemoteViews.setTextViewText(2131371843, biip.a().a().getString(2131694018));
          localObject = biub.a(paramNoticeParam.d);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131371844, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = bixh.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 3)
        {
          localRemoteViews.setTextViewText(2131371843, biip.a().a().getString(2131694015));
          localObject = bixh.a(4, paramNoticeParam);
          Bitmap localBitmap = bisw.a(paramNoticeParam.jdField_a_of_type_JavaLangString);
          if (localBitmap == null) {
            break label476;
          }
          localRemoteViews.setImageViewBitmap(2131371844, localBitmap);
        }
        for (;;)
        {
          if (paramNoticeParam.jdField_b_of_type_Int == 0)
          {
            if (Build.VERSION.SDK_INT > 10)
            {
              localRemoteViews.setOnClickPendingIntent(2131371853, (PendingIntent)localObject);
              break;
              label476:
              bisy.b("AppNotificationManager", ">>download icon fail,so we use default notification icon");
              localRemoteViews.setImageViewResource(2131371844, 2130844370);
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
        localNotification.icon = 2130844374;
        localRemoteViews.setImageViewResource(2131371844, 2130844370);
        localRemoteViews.setTextViewText(2131371843, biip.a().a().getString(2131694014));
        localRemoteViews.setViewVisibility(2131371843, 0);
        localRemoteViews.setViewVisibility(2131371838, 8);
        paramNoticeParam = bixh.a(5, paramNoticeParam);
        localNotification.flags |= 0x10;
        localNotification.contentIntent = paramNoticeParam;
      }
      else
      {
        localNotification.icon = 2130841833;
        localRemoteViews.setImageViewResource(2131371844, 2130841834);
        localRemoteViews.setTextViewText(2131371843, paramNoticeParam.c);
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
    }
  }
  
  public ConcurrentHashMap<String, bixe> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {}
    try
    {
      bkfm.a(biip.a().a(), 0, paramNotification);
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify2", paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      bisy.c("AppNotificationManager", "notify>>>", paramNotification);
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    if ((this.jdField_a_of_type_Bixf == null) || (this.jdField_a_of_type_Bixf.a() == null)) {
      this.jdField_a_of_type_Bixf = new bixf(this, biip.a().a());
    }
    bisy.b("notificationtest", "title color:" + this.jdField_a_of_type_Bixf.b());
    if (this.jdField_a_of_type_Bixf.b() != null) {
      paramRemoteViews.setTextColor(2131371855, this.jdField_a_of_type_Bixf.b().intValue());
    }
    bisy.b("notificationtest", "text color:" + this.jdField_a_of_type_Bixf.a());
    if (this.jdField_a_of_type_Bixf.a() != null) {
      paramRemoteViews.setTextColor(2131371843, this.jdField_a_of_type_Bixf.a().intValue());
    }
    if (this.jdField_a_of_type_Bixf.a() != null) {
      paramRemoteViews.setTextColor(2131371849, this.jdField_a_of_type_Bixf.a().intValue());
    }
    bisy.b("notificationtest", "text size:" + this.jdField_a_of_type_Bixf.a());
    if (this.jdField_a_of_type_Bixf.a() > 0.0F) {
      paramRemoteViews.setFloat(2131371843, "setTextSize", this.jdField_a_of_type_Bixf.a());
    }
    if (this.jdField_a_of_type_Bixf.a() > 0.0F) {
      paramRemoteViews.setFloat(2131371849, "setTextSize", this.jdField_a_of_type_Bixf.a());
    }
    if (this.jdField_a_of_type_Bixf.b() > 0.0F) {
      paramRemoteViews.setFloat(2131371855, "setTextSize", this.jdField_a_of_type_Bixf.b());
    }
    ApplicationInfo localApplicationInfo = biip.a().a().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.jdField_a_of_type_Bixf.b().intValue();
      paramRemoteViews.setInt(2131371853, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
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
        bkfm.a(biip.a().a(), 0, localNotification);
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify1", a(paramNoticeParam.f, paramNoticeParam.jdField_b_of_type_Int, paramNoticeParam.jdField_a_of_type_JavaLangString), localNotification);
      }
    }
  }
  
  public void a(String paramString)
  {
    bisy.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
    {
      bixe localbixe = (bixe)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localbixe != null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelBySendTime", localbixe.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void b(String paramString)
  {
    bisy.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelNotRemoveId", ((bixe)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bixd
 * JD-Core Version:    0.7.0.1
 */