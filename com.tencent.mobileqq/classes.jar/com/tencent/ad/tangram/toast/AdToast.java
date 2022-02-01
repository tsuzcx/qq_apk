package com.tencent.ad.tangram.toast;

import android.content.Context;
import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public enum AdToast
{
  INSTANCE;
  
  public static final int ICON_DEFAULT = 0;
  public static final int ICON_ERROR = 1;
  public static final int ICON_SUCCESS = 2;
  private WeakReference<AdToastAdapter> adapter;
  
  private AdToast() {}
  
  private static AdToastAdapter getAdapter()
  {
    WeakReference localWeakReference = INSTANCE.adapter;
    if (localWeakReference != null) {
      return (AdToastAdapter)localWeakReference.get();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdToastAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
  
  public static void show(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    AdToastAdapter localAdToastAdapter = getAdapter();
    if (localAdToastAdapter != null) {
      localAdToastAdapter.show(paramContext, paramInt1, paramCharSequence, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.toast.AdToast
 * JD-Core Version:    0.7.0.1
 */