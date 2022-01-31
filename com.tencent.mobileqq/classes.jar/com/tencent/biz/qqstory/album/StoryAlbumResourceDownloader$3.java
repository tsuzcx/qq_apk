package com.tencent.biz.qqstory.album;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mzj;
import spm;
import spp;

public class StoryAlbumResourceDownloader$3
  implements Runnable
{
  public StoryAlbumResourceDownloader$3(spm paramspm) {}
  
  public void run()
  {
    new mzj(QQStoryContext.a().getApp().getBaseContext(), "http://3408?_bid=3408", new spp(this)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.StoryAlbumResourceDownloader.3
 * JD-Core Version:    0.7.0.1
 */