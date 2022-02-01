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
  
  private AdProgressDialogAdapter getAdapter()
  {
    if (this.adapter != null) {
      return (AdProgressDialogAdapter)this.adapter.get();
    }
    return null;
  }
  
  public void dismiss()
  {
    AdProgressDialogAdapter localAdProgressDialogAdapter = getAdapter();
    if (localAdProgressDialogAdapter != null) {
      localAdProgressDialogAdapter.dismiss();
    }
  }
  
  public boolean isShowing(Context paramContext)
  {
    AdProgressDialogAdapter localAdProgressDialogAdapter = getAdapter();
    if (localAdProgressDialogAdapter != null) {}
    for (paramContext = Boolean.valueOf(localAdProgressDialogAdapter.isShowing(paramContext));; paramContext = null) {
      return paramContext.booleanValue();
    }
  }
  
  public void setAdapter(WeakReference<AdProgressDialogAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
  
  public void show(Context paramContext, AdProgressDialog.Params paramParams)
  {
    AdProgressDialogAdapter localAdProgressDialogAdapter = getAdapter();
    if (localAdProgressDialogAdapter != null) {
      localAdProgressDialogAdapter.show(paramContext, paramParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.dialog.AdProgressDialog
 * JD-Core Version:    0.7.0.1
 */