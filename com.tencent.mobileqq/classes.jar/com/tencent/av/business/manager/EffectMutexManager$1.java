package com.tencent.av.business.manager;

import android.util.SparseArray;
import lgl;
import lgm;

public class EffectMutexManager$1
  implements Runnable
{
  public EffectMutexManager$1(lgl paramlgl, int paramInt, String paramString) {}
  
  public void run()
  {
    int i = 0;
    while (i < lgl.a(this.this$0).size())
    {
      lgm locallgm = (lgm)lgl.a(this.this$0).valueAt(i);
      if ((locallgm != null) && (lgl.a(this.this$0).keyAt(i) != this.jdField_a_of_type_Int)) {
        locallgm.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectMutexManager.1
 * JD-Core Version:    0.7.0.1
 */