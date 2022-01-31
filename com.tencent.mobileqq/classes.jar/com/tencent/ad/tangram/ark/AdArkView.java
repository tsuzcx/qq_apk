package com.tencent.ad.tangram.ark;

import android.graphics.Rect;
import android.support.annotation.Keep;
import android.view.View;
import java.lang.ref.WeakReference;

@Keep
public enum AdArkView
{
  INSTANCE;
  
  private WeakReference<AdArkAdapter> adapter;
  
  private AdArkView() {}
  
  public static View buildArkView(AdArkAdapter.Params paramParams)
  {
    AdArkAdapter localAdArkAdapter = getAdapter();
    if (localAdArkAdapter != null) {
      return localAdArkAdapter.buildArkView(paramParams);
    }
    return null;
  }
  
  public static View buildSelectWindowArkView(AdArkAdapter.Params paramParams)
  {
    AdArkAdapter localAdArkAdapter = getAdapter();
    if (localAdArkAdapter != null) {
      return localAdArkAdapter.buildSelectWindowArkView(paramParams);
    }
    return null;
  }
  
  private static AdArkAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdArkAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static String getArkFormData(AdArkAdapter.DataParams paramDataParams)
  {
    AdArkAdapter localAdArkAdapter = getAdapter();
    if (localAdArkAdapter != null) {
      return localAdArkAdapter.getArkFormData(paramDataParams);
    }
    return null;
  }
  
  public static Rect getArkInputRect(View paramView)
  {
    AdArkAdapter localAdArkAdapter = getAdapter();
    if (localAdArkAdapter != null) {
      return localAdArkAdapter.getArkInputRect(paramView);
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdArkAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
  
  public static void setNotify(WeakReference<AdArkAdapter.ArkNotifyCallback> paramWeakReference)
  {
    AdArkAdapter localAdArkAdapter = getAdapter();
    if (localAdArkAdapter != null) {
      localAdArkAdapter.setNotify(paramWeakReference);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.ark.AdArkView
 * JD-Core Version:    0.7.0.1
 */