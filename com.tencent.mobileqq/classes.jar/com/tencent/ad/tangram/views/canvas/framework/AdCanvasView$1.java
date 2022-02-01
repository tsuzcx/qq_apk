package com.tencent.ad.tangram.views.canvas.framework;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.d;

class AdCanvasView$1
  implements AdAppDownloadManager.d
{
  AdCanvasView$1(AdCanvasView paramAdCanvasView) {}
  
  public void getDownloadStatus(int paramInt)
  {
    if ((paramInt == 8) || (paramInt == 2) || (paramInt == 3) || (paramInt == 6))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDownloadStatus");
      localStringBuilder.append(paramInt);
      AdLog.e("AdCanvasView", localStringBuilder.toString());
      AdThreadManager.INSTANCE.post(new AdCanvasView.1.1(this), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.framework.AdCanvasView.1
 * JD-Core Version:    0.7.0.1
 */