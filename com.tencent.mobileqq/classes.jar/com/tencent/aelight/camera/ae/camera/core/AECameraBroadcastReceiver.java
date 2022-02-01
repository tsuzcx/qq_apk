package com.tencent.aelight.camera.ae.camera.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.tencent.aelight.camera.ae.AEBaseCameraUnit;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;

public class AECameraBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AECameraReceiver";
  private AEBaseCameraUnit captureUnit;
  
  public AECameraBroadcastReceiver(AEBaseCameraUnit paramAEBaseCameraUnit)
  {
    this.captureUnit = paramAEBaseCameraUnit;
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
    paramContext = this.captureUnit.s();
    if (paramContext != null)
    {
      if (paramContext.isFinishing()) {
        return;
      }
      paramContext = paramIntent.getAction();
      paramIntent = new StringBuilder();
      paramIntent.append("AECameraBroadcastReceiver onReceive: action = ");
      paramIntent.append(paramContext);
      AEQLog.a("AECameraReceiver", paramIntent.toString());
      paramIntent = AEResInfo.getAEResInfoByPrefix(paramContext);
      if (AEResInfo.isAdittionPackage(paramIntent))
      {
        if ((this.captureUnit instanceof AEPituCameraUnit))
        {
          paramContext = AEResUtil.f(paramIntent);
          paramIntent = paramIntent.agentType;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("AECameraBroadcastReceiver 收到广播 isAdittionPackage: path = ");
          localStringBuilder.append(paramContext);
          localStringBuilder.append(" agent = ");
          localStringBuilder.append(paramIntent);
          AEQLog.a("AECameraReceiver", localStringBuilder.toString());
          ((AEPituCameraUnit)this.captureUnit).b(paramContext, paramIntent);
          ((AEPituCameraUnit)this.captureUnit).aG();
        }
      }
      else if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
      {
        paramIntent = new StringBuilder();
        paramIntent.append("AECameraBroadcastReceiver onReceive: action = ");
        paramIntent.append(paramContext);
        Log.d("AECameraReceiver", paramIntent.toString());
      }
    }
  }
  
  public void registerSelf(Activity paramActivity)
  {
    paramActivity.registerReceiver(this, getBroadcastIntentFilter());
  }
  
  public void unRegisterSelf(Activity paramActivity)
  {
    paramActivity.unregisterReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */