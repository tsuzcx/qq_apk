package com.tencent.luggage.wxa.rt;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

class f$1$1
  extends f.b
{
  f$1$1(f.1 param1, File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(param1.c, paramFile, paramBoolean1, paramBoolean2);
  }
  
  protected d.a a(File paramFile)
  {
    return null;
  }
  
  protected Iterator<? extends d.a> a(File paramFile, d.a parama)
  {
    paramFile = paramFile.listFiles();
    if (paramFile == null) {
      return null;
    }
    return new f.b(this.a.c, Arrays.asList(paramFile), this.c, this.a.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.f.1.1
 * JD-Core Version:    0.7.0.1
 */