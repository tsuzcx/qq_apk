package com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator;

import androidx.collection.ArrayMap;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.IChatPieCreator;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.IChatPieCreatorFactory;

public class ChatPieSubTypeCreatorFactory
  implements IChatPieCreatorFactory
{
  private static ChatPieSubTypeCreatorFactory jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatpiecreatorChatPieSubTypeCreatorFactory;
  private final ArrayMap<Integer, IChatPieCreator> jdField_a_of_type_AndroidxCollectionArrayMap = new ArrayMap();
  
  private ChatPieSubTypeCreatorFactory()
  {
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1), new BusinessCmrTmpChatPieCreator());
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(3), new MultiForwardChatPieCreator());
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(4), new UpComingMsgChatPieCreator());
  }
  
  public static ChatPieSubTypeCreatorFactory a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatpiecreatorChatPieSubTypeCreatorFactory == null) {
      jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatpiecreatorChatPieSubTypeCreatorFactory = new ChatPieSubTypeCreatorFactory();
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatpiecreatorChatPieSubTypeCreatorFactory;
  }
  
  public IChatPieCreator a(int paramInt)
  {
    return (IChatPieCreator)this.jdField_a_of_type_AndroidxCollectionArrayMap.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.ChatPieSubTypeCreatorFactory
 * JD-Core Version:    0.7.0.1
 */