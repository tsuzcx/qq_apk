package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.api.IAEPhotoAIManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.struct.camera.AEPhotoAIResult;
import com.tencent.ttpic.filter.aifilter.AIImageFilterResult;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import java.io.File;
import java.util.concurrent.CountDownLatch;

public class AEPhotoAIManagerImpl
  implements IAEPhotoAIManager
{
  private static final String TAG = "AEPhotoAIManagerImpl";
  
  protected static String parseLutBylutPath(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = paramString.split("\\.")[0];
    paramString = AEEditorResourceManager.a().c(str);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseLutBySceneLabel--select lut=");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(", path=");
    ((StringBuilder)localObject).append(paramString);
    AEQLog.b("AEPhotoAIManagerImpl", ((StringBuilder)localObject).toString());
    if ((paramString == null) || (!new File(paramString).exists()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseLutBySceneLabel--used lut not exists, id=");
      ((StringBuilder)localObject).append(str);
      AEQLog.b("AEPhotoAIManagerImpl", ((StringBuilder)localObject).toString());
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject = new boolean[1];
      AEEditorResourceManager.a().a(str, new AEPhotoAIManagerImpl.1((boolean[])localObject, localCountDownLatch));
      try
      {
        localCountDownLatch.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      if (localObject[0] != 0) {
        AEQLog.b("AEPhotoAIManagerImpl", "parseLutBySceneLabel--download SUCCESS");
      }
    }
    else
    {
      return paramString;
    }
    AEQLog.b("AEPhotoAIManagerImpl", "parseLutBySceneLabel--download FAIL");
    return null;
  }
  
  public void downloadPhotoAIRes()
  {
    AEEditorResourceManager.a().c();
  }
  
  public AEPhotoAIResult getPhotoAIResult(String paramString)
  {
    AEPhotoAIResult localAEPhotoAIResult = new AEPhotoAIResult();
    PhotoAIFilter.setAIImageJsonPath(AEEditorResourceManager.a().a());
    PhotoAIFilter.setLutImagePath("");
    paramString = PhotoAIFilter.parseAIImageParamsBySceneLabel(paramString);
    localAEPhotoAIResult.a(parseLutBylutPath(paramString.lutPath));
    localAEPhotoAIResult.a(paramString.lutStrengt);
    localAEPhotoAIResult.a(paramString.adjustParam);
    localAEPhotoAIResult.b(paramString.smoothLevel);
    localAEPhotoAIResult.c(paramString.glowStrength);
    return localAEPhotoAIResult;
  }
  
  public boolean isPhotoAIResExist()
  {
    return AEEditorResourceManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.AEPhotoAIManagerImpl
 * JD-Core Version:    0.7.0.1
 */