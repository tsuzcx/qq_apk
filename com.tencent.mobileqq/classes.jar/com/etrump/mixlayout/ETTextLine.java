package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public class ETTextLine
{
  private ArrayList<ETFragment> a = new ArrayList(4);
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public int a()
  {
    return this.e;
  }
  
  public ETFragment a(int paramInt)
  {
    int i = this.b;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ETFragment localETFragment = (ETFragment)localIterator.next();
      int j = localETFragment.e() + i;
      if ((i <= paramInt) && (paramInt < j)) {
        return localETFragment;
      }
      i = j;
    }
    return null;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ETFragment localETFragment = (ETFragment)localIterator.next();
      localETFragment.a(paramCanvas, paramInt1, paramInt2, this.e);
      paramInt1 += localETFragment.e();
    }
  }
  
  public void a(ETEngine paramETEngine, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = 0;
    this.e = paramInt3;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ETFragment localETFragment = (ETFragment)localIterator.next();
      if (localETFragment.f() > this.e) {
        this.e = localETFragment.f();
      }
      this.d += localETFragment.e();
    }
    this.f = 0;
    localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      paramInt1 = ((ETFragment)localIterator.next()).a(paramETEngine);
      if (paramInt1 > this.f) {
        this.f = paramInt1;
      }
    }
  }
  
  public void a(ETEngine paramETEngine, Bitmap paramBitmap, ETDecoration paramETDecoration, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ETFragment localETFragment = (ETFragment)localIterator.next();
      localETFragment.a(paramETEngine, paramBitmap, paramETDecoration, paramInt1, this.e - localETFragment.f() + paramInt2 - (this.f - localETFragment.a(paramETEngine)));
      paramInt1 += localETFragment.e();
    }
  }
  
  public void a(ETFragment paramETFragment)
  {
    this.a.add(paramETFragment);
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ETFragment localETFragment = (ETFragment)localIterator.next();
      localETFragment.b(paramCanvas, paramInt1, paramInt2, this.e);
      paramInt1 += localETFragment.e();
    }
  }
  
  public int c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public int e()
  {
    return this.f;
  }
  
  public ArrayList<ETFragment> f()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextLine
 * JD-Core Version:    0.7.0.1
 */