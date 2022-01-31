package com.tencent.av.business.manager;

import android.util.SparseArray;
import lhn;
import lho;

public class EffectMutexManager$1
  implements Runnable
{
  public EffectMutexManager$1(lhn paramlhn, int paramInt, String paramString) {}
  
  public void run()
  {
    int i = 0;
    while (i < lhn.a(this.this$0).size())
    {
      lho locallho = (lho)lhn.a(this.this$0).valueAt(i);
      if ((locallho != null) && (lhn.a(this.this$0).keyAt(i) != this.jdField_a_of_type_Int)) {
        locallho.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectMutexManager.1
 * JD-Core Version:    0.7.0.1
 */