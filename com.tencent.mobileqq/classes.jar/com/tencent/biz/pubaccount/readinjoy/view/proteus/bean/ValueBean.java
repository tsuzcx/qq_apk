package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqu;
import org.json.JSONArray;
import org.json.JSONException;

public class ValueBean
{
  public Map a = new HashMap();
  public Map b = new HashMap();
  private Map c = new HashMap();
  
  private void a(mqu parammqu, String paramString1, String paramString2)
  {
    String str1 = parammqu.b;
    String str2 = (String)this.b.get(parammqu.jdField_a_of_type_JavaLangString);
    JSONArray localJSONArray = new JSONArray();
    parammqu.b = str1.replace("\"" + paramString1 + "\"", "\"" + paramString2 + "\"");
    if (str2 == null)
    {
      paramString1 = parammqu.b;
      QLog.d("ValueBean", 2, "putJsonArray: 样式定义有问题: 样式里没定义 " + parammqu.jdField_a_of_type_JavaLangString + "  ");
    }
    for (;;)
    {
      this.b.put(parammqu.jdField_a_of_type_JavaLangString, paramString1);
      return;
      try
      {
        a(new JSONArray(parammqu.b), new JSONArray(str2), localJSONArray);
        paramString1 = localJSONArray.toString();
      }
      catch (JSONException paramString1)
      {
        QLog.e("ValueBean", 2, "putJsonArray: ", paramString1);
        paramString1 = null;
      }
    }
  }
  
  private void a(JSONArray paramJSONArray, mqu parammqu)
  {
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.get(i);
      if ((localObject instanceof JSONArray)) {
        a((JSONArray)localObject, parammqu);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!(localObject instanceof String)) {
          break label69;
        }
        this.c.put((String)localObject, parammqu);
      }
      label69:
      throw new IllegalArgumentException("error format");
    }
  }
  
  private void a(JSONArray paramJSONArray1, JSONArray paramJSONArray2, JSONArray paramJSONArray3)
  {
    int i = 0;
    for (;;)
    {
      Object localObject2;
      try
      {
        if (i < paramJSONArray1.length())
        {
          Object localObject1 = paramJSONArray1.get(i);
          localObject2 = paramJSONArray2.get(i);
          if ((localObject2 instanceof JSONArray))
          {
            JSONArray localJSONArray = new JSONArray();
            a((JSONArray)localObject1, (JSONArray)localObject2, localJSONArray);
            paramJSONArray3.put(localJSONArray);
          }
          else if ((localObject2 instanceof String))
          {
            if ("-1".equals(localObject2)) {
              paramJSONArray3.put(localObject1);
            }
          }
        }
      }
      catch (Exception paramJSONArray1)
      {
        QLog.e("ValueBean", 2, "mergeJsonArray: ", paramJSONArray1);
      }
      return;
      paramJSONArray3.put(localObject2);
      break label130;
      throw new IllegalArgumentException("error format");
      label130:
      i += 1;
    }
  }
  
  private boolean a(String paramString)
  {
    return paramString.contains("[");
  }
  
  private void b(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new mqu(paramString2, null);
      paramString2.jdField_a_of_type_Boolean = true;
      paramString2.b = paramString1;
      a(new JSONArray(paramString1), paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public ValueBean a()
  {
    ValueBean localValueBean = new ValueBean();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.b);
    localValueBean.b = localHashMap;
    localHashMap = new HashMap();
    localHashMap.putAll(this.c);
    localValueBean.c = localHashMap;
    return localValueBean;
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.b.put(paramString, paramObject);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (a(paramString1))
    {
      b(paramString1, paramString2);
      return;
    }
    paramString2 = new mqu(paramString2, (mqu)this.c.get(paramString1));
    this.c.put(paramString1, paramString2);
  }
  
  public void b(String paramString, Object paramObject)
  {
    mqu localmqu = (mqu)this.c.get(paramString);
    if (localmqu == null) {
      this.a.put(paramString, paramObject);
    }
    if (localmqu != null)
    {
      if (localmqu.jdField_a_of_type_Boolean) {
        a(localmqu, paramString, (String)paramObject);
      }
      for (;;)
      {
        localmqu = localmqu.jdField_a_of_type_Mqu;
        break;
        String str = localmqu.jdField_a_of_type_JavaLangString;
        this.a.put(str, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean
 * JD-Core Version:    0.7.0.1
 */