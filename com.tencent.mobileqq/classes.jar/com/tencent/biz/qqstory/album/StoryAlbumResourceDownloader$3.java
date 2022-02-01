package com.tencent.biz.qqstory.album;

import com.tencent.biz.common.offline.HtmlOffline.TransUrl;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class StoryAlbumResourceDownloader$3
  implements Runnable
{
  public void run()
  {
    new HtmlOffline.TransUrl(QQStoryContext.a().getApp().getBaseContext(), "https://3408?_bid=3408", new StoryAlbumResourceDownloader.3.1(this)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryAlbumResourceDownloader.3
 * JD-Core Version:    0.7.0.1
 */