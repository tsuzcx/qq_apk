package com.tencent.biz.qqstory.troop.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.storyHome.atvideo.model.AtVideoTextWatcher;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.biz.qqstory.view.widget.FullScreenEmptyView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import mqq.os.MqqHandler;

public class TroopStoryMainActivity
  extends QQStoryBaseActivity
  implements IMyStoryListView
{
  public static final String a = "com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity";
  public TroopStoryListView b;
  public FullScreenEmptyView c;
  protected StoryInputBarView d;
  public FeedManager e;
  protected Runnable f = new TroopStoryMainActivity.1(this);
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, TroopStoryMainActivity.class));
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString) {}
  
  public SegmentView b(String paramString)
  {
    return this.b.b(paramString);
  }
  
  public void b(boolean paramBoolean) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    if (this.d.getVisibility() == 0)
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
      this.d.clearFocus();
      this.d.setVisibility(8);
      return;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mUseOptimizMode = true;
    super.doOnCreate(paramBundle);
    super.setContentView(2131628171);
    super.setTitle(HardCodeUtil.a(2131913045));
    this.e = ((FeedManager)SuperManager.a(11));
    this.e.g.clear();
    this.d = ((StoryInputBarView)super.findViewById(2131442726));
    this.b = ((TroopStoryListView)super.findViewById(2131437330));
    this.b.a(this, this);
    this.b.setDivider(null);
    this.b.setContentBackground(2130839572);
    ((ViewGroup)this.b.getParent()).setBackgroundColor(getResources().getColor(2131168094));
    this.c = new FullScreenEmptyView(this);
    this.c.setVisibility(8);
    ((ViewGroup)this.b.getParent()).addView(this.c);
    this.b.setEmptyView(this.c);
    this.b.k();
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(8);
    QQStoryMainController.a(this, "troopStoryHallConfig", this.rightViewImg, this.rightViewText);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    TroopStoryListView localTroopStoryListView = this.b;
    if (localTroopStoryListView != null) {
      localTroopStoryListView.m();
    }
    this.d.d();
    this.e.g.clear();
    ThreadManager.getUIHandler().removeCallbacks(this.f);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    TroopStoryListView localTroopStoryListView = this.b;
    if (localTroopStoryListView != null) {
      localTroopStoryListView.l();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    TroopStoryListView localTroopStoryListView = this.b;
    if (localTroopStoryListView != null)
    {
      localTroopStoryListView.p();
      this.b.q();
    }
  }
  
  public StoryInputBarView h()
  {
    return this.d;
  }
  
  public boolean i()
  {
    return isResume();
  }
  
  public void j() {}
  
  public void k() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    TroopStoryListView localTroopStoryListView = this.b;
    if (localTroopStoryListView != null) {
      localTroopStoryListView.a(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 != 30000) {
        return;
      }
      AtVideoTextWatcher.a(this.d.e, paramIntent);
      ThreadManager.getUIHandler().postDelayed(this.f, 100L);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity
 * JD-Core Version:    0.7.0.1
 */