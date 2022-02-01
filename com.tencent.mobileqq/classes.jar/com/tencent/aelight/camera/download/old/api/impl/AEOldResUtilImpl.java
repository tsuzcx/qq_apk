package com.tencent.aelight.camera.download.old.api.impl;

import android.support.annotation.NonNull;
import com.tencent.aelight.camera.ae.download.old.AEOldResUtil;
import com.tencent.aelight.camera.download.old.api.AEOldResInfo;
import com.tencent.aelight.camera.download.old.api.IAEOldResUtil;

public class AEOldResUtilImpl
  implements IAEOldResUtil
{
  @NonNull
  public String getFinalUnzippedPackageDir(@NonNull AEOldResInfo paramAEOldResInfo)
  {
    return AEOldResUtil.b(paramAEOldResInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.download.old.api.impl.AEOldResUtilImpl
 * JD-Core Version:    0.7.0.1
 */