package com.tencent.mobileqq.activity.aio.doodle;

import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker.ColorPickerData;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker.ColorSelectListener;
import com.tencent.mobileqq.util.SharePreferenceUtils;

class DoodlePanel$1
  implements ColorPicker.ColorSelectListener
{
  DoodlePanel$1(DoodlePanel paramDoodlePanel) {}
  
  public void a(ColorPicker.ColorPickerData paramColorPickerData)
  {
    this.a.a(paramColorPickerData);
    paramColorPickerData = "" + paramColorPickerData.a + ";" + paramColorPickerData.b + ";" + paramColorPickerData.c;
    SharePreferenceUtils.a(this.a.getContext(), "aio_doodle_colorpicker_select", paramColorPickerData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.1
 * JD-Core Version:    0.7.0.1
 */