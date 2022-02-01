package com.tencent.mobileqq.activity.miniaio;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class MiniMsgConfigData
{
  public boolean a = true;
  public Map<Integer, Boolean> b = new HashMap();
  
  public static MiniMsgConfigData a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse.configData : ");
      ((StringBuilder)localObject).append(paramArrayOfQConfItem[0].b);
      QLog.d("mini_msg_config", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new MiniMsgConfigData();
    for (;;)
    {
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].b);
        if (paramArrayOfQConfItem.optInt("allSwitch") == 1)
        {
          bool = true;
          ((MiniMsgConfigData)localObject).a = bool;
          paramArrayOfQConfItem = paramArrayOfQConfItem.optJSONArray("business");
          int j = paramArrayOfQConfItem.length();
          int i = 0;
          if (i < j)
          {
            JSONObject localJSONObject = (JSONObject)paramArrayOfQConfItem.get(i);
            int k = localJSONObject.optInt("id");
            if (localJSONObject.optInt("switch") != 1) {
              break label187;
            }
            bool = true;
            ((MiniMsgConfigData)localObject).b.put(Integer.valueOf(k), Boolean.valueOf(bool));
            i += 1;
            continue;
          }
          return localObject;
        }
      }
      catch (Exception paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
      }
      boolean bool = false;
      continue;
      label187:
      bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("allSwitch = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",businessSwitch: ");
    if (this.b.size() > 0)
    {
      Iterator localIterator = this.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        boolean bool = ((Boolean)this.b.get(localInteger)).booleanValue();
        localStringBuilder.append(localInteger);
        localStringBuilder.append("=");
        localStringBuilder.append(bool);
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgConfigData
 * JD-Core Version:    0.7.0.1
 */