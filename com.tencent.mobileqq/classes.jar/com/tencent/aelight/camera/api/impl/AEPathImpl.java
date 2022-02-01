package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.INTERNAL_FILES;
import com.tencent.aelight.camera.ae.AEPath.GIF.CACHE;
import com.tencent.aelight.camera.ae.AEPathBase.TMP;
import com.tencent.aelight.camera.api.IAEPath;

public class AEPathImpl
  implements IAEPath
{
  public String getCameraResPath()
  {
    return AEPath.CAMERA.FILES.b;
  }
  
  public String getGifPreviewCache()
  {
    return AEPath.GIF.CACHE.b;
  }
  
  public String getPendantBasePath()
  {
    return AEPath.CAMERA.INTERNAL_FILES.a;
  }
  
  public String getTmpCache()
  {
    return AEPathBase.TMP.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.AEPathImpl
 * JD-Core Version:    0.7.0.1
 */