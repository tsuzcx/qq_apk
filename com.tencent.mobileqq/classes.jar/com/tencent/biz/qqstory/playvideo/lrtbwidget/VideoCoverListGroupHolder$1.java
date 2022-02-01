package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar.OnVideoClickListener;
import java.util.List;

class VideoCoverListGroupHolder$1
  implements VideoCoverListBar.OnVideoClickListener
{
  VideoCoverListGroupHolder$1(VideoCoverListGroupHolder paramVideoCoverListGroupHolder) {}
  
  public void a(String paramString)
  {
    int i = 0;
    while (i < this.a.a.size())
    {
      if (TextUtils.equals(paramString, ((StoryPlayerVideoData)this.a.a.get(i)).a)) {
        ((StoryPlayerGroupHolder)this.a.a()).a.setCurrentItem(i);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoCoverListGroupHolder.1
 * JD-Core Version:    0.7.0.1
 */