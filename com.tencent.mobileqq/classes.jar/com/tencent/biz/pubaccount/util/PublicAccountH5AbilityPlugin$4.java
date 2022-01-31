package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Intent;
import baaw;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import rsv;

public class PublicAccountH5AbilityPlugin$4
  implements Runnable
{
  public PublicAccountH5AbilityPlugin$4(rsv paramrsv, String[] paramArrayOfString) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      int j;
      boolean bool;
      try
      {
        Object localObject2 = new JSONObject(this.a[0]);
        if (QLog.isColorLevel()) {
          QLog.i("PublicAccountH5AbilityPlugin", 2, "showUGCEditPage param json:" + ((JSONObject)localObject2).toString());
        }
        String str2 = ((JSONObject)localObject2).optString("topicId");
        Object localObject1 = ((JSONObject)localObject2).optString("topicName");
        String str3 = ((JSONObject)localObject2).optString("cookie");
        if (((JSONObject)localObject2).optInt("isQuestion", 0) != 1) {
          break label332;
        }
        i = 1;
        if (((JSONObject)localObject2).optInt("isAnswer", 0) != 1) {
          break label337;
        }
        j = 1;
        int k = ((JSONObject)localObject2).optInt("adtag");
        int m = ((JSONObject)localObject2).optInt("ugcPushType");
        try
        {
          str1 = new String(baaw.decode((String)localObject1, 0));
          localObject1 = str1;
        }
        catch (Exception localException)
        {
          String str1;
          localException.printStackTrace();
          continue;
          i = 0;
        }
        str1 = ((JSONObject)localObject2).optString("callback");
        localObject2 = new Intent(this.this$0.a, ReadInJoyDeliverUGCActivity.class);
        ((Intent)localObject2).putExtra("arg_topic_id", str2);
        if (i == 0)
        {
          if (j != 0)
          {
            break label320;
            ((Intent)localObject2).putExtra("support_topic", bool);
            if (i == 0)
            {
              bool = true;
              ((Intent)localObject2).putExtra("support_linkify", bool);
              ((Intent)localObject2).putExtra("arg_topic_name", (String)localObject1);
              ((Intent)localObject2).putExtra("arg_ad_tag", k);
              ((Intent)localObject2).putExtra("arg_callback", str1);
              ((Intent)localObject2).putExtra("arg_ugc_edit_cookie", str3);
              ((Intent)localObject2).putExtra("ugcPushType", m);
              this.this$0.a.startActivityForResult((Intent)localObject2, 114);
            }
          }
          else
          {
            bool = false;
            continue;
          }
          bool = false;
          continue;
        }
        i = 1;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("PublicAccountH5AbilityPlugin", 2, "handleJsRequest: showUGCEditPage", localJSONException);
        return;
      }
      label320:
      if (i == 0)
      {
        bool = true;
        continue;
        label332:
        i = 0;
        continue;
        label337:
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.4
 * JD-Core Version:    0.7.0.1
 */