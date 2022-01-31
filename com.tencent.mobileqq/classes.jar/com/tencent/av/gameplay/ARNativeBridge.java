package com.tencent.av.gameplay;

import android.content.Context;
import android.content.res.AssetManager;

public class ARNativeBridge
{
  public native void native_CreateEngineBusiness(long paramLong, String paramString1, Context paramContext, AssetManager paramAssetManager, String paramString2, int paramInt1, int paramInt2, int paramInt3);
  
  public native void native_setDrawParticle(boolean paramBoolean);
  
  public native void native_stopEmitter(boolean paramBoolean);
  
  public native void native_updateEmitterLocation(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public native void native_updateParticleTexture(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native void native_updateResourcePath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.gameplay.ARNativeBridge
 * JD-Core Version:    0.7.0.1
 */