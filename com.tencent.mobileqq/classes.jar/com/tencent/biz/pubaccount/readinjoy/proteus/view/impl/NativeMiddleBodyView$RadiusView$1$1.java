package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import pbn;

public class NativeMiddleBodyView$RadiusView$1$1
  implements Runnable
{
  public NativeMiddleBodyView$RadiusView$1$1(pbn parampbn, int paramInt1, int paramInt2, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void run()
  {
    QLog.i(NativeMiddleBodyView.a(), 1, "setLayoutParams width:" + this.jdField_a_of_type_Int + " height:" + this.b + " old: " + this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width + ":" + this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.height);
    this.jdField_a_of_type_Pbn.a.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView.RadiusView.1.1
 * JD-Core Version:    0.7.0.1
 */