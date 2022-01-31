package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;
import uqo;
import urd;
import urr;
import uru;
import wec;
import weh;
import wkp;
import wkv;
import wsv;

public class DetailFeedAllInfoPuller$1
  implements Runnable
{
  public DetailFeedAllInfoPuller$1(wec paramwec) {}
  
  public void run()
  {
    boolean bool2 = false;
    Object localObject1 = (CommentLikeFeedItem)((wkp)urr.a(11)).a(wec.a(this.this$0));
    if (localObject1 == null)
    {
      wec.a(this.this$0, wec.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
      return;
    }
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof VideoListFeedItem))
    {
      localObject2 = (VideoListFeedItem)localObject1;
      localObject3 = ((wkv)urr.a(12)).a(wec.a(this.this$0), ((VideoListFeedItem)localObject2).mVideoPullType);
      if (localObject3 == null)
      {
        wec.a(this.this$0, wec.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
        return;
      }
      ((VideoListFeedItem)localObject2).mVideoNextCookie = ((FeedVideoInfo)localObject3).mVideoNextCookie;
      ((VideoListFeedItem)localObject2).mIsVideoEnd = ((FeedVideoInfo)localObject3).mIsVideoEnd;
      ((VideoListFeedItem)localObject2).mVideoPullType = ((FeedVideoInfo)localObject3).mVideoPullType;
      ((VideoListFeedItem)localObject2).mVideoSeq = ((FeedVideoInfo)localObject3).mVideoSeq;
      wec.a(this.this$0).a(((FeedVideoInfo)localObject3).mVideoItemList, true);
      localObject2 = ((uru)urr.a(27)).a(wec.a(this.this$0), ((FeedVideoInfo)localObject3).mVideoItemList);
      wec.a(this.this$0).b((List)localObject2, true);
    }
    wec.a(this.this$0).a = ((CommentLikeFeedItem)localObject1);
    if (this.this$0.a)
    {
      localObject2 = (urd)urr.a(15);
      localObject1 = ((urd)localObject2).a(wec.a(this.this$0), wec.a(this.this$0));
      wec.a(this.this$0).b((List)localObject1, true, wec.a(this.this$0));
      localObject1 = (uqo)urr.a(17);
      localObject3 = ((uqo)localObject1).a(wec.a(this.this$0), wec.a(this.this$0));
      wec.a(this.this$0).a((List)localObject3, true, wec.a(this.this$0));
      if (wec.a(this.this$0).a())
      {
        localObject3 = wec.a(this.this$0);
        if (wec.a(this.this$0)) {
          break label510;
        }
        bool1 = true;
        localObject2 = ((urd)localObject2).a((String)localObject3, bool1);
        localObject3 = wec.a(this.this$0);
        if (wec.a(this.this$0)) {
          break label515;
        }
        bool1 = true;
        label401:
        ((weh)localObject3).b((List)localObject2, true, bool1);
        localObject2 = wec.a(this.this$0);
        if (wec.a(this.this$0)) {
          break label520;
        }
      }
    }
    label515:
    label520:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = ((uqo)localObject1).a((String)localObject2, bool1);
      localObject2 = wec.a(this.this$0);
      bool1 = bool2;
      if (!wec.a(this.this$0)) {
        bool1 = true;
      }
      ((weh)localObject2).a((List)localObject1, true, bool1);
      wsv.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "load feed data from cache: %s.", wec.a(this.this$0).toString());
      wec.a(this.this$0, wec.a(this.this$0), true, new ErrorMessage());
      return;
      label510:
      bool1 = false;
      break;
      bool1 = false;
      break label401;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.1
 * JD-Core Version:    0.7.0.1
 */