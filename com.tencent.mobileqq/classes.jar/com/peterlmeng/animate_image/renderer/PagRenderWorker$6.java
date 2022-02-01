package com.peterlmeng.animate_image.renderer;

import com.peterlmeng.animate_image.QueuingEventSink;
import com.peterlmeng.animate_image.support.log.LogUtils;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.EventChannel.StreamHandler;

class PagRenderWorker$6
  implements EventChannel.StreamHandler
{
  PagRenderWorker$6(PagRenderWorker paramPagRenderWorker) {}
  
  public void onCancel(Object paramObject)
  {
    PagRenderWorker.access$500(this.this$0).setDelegate(null);
  }
  
  public void onListen(Object paramObject, EventChannel.EventSink paramEventSink)
  {
    LogUtils.c("PagRenderWorker", "eventChannel onListen");
    PagRenderWorker.access$500(this.this$0).setDelegate(paramEventSink);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.6
 * JD-Core Version:    0.7.0.1
 */