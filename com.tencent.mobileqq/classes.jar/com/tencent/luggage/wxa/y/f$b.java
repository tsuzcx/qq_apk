package com.tencent.luggage.wxa.y;

import android.os.Parcel;
import com.tencent.luggage.wxa.ao.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class f$b
{
  public final long a;
  public final boolean b;
  public final boolean c;
  public final boolean d;
  public final long e;
  public final List<f.a> f;
  public final boolean g;
  public final long h;
  public final int i;
  public final int j;
  public final int k;
  
  private f$b(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<f.a> paramList, long paramLong2, boolean paramBoolean4, long paramLong3, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramLong1;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
    this.f = Collections.unmodifiableList(paramList);
    this.e = paramLong2;
    this.g = paramBoolean4;
    this.h = paramLong3;
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramInt3;
  }
  
  private f$b(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    int m = paramParcel.readByte();
    boolean bool2 = false;
    if (m == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.c = bool1;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.d = bool1;
    int n = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(n);
    m = 0;
    while (m < n)
    {
      localArrayList.add(f.a.a(paramParcel));
      m += 1;
    }
    this.f = Collections.unmodifiableList(localArrayList);
    this.e = paramParcel.readLong();
    boolean bool1 = bool2;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    }
    this.g = bool1;
    this.h = paramParcel.readLong();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
  }
  
  private static b b(m paramm)
  {
    long l3 = paramm.l();
    boolean bool4;
    if ((paramm.g() & 0x80) != 0) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    ArrayList localArrayList = new ArrayList();
    int m;
    boolean bool1;
    boolean bool2;
    long l1;
    int i1;
    int n;
    long l2;
    boolean bool3;
    if (!bool4)
    {
      m = paramm.g();
      if ((m & 0x80) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((m & 0x40) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if ((m & 0x20) != 0) {
        m = 1;
      } else {
        m = 0;
      }
      if (bool2) {
        l1 = paramm.l();
      } else {
        l1 = -9223372036854775807L;
      }
      if (!bool2)
      {
        i1 = paramm.g();
        localArrayList = new ArrayList(i1);
        n = 0;
        while (n < i1)
        {
          localArrayList.add(new f.a(paramm.g(), paramm.l(), null));
          n += 1;
        }
      }
      if (m != 0)
      {
        l2 = paramm.g();
        if ((0x80 & l2) != 0L) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        l2 = paramm.l() | (l2 & 1L) << 32;
      }
      else
      {
        bool3 = false;
        l2 = -9223372036854775807L;
      }
      m = paramm.h();
      n = paramm.g();
      i1 = paramm.g();
    }
    else
    {
      bool1 = false;
      l1 = -9223372036854775807L;
      bool3 = false;
      l2 = -9223372036854775807L;
      m = 0;
      n = 0;
      i1 = 0;
      bool2 = false;
    }
    return new b(l3, bool4, bool1, bool2, localArrayList, l1, bool3, l2, m, n, i1);
  }
  
  private void b(Parcel paramParcel)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeByte((byte)this.b);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeByte((byte)this.d);
    int n = this.f.size();
    paramParcel.writeInt(n);
    int m = 0;
    while (m < n)
    {
      f.a.a((f.a)this.f.get(m), paramParcel);
      m += 1;
    }
    paramParcel.writeLong(this.e);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
  }
  
  private static b c(Parcel paramParcel)
  {
    return new b(paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.y.f.b
 * JD-Core Version:    0.7.0.1
 */