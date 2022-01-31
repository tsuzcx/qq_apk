package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProteusParser
{
  private static Map a = new HashMap();
  
  public static TemplateBean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    String str = paramJSONObject.getString("style_ID");
    TemplateBean localTemplateBean = TemplateFactory.a().a(str);
    if (localTemplateBean == null)
    {
      QLog.e("Q.readinjoy.proteus", 2, "proteus error : there is not Template: " + str);
      return null;
    }
    localTemplateBean.a().a(paramJSONObject);
    return localTemplateBean;
  }
  
  private static ViewBean a(JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader)
  {
    ViewBean localViewBean = new ViewBean();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramJSONObject.get((String)localObject1);
      if (paramJSONObject.has("view_id")) {
        localViewBean.jdField_a_of_type_JavaLangString = paramJSONObject.getString("view_id");
      }
      if (((String)localObject1).equals("view_type"))
      {
        localObject1 = paramJSONObject.getString("view_type");
        if ((TextUtils.equals((CharSequence)localObject1, "cell")) || (TextUtils.equals((CharSequence)localObject1, "container")))
        {
          if (TextUtils.equals("layout_relative", paramJSONObject.optString("layout_type"))) {
            localViewBean.b = "RelativeLayout";
          } else {
            localViewBean.b = "LinearLayout";
          }
        }
        else if (TextUtils.equals((CharSequence)localObject1, "UIView"))
        {
          if (paramJSONObject.optJSONArray("subviews") != null)
          {
            if (TextUtils.equals("layout_relative", paramJSONObject.optString("layout_type"))) {
              localViewBean.b = "NativeRelativeLayout";
            } else {
              localViewBean.b = "NativeLinearLayout";
            }
          }
          else {
            localViewBean.b = ((String)localObject1);
          }
        }
        else {
          localViewBean.b = ((String)localObject1);
        }
      }
      else if (!((String)localObject1).equals("view_id"))
      {
        if (((String)localObject1).equals("subviews"))
        {
          localObject1 = paramJSONObject.getJSONArray((String)localObject1);
          localObject2 = new ArrayList();
          int i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            JSONObject localJSONObject = a(((JSONArray)localObject1).getJSONObject(i), paramComplementFileStringLoader);
            if (localJSONObject != null) {
              ((List)localObject2).add(a(localJSONObject, paramComplementFileStringLoader));
            }
            i += 1;
          }
          localViewBean.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean = new ViewBean[((List)localObject2).size()];
          ((List)localObject2).toArray(localViewBean.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean);
        }
        else if (((String)localObject1).equals("attributes"))
        {
          a(paramJSONObject.getJSONObject((String)localObject1), localViewBean);
        }
        else
        {
          a((String)localObject1, localObject2, localViewBean.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueBean);
        }
      }
    }
    return localViewBean;
  }
  
  private static String a(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      if (paramObject.has("value")) {
        return paramObject.getString("value");
      }
      if (paramObject.has("type")) {
        return paramObject.getString("type");
      }
      localObject = paramObject.keys();
      if (((Iterator)localObject).hasNext()) {
        return paramObject.getString((String)((Iterator)localObject).next());
      }
    }
    else
    {
      if ((paramObject instanceof String)) {
        return (String)paramObject;
      }
      if ((paramObject instanceof JSONArray))
      {
        localObject = ((JSONArray)paramObject).get(0);
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        if ((localObject instanceof JSONArray)) {
          return paramObject.toString();
        }
      }
    }
    return null;
  }
  
  private static Map a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = a(paramJSONObject.get(str1));
      if (str2 != null) {
        localHashMap.put(str1, str2);
      }
    }
    return localHashMap;
  }
  
  private static JSONObject a(JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject.has("$includeComponet"))
    {
      if (paramComplementFileStringLoader == null) {
        break label45;
      }
      paramJSONObject = paramComplementFileStringLoader.a(paramJSONObject.getString("$includeComponet"));
      if (paramJSONObject != null) {
        localJSONObject = new JSONObject(paramJSONObject);
      }
    }
    else
    {
      return localJSONObject;
    }
    return null;
    label45:
    return null;
  }
  
  public static void a(TemplateFactory paramTemplateFactory, String paramString, ComplementFileStringLoader paramComplementFileStringLoader)
  {
    paramString = new JSONObject(paramString);
    int i = paramTemplateFactory.a();
    Iterator localIterator = paramString.keys();
    while ((localIterator != null) && (localIterator.hasNext()))
    {
      String str = (String)localIterator.next();
      paramTemplateFactory.a(i, str, a(paramString.getJSONObject(str), paramComplementFileStringLoader));
    }
  }
  
  public static void a(String paramString)
  {
    paramString = new JSONObject(paramString);
    if (paramString.has("version"))
    {
      localObject = paramString.getString("version");
      QLog.d("Q.readinjoy.proteus", 2, "proteus version : " + (String)localObject);
    }
    paramString = paramString.getJSONObject("data_map");
    Object localObject = paramString.keys();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      JSONObject localJSONObject = paramString.getJSONObject(str);
      a.put(str, a(localJSONObject));
    }
  }
  
  private static void a(String paramString, Object paramObject, ValueBean paramValueBean)
  {
    paramValueBean.a(paramString, a(paramObject));
  }
  
  private static void a(JSONObject paramJSONObject, ViewBean paramViewBean)
  {
    Iterator localIterator = paramJSONObject.keys();
    Object localObject1 = (Map)a.get(paramViewBean.jdField_a_of_type_JavaLangString);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        paramViewBean.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueBean.a((String)((Map.Entry)localObject2).getValue(), (String)((Map.Entry)localObject2).getKey());
      }
    }
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      localObject2 = paramJSONObject.get((String)localObject1);
      if ((localObject2 != null) && (!"-1".equals(localObject2))) {
        if ((localObject2 instanceof JSONArray)) {
          paramViewBean.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueBean.a((String)localObject1, a(localObject2));
        } else {
          paramViewBean.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanValueBean.a((String)localObject1, localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser
 * JD-Core Version:    0.7.0.1
 */