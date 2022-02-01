package com.tencent.falco.base.libapi.qqsdk;

import android.app.Activity;
import android.content.Intent;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface QQSdkInterface
  extends ServiceBaseInterface
{
  public abstract boolean isQQInstalled();
  
  public abstract void login(QQLoginCallback paramQQLoginCallback);
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void shareToQQ(Activity paramActivity, QQBaseShareData paramQQBaseShareData, QQShareListener paramQQShareListener);
  
  public abstract void shareToQzone(Activity paramActivity, QZoneBaseShareData paramQZoneBaseShareData, QZoneShareListener paramQZoneShareListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.qqsdk.QQSdkInterface
 * JD-Core Version:    0.7.0.1
 */