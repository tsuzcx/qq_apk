package com.tencent.mobileqq.activity.contact.phonecontact;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppActivity;

class PhoneContactManagerImp$2
  extends ContactBindObserver
{
  PhoneContactManagerImp$2(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  void a()
  {
    ThreadManager.excute(new PhoneContactManagerImp.2.2(this), 16, null, false);
  }
  
  void b()
  {
    boolean bool2 = false;
    if (PhoneContactManagerImp.a(this.a)) {
      return;
    }
    int i = this.a.d();
    boolean bool3 = LoginWelcomeManager.a(PhoneContactManagerImp.a(this.a)).jdField_a_of_type_Boolean;
    boolean bool4 = PhoneContactManagerImp.b(this.a);
    long l = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_pop_time_for_switchphone", 0L);
    if ((PhoneContactManagerImp.c(this.a)) && (System.currentTimeMillis() - l > 86400000L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "onFirstRespQueryNotBindState bindState = " + i + ", needToJumpBind = " + bool4 + ", phoneSwitchBefit = " + bool1 + l + ",showNewUserGuide = " + bool3);
      }
      if ((!bool4) && (!bool1)) {
        break;
      }
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("topActivity is:").append(localBaseActivity).append(",isFinishing is:");
        bool1 = bool2;
        if (localBaseActivity != null) {
          bool1 = localBaseActivity.isFinishing();
        }
        QLog.d("PhoneContact.Manager", 2, bool1);
      }
      if ((localBaseActivity == null) || (localBaseActivity.isFinishing()) || (localBaseActivity.getAppRuntime() != PhoneContactManagerImp.a(this.a)) || ((localBaseActivity instanceof UserguideActivity)) || (bool3) || (UserguideActivity.jdField_a_of_type_Boolean)) {
        break;
      }
      PhoneContactManagerImp.a(this.a, true);
      return;
    }
  }
  
  void c()
  {
    boolean bool1 = true;
    if (PhoneContactManagerImp.f) {}
    boolean bool2;
    boolean bool3;
    label170:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (PhoneContactManagerImp.a(this.a))
            {
              QLog.e("PhoneContact", 1, "onFirstRespQueryState app is null");
              return;
            }
            if (!UserguideActivity.a(PhoneContactManagerImp.a(this.a).getApp(), PhoneContactManagerImp.a(this.a).getCurrentAccountUin())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("PhoneContact", 2, "UserguideActivity.showUserGuideThisTime = ture");
          return;
        } while (PhoneNumLoginImpl.a().a());
        if (!PortalManager.b()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PhoneContact", 2, "hongbao forbid alert");
      return;
      int i = this.a.d();
      bool2 = LoginWelcomeManager.a(PhoneContactManagerImp.a(this.a)).jdField_a_of_type_Boolean;
      bool3 = PhoneContactManagerImp.d(this.a);
      long l = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_pop_time_for_switchphone", 0L);
      if ((!PhoneContactManagerImp.c(this.a)) || (System.currentTimeMillis() - l <= 86400000L)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "bindState = " + i + ", isFristRun = " + bool3 + ", attempPop = " + bool1 + l + ",showNewUserGuide = " + bool2);
      }
    } while ((!bool3) && (!bool1));
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("topActivity is:").append(localBaseActivity).append(",isFinishing is:");
      if (localBaseActivity == null) {
        break label364;
      }
    }
    label364:
    for (bool1 = localBaseActivity.isFinishing();; bool1 = false)
    {
      QLog.d("PhoneContact.Manager", 2, bool1);
      if ((localBaseActivity == null) || (localBaseActivity.isFinishing()) || (localBaseActivity.getAppRuntime() != PhoneContactManagerImp.a(this.a)) || ((localBaseActivity instanceof UserguideActivity)) || (bool2) || (UserguideActivity.jdField_a_of_type_Boolean)) {
        break;
      }
      PhoneContactManagerImp.a(this.a, false);
      return;
      bool1 = false;
      break label170;
    }
  }
  
  public void onCancelBind(boolean paramBoolean)
  {
    if (PhoneContactManagerImp.a(this.a)) {}
    while (!paramBoolean) {
      return;
    }
    PhoneContactManagerImp.a(this.a, true, true, 11L);
    this.a.jdField_a_of_type_Int = 1;
    PhoneContactManagerImp.b(this.a);
    PhoneContactManagerImp.a(this.a).getPreferences().edit().putInt("system_msg_list_showcount", 0).putBoolean("contact_guide_user_close", false).putInt("new_friend_show_count_after_user_close", 0).apply();
  }
  
  public void onHideContact(boolean paramBoolean)
  {
    if (PhoneContactManagerImp.a(this.a)) {}
    while (!paramBoolean) {
      return;
    }
    PhoneContactManagerImp.a(this.a, 2);
  }
  
  public void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (PhoneContactManagerImp.a(this.a)) {
      return;
    }
    if ((paramBoolean1) && (paramBoolean2)) {
      BannerManager.a().a(9, 0, null);
    }
    this.a.b = false;
    this.a.jdField_c_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("onQueryBindState [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.a.jdField_a_of_type_Boolean), Integer.valueOf(this.a.d()) }));
    }
    PhoneContactManagerImp.a(this.a, 6, paramBoolean1);
    if (paramBoolean1)
    {
      this.a.a(this.a.jdField_a_of_type_Boolean, 1);
      if (this.a.jdField_a_of_type_Boolean) {
        ThreadManager.excute(new PhoneContactManagerImp.2.1(this), 16, null, false);
      }
    }
    a();
  }
  
  public void onQueryContactList(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactManagerImp.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onQueryContactList, isSuc = " + paramBoolean + ", updateFlag = " + paramInt);
    }
    if (paramBoolean) {
      PhoneContactManagerImp.a(this.a, paramInt);
    }
    PhoneContactManagerImp.c(this.a);
  }
  
  public void onQueryLastLoginInfo(boolean paramBoolean)
  {
    if (PhoneContactManagerImp.a(this.a)) {}
    do
    {
      return;
      PhoneContactManagerImp.a(this.a, false);
    } while (!paramBoolean);
    PhoneContactManagerImp.a(this.a, 2);
  }
  
  public void onUpdateContact(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactManagerImp.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onUpdateContact, isSuc = " + paramBoolean + ", reason = " + paramInt);
    }
    this.a.jdField_c_of_type_Boolean = false;
    if (paramBoolean)
    {
      PhoneContactManagerImp.a(this.a, 1);
      PhoneContactManagerImp.a(this.a, 0L, 0L);
    }
    for (;;)
    {
      PhoneContactManagerImp.a(this.a, true, true, 9L);
      return;
      if ((paramInt == 2) || (paramInt == 3)) {
        this.a.g = true;
      }
      this.a.e = System.currentTimeMillis();
    }
  }
  
  public void onUpdateContactNotBind(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactManagerImp.a(this.a)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "onUpdateContactNotBind, isSuc = " + paramBoolean + ", reason = " + paramInt);
      }
      this.a.jdField_c_of_type_Boolean = false;
      if (paramBoolean)
      {
        PhoneContactManagerImp.a(this.a, 1);
        PhoneContactManagerImp.a(this.a, 0L);
      }
      do
      {
        for (;;)
        {
          PhoneContactManagerImp.a(this.a, true, true, 8L);
          return;
          this.a.e = System.currentTimeMillis();
          if ((paramInt != 2) && (paramInt != 3)) {
            break;
          }
          this.a.g = true;
        }
      } while ((paramInt != 5) && (paramInt != 4));
    } while (this.a.jdField_a_of_type_Int == 8);
    PhoneContactManagerImp.a(this.a, true, true, 8L);
  }
  
  public void onUploadContact(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactManagerImp.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onUploadContact, isSuc = " + paramBoolean + ", reason = " + paramInt + ", currentState=" + this.a.jdField_a_of_type_Int);
    }
    int i;
    if (PhoneContactManagerImp.e(this.a))
    {
      PhoneContactManagerImp localPhoneContactManagerImp = this.a;
      if (paramBoolean)
      {
        i = 3;
        PhoneContactManagerImp.a(localPhoneContactManagerImp, i, PhoneContactManagerImp.a(this.a).size(), 100, 100);
      }
    }
    else
    {
      if (PhoneContactManagerImp.a(this.a) != null)
      {
        PhoneContactManagerImp.a(this.a).b();
        PhoneContactManagerImp.a(this.a, null);
      }
      if (!paramBoolean) {
        break label197;
      }
      this.a.jdField_a_of_type_Int = 9;
      PhoneContactManagerImp.a(this.a, 0L, 0L);
      PhoneContactManagerImp.a(this.a, 15);
    }
    for (;;)
    {
      PhoneContactManagerImp.b(this.a);
      PhoneContactManagerImp.a(this.a, true, true, 7L);
      return;
      i = 4;
      break;
      label197:
      this.a.d = System.currentTimeMillis();
      if (paramInt == 2)
      {
        this.a.jdField_a_of_type_Int = 7;
      }
      else if (paramInt == 3)
      {
        this.a.jdField_a_of_type_Int = 9;
        this.a.g = true;
      }
      else if (paramInt == 1)
      {
        this.a.jdField_a_of_type_Int = 1;
        this.a.d = 0L;
      }
    }
  }
  
  public void onUploadContactNotBind(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactManagerImp.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onUploadContactNotBind, isSuc = " + paramBoolean + ", reason = " + paramInt + ", currentState=" + this.a.jdField_a_of_type_Int);
    }
    if (PhoneContactManagerImp.a(this.a) != null)
    {
      PhoneContactManagerImp.a(this.a).b();
      PhoneContactManagerImp.a(this.a, null);
    }
    int i;
    if (PhoneContactManagerImp.e(this.a))
    {
      PhoneContactManagerImp localPhoneContactManagerImp = this.a;
      if (paramBoolean)
      {
        i = 3;
        PhoneContactManagerImp.a(localPhoneContactManagerImp, i, PhoneContactManagerImp.a(this.a).size(), 100, 100);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label196;
      }
      this.a.jdField_a_of_type_Int = 2;
      PhoneContactManagerImp.a(this.a, 0L, 0L);
      PhoneContactManagerImp.a(this.a, 15);
    }
    for (;;)
    {
      PhoneContactManagerImp.b(this.a);
      PhoneContactManagerImp.a(this.a, true, true, 6L);
      return;
      i = 4;
      break;
      label196:
      this.a.d = System.currentTimeMillis();
      if ((paramInt != 2) && (paramInt != 3)) {
        break label235;
      }
      this.a.jdField_a_of_type_Int = 0;
      this.a.g = true;
    }
    label235:
    if (paramInt == 5)
    {
      this.a.jdField_a_of_type_Int = 1;
      this.a.d = 0L;
      PhoneContactManagerImp.b(this.a);
      PhoneContactManagerImp.a(this.a, true, true, 6L);
      return;
    }
    if (paramInt == 4)
    {
      this.a.jdField_a_of_type_Int = 9;
      this.a.g = true;
      PhoneContactManagerImp.b(this.a);
      PhoneContactManagerImp.a(this.a, true, true, 6L);
      return;
    }
    this.a.jdField_a_of_type_Int = 0;
    PhoneContactManagerImp.b(this.a);
    PhoneContactManagerImp.a(this.a, true, true, 6L);
  }
  
  public void onUploadProgressUpdated(int paramInt1, int paramInt2)
  {
    if (PhoneContactManagerImp.a(this.a)) {}
    do
    {
      return;
      if (PhoneContactManagerImp.a(this.a) == null) {
        PhoneContactManagerImp.a(this.a, new PhoneContactManagerImp.UploadProgressGenerator(this.a, null));
      }
      PhoneContactManagerImp.a(this.a).a(paramInt1, paramInt2);
    } while (!PhoneContactManagerImp.e(this.a));
    PhoneContactManagerImp.a(this.a, 2, PhoneContactManagerImp.a(this.a).size(), paramInt1, paramInt2);
  }
  
  public void onVerifyBindSms(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactManagerImp.a(this.a)) {}
    while ((!paramBoolean) || (paramInt != 0)) {
      return;
    }
    PhoneContactManagerImp.a(this.a, true, true, 10L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.2
 * JD-Core Version:    0.7.0.1
 */