package com.tencent.mobileqq.app.proxy;

public class ProxyObserver
{
  public static final int EVENT_NONE = -1;
  public static final int EVENT_SAVE_DB_ERROR = 1001;
  public static final int EVENT_SAVE_DB_FINISH = 1000;
  public static final int EVENT_UPDATA_FRIEND_INFO = 2001;
  public static final int EVENT_UPDATA_TROOP_MEMBER = 2000;
  
  public void notifyEvent(int paramInt)
  {
    if (paramInt != 1000)
    {
      if (paramInt != 2000) {
        return;
      }
      onProxyUpdataTroopMember();
      return;
    }
    onProxySaveToDbFinished();
  }
  
  public void onProxySaveToDbError() {}
  
  public void onProxySaveToDbFinished() {}
  
  public void onProxyUpdataTroopMember() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ProxyObserver
 * JD-Core Version:    0.7.0.1
 */