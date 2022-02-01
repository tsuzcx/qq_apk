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
    localHashMap.put("position_profile", "dynamics_nickname" + this.jdField_a_of_type_Int);
    localHashMap.put("position_nickname", "dynamics_nickname" + this.jdField_a_of_type_Int);
    localHashMap.put("position_content", "dynamics_content" + this.jdField_a_of_type_Int);
    localHashMap.put("position_video", "dynamics_video" + this.jdField_a_of_type_Int);
    localHashMap.put("position_more_operations", "dynamics_more_operations" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      localHashMap.put("position_close", "dynamics_close" + this.jdField_a_of_type_Int);
      localHashMap.put("position_follow", "dynamics_follow" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_b_of_type_Boolean) {
      localHashMap.put("position_label_music", "dynamics_bottom_label_music" + this.jdField_a_of_type_Int);
    }
    if (this.c) {
      localHashMap.put("position_label_magic", "dynamics_bottom_label_magic" + this.jdField_a_of_type_Int);
    }
    if (this.d) {
      localHashMap.put("position_label_location", "dynamics_bottom_label_location" + this.jdField_a_of_type_Int);
    }
    if (this.e) {
      localHashMap.put("position_qqgroup", "dynamics_qqgroup" + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.friendLikes != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.friendLikes.likeFriends != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.friendLikes.likeFriends.size() > 0)) {
      localHashMap.put("position_friend", "dynamics_friend" + this.jdField_a_of_type_Int);
    }
    String str = "0";
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) {
      if (!WSFeedUtils.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster)) {
        break label568;
      }
    }
    label568:
    for (str = "1";; str = "0")
    {
      localHashMap.put("is_livenow", str);
      WSFollowBeaconReport.a(localHashMap, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
      WSFollowBeaconReport.b(localHashMap, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
      WSFollowBeaconReport.a(WSFollowBeaconReport.a("focus").addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("dynamics_feed", 0, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed)).addExtParams(localHashMap), "gzh_exposure");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport.1
 * JD-Core Version:    0.7.0.1
 */