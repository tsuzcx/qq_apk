package com.tencent.ad.tangram.dialog;

import android.content.Context;
import android.support.annotation.Keep;

@Keep
public abstract interface AdProgressDialogAdapter
{
  public abstract void dismiss();
  
  public abstract boolean isShowing(Context paramContext);
  
  public abstract void show(Context paramContext, AdProgressDialog.Params paramParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.dialog.AdProgressDialogAdapter
 * JD-Core Version:    0.7.0.1
 */