package com.tencent.mobileqq.activity.aio.doodle;

import com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker.GifTemplatePickerListener;
import com.tencent.mobileqq.util.SharePreferenceUtils;

class DoodlePanel$2
  implements GifTemplatePicker.GifTemplatePickerListener
{
  DoodlePanel$2(DoodlePanel paramDoodlePanel) {}
  
  public void a(int paramInt)
  {
    if (this.a.a != null)
    {
      if (this.a.a != null) {
        this.a.a.setTemplateID(paramInt);
      }
      DoodlePanel.a(this.a);
      SharePreferenceUtils.a(this.a.getContext(), "aio_doodle_template_picker_select", String.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.2
 * JD-Core Version:    0.7.0.1
 */