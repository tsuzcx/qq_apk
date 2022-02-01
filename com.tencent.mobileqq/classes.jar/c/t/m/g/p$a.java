package c.t.m.g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class p$a
{
  String a;
  String b;
  private String c;
  private List<n> d;
  private List<n> e;
  private List<n> f;
  private List<n> g;
  
  public p$a(String paramString)
  {
    this.c = paramString;
  }
  
  public final List<n> a()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.d;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    localList = this.e;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    localList = this.f;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    localList = this.g;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    return localArrayList;
  }
  
  public final void a(n paramn)
  {
    if (paramn == null) {
      return;
    }
    if (paramn.e == 1)
    {
      if (this.d == null) {
        this.d = new ArrayList();
      }
      this.d.add(paramn);
      return;
    }
    if (paramn.e == 2)
    {
      if (this.e == null) {
        this.e = new ArrayList();
      }
      this.e.add(paramn);
      return;
    }
    if (paramn.e == 3)
    {
      if (this.f == null) {
        this.f = new ArrayList();
      }
      this.f.add(paramn);
      return;
    }
    if (paramn.e == 4)
    {
      if (this.g == null) {
        this.g = new ArrayList();
      }
      this.g.add(paramn);
      return;
    }
    if (this.d == null) {
      this.d = new ArrayList();
    }
    this.d.add(paramn);
  }
  
  public final void b(n paramn)
  {
    if (paramn == null) {
      return;
    }
    try
    {
      if (paramn.e == 1)
      {
        if ((this.d != null) && (!this.d.isEmpty()) && (paramn.a((n)this.d.get(0)))) {
          this.d.remove(0);
        }
      }
      else if ((paramn.e == 2) && (this.e != null) && (!this.e.isEmpty()) && (paramn.a((n)this.e.get(0)))) {
        this.e.remove(0);
      }
      return;
    }
    finally {}
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = new StringBuilder("Appid：");
    ((StringBuilder)localObject).append(null);
    ((StringBuilder)localObject).append(" domain：");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("\r\n");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder("apn：");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(" ckIP：");
    ((StringBuilder)localObject).append(null);
    ((StringBuilder)localObject).append("\r\n");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = a().iterator();
    while (((Iterator)localObject).hasNext())
    {
      n localn = (n)((Iterator)localObject).next();
      StringBuilder localStringBuilder2 = new StringBuilder("accessIP：");
      localStringBuilder2.append(localn.toString());
      localStringBuilder2.append("\r\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.p.a
 * JD-Core Version:    0.7.0.1
 */