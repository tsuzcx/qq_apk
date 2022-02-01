package com.tencent.mobileqq.activity.contacts.troopnotificationentry;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager.INewTroopNotificationUnreadCountOrConfigChangedListener;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.TroopNotificationEntryConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;

public class TroopNotificationEntryController
{
  int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TroopNotificationManager.INewTroopNotificationUnreadCountOrConfigChangedListener jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationManager$INewTroopNotificationUnreadCountOrConfigChangedListener = new TroopNotificationEntryController.2(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView b;
  private TextView c;
  
  public TroopNotificationEntryController(View paramView, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    i();
    a();
    e();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    TroopNotificationManager localTroopNotificationManager;
    do
    {
      return;
      localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    } while (localTroopNotificationManager == null);
    localTroopNotificationManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationManager$INewTroopNotificationUnreadCountOrConfigChangedListener);
  }
  
  private void f()
  {
    if (this.c == null) {
      return;
    }
    if ((this.b == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      this.c.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((j != 0) || (i != 0)) {
        break label393;
      }
      i = TroopNotifyHelper.c();
      if (!TroopNotifyHelper.a(i)) {
        break label331;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B52E", "0X800B52E", 0, 0, "", "", null, null);
      String str = String.valueOf(i);
      if (i > 99) {
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131720256);
      }
      this.c.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131720257) + str + this.jdField_a_of_type_AndroidAppActivity.getString(2131720258));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131720254) + String.valueOf(str) + this.jdField_a_of_type_AndroidAppActivity.getString(2131720258));
      TroopNotifyHelper.a(true);
      i = TroopNotifyHelper.a() + 1;
      TroopNotifyHelper.a(i);
      j = TroopNotifyHelper.b() + 1;
      TroopNotifyHelper.b(j);
      TroopNotifyHelper.b(System.currentTimeMillis());
      CustomWidgetUtil.a(this.b, 1, 0, 0);
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopNotificationEntryController", 2, "updateUndealTV bShowEntry" + this.jdField_a_of_type_Boolean + "oneWeekCount" + i + "oneDayCount" + j);
      return;
    }
    label331:
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, "updateUndealTV bShowEntry" + this.jdField_a_of_type_Boolean + " not show undeal tip");
    }
    TroopNotifyHelper.a(false);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    return;
    label393:
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, "updateUndealTV unReadCount" + j + " not show undeal tip");
    }
    TroopNotifyHelper.a(false);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)) {}
    do
    {
      int i;
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        i = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_Int != i)
        {
          ReportController.b(null, "dc00898", "", "", "0X800B52A", "0X800B52A", 0, 0, "", "", null, null);
          this.jdField_a_of_type_Int = i;
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131720254) + String.valueOf(i) + this.jdField_a_of_type_AndroidAppActivity.getString(2131720255));
        if (i <= 0) {
          break;
        }
        CustomWidgetUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, 4, i, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      } while (!QLog.isColorLevel());
      QLog.d("TroopNotificationEntryController", 2, "updateRedDot bShowEntry" + this.jdField_a_of_type_Boolean + " unReadCount" + i + "  mRedDotTV is VISIBLE");
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    } while (!QLog.isColorLevel());
    QLog.d("TroopNotificationEntryController", 2, "updateRedDot bShowEntry" + this.jdField_a_of_type_Boolean + " mRedDotTV is GONE");
  }
  
  private void h()
  {
    TroopNotificationManager localTroopNotificationManager = (TroopNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
    if (localTroopNotificationManager != null) {
      localTroopNotificationManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationManager$INewTroopNotificationUnreadCountOrConfigChangedListener);
    }
  }
  
  private void i()
  {
    TroopNotificationEntryConfig localTroopNotificationEntryConfig = (TroopNotificationEntryConfig)QConfigManager.a().a(691);
    if ((localTroopNotificationEntryConfig != null) && (localTroopNotificationEntryConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379999));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new TroopNotificationEntryController.1(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380000));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380003));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380001));
    d();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, "onAccountChanged");
    }
    h();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    e();
    i();
    d();
  }
  
  public void b()
  {
    h();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, "onResume bShowEntry" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B41A", "0X800B41A", 0, 0, "", "", null, null);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, "updateUI bShowEntry" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    g();
    f();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troopnotificationentry.TroopNotificationEntryController
 * JD-Core Version:    0.7.0.1
 */