package com.tencent.biz.qqstory.album;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import nmo;
import wfr;
import wfu;

public class StoryAlbumResourceDownloader$3
  implements Runnable
{
  public StoryAlbumResourceDownloader$3(wfr paramwfr) {}
  
  public void run()
  {
    new nmo(QQStoryContext.a().getApp().getBaseContext(), "https://3408?_bid=3408", new wfu(this)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryAlbumResourceDownloader.3
 * JD-Core Version:    0.7.0.1
 */