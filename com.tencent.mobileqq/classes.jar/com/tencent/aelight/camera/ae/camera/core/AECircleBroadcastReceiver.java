package com.tencent.aelight.camera.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;

public class AECircleBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AECircleBroadcastReceiver";
  private AECircleBroadcastReceiver.AEResDownLoadListener mPhotoListLogicAECircle;
  private boolean mReceiverActive = false;
  
  public AECircleBroadcastReceiver(AECircleBroadcastReceiver.AEResDownLoadListener paramAEResDownLoadListener)
  {
    this.mPhotoListLogicAECircle = paramAEResDownLoadListener;
  }
  
  private IntentFilter getBroadcastIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction(AEResInfo.AE_RES_BASE_PACKAGE.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BASE_PACKAGE.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_3DMM.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_ACE3D.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_CAT.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_DEPTH.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_GENDER.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_AGE.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_GAZE.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_HAND.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_SEG_HEAD.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_SCENE.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_BODY.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_BODY_3D.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_EMOTION.resPrefix);
    return localIntentFilter;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AECircleBroadcastReceiver onReceive!  action = ");
    localStringBuilder.append(paramContext);
    AEQLog.a("AECircleBroadcastReceiver", localStringBuilder.toString());
    paramIntent = paramIntent.getStringExtra("ae_camera_res_downloadfinish_path");
    if (AEResInfo.AE_RES_BASE_PACKAGE.resPrefix.equals(paramContext))
    {
      paramContext = this.mPhotoListLogicAECircle;
      if (paramContext != null)
      {
        paramContext.onDownLoadFinish(paramIntent);
        AEQLog.a("AECircleBroadcastReceiver", "[onReceive]");
      }
    }
  }
  
  public void registerSelf(Context paramContext)
  {
    if (!this.mReceiverActive)
    {
      paramContext.registerReceiver(this, getBroadcastIntentFilter());
      this.mReceiverActive = true;
    }
  }
  
  public void unRegisterSelf(Context paramContext)
  {
    if (this.mReceiverActive)
    {
      paramContext.unregisterReceiver(this);
      this.mReceiverActive = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECircleBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */