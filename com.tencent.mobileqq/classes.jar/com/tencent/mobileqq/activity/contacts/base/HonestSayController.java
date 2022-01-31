package com.tencent.mobileqq.activity.contacts.base;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import wmy;

public class HonestSayController
  extends BaseViewController
{
  private CardController jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController;
  private CommonCardEntry jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((SplashActivity)a()).app;
  private ConfessManager jdField_a_of_type_ComTencentMobileqqConfessConfessManager;
  private boolean jdField_a_of_type_Boolean;
  
  public HonestSayController(Activity paramActivity, CardController paramCardController)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController = paramCardController;
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268));
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager == null) {}
    label259:
    do
    {
      ConfessConfig localConfessConfig;
      do
      {
        return;
        localConfessConfig = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.b();
        if (localConfessConfig != null) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(1)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(1, null);
        }
      } while (!QLog.isColorLevel());
      QLog.i("HonestSayController", 2, String.format(Locale.getDefault(), "checkShowEntry config: %s, entry: %s", new Object[] { localConfessConfig, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry }));
      return;
      String str = localConfessConfig.a();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry = new CommonCardEntry(1, 2130842387, a().getResources().getString(2131439179), localConfessConfig.a(paramQQAppInterface), str, localConfessConfig.d);
      }
      for (;;)
      {
        if (localConfessConfig.a()) {
          break label259;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(1)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(1, null);
        return;
        if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.d, localConfessConfig.d))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.d = localConfessConfig.d;
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.jdField_a_of_type_Boolean = true;
        }
        if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.b, localConfessConfig.a(paramQQAppInterface)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.b = localConfessConfig.a(paramQQAppInterface);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.jdField_a_of_type_Boolean = true;
        }
        if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.c, str))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.c = str;
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.jdField_a_of_type_Boolean = true;
        }
      }
      paramQQAppInterface = localConfessConfig.a();
      if (!TextUtils.equals(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.c))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.c = paramQQAppInterface;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.jdField_a_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(1)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardController.a(1, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCommonCardEntry);
      }
    } while (this.jdField_a_of_type_Boolean);
    ThreadManager.post(new wmy(this), 5, null, true);
  }
  
  public void a() {}
  
  public void a(CommonCardEntry paramCommonCardEntry)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager == null) {}
    ConfessConfig localConfessConfig;
    do
    {
      return;
      localConfessConfig = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.b();
      if (localConfessConfig != null) {
        localConfessConfig.a();
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("HonestSayController", 4, String.format(Locale.getDefault(), "onCardVanish config: %s , entry: %s", new Object[] { localConfessConfig, paramCommonCardEntry }));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("HonestSayController", 4, String.format(Locale.getDefault(), "fillData account: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() }));
    }
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268));
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager = null;
  }
  
  public void d()
  {
    Locale localLocale;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label45;
      }
    }
    label45:
    for (String str = null;; str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())
    {
      QLog.i("HonestSayController", 4, String.format(localLocale, "onBeforeAccountChanged account: %s", new Object[] { str }));
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.HonestSayController
 * JD-Core Version:    0.7.0.1
 */