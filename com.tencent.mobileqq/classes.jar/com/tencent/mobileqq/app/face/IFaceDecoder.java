package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;

public abstract interface IFaceDecoder
{
  public abstract void cancelPendingRequests();
  
  public abstract void destory();
  
  public abstract Bitmap getBitmapFromCache(int paramInt, String paramString);
  
  public abstract Bitmap getBitmapFromCache(int paramInt1, String paramString, int paramInt2);
  
  public abstract Bitmap getBitmapFromCache(int paramInt1, String paramString, int paramInt2, byte paramByte);
  
  public abstract Bitmap getBitmapFromCacheFrom(int paramInt1, String paramString, int paramInt2);
  
  public abstract boolean isPausing();
  
  public abstract void pause();
  
  public abstract void refreshFaceWithTimeStamp(int paramInt1, String paramString, int paramInt2, long paramLong, int paramInt3);
  
  public abstract boolean requestDecodeFace(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract boolean requestDecodeFace(String paramString, int paramInt, boolean paramBoolean, byte paramByte);
  
  public abstract boolean requestDecodeFace(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3);
  
  public abstract boolean requestDecodeQCallFace(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean requestDecodeStrangeFace(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void resume();
  
  public abstract void setAppRuntime(AppInterface paramAppInterface);
  
  public abstract void setDecodeTaskCompletionListener(DecodeTaskCompletionListener paramDecodeTaskCompletionListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.IFaceDecoder
 * JD-Core Version:    0.7.0.1
 */