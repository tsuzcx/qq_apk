package com.tencent.mobileqq.activity.aio.doodle;

import android.text.TextUtils;
import java.lang.ref.WeakReference;

class LineLayer$SaveTempFileJob$1
  implements Runnable
{
  LineLayer$SaveTempFileJob$1(LineLayer.SaveTempFileJob paramSaveTempFileJob, String paramString) {}
  
  public void run()
  {
    SaveTempFileJobListener localSaveTempFileJobListener;
    if (LineLayer.SaveTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$SaveTempFileJob) != null)
    {
      localSaveTempFileJobListener = (SaveTempFileJobListener)LineLayer.SaveTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$SaveTempFileJob).get();
      if (localSaveTempFileJobListener != null) {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label66;
        }
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      localSaveTempFileJobListener.a(bool, LineLayer.SaveTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$SaveTempFileJob), LineLayer.SaveTempFileJob.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$SaveTempFileJob), this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LineLayer.SaveTempFileJob.1
 * JD-Core Version:    0.7.0.1
 */