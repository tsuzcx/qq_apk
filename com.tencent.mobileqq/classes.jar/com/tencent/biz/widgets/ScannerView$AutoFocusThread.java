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
  Camera jdField_a_of_type_AndroidHardwareCamera;
  Handler jdField_a_of_type_AndroidOsHandler;
  protected Runnable a;
  
  public ScannerView$AutoFocusThread(ScannerView paramScannerView, Camera paramCamera)
  {
    this.jdField_a_of_type_JavaLangRunnable = new ScannerView.AutoFocusThread.1(this);
    this.jdField_a_of_type_AndroidHardwareCamera = paramCamera;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void a()
  {
    try
    {
      if ((ScannerView.e(this.this$0)) && (this.jdField_a_of_type_AndroidHardwareCamera != null) && (ScannerView.f(this.this$0)))
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2500L);
        this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this);
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/biz/widgets/ScannerView$AutoFocusThread:this$0	Lcom/tencent/biz/widgets/ScannerView;
    //   4: invokestatic 93	com/tencent/biz/widgets/ScannerView:d	(Lcom/tencent/biz/widgets/ScannerView;)Z
    //   7: ifeq +15 -> 22
    //   10: aload_0
    //   11: getfield 16	com/tencent/biz/widgets/ScannerView$AutoFocusThread:this$0	Lcom/tencent/biz/widgets/ScannerView;
    //   14: iconst_0
    //   15: invokestatic 96	com/tencent/biz/widgets/ScannerView:c	(Lcom/tencent/biz/widgets/ScannerView;Z)Z
    //   18: pop
    //   19: goto +9 -> 28
    //   22: ldc2_w 97
    //   25: invokestatic 102	java/lang/Thread:sleep	(J)V
    //   28: aload_0
    //   29: invokevirtual 104	com/tencent/biz/widgets/ScannerView$AutoFocusThread:a	()V
    //   32: goto -32 -> 0
    //   35: aload_0
    //   36: getfield 16	com/tencent/biz/widgets/ScannerView$AutoFocusThread:this$0	Lcom/tencent/biz/widgets/ScannerView;
    //   39: invokestatic 48	com/tencent/biz/widgets/ScannerView:e	(Lcom/tencent/biz/widgets/ScannerView;)Z
    //   42: ifne +35 -> 77
    //   45: aload_0
    //   46: getfield 28	com/tencent/biz/widgets/ScannerView$AutoFocusThread:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   49: invokevirtual 107	android/hardware/Camera:cancelAutoFocus	()V
    //   52: aload_0
    //   53: getfield 16	com/tencent/biz/widgets/ScannerView$AutoFocusThread:this$0	Lcom/tencent/biz/widgets/ScannerView;
    //   56: iconst_1
    //   57: invokestatic 67	com/tencent/biz/widgets/ScannerView:b	(Lcom/tencent/biz/widgets/ScannerView;Z)Z
    //   60: pop
    //   61: aload_0
    //   62: getfield 41	com/tencent/biz/widgets/ScannerView$AutoFocusThread:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   65: aload_0
    //   66: getfield 26	com/tencent/biz/widgets/ScannerView$AutoFocusThread:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   69: invokevirtual 86	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 28	com/tencent/biz/widgets/ScannerView$AutoFocusThread:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.AutoFocusThread
 * JD-Core Version:    0.7.0.1
 */