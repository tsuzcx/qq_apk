package com.tencent.aelight.camera.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.aelight.camera.ae.camera.core.AEEditorManagerForQzone;
import com.tencent.aelight.camera.ae.entry.AECameraLauncher;
import com.tencent.aelight.camera.ae.play.AECoverSelectFragment;
import com.tencent.aelight.camera.ae.play.AEVideoPreviewFragment;
import com.tencent.aelight.camera.ae.util.PicChooseJumpUtil;
import com.tencent.aelight.camera.aeeditor.AEEditorProcessManager;
import com.tencent.aelight.camera.api.IAEEditorGenerateResultListener;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.aelight.camera.api.IAEEditorUICallbackListener;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQcircle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class AEEditorManagerForQzoneImpl
  implements IAEEditorManagerForQzone
{
  private ConcurrentHashMap<IAEEditorGenerateResultListener, AEEditorManagerForQzoneImpl.RealResultListener> mResultListenerMaps = new ConcurrentHashMap();
  private ConcurrentHashMap<IAEEditorUICallbackListener, AEEditorManagerForQzoneImpl.RealUICallback> mUICallbackMaps = new ConcurrentHashMap();
  
  public void addListener(IAEEditorGenerateResultListener paramIAEEditorGenerateResultListener)
  {
    AEEditorManagerForQzoneImpl.RealResultListener localRealResultListener = new AEEditorManagerForQzoneImpl.RealResultListener(paramIAEEditorGenerateResultListener);
    AEEditorManagerForQzone.getInstance().addListener(localRealResultListener);
    this.mResultListenerMaps.put(paramIAEEditorGenerateResultListener, localRealResultListener);
  }
  
  public void addUICallbackListener(IAEEditorUICallbackListener paramIAEEditorUICallbackListener)
  {
    AEEditorManagerForQzoneImpl.RealUICallback localRealUICallback = new AEEditorManagerForQzoneImpl.RealUICallback(paramIAEEditorUICallbackListener);
    AEEditorManagerForQzone.getInstance().addUICallbackListener(localRealUICallback);
    this.mUICallbackMaps.put(paramIAEEditorUICallbackListener, localRealUICallback);
  }
  
  public void cancelMission(String paramString)
  {
    AEEditorManagerForQzone.getInstance().cancelMission(paramString);
  }
  
  public boolean checkAEResVersionOKForAEBasePackage()
  {
    return ((IAEResUtil)QRoute.api(IAEResUtil.class)).checkAEResVersionOK(AEResInfo.AE_RES_BASE_PACKAGE);
  }
  
  public Class getAECoverSelectFragmentClass()
  {
    return AECoverSelectFragment.class;
  }
  
  public Class getAEVideoPreviewFragmentClass()
  {
    return AEVideoPreviewFragment.class;
  }
  
  public LocalMediaInfo getMissionInfo(String paramString)
  {
    return AEEditorManagerForQzone.getInstance().getMissionInfo(paramString);
  }
  
  public void init()
  {
    AEEditorManagerForQzone.getInstance().init();
  }
  
  public boolean isAEKitForQQInit()
  {
    return AEKitForQQ.a();
  }
  
  public boolean isCameraResReady()
  {
    return AECameraLauncher.a();
  }
  
  public void jumpForAECircle(Context paramContext, Intent paramIntent)
  {
    PicChooseJumpUtil.a(paramContext, paramIntent);
  }
  
  public void launchAECameraFromCircle(Context paramContext, Bundle paramBundle)
  {
    AECameraLauncher.b(paramContext, paramBundle);
  }
  
  public void launchAEMutiCameraFromCircle(Context paramContext, Bundle paramBundle)
  {
    AECameraLauncher.c(paramContext, paramBundle);
  }
  
  public void launchQQPhotoSelect(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 31);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationQcircle.a);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(localIntent, 20000);
      return;
    }
    QLog.e("QCircleHostLauncher", 1, "launchQQPhotoSelect activity is not Activity");
  }
  
  public void removeCallbackListener(@Nullable IAEEditorUICallbackListener paramIAEEditorUICallbackListener)
  {
    AEEditorManagerForQzone.getInstance().removeCallbackListener(paramIAEEditorUICallbackListener);
  }
  
  public void removeListener(IAEEditorGenerateResultListener paramIAEEditorGenerateResultListener)
  {
    if (this.mResultListenerMaps.get(paramIAEEditorGenerateResultListener) != null)
    {
      AEEditorManagerForQzoneImpl.RealResultListener localRealResultListener = (AEEditorManagerForQzoneImpl.RealResultListener)this.mResultListenerMaps.get(paramIAEEditorGenerateResultListener);
      AEEditorManagerForQzone.getInstance().removeListener(localRealResultListener);
      this.mResultListenerMaps.remove(paramIAEEditorGenerateResultListener);
    }
  }
  
  public void removeUICallbackListener(IAEEditorUICallbackListener paramIAEEditorUICallbackListener)
  {
    if (this.mUICallbackMaps.get(paramIAEEditorUICallbackListener) != null)
    {
      AEEditorManagerForQzoneImpl.RealUICallback localRealUICallback = (AEEditorManagerForQzoneImpl.RealUICallback)this.mUICallbackMaps.get(paramIAEEditorUICallbackListener);
      AEEditorManagerForQzone.getInstance().removeCallbackListener(localRealUICallback);
      this.mUICallbackMaps.remove(paramIAEEditorUICallbackListener);
    }
  }
  
  public void requestGenerateVideo(String paramString)
  {
    AEEditorProcessManager.a().a(paramString);
  }
  
  public void retryMission(String paramString)
  {
    AEEditorManagerForQzone.getInstance().retryMission(paramString);
  }
  
  public void saveMission(String paramString)
  {
    AEEditorManagerForQzone.getInstance().saveMission(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.AEEditorManagerForQzoneImpl
 * JD-Core Version:    0.7.0.1
 */