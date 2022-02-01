package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import oat;
import och;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyVideoSubChannelActivity$11
  implements Runnable
{
  ReadInJoyVideoSubChannelActivity$11(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity, ChannelInfo paramChannelInfo) {}
  
  public void run()
  {
    if (ReadInJoyVideoSubChannelActivity.b(this.this$0) == 6) {}
    for (;;)
    {
      Object localObject;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!this.a.mIsFollowed) {
          break label202;
        }
        String str1 = "1";
        localJSONObject.put("is_followed", str1);
        if (!this.a.mIsTopic) {
          break label208;
        }
        str1 = "0X80088BB";
        if (this.a.mIsTopic)
        {
          localObject = "0X80088BB";
          oat.a(null, "", str1, (String)localObject, 0, 0, "2", "", "", och.a(this.a.mChannelID, localJSONObject), false);
          return;
        }
        localObject = "0X8007BE6";
        continue;
        if (ReadInJoyVideoSubChannelActivity.b(this.this$0) != 8) {
          break label201;
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        return;
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject();
          if (this.a.mIsFollowed)
          {
            String str2 = "1";
            ((JSONObject)localObject).put("is_followed", str2);
            ((JSONObject)localObject).put("channel_id", 409409);
            oat.a(null, "", "0X80088BB", "0X80088BB", 0, 0, "3", "", "", och.a(this.a.mChannelID, (JSONObject)localObject), false);
            return;
          }
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
          return;
        }
        str3 = "0";
      }
      label201:
      return;
      label202:
      String str3 = "0";
      continue;
      label208:
      str3 = "0X8007BE6";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity.11
 * JD-Core Version:    0.7.0.1
 */