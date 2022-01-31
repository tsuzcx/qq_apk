package com.tencent.mobileqq.ar.ARRenderModel;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;

public abstract interface ARRenderManager
  extends GLSurfaceView.Renderer
{
  public abstract long a();
  
  public abstract void a();
  
  public abstract void a(int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void a(int paramInt, Object paramObject);
  
  public abstract void a(int paramInt, float[] paramArrayOfFloat);
  
  public abstract void a(long paramLong);
  
  public abstract void a(VideoRecordController paramVideoRecordController);
  
  public abstract void a(ARRenderTrackInfo paramARRenderTrackInfo);
  
  public abstract boolean a();
  
  public abstract boolean a(GLSurfaceView paramGLSurfaceView, Context paramContext, ARRenderManagerCallBack paramARRenderManagerCallBack);
  
  public abstract boolean a(ARRenderResourceInfo paramARRenderResourceInfo);
  
  public abstract boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2);
  
  public abstract void b();
  
  public abstract void b(long paramLong);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARRenderManager
 * JD-Core Version:    0.7.0.1
 */