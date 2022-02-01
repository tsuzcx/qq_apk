package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import cooperation.readinjoy.ReadInJoyHelper;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;

class FollowCoverInfoModule$2
  implements Runnable
{
  FollowCoverInfoModule$2(FollowCoverInfoModule paramFollowCoverInfoModule, TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo) {}
  
  public void run()
  {
    Object localObject = ReadInJoyHelper.a(FollowCoverInfoModule.a(this.this$0), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        if (this.a != null) {
          break label66;
        }
        ((SharedPreferences.Editor)localObject).remove("follow_tab_topic_update_info");
      }
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).putInt("follow_tab_topic_update_info_exists", FollowCoverInfoModule.a(this.this$0));
      ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
      return;
      label66:
      ((SharedPreferences.Editor)localObject).putString("follow_tab_topic_update_info", Base64.encodeToString(this.a.a().toByteArray(), 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.2
 * JD-Core Version:    0.7.0.1
 */