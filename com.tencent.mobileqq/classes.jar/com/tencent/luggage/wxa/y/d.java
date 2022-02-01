package com.tencent.luggage.wxa.y;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d
  extends b
{
  public static final Parcelable.Creator<d> CREATOR = new d.1();
  public final long a;
  public final boolean b;
  public final boolean c;
  public final boolean d;
  public final boolean e;
  public final long f;
  public final long g;
  public final List<d.a> h;
  public final boolean i;
  public final long j;
  public final int k;
  public final int l;
  public final int m;
  
  private d(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, long paramLong2, long paramLong3, List<d.a> paramList, boolean paramBoolean5, long paramLong4, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramLong1;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
    this.e = paramBoolean4;
    this.f = paramLong2;
    this.g = paramLong3;
    this.h = Collections.unmodifiableList(paramList);
    this.i = paramBoolean5;
    this.j = paramLong4;
    this.k = paramInt1;
    this.l = paramInt2;
    this.m = paramInt3;
  }
  
  private d(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    int n = paramParcel.readByte();
    boolean bool2 = false;
    if (n == 1) {
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
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.e = bool1;
    this.f = paramParcel.readLong();
    this.g = paramParcel.readLong();
    int i1 = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(i1);
    n = 0;
    while (n < i1)
    {
      localArrayList.add(d.a.b(paramParcel));
      n += 1;
    }
    this.h = Collections.unmodifiableList(localArrayList);
    boolean bool1 = bool2;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    }
    this.i = bool1;
    this.j = paramParcel.readLong();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readInt();
    this.m = paramParcel.readInt();
  }
  
  static d a(m paramm, long paramLong, u paramu)
  {
    long l3 = paramm.l();
    boolean bool5;
    if ((paramm.g() & 0x80) != 0) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    Object localObject = Collections.emptyList();
    int i1;
    boolean bool1;
    boolean bool2;
    int n;
    boolean bool3;
    long l1;
    int i2;
    boolean bool4;
    if (!bool5)
    {
      i1 = paramm.g();
      if ((i1 & 0x80) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((i1 & 0x40) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if ((i1 & 0x20) != 0) {
        n = 1;
      } else {
        n = 0;
      }
      if ((i1 & 0x10) != 0) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      if ((bool2) && (!bool3)) {
        l1 = g.a(paramm, paramLong);
      } else {
        l1 = -9223372036854775807L;
      }
      if (!bool2)
      {
        i2 = paramm.g();
        ArrayList localArrayList = new ArrayList(i2);
        i1 = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i1 >= i2) {
            break;
          }
          int i3 = paramm.g();
          long l2;
          if (!bool3) {
            l2 = g.a(paramm, paramLong);
          } else {
            l2 = -9223372036854775807L;
          }
          localArrayList.add(new d.a(i3, l2, paramu.b(l2), null));
          i1 += 1;
        }
      }
      if (n != 0)
      {
        paramLong = paramm.g();
        if ((0x80 & paramLong) != 0L) {
          bool4 = true;
        } else {
          bool4 = false;
        }
        paramLong = paramm.l() | (paramLong & 1L) << 32;
      }
      else
      {
        paramLong = -9223372036854775807L;
        bool4 = false;
      }
      i2 = paramm.h();
      n = paramm.g();
      i1 = paramm.g();
    }
    else
    {
      bool1 = false;
      bool3 = false;
      l1 = -9223372036854775807L;
      bool4 = false;
      paramLong = -9223372036854775807L;
      i2 = 0;
      n = 0;
      i1 = 0;
      bool2 = false;
    }
    return new d(l3, bool5, bool1, bool2, bool3, l1, paramu.b(l1), (List)localObject, bool4, paramLong, i2, n, i1);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeByte((byte)this.b);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeByte((byte)this.d);
    paramParcel.writeByte((byte)this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeLong(this.g);
    int n = this.h.size();
    paramParcel.writeInt(n);
    paramInt = 0;
    while (paramInt < n)
    {
      ((d.a)this.h.get(paramInt)).a(paramParcel);
      paramInt += 1;
    }
    paramParcel.writeByte((byte)this.i);
    paramParcel.writeLong(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeInt(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.y.d
 * JD-Core Version:    0.7.0.1
 */