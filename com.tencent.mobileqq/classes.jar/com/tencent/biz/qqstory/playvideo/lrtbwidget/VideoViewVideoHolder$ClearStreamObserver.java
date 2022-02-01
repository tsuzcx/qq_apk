package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.reactive.SimpleObserver;

class VideoViewVideoHolder$ClearStreamObserver<T>
  extends SimpleObserver<T>
{
  private VideoViewVideoHolder$ClearStreamObserver(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d(this.b.a, "stream : [%s]  CANCEL", new Object[] { this.b.o });
    VideoViewVideoHolder localVideoViewVideoHolder = this.b;
    localVideoViewVideoHolder.n = null;
    localVideoViewVideoHolder.o = null;
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.d(this.b.a, "stream : [%s]  ERROR", new Object[] { this.b.o });
    paramError = this.b;
    paramError.n = null;
    paramError.o = null;
  }
  
  public void onNext(T paramT)
  {
    super.onNext(paramT);
    SLog.d(this.b.a, "stream : [%s] DONE", new Object[] { this.b.o });
    paramT = this.b;
    paramT.n = null;
    paramT.o = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.ClearStreamObserver
 * JD-Core Version:    0.7.0.1
 */