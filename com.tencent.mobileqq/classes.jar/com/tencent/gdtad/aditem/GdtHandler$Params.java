package com.tencent.gdtad.aditem;

import android.app.Activity;
import java.lang.ref.WeakReference;

public final class GdtHandler$Params
  extends GdtHandler.Options
{
  public int q = -2147483648;
  public WeakReference<Activity> r;
  public WeakReference<GdtAppReceiver> s;
  public Class t;
  
  public boolean a()
  {
    return (super.a()) && (b());
  }
  
  public boolean b()
  {
    WeakReference localWeakReference = this.r;
    return (localWeakReference != null) && (localWeakReference.get() != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler.Params
 * JD-Core Version:    0.7.0.1
 */