package com.tencent.biz.qqcircle.fragments.content;

import android.widget.TextView;
import com.tencent.biz.qqcircle.utils.TimeUtils;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.superplayer.api.ISuperPlayer;

class QCircleContentVideo$4
  implements Runnable
{
  QCircleContentVideo$4(QCircleContentVideo paramQCircleContentVideo, ISuperPlayer paramISuperPlayer) {}
  
  public void run()
  {
    if ((QCircleContentVideo.a(this.this$0) != null) && (QCircleContentVideo.a(this.this$0).n != null))
    {
      RFWTypefaceUtil.a(QCircleContentVideo.a(this.this$0).n, false);
      QCircleContentVideo.a(this.this$0).n.setText(TimeUtils.a((int)this.a.getDurationMs()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo.4
 * JD-Core Version:    0.7.0.1
 */