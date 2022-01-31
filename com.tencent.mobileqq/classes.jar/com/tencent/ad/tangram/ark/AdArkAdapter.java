package com.tencent.ad.tangram.ark;

import android.graphics.Rect;
import android.support.annotation.Keep;
import android.view.View;
import java.lang.ref.WeakReference;

@Keep
public abstract interface AdArkAdapter
{
  public abstract Rect getArkInputRect(View paramView);
  
  public abstract View getArkView(AdArkAdapter.Params paramParams);
  
  public abstract View getSelectWindowArkView(AdArkAdapter.Params paramParams);
  
  public abstract void setNotify(WeakReference<AdArkAdapter.ArkNotifyCallback> paramWeakReference);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.ark.AdArkAdapter
 * JD-Core Version:    0.7.0.1
 */