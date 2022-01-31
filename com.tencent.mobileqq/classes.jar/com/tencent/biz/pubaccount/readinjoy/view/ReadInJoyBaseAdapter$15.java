package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import ndn;
import new;
import org.json.JSONException;
import org.json.JSONObject;
import qoe;

public class ReadInJoyBaseAdapter$15
  implements Runnable
{
  public ReadInJoyBaseAdapter$15(qoe paramqoe, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void run()
  {
    if (this.a != null) {
      if (this.this$0.c != 56) {
        break label95;
      }
    }
    label95:
    for (JSONObject localJSONObject = new JSONObject();; localJSONObject = null) {
      try
      {
        localJSONObject.put("algorithm_id", this.a.mAlgorithmID);
        ndn.a(null, "", "0X8008AD1", "0X8008AD1", 0, 0, "", "", "", new.a(this.a.mVideoVid, this.a.innerUniqueID, (int)this.a.mChannelID, localJSONObject), false);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.15
 * JD-Core Version:    0.7.0.1
 */