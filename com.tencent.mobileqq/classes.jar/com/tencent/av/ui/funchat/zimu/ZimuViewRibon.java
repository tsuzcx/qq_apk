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
import krx;
import kws;
import lbk;
import mda;
import mdb;
import mdh;

public class ZimuViewRibon
  extends ZimuViewMotion
{
  WeakReference<ZimuView> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  int[] jdField_a_of_type_ArrayOfInt = { 86, 60, 56, 44, 32 };
  mda[] jdField_a_of_type_ArrayOfMda = { new mda(Color.parseColor("#cc8de1"), Color.parseColor("#ffffff"), 7), new mda(Color.parseColor("#57d4d9"), Color.parseColor("#ffffff"), 7), new mda(Color.parseColor("#ffc903"), Color.parseColor("#ffffff"), 7) };
  private int e = this.jdField_a_of_type_JavaUtilRandom.nextInt() & 0x1;
  private int f;
  
  public ZimuViewRibon(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
  }
  
  @NonNull
  private mdh a(kws paramkws, int paramInt1, int paramInt2, boolean paramBoolean, mdh parammdh)
  {
    int j = this.jdField_a_of_type_ArrayOfInt.length;
    int i = this.jdField_a_of_type_ArrayOfMda.length;
    j = paramInt1 % j;
    parammdh.a(paramBoolean);
    parammdh.a(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[j], this.jdField_a_of_type_ArrayOfMda[(paramInt1 % i)]);
    parammdh.a(paramkws);
    i = a(this.jdField_c_of_type_Int * (paramInt1 % 4), parammdh.d());
    parammdh.a(this.jdField_a_of_type_Int, i);
    krx.c("ZimuViewRibon", "onCreateItemView:" + paramInt1 + "|" + paramInt2 + "|" + i + "|" + this.jdField_c_of_type_Int + "|" + this.jdField_a_of_type_ArrayOfInt[j]);
    parammdh.a(paramInt2);
    return parammdh;
  }
  
  long a()
  {
    long l = lbk.c();
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
  
  protected List<mdb> a(kws paramkws, boolean paramBoolean)
  {
    c();
    ArrayList localArrayList = new ArrayList();
    mdh localmdh;
    int k;
    if (this.f % 3 == 0)
    {
      i = this.jdField_a_of_type_JavaUtilRandom.nextInt(3000);
      if ((i & 0x1) == 1)
      {
        j = 1;
        localmdh = new mdh(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
        int m = this.e;
        if (j == 0) {
          break label243;
        }
        k = i;
        label86:
        localArrayList.add(a(paramkws, m, k, paramBoolean, localmdh));
        this.e += 1;
        localmdh = new mdh(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
        k = this.e;
        if (j != 0) {
          break label249;
        }
      }
      for (;;)
      {
        localArrayList.add(a(paramkws, k, i, paramBoolean, localmdh));
        krx.c("ZimuViewRibon", "onCreateItemView random 00 :" + this.e + "||" + paramkws.a);
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
      localmdh = new mdh(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Float);
      k = this.e;
      if (i == 0) {
        break label384;
      }
    }
    label384:
    for (int i = j;; i = 0)
    {
      localArrayList.add(a(paramkws, k, i, paramBoolean, localmdh));
      krx.c("ZimuViewRibon", "onCreateItemView random zz :" + this.e + "|" + paramkws.a);
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
    k = this.jdField_a_of_type_ArrayOfMda.length;
    i = j;
    while (i < k)
    {
      this.jdField_a_of_type_ArrayOfMda[i].jdField_a_of_type_Float *= f1;
      i += 1;
    }
    a();
    super.b();
  }
  
  protected void b(mdb parammdb)
  {
    super.b(parammdb);
    parammdb.d();
    kws localkws = parammdb.a;
    parammdb = (mdh)parammdb;
    a(localkws, this.e, 0, true, parammdb);
    this.e += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewRibon
 * JD-Core Version:    0.7.0.1
 */