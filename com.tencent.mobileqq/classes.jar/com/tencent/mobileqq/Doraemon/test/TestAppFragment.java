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
import rcl;

public class TestAppFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public EditText a;
  DoraemonAPIManager a;
  
  protected int a()
  {
    return 2130968946;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.e.findViewById(2131364317).setOnClickListener(this);
    this.e.findViewById(2131364318).setOnClickListener(this);
    this.e.findViewById(2131364319).setOnClickListener(this);
    this.e.findViewById(2131364322).setOnClickListener(this);
    this.e.findViewById(2131364323).setOnClickListener(this);
    this.e.findViewById(2131364320).setOnClickListener(this);
    this.e.findViewById(2131364321).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.e.findViewById(2131364324));
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
    case 2131364317: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("hello", null, new rcl(this));
      return;
    case 2131364318: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("login", null, new rcl(this));
      return;
    case 2131364319: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getSkey", new APIParam(), new rcl(this));
      return;
    case 2131364320: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getUserInfo", new APIParam(), new rcl(this));
      return;
    case 2131364321: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getAppFriends", new APIParam(), new rcl(this));
      return;
    case 2131364322: 
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getLocation", null, new rcl(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getCity", null, new rcl(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */