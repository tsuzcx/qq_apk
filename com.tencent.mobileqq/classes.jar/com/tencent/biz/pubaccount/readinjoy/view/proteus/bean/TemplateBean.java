package com.tencent.biz.pubaccount.readinjoy.view.proteus.bean;

import android.support.v4.util.ArrayMap;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.model.ProteusStyleModel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ParseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TemplateBean
  implements ProteusStyleModel
{
  JSONObject data;
  private int id;
  public ParseData parseData = new ParseData();
  private final String styleName;
  private String styleSource;
  private ViewBean viewBean;
  private Map<String, ViewBean> viewDataBinding = new ArrayMap();
  
  public TemplateBean(int paramInt, String paramString)
  {
    this.id = paramInt;
    this.styleName = paramString;
  }
  
  private ViewBean getViewBean(String paramString)
  {
    if (paramString == null) {
      return this.viewBean;
    }
    return findViewById(paramString);
  }
  
  public TemplateBean clone()
  {
    TemplateBean localTemplateBean = new TemplateBean(this.id, this.styleName);
    localTemplateBean.viewBean = this.viewBean.clone();
    localTemplateBean.setStyleSource(this.styleSource);
    return localTemplateBean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if (this == paramObject) {
              return true;
            }
          } while (!(paramObject instanceof TemplateBean));
          paramObject = (TemplateBean)paramObject;
        } while (this.id != paramObject.id);
        if (this.styleSource != null) {
          break;
        }
      } while (paramObject.getStyleSource() != null);
      if (this.styleName != null) {
        break label82;
      }
    } while (paramObject.getStyleName() != null);
    label82:
    while (this.styleName.equals(paramObject.getStyleName()))
    {
      return true;
      if (this.styleSource.equals(paramObject.getStyleSource())) {
        break;
      }
      return false;
    }
    return false;
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
    while (localIterator1.hasNext()) {
      try
      {
        Object localObject1 = (String)localIterator1.next();
        Object localObject2 = paramJSONObject.get((String)localObject1);
        localObject1 = findViewById((String)localObject1);
        if ((localObject1 == null) || (!(localObject2 instanceof JSONObject))) {
          continue;
        }
        localObject1 = ((ViewBean)localObject1).valueBean;
        localObject2 = (JSONObject)localObject2;
        Iterator localIterator2 = ((JSONObject)localObject2).keys();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          ((ValueBean)localObject1).putTrueDynamicValue(str, ((JSONObject)localObject2).getString(str));
        }
      }
      catch (JSONException localJSONException)
      {
        LogUtil.QLog.d(TemplateBean.class.getSimpleName(), 2, "", localJSONException);
      }
    }
  }
  
  public void refreshData()
  {
    try
    {
      if (this.viewBean != null)
      {
        this.viewDataBinding.clear();
        this.viewBean.bindData(this.data, this.viewDataBinding);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void setData(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.data = paramJSONObject;
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
    return " id : " + this.id + "  style: " + this.styleName + "  styleSource: " + this.styleSource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean
 * JD-Core Version:    0.7.0.1
 */