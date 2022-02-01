package com.tencent.biz.qqcircle.richframework.video;

import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.Collections;

class QCirclePlayer$2
  implements QUICStatus.QUICListener
{
  QCirclePlayer$2(QCirclePlayer paramQCirclePlayer, String paramString) {}
  
  public void a(QUICStatus paramQUICStatus)
  {
    QCirclePlayer.a(this.b, "video_quic_to_http", Collections.singletonList(QCircleReportHelper.newEntry("video_url", this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.video.QCirclePlayer.2
 * JD-Core Version:    0.7.0.1
 */