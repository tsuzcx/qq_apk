package com.tencent.mobileqq.activity.springfestival.entry.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class SpringPopBanner$4$1
  implements Runnable
{
  SpringPopBanner$4$1(SpringPopBanner.4 param4, IPreloadService.PathResult paramPathResult) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("show PopBanner type=");
    ((StringBuilder)localObject).append(this.b.a);
    ((StringBuilder)localObject).append(" path=");
    ((StringBuilder)localObject).append(this.a.filePath);
    QLog.d("shua2021_SpringPopBanner", 2, ((StringBuilder)localObject).toString());
    this.b.c.a(true);
    try
    {
      SpringPopBanner.c(this.b.c).addView(SpringPopBanner.b(this.b.c));
      SpringPopBanner.a(this.b.c, this.b.a, this.a.filePath);
      localObject = SpringPopBanner.b(this.b.c, this.b.a, this.a.filePath);
      SpringPopBanner.a(this.b.c).setBackgroundDrawable(null);
      SpringPopBanner.a(this.b.c).setBackgroundDrawable((Drawable)localObject);
      SpringPopBanner.a(SpringPopBanner.d(this.b.c));
      SpringPopBanner.a(this.b.c).setTag(this.b.b);
    }
    catch (Throwable localThrowable)
    {
      SpringHbMonitorReporter.a(212, localThrowable, new String[0]);
      QLog.d("shua2021_SpringPopBanner", 1, localThrowable.getMessage(), localThrowable);
    }
    SpringPopBanner.a(this.b.c, this.b.b, true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("active_id", this.b.b);
    SpringHbReporter.a("event_dachaping", 0, 0, localHashMap, "exp", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ui.SpringPopBanner.4.1
 * JD-Core Version:    0.7.0.1
 */