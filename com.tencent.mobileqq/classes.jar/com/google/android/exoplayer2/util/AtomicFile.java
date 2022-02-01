package com.google.android.exoplayer2.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class AtomicFile
{
  private static final String TAG = "AtomicFile";
  private final File backupName;
  private final File baseName;
  
  public AtomicFile(File paramFile)
  {
    this.baseName = paramFile;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getPath());
    localStringBuilder.append(".bak");
    this.backupName = new File(localStringBuilder.toString());
  }
  
  private void restoreBackup()
  {
    if (this.backupName.exists())
    {
      this.baseName.delete();
      this.backupName.renameTo(this.baseName);
    }
  }
  
  public void delete()
  {
    this.baseName.delete();
    this.backupName.delete();
  }
  
  public void endWrite(OutputStream paramOutputStream)
  {
    paramOutputStream.close();
    this.backupName.delete();
  }
  
  public InputStream openRead()
  {
    restoreBackup();
    return new FileInputStream(this.baseName);
  }
  
  public OutputStream startWrite()
  {
    Object localObject;
    if (this.baseName.exists()) {
      if (!this.backupName.exists())
      {
        if (!this.baseName.renameTo(this.backupName))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Couldn't rename file ");
          ((StringBuilder)localObject).append(this.baseName);
          ((StringBuilder)localObject).append(" to backup file ");
          ((StringBuilder)localObject).append(this.backupName);
          Log.w("AtomicFile", ((StringBuilder)localObject).toString());
        }
      }
      else {
        this.baseName.delete();
      }
    }
    try
    {
      localObject = new AtomicFile.AtomicFileOutputStream(this.baseName);
      return localObject;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      if (this.baseName.getParentFile().mkdirs()) {
        try
        {
          AtomicFile.AtomicFileOutputStream localAtomicFileOutputStream = new AtomicFile.AtomicFileOutputStream(this.baseName);
          return localAtomicFileOutputStream;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Couldn't create ");
          localStringBuilder.append(this.baseName);
          throw new IOException(localStringBuilder.toString(), localFileNotFoundException2);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Couldn't create directory ");
      localStringBuilder.append(this.baseName);
      throw new IOException(localStringBuilder.toString(), localFileNotFoundException2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.AtomicFile
 * JD-Core Version:    0.7.0.1
 */