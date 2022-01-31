package com.tencent.biz.now;

import android.view.View;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.widget.AbsListView;
import ngf;

public class NowVideoController$2
  implements Runnable
{
  public NowVideoController$2(ngf paramngf, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (ngf.a(this.this$0) == null) {}
    for (;;)
    {
      return;
      int i = this.a;
      while (i <= this.b)
      {
        Object localObject = ngf.a(this.this$0).getChildAt(i - this.a);
        if (localObject != null)
        {
          localObject = (PAVideoView)((View)localObject).findViewById(2131377079);
          if ((localObject != null) && (((PAVideoView)localObject).j == 4)) {
            ((PAVideoView)localObject).e();
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoController.2
 * JD-Core Version:    0.7.0.1
 */