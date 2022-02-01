package com.tencent.biz.qqcircle.fragments.content;

import aadv;
import android.widget.TextView;
import com.tencent.superplayer.api.ISuperPlayer;
import vwr;

class QCircleContentVideo$3
  implements Runnable
{
  QCircleContentVideo$3(QCircleContentVideo paramQCircleContentVideo, ISuperPlayer paramISuperPlayer) {}
  
  public void run()
  {
    if ((QCircleContentVideo.a(this.this$0) != null) && (QCircleContentVideo.a(this.this$0).f != null))
    {
      aadv.a(QCircleContentVideo.a(this.this$0).f, false);
      QCircleContentVideo.a(this.this$0).f.setText(vwr.a((int)this.a.getDurationMs()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo.3
 * JD-Core Version:    0.7.0.1
 */