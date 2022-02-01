package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.view.MotionEvent;

class MystoryListView$3
  implements Runnable
{
  int a = -1;
  
  MystoryListView$3(MystoryListView paramMystoryListView, int[] paramArrayOfInt1, int[] paramArrayOfInt2, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    int i = this.a;
    if (i >= this.b.length) {
      return;
    }
    if (i < 0)
    {
      this.a = (i + 1);
      i = this.a;
      if (i >= 0) {
        i = this.c[i];
      } else {
        i = 0;
      }
      this.this$0.postDelayed(this, i);
      return;
    }
    long l = System.currentTimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, this.b[this.a], this.this$0.getWidth() / 2, this.d[this.a], 0);
    this.this$0.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    this.a += 1;
    i = this.a;
    if (i < this.b.length) {
      this.this$0.postDelayed(this, this.c[i]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.3
 * JD-Core Version:    0.7.0.1
 */