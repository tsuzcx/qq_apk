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

public class bdmb
{
  protected static bdmb a;
  protected bdmd a;
  protected QQNotificationManager a;
  protected final ConcurrentHashMap<String, bdmc> a;
  
  protected bdmb()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
  }
  
  private int a(String paramString)
  {
    bdht.b("AppNotificationManager", ">genNextNotificationId key:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return 378;
    }
    int i = Math.abs(paramString.hashCode()) % 99;
    bdht.b("AppNotificationManager", ">genNextNotificationId mod:" + i);
    i += 378;
    bdht.b("AppNotificationManager", ">genNextNotificationId id:" + i);
    return i;
  }
  
  public static bdmb a()
  {
    if (jdField_a_of_type_Bdmb == null) {
      jdField_a_of_type_Bdmb = new bdmb();
    }
    return jdField_a_of_type_Bdmb;
  }
  
  public int a(String paramString1, int paramInt, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      bdht.e("AppNotificationManager", ">getNotificationId param error, return invalid id.");
      return -1;
    }
    bdht.b("AppNotificationManager", ">getNotificationId " + paramString1 + ", " + paramString2);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      paramString1 = new bdmc(this);
      paramString1.jdField_a_of_type_JavaLangString = str;
      paramString1.jdField_a_of_type_Int = a(str);
      paramString1.jdField_b_of_type_Int = paramInt;
      paramString1.jdField_b_of_type_JavaLangString = paramString2;
      paramString1.jdField_a_of_type_Long = (System.currentTimeMillis() + paramString1.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
    }
    return ((bdmc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).jdField_a_of_type_Int;
  }
  
  public long a(String paramString1, int paramInt, String paramString2)
  {
    bdht.b("AppNotificationManager", ">getNotificationWhen " + paramString1 + ", " + paramString2);
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      bdmc localbdmc = new bdmc(this);
      localbdmc.jdField_a_of_type_JavaLangString = paramString1;
      localbdmc.jdField_a_of_type_Int = a(paramString1);
      localbdmc.jdField_b_of_type_Int = paramInt;
      localbdmc.jdField_b_of_type_JavaLangString = paramString2;
      localbdmc.jdField_a_of_type_Long = (System.currentTimeMillis() + localbdmc.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localbdmc);
    }
    return ((bdmc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).jdField_a_of_type_Long;
  }
  
  public Notification a(NoticeParam paramNoticeParam)
  {
    if ((bcxm.a().a() == null) || (paramNoticeParam == null))
    {
      bdht.e("AppNotificationManager", "getNotification context == null");
      return null;
    }
    Notification localNotification = new Notification();
    localNotification.tickerText = paramNoticeParam.jdField_b_of_type_JavaLangString;
    localNotification.when = paramNoticeParam.jdField_a_of_type_Long;
    RemoteViews localRemoteViews = new RemoteViews(bcxm.a().a().getPackageName(), 2131559466);
    Object localObject = bdmf.a(1, paramNoticeParam);
    a(localRemoteViews);
    localRemoteViews.setInt(2131370956, "setBackgroundColor", -1);
    localRemoteViews.setInt(2131370958, "setTextColor", -16777216);
    localRemoteViews.setInt(2131370952, "setTextColor", -12303292);
    localRemoteViews.setInt(2131370948, "setTextColor", -12303292);
    localRemoteViews.setTextViewText(2131370958, bdhz.a(paramNoticeParam.jdField_b_of_type_JavaLangString, 18, true, true));
    if (paramNoticeParam.jdField_b_of_type_Int == 1)
    {
      localNotification.icon = 2130843548;
      localRemoteViews.setImageViewResource(2131370949, 2130843544);
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
        localNotification.icon = 2130843548;
        if (paramNoticeParam.jdField_b_of_type_Int == 0)
        {
          localRemoteViews.setTextViewText(2131370948, bcxm.a().a().getString(2131694713));
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localRemoteViews.setImageViewResource(2131370949, 2130843544);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 2)
        {
          localRemoteViews.setTextViewText(2131370948, bcxm.a().a().getString(2131694716));
          localObject = bdiw.a(paramNoticeParam.d);
          if (localObject != null) {
            localRemoteViews.setImageViewBitmap(2131370949, (Bitmap)localObject);
          }
          localNotification.flags |= 0x10;
          localNotification.defaults |= 0x1;
          localNotification.defaults |= 0x4;
          localObject = bdmf.a(6, paramNoticeParam);
        }
        if (paramNoticeParam.jdField_b_of_type_Int == 3)
        {
          localRemoteViews.setTextViewText(2131370948, bcxm.a().a().getString(2131694713));
          localObject = bdmf.a(4, paramNoticeParam);
          Bitmap localBitmap = bdhr.a(paramNoticeParam.jdField_a_of_type_JavaLangString);
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
              bdht.b("AppNotificationManager", ">>download icon fail,so we use default notification icon");
              localRemoteViews.setImageViewResource(2131370949, 2130843544);
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
        localNotification.icon = 2130843548;
        localRemoteViews.setImageViewResource(2131370949, 2130843544);
        localRemoteViews.setTextViewText(2131370948, bcxm.a().a().getString(2131694712));
        localRemoteViews.setViewVisibility(2131370948, 0);
        localRemoteViews.setViewVisibility(2131370944, 8);
        paramNoticeParam = bdmf.a(5, paramNoticeParam);
        localNotification.flags |= 0x10;
        localNotification.contentIntent = paramNoticeParam;
      }
      else
      {
        localNotification.icon = 2130841372;
        localRemoteViews.setImageViewResource(2131370949, 2130841373);
        localRemoteViews.setTextViewText(2131370948, paramNoticeParam.c);
        localNotification.contentIntent = ((PendingIntent)localObject);
      }
    }
  }
  
  public ConcurrentHashMap<String, bdmc> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {}
    try
    {
      bfmk.a(bcxm.a().a(), 0, paramNotification);
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify2", paramInt, paramNotification);
      return;
    }
    catch (Exception paramNotification)
    {
      bdht.c("AppNotificationManager", "notify>>>", paramNotification);
    }
  }
  
  public void a(RemoteViews paramRemoteViews)
  {
    if ((this.jdField_a_of_type_Bdmd == null) || (this.jdField_a_of_type_Bdmd.a() == null)) {
      this.jdField_a_of_type_Bdmd = new bdmd(this, bcxm.a().a());
    }
    bdht.b("notificationtest", "title color:" + this.jdField_a_of_type_Bdmd.b());
    if (this.jdField_a_of_type_Bdmd.b() != null) {
      paramRemoteViews.setTextColor(2131370958, this.jdField_a_of_type_Bdmd.b().intValue());
    }
    bdht.b("notificationtest", "text color:" + this.jdField_a_of_type_Bdmd.a());
    if (this.jdField_a_of_type_Bdmd.a() != null) {
      paramRemoteViews.setTextColor(2131370948, this.jdField_a_of_type_Bdmd.a().intValue());
    }
    if (this.jdField_a_of_type_Bdmd.a() != null) {
      paramRemoteViews.setTextColor(2131370952, this.jdField_a_of_type_Bdmd.a().intValue());
    }
    bdht.b("notificationtest", "text size:" + this.jdField_a_of_type_Bdmd.a());
    if (this.jdField_a_of_type_Bdmd.a() > 0.0F) {
      paramRemoteViews.setFloat(2131370948, "setTextSize", this.jdField_a_of_type_Bdmd.a());
    }
    if (this.jdField_a_of_type_Bdmd.a() > 0.0F) {
      paramRemoteViews.setFloat(2131370952, "setTextSize", this.jdField_a_of_type_Bdmd.a());
    }
    if (this.jdField_a_of_type_Bdmd.b() > 0.0F) {
      paramRemoteViews.setFloat(2131370958, "setTextSize", this.jdField_a_of_type_Bdmd.b());
    }
    ApplicationInfo localApplicationInfo = bcxm.a().a().getApplicationInfo();
    if ((localApplicationInfo != null) && (localApplicationInfo.targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
    try
    {
      int i = this.jdField_a_of_type_Bdmd.b().intValue();
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
        bfmk.a(bcxm.a().a(), 0, localNotification);
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("AppNotificationManagernotify1", a(paramNoticeParam.f, paramNoticeParam.jdField_b_of_type_Int, paramNoticeParam.jdField_a_of_type_JavaLangString), localNotification);
      }
    }
  }
  
  public void a(String paramString)
  {
    bdht.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
    {
      bdmc localbdmc = (bdmc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localbdmc != null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelBySendTime", localbdmc.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void b(String paramString)
  {
    bdht.a("AppNotificationManager", "cancelBySendTime:" + paramString);
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("AppNotificationManager_cancelNotRemoveId", ((bdmc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdmb
 * JD-Core Version:    0.7.0.1
 */