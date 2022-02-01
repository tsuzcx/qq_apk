package com.tencent.mobileqq.activity.richmedia.p2veffect.music;

import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.takevideo.music.QQStoryBGMusicUtils;

class P2VEditMusicDialog$3
  implements Runnable
{
  P2VEditMusicDialog$3(P2VEditMusicDialog paramP2VEditMusicDialog, String paramString) {}
  
  public void run()
  {
    String str = QQStoryBGMusicUtils.a(this.a);
    this.this$0.a = new DownloaderImp();
    this.this$0.a.a(this.this$0);
    this.this$0.a.a(this.a, str, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.3
 * JD-Core Version:    0.7.0.1
 */