package com.tencent.biz.qqcircle.fragments.content;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener;

class QCircleContentVerticalAdapter$1
  implements RecyclerView.OnItemTouchListener
{
  private int b;
  private int c;
  
  QCircleContentVerticalAdapter$1(QCircleContentVerticalAdapter paramQCircleContentVerticalAdapter) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 2) {
        return false;
      }
      int j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      j -= this.c;
      int m = this.b;
      int k = i - m;
      i = (int)((i - m) * 0.6F);
      if (QCircleContentVerticalAdapter.a(this.a, paramMotionEvent)) {
        return false;
      }
      if ((Math.abs(j) > QCircleContentVerticalAdapter.a(this.a)) && (Math.abs(j) >= Math.abs(i))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        QCircleContentVerticalAdapter.a(this.a, j, k);
        return false;
      }
      QCircleContentVerticalAdapter.b(this.a, j, k);
      return false;
    }
    this.c = ((int)(paramMotionEvent.getX() + 0.5F));
    this.b = ((int)(paramMotionEvent.getY() + 0.5F));
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVerticalAdapter.1
 * JD-Core Version:    0.7.0.1
 */