package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Message;

class HWEditImportVideoPlayer$4
  implements Runnable
{
  HWEditImportVideoPlayer$4(HWEditImportVideoPlayer paramHWEditImportVideoPlayer) {}
  
  public void run()
  {
    if (this.this$0.w) {
      return;
    }
    EditMusicExport localEditMusicExport = (EditMusicExport)this.this$0.b(EditMusicExport.class);
    if (localEditMusicExport != null) {
      localEditMusicExport.d();
    }
    this.this$0.t.a(Message.obtain(null, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditImportVideoPlayer.4
 * JD-Core Version:    0.7.0.1
 */