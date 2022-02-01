package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.AssertUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ValueBean$ValueNode
{
  Object styleDynamicValue;
  
  public ValueBean$ValueNode(Object paramObject)
  {
    this.styleDynamicValue = paramObject;
  }
  
  private Object createJsonType(Object paramObject)
  {
    if ((paramObject instanceof JSONObject)) {
      return new JSONObject();
    }
    if ((paramObject instanceof JSONArray)) {
      return new JSONArray();
    }
    return null;
  }
  
  private String getDynamicValue(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("${");
    localStringBuilder.append(paramString);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private boolean isDynamicInString(String paramString1, String paramString2)
  {
    return paramString2.contains(getDynamicValue(paramString1));
  }
  
  private boolean isDynamicValue(String paramString1, String paramString2)
  {
    if (!paramString1.equals(paramString2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("$");
      localStringBuilder.append(paramString1);
      if (!localStringBuilder.toString().equals(paramString2)) {
        return false;
      }
    }
    return true;
  }
  
  private String replace$Value(String paramString1, String paramString2, Object paramObject)
  {
    return paramString1.replace(getDynamicValue(paramString2), String.valueOf(paramObject));
  }
  
  private boolean setTrueValue(Object paramObject1, Object paramObject2, String paramString, Object paramObject3)
  {
    boolean bool3 = paramObject1 instanceof JSONArray;
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (bool3)
    {
      localObject1 = (JSONArray)paramObject1;
      localObject2 = (JSONArray)paramObject2;
      for (bool2 = false; i < ((JSONArray)localObject1).length(); bool2 = bool1)
      {
        try
        {
          localObject3 = ((JSONArray)localObject1).get(i);
          if ((localObject3 instanceof String))
          {
            paramObject1 = (String)localObject3;
            if (isDynamicValue(paramString, (String)localObject3))
            {
              ((JSONArray)localObject2).put(i, paramObject3);
              break label484;
            }
            if (isDynamicInString(paramString, paramObject1))
            {
              ((JSONArray)localObject2).put(i, replace$Value(paramObject1, paramString, paramObject3));
              break label484;
            }
            bool1 = bool2;
            if (((JSONArray)localObject2).length() <= i)
            {
              ((JSONArray)localObject2).put(i, localObject3);
              bool1 = bool2;
            }
          }
          else
          {
            paramObject1 = null;
            if (i < ((JSONArray)localObject2).length()) {
              paramObject1 = ((JSONArray)localObject2).get(i);
            }
            paramObject2 = paramObject1;
            if (paramObject1 == null) {
              paramObject2 = createJsonType(localObject3);
            }
            ((JSONArray)localObject2).put(i, paramObject2);
            bool1 = setTrueValue(localObject3, paramObject2, paramString, paramObject3);
            bool1 = bool2 | bool1;
          }
        }
        catch (JSONException paramObject1)
        {
          LogUtil.QLog.e("ValueBean", 2, "setTrueValue: ", paramObject1);
          bool1 = bool2;
        }
        i += 1;
      }
      return bool2;
    }
    else if ((paramObject1 instanceof JSONObject))
    {
      localObject1 = (JSONObject)paramObject1;
      localObject2 = (JSONObject)paramObject2;
      localObject3 = ((JSONObject)localObject1).keys();
    }
    for (;;)
    {
      bool2 = bool1;
      if (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        try
        {
          Object localObject4 = ((JSONObject)localObject1).get(str);
          if ((localObject4 instanceof String))
          {
            paramObject1 = (String)localObject4;
            if (isDynamicValue(paramString, paramObject1))
            {
              ((JSONObject)localObject2).put(str, paramObject3);
              break label490;
            }
            if (isDynamicInString(paramString, paramObject1))
            {
              ((JSONObject)localObject2).put(str, replace$Value(paramObject1, paramString, paramObject3));
              break label490;
            }
            if (((JSONObject)localObject2).has(str)) {
              continue;
            }
            ((JSONObject)localObject2).put(str, localObject4);
            continue;
          }
          if ((localObject4 instanceof Integer))
          {
            ((JSONObject)localObject2).put(str, localObject4);
            continue;
          }
          paramObject2 = ((JSONObject)localObject2).opt(str);
          paramObject1 = paramObject2;
          if (paramObject2 == null)
          {
            paramObject1 = createJsonType(localObject4);
            ((JSONObject)localObject2).put(str, paramObject1);
          }
          bool2 = setTrueValue(localObject4, paramObject1, paramString, paramObject3);
          bool1 |= bool2;
        }
        catch (JSONException paramObject1)
        {
          LogUtil.QLog.e("ValueBean", 2, "setTrueValue: ", paramObject1);
        }
      }
      else
      {
        return bool2;
        label484:
        bool1 = true;
        break;
        label490:
        bool1 = true;
      }
    }
  }
  
  public void setTrueValue(Map<String, Object> paramMap, String paramString1, String paramString2, Object paramObject)
  {
    Object localObject1 = this.styleDynamicValue;
    boolean bool;
    if ((localObject1 instanceof String))
    {
      if (isDynamicValue(paramString2, (String)localObject1))
      {
        bool = true;
      }
      else
      {
        bool = false;
        paramObject = null;
      }
    }
    else
    {
      Object localObject2 = paramMap.get(paramString1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = createJsonType(this.styleDynamicValue);
      }
      bool = setTrueValue(this.styleDynamicValue, localObject1, paramString2, paramObject);
      paramObject = localObject1;
    }
    if ((bool) && (paramMap != null)) {
      paramMap.put(paramString1, paramObject);
    }
    if (AssertUtil.isDebugVersion()) {
      AssertUtil.assertInValidAttributesBinding(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean.ValueNode
 * JD-Core Version:    0.7.0.1
 */