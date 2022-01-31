package com.tencent.mobileqq.activity.aio.doodle;

import aepi;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.widget.ImageView;
import berz;

class DoodleMsgLayout$2$1
  implements Runnable
{
  DoodleMsgLayout$2$1(DoodleMsgLayout.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (DoodleMsgLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$2.this$0) != null)
    {
      berz localberz = new berz(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, false);
      localberz.setBounds(new Rect(0, 0, aepi.a(19.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$2.this$0.getResources()), aepi.a(19.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$2.this$0.getResources())));
      DoodleMsgLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$2.this$0).setImageDrawable(localberz);
    }
    DoodleMsgLayout.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$2.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.2.1
 * JD-Core Version:    0.7.0.1
 */