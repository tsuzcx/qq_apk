package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class CommentFloatDialogController$GetFeedItemSegment
  extends JobSegment<String, DetailFeedItem>
{
  public CommentFloatDialogController$GetFeedItemSegment(CommentFloatDialogController paramCommentFloatDialogController) {}
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    if ((CommentFloatDialogController.a(this.a).a != null) && (TextUtils.equals(CommentFloatDialogController.a(this.a).a.feedId, paramString)))
    {
      SLog.d("Q.qqstory.player.CommentFloatDialogController", "feed item already exist , no need to pull again");
      notifyError(new ErrorMessage(2223, "feed item already exist"));
      return;
    }
    paramString = new DetailFeedItem();
    Object localObject1 = (CommentLikeFeedItem)((FeedManager)SuperManager.a(11)).a(CommentFloatDialogController.a(this.a));
    if (localObject1 != null)
    {
      if ((localObject1 instanceof VideoListFeedItem))
      {
        paramJobContext = (VideoListFeedItem)localObject1;
        localObject2 = ((FeedVideoManager)SuperManager.a(12)).a(CommentFloatDialogController.a(this.a), paramJobContext.mVideoPullType);
        if (localObject2 != null)
        {
          paramJobContext.mVideoNextCookie = ((FeedVideoInfo)localObject2).mVideoNextCookie;
          paramJobContext.mIsVideoEnd = ((FeedVideoInfo)localObject2).mIsVideoEnd;
          paramJobContext.mVideoPullType = ((FeedVideoInfo)localObject2).mVideoPullType;
          paramJobContext.mVideoSeq = ((FeedVideoInfo)localObject2).mVideoSeq;
          paramString.a(((FeedVideoInfo)localObject2).mVideoItemList, true);
        }
      }
      paramString.a = ((CommentLikeFeedItem)localObject1);
      notifyResult(paramString);
      return;
    }
    localObject1 = new BatchGetFriendStoryFeedInfoRequest();
    ((BatchGetFriendStoryFeedInfoRequest)localObject1).a = new ArrayList();
    Object localObject2 = new FeedIdListSeqInfo(CommentFloatDialogController.a(this.a), 0, "", "");
    ((BatchGetFriendStoryFeedInfoRequest)localObject1).a.add(localObject2);
    CmdTaskManger.a().a((NetworkRequest)localObject1, new CommentFloatDialogController.GetFeedItemSegment.1(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController.GetFeedItemSegment
 * JD-Core Version:    0.7.0.1
 */