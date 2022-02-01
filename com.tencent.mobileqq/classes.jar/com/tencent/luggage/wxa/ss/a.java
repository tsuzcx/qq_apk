package com.tencent.luggage.wxa.ss;

import java.io.File;

public class a
  implements d
{
  File a;
  
  public a(File paramFile)
  {
    this.a = paramFile;
  }
  
  public String a()
  {
    return this.a.getPath();
  }
  
  public boolean b()
  {
    return this.a.isDirectory();
  }
  
  public d[] c()
  {
    File[] arrayOfFile = this.a.listFiles();
    int i = 0;
    if ((arrayOfFile != null) && (arrayOfFile.length != 0))
    {
      d[] arrayOfd = new d[arrayOfFile.length];
      while (i < arrayOfFile.length)
      {
        arrayOfd[i] = new a(arrayOfFile[i]);
        i += 1;
      }
      return arrayOfd;
    }
    return new d[0];
  }
  
  public boolean d()
  {
    return this.a.exists();
  }
  
  public boolean e()
  {
    return this.a.delete();
  }
  
  public String[] f()
  {
    return this.a.list();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ss.a
 * JD-Core Version:    0.7.0.1
 */