package com.tencent.mobileqq.Doraemon.test;

import aded;
import adei;
import adgv;
import adgw;
import adgx;
import adgy;
import adgz;
import adhb;
import adhc;
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
import anhk;
import anni;
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
  public aded a;
  public EditText a;
  private RadioGroup a;
  public String a;
  private RadioGroup b;
  public String b;
  public String c = "101469453";
  
  public TestAppFragment()
  {
    this.jdField_a_of_type_JavaLangString = (anhk.aZ + "/Tencent/com/tencent/mobileqq/");
    this.jdField_b_of_type_JavaLangString = "openapi";
    this.jdField_a_of_type_Int = 5;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Aded.a("login", null, new adgz(this));
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
    localBuilder.setPositiveButton(anni.a(2131713540), new adgx(this, localEditText1, localEditText2)).setNegativeButton(anni.a(2131713544), new adgw(this));
    localBuilder.create().show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (FormSwitchItem)this.mContentView.findViewById(2131365412);
    paramLayoutInflater.setChecked(new File(this.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString).exists());
    paramLayoutInflater.setOnCheckedChangeListener(new adgv(this));
    this.mContentView.findViewById(2131367942).setOnClickListener(this);
    this.mContentView.findViewById(2131370282).setOnClickListener(this);
    this.mContentView.findViewById(2131370285).setOnClickListener(this);
    this.mContentView.findViewById(2131370283).setOnClickListener(this);
    this.mContentView.findViewById(2131367470).setOnClickListener(this);
    this.mContentView.findViewById(2131367468).setOnClickListener(this);
    this.mContentView.findViewById(2131364478).setOnClickListener(this);
    this.mContentView.findViewById(2131367471).setOnClickListener(this);
    this.mContentView.findViewById(2131367466).setOnClickListener(this);
    this.mContentView.findViewById(2131367469).setOnClickListener(this);
    this.mContentView.findViewById(2131376403).setOnClickListener(this);
    this.mContentView.findViewById(2131368656).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131372066));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131376493));
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131376492));
    adei.a();
    this.jdField_a_of_type_Aded = adei.a(getActivity(), 3, "101480522");
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
      this.jdField_a_of_type_Aded.a("hello", null, new adhb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Aded.a("login", null, new adhb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Aded.a("loginSilent", null, new adhb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      localObject = new adhc(getActivity());
      ((adhc)localObject).c(anni.a(2131713542));
      ((adhc)localObject).b("appName");
      ((adhc)localObject).d("desc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\n");
      ((adhc)localObject).f("negativeButton");
      ((adhc)localObject).e("positiveButton");
      ((adhc)localObject).a(null);
      ((adhc)localObject).b(null);
      ((adhc)localObject).a("https://seeklogo.com/images/T/twitter-icon-square-logo-108D17D373-seeklogo.com.png");
      ((adhc)localObject).show();
      continue;
      this.jdField_a_of_type_Aded.a("getSkey", (JSONObject)localObject, new adhb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Aded.a("getUserInfo", (JSONObject)localObject, new adhb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Aded.a("getAppFriends", (JSONObject)localObject, new adhb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Aded.a("getLocation", null, new adhb(this.jdField_a_of_type_AndroidWidgetEditText));
      continue;
      this.jdField_a_of_type_Aded.a("getCity", null, new adhb(this.jdField_a_of_type_AndroidWidgetEditText));
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
        this.jdField_a_of_type_Aded.a("getRankingList", (JSONObject)localObject, new adhb(this.jdField_a_of_type_AndroidWidgetEditText));
        this.jdField_a_of_type_Aded.a("loginSilent", null, new adgy(this, this.jdField_a_of_type_AndroidWidgetEditText, (JSONObject)localObject));
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
    if (this.jdField_a_of_type_Aded != null)
    {
      this.jdField_a_of_type_Aded.b();
      this.jdField_a_of_type_Aded = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */