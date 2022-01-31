package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.List;
import tbw;
import tcl;
import tcz;
import tdc;
import upk;
import upp;
import uvx;
import uwd;
import ved;

public class DetailFeedAllInfoPuller$1
  implements Runnable
{
  public DetailFeedAllInfoPuller$1(upk paramupk) {}
  
  public void run()
  {
    boolean bool2 = false;
    Object localObject1 = (CommentLikeFeedItem)((uvx)tcz.a(11)).a(upk.a(this.this$0));
    if (localObject1 == null)
    {
      upk.a(this.this$0, upk.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
      return;
    }
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof VideoListFeedItem))
    {
      localObject2 = (VideoListFeedItem)localObject1;
      localObject3 = ((uwd)tcz.a(12)).a(upk.a(this.this$0), ((VideoListFeedItem)localObject2).mVideoPullType);
      if (localObject3 == null)
      {
        upk.a(this.this$0, upk.a(this.this$0), true, new ErrorMessage(-1, "no cache data found."));
        return;
      }
      ((VideoListFeedItem)localObject2).mVideoNextCookie = ((FeedVideoInfo)localObject3).mVideoNextCookie;
      ((VideoListFeedItem)localObject2).mIsVideoEnd = ((FeedVideoInfo)localObject3).mIsVideoEnd;
      ((VideoListFeedItem)localObject2).mVideoPullType = ((FeedVideoInfo)localObject3).mVideoPullType;
      ((VideoListFeedItem)localObject2).mVideoSeq = ((FeedVideoInfo)localObject3).mVideoSeq;
      upk.a(this.this$0).a(((FeedVideoInfo)localObject3).mVideoItemList, true);
      localObject2 = ((tdc)tcz.a(27)).a(upk.a(this.this$0), ((FeedVideoInfo)localObject3).mVideoItemList);
      upk.a(this.this$0).b((List)localObject2, true);
    }
    upk.a(this.this$0).a = ((CommentLikeFeedItem)localObject1);
    if (this.this$0.a)
    {
      localObject2 = (tcl)tcz.a(15);
      localObject1 = ((tcl)localObject2).a(upk.a(this.this$0), upk.a(this.this$0));
      upk.a(this.this$0).b((List)localObject1, true, upk.a(this.this$0));
      localObject1 = (tbw)tcz.a(17);
      localObject3 = ((tbw)localObject1).a(upk.a(this.this$0), upk.a(this.this$0));
      upk.a(this.this$0).a((List)localObject3, true, upk.a(this.this$0));
      if (upk.a(this.this$0).a())
      {
        localObject3 = upk.a(this.this$0);
        if (upk.a(this.this$0)) {
          break label510;
        }
        bool1 = true;
        localObject2 = ((tcl)localObject2).a((String)localObject3, bool1);
        localObject3 = upk.a(this.this$0);
        if (upk.a(this.this$0)) {
          break label515;
        }
        bool1 = true;
        label401:
        ((upp)localObject3).b((List)localObject2, true, bool1);
        localObject2 = upk.a(this.this$0);
        if (upk.a(this.this$0)) {
          break label520;
        }
      }
    }
    label515:
    label520:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = ((tbw)localObject1).a((String)localObject2, bool1);
      localObject2 = upk.a(this.this$0);
      bool1 = bool2;
      if (!upk.a(this.this$0)) {
        bool1 = true;
      }
      ((upp)localObject2).a((List)localObject1, true, bool1);
      ved.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "load feed data from cache: %s.", upk.a(this.this$0).toString());
      upk.a(this.this$0, upk.a(this.this$0), true, new ErrorMessage());
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