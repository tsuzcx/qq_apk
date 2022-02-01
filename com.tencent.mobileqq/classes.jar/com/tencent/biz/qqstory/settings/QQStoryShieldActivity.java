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
  String a;
  View[] b = new View[3];
  ViewGroup c;
  int d = 3;
  Switch e;
  Switch f;
  QQStoryManager g;
  QQStoryHandler h;
  protected QQProgressNotifier i;
  QQStoryObserver j = new QQStoryShieldActivity.1(this);
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2131627906, null);
    ((TextView)localView.findViewById(2131447463)).setText(paramString);
    ((TextView)localView.findViewById(2131435692)).setText("");
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
    this.h.a(this.a);
    super.startTitleProgress();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = super.getIntent().getStringExtra("uin");
    this.d = super.getIntent().getIntExtra("from", 3);
    if (TextUtils.isEmpty(this.a))
    {
      super.finish();
      return false;
    }
    this.g = ((QQStoryManager)this.app.getManager(QQManagerFactory.QQSTORY_MANAGER));
    this.h = ((QQStoryHandler)this.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER));
    this.app.addObserver(this.j);
    paramBundle = new LinearLayout(this);
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.setBackgroundResource(2130838959);
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramBundle.setOrientation(1);
    paramBundle.setPadding(0, AIOUtils.b(20.0F, getResources()), 0, 0);
    this.c = paramBundle;
    paramBundle = a(0, HardCodeUtil.a(2131908647));
    paramBundle.setBackgroundResource(2130839629);
    this.c.addView(paramBundle);
    int k = this.d;
    if ((k == 3) || (k == 2)) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new FormSwitchItem(this, null);
    this.b[1] = paramBundle;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131908665));
    ((StringBuilder)localObject).append(QQStoryConstant.b);
    paramBundle.setText(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131908635));
    ((StringBuilder)localObject).append(QQStoryConstant.b);
    paramBundle.setContentDescription(((StringBuilder)localObject).toString());
    paramBundle.setBgType(2);
    paramBundle.setTag(Integer.valueOf(1));
    paramBundle.getTextView().setTextSize(1, 18.0F);
    paramBundle.setFocusable(true);
    this.f = paramBundle.getSwitch();
    this.f.setTag(Integer.valueOf(1));
    this.f.setOnCheckedChangeListener(null);
    this.c.addView(paramBundle);
    paramBundle = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
    k = this.d;
    if ((k != 3) && (k != 2)) {
      paramBundle.topMargin = AIOUtils.b(20.0F, getResources());
    }
    paramBundle = new FormSwitchItem(this, null);
    this.b[2] = paramBundle;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131908651));
    ((StringBuilder)localObject).append(QQStoryConstant.b);
    paramBundle.setText(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131908623));
    ((StringBuilder)localObject).append(QQStoryConstant.b);
    paramBundle.setContentDescription(((StringBuilder)localObject).toString());
    paramBundle.setBgType(3);
    paramBundle.setTag(Integer.valueOf(2));
    paramBundle.getTextView().setTextSize(1, 18.0F);
    paramBundle.setFocusable(true);
    this.e = paramBundle.getSwitch();
    this.e.setTag(Integer.valueOf(2));
    this.e.setOnCheckedChangeListener(null);
    this.c.addView(paramBundle);
    paramBundle = this.g.a(this.a);
    if (paramBundle != null)
    {
      localObject = this.e;
      boolean bool;
      if (paramBundle.isAllowed == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((Switch)localObject).setChecked(bool);
      localObject = this.f;
      if (paramBundle.isInterested == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((Switch)localObject).setChecked(bool);
    }
    this.e.setOnCheckedChangeListener(this);
    this.f.setOnCheckedChangeListener(this);
    super.setContentView(this.c);
    k = this.d;
    if (k == 3)
    {
      paramBundle = new StringBuilder();
      paramBundle.append(QQStoryConstant.a);
      paramBundle.append(HardCodeUtil.a(2131908624));
      super.setTitle(paramBundle.toString());
    }
    else if (k == 2)
    {
      if (QQStoryContext.a().b(this.a))
      {
        paramBundle = new StringBuilder();
        paramBundle.append(QQStoryConstant.a);
        paramBundle.append(HardCodeUtil.a(2131908664));
        super.setTitle(paramBundle.toString());
      }
      else
      {
        super.setTitle(HardCodeUtil.a(2131908643));
      }
    }
    else
    {
      super.setTitle(HardCodeUtil.a(2131908660));
    }
    this.i = new QQProgressNotifier(this, 2131627752);
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.makeText(this, 1, HardCodeUtil.a(2131908620), 0).show(getTitleBarHeight());
      super.startTitleProgress();
    }
    else
    {
      this.h.a(this.a);
    }
    StoryReportor.a("friend_story_settings", "exp_set", this.d, 0, new String[] { "2", "", "", "" });
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.removeObserver(this.j);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    StoryListUtils.a(this.app);
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int m = ((Integer)paramCompoundButton.getTag()).intValue();
    int k;
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.makeText(this, 1, HardCodeUtil.a(2131908662), 0).show(getTitleBarHeight());
      k = 0;
    }
    else
    {
      k = 1;
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(this.a);
    if (m != 1)
    {
      if (m == 2) {
        if (k != 0)
        {
          this.h.a((ArrayList)localObject, true, paramBoolean);
          this.i.b(0, 2131915649, 0);
        }
        else
        {
          this.e.setChecked(paramBoolean ^ true);
        }
      }
    }
    else if (k != 0)
    {
      this.h.a((ArrayList)localObject, false, paramBoolean);
      this.i.b(0, 2131915649, 0);
    }
    else
    {
      this.f.setChecked(paramBoolean ^ true);
    }
    if (m == 2)
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
    if (this.d == 3) {
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
      int k = 19;
      if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(this.a)) {
        k = 1;
      }
      AllInOne localAllInOne = new AllInOne(this.a, k);
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