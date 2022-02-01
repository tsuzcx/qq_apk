package com.tencent.ilive.interfaces;

import android.content.Intent;
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;

public abstract interface IAudienceRoomPager
{
  public abstract int getCount();
  
  public abstract LiveTemplateFragment getCurrentFragment();
  
  public abstract int getCurrentIndex();
  
  public abstract Intent getIntent();
  
  public abstract int getLastIndex();
  
  public abstract RoomPageActionInterface getRoomPageAction();
  
  public abstract int getScrollDirection();
  
  public abstract int getScrollState();
  
  public abstract int getScrollY();
  
  public abstract void requestDisallowInterceptTouchEvent(boolean paramBoolean);
  
  public abstract void scrollTo(int paramInt1, int paramInt2);
  
  public abstract void setCurrentItem(int paramInt);
  
  public abstract void setScrollForbidden(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.interfaces.IAudienceRoomPager
 * JD-Core Version:    0.7.0.1
 */