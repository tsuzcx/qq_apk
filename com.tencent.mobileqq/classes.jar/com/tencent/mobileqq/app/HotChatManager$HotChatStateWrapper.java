package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotchat.api.IHotChatStateWrapper;
import java.io.Serializable;

public class HotChatManager$HotChatStateWrapper
  implements IHotChatStateWrapper, Serializable
{
  public static final int ACTION_DELETE_SHELL = 3;
  public static final int ACTION_KEEP_RECENT_USER = 2;
  public static final int ACTION_NO = -1;
  public static final int ACTION_PULL_SHELL = 1;
  public static final HotChatStateWrapper STATE_HOT_CHAT_IS_DISBANDED = wrap(7, -1);
  public static final HotChatStateWrapper STATE_HOT_CHAT_LEFT_OVERCOUNT = wrap(9, 3);
  public static final HotChatStateWrapper STATE_KICK_OUT;
  public static final HotChatStateWrapper STATE_LEFT_LONG_TIME_NOT_SAY;
  public static final HotChatStateWrapper STATE_LEFT_NORMAL = wrap(4, -1);
  public static final HotChatStateWrapper STATE_LEFT_NORMAL_ACTION_DELETE_SHELL = wrap(4, 3);
  public int action = -1;
  public int targetState;
  
  static
  {
    STATE_LEFT_LONG_TIME_NOT_SAY = wrap(1, -1);
    STATE_KICK_OUT = wrap(6, -1);
  }
  
  public static HotChatStateWrapper wrap(int paramInt)
  {
    HotChatStateWrapper localHotChatStateWrapper = new HotChatStateWrapper();
    localHotChatStateWrapper.targetState = paramInt;
    return localHotChatStateWrapper;
  }
  
  public static HotChatStateWrapper wrap(int paramInt1, int paramInt2)
  {
    HotChatStateWrapper localHotChatStateWrapper = new HotChatStateWrapper();
    localHotChatStateWrapper.targetState = paramInt1;
    localHotChatStateWrapper.action = paramInt2;
    return localHotChatStateWrapper;
  }
  
  public boolean hasAction()
  {
    return this.action != -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HotChatStateWrapper{targetState=");
    localStringBuilder.append(this.targetState);
    localStringBuilder.append(", action=");
    localStringBuilder.append(this.action);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper
 * JD-Core Version:    0.7.0.1
 */