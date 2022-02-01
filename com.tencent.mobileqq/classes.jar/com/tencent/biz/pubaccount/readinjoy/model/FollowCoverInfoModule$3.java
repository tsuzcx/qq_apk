package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cooperation.readinjoy.ReadInJoyHelper;

class FollowCoverInfoModule$3
  implements Runnable
{
  public void run()
  {
    Object localObject = ReadInJoyHelper.a(FollowCoverInfoModule.a(this.this$0), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).remove("follow_tab_topic_update_info_exposure");
        ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.3
 * JD-Core Version:    0.7.0.1
 */