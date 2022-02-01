package com.etrump.mixlayout;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

public class ETTextView$DecorationHolder
{
  public int a;
  public long a;
  public Bitmap a;
  public ETLayout a;
  public WeakReference<ETTextView> a;
  public long b = 0L;
  
  public ETTextView$DecorationHolder()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  static DecorationHolder a(ETTextView paramETTextView)
  {
    if (ETTextView.access$600(paramETTextView) == null) {
      return null;
    }
    DecorationHolder localDecorationHolder = new DecorationHolder();
    localDecorationHolder.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramETTextView);
    localDecorationHolder.jdField_a_of_type_Long = paramETTextView.mMsgId;
    localDecorationHolder.jdField_a_of_type_ComEtrumpMixlayoutETLayout = paramETTextView.mLayout;
    localDecorationHolder.jdField_a_of_type_Int = ETTextView.access$600(paramETTextView).currentFrameIndex();
    localDecorationHolder.jdField_a_of_type_AndroidGraphicsBitmap = ETTextView.access$400(paramETTextView).a();
    localDecorationHolder.b = System.currentTimeMillis();
    return localDecorationHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView.DecorationHolder
 * JD-Core Version:    0.7.0.1
 */