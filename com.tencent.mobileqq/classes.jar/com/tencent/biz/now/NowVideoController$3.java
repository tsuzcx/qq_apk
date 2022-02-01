package com.tencent.biz.now;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.widget.AbsListView;
import nza;
import onq;

public class NowVideoController$3
  implements Runnable
{
  public NowVideoController$3(nza paramnza, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (nza.a(this.this$0) == null) {
      return;
    }
    int i = this.a;
    label16:
    Object localObject;
    if (i <= this.b)
    {
      localObject = nza.a(this.this$0).getChildAt(i - this.a);
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
      localObject = (PAVideoView)((View)localObject).findViewById(2131378150);
      if ((localObject != null) && (((PAVideoView)localObject).jdField_j_of_type_Int == 4))
      {
        ((PAVideoView)localObject).getGlobalVisibleRect(nza.a());
        if ((((PAVideoView)localObject).getHeight() == nza.a().height()) && (NetworkUtil.isWifiConnected(((PAVideoView)localObject).getContext())) && (onq.a) && (nza.a().top > 0) && (!((PAVideoView)localObject).jdField_j_of_type_Boolean)) {
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