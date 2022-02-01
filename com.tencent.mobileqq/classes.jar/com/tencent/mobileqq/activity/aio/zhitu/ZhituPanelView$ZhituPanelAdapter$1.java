package com.tencent.mobileqq.activity.aio.zhitu;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ZhituPanelView$ZhituPanelAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  ZhituPanelView$ZhituPanelAdapter$1(ZhituPanelView.ZhituPanelAdapter paramZhituPanelAdapter) {}
  
  public int getSpanSize(int paramInt)
  {
    switch (this.a.getItemViewType(paramInt))
    {
    case 1: 
    default: 
      return 1;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.ZhituPanelAdapter.1
 * JD-Core Version:    0.7.0.1
 */