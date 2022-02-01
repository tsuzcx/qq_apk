package com.tencent.aelight.camera.download.api.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.Map;

public class AEResUtilImpl
  implements IAEResUtil
{
  public boolean checkAEResVersionOK(@NonNull AEResInfo paramAEResInfo)
  {
    return AEResUtil.c(paramAEResInfo);
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
    return AEResUtil.e(paramAEResInfo);
  }
  
  public int getDownloadPackageVersion(int paramInt)
  {
    return AEResUtil.a(paramInt);
  }
  
  public String getFinalUnzipFilePath()
  {
    return AEResUtil.c();
  }
  
  public String getFinalUnzippedPackageDir(@NonNull AEResInfo paramAEResInfo)
  {
    return AEResUtil.a(paramAEResInfo);
  }
  
  public String getLightAssetsDir()
  {
    return AEResUtil.k();
  }
  
  public String getLightBundleDir(@NonNull AEResInfo paramAEResInfo)
  {
    return AEResUtil.f(paramAEResInfo);
  }
  
  public Map<AEResInfo, String> getLightBundleMap()
  {
    return AEResUtil.a();
  }
  
  public String getLightEmptyMaterialConfigPath()
  {
    return AEResUtil.l();
  }
  
  public String getLightModelDir()
  {
    return AEResUtil.n();
  }
  
  public String getPituDownloadTips()
  {
    return AEResUtil.b;
  }
  
  public String getUnzipAEResPath(@NonNull AEResInfo paramAEResInfo)
  {
    return AEResUtil.b(paramAEResInfo);
  }
  
  public boolean isAEBaseSoReady()
  {
    return AEResUtil.e();
  }
  
  public boolean isAEResExist(AEResInfo paramAEResInfo)
  {
    return AEResUtil.d(paramAEResInfo);
  }
  
  public boolean isFilterFaceSoVersionOK()
  {
    return AEResUtil.h();
  }
  
  public boolean isLightCameraBaseResNotAllExist()
  {
    return AEResUtil.g();
  }
  
  public boolean isLightCameraResExist()
  {
    return AEResUtil.f();
  }
  
  public boolean loadAEBaseSo()
  {
    return AEResUtil.i();
  }
  
  public void peakRequestAEBaseRes() {}
  
  public void tryDownloadLightAdditionBundle(Context paramContext, String paramString)
  {
    AEResUtil.b(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.download.api.impl.AEResUtilImpl
 * JD-Core Version:    0.7.0.1
 */