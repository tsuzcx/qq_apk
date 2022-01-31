package com.tencent.biz.qqstory.comment;

import android.widget.TextView;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.widget.InnerListViewAdapter;
import com.tencent.mobileqq.text.QQText;
import java.util.List;

public class FeedCommentLego$CommentInnerAdpter
  extends InnerListViewAdapter
{
  boolean jdField_a_of_type_Boolean;
  
  public FeedCommentLego$CommentInnerAdpter(FeedCommentLego paramFeedCommentLego, int paramInt, List paramList, boolean paramBoolean)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(int paramInt, CommentEntry paramCommentEntry, BaseViewHolder paramBaseViewHolder)
  {
    if (paramCommentEntry == null) {
      SLog.e("FeedCommentLego", "FeedComment getView. data is null.");
    }
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (TextView)paramBaseViewHolder.a(2131371522);
        paramBaseViewHolder = paramCommentEntry.commentId + paramCommentEntry.feedId + paramCommentEntry.status;
        localObject1 = StoryQQTextCacher.a().a(paramBaseViewHolder);
        if ((localObject1 != null) && (this.jdField_a_of_type_Boolean))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          return;
        }
        localObject1 = SpannableStringUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.a, paramCommentEntry, FeedCommentLego.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego));
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setSpannableFactory(QQText.a);
        ((TextView)localObject2).setOnTouchListener(FeedCommentLego.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego));
        UserManager localUserManager = (UserManager)SuperManager.a(2);
        localObject2 = localUserManager.b(paramCommentEntry.authorUnionId);
        if (!paramCommentEntry.isReply()) {
          break;
        }
        paramCommentEntry = localUserManager.b(paramCommentEntry.replierUnionId);
      } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()) || (paramCommentEntry == null) || (!paramCommentEntry.isAvailable()));
      StoryQQTextCacher.a().a(paramBaseViewHolder, (CharSequence)localObject1);
      return;
    } while ((localObject2 == null) || (!((QQUserUIItem)localObject2).isAvailable()));
    StoryQQTextCacher.a().a(paramBaseViewHolder, (CharSequence)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLego.CommentInnerAdpter
 * JD-Core Version:    0.7.0.1
 */