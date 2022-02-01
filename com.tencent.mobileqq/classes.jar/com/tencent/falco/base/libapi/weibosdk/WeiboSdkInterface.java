package com.tencent.falco.base.libapi.weibosdk;

import android.app.Activity;
import android.content.Intent;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface WeiboSdkInterface
  extends ServiceBaseInterface
{
  public abstract boolean isWeiboInstalled();
  
  public abstract void login(Activity paramActivity, WeiboLoginCallback paramWeiboLoginCallback);
  
  public abstract void onWeiboResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void share(Activity paramActivity, WeiboShareData paramWeiboShareData, WeiboShareListener paramWeiboShareListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.weibosdk.WeiboSdkInterface
 * JD-Core Version:    0.7.0.1
 */