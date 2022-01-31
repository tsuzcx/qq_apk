package com.tencent.av.business.manager;

import android.util.SparseArray;
import lhs;
import lht;

public class EffectMutexManager$1
  implements Runnable
{
  public EffectMutexManager$1(lhs paramlhs, int paramInt, String paramString) {}
  
  public void run()
  {
    int i = 0;
    while (i < lhs.a(this.this$0).size())
    {
      lht locallht = (lht)lhs.a(this.this$0).valueAt(i);
      if ((locallht != null) && (lhs.a(this.this$0).keyAt(i) != this.jdField_a_of_type_Int)) {
        locallht.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectMutexManager.1
 * JD-Core Version:    0.7.0.1
 */