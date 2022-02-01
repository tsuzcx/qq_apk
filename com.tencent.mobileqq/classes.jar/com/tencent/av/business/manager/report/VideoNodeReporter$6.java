package com.tencent.av.business.manager.report;

import android.text.TextUtils;
import bdkl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import lie;
import lig;

public class VideoNodeReporter$6
  implements Runnable
{
  public VideoNodeReporter$6(lie paramlie, long paramLong) {}
  
  public void run()
  {
    Object localObject = lie.a(this.this$0, this.a);
    QLog.d("VideoNodeReporter", 1, "reportToServer ,roomId = " + this.a + ", detail = " + (String)localObject);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.a != 0L)) {
      bdkl.a(null, "dc02402", (String)localObject);
    }
    lie.a(this.this$0, this.a);
    localObject = this.this$0.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      lig locallig = (lig)((Iterator)localObject).next();
      if (this.a == locallig.a) {
        ((Iterator)localObject).remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.6
 * JD-Core Version:    0.7.0.1
 */