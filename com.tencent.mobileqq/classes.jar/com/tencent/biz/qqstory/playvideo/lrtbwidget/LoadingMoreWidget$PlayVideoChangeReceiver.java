package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class LoadingMoreWidget$PlayVideoChangeReceiver
  extends QQUIEventReceiver<LoadingMoreWidget, PlayVideoChangeEvent>
{
  public LoadingMoreWidget$PlayVideoChangeReceiver(@NonNull LoadingMoreWidget paramLoadingMoreWidget)
  {
    super(paramLoadingMoreWidget);
  }
  
  public void a(@NonNull LoadingMoreWidget paramLoadingMoreWidget, @NonNull PlayVideoChangeEvent paramPlayVideoChangeEvent)
  {
    if (paramPlayVideoChangeEvent.g.isSuccess())
    {
      SLog.a("Q.qqstory.playernew.LoadingMoreWidget", "PlayVideoChangeReceiver. %s.", paramPlayVideoChangeEvent.toString());
      paramLoadingMoreWidget.p();
    }
  }
  
  public Class acceptEventClass()
  {
    return PlayVideoChangeEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.LoadingMoreWidget.PlayVideoChangeReceiver
 * JD-Core Version:    0.7.0.1
 */