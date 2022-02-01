package com.tencent.ilivesdk.playview.view;

import com.tencent.ilivesdk.utils.LogUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class GLTextureView$GLThread
  extends Thread
{
  private GLTextureView.EglHelper mEglHelper;
  private ArrayList<Runnable> mEventQueue = new ArrayList();
  private boolean mExited;
  private boolean mFinishedCreatingEglSurface;
  private WeakReference<GLTextureView> mGLTextureViewWeakRef;
  private boolean mHasSurface;
  private boolean mHaveEglContext;
  private boolean mHaveEglSurface;
  private int mHeight = 0;
  private boolean mLogPrinted = false;
  private boolean mPaused;
  private boolean mRenderComplete;
  private int mRenderMode = 1;
  private boolean mRequestPaused;
  private boolean mRequestRender = true;
  private boolean mShouldExit;
  private boolean mShouldReleaseEglContext;
  private boolean mSizeChanged = true;
  private boolean mSurfaceIsBad;
  private boolean mWaitingForSurface;
  private int mWidth = 0;
  
  GLTextureView$GLThread(WeakReference<GLTextureView> paramWeakReference)
  {
    this.mGLTextureViewWeakRef = paramWeakReference;
  }
  
  private void guardedRun()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean readyToDraw()
  {
    boolean bool2 = this.mPaused;
    boolean bool1 = true;
    if ((!bool2) && (this.mHasSurface) && (!this.mSurfaceIsBad) && (this.mWidth > 0) && (this.mHeight > 0))
    {
      if (this.mRequestRender) {
        return bool1;
      }
      if (this.mRenderMode == 1) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  private void stopEglContextLocked()
  {
    if (this.mHaveEglContext)
    {
      this.mEglHelper.finish();
      this.mHaveEglContext = false;
      GLTextureView.access$800().releaseEglContextLocked(this);
    }
  }
  
  private void stopEglSurfaceLocked()
  {
    if (this.mHaveEglSurface)
    {
      this.mHaveEglSurface = false;
      this.mEglHelper.destroySurface();
    }
  }
  
  public boolean ableToDraw()
  {
    return (this.mHaveEglContext) && (this.mHaveEglSurface) && (readyToDraw());
  }
  
  public int getRenderMode()
  {
    synchronized ()
    {
      int i = this.mRenderMode;
      return i;
    }
  }
  
  public void onPause()
  {
    synchronized ()
    {
      this.mRequestPaused = true;
      GLTextureView.access$800().notifyAll();
      while (!this.mExited)
      {
        boolean bool = this.mPaused;
        if (bool) {
          break;
        }
        try
        {
          GLTextureView.access$800().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label42:
          break label42;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void onResume()
  {
    synchronized ()
    {
      this.mRequestPaused = false;
      this.mRequestRender = true;
      this.mRenderComplete = false;
      GLTextureView.access$800().notifyAll();
      while ((!this.mExited) && (this.mPaused))
      {
        boolean bool = this.mRenderComplete;
        if (bool) {
          break;
        }
        try
        {
          GLTextureView.access$800().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label59:
          break label59;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void onWindowResize(int paramInt1, int paramInt2)
  {
    synchronized ()
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      this.mSizeChanged = true;
      this.mRequestRender = true;
      this.mRenderComplete = false;
      GLTextureView.access$800().notifyAll();
      while ((!this.mExited) && (!this.mPaused) && (!this.mRenderComplete))
      {
        boolean bool = ableToDraw();
        if (!bool) {
          break;
        }
        try
        {
          GLTextureView.access$800().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label78:
          break label78;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void queueEvent(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      synchronized (GLTextureView.access$800())
      {
        this.mEventQueue.add(paramRunnable);
        GLTextureView.access$800().notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("r must not be null");
  }
  
  public void requestExitAndWait()
  {
    synchronized ()
    {
      this.mShouldExit = true;
      GLTextureView.access$800().notifyAll();
      for (;;)
      {
        boolean bool = this.mExited;
        if (bool) {
          break;
        }
        try
        {
          GLTextureView.access$800().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label35:
          break label35;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void requestReleaseEglContextLocked()
  {
    this.mShouldReleaseEglContext = true;
    GLTextureView.access$800().notifyAll();
  }
  
  public void requestRender()
  {
    synchronized ()
    {
      this.mRequestRender = true;
      GLTextureView.access$800().notifyAll();
      return;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 162	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 165
    //   11: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 173	com/tencent/ilivesdk/playview/view/GLTextureView$GLThread:getId	()J
    //   20: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 183	com/tencent/ilivesdk/playview/view/GLTextureView$GLThread:setName	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: invokespecial 185	com/tencent/ilivesdk/playview/view/GLTextureView$GLThread:guardedRun	()V
    //   36: invokestatic 97	com/tencent/ilivesdk/playview/view/GLTextureView:access$800	()Lcom/tencent/ilivesdk/playview/view/GLTextureView$GLThreadManager;
    //   39: aload_0
    //   40: invokevirtual 188	com/tencent/ilivesdk/playview/view/GLTextureView$GLThreadManager:threadExiting	(Lcom/tencent/ilivesdk/playview/view/GLTextureView$GLThread;)V
    //   43: return
    //   44: astore_1
    //   45: invokestatic 97	com/tencent/ilivesdk/playview/view/GLTextureView:access$800	()Lcom/tencent/ilivesdk/playview/view/GLTextureView$GLThreadManager;
    //   48: aload_0
    //   49: invokevirtual 188	com/tencent/ilivesdk/playview/view/GLTextureView$GLThreadManager:threadExiting	(Lcom/tencent/ilivesdk/playview/view/GLTextureView$GLThread;)V
    //   52: aload_1
    //   53: athrow
    //   54: astore_1
    //   55: goto -19 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	GLThread
    //   7	19	1	localStringBuilder	StringBuilder
    //   44	9	1	localObject	Object
    //   54	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   32	36	44	finally
    //   32	36	54	java/lang/InterruptedException
  }
  
  public void setRenderMode(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      synchronized (GLTextureView.access$800())
      {
        this.mRenderMode = paramInt;
        GLTextureView.access$800().notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("renderMode");
  }
  
  public void surfaceCreated()
  {
    synchronized ()
    {
      this.mHasSurface = true;
      this.mFinishedCreatingEglSurface = false;
      GLTextureView.access$800().notifyAll();
      while ((this.mWaitingForSurface) && (!this.mFinishedCreatingEglSurface))
      {
        boolean bool = this.mExited;
        if (bool) {
          break;
        }
        try
        {
          GLTextureView.access$800().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label54:
          break label54;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void surfaceDestroyed()
  {
    synchronized ()
    {
      this.mHasSurface = false;
      GLTextureView.access$800().notifyAll();
      while ((!this.mWaitingForSurface) && (!this.mExited))
      {
        if (!this.mLogPrinted)
        {
          this.mLogPrinted = true;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mWaitingForSurface ");
          localStringBuilder.append(this.mWaitingForSurface);
          localStringBuilder.append(" mExited ");
          localStringBuilder.append(this.mExited);
          LogUtils.d("Render|GLTextureView", localStringBuilder.toString());
        }
        try
        {
          GLTextureView.access$800().wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label101:
          break label101;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.GLTextureView.GLThread
 * JD-Core Version:    0.7.0.1
 */