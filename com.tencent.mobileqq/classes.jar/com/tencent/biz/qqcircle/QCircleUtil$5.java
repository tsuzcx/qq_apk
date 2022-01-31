package com.tencent.biz.qqcircle;

import android.content.Context;
import android.content.Intent;
import bkny;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.photo.PeakService;
import tra;

public final class QCircleUtil$5
  implements Runnable
{
  public QCircleUtil$5(Context paramContext) {}
  
  public void run()
  {
    if (bkny.a(this.a)) {}
    do
    {
      return;
      Intent localIntent = new Intent(this.a, PeakService.class);
      localIntent.putExtra("ServiceAction", 5);
      localIntent.putExtra("key_alive", false);
      try
      {
        this.a.startService(localIntent);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e(tra.a(), 0, "preload peak fail ", localException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleUtil.5
 * JD-Core Version:    0.7.0.1
 */