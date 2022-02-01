package com.tencent.mobileqq.apollo.player.api.impl;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class ApolloBrickPlayerImpl$1$1
  implements Runnable
{
  ApolloBrickPlayerImpl$1$1(ApolloBrickPlayerImpl.1 param1, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    ApolloBrickPlayerImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiImplApolloBrickPlayerImpl$1.this$0).setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    ApolloBrickPlayerImpl.access$800(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiImplApolloBrickPlayerImpl$1.this$0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start getFileDrawable ");
      localStringBuilder.append(ApolloBrickPlayerImpl.access$500(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiImplApolloBrickPlayerImpl$1.this$0));
      QLog.d("[cmshow]ApolloBrickPlayer", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.api.impl.ApolloBrickPlayerImpl.1.1
 * JD-Core Version:    0.7.0.1
 */