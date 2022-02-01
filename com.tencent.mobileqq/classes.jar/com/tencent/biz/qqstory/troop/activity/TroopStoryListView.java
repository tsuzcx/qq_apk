package com.tencent.biz.qqstory.troop.activity;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.PlaceholderSegment;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.widget.AbsEmptyView;
import com.tencent.widget.ListView;

public class TroopStoryListView
  extends SegmentList
  implements View.OnTouchListener
{
  private Activity a;
  private IMyStoryListView b;
  private boolean c = false;
  
  public TroopStoryListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopStoryListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopStoryListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    super.setActTAG("list_qqstory_troop");
    FeedSegment localFeedSegment = new FeedSegment(getContext(), this.a, 11, this.b, false);
    a(localFeedSegment);
    a(new PlaceholderSegment(getContext(), "FeedSegment", "暂时没有小视频\n你可以在这里查看群内的小视频", 2130848405, 2130848405));
    localFeedSegment.c(true);
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void a(Activity paramActivity, IMyStoryListView paramIMyStoryListView)
  {
    this.b = paramIMyStoryListView;
    this.a = paramActivity;
    super.setOnTouchListener(this);
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    super.b(paramBoolean, paramInt);
    if (this.c) {
      this.c = false;
    }
    if ((getEmptyView() instanceof AbsEmptyView)) {
      ((AbsEmptyView)getEmptyView()).a(4);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.b.h();
    if (paramView.getVisibility() == 0)
    {
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      paramView.clearFocus();
      paramView.setVisibility(8);
      paramView = paramView.p.g;
      int i = StoryReportor.a(paramView.getOwner());
      if (paramView.getOwner().isMe()) {
        paramView = "1";
      } else {
        paramView = "2";
      }
      StoryReportor.a("home_page", "cancel_reply", i, 0, new String[] { paramView, "3", "", "" });
    }
    return false;
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    if (paramInt == 0) {
      this.c = true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.activity.TroopStoryListView
 * JD-Core Version:    0.7.0.1
 */