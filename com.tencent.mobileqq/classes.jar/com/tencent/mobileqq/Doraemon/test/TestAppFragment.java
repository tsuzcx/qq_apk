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
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.Doraemon.ui.SdkAuthDialog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class TestAppFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  DoraemonAPIManager jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
  String jdField_a_of_type_JavaLangString;
  private RadioGroup jdField_b_of_type_AndroidWidgetRadioGroup;
  String jdField_b_of_type_JavaLangString;
  String c;
  
  public TestAppFragment()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Tencent/com/tencent/mobileqq/");
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_b_of_type_JavaLangString = "openapi";
    this.c = "101469453";
    this.jdField_a_of_type_Int = 5;
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("login", null, new TestAppFragment.6(this));
  }
  
  protected int a()
  {
    return 2131559070;
  }
  
  public void a()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getQBaseActivity());
    LinearLayout localLinearLayout = new LinearLayout(getQBaseActivity());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
    EditText localEditText1 = new EditText(getQBaseActivity());
    localEditText1.setLayoutParams(new ViewGroup.LayoutParams(400, 80));
    localEditText1.setText(this.c);
    EditText localEditText2 = new EditText(getQBaseActivity());
    localEditText2.setLayoutParams(new ViewGroup.LayoutParams(400, 80));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localEditText2.setText(localStringBuilder.toString());
    localLinearLayout.addView(localEditText1);
    localLinearLayout.addView(localEditText2);
    localBuilder.setView(localLinearLayout);
    localBuilder.setTitle("输入appid&type");
    localBuilder.setPositiveButton(HardCodeUtil.a(2131714655), new TestAppFragment.3(this, localEditText1, localEditText2)).setNegativeButton(HardCodeUtil.a(2131714659), new TestAppFragment.2(this));
    localBuilder.create().show();
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131365580);
    paramViewGroup = new StringBuilder();
    paramViewGroup.append(this.jdField_a_of_type_JavaLangString);
    paramViewGroup.append(this.jdField_b_of_type_JavaLangString);
    paramLayoutInflater.setChecked(new File(paramViewGroup.toString()).exists());
    paramLayoutInflater.setOnCheckedChangeListener(new TestAppFragment.1(this));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131368153).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131370448).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131370451).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131370449).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131367666).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131367664).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131364626).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131367667).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131367663).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131367665).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131376439).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131368878).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131372225));
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.jdField_b_of_type_AndroidViewView.findViewById(2131376520));
    this.jdField_b_of_type_AndroidWidgetRadioGroup = ((RadioGroup)this.jdField_b_of_type_AndroidViewView.findViewById(2131376519));
    ((IDoraemonService)QRoute.api(IDoraemonService.class)).prepare();
    this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(getQBaseActivity(), 3, "101480522");
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(2);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new JSONObject();
    int i = paramView.getId();
    int j;
    if (i == 2131368153)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("hello", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
    }
    else if (i == 2131370448)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("login", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
    }
    else if (i == 2131370451)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("loginSilent", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
    }
    else if (i == 2131370449)
    {
      localObject = new SdkAuthDialog(getQBaseActivity());
      ((SdkAuthDialog)localObject).c(HardCodeUtil.a(2131714657));
      ((SdkAuthDialog)localObject).b("appName");
      ((SdkAuthDialog)localObject).d("desc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\n");
      ((SdkAuthDialog)localObject).f("negativeButton");
      ((SdkAuthDialog)localObject).e("positiveButton");
      ((SdkAuthDialog)localObject).a(null);
      ((SdkAuthDialog)localObject).b(null);
      ((SdkAuthDialog)localObject).a("https://seeklogo.com/images/T/twitter-icon-square-logo-108D17D373-seeklogo.com.png");
      ((SdkAuthDialog)localObject).show();
    }
    else if (i == 2131367666)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getSkey", (JSONObject)localObject, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
    }
    else if (i == 2131367667)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getUserInfo", (JSONObject)localObject, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
    }
    else if (i == 2131367663)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getAppFriends", (JSONObject)localObject, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
    }
    else if (i == 2131367664)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getLocation", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
    }
    else if (i == 2131364626)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getCity", null, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
    }
    else if (i == 2131367665)
    {
      i = this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId();
      j = 1;
      if (i == 2131370719) {
        i = 1;
      } else if (i == 2131371039) {
        i = 2;
      } else {
        i = 0;
      }
      if (this.jdField_b_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId() != 2131372966) {
        j = 0;
      }
    }
    try
    {
      ((JSONObject)localObject).put("rankingID", 11007);
      ((JSONObject)localObject).put("topCount", 11);
      ((JSONObject)localObject).put("rankKey", "");
      ((JSONObject)localObject).put("rankValueType", i);
      ((JSONObject)localObject).put("rankOrderType", j);
      label468:
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("getRankingList", (JSONObject)localObject, new TestAppFragment.MyAPICallback(this.jdField_a_of_type_AndroidWidgetEditText));
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("loginSilent", null, new TestAppFragment.4(this, this.jdField_a_of_type_AndroidWidgetEditText, (JSONObject)localObject));
      break label542;
      if (i == 2131376439) {
        c();
      } else if (i == 2131368878) {
        a();
      }
      label542:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label468;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    DoraemonAPIManager localDoraemonAPIManager = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
    if (localDoraemonAPIManager != null)
    {
      localDoraemonAPIManager.b();
      this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */