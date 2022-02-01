package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean;

import android.support.v4.util.ArrayMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class ValueBean
{
  private static final String TAG = "ValueBean";
  private Map<String, ValueBean.ValueNode> attributeDynamicValue = new ArrayMap();
  private Map<String, ValueBean.ValueNode> dataAttributeDynamicValue = new ArrayMap();
  private Map<String, Object> dataAttributeLocalInfo = new ArrayMap();
  private Map<String, Object> dataAttributeRemoteInfo = new ArrayMap();
  public Map<String, Object> dynamicValue = new ArrayMap();
  private Map<String, ValueBean.Node> dynamicValueBinder = new ArrayMap();
  public Map<String, Object> normalValue = new ArrayMap();
  
  private void putTrueDynamicValueAttrbute(String paramString1, Object paramObject, String paramString2)
  {
    ValueBean.ValueNode localValueNode = (ValueBean.ValueNode)this.attributeDynamicValue.get(paramString2);
    if (localValueNode != null) {
      localValueNode.setTrueValue(this.dynamicValue, paramString2, paramString1, paramObject);
    }
  }
  
  private void putTrueDynamicValueDataAttr(String paramString1, Object paramObject, String paramString2)
  {
    Object localObject = (ValueBean.ValueNode)this.dataAttributeDynamicValue.get(paramString2);
    if (localObject != null)
    {
      ((ValueBean.ValueNode)localObject).setTrueValue(this.dataAttributeRemoteInfo, paramString2, paramString1, paramObject);
      if ("$setRemoteInfo:".equals(paramString2))
      {
        paramString1 = this.dataAttributeRemoteInfo.remove("$setRemoteInfo:");
        if ((paramString1 instanceof JSONObject))
        {
          paramString1 = (JSONObject)paramString1;
          paramObject = paramString1.keys();
          while ((paramObject != null) && (paramObject.hasNext()))
          {
            paramString2 = (String)paramObject.next();
            localObject = paramString1.opt(paramString2);
            if (localObject != null) {
              this.dataAttributeRemoteInfo.put(paramString2, localObject);
            }
          }
        }
      }
    }
  }
  
  public ValueBean clone()
  {
    ValueBean localValueBean = new ValueBean();
    localValueBean.normalValue = this.normalValue;
    localValueBean.dynamicValueBinder = this.dynamicValueBinder;
    localValueBean.attributeDynamicValue = this.attributeDynamicValue;
    localValueBean.dataAttributeDynamicValue = this.dataAttributeDynamicValue;
    localValueBean.dataAttributeLocalInfo = this.dataAttributeLocalInfo;
    return localValueBean;
  }
  
  public Object getDataAttribute(String paramString)
  {
    Object localObject = this.dataAttributeRemoteInfo.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    return this.dataAttributeLocalInfo.get(paramString);
  }
  
  public Map<String, Object> getDataAttribute()
  {
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.putAll(this.dataAttributeLocalInfo);
    localArrayMap.putAll(this.dataAttributeRemoteInfo);
    return localArrayMap;
  }
  
  public String getVisibleDependeOnBrotherViewId()
  {
    if (this.normalValue.containsKey("visible_depend_on_brother"))
    {
      Object localObject = this.normalValue.get("visible_depend_on_brother");
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
    }
    return null;
  }
  
  public boolean isDefalutVisible()
  {
    return (this.normalValue.containsKey("default_visible")) && ("YES".equals((String)this.normalValue.get("default_visible")));
  }
  
  public boolean isVisible()
  {
    return "VISIBLE".equals(this.dynamicValue.get("visibility"));
  }
  
  public boolean isVisibleDependeOnChilds()
  {
    return (this.normalValue.containsKey("visible_depend_on_children")) && ("YES".equals(this.normalValue.get("visible_depend_on_children")));
  }
  
  public void putAttributeDynamicValue(String paramString, Object paramObject)
  {
    paramObject = new ValueBean.ValueNode(paramObject);
    this.attributeDynamicValue.put(paramString, paramObject);
  }
  
  public void putDataAttributeDynamicValue(String paramString, Object paramObject)
  {
    paramObject = new ValueBean.ValueNode(paramObject);
    this.dataAttributeDynamicValue.put(paramString, paramObject);
  }
  
  public void putDataAttributeLocalData(String paramString, Object paramObject)
  {
    this.dataAttributeLocalInfo.put(paramString, paramObject);
  }
  
  public void putDynamicValue(String paramString1, String paramString2)
  {
    paramString2 = new ValueBean.Node(paramString2, (ValueBean.Node)this.dynamicValueBinder.get(paramString1));
    this.dynamicValueBinder.put(paramString1, paramString2);
  }
  
  public void putNomalValue(String paramString, Object paramObject)
  {
    this.normalValue.put(paramString, paramObject);
  }
  
  public void putTrueDynamicValue(String paramString, Object paramObject)
  {
    putTrueDynamicValue(paramString, paramObject, true);
  }
  
  public boolean putTrueDynamicValue(String paramString, Object paramObject, boolean paramBoolean)
  {
    ValueBean.Node localNode2 = (ValueBean.Node)this.dynamicValueBinder.get(paramString);
    ValueBean.Node localNode1 = localNode2;
    if (localNode2 == null)
    {
      if (paramBoolean) {
        this.dynamicValue.put(paramString, paramObject);
      }
      return false;
    }
    while (localNode1 != null)
    {
      putTrueDynamicValueAttrbute(paramString, paramObject, localNode1.methodName);
      putTrueDynamicValueDataAttr(paramString, paramObject, localNode1.methodName);
      localNode1 = localNode1.next;
    }
    return true;
  }
  
  public String toString()
  {
    return "normalValueMap : " + this.normalValue.toString() + "\ndynamicValueMap : " + this.dynamicValue.toString() + "\ndynamicValueBinder : " + this.dynamicValueBinder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean
 * JD-Core Version:    0.7.0.1
 */