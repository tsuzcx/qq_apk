package com.tencent.mm.ui.widget.picker;

import com.tencent.luggage.wxa.ir.c;
import java.util.ArrayList;
import java.util.List;

class MMOptionPicker$2
  implements c
{
  MMOptionPicker$2(MMOptionPicker paramMMOptionPicker) {}
  
  public void onOptionsSelectChanged(int paramInt)
  {
    int k = MMOptionPicker.e(this.a).currentIndex();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((List)MMOptionPicker.d(this.a).get(i)).size();
      i += 1;
    }
    MMOptionPicker.c(this.a).setOptionsArray(MMOptionPicker.b(this.a, j + paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MMOptionPicker.2
 * JD-Core Version:    0.7.0.1
 */