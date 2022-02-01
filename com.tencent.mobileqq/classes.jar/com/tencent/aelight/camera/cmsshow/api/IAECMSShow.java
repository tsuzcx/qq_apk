package com.tencent.aelight.camera.cmsshow.api;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import eipc.EIPCResultCallback;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IAECMSShow
  extends QRouteApi
{
  public static final String NAME = "AECMShowQipcModule";
  public static final int SCENE_ALBUM = 2;
  public static final int SCENE_CAMERA = 1;
  
  public abstract void downloadAEKitResource(@Nullable EIPCResultCallback paramEIPCResultCallback);
  
  public abstract void downloadEssentialResource(@NonNull ArrayList<String> paramArrayList, @Nullable CMJoyEssentialDownloadCallback paramCMJoyEssentialDownloadCallback);
  
  public abstract QIPCModule getCMSShowModule();
  
  public abstract ArrayList<String> getEssetialResourceIdlist();
  
  public abstract void init3DCapabilityChecker();
  
  public abstract boolean isAEResReady();
  
  public abstract boolean isCMShowSupported();
  
  public abstract void jumpToMe(Activity paramActivity, Intent paramIntent);
  
  public abstract void jumpToMeForResult(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract boolean supportAceEngine();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.cmsshow.api.IAECMSShow
 * JD-Core Version:    0.7.0.1
 */