package com.tencent.biz.qqstory.playvideo.playerwidget;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.FileDownloadListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;

class BottomVideoInfoWidget$OnSimpleShareListenerImpl$1
  implements StorySingleFileDownloader.FileDownloadListener
{
  BottomVideoInfoWidget$OnSimpleShareListenerImpl$1(BottomVideoInfoWidget.OnSimpleShareListenerImpl paramOnSimpleShareListenerImpl) {}
  
  public void a(String paramString, int paramInt)
  {
    SLog.d(this.a.a.i, "save -info download suc , start watermark ,vid:%s", new Object[] { BottomVideoInfoWidget.OnSimpleShareListenerImpl.a(this.a).mVid });
    PlayModeUtils.a(BottomVideoInfoWidget.OnSimpleShareListenerImpl.a(this.a), BottomVideoInfoWidget.OnSimpleShareListenerImpl.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void a(String paramString, int paramInt, ErrorMessage paramErrorMessage)
  {
    SLog.d(this.a.a.i, "save video -info download error , vid:%s , error :%s", new Object[] { BottomVideoInfoWidget.OnSimpleShareListenerImpl.a(this.a).mVid, paramErrorMessage.toString() });
    PlayModeUtils.a(BottomVideoInfoWidget.OnSimpleShareListenerImpl.a(this.a), BottomVideoInfoWidget.OnSimpleShareListenerImpl.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
  
  public void b(String paramString, int paramInt)
  {
    SLog.d(this.a.a.i, "save video -info download cancel , vid:%s ", new Object[] { BottomVideoInfoWidget.OnSimpleShareListenerImpl.a(this.a).mVid });
    PlayModeUtils.a(BottomVideoInfoWidget.OnSimpleShareListenerImpl.a(this.a), BottomVideoInfoWidget.OnSimpleShareListenerImpl.a(this.a).mStoryType, String.valueOf(this.a.a.hashCode()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.OnSimpleShareListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */