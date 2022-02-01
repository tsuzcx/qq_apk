package com.tencent.falco.base.libapi.toast;

import android.widget.Toast;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface ToastInterface
  extends ServiceBaseInterface
{
  public abstract Toast makeToast(String paramString, int paramInt);
  
  public abstract void showToast(int paramInt);
  
  public abstract void showToast(int paramInt1, int paramInt2);
  
  public abstract void showToast(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void showToast(int paramInt, boolean paramBoolean);
  
  public abstract void showToast(String paramString);
  
  public abstract void showToast(String paramString, int paramInt);
  
  public abstract void showToast(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void showToast(String paramString, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void showToast(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.toast.ToastInterface
 * JD-Core Version:    0.7.0.1
 */