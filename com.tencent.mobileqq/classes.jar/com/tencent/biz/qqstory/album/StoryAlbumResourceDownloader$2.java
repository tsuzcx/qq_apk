package com.tencent.biz.qqstory.album;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.qqstory.support.logging.SLog;

class StoryAlbumResourceDownloader$2
  implements AsyncBack
{
  StoryAlbumResourceDownloader$2(StoryAlbumResourceDownloader paramStoryAlbumResourceDownloader, boolean paramBoolean) {}
  
  public void loaded(String paramString, int paramInt)
  {
    SLog.a("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkResource loaded code = %d ", Integer.valueOf(paramInt));
    if (paramInt != -1) {
      if (paramInt != 0)
      {
        if (paramInt == 5) {}
      }
      else
      {
        if (this.a) {
          StoryAlbumResourceDownloader.a(this.b);
        }
        SLog.a("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkResource download success", Integer.valueOf(paramInt));
      }
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryAlbumResourceDownloader.2
 * JD-Core Version:    0.7.0.1
 */