package com.tencent.luggage.wxa.rt;

import android.annotation.TargetApi;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@TargetApi(21)
final class f$a
{
  static d.a a(File paramFile, d paramd, String paramString1, String paramString2)
  {
    try
    {
      paramFile = Os.stat(paramFile.getPath());
      if (paramFile == null) {
        return null;
      }
      boolean bool = OsConstants.S_ISDIR(paramFile.st_mode);
      paramFile = new d.a(paramd, paramString1, paramString2, paramFile.st_size, paramFile.st_blocks * 512L, paramFile.st_mtime * 1000L, bool);
      return paramFile;
    }
    catch (ErrnoException paramFile) {}
    return null;
  }
  
  static boolean a(String paramString1, String paramString2)
  {
    try
    {
      Os.rename(paramString1, paramString2);
      return true;
    }
    catch (ErrnoException localErrnoException)
    {
      if (localErrnoException.errno == OsConstants.EXDEV) {
        return false;
      }
      if (localErrnoException.errno == OsConstants.ENOENT)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot move file ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" to ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(": ");
        localStringBuilder.append(localErrnoException.getMessage());
        throw new FileNotFoundException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot move file ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(": ");
      localStringBuilder.append(localErrnoException.getMessage());
      throw new IOException(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.f.a
 * JD-Core Version:    0.7.0.1
 */