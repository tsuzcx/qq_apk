package com.tencent.biz.qqstory.comment;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
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
  extends InnerListViewAdapter<CommentEntry>
{
  boolean jdField_a_of_type_Boolean;
  
  public FeedCommentLego$CommentInnerAdpter(int paramInt, List<CommentEntry> paramList, boolean paramBoolean)
  {
    super(paramList, paramBoolean);
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
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
        localObject2 = (TextView)paramBaseViewHolder.a(2131365059);
        paramBaseViewHolder = paramCommentEntry.commentId + paramCommentEntry.feedId + paramCommentEntry.status;
        localObject1 = StoryQQTextCacher.a().a(paramBaseViewHolder);
        if ((localObject1 != null) && (this.jdField_a_of_type_Boolean))
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          ((TextView)localObject2).setSpannableFactory(QQText.SPANNABLE_FACTORY);
          ((TextView)localObject2).setOnTouchListener(FeedCommentLego.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego));
          return;
        }
        localObject1 = SpannableStringUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramCommentEntry, FeedCommentLego.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego));
        if (QQStoryContext.a()) {
          ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166514)), 0, ((SpannableStringBuilder)localObject1).length(), 33);
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setSpannableFactory(QQText.SPANNABLE_FACTORY);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLego.CommentInnerAdpter
 * JD-Core Version:    0.7.0.1
 */