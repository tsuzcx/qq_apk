package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

public class NewerGuideBannerManager
  implements Manager
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  NewerGuideBannerObserver jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerObserver;
  NewerGuideBannerSharePreferenceHelper jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper = NewerGuideBannerSharePreferenceHelper.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper;
  private oidb_0x59f.Guidelines_8410 jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410;
  
  public NewerGuideBannerManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerObserver = new NewerGuideBannerObserver(paramAppInterface);
    paramAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerObserver);
  }
  
  private <T> void a(List<T> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    int k;
    for (int j = -1; paramList.hasNext(); j = k)
    {
      k = j;
      if (a(paramList.next()))
      {
        paramList.remove();
        k = j;
        if (j < 0) {
          k = i;
        }
      }
      if ((i >= 9) && (k < 0)) {
        return;
      }
      i += 1;
    }
  }
  
  private <T> boolean a(T paramT)
  {
    return ((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).isMayKnowRecentBaseData(paramT);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      ((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).getNewerGuideHandler(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a();
    }
  }
  
  public <T> void a(List<T> paramList, BannerManager paramBannerManager)
  {
    if (paramList != null)
    {
      if (paramBannerManager == null) {
        return;
      }
      if (paramBannerManager.b(((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).getBannerId()))
      {
        a(paramList);
        return;
      }
      if (!a(paramList)) {
        d();
      }
    }
  }
  
  void a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 = paramGuidelines_8410;
    boolean bool = a(paramGuidelines_8410);
    if (QLog.isColorLevel())
    {
      paramGuidelines_8410 = new StringBuilder();
      paramGuidelines_8410.append("showNewerGuideBannerIfNeed needShow -> ");
      paramGuidelines_8410.append(bool);
      QLog.d("NewerGuideBannerManager", 2, paramGuidelines_8410.toString());
    }
    if (!bool)
    {
      b();
      return;
    }
    e();
  }
  
  public <T> boolean a(List<T> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "canShowNewerGuideBanner");
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < Math.min(10, paramList.size()))
      {
        if (a(paramList.get(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  boolean a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    if ((paramGuidelines_8410 != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      int i = paramGuidelines_8410.uint32_banner_status.get();
      if (i == 0) {
        return false;
      }
      paramGuidelines_8410 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper.a(paramGuidelines_8410);
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper.a(paramGuidelines_8410) <= 0L) {
        return true;
      }
    }
    return false;
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "hideNewerGuideBanner");
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      ((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).hideNewerGuideBanner(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
  
  void c()
  {
    oidb_0x59f.Guidelines_8410 localGuidelines_8410 = this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410;
    if ((localGuidelines_8410 != null) && (localGuidelines_8410.uint32_banner_status.has()) && (this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.uint32_banner_status.get() == 2)) {
      this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.uint32_banner_status.set(1);
    }
  }
  
  public void d()
  {
    a(this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410);
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "showNewerGuideBanner called");
    }
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 != null)) {
      ((INewerGuideHelper)QRoute.api(INewerGuideHelper.class)).showNewerGuideBanner(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy, instance manager -> ");
      ((StringBuilder)localObject).append(this);
      QLog.d("NewerGuideBannerManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject != null)
    {
      ((AppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerObserver);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerObserver = null;
    this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerManager
 * JD-Core Version:    0.7.0.1
 */