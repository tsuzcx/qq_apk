package com.tencent.mobileqq.activity.recent.guidebanner;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

public class NewerGuideBannerViewModel
  extends BaseViewModel<NewerGuideBannerRepository>
{
  static ViewModelProvider.Factory jdField_a_of_type_AndroidxLifecycleViewModelProvider$Factory = new NewerGuideBannerViewModel.6();
  private MutableLiveData<NewerGuideBannerData> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  NewerGuideBannerSharePreferenceHelper jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper = NewerGuideBannerSharePreferenceHelper.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper;
  private NewerGuideWebLaunchSuccessReceiver jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver;
  
  public NewerGuideBannerViewModel(NewerGuideBannerRepository paramNewerGuideBannerRepository)
  {
    super(paramNewerGuideBannerRepository);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNewerGuideBrowserActivityOnStart sourceFrom -> ");
      localStringBuilder.append(paramString);
      QLog.d("NewerGuideBannerViewModel", 2, localStringBuilder.toString());
    }
    if (TextUtils.equals(paramString, "NewerGuideBannerViewModel"))
    {
      paramString = new Intent("ACTION_NEWER_GUIDE_WEB_LAUNCH_SUCCESS");
      MobileQQ.getContext().sendBroadcast(paramString);
    }
  }
  
  private void a(AppRuntime paramAppRuntime, URLDrawable paramURLDrawable)
  {
    paramURLDrawable.setURLDrawableListener(new NewerGuideBannerViewModel.1(this, paramAppRuntime));
    paramURLDrawable.startDownload();
  }
  
  private void a(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localObject != null) {
      ((URLDrawable)localObject).setURLDrawableListener(null);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    localObject = this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
    URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
    int i = 0;
    ((MutableLiveData)localObject).setValue(NewerGuideBannerData.a(localURLDrawable, false));
    int j = this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus();
    if (j == 1) {
      i = 1;
    }
    if (i == 0)
    {
      a(paramAppRuntime, this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
    else
    {
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(NewerGuideBannerData.a(this.jdField_a_of_type_ComTencentImageURLDrawable, true));
      d(paramAppRuntime);
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("updateUrlDrawableBg bgUrl: ");
      paramAppRuntime.append(paramString);
      paramAppRuntime.append(", status: ");
      paramAppRuntime.append(j);
      QLog.d("NewerGuideBannerViewModel", 2, paramAppRuntime.toString());
    }
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://ti.qq.com/hybrid-h5/new_user_guide/index"));
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "[onContactsWebJump] do not have permission");
    }
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(NewerGuideBannerData.a());
  }
  
  private void d(AppRuntime paramAppRuntime)
  {
    if (!NewerGuideBannerPreloadWebProcessConfigProcessor.a.a()) {
      return;
    }
    if (DeviceInfoUtils.b()) {
      return;
    }
    if (((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a() != 0) {
      return;
    }
    if (((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramAppRuntime)) {
      return;
    }
    e(paramAppRuntime);
  }
  
  private void e(QBaseActivity paramQBaseActivity)
  {
    ThreadManager.excute(new NewerGuideBannerViewModel.5(this, paramQBaseActivity), 16, null, false);
  }
  
  private void e(QBaseActivity paramQBaseActivity, String paramString)
  {
    PermissionChecker.a(paramQBaseActivity, new NewerGuideBannerViewModel.3(this, paramString, paramQBaseActivity), new NewerGuideBannerViewModel.4(this));
  }
  
  private void e(AppRuntime paramAppRuntime)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "doPreloadWebProcess");
    ThreadManager.excute(new NewerGuideBannerViewModel.2(this, paramAppRuntime), 16, null, true);
  }
  
  MutableLiveData<NewerGuideBannerData> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver == null)
    {
      IntentFilter localIntentFilter = new IntentFilter("ACTION_NEWER_GUIDE_WEB_LAUNCH_SUCCESS");
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver = new NewerGuideWebLaunchSuccessReceiver(this);
      MobileQQ.getContext().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver, localIntentFilter);
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(NewerGuideBannerData.a(true));
    }
  }
  
  void a(QBaseActivity paramQBaseActivity)
  {
    String str = ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
    if (!TextUtils.isEmpty(str)) {
      a(paramQBaseActivity.getAppRuntime(), str);
    }
    paramQBaseActivity = new StringBuilder();
    paramQBaseActivity.append("onThemeChange bgUrl: ");
    paramQBaseActivity.append(str);
    QLog.d("NewerGuideBannerViewModel", 1, paramQBaseActivity.toString());
  }
  
  void a(QBaseActivity paramQBaseActivity, String paramString)
  {
    if (a(paramString))
    {
      e(paramQBaseActivity, paramString);
      return;
    }
    b(paramQBaseActivity, paramString);
  }
  
  void a(QBaseActivity paramQBaseActivity, oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramGuidelines_8410);
    paramQBaseActivity = paramQBaseActivity.getAppRuntime();
    paramGuidelines_8410 = ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
    if (!TextUtils.isEmpty(paramGuidelines_8410))
    {
      a(paramQBaseActivity, paramGuidelines_8410);
      ReportController.b(paramQBaseActivity, "dc00898", "", "", "0X800B618", "0X800B618", ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).b(), 0, "", "", "", "");
      return;
    }
    c(paramQBaseActivity);
  }
  
  void a(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "onClickClose");
    }
    b(paramAppRuntime);
    ReportController.b(paramAppRuntime, "dc00898", "", "", "0X800B4EA", "0X800B4EA", ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).b(), 0, "", "", "", "");
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "unRegisterReceiver");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver != null)
    {
      MobileQQ.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver = null;
    }
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(NewerGuideBannerData.a(false));
  }
  
  void b(QBaseActivity paramQBaseActivity)
  {
    AppRuntime localAppRuntime = paramQBaseActivity.getAppRuntime();
    String str = ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).b();
    if (!TextUtils.isEmpty(str))
    {
      int i = ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onBannerClick url -> ");
        localStringBuilder.append(str);
        localStringBuilder.append(", jumpType -> ");
        localStringBuilder.append(i);
        QLog.d("NewerGuideBannerViewModel", 2, localStringBuilder.toString());
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            d(paramQBaseActivity, str);
            b(localAppRuntime);
          }
        }
        else
        {
          c(paramQBaseActivity, str);
          b(localAppRuntime);
        }
      }
      else {
        a(paramQBaseActivity, str);
      }
    }
    ReportController.b(localAppRuntime, "dc00898", "", "", "0X800B619", "0X800B619", ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).b(), 0, "", "", "", "");
  }
  
  void b(QBaseActivity paramQBaseActivity, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onCommonWebJump] jump url: ");
      localStringBuilder.append(paramString);
      QLog.d("NewerGuideBannerViewModel", 2, localStringBuilder.toString());
    }
    if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
    {
      a();
      ((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).startBrowser(paramQBaseActivity, paramString, "NewerGuideBannerViewModel");
    }
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    ((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).getNewerGuideManager(paramAppRuntime).c();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper.b(paramAppRuntime.getCurrentAccountUin());
    c(paramAppRuntime);
  }
  
  void c(QBaseActivity paramQBaseActivity)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "[showPermissionDeniedHint] confirm");
    ReportController.b(paramQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B4E8", "0X800B4E8", 2, 0, "", "", "", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).b());
    localStringBuilder.append("&ab_auth=0");
    b(paramQBaseActivity, localStringBuilder.toString());
  }
  
  void c(QBaseActivity paramQBaseActivity, String paramString)
  {
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString)) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramQBaseActivity, paramString, 2016, null);
    }
  }
  
  void c(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "hideNewerGuideBanner");
    }
    if (paramAppRuntime != null) {
      ((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).hideNewerGuideBanner(paramAppRuntime);
    }
  }
  
  void d(QBaseActivity paramQBaseActivity)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "[showPermissionDeniedHint] cancel");
    ReportController.b(paramQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B4E8", "0X800B4E8", 1, 0, "", "", "", "");
    b(paramQBaseActivity.getAppRuntime());
  }
  
  void d(QBaseActivity paramQBaseActivity, String paramString)
  {
    try
    {
      paramQBaseActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return;
    }
    catch (Throwable paramQBaseActivity)
    {
      QLog.e("NewerGuideBannerViewModel", 1, paramQBaseActivity, new Object[0]);
    }
  }
  
  protected void onCleared()
  {
    super.onCleared();
    URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localURLDrawable != null)
    {
      localURLDrawable.setURLDrawableListener(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel
 * JD-Core Version:    0.7.0.1
 */