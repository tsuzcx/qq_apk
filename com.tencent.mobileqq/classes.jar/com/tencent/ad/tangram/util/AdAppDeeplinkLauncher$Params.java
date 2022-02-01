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
    if (!isValid()) {
      return null;
    }
    Object localObject = AdUriUtil.parse(this.deeplink);
    if (localObject == null) {
      return null;
    }
    localObject = new Intent("android.intent.action.VIEW", (Uri)localObject);
    if (!TextUtils.isEmpty(this.packageName)) {
      ((Intent)localObject).setPackage(this.packageName);
    }
    Bundle localBundle = this.extrasForIntent;
    if ((localBundle != null) && (!localBundle.isEmpty())) {
      ((Intent)localObject).putExtras(this.extrasForIntent);
    }
    int i = this.addflags;
    if (i != -2147483648) {
      ((Intent)localObject).addFlags(i);
    }
    return localObject;
  }
  
  boolean isValid()
  {
    return TextUtils.isEmpty(this.deeplink) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Params
 * JD-Core Version:    0.7.0.1
 */