package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import ahfa;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

class LineLayer$SaveTempFileJob$1
  implements Runnable
{
  LineLayer$SaveTempFileJob$1(LineLayer.SaveTempFileJob paramSaveTempFileJob, String paramString) {}
  
  public void run()
  {
    ahfa localahfa;
    if (LineLayer.SaveTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$SaveTempFileJob) != null)
    {
      localahfa = (ahfa)LineLayer.SaveTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$SaveTempFileJob).get();
      if (localahfa != null) {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label66;
        }
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      localahfa.a(bool, LineLayer.SaveTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$SaveTempFileJob), LineLayer.SaveTempFileJob.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer$SaveTempFileJob), this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.LineLayer.SaveTempFileJob.1
 * JD-Core Version:    0.7.0.1
 */