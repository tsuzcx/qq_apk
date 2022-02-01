package com.tencent.mobileqq.activity.contacts.troopnotificationentry;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.api.ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationEntryConfig;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;

public class TroopNotificationEntryController
{
  int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener jdField_a_of_type_ComTencentMobileqqTroopApiITroopNotificationService$INewTroopNotificationUnreadCountOrConfigChangedListener = new TroopNotificationEntryController.2(this);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null) {
      return;
    }
    localObject = (ITroopNotificationService)((QQAppInterface)localObject).getRuntimeService(ITroopNotificationService.class, "");
    if (localObject != null) {
      ((ITroopNotificationService)localObject).addUnreadCountOrConfigChangedListener(this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopNotificationService$INewTroopNotificationUnreadCountOrConfigChangedListener);
    }
  }
  
  private void f()
  {
    if (this.c == null) {
      return;
    }
    if (this.b != null)
    {
      Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        int i;
        if (((TextView)localObject1).getVisibility() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        int j = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((j == 0) && (i == 0))
        {
          i = TroopNotifyHelper.c();
          if (TroopNotifyHelper.a(i))
          {
            ReportController.b(null, "dc00898", "", "", "0X800B52E", "0X800B52E", 0, 0, "", "", null, null);
            localObject1 = String.valueOf(i);
            if (i > 99) {
              localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131719991);
            }
            Object localObject2 = this.c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131719992));
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131719993));
            ((TextView)localObject2).setText(localStringBuilder.toString());
            localObject2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131719989));
            localStringBuilder.append(String.valueOf(localObject1));
            localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131719993));
            ((RelativeLayout)localObject2).setContentDescription(localStringBuilder.toString());
            TroopNotifyHelper.a(true);
            i = TroopNotifyHelper.a() + 1;
            TroopNotifyHelper.a(i);
            j = TroopNotifyHelper.b() + 1;
            TroopNotifyHelper.b(j);
            TroopNotifyHelper.b(System.currentTimeMillis());
            CustomWidgetUtil.a(this.b, 1, 0, 0);
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateUndealTV bShowEntry");
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
              ((StringBuilder)localObject1).append("oneWeekCount");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append("oneDayCount");
              ((StringBuilder)localObject1).append(j);
              QLog.d("TroopNotificationEntryController", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateUndealTV bShowEntry");
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
              ((StringBuilder)localObject1).append(" not show undeal tip");
              QLog.d("TroopNotificationEntryController", 2, ((StringBuilder)localObject1).toString());
            }
            TroopNotifyHelper.a(false);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateUndealTV unReadCount");
            ((StringBuilder)localObject1).append(j);
            ((StringBuilder)localObject1).append(" not show undeal tip");
            QLog.d("TroopNotificationEntryController", 2, ((StringBuilder)localObject1).toString());
          }
          TroopNotifyHelper.a(false);
          this.b.setVisibility(8);
          this.c.setVisibility(8);
        }
        return;
      }
    }
    this.c.setVisibility(8);
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        ((TextView)localObject).setVisibility(8);
        return;
      }
      int i = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_Int != i)
      {
        ReportController.b(null, "dc00898", "", "", "0X800B52A", "0X800B52A", 0, 0, "", "", null, null);
        this.jdField_a_of_type_Int = i;
      }
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131719989));
      localStringBuilder.append(String.valueOf(i));
      localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131719990));
      ((RelativeLayout)localObject).setContentDescription(localStringBuilder.toString());
      if (i > 0)
      {
        CustomWidgetUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, 4, i, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateRedDot bShowEntry");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
          ((StringBuilder)localObject).append(" unReadCount");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("  mRedDotTV is VISIBLE");
          QLog.d("TroopNotificationEntryController", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateRedDot bShowEntry");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
          ((StringBuilder)localObject).append(" mRedDotTV is GONE");
          QLog.d("TroopNotificationEntryController", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void h()
  {
    ITroopNotificationService localITroopNotificationService = (ITroopNotificationService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopNotificationService.class, "");
    if (localITroopNotificationService != null) {
      localITroopNotificationService.removeUnreadCountOrConfigChangedListener(this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopNotificationService$INewTroopNotificationUnreadCountOrConfigChangedListener);
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
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131379328));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new TroopNotificationEntryController.1(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379329));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379332));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379330));
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume bShowEntry");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("TroopNotificationEntryController", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B41A", "0X800B41A", 0, 0, "", "", null, null);
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUI bShowEntry");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("TroopNotificationEntryController", 2, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troopnotificationentry.TroopNotificationEntryController
 * JD-Core Version:    0.7.0.1
 */