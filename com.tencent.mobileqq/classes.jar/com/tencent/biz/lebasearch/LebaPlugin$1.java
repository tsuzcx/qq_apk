package com.tencent.biz.lebasearch;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class LebaPlugin$1
  implements BusinessObserver
{
  LebaPlugin$1(LebaPlugin paramLebaPlugin) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 17)
    {
      if (paramInt != 18) {
        return;
      }
      paramObject = (Bundle)paramObject;
      if (paramObject == null) {
        return;
      }
      paramInt = paramObject.getInt("reqCode");
      String str1;
      if (paramInt == 10000)
      {
        str1 = paramObject.getString("name");
        String str2 = paramObject.getString("callback");
        String str3 = paramObject.getString("msg");
        long l = paramObject.getLong("uiResId");
        paramObject = this.a;
        paramObject.a = str2;
        LebaPlugin.a(paramObject, 1, l, str1, str3);
        return;
      }
      if (paramInt == 10002)
      {
        paramBoolean = paramObject.getBoolean("isOpen");
        str1 = paramObject.getString("callback");
        boolean bool = paramObject.getBoolean("has");
        paramObject = new JSONObject();
        if (bool) {
          if (paramBoolean) {
            paramInt = 1;
          } else {
            paramInt = 0;
          }
        }
        try
        {
          paramObject.put("isOpen", paramInt);
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
        paramObject.put("isOpen", 1);
        if (!TextUtils.isEmpty(str1)) {
          this.a.callJs(str1, new String[] { paramObject.toString() });
        }
      }
    }
    else
    {
      paramObject = new JSONObject();
      if (paramBoolean) {}
      try
      {
        paramObject.put("userOption", 1);
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
      paramObject.put("userOption", 0);
      if (!TextUtils.isEmpty(this.a.a))
      {
        LebaPlugin localLebaPlugin = this.a;
        localLebaPlugin.callJs(localLebaPlugin.a, new String[] { paramObject.toString() });
        this.a.a = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaPlugin.1
 * JD-Core Version:    0.7.0.1
 */