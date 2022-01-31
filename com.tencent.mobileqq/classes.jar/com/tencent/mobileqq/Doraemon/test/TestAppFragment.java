package com.tencent.mobileqq.Doraemon.test;

import aabl;
import aabq;
import aaed;
import aaee;
import aaef;
import aaeg;
import aaeh;
import aaej;
import aaek;
import ajsd;
import ajya;
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
  public aabl a;
  public EditText a;
  private RadioGroup a;
  public String a;
  private RadioGroup b;
  public String b;
  public String c = "101469453";
  
  public TestAppFragment()
  {
    this.jdField_a_of_type_JavaLangString = (ajsd.aV + "/Tencent/com/tencent/mobileqq/");
    this.jdField_b_of_type_JavaLangString = "openapi";
    this.jdField_a_of_type_Int = 5;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Aabl.a("login", null, new aaeh(this));
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
    localBuilder.setPositiveButton(ajya.a(2131714856), new aaef(this, localEditText1, localEditText2)).setNegativeButton(ajya.a(2131714860), new aaee(this));
    localBuilder.create().show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (FormSwitchItem)this.mContentView.findViewById(2131365084);
    paramLayoutInflater.setChecked(new File(this.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString).exists());
    paramLayoutInflater.setOnCheckedChangeListener(new aaed(this));
    this.mContentView.findViewById(2131367497).setOnClickListener(this);
    this.mContentView.findViewById(2131369561).setOnClickListener(this);
    this.mContentView.findViewById(2131369564).setOnClickListener(this);
    this.mContentView.findViewById(2131369562).setOnClickListener(this);
    this.mContentView.findViewById(2131367041).setOnClickListener(this);
    this.mContentView.findViewById(2131367039).setOnClickListener(this);
    this.mContentView.findViewById(2131364203).setOnClickListener(this);
    this.mContentView.findViewById(2131367042).setOnClickListener(this);
    this.mContentView.findViewById(2131367037).setOnClickListener(this);
    this.mContentView.findViewById(2131367040).setOnClickListener(this);
    this.mContentView.findViewById(2131375145).setOnClickListener(this);
    this.mContentView.findViewById(2131368191).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131371164));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131375232));
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131375231));
    aabq.a();
    this.jdField_a_of_type_Aabl = aabq.a(getActivity(), 3, "101480522");
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
      this.jdField_a_of_type_Aabl.a("hello", null, new aaej(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131369561: 
      this.jdField_a_of_type_Aabl.a("login", null, new aaej(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131369564: 
      this.jdField_a_of_type_Aabl.a("loginSilent", null, new aaej(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131369562: 
      paramView = new aaek(getActivity());
      paramView.c(ajya.a(2131714858));
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
      this.jdField_a_of_type_Aabl.a("getSkey", localJSONObject, new aaej(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367042: 
      this.jdField_a_of_type_Aabl.a("getUserInfo", localJSONObject, new aaej(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367037: 
      this.jdField_a_of_type_Aabl.a("getAppFriends", localJSONObject, new aaej(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131367039: 
      this.jdField_a_of_type_Aabl.a("getLocation", null, new aaej(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131364203: 
      this.jdField_a_of_type_Aabl.a("getCity", null, new aaej(this.jdField_a_of_type_AndroidWidgetEditText));
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
        this.jdField_a_of_type_Aabl.a("getRankingList", localJSONObject, new aaej(this.jdField_a_of_type_AndroidWidgetEditText));
        this.jdField_a_of_type_Aabl.a("loginSilent", null, new aaeg(this, this.jdField_a_of_type_AndroidWidgetEditText, localJSONObject));
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
    if (this.jdField_a_of_type_Aabl != null)
    {
      this.jdField_a_of_type_Aabl.b();
      this.jdField_a_of_type_Aabl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */