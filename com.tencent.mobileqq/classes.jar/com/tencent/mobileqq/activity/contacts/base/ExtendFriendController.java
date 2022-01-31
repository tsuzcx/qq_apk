package com.tencent.mobileqq.activity.contacts.base;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.ExtendFriendConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Date;

public class ExtendFriendController
  extends BaseViewController
{
  private CardController jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController;
  private CommonCardEntry jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((SplashActivity)a()).app;
  private ExtendFriendManager jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager;
  
  public ExtendFriendController(Activity paramActivity, CardController paramCardController)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController = paramCardController;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263));
  }
  
  private boolean a(ExtendFriendManager.ExtendFriendConfig paramExtendFriendConfig)
  {
    Date localDate1 = new Date(this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a());
    Date localDate2 = new Date();
    SharedPreferences localSharedPreferences = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config");
    int i = localSharedPreferences.getInt("sp_extend_friend_entry_contact", 0);
    int j = localSharedPreferences.getInt("sp_extend_friend_entry_add_friend", 0);
    return (i == 1) && (j == 1) && ((localDate1.getDate() != localDate2.getDate()) || (localDate1.getMonth() != localDate2.getMonth()) || (localDate1.getYear() != localDate2.getYear())) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a()) && ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.b() < paramExtendFriendConfig.d) || ((int)((System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a()) / 86400000L) > paramExtendFriendConfig.e));
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager == null) {}
    label245:
    boolean bool;
    int i;
    int j;
    do
    {
      for (;;)
      {
        return;
        ExtendFriendManager.ExtendFriendConfig localExtendFriendConfig = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a();
        if (localExtendFriendConfig == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(0)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(0, null);
          }
        }
        else {
          try
          {
            str = String.format(localExtendFriendConfig.c, new Object[] { this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a() });
            if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry == null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry = new CommonCardEntry(0, 2130842486, localExtendFriendConfig.a, localExtendFriendConfig.b, str, null);
              if (a(localExtendFriendConfig)) {
                break label245;
              }
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(0)) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(0, null);
            }
          }
          catch (Exception localException)
          {
            String str;
            for (;;)
            {
              str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131439330), new Object[] { this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a() });
              localException.printStackTrace();
              continue;
              if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.b, localExtendFriendConfig.b))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.b = localExtendFriendConfig.b;
                this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.a = true;
              }
              if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.c, str))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.c = str;
                this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.a = true;
              }
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092C6", "0X80092C6", 0, 0, "", "", "", "");
            if (!TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.c))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.c = str;
              this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.a = true;
            }
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(0)) {
              this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(0, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry);
            }
            if (localExtendFriendConfig.g == 1) {}
            for (bool = true;; bool = false)
            {
              i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(1);
              j = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(0);
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendController", 0, String.format("makeAndShowEntry isFirst=%s honestSayPos=%s extendFriendPos=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) }));
              }
              if ((!bool) || (j == 0)) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(0, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry, 0);
              return;
            }
          }
        }
      }
    } while ((bool) || (i < 0) || (j == i + 1));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(0, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry, i + 1);
  }
  
  public void a() {}
  
  public void a(CommonCardEntry paramCommonCardEntry)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(l))
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.b() + 1);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(l);
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(1);
      paramCommonCardEntry = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (j < 0) {
        break label98;
      }
    }
    for (;;)
    {
      ReportController.b(paramCommonCardEntry, "dc00898", "", "", "0X80092C8", "0X80092C8", i, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(1);
      break;
      label98:
      i = 2;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263));
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    e();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.ExtendFriendController
 * JD-Core Version:    0.7.0.1
 */