package com.tencent.aelight.camera.download.api.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.ttpic.openapi.model.VideoMaterial;

public class AEResUtilImpl
  implements IAEResUtil
{
  public boolean checkAEResVersionOK(@NonNull AEResInfo paramAEResInfo)
  {
    return AEResUtil.a(paramAEResInfo);
  }
  
  public int checkBundleStatus(VideoMaterial paramVideoMaterial)
  {
    return AEResUtil.a(paramVideoMaterial);
  }
  
  public void fetchBundles(Context paramContext, long paramLong)
  {
    AEResUtil.a(paramContext, paramLong);
  }
  
  public int getAEResStatus(AEResInfo paramAEResInfo)
  {
    return AEResUtil.a(paramAEResInfo);
  }
  
  public int getDownloadPackageVersion(int paramInt)
  {
    return AEResUtil.a(paramInt);
  }
  
  public String getFinalUnzipFilePath()
  {
    return AEResUtil.b();
  }
  
  public String getFinalUnzippedPackageDir(@NonNull AEResInfo paramAEResInfo)
  {
    return AEResUtil.a(paramAEResInfo);
  }
  
  public String getLightAssetsDir()
  {
    return AEResUtil.d();
  }
  
  public String getLightBundleDir(@NonNull AEResInfo paramAEResInfo)
  {
    return AEResUtil.c(paramAEResInfo);
  }
  
  public String getLightEmptyMaterialConfigPath()
  {
    return AEResUtil.e();
  }
  
  public String getLightModelDir()
  {
    return AEResUtil.g();
  }
  
  public String getPituDownloadTips()
  {
    return AEResUtil.a;
  }
  
  public String getUnzipAEResPath(@NonNull AEResInfo paramAEResInfo)
  {
    return AEResUtil.b(paramAEResInfo);
  }
  
  public boolean isAEBaseSoReady()
  {
    return AEResUtil.a();
  }
  
  public boolean isAEResExist(AEResInfo paramAEResInfo)
  {
    return AEResUtil.b(paramAEResInfo);
  }
  
  public boolean isFilterFaceSoVersionOK()
  {
    return AEResUtil.d();
  }
  
  public boolean isLightCameraBaseResNotAllExist()
  {
    return AEResUtil.c();
  }
  
  public boolean isLightCameraResExist()
  {
    return AEResUtil.b();
  }
  
  public boolean loadAEBaseSo()
  {
    return AEResUtil.e();
  }
  
  public void peakRequestAEBaseRes() {}
  
  public void tryDownloadLightAdditionBundle(Context paramContext, String paramString)
  {
    AEResUtil.b(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.download.api.impl.AEResUtilImpl
 * JD-Core Version:    0.7.0.1
 */