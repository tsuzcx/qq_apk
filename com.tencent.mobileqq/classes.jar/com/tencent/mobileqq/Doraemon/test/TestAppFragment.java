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
  String a;
  String b;
  DoraemonAPIManager c;
  EditText d;
  String e;
  int f;
  private RadioGroup g;
  private RadioGroup w;
  
  public TestAppFragment()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Tencent/com/tencent/mobileqq/");
    this.a = localStringBuilder.toString();
    this.b = "openapi";
    this.e = "101469453";
    this.f = 5;
  }
  
  private void c()
  {
    this.c.a("login", null, new TestAppFragment.6(this));
  }
  
  protected int a()
  {
    return 2131624730;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (FormSwitchItem)this.t.findViewById(2131431807);
    paramViewGroup = new StringBuilder();
    paramViewGroup.append(this.a);
    paramViewGroup.append(this.b);
    paramLayoutInflater.setChecked(new File(paramViewGroup.toString()).exists());
    paramLayoutInflater.setOnCheckedChangeListener(new TestAppFragment.1(this));
    this.t.findViewById(2131435010).setOnClickListener(this);
    this.t.findViewById(2131437716).setOnClickListener(this);
    this.t.findViewById(2131437719).setOnClickListener(this);
    this.t.findViewById(2131437717).setOnClickListener(this);
    this.t.findViewById(2131434210).setOnClickListener(this);
    this.t.findViewById(2131434208).setOnClickListener(this);
    this.t.findViewById(2131430711).setOnClickListener(this);
    this.t.findViewById(2131434211).setOnClickListener(this);
    this.t.findViewById(2131434207).setOnClickListener(this);
    this.t.findViewById(2131434209).setOnClickListener(this);
    this.t.findViewById(2131444661).setOnClickListener(this);
    this.t.findViewById(2131435817).setOnClickListener(this);
    this.d = ((EditText)this.t.findViewById(2131439729));
    this.g = ((RadioGroup)this.t.findViewById(2131444767));
    this.w = ((RadioGroup)this.t.findViewById(2131444766));
    ((IDoraemonService)QRoute.api(IDoraemonService.class)).prepare();
    this.c = ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(getQBaseActivity(), 3, "101480522");
  }
  
  public void b()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getQBaseActivity());
    LinearLayout localLinearLayout = new LinearLayout(getQBaseActivity());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
    EditText localEditText1 = new EditText(getQBaseActivity());
    localEditText1.setLayoutParams(new ViewGroup.LayoutParams(400, 80));
    localEditText1.setText(this.e);
    EditText localEditText2 = new EditText(getQBaseActivity());
    localEditText2.setLayoutParams(new ViewGroup.LayoutParams(400, 80));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.f);
    localEditText2.setText(localStringBuilder.toString());
    localLinearLayout.addView(localEditText1);
    localLinearLayout.addView(localEditText2);
    localBuilder.setView(localLinearLayout);
    localBuilder.setTitle("输入appid&type");
    localBuilder.setPositiveButton(HardCodeUtil.a(2131912164), new TestAppFragment.3(this, localEditText1, localEditText2)).setNegativeButton(HardCodeUtil.a(2131912168), new TestAppFragment.2(this));
    localBuilder.create().show();
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
    if (i == 2131435010)
    {
      this.c.a("hello", null, new TestAppFragment.MyAPICallback(this.d));
    }
    else if (i == 2131437716)
    {
      this.c.a("login", null, new TestAppFragment.MyAPICallback(this.d));
    }
    else if (i == 2131437719)
    {
      this.c.a("loginSilent", null, new TestAppFragment.MyAPICallback(this.d));
    }
    else if (i == 2131437717)
    {
      localObject = new SdkAuthDialog(getQBaseActivity());
      ((SdkAuthDialog)localObject).c(HardCodeUtil.a(2131912166));
      ((SdkAuthDialog)localObject).b("appName");
      ((SdkAuthDialog)localObject).d("desc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\n");
      ((SdkAuthDialog)localObject).f("negativeButton");
      ((SdkAuthDialog)localObject).e("positiveButton");
      ((SdkAuthDialog)localObject).a(null);
      ((SdkAuthDialog)localObject).b(null);
      ((SdkAuthDialog)localObject).a("https://seeklogo.com/images/T/twitter-icon-square-logo-108D17D373-seeklogo.com.png");
      ((SdkAuthDialog)localObject).show();
    }
    else if (i == 2131434210)
    {
      this.c.a("getSkey", (JSONObject)localObject, new TestAppFragment.MyAPICallback(this.d));
    }
    else if (i == 2131434211)
    {
      this.c.a("getUserInfo", (JSONObject)localObject, new TestAppFragment.MyAPICallback(this.d));
    }
    else if (i == 2131434207)
    {
      this.c.a("getAppFriends", (JSONObject)localObject, new TestAppFragment.MyAPICallback(this.d));
    }
    else if (i == 2131434208)
    {
      this.c.a("getLocation", null, new TestAppFragment.MyAPICallback(this.d));
    }
    else if (i == 2131430711)
    {
      this.c.a("getCity", null, new TestAppFragment.MyAPICallback(this.d));
    }
    else if (i == 2131434209)
    {
      i = this.g.getCheckedRadioButtonId();
      j = 1;
      if (i == 2131438019) {
        i = 1;
      } else if (i == 2131438379) {
        i = 2;
      } else {
        i = 0;
      }
      if (this.w.getCheckedRadioButtonId() != 2131440534) {
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
      this.c.a("getRankingList", (JSONObject)localObject, new TestAppFragment.MyAPICallback(this.d));
      this.c.a("loginSilent", null, new TestAppFragment.4(this, this.d, (JSONObject)localObject));
      break label542;
      if (i == 2131444661) {
        c();
      } else if (i == 2131435817) {
        b();
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
    DoraemonAPIManager localDoraemonAPIManager = this.c;
    if (localDoraemonAPIManager != null)
    {
      localDoraemonAPIManager.b();
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */