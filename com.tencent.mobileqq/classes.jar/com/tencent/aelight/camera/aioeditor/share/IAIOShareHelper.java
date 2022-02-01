package com.tencent.aelight.camera.aioeditor.share;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"peak"})
public abstract interface IAIOShareHelper
  extends QRouteApi
{
  public abstract void dismissLoading();
  
  public abstract void shareToQQ(@NonNull Activity paramActivity, int paramInt, @Nullable String paramString, @NonNull AIOShareObject paramAIOShareObject);
  
  public abstract void shareToQZone(@NonNull Activity paramActivity, @NonNull AIOShareObject paramAIOShareObject);
  
  public abstract void shareToWX(@NonNull Activity paramActivity, int paramInt, String paramString, @NonNull AIOShareObject paramAIOShareObject, @Nullable IAIOShareHelper.AIOWXShareListener paramAIOWXShareListener);
  
  public abstract void showLoading(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper
 * JD-Core Version:    0.7.0.1
 */