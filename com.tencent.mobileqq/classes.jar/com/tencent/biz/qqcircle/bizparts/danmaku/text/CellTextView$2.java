package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.view.View;
import android.view.View.OnLongClickListener;

class CellTextView$2
  implements View.OnLongClickListener
{
  CellTextView$2(CellTextView paramCellTextView) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = this.a;
    paramView.c = true;
    paramView.postInvalidate();
    if (this.a.j != null)
    {
      paramView = this.a.j;
      CellTextView localCellTextView = this.a;
      paramView.a(localCellTextView, localCellTextView.r);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.CellTextView.2
 * JD-Core Version:    0.7.0.1
 */