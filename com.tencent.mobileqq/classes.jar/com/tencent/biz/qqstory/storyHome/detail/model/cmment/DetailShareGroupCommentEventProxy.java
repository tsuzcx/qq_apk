package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.content.Context;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;

public class DetailShareGroupCommentEventProxy
  implements IDetailCommentEventProxy
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private DetailGeneralCommentEventProxy.ActionSheetEventCallback jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailGeneralCommentEventProxy$ActionSheetEventCallback;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  
  public DetailShareGroupCommentEventProxy(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, DetailGeneralCommentEventProxy.ActionSheetEventCallback paramActionSheetEventCallback)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailGeneralCommentEventProxy$ActionSheetEventCallback = paramActionSheetEventCallback;
    if (!(paramCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
      throw new IllegalStateException("initial comment event proxy while owner is not share group item.");
    }
  }
  
  public boolean a()
  {
    SLog.c("Q.qqstory.detail.DetailShareGroupCommentEventProxy", "on comment button click.");
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, "网络不可用，请检查你的网络设置", 0).a();
      return false;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
    if ((!localShareGroupItem.isPublic()) && (!localShareGroupItem.isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, StoryApi.a(2131432103), 0).a();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, "网络不可用，请检查你的网络设置", 0).a();
      bool = false;
      paramInt1 = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label245;
      }
    }
    label245:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      StoryReportor.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, StoryReportor.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        ActionSheet localActionSheet = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          localActionSheet.c("重发");
        }
        for (;;)
        {
          localActionSheet.a("删除", 3);
          localActionSheet.d("取消");
          localActionSheet.a(new DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener(localActionSheet, paramCommentEntry, paramInt1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailGeneralCommentEventProxy$ActionSheetEventCallback));
          localActionSheet.show();
          bool = false;
          break;
          localActionSheet.c("复制");
        }
      }
      paramCommentEntry = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((!paramCommentEntry.isPublic()) && (!paramCommentEntry.isSubscribe()))
      {
        QQToast.a(BaseApplication.getContext(), 1, StoryApi.a(2131432103), 0).a();
        bool = false;
        break;
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
    ActionSheet localActionSheet = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localActionSheet.c("重发");
        localActionSheet.a("删除", 3);
      }
    }
    for (;;)
    {
      localActionSheet.d("取消");
      localActionSheet.a(new DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener(localActionSheet, paramCommentEntry, paramInt1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailGeneralCommentEventProxy$ActionSheetEventCallback));
      localActionSheet.show();
      return false;
      localActionSheet.c("复制");
      break;
      if ((localShareGroupItem.isPublic()) && (localShareGroupItem.isOwner()))
      {
        localActionSheet.c("举报");
        localActionSheet.a("删除", 3);
        localActionSheet.c("复制");
      }
      else
      {
        localActionSheet.c("举报");
        localActionSheet.c("复制");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailShareGroupCommentEventProxy
 * JD-Core Version:    0.7.0.1
 */