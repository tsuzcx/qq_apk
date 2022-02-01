package com.tencent.aelight.camera.download.old.api.impl;

import com.tencent.aelight.camera.ae.download.old.AEOldPath.CAMERA.FILES;
import com.tencent.aelight.camera.ae.download.old.AEOldPath.CAMERA.INTERNAL_FILES;
import com.tencent.aelight.camera.ae.download.old.AEOldPathBase.TMP;
import com.tencent.aelight.camera.download.old.api.IAEOldPath;

public class AEOldPathImpl
  implements IAEOldPath
{
  public String getCameraResPath()
  {
    return AEOldPath.CAMERA.FILES.b;
  }
  
  public String getPendantBasePath()
  {
    return AEOldPath.CAMERA.INTERNAL_FILES.a;
  }
  
  public String getTmpCache()
  {
    return AEOldPathBase.TMP.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.download.old.api.impl.AEOldPathImpl
 * JD-Core Version:    0.7.0.1
 */