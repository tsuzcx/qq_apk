package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.regex.Pattern;

public class SearchBaseActivity
  extends BaseActivity
{
  public static final Pattern C = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
  public static final Pattern D = Pattern.compile("[^0-9]");
  public static final Pattern E = Pattern.compile("^1[0-9]{2}\\d{8}$");
  public final int B = 64;
  protected String F;
  protected int G;
  protected int H;
  Button I;
  ImageButton J;
  EditText K;
  ImageView L;
  SearchBaseFragment M;
  private int a;
  private Handler b = new SearchBaseActivity.5(this);
  
  protected boolean a(boolean paramBoolean, View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      if (paramView == null) {
        return false;
      }
      if (localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0))
      {
        if (paramBoolean) {
          paramView.clearFocus();
        }
        return true;
      }
    }
    return false;
  }
  
  protected void b()
  {
    Intent localIntent = getIntent();
    if (localIntent.hasExtra("from_key"))
    {
      this.G = localIntent.getIntExtra("from_key", 0);
      this.F = localIntent.getStringExtra("last_key_words");
      this.a = localIntent.getIntExtra("jump_src_key", 1);
    }
    if (localIntent.hasExtra("fromType")) {
      this.H = localIntent.getIntExtra("fromType", -1);
    }
  }
  
  protected void c()
  {
    this.I = ((Button)findViewById(2131429816));
    this.I.setTextColor(getResources().getColor(2131168002));
    this.I.setOnClickListener(new SearchBaseActivity.1(this));
    if (AppSetting.e)
    {
      Button localButton = this.I;
      localButton.setContentDescription(localButton.getText());
    }
    this.K = ((EditText)findViewById(2131432634));
    this.K.setHint(getResources().getString(2131886278));
    this.K.setFilters(new InputFilter[] { new InputFilter.LengthFilter(64) });
    this.K.setTextSize(0, getResources().getDimension(2131299845));
    this.K.setImeOptions(3);
    this.K.setSingleLine();
    this.K.setOnEditorActionListener(new SearchBaseActivity.2(this));
    this.J = ((ImageButton)findViewById(2131435215));
    this.J.setOnClickListener(new SearchBaseActivity.3(this));
    this.L = ((ImageView)findViewById(2131436275));
    if (AppSetting.e) {
      this.L.setContentDescription(HardCodeUtil.a(2131901576));
    }
    this.L.setOnClickListener(new SearchBaseActivity.4(this));
  }
  
  protected SearchBaseFragment d()
  {
    return new SearchBaseFragment();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.isClearCoverLayer = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131627775);
    paramBundle = super.findViewById(2131445137);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      paramBundle.setFitsSystemWindows(true);
    }
    super.getWindow().setBackgroundDrawable(null);
    b();
    c();
    this.M = d();
    paramBundle = this.M;
    if ((paramBundle instanceof ClassificationSearchFragment)) {
      ((ClassificationSearchFragment)paramBundle).b(this.H);
    }
    paramBundle = new Bundle();
    paramBundle.putInt("from_key", this.G);
    paramBundle.putString("last_key_words", this.F);
    paramBundle.putString("start_search_key", getIntent().getStringExtra("start_search_key"));
    paramBundle.putBoolean("auto_add_and_prohibit_auto_search", getIntent().getBooleanExtra("auto_add_and_prohibit_auto_search", false));
    this.M.setArguments(paramBundle);
    this.M.a(this.b);
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131431280, this.M);
    paramBundle.commit();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ViewFactory.a().b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    setContentBackgroundResource(2130838959);
  }
  
  public int f()
  {
    return this.a;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
 * JD-Core Version:    0.7.0.1
 */