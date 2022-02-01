package com.tencent.mobileqq.activity.aio.core.impl;

import com.tencent.mobileqq.activity.aio.core.ChatPieCache;
import com.tencent.mobileqq.activity.aio.core.IChatPieCacheService;
import mqq.app.AppRuntime;

public class ChatPieCacheServiceImpl
  implements IChatPieCacheService
{
  private ChatPieCache chatPieCache;
  
  public ChatPieCache getChatPieCache()
  {
    return this.chatPieCache;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.chatPieCache = new ChatPieCache();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.impl.ChatPieCacheServiceImpl
 * JD-Core Version:    0.7.0.1
 */