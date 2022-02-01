package com.tencent.mobileqq.activity.phone;

import Override;
import akim;
import akin;
import akio;
import akip;
import akiq;
import akis;
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
import bgyd;
import bhbx;
import bhdz;
import bhft;
import bhfu;
import bipq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.minigame.utils.AssetsUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class NewStyleCountryActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener, bipq
{
  private akip jdField_a_of_type_Akip;
  public akis a;
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public IndexView a;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public ArrayList<bhfu> a;
  public LinkedHashMap<String, Integer> a;
  public View b;
  private View c;
  private String d;
  
  public NewStyleCountryActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  }
  
  private View a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131562795, paramViewGroup, false);
    if (paramBoolean) {
      paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop(), (int)bhdz.a(BaseApplicationImpl.sApplication, 40.0F), paramViewGroup.getPaddingBottom());
    }
    paramLayoutInflater = new akiq(null);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365269));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131364606));
    paramViewGroup.setTag(paramLayoutInflater);
    return paramViewGroup;
  }
  
  public void a(View paramView)
  {
    paramView = (akiq)paramView.getTag();
    if (paramView.jdField_a_of_type_Bhfu != null)
    {
      if ((this.jdField_a_of_type_Akis != null) && (this.jdField_a_of_type_Akis.isShowing()) && (!super.isFinishing())) {
        this.jdField_a_of_type_Akis.dismiss();
      }
      this.jdField_b_of_type_JavaLangString = paramView.jdField_a_of_type_Bhfu.c;
      Intent localIntent = new Intent();
      localIntent.putExtra("k_name", paramView.jdField_a_of_type_Bhfu.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("k_code", paramView.jdField_a_of_type_Bhfu.c);
      setResult(-1, localIntent);
      finish();
    }
  }
  
  public void a(View paramView, bhfu parambhfu)
  {
    int j = 0;
    paramView = (akiq)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(parambhfu.jdField_b_of_type_JavaLangString);
    if ((bhbx.a(parambhfu.c, this.jdField_b_of_type_JavaLangString)) && (bhbx.a(parambhfu.jdField_b_of_type_JavaLangString, this.d)))
    {
      i = 1;
      if (i == 0) {
        break label89;
      }
    }
    label89:
    for (int i = j;; i = 8)
    {
      if (paramView.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != i) {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(i);
      }
      paramView.jdField_a_of_type_Bhfu = parambhfu;
      return;
      i = 0;
      break;
    }
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    PinnedDividerListView localPinnedDividerListView = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount();
    localPinnedDividerListView.setSelection(((Integer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString)).intValue() + i);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131562793);
    getWindow().setBackgroundDrawableResource(2131165800);
    c(2131716488);
    b();
    a(false);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("k_code");
    this.d = getIntent().getStringExtra("k_name");
    String[] arrayOfString = getResources().getStringArray(2130968653);
    Object localObject = bhft.a(AssetsUtil.getContentFromAssets(this, "internationalCode.json"));
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle;
    localObject = bhft.a(arrayOfString, this.jdField_a_of_type_JavaUtilArrayList);
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap = paramBundle;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379081);
    this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131365270));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setDivider(null);
    this.c = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131561459, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.c.findViewById(2131363845).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.c.findViewById(2131366280));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    bgyd.b(this.c);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.c);
    this.jdField_a_of_type_Akip = new akip(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Akip);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368806));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(arrayOfString, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetEditText)
    {
      this.jdField_a_of_type_Akis = new akis(this, this);
      this.jdField_a_of_type_Akis.setCanceledOnTouchOutside(true);
      int i = this.jdField_a_of_type_AndroidViewView.getHeight();
      TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
      localTranslateAnimation1.setDuration(300L);
      localTranslateAnimation1.setFillAfter(true);
      localTranslateAnimation1.setAnimationListener(new akim(this));
      TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
      localTranslateAnimation2.setDuration(300L);
      localTranslateAnimation2.setAnimationListener(new akin(this, i));
      this.jdField_a_of_type_Akis.setOnDismissListener(new akio(this, i, localTranslateAnimation2));
      this.jdField_b_of_type_AndroidViewView.startAnimation(localTranslateAnimation1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.NewStyleCountryActivity
 * JD-Core Version:    0.7.0.1
 */