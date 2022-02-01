package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;

public class CommentFloatDialogController$FeedInfoUpdateReceiver
  extends UIBaseEventReceiver<CommentFloatDialogController, FeedInfoChangeEvent>
{
  public CommentFloatDialogController$FeedInfoUpdateReceiver(CommentFloatDialogController paramCommentFloatDialogController)
  {
    super(paramCommentFloatDialogController);
  }
  
  public void a(@NonNull CommentFloatDialogController paramCommentFloatDialogController, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent)
  {
    if ((paramFeedInfoChangeEvent.jdField_a_of_type_Int != 2) && (paramFeedInfoChangeEvent.jdField_a_of_type_JavaLangString.equals(CommentFloatDialogController.a(paramCommentFloatDialogController))) && (CommentFloatDialogController.a(paramCommentFloatDialogController) != null) && (CommentFloatDialogController.a(paramCommentFloatDialogController).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null))
    {
      SLog.a(this.TAG, "receive feed info change event. %s.", paramFeedInfoChangeEvent.toString());
      CommentFloatDialogController.OnDataChangeListener localOnDataChangeListener = paramCommentFloatDialogController.a();
      if (paramFeedInfoChangeEvent.b != 2) {
        return;
      }
      if (paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        CommentFloatDialogController.a(paramCommentFloatDialogController).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        CommentFloatDialogController.a(paramCommentFloatDialogController).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        CommentFloatDialogController.a(paramCommentFloatDialogController).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      CommentFloatDialogController.a(paramCommentFloatDialogController).a(paramFeedInfoChangeEvent.c);
      if (localOnDataChangeListener != null) {
        localOnDataChangeListener.a(CommentFloatDialogController.a(paramCommentFloatDialogController), paramFeedInfoChangeEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
      }
      return;
    }
    SLog.b(this.TAG, "ignore this feed info change event. %s.", paramFeedInfoChangeEvent.toString());
  }
  
  public Class acceptEventClass()
  {
    return FeedInfoChangeEvent.class;
  }
  
  public void b(@NonNull CommentFloatDialogController paramCommentFloatDialogController, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController.FeedInfoUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */