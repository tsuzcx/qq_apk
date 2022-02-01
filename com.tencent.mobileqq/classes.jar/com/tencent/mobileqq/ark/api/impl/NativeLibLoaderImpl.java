package com.tencent.mobileqq.ark.api.impl;

import android.content.Context;
import com.tencent.mobileqq.ark.api.INativeLibLoader;
import com.tencent.mobileqq.ark.core.ArkEnvironment;
import com.tencent.mobileqq.ark.util.NativeLibLoader;
import com.tencent.qphone.base.util.BaseApplication;

public class NativeLibLoaderImpl
  implements INativeLibLoader
{
  public void extractArkLibrary()
  {
    NativeLibLoader.a(BaseApplication.getContext(), "ark", false);
  }
  
  public void extractPNGLibrary()
  {
    NativeLibLoader.b(BaseApplication.getContext(), "png-armeabi-v7a");
  }
  
  public void extractWordSegmentLibrary()
  {
    NativeLibLoader.a(BaseApplication.getContext(), "WordSegment", false);
  }
  
  public boolean isArkLibraryLoaded()
  {
    return ArkEnvironment.b;
  }
  
  public void loadArkLibrary() {}
  
  public boolean loadPNGLibrary(Context paramContext)
  {
    return NativeLibLoader.a(paramContext, NativeLibLoader.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.NativeLibLoaderImpl
 * JD-Core Version:    0.7.0.1
 */