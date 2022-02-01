package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.BindDataUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PolymericContainerHelper
  implements PolymericContainer
{
  private String TAG = "PolymericContainerHelper";
  public List<TemplateBean> childs = new ArrayList();
  
  private void addCell(BaseTemplateFactory paramBaseTemplateFactory, JSONObject paramJSONObject)
  {
    try
    {
      paramBaseTemplateFactory = paramBaseTemplateFactory.getTemplateBean(paramJSONObject);
      if (paramBaseTemplateFactory != null)
      {
        this.childs.add(paramBaseTemplateFactory);
        return;
      }
      paramBaseTemplateFactory = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("templateBean == null ");
      ((StringBuilder)localObject).append(paramJSONObject);
      LogUtil.QLog.e(paramBaseTemplateFactory, 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (JSONException paramBaseTemplateFactory)
    {
      Object localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addCell ");
      localStringBuilder.append(paramJSONObject);
      LogUtil.QLog.e((String)localObject, 1, localStringBuilder.toString(), paramBaseTemplateFactory);
    }
  }
  
  public TemplateBean getCellData(int paramInt)
  {
    if (paramInt >= this.childs.size()) {
      return null;
    }
    return (TemplateBean)this.childs.get(paramInt);
  }
  
  public Container getCellView(VafContext paramVafContext, int paramInt)
  {
    if (paramInt >= this.childs.size()) {
      return null;
    }
    TemplateBean localTemplateBean = (TemplateBean)this.childs.get(paramInt);
    paramVafContext = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
    BindDataUtil.bindDynamicValueWithoutRecursion(paramVafContext, null, localTemplateBean);
    return paramVafContext;
  }
  
  public EventCallback getEventCallback()
  {
    return null;
  }
  
  public void setCellArray(BaseTemplateFactory paramBaseTemplateFactory, JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      this.childs.clear();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          addCell(paramBaseTemplateFactory, paramJSONArray.getJSONObject(i));
        }
        catch (JSONException localJSONException)
        {
          LogUtil.QLog.e(this.TAG, 1, "", localJSONException);
        }
        i += 1;
      }
    }
  }
  
  public void setEventCallback(EventCallback paramEventCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.PolymericContainerHelper
 * JD-Core Version:    0.7.0.1
 */