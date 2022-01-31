package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class hi
{
  public ArrayList<GeoPoint> a;
  public ArrayList<GeoPoint> b;
  public int[] c;
  public int[] d;
  public int[] e;
  public int[] f;
  public float g;
  public boolean h;
  public boolean i;
  public float j = 9.0F;
  public String k = "";
  public boolean l = true;
  public float m = 1.0F;
  public boolean n = true;
  public int o = 0;
  public boolean p = false;
  public boolean q = false;
  public Rect r = new Rect();
  public int s = 0;
  public String t = "";
  public float u = -1.0F;
  public int v = -1;
  public int w = -15248742;
  public List<Integer> x = null;
  public int y = OverlayLevel.OverlayLevelAboveLabels;
  public int z = -7829368;
  
  public final hi a(List<GeoPoint> paramList)
  {
    if ((paramList == null) || (paramList.size() < 2)) {
      throw new IllegalArgumentException("参数points不能小于2!");
    }
    this.b = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GeoPoint localGeoPoint = (GeoPoint)localIterator.next();
      if (localGeoPoint != null) {
        this.b.add(localGeoPoint);
      }
    }
    if (this.b.size() < 2) {
      throw new IllegalArgumentException("参数points存在null值");
    }
    this.a = new ArrayList(paramList.size());
    this.a.addAll(this.b);
    return this;
  }
  
  public final hi a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      throw new IllegalArgumentException("参数startIndexes不能为空!");
    }
    this.c = paramArrayOfInt;
    return this;
  }
  
  public final hi a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i2 = 0;
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0) || (paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) {
      throw new IllegalArgumentException("参数colors 、borderColors为空，或者两者长度不同");
    }
    if (!this.h) {
      this.d = paramArrayOfInt1;
    }
    for (;;)
    {
      return this;
      int[] arrayOfInt = paramArrayOfInt2;
      if (paramArrayOfInt2.length < paramArrayOfInt1.length)
      {
        arrayOfInt = new int[paramArrayOfInt1.length];
        i1 = 0;
        if (i1 < paramArrayOfInt1.length)
        {
          if (i1 < paramArrayOfInt2.length) {
            arrayOfInt[i1] = paramArrayOfInt2[i1];
          }
          for (;;)
          {
            i1 += 1;
            break;
            arrayOfInt[i1] = paramArrayOfInt2[(paramArrayOfInt2.length - 1)];
          }
        }
      }
      paramArrayOfInt2 = new ArrayList();
      this.d = new int[paramArrayOfInt1.length];
      int i1 = 0;
      while (i1 < paramArrayOfInt1.length)
      {
        hi.a locala = new hi.a(this, paramArrayOfInt1[i1], arrayOfInt[i1]);
        if (!paramArrayOfInt2.contains(locala)) {
          paramArrayOfInt2.add(locala);
        }
        this.d[i1] = paramArrayOfInt2.indexOf(locala);
        i1 += 1;
      }
      int i3 = paramArrayOfInt2.size();
      this.e = new int[i3];
      this.f = new int[i3];
      i1 = i2;
      while (i1 < i3)
      {
        this.e[i1] = ((hi.a)paramArrayOfInt2.get(i1)).b;
        this.f[i1] = ((hi.a)paramArrayOfInt2.get(i1)).a;
        i1 += 1;
      }
    }
  }
  
  public final hi b(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() % 2 != 0)) {
      paramList.add(paramList.get(paramList.size() - 1));
    }
    this.x = paramList;
    return this;
  }
  
  public final hi b(int[] paramArrayOfInt)
  {
    int i2 = 0;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      throw new IllegalArgumentException("参数colors不能为空!");
    }
    if (!this.h) {
      this.d = paramArrayOfInt;
    }
    for (;;)
    {
      return this;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(this.z));
      int i1 = 0;
      while (i1 < paramArrayOfInt.length)
      {
        if (!localArrayList.contains(Integer.valueOf(paramArrayOfInt[i1]))) {
          localArrayList.add(Integer.valueOf(paramArrayOfInt[i1]));
        }
        paramArrayOfInt[i1] = localArrayList.indexOf(Integer.valueOf(paramArrayOfInt[i1]));
        i1 += 1;
      }
      this.d = paramArrayOfInt;
      int i3 = localArrayList.size();
      this.e = new int[i3];
      i1 = i2;
      while (i1 < i3)
      {
        this.e[i1] = ((Integer)localArrayList.get(i1)).intValue();
        i1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.hi
 * JD-Core Version:    0.7.0.1
 */