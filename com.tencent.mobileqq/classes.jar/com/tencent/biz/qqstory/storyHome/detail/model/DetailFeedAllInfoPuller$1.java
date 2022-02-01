package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;
import woj;
import woy;
import wpm;
import wpp;
import ybw;
import ycb;
import yij;
import yip;
import yqp;

public class DetailFeedAllInfoPuller$1
  implements Runnable
{
  public DetailFeedAllInfoPuller$1(ybw paramybw) {}
  
  public void run()
  {
    boolean bool2 = false;
    Object localObject1 = (CommentLikeFeedItem)((yij)wpm.a(11)).a(ybw.a(this.this$0));
    if (localObject1 == null)
    {
      ybw.a(this.this$0, ybw.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
      return;
    }
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof VideoListFeedItem))
    {
      localObject2 = (VideoListFeedItem)localObject1;
      localObject3 = ((yip)wpm.a(12)).a(ybw.a(this.this$0), ((VideoListFeedItem)localObject2).mVideoPullType);
      if (localObject3 == null)
      {
        ybw.a(this.this$0, ybw.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
        return;
      }
      ((VideoListFeedItem)localObject2).mVideoNextCookie = ((FeedVideoInfo)localObject3).mVideoNextCookie;
      ((VideoListFeedItem)localObject2).mIsVideoEnd = ((FeedVideoInfo)localObject3).mIsVideoEnd;
      ((VideoListFeedItem)localObject2).mVideoPullType = ((FeedVideoInfo)localObject3).mVideoPullType;
      ((VideoListFeedItem)localObject2).mVideoSeq = ((FeedVideoInfo)localObject3).mVideoSeq;
      ybw.a(this.this$0).a(((FeedVideoInfo)localObject3).mVideoItemList, true);
      localObject2 = ((wpp)wpm.a(27)).a(ybw.a(this.this$0), ((FeedVideoInfo)localObject3).mVideoItemList);
      ybw.a(this.this$0).b((List)localObject2, true);
    }
    ybw.a(this.this$0).a = ((CommentLikeFeedItem)localObject1);
    if (this.this$0.a)
    {
      localObject2 = (woy)wpm.a(15);
      localObject1 = ((woy)localObject2).a(ybw.a(this.this$0), ybw.a(this.this$0));
      ybw.a(this.this$0).b((List)localObject1, true, ybw.a(this.this$0));
      localObject1 = (woj)wpm.a(17);
      localObject3 = ((woj)localObject1).a(ybw.a(this.this$0), ybw.a(this.this$0));
      ybw.a(this.this$0).a((List)localObject3, true, ybw.a(this.this$0));
      if (ybw.a(this.this$0).a())
      {
        localObject3 = ybw.a(this.this$0);
        if (ybw.a(this.this$0)) {
          break label510;
        }
        bool1 = true;
        localObject2 = ((woy)localObject2).a((String)localObject3, bool1);
        localObject3 = ybw.a(this.this$0);
        if (ybw.a(this.this$0)) {
          break label515;
        }
        bool1 = true;
        label401:
        ((ycb)localObject3).b((List)localObject2, true, bool1);
        localObject2 = ybw.a(this.this$0);
        if (ybw.a(this.this$0)) {
          break label520;
        }
      }
    }
    label515:
    label520:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = ((woj)localObject1).a((String)localObject2, bool1);
      localObject2 = ybw.a(this.this$0);
      bool1 = bool2;
      if (!ybw.a(this.this$0)) {
        bool1 = true;
      }
      ((ycb)localObject2).a((List)localObject1, true, bool1);
      yqp.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "load feed data from cache: %s.", ybw.a(this.this$0).toString());
      ybw.a(this.this$0, ybw.a(this.this$0), true, new ErrorMessage());
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