package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import ajdt;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

class LineLayer$SaveTempFileJob$1
  implements Runnable
{
  LineLayer$SaveTempFileJob$1(LineLayer.SaveTempFileJob paramSaveTempFileJob, String paramString) {}
  
  public void run()
  {
    ajdt localajdt;
    if (LineLayer.SaveTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$SaveTempFileJob) != null)
    {
      localajdt = (ajdt)LineLayer.SaveTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$SaveTempFileJob).get();
      if (localajdt != null) {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label66;
        }
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      localajdt.a(bool, LineLayer.SaveTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$SaveTempFileJob), LineLayer.SaveTempFileJob.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$SaveTempFileJob), this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.LineLayer.SaveTempFileJob.1
 * JD-Core Version:    0.7.0.1
 */