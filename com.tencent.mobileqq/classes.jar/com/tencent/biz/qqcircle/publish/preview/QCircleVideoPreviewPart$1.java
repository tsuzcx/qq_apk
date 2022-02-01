package com.tencent.biz.qqcircle.publish.preview;

import com.tencent.biz.qqcircle.richframework.widget.BaseVideoViewListenerSets;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class QCircleVideoPreviewPart$1
  extends BaseVideoViewListenerSets
{
  QCircleVideoPreviewPart$1(QCircleVideoPreviewPart paramQCircleVideoPreviewPart) {}
  
  public void a()
  {
    super.a();
    QLog.d("[QcirclePublish]QCircleVideoPreviewPart", 1, "firstFrameRenderCallBack...");
  }
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    super.a(paramISuperPlayer);
    QLog.d("[QcirclePublish]QCircleVideoPreviewPart", 1, "onVideoPrepared...");
    paramISuperPlayer.start();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    super.a(paramString, paramInt1, paramInt2);
    QLog.d("[QcirclePublish]QCircleVideoPreviewPart", 1, new Object[] { "onProgress... videoDuration:", Integer.valueOf(paramInt1), " currentDuration:", Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.QCircleVideoPreviewPart.1
 * JD-Core Version:    0.7.0.1
 */