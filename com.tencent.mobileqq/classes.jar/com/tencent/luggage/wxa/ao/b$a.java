package com.tencent.luggage.wxa.ao;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class b$a
  extends OutputStream
{
  private final FileOutputStream a;
  private boolean b = false;
  
  public b$a(File paramFile)
  {
    this.a = new FileOutputStream(paramFile);
  }
  
  public void close()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    flush();
    try
    {
      this.a.getFD().sync();
    }
    catch (IOException localIOException)
    {
      Log.w("AtomicFile", "Failed to sync file descriptor:", localIOException);
    }
    this.a.close();
  }
  
  public void flush()
  {
    this.a.flush();
  }
  
  public void write(int paramInt)
  {
    this.a.write(paramInt);
  }
  
  public void write(@NonNull byte[] paramArrayOfByte)
  {
    this.a.write(paramArrayOfByte);
  }
  
  public void write(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.b.a
 * JD-Core Version:    0.7.0.1
 */