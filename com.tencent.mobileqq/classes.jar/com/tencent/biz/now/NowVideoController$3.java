package com.tencent.biz.now;

import android.graphics.Rect;
import android.view.View;
import bbev;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.widget.AbsListView;
import ndm;
import nqq;

public class NowVideoController$3
  implements Runnable
{
  public NowVideoController$3(ndm paramndm, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (ndm.a(this.this$0) == null) {
      return;
    }
    int i = this.a;
    label16:
    Object localObject;
    if (i <= this.b)
    {
      localObject = ndm.a(this.this$0).getChildAt(i - this.a);
      if (localObject != null) {
        break label52;
      }
    }
    for (;;)
    {
      i += 1;
      break label16;
      break;
      label52:
      localObject = (PAVideoView)((View)localObject).findViewById(2131376577);
      if ((localObject != null) && (((PAVideoView)localObject).j == 4))
      {
        ((PAVideoView)localObject).getGlobalVisibleRect(ndm.a());
        if ((((PAVideoView)localObject).getHeight() == ndm.a().height()) && (bbev.h(((PAVideoView)localObject).getContext())) && (nqq.a) && (ndm.a().top > 0)) {
          ((PAVideoView)localObject).f();
        } else {
          ((PAVideoView)localObject).e();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoController.3
 * JD-Core Version:    0.7.0.1
 */