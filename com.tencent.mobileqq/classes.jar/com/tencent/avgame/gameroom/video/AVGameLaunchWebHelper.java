package com.tencent.avgame.gameroom.video;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.IToolProcStart;
import com.tencent.mobileqq.qrscan.api.IQRToolProcStartApi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class AVGameLaunchWebHelper
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new AVGameLaunchWebHelper.2(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private IToolProcStart jdField_a_of_type_ComTencentMobileqqQrscanIToolProcStart;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new AVGameLaunchWebHelper.1(this);
  private boolean jdField_a_of_type_Boolean;
  
  public AVGameLaunchWebHelper(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    b();
  }
  
  private void a(Runnable paramRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameLaunchWebHelper", 2, "executeCallable");
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  private void b()
  {
    ((Application)this.jdField_a_of_type_AndroidAppActivity.getApplicationContext()).registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
  }
  
  private void c()
  {
    ((Application)this.jdField_a_of_type_AndroidAppActivity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
  }
  
  private void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showProgress mProgressShowing:");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("AVGameLaunchWebHelper", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131708933));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      label115:
      break label115;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVGameLaunchWebHelper", 2, "");
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("hideProgress  mProgressShowing:");
      localStringBuilder1.append(this.jdField_a_of_type_Boolean);
      QLog.d("AVGameLaunchWebHelper", 2, localStringBuilder1.toString());
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("hide init check progress:");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("AVGameLaunchWebHelper", 2, localStringBuilder2.toString());
      }
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameLaunchWebHelper", 2, "release");
    }
    e();
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQrscanIToolProcStart;
    if (localObject != null)
    {
      ((IToolProcStart)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqQrscanIToolProcStart = null;
    }
  }
  
  public void a(Activity paramActivity, Runnable paramRunnable)
  {
    QLog.d("AVGameLaunchWebHelper", 2, "preLoadToolProcAndExecuteCallable");
    if (UITools.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      a(paramRunnable);
      return;
    }
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqQrscanIToolProcStart == null) {
      this.jdField_a_of_type_ComTencentMobileqqQrscanIToolProcStart = ((IQRToolProcStartApi)QRoute.api(IQRToolProcStartApi.class)).get();
    }
    paramActivity = this.jdField_a_of_type_AndroidOsHandler;
    if (paramActivity != null)
    {
      paramActivity.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
    this.jdField_a_of_type_ComTencentMobileqqQrscanIToolProcStart.a("preLoadToolProc", 5000L, new AVGameLaunchWebHelper.3(this, paramRunnable, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameLaunchWebHelper
 * JD-Core Version:    0.7.0.1
 */