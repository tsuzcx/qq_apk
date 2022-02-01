package com.tencent.biz.qqcircle.picload;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import vou;

class QCircleFeedPicLoader$5
  implements Runnable
{
  QCircleFeedPicLoader$5(QCircleFeedPicLoader paramQCircleFeedPicLoader, vou paramvou, Drawable paramDrawable) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Vou.c())
    {
      this.jdField_a_of_type_Vou.a().setImageDrawable(null);
      this.jdField_a_of_type_Vou.a().setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      QCircleFeedPicLoader.b(this.this$0, this.jdField_a_of_type_Vou, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader.5
 * JD-Core Version:    0.7.0.1
 */