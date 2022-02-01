package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Typeface;
import android.view.View;
import vip;
import vis;
import vjg;

public class TextCellLayout$4$1
  implements Runnable
{
  public TextCellLayout$4$1(vis paramvis, Typeface paramTypeface) {}
  
  public void run()
  {
    vip.a(this.jdField_a_of_type_Vis.a, this.jdField_a_of_type_AndroidGraphicsTypeface);
    View localView = vip.a(this.jdField_a_of_type_Vis.a).a();
    if (localView != null)
    {
      this.jdField_a_of_type_Vis.a.b();
      localView.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayout.4.1
 * JD-Core Version:    0.7.0.1
 */