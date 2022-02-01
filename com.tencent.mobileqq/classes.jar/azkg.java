import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qzonealbumreddot.QzonePhotoGuideNotifyService.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class azkg
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new azkh(this);
  protected Handler a;
  public azkd a;
  protected QQAppInterface a;
  Runnable jdField_a_of_type_JavaLangRunnable = new QzonePhotoGuideNotifyService.1(this);
  
  public azkg(QQAppInterface paramQQAppInterface, azkd paramazkd)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Azkd = paramazkd;
    if (paramQQAppInterface != null) {}
    try
    {
      paramazkd = new IntentFilter("com.qzonex.localalbum.new_photo_notification_feedback_action");
      paramQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramazkd);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("QzonePhotoGuideNotifyServlet", 1, "registerreceiver fail:" + paramQQAppInterface);
    }
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo("com.qzone", 128);
      if ((paramContext == null) || (paramContext.metaData == null)) {
        break label50;
      }
      i = paramContext.metaData.getInt("com.qzone.versioncode");
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        int i = 0;
      }
    }
    if (i >= paramInt) {
      bool = true;
    }
    return bool;
  }
  
  public void a()
  {
    try
    {
      Intent localIntent = new Intent("com.qzonex.localalbum.new_photo_notification_action");
      localIntent.setComponent(new ComponentName("com.qzone", "com.qzonex.proxy.localalbum.business.NewPhotoNotificationService"));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().startService(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("QzonePhotoGuideNotifyServlet", 2, "calling qzone");
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QzonePhotoGuideNotifyServlet", 1, "startService fail:" + localException);
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzonePhotoGuideNotifyServlet", 1, "stopService fail:" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkg
 * JD-Core Version:    0.7.0.1
 */