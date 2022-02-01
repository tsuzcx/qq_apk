package com.tencent.biz.pubaccount.weishi_new.util;

import com.tencent.widget.ActionSheet.OnDismissListener;

final class WSFeedUtils$2
  implements ActionSheet.OnDismissListener
{
  WSFeedUtils$2(ActionSheet.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss()
  {
    WSLog.b("WSFeedUtils", "onDismiss entered");
    ActionSheet.OnDismissListener localOnDismissListener = this.a;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils.2
 * JD-Core Version:    0.7.0.1
 */