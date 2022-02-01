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
  int a;
  private QQAppInterface b;
  private View c;
  private RelativeLayout d;
  private Activity e;
  private TextView f;
  private TextView g;
  private TextView h;
  private boolean i = false;
  private ITroopNotificationService.INewTroopNotificationUnreadCountOrConfigChangedListener j = new TroopNotificationEntryController.2(this);
  
  public TroopNotificationEntryController(View paramView, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.b = paramQQAppInterface;
    this.c = paramView;
    this.e = paramActivity;
    i();
    a();
    e();
  }
  
  private void e()
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = (ITroopNotificationService)((QQAppInterface)localObject).getRuntimeService(ITroopNotificationService.class, "");
    if (localObject != null) {
      ((ITroopNotificationService)localObject).addUnreadCountOrConfigChangedListener(this.j);
    }
  }
  
  private void f()
  {
    if (this.h == null) {
      return;
    }
    if (this.g != null)
    {
      Object localObject1 = this.f;
      if ((localObject1 != null) && (this.b != null))
      {
        int k;
        if (((TextView)localObject1).getVisibility() == 0) {
          k = 1;
        } else {
          k = 0;
        }
        int m = GroupSystemMsgController.a().b(this.b);
        if ((m == 0) && (k == 0))
        {
          k = TroopNotifyHelper.g();
          if (TroopNotifyHelper.a(k))
          {
            ReportController.b(null, "dc00898", "", "", "0X800B52E", "0X800B52E", 0, 0, "", "", null, null);
            localObject1 = String.valueOf(k);
            if (k > 99) {
              localObject1 = this.e.getString(2131917596);
            }
            Object localObject2 = this.h;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.e.getString(2131917597));
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(this.e.getString(2131917598));
            ((TextView)localObject2).setText(localStringBuilder.toString());
            localObject2 = this.d;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.e.getString(2131917594));
            localStringBuilder.append(String.valueOf(localObject1));
            localStringBuilder.append(this.e.getString(2131917598));
            ((RelativeLayout)localObject2).setContentDescription(localStringBuilder.toString());
            TroopNotifyHelper.a(true);
            k = TroopNotifyHelper.a() + 1;
            TroopNotifyHelper.b(k);
            m = TroopNotifyHelper.c() + 1;
            TroopNotifyHelper.c(m);
            TroopNotifyHelper.b(System.currentTimeMillis());
            CustomWidgetUtil.a(this.g, 1, 0, 0);
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateUndealTV bShowEntry");
              ((StringBuilder)localObject1).append(this.i);
              ((StringBuilder)localObject1).append("oneWeekCount");
              ((StringBuilder)localObject1).append(k);
              ((StringBuilder)localObject1).append("oneDayCount");
              ((StringBuilder)localObject1).append(m);
              QLog.d("TroopNotificationEntryController", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateUndealTV bShowEntry");
              ((StringBuilder)localObject1).append(this.i);
              ((StringBuilder)localObject1).append(" not show undeal tip");
              QLog.d("TroopNotificationEntryController", 2, ((StringBuilder)localObject1).toString());
            }
            TroopNotifyHelper.a(false);
            this.g.setVisibility(8);
            this.h.setVisibility(8);
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateUndealTV unReadCount");
            ((StringBuilder)localObject1).append(m);
            ((StringBuilder)localObject1).append(" not show undeal tip");
            QLog.d("TroopNotificationEntryController", 2, ((StringBuilder)localObject1).toString());
          }
          TroopNotifyHelper.a(false);
          this.g.setVisibility(8);
          this.h.setVisibility(8);
        }
        return;
      }
    }
    this.h.setVisibility(8);
  }
  
  private void g()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (this.d == null) {
        return;
      }
      if (this.b == null)
      {
        ((TextView)localObject).setVisibility(8);
        return;
      }
      int k = GroupSystemMsgController.a().b(this.b);
      if (this.a != k)
      {
        ReportController.b(null, "dc00898", "", "", "0X800B52A", "0X800B52A", 0, 0, "", "", null, null);
        this.a = k;
      }
      localObject = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e.getString(2131917594));
      localStringBuilder.append(String.valueOf(k));
      localStringBuilder.append(this.e.getString(2131917595));
      ((RelativeLayout)localObject).setContentDescription(localStringBuilder.toString());
      if (k > 0)
      {
        CustomWidgetUtil.a(this.f, 4, k, 0);
        this.f.setVisibility(0);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateRedDot bShowEntry");
          ((StringBuilder)localObject).append(this.i);
          ((StringBuilder)localObject).append(" unReadCount");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append("  mRedDotTV is VISIBLE");
          QLog.d("TroopNotificationEntryController", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.f.setVisibility(8);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateRedDot bShowEntry");
          ((StringBuilder)localObject).append(this.i);
          ((StringBuilder)localObject).append(" mRedDotTV is GONE");
          QLog.d("TroopNotificationEntryController", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void h()
  {
    ITroopNotificationService localITroopNotificationService = (ITroopNotificationService)this.b.getRuntimeService(ITroopNotificationService.class, "");
    if (localITroopNotificationService != null) {
      localITroopNotificationService.removeUnreadCountOrConfigChangedListener(this.j);
    }
  }
  
  private void i()
  {
    TroopNotificationEntryConfig localTroopNotificationEntryConfig = (TroopNotificationEntryConfig)QConfigManager.b().b(691);
    if ((localTroopNotificationEntryConfig != null) && (localTroopNotificationEntryConfig.b(this.b.getCurrentAccountUin())))
    {
      this.i = true;
      return;
    }
    this.i = false;
  }
  
  public void a()
  {
    View localView = this.c;
    if (localView == null) {
      return;
    }
    this.d = ((RelativeLayout)localView.findViewById(2131448065));
    this.d.setOnClickListener(new TroopNotificationEntryController.1(this));
    this.f = ((TextView)this.d.findViewById(2131448066));
    this.h = ((TextView)this.d.findViewById(2131448069));
    this.g = ((TextView)this.d.findViewById(2131448067));
    d();
    if (this.i)
    {
      this.d.setVisibility(0);
      return;
    }
    this.d.setVisibility(8);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationEntryController", 2, "onAccountChanged");
    }
    h();
    this.b = paramQQAppInterface;
    this.e = paramActivity;
    e();
    i();
    d();
  }
  
  public void b()
  {
    h();
    this.b = null;
    this.e = null;
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume bShowEntry");
      localStringBuilder.append(this.i);
      QLog.d("TroopNotificationEntryController", 2, localStringBuilder.toString());
    }
    if (!this.i) {
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
      localStringBuilder.append(this.i);
      QLog.d("TroopNotificationEntryController", 2, localStringBuilder.toString());
    }
    if (!this.i)
    {
      this.d.setVisibility(8);
      return;
    }
    g();
    f();
    this.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troopnotificationentry.TroopNotificationEntryController
 * JD-Core Version:    0.7.0.1
 */