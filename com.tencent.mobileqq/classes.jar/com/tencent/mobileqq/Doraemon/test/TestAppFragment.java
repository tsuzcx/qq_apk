package com.tencent.mobileqq.Doraemon.test;

import aabp;
import aabu;
import aaeh;
import aaei;
import aaej;
import aaek;
import aael;
import aaen;
import aaeo;
import ajsf;
import ajyc;
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
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class TestAppFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public int a;
  public aabp a;
  public EditText a;
  private RadioGroup a;
  public String a;
  private RadioGroup b;
  public String b;
  public String c = "101469453";
  
  public TestAppFragment()
  {
    this.jdField_a_of_type_JavaLangString = (ajsf.aV + "/Tencent/com/tencent/mobileqq/");
    this.jdField_b_of_type_JavaLangString = "openapi";
    this.jdField_a_of_type_Int = 5;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Aabp.a("login", null, new aael(this));
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
    localBuilder.setPositiveButton(ajyc.a(2131714845), new aaej(this, localEditText1, localEditText2)).setNegativeButton(ajyc.a(2131714849), new aaei(this));
    localBuilder.create().show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (FormSwitchItem)this.mContentView.findViewById(2131365085);
    paramLayoutInflater.setChecked(new File(this.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString).exists());
    paramLayoutInflater.setOnCheckedChangeListener(new aaeh(this));
    this.mContentView.findViewById(2131367497).setOnClickListener(this);
    this.mContentView.findViewById(2131369562).setOnClickListener(this);
    this.mContentView.findViewById(2131369565).setOnClickListener(this);
    this.mContentView.findViewById(2131369563).setOnClickListener(this);
    this.mContentView.findViewById(2131367041).setOnClickListener(this);
    this.mContentView.findViewById(2131367039).setOnClickListener(this);
    this.mContentView.findViewById(2131364204).setOnClickListener(this);
    this.mContentView.findViewById(2131367042).setOnClickListener(this);
    this.mContentView.findViewById(2131367037).setOnClickListener(this);
    this.mContentView.findViewById(2131367040).setOnClickListener(this);
    this.mContentView.findViewById(2131375143).setOnClickListener(this);
    this.mContentView.findViewById(2131368191).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131371164));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131375230));
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131375229));
    aabu.a();
    this.jdField_a_of_type_Aabp = aabu.a(getActivity(), 3, "101480522");
  }
  
  public int getContentLayoutId()
  {
    return 2131558993;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(2);
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    int i;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367497: 
      this.jdField_a_of_type_Aabp.a("hello", null, new aaen(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131369562: 
      this.jdField_a_of_type_Aabp.a("login", null, new aaen(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131369565: 
      this.jdField_a_of_type_Aabp.a("loginSilent", null, new aaen(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131369563: 
      paramView = new aaeo(getActivity());
      paramView.c(ajyc.a(2131714847));
      paramView.b("appName");
      paramView.d("desc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\n");
      paramView.f("negativeButton");
      paramView.e("positiveButton");
      paramView.a(null);
      paramView.b(null);
      paramView.a("https://seeklogo.com/images/T/twitter-icon-square-logo-108D17D373-seeklogo.com.png");
      paramView.show();
      return;
    case 2131367041: 
      this.jdField_a_of_type_Aabp.a("getSkey", localJSONObject, new aaen(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367042: 
      this.jdField_a_of_type_Aabp.a("getUserInfo", localJSONObject, new aaen(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367037: 
      this.jdField_a_of_type_Aabp.a("getAppFriends", localJSONObject, new aaen(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367039: 
      this.jdField_a_of_type_Aabp.a("getLocation", null, new aaen(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364204: 
      this.jdField_a_of_type_Aabp.a("getCity", null, new aaen(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367040: 
      switch (this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId())
      {
      default: 
        i = 0;
      }
      break;
    }
    for (;;)
    {
      switch (this.jdField_b_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId())
      {
      default: 
        j = 0;
      }
      try
      {
        localJSONObject.put("rankingID", 11007);
        localJSONObject.put("topCount", 11);
        localJSONObject.put("rankKey", "");
        localJSONObject.put("rankValueType", i);
        localJSONObject.put("rankOrderType", j);
        label496:
        this.jdField_a_of_type_Aabp.a("getRankingList", localJSONObject, new aaen(this.jdField_a_of_type_AndroidWidgetEditText));
        this.jdField_a_of_type_Aabp.a("loginSilent", null, new aaek(this, this.jdField_a_of_type_AndroidWidgetEditText, localJSONObject));
        return;
        i = 1;
        continue;
        i = 2;
        continue;
        b();
        return;
        a();
        return;
      }
      catch (JSONException paramView)
      {
        break label496;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aabp != null)
    {
      this.jdField_a_of_type_Aabp.b();
      this.jdField_a_of_type_Aabp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */