package com.tencent.camerasdk.avreport;

import java.io.File;
import java.io.FileInputStream;

class Reporter$1
  implements Runnable
{
  Reporter$1(Reporter paramReporter) {}
  
  public void run()
  {
    try
    {
      File[] arrayOfFile = Reporter.access$000(this.this$0).listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if ((localFile.exists()) && (localFile.isFile()))
        {
          FileInputStream localFileInputStream = new FileInputStream(localFile);
          byte[] arrayOfByte = new byte[1024];
          StringBuffer localStringBuffer = new StringBuffer();
          for (;;)
          {
            int k = localFileInputStream.read(arrayOfByte);
            if (k == -1) {
              break;
            }
            localStringBuffer.append(new String(arrayOfByte, 0, k));
          }
          localFileInputStream.close();
          localFile.delete();
          Reporter.access$100(this.this$0, localStringBuffer.toString());
        }
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      Reporter.access$200(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.Reporter.1
 * JD-Core Version:    0.7.0.1
 */