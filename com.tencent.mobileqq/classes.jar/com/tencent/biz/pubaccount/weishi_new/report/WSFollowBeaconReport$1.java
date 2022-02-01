package com.tencent.biz.pubaccount.weishi_new.report;

import UserGrowth.stFriendLikes;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

final class WSFollowBeaconReport$1
  implements Runnable
{
  WSFollowBeaconReport$1(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, stSimpleMetaFeed paramstSimpleMetaFeed, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("index", String.valueOf(this.a));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dynamics_nickname");
    ((StringBuilder)localObject).append(this.a);
    localHashMap.put("position_profile", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dynamics_nickname");
    ((StringBuilder)localObject).append(this.a);
    localHashMap.put("position_nickname", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dynamics_content");
    ((StringBuilder)localObject).append(this.a);
    localHashMap.put("position_content", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dynamics_video");
    ((StringBuilder)localObject).append(this.a);
    localHashMap.put("position_video", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dynamics_more_operations");
    ((StringBuilder)localObject).append(this.a);
    localHashMap.put("position_more_operations", ((StringBuilder)localObject).toString());
    if (this.b)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_close");
      ((StringBuilder)localObject).append(this.a);
      localHashMap.put("position_close", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_follow");
      ((StringBuilder)localObject).append(this.a);
      localHashMap.put("position_follow", ((StringBuilder)localObject).toString());
    }
    if (this.c)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_bottom_label_music");
      ((StringBuilder)localObject).append(this.a);
      localHashMap.put("position_label_music", ((StringBuilder)localObject).toString());
    }
    if (this.d)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_bottom_label_magic");
      ((StringBuilder)localObject).append(this.a);
      localHashMap.put("position_label_magic", ((StringBuilder)localObject).toString());
    }
    if (this.e)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_bottom_label_location");
      ((StringBuilder)localObject).append(this.a);
      localHashMap.put("position_label_location", ((StringBuilder)localObject).toString());
    }
    if (this.f)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_qqgroup");
      ((StringBuilder)localObject).append(this.a);
      localHashMap.put("position_qqgroup", ((StringBuilder)localObject).toString());
    }
    localObject = this.g;
    if ((localObject != null) && (((stSimpleMetaFeed)localObject).friendLikes != null) && (this.g.friendLikes.likeFriends != null) && (this.g.friendLikes.likeFriends.size() > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_friend");
      ((StringBuilder)localObject).append(this.a);
      localHashMap.put("position_friend", ((StringBuilder)localObject).toString());
    }
    stSimpleMetaFeed localstSimpleMetaFeed = this.g;
    String str = "0";
    localObject = str;
    if (localstSimpleMetaFeed != null)
    {
      localObject = str;
      if (WSFeedUtils.a(localstSimpleMetaFeed.poster)) {
        localObject = "1";
      }
    }
    localHashMap.put("is_livenow", localObject);
    WSFollowBeaconReport.a(localHashMap, this.h, this.a);
    WSFollowBeaconReport.b(localHashMap, this.i, this.a);
    WSFollowBeaconReport.a(WSFollowBeaconReport.b("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("dynamics_feed", 0, this.g)).addExtParams(localHashMap), "gzh_exposure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport.1
 * JD-Core Version:    0.7.0.1
 */