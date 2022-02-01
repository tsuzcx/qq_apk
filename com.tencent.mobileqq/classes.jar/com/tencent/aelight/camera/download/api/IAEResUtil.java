package com.tencent.aelight.camera.download.api;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.ttpic.openapi.model.VideoMaterial;

@QAPI(process={"all"})
public abstract interface IAEResUtil
  extends QRouteApi
{
  public static final int AERES_EXIST = 1;
  public static final int AERES_MACHINE_NOT_SUPPORT = 0;
  public static final int AERES_NOT_EXIST = 2;
  
  public abstract boolean checkAEResVersionOK(AEResInfo paramAEResInfo);
  
  public abstract int checkBundleStatus(VideoMaterial paramVideoMaterial);
  
  public abstract void fetchBundles(Context paramContext, long paramLong);
  
  public abstract int getAEResStatus(AEResInfo paramAEResInfo);
  
  public abstract int getDownloadPackageVersion(int paramInt);
  
  public abstract String getFinalUnzipFilePath();
  
  @NonNull
  public abstract String getFinalUnzippedPackageDir(@NonNull AEResInfo paramAEResInfo);
  
  public abstract String getLightAssetsDir();
  
  public abstract String getLightBundleDir(@NonNull AEResInfo paramAEResInfo);
  
  public abstract String getLightEmptyMaterialConfigPath();
  
  public abstract String getLightModelDir();
  
  public abstract String getPituDownloadTips();
  
  public abstract String getUnzipAEResPath(@NonNull AEResInfo paramAEResInfo);
  
  public abstract boolean isAEBaseSoReady();
  
  public abstract boolean isAEResExist(AEResInfo paramAEResInfo);
  
  public abstract boolean isFilterFaceSoVersionOK();
  
  public abstract boolean isLightCameraBaseResNotAllExist();
  
  public abstract boolean isLightCameraResExist();
  
  public abstract boolean loadAEBaseSo();
  
  public abstract void peakRequestAEBaseRes();
  
  public abstract void tryDownloadLightAdditionBundle(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.download.api.IAEResUtil
 * JD-Core Version:    0.7.0.1
 */