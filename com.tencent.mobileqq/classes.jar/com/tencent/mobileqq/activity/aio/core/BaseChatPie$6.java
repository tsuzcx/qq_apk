package com.tencent.mobileqq.activity.aio.core;

import afsn;
import aftj;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$6
  implements View.OnLayoutChangeListener
{
  BaseChatPie$6(BaseChatPie paramBaseChatPie) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i = paramInt6 - paramInt2;
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.tag, 2, "onLayoutChange() called with: v = [" + paramView + "], left = [" + paramInt1 + "], top = [" + paramInt2 + "], right = [" + paramInt3 + "], bottom = [" + paramInt4 + "], oldLeft = [" + paramInt5 + "], oldTop = [" + paramInt6 + "], oldRight = [" + paramInt7 + "], oldBottom = [" + paramInt8 + "], scrollY=" + this.this$0.listView.getScrollY() + ", diff=" + i);
    }
    paramInt1 = this.this$0.listView.getBottom() - this.this$0.mInputBar.getTop();
    paramInt3 = 0;
    paramView = (aftj)this.this$0.getHelper(23);
    if ((paramView != null) && (paramView.b()))
    {
      paramInt3 = paramView.a();
      paramInt1 += paramInt3;
    }
    for (;;)
    {
      paramView = (afsn)this.this$0.getHelper(52);
      if ((paramView != null) && (paramView.b()) && (paramInt3 == 0))
      {
        paramInt7 = AIOUtils.dp2px(39.0F, this.this$0.mActivity.getResources());
        paramInt5 = paramInt1 + paramInt7;
      }
      for (paramInt1 = paramInt7;; paramInt1 = paramInt7)
      {
        if ((i != 0) && (paramView != null)) {
          paramView.f();
        }
        BaseChatPie.access$200(this.this$0, paramInt5);
        if (!BaseChatPie.access$300(this.this$0, paramInt2, paramInt4, paramInt6, paramInt8)) {
          break label302;
        }
        label302:
        while (this.this$0.listView.getChildCount() <= 0) {
          return;
        }
        paramInt8 = paramInt2 - paramInt3 - paramInt1;
        paramInt6 = -1;
        paramInt7 = 0;
        paramInt4 = this.this$0.listView.getChildCount() - 1;
        for (;;)
        {
          paramInt5 = paramInt7;
          paramInt2 = paramInt6;
          if (paramInt4 >= 0)
          {
            View localView = this.this$0.listView.getChildAt(paramInt4);
            if ((paramInt8 > localView.getTop()) && (paramInt8 <= localView.getBottom()))
            {
              paramInt2 = this.this$0.listView.getFirstVisiblePosition() + paramInt4;
              paramInt5 = paramInt8 - localView.getBottom();
            }
          }
          else
          {
            if (paramInt2 != -1) {
              break label456;
            }
            if ((paramView == null) || (paramView.c()) || (!paramView.b()) || (paramInt3 != 0)) {
              break;
            }
            paramView.e();
            return;
          }
          paramInt4 -= 1;
        }
        label456:
        this.this$0.listView.setOnMeasureListener(new BaseChatPie.6.1(this, paramView, paramInt3, paramInt2, paramInt1 + (paramInt5 + paramInt3)));
        return;
        paramInt7 = 0;
        paramInt5 = paramInt1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.6
 * JD-Core Version:    0.7.0.1
 */