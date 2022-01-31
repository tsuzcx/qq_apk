package com.tencent.ad.tangram.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;

@Keep
public final class AdAppDeeplinkLauncher$Params
{
  public int addflags = -2147483648;
  public String deeplink;
  public Bundle extrasForIntent;
  public String packageName;
  
  Intent getIntent()
  {
    Object localObject1 = null;
    if (!isValid()) {}
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = AdUriUtil.parse(this.deeplink);
      } while (localObject2 == null);
      localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject2);
      if (!TextUtils.isEmpty(this.packageName)) {
        ((Intent)localObject2).setPackage(this.packageName);
      }
      if ((this.extrasForIntent != null) && (!this.extrasForIntent.isEmpty())) {
        ((Intent)localObject2).putExtras(this.extrasForIntent);
      }
      localObject1 = localObject2;
    } while (this.addflags == -2147483648);
    ((Intent)localObject2).addFlags(this.addflags);
    return localObject2;
  }
  
  boolean isValid()
  {
    return !TextUtils.isEmpty(this.deeplink);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Params
 * JD-Core Version:    0.7.0.1
 */