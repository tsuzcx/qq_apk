package com.tencent.luggage.wxa.cg;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public final class b
{
  private String a;
  private String b;
  private RandomAccessFile c;
  private FileLock d;
  
  public b(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  private boolean c()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b));
  }
  
  public String a(int paramInt)
  {
    if (!c()) {
      return null;
    }
    Object localObject = this.c;
    int i;
    if (localObject != null)
    {
      if (this.d == null) {
        return null;
      }
      i = paramInt;
    }
    do
    {
      try
      {
        if (((RandomAccessFile)localObject).length() > paramInt) {
          continue;
        }
        i = Long.valueOf(this.c.length()).intValue();
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdUUIDFile", "read", localThrowable);
      }
      localObject = new byte[i];
      if (this.c.read((byte[])localObject, 0, i) == i)
      {
        localObject = new String((byte[])localObject, 0, i, "UTF-8");
        return localObject;
      }
      return null;
      return null;
    } while (i > 0);
    return null;
  }
  
  public boolean a()
  {
    if (!c()) {
      return false;
    }
    if (this.c == null)
    {
      if (this.d != null) {
        return false;
      }
      try
      {
        File localFile1 = new File(Environment.getExternalStorageDirectory(), this.a);
        File localFile2 = new File(localFile1, this.b);
        if ((!localFile1.exists()) && (!localFile1.mkdirs())) {
          return false;
        }
        this.c = new RandomAccessFile(localFile2, "rwd");
        this.d = this.c.getChannel().lock();
        if (!localFile2.isFile())
        {
          b();
          return false;
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdUUIDFile", "open", localThrowable);
        b();
      }
    }
    return false;
  }
  
  public void b()
  {
    try
    {
      if (this.d != null)
      {
        this.d.release();
        this.d = null;
      }
    }
    catch (Throwable localThrowable1)
    {
      Log.e("AdUUIDFile", "close", localThrowable1);
    }
    try
    {
      if (this.c != null)
      {
        this.c.close();
        this.c = null;
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      Log.e("AdUUIDFile", "close", localThrowable2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cg.b
 * JD-Core Version:    0.7.0.1
 */