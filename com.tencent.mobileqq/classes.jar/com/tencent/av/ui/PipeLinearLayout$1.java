package com.tencent.av.ui;

import android.os.Handler;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

class PipeLinearLayout$1
  implements Runnable
{
  PipeLinearLayout$1(PipeLinearLayout paramPipeLinearLayout) {}
  
  public void run()
  {
    PipeLinearLayout.a(this.this$0);
    if (PipeLinearLayout.a(this.this$0).size() == 0)
    {
      localObject = new StringBuilder(PipeLinearLayout.a(this.this$0));
      ((StringBuilder)localObject).append("等");
      ((StringBuilder)localObject).append(PipeLinearLayout.a(this.this$0).getText());
      if (PipeLinearLayout.a(this.this$0)) {
        return;
      }
      PipeLinearLayout.a(this.this$0).post(new PipeLinearLayout.1.1(this, (StringBuilder)localObject));
      return;
    }
    Object localObject = new ArrayList();
    Iterator localIterator = PipeLinearLayout.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      ((ArrayList)localObject).add(PipeLinearLayout.a(this.this$0, localLong.longValue()));
    }
    if (PipeLinearLayout.a(this.this$0)) {
      return;
    }
    PipeLinearLayout.a(this.this$0).post(new PipeLinearLayout.1.2(this, (ArrayList)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.PipeLinearLayout.1
 * JD-Core Version:    0.7.0.1
 */