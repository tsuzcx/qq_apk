package com.tencent.biz.pubaccount.weishi_new.comment;

public class WSCommentClickListenerFactory
{
  public static WSOnCommentClickListener a(WsCommentPresenter paramWsCommentPresenter, int paramInt)
  {
    if (paramInt == 12) {
      return new WSCommentClickListenerFactory.ShowMoreCommentListener(paramWsCommentPresenter);
    }
    if (paramInt == 2) {
      return new WSCommentClickListenerFactory.NickNameListener(paramWsCommentPresenter);
    }
    if (paramInt == 1) {
      return new WSCommentClickListenerFactory.AvatarListener(paramWsCommentPresenter);
    }
    if (paramInt == 77) {
      return new WSCommentClickListenerFactory.ReplyItemAvatar(paramWsCommentPresenter);
    }
    if (paramInt == 4) {
      return new WSCommentClickListenerFactory.CommentItemListener(paramWsCommentPresenter);
    }
    if (paramInt == 7) {
      return new WSCommentClickListenerFactory.ReplyItemListener(paramWsCommentPresenter);
    }
    if (paramInt == 10) {
      return new WSCommentClickListenerFactory.MoreReplyListener(paramWsCommentPresenter);
    }
    if (paramInt == 11) {
      return new WSCommentClickListenerFactory.LessReplyListener(paramWsCommentPresenter);
    }
    if (paramInt == 6) {
      return new WSCommentClickListenerFactory.CommentLikeListener(paramWsCommentPresenter);
    }
    if (paramInt == 9) {
      return new WSCommentClickListenerFactory.ReplyLikeListener(paramWsCommentPresenter);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentClickListenerFactory
 * JD-Core Version:    0.7.0.1
 */