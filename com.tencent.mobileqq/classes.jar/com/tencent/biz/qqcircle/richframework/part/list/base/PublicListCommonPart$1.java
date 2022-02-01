package com.tencent.biz.qqcircle.richframework.part.list.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicListCommonPart$1
  implements View.OnClickListener
{
  PublicListCommonPart$1(PublicListCommonPart paramPublicListCommonPart, int paramInt, View paramView, BaseListBlock paramBaseListBlock) {}
  
  public void onClick(View paramView)
  {
    PublicListCommonPart.a(this.d, this.a);
    if (FastClickUtils.a(String.valueOf(this.b.hashCode()))) {
      this.c.onDoubleClickTitle();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.list.base.PublicListCommonPart.1
 * JD-Core Version:    0.7.0.1
 */