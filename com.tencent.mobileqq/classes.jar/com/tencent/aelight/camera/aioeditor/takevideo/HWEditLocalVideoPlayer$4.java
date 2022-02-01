package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Message;

class HWEditLocalVideoPlayer$4
  implements Runnable
{
  HWEditLocalVideoPlayer$4(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    EditMusicExport localEditMusicExport = (EditMusicExport)this.this$0.b(EditMusicExport.class);
    if (localEditMusicExport != null) {
      localEditMusicExport.d();
    }
    this.this$0.t.a(Message.obtain(null, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.4
 * JD-Core Version:    0.7.0.1
 */