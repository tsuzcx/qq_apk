package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;

class BottomVideoInfoWidget$8$1
  implements Runnable
{
  BottomVideoInfoWidget$8$1(BottomVideoInfoWidget.8 param8) {}
  
  public void run()
  {
    Activity localActivity = this.a.h.y();
    if (StoryPublishLauncher.a().b(localActivity, new Bundle(), 467)) {
      BottomVideoInfoWidget.a(this.a.h, localActivity, this.a.a, this.a.b, this.a.c, this.a.d, this.a.e, this.a.f, this.a.g);
    } else {
      BottomVideoInfoWidget.a(this.a.h, new BottomVideoInfoWidget.8.1.1(this, localActivity));
    }
    this.a.h.E();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.8.1
 * JD-Core Version:    0.7.0.1
 */