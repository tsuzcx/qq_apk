package com.tencent.biz.pubaccount.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

class PublicAccountSearchRecommendManagerImpl$1
  implements Runnable
{
  PublicAccountSearchRecommendManagerImpl$1(PublicAccountSearchRecommendManagerImpl paramPublicAccountSearchRecommendManagerImpl, AppInterface paramAppInterface) {}
  
  public void run()
  {
    Object localObject1 = this.a.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sp_public_account_with_cuin_");
    ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
    localObject1 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    if (localObject1 != null) {
      try
      {
        localObject2 = new JSONArray();
        localObject3 = PublicAccountSearchRecommendManagerImpl.access$000(this.this$0).iterator();
        Object localObject4;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)((Iterator)localObject3).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uin", ((IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)localObject4).a);
          localJSONObject.put("name", ((IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)localObject4).b);
          localJSONObject.put("isPA", ((IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)localObject4).c);
          ((JSONArray)localObject2).put(localJSONObject);
        }
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("recommend_title", PublicAccountSearchRecommendManagerImpl.access$100(this.this$0));
        ((JSONObject)localObject3).put("recommend_cache_time", PublicAccountSearchRecommendManagerImpl.access$200(this.this$0));
        ((JSONObject)localObject3).put("recommend_fetch_time", PublicAccountSearchRecommendManagerImpl.access$300(this.this$0));
        ((JSONObject)localObject3).put("recommend_is_forbidden", PublicAccountSearchRecommendManagerImpl.access$400(this.this$0));
        ((JSONObject)localObject3).put("recommend_content_list", localObject2);
        localObject2 = ((JSONObject)localObject3).toString();
        if (QLog.isColorLevel())
        {
          localObject3 = PublicAccountSearchRecommendManagerImpl.access$500(this.this$0);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("saveRecommendListToLocal->json:");
          ((StringBuilder)localObject4).append((String)localObject2);
          QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
        }
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putString("public_account_search_recommend", (String)localObject2);
        ((SharedPreferences.Editor)localObject1).commit();
        return;
      }
      catch (Exception localException)
      {
        Object localObject3;
        if (QLog.isColorLevel())
        {
          localObject2 = PublicAccountSearchRecommendManagerImpl.access$500(this.this$0);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("saveRecommendListToLocal->error:");
          ((StringBuilder)localObject3).append(localException);
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountSearchRecommendManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */