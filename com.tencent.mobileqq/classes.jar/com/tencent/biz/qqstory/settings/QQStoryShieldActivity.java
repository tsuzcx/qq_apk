package com.tencent.biz.qqstory.settings;

import actj;
import ajxl;
import ajya;
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
import bbfj;
import bcqi;
import bcql;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import ssf;
import sss;
import sst;
import ssv;
import uka;
import uyk;
import vei;

public class QQStoryShieldActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int = 3;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public bcqi a;
  public Switch a;
  String jdField_a_of_type_JavaLangString;
  sss jdField_a_of_type_Sss;
  sst jdField_a_of_type_Sst;
  ssv jdField_a_of_type_Ssv = new uka(this);
  View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
  public Switch b;
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2131561161, null);
    ((TextView)localView.findViewById(2131377350)).setText(paramString);
    ((TextView)localView.findViewById(2131368086)).setText("");
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Sss.a(this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Sst = ((sst)this.app.getManager(181));
    this.jdField_a_of_type_Sss = ((sss)this.app.a(98));
    this.app.addObserver(this.jdField_a_of_type_Ssv);
    paramBundle = new LinearLayout(this);
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.setBackgroundResource(2130838515);
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramBundle.setOrientation(1);
    paramBundle.setPadding(0, actj.a(20.0F, getResources()), 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup = paramBundle;
    paramBundle = a(0, ajya.a(2131711041));
    paramBundle.setBackgroundResource(2130839176);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 2)) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new FormSwitchItem(this, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = paramBundle;
    paramBundle.setText(ajya.a(2131711059) + ssf.b);
    paramBundle.setContentDescription(ajya.a(2131711028) + ssf.b);
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
      paramBundle.topMargin = actj.a(20.0F, getResources());
    }
    paramBundle = new FormSwitchItem(this, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = paramBundle;
    paramBundle.setText(ajya.a(2131711045) + ssf.b);
    paramBundle.setContentDescription(ajya.a(2131711016) + ssf.b);
    paramBundle.setBgType(3);
    paramBundle.setTag(Integer.valueOf(2));
    paramBundle.a().setTextSize(1, 18.0F);
    paramBundle.setFocusable(true);
    this.jdField_a_of_type_ComTencentWidgetSwitch = paramBundle.a();
    this.jdField_a_of_type_ComTencentWidgetSwitch.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    paramBundle = this.jdField_a_of_type_Sst.a(this.jdField_a_of_type_JavaLangString);
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
      super.setTitle(ssf.jdField_a_of_type_JavaLangString + ajya.a(2131711017));
      label624:
      this.jdField_a_of_type_Bcqi = new bcqi(this, 2131561032);
      if (bbfj.g(this)) {
        break label801;
      }
      bcql.a(this, 1, ajya.a(2131711013), 0).b(getTitleBarHeight());
      super.startTitleProgress();
    }
    for (;;)
    {
      vei.a("friend_story_settings", "exp_set", this.jdField_a_of_type_Int, 0, new String[] { "2", "", "", "" });
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
          super.setTitle(ssf.jdField_a_of_type_JavaLangString + ajya.a(2131711058));
          break label624;
        }
        super.setTitle(ajya.a(2131711037));
        break label624;
      }
      super.setTitle(ajya.a(2131711054));
      break label624;
      label801:
      this.jdField_a_of_type_Sss.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Ssv);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    uyk.a(this.app);
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = ((Integer)paramCompoundButton.getTag()).intValue();
    if (!bbfj.g(this)) {
      bcql.a(this, 1, ajya.a(2131711056), 0).b(getTitleBarHeight());
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
        vei.a("person_data_set", paramCompoundButton, 0, 0, new String[] { "", "", "", "" });
        return;
        if (i != 0)
        {
          this.jdField_a_of_type_Sss.a(paramCompoundButton, true, paramBoolean);
          this.jdField_a_of_type_Bcqi.b(0, 2131718679, 0);
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
          this.jdField_a_of_type_Sss.a(paramCompoundButton, false, paramBoolean);
          this.jdField_a_of_type_Bcqi.b(0, 2131718679, 0);
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
      vei.a("list_settings", paramCompoundButton, 0, 0, new String[] { "", "", "", "" });
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
    if (((ajxl)this.app.getManager(51)).b(this.jdField_a_of_type_JavaLangString)) {}
    for (int i = 1;; i = 19)
    {
      paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, i);
      ProfileActivity.b(getActivity(), paramView);
      vei.a("list_settings", "clk_person_data", 0, 0, new String[] { "", "", "", "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldActivity
 * JD-Core Version:    0.7.0.1
 */