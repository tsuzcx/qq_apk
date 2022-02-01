package com.tencent.hippy.qq.view.tkd.listview;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class HippyTKDRefreshHeader$2
  implements View.OnLayoutChangeListener
{
  HippyTKDRefreshHeader$2(HippyTKDRefreshHeader paramHippyTKDRefreshHeader) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = paramInt4 - paramInt2;
    if (paramInt1 > 0) {
      this.this$0.mContentheight = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.2
 * JD-Core Version:    0.7.0.1
 */