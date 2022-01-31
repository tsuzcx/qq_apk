package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;
import tbz;
import tco;
import tdc;
import tdf;
import upn;
import ups;
import uwa;
import uwg;
import veg;

public class DetailFeedAllInfoPuller$1
  implements Runnable
{
  public DetailFeedAllInfoPuller$1(upn paramupn) {}
  
  public void run()
  {
    boolean bool2 = false;
    Object localObject1 = (CommentLikeFeedItem)((uwa)tdc.a(11)).a(upn.a(this.this$0));
    if (localObject1 == null)
    {
      upn.a(this.this$0, upn.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
      return;
    }
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof VideoListFeedItem))
    {
      localObject2 = (VideoListFeedItem)localObject1;
      localObject3 = ((uwg)tdc.a(12)).a(upn.a(this.this$0), ((VideoListFeedItem)localObject2).mVideoPullType);
      if (localObject3 == null)
      {
        upn.a(this.this$0, upn.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
        return;
      }
      ((VideoListFeedItem)localObject2).mVideoNextCookie = ((FeedVideoInfo)localObject3).mVideoNextCookie;
      ((VideoListFeedItem)localObject2).mIsVideoEnd = ((FeedVideoInfo)localObject3).mIsVideoEnd;
      ((VideoListFeedItem)localObject2).mVideoPullType = ((FeedVideoInfo)localObject3).mVideoPullType;
      ((VideoListFeedItem)localObject2).mVideoSeq = ((FeedVideoInfo)localObject3).mVideoSeq;
      upn.a(this.this$0).a(((FeedVideoInfo)localObject3).mVideoItemList, true);
      localObject2 = ((tdf)tdc.a(27)).a(upn.a(this.this$0), ((FeedVideoInfo)localObject3).mVideoItemList);
      upn.a(this.this$0).b((List)localObject2, true);
    }
    upn.a(this.this$0).a = ((CommentLikeFeedItem)localObject1);
    if (this.this$0.a)
    {
      localObject2 = (tco)tdc.a(15);
      localObject1 = ((tco)localObject2).a(upn.a(this.this$0), upn.a(this.this$0));
      upn.a(this.this$0).b((List)localObject1, true, upn.a(this.this$0));
      localObject1 = (tbz)tdc.a(17);
      localObject3 = ((tbz)localObject1).a(upn.a(this.this$0), upn.a(this.this$0));
      upn.a(this.this$0).a((List)localObject3, true, upn.a(this.this$0));
      if (upn.a(this.this$0).a())
      {
        localObject3 = upn.a(this.this$0);
        if (upn.a(this.this$0)) {
          break label510;
        }
        bool1 = true;
        localObject2 = ((tco)localObject2).a((String)localObject3, bool1);
        localObject3 = upn.a(this.this$0);
        if (upn.a(this.this$0)) {
          break label515;
        }
        bool1 = true;
        label401:
        ((ups)localObject3).b((List)localObject2, true, bool1);
        localObject2 = upn.a(this.this$0);
        if (upn.a(this.this$0)) {
          break label520;
        }
      }
    }
    label515:
    label520:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = ((tbz)localObject1).a((String)localObject2, bool1);
      localObject2 = upn.a(this.this$0);
      bool1 = bool2;
      if (!upn.a(this.this$0)) {
        bool1 = true;
      }
      ((ups)localObject2).a((List)localObject1, true, bool1);
      veg.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "load feed data from cache: %s.", upn.a(this.this$0).toString());
      upn.a(this.this$0, upn.a(this.this$0), true, new ErrorMessage());
      return;
      label510:
      bool1 = false;
      break;
      bool1 = false;
      break label401;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.1
 * JD-Core Version:    0.7.0.1
 */