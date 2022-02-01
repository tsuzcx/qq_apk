package com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator;

import androidx.collection.ArrayMap;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.IChatPieCreator;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.IChatPieCreatorFactory;

public class ChatPieSubTypeCreatorFactory
  implements IChatPieCreatorFactory
{
  private static ChatPieSubTypeCreatorFactory a;
  private final ArrayMap<Integer, IChatPieCreator> b = new ArrayMap();
  
  private ChatPieSubTypeCreatorFactory()
  {
    this.b.put(Integer.valueOf(1), new BusinessCmrTmpChatPieCreator());
    this.b.put(Integer.valueOf(3), new MultiForwardChatPieCreator());
    this.b.put(Integer.valueOf(4), new UpComingMsgChatPieCreator());
  }
  
  public static ChatPieSubTypeCreatorFactory a()
  {
    if (a == null) {
      a = new ChatPieSubTypeCreatorFactory();
    }
    return a;
  }
  
  public IChatPieCreator a(int paramInt)
  {
    return (IChatPieCreator)this.b.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.ChatPieSubTypeCreatorFactory
 * JD-Core Version:    0.7.0.1
 */