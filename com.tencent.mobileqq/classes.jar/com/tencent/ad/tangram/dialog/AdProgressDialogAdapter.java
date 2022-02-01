package com.tencent.ad.tangram.dialog;

import android.content.Context;
import android.support.annotation.Keep;

@Keep
public abstract interface AdProgressDialogAdapter
{
  public abstract void dismiss();
  
  public abstract void show(Context paramContext, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.dialog.AdProgressDialogAdapter
 * JD-Core Version:    0.7.0.1
 */