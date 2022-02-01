package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;
import wse;
import wst;
import wth;
import wtk;
import yfr;
import yfw;
import yme;
import ymk;
import yuk;

public class DetailFeedAllInfoPuller$1
  implements Runnable
{
  public DetailFeedAllInfoPuller$1(yfr paramyfr) {}
  
  public void run()
  {
    boolean bool2 = false;
    Object localObject1 = (CommentLikeFeedItem)((yme)wth.a(11)).a(yfr.a(this.this$0));
    if (localObject1 == null)
    {
      yfr.a(this.this$0, yfr.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
      return;
    }
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof VideoListFeedItem))
    {
      localObject2 = (VideoListFeedItem)localObject1;
      localObject3 = ((ymk)wth.a(12)).a(yfr.a(this.this$0), ((VideoListFeedItem)localObject2).mVideoPullType);
      if (localObject3 == null)
      {
        yfr.a(this.this$0, yfr.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
        return;
      }
      ((VideoListFeedItem)localObject2).mVideoNextCookie = ((FeedVideoInfo)localObject3).mVideoNextCookie;
      ((VideoListFeedItem)localObject2).mIsVideoEnd = ((FeedVideoInfo)localObject3).mIsVideoEnd;
      ((VideoListFeedItem)localObject2).mVideoPullType = ((FeedVideoInfo)localObject3).mVideoPullType;
      ((VideoListFeedItem)localObject2).mVideoSeq = ((FeedVideoInfo)localObject3).mVideoSeq;
      yfr.a(this.this$0).a(((FeedVideoInfo)localObject3).mVideoItemList, true);
      localObject2 = ((wtk)wth.a(27)).a(yfr.a(this.this$0), ((FeedVideoInfo)localObject3).mVideoItemList);
      yfr.a(this.this$0).b((List)localObject2, true);
    }
    yfr.a(this.this$0).a = ((CommentLikeFeedItem)localObject1);
    if (this.this$0.a)
    {
      localObject2 = (wst)wth.a(15);
      localObject1 = ((wst)localObject2).a(yfr.a(this.this$0), yfr.a(this.this$0));
      yfr.a(this.this$0).b((List)localObject1, true, yfr.a(this.this$0));
      localObject1 = (wse)wth.a(17);
      localObject3 = ((wse)localObject1).a(yfr.a(this.this$0), yfr.a(this.this$0));
      yfr.a(this.this$0).a((List)localObject3, true, yfr.a(this.this$0));
      if (yfr.a(this.this$0).a())
      {
        localObject3 = yfr.a(this.this$0);
        if (yfr.a(this.this$0)) {
          break label510;
        }
        bool1 = true;
        localObject2 = ((wst)localObject2).a((String)localObject3, bool1);
        localObject3 = yfr.a(this.this$0);
        if (yfr.a(this.this$0)) {
          break label515;
        }
        bool1 = true;
        label401:
        ((yfw)localObject3).b((List)localObject2, true, bool1);
        localObject2 = yfr.a(this.this$0);
        if (yfr.a(this.this$0)) {
          break label520;
        }
      }
    }
    label515:
    label520:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = ((wse)localObject1).a((String)localObject2, bool1);
      localObject2 = yfr.a(this.this$0);
      bool1 = bool2;
      if (!yfr.a(this.this$0)) {
        bool1 = true;
      }
      ((yfw)localObject2).a((List)localObject1, true, bool1);
      yuk.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "load feed data from cache: %s.", yfr.a(this.this$0).toString());
      yfr.a(this.this$0, yfr.a(this.this$0), true, new ErrorMessage());
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