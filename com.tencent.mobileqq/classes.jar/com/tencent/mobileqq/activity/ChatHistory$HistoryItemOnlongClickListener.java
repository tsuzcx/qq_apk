package com.tencent.mobileqq.activity;

import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class ChatHistory$HistoryItemOnlongClickListener
  implements View.OnClickListener, OnLongClickAndTouchListener, BubblePopupWindow.OnDismissListener
{
  protected PointF a = new PointF();
  BubblePopupWindow b;
  MessageRecord c;
  
  protected ChatHistory$HistoryItemOnlongClickListener(ChatHistory paramChatHistory) {}
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131431695) {
      this.d.a(this.c);
    }
    this.c = null;
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss()
  {
    this.b = null;
  }
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((BubblePopupWindow)localObject).isShowing()))
    {
      a(paramView);
      return false;
    }
    localObject = new QQCustomMenu();
    ((QQCustomMenu)localObject).a(2131431695, this.d.getString(2131887718), 2130839061);
    if (((QQCustomMenu)localObject).b() > 0)
    {
      this.c = ((ChatHistory.Holder)ChatHistory.a(paramView)).a;
      int i = (int)this.a.y;
      int j = AIOUtils.b(10.0F, paramView.getResources());
      this.b = BubbleContextMenu.a(paramView, (int)this.a.x, i - j, (QQCustomMenu)localObject, this, null);
      this.b.setOnDismissListener(this);
      a(paramView);
      return true;
    }
    a(paramView);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a.x = paramMotionEvent.getRawX();
      this.a.y = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.HistoryItemOnlongClickListener
 * JD-Core Version:    0.7.0.1
 */