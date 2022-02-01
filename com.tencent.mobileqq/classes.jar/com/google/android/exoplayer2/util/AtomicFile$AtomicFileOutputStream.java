package com.google.android.exoplayer2.util;

import android.support.annotation.NonNull;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class AtomicFile$AtomicFileOutputStream
  extends OutputStream
{
  private boolean closed = false;
  private final FileOutputStream fileOutputStream;
  
  public AtomicFile$AtomicFileOutputStream(File paramFile)
  {
    this.fileOutputStream = new FileOutputStream(paramFile);
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    this.closed = true;
    flush();
    try
    {
      this.fileOutputStream.getFD().sync();
      this.fileOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.w("AtomicFile", "Failed to sync file descriptor:", localIOException);
      }
    }
  }
  
  public void flush()
  {
    this.fileOutputStream.flush();
  }
  
  public void write(int paramInt)
  {
    this.fileOutputStream.write(paramInt);
  }
  
  public void write(@NonNull byte[] paramArrayOfByte)
  {
    this.fileOutputStream.write(paramArrayOfByte);
  }
  
  public void write(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.fileOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.util.AtomicFile.AtomicFileOutputStream
 * JD-Core Version:    0.7.0.1
 */