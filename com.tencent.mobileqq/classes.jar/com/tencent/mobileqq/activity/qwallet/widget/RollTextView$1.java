package com.tencent.mobileqq.activity.qwallet.widget;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

class RollTextView$1
  implements ViewSwitcher.ViewFactory
{
  RollTextView$1(RollTextView paramRollTextView, boolean paramBoolean) {}
  
  public View makeView()
  {
    localTextView = new TextView(RollTextView.access$100(this.this$0));
    try
    {
      localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      localTextView.setTextSize(0, RollTextView.access$200(this.this$0));
      localTextView.setIncludeFontPadding(false);
      localTextView.setTextColor(RollTextView.access$300(this.this$0));
      if (this.val$isRool) {}
      for (String str = "0";; str = "")
      {
        localTextView.setText(str);
        return localTextView;
      }
      return localTextView;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.RollTextView.1
 * JD-Core Version:    0.7.0.1
 */