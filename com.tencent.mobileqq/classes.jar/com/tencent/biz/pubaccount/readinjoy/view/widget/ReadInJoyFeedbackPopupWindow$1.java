package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.widget.QQToast;

class ReadInJoyFeedbackPopupWindow$1
  implements ReadInJoyFeedbackPopupWindow.FeedbackCallback
{
  ReadInJoyFeedbackPopupWindow$1(ReadInJoyFeedbackPopupWindow paramReadInJoyFeedbackPopupWindow) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (ReadInJoyFeedbackPopupWindow.a(this.a) != null)
      {
        paramString = (Animation)ReadInJoyFeedbackPopupWindow.a(this.a).getTag(2131369928);
        paramString.setAnimationListener(new ReadInJoyFeedbackPopupWindow.1.1(this));
        ReadInJoyFeedbackPopupWindow.a(this.a).startAnimation(paramString);
      }
      return;
    }
    QQToast.a(this.a.a, 1, 2131718244, 0).a();
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (paramBoolean)
    {
      ReadInJoyFeedbackPopupWindow.a(this.a).a(ReadInJoyFeedbackPopupWindow.a(this.a), ReadInJoyFeedbackPopupWindow.a(this.a, paramInt), this.a.a, "", "", paramString2, "", 0, "");
      return;
    }
    QQToast.a(this.a.a, 1, 2131718248, 0).a();
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (ReadInJoyFeedbackPopupWindow.a(this.a) != null)
      {
        paramString = (Animation)ReadInJoyFeedbackPopupWindow.a(this.a).getTag(2131369928);
        paramString.setAnimationListener(new ReadInJoyFeedbackPopupWindow.1.2(this));
        ReadInJoyFeedbackPopupWindow.a(this.a).startAnimation(paramString);
      }
      return;
    }
    QQToast.a(this.a.a, 1, 2131718250, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */