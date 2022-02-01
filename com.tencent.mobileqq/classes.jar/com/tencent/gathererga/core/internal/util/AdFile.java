package com.tencent.gathererga.core.internal.util;

import android.text.TextUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class AdFile
{
  private String a;
  private String b;
  private String c;
  private boolean d = false;
  private RandomAccessFile e;
  private FileLock f;
  
  public AdFile(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramBoolean;
  }
  
  private boolean d()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c));
  }
  
  public String a(int paramInt)
  {
    if (!d()) {
      return null;
    }
    Object localObject = this.e;
    int i;
    if (localObject != null)
    {
      if (this.f == null) {
        return null;
      }
      if (paramInt != -2147483648) {
        i = paramInt;
      }
    }
    do
    {
      try
      {
        if (((RandomAccessFile)localObject).length() > paramInt) {
          continue;
        }
        i = Long.valueOf(this.e.length()).intValue();
      }
      catch (Throwable localThrowable)
      {
        GLog.b("AdFile read", localThrowable);
      }
      localObject = new byte[i];
      if (this.e.read((byte[])localObject, 0, i) == i)
      {
        localObject = new String((byte[])localObject, 0, i, this.c);
        return localObject;
      }
      return null;
      return null;
    } while (i > 0);
    return null;
  }
  
  public boolean a()
  {
    if (!d()) {
      return false;
    }
    if (this.e == null) {
      if (this.f != null) {
        return false;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = new File(this.a);
        File localFile = new File((File)localObject, this.b);
        if ((this.d) && (!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
          return false;
        }
        if (!this.d) {
          break label178;
        }
        localObject = "rwd";
        this.e = new RandomAccessFile(localFile, (String)localObject);
        if (this.d) {
          this.f = this.e.getChannel().lock();
        } else {
          this.f = this.e.getChannel().tryLock(0L, 9223372036854775807L, true);
        }
        if (localFile.exists()) {
          if (localFile.isFile()) {
            break;
          }
        }
        b();
        return false;
      }
      catch (Throwable localThrowable)
      {
        GLog.b("AdFile open", localThrowable);
        b();
      }
      return false;
      label178:
      String str = "r";
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (!d()) {
      return false;
    }
    if (!this.d) {
      return false;
    }
    RandomAccessFile localRandomAccessFile = this.e;
    if (localRandomAccessFile != null)
    {
      if (this.f == null) {
        return false;
      }
      try
      {
        localRandomAccessFile.setLength(0L);
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = paramString.getBytes(this.c);
          this.e.write(paramString);
        }
        return true;
      }
      catch (Throwable paramString)
      {
        GLog.b("AdFile write", paramString);
      }
    }
    return false;
  }
  
  public void b()
  {
    try
    {
      if (this.f != null)
      {
        this.f.release();
        this.f = null;
      }
    }
    catch (Throwable localThrowable1)
    {
      GLog.b("AdFile close", localThrowable1);
    }
    try
    {
      if (this.e != null)
      {
        this.e.close();
        this.e = null;
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      GLog.b("AdFile close", localThrowable2);
    }
  }
  
  public String c()
  {
    return a(-2147483648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.AdFile
 * JD-Core Version:    0.7.0.1
 */