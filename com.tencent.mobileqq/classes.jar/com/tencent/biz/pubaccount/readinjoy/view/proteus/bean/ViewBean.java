package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean;

import android.support.v4.util.ArrayMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewBean
{
  public ViewBean[] children;
  public ValueBean valueBean = new ValueBean();
  public String viewId;
  public String viewType;
  
  private boolean bindValueWithoutId(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    Object localObject1 = paramJSONObject1.keys();
    bool1 = false;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        try
        {
          boolean bool2 = this.valueBean.putTrueDynamicValue(str, paramJSONObject1.get(str), false);
          if (bool2) {
            bool1 = true;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    if (paramJSONObject2 != null) {
      try
      {
        paramJSONObject1 = paramJSONObject2.keys();
        while (paramJSONObject1.hasNext())
        {
          localObject1 = (String)paramJSONObject1.next();
          Object localObject2 = paramJSONObject2.get((String)localObject1);
          this.valueBean.putTrueDynamicValue((String)localObject1, localObject2, false);
        }
        return setVisible(bool1);
      }
      catch (JSONException paramJSONObject1)
      {
        paramJSONObject1.printStackTrace();
      }
    }
  }
  
  private static Map<String, Object> getKeyOriginValue(JSONObject paramJSONObject)
  {
    ArrayMap localArrayMap = new ArrayMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.get(str);
      if (localObject != null) {
        localArrayMap.put(str, localObject);
      }
    }
    return localArrayMap;
  }
  
  void bindData(JSONObject paramJSONObject1, JSONObject paramJSONObject2, Map<String, ViewBean> paramMap)
  {
    Object localObject1 = paramJSONObject1.optJSONObject(this.viewId);
    Object localObject2;
    if (localObject1 != null)
    {
      setVisible(true);
      localObject1 = getKeyOriginValue((JSONObject)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        this.valueBean.putTrueDynamicValue((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
    }
    bindValueWithoutId(paramJSONObject1, paramJSONObject2);
    boolean bool2;
    int i;
    boolean bool1;
    ViewBean localViewBean;
    if (this.children != null)
    {
      bool2 = this.valueBean.isVisibleDependeOnChilds();
      ViewBean[] arrayOfViewBean = this.children;
      int j = arrayOfViewBean.length;
      i = 0;
      localObject1 = null;
      bool1 = false;
      if (i < j)
      {
        localViewBean = arrayOfViewBean[i];
        if (localViewBean.valueBean.isVisibleDependeOnChilds()) {
          break label423;
        }
      }
    }
    label423:
    for (String str = localViewBean.valueBean.getVisibleDependeOnBrotherViewId();; str = null)
    {
      localObject2 = localObject1;
      if (str != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new HashMap();
        }
        ((Map)localObject2).put(str, localViewBean);
      }
      localViewBean.bindData(paramJSONObject1, paramJSONObject2, paramMap);
      if (localViewBean.valueBean.isVisible()) {
        bool1 = true;
      }
      i += 1;
      localObject1 = localObject2;
      break;
      if (bool2) {
        setVisible(bool1);
      }
      if (localObject1 != null)
      {
        paramJSONObject1 = ((Map)localObject1).entrySet().iterator();
        while (paramJSONObject1.hasNext())
        {
          paramJSONObject2 = (Map.Entry)paramJSONObject1.next();
          localObject1 = findViewById((String)paramJSONObject2.getKey());
          if (localObject1 != null)
          {
            bool1 = ((ViewBean)localObject1).valueBean.isVisible();
            ((ViewBean)paramJSONObject2.getValue()).setVisible(bool1);
            if (bool1) {
              paramMap.put(((ViewBean)paramJSONObject2.getValue()).viewId, paramJSONObject2.getValue());
            } else {
              paramMap.remove(((ViewBean)paramJSONObject2.getValue()).viewId);
            }
          }
        }
      }
      if (this.valueBean.isVisible())
      {
        paramMap.put(this.viewId, this);
        return;
      }
      paramMap.remove(this.viewId);
      return;
    }
  }
  
  public ViewBean clone()
  {
    ViewBean localViewBean = new ViewBean();
    localViewBean.viewId = this.viewId;
    localViewBean.viewType = this.viewType;
    if (this.valueBean != null) {
      localViewBean.valueBean = this.valueBean.clone();
    }
    if (this.children != null)
    {
      localViewBean.children = new ViewBean[this.children.length];
      int i = 0;
      while (i < this.children.length)
      {
        localViewBean.children[i] = this.children[i].clone();
        i += 1;
      }
    }
    return localViewBean;
  }
  
  public ViewBean findViewById(String paramString)
  {
    if (paramString.equals(this.viewId)) {
      return this;
    }
    return findViewFromChild(paramString);
  }
  
  public ViewBean findViewFromChild(String paramString)
  {
    if (this.children != null)
    {
      ViewBean[] arrayOfViewBean = this.children;
      int j = arrayOfViewBean.length;
      int i = 0;
      while (i < j)
      {
        ViewBean localViewBean = arrayOfViewBean[i];
        if (localViewBean != null)
        {
          localViewBean = localViewBean.findViewById(paramString);
          if (localViewBean != null) {
            return localViewBean;
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public Object getDynamicValue(String paramString)
  {
    return this.valueBean.dynamicValue.get(paramString);
  }
  
  public void putDynamicValue(String paramString, Object paramObject)
  {
    this.valueBean.dynamicValue.put(paramString, paramObject);
  }
  
  public void putMapValue(String paramString, Object paramObject)
  {
    this.valueBean.putTrueDynamicValue(paramString, paramObject);
  }
  
  public boolean setVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.valueBean.putTrueDynamicValue("visibility", "VISIBLE");
      return paramBoolean;
    }
    if (this.valueBean.isDefalutVisible())
    {
      this.valueBean.putTrueDynamicValue("visibility", "VISIBLE");
      return true;
    }
    this.valueBean.putTrueDynamicValue("visibility", "GONE");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean
 * JD-Core Version:    0.7.0.1
 */