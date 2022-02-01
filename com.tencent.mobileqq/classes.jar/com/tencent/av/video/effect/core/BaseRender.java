package com.tencent.av.video.effect.core;

import android.opengl.GLES20;
import com.tencent.av.video.effect.utils.CommonUtils;
import java.util.LinkedList;
import java.util.Queue;

public class BaseRender
{
  private static final String TAG = "BaseRender";
  protected int mHeight = 0;
  protected int mOutFbo = -1;
  protected int mOutTextureId = -1;
  private final Queue<Runnable> mTaskListBeforeProcess = new LinkedList();
  protected int mWidth = 0;
  
  private void runAll(Queue<Runnable> paramQueue)
  {
    try
    {
      while (!paramQueue.isEmpty()) {
        ((Runnable)paramQueue.poll()).run();
      }
    }
    finally {}
  }
  
  protected void addTaskBeforeProcess(Runnable paramRunnable)
  {
    synchronized (this.mTaskListBeforeProcess)
    {
      this.mTaskListBeforeProcess.add(paramRunnable);
      return;
    }
  }
  
  protected void baseProcess(int paramInt1, int paramInt2)
  {
    runAllTaskBeforeProcess();
    onSizeChange(paramInt1, paramInt2);
  }
  
  public void destroy()
  {
    this.mWidth = 0;
    this.mHeight = 0;
    if (this.mOutTextureId != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.mOutTextureId }, 0);
      this.mOutTextureId = -1;
    }
    if (this.mOutFbo != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.mOutFbo }, 0);
      this.mOutFbo = -1;
    }
  }
  
  protected void onSizeChange(int paramInt1, int paramInt2)
  {
    if ((this.mWidth != paramInt1) || (this.mHeight != paramInt2))
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      if (this.mOutTextureId != -1)
      {
        GLES20.glDeleteTextures(1, new int[] { this.mOutTextureId }, 0);
        this.mOutTextureId = -1;
      }
      if (this.mOutFbo != -1)
      {
        GLES20.glDeleteFramebuffers(1, new int[] { this.mOutFbo }, 0);
        this.mOutFbo = -1;
      }
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.mOutTextureId = arrayOfInt[0];
      this.mOutFbo = CommonUtils.initFrameBuffer(this.mWidth, this.mHeight, this.mOutTextureId);
    }
  }
  
  public EffectTexture process(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    baseProcess(paramInt3, paramInt4);
    return new EffectTexture(paramInt1, paramInt2, this.mWidth, this.mHeight);
  }
  
  protected void runAllTaskBeforeProcess()
  {
    runAll(this.mTaskListBeforeProcess);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.BaseRender
 * JD-Core Version:    0.7.0.1
 */