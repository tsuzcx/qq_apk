package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.drawable.Drawable;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class DoodleMsgLayout$4$1
  implements Runnable
{
  DoodleMsgLayout$4$1(DoodleMsgLayout.4 param4, Drawable paramDrawable1, Drawable paramDrawable2) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setDoodleContent start update drawable:");
    ((StringBuilder)localObject).append(DoodleMsgLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$4.this$0));
    QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (DoodleMsgLayout.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$4.this$0) != null)) {
      DoodleMsgLayout.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$4.this$0).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    if (DoodleMsgLayout.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$4.this$0) != null) {
      DoodleMsgLayout.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$4.this$0).setImageDrawable(this.b);
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null)
    {
      localObject = ((URLDrawable)localObject).getCurrDrawable();
      if ((localObject instanceof GifDrawable)) {
        ((GifDrawable)localObject).getImage().reset();
      }
      ((URLDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setIndividualPause(false);
    }
    DoodleMsgLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$4.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.4.1
 * JD-Core Version:    0.7.0.1
 */