package com.tencent.mobileqq.activity.editservice;

import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.ColorItem;
import com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.OnColorSelectListener;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.ColorNickManager.ColorNickColor;
import com.tencent.mobileqq.vas.ColorSpan;
import com.tencent.mobileqq.widget.ColorClearableEditText;

class EditTroopMemberNickService$8
  implements ColorNickColorPanelAdapter.OnColorSelectListener
{
  EditTroopMemberNickService$8(EditTroopMemberNickService paramEditTroopMemberNickService) {}
  
  public void a(ColorNickColorPanelAdapter.ColorItem paramColorItem)
  {
    if ((this.a.a instanceof ColorClearableEditText))
    {
      EditTroopMemberNickService.a(this.a, true);
      ColorClearableEditText localColorClearableEditText = (ColorClearableEditText)this.a.a;
      String str = ColorNickManager.a(paramColorItem);
      ColorSpan[] arrayOfColorSpan = (ColorSpan[])this.a.a.getEditableText().getSpans(0, this.a.a.getEditableText().length(), ColorSpan.class);
      int j;
      if ((arrayOfColorSpan != null) && (arrayOfColorSpan.length > 0))
      {
        i = this.a.a.getEditableText().getSpanStart(arrayOfColorSpan[0]);
        j = this.a.a.getEditableText().getSpanEnd(arrayOfColorSpan[0]);
        this.a.a.getEditableText().removeSpan(arrayOfColorSpan[0]);
      }
      else
      {
        i = 0;
        j = 0;
      }
      this.a.a.getEditableText().replace(i, j, str);
      int i = paramColorItem.a;
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        localColorClearableEditText.setTextColor(-16777216);
        paramColorItem = ColorNickManager.a(EditTroopMemberNickService.b(this.a)).a(paramColorItem.d);
        if (paramColorItem != null) {
          localColorClearableEditText.setSpecialColor(paramColorItem.a, paramColorItem.c, paramColorItem.d, paramColorItem.b, paramColorItem.e);
        }
      }
      else
      {
        if (paramColorItem.d != 0) {
          localColorClearableEditText.setTextColor(paramColorItem.d);
        } else {
          localColorClearableEditText.setTextColor(-16777216);
        }
        localColorClearableEditText.setSpecialColor(0, null, null, 0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.8
 * JD-Core Version:    0.7.0.1
 */