package com.tencent.mobileqq.activity.miniaio;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.widget.RedWidgetUtil;

public class MiniCustomViewUnreadCallback
  implements IMiniMsgUnreadCallback
{
  private View a;
  private TextView b;
  
  public MiniCustomViewUnreadCallback(View paramView, TextView paramTextView)
  {
    this.a = paramView;
    this.b = paramTextView;
  }
  
  public void destroy()
  {
    this.a = null;
    this.b = null;
  }
  
  public void hide()
  {
    this.a.setVisibility(4);
  }
  
  public void hideUnread()
  {
    TextView localTextView = this.b;
    if (localTextView == null) {
      return;
    }
    localTextView.setVisibility(8);
  }
  
  public boolean show(int paramInt)
  {
    this.a.setVisibility(0);
    updateUnreadCount(paramInt, false);
    return true;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle) {}
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    TextView localTextView = this.b;
    if (localTextView == null) {
      return;
    }
    String str = String.valueOf(paramInt);
    if (paramInt > 99) {
      str = "99+";
    }
    localTextView.setText(str);
    if (!paramBoolean) {
      if (paramInt <= 0) {
        localTextView.setVisibility(8);
      } else {
        localTextView.setVisibility(0);
      }
    }
    RedWidgetUtil.fixTextViewLayout(localTextView, paramInt, 99, 2130852592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniCustomViewUnreadCallback
 * JD-Core Version:    0.7.0.1
 */