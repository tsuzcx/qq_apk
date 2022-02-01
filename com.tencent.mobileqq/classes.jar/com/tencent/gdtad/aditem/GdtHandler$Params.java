package com.tencent.gdtad.aditem;

import android.app.Activity;
import java.lang.ref.WeakReference;

public final class GdtHandler$Params
  extends GdtHandler.Options
{
  public Class a;
  public WeakReference<Activity> a;
  public WeakReference<GdtAppReceiver> b;
  public int c = -2147483648;
  
  public boolean a()
  {
    return (super.a()) && (b());
  }
  
  public boolean b()
  {
    WeakReference localWeakReference = this.a;
    return (localWeakReference != null) && (localWeakReference.get() != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler.Params
 * JD-Core Version:    0.7.0.1
 */