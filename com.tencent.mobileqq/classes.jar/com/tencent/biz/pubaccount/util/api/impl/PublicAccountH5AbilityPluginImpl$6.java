package com.tencent.biz.pubaccount.util.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$6
  implements Runnable
{
  PublicAccountH5AbilityPluginImpl$6(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, String[] paramArrayOfString) {}
  
  public void run()
  {
    int i;
    int j;
    label126:
    boolean bool1;
    try
    {
      localObject2 = new JSONObject(this.a[0]);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showUGCEditPage param json:");
        ((StringBuilder)localObject1).append(((JSONObject)localObject2).toString());
        QLog.i("PublicAccountH5AbilityPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      String str3 = ((JSONObject)localObject2).optString("topicId");
      localObject1 = ((JSONObject)localObject2).optString("topicName");
      str4 = ((JSONObject)localObject2).optString("cookie");
      i = ((JSONObject)localObject2).optInt("isQuestion", 0);
      bool2 = true;
      if (i != 1) {
        break label339;
      }
      i = 1;
      if (((JSONObject)localObject2).optInt("isAnswer", 0) != 1) {
        break label344;
      }
      j = 1;
      k = ((JSONObject)localObject2).optInt("adtag");
      m = ((JSONObject)localObject2).optInt("ugcPushType");
      try
      {
        String str1 = new String(Base64Util.decode((String)localObject1, 0));
        localObject1 = str1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      str2 = ((JSONObject)localObject2).optString("callback");
      localObject2 = new Intent(this.this$0.activity, ((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).getReadInJoyDeliverUgcActivityClazz());
      ((Intent)localObject2).putExtra("arg_topic_id", str3);
      if (i != 0) {
        break label354;
      }
      if (j == 0) {
        break label349;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject2;
      Object localObject1;
      String str4;
      boolean bool2;
      int k;
      int m;
      String str2;
      label231:
      QLog.e("PublicAccountH5AbilityPlugin", 2, "handleJsRequest: showUGCEditPage", localJSONException);
      return;
    }
    ((Intent)localObject2).putExtra("support_topic", bool1);
    if (i == 0) {
      bool1 = bool2;
    }
    for (;;)
    {
      ((Intent)localObject2).putExtra("support_linkify", bool1);
      ((Intent)localObject2).putExtra("arg_topic_name", (String)localObject1);
      ((Intent)localObject2).putExtra("arg_ad_tag", k);
      ((Intent)localObject2).putExtra("arg_callback", str2);
      ((Intent)localObject2).putExtra("arg_ugc_edit_cookie", str4);
      ((Intent)localObject2).putExtra("ugcPushType", m);
      this.this$0.activity.startActivityForResult((Intent)localObject2, 114);
      return;
      label339:
      i = 0;
      break;
      label344:
      j = 0;
      break label126;
      label349:
      i = 0;
      break label356;
      label354:
      i = 1;
      label356:
      if (i == 0)
      {
        bool1 = true;
        break label231;
      }
      bool1 = false;
      break label231;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.6
 * JD-Core Version:    0.7.0.1
 */