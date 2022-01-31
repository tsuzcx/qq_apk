package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.ArrayList;

public class ETTextLine
{
  private int jdField_a_of_type_Int;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
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
    int i = this.jdField_a_of_type_Int;
    int n = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = i;
    int m = 0;
    int k = j;
    j = m;
    while (j < n)
    {
      ETFragment localETFragment = (ETFragment)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      k += localETFragment.c();
      if ((i <= paramInt) && (paramInt < k)) {
        return localETFragment;
      }
      j += 1;
      i = k;
    }
    return null;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = 0;
    this.d = paramInt3;
    paramInt2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramInt1 = 0;
    ETFragment localETFragment;
    while (paramInt1 < paramInt2)
    {
      localETFragment = (ETFragment)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
      if (localETFragment.d() > this.d) {
        this.d = localETFragment.d();
      }
      paramInt3 = this.c;
      this.c = (localETFragment.c() + paramInt3);
      paramInt1 += 1;
    }
    this.e = 0;
    paramInt1 = i;
    while (paramInt1 < paramInt2)
    {
      localETFragment = (ETFragment)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
      if (localETFragment.f() == 0)
      {
        paramInt3 = localETFragment.g();
        if (paramInt3 > this.e) {
          this.e = paramInt3;
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < k)
    {
      ETFragment localETFragment = (ETFragment)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
      localETFragment.a(paramBitmap, i, this.d - localETFragment.d() + paramInt2 - (this.e - localETFragment.g()));
      i += localETFragment.c();
      paramInt1 += 1;
    }
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < k)
    {
      ETFragment localETFragment = (ETFragment)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
      localETFragment.a(paramCanvas, i, paramInt2, this.d);
      i += localETFragment.c();
      paramInt1 += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextLine
 * JD-Core Version:    0.7.0.1
 */