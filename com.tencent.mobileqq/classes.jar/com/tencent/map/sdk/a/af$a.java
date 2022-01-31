package com.tencent.map.sdk.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class af$a
{
  Integer a;
  String b;
  String c;
  List<ad> d = new ArrayList();
  String e;
  private String f;
  
  public af$a(String paramString)
  {
    this.f = paramString;
  }
  
  public final void a(ad paramad)
  {
    if (paramad == null) {}
    while ((paramad.e <= 0) || (paramad.e > 5)) {
      return;
    }
    this.d.add(paramad);
  }
  
  public final void b(ad paramad)
  {
    if (paramad == null) {}
    for (;;)
    {
      return;
      try
      {
        if (((paramad.e != 1) && (paramad.e != 2)) || (!this.d.contains(paramad))) {
          continue;
        }
        this.d.remove(paramad);
      }
      finally {}
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Appid：" + this.a + " domain：" + this.b + "\r\n");
    localStringBuilder.append("apn：" + this.f + " ckIP：" + this.c + "\r\n");
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.d);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ad localad = (ad)((Iterator)localObject).next();
      localStringBuilder.append("accessIP：" + localad.toString() + "\r\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.af.a
 * JD-Core Version:    0.7.0.1
 */