package com.tencent.mobileqq.activity;

import Override;
import adxb;
import amsh;
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
import asvf;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class AuthDevEnableCompleteActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<amsh> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  
  private View a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " parameter is Wrong!");
      }
      return null;
    }
    View localView = getLayoutInflater().inflate(2131561169, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    if ((localView == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " view initialization failed!");
      }
      return null;
    }
    localView.setOnClickListener(new adxb(this));
    ImageView localImageView = (ImageView)localView.findViewById(2131364490);
    TextView localTextView1 = (TextView)localView.findViewById(2131371647);
    TextView localTextView2 = (TextView)localView.findViewById(2131378815);
    TextView localTextView3 = (TextView)localView.findViewById(2131368636);
    if ((localImageView == null) || (localTextView1 == null) || (localTextView2 == null) || (localTextView3 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "some controls are invalide!");
      }
      return null;
    }
    localImageView.setVisibility(0);
    localTextView1.setText(paramString1);
    localTextView2.setText(getString(2131691817));
    localTextView3.setText(paramString2);
    return localView;
  }
  
  private void a()
  {
    super.setContentView(2131561163);
    setTitle(2131691835);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363800));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377417));
    if ((this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "one or more controls is null in AuthDevEnableCompleteActivity! ");
      }
      return;
    }
    Object localObject1 = (TextView)findViewById(2131369042);
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_JavaUtilArrayList = asvf.a().a();
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = 0;
    int i = 0;
    Object localObject2;
    boolean bool1;
    label171:
    boolean bool2;
    for (;;)
    {
      if (j < k)
      {
        localObject2 = (amsh)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (localObject2 == null)
        {
          j += 1;
        }
        else if ((((amsh)localObject2).c == 1) || (((amsh)localObject2).c == 2))
        {
          bool1 = true;
          if (((((amsh)localObject2).jdField_a_of_type_ArrayOfByte == null) || (!((amsh)localObject2).jdField_a_of_type_ArrayOfByte.equals(NetConnInfoCenter.GUID))) && (((amsh)localObject2).c != 1)) {
            break label361;
          }
          ((amsh)localObject2).jdField_a_of_type_Boolean = true;
          bool2 = false;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      localObject1 = a(((amsh)localObject2).jdField_a_of_type_JavaLangString, ((amsh)localObject2).b, bool1, bool2, ((amsh)localObject2).jdField_a_of_type_Boolean);
      if (localObject1 != null)
      {
        ((amsh)localObject2).d = i;
        i += 1;
        localObject2 = (RelativeLayout)((View)localObject1).findViewById(2131368923);
        if (k == 1) {
          ((RelativeLayout)localObject2).setBackgroundResource(2130839440);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          break;
          bool1 = false;
          break label171;
          if (i == 1) {
            ((RelativeLayout)localObject2).setBackgroundResource(2130839456);
          } else if (j == k - 1) {
            ((RelativeLayout)localObject2).setBackgroundResource(2130839447);
          } else {
            ((RelativeLayout)localObject2).setBackgroundResource(2130839450);
          }
        }
        try
        {
          asvf.a().a(null, this.app.getCurrentAccountUin(), 10);
          return;
        }
        catch (Exception localException)
        {
          return;
        }
      }
      break;
      label361:
      bool2 = true;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if ((AuthDevOpenUgActivity.a()) && (this.jdField_a_of_type_Boolean))
    {
      finish();
      startActivity(new Intent(this, LoginInfoActivity.class));
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "click confirm mobile phone button! ");
      }
      try
      {
        asvf.a().a(null, this.app.getCurrentAccountUin(), 11);
        label70:
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
        {
          int k = this.jdField_a_of_type_JavaUtilArrayList.size();
          int i = 0;
          if (i < k)
          {
            localObject = (amsh)this.jdField_a_of_type_JavaUtilArrayList.get(i);
            int j = ((amsh)localObject).d;
            View localView;
            if (j >= 0)
            {
              localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
              if (localView != null) {
                break label146;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              if (((ImageView)localView.findViewById(2131364490)).getVisibility() == 0) {}
              for (j = 1;; j = 0)
              {
                if (j == 0) {
                  break label190;
                }
                if (((amsh)localObject).c != 0) {
                  break;
                }
                ((amsh)localObject).c = 3;
                break;
              }
              ((amsh)localObject).c = 0;
            }
          }
        }
        label146:
        label190:
        asvf.a().a(this.app, this.jdField_a_of_type_JavaUtilArrayList);
        Object localObject = new Intent(this, AuthDevActivity.class);
        ((Intent)localObject).putExtra("auth_dev_open", true);
        if (this.jdField_a_of_type_JavaLangString != null)
        {
          ((Intent)localObject).putExtra("country_code", this.jdField_a_of_type_Int);
          ((Intent)localObject).putExtra("phone_num", this.jdField_a_of_type_JavaLangString);
        }
        startActivity((Intent)localObject);
        overridePendingTransition(0, 2130772001);
        asvf.a().c();
        finish();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "onClick right cancel button! ");
        }
        finish();
        overridePendingTransition(0, 2130772001);
      }
      catch (Exception localException)
      {
        break label70;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
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
    this.jdField_a_of_type_Boolean = ((Bundle)localObject).getBoolean("h5_flag");
    this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("phone_num");
    this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("country_code");
    if (QLog.isColorLevel()) {
      QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "on Create AuthDevEnableCompleteActivity！");
    }
    super.onCreate(paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevEnableCompleteActivity
 * JD-Core Version:    0.7.0.1
 */