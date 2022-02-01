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
  protected PointF a;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  
  protected ChatHistory$HistoryItemOnlongClickListener(ChatHistory paramChatHistory)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  }
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365636) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      a(paramView);
      return false;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131365636, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131690860), 2130839054);
    if (localQQCustomMenu.a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((ChatHistory.Holder)ChatHistory.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      int i = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int j = AIOUtils.a(10.0F, paramView.getResources());
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, (int)this.jdField_a_of_type_AndroidGraphicsPointF.x, i - j, localQQCustomMenu, this, null);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this);
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
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.HistoryItemOnlongClickListener
 * JD-Core Version:    0.7.0.1
 */