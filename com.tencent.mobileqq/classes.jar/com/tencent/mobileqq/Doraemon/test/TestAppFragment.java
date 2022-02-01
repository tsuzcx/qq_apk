package com.tencent.mobileqq.Doraemon.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioGroup;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonOpenAPI;
import com.tencent.mobileqq.Doraemon.ui.SdkAuthDialog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class TestAppFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 5;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  DoraemonAPIManager jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
  String jdField_a_of_type_JavaLangString = AppConstants.SDCARD_ROOT + "/Tencent/com/tencent/mobileqq/";
  private RadioGroup jdField_b_of_type_AndroidWidgetRadioGroup;
  String jdField_b_of_type_JavaLangString = "openapi";
  String c = "101469453";
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("login", null, new TestAppFragment.6(this));
  }
  
  public void a()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    LinearLayout localLinearLayout = new LinearLayout(getActivity());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
    EditText localEditText1 = new EditText(getActivity());
    localEditText1.setLayoutParams(new ViewGroup.LayoutParams(400, 80));
    localEditText1.setText(this.c);
    EditText localEditText2 = new EditText(getActivity());
    localEditText2.setLayoutParams(new ViewGroup.LayoutParams(400, 80));
    localEditText2.setText("" + this.jdField_a_of_type_Int);
    localLinearLayout.addView(localEditText1);
    localLinearLayout.addView(localEditText2);
    localBuilder.setView(localLinearLayout);
    localBuilder.setTitle("输入appid&type");
    localBuilder.setPositiveButton(HardCodeUtil.a(2131714724), new TestAppFragment.3(this, localEditText1, localEditText2)).setNegativeButton(HardCodeUtil.a(2131714728), new TestAppFragment.2(this));
    localBuilder.create().show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (FormSwitchItem)this.mContentView.findViewById(2131365742);
    paramLayoutInflater.setChecked(new File(this.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString).exists());
    paramLayoutInflater.setOnCheckedChangeListener(new TestAppFragment.1(this));
    this.mContentView.findViewById(2131368402).setOnClickListener(this);
    this.mContentView.findViewById(2131370817).setOnClickListener(this);
    this.mContentView.findViewById(2131370820).setOnClickListener(this);
    this.mContentView.findViewById(2131370818).setOnClickListener(this);
    this.mContentView.findViewById(2131367899).setOnClickListener(this);
    this.mContentView.findViewById(2131367897).setOnClickListener(this);
    this.mContentView.findViewById(2131364738).setOnClickListener(this);
    this.mContentView.findViewById(2131367900).setOnClickListener(this);
    this.mContentView.findViewById(2131367896).setOnClickListener(this);
    this.mContentView.findViewById(2131367898).setOnClickListener(this);
    this.mContentView.findViewById(2131376949).setOnClickListener(this);
    this.mContentView.findViewById(2131369146).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131372647));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131377040));
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131377039));
    DoraemonOpenAPI.a();
    this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = DoraemonOpenAPI.a(getActivity(), 3, "101480522");
  }
  
  public int getContentLayoutId()
  {
    return 2131559176;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(2);
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    Object localObject = new JSONObject();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("hello", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("login", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("loginSilent", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      localObject = new SdkAuthDialog(getActivity());
      ((SdkAuthDialog)localObject).c(HardCodeUtil.a(2131714726));
      ((SdkAuthDialog)localObject).b("appName");
      ((SdkAuthDialog)localObject).d("desc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\n");
      ((SdkAuthDialog)localObject).f("negativeButton");
      ((SdkAuthDialog)localObject).e("positiveButton");
      ((SdkAuthDialog)localObject).a(null);
      ((SdkAuthDialog)localObject).b(null);
      ((SdkAuthDialog)localObject).a("https://seeklogo.com/images/T/twitter-icon-square-logo-108D17D373-seeklogo.com.png");
      ((SdkAuthDialog)localObject).show();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getSkey", (JSONObject)localObject, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getUserInfo", (JSONObject)localObject, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getAppFriends", (JSONObject)localObject, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getLocation", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getCity", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      int i;
      switch (this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId())
      {
      default: 
        i = 0;
        label450:
        switch (this.jdField_b_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId())
        {
        default: 
          j = 0;
        }
        break;
      }
      try
      {
        ((JSONObject)localObject).put("rankingID", 11007);
        ((JSONObject)localObject).put("topCount", 11);
        ((JSONObject)localObject).put("rankKey", "");
        ((JSONObject)localObject).put("rankValueType", i);
        ((JSONObject)localObject).put("rankOrderType", j);
        label532:
        this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getRankingList", (JSONObject)localObject, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
        this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("loginSilent", null, new TestAppFragment.4(this, this.jdField_a_of_type_AndroidWidgetEditText, (JSONObject)localObject));
        continue;
        i = 1;
        break label450;
        i = 2;
        break label450;
        b();
        continue;
        a();
      }
      catch (JSONException localJSONException)
      {
        break label532;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.b();
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */