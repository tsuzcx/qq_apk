package com.tencent.mobileqq.adapter;

import akfe;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class MayKnowAdapter$5
  implements Runnable
{
  public MayKnowAdapter$5(akfe paramakfe) {}
  
  public void run()
  {
    View localView = akfe.a(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "delayUpdateRunnable target：" + localView);
    }
    if (localView != null)
    {
      akfe.a(this.this$0, localView);
      return;
    }
    akfe.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.MayKnowAdapter.5
 * JD-Core Version:    0.7.0.1
 */