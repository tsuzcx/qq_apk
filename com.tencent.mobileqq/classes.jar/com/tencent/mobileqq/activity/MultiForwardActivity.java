package com.tencent.mobileqq.activity;

import afcw;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class MultiForwardActivity
  extends ChatActivity
{
  public afcw a = new afcw();
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    this.a.a(this);
    return bool;
  }
  
  public void doOnDestroy()
  {
    Object localObject = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {}
    for (localObject = ((ChatFragment)localObject).a();; localObject = null)
    {
      if (localObject != null) {
        ((BaseChatPie)localObject).H();
      }
      this.a.c(this);
      super.doOnDestroy();
      return;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.a.b(this);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MultiForwardActivity
 * JD-Core Version:    0.7.0.1
 */