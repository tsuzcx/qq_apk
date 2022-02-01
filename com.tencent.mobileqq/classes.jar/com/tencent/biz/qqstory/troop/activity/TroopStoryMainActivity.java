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
  protected StoryInputBarView a;
  public FeedManager a;
  public TroopStoryListView a;
  public FullScreenEmptyView a;
  protected Runnable a;
  
  public TroopStoryMainActivity()
  {
    this.jdField_a_of_type_JavaLangRunnable = new TroopStoryMainActivity.1(this);
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, TroopStoryMainActivity.class));
  }
  
  public StoryInputBarView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
  }
  
  public SegmentView a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.a(paramString);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString) {}
  
  public boolean a()
  {
    return isResume();
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getVisibility() == 0)
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.clearFocus();
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.setVisibility(8);
      return;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mUseOptimizMode = true;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561792);
    super.setTitle(HardCodeUtil.a(2131715573));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager = ((FeedManager)SuperManager.a(11));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a.clear();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = ((StoryInputBarView)super.findViewById(2131374556));
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView = ((TroopStoryListView)super.findViewById(2131370164));
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.a(this, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.setDivider(null);
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.setContentBackground(2130839388);
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.getParent()).setBackgroundColor(getResources().getColor(2131167116));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView = new FullScreenEmptyView(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView.setVisibility(8);
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.getParent()).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView);
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.setEmptyView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView);
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.j();
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(8);
    QQStoryMainController.a(this, "troopStoryHallConfig", this.rightViewImg, this.rightViewText);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    TroopStoryListView localTroopStoryListView = this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView;
    if (localTroopStoryListView != null) {
      localTroopStoryListView.l();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.d();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a.clear();
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    TroopStoryListView localTroopStoryListView = this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView;
    if (localTroopStoryListView != null) {
      localTroopStoryListView.k();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    TroopStoryListView localTroopStoryListView = this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView;
    if (localTroopStoryListView != null)
    {
      localTroopStoryListView.o();
      this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.p();
    }
  }
  
  public void g() {}
  
  public void h() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    TroopStoryListView localTroopStoryListView = this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView;
    if (localTroopStoryListView != null) {
      localTroopStoryListView.a(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == -1)
    {
      if (paramInt1 != 30000) {
        return;
      }
      AtVideoTextWatcher.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a, paramIntent);
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
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