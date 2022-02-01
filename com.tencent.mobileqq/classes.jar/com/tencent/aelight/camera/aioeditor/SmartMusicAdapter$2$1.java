package com.tencent.aelight.camera.aioeditor;

import com.tencent.biz.videostory.widget.view.smartmusicview.CircleLayoutManager;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import java.util.List;

class SmartMusicAdapter$2$1
  implements Runnable
{
  SmartMusicAdapter$2$1(SmartMusicAdapter.2 param2) {}
  
  public void run()
  {
    if ((SmartMusicAdapter.a(this.a.b) != null) && (SmartMusicAdapter.d(this.a.b) != null))
    {
      int i = SmartMusicAdapter.d(this.a.b).a() % this.a.b.b();
      SmartMusicAdapter.a(this.a.b).a((VsMusicItemInfo)SmartMusicAdapter.c(this.a.b).get(i), i, this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.SmartMusicAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */