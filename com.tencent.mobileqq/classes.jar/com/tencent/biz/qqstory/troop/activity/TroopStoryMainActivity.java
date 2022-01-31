package com.tencent.biz.qqstory.troop.activity;

import ajyc;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.view.widget.FullScreenEmptyView;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Map;
import mqq.os.MqqHandler;
import tdc;
import uou;
import uwa;
import vat;
import wcr;

public class TroopStoryMainActivity
  extends QQStoryBaseActivity
  implements vat
{
  public static final String a;
  protected StoryInputBarView a;
  public TroopStoryListView a;
  public FullScreenEmptyView a;
  protected Runnable a;
  public uwa a;
  
  static
  {
    jdField_a_of_type_JavaLangString = TroopStoryMainActivity.class.getName();
  }
  
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
  
  public wcr a(String paramString)
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mUseOptimizMode = true;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561385);
    super.setTitle(ajyc.a(2131715790));
    this.jdField_a_of_type_Uwa = ((uwa)tdc.a(11));
    this.jdField_a_of_type_Uwa.a.clear();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = ((StoryInputBarView)super.findViewById(2131373307));
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView = ((TroopStoryListView)super.findViewById(2131369318));
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.a(this, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.setDivider(null);
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.setContentBackground(2130839127);
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.getParent()).setBackgroundColor(getResources().getColor(2131166912));
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
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.l();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.d();
    this.jdField_a_of_type_Uwa.a.clear();
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.k();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.o();
      this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.p();
    }
  }
  
  public void g() {}
  
  public void h() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.a(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    uou.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.a, paramIntent);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity
 * JD-Core Version:    0.7.0.1
 */