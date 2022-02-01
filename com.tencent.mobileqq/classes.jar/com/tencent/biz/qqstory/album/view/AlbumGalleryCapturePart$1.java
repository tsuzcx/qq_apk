package com.tencent.biz.qqstory.album.view;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AlbumGalleryCapturePart$1
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AlbumGalleryCapturePart.a(this.a);
      if (AlbumGalleryCapturePart.a(this.a)) {
        StoryReportor.a("video_shoot_slides", "clk_setting_on", 0, 0, new String[0]);
      }
    }
    for (;;)
    {
      AlbumGalleryCapturePart.a(this.a, paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      AlbumGalleryCapturePart.b(this.a);
      if (AlbumGalleryCapturePart.a(this.a)) {
        StoryReportor.a("video_shoot_slides", "clk_setting_close", 0, 0, new String[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.1
 * JD-Core Version:    0.7.0.1
 */