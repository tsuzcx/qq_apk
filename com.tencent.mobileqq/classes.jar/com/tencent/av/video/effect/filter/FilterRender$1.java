package com.tencent.av.video.effect.filter;

import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;

class FilterRender$1
  implements Runnable
{
  FilterRender$1(FilterRender paramFilterRender, String paramString) {}
  
  public void run()
  {
    FilterRender localFilterRender = this.this$0;
    FilterRender.access$002(localFilterRender, FilterRender.access$100(localFilterRender).getFilter(this.val$filterPath));
    if (FilterRender.access$000(this.this$0) != null) {
      FilterRender.access$000(this.this$0).init();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.filter.FilterRender.1
 * JD-Core Version:    0.7.0.1
 */