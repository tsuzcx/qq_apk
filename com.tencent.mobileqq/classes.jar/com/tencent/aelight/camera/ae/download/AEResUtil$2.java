package com.tencent.aelight.camera.ae.download;

import android.content.Context;
import com.tencent.aelight.camera.log.AEQLog;

final class AEResUtil$2
  implements Runnable
{
  AEResUtil$2(Context paramContext, String paramString) {}
  
  public void run()
  {
    AEResUtil.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【tryDownloadLightAdditionBundle】4g网络 : dialog show --> prefix:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    AEQLog.d("PreCheckAERes", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEResUtil.2
 * JD-Core Version:    0.7.0.1
 */