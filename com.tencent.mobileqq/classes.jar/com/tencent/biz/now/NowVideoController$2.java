package com.tencent.biz.now;

import android.view.View;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.widget.AbsListView;

class NowVideoController$2
  implements Runnable
{
  NowVideoController$2(NowVideoController paramNowVideoController, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (NowVideoController.b(this.this$0) == null) {
      return;
    }
    int i = this.a;
    while (i <= this.b)
    {
      Object localObject = NowVideoController.b(this.this$0).getChildAt(i - this.a);
      if (localObject != null)
      {
        localObject = (PAVideoView)((View)localObject).findViewById(2131446469);
        if ((localObject != null) && (((PAVideoView)localObject).P == 4)) {
          ((PAVideoView)localObject).g();
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoController.2
 * JD-Core Version:    0.7.0.1
 */