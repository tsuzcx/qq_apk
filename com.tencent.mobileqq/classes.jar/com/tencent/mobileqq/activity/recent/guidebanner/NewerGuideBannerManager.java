package com.tencent.mobileqq.activity.recent.guidebanner;

import android.os.Message;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

public class NewerGuideBannerManager
  implements Manager
{
  NewerGuideBannerObserver jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerObserver;
  NewerGuideBannerSharePreferenceHelper jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper = NewerGuideBannerSharePreferenceHelper.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private oidb_0x59f.Guidelines_8410 jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410;
  
  public NewerGuideBannerManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerObserver = new NewerGuideBannerObserver(paramQQAppInterface);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerObserver);
  }
  
  private <T> void a(List<T> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    int k;
    for (int j = -1;; j = k)
    {
      if (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (!(localObject instanceof RecentItemMayKnowFriendData))
        {
          k = j;
          if (!(localObject instanceof RecentItemMayKnowFriendVerticalListData)) {}
        }
        else
        {
          paramList.remove();
          k = j;
          if (j < 0) {
            k = i;
          }
        }
        if ((i < 9) || (k >= 0)) {}
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((NewerGuideBannerHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NEWER_GUIDE_BANNER_HANDLER)).a();
    }
  }
  
  public <T> void a(List<T> paramList, BannerManager paramBannerManager)
  {
    if ((paramList == null) || (paramBannerManager == null)) {}
    do
    {
      return;
      if (paramBannerManager.b(46))
      {
        a(paramList);
        return;
      }
    } while (a(paramList));
    d();
  }
  
  void a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 = paramGuidelines_8410;
    boolean bool = a(paramGuidelines_8410);
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "showNewerGuideBannerIfNeed needShow -> " + bool);
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
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "canShowNewerGuideBanner");
    }
    boolean bool1 = bool2;
    int i;
    if (paramList != null)
    {
      bool1 = bool2;
      if (paramList.size() > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < Math.min(10, paramList.size()))
      {
        Object localObject = paramList.get(i);
        if (((localObject instanceof RecentItemMayKnowFriendData)) || ((localObject instanceof RecentItemMayKnowFriendVerticalListData))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  boolean a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    boolean bool = true;
    if ((paramGuidelines_8410 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      int i = paramGuidelines_8410.uint32_banner_status.get();
      if (i == 0) {
        return false;
      }
      paramGuidelines_8410 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (i == 2) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper.a(paramGuidelines_8410);
      }
    }
    for (;;)
    {
      return bool;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerSharePreferenceHelper.a(paramGuidelines_8410) > 0L)
      {
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "hideNewerGuideBanner");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      BannerManager.a().b(46, 3000);
    }
  }
  
  void c()
  {
    if ((this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 != null) && (this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.uint32_banner_status.has()) && (this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.uint32_banner_status.get() == 2)) {
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
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 != null))
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandlerWithoutDefault(Conversation.class);
      if (localMqqHandler == null) {
        break label67;
      }
      localMessage = Message.obtain();
      localMessage.what = 1134210;
      localMessage.obj = this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410;
      localMqqHandler.sendMessage(localMessage);
    }
    label67:
    while (!QLog.isColorLevel())
    {
      Message localMessage;
      return;
    }
    QLog.d("NewerGuideBannerManager", 2, "showNewerGuideBanner get handler fail null");
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideBannerManager", 2, "onDestroy, instance manager -> " + this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentGuidebannerNewerGuideBannerObserver = null;
    this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerManager
 * JD-Core Version:    0.7.0.1
 */