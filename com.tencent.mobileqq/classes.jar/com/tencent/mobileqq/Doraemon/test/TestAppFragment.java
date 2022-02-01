package com.tencent.mobileqq.Doraemon.test;

import adnb;
import adng;
import adpt;
import adpu;
import adpv;
import adpw;
import adpx;
import adpz;
import adqa;
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
import antf;
import anzj;
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
  public int a;
  public adnb a;
  public EditText a;
  private RadioGroup a;
  public String a;
  private RadioGroup b;
  public String b;
  public String c = "101469453";
  
  public TestAppFragment()
  {
    this.jdField_a_of_type_JavaLangString = (antf.aZ + "/Tencent/com/tencent/mobileqq/");
    this.jdField_b_of_type_JavaLangString = "openapi";
    this.jdField_a_of_type_Int = 5;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Adnb.a("login", null, new adpx(this));
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
    localBuilder.setPositiveButton(anzj.a(2131713649), new adpv(this, localEditText1, localEditText2)).setNegativeButton(anzj.a(2131713653), new adpu(this));
    localBuilder.create().show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (FormSwitchItem)this.mContentView.findViewById(2131365456);
    paramLayoutInflater.setChecked(new File(this.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString).exists());
    paramLayoutInflater.setOnCheckedChangeListener(new adpt(this));
    this.mContentView.findViewById(2131368012).setOnClickListener(this);
    this.mContentView.findViewById(2131370383).setOnClickListener(this);
    this.mContentView.findViewById(2131370386).setOnClickListener(this);
    this.mContentView.findViewById(2131370384).setOnClickListener(this);
    this.mContentView.findViewById(2131367532).setOnClickListener(this);
    this.mContentView.findViewById(2131367530).setOnClickListener(this);
    this.mContentView.findViewById(2131364523).setOnClickListener(this);
    this.mContentView.findViewById(2131367533).setOnClickListener(this);
    this.mContentView.findViewById(2131367528).setOnClickListener(this);
    this.mContentView.findViewById(2131367531).setOnClickListener(this);
    this.mContentView.findViewById(2131376535).setOnClickListener(this);
    this.mContentView.findViewById(2131368730).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131372180));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131376625));
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131376624));
    adng.a();
    this.jdField_a_of_type_Adnb = adng.a(getActivity(), 3, "101480522");
  }
  
  public int getContentLayoutId()
  {
    return 2131559098;
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
      this.jdField_a_of_type_Adnb.a("hello", null, new adpz(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Adnb.a("login", null, new adpz(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Adnb.a("loginSilent", null, new adpz(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      localObject = new adqa(getActivity());
      ((adqa)localObject).c(anzj.a(2131713651));
      ((adqa)localObject).b("appName");
      ((adqa)localObject).d("desc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\n");
      ((adqa)localObject).f("negativeButton");
      ((adqa)localObject).e("positiveButton");
      ((adqa)localObject).a(null);
      ((adqa)localObject).b(null);
      ((adqa)localObject).a("https://seeklogo.com/images/T/twitter-icon-square-logo-108D17D373-seeklogo.com.png");
      ((adqa)localObject).show();
      continue;
      this.jdField_a_of_type_Adnb.a("getSkey", (JSONObject)localObject, new adpz(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Adnb.a("getUserInfo", (JSONObject)localObject, new adpz(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Adnb.a("getAppFriends", (JSONObject)localObject, new adpz(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Adnb.a("getLocation", null, new adpz(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Adnb.a("getCity", null, new adpz(this.jdField_a_of_type_AndroidWidgetEditText));
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
        this.jdField_a_of_type_Adnb.a("getRankingList", (JSONObject)localObject, new adpz(this.jdField_a_of_type_AndroidWidgetEditText));
        this.jdField_a_of_type_Adnb.a("loginSilent", null, new adpw(this, this.jdField_a_of_type_AndroidWidgetEditText, (JSONObject)localObject));
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
    if (this.jdField_a_of_type_Adnb != null)
    {
      this.jdField_a_of_type_Adnb.b();
      this.jdField_a_of_type_Adnb = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */