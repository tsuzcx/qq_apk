package com.tencent.ad.tangram.file;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

@Keep
public final class AdFile
{
  private static final String TAG = "AdFile";
  private String charsetName;
  private String directoryPath;
  private FileLock fileLock;
  private String filename;
  private RandomAccessFile randomAccessFile;
  private boolean writable = false;
  
  public AdFile(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.directoryPath = paramString1;
    this.filename = paramString2;
    this.charsetName = paramString3;
    this.writable = paramBoolean;
  }
  
  private boolean isValid()
  {
    return (!TextUtils.isEmpty(this.directoryPath)) && (!TextUtils.isEmpty(this.filename)) && (!TextUtils.isEmpty(this.charsetName));
  }
  
  public void close()
  {
    try
    {
      if (this.fileLock != null)
      {
        this.fileLock.release();
        this.fileLock = null;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          if (this.randomAccessFile != null)
          {
            this.randomAccessFile.close();
            this.randomAccessFile = null;
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          AdLog.e("AdFile", "close", localThrowable2);
        }
        localThrowable1 = localThrowable1;
        AdLog.e("AdFile", "close", localThrowable1);
      }
    }
  }
  
  public boolean open()
  {
    if (!isValid()) {}
    while ((this.randomAccessFile != null) || (this.fileLock != null)) {
      return false;
    }
    for (;;)
    {
      try
      {
        Object localObject = new File(this.directoryPath);
        File localFile = new File((File)localObject, this.filename);
        if ((this.writable) && (!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
          break;
        }
        if (this.writable)
        {
          localObject = "rwd";
          this.randomAccessFile = new RandomAccessFile(localFile, (String)localObject);
          if (!this.writable) {
            break label154;
          }
          this.fileLock = this.randomAccessFile.getChannel().lock();
          if ((localFile.exists()) && (localFile.isFile())) {
            break label176;
          }
          close();
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        AdLog.e("AdFile", "open", localThrowable);
        close();
        return false;
      }
      String str = "r";
      continue;
      label154:
      this.fileLock = this.randomAccessFile.getChannel().tryLock(0L, 9223372036854775807L, true);
    }
    label176:
    return true;
  }
  
  public String readFully()
  {
    return readFully(-2147483648);
  }
  
  public String readFully(int paramInt)
  {
    if (!isValid()) {}
    for (;;)
    {
      return null;
      if ((this.randomAccessFile != null) && (this.fileLock != null))
      {
        int i;
        if (paramInt != -2147483648) {
          i = paramInt;
        }
        try
        {
          if (this.randomAccessFile.length() <= paramInt) {
            i = Long.valueOf(this.randomAccessFile.length()).intValue();
          }
          if (i > 0)
          {
            Object localObject = new byte[i];
            if (this.randomAccessFile.read((byte[])localObject, 0, i) == i)
            {
              localObject = new String((byte[])localObject, 0, i, this.charsetName);
              return localObject;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("AdFile", "read", localThrowable);
        }
      }
    }
    return null;
  }
  
  public boolean writeFully(String paramString)
  {
    if (!isValid()) {}
    while ((!this.writable) || (this.randomAccessFile == null) || (this.fileLock == null)) {
      return false;
    }
    try
    {
      this.randomAccessFile.setLength(0L);
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.getBytes(this.charsetName);
        this.randomAccessFile.write(paramString);
      }
      return true;
    }
    catch (Throwable paramString)
    {
      AdLog.e("AdFile", "write", paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.file.AdFile
 * JD-Core Version:    0.7.0.1
 */