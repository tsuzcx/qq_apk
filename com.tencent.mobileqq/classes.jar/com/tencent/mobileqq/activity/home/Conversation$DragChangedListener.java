package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import java.util.List;
import mqq.os.MqqHandler;

class Conversation$DragChangedListener
  implements DragFrameLayout.OnDragModeChangedListener
{
  private final int b = -2147483648;
  
  private Conversation$DragChangedListener(Conversation paramConversation) {}
  
  public void a(int paramInt, List<RecentBaseData> paramList) {}
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramDragFrameLayout.getMode() == -1)
    {
      this.a.G.sendEmptyMessage(10);
      FrameHelperActivity.c(true);
      return;
    }
    FrameHelperActivity.c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.DragChangedListener
 * JD-Core Version:    0.7.0.1
 */