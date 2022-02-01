package com.tencent.mobileqq.apollo.aio.panel;

import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

class ApolloPanelTips$PopupWindowData
{
  WeakReference<View.OnClickListener> a;
  private final View b;
  private final int c;
  private final String d;
  private final int e;
  
  ApolloPanelTips$PopupWindowData(View paramView, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    this.b = paramView;
    this.c = paramInt1;
    this.d = paramString;
    this.e = paramInt2;
    this.a = new WeakReference(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelTips.PopupWindowData
 * JD-Core Version:    0.7.0.1
 */