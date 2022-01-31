package com.tencent.mobileqq.Doraemon.test;

import absi;
import absn;
import abva;
import abvb;
import abvc;
import abvd;
import abve;
import abvg;
import abvh;
import aljq;
import alpo;
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
  public absi a;
  public EditText a;
  private RadioGroup a;
  public String a;
  private RadioGroup b;
  public String b;
  public String c = "101469453";
  
  public TestAppFragment()
  {
    this.jdField_a_of_type_JavaLangString = (aljq.aW + "/Tencent/com/tencent/mobileqq/");
    this.jdField_b_of_type_JavaLangString = "openapi";
    this.jdField_a_of_type_Int = 5;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Absi.a("login", null, new abve(this));
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
    localBuilder.setPositiveButton(alpo.a(2131715228), new abvc(this, localEditText1, localEditText2)).setNegativeButton(alpo.a(2131715232), new abvb(this));
    localBuilder.create().show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (FormSwitchItem)this.mContentView.findViewById(2131365169);
    paramLayoutInflater.setChecked(new File(this.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString).exists());
    paramLayoutInflater.setOnCheckedChangeListener(new abva(this));
    this.mContentView.findViewById(2131367625).setOnClickListener(this);
    this.mContentView.findViewById(2131369823).setOnClickListener(this);
    this.mContentView.findViewById(2131369826).setOnClickListener(this);
    this.mContentView.findViewById(2131369824).setOnClickListener(this);
    this.mContentView.findViewById(2131367168).setOnClickListener(this);
    this.mContentView.findViewById(2131367166).setOnClickListener(this);
    this.mContentView.findViewById(2131364265).setOnClickListener(this);
    this.mContentView.findViewById(2131367169).setOnClickListener(this);
    this.mContentView.findViewById(2131367164).setOnClickListener(this);
    this.mContentView.findViewById(2131367167).setOnClickListener(this);
    this.mContentView.findViewById(2131375626).setOnClickListener(this);
    this.mContentView.findViewById(2131368337).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131371476));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131375714));
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131375713));
    absn.a();
    this.jdField_a_of_type_Absi = absn.a(getActivity(), 3, "101480522");
  }
  
  public int getContentLayoutId()
  {
    return 2131559032;
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
    case 2131367625: 
      this.jdField_a_of_type_Absi.a("hello", null, new abvg(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131369823: 
      this.jdField_a_of_type_Absi.a("login", null, new abvg(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131369826: 
      this.jdField_a_of_type_Absi.a("loginSilent", null, new abvg(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131369824: 
      paramView = new abvh(getActivity());
      paramView.c(alpo.a(2131715230));
      paramView.b("appName");
      paramView.d("desc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\n");
      paramView.f("negativeButton");
      paramView.e("positiveButton");
      paramView.a(null);
      paramView.b(null);
      paramView.a("https://seeklogo.com/images/T/twitter-icon-square-logo-108D17D373-seeklogo.com.png");
      paramView.show();
      return;
    case 2131367168: 
      this.jdField_a_of_type_Absi.a("getSkey", localJSONObject, new abvg(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367169: 
      this.jdField_a_of_type_Absi.a("getUserInfo", localJSONObject, new abvg(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367164: 
      this.jdField_a_of_type_Absi.a("getAppFriends", localJSONObject, new abvg(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367166: 
      this.jdField_a_of_type_Absi.a("getLocation", null, new abvg(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364265: 
      this.jdField_a_of_type_Absi.a("getCity", null, new abvg(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367167: 
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
        this.jdField_a_of_type_Absi.a("getRankingList", localJSONObject, new abvg(this.jdField_a_of_type_AndroidWidgetEditText));
        this.jdField_a_of_type_Absi.a("loginSilent", null, new abvd(this, this.jdField_a_of_type_AndroidWidgetEditText, localJSONObject));
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
    if (this.jdField_a_of_type_Absi != null)
    {
      this.jdField_a_of_type_Absi.b();
      this.jdField_a_of_type_Absi = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */