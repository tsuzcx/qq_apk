package com.tencent.biz.now;

import android.graphics.Rect;
import android.view.View;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.widget.AbsListView;

class NowVideoController$3
  implements Runnable
{
  NowVideoController$3(NowVideoController paramNowVideoController, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (NowVideoController.a(this.this$0) == null) {
      return;
    }
    int i = this.a;
    label16:
    Object localObject;
    if (i <= this.b)
    {
      localObject = NowVideoController.a(this.this$0).getChildAt(i - this.a);
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
      localObject = (PAVideoView)((View)localObject).findViewById(2131378571);
      if ((localObject != null) && (((PAVideoView)localObject).jdField_j_of_type_Int == 4))
      {
        ((PAVideoView)localObject).getGlobalVisibleRect(NowVideoController.a());
        if ((((PAVideoView)localObject).getHeight() == NowVideoController.a().height()) && (NetworkUtil.h(((PAVideoView)localObject).getContext())) && (EcShopAssistantManager.a) && (NowVideoController.a().top > 0) && (!((PAVideoView)localObject).jdField_j_of_type_Boolean)) {
          ((PAVideoView)localObject).f();
        } else {
          ((PAVideoView)localObject).e();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoController.3
 * JD-Core Version:    0.7.0.1
 */