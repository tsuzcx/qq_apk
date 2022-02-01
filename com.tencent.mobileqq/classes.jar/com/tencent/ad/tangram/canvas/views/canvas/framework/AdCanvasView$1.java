package com.tencent.ad.tangram.canvas.views.canvas.framework;

import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager.c;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;

class AdCanvasView$1
  implements AdAppDownloadManager.c
{
  AdCanvasView$1(AdCanvasView paramAdCanvasView) {}
  
  public void getDownloadStatus(int paramInt)
  {
    if ((paramInt == 8) || (paramInt == 2) || (paramInt == 3) || (paramInt == 6))
    {
      AdLog.e("AdCanvasView", "getDownloadStatus" + paramInt);
      AdThreadManager.INSTANCE.post(new AdCanvasView.1.1(this), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasView.1
 * JD-Core Version:    0.7.0.1
 */