package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import bnrf;
import ppn;
import qzb;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;

public class FollowCoverInfoModule$2
  implements Runnable
{
  public FollowCoverInfoModule$2(ppn paramppn, qzb paramqzb) {}
  
  public void run()
  {
    Object localObject = bnrf.a(ppn.a(this.this$0), true, false);
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
      ((SharedPreferences.Editor)localObject).putInt("follow_tab_topic_update_info_exists", ppn.a(this.this$0));
      bnrf.a((SharedPreferences.Editor)localObject, true);
      return;
      label66:
      ((SharedPreferences.Editor)localObject).putString("follow_tab_topic_update_info", Base64.encodeToString(this.a.a().toByteArray(), 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.2
 * JD-Core Version:    0.7.0.1
 */