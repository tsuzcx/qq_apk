package com.tencent.mobileqq.activity;

import Override;
import aege;
import aegf;
import amov;
import amsw;
import amtj;
import amvi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import apyy;
import apyz;
import aqgz;
import aqha;
import avjp;
import awfn;
import awfv;
import awfy;
import awgn;
import awgo;
import awgp;
import bcef;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.ArrayList;
import java.util.Iterator;

public class ShowReactiveActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int;
  amsw jdField_a_of_type_Amsw;
  Button jdField_a_of_type_AndroidWidgetButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aegf(this);
  FormMutiItem jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem a;
  TextView b;
  
  private FormMutiItem a(LayoutInflater paramLayoutInflater, LinearLayout paramLinearLayout, awgp paramawgp, FormMutiItem paramFormMutiItem, int paramInt)
  {
    Object localObject1 = paramFormMutiItem;
    if (paramawgp.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = paramFormMutiItem;
      if (paramawgp.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject1 = paramFormMutiItem;
        if (paramLayoutInflater != null)
        {
          localObject1 = a(paramInt);
          paramInt = ((Drawable)localObject1).getIntrinsicHeight();
          int i = ((Drawable)localObject1).getIntrinsicWidth();
          Iterator localIterator = paramawgp.jdField_a_of_type_JavaUtilArrayList.iterator();
          localObject1 = paramFormMutiItem;
          if (localIterator.hasNext())
          {
            awgo localawgo = (awgo)localIterator.next();
            localObject1 = (FormMutiItem)paramLayoutInflater.inflate(2131561451, null);
            if (!TextUtils.isEmpty(localawgo.jdField_b_of_type_JavaLangString))
            {
              Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ColorDrawable localColorDrawable = new ColorDrawable(0);
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localColorDrawable;
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localColorDrawable;
              localObject2 = URLDrawable.getDrawable(localawgo.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
              if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 2)) {
                ((URLDrawable)localObject2).restartDownload();
              }
              ((FormMutiItem)localObject1).setLeftIcon((Drawable)localObject2, i, paramInt);
            }
            ((FormMutiItem)localObject1).setFirstLineText(localawgo.a);
            ((FormMutiItem)localObject1).setSecondLineText(localawgo.d);
            if (a(paramawgp))
            {
              FormMutiItem.setNeedFocusBg(true);
              ((FormMutiItem)localObject1).setBgType(2);
              ((FormMutiItem)localObject1).setTag(paramawgp);
              ((FormMutiItem)localObject1).setOnClickListener(this);
              ((FormMutiItem)localObject1).setRightIcon(getResources().getDrawable(2130839422));
            }
            for (;;)
            {
              paramLinearLayout.addView((View)localObject1);
              if (paramFormMutiItem == null) {
                ((FormMutiItem)localObject1).setBgType(1);
              }
              paramFormMutiItem = (FormMutiItem)localObject1;
              break;
              FormMutiItem.setNeedFocusBg(false);
              ((FormMutiItem)localObject1).setBgType(2);
              ((FormMutiItem)localObject1).setSecondLineTextViewPaddingRight(AIOUtils.dp2px(12.0F, getResources()));
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  private void a()
  {
    setLeftViewName(2131690424);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131362644));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131362655));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131362656));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131371568));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)a(2131363585));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131376168));
    this.b = ((TextView)a(2131376169));
    apyy localapyy = apyz.a();
    boolean bool;
    label159:
    LayoutInflater localLayoutInflater;
    label265:
    Object localObject2;
    int i;
    FormMutiItem localFormMutiItem;
    if (!TextUtils.isEmpty(localapyy.e))
    {
      if (amvi.a()) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localapyy.e);
      }
    }
    else
    {
      bool = ((amsw)this.app.getManager(51)).a(false);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (bool) {
        break label466;
      }
      bool = true;
      ((FormSwitchItem)localObject1).setChecked(bool);
      ((amov)this.app.getBusinessHandler(2)).o();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        bcef.b(null, "dc00898", "", "", "0X800A1FC", "0X800A1FC", 0, 0, "", "", "", "");
      }
      localObject1 = awfn.a(this.app);
      localLayoutInflater = LayoutInflater.from(this);
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      localObject1 = null;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (awgp)localIterator.next();
        i = awfn.a(this.app, null, ((awgp)localObject2).jdField_a_of_type_Long, ((awgp)localObject2).jdField_b_of_type_Long, true);
      } while (i == 0);
      localFormMutiItem = (FormMutiItem)localLayoutInflater.inflate(2131561451, null);
      localFormMutiItem.setLeftIcon(a(i));
      localFormMutiItem.setFirstLineText(((awgp)localObject2).jdField_b_of_type_JavaLangString);
      localFormMutiItem.setSecondLineText(((awgp)localObject2).c);
      if (!a((awgp)localObject2)) {
        break label471;
      }
      FormMutiItem.setNeedFocusBg(true);
      localFormMutiItem.setBgType(2);
      localFormMutiItem.setTag(localObject2);
      localFormMutiItem.setOnClickListener(this);
      localFormMutiItem.setRightIcon(getResources().getDrawable(2130839422));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormMutiItem);
      if (localObject1 == null) {
        localFormMutiItem.setBgType(1);
      }
      localObject2 = a(localLayoutInflater, this.jdField_a_of_type_AndroidWidgetLinearLayout, (awgp)localObject2, localFormMutiItem, i);
      localObject1 = localFormMutiItem;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      break label265;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131690608));
      break;
      label466:
      bool = false;
      break label159;
      label471:
      FormMutiItem.setNeedFocusBg(false);
      localFormMutiItem.setBgType(2);
      localFormMutiItem.setSecondLineTextViewPaddingRight(AIOUtils.dp2px(12.0F, getResources()));
    }
    if (localObject1 != null) {
      ((FormMutiItem)localObject1).setBgType(3);
    }
    Object localObject1 = new awfv(this, 2130850114);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon((Drawable)localObject1);
    ((awfv)localObject1).a("");
    if (!TextUtils.isEmpty(localapyy.f)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(localapyy.f);
    }
    if (!TextUtils.isEmpty(localapyy.g)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText(localapyy.g);
    }
    localObject1 = aqha.c();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aege(this, (aqgz)localObject1));
    if (((aqgz)localObject1).a)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.b.setVisibility(0);
    }
    for (;;)
    {
      if (AppSetting.c) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718219));
      }
      avjp.a("1", "1", "1", LpReportInfo_dc03950.getReportUserType(this.app));
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.b.setVisibility(8);
    }
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    startActivity(localIntent);
  }
  
  private boolean a(awgp paramawgp)
  {
    return (paramawgp.jdField_a_of_type_Awgn != null) && (!TextUtils.isEmpty(paramawgp.jdField_a_of_type_Awgn.jdField_b_of_type_JavaLangString));
  }
  
  protected Drawable a(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt);
    ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
    return localDrawable;
  }
  
  public <T extends View> T a(int paramInt)
  {
    return findViewById(paramInt);
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
    super.setContentView(2131561450);
    setTitle(2131690607);
    this.jdField_a_of_type_Amsw = ((amsw)this.app.getManager(51));
    this.jdField_a_of_type_Int = getIntent().getIntExtra("entry", 1);
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    bcef.b(null, "dc00898", "", "", "0X800A1FB", "0X800A1FB", 0, 0, "", "", "", "");
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      QQToast.a(getApplicationContext(), 2131718207, 1).a();
      bool1 = bool2;
      if (!paramBoolean) {
        bool1 = true;
      }
      a(paramCompoundButton, bool1);
    }
    while (paramCompoundButton != this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    Object localObject = this.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      label81:
      bcef.b((QQAppInterface)localObject, "CliOper", "", "", "0X8007021", "0X8007021", 0, 0, String.valueOf(i), "", "", "");
      localObject = (amov)this.app.getBusinessHandler(2);
      if (paramBoolean) {
        break label148;
      }
    }
    for (;;)
    {
      ((amov)localObject).j(bool1);
      break;
      i = 0;
      break label81;
      label148:
      bool1 = false;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView.getId() == 2131362644)
    {
      bcef.b(null, "dc00898", "", "", "0X800A1FD", "0X800A1FD", 0, 0, "", "", "", "");
      localObject = apyz.a().a();
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("finish_animation_out_to_right", true);
      localIntent.putExtra("is_wrap_content", true);
      localIntent.putExtra("hide_left_button", false);
      startActivity(localIntent);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView.getTag() != null) && ((paramView.getTag() instanceof awgp)))
      {
        localObject = (awgp)paramView.getTag();
        if (localObject != null) {
          if (((awgp)localObject).jdField_a_of_type_Long == 7L) {
            avjp.a(this.app, this, 2087, "1");
          } else if ((((awgp)localObject).jdField_a_of_type_Awgn != null) && (!TextUtils.isEmpty(((awgp)localObject).jdField_a_of_type_Awgn.jdField_b_of_type_JavaLangString))) {
            a(awfy.a(((awgp)localObject).jdField_a_of_type_Awgn.jdField_b_of_type_JavaLangString));
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShowReactiveActivity
 * JD-Core Version:    0.7.0.1
 */