package com.tencent.biz.now;

import android.graphics.Rect;
import android.view.View;
import bdin;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.widget.AbsListView;
import ngf;
import ntw;

public class NowVideoController$3
  implements Runnable
{
  public NowVideoController$3(ngf paramngf, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (ngf.a(this.this$0) == null) {
      return;
    }
    int i = this.a;
    label16:
    Object localObject;
    if (i <= this.b)
    {
      localObject = ngf.a(this.this$0).getChildAt(i - this.a);
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
      localObject = (PAVideoView)((View)localObject).findViewById(2131377133);
      if ((localObject != null) && (((PAVideoView)localObject).j == 4))
      {
        ((PAVideoView)localObject).getGlobalVisibleRect(ngf.a());
        if ((((PAVideoView)localObject).getHeight() == ngf.a().height()) && (bdin.h(((PAVideoView)localObject).getContext())) && (ntw.a) && (ngf.a().top > 0)) {
          ((PAVideoView)localObject).f();
        } else {
          ((PAVideoView)localObject).e();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoController.3
 * JD-Core Version:    0.7.0.1
 */