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

public class bfln
{
  protected static bfln a;
  protected bflp a;
  protected QQNotificationManager a;
  protected final ConcurrentHashMap<String, bflo> a;
  
  protected bfln()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
  }
  
  private int a(String paramString)
  {
    bfhg.b("AppNotificationManager", ">genNextNotificationId key:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 378;
    }
    int i = Math.abs(paramString.hashCode()) % 99;
    bfhg.b("AppNotificationManager", ">genNextNotificationId mod:" + i);
    i += 378;
    bfhg.b("AppNotificationManager", ">genNextNotificationId id:" + i);
    return i;
  }
  
  public static bfln a()
  {
    if (jdField_a_of_type_Bfln == null) {
      jdField_a_of_type_Bfln = new bfln();
    }
    return jdField_a_of_type_Bfln;
  }
  
  public int a(String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      bfhg.e("AppNotificationManager", ">getNotificationId param error, return invalid id.");
      return -1;
    }
    bfhg.b("AppNotificationManager", ">getNotificationId " + paramString1 + ", " + paramString2);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramString1 = new bflo(this);
      paramString1.jdField_a_of_type_JavaLangString = str;
      paramString1.jdField_a_of_type_Int = a(str);
      paramString1.jdField_b_of_type_Int = paramInt;
      paramString1.jdField_b_of_type_JavaLangString = paramString2;
      paramString1.jdField_a_of_type_Long = (System.currentTimeMillis() + paramString1.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
    }
    return ((bflo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).jdField_a_of_type_Int;
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    bfhg.b("AppNotificationManager", ">getNotificationWhen " + paramString1 + ", " + paramString2);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      bflo localbflo = new bflo(this);
      localbflo.jdField_a_of_type_JavaLangString = paramString1;
      localbflo.jdField_a_of_type_Int = a(paramString1);
      localbflo.jdField_b_of_type_Int = paramInt;
      localbflo.jdField_b_of_type_JavaLangString = paramString2;
      localbflo.jdField_a_of_type_Long = (System.currentTimeMillis() + localbflo.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localbflo);
    }
    return ((bflo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).jdField_a_of_type_Long;
  }
  
  public Notification a(NoticeParam paramNoticeParam)
  {
    if ((bexd.a().a() == null) || (paramNoticeParam == null))
    {
      bfhg.e("AppNotificationManager", "getNotification context == null");
      return null;
    }
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNoticeParam.jdField_b_of_type_JavaLangString;
    localNotification.when = paramNoticeParam.jdField_a_of_type_Long;
    RemoteViews localRemoteViews = new RemoteViews(bexd.a().a().getPackageName(), 2131559518);
    Object localObject = bflr.a(1, paramNoticeParam);
    a(localRemoteViews);
    localRemoteViews.setInt(2131371267, "setBackgroundColor", -1);
    localRemoteViews.setInt(2131371269, "setTextColor", -16777216);
    localRemoteViews.setInt(2131371263, "setTextColor", -12303292);
    localRemoteViews.setInt(2131371259, "setTextColor", -12303292);
    localRemoteViews.setTextViewText(2131371269, bfhm.a(paramNoticeParam.jdField_b_of_type_JavaLangString, 18, true, true));
    if (paramNoticeParam.jdField_b_of_type_Int == 1)
    {
      localNotification.icon = 2130843908;
      localRemoteViews.setImageViewResource(2131371260, 2130843904);
      localRemoteViews.setViewVisibility(2131371259, 8);
      localRemoteViews.setViewVisibility(2131371255, 0);
      if (Build.VERSION.SDK_INT > 10) {
        localRemoteViews.setOnClickPendingIntent(2131371267, (PendingIntent)localObject);
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
        localNotification.icon = 2130843908;
        if (paramNoticeParam.jdField_b_of_type_Int == 0)
        {
          localRemoteViews.setTextViewText(2131371259, bexd.a().a().getString(2131694871));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131371260, 2130843904);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 2)
        {
          localRemoteViews.setTextViewText(2131371259, bexd.a().a().getString(2131694874));
          localObject = bfij.a(paramNoticeParam.d);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131371260, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = bflr.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 3)
        {
          localRemoteViews.setTextViewText(2131371259, bexd.a().a().getString(2131694871));
          localObject = bflr.a(4, paramNoticeParam);
          Bitmap localBitmap = bfhe.a(paramNoticeParam.jdField_a_of_type_JavaLangString);
          if (localBitmap == null) {
            break label476;
          }
          localRemoteViews.setImageViewBitmap(2131371260, localBitmap);
        }
        for (;;)
        {
          if (paramNoticeParam.jdField_b_of_type_Int == 0)
          {
            if (Build.VERSION.SDK_INT > 10)
            {
              localRemoteViews.setOnClickPendingIntent(2131371267, (PendingIntent)localObject);
              break;
              label476:
              bfhg.b("AppNotificationManager", ">>download icon fail,so we use default notification icon");
              localRemoteViews.setImageViewResource(2131371260, 2130843904);
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
        localNotification.icon = 2130843908;
        localRemoteViews.setImageViewResource(2131371260, 2130843904);
        localRemoteViews.setTextViewText(2131371259, bexd.a().a().getString(2131694870));
        localRemoteViews.setViewVisibility(2131371259, 0);
        localRemoteViews.setViewVisibility(2131371255, 8);
        paramNoticeParam = bflr.a(5, paramNoticeParam);
        localNotification.flags |= 0x10;
        localNotification.contentIntent = paramNoticeParam;
      }
      else
      {
        localNotification.icon = 2130841517;
        localRemoteViews.setImageViewResource(2131371260, 2130841518);
        localRemoteViews.setTextViewText(2131371259, paramNoticeParam.c);
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
    }
  }
  
  public ConcurrentHashMap<String, bflo> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {}
    try
    {
      bhnv.a(bexd.a().a(), 0, paramNotification);
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify2", paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      bfhg.c("AppNotificationManager", "notify>>>", paramNotification);
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    if ((this.jdField_a_of_type_Bflp == null) || (this.jdField_a_of_type_Bflp.a() == null)) {
      this.jdField_a_of_type_Bflp = new bflp(this, bexd.a().a());
    }
    bfhg.b("notificationtest", "title color:" + this.jdField_a_of_type_Bflp.b());
    if (this.jdField_a_of_type_Bflp.b() != null) {
      paramRemoteViews.setTextColor(2131371269, this.jdField_a_of_type_Bflp.b().intValue());
    }
    bfhg.b("notificationtest", "text color:" + this.jdField_a_of_type_Bflp.a());
    if (this.jdField_a_of_type_Bflp.a() != null) {
      paramRemoteViews.setTextColor(2131371259, this.jdField_a_of_type_Bflp.a().intValue());
    }
    if (this.jdField_a_of_type_Bflp.a() != null) {
      paramRemoteViews.setTextColor(2131371263, this.jdField_a_of_type_Bflp.a().intValue());
    }
    bfhg.b("notificationtest", "text size:" + this.jdField_a_of_type_Bflp.a());
    if (this.jdField_a_of_type_Bflp.a() > 0.0F) {
      paramRemoteViews.setFloat(2131371259, "setTextSize", this.jdField_a_of_type_Bflp.a());
    }
    if (this.jdField_a_of_type_Bflp.a() > 0.0F) {
      paramRemoteViews.setFloat(2131371263, "setTextSize", this.jdField_a_of_type_Bflp.a());
    }
    if (this.jdField_a_of_type_Bflp.b() > 0.0F) {
      paramRemoteViews.setFloat(2131371269, "setTextSize", this.jdField_a_of_type_Bflp.b());
    }
    ApplicationInfo localApplicationInfo = bexd.a().a().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.jdField_a_of_type_Bflp.b().intValue();
      paramRemoteViews.setInt(2131371267, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
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
        bhnv.a(bexd.a().a(), 0, localNotification);
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify1", a(paramNoticeParam.f, paramNoticeParam.jdField_b_of_type_Int, paramNoticeParam.jdField_a_of_type_JavaLangString), localNotification);
      }
    }
  }
  
  public void a(String paramString)
  {
    bfhg.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
    {
      bflo localbflo = (bflo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localbflo != null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelBySendTime", localbflo.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void b(String paramString)
  {
    bfhg.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelNotRemoveId", ((bflo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfln
 * JD-Core Version:    0.7.0.1
 */