package com.tencent.av.business.manager;

import android.util.SparseArray;
import lgz;
import lha;

public class EffectMutexManager$1
  implements Runnable
{
  public EffectMutexManager$1(lgz paramlgz, int paramInt, String paramString) {}
  
  public void run()
  {
    int i = 0;
    while (i < lgz.a(this.this$0).size())
    {
      lha locallha = (lha)lgz.a(this.this$0).valueAt(i);
      if ((locallha != null) && (lgz.a(this.this$0).keyAt(i) != this.jdField_a_of_type_Int)) {
        locallha.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectMutexManager.1
 * JD-Core Version:    0.7.0.1
 */