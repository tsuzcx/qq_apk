package com.dataline.activities;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.widget.XListView;

class LiteActivity$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  LiteActivity$3(LiteActivity paramLiteActivity) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.f.getBottom() - LiteActivity.a(this.a).getTop();
    if ((LiteActivity.a(this.a).getVisibility() == 0) && (this.a.f.getPaddingBottom() != i)) {
      this.a.f.setPadding(this.a.f.getPaddingLeft(), this.a.f.getPaddingTop(), this.a.f.getPaddingRight(), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.3
 * JD-Core Version:    0.7.0.1
 */