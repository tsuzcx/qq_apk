package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.av.app.VideoAppInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import lhc;
import mnw;
import mnx;
import mny;

public class ZimuViewFilm
  extends ZimuView
{
  WeakReference<ZimuView> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  final int[] jdField_a_of_type_ArrayOfInt = { 44, 30 };
  mnw[] jdField_a_of_type_ArrayOfMnw = { new mnw(Color.parseColor("#ffffff"), Color.parseColor("#000000"), 5), new mnw(Color.parseColor("#fdeabd"), Color.parseColor("#000000"), 4) };
  
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
    while (j < this.jdField_a_of_type_ArrayOfMnw.length)
    {
      paramVideoAppInterface = this.jdField_a_of_type_ArrayOfMnw[j];
      paramVideoAppInterface.jdField_a_of_type_Float *= f;
      j += 1;
    }
  }
  
  public int a()
  {
    return (int)getContext().getResources().getDimension(2131297548);
  }
  
  public String a()
  {
    return "film";
  }
  
  protected List<mnx> a(lhc paramlhc, boolean paramBoolean)
  {
    a();
    mny localmny = new mny(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Float);
    localmny.a(paramBoolean);
    localmny.a(0, 0);
    localmny.a(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfMnw[0]);
    localmny.b(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[1], this.jdField_a_of_type_ArrayOfMnw[1]);
    localmny.a(paramlhc);
    localmny.a(0L);
    paramlhc = new ArrayList();
    paramlhc.add(localmny);
    return paramlhc;
  }
  
  void d()
  {
    mny localmny = (mny)this.jdField_a_of_type_JavaUtilList.get(0);
    if ((localmny != null) && (localmny.f())) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewFilm
 * JD-Core Version:    0.7.0.1
 */