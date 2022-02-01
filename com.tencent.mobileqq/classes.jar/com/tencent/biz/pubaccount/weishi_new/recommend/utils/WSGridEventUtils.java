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
    while (i < paramList.size())
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.get(i);
      if (!TextUtils.equals(localstSimpleMetaFeed.id, paramLikeRspEvent.getFeedId()))
      {
        i += 1;
      }
      else
      {
        if (paramLikeRspEvent.getRspIsDing() != localstSimpleMetaFeed.is_ding)
        {
          if (localstSimpleMetaFeed.is_ding == 1) {
            j = 1;
          }
          if (j != 0) {
            localstSimpleMetaFeed.ding_count -= 1;
          } else {
            localstSimpleMetaFeed.ding_count += 1;
          }
        }
        localstSimpleMetaFeed.is_ding = paramLikeRspEvent.getRspIsDing();
        paramWSRecommendAdapter.notifyItemChanged(i);
      }
    }
  }
  
  public static void a(WSAddCommentEvent paramWSAddCommentEvent, List<stSimpleMetaFeed> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WSAddCommentEvent feedId = ");
    ((StringBuilder)localObject).append(paramWSAddCommentEvent.getFeedId());
    ((StringBuilder)localObject).append("; position = ");
    ((StringBuilder)localObject).append(paramWSAddCommentEvent.getPosition());
    ((StringBuilder)localObject).append("; num = ");
    ((StringBuilder)localObject).append(paramWSAddCommentEvent.getCommentNum());
    WSLog.b("WSGridEventUtils", ((StringBuilder)localObject).toString());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (stSimpleMetaFeed)paramList.next();
      if (TextUtils.equals(((stSimpleMetaFeed)localObject).id, paramWSAddCommentEvent.getFeedId())) {
        ((stSimpleMetaFeed)localObject).total_comment_num = ((int)paramWSAddCommentEvent.getCommentNum());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridEventUtils
 * JD-Core Version:    0.7.0.1
 */