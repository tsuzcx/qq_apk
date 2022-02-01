package com.tencent.ad.tangram.ark;

import android.graphics.Rect;
import android.support.annotation.Keep;
import android.view.View;
import java.lang.ref.WeakReference;

@Keep
public abstract interface AdArkAdapter
{
  public abstract View buildArkView(AdArkAdapter.Params paramParams);
  
  public abstract View buildSelectWindowArkView(AdArkAdapter.Params paramParams);
  
  public abstract String getArkFormData(AdArkAdapter.DataParams paramDataParams);
  
  public abstract Rect getArkInputRect(View paramView);
  
  public abstract void setNotify(WeakReference<AdArkAdapter.ArkNotifyCallback> paramWeakReference);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.ark.AdArkAdapter
 * JD-Core Version:    0.7.0.1
 */