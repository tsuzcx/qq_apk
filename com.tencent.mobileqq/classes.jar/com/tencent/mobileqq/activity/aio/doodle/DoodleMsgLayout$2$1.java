package com.tencent.mobileqq.activity.aio.doodle;

import aekt;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.widget.ImageView;
import benq;

class DoodleMsgLayout$2$1
  implements Runnable
{
  DoodleMsgLayout$2$1(DoodleMsgLayout.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (DoodleMsgLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$2.this$0) != null)
    {
      benq localbenq = new benq(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, false);
      localbenq.setBounds(new Rect(0, 0, aekt.a(19.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$2.this$0.getResources()), aekt.a(19.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$2.this$0.getResources())));
      DoodleMsgLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$2.this$0).setImageDrawable(localbenq);
    }
    DoodleMsgLayout.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$2.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.2.1
 * JD-Core Version:    0.7.0.1
 */