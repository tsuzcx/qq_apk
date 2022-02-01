package com.tencent.biz.pubaccount.weishi_new.recommend.utils;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.Iterator;
import java.util.List;

public class WSGridEventUtils
{
  public static void a(FollowEvent paramFollowEvent, List<stSimpleMetaFeed> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
      if ((localstSimpleMetaFeed.poster != null) && (TextUtils.equals(localstSimpleMetaFeed.poster.id, paramFollowEvent.getPersonId()))) {
        localstSimpleMetaFeed.poster.followStatus = paramFollowEvent.getIsFollow();
      }
    }
  }
  
  public static void a(LikeRspEvent paramLikeRspEvent, WSRecommendAdapter paramWSRecommendAdapter, List<stSimpleMetaFeed> paramList)
  {
    int j = 0;
    int i = 0;
    stSimpleMetaFeed localstSimpleMetaFeed;
    for (;;)
    {
      if (i < paramList.size())
      {
        localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.get(i);
        if (!TextUtils.equals(localstSimpleMetaFeed.id, paramLikeRspEvent.getFeedId()))
        {
          i += 1;
        }
        else if (paramLikeRspEvent.getRspIsDing() != localstSimpleMetaFeed.is_ding)
        {
          if (localstSimpleMetaFeed.is_ding == 1) {
            j = 1;
          }
          if (j == 0) {
            break label105;
          }
        }
      }
    }
    label105:
    for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
    {
      localstSimpleMetaFeed.is_ding = paramLikeRspEvent.getRspIsDing();
      paramWSRecommendAdapter.notifyItemChanged(i);
      return;
    }
  }
  
  public static void a(WSAddCommentEvent paramWSAddCommentEvent, List<stSimpleMetaFeed> paramList)
  {
    WSLog.b("WSGridEventUtils", "WSAddCommentEvent feedId = " + paramWSAddCommentEvent.getFeedId() + "; position = " + paramWSAddCommentEvent.getPosition() + "; num = " + paramWSAddCommentEvent.getCommentNum());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
      if (TextUtils.equals(localstSimpleMetaFeed.id, paramWSAddCommentEvent.getFeedId())) {
        localstSimpleMetaFeed.total_comment_num = ((int)paramWSAddCommentEvent.getCommentNum());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridEventUtils
 * JD-Core Version:    0.7.0.1
 */