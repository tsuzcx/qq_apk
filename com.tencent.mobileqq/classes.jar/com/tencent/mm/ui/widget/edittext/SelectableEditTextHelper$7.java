package com.tencent.mm.ui.widget.edittext;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.TextView;
import com.tencent.mm.ui.f;

class SelectableEditTextHelper$7
  implements View.OnLayoutChangeListener
{
  SelectableEditTextHelper$7(SelectableEditTextHelper paramSelectableEditTextHelper) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (SelectableEditTextHelper.m(this.a)) {
      return;
    }
    paramView = new int[2];
    paramView[0] = SelectableEditTextHelper.v(this.a)[0];
    paramView[1] = SelectableEditTextHelper.v(this.a)[1];
    SelectableEditTextHelper.k(this.a).getLocationInWindow(SelectableEditTextHelper.v(this.a));
    f.b("SelectableEditTextHelper", "LayoutChangeFromWindow l:%d,t:%d,r:%d,b:%d,oldl:%d,oldt:%d,oldr:%d,oldb:%d,oldx:%d, newx:%d, oldy:%d, newy:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramView[0]), Integer.valueOf(SelectableEditTextHelper.v(this.a)[0]), Integer.valueOf(paramView[1]), Integer.valueOf(SelectableEditTextHelper.v(this.a)[1]) });
    if ((paramInt2 != paramInt6) || (paramInt4 != paramInt8) || (paramView[1] != SelectableEditTextHelper.v(this.a)[1])) {
      this.a.closeSelectAndTools();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.7
 * JD-Core Version:    0.7.0.1
 */