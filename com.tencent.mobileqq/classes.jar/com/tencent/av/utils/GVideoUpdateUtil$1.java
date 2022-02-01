package com.tencent.av.utils;

import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class GVideoUpdateUtil$1
  implements HttpWebCgiAsyncTask.Callback
{
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.a.dismiss();
    if (paramInt != 2134) {
      return;
    }
    if (paramJSONObject != null) {
      try
      {
        Object localObject = paramJSONObject.getJSONObject("data");
        boolean bool = ((JSONObject)localObject).getBoolean("update");
        if (bool)
        {
          paramBundle = ((JSONObject)localObject).getString("title");
          localObject = ((JSONObject)localObject).getString("tips");
          GVideoUpdateUtil.a(this.b, paramBundle, (String)localObject, this.c, this.d);
        }
        else
        {
          this.d.a(this.b, this.c);
          paramBundle = null;
          localObject = paramBundle;
        }
        GVideoUpdateUtil.Record localRecord = (GVideoUpdateUtil.Record)GVideoUpdateUtil.a.get(this.c);
        if (localRecord == null)
        {
          localRecord = new GVideoUpdateUtil.Record();
          localRecord.a(System.currentTimeMillis(), paramBundle, (String)localObject, bool);
          GVideoUpdateUtil.a.put(this.c, localRecord);
          return;
        }
        localRecord.a(System.currentTimeMillis(), paramBundle, (String)localObject, bool);
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        paramJSONObject.optInt("errCode");
        GVideoUpdateUtil.a(this.b, this.c, this.d);
        return;
      }
    }
    GVideoUpdateUtil.a(this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.GVideoUpdateUtil.1
 * JD-Core Version:    0.7.0.1
 */