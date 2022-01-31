package com.tencent.ad.tangram.dialog;

import android.content.Context;
import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public enum AdProgressDialog
{
  INSTANCE;
  
  private WeakReference<AdProgressDialogAdapter> adapter;
  
  private AdProgressDialog() {}
  
  public static void dismiss()
  {
    AdProgressDialogAdapter localAdProgressDialogAdapter = getAdapter();
    if (localAdProgressDialogAdapter != null) {
      localAdProgressDialogAdapter.dismiss();
    }
  }
  
  private static AdProgressDialogAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdProgressDialogAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdProgressDialogAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
  
  public static void show(Context paramContext, int paramInt)
  {
    AdProgressDialogAdapter localAdProgressDialogAdapter = getAdapter();
    if (localAdProgressDialogAdapter != null) {
      localAdProgressDialogAdapter.show(paramContext, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.dialog.AdProgressDialog
 * JD-Core Version:    0.7.0.1
 */