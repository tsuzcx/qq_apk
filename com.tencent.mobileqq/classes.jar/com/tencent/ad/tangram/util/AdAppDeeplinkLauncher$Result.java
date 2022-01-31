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
    if ((this.resolveInfo != null) && (this.resolveInfo.activityInfo != null)) {
      return this.resolveInfo.activityInfo.name;
    }
    return null;
  }
  
  AdError getError()
  {
    if (this.error != null) {
      return this.error;
    }
    return new AdError(1);
  }
  
  int getErrorCode()
  {
    return getError().getErrorCode();
  }
  
  public boolean isSuccess()
  {
    return (this.error != null) && (this.error.isSuccess());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Result
 * JD-Core Version:    0.7.0.1
 */