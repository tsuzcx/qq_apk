package com.tencent.mobileqq.apollo.aio.panel;

import android.view.View.OnClickListener;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.ref.WeakReference;
import java.util.Deque;

class ApolloPanelTips$1
  implements PopupWindow.OnDismissListener
{
  ApolloPanelTips$1(ApolloPanelTips paramApolloPanelTips) {}
  
  public void onDismiss()
  {
    ApolloPanelTips.a(this.a, null);
    if (ApolloPanelTips.a(this.a).size() == 0) {
      return;
    }
    ApolloPanelTips.PopupWindowData localPopupWindowData = (ApolloPanelTips.PopupWindowData)ApolloPanelTips.a(this.a).poll();
    if (localPopupWindowData == null) {
      return;
    }
    View.OnClickListener localOnClickListener = (View.OnClickListener)localPopupWindowData.a.get();
    this.a.a(ApolloPanelTips.PopupWindowData.a(localPopupWindowData), ApolloPanelTips.PopupWindowData.b(localPopupWindowData), ApolloPanelTips.PopupWindowData.c(localPopupWindowData), ApolloPanelTips.PopupWindowData.d(localPopupWindowData), localOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelTips.1
 * JD-Core Version:    0.7.0.1
 */