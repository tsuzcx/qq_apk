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
    while (i < this.a.f.size())
    {
      if (TextUtils.equals(paramString, ((StoryPlayerVideoData)this.a.f.get(i)).b)) {
        ((StoryPlayerGroupHolder)this.a.d()).j.setCurrentItem(i);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoCoverListGroupHolder.1
 * JD-Core Version:    0.7.0.1
 */