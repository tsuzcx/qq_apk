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
    return "${" + paramString + "}";
  }
  
  private boolean isDynamicInString(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (paramString2.contains(getDynamicValue(paramString1))) {
      bool = true;
    }
    return bool;
  }
  
  private boolean isDynamicValue(String paramString1, String paramString2)
  {
    return (paramString1.equals(paramString2)) || (("$" + paramString1).equals(paramString2));
  }
  
  private String replace$Value(String paramString1, String paramString2, Object paramObject)
  {
    return paramString1.replace(getDynamicValue(paramString2), String.valueOf(paramObject));
  }
  
  private boolean setTrueValue(Object paramObject1, Object paramObject2, String paramString, Object paramObject3)
  {
    Object localObject1;
    Object localObject2;
    int i;
    boolean bool2;
    Object localObject3;
    if ((paramObject1 instanceof JSONArray))
    {
      localObject1 = (JSONArray)paramObject1;
      localObject2 = (JSONArray)paramObject2;
      i = 0;
      bool1 = false;
      bool2 = bool1;
      if (i < ((JSONArray)localObject1).length())
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
              bool2 = true;
            }
            else if (isDynamicInString(paramString, paramObject1))
            {
              ((JSONArray)localObject2).put(i, replace$Value(paramObject1, paramString, paramObject3));
              bool2 = true;
            }
            else
            {
              bool2 = bool1;
              if (((JSONArray)localObject2).length() <= i)
              {
                ((JSONArray)localObject2).put(i, localObject3);
                bool2 = bool1;
              }
            }
          }
        }
        catch (JSONException paramObject1)
        {
          LogUtil.QLog.e("ValueBean", 2, "setTrueValue: ", paramObject1);
          break label469;
        }
        paramObject1 = null;
        if (i < ((JSONArray)localObject2).length()) {
          paramObject1 = ((JSONArray)localObject2).get(i);
        }
        paramObject2 = paramObject1;
        if (paramObject1 == null) {
          paramObject2 = createJsonType(localObject3);
        }
        ((JSONArray)localObject2).put(i, paramObject2);
        bool2 = setTrueValue(localObject3, paramObject2, paramString, paramObject3);
        bool2 = bool1 | bool2;
        break label465;
      }
    }
    else
    {
      if (!(paramObject1 instanceof JSONObject)) {
        break label463;
      }
      localObject1 = (JSONObject)paramObject1;
      localObject2 = (JSONObject)paramObject2;
      localObject3 = ((JSONObject)localObject1).keys();
    }
    label463:
    label465:
    label469:
    label482:
    for (boolean bool1 = false;; bool1 = bool2) {
      if (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        Object localObject4;
        try
        {
          localObject4 = ((JSONObject)localObject1).get(str);
          if ((localObject4 instanceof String))
          {
            paramObject1 = (String)localObject4;
            if (isDynamicValue(paramString, paramObject1))
            {
              ((JSONObject)localObject2).put(str, paramObject3);
              bool2 = true;
            }
            else if (isDynamicInString(paramString, paramObject1))
            {
              ((JSONObject)localObject2).put(str, replace$Value(paramObject1, paramString, paramObject3));
              bool2 = true;
            }
            else
            {
              bool2 = bool1;
              if (!((JSONObject)localObject2).has(str))
              {
                ((JSONObject)localObject2).put(str, localObject4);
                bool2 = bool1;
              }
            }
          }
        }
        catch (JSONException paramObject1)
        {
          LogUtil.QLog.e("ValueBean", 2, "setTrueValue: ", paramObject1);
          break label482;
        }
        paramObject2 = ((JSONObject)localObject2).opt(str);
        paramObject1 = paramObject2;
        if (paramObject2 == null)
        {
          paramObject1 = createJsonType(localObject4);
          ((JSONObject)localObject2).put(str, paramObject1);
        }
        bool2 = setTrueValue(localObject4, paramObject1, paramString, paramObject3);
        bool2 = bool1 | bool2;
      }
      else
      {
        bool2 = bool1;
        return bool2;
        return false;
        bool1 = bool2;
        i += 1;
        break;
      }
    }
  }
  
  public void setTrueValue(Map<String, Object> paramMap, String paramString1, String paramString2, Object paramObject)
  {
    boolean bool;
    if ((this.styleDynamicValue instanceof String))
    {
      if (!isDynamicValue(paramString2, (String)this.styleDynamicValue)) {
        break label108;
      }
      bool = true;
    }
    for (;;)
    {
      if ((bool) && (paramMap != null)) {
        paramMap.put(paramString1, paramObject);
      }
      if (AssertUtil.isDebugVersion()) {
        AssertUtil.assertInValidAttributesBinding(paramString1);
      }
      return;
      Object localObject2 = paramMap.get(paramString1);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = createJsonType(this.styleDynamicValue);
      }
      bool = setTrueValue(this.styleDynamicValue, localObject1, paramString2, paramObject);
      paramObject = localObject1;
      continue;
      label108:
      paramObject = null;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean.ValueNode
 * JD-Core Version:    0.7.0.1
 */