package com.tencent.biz.qqstory.settings;

import Override;
import agej;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anyw;
import anzj;
import bhnv;
import bjbv;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import win;
import wja;
import wjb;
import wjd;
import yah;
import yor;
import yup;

public class QQStoryShieldActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int = 3;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public bjbv a;
  public Switch a;
  String jdField_a_of_type_JavaLangString;
  wja jdField_a_of_type_Wja;
  wjb jdField_a_of_type_Wjb;
  wjd jdField_a_of_type_Wjd = new yah(this);
  View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
  public Switch b;
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2131561643, null);
    ((TextView)localView.findViewById(2131378936)).setText(paramString);
    ((TextView)localView.findViewById(2131368636)).setText("");
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Wja.a(this.jdField_a_of_type_JavaLangString);
    super.startTitleProgress();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = super.getIntent().getStringExtra("uin");
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("from", 3);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      super.finish();
      return false;
    }
    this.jdField_a_of_type_Wjb = ((wjb)this.app.getManager(181));
    this.jdField_a_of_type_Wja = ((wja)this.app.a(98));
    this.app.addObserver(this.jdField_a_of_type_Wjd);
    paramBundle = new LinearLayout(this);
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.setBackgroundResource(2130838779);
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramBundle.setOrientation(1);
    paramBundle.setPadding(0, agej.a(20.0F, getResources()), 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup = paramBundle;
    paramBundle = a(0, anzj.a(2131709910));
    paramBundle.setBackgroundResource(2130839447);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 2)) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new FormSwitchItem(this, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = paramBundle;
    paramBundle.setText(anzj.a(2131709928) + win.b);
    paramBundle.setContentDescription(anzj.a(2131709897) + win.b);
    paramBundle.setBgType(2);
    paramBundle.setTag(Integer.valueOf(1));
    paramBundle.a().setTextSize(1, 18.0F);
    paramBundle.setFocusable(true);
    this.b = paramBundle.a();
    this.b.setTag(Integer.valueOf(1));
    this.b.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    paramBundle = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
    if ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 2)) {
      paramBundle.topMargin = agej.a(20.0F, getResources());
    }
    paramBundle = new FormSwitchItem(this, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = paramBundle;
    paramBundle.setText(anzj.a(2131709914) + win.b);
    paramBundle.setContentDescription(anzj.a(2131709885) + win.b);
    paramBundle.setBgType(3);
    paramBundle.setTag(Integer.valueOf(2));
    paramBundle.a().setTextSize(1, 18.0F);
    paramBundle.setFocusable(true);
    this.jdField_a_of_type_ComTencentWidgetSwitch = paramBundle.a();
    this.jdField_a_of_type_ComTencentWidgetSwitch.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    paramBundle = this.jdField_a_of_type_Wjb.a(this.jdField_a_of_type_JavaLangString);
    boolean bool;
    if (paramBundle != null)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
      if (paramBundle.isAllowed == 1)
      {
        bool = true;
        ((Switch)localObject).setChecked(bool);
        localObject = this.b;
        if (paramBundle.isInterested != 1) {
          break label717;
        }
        bool = true;
        label558:
        ((Switch)localObject).setChecked(bool);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      this.b.setOnCheckedChangeListener(this);
      super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
      if (this.jdField_a_of_type_Int != 3) {
        break label722;
      }
      super.setTitle(win.jdField_a_of_type_JavaLangString + anzj.a(2131709886));
      label624:
      this.jdField_a_of_type_Bjbv = new bjbv(this, 2131561501);
      if (bhnv.g(this)) {
        break label801;
      }
      QQToast.a(this, 1, anzj.a(2131709882), 0).b(getTitleBarHeight());
      super.startTitleProgress();
    }
    for (;;)
    {
      yup.a("friend_story_settings", "exp_set", this.jdField_a_of_type_Int, 0, new String[] { "2", "", "", "" });
      return true;
      bool = false;
      break;
      label717:
      bool = false;
      break label558;
      label722:
      if (this.jdField_a_of_type_Int == 2)
      {
        if (QQStoryContext.a().a(this.jdField_a_of_type_JavaLangString))
        {
          super.setTitle(win.jdField_a_of_type_JavaLangString + anzj.a(2131709927));
          break label624;
        }
        super.setTitle(anzj.a(2131709906));
        break label624;
      }
      super.setTitle(anzj.a(2131709923));
      break label624;
      label801:
      this.jdField_a_of_type_Wja.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Wjd);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    yor.a(this.app);
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = ((Integer)paramCompoundButton.getTag()).intValue();
    if (!bhnv.g(this)) {
      QQToast.a(this, 1, anzj.a(2131709925), 0).b(getTitleBarHeight());
    }
    for (int i = 0;; i = 1)
    {
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(this.jdField_a_of_type_JavaLangString);
      switch (j)
      {
      default: 
        if (j == 2) {
          if (paramBoolean)
          {
            localObject = "open_notletsee";
            label99:
            if (this.jdField_a_of_type_Int != 3) {
              break label296;
            }
            yup.a("person_data_set", (String)localObject, 0, 0, new String[] { "", "", "", "" });
          }
        }
        break;
      }
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        if (i != 0)
        {
          this.jdField_a_of_type_Wja.a((ArrayList)localObject, true, paramBoolean);
          this.jdField_a_of_type_Bjbv.b(0, 2131717414, 0);
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!paramBoolean) {}
        for (boolean bool = true;; bool = false)
        {
          ((Switch)localObject).setChecked(bool);
          break;
        }
        if (i != 0)
        {
          this.jdField_a_of_type_Wja.a((ArrayList)localObject, false, paramBoolean);
          this.jdField_a_of_type_Bjbv.b(0, 2131717414, 0);
          break;
        }
        localObject = this.b;
        if (!paramBoolean) {}
        for (bool = true;; bool = false)
        {
          ((Switch)localObject).setChecked(bool);
          break;
        }
        localObject = "close_notletsee";
        break label99;
        if (paramBoolean)
        {
          localObject = "open_notsee";
          break label99;
        }
        localObject = "close_notsee";
        break label99;
        label296:
        yup.a("list_settings", (String)localObject, 0, 0, new String[] { "", "", "", "" });
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (((Integer)paramView.getTag()).intValue())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (((anyw)this.app.getManager(51)).b(this.jdField_a_of_type_JavaLangString)) {}
    for (int i = 1;; i = 19)
    {
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, i);
      ProfileActivity.b(getActivity(), localAllInOne);
      yup.a("list_settings", "clk_person_data", 0, 0, new String[] { "", "", "", "" });
      break;
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
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldActivity
 * JD-Core Version:    0.7.0.1
 */