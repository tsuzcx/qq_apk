package com.tencent.av.business.manager;

import android.util.SparseArray;
import lgn;
import lgo;

public class EffectMutexManager$1
  implements Runnable
{
  public EffectMutexManager$1(lgn paramlgn, int paramInt, String paramString) {}
  
  public void run()
  {
    int i = 0;
    while (i < lgn.a(this.this$0).size())
    {
      lgo locallgo = (lgo)lgn.a(this.this$0).valueAt(i);
      if ((locallgo != null) && (lgn.a(this.this$0).keyAt(i) != this.jdField_a_of_type_Int)) {
        locallgo.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectMutexManager.1
 * JD-Core Version:    0.7.0.1
 */