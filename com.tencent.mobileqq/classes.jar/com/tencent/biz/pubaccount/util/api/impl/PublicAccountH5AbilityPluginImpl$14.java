package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$14
  implements ITroopMemberApiClientApi.Callback
{
  PublicAccountH5AbilityPluginImpl$14(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, CallCommentJs paramCallCommentJs, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("action");
    String str;
    Object localObject2;
    int i;
    if ("onCommentSend".equals(localObject1)) {
      try
      {
        localObject1 = paramBundle.getString("commentId", "");
        str = paramBundle.getString("rowKey", "");
        localObject2 = paramBundle.getString("commentContent", "");
        i = paramBundle.getInt("firstLevelComment");
        paramBundle = paramBundle.getString("parentCommentId", "");
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("type", "onCommentSend");
        localJSONObject.put("commentId", localObject1);
        localJSONObject.put("rowKey", str);
        localJSONObject.put("commentContent", localObject2);
        localJSONObject.put("firstLevelComment", i + 1);
        localJSONObject.put("parentCommentID", paramBundle);
        localJSONObject.put("result", "success");
        if (this.a == null) {
          return;
        }
        this.a.a(this.b, localJSONObject);
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    } else if ("onCommentLike".equals(localObject1)) {
      try
      {
        localObject1 = paramBundle.getString("commentId", "");
        str = paramBundle.getString("rowKey", "");
        paramBundle = paramBundle.getString("likeStatus", "");
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("type", "onCommentLike");
        ((JSONObject)localObject2).put("rowKey", str);
        ((JSONObject)localObject2).put("commentId", localObject1);
        ((JSONObject)localObject2).put("likeStatus", paramBundle);
        ((JSONObject)localObject2).put("result", "success");
        if (this.a == null) {
          return;
        }
        this.a.a(this.b, (JSONObject)localObject2);
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    } else if ("onCommentDelete".equals(localObject1)) {
      try
      {
        localObject1 = paramBundle.getString("commentId", "");
        str = paramBundle.getString("rowKey", "");
        i = paramBundle.getInt("totalDeleteCount", 0);
        paramBundle = new JSONObject();
        paramBundle.put("type", "onCommentDelete");
        paramBundle.put("totalDelete", i);
        paramBundle.put("commentID", localObject1);
        paramBundle.put("rowKey", str);
        paramBundle.put("result", "success");
        if (this.a == null) {
          return;
        }
        this.a.a(this.b, paramBundle);
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    } else if ("onPanelClose".equals(localObject1)) {
      try
      {
        paramBundle = paramBundle.getString("rowKey", "");
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("type", "onPanelClose");
        ((JSONObject)localObject1).put("rowKey", paramBundle);
        ((JSONObject)localObject1).put("result", "success");
        if (this.a != null)
        {
          this.a.a(this.b, (JSONObject)localObject1);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.14
 * JD-Core Version:    0.7.0.1
 */