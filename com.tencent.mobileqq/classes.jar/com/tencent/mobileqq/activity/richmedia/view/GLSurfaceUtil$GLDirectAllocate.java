package com.tencent.mobileqq.activity.richmedia.view;

import java.nio.ByteBuffer;

public class GLSurfaceUtil$GLDirectAllocate
{
  public static ByteBuffer a(int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    try
    {
      if (GLSurfaceUtil.c)
      {
        localObject1 = CameraGLSurfaceView.allocate(paramInt1, paramInt2);
        GLSurfaceUtil.b = true;
      }
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = ByteBuffer.allocateDirect(paramInt2);
        GLSurfaceUtil.b = false;
      }
      return localObject3;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.GLSurfaceUtil.GLDirectAllocate
 * JD-Core Version:    0.7.0.1
 */