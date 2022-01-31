package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ZimuViewFilm
  extends ZimuView
{
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  final int[] jdField_a_of_type_ArrayOfInt = { 44, 30 };
  IZimuItemView.FontPara[] jdField_a_of_type_ArrayOfComTencentAvUiFunchatZimuIZimuItemView$FontPara = { new IZimuItemView.FontPara(Color.parseColor("#ffffff"), Color.parseColor("#000000"), 5), new IZimuItemView.FontPara(Color.parseColor("#fdeabd"), Color.parseColor("#000000"), 4) };
  
  public ZimuViewFilm(VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramVideoAppInterface, paramContext, paramAttributeSet);
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
    while (j < this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatZimuIZimuItemView$FontPara.length)
    {
      paramVideoAppInterface = this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatZimuIZimuItemView$FontPara[j];
      paramVideoAppInterface.jdField_a_of_type_Float *= f;
      j += 1;
    }
  }
  
  public int a()
  {
    return (int)getContext().getResources().getDimension(2131560059);
  }
  
  public String a()
  {
    return "film";
  }
  
  protected List a(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    a();
    ZimuItemViewFilm localZimuItemViewFilm = new ZimuItemViewFilm(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_Float);
    localZimuItemViewFilm.a(paramBoolean);
    localZimuItemViewFilm.a(0, 0);
    localZimuItemViewFilm.a(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatZimuIZimuItemView$FontPara[0]);
    localZimuItemViewFilm.b(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_ArrayOfInt[1], this.jdField_a_of_type_ArrayOfComTencentAvUiFunchatZimuIZimuItemView$FontPara[1]);
    localZimuItemViewFilm.a(paramSentenceInfo);
    localZimuItemViewFilm.a(0L);
    paramSentenceInfo = new ArrayList();
    paramSentenceInfo.add(localZimuItemViewFilm);
    return paramSentenceInfo;
  }
  
  void d()
  {
    ZimuItemViewFilm localZimuItemViewFilm = (ZimuItemViewFilm)this.jdField_a_of_type_JavaUtilList.get(0);
    if ((localZimuItemViewFilm != null) && (localZimuItemViewFilm.f())) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewFilm
 * JD-Core Version:    0.7.0.1
 */