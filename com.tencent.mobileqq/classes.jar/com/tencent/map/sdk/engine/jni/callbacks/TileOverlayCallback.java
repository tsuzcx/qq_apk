package com.tencent.map.sdk.engine.jni.callbacks;

import android.graphics.Bitmap;

public abstract interface TileOverlayCallback
{
  public abstract Bitmap onLoadTile(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  public abstract void onWriteTile(int paramInt1, int paramInt2, int paramInt3, String paramString, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.engine.jni.callbacks.TileOverlayCallback
 * JD-Core Version:    0.7.0.1
 */