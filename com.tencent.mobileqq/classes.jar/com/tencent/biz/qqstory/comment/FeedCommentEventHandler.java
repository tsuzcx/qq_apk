package com.tencent.biz.qqstory.comment;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.lego.LegoDataProvider;
import com.tencent.biz.qqstory.comment.lego.LegoEvenHandler;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.biz.qqstory.view.widget.InnerListView.OnItemClickListener;
import com.tencent.biz.qqstory.view.widget.InnerListView.OnItemLongClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.List;

public class FeedCommentEventHandler
  extends LegoEvenHandler
  implements View.OnClickListener, InnerListView.OnItemClickListener, InnerListView.OnItemLongClickListener
{
  protected Handler a;
  private FeedCommentEventHandler.FeedCommentClickEvent a;
  public FeedCommentLego a;
  public CommentLikeFeedItem a;
  public String a;
  
  public FeedCommentEventHandler(FeedCommentLego paramFeedCommentLego)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego = paramFeedCommentLego;
    this.jdField_a_of_type_JavaLangString = QQStoryContext.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent = new FeedCommentEventHandler.FeedCommentClickEvent(this);
  }
  
  private void b(CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$KeyBoardUpCallback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$KeyBoardUpCallback.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego, this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_Int, paramCommentEntry);
    }
    FeedCommentLikeLego localFeedCommentLikeLego = (FeedCommentLikeLego)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.a();
    paramInt = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      StoryReportor.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, StoryReportor.a(localFeedCommentLikeLego.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    paramView = QQStoryContext.a().b();
    ActionSheet localActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidAppActivity);
    if (paramCommentEntry.authorUnionId.equals(paramView)) {
      if (paramCommentEntry.status == 2)
      {
        localActionSheet.c("重发");
        localActionSheet.a("删除", 3);
      }
    }
    for (;;)
    {
      localActionSheet.d("取消");
      localActionSheet.a(new FeedCommentEventHandler.OnActionSheetButtonClickListener(this, localActionSheet, paramCommentEntry, paramInt));
      localActionSheet.show();
      return;
      localActionSheet.c("复制");
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) {
          localActionSheet.a("删除", 3);
        }
        localActionSheet.c("举报");
        localActionSheet.c("复制");
      }
      else
      {
        localActionSheet.c("举报");
        localActionSheet.c("复制");
      }
    }
  }
  
  protected void a(CommentEntry paramCommentEntry, int paramInt)
  {
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
    {
      ActionSheet localActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidAppActivity);
      if (paramCommentEntry.status == 2) {
        localActionSheet.c("重发");
      }
      for (;;)
      {
        localActionSheet.a("删除", 3);
        localActionSheet.d("取消");
        localActionSheet.a(new FeedCommentEventHandler.OnActionSheetButtonClickListener(this, localActionSheet, paramCommentEntry, paramInt));
        localActionSheet.show();
        return;
        localActionSheet.c("复制");
      }
    }
    b(paramCommentEntry, paramInt);
    paramInt = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {}
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      StoryReportor.a("home_page", "clk_content", paramInt, 0, new String[] { paramCommentEntry, StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_Int = paramInt;
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, "网络不可用，请检查你的网络设置", 0).a();
      return;
    }
    a(localCommentEntry, paramInt);
  }
  
  public boolean a(InnerListView paramInnerListView, View paramView, int paramInt)
  {
    a(paramView, (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_AndroidViewViewGroup = paramInnerListView;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$FeedCommentClickEvent.jdField_a_of_type_Int = paramInt;
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      int i = ((Integer)paramView.getTag()).intValue();
      paramView = (CommentEntry)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_JavaUtilList.get(i);
      ActionSheet localActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidAppActivity);
      localActionSheet.c("重发");
      localActionSheet.a("删除", 3);
      localActionSheet.c(2131433029);
      localActionSheet.a(new FeedCommentEventHandler.OnActionSheetButtonClickListener(this, localActionSheet, paramView, i));
      localActionSheet.show();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.a().a();
    } while (!QLog.isColorLevel());
    QLog.d("FeedCommentEventHandler", 2, "onClick retry_btn");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentEventHandler
 * JD-Core Version:    0.7.0.1
 */