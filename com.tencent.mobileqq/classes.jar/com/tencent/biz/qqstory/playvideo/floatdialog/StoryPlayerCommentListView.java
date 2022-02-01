package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.comment.StoryFailCommentCacher;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.ListView;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StoryPlayerCommentListView
  extends SegmentList
  implements View.OnTouchListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  public int a;
  private StoryPlayerCommentListView.CommentListViewStateChangeListener b;
  private CommentFloatDialogController c;
  private List<SegmentView> d = new ArrayList();
  private StoryPlayerCommentListView.ListViewOnDataChangeListener m;
  
  public StoryPlayerCommentListView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public StoryPlayerCommentListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public StoryPlayerCommentListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    DetailFeedItem localDetailFeedItem = this.c.f();
    if ((localDetailFeedItem != null) && (localDetailFeedItem.a != null))
    {
      if ((paramInt != 2) && (paramInt != 1))
      {
        paramCommentEntry = new FeedInfoChangeEvent(2, localDetailFeedItem.a.feedId, paramInt, localDetailFeedItem.a);
      }
      else
      {
        FeedInfoChangeEvent localFeedInfoChangeEvent = new FeedInfoChangeEvent(2, paramCommentEntry.feedId, paramInt);
        localFeedInfoChangeEvent.e = paramCommentEntry.commentId;
        paramCommentEntry = localFeedInfoChangeEvent;
      }
      paramCommentEntry.c = localDetailFeedItem.a;
      StoryDispatcher.a().dispatch(paramCommentEntry);
      return;
    }
    SLog.d("Q.qqstory.player.StoryPlayerCommentListView", "feed item null , notify feed info change error!");
  }
  
  private void b()
  {
    setOnLoadMoreListener("CommentFloatDialog", new StoryPlayerCommentListView.1(this));
    setLoadMoreComplete("CommentFloatDialog", true, false);
    setOnTouchListener(this);
    super.setOverScrollHeader(null);
  }
  
  protected void a()
  {
    super.setActTAG("list_qqstory_detail");
    Object localObject = new PlayerDoubleTabSegment(getContext());
    PlayerCommentSegment localPlayerCommentSegment = new PlayerCommentSegment(getContext());
    PlayerCommentEmptySegment localPlayerCommentEmptySegment = new PlayerCommentEmptySegment(getContext());
    EmptyPlaceHolderSegment localEmptyPlaceHolderSegment = new EmptyPlaceHolderSegment(getContext(), 30);
    this.d.add(localObject);
    this.d.add(localEmptyPlaceHolderSegment);
    this.d.add(localPlayerCommentSegment);
    this.d.add(localPlayerCommentEmptySegment);
    localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((SegmentView)((Iterator)localObject).next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.c.a(paramCommentEntry, paramBoolean);
    StoryFailCommentCacher.a().b();
    q();
    QQToast.makeText(BaseApplication.getContext(), 2, HardCodeUtil.a(2131911863), 0).show();
    a(2, paramCommentEntry);
  }
  
  public void a(@NonNull CommentFloatDialogController paramCommentFloatDialogController, StoryPlayerCommentListView.CommentListViewStateChangeListener paramCommentListViewStateChangeListener, int paramInt)
  {
    super.k();
    this.b = paramCommentListViewStateChangeListener;
    this.c = paramCommentFloatDialogController;
    this.a = paramInt;
    this.m = new StoryPlayerCommentListView.ListViewOnDataChangeListener(this, null);
    this.c.a(this.m);
    PlayerCommentSegment localPlayerCommentSegment = (PlayerCommentSegment)b("PlayerCommentSegment");
    if (localPlayerCommentSegment != null) {
      localPlayerCommentSegment.a(paramCommentFloatDialogController, paramCommentListViewStateChangeListener, this.a);
    }
    paramCommentListViewStateChangeListener = (PlayerCommentEmptySegment)b("PlayerCommentEmptySegment");
    if (paramCommentListViewStateChangeListener != null) {
      paramCommentListViewStateChangeListener.a(paramCommentFloatDialogController);
    }
    paramCommentListViewStateChangeListener = (PlayerDoubleTabSegment)b("PlayerDoubleTabSegment");
    if (paramCommentListViewStateChangeListener != null) {
      paramCommentListViewStateChangeListener.a(paramCommentFloatDialogController);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.a(1);
      return;
    }
    super.a(1, g);
  }
  
  public int getCommentSegmentIndex()
  {
    Iterator localIterator = this.d.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      SegmentView localSegmentView = (SegmentView)localIterator.next();
      if ((localSegmentView instanceof PlayerCommentSegment)) {
        return i;
      }
      i += localSegmentView.a();
    }
    return i;
  }
  
  public int getLastCommentPoi()
  {
    Iterator localIterator = this.d.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      SegmentView localSegmentView = (SegmentView)localIterator.next();
      if ((localSegmentView instanceof PlayerCommentSegment))
      {
        j = i + localSegmentView.a();
        break;
      }
      i += localSegmentView.a();
    }
    if (j == 0) {
      return 0;
    }
    return j;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < getCommentSegmentIndex()) {
      return;
    }
    paramInt -= getCommentSegmentIndex();
    paramAdapterView = ((PlayerCommentSegment)b("PlayerCommentSegment")).a(paramInt);
    if (paramAdapterView == null)
    {
      SLog.e("Q.qqstory.player.StoryPlayerCommentListView", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if (paramAdapterView.type == 1)
    {
      paramAdapterView = this.c;
      paramAdapterView.a(paramAdapterView.e());
      return;
    }
    paramView = this.b;
    if (paramView != null) {
      paramView.a(paramAdapterView, paramInt, this.c.d());
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < getCommentSegmentIndex()) {
      return false;
    }
    paramInt -= getCommentSegmentIndex();
    paramView = ((PlayerCommentSegment)b("PlayerCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      SLog.e("Q.qqstory.player.StoryPlayerCommentListView", "the long clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramAdapterView = this.c.f();
    if ((paramAdapterView != null) && (paramAdapterView.a != null))
    {
      if (paramAdapterView.a.getOwner().isMe()) {
        paramAdapterView = "2";
      } else {
        paramAdapterView = "1";
      }
      StoryReportor.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, StoryReportor.b(this.a) });
    }
    if (paramView.type == 1)
    {
      paramAdapterView = this.c;
      paramAdapterView.a(paramAdapterView.e());
      return true;
    }
    paramAdapterView = this.b;
    if (paramAdapterView != null) {
      paramAdapterView.b(paramView, paramInt, this.c.d());
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.b;
    if (paramView != null) {
      return paramView.a(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    paramView = this.b;
    if (paramView != null) {
      paramView.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView
 * JD-Core Version:    0.7.0.1
 */