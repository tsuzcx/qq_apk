package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class AuthDevEnableCompleteActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private Button a = null;
  private LinearLayout b = null;
  private String c = null;
  private int d = 0;
  private ArrayList<DeviceLockItemInfo> e = null;
  private boolean f = false;
  
  private View a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      View localView = getLayoutInflater().inflate(2131627396, this.b, false);
      if ((localView != null) && (this.b != null))
      {
        localView.setOnClickListener(new AuthDevEnableCompleteActivity.1(this));
        ImageView localImageView = (ImageView)localView.findViewById(2131430661);
        TextView localTextView1 = (TextView)localView.findViewById(2131439121);
        TextView localTextView2 = (TextView)localView.findViewById(2131447311);
        TextView localTextView3 = (TextView)localView.findViewById(2131435692);
        if ((localImageView != null) && (localTextView1 != null) && (localTextView2 != null) && (localTextView3 != null))
        {
          localImageView.setVisibility(0);
          localTextView1.setText(paramString1);
          localTextView2.setText(getString(2131888967));
          localTextView3.setText(paramString2);
          return localView;
        }
        if (QLog.isColorLevel()) {
          QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "some controls are invalide!");
        }
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " view initialization failed!");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " parameter is Wrong!");
    }
    return null;
  }
  
  private void a()
  {
    super.setContentView(2131627390);
    setTitle(2131888985);
    this.a = ((Button)findViewById(2131429882));
    this.b = ((LinearLayout)findViewById(2131445684));
    if ((this.a != null) && (this.b != null))
    {
      Object localObject1 = (TextView)findViewById(2131436180);
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      this.a.setOnClickListener(this);
      this.e = EquipmentLockImpl.a().d();
      int m = this.e.size();
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        Object localObject2 = (DeviceLockItemInfo)this.e.get(i);
        if (localObject2 == null)
        {
          k = j;
        }
        else
        {
          boolean bool1;
          if ((((DeviceLockItemInfo)localObject2).g != 1) && (((DeviceLockItemInfo)localObject2).g != 2)) {
            bool1 = false;
          } else {
            bool1 = true;
          }
          boolean bool2;
          if (((((DeviceLockItemInfo)localObject2).c != null) && (((DeviceLockItemInfo)localObject2).c.equals(NetConnInfoCenter.GUID))) || (((DeviceLockItemInfo)localObject2).g == 1))
          {
            ((DeviceLockItemInfo)localObject2).h = true;
            bool1 = true;
            bool2 = false;
          }
          else
          {
            bool2 = true;
          }
          localObject1 = a(((DeviceLockItemInfo)localObject2).a, ((DeviceLockItemInfo)localObject2).b, bool1, bool2, ((DeviceLockItemInfo)localObject2).h);
          k = j;
          if (localObject1 != null)
          {
            ((DeviceLockItemInfo)localObject2).i = j;
            k = j + 1;
            localObject2 = (RelativeLayout)((View)localObject1).findViewById(2131436054);
            if (m == 1) {
              ((RelativeLayout)localObject2).setBackgroundResource(2130839622);
            } else if (k == 1) {
              ((RelativeLayout)localObject2).setBackgroundResource(2130839638);
            } else if (i == m - 1) {
              ((RelativeLayout)localObject2).setBackgroundResource(2130839629);
            } else {
              ((RelativeLayout)localObject2).setBackgroundResource(2130839632);
            }
            this.b.addView((View)localObject1);
          }
        }
        i += 1;
      }
    }
    try
    {
      EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 10);
      return;
    }
    catch (Exception localException) {}
    if (QLog.isColorLevel()) {
      QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "one or more controls is null in AuthDevEnableCompleteActivity! ");
    }
    return;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean onBackEvent()
  {
    if ((AuthDevOpenUgActivity.getIsH5Jump()) && (this.f))
    {
      finish();
      startActivity(new Intent(this, LoginInfoActivity.class));
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131429882)
    {
      if (i == 2131436211)
      {
        if (QLog.isColorLevel()) {
          QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "onClick right cancel button! ");
        }
        finish();
        overridePendingTransition(0, 2130772018);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "click confirm mobile phone button! ");
    }
    try
    {
      EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 11);
      label79:
      Object localObject = this.e;
      if ((localObject != null) && (this.b != null))
      {
        int k = ((ArrayList)localObject).size();
        i = 0;
        while (i < k)
        {
          localObject = (DeviceLockItemInfo)this.e.get(i);
          int j = ((DeviceLockItemInfo)localObject).i;
          if (j >= 0)
          {
            View localView = this.b.getChildAt(j);
            if (localView != null)
            {
              if (((ImageView)localView.findViewById(2131430661)).getVisibility() == 0) {
                j = 1;
              } else {
                j = 0;
              }
              if (j != 0)
              {
                if (((DeviceLockItemInfo)localObject).g == 0) {
                  ((DeviceLockItemInfo)localObject).g = 3;
                }
              }
              else {
                ((DeviceLockItemInfo)localObject).g = 0;
              }
            }
          }
          i += 1;
        }
      }
      EquipmentLockImpl.a().a(this.app, this.e);
      localObject = new Intent();
      ((Intent)localObject).putExtra("auth_dev_open", true);
      if (this.c != null)
      {
        ((Intent)localObject).putExtra("country_code", this.d);
        ((Intent)localObject).putExtra("phone_num", this.c);
      }
      RouteUtils.a(this, (Intent)localObject, "/base/safe/authDevActivity");
      overridePendingTransition(0, 2130772018);
      EquipmentLockImpl.a().e();
      finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label79;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = getIntent();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    this.f = ((Bundle)localObject).getBoolean("h5_flag");
    this.c = ((Bundle)localObject).getString("phone_num");
    this.d = ((Bundle)localObject).getInt("country_code");
    if (QLog.isColorLevel()) {
      QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "on Create AuthDevEnableCompleteActivity！");
    }
    super.onCreate(paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevEnableCompleteActivity
 * JD-Core Version:    0.7.0.1
 */