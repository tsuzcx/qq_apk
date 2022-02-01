package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow.FeedbackCallback;
import com.tencent.mobileqq.widget.QQToast;

class OnShareClickListener$ItemSheetClickProcessor$1
  implements ReadInJoyFeedbackPopupWindow.FeedbackCallback
{
  OnShareClickListener$ItemSheetClickProcessor$1(OnShareClickListener.ItemSheetClickProcessor paramItemSheetClickProcessor) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if ((paramBoolean) && ((OnShareClickListener.a(this.a.a) instanceof Activity)))
    {
      if (OnShareClickListener.a(this.a.a) == null) {
        OnShareClickListener.a(this.a.a, new FastWebShareUtils());
      }
      if (OnShareClickListener.a(this.a.a) != -1) {}
      for (paramInt = OnShareClickListener.a(this.a.a);; paramInt = OnShareClickListener.ItemSheetClickProcessor.a(this.a, paramInt))
      {
        OnShareClickListener.a(this.a.a).a(OnShareClickListener.ItemSheetClickProcessor.a(this.a), paramInt, (Activity)OnShareClickListener.a(this.a.a), "", "", paramString2, OnShareClickListener.a(this.a.a), OnShareClickListener.b(this.a.a), OnShareClickListener.b(this.a.a));
        OnShareClickListener.a(this.a.a, "");
        OnShareClickListener.a(this.a.a, 0);
        OnShareClickListener.b(this.a.a, "");
        OnShareClickListener.b(this.a.a, -1);
        return;
      }
    }
    QQToast.a(OnShareClickListener.a(this.a.a), 1, 2131718248, 0).a();
  }
  
  public void b(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnShareClickListener.ItemSheetClickProcessor.1
 * JD-Core Version:    0.7.0.1
 */