package com.tencent.mobileqq.activity.miniaio;

import android.os.Bundle;

public abstract interface IMiniMsgUnreadCallback
{
  public abstract void destroy();
  
  public abstract void hide();
  
  public abstract void hideUnread();
  
  public abstract boolean show(int paramInt);
  
  public abstract void updateOnBackFromMiniAIO(Bundle paramBundle);
  
  public abstract void updateUnreadCount(int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback
 * JD-Core Version:    0.7.0.1
 */