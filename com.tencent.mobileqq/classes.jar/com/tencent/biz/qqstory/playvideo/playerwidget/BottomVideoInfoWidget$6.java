package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.FileDownloadListener;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;

class BottomVideoInfoWidget$6
  implements StorySingleFileDownloader.FileDownloadListener
{
  BottomVideoInfoWidget$6(BottomVideoInfoWidget paramBottomVideoInfoWidget, VideoViewVideoHolder paramVideoViewVideoHolder, StoryVideoItem paramStoryVideoItem, QQUserUIItem paramQQUserUIItem, String paramString) {}
  
  public void a(String paramString, int paramInt)
  {
    this.a.c(false);
    paramString = FileCacheUtils.a(this.b.mVid, 0, false, false);
    if (paramString != null)
    {
      paramString = paramString.getPath();
      ThreadManager.getUIHandlerV2().post(new BottomVideoInfoWidget.6.1(this, paramString));
    }
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    this.a.c(false);
    ThreadManager.getUIHandlerV2().post(new BottomVideoInfoWidget.6.3(this));
  }
  
  public void b(String paramString, int paramInt)
  {
    this.a.c(false);
    ThreadManager.getUIHandlerV2().post(new BottomVideoInfoWidget.6.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.6
 * JD-Core Version:    0.7.0.1
 */