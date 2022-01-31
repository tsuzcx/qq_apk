package com.tencent.mobileqq.armap;

import android.opengl.GLES20;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

class SupercellActivity$10
  implements ARGLSurfaceView.SurfaceStateListener
{
  boolean isOnpuse = false;
  
  SupercellActivity$10(SupercellActivity paramSupercellActivity) {}
  
  public void onDestroy()
  {
    SupercellActivity.access$2000(this.this$0).c();
  }
  
  public void onEGLConfigCreated(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext, long paramLong) {}
  
  public void onEGLContextDestroyed(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext) {}
  
  public void onInit(long paramLong)
  {
    SupercellActivity.access$602(this.this$0, paramLong);
  }
  
  /* Error */
  @android.annotation.TargetApi(14)
  public void onPause()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 19	com/tencent/mobileqq/armap/SupercellActivity$10:isOnpuse	Z
    //   5: aload_0
    //   6: getfield 14	com/tencent/mobileqq/armap/SupercellActivity$10:this$0	Lcom/tencent/mobileqq/armap/SupercellActivity;
    //   9: invokestatic 27	com/tencent/mobileqq/armap/SupercellActivity:access$2000	(Lcom/tencent/mobileqq/armap/SupercellActivity;)Lcom/tencent/mobileqq/armap/CameraSurfaceView;
    //   12: invokevirtual 32	com/tencent/mobileqq/armap/CameraSurfaceView:c	()V
    //   15: aload_0
    //   16: getfield 14	com/tencent/mobileqq/armap/SupercellActivity$10:this$0	Lcom/tencent/mobileqq/armap/SupercellActivity;
    //   19: invokestatic 52	com/tencent/mobileqq/armap/SupercellActivity:access$700	(Lcom/tencent/mobileqq/armap/SupercellActivity;)Landroid/graphics/SurfaceTexture;
    //   22: ifnull +33 -> 55
    //   25: aload_0
    //   26: getfield 14	com/tencent/mobileqq/armap/SupercellActivity$10:this$0	Lcom/tencent/mobileqq/armap/SupercellActivity;
    //   29: invokestatic 52	com/tencent/mobileqq/armap/SupercellActivity:access$700	(Lcom/tencent/mobileqq/armap/SupercellActivity;)Landroid/graphics/SurfaceTexture;
    //   32: aconst_null
    //   33: invokevirtual 58	android/graphics/SurfaceTexture:setOnFrameAvailableListener	(Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;)V
    //   36: aload_0
    //   37: getfield 14	com/tencent/mobileqq/armap/SupercellActivity$10:this$0	Lcom/tencent/mobileqq/armap/SupercellActivity;
    //   40: invokestatic 52	com/tencent/mobileqq/armap/SupercellActivity:access$700	(Lcom/tencent/mobileqq/armap/SupercellActivity;)Landroid/graphics/SurfaceTexture;
    //   43: invokevirtual 61	android/graphics/SurfaceTexture:release	()V
    //   46: aload_0
    //   47: getfield 14	com/tencent/mobileqq/armap/SupercellActivity$10:this$0	Lcom/tencent/mobileqq/armap/SupercellActivity;
    //   50: aconst_null
    //   51: invokestatic 65	com/tencent/mobileqq/armap/SupercellActivity:access$702	(Lcom/tencent/mobileqq/armap/SupercellActivity;Landroid/graphics/SurfaceTexture;)Landroid/graphics/SurfaceTexture;
    //   54: pop
    //   55: aload_0
    //   56: getfield 14	com/tencent/mobileqq/armap/SupercellActivity$10:this$0	Lcom/tencent/mobileqq/armap/SupercellActivity;
    //   59: invokestatic 68	com/tencent/mobileqq/armap/SupercellActivity:access$900	(Lcom/tencent/mobileqq/armap/SupercellActivity;)Landroid/graphics/SurfaceTexture;
    //   62: ifnull +33 -> 95
    //   65: aload_0
    //   66: getfield 14	com/tencent/mobileqq/armap/SupercellActivity$10:this$0	Lcom/tencent/mobileqq/armap/SupercellActivity;
    //   69: invokestatic 68	com/tencent/mobileqq/armap/SupercellActivity:access$900	(Lcom/tencent/mobileqq/armap/SupercellActivity;)Landroid/graphics/SurfaceTexture;
    //   72: aconst_null
    //   73: invokevirtual 58	android/graphics/SurfaceTexture:setOnFrameAvailableListener	(Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;)V
    //   76: aload_0
    //   77: getfield 14	com/tencent/mobileqq/armap/SupercellActivity$10:this$0	Lcom/tencent/mobileqq/armap/SupercellActivity;
    //   80: invokestatic 68	com/tencent/mobileqq/armap/SupercellActivity:access$900	(Lcom/tencent/mobileqq/armap/SupercellActivity;)Landroid/graphics/SurfaceTexture;
    //   83: invokevirtual 61	android/graphics/SurfaceTexture:release	()V
    //   86: aload_0
    //   87: getfield 14	com/tencent/mobileqq/armap/SupercellActivity$10:this$0	Lcom/tencent/mobileqq/armap/SupercellActivity;
    //   90: aconst_null
    //   91: invokestatic 71	com/tencent/mobileqq/armap/SupercellActivity:access$902	(Lcom/tencent/mobileqq/armap/SupercellActivity;Landroid/graphics/SurfaceTexture;)Landroid/graphics/SurfaceTexture;
    //   94: pop
    //   95: return
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   101: goto -55 -> 46
    //   104: astore_1
    //   105: goto -50 -> 55
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   113: goto -27 -> 86
    //   116: astore_1
    //   117: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	10
    //   96	2	1	localException1	java.lang.Exception
    //   104	1	1	localException2	java.lang.Exception
    //   108	2	1	localException3	java.lang.Exception
    //   116	1	1	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   36	46	96	java/lang/Exception
    //   15	36	104	java/lang/Exception
    //   46	55	104	java/lang/Exception
    //   97	101	104	java/lang/Exception
    //   76	86	108	java/lang/Exception
    //   55	76	116	java/lang/Exception
    //   86	95	116	java/lang/Exception
    //   109	113	116	java/lang/Exception
  }
  
  public void onResume()
  {
    if (!this.isOnpuse) {
      return;
    }
    this.isOnpuse = false;
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (SupercellActivity.access$800(this.this$0) < 1)
    {
      paramGL10 = new int[1];
      GLES20.glGenTextures(1, paramGL10, 0);
      SupercellActivity.access$802(this.this$0, paramGL10[0]);
      if (SupercellActivity.access$800(this.this$0) < 1) {
        SupercellActivity.access$802(this.this$0, 10001);
      }
      GLES20.glBindTexture(36197, SupercellActivity.access$800(this.this$0));
      GLES20.glTexParameterf(36197, 10241, 9728.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
    }
    if (SupercellActivity.access$1000(this.this$0) < 1)
    {
      paramGL10 = new int[1];
      SupercellActivity.access$1002(this.this$0, paramGL10[0]);
      if (SupercellActivity.access$1000(this.this$0) < 1) {
        SupercellActivity.access$1002(this.this$0, 10000);
      }
      GLES20.glBindTexture(36197, SupercellActivity.access$1000(this.this$0));
      GLES20.glTexParameterf(36197, 10241, 9728.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.10
 * JD-Core Version:    0.7.0.1
 */