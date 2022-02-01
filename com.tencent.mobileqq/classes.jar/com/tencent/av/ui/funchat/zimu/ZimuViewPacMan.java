package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.av.app.VideoAppInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import lba;
import lgc;
import lld;
import mob;
import moc;
import mog;
import moh;
import mon;

public class ZimuViewPacMan
  extends ZimuViewMotion
{
  static final mob[] jdField_a_of_type_ArrayOfMob = { new mob(Color.parseColor("#ffffff"), Color.parseColor("#000000"), 4) };
  WeakReference<ZimuView> jdField_a_of_type_JavaLangRefWeakReference;
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  int[] jdField_a_of_type_ArrayOfInt = { 48, 38, 34 };
  Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = { null, null };
  List<mon> jdField_b_of_type_JavaUtilList = new ArrayList(4);
  final int[] jdField_b_of_type_ArrayOfInt = { 70, 58, 52 };
  int[] c;
  
  public ZimuViewPacMan(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
    this.jdField_c_of_type_ArrayOfInt = new int[] { 116, 102, 90 };
    int i = 0;
    while (i < 4)
    {
      paramVideoAppInterface = new mon(this, i, 0);
      this.jdField_b_of_type_JavaUtilList.add(paramVideoAppInterface);
      i += 1;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  }
  
  long a()
  {
    long l = lld.d();
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
    return "pacman";
  }
  
  protected List<moc> a(lgc paramlgc, boolean paramBoolean)
  {
    c();
    ArrayList localArrayList = new ArrayList();
    int k = this.jdField_a_of_type_JavaUtilRandom.nextInt(40);
    int m = this.jdField_b_of_type_ArrayOfInt.length;
    int n = this.jdField_c_of_type_ArrayOfInt.length;
    int i = k % this.jdField_a_of_type_ArrayOfInt.length;
    int j = c();
    Object localObject = new moh(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap, this.jdField_c_of_type_ArrayOfInt[(k % n)], this.jdField_b_of_type_ArrayOfInt[(k % m)], j);
    localObject = new mog(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float, (moh)localObject);
    ((mog)localObject).a(paramBoolean);
    ((mog)localObject).a(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[i], jdField_a_of_type_ArrayOfMob[0]);
    ((mog)localObject).a(paramlgc);
    m = this.jdField_c_of_type_Int;
    k = ((mog)localObject).d();
    j = a(m * j, k);
    ((mog)localObject).a(this.jdField_a_of_type_Int, j);
    ((mog)localObject).a(0L);
    localArrayList.add(localObject);
    lba.f("ZimuViewPacMan", "onCreateItemView:|" + j + "|" + k + "|" + this.jdField_c_of_type_Int + "|" + this.jdField_a_of_type_ArrayOfInt[i]);
    return localArrayList;
  }
  
  void a(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      mon localmon = (mon)localIterator.next();
      if (localmon.jdField_a_of_type_Int == paramInt)
      {
        localmon.jdField_b_of_type_Int -= 1;
        if (localmon.jdField_b_of_type_Int == 0)
        {
          localIterator.remove();
          this.jdField_b_of_type_JavaUtilList.add(0, localmon);
        }
      }
    }
  }
  
  protected void a(moc parammoc)
  {
    a(((mog)parammoc).e());
  }
  
  public void b()
  {
    int j = 0;
    float f = this.jdField_a_of_type_Float * 0.48F;
    int k = this.jdField_a_of_type_ArrayOfInt.length;
    int i = 0;
    int[] arrayOfInt;
    while (i < k)
    {
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[i] = ((int)(arrayOfInt[i] * f));
      i += 1;
    }
    k = this.jdField_b_of_type_ArrayOfInt.length;
    i = 0;
    while (i < k)
    {
      arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
      arrayOfInt[i] = ((int)(arrayOfInt[i] * f));
      i += 1;
    }
    k = this.jdField_c_of_type_ArrayOfInt.length;
    i = j;
    while (i < k)
    {
      arrayOfInt = this.jdField_c_of_type_ArrayOfInt;
      arrayOfInt[i] = ((int)(arrayOfInt[i] * f));
      i += 1;
    }
    try
    {
      this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0] = BitmapFactory.decodeResource(getContext().getResources(), 2130842328);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[1] = BitmapFactory.decodeResource(getContext().getResources(), 2130842329);
      a();
      super.b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void b(moc parammoc)
  {
    super.b(parammoc);
    parammoc.d();
    parammoc = (mog)parammoc;
    int i = this.jdField_a_of_type_JavaUtilRandom.nextInt(40);
    int j = this.jdField_c_of_type_ArrayOfInt.length;
    int k = this.jdField_b_of_type_ArrayOfInt.length;
    int m = this.jdField_a_of_type_ArrayOfInt.length;
    int n = c();
    parammoc.a(new moh(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap, this.jdField_c_of_type_ArrayOfInt[(i % j)], this.jdField_b_of_type_ArrayOfInt[(i % k)], n));
    parammoc.a(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[(i % m)], jdField_a_of_type_ArrayOfMob[0]);
    i = a(this.jdField_c_of_type_Int * n, parammoc.d());
    parammoc.a(this.jdField_a_of_type_Int, i);
    parammoc.a(0L);
  }
  
  int c()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    int j = this.jdField_b_of_type_JavaUtilList.size();
    if (i < j)
    {
      i = j - i;
      if (i <= 1) {}
    }
    for (i = this.jdField_a_of_type_JavaUtilRandom.nextInt(i * 10) % i;; i = 0)
    {
      mon localmon = (mon)this.jdField_b_of_type_JavaUtilList.get(i);
      localmon.jdField_b_of_type_Int += 1;
      this.jdField_b_of_type_JavaUtilList.remove(i);
      this.jdField_b_of_type_JavaUtilList.add(localmon);
      return localmon.jdField_a_of_type_Int;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    int j = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length;
    int i = 0;
    while (i < j)
    {
      if (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] != null)
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].recycle();
        this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] = null;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewPacMan
 * JD-Core Version:    0.7.0.1
 */