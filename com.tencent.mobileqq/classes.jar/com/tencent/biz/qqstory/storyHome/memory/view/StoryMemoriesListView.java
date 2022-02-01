package com.tencent.biz.qqstory.storyHome.memory.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryProfileListViewConfig;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesFeedSegment;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.InputViewHideListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import java.util.Iterator;
import java.util.List;

public class StoryMemoriesListView
  extends SegmentList
  implements View.OnTouchListener, FeedSegment.InputViewHideListener
{
  private StoryProfileListViewConfig a;
  
  public StoryMemoriesListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryMemoriesListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StoryMemoriesListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    Iterator localIterator = this.a.a().iterator();
    while (localIterator.hasNext()) {
      a((SegmentView)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setOnTouchListener(this);
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a().setInputViewHideListener(this);
    }
  }
  
  public void a(String paramString, CommentEntry paramCommentEntry) {}
  
  public void b()
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.g();
    }
  }
  
  public void c()
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.h();
    }
  }
  
  public void d() {}
  
  public void e() {}
  
  public void layoutChildren()
  {
    try
    {
      super.layoutChildren();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      SLog.e("SwipListView", "error:%s", new Object[] { localIllegalStateException.toString() });
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView == null) {
      return false;
    }
    paramView = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a();
    if (paramView.getVisibility() == 0)
    {
      ((InputMethodManager)this.a.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      paramView.clearFocus();
      paramView.setVisibility(8);
      b();
      paramView = paramView.a.a;
      int i = StoryReportor.a(paramView.getOwner());
      if (paramView.getOwner().isMe()) {}
      for (paramView = "1";; paramView = "2")
      {
        StoryReportor.a("home_page", "cancel_reply", i, 0, new String[] { paramView, "3", "", "" });
        return true;
      }
    }
    return false;
  }
  
  public void setConfig(@NonNull StoryProfileListViewConfig paramStoryProfileListViewConfig)
  {
    this.a = paramStoryProfileListViewConfig;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    MemoriesFeedSegment localMemoriesFeedSegment = (MemoriesFeedSegment)a("FeedSegment");
    if ((localMemoriesFeedSegment == null) || (localMemoriesFeedSegment.a() == 0) || (!localMemoriesFeedSegment.c())) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    localMemoriesFeedSegment.c(1);
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    localMemoriesFeedSegment.c(0);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView
 * JD-Core Version:    0.7.0.1
 */