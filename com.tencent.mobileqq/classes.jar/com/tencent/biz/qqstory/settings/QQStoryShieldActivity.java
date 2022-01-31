package com.tencent.biz.qqstory.settings;

import aekt;
import aloz;
import alpo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bdee;
import beps;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import ugx;
import uhk;
import uhl;
import uhn;
import vys;
import wnc;
import wta;

public class QQStoryShieldActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int = 3;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public beps a;
  public Switch a;
  String jdField_a_of_type_JavaLangString;
  uhk jdField_a_of_type_Uhk;
  uhl jdField_a_of_type_Uhl;
  uhn jdField_a_of_type_Uhn = new vys(this);
  View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
  public Switch b;
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2131561349, null);
    ((TextView)localView.findViewById(2131377884)).setText(paramString);
    ((TextView)localView.findViewById(2131368224)).setText("");
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Uhk.a(this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Uhl = ((uhl)this.app.getManager(181));
    this.jdField_a_of_type_Uhk = ((uhk)this.app.a(98));
    this.app.addObserver(this.jdField_a_of_type_Uhn);
    paramBundle = new LinearLayout(this);
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.setBackgroundResource(2130838592);
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramBundle.setOrientation(1);
    paramBundle.setPadding(0, aekt.a(20.0F, getResources()), 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup = paramBundle;
    paramBundle = a(0, alpo.a(2131711413));
    paramBundle.setBackgroundResource(2130839260);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 2)) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new FormSwitchItem(this, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = paramBundle;
    paramBundle.setText(alpo.a(2131711431) + ugx.b);
    paramBundle.setContentDescription(alpo.a(2131711400) + ugx.b);
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
      paramBundle.topMargin = aekt.a(20.0F, getResources());
    }
    paramBundle = new FormSwitchItem(this, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = paramBundle;
    paramBundle.setText(alpo.a(2131711417) + ugx.b);
    paramBundle.setContentDescription(alpo.a(2131711388) + ugx.b);
    paramBundle.setBgType(3);
    paramBundle.setTag(Integer.valueOf(2));
    paramBundle.a().setTextSize(1, 18.0F);
    paramBundle.setFocusable(true);
    this.jdField_a_of_type_ComTencentWidgetSwitch = paramBundle.a();
    this.jdField_a_of_type_ComTencentWidgetSwitch.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    paramBundle = this.jdField_a_of_type_Uhl.a(this.jdField_a_of_type_JavaLangString);
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
      super.setTitle(ugx.jdField_a_of_type_JavaLangString + alpo.a(2131711389));
      label624:
      this.jdField_a_of_type_Beps = new beps(this, 2131561218);
      if (bdee.g(this)) {
        break label801;
      }
      QQToast.a(this, 1, alpo.a(2131711385), 0).b(getTitleBarHeight());
      super.startTitleProgress();
    }
    for (;;)
    {
      wta.a("friend_story_settings", "exp_set", this.jdField_a_of_type_Int, 0, new String[] { "2", "", "", "" });
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
          super.setTitle(ugx.jdField_a_of_type_JavaLangString + alpo.a(2131711430));
          break label624;
        }
        super.setTitle(alpo.a(2131711409));
        break label624;
      }
      super.setTitle(alpo.a(2131711426));
      break label624;
      label801:
      this.jdField_a_of_type_Uhk.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Uhn);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    wnc.a(this.app);
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = ((Integer)paramCompoundButton.getTag()).intValue();
    if (!bdee.g(this)) {
      QQToast.a(this, 1, alpo.a(2131711428), 0).b(getTitleBarHeight());
    }
    for (int i = 0;; i = 1)
    {
      paramCompoundButton = new ArrayList();
      paramCompoundButton.add(this.jdField_a_of_type_JavaLangString);
      switch (j)
      {
      default: 
        if (j == 2) {
          if (paramBoolean) {
            paramCompoundButton = "open_notletsee";
          }
        }
        break;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Int != 3) {
          break label277;
        }
        wta.a("person_data_set", paramCompoundButton, 0, 0, new String[] { "", "", "", "" });
        return;
        if (i != 0)
        {
          this.jdField_a_of_type_Uhk.a(paramCompoundButton, true, paramBoolean);
          this.jdField_a_of_type_Beps.b(0, 2131719152, 0);
          break;
        }
        paramCompoundButton = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!paramBoolean) {}
        for (boolean bool = true;; bool = false)
        {
          paramCompoundButton.setChecked(bool);
          break;
        }
        if (i != 0)
        {
          this.jdField_a_of_type_Uhk.a(paramCompoundButton, false, paramBoolean);
          this.jdField_a_of_type_Beps.b(0, 2131719152, 0);
          break;
        }
        paramCompoundButton = this.b;
        if (!paramBoolean) {}
        for (bool = true;; bool = false)
        {
          paramCompoundButton.setChecked(bool);
          break;
        }
        paramCompoundButton = "close_notletsee";
        continue;
        if (paramBoolean) {
          paramCompoundButton = "open_notsee";
        } else {
          paramCompoundButton = "close_notsee";
        }
      }
      label277:
      wta.a("list_settings", paramCompoundButton, 0, 0, new String[] { "", "", "", "" });
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (((Integer)paramView.getTag()).intValue())
    {
    default: 
      return;
    }
    if (((aloz)this.app.getManager(51)).b(this.jdField_a_of_type_JavaLangString)) {}
    for (int i = 1;; i = 19)
    {
      paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, i);
      ProfileActivity.b(getActivity(), paramView);
      wta.a("list_settings", "clk_person_data", 0, 0, new String[] { "", "", "", "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldActivity
 * JD-Core Version:    0.7.0.1
 */