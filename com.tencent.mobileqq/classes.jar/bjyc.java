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

public class bjyc
{
  protected static bjyc a;
  protected bjye a;
  protected QQNotificationManager a;
  protected final ConcurrentHashMap<String, bjyd> a;
  
  protected bjyc()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
  }
  
  private int a(String paramString)
  {
    bjtx.b("AppNotificationManager", ">genNextNotificationId key:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 378;
    }
    int i = Math.abs(paramString.hashCode()) % 99;
    bjtx.b("AppNotificationManager", ">genNextNotificationId mod:" + i);
    i += 378;
    bjtx.b("AppNotificationManager", ">genNextNotificationId id:" + i);
    return i;
  }
  
  public static bjyc a()
  {
    if (jdField_a_of_type_Bjyc == null) {
      jdField_a_of_type_Bjyc = new bjyc();
    }
    return jdField_a_of_type_Bjyc;
  }
  
  public int a(String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      bjtx.e("AppNotificationManager", ">getNotificationId param error, return invalid id.");
      return -1;
    }
    bjtx.b("AppNotificationManager", ">getNotificationId " + paramString1 + ", " + paramString2);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramString1 = new bjyd(this);
      paramString1.jdField_a_of_type_JavaLangString = str;
      paramString1.jdField_a_of_type_Int = a(str);
      paramString1.jdField_b_of_type_Int = paramInt;
      paramString1.jdField_b_of_type_JavaLangString = paramString2;
      paramString1.jdField_a_of_type_Long = (System.currentTimeMillis() + paramString1.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
    }
    return ((bjyd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).jdField_a_of_type_Int;
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    bjtx.b("AppNotificationManager", ">getNotificationWhen " + paramString1 + ", " + paramString2);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      bjyd localbjyd = new bjyd(this);
      localbjyd.jdField_a_of_type_JavaLangString = paramString1;
      localbjyd.jdField_a_of_type_Int = a(paramString1);
      localbjyd.jdField_b_of_type_Int = paramInt;
      localbjyd.jdField_b_of_type_JavaLangString = paramString2;
      localbjyd.jdField_a_of_type_Long = (System.currentTimeMillis() + localbjyd.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localbjyd);
    }
    return ((bjyd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).jdField_a_of_type_Long;
  }
  
  public Notification a(NoticeParam paramNoticeParam)
  {
    if ((bjjo.a().a() == null) || (paramNoticeParam == null))
    {
      bjtx.e("AppNotificationManager", "getNotification context == null");
      return null;
    }
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNoticeParam.jdField_b_of_type_JavaLangString;
    localNotification.when = paramNoticeParam.jdField_a_of_type_Long;
    RemoteViews localRemoteViews = new RemoteViews(bjjo.a().a().getPackageName(), 2131559659);
    Object localObject = bjyg.a(1, paramNoticeParam);
    a(localRemoteViews);
    localRemoteViews.setInt(2131371961, "setBackgroundColor", -1);
    localRemoteViews.setInt(2131371963, "setTextColor", -16777216);
    localRemoteViews.setInt(2131371957, "setTextColor", -12303292);
    localRemoteViews.setInt(2131371951, "setTextColor", -12303292);
    localRemoteViews.setTextViewText(2131371963, bjud.a(paramNoticeParam.jdField_b_of_type_JavaLangString, 18, true, true));
    if (paramNoticeParam.jdField_b_of_type_Int == 1)
    {
      localNotification.icon = 2130844388;
      localRemoteViews.setImageViewResource(2131371952, 2130844384);
      localRemoteViews.setViewVisibility(2131371951, 8);
      localRemoteViews.setViewVisibility(2131371945, 0);
      if (Build.VERSION.SDK_INT > 10) {
        localRemoteViews.setOnClickPendingIntent(2131371961, (PendingIntent)localObject);
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
        localNotification.icon = 2130844388;
        if (paramNoticeParam.jdField_b_of_type_Int == 0)
        {
          localRemoteViews.setTextViewText(2131371951, bjjo.a().a().getString(2131694032));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131371952, 2130844384);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 2)
        {
          localRemoteViews.setTextViewText(2131371951, bjjo.a().a().getString(2131694035));
          localObject = bjva.a(paramNoticeParam.d);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131371952, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = bjyg.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 3)
        {
          localRemoteViews.setTextViewText(2131371951, bjjo.a().a().getString(2131694032));
          localObject = bjyg.a(4, paramNoticeParam);
          Bitmap localBitmap = bjtv.a(paramNoticeParam.jdField_a_of_type_JavaLangString);
          if (localBitmap == null) {
            break label476;
          }
          localRemoteViews.setImageViewBitmap(2131371952, localBitmap);
        }
        for (;;)
        {
          if (paramNoticeParam.jdField_b_of_type_Int == 0)
          {
            if (Build.VERSION.SDK_INT > 10)
            {
              localRemoteViews.setOnClickPendingIntent(2131371961, (PendingIntent)localObject);
              break;
              label476:
              bjtx.b("AppNotificationManager", ">>download icon fail,so we use default notification icon");
              localRemoteViews.setImageViewResource(2131371952, 2130844384);
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
        localNotification.icon = 2130844388;
        localRemoteViews.setImageViewResource(2131371952, 2130844384);
        localRemoteViews.setTextViewText(2131371951, bjjo.a().a().getString(2131694031));
        localRemoteViews.setViewVisibility(2131371951, 0);
        localRemoteViews.setViewVisibility(2131371945, 8);
        paramNoticeParam = bjyg.a(5, paramNoticeParam);
        localNotification.flags |= 0x10;
        localNotification.contentIntent = paramNoticeParam;
      }
      else
      {
        localNotification.icon = 2130841845;
        localRemoteViews.setImageViewResource(2131371952, 2130841846);
        localRemoteViews.setTextViewText(2131371951, paramNoticeParam.c);
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
    }
  }
  
  public ConcurrentHashMap<String, bjyd> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {}
    try
    {
      blgq.a(bjjo.a().a(), 0, paramNotification);
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify2", paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      bjtx.c("AppNotificationManager", "notify>>>", paramNotification);
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    if ((this.jdField_a_of_type_Bjye == null) || (this.jdField_a_of_type_Bjye.a() == null)) {
      this.jdField_a_of_type_Bjye = new bjye(this, bjjo.a().a());
    }
    bjtx.b("notificationtest", "title color:" + this.jdField_a_of_type_Bjye.b());
    if (this.jdField_a_of_type_Bjye.b() != null) {
      paramRemoteViews.setTextColor(2131371963, this.jdField_a_of_type_Bjye.b().intValue());
    }
    bjtx.b("notificationtest", "text color:" + this.jdField_a_of_type_Bjye.a());
    if (this.jdField_a_of_type_Bjye.a() != null) {
      paramRemoteViews.setTextColor(2131371951, this.jdField_a_of_type_Bjye.a().intValue());
    }
    if (this.jdField_a_of_type_Bjye.a() != null) {
      paramRemoteViews.setTextColor(2131371957, this.jdField_a_of_type_Bjye.a().intValue());
    }
    bjtx.b("notificationtest", "text size:" + this.jdField_a_of_type_Bjye.a());
    if (this.jdField_a_of_type_Bjye.a() > 0.0F) {
      paramRemoteViews.setFloat(2131371951, "setTextSize", this.jdField_a_of_type_Bjye.a());
    }
    if (this.jdField_a_of_type_Bjye.a() > 0.0F) {
      paramRemoteViews.setFloat(2131371957, "setTextSize", this.jdField_a_of_type_Bjye.a());
    }
    if (this.jdField_a_of_type_Bjye.b() > 0.0F) {
      paramRemoteViews.setFloat(2131371963, "setTextSize", this.jdField_a_of_type_Bjye.b());
    }
    ApplicationInfo localApplicationInfo = bjjo.a().a().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.jdField_a_of_type_Bjye.b().intValue();
      paramRemoteViews.setInt(2131371961, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
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
        blgq.a(bjjo.a().a(), 0, localNotification);
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify1", a(paramNoticeParam.f, paramNoticeParam.jdField_b_of_type_Int, paramNoticeParam.jdField_a_of_type_JavaLangString), localNotification);
      }
    }
  }
  
  public void a(String paramString)
  {
    bjtx.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
    {
      bjyd localbjyd = (bjyd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localbjyd != null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelBySendTime", localbjyd.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void b(String paramString)
  {
    bjtx.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelNotRemoveId", ((bjyd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjyc
 * JD-Core Version:    0.7.0.1
 */