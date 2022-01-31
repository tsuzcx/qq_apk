package com.tencent.av.business.manager;

import android.util.SparseArray;
import ljq;
import ljr;

public class EffectMutexManager$1
  implements Runnable
{
  public EffectMutexManager$1(ljq paramljq, int paramInt, String paramString) {}
  
  public void run()
  {
    int i = 0;
    while (i < ljq.a(this.this$0).size())
    {
      ljr localljr = (ljr)ljq.a(this.this$0).valueAt(i);
      if ((localljr != null) && (ljq.a(this.this$0).keyAt(i) != this.jdField_a_of_type_Int)) {
        localljr.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectMutexManager.1
 * JD-Core Version:    0.7.0.1
 */