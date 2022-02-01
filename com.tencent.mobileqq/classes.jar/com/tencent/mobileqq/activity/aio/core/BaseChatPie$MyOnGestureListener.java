package com.tencent.mobileqq.activity.aio.core;

import agiy;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import aqiq;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$MyOnGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  BaseChatPie$MyOnGestureListener(BaseChatPie paramBaseChatPie) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    this.this$0.onDoubleTap(paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return super.onDown(paramMotionEvent);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    super.onLongPress(paramMotionEvent);
    ((agiy)this.this$0.getHelper(26)).a();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((BaseChatPie.access$1000() == 1) && (!BaseChatPie.access$1100(this.this$0).booleanValue())) {
      if (this.this$0.listView.getCount() != 0) {}
    }
    do
    {
      return false;
      if ((this.this$0.listView != null) && (this.this$0.listView.getLastVisiblePosition() >= this.this$0.listView.getCount() - 1))
      {
        paramMotionEvent1 = new int[2];
        this.this$0.listView.getChildAt(this.this$0.listView.getChildCount() - 1).getLocationOnScreen(paramMotionEvent1);
        int i = paramMotionEvent1[1];
        if (BaseChatPie.access$3600(this.this$0) == i)
        {
          this.this$0.setVivoSetting(1);
          BaseChatPie.access$1102(this.this$0, Boolean.valueOf(true));
          BaseChatPie.access$3602(this.this$0, -1);
        }
        BaseChatPie.access$3602(this.this$0, i);
      }
      if (BaseChatPie.access$3700(this.this$0)) {
        this.this$0.hideAllPanels(true);
      }
    } while (paramFloat2 >= 0.0F);
    this.this$0.isOverScrollTarget = false;
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.tag, 2, "onShowPress");
    }
    this.this$0.hideTroopFCView(false);
    this.this$0.hideAllPanels(true);
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (aqiq)this.this$0.getHelper(50);
    if (paramMotionEvent != null) {
      paramMotionEvent.a(true);
    }
    this.this$0.hideTroopFCView(false);
    this.this$0.hideAllPanels(true);
    if (paramMotionEvent != null) {
      paramMotionEvent.a(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.MyOnGestureListener
 * JD-Core Version:    0.7.0.1
 */