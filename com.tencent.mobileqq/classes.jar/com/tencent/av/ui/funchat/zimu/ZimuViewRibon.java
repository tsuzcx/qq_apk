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
import lbd;
import lgo;
import llq;
import moy;
import moz;
import mpf;

public class ZimuViewRibon
  extends ZimuViewMotion
{
  WeakReference<ZimuView> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  int[] jdField_a_of_type_ArrayOfInt = { 86, 60, 56, 44, 32 };
  moy[] jdField_a_of_type_ArrayOfMoy = { new moy(Color.parseColor("#cc8de1"), Color.parseColor("#ffffff"), 7), new moy(Color.parseColor("#57d4d9"), Color.parseColor("#ffffff"), 7), new moy(Color.parseColor("#ffc903"), Color.parseColor("#ffffff"), 7) };
  private int e = this.jdField_a_of_type_JavaUtilRandom.nextInt() & 0x1;
  private int f;
  
  public ZimuViewRibon(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
  }
  
  @NonNull
  private mpf a(lgo paramlgo, int paramInt1, int paramInt2, boolean paramBoolean, mpf parammpf)
  {
    int j = this.jdField_a_of_type_ArrayOfInt.length;
    int i = this.jdField_a_of_type_ArrayOfMoy.length;
    j = paramInt1 % j;
    parammpf.a(paramBoolean);
    parammpf.a(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[j], this.jdField_a_of_type_ArrayOfMoy[(paramInt1 % i)]);
    parammpf.a(paramlgo);
    i = a(this.jdField_c_of_type_Int * (paramInt1 % 4), parammpf.d());
    parammpf.a(this.jdField_a_of_type_Int, i);
    lbd.f("ZimuViewRibon", "onCreateItemView:" + paramInt1 + "|" + paramInt2 + "|" + i + "|" + this.jdField_c_of_type_Int + "|" + this.jdField_a_of_type_ArrayOfInt[j]);
    parammpf.a(paramInt2);
    return parammpf;
  }
  
  long a()
  {
    long l = llq.d();
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
  
  protected List<moz> a(lgo paramlgo, boolean paramBoolean)
  {
    c();
    ArrayList localArrayList = new ArrayList();
    mpf localmpf;
    int k;
    if (this.f % 3 == 0)
    {
      i = this.jdField_a_of_type_JavaUtilRandom.nextInt(3000);
      if ((i & 0x1) == 1)
      {
        j = 1;
        localmpf = new mpf(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
        int m = this.e;
        if (j == 0) {
          break label243;
        }
        k = i;
        label86:
        localArrayList.add(a(paramlgo, m, k, paramBoolean, localmpf));
        this.e += 1;
        localmpf = new mpf(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
        k = this.e;
        if (j != 0) {
          break label249;
        }
      }
      for (;;)
      {
        localArrayList.add(a(paramlgo, k, i, paramBoolean, localmpf));
        lbd.f("ZimuViewRibon", "onCreateItemView random 00 :" + this.e + "||" + paramlgo.a);
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
      localmpf = new mpf(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
      k = this.e;
      if (i == 0) {
        break label384;
      }
    }
    label384:
    for (int i = j;; i = 0)
    {
      localArrayList.add(a(paramlgo, k, i, paramBoolean, localmpf));
      lbd.f("ZimuViewRibon", "onCreateItemView random zz :" + this.e + "|" + paramlgo.a);
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
    k = this.jdField_a_of_type_ArrayOfMoy.length;
    i = j;
    while (i < k)
    {
      this.jdField_a_of_type_ArrayOfMoy[i].jdField_a_of_type_Float *= f1;
      i += 1;
    }
    a();
    super.b();
  }
  
  protected void b(moz parammoz)
  {
    super.b(parammoz);
    parammoz.d();
    lgo locallgo = parammoz.a;
    parammoz = (mpf)parammoz;
    a(locallgo, this.e, 0, true, parammoz);
    this.e += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewRibon
 * JD-Core Version:    0.7.0.1
 */