package com.tencent.aelight.camera.cmsshow.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.ae.cmshow.AECMShowGuideFragment;
import com.tencent.aelight.camera.ae.cmshow.AECMShowPhotoPreviewFragment;
import com.tencent.aelight.camera.ae.cmshow.AECMShowQipcModule;
import com.tencent.aelight.camera.ae.cmshow.AECMShowUtil;
import com.tencent.aelight.camera.ae.cmshow.config.AECMShowConfig;
import com.tencent.aelight.camera.cmsshow.api.CMJoyEssentialDownloadCallback;
import com.tencent.aelight.camera.cmsshow.api.IAECMSShow;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResultCallback;
import java.util.ArrayList;

public class AECMSShowImpl
  implements IAECMSShow
{
  public void downloadAEKitResource(@Nullable EIPCResultCallback paramEIPCResultCallback)
  {
    AECMShowQipcModule.a(paramEIPCResultCallback);
  }
  
  public void downloadEssentialResource(@NonNull ArrayList<String> paramArrayList, @Nullable CMJoyEssentialDownloadCallback paramCMJoyEssentialDownloadCallback)
  {
    AECMShowQipcModule.a(paramArrayList, paramCMJoyEssentialDownloadCallback);
  }
  
  public QIPCModule getCMSShowModule()
  {
    return AECMShowQipcModule.a();
  }
  
  public ArrayList<String> getEssetialResourceIdlist()
  {
    return AECMShowConfig.ESSENTIAL_RESOURCE_ID_LIST;
  }
  
  public void init3DCapabilityChecker() {}
  
  public boolean isAEResReady()
  {
    return AECMShowUtil.b();
  }
  
  public boolean isCMShowSupported()
  {
    return AECMShowUtil.a();
  }
  
  public void jumpToMe(Activity paramActivity, Intent paramIntent)
  {
    AECMShowPhotoPreviewFragment.a(paramActivity, paramIntent);
  }
  
  public void jumpToMeForResult(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AECMShowGuideFragment.a(paramActivity, paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.cmsshow.api.impl.AECMSShowImpl
 * JD-Core Version:    0.7.0.1
 */