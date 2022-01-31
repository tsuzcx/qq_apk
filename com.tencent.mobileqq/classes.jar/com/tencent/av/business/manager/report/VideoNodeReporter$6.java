package com.tencent.av.business.manager.report;

import android.text.TextUtils;
import azps;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import lkz;
import llb;

public class VideoNodeReporter$6
  implements Runnable
{
  public VideoNodeReporter$6(lkz paramlkz, long paramLong) {}
  
  public void run()
  {
    Object localObject = lkz.a(this.this$0, this.a);
    QLog.d("VideoNodeReporter", 1, "reportToServer ,roomId = " + this.a + ", detail = " + (String)localObject);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.a != 0L)) {
      azps.a(null, "dc02402", (String)localObject);
    }
    lkz.a(this.this$0, this.a);
    localObject = this.this$0.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      llb localllb = (llb)((Iterator)localObject).next();
      if (this.a == localllb.a) {
        ((Iterator)localObject).remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.6
 * JD-Core Version:    0.7.0.1
 */