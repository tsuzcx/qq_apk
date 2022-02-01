package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.av.app.VideoAppInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import lgc;
import mob;
import moc;
import mod;

public class ZimuViewFilm
  extends ZimuView
{
  WeakReference<ZimuView> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  final int[] jdField_a_of_type_ArrayOfInt = { 44, 30 };
  mob[] jdField_a_of_type_ArrayOfMob = { new mob(Color.parseColor("#ffffff"), Color.parseColor("#000000"), 5), new mob(Color.parseColor("#fdeabd"), Color.parseColor("#000000"), 4) };
  
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
    while (j < this.jdField_a_of_type_ArrayOfMob.length)
    {
      paramVideoAppInterface = this.jdField_a_of_type_ArrayOfMob[j];
      paramVideoAppInterface.jdField_a_of_type_Float *= f;
      j += 1;
    }
  }
  
  public int a()
  {
    return (int)getContext().getResources().getDimension(2131297715);
  }
  
  public String a()
  {
    return "film";
  }
  
  protected List<moc> a(lgc paramlgc, boolean paramBoolean)
  {
    a();
    mod localmod = new mod(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Float);
    localmod.a(paramBoolean);
    localmod.a(0, 0);
    localmod.a(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfMob[0]);
    localmod.b(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[1], this.jdField_a_of_type_ArrayOfMob[1]);
    localmod.a(paramlgc);
    localmod.a(0L);
    paramlgc = new ArrayList();
    paramlgc.add(localmod);
    return paramlgc;
  }
  
  void d()
  {
    mod localmod = (mod)this.jdField_a_of_type_JavaUtilList.get(0);
    if ((localmod != null) && (localmod.f())) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewFilm
 * JD-Core Version:    0.7.0.1
 */