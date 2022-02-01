package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyVideoView;

class ProteusItemView$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ProteusItemView$3(ProteusItemView paramProteusItemView) {}
  
  public void onGlobalLayout()
  {
    if (this.a.getParent() == null)
    {
      ReadInJoyVideoView localReadInJoyVideoView = ProteusItemView.a(ProteusItemView.a(this.a));
      if ((localReadInJoyVideoView != null) && (localReadInJoyVideoView.isVisible()) && (ProteusItemView.a(this.a, localReadInJoyVideoView.a()))) {
        localReadInJoyVideoView.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView.3
 * JD-Core Version:    0.7.0.1
 */