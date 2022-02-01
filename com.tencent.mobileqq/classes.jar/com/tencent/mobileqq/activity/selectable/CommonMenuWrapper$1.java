package com.tencent.mobileqq.activity.selectable;

import android.app.Activity;
import android.view.View;
import com.tencent.widget.BubblePopupWindow;

class CommonMenuWrapper$1
  implements Runnable
{
  CommonMenuWrapper$1(CommonMenuWrapper paramCommonMenuWrapper, Activity paramActivity, View paramView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (!((Activity)localObject).isFinishing()) {
        CommonMenuWrapper.a(this.this$0).showAtLocation(this.b, this.c, this.d, true);
      }
    }
    else
    {
      localObject = this.b.getContext();
      if (((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
        CommonMenuWrapper.a(this.this$0).showAtLocation(this.b, this.c, this.d, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonMenuWrapper.1
 * JD-Core Version:    0.7.0.1
 */