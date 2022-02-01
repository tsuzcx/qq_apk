import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class atzr
{
  private static atzr jdField_a_of_type_Atzr;
  private static QQNotificationManager jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager;
  public static String a;
  private int jdField_a_of_type_Int = 278;
  private long jdField_a_of_type_Long;
  private atzt jdField_a_of_type_Atzt;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloadNfn<FileAssistant>";
  }
  
  private atzr()
  {
    try
    {
      jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
      this.jdField_a_of_type_Atzt = new atzt(this, BaseApplicationImpl.getContext());
      this.jdField_a_of_type_Long = 123456L;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private int a()
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "genNID : notificationId[" + i + "]");
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int > 377)
      {
        this.jdField_a_of_type_Int = 278;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "genNID : notificationId is reach to the max Id.");
      }
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private long a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_Long - 30L;
    }
    if (1 == paramInt) {
      return this.jdField_a_of_type_Long - 20L;
    }
    if (2 == paramInt) {
      return this.jdField_a_of_type_Long - 10L;
    }
    if (3 == paramInt) {
      return this.jdField_a_of_type_Long;
    }
    return System.currentTimeMillis();
  }
  
  public static atzr a()
  {
    if (jdField_a_of_type_Atzr == null) {
      jdField_a_of_type_Atzr = new atzr();
    }
    return jdField_a_of_type_Atzr;
  }
  
  private int b()
  {
    return (int)(System.currentTimeMillis() & 0xFFFFFFF);
  }
  
  public int a(aucp paramaucp, Bundle paramBundle, long paramLong, int paramInt)
  {
    if (-1 == paramInt)
    {
      paramInt = a();
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + paramLong + "]. attachDownloader.notificationId = " + paramInt);
    }
    while (paramaucp != null)
    {
      paramaucp.a(new atzs(this, ThreadManager.getSubThreadHandler().getLooper(), paramInt, paramBundle, paramLong), false);
      return paramInt;
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + paramLong + "]. attachDownloader.here will using notificationid,maybe is not uinform id");
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + paramLong + "]. attachDownloader.dler = null. notificationId = " + paramInt);
    return paramInt;
  }
  
  public Notification a(Bundle paramBundle)
  {
    Object localObject1 = new NotificationCompat.Builder(BaseApplication.getContext());
    if ((SdkInfoUtil.isOreo()) && (SdkInfoUtil.isTargetSDKOreo())) {
      ((NotificationCompat.Builder)localObject1).setChannelId("CHANNEL_ID_OTHER");
    }
    localObject1 = ((NotificationCompat.Builder)localObject1).build();
    if (paramBundle != null)
    {
      Object localObject2 = paramBundle.getString("_notify_param_ContentTitle");
      ((Notification)localObject1).icon = 2130844374;
      paramBundle = new RemoteViews(BaseApplication.getContext().getPackageName(), 2131560895);
      paramBundle.setImageViewResource(2131371844, 2130844370);
      paramBundle.setTextViewText(2131371855, (CharSequence)localObject2);
      paramBundle.setProgressBar(2131371837, 100, 0, false);
      paramBundle.setViewVisibility(2131371843, 8);
      paramBundle.setViewVisibility(2131371838, 8);
      paramBundle.setTextColor(2131371855, -7829368);
      paramBundle.setTextColor(2131371843, -7829368);
      paramBundle.setTextColor(2131371839, -7829368);
      float f1 = this.jdField_a_of_type_Atzt.a();
      if (this.jdField_a_of_type_Atzt.a() <= 0.0F)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTextSize failed. set defualt value:14");
        f1 = 14.0F;
      }
      paramBundle.setFloat(2131371843, "setTextSize", f1);
      paramBundle.setFloat(2131371839, "setTextSize", f1);
      float f2 = this.jdField_a_of_type_Atzt.b();
      f1 = f2;
      if (f2 <= 0.0F)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. initNotification param error. getTitleSize failed. set defualt value:16");
        f1 = 16.0F;
      }
      paramBundle.setFloat(2131371855, "setTextSize", f1);
      localObject2 = BaseApplication.getContext().getApplicationInfo();
      if ((localObject2 != null) && (((ApplicationInfo)localObject2).targetSdkVersion < 10) && (Build.VERSION.SDK_INT > 10)) {}
      try
      {
        int i = this.jdField_a_of_type_Atzt.a().intValue();
        paramBundle.setInt(2131371845, "setBackgroundColor", (i & 0xFF000000) + (-1 - i));
        ((Notification)localObject1).contentView = paramBundle;
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. getNfn param error, NF");
    return null;
  }
  
  protected void a(int paramInt)
  {
    if (jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
      jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel(jdField_a_of_type_JavaLangString, paramInt);
    }
  }
  
  protected void a(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnUPDATE, param error. mId = " + paramInt);
    }
    label295:
    label307:
    label319:
    for (;;)
    {
      return;
      paramNotification.tickerText = (BaseApplication.getContext().getString(2131718917) + " " + paramBundle1.getString("_notify_param_Filename"));
      paramNotification.contentView.setImageViewResource(2131371844, 2130844370);
      int i = paramBundle2.getInt("_START_WAITING_");
      if (1 == i)
      {
        paramNotification.contentView.setTextViewText(2131371839, BaseApplication.getContext().getString(2131718918));
        paramNotification.contentView.setViewVisibility(2131371838, 0);
        paramNotification.contentView.setViewVisibility(2131371843, 8);
        paramNotification.contentView.setProgressBar(2131371837, 100, 0, false);
        paramNotification.flags = 34;
        paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
        paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
        paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
        paramBundle2.putExtra("param_notifyid", paramInt);
        paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
        if (1 != i) {
          break label295;
        }
        paramNotification.when = a(2);
        label243:
        if (Build.VERSION.SDK_INT >= 11) {
          break label307;
        }
        paramNotification.contentIntent = paramBundle1;
      }
      for (;;)
      {
        if (jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager == null) {
          break label319;
        }
        try
        {
          jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify(jdField_a_of_type_JavaLangString, paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
          return;
        }
        paramNotification.contentView.setTextViewText(2131371839, "0%");
        break;
        paramNotification.when = a(3);
        break label243;
        paramNotification.contentView.setOnClickPendingIntent(2131371845, paramBundle1);
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendPauseNotification param error, NF id:" + paramInt);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendPauseNotification, NF id:" + paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", paramBundle.getInt("_notify_param_Progress"));
    Notification localNotification = a(paramBundle);
    if (localNotification != null)
    {
      c(paramInt, localNotification, paramBundle, localBundle);
      atzj.a().b(paramBundle.getString("_notify_param_Url"));
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendPauseNotification failed to getNfn, NF id:" + paramInt);
  }
  
  protected void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 == null) || (paramBundle2 == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnSUCESS, param error. mId = " + paramInt);
      return;
    }
    if (jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
      jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel(jdField_a_of_type_JavaLangString, paramInt);
    }
    Notification localNotification = a(paramBundle1);
    String str1 = paramBundle2.getString("_FILE_PATH_");
    paramBundle2.getLong("_FILE_SIZE_");
    int i = paramBundle2.getInt("_NEW_N_ID_");
    String str2 = paramBundle2.getString("_PKG_NAME_");
    localNotification.tickerText = (BaseApplication.getContext().getString(2131718911) + " " + paramBundle1.getString("_notify_param_Filename"));
    Object localObject = paramBundle1.getBundle("_notify_param_userdata");
    paramBundle2 = "";
    if (localObject != null) {
      paramBundle2 = ((Bundle)localObject).getString("big_brother_source_key", "");
    }
    Bitmap localBitmap = null;
    localObject = BaseApplication.getContext().getString(2131718913);
    if (auck.a(str1) != null)
    {
      localBitmap = auck.a(str1);
      localObject = BaseApplication.getContext().getString(2131718912);
    }
    if (localBitmap == null)
    {
      int j = atvo.b(str1);
      if (j != 0)
      {
        localNotification.contentView.setImageViewResource(2131371844, j);
        label236:
        localNotification.contentView.setImageViewResource(2131371844, 2130844372);
      }
    }
    for (;;)
    {
      localNotification.contentView.setViewVisibility(2131371843, 0);
      localNotification.contentView.setViewVisibility(2131371838, 8);
      localNotification.contentView.setTextViewText(2131371843, (CharSequence)localObject);
      localNotification.flags = 16;
      localObject = new Intent("com.tencent.mobileqq.UniformDownloadNfn.INSTALL");
      ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject).putExtra("_PARAM_FILEPATH", str1);
      ((Intent)localObject).putExtra("_PARAM_DL_SUC_NEW_NID", i);
      ((Intent)localObject).putExtra("param_notifyid", paramInt);
      if (!TextUtils.isEmpty(paramBundle2)) {
        ((Intent)localObject).putExtra("big_brother_source_key", paramBundle2);
      }
      if (str2 != null) {
        ((Intent)localObject).putExtra("_PARAM_PKGNAME", str2);
      }
      localNotification.contentIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), (Intent)localObject, 134217728);
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_DL_SUC_NEW_NID", i);
      if (str2 != null) {
        paramBundle2.putExtra("_PARAM_PKGNAME", str2);
      }
      localNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      localNotification.when = a(0);
      if (jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager == null) {
        break;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. NF_SUC, NF. newNId = " + i + " url:" + paramBundle1.getString("_notify_param_Url"));
      try
      {
        jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify(jdField_a_of_type_JavaLangString, i, localNotification);
        return;
      }
      catch (Exception paramBundle1)
      {
        paramBundle1.printStackTrace();
        return;
      }
      localNotification.contentView.setImageViewResource(2131371844, 2130844372);
      break label236;
      localNotification.contentView.setImageViewBitmap(2131371844, localBitmap);
    }
  }
  
  protected void b(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnUPDATE, param error. mId = " + paramInt);
    }
    for (;;)
    {
      return;
      paramNotification.tickerText = null;
      paramNotification.contentView.setImageViewResource(2131371844, 2130844370);
      paramNotification.contentView.setViewVisibility(2131371843, 8);
      paramNotification.contentView.setViewVisibility(2131371838, 0);
      int i = paramBundle2.getInt("_FILE_PROGRESS_");
      paramNotification.contentView.setProgressBar(2131371837, 100, i, false);
      paramNotification.contentView.setTextViewText(2131371839, "" + i + "%");
      paramNotification.flags = 34;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.putExtra("param_notifyid", paramInt);
      paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      paramNotification.when = a(3);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle1;
      }
      while (jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null)
      {
        try
        {
          jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify(jdField_a_of_type_JavaLangString, paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
          return;
        }
        paramNotification.contentView.setOnClickPendingIntent(2131371845, paramBundle1);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendStartAndWatingNotification param error, NF id:" + paramInt);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendStartAndWatingNotification, NF id:" + paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", 0);
    localBundle.putInt("_START_WAITING_", 1);
    Notification localNotification = a(paramBundle);
    if (localNotification != null)
    {
      a(paramInt, localNotification, paramBundle, localBundle);
      atzj.a().a(paramBundle.getString("_notify_param_Url"), paramBundle.getString("_notify_param_Filename"), paramBundle.getString("_notify_param_ContentTitle", ""), paramBundle.getLong("_notify_param_Filesize"), paramBundle.getBundle("_notify_param_userdata"), paramInt, true);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendStartAndWatingNotification failed to getNfn, NF id:" + paramInt);
  }
  
  protected void c(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnPUASE, param error. mId = " + paramInt);
      return;
    }
    if (jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
      jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel(jdField_a_of_type_JavaLangString, paramInt);
    }
    paramNotification.tickerText = null;
    int i = paramBundle2.getInt("_FILE_PROGRESS_");
    paramNotification.contentView.setImageViewResource(2131371844, 2130844373);
    paramNotification.contentView.setViewVisibility(2131371843, 0);
    paramNotification.contentView.setViewVisibility(2131371838, 8);
    paramNotification.contentView.setTextViewText(2131371843, BaseApplication.getContext().getString(2131718916));
    paramNotification.contentView.setProgressBar(2131371837, 100, i, false);
    paramNotification.contentView.setTextViewText(2131371839, "" + i + "%");
    paramNotification.flags = 16;
    paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.DO_DOWNLOAD");
    paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
    paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
    paramBundle2.putExtra("param_notifyid", paramInt);
    paramBundle2 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
    paramNotification.when = a(1);
    if (Build.VERSION.SDK_INT < 11) {
      paramNotification.contentIntent = paramBundle2;
    }
    for (;;)
    {
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      if (jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager == null) {
        break;
      }
      try
      {
        jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify(jdField_a_of_type_JavaLangString, paramInt, paramNotification);
        return;
      }
      catch (Exception paramNotification)
      {
        paramNotification.printStackTrace();
        return;
      }
      paramNotification.contentView.setOnClickPendingIntent(2131371845, paramBundle2);
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. sendCancelNotification, NF id:" + paramInt);
    a(paramInt);
    if (paramBundle != null) {
      atzj.a().b(paramBundle.getString("_notify_param_Url"));
    }
  }
  
  protected void d(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnFAILED, param error. mId = " + paramInt);
      return;
    }
    if (jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
      jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel(jdField_a_of_type_JavaLangString, paramInt);
    }
    paramNotification.contentView.setViewVisibility(2131371838, 8);
    int i = paramBundle2.getInt("_FILE_ERR_CODE_");
    if (2 == i)
    {
      paramNotification.tickerText = BaseApplication.getContext().getString(2131718915);
      paramNotification.contentView.setTextViewText(2131371843, BaseApplication.getContext().getString(2131718915));
      label115:
      paramNotification.contentView.setImageViewResource(2131371844, 2130844371);
      paramNotification.contentView.setViewVisibility(2131371843, 0);
      paramNotification.contentView.setTextViewText(2131371839, " ");
      paramNotification.flags = 16;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.TRY_DOWNLOAD");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.putExtra("param_notifyid", paramInt);
      paramBundle2 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      paramNotification.when = a(1);
      if (Build.VERSION.SDK_INT >= 11) {
        break label397;
      }
      paramNotification.contentIntent = paramBundle2;
    }
    for (;;)
    {
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramNotification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      if (jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager == null) {
        break;
      }
      try
      {
        jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify(jdField_a_of_type_JavaLangString, paramInt, paramNotification);
        return;
      }
      catch (Exception paramNotification)
      {
        paramNotification.printStackTrace();
        return;
      }
      paramNotification.tickerText = (BaseApplication.getContext().getString(2131718914) + " " + paramBundle1.getString("_notify_param_Filename"));
      paramNotification.contentView.setTextViewText(2131371843, aucp.a(i) + anni.a(2131714554));
      break label115;
      label397:
      paramNotification.contentView.setOnClickPendingIntent(2131371845, paramBundle2);
    }
  }
  
  protected void e(int paramInt, Notification paramNotification, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramNotification == null) || (paramBundle1 == null) || (paramBundle2 == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. nfnRESUME, param error. mId = " + paramInt);
    }
    for (;;)
    {
      return;
      if (jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
        jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel(jdField_a_of_type_JavaLangString, paramInt);
      }
      paramNotification.tickerText = null;
      paramNotification.contentView.setImageViewResource(2131371844, 2130844370);
      paramNotification.contentView.setViewVisibility(2131371843, 8);
      paramNotification.contentView.setViewVisibility(2131371838, 0);
      int i = paramBundle2.getInt("_FILE_PROGRESS_");
      paramNotification.contentView.setProgressBar(2131371837, 100, i, false);
      paramNotification.contentView.setTextViewText(2131371839, BaseApplication.getContext().getString(2131718918));
      paramNotification.flags = 34;
      paramBundle2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
      paramBundle2.setPackage(MobileQQ.getContext().getPackageName());
      paramBundle2.putExtra("_PARAM_EXTRA", paramBundle1);
      paramBundle2.putExtra("param_notifyid", paramInt);
      paramBundle1 = PendingIntent.getBroadcast(BaseApplication.getContext(), b(), paramBundle2, 134217728);
      paramNotification.when = a(2);
      if (Build.VERSION.SDK_INT < 11) {
        paramNotification.contentIntent = paramBundle1;
      }
      while (jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null)
      {
        try
        {
          jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify(jdField_a_of_type_JavaLangString, paramInt, paramNotification);
          return;
        }
        catch (Exception paramNotification)
        {
          paramNotification.printStackTrace();
          return;
        }
        paramNotification.contentView.setOnClickPendingIntent(2131371845, paramBundle1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzr
 * JD-Core Version:    0.7.0.1
 */