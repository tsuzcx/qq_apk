package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bkbq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import pfv;

public class FollowCoverInfoModule$4
  implements Runnable
{
  public FollowCoverInfoModule$4(pfv parampfv, HashMap paramHashMap) {}
  
  public void run()
  {
    Object localObject = bkbq.a(pfv.a(this.this$0), true, false);
    JSONObject localJSONObject;
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null) {
        try
        {
          localJSONObject = new JSONObject();
          Iterator localIterator = this.a.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            localJSONObject.put("" + localEntry.getKey(), localEntry.getValue());
            continue;
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    localJSONException.putString("follow_tab_topic_update_info_exposure", localJSONObject.toString());
    bkbq.a(localJSONException, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.4
 * JD-Core Version:    0.7.0.1
 */