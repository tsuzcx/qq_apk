package com.tencent.mobileqq.Doraemon.test;

import adad;
import adai;
import adcv;
import adcw;
import adcx;
import adcy;
import adcz;
import addb;
import addc;
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
import anvx;
import com.tencent.mobileqq.app.AppConstants;
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
  public adad a;
  public EditText a;
  private RadioGroup a;
  public String a;
  private RadioGroup b;
  public String b;
  public String c = "101469453";
  
  public TestAppFragment()
  {
    this.jdField_a_of_type_JavaLangString = (AppConstants.SDCARD_ROOT + "/Tencent/com/tencent/mobileqq/");
    this.jdField_b_of_type_JavaLangString = "openapi";
    this.jdField_a_of_type_Int = 5;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Adad.a("login", null, new adcz(this));
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
    localBuilder.setPositiveButton(anvx.a(2131714228), new adcx(this, localEditText1, localEditText2)).setNegativeButton(anvx.a(2131714232), new adcw(this));
    localBuilder.create().show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (FormSwitchItem)this.mContentView.findViewById(2131365581);
    paramLayoutInflater.setChecked(new File(this.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString).exists());
    paramLayoutInflater.setOnCheckedChangeListener(new adcv(this));
    this.mContentView.findViewById(2131368180).setOnClickListener(this);
    this.mContentView.findViewById(2131370534).setOnClickListener(this);
    this.mContentView.findViewById(2131370537).setOnClickListener(this);
    this.mContentView.findViewById(2131370535).setOnClickListener(this);
    this.mContentView.findViewById(2131367692).setOnClickListener(this);
    this.mContentView.findViewById(2131367690).setOnClickListener(this);
    this.mContentView.findViewById(2131364624).setOnClickListener(this);
    this.mContentView.findViewById(2131367693).setOnClickListener(this);
    this.mContentView.findViewById(2131367689).setOnClickListener(this);
    this.mContentView.findViewById(2131367691).setOnClickListener(this);
    this.mContentView.findViewById(2131376556).setOnClickListener(this);
    this.mContentView.findViewById(2131368914).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131372337));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131376645));
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131376644));
    adai.a();
    this.jdField_a_of_type_Adad = adai.a(getActivity(), 3, "101480522");
  }
  
  public int getContentLayoutId()
  {
    return 2131559134;
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
      this.jdField_a_of_type_Adad.a("hello", null, new addb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Adad.a("login", null, new addb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Adad.a("loginSilent", null, new addb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      localObject = new addc(getActivity());
      ((addc)localObject).c(anvx.a(2131714230));
      ((addc)localObject).b("appName");
      ((addc)localObject).d("desc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\n");
      ((addc)localObject).f("negativeButton");
      ((addc)localObject).e("positiveButton");
      ((addc)localObject).a(null);
      ((addc)localObject).b(null);
      ((addc)localObject).a("https://seeklogo.com/images/T/twitter-icon-square-logo-108D17D373-seeklogo.com.png");
      ((addc)localObject).show();
      continue;
      this.jdField_a_of_type_Adad.a("getSkey", (JSONObject)localObject, new addb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Adad.a("getUserInfo", (JSONObject)localObject, new addb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Adad.a("getAppFriends", (JSONObject)localObject, new addb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Adad.a("getLocation", null, new addb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Adad.a("getCity", null, new addb(this.jdField_a_of_type_AndroidWidgetEditText));
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
        this.jdField_a_of_type_Adad.a("getRankingList", (JSONObject)localObject, new addb(this.jdField_a_of_type_AndroidWidgetEditText));
        this.jdField_a_of_type_Adad.a("loginSilent", null, new adcy(this, this.jdField_a_of_type_AndroidWidgetEditText, (JSONObject)localObject));
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
    if (this.jdField_a_of_type_Adad != null)
    {
      this.jdField_a_of_type_Adad.b();
      this.jdField_a_of_type_Adad = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */