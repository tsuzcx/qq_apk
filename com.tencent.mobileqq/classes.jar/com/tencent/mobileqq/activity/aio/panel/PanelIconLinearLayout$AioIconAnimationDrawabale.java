package com.tencent.mobileqq.activity.aio.panel;

import com.tencent.mobileqq.activity.aio.item.DetectableAnimationDrawable;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;

public class PanelIconLinearLayout$AioIconAnimationDrawabale
  extends DetectableAnimationDrawable
{
  public RedDotImageView a;
  public int[] a;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconLinearLayout", 2, "onAnimationFinish," + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.isSelected());
    }
    if (this.jdField_a_of_type_ArrayOfInt != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setImageResource(this.jdField_a_of_type_ArrayOfInt[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.AioIconAnimationDrawabale
 * JD-Core Version:    0.7.0.1
 */