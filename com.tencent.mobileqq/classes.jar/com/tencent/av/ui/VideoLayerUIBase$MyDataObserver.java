package com.tencent.av.ui;

import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class VideoLayerUIBase$MyDataObserver
  implements Observer
{
  private WeakReference<VideoLayerUIBase> a;
  
  VideoLayerUIBase$MyDataObserver(VideoLayerUIBase paramVideoLayerUIBase)
  {
    this.a = new WeakReference(paramVideoLayerUIBase);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    VideoLayerUIBase localVideoLayerUIBase = (VideoLayerUIBase)this.a.get();
    if (localVideoLayerUIBase == null) {
      return;
    }
    VideoLayerUIBase.a(localVideoLayerUIBase, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase.MyDataObserver
 * JD-Core Version:    0.7.0.1
 */