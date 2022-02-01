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
import com.tencent.mobileqq.app.HardCodeUtil;
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
    if ((paramCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
      return;
    }
    throw new IllegalStateException("initial comment event proxy while owner is not share group item.");
  }
  
  public boolean a()
  {
    SLog.c("Q.qqstory.detail.DetailShareGroupCommentEventProxy", "on comment button click.");
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131703318), 0).a();
      return false;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
    if ((!localShareGroupItem.isPublic()) && (!localShareGroupItem.isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, StoryApi.a(2131699909), 0).a();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131703319), 0).a();
    }
    for (;;)
    {
      bool = false;
      break label175;
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          localActionSheet.addButton(DetailGeneralCommentEventProxy.d);
        } else {
          localActionSheet.addButton(DetailGeneralCommentEventProxy.e);
        }
        localActionSheet.addButton(DetailGeneralCommentEventProxy.a, 3);
        localActionSheet.addCancelButton(DetailGeneralCommentEventProxy.f);
        localActionSheet.setOnButtonClickListener(new DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener(localActionSheet, paramCommentEntry, paramInt1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailGeneralCommentEventProxy$ActionSheetEventCallback));
        localActionSheet.show();
      }
      else
      {
        paramCommentEntry = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
        if ((paramCommentEntry.isPublic()) || (paramCommentEntry.isSubscribe())) {
          break;
        }
        QQToast.a(BaseApplication.getContext(), 1, StoryApi.a(2131699909), 0).a();
      }
    }
    boolean bool = true;
    label175:
    paramInt1 = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
      paramCommentEntry = "1";
    } else {
      paramCommentEntry = "2";
    }
    StoryReportor.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, StoryReportor.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
    return bool;
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
    {
      if (paramCommentEntry.status == 2) {
        localActionSheet.addButton(DetailGeneralCommentEventProxy.d);
      } else {
        localActionSheet.addButton(DetailGeneralCommentEventProxy.e);
      }
      localActionSheet.addButton(DetailGeneralCommentEventProxy.a, 3);
    }
    else if ((localShareGroupItem.isPublic()) && (localShareGroupItem.isOwner()))
    {
      localActionSheet.addButton(DetailGeneralCommentEventProxy.c);
      localActionSheet.addButton(DetailGeneralCommentEventProxy.a, 3);
      localActionSheet.addButton(DetailGeneralCommentEventProxy.e);
    }
    else
    {
      localActionSheet.addButton(DetailGeneralCommentEventProxy.c);
      localActionSheet.addButton(DetailGeneralCommentEventProxy.e);
    }
    localActionSheet.addCancelButton(DetailGeneralCommentEventProxy.f);
    localActionSheet.setOnButtonClickListener(new DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener(localActionSheet, paramCommentEntry, paramInt1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailGeneralCommentEventProxy$ActionSheetEventCallback));
    localActionSheet.show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailShareGroupCommentEventProxy
 * JD-Core Version:    0.7.0.1
 */