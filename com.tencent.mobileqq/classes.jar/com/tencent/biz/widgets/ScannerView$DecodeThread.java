package com.tencent.biz.widgets;

import android.os.HandlerThread;
import android.os.Process;
import bijo;
import com.tencent.qphone.base.util.QLog;

class ScannerView$DecodeThread
  extends HandlerThread
{
  public boolean a;
  
  public ScannerView$DecodeThread(ScannerView paramScannerView, String paramString)
  {
    super(paramString);
  }
  
  public boolean quit()
  {
    this.a = true;
    if (QLog.isColorLevel()) {
      QLog.d("ScannerView", 2, "decode thread quit");
    }
    try
    {
      bijo.b();
      return super.quit();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ScannerView", 2, localUnsatisfiedLinkError.toString());
        }
      }
    }
  }
  
  public void run()
  {
    Process.setThreadPriority(-20);
    try
    {
      int i = bijo.b(0, "ANY", "UTF-8");
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 1;
      int j = bijo.b((int[])localObject, localObject.length);
      localObject = bijo.a();
      if (QLog.isDevelopLevel())
      {
        QLog.d("ScannerView", 4, "init for camera init_result1:" + i + ",init_result2:" + j);
        QLog.d("ScannerView", 4, "version:" + (String)localObject);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ScannerView", 2, localUnsatisfiedLinkError.toString());
        }
      }
    }
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.DecodeThread
 * JD-Core Version:    0.7.0.1
 */