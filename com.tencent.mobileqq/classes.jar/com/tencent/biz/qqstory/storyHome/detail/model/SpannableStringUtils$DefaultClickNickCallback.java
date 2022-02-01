package com.tencent.biz.qqstory.storyHome.detail.model;

import android.content.Context;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import java.lang.ref.WeakReference;

public class SpannableStringUtils$DefaultClickNickCallback
  implements SpannableStringUtils.ClickNickCallback
{
  private WeakReference<Context> a;
  private CommentLikeFeedItem b;
  private int c;
  private boolean d;
  
  public SpannableStringUtils$DefaultClickNickCallback(Context paramContext, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, boolean paramBoolean)
  {
    this.a = new WeakReference(paramContext);
    this.b = paramCommentLikeFeedItem;
    this.c = paramInt;
    this.d = paramBoolean;
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.b = paramCommentLikeFeedItem;
  }
  
  public void a(String paramString, int paramInt)
  {
    SLog.a("Q.qqstory.detail.SpannableStringUtils", "on nick click. unionId = %s.", paramString);
    if (paramInt != 1002)
    {
      if (paramInt == 1003) {
        return;
      }
      Object localObject1 = (Context)this.a.get();
      if (localObject1 != null) {
        StoryApi.a((Context)localObject1, 12, paramString);
      }
      if (this.b != null)
      {
        if (this.d) {
          paramString = "clk_reply_nick";
        } else {
          paramString = "clk_like_name";
        }
        Object localObject2 = this.b;
        boolean bool = localObject2 instanceof VideoListFeedItem;
        localObject1 = "2";
        if (bool)
        {
          localObject2 = (VideoListFeedItem)localObject2;
          int i = StoryReportor.a((FeedItem)localObject2);
          paramInt = i;
          if (((VideoListFeedItem)localObject2).getOwner().isMe())
          {
            localObject1 = "1";
            paramInt = i;
          }
        }
        else
        {
          paramInt = 4;
        }
        StoryReportor.a("home_page", paramString, paramInt, 0, new String[] { localObject1, StoryReportor.b(this.c), "", this.b.feedId });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils.DefaultClickNickCallback
 * JD-Core Version:    0.7.0.1
 */