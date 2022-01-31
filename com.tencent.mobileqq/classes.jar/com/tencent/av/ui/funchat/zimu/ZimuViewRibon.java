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
import lek;
import ljf;
import lnz;
import mqq;
import mqr;
import mqx;

public class ZimuViewRibon
  extends ZimuViewMotion
{
  WeakReference<ZimuView> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  int[] jdField_a_of_type_ArrayOfInt = { 86, 60, 56, 44, 32 };
  mqq[] jdField_a_of_type_ArrayOfMqq = { new mqq(Color.parseColor("#cc8de1"), Color.parseColor("#ffffff"), 7), new mqq(Color.parseColor("#57d4d9"), Color.parseColor("#ffffff"), 7), new mqq(Color.parseColor("#ffc903"), Color.parseColor("#ffffff"), 7) };
  private int e = this.jdField_a_of_type_JavaUtilRandom.nextInt() & 0x1;
  private int f;
  
  public ZimuViewRibon(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
  }
  
  @NonNull
  private mqx a(ljf paramljf, int paramInt1, int paramInt2, boolean paramBoolean, mqx parammqx)
  {
    int j = this.jdField_a_of_type_ArrayOfInt.length;
    int i = this.jdField_a_of_type_ArrayOfMqq.length;
    j = paramInt1 % j;
    parammqx.a(paramBoolean);
    parammqx.a(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[j], this.jdField_a_of_type_ArrayOfMqq[(paramInt1 % i)]);
    parammqx.a(paramljf);
    i = a(this.jdField_c_of_type_Int * (paramInt1 % 4), parammqx.d());
    parammqx.a(this.jdField_a_of_type_Int, i);
    lek.c("ZimuViewRibon", "onCreateItemView:" + paramInt1 + "|" + paramInt2 + "|" + i + "|" + this.jdField_c_of_type_Int + "|" + this.jdField_a_of_type_ArrayOfInt[j]);
    parammqx.a(paramInt2);
    return parammqx;
  }
  
  long a()
  {
    long l = lnz.d();
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
  
  protected List<mqr> a(ljf paramljf, boolean paramBoolean)
  {
    c();
    ArrayList localArrayList = new ArrayList();
    mqx localmqx;
    int k;
    if (this.f % 3 == 0)
    {
      i = this.jdField_a_of_type_JavaUtilRandom.nextInt(3000);
      if ((i & 0x1) == 1)
      {
        j = 1;
        localmqx = new mqx(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
        int m = this.e;
        if (j == 0) {
          break label243;
        }
        k = i;
        label86:
        localArrayList.add(a(paramljf, m, k, paramBoolean, localmqx));
        this.e += 1;
        localmqx = new mqx(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
        k = this.e;
        if (j != 0) {
          break label249;
        }
      }
      for (;;)
      {
        localArrayList.add(a(paramljf, k, i, paramBoolean, localmqx));
        lek.c("ZimuViewRibon", "onCreateItemView random 00 :" + this.e + "||" + paramljf.a);
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
      localmqx = new mqx(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
      k = this.e;
      if (i == 0) {
        break label384;
      }
    }
    label384:
    for (int i = j;; i = 0)
    {
      localArrayList.add(a(paramljf, k, i, paramBoolean, localmqx));
      lek.c("ZimuViewRibon", "onCreateItemView random zz :" + this.e + "|" + paramljf.a);
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
    k = this.jdField_a_of_type_ArrayOfMqq.length;
    i = j;
    while (i < k)
    {
      this.jdField_a_of_type_ArrayOfMqq[i].jdField_a_of_type_Float *= f1;
      i += 1;
    }
    a();
    super.b();
  }
  
  protected void b(mqr parammqr)
  {
    super.b(parammqr);
    parammqr.d();
    ljf localljf = parammqr.a;
    parammqr = (mqx)parammqr;
    a(localljf, this.e, 0, true, parammqr);
    this.e += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewRibon
 * JD-Core Version:    0.7.0.1
 */