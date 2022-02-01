package com.peterlmeng.animate_image.renderer;

import com.peterlmeng.animate_image.QueuingEventSink;
import java.util.Map;

class PagRenderWorker$PAGRenderHandler$1
  implements Runnable
{
  PagRenderWorker$PAGRenderHandler$1(PagRenderWorker.PAGRenderHandler paramPAGRenderHandler, PagRenderWorker paramPagRenderWorker, Map paramMap) {}
  
  public void run()
  {
    PagRenderWorker localPagRenderWorker = this.val$worker;
    if ((localPagRenderWorker != null) && (PagRenderWorker.access$500(localPagRenderWorker) != null)) {
      PagRenderWorker.access$500(this.val$worker).success(this.val$event);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.PagRenderWorker.PAGRenderHandler.1
 * JD-Core Version:    0.7.0.1
 */