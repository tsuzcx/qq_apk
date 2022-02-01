package com.tencent.biz.qqstory.playvideo;

import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.support.ImageDownloader.FILE;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.TimeZone;

class VideoCoverListBar$VideoCoverListBarAdapter$ViewHolder
{
  private VideoCoverImgBorder b;
  private TextView c;
  private String d;
  
  public VideoCoverListBar$VideoCoverListBarAdapter$ViewHolder(VideoCoverListBar.VideoCoverListBarAdapter paramVideoCoverListBarAdapter, View paramView)
  {
    this.b = ((VideoCoverImgBorder)paramView.findViewById(2131429608));
    this.c = ((TextView)paramView.findViewById(2131447345));
    this.b.setOnClickListener(new VideoCoverListBar.VideoCoverListBarAdapter.ViewHolder.1(this, paramVideoCoverListBarAdapter));
  }
  
  private void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      UIUtils.a(this.b, paramString, VideoCoverListBar.h(this.a.a), VideoCoverListBar.h(this.a.a), VideoCoverListBar.i(this.a.a), VideoCoverListBar.j(this.a.a), "VideoCoverList");
      return;
    }
    UIUtils.a(this.b, paramString, VideoCoverListBar.h(this.a.a), VideoCoverListBar.k(this.a.a), VideoCoverListBar.i(this.a.a), VideoCoverListBar.j(this.a.a), "VideoCoverList");
  }
  
  public void a(int paramInt)
  {
    SLog.a("Q.qqstory.player:VideoCoverListBar", "bindView, position=%d", Integer.valueOf(paramInt));
    this.d = this.a.a(paramInt);
    StoryVideoItem localStoryVideoItem = VideoCoverListBar.f(this.a.a).b(this.d);
    Object localObject = localStoryVideoItem;
    if (localStoryVideoItem == null)
    {
      localObject = new StoryVideoItem();
      ((StoryVideoItem)localObject).mVid = this.d;
    }
    if (!TextUtils.isEmpty(((StoryVideoItem)localObject).getThumbUrl())) {
      a(ThumbnailUrlHelper.a(((StoryVideoItem)localObject).getThumbUrl()), paramInt);
    } else {
      a(ThumbnailUrlHelper.a(ImageDownloader.FILE.a(((StoryVideoItem)localObject).mVideoLocalThumbnailPath)), paramInt);
    }
    if (((StoryVideoItem)localObject).isUploadFail()) {
      this.b.setState(0);
    } else if (TextUtils.isEmpty(VideoCoverListBar.a(this.a.a))) {
      this.b.setState(2);
    } else if (TextUtils.equals(this.d, VideoCoverListBar.a(this.a.a))) {
      this.b.setState(1);
    } else {
      this.b.setState(2);
    }
    if ((!VideoCoverListBar.g(this.a.a).b()) && (!VideoCoverListBar.g(this.a.a).c()))
    {
      if ((!PlayModeUtils.b((StoryVideoItem)localObject)) && (((StoryVideoItem)localObject).mErrorCode == 0))
      {
        long l2 = ((StoryVideoItem)localObject).mCreateTime;
        long l1;
        boolean bool;
        if (((StoryVideoItem)localObject).mTimeZoneOffsetMillis != 2147483647L)
        {
          l1 = ((StoryVideoItem)localObject).mTimeZoneOffsetMillis;
          bool = true;
        }
        else
        {
          l1 = TimeZone.getDefault().getRawOffset();
          bool = false;
        }
        localObject = StoryListUtils.a(l2, l1, bool, false, true);
        this.c.setText((CharSequence)localObject);
        this.b.setColorFilter(1711276032, PorterDuff.Mode.SRC_ATOP);
        return;
      }
      this.c.setText("");
      this.b.setColorFilter(1711276032, PorterDuff.Mode.SRC_ATOP);
      return;
    }
    this.c.setText("");
    this.b.clearColorFilter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverListBar.VideoCoverListBarAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */