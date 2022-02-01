package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean;

import android.support.v4.util.ArrayMap;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.model.ProteusStyleModel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ParseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class TemplateBean
  implements ProteusStyleModel
{
  JSONObject data;
  private Map<String, Object> globalVariable;
  private int id;
  public ParseData parseData = new ParseData();
  private final String styleName;
  private String styleSource;
  private ViewBean viewBean;
  private Map<String, ViewBean> viewDataBinding = new ArrayMap();
  
  public TemplateBean(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    this.id = paramInt;
    this.styleName = paramString;
    this.globalVariable = paramMap;
  }
  
  private ViewBean getViewBean(String paramString)
  {
    if (paramString == null) {
      return this.viewBean;
    }
    return findViewById(paramString);
  }
  
  public void bindData(JSONObject paramJSONObject)
  {
    if ((this.viewBean != null) && (paramJSONObject != null))
    {
      this.data = paramJSONObject;
      JSONObject localJSONObject = null;
      Object localObject2 = this.globalVariable;
      Object localObject1 = localJSONObject;
      if (localObject2 != null)
      {
        localObject1 = localJSONObject;
        if (((Map)localObject2).size() > 0)
        {
          localJSONObject = new JSONObject();
          localObject2 = this.globalVariable.keySet().iterator();
          for (;;)
          {
            localObject1 = localJSONObject;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = (String)((Iterator)localObject2).next();
            if (!paramJSONObject.has((String)localObject1)) {
              localJSONObject.put((String)localObject1, this.globalVariable.get(localObject1));
            }
          }
        }
      }
      this.viewBean.bindData(paramJSONObject, (JSONObject)localObject1, this.viewDataBinding);
      return;
    }
    paramJSONObject = new JSONException("dataJson is null");
    for (;;)
    {
      throw paramJSONObject;
    }
  }
  
  public TemplateBean clone()
  {
    TemplateBean localTemplateBean = new TemplateBean(this.id, this.styleName, this.globalVariable);
    localTemplateBean.viewBean = this.viewBean.clone();
    localTemplateBean.setStyleSource(this.styleSource);
    return localTemplateBean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof TemplateBean)) {
      return false;
    }
    paramObject = (TemplateBean)paramObject;
    if (this.id != paramObject.id) {
      return false;
    }
    String str = this.styleSource;
    if (str == null)
    {
      if (paramObject.getStyleSource() != null) {
        return false;
      }
    }
    else if (!str.equals(paramObject.getStyleSource())) {
      return false;
    }
    str = this.styleName;
    if (str == null)
    {
      if (paramObject.getStyleName() != null) {
        return false;
      }
    }
    else if (!str.equals(paramObject.getStyleName())) {
      return false;
    }
    return true;
  }
  
  public ViewBean findViewById(String paramString)
  {
    return (ViewBean)this.viewDataBinding.get(paramString);
  }
  
  public JSONObject getData()
  {
    return this.data;
  }
  
  public Object getDataAttribute(String paramString1, String paramString2)
  {
    paramString1 = getViewBean(paramString1);
    if (paramString1 != null) {
      return paramString1.valueBean.getDataAttribute(paramString2);
    }
    return null;
  }
  
  public Map<String, Object> getDataAttribute(String paramString)
  {
    paramString = getViewBean(paramString);
    if (paramString != null) {
      return paramString.valueBean.getDataAttribute();
    }
    return null;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getStyleName()
  {
    return this.styleName;
  }
  
  public String getStyleSource()
  {
    return this.styleSource;
  }
  
  public ViewBean getViewBean()
  {
    return this.viewBean;
  }
  
  public Map<String, ViewBean> getViewDataBinding()
  {
    return this.viewDataBinding;
  }
  
  public void putDynamicJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Iterator localIterator1 = paramJSONObject.keys();
    for (;;)
    {
      if (localIterator1.hasNext()) {
        try
        {
          Object localObject1 = (String)localIterator1.next();
          Object localObject2 = paramJSONObject.get((String)localObject1);
          localObject1 = findViewById((String)localObject1);
          if ((localObject1 != null) && ((localObject2 instanceof JSONObject)))
          {
            localObject1 = ((ViewBean)localObject1).valueBean;
            localObject2 = (JSONObject)localObject2;
            Iterator localIterator2 = ((JSONObject)localObject2).keys();
            while (localIterator2.hasNext())
            {
              String str = (String)localIterator2.next();
              ((ValueBean)localObject1).putTrueDynamicValue(str, ((JSONObject)localObject2).getString(str));
            }
          }
        }
        catch (JSONException localJSONException)
        {
          LogUtil.QLog.d(TemplateBean.class.getSimpleName(), 2, "", localJSONException);
        }
      }
    }
  }
  
  public void refreshData()
  {
    try
    {
      if ((this.viewBean != null) && (this.data != null))
      {
        this.viewDataBinding.clear();
        bindData(this.data);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setStyleSource(String paramString)
  {
    this.styleSource = paramString;
  }
  
  public void setViewBean(ViewBean paramViewBean)
  {
    this.viewBean = paramViewBean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" id : ");
    localStringBuilder.append(this.id);
    localStringBuilder.append("  style: ");
    localStringBuilder.append(this.styleName);
    localStringBuilder.append("  styleSource: ");
    localStringBuilder.append(this.styleSource);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean
 * JD-Core Version:    0.7.0.1
 */