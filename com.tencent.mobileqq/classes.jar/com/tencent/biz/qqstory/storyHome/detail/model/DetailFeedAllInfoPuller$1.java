package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;
import wip;
import wje;
import wjs;
import wjv;
import xvx;
import xwc;
import yck;
import ycq;
import ykq;

public class DetailFeedAllInfoPuller$1
  implements Runnable
{
  public DetailFeedAllInfoPuller$1(xvx paramxvx) {}
  
  public void run()
  {
    boolean bool2 = false;
    Object localObject1 = (CommentLikeFeedItem)((yck)wjs.a(11)).a(xvx.a(this.this$0));
    if (localObject1 == null)
    {
      xvx.a(this.this$0, xvx.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
      return;
    }
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof VideoListFeedItem))
    {
      localObject2 = (VideoListFeedItem)localObject1;
      localObject3 = ((ycq)wjs.a(12)).a(xvx.a(this.this$0), ((VideoListFeedItem)localObject2).mVideoPullType);
      if (localObject3 == null)
      {
        xvx.a(this.this$0, xvx.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
        return;
      }
      ((VideoListFeedItem)localObject2).mVideoNextCookie = ((FeedVideoInfo)localObject3).mVideoNextCookie;
      ((VideoListFeedItem)localObject2).mIsVideoEnd = ((FeedVideoInfo)localObject3).mIsVideoEnd;
      ((VideoListFeedItem)localObject2).mVideoPullType = ((FeedVideoInfo)localObject3).mVideoPullType;
      ((VideoListFeedItem)localObject2).mVideoSeq = ((FeedVideoInfo)localObject3).mVideoSeq;
      xvx.a(this.this$0).a(((FeedVideoInfo)localObject3).mVideoItemList, true);
      localObject2 = ((wjv)wjs.a(27)).a(xvx.a(this.this$0), ((FeedVideoInfo)localObject3).mVideoItemList);
      xvx.a(this.this$0).b((List)localObject2, true);
    }
    xvx.a(this.this$0).a = ((CommentLikeFeedItem)localObject1);
    if (this.this$0.a)
    {
      localObject2 = (wje)wjs.a(15);
      localObject1 = ((wje)localObject2).a(xvx.a(this.this$0), xvx.a(this.this$0));
      xvx.a(this.this$0).b((List)localObject1, true, xvx.a(this.this$0));
      localObject1 = (wip)wjs.a(17);
      localObject3 = ((wip)localObject1).a(xvx.a(this.this$0), xvx.a(this.this$0));
      xvx.a(this.this$0).a((List)localObject3, true, xvx.a(this.this$0));
      if (xvx.a(this.this$0).a())
      {
        localObject3 = xvx.a(this.this$0);
        if (xvx.a(this.this$0)) {
          break label510;
        }
        bool1 = true;
        localObject2 = ((wje)localObject2).a((String)localObject3, bool1);
        localObject3 = xvx.a(this.this$0);
        if (xvx.a(this.this$0)) {
          break label515;
        }
        bool1 = true;
        label401:
        ((xwc)localObject3).b((List)localObject2, true, bool1);
        localObject2 = xvx.a(this.this$0);
        if (xvx.a(this.this$0)) {
          break label520;
        }
      }
    }
    label515:
    label520:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = ((wip)localObject1).a((String)localObject2, bool1);
      localObject2 = xvx.a(this.this$0);
      bool1 = bool2;
      if (!xvx.a(this.this$0)) {
        bool1 = true;
      }
      ((xwc)localObject2).a((List)localObject1, true, bool1);
      ykq.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "load feed data from cache: %s.", xvx.a(this.this$0).toString());
      xvx.a(this.this$0, xvx.a(this.this$0), true, new ErrorMessage());
      return;
      label510:
      bool1 = false;
      break;
      bool1 = false;
      break label401;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.1
 * JD-Core Version:    0.7.0.1
 */