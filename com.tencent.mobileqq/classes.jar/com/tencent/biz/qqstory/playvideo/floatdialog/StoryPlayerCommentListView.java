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
  private CommentFloatDialogController jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController;
  private StoryPlayerCommentListView.CommentListViewStateChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$CommentListViewStateChangeListener;
  private StoryPlayerCommentListView.ListViewOnDataChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$ListViewOnDataChangeListener;
  private List<SegmentView> jdField_a_of_type_JavaUtilList = new ArrayList();
  
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
    DetailFeedItem localDetailFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a();
    if ((localDetailFeedItem == null) || (localDetailFeedItem.a == null))
    {
      SLog.d("Q.qqstory.player.StoryPlayerCommentListView", "feed item null , notify feed info change error!");
      return;
    }
    FeedInfoChangeEvent localFeedInfoChangeEvent;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localFeedInfoChangeEvent = new FeedInfoChangeEvent(2, paramCommentEntry.feedId, paramInt);
      localFeedInfoChangeEvent.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localFeedInfoChangeEvent;; paramCommentEntry = new FeedInfoChangeEvent(2, localDetailFeedItem.a.feedId, paramInt, localDetailFeedItem.a))
    {
      paramCommentEntry.a = localDetailFeedItem.a;
      StoryDispatcher.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void b()
  {
    setOnLoadMoreListener("CommentFloatDialog", new StoryPlayerCommentListView.1(this));
    setLoadMoreComplete("CommentFloatDialog", true, false);
    setOnTouchListener(this);
    super.setOverScrollHeader(null);
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    SegmentView localSegmentView;
    for (int i = 0;; i = localSegmentView.a() + i) {
      if (localIterator.hasNext())
      {
        localSegmentView = (SegmentView)localIterator.next();
        if (!(localSegmentView instanceof PlayerCommentSegment)) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_detail");
    Object localObject = new PlayerDoubleTabSegment(getContext());
    PlayerCommentSegment localPlayerCommentSegment = new PlayerCommentSegment(getContext());
    PlayerCommentEmptySegment localPlayerCommentEmptySegment = new PlayerCommentEmptySegment(getContext());
    EmptyPlaceHolderSegment localEmptyPlaceHolderSegment = new EmptyPlaceHolderSegment(getContext(), 30);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localEmptyPlaceHolderSegment);
    this.jdField_a_of_type_JavaUtilList.add(localPlayerCommentSegment);
    this.jdField_a_of_type_JavaUtilList.add(localPlayerCommentEmptySegment);
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
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
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a(paramCommentEntry, paramBoolean);
    StoryFailCommentCacher.a().a();
    p();
    QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131714428), 0).a();
    a(2, paramCommentEntry);
  }
  
  public void a(@NonNull CommentFloatDialogController paramCommentFloatDialogController, StoryPlayerCommentListView.CommentListViewStateChangeListener paramCommentListViewStateChangeListener, int paramInt)
  {
    super.j();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$CommentListViewStateChangeListener = paramCommentListViewStateChangeListener;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController = paramCommentFloatDialogController;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$ListViewOnDataChangeListener = new StoryPlayerCommentListView.ListViewOnDataChangeListener(this, null);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$ListViewOnDataChangeListener);
    PlayerCommentSegment localPlayerCommentSegment = (PlayerCommentSegment)a("PlayerCommentSegment");
    if (localPlayerCommentSegment != null) {
      localPlayerCommentSegment.a(paramCommentFloatDialogController, paramCommentListViewStateChangeListener, this.jdField_a_of_type_Int);
    }
    paramCommentListViewStateChangeListener = (PlayerCommentEmptySegment)a("PlayerCommentEmptySegment");
    if (paramCommentListViewStateChangeListener != null) {
      paramCommentListViewStateChangeListener.a(paramCommentFloatDialogController);
    }
    paramCommentListViewStateChangeListener = (PlayerDoubleTabSegment)a("PlayerDoubleTabSegment");
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
    super.a(1, e);
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    SegmentView localSegmentView;
    if (localIterator.hasNext())
    {
      localSegmentView = (SegmentView)localIterator.next();
      if ((localSegmentView instanceof PlayerCommentSegment)) {
        i = localSegmentView.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localSegmentView.a() + i;
        break;
      }
      return i;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < a()) {}
    do
    {
      return;
      paramInt -= a();
      paramAdapterView = ((PlayerCommentSegment)a("PlayerCommentSegment")).a(paramInt);
      if (paramAdapterView == null)
      {
        SLog.e("Q.qqstory.player.StoryPlayerCommentListView", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      if (paramAdapterView.type == 1)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a());
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$CommentListViewStateChangeListener == null);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$CommentListViewStateChangeListener.a(paramAdapterView, paramInt, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a());
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < a()) {
      return false;
    }
    paramInt -= a();
    paramView = ((PlayerCommentSegment)a("PlayerCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      SLog.e("Q.qqstory.player.StoryPlayerCommentListView", "the long clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramAdapterView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a();
    if ((paramAdapterView != null) && (paramAdapterView.a != null)) {
      if (!paramAdapterView.a.getOwner().isMe()) {
        break label147;
      }
    }
    label147:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      StoryReportor.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, StoryReportor.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a());
      return true;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$CommentListViewStateChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$CommentListViewStateChangeListener.b(paramView, paramInt, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogController.a());
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$CommentListViewStateChangeListener != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$CommentListViewStateChangeListener.a(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$CommentListViewStateChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$CommentListViewStateChangeListener.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView
 * JD-Core Version:    0.7.0.1
 */