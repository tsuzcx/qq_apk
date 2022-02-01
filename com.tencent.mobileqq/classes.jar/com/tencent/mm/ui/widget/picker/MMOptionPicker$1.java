package com.tencent.mm.ui.widget.picker;

import com.tencent.luggage.wxa.ir.c;
import java.util.ArrayList;
import java.util.List;

class MMOptionPicker$1
  implements c
{
  MMOptionPicker$1(MMOptionPicker paramMMOptionPicker) {}
  
  public void onOptionsSelectChanged(int paramInt)
  {
    MMOptionPicker.a(this.a).setOptionsArray(MMOptionPicker.a(this.a, paramInt));
    if ((MMOptionPicker.b(this.a) != null) && (MMOptionPicker.c(this.a) != null))
    {
      int j = 0;
      int i = 0;
      while (j < paramInt)
      {
        i += ((List)MMOptionPicker.d(this.a).get(j)).size();
        j += 1;
      }
      paramInt = MMOptionPicker.a(this.a).currentIndex();
      MMOptionPicker.c(this.a).setOptionsArray(MMOptionPicker.b(this.a, i + paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MMOptionPicker.1
 * JD-Core Version:    0.7.0.1
 */