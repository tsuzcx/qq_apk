package com.tencent.biz.qqcircle.picload;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import vrd;

class QCircleFeedPicLoader$5
  implements Runnable
{
  QCircleFeedPicLoader$5(QCircleFeedPicLoader paramQCircleFeedPicLoader, vrd paramvrd, Drawable paramDrawable) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Vrd.c())
    {
      if (this.jdField_a_of_type_Vrd.a() != null)
      {
        this.jdField_a_of_type_Vrd.a().setImageDrawable(null);
        this.jdField_a_of_type_Vrd.a().setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      QCircleFeedPicLoader.b(this.this$0, this.jdField_a_of_type_Vrd, 0);
      QLog.i(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " cacheKey = " + this.jdField_a_of_type_Vrd.b() + " the total time " + (System.currentTimeMillis() - this.jdField_a_of_type_Vrd.a.longValue()) + "pic is valid");
      return;
    }
    QLog.i(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " cacheKey = " + this.jdField_a_of_type_Vrd.b() + " the total time " + (System.currentTimeMillis() - this.jdField_a_of_type_Vrd.a.longValue()) + "pic is unValid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader.5
 * JD-Core Version:    0.7.0.1
 */