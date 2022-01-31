package com.tencent.biz.qqstory.album;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import nca;
import ueb;
import uee;

public class StoryAlbumResourceDownloader$3
  implements Runnable
{
  public StoryAlbumResourceDownloader$3(ueb paramueb) {}
  
  public void run()
  {
    new nca(QQStoryContext.a().getApp().getBaseContext(), "http://3408?_bid=3408", new uee(this)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryAlbumResourceDownloader.3
 * JD-Core Version:    0.7.0.1
 */