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
    this.backupName = new File(paramFile.getPath() + ".bak");
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
    if (this.baseName.exists())
    {
      if (this.backupName.exists()) {
        break label88;
      }
      if (!this.baseName.renameTo(this.backupName)) {
        Log.w("AtomicFile", "Couldn't rename file " + this.baseName + " to backup file " + this.backupName);
      }
    }
    for (;;)
    {
      try
      {
        AtomicFile.AtomicFileOutputStream localAtomicFileOutputStream1 = new AtomicFile.AtomicFileOutputStream(this.baseName);
        return localAtomicFileOutputStream1;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        label88:
        if (this.baseName.getParentFile().mkdirs()) {
          continue;
        }
        throw new IOException("Couldn't create directory " + this.baseName, localFileNotFoundException1);
        try
        {
          AtomicFile.AtomicFileOutputStream localAtomicFileOutputStream2 = new AtomicFile.AtomicFileOutputStream(this.baseName);
          return localAtomicFileOutputStream2;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          throw new IOException("Couldn't create " + this.baseName, localFileNotFoundException2);
        }
      }
      this.baseName.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.util.AtomicFile
 * JD-Core Version:    0.7.0.1
 */