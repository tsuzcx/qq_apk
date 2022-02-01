package com.tencent.biz.now;

import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class NowLiveManager$1
  implements HttpWebCgiAsyncTask.Callback
{
  NowLiveManager$1(NowLiveManager paramNowLiveManager) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    NowLiveManager.a(this.a);
    long l = 0L;
    Object localObject1 = "";
    String str;
    if (paramBundle != null)
    {
      l = paramBundle.getLong("time", 0L);
      str = paramBundle.getString("room_id");
      localObject1 = paramBundle.getString("friendUin");
    }
    else
    {
      str = "";
    }
    localObject1 = this.a.a((String)localObject1, l);
    if (paramJSONObject == null)
    {
      NowLiveManager.b(this.a);
      this.a.notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(false), localObject1, paramBundle });
      return;
    }
    if (paramInt != 1001)
    {
      if ((paramInt == 1003) && (paramJSONObject.optInt("retcode") == 0))
      {
        paramJSONObject = paramJSONObject.optJSONObject("result");
        if (paramJSONObject != null)
        {
          ((NowLiveManager.NowLiveInfo)localObject1).jdField_a_of_type_Int = paramJSONObject.optInt("state");
          this.a.notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(true), localObject1, paramBundle });
        }
      }
    }
    else
    {
      Object localObject2 = paramJSONObject.optJSONObject("result");
      if ((localObject2 != null) && (((JSONObject)localObject2).optInt("retcode") == 0))
      {
        paramJSONObject = new ArrayList();
        localObject2 = ((JSONObject)localObject2).optJSONArray("videoURLList");
        if (localObject2 != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            try
            {
              paramJSONObject.add(((JSONArray)localObject2).getString(i));
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
            i += 1;
          }
          ((NowLiveManager.NowLiveInfo)localObject1).jdField_a_of_type_JavaUtilList = paramJSONObject;
          ((NowLiveManager.NowLiveInfo)localObject1).b = str;
        }
        this.a.notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(true), localObject1, paramBundle });
      }
    }
    this.a.notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(false), null, paramBundle });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.now.NowLiveManager.1
 * JD-Core Version:    0.7.0.1
 */