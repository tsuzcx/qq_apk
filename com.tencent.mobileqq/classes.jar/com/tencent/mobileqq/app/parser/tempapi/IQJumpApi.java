package com.tencent.mobileqq.app.parser.tempapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQJumpApi
  extends QRouteApi
{
  public abstract boolean backToFileScheme();
  
  public abstract void buildMapActivityProxy(String paramString);
  
  public abstract void checkDevLockStatus(QBaseActivity paramQBaseActivity);
  
  public abstract void devlockUpdate(byte[] paramArrayOfByte);
  
  public abstract String forwardGetFilePath(Context paramContext, Uri paramUri);
  
  public abstract boolean gestureGetJumpLock(Context paramContext, String paramString);
  
  public abstract String getSecurityVerifyPluginDataKey();
  
  public abstract void handleByColorNote();
  
  public abstract void handleStartGroupAudio(QBaseActivity paramQBaseActivity, String paramString);
  
  public abstract void nearByEnterNewGame(Context paramContext);
  
  public abstract String parseJumpActionName(AppRuntime paramAppRuntime, Context paramContext, String paramString);
  
  public abstract String parseJumpServerName(AppRuntime paramAppRuntime, Context paramContext, String paramString);
  
  public abstract Boolean qserIsOn();
  
  public abstract void qzoneLaunchForPreview(Context paramContext, Bundle paramBundle);
  
  public abstract void releaseMapActivityProxy();
  
  public abstract void startForwardActivity(Context paramContext, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
 * JD-Core Version:    0.7.0.1
 */