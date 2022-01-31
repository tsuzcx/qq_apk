package com.tencent.biz.qqstory.comment;

import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.widget.ActionSheet;

public class ShareGroupCommentEventHandler
  extends FeedCommentEventHandler
{
  ShareGroupItem jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public ShareGroupCommentEventHandler(FeedCommentLego paramFeedCommentLego, ShareGroupItem paramShareGroupItem)
  {
    super(paramFeedCommentLego);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isOwner();
    this.b = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic();
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) {
      super.a(paramView, paramCommentEntry, paramInt);
    }
    paramView = QQStoryContext.a().b();
    ActionSheet localActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.a);
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
      if ((this.b) && (this.jdField_a_of_type_Boolean))
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
 * Qualified Name:     com.tencent.biz.qqstory.comment.ShareGroupCommentEventHandler
 * JD-Core Version:    0.7.0.1
 */