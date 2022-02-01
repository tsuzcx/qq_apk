package com.tencent.luggage.wxa.lq;

import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.i.d;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import java.util.ArrayList;
import java.util.Map;

class b$1$1
  implements i.d
{
  b$1$1(b.1 param1, MMBottomSheet paramMMBottomSheet, Map paramMap, int paramInt) {}
  
  public void a(g paramg)
  {
    this.a.setFooterView(null);
    paramg.clear();
    int i = 0;
    while (i < this.d.e.size())
    {
      if (this.b.containsKey(Integer.valueOf(i))) {
        paramg.add(i, (CharSequence)this.d.e.get(i), true, false);
      } else {
        paramg.add(i, this.c, (CharSequence)this.d.e.get(i));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.b.1.1
 * JD-Core Version:    0.7.0.1
 */