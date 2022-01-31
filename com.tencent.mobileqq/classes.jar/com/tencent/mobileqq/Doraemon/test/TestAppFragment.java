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
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mContentView.findViewById(2131364366).setOnClickListener(this);
    this.mContentView.findViewById(2131364367).setOnClickListener(this);
    this.mContentView.findViewById(2131364368).setOnClickListener(this);
    this.mContentView.findViewById(2131364371).setOnClickListener(this);
    this.mContentView.findViewById(2131364372).setOnClickListener(this);
    this.mContentView.findViewById(2131364369).setOnClickListener(this);
    this.mContentView.findViewById(2131364370).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131364373));
    DoraemonOpenAPI.a();
  }
  
  protected int getContentLayoutId()
  {
    return 2130968948;
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
    case 2131364366: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("hello", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364367: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("login", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364368: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getSkey", new APIParam(), new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364369: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getUserInfo", new APIParam(), new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364370: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getAppFriends", new APIParam(), new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364371: 
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */