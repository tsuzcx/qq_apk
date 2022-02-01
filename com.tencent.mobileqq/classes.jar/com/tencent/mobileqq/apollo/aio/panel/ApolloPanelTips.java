package com.tencent.mobileqq.apollo.aio.panel;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import java.util.Deque;
import java.util.LinkedList;

public class ApolloPanelTips
{
  private CalloutPopupWindow a;
  private Deque<ApolloPanelTips.PopupWindowData> b = new LinkedList();
  
  public void a()
  {
    CalloutPopupWindow localCalloutPopupWindow = this.a;
    if (localCalloutPopupWindow != null)
    {
      if (!localCalloutPopupWindow.isShowing()) {
        return;
      }
      this.b.clear();
      this.a.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (paramView != null)
    {
      if (paramString == null) {
        return;
      }
      if (!this.b.isEmpty())
      {
        this.b.addLast(new ApolloPanelTips.PopupWindowData(paramView, paramInt1, paramString, paramInt2, paramOnClickListener));
        return;
      }
      paramString = CalloutPopupWindow.a(paramView.getContext()).b(paramInt2).a(paramString).a(16.0F).a(-1);
      paramString.c(paramInt1);
      this.a = new CalloutPopupWindow.DrawableBuilder(paramString).b(Color.argb(255, 0, 0, 0)).a(5).a().a();
      paramString = this.a;
      if (paramString == null) {
        return;
      }
      paramString.a(82);
      this.a.c(2);
      this.a.a(paramOnClickListener);
      this.a.setOnDismissListener(new ApolloPanelTips.1(this));
      this.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelTips
 * JD-Core Version:    0.7.0.1
 */