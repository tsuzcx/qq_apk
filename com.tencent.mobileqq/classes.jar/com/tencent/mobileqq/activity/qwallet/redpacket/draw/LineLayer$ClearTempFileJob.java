package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import ajed;
import bace;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class LineLayer$ClearTempFileJob
  implements Runnable
{
  public final String a = ajed.cd + "temp" + File.separator;
  
  public LineLayer$ClearTempFileJob(LineLayer paramLineLayer) {}
  
  public void run()
  {
    try
    {
      bace.a(this.a, true);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ClearTempFileJobdownloading", 2, "makedir execption: " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.LineLayer.ClearTempFileJob
 * JD-Core Version:    0.7.0.1
 */