package com.tencent.mobileqq.activity.aio.core.chatpiecreator;

import androidx.collection.ArrayMap;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.AppletChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.ArkDebugChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.BusinessCmrTmpChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.ConfessChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.DatalineChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.DeviceMsgChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.GameBuddyChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.GameMsgChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.LimitChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.NearbyChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.PublicAccountChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.QCircleChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.RobotChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.StrangerChatPieCreator;

public class ChatPieCreatorFactory
  implements IChatPieCreatorFactory
{
  private static ChatPieCreatorFactory jdField_a_of_type_ComTencentMobileqqActivityAioCoreChatpiecreatorChatPieCreatorFactory;
  private final ArrayMap<Integer, IChatPieCreator> jdField_a_of_type_AndroidxCollectionArrayMap = new ArrayMap();
  
  private ChatPieCreatorFactory()
  {
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(0), new FriendChatPieCreator());
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1), new TroopChatPieCreator());
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(3000), new DiscussChatPieCreator());
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1038), new AppletChatPieCreator());
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1024), new BusinessCmrTmpChatPieCreator());
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1008), new PublicAccountChatPieCreator());
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(9501), new DeviceMsgChatPieCreator());
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(6000), new DatalineChatPieCreator());
    Object localObject = new StrangerChatPieCreator();
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1000), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(10004), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1020), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1004), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1006), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1003), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1005), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1021), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1022), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1023), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1025), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(7400), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(10010), localObject);
    localObject = new NearbyChatPieCreator();
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1009), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1001), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1010), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(10002), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1031), new ArkDebugChatPieCreator());
    localObject = new ConfessChatPieCreator();
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1033), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1034), localObject);
    localObject = new LimitChatPieCreator();
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1044), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1045), localObject);
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(1043), new RobotChatPieCreator());
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(10007), new GameMsgChatPieCreator());
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(10009), new GameBuddyChatPieCreator());
    this.jdField_a_of_type_AndroidxCollectionArrayMap.put(Integer.valueOf(10008), new QCircleChatPieCreator());
  }
  
  public static ChatPieCreatorFactory a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioCoreChatpiecreatorChatPieCreatorFactory == null) {
      jdField_a_of_type_ComTencentMobileqqActivityAioCoreChatpiecreatorChatPieCreatorFactory = new ChatPieCreatorFactory();
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioCoreChatpiecreatorChatPieCreatorFactory;
  }
  
  public IChatPieCreator a(int paramInt)
  {
    return (IChatPieCreator)this.jdField_a_of_type_AndroidxCollectionArrayMap.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.chatpiecreator.ChatPieCreatorFactory
 * JD-Core Version:    0.7.0.1
 */