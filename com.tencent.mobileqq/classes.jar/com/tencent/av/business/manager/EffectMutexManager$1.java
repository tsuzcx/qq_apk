package com.tencent.av.business.manager;

import android.util.SparseArray;

class EffectMutexManager$1
  implements Runnable
{
  EffectMutexManager$1(EffectMutexManager paramEffectMutexManager, int paramInt, String paramString) {}
  
  public void run()
  {
    int i = 0;
    while (i < EffectMutexManager.a(this.this$0).size())
    {
      EffectMutexManager.IMutexItem localIMutexItem = (EffectMutexManager.IMutexItem)EffectMutexManager.a(this.this$0).valueAt(i);
      if (localIMutexItem != null)
      {
        int j = EffectMutexManager.a(this.this$0).keyAt(i);
        int k = this.a;
        if (j != k) {
          localIMutexItem.b(k, this.b);
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectMutexManager.1
 * JD-Core Version:    0.7.0.1
 */