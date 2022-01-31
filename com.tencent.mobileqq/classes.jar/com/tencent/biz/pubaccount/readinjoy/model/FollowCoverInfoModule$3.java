package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgmq;
import opo;

public class FollowCoverInfoModule$3
  implements Runnable
{
  public FollowCoverInfoModule$3(opo paramopo) {}
  
  public void run()
  {
    Object localObject = bgmq.a(opo.a(this.this$0), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).remove("follow_tab_topic_update_info_exposure");
        bgmq.a((SharedPreferences.Editor)localObject, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.3
 * JD-Core Version:    0.7.0.1
 */