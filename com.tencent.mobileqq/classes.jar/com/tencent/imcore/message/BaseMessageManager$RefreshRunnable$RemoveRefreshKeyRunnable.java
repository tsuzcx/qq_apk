package com.tencent.imcore.message;

import java.util.Map;

class BaseMessageManager$RefreshRunnable$RemoveRefreshKeyRunnable
  implements Runnable
{
  private final BaseMessageManager a;
  
  BaseMessageManager$RefreshRunnable$RemoveRefreshKeyRunnable(BaseMessageManager.RefreshRunnable paramRefreshRunnable, BaseMessageManager paramBaseMessageManager)
  {
    this.a = paramBaseMessageManager;
  }
  
  public void run()
  {
    this.a.a.b.remove(BaseMessageManager.RefreshRunnable.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.RefreshRunnable.RemoveRefreshKeyRunnable
 * JD-Core Version:    0.7.0.1
 */