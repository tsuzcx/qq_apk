package com.tencent.biz.qqcircle.bizparts.danmaku;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.ApngImage;
import vgm;
import vgx;
import vhb;

public class QCircleDanmakuPart$2
  implements Runnable
{
  public QCircleDanmakuPart$2(vgm paramvgm, ImageView paramImageView, vhb paramvhb) {}
  
  public void run()
  {
    vgm.a(this.this$0).a();
    vgm.a(this.this$0).removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    ApngImage.pauseByTag(33);
    if (!this.jdField_a_of_type_Vhb.h())
    {
      this.jdField_a_of_type_Vhb.i(this.jdField_a_of_type_Vhb.t + 1);
      this.jdField_a_of_type_Vhb.h = true;
    }
    this.this$0.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.QCircleDanmakuPart.2
 * JD-Core Version:    0.7.0.1
 */