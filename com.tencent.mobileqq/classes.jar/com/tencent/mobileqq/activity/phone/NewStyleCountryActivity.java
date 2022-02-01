package com.tencent.mobileqq.activity.phone;

import Override;
import akoz;
import akpa;
import akpb;
import akpc;
import akpd;
import akpf;
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
import bhga;
import bhjx;
import bhmg;
import bhoe;
import bhof;
import biyw;
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
  implements View.OnClickListener, biyw
{
  private akpc jdField_a_of_type_Akpc;
  public akpf a;
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public IndexView a;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public ArrayList<bhof> a;
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
    paramViewGroup = paramLayoutInflater.inflate(2131562845, paramViewGroup, false);
    if (paramBoolean) {
      paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop(), (int)bhmg.a(BaseApplicationImpl.sApplication, 40.0F), paramViewGroup.getPaddingBottom());
    }
    paramLayoutInflater = new akpd(null);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365158));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131364505));
    paramViewGroup.setTag(paramLayoutInflater);
    return paramViewGroup;
  }
  
  public void a(View paramView)
  {
    paramView = (akpd)paramView.getTag();
    if (paramView.jdField_a_of_type_Bhof != null)
    {
      if ((this.jdField_a_of_type_Akpf != null) && (this.jdField_a_of_type_Akpf.isShowing()) && (!super.isFinishing())) {
        this.jdField_a_of_type_Akpf.dismiss();
      }
      this.jdField_b_of_type_JavaLangString = paramView.jdField_a_of_type_Bhof.c;
      Intent localIntent = new Intent();
      localIntent.putExtra("k_name", paramView.jdField_a_of_type_Bhof.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("k_code", paramView.jdField_a_of_type_Bhof.c);
      setResult(-1, localIntent);
      finish();
    }
  }
  
  public void a(View paramView, bhof parambhof)
  {
    int j = 0;
    paramView = (akpd)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(parambhof.jdField_b_of_type_JavaLangString);
    if ((bhjx.a(parambhof.c, this.jdField_b_of_type_JavaLangString)) && (bhjx.a(parambhof.jdField_b_of_type_JavaLangString, this.d)))
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
      paramView.jdField_a_of_type_Bhof = parambhof;
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131562843);
    getWindow().setBackgroundDrawableResource(2131165781);
    c(2131715898);
    b();
    a(false);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("k_code");
    this.d = getIntent().getStringExtra("k_name");
    String[] arrayOfString = getResources().getStringArray(2130968653);
    Object localObject = bhoe.a(AssetsUtil.getContentFromAssets(this, "internationalCode.json"));
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle;
    localObject = bhoe.a(arrayOfString, this.jdField_a_of_type_JavaUtilArrayList);
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap = paramBundle;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379018);
    this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131365159));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setDivider(null);
    this.c = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131561513, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.c.findViewById(2131363745).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.c.findViewById(2131366151));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    bhga.b(this.c);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.c);
    this.jdField_a_of_type_Akpc = new akpc(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Akpc);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368623));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(arrayOfString, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetEditText)
    {
      this.jdField_a_of_type_Akpf = new akpf(this, this);
      this.jdField_a_of_type_Akpf.setCanceledOnTouchOutside(true);
      int i = this.jdField_a_of_type_AndroidViewView.getHeight();
      TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
      localTranslateAnimation1.setDuration(300L);
      localTranslateAnimation1.setFillAfter(true);
      localTranslateAnimation1.setAnimationListener(new akoz(this));
      TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
      localTranslateAnimation2.setDuration(300L);
      localTranslateAnimation2.setAnimationListener(new akpa(this, i));
      this.jdField_a_of_type_Akpf.setOnDismissListener(new akpb(this, i, localTranslateAnimation2));
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