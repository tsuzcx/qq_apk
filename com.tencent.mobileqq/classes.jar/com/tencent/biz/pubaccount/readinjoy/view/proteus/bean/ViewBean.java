package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean;

import android.support.v4.util.ArrayMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class ViewBean
{
  public ViewBean[] children;
  public ValueBean valueBean = new ValueBean();
  public String viewId;
  public String viewType;
  
  private boolean bindValueWithoutId(JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    boolean bool1 = false;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          boolean bool2 = this.valueBean.putTrueDynamicValue(str, paramJSONObject.get(str), false);
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
    return setVisible(bool1);
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
  
  public void bindData(JSONObject paramJSONObject, Map<String, ViewBean> paramMap)
  {
    Object localObject1 = paramJSONObject.optJSONObject(this.viewId);
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
    bindValueWithoutId(paramJSONObject);
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
          break label422;
        }
      }
    }
    label422:
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
      localViewBean.bindData(paramJSONObject, paramMap);
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
        paramJSONObject = ((Map)localObject1).entrySet().iterator();
        while (paramJSONObject.hasNext())
        {
          localObject1 = (Map.Entry)paramJSONObject.next();
          localObject2 = findViewById((String)((Map.Entry)localObject1).getKey());
          if (localObject2 != null)
          {
            bool1 = ((ViewBean)localObject2).valueBean.isVisible();
            ((ViewBean)((Map.Entry)localObject1).getValue()).setVisible(bool1);
            if (bool1) {
              paramMap.put(((ViewBean)((Map.Entry)localObject1).getValue()).viewId, ((Map.Entry)localObject1).getValue());
            } else {
              paramMap.remove(((ViewBean)((Map.Entry)localObject1).getValue()).viewId);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean
 * JD-Core Version:    0.7.0.1
 */