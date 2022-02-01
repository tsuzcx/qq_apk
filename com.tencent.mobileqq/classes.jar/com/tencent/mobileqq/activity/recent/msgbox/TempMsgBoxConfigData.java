package com.tencent.mobileqq.activity.recent.msgbox;

import com.tencent.mobileqq.activity.recent.msgbox.config.SessionKey;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TempMsgBoxConfigData
{
  private boolean a;
  private List<SessionKey> b = new ArrayList();
  
  public static TempMsgBoxConfigData a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        TempMsgBoxConfigData localTempMsgBoxConfigData = new TempMsgBoxConfigData();
        paramString = new JSONObject(paramString);
        int i = 0;
        int j = paramString.optInt("msg_box_switch", 0);
        bool = true;
        if (j == 1)
        {
          localTempMsgBoxConfigData.a = bool;
          paramString = paramString.optJSONArray("msg_box_types");
          if (paramString != null)
          {
            ArrayList localArrayList = new ArrayList();
            if (i < paramString.length())
            {
              JSONObject localJSONObject = paramString.getJSONObject(i);
              localArrayList.add(new SessionKey(localJSONObject.optInt("c2c_type"), localJSONObject.optInt("service_type")));
              i += 1;
              continue;
            }
            localTempMsgBoxConfigData.b = localArrayList;
          }
          return localTempMsgBoxConfigData;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("TempMsgBoxConfigData", 2, "TempMsgBoxConfigData parse error", paramString);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public List<SessionKey> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxConfigData
 * JD-Core Version:    0.7.0.1
 */