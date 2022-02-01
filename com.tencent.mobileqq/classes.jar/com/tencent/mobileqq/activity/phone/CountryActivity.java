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
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.AssetsUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.utils.PhoneCodeUtils.CountryCode;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CountryActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IndexView.OnIndexChangedListener
{
  IndexView a;
  ArrayList<PhoneCodeUtils.CountryCode> b = new ArrayList();
  LinkedHashMap<String, Integer> c = new LinkedHashMap();
  View d;
  View e;
  CountryActivity.SearchDialog f;
  private PinnedDividerListView g;
  private CountryActivity.CountryAdapter h;
  private View i;
  private EditText j;
  
  static void a(View paramView, PhoneCodeUtils.CountryCode paramCountryCode)
  {
    paramView = (CountryActivity.ItemViewHolder)paramView.getTag();
    paramView.a.setText(paramCountryCode.c);
    TextView localTextView = paramView.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("+");
    localStringBuilder.append(paramCountryCode.d);
    localTextView.setText(localStringBuilder.toString());
    paramView.c = paramCountryCode;
  }
  
  private static View b(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131625568, paramViewGroup, false);
    if (paramBoolean) {
      paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop(), (int)DisplayUtils.a(BaseApplicationImpl.sApplication, 40.0F), paramViewGroup.getPaddingBottom());
    }
    paramLayoutInflater = new CountryActivity.ItemViewHolder(null);
    paramLayoutInflater.a = ((TextView)paramViewGroup.findViewById(2131431449));
    paramLayoutInflater.b = ((TextView)paramViewGroup.findViewById(2131431448));
    paramViewGroup.setTag(paramLayoutInflater);
    return paramViewGroup;
  }
  
  public void a(View paramView)
  {
    paramView = (CountryActivity.ItemViewHolder)paramView.getTag();
    if (paramView.c != null)
    {
      Object localObject = this.f;
      if ((localObject != null) && (((CountryActivity.SearchDialog)localObject).isShowing()) && (!super.isFinishing())) {
        this.f.dismiss();
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("k_name", paramView.c.c);
      ((Intent)localObject).putExtra("k_code", paramView.c.d);
      setResult(-1, (Intent)localObject);
      finish();
    }
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
    setContentView(2131625566);
    String[] arrayOfString = getResources().getStringArray(2130968654);
    Object localObject = PhoneCodeUtils.b(AssetsUtil.a(this, "internationalCode.json"));
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
    setTitle(HardCodeUtil.a(2131900770));
    this.leftView.setText(2131887625);
    this.d = findViewById(2131444897);
    this.e = ((View)this.d.getParent());
    this.g = ((PinnedDividerListView)findViewById(2131431450));
    this.i = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131629215, this.g, false);
    this.i.setPadding(0, 0, 40, 0);
    this.i.findViewById(2131429816).setVisibility(8);
    this.j = ((EditText)this.i.findViewById(2131432634));
    this.j.setFocusableInTouchMode(false);
    this.j.setCursorVisible(false);
    this.j.setOnClickListener(this);
    AccessibilityUtil.b(this.i);
    this.g.addHeaderView(this.i);
    this.h = new CountryActivity.CountryAdapter(this, null);
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
      this.f = new CountryActivity.SearchDialog(this, this);
      this.f.setCanceledOnTouchOutside(true);
      int k = this.d.getHeight();
      float f1 = -k;
      TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, f1);
      localTranslateAnimation1.setDuration(300L);
      localTranslateAnimation1.setFillAfter(true);
      localTranslateAnimation1.setAnimationListener(new CountryActivity.1(this));
      TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, f1, 0.0F);
      localTranslateAnimation2.setDuration(300L);
      localTranslateAnimation2.setAnimationListener(new CountryActivity.2(this, k));
      this.f.setOnDismissListener(new CountryActivity.3(this, k, localTranslateAnimation2));
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
 * Qualified Name:     com.tencent.mobileqq.activity.phone.CountryActivity
 * JD-Core Version:    0.7.0.1
 */