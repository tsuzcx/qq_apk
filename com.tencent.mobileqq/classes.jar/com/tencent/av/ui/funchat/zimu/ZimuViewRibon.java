package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import com.tencent.av.app.VideoAppInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lcg;
import lhc;
import llw;
import mnw;
import mnx;
import mod;

public class ZimuViewRibon
  extends ZimuViewMotion
{
  WeakReference<ZimuView> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  int[] jdField_a_of_type_ArrayOfInt = { 86, 60, 56, 44, 32 };
  mnw[] jdField_a_of_type_ArrayOfMnw = { new mnw(Color.parseColor("#cc8de1"), Color.parseColor("#ffffff"), 7), new mnw(Color.parseColor("#57d4d9"), Color.parseColor("#ffffff"), 7), new mnw(Color.parseColor("#ffc903"), Color.parseColor("#ffffff"), 7) };
  private int e = this.jdField_a_of_type_JavaUtilRandom.nextInt() & 0x1;
  private int f;
  
  public ZimuViewRibon(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
  }
  
  @NonNull
  private mod a(lhc paramlhc, int paramInt1, int paramInt2, boolean paramBoolean, mod parammod)
  {
    int j = this.jdField_a_of_type_ArrayOfInt.length;
    int i = this.jdField_a_of_type_ArrayOfMnw.length;
    j = paramInt1 % j;
    parammod.a(paramBoolean);
    parammod.a(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[j], this.jdField_a_of_type_ArrayOfMnw[(paramInt1 % i)]);
    parammod.a(paramlhc);
    i = a(this.jdField_c_of_type_Int * (paramInt1 % 4), parammod.d());
    parammod.a(this.jdField_a_of_type_Int, i);
    lcg.c("ZimuViewRibon", "onCreateItemView:" + paramInt1 + "|" + paramInt2 + "|" + i + "|" + this.jdField_c_of_type_Int + "|" + this.jdField_a_of_type_ArrayOfInt[j]);
    parammod.a(paramInt2);
    return parammod;
  }
  
  long a()
  {
    long l = llw.c();
    if (l > 1800000L) {
      this.jdField_c_of_type_Long = 50L;
    }
    for (;;)
    {
      return this.jdField_c_of_type_Long;
      if (l > 1400000L) {
        this.jdField_c_of_type_Long = 62L;
      } else {
        this.jdField_c_of_type_Long = 83L;
      }
    }
  }
  
  public String a()
  {
    return "ribbon";
  }
  
  protected List<mnx> a(lhc paramlhc, boolean paramBoolean)
  {
    c();
    ArrayList localArrayList = new ArrayList();
    mod localmod;
    int k;
    if (this.f % 3 == 0)
    {
      i = this.jdField_a_of_type_JavaUtilRandom.nextInt(3000);
      if ((i & 0x1) == 1)
      {
        j = 1;
        localmod = new mod(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
        int m = this.e;
        if (j == 0) {
          break label243;
        }
        k = i;
        label86:
        localArrayList.add(a(paramlhc, m, k, paramBoolean, localmod));
        this.e += 1;
        localmod = new mod(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
        k = this.e;
        if (j != 0) {
          break label249;
        }
      }
      for (;;)
      {
        localArrayList.add(a(paramlhc, k, i, paramBoolean, localmod));
        lcg.c("ZimuViewRibon", "onCreateItemView random 00 :" + this.e + "||" + paramlhc.a);
        this.e += 1;
        this.f += 1;
        return localArrayList;
        j = 0;
        break;
        label243:
        k = 0;
        break label86;
        label249:
        i = 0;
      }
    }
    int j = this.jdField_a_of_type_JavaUtilRandom.nextInt(3000);
    if ((j & 0x1) == 1)
    {
      i = 1;
      label276:
      localmod = new mod(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
      k = this.e;
      if (i == 0) {
        break label384;
      }
    }
    label384:
    for (int i = j;; i = 0)
    {
      localArrayList.add(a(paramlhc, k, i, paramBoolean, localmod));
      lcg.c("ZimuViewRibon", "onCreateItemView random zz :" + this.e + "|" + paramlhc.a);
      break;
      i = 0;
      break label276;
    }
  }
  
  public void b()
  {
    int j = 0;
    float f1 = this.jdField_a_of_type_Float * 0.48F;
    int k = this.jdField_a_of_type_ArrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = ((int)(this.jdField_a_of_type_ArrayOfInt[i] * f1));
      i += 1;
    }
    k = this.jdField_a_of_type_ArrayOfMnw.length;
    i = j;
    while (i < k)
    {
      this.jdField_a_of_type_ArrayOfMnw[i].jdField_a_of_type_Float *= f1;
      i += 1;
    }
    a();
    super.b();
  }
  
  protected void b(mnx parammnx)
  {
    super.b(parammnx);
    parammnx.d();
    lhc locallhc = parammnx.a;
    parammnx = (mod)parammnx;
    a(locallhc, this.e, 0, true, parammnx);
    this.e += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewRibon
 * JD-Core Version:    0.7.0.1
 */