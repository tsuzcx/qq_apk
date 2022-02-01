package com.tencent.ad.tangram.util;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.AdError;

@Keep
public final class AdAppDeeplinkLauncher$Result
{
  AdError error;
  ResolveInfo resolveInfo;
  
  String getActivityName()
  {
    ResolveInfo localResolveInfo = this.resolveInfo;
    if ((localResolveInfo != null) && (localResolveInfo.activityInfo != null)) {
      return this.resolveInfo.activityInfo.name;
    }
    return null;
  }
  
  AdError getError()
  {
    AdError localAdError = this.error;
    if (localAdError != null) {
      return localAdError;
    }
    return new AdError(1);
  }
  
  public int getErrorCode()
  {
    return getError().getErrorCode();
  }
  
  public boolean isSuccess()
  {
    AdError localAdError = this.error;
    return (localAdError != null) && (localAdError.isSuccess());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Result
 * JD-Core Version:    0.7.0.1
 */