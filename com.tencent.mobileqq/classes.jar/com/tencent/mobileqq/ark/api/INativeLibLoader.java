package com.tencent.mobileqq.ark.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INativeLibLoader
  extends QRouteApi
{
  public abstract void extractArkLibrary();
  
  public abstract void extractPNGLibrary();
  
  public abstract void extractWordSegmentLibrary();
  
  public abstract boolean isArkLibraryLoaded();
  
  public abstract void loadArkLibrary();
  
  public abstract boolean loadPNGLibrary(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.INativeLibLoader
 * JD-Core Version:    0.7.0.1
 */