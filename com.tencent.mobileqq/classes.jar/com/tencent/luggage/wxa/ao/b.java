package com.tencent.luggage.wxa.ao;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class b
{
  private final File a;
  private final File b;
  
  public b(File paramFile)
  {
    this.a = paramFile;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getPath());
    localStringBuilder.append(".bak");
    this.b = new File(localStringBuilder.toString());
  }
  
  private void d()
  {
    if (this.b.exists())
    {
      this.a.delete();
      this.b.renameTo(this.a);
    }
  }
  
  public void a()
  {
    this.a.delete();
    this.b.delete();
  }
  
  public void a(OutputStream paramOutputStream)
  {
    paramOutputStream.close();
    this.b.delete();
  }
  
  public OutputStream b()
  {
    if (this.a.exists()) {
      if (!this.b.exists())
      {
        if (!this.a.renameTo(this.b))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Couldn't rename file ");
          ((StringBuilder)localObject).append(this.a);
          ((StringBuilder)localObject).append(" to backup file ");
          ((StringBuilder)localObject).append(this.b);
          Log.w("AtomicFile", ((StringBuilder)localObject).toString());
        }
      }
      else {
        this.a.delete();
      }
    }
    try
    {
      localObject = new b.a(this.a);
      return localObject;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      label109:
      break label109;
    }
    if (this.a.getParentFile().mkdirs()) {}
    try
    {
      localObject = new b.a(this.a);
      return localObject;
    }
    catch (FileNotFoundException localFileNotFoundException2)
    {
      label136:
      break label136;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Couldn't create ");
    ((StringBuilder)localObject).append(this.a);
    throw new IOException(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Couldn't create directory ");
    ((StringBuilder)localObject).append(this.a);
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  public InputStream c()
  {
    d();
    return new FileInputStream(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.b
 * JD-Core Version:    0.7.0.1
 */