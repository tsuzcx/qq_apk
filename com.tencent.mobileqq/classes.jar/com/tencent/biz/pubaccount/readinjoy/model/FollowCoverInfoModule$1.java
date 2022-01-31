package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.SharedPreferences;
import android.util.Base64;
import bkbq;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import pfv;
import qnm;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;

public class FollowCoverInfoModule$1
  implements Runnable
{
  public FollowCoverInfoModule$1(pfv parampfv) {}
  
  public void run()
  {
    Object localObject1 = bkbq.a(pfv.a(this.this$0), true, false);
    if (localObject1 != null) {
      try
      {
        pfv.a(this.this$0, ((SharedPreferences)localObject1).getInt("follow_tab_topic_update_info_exists", 0));
        if (pfv.a(this.this$0) == 1)
        {
          Object localObject2 = ((SharedPreferences)localObject1).getString("follow_tab_topic_update_info", null);
          Object localObject3;
          if (localObject2 != null)
          {
            localObject2 = Base64.decode((String)localObject2, 0);
            localObject3 = new articlesummary.TopicRecommendFeedsInfo();
            ((articlesummary.TopicRecommendFeedsInfo)localObject3).mergeFrom((byte[])localObject2);
            pfv.a(this.this$0, qnm.a((articlesummary.TopicRecommendFeedsInfo)localObject3));
          }
          localObject1 = ((SharedPreferences)localObject1).getString("follow_tab_topic_update_info_exposure", null);
          if (localObject1 != null)
          {
            localObject1 = new JSONObject((String)localObject1);
            localObject2 = ((JSONObject)localObject1).keys();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              Long localLong = Long.valueOf(((JSONObject)localObject1).optLong((String)localObject3, 0L));
              if (localLong.longValue() != 0L) {
                pfv.a(this.this$0).put(Long.valueOf((String)localObject3), localLong);
              }
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        pfv.a(this.this$0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.1
 * JD-Core Version:    0.7.0.1
 */