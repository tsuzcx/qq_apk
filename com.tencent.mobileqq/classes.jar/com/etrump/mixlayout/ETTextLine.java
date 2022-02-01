package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public class ETTextLine
{
  private int jdField_a_of_type_Int;
  private ArrayList<ETFragment> jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  private int b;
  private int c;
  private int d;
  private int e;
  
  public int a()
  {
    return this.d;
  }
  
  public ETFragment a(int paramInt)
  {
    int j = this.jdField_a_of_type_Int;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = j;
    while (localIterator.hasNext())
    {
      ETFragment localETFragment = (ETFragment)localIterator.next();
      i += localETFragment.c();
      if ((j <= paramInt) && (paramInt < i)) {
        return localETFragment;
      }
      j = i;
    }
    return null;
  }
  
  public ArrayList<ETFragment> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ETFragment localETFragment = (ETFragment)localIterator.next();
      localETFragment.a(paramCanvas, paramInt1, paramInt2, this.d);
      paramInt1 += localETFragment.c();
    }
  }
  
  public void a(ETEngine paramETEngine, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = 0;
    this.d = paramInt3;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ETFragment localETFragment = (ETFragment)localIterator.next();
      if (localETFragment.d() > this.d) {
        this.d = localETFragment.d();
      }
      paramInt1 = this.c;
      this.c = (localETFragment.c() + paramInt1);
    }
    this.e = 0;
    localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      paramInt1 = ((ETFragment)localIterator.next()).a(paramETEngine);
      if (paramInt1 > this.e) {
        this.e = paramInt1;
      }
    }
  }
  
  public void a(ETEngine paramETEngine, Bitmap paramBitmap, ETDecoration paramETDecoration, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ETFragment localETFragment = (ETFragment)localIterator.next();
      localETFragment.a(paramETEngine, paramBitmap, paramETDecoration, paramInt1, this.d - localETFragment.d() + paramInt2 - (this.e - localETFragment.a(paramETEngine)));
      paramInt1 += localETFragment.c();
    }
  }
  
  public void a(ETFragment paramETFragment)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramETFragment);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ETFragment localETFragment = (ETFragment)localIterator.next();
      localETFragment.b(paramCanvas, paramInt1, paramInt2, this.d);
      paramInt1 += localETFragment.c();
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public int e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextLine
 * JD-Core Version:    0.7.0.1
 */