package com.tencent.mobileqq.activity.aio.doodle;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class LineLayer$ClearTempFileJob
  implements Runnable
{
  public final String a = AppConstants.SCRIBBLE_FILE_DIR + "temp" + File.separator;
  
  public LineLayer$ClearTempFileJob(LineLayer paramLineLayer) {}
  
  public void run()
  {
    try
    {
      FileUtils.delete(this.a, true);
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