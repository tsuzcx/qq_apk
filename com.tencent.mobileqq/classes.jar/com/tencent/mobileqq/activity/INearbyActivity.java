package com.tencent.mobileqq.activity;

import com.tencent.common.app.AppInterface;

public abstract interface INearbyActivity
{
  public abstract IHotChatFragment getHotChatFragment();
  
  public abstract AppInterface getNearbyAppInterface();
  
  public abstract void updateTitlebar(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.INearbyActivity
 * JD-Core Version:    0.7.0.1
 */