package com.tencent.biz.qqstory.takevideo;

class HWEditLocalVideoPlayer$5
  implements Runnable
{
  HWEditLocalVideoPlayer$5(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    Object localObject = (EditMusicExport)this.this$0.a(EditMusicExport.class);
    if (localObject != null) {
      ((EditMusicExport)localObject).b();
    }
    localObject = (EditSubtitleExport)this.this$0.a(EditSubtitleExport.class);
    if (localObject != null) {
      ((EditSubtitleExport)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */