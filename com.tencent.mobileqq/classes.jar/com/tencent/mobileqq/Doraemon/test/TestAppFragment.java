package com.tencent.mobileqq.Doraemon.test;

import acju;
import acjz;
import acmm;
import acmn;
import acmo;
import acmp;
import acmq;
import acms;
import acmt;
import amtj;
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
  public acju a;
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
    this.jdField_a_of_type_Acju.a("login", null, new acmq(this));
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
    localBuilder.setPositiveButton(amtj.a(2131713881), new acmo(this, localEditText1, localEditText2)).setNegativeButton(amtj.a(2131713885), new acmn(this));
    localBuilder.create().show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (FormSwitchItem)this.mContentView.findViewById(2131365488);
    paramLayoutInflater.setChecked(new File(this.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString).exists());
    paramLayoutInflater.setOnCheckedChangeListener(new acmm(this));
    this.mContentView.findViewById(2131368045).setOnClickListener(this);
    this.mContentView.findViewById(2131370351).setOnClickListener(this);
    this.mContentView.findViewById(2131370354).setOnClickListener(this);
    this.mContentView.findViewById(2131370352).setOnClickListener(this);
    this.mContentView.findViewById(2131367560).setOnClickListener(this);
    this.mContentView.findViewById(2131367558).setOnClickListener(this);
    this.mContentView.findViewById(2131364542).setOnClickListener(this);
    this.mContentView.findViewById(2131367561).setOnClickListener(this);
    this.mContentView.findViewById(2131367557).setOnClickListener(this);
    this.mContentView.findViewById(2131367559).setOnClickListener(this);
    this.mContentView.findViewById(2131376301).setOnClickListener(this);
    this.mContentView.findViewById(2131368755).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131372145));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131376390));
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131376389));
    acjz.a();
    this.jdField_a_of_type_Acju = acjz.a(getActivity(), 3, "101480522");
  }
  
  public int getContentLayoutId()
  {
    return 2131559106;
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
      this.jdField_a_of_type_Acju.a("hello", null, new acms(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Acju.a("login", null, new acms(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Acju.a("loginSilent", null, new acms(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      localObject = new acmt(getActivity());
      ((acmt)localObject).c(amtj.a(2131713883));
      ((acmt)localObject).b("appName");
      ((acmt)localObject).d("desc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\n");
      ((acmt)localObject).f("negativeButton");
      ((acmt)localObject).e("positiveButton");
      ((acmt)localObject).a(null);
      ((acmt)localObject).b(null);
      ((acmt)localObject).a("https://seeklogo.com/images/T/twitter-icon-square-logo-108D17D373-seeklogo.com.png");
      ((acmt)localObject).show();
      continue;
      this.jdField_a_of_type_Acju.a("getSkey", (JSONObject)localObject, new acms(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Acju.a("getUserInfo", (JSONObject)localObject, new acms(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Acju.a("getAppFriends", (JSONObject)localObject, new acms(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Acju.a("getLocation", null, new acms(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Acju.a("getCity", null, new acms(this.jdField_a_of_type_AndroidWidgetEditText));
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
        this.jdField_a_of_type_Acju.a("getRankingList", (JSONObject)localObject, new acms(this.jdField_a_of_type_AndroidWidgetEditText));
        this.jdField_a_of_type_Acju.a("loginSilent", null, new acmp(this, this.jdField_a_of_type_AndroidWidgetEditText, (JSONObject)localObject));
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
    if (this.jdField_a_of_type_Acju != null)
    {
      this.jdField_a_of_type_Acju.b();
      this.jdField_a_of_type_Acju = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */