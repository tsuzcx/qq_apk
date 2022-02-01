package com.tencent.aelight.camera.ae.download;

import android.content.Context;
import com.tencent.aelight.camera.log.AEQLog;

final class AEResUtil$1
  implements Runnable
{
  AEResUtil$1(Context paramContext, String paramString) {}
  
  public void run()
  {
    AEResUtil.c(this.a, this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【tryDownloadLightAdditionBundle】4g网络 : dialog show --> prefix:");
    localStringBuilder.append(this.b);
    AEQLog.d("PreCheckAERes", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEResUtil.1
 * JD-Core Version:    0.7.0.1
 */