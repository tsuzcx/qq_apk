package com.tencent.mobileqq.ar.model;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.Size;
import com.tencent.mobileqq.ar.ARRecord.VideoRecordController;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManagerCallBack;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderTrackInfo;
import com.tencent.mobileqq.ar.view.GLRenderStatusCallBack;
import java.nio.FloatBuffer;

public abstract interface UniformGLRenderManager
  extends GLSurfaceView.Renderer
{
  public abstract int a();
  
  public abstract long a();
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void a(int paramInt, Object paramObject);
  
  public abstract void a(int paramInt, float[] paramArrayOfFloat);
  
  public abstract void a(long paramLong);
  
  public abstract void a(VideoRecordController paramVideoRecordController);
  
  public abstract void a(ARRenderManagerCallBack paramARRenderManagerCallBack);
  
  public abstract void a(ARRenderTrackInfo paramARRenderTrackInfo);
  
  public abstract void a(GLRenderStatusCallBack paramGLRenderStatusCallBack);
  
  public abstract void a(FloatBuffer paramFloatBuffer, Size paramSize);
  
  public abstract boolean a();
  
  public abstract boolean a(GLSurfaceView paramGLSurfaceView, Context paramContext);
  
  public abstract boolean a(ARRenderResourceInfo paramARRenderResourceInfo);
  
  public abstract boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2);
  
  public abstract void b();
  
  public abstract void b(long paramLong);
  
  public abstract boolean b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManager
 * JD-Core Version:    0.7.0.1
 */