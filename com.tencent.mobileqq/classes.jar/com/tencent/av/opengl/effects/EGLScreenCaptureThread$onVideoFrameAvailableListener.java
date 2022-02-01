package com.tencent.av.opengl.effects;

import android.graphics.Bitmap;
import com.tencent.avcore.data.RecordParam;

public abstract interface EGLScreenCaptureThread$onVideoFrameAvailableListener
{
  public abstract void a(Bitmap paramBitmap, RecordParam paramRecordParam);
  
  public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, RecordParam paramRecordParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EGLScreenCaptureThread.onVideoFrameAvailableListener
 * JD-Core Version:    0.7.0.1
 */