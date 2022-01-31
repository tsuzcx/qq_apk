package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import rsm;

public class AuthDevEnableCompleteActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  private View a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " parameter is Wrong!");
      }
      return null;
    }
    View localView = getLayoutInflater().inflate(2130970338, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    if ((localView == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " view initialization failed!");
      }
      return null;
    }
    localView.setOnClickListener(new rsm(this));
    ImageView localImageView = (ImageView)localView.findViewById(2131362761);
    TextView localTextView1 = (TextView)localView.findViewById(2131362759);
    TextView localTextView2 = (TextView)localView.findViewById(2131370073);
    TextView localTextView3 = (TextView)localView.findViewById(2131364144);
    if ((localImageView == null) || (localTextView1 == null) || (localTextView2 == null) || (localTextView3 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "some controls are invalide!");
      }
      return null;
    }
    localImageView.setVisibility(0);
    localTextView1.setText(paramString1);
    localTextView2.setText(getString(2131436634));
    localTextView3.setText(paramString2);
    return localView;
  }
  
  private void a()
  {
    super.setContentView(2130970333);
    setTitle(2131436572);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370060));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370059));
    if ((this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "one or more controls is null in AuthDevEnableCompleteActivity! ");
      }
      return;
    }
    Object localObject1 = (TextView)findViewById(2131363262);
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_JavaUtilArrayList = EquipmentLockImpl.a().a();
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
        localObject2 = (DeviceLockItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (localObject2 == null)
        {
          j += 1;
        }
        else if ((((DeviceLockItemInfo)localObject2).c == 1) || (((DeviceLockItemInfo)localObject2).c == 2))
        {
          bool1 = true;
          if (((((DeviceLockItemInfo)localObject2).jdField_a_of_type_ArrayOfByte == null) || (!((DeviceLockItemInfo)localObject2).jdField_a_of_type_ArrayOfByte.equals(NetConnInfoCenter.GUID))) && (((DeviceLockItemInfo)localObject2).c != 1)) {
            break label361;
          }
          ((DeviceLockItemInfo)localObject2).jdField_a_of_type_Boolean = true;
          bool2 = false;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      localObject1 = a(((DeviceLockItemInfo)localObject2).jdField_a_of_type_JavaLangString, ((DeviceLockItemInfo)localObject2).b, bool1, bool2, ((DeviceLockItemInfo)localObject2).jdField_a_of_type_Boolean);
      if (localObject1 != null)
      {
        ((DeviceLockItemInfo)localObject2).d = i;
        i += 1;
        localObject2 = (RelativeLayout)((View)localObject1).findViewById(2131362754);
        if (k == 1) {
          ((RelativeLayout)localObject2).setBackgroundResource(2130838629);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          break;
          bool1 = false;
          break label171;
          if (i == 1) {
            ((RelativeLayout)localObject2).setBackgroundResource(2130838641);
          } else if (j == k - 1) {
            ((RelativeLayout)localObject2).setBackgroundResource(2130838636);
          } else {
            ((RelativeLayout)localObject2).setBackgroundResource(2130838639);
          }
        }
        try
        {
          EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 10);
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean onBackEvent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131370060: 
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "click confirm mobile phone button! ");
      }
      break;
    }
    try
    {
      EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 11);
      label63:
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
      {
        int k = this.jdField_a_of_type_JavaUtilArrayList.size();
        int i = 0;
        if (i < k)
        {
          paramView = (DeviceLockItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          int j = paramView.d;
          View localView;
          if (j >= 0)
          {
            localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
            if (localView != null) {
              break label137;
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if (((ImageView)localView.findViewById(2131362761)).getVisibility() == 0) {}
            for (j = 1;; j = 0)
            {
              if (j == 0) {
                break label179;
              }
              if (paramView.c != 0) {
                break;
              }
              paramView.c = 3;
              break;
            }
            paramView.c = 0;
          }
        }
      }
      label137:
      label179:
      EquipmentLockImpl.a().a(this.app, this.jdField_a_of_type_JavaUtilArrayList);
      paramView = new Intent(this, AuthDevActivity.class);
      paramView.putExtra("auth_dev_open", true);
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        paramView.putExtra("country_code", this.jdField_a_of_type_Int);
        paramView.putExtra("phone_num", this.jdField_a_of_type_JavaLangString);
      }
      startActivity(paramView);
      overridePendingTransition(0, 2131034135);
      EquipmentLockImpl.a().c();
      finish();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "onClick right cancel button! ");
      }
      finish();
      overridePendingTransition(0, 2131034135);
      return;
    }
    catch (Exception paramView)
    {
      break label63;
    }
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
    this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("phone_num");
    this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("country_code");
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