package com.tencent.biz.qqstory.album;

import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.qqstory.support.logging.SLog;

class StoryAlbumResourceDownloader$3$1
  implements AsyncCallBack
{
  StoryAlbumResourceDownloader$3$1(StoryAlbumResourceDownloader.3 param3) {}
  
  public void loaded(int paramInt, String paramString)
  {
    StoryAlbumResourceDownloader.a(this.a.this$0);
    StoryAlbumResourceDownloader.a(this.a.this$0, false);
    StoryAlbumResourceDownloader.b(this.a.this$0, false);
    SLog.a("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "unzip success , code = %d", Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryAlbumResourceDownloader.3.1
 * JD-Core Version:    0.7.0.1
 */