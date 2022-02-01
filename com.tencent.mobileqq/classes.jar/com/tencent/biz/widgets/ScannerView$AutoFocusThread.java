package com.tencent.biz.widgets;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

class ScannerView$AutoFocusThread
  extends Thread
  implements Camera.AutoFocusCallback
{
  Camera a;
  Handler b;
  protected Runnable c = new ScannerView.AutoFocusThread.1(this);
  
  public ScannerView$AutoFocusThread(ScannerView paramScannerView, Camera paramCamera)
  {
    this.a = paramCamera;
    this.b = new Handler(Looper.getMainLooper());
  }
  
  public void a()
  {
    try
    {
      if ((ScannerView.j(this.this$0)) && (this.a != null) && (ScannerView.k(this.this$0)))
      {
        this.b.postDelayed(this.c, 2500L);
        this.a.autoFocus(this);
        ScannerView.b(this.this$0, false);
      }
      return;
    }
    finally {}
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScannerView", 4, "onAutoFocus");
    }
    ScannerView.b(this.this$0, true);
    this.b.removeCallbacks(this.c);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/biz/widgets/ScannerView$AutoFocusThread:this$0	Lcom/tencent/biz/widgets/ScannerView;
    //   4: invokestatic 95	com/tencent/biz/widgets/ScannerView:i	(Lcom/tencent/biz/widgets/ScannerView;)Z
    //   7: ifeq +15 -> 22
    //   10: aload_0
    //   11: getfield 18	com/tencent/biz/widgets/ScannerView$AutoFocusThread:this$0	Lcom/tencent/biz/widgets/ScannerView;
    //   14: iconst_0
    //   15: invokestatic 97	com/tencent/biz/widgets/ScannerView:c	(Lcom/tencent/biz/widgets/ScannerView;Z)Z
    //   18: pop
    //   19: goto +9 -> 28
    //   22: ldc2_w 98
    //   25: invokestatic 103	java/lang/Thread:sleep	(J)V
    //   28: aload_0
    //   29: invokevirtual 105	com/tencent/biz/widgets/ScannerView$AutoFocusThread:a	()V
    //   32: goto -32 -> 0
    //   35: aload_0
    //   36: getfield 18	com/tencent/biz/widgets/ScannerView$AutoFocusThread:this$0	Lcom/tencent/biz/widgets/ScannerView;
    //   39: invokestatic 50	com/tencent/biz/widgets/ScannerView:j	(Lcom/tencent/biz/widgets/ScannerView;)Z
    //   42: ifne +35 -> 77
    //   45: aload_0
    //   46: getfield 30	com/tencent/biz/widgets/ScannerView$AutoFocusThread:a	Landroid/hardware/Camera;
    //   49: invokevirtual 108	android/hardware/Camera:cancelAutoFocus	()V
    //   52: aload_0
    //   53: getfield 18	com/tencent/biz/widgets/ScannerView$AutoFocusThread:this$0	Lcom/tencent/biz/widgets/ScannerView;
    //   56: iconst_1
    //   57: invokestatic 68	com/tencent/biz/widgets/ScannerView:b	(Lcom/tencent/biz/widgets/ScannerView;Z)Z
    //   60: pop
    //   61: aload_0
    //   62: getfield 43	com/tencent/biz/widgets/ScannerView$AutoFocusThread:b	Landroid/os/Handler;
    //   65: aload_0
    //   66: getfield 28	com/tencent/biz/widgets/ScannerView$AutoFocusThread:c	Ljava/lang/Runnable;
    //   69: invokevirtual 87	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 30	com/tencent/biz/widgets/ScannerView$AutoFocusThread:a	Landroid/hardware/Camera;
    //   77: return
    //   78: astore_1
    //   79: goto -44 -> 35
    //   82: astore_1
    //   83: goto -83 -> 0
    //   86: astore_1
    //   87: goto -15 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	AutoFocusThread
    //   78	1	1	localInterruptedException	java.lang.InterruptedException
    //   82	1	1	localRuntimeException1	java.lang.RuntimeException
    //   86	1	1	localRuntimeException2	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   0	19	78	java/lang/InterruptedException
    //   22	28	78	java/lang/InterruptedException
    //   28	32	78	java/lang/InterruptedException
    //   28	32	82	java/lang/RuntimeException
    //   45	72	86	java/lang/RuntimeException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.AutoFocusThread
 * JD-Core Version:    0.7.0.1
 */