package com.tencent.mobileqq.activity.aio.core.chatpiecreator;

import androidx.collection.ArrayMap;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;

public class GuildLiveChatPieCreatorFactory
  extends ChatPieCreatorFactory
{
  private static GuildLiveChatPieCreatorFactory b;
  
  private GuildLiveChatPieCreatorFactory()
  {
    this.a.put(Integer.valueOf(10014), (IChatPieCreator)((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildLiveChatPieCreator());
  }
  
  public static GuildLiveChatPieCreatorFactory b()
  {
    if (b == null) {
      b = new GuildLiveChatPieCreatorFactory();
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.chatpiecreator.GuildLiveChatPieCreatorFactory
 * JD-Core Version:    0.7.0.1
 */