package com.tencent.biz.qqstory.takevideo.music;

import com.tencent.biz.qqstory.base.download.DownloaderImp;

class EditVideoMusicDialog$3
  implements Runnable
{
  EditVideoMusicDialog$3(EditVideoMusicDialog paramEditVideoMusicDialog, String paramString) {}
  
  public void run()
  {
    String str = QQStoryBGMusicUtils.a(this.a);
    this.this$0.a = new DownloaderImp();
    this.this$0.a.a(1);
    this.this$0.a.a(this.this$0);
    this.this$0.a.a(this.a, str, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog.3
 * JD-Core Version:    0.7.0.1
 */