package com.tencent.mobileqq.activity.history.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopMemberAddFrdHelper$TroopMemberListConfig
{
  final List<Long> a = new ArrayList(5);
  int b = 0;
  
  public TroopMemberAddFrdHelper$TroopMemberListConfig(String paramString)
  {
    try
    {
      paramString = CfgProcess.a(paramString, "troop_member_list_config");
      if (paramString != null)
      {
        Object localObject = new JSONObject(paramString);
        this.b = ((JSONObject)localObject).optInt("maxTroopMemberSize");
        localObject = ((JSONObject)localObject).optJSONArray("troopClassIdList");
        int i = 0;
        while ((localObject != null) && (i < ((JSONArray)localObject).length()))
        {
          this.a.add(Long.valueOf(((JSONArray)localObject).optLong(i)));
          i += 1;
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.i("TroopMemberAddFrdHelper", 2, String.format("TroopMemberListConfig max: %s, idList: %s, config: %s", new Object[] { Integer.valueOf(this.b), TextUtils.join(",", this.a), paramString }));
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper.TroopMemberListConfig
 * JD-Core Version:    0.7.0.1
 */