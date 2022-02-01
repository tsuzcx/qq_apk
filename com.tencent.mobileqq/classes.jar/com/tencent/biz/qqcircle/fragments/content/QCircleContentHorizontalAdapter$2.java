package com.tencent.biz.qqcircle.fragments.content;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.OnLongClickListener;

class QCircleContentHorizontalAdapter$2
  implements QCircleDoubleClickLayout.OnLongClickListener
{
  QCircleContentHorizontalAdapter$2(QCircleContentHorizontalAdapter paramQCircleContentHorizontalAdapter, ViewGroup paramViewGroup) {}
  
  public void onLongClick()
  {
    View localView = ((Activity)this.a.getContext()).findViewById(2131436572);
    if (localView != null) {
      localView.callOnClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentHorizontalAdapter.2
 * JD-Core Version:    0.7.0.1
 */