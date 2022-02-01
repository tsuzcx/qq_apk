package com.tencent.biz.pubaccount.weishi_new.util;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class WSFeedUtils$1
  implements ActionSheet.OnButtonClickListener
{
  WSFeedUtils$1(ActionSheet.OnButtonClickListener paramOnButtonClickListener, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clickedView :");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(", which: ");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.b("WSFeedUtils", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null) {
      ((ActionSheet.OnButtonClickListener)localObject).onClick(paramView, paramInt);
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils.1
 * JD-Core Version:    0.7.0.1
 */