package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.view.MotionEvent;

class MystoryListView$3
  implements Runnable
{
  int jdField_a_of_type_Int = -1;
  
  MystoryListView$3(MystoryListView paramMystoryListView, int[] paramArrayOfInt1, int[] paramArrayOfInt2, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    if (i >= this.jdField_a_of_type_ArrayOfInt.length) {
      return;
    }
    if (i < 0)
    {
      this.jdField_a_of_type_Int = (i + 1);
      i = this.jdField_a_of_type_Int;
      if (i >= 0) {
        i = this.b[i];
      } else {
        i = 0;
      }
      this.this$0.postDelayed(this, i);
      return;
    }
    long l = System.currentTimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int], this.this$0.getWidth() / 2, this.jdField_a_of_type_ArrayOfFloat[this.jdField_a_of_type_Int], 0);
    this.this$0.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    this.jdField_a_of_type_Int += 1;
    i = this.jdField_a_of_type_Int;
    if (i < this.jdField_a_of_type_ArrayOfInt.length) {
      this.this$0.postDelayed(this, this.b[i]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.3
 * JD-Core Version:    0.7.0.1
 */