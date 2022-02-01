package com.tencent.ilive.interfaces;

import android.content.Intent;
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;
import com.tencent.ilive.commonpages.room.VerticalViewPager;

public abstract interface IAudienceRoomPager
{
  public abstract LiveTemplateFragment getCurrentFragment();
  
  public abstract Intent getIntent();
  
  public abstract int getLastIndex();
  
  public abstract RoomPageActionInterface getRoomPageAction();
  
  public abstract int getScrollDirection();
  
  public abstract int getScrollState();
  
  public abstract VerticalViewPager getViewPager();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.interfaces.IAudienceRoomPager
 * JD-Core Version:    0.7.0.1
 */