package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import androidx.annotation.Nullable;

public abstract interface i$a
  extends DialogInterface, i
{
  public abstract void setCancelable(boolean paramBoolean);
  
  public abstract void setCanceledOnTouchOutside(boolean paramBoolean);
  
  public abstract void setMessage(CharSequence paramCharSequence);
  
  public abstract void setOnCancelListener(@Nullable DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract void setTitle(CharSequence paramCharSequence);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i.a
 * JD-Core Version:    0.7.0.1
 */