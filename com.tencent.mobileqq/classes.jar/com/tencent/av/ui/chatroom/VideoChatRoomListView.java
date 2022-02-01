package com.tencent.av.ui.chatroom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class VideoChatRoomListView
  extends ListView
{
  private VideoChatRoomListView.OnDispatchTouchEventResponseListener a;
  
  public VideoChatRoomListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoChatRoomListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoChatRoomListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    VideoChatRoomListView.OnDispatchTouchEventResponseListener localOnDispatchTouchEventResponseListener = this.a;
    if (localOnDispatchTouchEventResponseListener != null) {
      localOnDispatchTouchEventResponseListener.a(paramMotionEvent, bool);
    }
    return bool;
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  public void setOnDispatchTouchEventResponseListener(VideoChatRoomListView.OnDispatchTouchEventResponseListener paramOnDispatchTouchEventResponseListener)
  {
    this.a = paramOnDispatchTouchEventResponseListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomListView
 * JD-Core Version:    0.7.0.1
 */