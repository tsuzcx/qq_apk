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
  public Map<Integer, Boolean> a;
  public boolean a;
  
  public MiniMsgConfigData()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static MiniMsgConfigData a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse.configData : ");
      ((StringBuilder)localObject).append(paramArrayOfQConfItem[0].a);
      QLog.d("mini_msg_config", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new MiniMsgConfigData();
    for (;;)
    {
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].a);
        if (paramArrayOfQConfItem.optInt("allSwitch") == 1)
        {
          bool = true;
          ((MiniMsgConfigData)localObject).jdField_a_of_type_Boolean = bool;
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
            ((MiniMsgConfigData)localObject).jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(k), Boolean.valueOf(bool));
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
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",businessSwitch: ");
    if (this.jdField_a_of_type_JavaUtilMap.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        boolean bool = ((Boolean)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).booleanValue();
        localStringBuilder.append(localInteger);
        localStringBuilder.append("=");
        localStringBuilder.append(bool);
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgConfigData
 * JD-Core Version:    0.7.0.1
 */