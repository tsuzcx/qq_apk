package com.tencent.mm.ui.widget.dialog;

import android.view.View;
import android.widget.ScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;

class MMBottomSheet$2
  implements CustomScrollView.a
{
  MMBottomSheet$2(MMBottomSheet paramMMBottomSheet) {}
  
  public void onScrollChange(ScrollView paramScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramScrollView.getChildAt(0).getMeasuredHeight() - (paramScrollView.getHeight() + paramScrollView.getScrollY()) < 50)
    {
      MMBottomSheet.b(this.a).setVisibility(8);
      return;
    }
    MMBottomSheet.b(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMBottomSheet.2
 * JD-Core Version:    0.7.0.1
 */