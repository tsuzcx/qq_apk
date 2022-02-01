package com.tencent.mobileqq.adapter;

import amdl;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class MayKnowAdapter$5
  implements Runnable
{
  public MayKnowAdapter$5(amdl paramamdl) {}
  
  public void run()
  {
    View localView = amdl.a(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "delayUpdateRunnable target：" + localView);
    }
    if (localView != null)
    {
      amdl.a(this.this$0, localView);
      return;
    }
    amdl.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.MayKnowAdapter.5
 * JD-Core Version:    0.7.0.1
 */