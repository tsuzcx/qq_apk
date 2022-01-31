package com.tencent.mobileqq.Doraemon.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonOpenAPI;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;

public class TestAppFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  EditText jdField_a_of_type_AndroidWidgetEditText;
  DoraemonAPIManager jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
  
  protected int a()
  {
    return 2130968946;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.e.findViewById(2131364341).setOnClickListener(this);
    this.e.findViewById(2131364342).setOnClickListener(this);
    this.e.findViewById(2131364343).setOnClickListener(this);
    this.e.findViewById(2131364346).setOnClickListener(this);
    this.e.findViewById(2131364347).setOnClickListener(this);
    this.e.findViewById(2131364344).setOnClickListener(this);
    this.e.findViewById(2131364345).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.e.findViewById(2131364348));
    DoraemonOpenAPI.a();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager == null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("getSkey");
      localArrayList.add("ssoSend");
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("internalApis", localArrayList);
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = DoraemonOpenAPI.a(getActivity(), 1, "100336399", localBundle);
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364341: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("hello", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364342: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("login", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364343: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getSkey", new APIParam(), new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364344: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getUserInfo", new APIParam(), new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364345: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getAppFriends", new APIParam(), new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364346: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getLocation", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getCity", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a();
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */