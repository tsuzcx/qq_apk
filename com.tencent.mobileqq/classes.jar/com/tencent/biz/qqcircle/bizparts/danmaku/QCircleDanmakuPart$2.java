package com.tencent.biz.qqcircle.bizparts.danmaku;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.ApngImage;
import vei;
import vet;
import vex;

public class QCircleDanmakuPart$2
  implements Runnable
{
  public QCircleDanmakuPart$2(vei paramvei, ImageView paramImageView, vex paramvex) {}
  
  public void run()
  {
    vei.a(this.this$0).a();
    vei.a(this.this$0).removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    ApngImage.pauseByTag(33);
    if (!this.jdField_a_of_type_Vex.h())
    {
      this.jdField_a_of_type_Vex.i(this.jdField_a_of_type_Vex.t + 1);
      this.jdField_a_of_type_Vex.h = true;
    }
    this.this$0.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.QCircleDanmakuPart.2
 * JD-Core Version:    0.7.0.1
 */