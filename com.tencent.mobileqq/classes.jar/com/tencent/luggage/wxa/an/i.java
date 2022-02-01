package com.tencent.luggage.wxa.an;

import com.tencent.luggage.wxa.ao.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

final class i
{
  public final int a;
  public final String b;
  private final TreeSet<m> c;
  private long d;
  
  public i(int paramInt, String paramString, long paramLong)
  {
    this.a = paramInt;
    this.b = paramString;
    this.d = paramLong;
    this.c = new TreeSet();
  }
  
  public i(DataInputStream paramDataInputStream)
  {
    this(paramDataInputStream.readInt(), paramDataInputStream.readUTF(), paramDataInputStream.readLong());
  }
  
  public long a()
  {
    return this.d;
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    Object localObject = b(paramLong1);
    if (((m)localObject).b())
    {
      if (((m)localObject).a()) {
        paramLong1 = 9223372036854775807L;
      } else {
        paramLong1 = ((m)localObject).c;
      }
      return -Math.min(paramLong1, paramLong2);
    }
    long l3 = paramLong1 + paramLong2;
    long l1 = ((m)localObject).b + ((m)localObject).c;
    long l2 = l1;
    if (l1 < l3)
    {
      localObject = this.c.tailSet(localObject, false).iterator();
      do
      {
        l2 = l1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        m localm = (m)((Iterator)localObject).next();
        if (localm.b > l1)
        {
          l2 = l1;
          break;
        }
        l2 = Math.max(l1, localm.b + localm.c);
        l1 = l2;
      } while (l2 < l3);
    }
    return Math.min(l2 - paramLong1, paramLong2);
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(m paramm)
  {
    this.c.add(paramm);
  }
  
  public void a(DataOutputStream paramDataOutputStream)
  {
    paramDataOutputStream.writeInt(this.a);
    paramDataOutputStream.writeUTF(this.b);
    paramDataOutputStream.writeLong(this.d);
  }
  
  public boolean a(g paramg)
  {
    if (this.c.remove(paramg))
    {
      paramg.e.delete();
      return true;
    }
    return false;
  }
  
  public m b(long paramLong)
  {
    m localm1 = m.a(this.b, paramLong);
    m localm2 = (m)this.c.floor(localm1);
    if ((localm2 != null) && (localm2.b + localm2.c > paramLong)) {
      return localm2;
    }
    localm1 = (m)this.c.ceiling(localm1);
    if (localm1 == null) {
      return m.b(this.b, paramLong);
    }
    return m.a(this.b, paramLong, localm1.b - paramLong);
  }
  
  public m b(m paramm)
  {
    a.b(this.c.remove(paramm));
    m localm = paramm.a(this.a);
    if (paramm.e.renameTo(localm.e))
    {
      this.c.add(localm);
      return localm;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Renaming of ");
    localStringBuilder.append(paramm.e);
    localStringBuilder.append(" to ");
    localStringBuilder.append(localm.e);
    localStringBuilder.append(" failed.");
    throw new a.a(localStringBuilder.toString());
  }
  
  public TreeSet<m> b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.c.isEmpty();
  }
  
  public int d()
  {
    int i = this.a;
    int j = this.b.hashCode();
    long l = this.d;
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.an.i
 * JD-Core Version:    0.7.0.1
 */