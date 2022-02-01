package com.qwallet.temp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qwallet.plugin.ipc.TickReq;

@QAPI(process={"all"})
public abstract interface IQWalletApiProxy
  extends QRouteApi
{
  public abstract void decodeDrawable(Drawable paramDrawable, IQWalletApiProxy.OnDecodeListener paramOnDecodeListener);
  
  public abstract boolean getAppForground(Context paramContext);
  
  public abstract Drawable getDrawableForWallet(String paramString, Drawable paramDrawable, Bundle paramBundle);
  
  public abstract boolean launchPlugin(Context paramContext, Bundle paramBundle);
  
  public abstract void onPubAcc(String paramString);
  
  public abstract void onSetBaseActivityUnlockSuceess();
  
  public abstract void setLastExitWalletTime(long paramLong, TickReq paramTickReq);
  
  public abstract void syncQWalletPatternLock(BaseQQAppInterface paramBaseQQAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qwallet.temp.IQWalletApiProxy
 * JD-Core Version:    0.7.0.1
 */