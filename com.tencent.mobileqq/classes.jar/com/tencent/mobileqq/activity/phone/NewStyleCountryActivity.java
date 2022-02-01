package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.utils.PhoneCodeUtils.CountryCode;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class NewStyleCountryActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener, IndexView.OnIndexChangedListener
{
  IndexView a;
  ArrayList<PhoneCodeUtils.CountryCode> b = new ArrayList();
  LinkedHashMap<String, Integer> c = new LinkedHashMap();
  View d;
  View e;
  NewStyleCountryActivity.SearchDialog f;
  private PinnedDividerListView g;
  private NewStyleCountryActivity.CountryAdapter h;
  private View i;
  private EditText j;
  private String k;
  
  private View a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131629194, paramViewGroup, false);
    if (paramBoolean) {
      paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop(), (int)DisplayUtils.a(BaseApplication.getContext(), 40.0F), paramViewGroup.getPaddingBottom());
    }
    paramLayoutInflater = new NewStyleCountryActivity.ItemViewHolder(null);
    paramLayoutInflater.a = ((TextView)paramViewGroup.findViewById(2131431449));
    paramLayoutInflater.b = ((ImageView)paramViewGroup.findViewById(2131430679));
    paramViewGroup.setTag(paramLayoutInflater);
    return paramViewGroup;
  }
  
  public void a(View paramView)
  {
    paramView = (NewStyleCountryActivity.ItemViewHolder)paramView.getTag();
    if (paramView.c != null)
    {
      Object localObject = this.f;
      if ((localObject != null) && (((NewStyleCountryActivity.SearchDialog)localObject).isShowing()) && (!super.isFinishing())) {
        this.f.dismiss();
      }
      this.countryCode = paramView.c.d;
      localObject = new Intent();
      ((Intent)localObject).putExtra("k_name", paramView.c.c);
      ((Intent)localObject).putExtra("k_code", paramView.c.d);
      ((Intent)localObject).putExtra("k_english_name", paramView.c.e);
      setResult(-1, (Intent)localObject);
      finish();
    }
  }
  
  void a(View paramView, PhoneCodeUtils.CountryCode paramCountryCode)
  {
    paramView = (NewStyleCountryActivity.ItemViewHolder)paramView.getTag();
    paramView.a.setText(paramCountryCode.c);
    boolean bool = Utils.a(paramCountryCode.d, this.countryCode);
    int n = 0;
    int m;
    if ((bool) && (Utils.a(paramCountryCode.c, this.k))) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0) {
      m = n;
    } else {
      m = 8;
    }
    if (paramView.b.getVisibility() != m) {
      paramView.b.setVisibility(m);
    }
    paramView.c = paramCountryCode;
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
    super.doOnCreate(paramBundle);
    setContentView(2131629192);
    getWindow().setBackgroundDrawableResource(2131166409);
    setTitleText(2131914099);
    setBackListener();
    setProgressBarVisible(false);
    this.countryCode = getIntent().getStringExtra("k_code");
    this.k = getIntent().getStringExtra("k_name");
    String[] arrayOfString = getResources().getStringArray(2130968654);
    Object localObject = PhoneCodeUtils.b(Utils.b(this, "internationalCode.json"));
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = this.b;
    }
    this.b = paramBundle;
    localObject = PhoneCodeUtils.a(arrayOfString, this.b);
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = this.c;
    }
    this.c = paramBundle;
    this.d = findViewById(2131447564);
    this.e = ((View)this.d.getParent());
    this.g = ((PinnedDividerListView)findViewById(2131431450));
    this.g.setDivider(null);
    this.i = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131627764, this.g, false);
    this.i.findViewById(2131429816).setVisibility(8);
    this.j = ((EditText)this.i.findViewById(2131432634));
    this.j.setFocusableInTouchMode(false);
    this.j.setCursorVisible(false);
    this.j.setOnClickListener(this);
    AccessibilityUtil.b(this.i);
    this.g.addHeaderView(this.i);
    this.h = new NewStyleCountryActivity.CountryAdapter(this, null);
    this.g.setAdapter(this.h);
    this.a = ((IndexView)findViewById(2131435677));
    this.a.setIndex(arrayOfString, true);
    this.a.setOnIndexChangedListener(this);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.j)
    {
      this.f = new NewStyleCountryActivity.SearchDialog(this, this);
      this.f.setCanceledOnTouchOutside(true);
      int m = this.d.getHeight();
      float f1 = -m;
      TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, f1);
      localTranslateAnimation1.setDuration(300L);
      localTranslateAnimation1.setFillAfter(true);
      localTranslateAnimation1.setAnimationListener(new NewStyleCountryActivity.1(this));
      TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, f1, 0.0F);
      localTranslateAnimation2.setDuration(300L);
      localTranslateAnimation2.setAnimationListener(new NewStyleCountryActivity.2(this, m));
      this.f.setOnDismissListener(new NewStyleCountryActivity.3(this, m, localTranslateAnimation2));
      this.e.startAnimation(localTranslateAnimation1);
    }
    else
    {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.g.setSelection(0);
      return;
    }
    PinnedDividerListView localPinnedDividerListView = this.g;
    localPinnedDividerListView.setSelection(localPinnedDividerListView.getHeaderViewsCount() + ((Integer)this.c.get(paramString)).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.NewStyleCountryActivity
 * JD-Core Version:    0.7.0.1
 */