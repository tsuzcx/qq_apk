package com.tencent.biz.pubaccount.troopbarassit;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bhvy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdc;

public class TroopBarAssistantManager$2
  implements Runnable
{
  public TroopBarAssistantManager$2(sdc paramsdc, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject1 = new JSONArray();
    Object localObject2 = this.this$0.a.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      JSONObject localJSONObject = new JSONObject();
      String str = (String)((Iterator)localObject2).next();
      if ((str != null) && (this.this$0.a.get(str) != null)) {
        try
        {
          localJSONObject.put(str, this.this$0.a.get(str));
          ((JSONArray)localObject1).put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    localObject1 = ((JSONArray)localObject1).toString();
    if (bhvy.b()) {
      QLog.i("TroopBarAssistantManager", 2, "saveNewMsgSet, save newMsgStr into sp:" + (String)localObject1);
    }
    localObject2 = this.a.getApp().getSharedPreferences(this.a.getAccount(), 0).edit();
    ((SharedPreferences.Editor)localObject2).putString("troopbar_assist_new_unread_list", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager.2
 * JD-Core Version:    0.7.0.1
 */