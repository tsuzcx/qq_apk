package com.tencent.biz.pubaccount.readinjoy.channelCover;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import odq;
import ofe;
import opq;
import org.json.JSONException;
import org.json.JSONObject;

public class ChannelCoverView$2
  implements Runnable
{
  public ChannelCoverView$2(opq paramopq, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("is_followed", "1");
        if (this.a.mIsTopic)
        {
          String str1 = "0X80088BB";
          if (this.a.mIsTopic)
          {
            str3 = "0X80088BB";
            odq.a(null, "", str1, str3, 0, 0, "1", "", "", ofe.a(this.a.mChannelCoverId, localJSONObject), false);
            return;
          }
          String str3 = "0X8007BE6";
          continue;
        }
        String str2 = "0X8007BE6";
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.2
 * JD-Core Version:    0.7.0.1
 */