package com.tencent.mobileqq.activity.aio.zhitu;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ZhituPanelView$ZhituPanelAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  ZhituPanelView$ZhituPanelAdapter$1(ZhituPanelView.ZhituPanelAdapter paramZhituPanelAdapter) {}
  
  public int getSpanSize(int paramInt)
  {
    paramInt = this.a.getItemViewType(paramInt);
    if (paramInt != 1)
    {
      if ((paramInt != 2) && (paramInt != 3)) {
        return 1;
      }
      return 3;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.ZhituPanelAdapter.1
 * JD-Core Version:    0.7.0.1
 */