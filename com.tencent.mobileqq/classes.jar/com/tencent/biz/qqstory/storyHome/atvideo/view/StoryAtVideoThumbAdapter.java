package com.tencent.biz.qqstory.storyHome.atvideo.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.FeedItemThumbAdapter;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView.StoryCoverClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;

public class StoryAtVideoThumbAdapter
  extends FeedItemThumbAdapter
  implements QQStoryAutoPlayView.StoryCoverClickListener
{
  public StoryAtVideoThumbAdapter(Context paramContext, Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramContext, paramActivity, paramInt1, paramInt2);
    super.a(this);
  }
  
  public static void a(Activity paramActivity, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem)
  {
    StringBuilder localStringBuilder1 = null;
    if ((paramVideoListFeedItem != null) && (paramStoryVideoItem != null))
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      if (paramStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {
        localStringBuilder2.append(UIUtils.a(paramStoryVideoItem.mCreateTime, paramStoryVideoItem.mTimeZoneOffsetMillis));
      } else {
        localStringBuilder2.append(UIUtils.b(paramStoryVideoItem.mCreateTime));
      }
      paramVideoListFeedItem = localStringBuilder1;
      paramStoryVideoItem = localStringBuilder2;
      if (localStringBuilder2.length() > 0)
      {
        paramVideoListFeedItem = new Intent();
        paramVideoListFeedItem.putExtra("at_video_text", localStringBuilder2.toString());
        paramStoryVideoItem = localStringBuilder2;
      }
    }
    else
    {
      paramStoryVideoItem = null;
      paramVideoListFeedItem = localStringBuilder1;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("set result ok. At video text is:");
      if (paramStoryVideoItem == null) {
        paramStoryVideoItem = "";
      } else {
        paramStoryVideoItem = paramStoryVideoItem.toString();
      }
      localStringBuilder1.append(paramStoryVideoItem);
      QLog.d("Q.qqstory.detail.FeedItemThumbAdapter", 2, localStringBuilder1.toString());
    }
    paramActivity.setResult(-1, paramVideoListFeedItem);
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (UIUtils.d()) {
      return;
    }
    a(this.d, paramVideoListFeedItem, paramStoryVideoItem);
    StoryReportor.a("home_page", "choose_video", 0, 0, new String[0]);
    this.d.finish();
  }
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoThumbAdapter
 * JD-Core Version:    0.7.0.1
 */