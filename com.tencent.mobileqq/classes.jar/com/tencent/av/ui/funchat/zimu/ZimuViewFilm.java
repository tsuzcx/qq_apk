package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.av.app.VideoAppInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import ljf;
import mqq;
import mqr;
import mqs;

public class ZimuViewFilm
  extends ZimuView
{
  WeakReference<ZimuView> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  final int[] jdField_a_of_type_ArrayOfInt = { 44, 30 };
  mqq[] jdField_a_of_type_ArrayOfMqq = { new mqq(Color.parseColor("#ffffff"), Color.parseColor("#000000"), 5), new mqq(Color.parseColor("#fdeabd"), Color.parseColor("#000000"), 4) };
  
  public ZimuViewFilm(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
    float f = this.jdField_a_of_type_Float * 0.48F;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_ArrayOfInt.length) {
        break;
      }
      paramVideoAppInterface = this.jdField_a_of_type_ArrayOfInt;
      paramVideoAppInterface[i] = ((int)(paramVideoAppInterface[i] * f));
      i += 1;
    }
    while (j < this.jdField_a_of_type_ArrayOfMqq.length)
    {
      paramVideoAppInterface = this.jdField_a_of_type_ArrayOfMqq[j];
      paramVideoAppInterface.jdField_a_of_type_Float *= f;
      j += 1;
    }
  }
  
  public int a()
  {
    return (int)getContext().getResources().getDimension(2131297569);
  }
  
  public String a()
  {
    return "film";
  }
  
  protected List<mqr> a(ljf paramljf, boolean paramBoolean)
  {
    a();
    mqs localmqs = new mqs(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Float);
    localmqs.a(paramBoolean);
    localmqs.a(0, 0);
    localmqs.a(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfMqq[0]);
    localmqs.b(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[1], this.jdField_a_of_type_ArrayOfMqq[1]);
    localmqs.a(paramljf);
    localmqs.a(0L);
    paramljf = new ArrayList();
    paramljf.add(localmqs);
    return paramljf;
  }
  
  void d()
  {
    mqs localmqs = (mqs)this.jdField_a_of_type_JavaUtilList.get(0);
    if ((localmqs != null) && (localmqs.f())) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewFilm
 * JD-Core Version:    0.7.0.1
 */