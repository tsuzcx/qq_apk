package com.tencent.biz.pubaccount.weishi_new.follow;

import UserGrowth.stFriendFeed;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.follow.data.WSFriendItemData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class WSFriendItemDataUtil
{
  private static WSFriendItemData a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSFriendItemData localWSFriendItemData = new WSFriendItemData();
    localWSFriendItemData.a(paramstSimpleMetaFeed);
    return localWSFriendItemData;
  }
  
  public static List<WSFriendItemData> a(stFriendFeed paramstFriendFeed)
  {
    if (paramstFriendFeed == null) {
      return Collections.emptyList();
    }
    paramstFriendFeed = paramstFriendFeed.friendFeeds;
    if ((paramstFriendFeed != null) && (paramstFriendFeed.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(a((stSimpleMetaFeed)paramstFriendFeed.get(0)));
      int i = 1;
      while (i < paramstFriendFeed.size())
      {
        Object localObject = (stSimpleMetaFeed)paramstFriendFeed.get(i);
        WSFriendItemData localWSFriendItemData = (WSFriendItemData)localArrayList.get(localArrayList.size() - 1);
        if (!localWSFriendItemData.a((stSimpleMetaFeed)localObject))
        {
          a(localWSFriendItemData);
          localObject = a((stSimpleMetaFeed)localObject);
          ((WSFriendItemData)localObject).a(i);
          localArrayList.add(localObject);
        }
        i += 1;
      }
      a((WSFriendItemData)localArrayList.get(localArrayList.size() - 1));
      WeiShiCacheManager.a().c(localArrayList);
      return localArrayList;
    }
    return Collections.emptyList();
  }
  
  private static void a(WSFriendItemData paramWSFriendItemData)
  {
    paramWSFriendItemData.a(WeiShiCacheManager.a().a().contains(paramWSFriendItemData.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.WSFriendItemDataUtil
 * JD-Core Version:    0.7.0.1
 */