package com.tencent.biz.now;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.widget.AbsListView;
import nrz;
import ofx;

public class NowVideoController$3
  implements Runnable
{
  public NowVideoController$3(nrz paramnrz, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (nrz.a(this.this$0) == null) {
      return;
    }
    int i = this.a;
    label16:
    Object localObject;
    if (i <= this.b)
    {
      localObject = nrz.a(this.this$0).getChildAt(i - this.a);
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
      localObject = (PAVideoView)((View)localObject).findViewById(2131377864);
      if ((localObject != null) && (((PAVideoView)localObject).jdField_j_of_type_Int == 4))
      {
        ((PAVideoView)localObject).getGlobalVisibleRect(nrz.a());
        if ((((PAVideoView)localObject).getHeight() == nrz.a().height()) && (NetworkUtil.isWifiConnected(((PAVideoView)localObject).getContext())) && (ofx.a) && (nrz.a().top > 0) && (!((PAVideoView)localObject).jdField_j_of_type_Boolean)) {
          ((PAVideoView)localObject).f();
        } else {
          ((PAVideoView)localObject).e();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoController.3
 * JD-Core Version:    0.7.0.1
 */