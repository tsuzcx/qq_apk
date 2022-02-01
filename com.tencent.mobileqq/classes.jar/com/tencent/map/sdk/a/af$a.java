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
    if (paramad == null) {
      return;
    }
    if (paramad.e > 0)
    {
      if (paramad.e > 5) {
        return;
      }
      this.d.add(paramad);
    }
  }
  
  public final void b(ad paramad)
  {
    if (paramad == null) {
      return;
    }
    try
    {
      if (((paramad.e == 1) || (paramad.e == 2)) && (this.d.contains(paramad))) {
        this.d.remove(paramad);
      }
      return;
    }
    finally {}
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = new StringBuilder("Appid：");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" domain：");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("\r\n");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder("apn：");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append(" ckIP：");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("\r\n");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    ((List)localObject).addAll(this.d);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ad localad = (ad)((Iterator)localObject).next();
      StringBuilder localStringBuilder2 = new StringBuilder("accessIP：");
      localStringBuilder2.append(localad.toString());
      localStringBuilder2.append("\r\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.af.a
 * JD-Core Version:    0.7.0.1
 */