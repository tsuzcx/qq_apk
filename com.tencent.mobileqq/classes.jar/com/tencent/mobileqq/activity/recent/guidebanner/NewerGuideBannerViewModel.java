package com.tencent.mobileqq.activity.recent.guidebanner;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

public class NewerGuideBannerViewModel
  extends BaseViewModel<NewerGuideBannerRepository>
{
  static ViewModelProvider.Factory jdField_a_of_type_AndroidxLifecycleViewModelProvider$Factory = new NewerGuideBannerViewModel.6();
  private MutableLiveData<NewerGuideBannerData> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  NewerGuideBannerSharePreferenceHelper jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper = NewerGuideBannerSharePreferenceHelper.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper;
  private NewerGuideWebLaunchSuccessReceiver jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver;
  
  NewerGuideBannerViewModel(NewerGuideBannerRepository paramNewerGuideBannerRepository)
  {
    super(paramNewerGuideBannerRepository);
  }
  
  private void a(QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable)
  {
    paramURLDrawable.setURLDrawableListener(new NewerGuideBannerViewModel.1(this, paramQQAppInterface));
    paramURLDrawable.startDownload();
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(NewerGuideBannerData.a(this.jdField_a_of_type_ComTencentImageURLDrawable, false));
    int j = this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus();
    if (j == 1) {
      i = 1;
    }
    if (i == 0) {
      a(paramQQAppInterface, this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuideBannerViewModel", 2, "updateUrlDrawableBg bgUrl: " + paramString + ", status: " + j);
      }
      return;
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(NewerGuideBannerData.a(this.jdField_a_of_type_ComTencentImageURLDrawable, true));
      d(paramQQAppInterface);
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "onNewerGuideBrowserActivityOnStart sourceFrom -> " + paramString);
    }
    if (TextUtils.equals(paramString, "NewerGuideBannerViewModel"))
    {
      paramString = new Intent("ACTION_NEWER_GUIDE_WEB_LAUNCH_SUCCESS");
      BaseApplicationImpl.getContext().sendBroadcast(paramString);
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
  
  private void d(BaseActivity paramBaseActivity, String paramString)
  {
    PermissionChecker.a(paramBaseActivity, paramBaseActivity.app, new NewerGuideBannerViewModel.3(this, paramString, paramBaseActivity), new NewerGuideBannerViewModel.4(this));
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    if (!NewerGuideBannerPreloadWebProcessConfigProcessor.a.a()) {}
    while ((DeviceInfoUtils.b()) || (((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a() != 0) || (((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramQQAppInterface))) {
      return;
    }
    e(paramQQAppInterface);
  }
  
  private void e(BaseActivity paramBaseActivity)
  {
    ThreadManager.excute(new NewerGuideBannerViewModel.5(this, paramBaseActivity), 16, null, false);
  }
  
  private void e(BaseActivity paramBaseActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "[onCommonWebJump] jump url: " + paramString);
    }
    if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
    {
      a();
      Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("source_from", "NewerGuideBannerViewModel");
      paramBaseActivity.startActivity(localIntent);
    }
  }
  
  private void e(QQAppInterface paramQQAppInterface)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "doPreloadWebProcess");
    ThreadManager.excute(new NewerGuideBannerViewModel.2(this, paramQQAppInterface), 16, null, true);
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
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver, localIntentFilter);
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(NewerGuideBannerData.a(true));
    }
  }
  
  void a(BaseActivity paramBaseActivity)
  {
    String str = ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
    if (!TextUtils.isEmpty(str)) {
      a(paramBaseActivity.app, str);
    }
    QLog.d("NewerGuideBannerViewModel", 1, "onThemeChange bgUrl: " + str);
  }
  
  void a(BaseActivity paramBaseActivity, String paramString)
  {
    if (a(paramString))
    {
      d(paramBaseActivity, paramString);
      return;
    }
    e(paramBaseActivity, paramString);
  }
  
  void a(BaseActivity paramBaseActivity, oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramGuidelines_8410);
    paramBaseActivity = paramBaseActivity.app;
    paramGuidelines_8410 = ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
    if (!TextUtils.isEmpty(paramGuidelines_8410))
    {
      a(paramBaseActivity, paramGuidelines_8410);
      ReportController.b(paramBaseActivity, "dc00898", "", "", "0X800B618", "0X800B618", ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).b(), 0, "", "", "", "");
      return;
    }
    c(paramBaseActivity);
  }
  
  void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "onClickClose");
    }
    b(paramQQAppInterface);
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B4EA", "0X800B4EA", ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).b(), 0, "", "", "", "");
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "unRegisterReceiver");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideWebLaunchSuccessReceiver = null;
    }
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(NewerGuideBannerData.a(false));
  }
  
  void b(BaseActivity paramBaseActivity)
  {
    QQAppInterface localQQAppInterface = paramBaseActivity.app;
    String str = ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).b();
    if (!TextUtils.isEmpty(str))
    {
      int i = ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuideBannerViewModel", 2, "onBannerClick url -> " + str + ", jumpType -> " + i);
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800B619", "0X800B619", ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).b(), 0, "", "", "", "");
      return;
      a(paramBaseActivity, str);
      continue;
      b(paramBaseActivity, str);
      b(localQQAppInterface);
      continue;
      c(paramBaseActivity, str);
      b(localQQAppInterface);
    }
  }
  
  void b(BaseActivity paramBaseActivity, String paramString)
  {
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString)) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramBaseActivity, paramString, 2016, null);
    }
  }
  
  void b(QQAppInterface paramQQAppInterface)
  {
    ((NewerGuideBannerManager)paramQQAppInterface.getManager(QQManagerFactory.NEWER_GUIDE_BANNER_MANAGER)).c();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper.b(paramQQAppInterface.getCurrentAccountUin());
    c(paramQQAppInterface);
  }
  
  void c(BaseActivity paramBaseActivity)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "[showPermissionDeniedHint] confirm");
    ReportController.b(paramBaseActivity.app, "dc00898", "", "", "0X800B4E8", "0X800B4E8", 2, 0, "", "", "", "");
    e(paramBaseActivity, ((NewerGuideBannerRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).b() + "&ab_auth=0");
  }
  
  void c(BaseActivity paramBaseActivity, String paramString)
  {
    try
    {
      paramBaseActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return;
    }
    catch (Throwable paramBaseActivity)
    {
      QLog.e("NewerGuideBannerViewModel", 1, paramBaseActivity, new Object[0]);
    }
  }
  
  void c(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerViewModel", 2, "hideNewerGuideBanner");
    }
    if (paramQQAppInterface != null) {
      BannerManager.a().b(46, 3000);
    }
  }
  
  void d(BaseActivity paramBaseActivity)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "[showPermissionDeniedHint] cancel");
    ReportController.b(paramBaseActivity.app, "dc00898", "", "", "0X800B4E8", "0X800B4E8", 1, 0, "", "", "", "");
    b(paramBaseActivity.app);
  }
  
  public void onCleared()
  {
    super.onCleared();
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel
 * JD-Core Version:    0.7.0.1
 */