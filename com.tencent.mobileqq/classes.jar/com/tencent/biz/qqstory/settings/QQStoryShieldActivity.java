package com.tencent.biz.qqstory.settings;

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
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;

public class QQStoryShieldActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int = 3;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  QQStoryHandler jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
  QQStoryManager jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager;
  QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new QQStoryShieldActivity.1(this);
  protected QQProgressNotifier a;
  Switch jdField_a_of_type_ComTencentWidgetSwitch;
  String jdField_a_of_type_JavaLangString;
  View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
  Switch b;
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2131561545, null);
    ((TextView)localView.findViewById(2131378784)).setText(paramString);
    ((TextView)localView.findViewById(2131368773)).setText("");
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_JavaLangString);
    super.startTitleProgress();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = super.getIntent().getStringExtra("uin");
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("from", 3);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      super.finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager = ((QQStoryManager)this.app.getManager(QQManagerFactory.QQSTORY_MANAGER));
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER));
    this.app.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    paramBundle = new LinearLayout(this);
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.setBackgroundResource(2130838740);
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramBundle.setOrientation(1);
    paramBundle.setPadding(0, AIOUtils.b(20.0F, getResources()), 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup = paramBundle;
    paramBundle = a(0, HardCodeUtil.a(2131710981));
    paramBundle.setBackgroundResource(2130839440);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    int i = this.jdField_a_of_type_Int;
    if ((i == 3) || (i == 2)) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new FormSwitchItem(this, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = paramBundle;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131710999));
    ((StringBuilder)localObject).append(QQStoryConstant.b);
    paramBundle.setText(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131710968));
    ((StringBuilder)localObject).append(QQStoryConstant.b);
    paramBundle.setContentDescription(((StringBuilder)localObject).toString());
    paramBundle.setBgType(2);
    paramBundle.setTag(Integer.valueOf(1));
    paramBundle.a().setTextSize(1, 18.0F);
    paramBundle.setFocusable(true);
    this.b = paramBundle.a();
    this.b.setTag(Integer.valueOf(1));
    this.b.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    paramBundle = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
    i = this.jdField_a_of_type_Int;
    if ((i != 3) && (i != 2)) {
      paramBundle.topMargin = AIOUtils.b(20.0F, getResources());
    }
    paramBundle = new FormSwitchItem(this, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = paramBundle;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131710985));
    ((StringBuilder)localObject).append(QQStoryConstant.b);
    paramBundle.setText(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131710956));
    ((StringBuilder)localObject).append(QQStoryConstant.b);
    paramBundle.setContentDescription(((StringBuilder)localObject).toString());
    paramBundle.setBgType(3);
    paramBundle.setTag(Integer.valueOf(2));
    paramBundle.a().setTextSize(1, 18.0F);
    paramBundle.setFocusable(true);
    this.jdField_a_of_type_ComTencentWidgetSwitch = paramBundle.a();
    this.jdField_a_of_type_ComTencentWidgetSwitch.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a(this.jdField_a_of_type_JavaLangString);
    if (paramBundle != null)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
      boolean bool;
      if (paramBundle.isAllowed == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((Switch)localObject).setChecked(bool);
      localObject = this.b;
      if (paramBundle.isInterested == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((Switch)localObject).setChecked(bool);
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
    this.b.setOnCheckedChangeListener(this);
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    i = this.jdField_a_of_type_Int;
    if (i == 3)
    {
      paramBundle = new StringBuilder();
      paramBundle.append(QQStoryConstant.jdField_a_of_type_JavaLangString);
      paramBundle.append(HardCodeUtil.a(2131710957));
      super.setTitle(paramBundle.toString());
    }
    else if (i == 2)
    {
      if (QQStoryContext.a().a(this.jdField_a_of_type_JavaLangString))
      {
        paramBundle = new StringBuilder();
        paramBundle.append(QQStoryConstant.jdField_a_of_type_JavaLangString);
        paramBundle.append(HardCodeUtil.a(2131710998));
        super.setTitle(paramBundle.toString());
      }
      else
      {
        super.setTitle(HardCodeUtil.a(2131710977));
      }
    }
    else
    {
      super.setTitle(HardCodeUtil.a(2131710994));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this, 2131561396);
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, HardCodeUtil.a(2131710953), 0).b(getTitleBarHeight());
      super.startTitleProgress();
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_JavaLangString);
    }
    StoryReportor.a("friend_story_settings", "exp_set", this.jdField_a_of_type_Int, 0, new String[] { "2", "", "", "" });
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    StoryListUtils.a(this.app);
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = ((Integer)paramCompoundButton.getTag()).intValue();
    int i;
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, HardCodeUtil.a(2131710996), 0).b(getTitleBarHeight());
      i = 0;
    }
    else
    {
      i = 1;
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(this.jdField_a_of_type_JavaLangString);
    if (j != 1)
    {
      if (j == 2) {
        if (i != 0)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a((ArrayList)localObject, true, paramBoolean);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(0, 2131718170, 0);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean ^ true);
        }
      }
    }
    else if (i != 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a((ArrayList)localObject, false, paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(0, 2131718170, 0);
    }
    else
    {
      this.b.setChecked(paramBoolean ^ true);
    }
    if (j == 2)
    {
      if (paramBoolean) {
        localObject = "open_notletsee";
      } else {
        localObject = "close_notletsee";
      }
    }
    else if (paramBoolean) {
      localObject = "open_notsee";
    } else {
      localObject = "close_notsee";
    }
    if (this.jdField_a_of_type_Int == 3) {
      StoryReportor.a("person_data_set", (String)localObject, 0, 0, new String[] { "", "", "", "" });
    } else {
      StoryReportor.a("list_settings", (String)localObject, 0, 0, new String[] { "", "", "", "" });
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (((Integer)paramView.getTag()).intValue() == 0)
    {
      int i = 19;
      if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_JavaLangString)) {
        i = 1;
      }
      AllInOne localAllInOne = new AllInOne(this.jdField_a_of_type_JavaLangString, i);
      ProfileUtils.openProfileCard(getActivity(), localAllInOne);
      StoryReportor.a("list_settings", "clk_person_data", 0, 0, new String[] { "", "", "", "" });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldActivity
 * JD-Core Version:    0.7.0.1
 */