package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import agsm;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

class LineLayer$LoadTempFileJob$1
  implements Runnable
{
  LineLayer$LoadTempFileJob$1(LineLayer.LoadTempFileJob paramLoadTempFileJob, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (LineLayer.LoadTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$LoadTempFileJob) != null)
    {
      agsm localagsm = (agsm)LineLayer.LoadTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$LoadTempFileJob).get();
      if (localagsm != null) {
        localagsm.a(LineLayer.LoadTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$LoadTempFileJob), this.jdField_a_of_type_Int, LineLayer.LoadTempFileJob.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$LoadTempFileJob), this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.LineLayer.LoadTempFileJob.1
 * JD-Core Version:    0.7.0.1
 */