package com.tencent.mobileqq.activity.phone;

import aiif;
import aiig;
import aiih;
import aiii;
import aiij;
import aiil;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import bcvq;
import bdal;
import bdcq;
import bdes;
import bdet;
import bemh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.minigame.utils.AssetsUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class NewStyleCountryActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener, bemh
{
  private aiii jdField_a_of_type_Aiii;
  public aiil a;
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public IndexView a;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public ArrayList<bdet> a;
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
    paramViewGroup = paramLayoutInflater.inflate(2131562555, paramViewGroup, false);
    if (paramBoolean) {
      paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop(), (int)bdcq.a(BaseApplicationImpl.sApplication, 40.0F), paramViewGroup.getPaddingBottom());
    }
    paramLayoutInflater = new aiij(null);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364877));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131364250));
    paramViewGroup.setTag(paramLayoutInflater);
    return paramViewGroup;
  }
  
  public void a(View paramView)
  {
    paramView = (aiij)paramView.getTag();
    if (paramView.jdField_a_of_type_Bdet != null)
    {
      if ((this.jdField_a_of_type_Aiil != null) && (this.jdField_a_of_type_Aiil.isShowing()) && (!super.isFinishing())) {
        this.jdField_a_of_type_Aiil.dismiss();
      }
      this.jdField_b_of_type_JavaLangString = paramView.jdField_a_of_type_Bdet.c;
      Intent localIntent = new Intent();
      localIntent.putExtra("k_name", paramView.jdField_a_of_type_Bdet.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("k_code", paramView.jdField_a_of_type_Bdet.c);
      setResult(-1, localIntent);
      finish();
    }
  }
  
  public void a(View paramView, bdet parambdet)
  {
    int j = 0;
    paramView = (aiij)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(parambdet.jdField_b_of_type_JavaLangString);
    if ((bdal.a(parambdet.c, this.jdField_b_of_type_JavaLangString)) && (bdal.a(parambdet.jdField_b_of_type_JavaLangString, this.d)))
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
      paramView.jdField_a_of_type_Bdet = parambdet;
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131562553);
    getWindow().setBackgroundDrawableResource(2131165733);
    c(2131717542);
    b();
    a(false);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("k_code");
    this.d = getIntent().getStringExtra("k_name");
    String[] arrayOfString = getResources().getStringArray(2130968651);
    Object localObject = bdes.a(AssetsUtil.getContentFromAssets(this, "internationalCode.json"));
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle;
    localObject = bdes.a(arrayOfString, this.jdField_a_of_type_JavaUtilArrayList);
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap = paramBundle;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377960);
    this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364878));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setDivider(null);
    this.c = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131561230, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.c.findViewById(2131363520).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.c.findViewById(2131365849));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    bcvq.b(this.c);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.c);
    this.jdField_a_of_type_Aiii = new aiii(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Aiii);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368211));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(arrayOfString, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetEditText)
    {
      this.jdField_a_of_type_Aiil = new aiil(this, this);
      this.jdField_a_of_type_Aiil.setCanceledOnTouchOutside(true);
      int i = this.jdField_a_of_type_AndroidViewView.getHeight();
      paramView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
      paramView.setDuration(300L);
      paramView.setFillAfter(true);
      paramView.setAnimationListener(new aiif(this));
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new aiig(this, i));
      this.jdField_a_of_type_Aiil.setOnDismissListener(new aiih(this, i, localTranslateAnimation));
      this.jdField_b_of_type_AndroidViewView.startAnimation(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.NewStyleCountryActivity
 * JD-Core Version:    0.7.0.1
 */