package com.tencent.biz.qqstory.comment;

import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.ActionSheet;

public class ShareGroupCommentEventHandler
  extends FeedCommentEventHandler
{
  ShareGroupItem e;
  boolean f = false;
  boolean g = false;
  
  public ShareGroupCommentEventHandler(FeedCommentLego paramFeedCommentLego, ShareGroupItem paramShareGroupItem)
  {
    super(paramFeedCommentLego);
    this.e = paramShareGroupItem;
    this.f = this.e.isOwner();
    this.g = this.e.isPublic();
  }
  
  protected void a(View paramView, CommentEntry paramCommentEntry, int paramInt)
  {
    if (this.e == null) {
      super.a(paramView, paramCommentEntry, paramInt);
    }
    paramView = QQStoryContext.a().i();
    ActionSheet localActionSheet = ActionSheet.create(this.a.p);
    if (paramCommentEntry.authorUnionId.equals(paramView))
    {
      if (paramCommentEntry.status == 2) {
        localActionSheet.addButton(HardCodeUtil.a(2131911349));
      } else {
        localActionSheet.addButton(HardCodeUtil.a(2131911326));
      }
      localActionSheet.addButton(HardCodeUtil.a(2131911343), 3);
    }
    else if ((this.g) && (this.f))
    {
      localActionSheet.addButton(HardCodeUtil.a(2131911337));
      localActionSheet.addButton(HardCodeUtil.a(2131911346), 3);
      localActionSheet.addButton(HardCodeUtil.a(2131911353));
    }
    else
    {
      localActionSheet.addButton(HardCodeUtil.a(2131911336));
      localActionSheet.addButton(HardCodeUtil.a(2131911344));
    }
    localActionSheet.addCancelButton(HardCodeUtil.a(2131898212));
    localActionSheet.setOnButtonClickListener(new FeedCommentEventHandler.OnActionSheetButtonClickListener(this, localActionSheet, paramCommentEntry, paramInt));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.ShareGroupCommentEventHandler
 * JD-Core Version:    0.7.0.1
 */