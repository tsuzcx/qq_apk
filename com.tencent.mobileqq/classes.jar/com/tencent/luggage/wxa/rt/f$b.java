package com.tencent.luggage.wxa.rt;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class f$b
  extends o.a<File, d.a>
{
  private final boolean a;
  
  f$b(f paramf, File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramf, Collections.singletonList(paramFile), paramBoolean1, paramBoolean2);
  }
  
  private f$b(List<File> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramBoolean1.iterator(), paramBoolean2);
    boolean bool;
    this.a = bool;
  }
  
  protected d.a a(File paramFile)
  {
    return f.a(this.b, paramFile);
  }
  
  protected Iterator<? extends d.a> a(File paramFile, d.a parama)
  {
    if (!this.a) {
      return null;
    }
    if ((parama != null) && (!parama.f)) {
      return null;
    }
    paramFile = paramFile.listFiles();
    if (paramFile != null)
    {
      if (paramFile.length == 0) {
        return null;
      }
      return new b(this.b, Arrays.asList(paramFile), this.c, true);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.f.b
 * JD-Core Version:    0.7.0.1
 */