package com.tencent.ad.tangram.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.process.AdProcessManager;
import java.io.File;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

class AdExposureListHolder$1
  implements Runnable
{
  AdExposureListHolder$1(AdExposureListHolder paramAdExposureListHolder, Context paramContext) {}
  
  public void run()
  {
    Object localObject = AdExposureListHolder.access$000(this.this$0, this.val$context, AdProcessManager.INSTANCE.getCurrentProcessName(this.val$context));
    if ((localObject != null) && (((File)localObject).exists()))
    {
      localObject = b.read((File)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      if (((JSONArray)localObject).length() > 0)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          AdExposureListHolder.access$100(this.this$0).add(((JSONArray)localObject).get(i).toString());
          i += 1;
        }
      }
      AdLog.i("AdExposureListHolder", "init from file ids :" + AdExposureListHolder.access$100(this.this$0).size());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureListHolder.1
 * JD-Core Version:    0.7.0.1
 */