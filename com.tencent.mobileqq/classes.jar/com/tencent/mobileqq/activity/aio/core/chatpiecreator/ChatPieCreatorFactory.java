package com.tencent.mobileqq.activity.aio.core.chatpiecreator;

import androidx.collection.ArrayMap;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.AppletChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.ArkDebugChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.BusinessCmrTmpChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.ConfessChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.DatalineChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.DeviceMsgChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.GameMsgChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.KanDianPrivateChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.LimitChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.NearbyChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.PublicAccountChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.QCircleChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.RobotChatPieCreator;
import com.tencent.mobileqq.activity.aio.rebuild.chatpiecreator.StrangerChatPieCreator;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;

public class ChatPieCreatorFactory
  implements IChatPieCreatorFactory
{
  private static ChatPieCreatorFactory b;
  protected final ArrayMap<Integer, IChatPieCreator> a = new ArrayMap();
  
  protected ChatPieCreatorFactory()
  {
    this.a.put(Integer.valueOf(0), new FriendChatPieCreator());
    this.a.put(Integer.valueOf(1), new TroopChatPieCreator());
    this.a.put(Integer.valueOf(3000), new DiscussChatPieCreator());
    this.a.put(Integer.valueOf(1038), new AppletChatPieCreator());
    this.a.put(Integer.valueOf(1024), new BusinessCmrTmpChatPieCreator());
    this.a.put(Integer.valueOf(1008), new PublicAccountChatPieCreator());
    this.a.put(Integer.valueOf(9501), new DeviceMsgChatPieCreator());
    this.a.put(Integer.valueOf(6000), new DatalineChatPieCreator());
    Object localObject = new StrangerChatPieCreator();
    this.a.put(Integer.valueOf(1000), localObject);
    this.a.put(Integer.valueOf(10004), localObject);
    this.a.put(Integer.valueOf(1020), localObject);
    this.a.put(Integer.valueOf(1004), localObject);
    this.a.put(Integer.valueOf(1006), localObject);
    this.a.put(Integer.valueOf(1003), localObject);
    this.a.put(Integer.valueOf(1005), localObject);
    this.a.put(Integer.valueOf(1021), localObject);
    this.a.put(Integer.valueOf(1022), localObject);
    this.a.put(Integer.valueOf(1023), localObject);
    this.a.put(Integer.valueOf(1025), localObject);
    this.a.put(Integer.valueOf(7400), localObject);
    this.a.put(Integer.valueOf(10010), localObject);
    localObject = new NearbyChatPieCreator();
    this.a.put(Integer.valueOf(1009), localObject);
    this.a.put(Integer.valueOf(1001), localObject);
    this.a.put(Integer.valueOf(1010), localObject);
    this.a.put(Integer.valueOf(10002), localObject);
    this.a.put(Integer.valueOf(1031), new ArkDebugChatPieCreator());
    localObject = new ConfessChatPieCreator();
    this.a.put(Integer.valueOf(1033), localObject);
    this.a.put(Integer.valueOf(1034), localObject);
    localObject = new LimitChatPieCreator();
    this.a.put(Integer.valueOf(1044), localObject);
    this.a.put(Integer.valueOf(1045), localObject);
    this.a.put(Integer.valueOf(1043), new RobotChatPieCreator());
    this.a.put(Integer.valueOf(10007), new GameMsgChatPieCreator());
    this.a.put(Integer.valueOf(10008), new QCircleChatPieCreator());
    this.a.put(Integer.valueOf(10014), (IChatPieCreator)((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildChatPieCreator());
    this.a.put(Integer.valueOf(10013), new KanDianPrivateChatPieCreator());
  }
  
  public static ChatPieCreatorFactory a()
  {
    if (b == null) {
      b = new ChatPieCreatorFactory();
    }
    return b;
  }
  
  public IChatPieCreator a(int paramInt)
  {
    return (IChatPieCreator)this.a.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.chatpiecreator.ChatPieCreatorFactory
 * JD-Core Version:    0.7.0.1
 */