package com.tencent.featuretoggle.hltxkg.common.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b$a
{
  Integer a;
  String b;
  String c;
  List<a> d = new ArrayList();
  String e;
  private String f;
  
  public b$a(String paramString)
  {
    this.f = paramString;
  }
  
  public final void a(a parama)
  {
    if (parama == null) {
      return;
    }
    if (parama.b() > 0)
    {
      if (parama.b() > 5) {
        return;
      }
      this.d.add(parama);
    }
  }
  
  public final void b(a parama)
  {
    if (parama == null) {
      return;
    }
    try
    {
      if (((parama.b() == 1) || (parama.b() == 2)) && (this.d.contains(parama))) {
        this.d.remove(parama);
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
      a locala = (a)((Iterator)localObject).next();
      StringBuilder localStringBuilder2 = new StringBuilder("accessIP：");
      localStringBuilder2.append(locala.toString());
      localStringBuilder2.append("\r\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.b.a
 * JD-Core Version:    0.7.0.1
 */