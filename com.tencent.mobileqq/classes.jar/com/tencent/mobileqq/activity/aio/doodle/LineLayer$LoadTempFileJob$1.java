package com.tencent.mobileqq.activity.aio.doodle;

import agdf;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

class LineLayer$LoadTempFileJob$1
  implements Runnable
{
  LineLayer$LoadTempFileJob$1(LineLayer.LoadTempFileJob paramLoadTempFileJob, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (LineLayer.LoadTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LoadTempFileJob) != null)
    {
      agdf localagdf = (agdf)LineLayer.LoadTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LoadTempFileJob).get();
      if (localagdf != null) {
        localagdf.a(LineLayer.LoadTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LoadTempFileJob), this.jdField_a_of_type_Int, LineLayer.LoadTempFileJob.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LoadTempFileJob), this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LineLayer.LoadTempFileJob.1
 * JD-Core Version:    0.7.0.1
 */