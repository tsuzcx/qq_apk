package com.tencent.camerasdk.avreport;

import java.io.File;
import java.io.FileInputStream;

class Reporter$1
  implements Runnable
{
  Reporter$1(Reporter paramReporter) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      File localFile;
      StringBuffer localStringBuffer;
      try
      {
        File[] arrayOfFile = Reporter.access$000(this.this$0).listFiles();
        int j = arrayOfFile.length;
        FileInputStream localFileInputStream;
        if (i < j)
        {
          localFile = arrayOfFile[i];
          if ((!localFile.exists()) || (!localFile.isFile())) {
            break label143;
          }
          localFileInputStream = new FileInputStream(localFile);
          byte[] arrayOfByte = new byte[1024];
          localStringBuffer = new StringBuffer();
          int k = localFileInputStream.read(arrayOfByte);
          if (k == -1) {
            break label120;
          }
          localStringBuffer.append(new String(arrayOfByte, 0, k));
          continue;
        }
        localFileInputStream.close();
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        Reporter.access$200(this.this$0);
        return;
      }
      label120:
      localFile.delete();
      Reporter.access$100(this.this$0, localStringBuffer.toString());
      label143:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.camerasdk.avreport.Reporter.1
 * JD-Core Version:    0.7.0.1
 */