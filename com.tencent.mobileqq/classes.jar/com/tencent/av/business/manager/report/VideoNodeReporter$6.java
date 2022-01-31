package com.tencent.av.business.manager.report;

import android.text.TextUtils;
import awpy;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kyl;
import kyn;

public class VideoNodeReporter$6
  implements Runnable
{
  public VideoNodeReporter$6(kyl paramkyl, long paramLong) {}
  
  public void run()
  {
    Object localObject = kyl.a(this.this$0, this.a);
    QLog.d("VideoNodeReporter", 1, "reportToServer ,roomId = " + this.a + ", detail = " + (String)localObject);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.a != 0L)) {
      awpy.a(null, "dc02402", (String)localObject);
    }
    kyl.a(this.this$0, this.a);
    localObject = this.this$0.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      kyn localkyn = (kyn)((Iterator)localObject).next();
      if (this.a == localkyn.a) {
        ((Iterator)localObject).remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.6
 * JD-Core Version:    0.7.0.1
 */