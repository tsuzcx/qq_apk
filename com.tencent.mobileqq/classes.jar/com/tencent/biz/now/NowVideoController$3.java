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
        if ((localObject != null) && (((PAVideoView)localObject).P == 4))
        {
          ((PAVideoView)localObject).getGlobalVisibleRect(NowVideoController.f());
          if ((((PAVideoView)localObject).getHeight() == NowVideoController.f().height()) && (NetworkUtil.isWifiConnected(((PAVideoView)localObject).getContext())) && (EcShopAssistantManager.t) && (NowVideoController.f().top > 0) && (!((PAVideoView)localObject).G)) {
            ((PAVideoView)localObject).h();
          } else {
            ((PAVideoView)localObject).g();
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoController.3
 * JD-Core Version:    0.7.0.1
 */