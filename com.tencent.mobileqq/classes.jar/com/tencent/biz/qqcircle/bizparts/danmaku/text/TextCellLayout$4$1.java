package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Typeface;
import android.view.View;
import vgl;
import vgo;
import vhc;

public class TextCellLayout$4$1
  implements Runnable
{
  public TextCellLayout$4$1(vgo paramvgo, Typeface paramTypeface) {}
  
  public void run()
  {
    vgl.a(this.jdField_a_of_type_Vgo.a, this.jdField_a_of_type_AndroidGraphicsTypeface);
    View localView = vgl.a(this.jdField_a_of_type_Vgo.a).a();
    if (localView != null)
    {
      this.jdField_a_of_type_Vgo.a.b();
      localView.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayout.4.1
 * JD-Core Version:    0.7.0.1
 */