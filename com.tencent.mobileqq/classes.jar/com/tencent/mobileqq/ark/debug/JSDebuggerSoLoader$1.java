package com.tencent.mobileqq.ark.debug;

import com.tencent.mobileqq.ark.delegate.IHTTPDownloadCallback;
import com.tencent.qphone.base.util.QLog;

final class JSDebuggerSoLoader$1
  implements IHTTPDownloadCallback
{
  JSDebuggerSoLoader$1(String paramString1, String paramString2, String paramString3) {}
  
  public void a(int paramInt, byte[] arg2)
  {
    if ((paramInt == 0) && (??? != null))
    {
      ??? = this.a;
      String str = this.b;
      if (JSDebuggerSoLoader.a(???, str, str, this.c))
      {
        JSDebuggerSoLoader.a(4);
        QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.testZipAndUnzip 2 succeed");
        JSDebuggerSoLoader.a(this.c, "libarkDebuggerJSImpl.so");
      }
      else
      {
        JSDebuggerSoLoader.a(5);
        QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.testZipAndUnzip 2 failed");
      }
    }
    else
    {
      JSDebuggerSoLoader.a(6);
      QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.onDownloadArkJSDebugger failed!");
    }
    synchronized (JSDebuggerSoLoader.b())
    {
      JSDebuggerSoLoader.a(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.1
 * JD-Core Version:    0.7.0.1
 */