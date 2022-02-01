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
    localHashMap.put("index", String.valueOf(this.jdField_a_of_type_Int));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dynamics_nickname");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    localHashMap.put("position_profile", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dynamics_nickname");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    localHashMap.put("position_nickname", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dynamics_content");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    localHashMap.put("position_content", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dynamics_video");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    localHashMap.put("position_video", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dynamics_more_operations");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    localHashMap.put("position_more_operations", ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_close");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      localHashMap.put("position_close", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_follow");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      localHashMap.put("position_follow", ((StringBuilder)localObject).toString());
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_bottom_label_music");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      localHashMap.put("position_label_music", ((StringBuilder)localObject).toString());
    }
    if (this.c)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_bottom_label_magic");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      localHashMap.put("position_label_magic", ((StringBuilder)localObject).toString());
    }
    if (this.d)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_bottom_label_location");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      localHashMap.put("position_label_location", ((StringBuilder)localObject).toString());
    }
    if (this.e)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_qqgroup");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      localHashMap.put("position_qqgroup", ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    if ((localObject != null) && (((stSimpleMetaFeed)localObject).friendLikes != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.friendLikes.likeFriends != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.friendLikes.likeFriends.size() > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dynamics_friend");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      localHashMap.put("position_friend", ((StringBuilder)localObject).toString());
    }
    stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
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
    WSFollowBeaconReport.a(localHashMap, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
    WSFollowBeaconReport.b(localHashMap, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
    WSFollowBeaconReport.a(WSFollowBeaconReport.a("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("dynamics_feed", 0, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed)).addExtParams(localHashMap), "gzh_exposure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport.1
 * JD-Core Version:    0.7.0.1
 */