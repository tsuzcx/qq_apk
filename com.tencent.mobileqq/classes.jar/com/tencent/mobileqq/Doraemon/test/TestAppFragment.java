package com.tencent.mobileqq.Doraemon.test;

import ajed;
import ajjy;
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
import zrw;
import zsb;
import zuo;
import zup;
import zuq;
import zur;
import zus;
import zuu;
import zuv;

public class TestAppFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public int a;
  public EditText a;
  private RadioGroup a;
  public String a;
  public zrw a;
  private RadioGroup b;
  public String b;
  public String c = "101469453";
  
  public TestAppFragment()
  {
    this.jdField_a_of_type_JavaLangString = (ajed.aT + "/Tencent/com/tencent/mobileqq/");
    this.jdField_b_of_type_JavaLangString = "openapi";
    this.jdField_a_of_type_Int = 5;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Zrw.a("login", null, new zus(this));
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
    localBuilder.setPositiveButton(ajjy.a(2131649056), new zuq(this, localEditText1, localEditText2)).setNegativeButton(ajjy.a(2131649060), new zup(this));
    localBuilder.create().show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (FormSwitchItem)this.mContentView.findViewById(2131299517);
    paramLayoutInflater.setChecked(new File(this.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString).exists());
    paramLayoutInflater.setOnCheckedChangeListener(new zuo(this));
    this.mContentView.findViewById(2131301880).setOnClickListener(this);
    this.mContentView.findViewById(2131303887).setOnClickListener(this);
    this.mContentView.findViewById(2131303890).setOnClickListener(this);
    this.mContentView.findViewById(2131303888).setOnClickListener(this);
    this.mContentView.findViewById(2131301431).setOnClickListener(this);
    this.mContentView.findViewById(2131301429).setOnClickListener(this);
    this.mContentView.findViewById(2131298646).setOnClickListener(this);
    this.mContentView.findViewById(2131301432).setOnClickListener(this);
    this.mContentView.findViewById(2131301427).setOnClickListener(this);
    this.mContentView.findViewById(2131301430).setOnClickListener(this);
    this.mContentView.findViewById(2131309396).setOnClickListener(this);
    this.mContentView.findViewById(2131302571).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131305471));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131309482));
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.mContentView.findViewById(2131309481));
    zsb.a();
    this.jdField_a_of_type_Zrw = zsb.a(getActivity(), 3, "101480522");
  }
  
  public int getContentLayoutId()
  {
    return 2131493430;
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
    case 2131301880: 
      this.jdField_a_of_type_Zrw.a("hello", null, new zuu(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131303887: 
      this.jdField_a_of_type_Zrw.a("login", null, new zuu(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131303890: 
      this.jdField_a_of_type_Zrw.a("loginSilent", null, new zuu(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131303888: 
      paramView = new zuv(getActivity());
      paramView.c(ajjy.a(2131649058));
      paramView.b("appName");
      paramView.d("desc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\n");
      paramView.f("negativeButton");
      paramView.e("positiveButton");
      paramView.a(null);
      paramView.b(null);
      paramView.a("https://seeklogo.com/images/T/twitter-icon-square-logo-108D17D373-seeklogo.com.png");
      paramView.show();
      return;
    case 2131301431: 
      this.jdField_a_of_type_Zrw.a("getSkey", localJSONObject, new zuu(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131301432: 
      this.jdField_a_of_type_Zrw.a("getUserInfo", localJSONObject, new zuu(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131301427: 
      this.jdField_a_of_type_Zrw.a("getAppFriends", localJSONObject, new zuu(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131301429: 
      this.jdField_a_of_type_Zrw.a("getLocation", null, new zuu(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131298646: 
      this.jdField_a_of_type_Zrw.a("getCity", null, new zuu(this.jdField_a_of_type_AndroidWidgetEditText));
      return;
    case 2131301430: 
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
        this.jdField_a_of_type_Zrw.a("getRankingList", localJSONObject, new zuu(this.jdField_a_of_type_AndroidWidgetEditText));
        this.jdField_a_of_type_Zrw.a("loginSilent", null, new zur(this, this.jdField_a_of_type_AndroidWidgetEditText, localJSONObject));
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
    if (this.jdField_a_of_type_Zrw != null)
    {
      this.jdField_a_of_type_Zrw.b();
      this.jdField_a_of_type_Zrw = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */