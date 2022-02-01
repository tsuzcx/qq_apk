package com.tencent.av.gameplay;

import android.content.Context;
import android.content.res.AssetManager;
import lba;

public class ARNativeBridge
{
  public void a(long paramLong, String paramString1, Context paramContext, AssetManager paramAssetManager, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      native_CreateEngineBusiness(paramLong, paramString1, paramContext, paramAssetManager, paramString2, paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      lba.h("ARZimuTask_ARNativeBridge", "nativeCreateEngineBusiness has exception: " + paramString1);
      paramString1.printStackTrace();
    }
  }
  
  public native void native_CreateEngineBusiness(long paramLong, String paramString1, Context paramContext, AssetManager paramAssetManager, String paramString2, int paramInt1, int paramInt2, int paramInt3);
  
  public native void native_setDrawParticle(boolean paramBoolean);
  
  public native void native_stopEmitter(boolean paramBoolean);
  
  public native void native_updateEmitterLocation(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public native void native_updateParticleTexture(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native void native_updateResourcePath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.gameplay.ARNativeBridge
 * JD-Core Version:    0.7.0.1
 */