package com.tencent.biz.qqstory.settings;

import Override;
import amsw;
import amtj;
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
import bhhw;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import vkm;
import vkz;
import vla;
import vlc;
import xbs;
import xqc;
import xwa;

public class QQStoryShieldActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int = 3;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public bhhw a;
  public Switch a;
  String jdField_a_of_type_JavaLangString;
  vkz jdField_a_of_type_Vkz;
  vla jdField_a_of_type_Vla;
  vlc jdField_a_of_type_Vlc = new xbs(this);
  View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
  public Switch b;
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2131561522, null);
    ((TextView)localView.findViewById(2131378707)).setText(paramString);
    ((TextView)localView.findViewById(2131368660)).setText("");
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Vkz.a(this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Vla = ((vla)this.app.getManager(181));
    this.jdField_a_of_type_Vkz = ((vkz)this.app.getBusinessHandler(98));
    this.app.addObserver(this.jdField_a_of_type_Vlc);
    paramBundle = new LinearLayout(this);
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.setBackgroundResource(2130838892);
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramBundle.setOrientation(1);
    paramBundle.setPadding(0, AIOUtils.dp2px(20.0F, getResources()), 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup = paramBundle;
    paramBundle = a(0, amtj.a(2131710142));
    paramBundle.setBackgroundResource(2130839482);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 2)) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new FormSwitchItem(this, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = paramBundle;
    paramBundle.setText(amtj.a(2131710160) + vkm.b);
    paramBundle.setContentDescription(amtj.a(2131710129) + vkm.b);
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
      paramBundle.topMargin = AIOUtils.dp2px(20.0F, getResources());
    }
    paramBundle = new FormSwitchItem(this, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = paramBundle;
    paramBundle.setText(amtj.a(2131710146) + vkm.b);
    paramBundle.setContentDescription(amtj.a(2131710117) + vkm.b);
    paramBundle.setBgType(3);
    paramBundle.setTag(Integer.valueOf(2));
    paramBundle.a().setTextSize(1, 18.0F);
    paramBundle.setFocusable(true);
    this.jdField_a_of_type_ComTencentWidgetSwitch = paramBundle.a();
    this.jdField_a_of_type_ComTencentWidgetSwitch.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    paramBundle = this.jdField_a_of_type_Vla.a(this.jdField_a_of_type_JavaLangString);
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
      super.setTitle(vkm.jdField_a_of_type_JavaLangString + amtj.a(2131710118));
      label624:
      this.jdField_a_of_type_Bhhw = new bhhw(this, 2131561385);
      if (NetworkUtil.isNetworkAvailable(this)) {
        break label801;
      }
      QQToast.a(this, 1, amtj.a(2131710114), 0).b(getTitleBarHeight());
      super.startTitleProgress();
    }
    for (;;)
    {
      xwa.a("friend_story_settings", "exp_set", this.jdField_a_of_type_Int, 0, new String[] { "2", "", "", "" });
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
          super.setTitle(vkm.jdField_a_of_type_JavaLangString + amtj.a(2131710159));
          break label624;
        }
        super.setTitle(amtj.a(2131710138));
        break label624;
      }
      super.setTitle(amtj.a(2131710155));
      break label624;
      label801:
      this.jdField_a_of_type_Vkz.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Vlc);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    xqc.a(this.app);
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = ((Integer)paramCompoundButton.getTag()).intValue();
    if (!NetworkUtil.isNetworkAvailable(this)) {
      QQToast.a(this, 1, amtj.a(2131710157), 0).b(getTitleBarHeight());
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
            xwa.a("person_data_set", (String)localObject, 0, 0, new String[] { "", "", "", "" });
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
          this.jdField_a_of_type_Vkz.a((ArrayList)localObject, true, paramBoolean);
          this.jdField_a_of_type_Bhhw.b(0, 2131717646, 0);
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
          this.jdField_a_of_type_Vkz.a((ArrayList)localObject, false, paramBoolean);
          this.jdField_a_of_type_Bhhw.b(0, 2131717646, 0);
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
        xwa.a("list_settings", (String)localObject, 0, 0, new String[] { "", "", "", "" });
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
    if (((amsw)this.app.getManager(51)).b(this.jdField_a_of_type_JavaLangString)) {}
    for (int i = 1;; i = 19)
    {
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, i);
      ProfileActivity.b(getActivity(), localAllInOne);
      xwa.a("list_settings", "clk_person_data", 0, 0, new String[] { "", "", "", "" });
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