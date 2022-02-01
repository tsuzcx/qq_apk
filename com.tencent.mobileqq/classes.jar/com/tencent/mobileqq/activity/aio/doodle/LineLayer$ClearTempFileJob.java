package com.tencent.mobileqq.activity.aio.doodle;

import antf;
import bhmi;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class LineLayer$ClearTempFileJob
  implements Runnable
{
  public final String a = antf.cp + "temp" + File.separator;
  
  public LineLayer$ClearTempFileJob(LineLayer paramLineLayer) {}
  
  public void run()
  {
    try
    {
      bhmi.a(this.a, true);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ClearTempFileJobdownloading", 2, "makedir execption: " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LineLayer.ClearTempFileJob
 * JD-Core Version:    0.7.0.1
 */