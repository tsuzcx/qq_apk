package com.tencent.mobileqq.app.hiddenchat;

import ajfi;
import ajfo;
import ajyx;
import ajyy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import awqx;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class HiddenChatSettingFragment
  extends IphoneTitleBarFragment
  implements CompoundButton.OnCheckedChangeListener
{
  private ajfo jdField_a_of_type_Ajfo = new ajyx(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem b;
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("should_restore_from_kill", false);
    PublicFragmentActivity.a((Activity)paramContext, localIntent, HiddenChatSettingFragment.class, paramInt);
  }
  
  private void a(FormSwitchItem paramFormSwitchItem, boolean paramBoolean)
  {
    paramFormSwitchItem.setOnCheckedChangeListener(null);
    paramFormSwitchItem.setChecked(paramBoolean);
    paramFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131307390));
      this.b = ((FormSwitchItem)this.mContentView.findViewById(2131307391));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajfo);
      boolean bool = ajyy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), getActivity());
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem, bool);
      bool = ajyy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), getActivity());
      a(this.b, bool);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131496716;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int i = 1;
    if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      ((ajfi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(paramBoolean, 42318);
      paramCompoundButton = getActivity().app;
      if (paramBoolean) {
        awqx.b(paramCompoundButton, "dc00898", "", "", "0X800A34C", "0X800A34C", i, 0, "0", "0", "", "");
      }
    }
    while (paramCompoundButton != this.b.a()) {
      for (;;)
      {
        return;
        i = 2;
      }
    }
    ((ajfi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(paramBoolean, 42319);
    paramCompoundButton = getActivity().app;
    if (paramBoolean) {}
    for (i = j;; i = 2)
    {
      awqx.b(paramCompoundButton, "dc00898", "", "", "0X800A350", "0X800A350", i, 0, "0", "0", "", "");
      return;
    }
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131653544));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment
 * JD-Core Version:    0.7.0.1
 */