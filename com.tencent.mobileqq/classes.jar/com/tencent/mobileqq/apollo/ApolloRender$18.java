package com.tencent.mobileqq.apollo;

import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

final class ApolloRender$18
  implements Runnable
{
  ApolloRender$18(ApolloRender paramApolloRender, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null) {
      return;
    }
    int i = (int)(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredWidth() - 80.0F * DeviceInfoUtil.density);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop.setWidth(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.18
 * JD-Core Version:    0.7.0.1
 */