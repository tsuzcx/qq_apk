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

public class bfpw
{
  protected static bfpw a;
  protected bfpy a;
  protected QQNotificationManager a;
  protected final ConcurrentHashMap<String, bfpx> a;
  
  protected bfpw()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
  }
  
  private int a(String paramString)
  {
    bflp.b("AppNotificationManager", ">genNextNotificationId key:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 378;
    }
    int i = Math.abs(paramString.hashCode()) % 99;
    bflp.b("AppNotificationManager", ">genNextNotificationId mod:" + i);
    i += 378;
    bflp.b("AppNotificationManager", ">genNextNotificationId id:" + i);
    return i;
  }
  
  public static bfpw a()
  {
    if (jdField_a_of_type_Bfpw == null) {
      jdField_a_of_type_Bfpw = new bfpw();
    }
    return jdField_a_of_type_Bfpw;
  }
  
  public int a(String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      bflp.e("AppNotificationManager", ">getNotificationId param error, return invalid id.");
      return -1;
    }
    bflp.b("AppNotificationManager", ">getNotificationId " + paramString1 + ", " + paramString2);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramString1 = new bfpx(this);
      paramString1.jdField_a_of_type_JavaLangString = str;
      paramString1.jdField_a_of_type_Int = a(str);
      paramString1.jdField_b_of_type_Int = paramInt;
      paramString1.jdField_b_of_type_JavaLangString = paramString2;
      paramString1.jdField_a_of_type_Long = (System.currentTimeMillis() + paramString1.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
    }
    return ((bfpx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).jdField_a_of_type_Int;
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    bflp.b("AppNotificationManager", ">getNotificationWhen " + paramString1 + ", " + paramString2);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      bfpx localbfpx = new bfpx(this);
      localbfpx.jdField_a_of_type_JavaLangString = paramString1;
      localbfpx.jdField_a_of_type_Int = a(paramString1);
      localbfpx.jdField_b_of_type_Int = paramInt;
      localbfpx.jdField_b_of_type_JavaLangString = paramString2;
      localbfpx.jdField_a_of_type_Long = (System.currentTimeMillis() + localbfpx.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localbfpx);
    }
    return ((bfpx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).jdField_a_of_type_Long;
  }
  
  public Notification a(NoticeParam paramNoticeParam)
  {
    if ((bfbm.a().a() == null) || (paramNoticeParam == null))
    {
      bflp.e("AppNotificationManager", "getNotification context == null");
      return null;
    }
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNoticeParam.jdField_b_of_type_JavaLangString;
    localNotification.when = paramNoticeParam.jdField_a_of_type_Long;
    RemoteViews localRemoteViews = new RemoteViews(bfbm.a().a().getPackageName(), 2131559517);
    Object localObject = bfqa.a(1, paramNoticeParam);
    a(localRemoteViews);
    localRemoteViews.setInt(2131371286, "setBackgroundColor", -1);
    localRemoteViews.setInt(2131371288, "setTextColor", -16777216);
    localRemoteViews.setInt(2131371282, "setTextColor", -12303292);
    localRemoteViews.setInt(2131371278, "setTextColor", -12303292);
    localRemoteViews.setTextViewText(2131371288, bflv.a(paramNoticeParam.jdField_b_of_type_JavaLangString, 18, true, true));
    if (paramNoticeParam.jdField_b_of_type_Int == 1)
    {
      localNotification.icon = 2130843980;
      localRemoteViews.setImageViewResource(2131371279, 2130843976);
      localRemoteViews.setViewVisibility(2131371278, 8);
      localRemoteViews.setViewVisibility(2131371274, 0);
      if (Build.VERSION.SDK_INT > 10) {
        localRemoteViews.setOnClickPendingIntent(2131371286, (PendingIntent)localObject);
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
        localNotification.icon = 2130843980;
        if (paramNoticeParam.jdField_b_of_type_Int == 0)
        {
          localRemoteViews.setTextViewText(2131371278, bfbm.a().a().getString(2131694873));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131371279, 2130843976);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 2)
        {
          localRemoteViews.setTextViewText(2131371278, bfbm.a().a().getString(2131694876));
          localObject = bfms.a(paramNoticeParam.d);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131371279, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = bfqa.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 3)
        {
          localRemoteViews.setTextViewText(2131371278, bfbm.a().a().getString(2131694873));
          localObject = bfqa.a(4, paramNoticeParam);
          Bitmap localBitmap = bfln.a(paramNoticeParam.jdField_a_of_type_JavaLangString);
          if (localBitmap == null) {
            break label476;
          }
          localRemoteViews.setImageViewBitmap(2131371279, localBitmap);
        }
        for (;;)
        {
          if (paramNoticeParam.jdField_b_of_type_Int == 0)
          {
            if (Build.VERSION.SDK_INT > 10)
            {
              localRemoteViews.setOnClickPendingIntent(2131371286, (PendingIntent)localObject);
              break;
              label476:
              bflp.b("AppNotificationManager", ">>download icon fail,so we use default notification icon");
              localRemoteViews.setImageViewResource(2131371279, 2130843976);
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
        localNotification.icon = 2130843980;
        localRemoteViews.setImageViewResource(2131371279, 2130843976);
        localRemoteViews.setTextViewText(2131371278, bfbm.a().a().getString(2131694872));
        localRemoteViews.setViewVisibility(2131371278, 0);
        localRemoteViews.setViewVisibility(2131371274, 8);
        paramNoticeParam = bfqa.a(5, paramNoticeParam);
        localNotification.flags |= 0x10;
        localNotification.contentIntent = paramNoticeParam;
      }
      else
      {
        localNotification.icon = 2130841530;
        localRemoteViews.setImageViewResource(2131371279, 2130841531);
        localRemoteViews.setTextViewText(2131371278, paramNoticeParam.c);
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
    }
  }
  
  public ConcurrentHashMap<String, bfpx> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {}
    try
    {
      bhsc.a(bfbm.a().a(), 0, paramNotification);
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify2", paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      bflp.c("AppNotificationManager", "notify>>>", paramNotification);
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    if ((this.jdField_a_of_type_Bfpy == null) || (this.jdField_a_of_type_Bfpy.a() == null)) {
      this.jdField_a_of_type_Bfpy = new bfpy(this, bfbm.a().a());
    }
    bflp.b("notificationtest", "title color:" + this.jdField_a_of_type_Bfpy.b());
    if (this.jdField_a_of_type_Bfpy.b() != null) {
      paramRemoteViews.setTextColor(2131371288, this.jdField_a_of_type_Bfpy.b().intValue());
    }
    bflp.b("notificationtest", "text color:" + this.jdField_a_of_type_Bfpy.a());
    if (this.jdField_a_of_type_Bfpy.a() != null) {
      paramRemoteViews.setTextColor(2131371278, this.jdField_a_of_type_Bfpy.a().intValue());
    }
    if (this.jdField_a_of_type_Bfpy.a() != null) {
      paramRemoteViews.setTextColor(2131371282, this.jdField_a_of_type_Bfpy.a().intValue());
    }
    bflp.b("notificationtest", "text size:" + this.jdField_a_of_type_Bfpy.a());
    if (this.jdField_a_of_type_Bfpy.a() > 0.0F) {
      paramRemoteViews.setFloat(2131371278, "setTextSize", this.jdField_a_of_type_Bfpy.a());
    }
    if (this.jdField_a_of_type_Bfpy.a() > 0.0F) {
      paramRemoteViews.setFloat(2131371282, "setTextSize", this.jdField_a_of_type_Bfpy.a());
    }
    if (this.jdField_a_of_type_Bfpy.b() > 0.0F) {
      paramRemoteViews.setFloat(2131371288, "setTextSize", this.jdField_a_of_type_Bfpy.b());
    }
    ApplicationInfo localApplicationInfo = bfbm.a().a().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.jdField_a_of_type_Bfpy.b().intValue();
      paramRemoteViews.setInt(2131371286, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
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
        bhsc.a(bfbm.a().a(), 0, localNotification);
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify1", a(paramNoticeParam.f, paramNoticeParam.jdField_b_of_type_Int, paramNoticeParam.jdField_a_of_type_JavaLangString), localNotification);
      }
    }
  }
  
  public void a(String paramString)
  {
    bflp.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
    {
      bfpx localbfpx = (bfpx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localbfpx != null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelBySendTime", localbfpx.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void b(String paramString)
  {
    bflp.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelNotRemoveId", ((bfpx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfpw
 * JD-Core Version:    0.7.0.1
 */