package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.widget.AlphaDrawable;
import tso;

public class ShowReactiveActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new tso(this);
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  FormMutiItem jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem a;
  String jdField_a_of_type_JavaLangString = "";
  TextView jdField_b_of_type_AndroidWidgetTextView;
  FormMutiItem jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormMutiItem c;
  FormMutiItem d;
  FormMutiItem e;
  FormMutiItem f;
  FormMutiItem g;
  FormMutiItem h;
  FormMutiItem i;
  FormMutiItem j;
  FormMutiItem k;
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this);
  }
  
  public View a(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  public void a()
  {
    setLeftViewName(2131432414);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131371393));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131371431));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)a(2131371432));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)a(2131371433));
    this.c = ((FormMutiItem)a(2131371434));
    this.d = ((FormMutiItem)a(2131371435));
    this.e = ((FormMutiItem)a(2131371438));
    this.f = ((FormMutiItem)a(2131371439));
    this.g = ((FormMutiItem)a(2131371440));
    this.h = ((FormMutiItem)a(2131371441));
    this.j = ((FormMutiItem)a(2131371436));
    this.k = ((FormMutiItem)a(2131371437));
    this.i = ((FormMutiItem)a(2131371442));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131371430));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131371428));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131371429));
    Object localObject2 = (FriendsManager)this.app.getManager(50);
    boolean bool2 = ((FriendsManager)localObject2).d();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    boolean bool1;
    int m;
    if (!bool2)
    {
      bool1 = true;
      ((FormSwitchItem)localObject1).setChecked(bool1);
      ((CardHandler)this.app.a(2)).p();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      }
      localObject1 = ((FriendsManager)localObject2).a(this.jdField_a_of_type_JavaLangString, false);
      m = ((FriendsManager)localObject2).b(this.jdField_a_of_type_JavaLangString, (ExtensionInfo)localObject1, bool2);
      ((FriendsManager)localObject2).c(this.jdField_a_of_type_JavaLangString, (ExtensionInfo)localObject1, bool2);
      ((FriendsManager)localObject2).d(this.jdField_a_of_type_JavaLangString, (ExtensionInfo)localObject1, bool2);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (getIntent().getBooleanExtra("showFriendDays", false))) {
        break label900;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130845927));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(HotReactiveHelper.a(this, 1));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText(HotReactiveHelper.a(this, 7));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130845913));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(HotReactiveHelper.a(this, 2));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText(HotReactiveHelper.a(this, 8));
      this.c.setLeftIcon(getResources().getDrawable(2130845930));
      this.c.setFirstLineText(HotReactiveHelper.a(this, 3));
      this.c.setSecondLineText(HotReactiveHelper.a(this, 9));
      this.d.setLeftIcon(getResources().getDrawable(2130845916));
      this.d.setFirstLineText(HotReactiveHelper.a(this, 4));
      this.d.setSecondLineText(HotReactiveHelper.a(this, 10));
      this.e.setLeftIcon(getResources().getDrawable(2130845929));
      this.e.setFirstLineText(HotReactiveHelper.a(this, 5));
      this.e.setSecondLineText(HotReactiveHelper.a(this, 11));
      this.f.setLeftIcon(getResources().getDrawable(2130845915));
      this.f.setFirstLineText(HotReactiveHelper.a(this, 6));
      this.f.setSecondLineText(HotReactiveHelper.a(this, 12));
      this.g.setLeftIcon(getResources().getDrawable(2130845922));
      this.g.setFirstLineText(HotReactiveHelper.a(this, 59));
      this.g.setSecondLineText(HotReactiveHelper.a(this, 61));
      this.h.setLeftIcon(getResources().getDrawable(2130845921));
      this.h.setFirstLineText(HotReactiveHelper.a(this, 60));
      this.h.setSecondLineText(HotReactiveHelper.a(this, 62));
      this.j.setLeftIcon(getResources().getDrawable(2130845923));
      this.j.setFirstLineText(HotReactiveHelper.a(this, 36));
      this.j.setSecondLineText(HotReactiveHelper.a(this, 34));
      this.k.setLeftIcon(getResources().getDrawable(2130845925));
      this.k.setFirstLineText(HotReactiveHelper.a(this, 37));
      this.k.setSecondLineText(HotReactiveHelper.a(this, 35));
      localObject1 = new AlphaDrawable(this, 2130845927, 2130845928);
      this.i.setLeftIcon((Drawable)localObject1);
      HotReactiveHelper.a((AlphaDrawable)localObject1);
      this.i.setFirstLineText(HotReactiveHelper.a(this, 30));
      this.i.setSecondLineText(HotReactiveHelper.a(this, 31));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HotReactiveHelper.a(this, 29));
      if (AppSetting.b) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131438568));
      }
      return;
      bool1 = false;
      break;
      label900:
      localObject2 = ContactUtils.n(this.app, this.jdField_a_of_type_JavaLangString);
      String str = "你和好友" + (String)localObject2 + "获取以下标识";
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      str = HotReactiveHelper.a(this, 55);
      if (m == 0)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else if (m == 2)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, str, (String)localObject2, ((ExtensionInfo)localObject1).chatDays, 2130845927);
      }
      else if (m == 1)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, str, (String)localObject2, ((ExtensionInfo)localObject1).chatDays, 2130845927);
      }
    }
  }
  
  public void a(FormSimpleItem paramFormSimpleItem, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramString1 = paramString1.replace("好友昵称", paramString2).replace("#realdays", "" + paramInt1);
    paramFormSimpleItem.setLeftIcon(getResources().getDrawable(paramInt2));
    paramInt1 = paramString1.lastIndexOf("" + paramInt1);
    paramString1 = new SpannableString(paramString1);
    paramString1.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(getResources().getColor(2131493062), getResources().getColor(2131493063)), paramInt1, paramInt1 + 1, 33);
    paramFormSimpleItem.setLeftText(paramString1);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970617);
    setTitle(2131435466);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(50));
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("friendUin");
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    String str = getString(2131436861);
    SpecialCareInfo localSpecialCareInfo = ((FriendsManager)this.app.getManager(50)).a(this.jdField_a_of_type_JavaLangString);
    if ((localSpecialCareInfo == null) || (localSpecialCareInfo.globalSwitch == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131436036));
    }
    for (str = str + getString(2131436036);; str = str + getString(2131436037))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(str);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131436037));
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (!NetworkUtil.d(getActivity()))
    {
      QQToast.a(getApplicationContext(), 2131436066, 1).a();
      bool1 = bool2;
      if (!paramBoolean) {
        bool1 = true;
      }
      a(paramCompoundButton, bool1);
    }
    while (paramCompoundButton != this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
      return;
    }
    paramCompoundButton = this.app;
    int m;
    if (paramBoolean)
    {
      m = 1;
      ReportController.b(paramCompoundButton, "CliOper", "", "", "0X8007021", "0X8007021", 0, 0, String.valueOf(m), "", "", "");
      paramCompoundButton = (CardHandler)this.app.a(2);
      if (paramBoolean) {
        break label131;
      }
    }
    label131:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      paramCompoundButton.g(paramBoolean);
      return;
      m = 0;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent(this, QQSpecialCareSettingActivity.class);
    paramView.putExtra("key_friend_uin", this.jdField_a_of_type_JavaLangString);
    paramView.putExtra("key_start_from", 4);
    startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShowReactiveActivity
 * JD-Core Version:    0.7.0.1
 */