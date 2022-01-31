package com.tencent.mobileqq.Doraemon.test;

import abwx;
import abxc;
import abzp;
import abzq;
import abzr;
import abzs;
import abzt;
import abzv;
import abzw;
import alof;
import alud;
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
  public abwx a;
  public EditText a;
  private RadioGroup a;
  public String a;
  private RadioGroup b;
  public String b;
  public String c = "101469453";
  
  public TestAppFragment()
  {
    this.jdField_a_of_type_JavaLangString = (alof.aW + "/Tencent/com/tencent/mobileqq/");
    this.jdField_b_of_type_JavaLangString = "openapi";
    this.jdField_a_of_type_Int = 5;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Abwx.a("login", null, new abzt(this));
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
    localBuilder.setPositiveButton(alud.a(2131715240), new abzr(this, localEditText1, localEditText2)).setNegativeButton(alud.a(2131715244), new abzq(this));
    localBuilder.create().show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (FormSwitchItem)this.mContentView.findViewById(2131365171);
    paramLayoutInflater.setChecked(new File(this.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString).exists());
    paramLayoutInflater.setOnCheckedChangeListener(new abzp(this));
    this.mContentView.findViewById(2131367635).setOnClickListener(this);
    this.mContentView.findViewById(2131369842).setOnClickListener(this);
    this.mContentView.findViewById(2131369845).setOnClickListener(this);
    this.mContentView.findViewById(2131369843).setOnClickListener(this);
    this.mContentView.findViewById(2131367178).setOnClickListener(this);
    this.mContentView.findViewById(2131367176).setOnClickListener(this);
    this.mContentView.findViewById(2131364267).setOnClickListener(this);
    this.mContentView.findViewById(2131367179).setOnClickListener(this);
    this.mContentView.findViewById(2131367174).setOnClickListener(this);
    this.mContentView.findViewById(2131367177).setOnClickListener(this);
    this.mContentView.findViewById(2131375677).setOnClickListener(this);
    this.mContentView.findViewById(2131368348).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131371495));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131375765));
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131375764));
    abxc.a();
    this.jdField_a_of_type_Abwx = abxc.a(getActivity(), 3, "101480522");
  }
  
  public int getContentLayoutId()
  {
    return 2131559031;
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
    case 2131367635: 
      this.jdField_a_of_type_Abwx.a("hello", null, new abzv(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131369842: 
      this.jdField_a_of_type_Abwx.a("login", null, new abzv(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131369845: 
      this.jdField_a_of_type_Abwx.a("loginSilent", null, new abzv(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131369843: 
      paramView = new abzw(getActivity());
      paramView.c(alud.a(2131715242));
      paramView.b("appName");
      paramView.d("desc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\n");
      paramView.f("negativeButton");
      paramView.e("positiveButton");
      paramView.a(null);
      paramView.b(null);
      paramView.a("https://seeklogo.com/images/T/twitter-icon-square-logo-108D17D373-seeklogo.com.png");
      paramView.show();
      return;
    case 2131367178: 
      this.jdField_a_of_type_Abwx.a("getSkey", localJSONObject, new abzv(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367179: 
      this.jdField_a_of_type_Abwx.a("getUserInfo", localJSONObject, new abzv(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367174: 
      this.jdField_a_of_type_Abwx.a("getAppFriends", localJSONObject, new abzv(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367176: 
      this.jdField_a_of_type_Abwx.a("getLocation", null, new abzv(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364267: 
      this.jdField_a_of_type_Abwx.a("getCity", null, new abzv(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367177: 
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
        this.jdField_a_of_type_Abwx.a("getRankingList", localJSONObject, new abzv(this.jdField_a_of_type_AndroidWidgetEditText));
        this.jdField_a_of_type_Abwx.a("loginSilent", null, new abzs(this, this.jdField_a_of_type_AndroidWidgetEditText, localJSONObject));
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
    if (this.jdField_a_of_type_Abwx != null)
    {
      this.jdField_a_of_type_Abwx.b();
      this.jdField_a_of_type_Abwx = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */