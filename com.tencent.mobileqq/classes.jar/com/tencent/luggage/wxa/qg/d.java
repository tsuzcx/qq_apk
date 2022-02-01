package com.tencent.luggage.wxa.qg;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.o;
import java.util.BitSet;

public class d
{
  private BitSet a = new BitSet();
  private long b = -1L;
  private int c = 0;
  private String d = "";
  private String e;
  
  public d(String paramString)
  {
    this.e = paramString;
  }
  
  public void a()
  {
    o.d("MicroMsg.Music.IndexBitMgr", "initData");
    long l = this.b;
    if (l <= 0L)
    {
      o.b("MicroMsg.Music.IndexBitMgr", "fileLength is invalid!");
      return;
    }
    if ((l % 8192L != 0L) && (l >= 8192L)) {
      this.c = ((int)(l / 8192L) + 1);
    } else {
      this.c = ((int)(this.b / 8192L));
    }
    if (this.b <= 8192L)
    {
      o.d("MicroMsg.Music.IndexBitMgr", "fileLength < PIECE_SIZE, count should be 1");
      this.c = 1;
    }
    o.d("MicroMsg.Music.IndexBitMgr", "fileLength:%d, count:%d", new Object[] { Long.valueOf(this.b), Integer.valueOf(this.c) });
    this.a = new BitSet(this.c);
    this.d = g.b(this.e);
    if (TextUtils.isEmpty(this.d))
    {
      o.b("MicroMsg.Music.IndexBitMgr", "initData musicId is null!'");
      return;
    }
    o.d("MicroMsg.Music.IndexBitMgr", "musicId:%s", new Object[] { this.d });
    Object localObject = e.a(this.d);
    if (localObject == null)
    {
      o.b("MicroMsg.Music.IndexBitMgr", "initData pMusic is null!'");
      return;
    }
    o.d("MicroMsg.Music.IndexBitMgr", "initData music field_fileCacheComplete:%d", new Object[] { Integer.valueOf(((com.tencent.luggage.wxa.ig.g)localObject).b) });
    if ((((com.tencent.luggage.wxa.ig.g)localObject).a != null) && (((com.tencent.luggage.wxa.ig.g)localObject).a.length != 0))
    {
      this.a = d.a.a(((com.tencent.luggage.wxa.ig.g)localObject).a);
      BitSet localBitSet = this.a;
      if (localBitSet == null)
      {
        o.b("MicroMsg.Music.IndexBitMgr", "initData bitSet is null");
        this.a = new BitSet(this.c);
      }
      else if (this.c < localBitSet.cardinality())
      {
        o.b("MicroMsg.Music.IndexBitMgr", "initData cont < bitSet.cardinality(), count:%d, cardinality:%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.a.cardinality()) });
        c();
      }
      else if (((com.tencent.luggage.wxa.ig.g)localObject).c != 1)
      {
        o.d("MicroMsg.Music.IndexBitMgr", "remove dirty bit set from db, reset cache complete to 0");
        int i = this.c;
        if (i > 1)
        {
          a(i - 1, false);
          a(this.c - 2, false);
        }
        else
        {
          a(i - 1, false);
        }
        a(0);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData bitSet:");
      ((StringBuilder)localObject).append(this.a.toString());
      o.d("MicroMsg.Music.IndexBitMgr", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData bitSet count %d, cardinality:");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.a.cardinality());
      o.d("MicroMsg.Music.IndexBitMgr", ((StringBuilder)localObject).toString());
      return;
    }
    o.b("MicroMsg.Music.IndexBitMgr", "initData field_indexBitData is null!'");
  }
  
  public void a(int paramInt)
  {
    o.d("MicroMsg.Music.IndexBitMgr", "setFileCacheComplete %d", new Object[] { Integer.valueOf(paramInt) });
    if (!TextUtils.isEmpty(this.d)) {
      e.a(this.d, paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.set(paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
    {
      long l2 = paramInt1;
      long l1 = this.b;
      if (l2 <= l1)
      {
        int j = paramInt1 + paramInt2;
        l2 = j;
        if (l2 <= l1)
        {
          int[] arrayOfInt = new int[2];
          int[] tmp54_52 = arrayOfInt;
          tmp54_52[0] = -1;
          int[] tmp58_54 = tmp54_52;
          tmp58_54[1] = -1;
          tmp58_54;
          int i = b(paramInt1);
          int k = b(j);
          paramInt2 = i;
          while (paramInt2 <= k)
          {
            int m = e(paramInt2);
            int n = f(paramInt2);
            if ((m >= paramInt1) && (n <= j))
            {
              if (tmp58_54[0] == -1) {
                tmp58_54[0] = paramInt2;
              }
              if (tmp58_54[0] > paramInt2) {
                tmp58_54[0] = paramInt2;
              }
              if (tmp58_54[1] == -1) {
                tmp58_54[1] = paramInt2;
              }
              if (tmp58_54[1] < paramInt2) {
                tmp58_54[1] = paramInt2;
              }
            }
            paramInt2 += 1;
          }
          if ((l2 == this.b) && (((k == 0) && (paramInt1 == 0)) || ((k > 0) && (paramInt1 <= k * 8192))))
          {
            o.d("MicroMsg.Music.IndexBitMgr", "write to file end!");
            tmp58_54[0] = i;
            tmp58_54[1] = k;
          }
          return tmp58_54;
        }
      }
    }
    o.d("MicroMsg.Music.IndexBitMgr", "getWriteBuffIndexRange offset %d, size %d, fileLength %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(this.b) });
    o.b("MicroMsg.Music.IndexBitMgr", "getWriteBuffRange invalid parameter!");
    return null;
  }
  
  public int b(int paramInt)
  {
    if (paramInt > this.b)
    {
      o.b("MicroMsg.Music.IndexBitMgr", "getIndex, offset is invalid, offset:%d, fileLength:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.b) });
      return 0;
    }
    return paramInt / 8192;
  }
  
  public void b()
  {
    if (!TextUtils.isEmpty(this.d))
    {
      localObject = d.a.a(this.a);
      e.a(this.d, (byte[])localObject);
    }
    o.e("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet:%s", new Object[] { this.a.toString() });
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveBitCache bitSet count %d, cardinality:");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(this.a.cardinality());
    o.d("MicroMsg.Music.IndexBitMgr", ((StringBuilder)localObject).toString());
    if (d()) {
      a(1);
    }
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
    {
      long l1 = paramInt1;
      long l2 = this.b;
      if (l1 <= l2)
      {
        int i = paramInt1 + paramInt2;
        if (i <= l2)
        {
          paramInt2 = b(paramInt1);
          i = b(i);
          paramInt1 = paramInt2;
          while (paramInt1 <= i)
          {
            if (!c(paramInt2))
            {
              o.e("MicroMsg.Music.IndexBitMgr", "index %d, indexBit 0", new Object[] { Integer.valueOf(paramInt1) });
              return false;
            }
            paramInt1 += 1;
          }
          return true;
        }
      }
    }
    o.b("MicroMsg.Music.IndexBitMgr", "canReadFromCache offset %d, size %d, fileLength %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(this.b) });
    o.b("MicroMsg.Music.IndexBitMgr", "canReadFromCache invalid parameter!");
    return false;
  }
  
  public void c()
  {
    o.d("MicroMsg.Music.IndexBitMgr", "clearCache");
    this.a = new BitSet(this.c);
    a(0);
    if (!TextUtils.isEmpty(this.d)) {
      e.a(this.d, null);
    }
  }
  
  public boolean c(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public void d(int paramInt)
  {
    this.a.set(paramInt);
  }
  
  public boolean d()
  {
    int i = this.c;
    boolean bool2 = false;
    o.d("MicroMsg.Music.IndexBitMgr", "isCacheComplete, count:%d, cardinality:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.a.cardinality()) });
    i = this.c;
    boolean bool1 = bool2;
    if (i > 0)
    {
      bool1 = bool2;
      if (i == this.a.cardinality()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int e(int paramInt)
  {
    return paramInt * 8192;
  }
  
  public int f(int paramInt)
  {
    return (paramInt + 1) * 8192;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qg.d
 * JD-Core Version:    0.7.0.1
 */