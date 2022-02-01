package com.tencent.biz.richframework.widget;

import android.widget.SeekBar;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;

class BaseVideoView$5
  implements Runnable
{
  BaseVideoView$5(BaseVideoView paramBaseVideoView) {}
  
  public void run()
  {
    if (BaseVideoView.a(this.this$0) != null) {
      BaseVideoView.a(this.this$0).setXYaxis(0);
    }
    if (this.this$0.a() != null) {
      this.this$0.a().setMax((int)this.this$0.a().getDurationMs());
    }
    if (!this.this$0.b())
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(QCircleReportHelper.newEntry("time_cost", String.valueOf((float)(System.currentTimeMillis() - BaseVideoView.a(this.this$0)) / 1000.0F)));
      this.this$0.a(this.this$0.a, "video_first_buffer_time_consuming", this.this$0.a(), localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.widget.BaseVideoView.5
 * JD-Core Version:    0.7.0.1
 */