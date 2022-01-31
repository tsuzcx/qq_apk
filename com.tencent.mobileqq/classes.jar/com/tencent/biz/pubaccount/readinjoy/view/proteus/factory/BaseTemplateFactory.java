package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import android.support.v4.util.ArrayMap;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ParseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class BaseTemplateFactory
{
  protected Map<String, TemplateBean> nameTemplateMap = new ArrayMap();
  private ProteusParser proteusParser = new ProteusParser();
  protected AtomicInteger templateId = new AtomicInteger(0);
  
  public BaseTemplateFactory clone()
  {
    BaseTemplateFactory localBaseTemplateFactory = new BaseTemplateFactory();
    localBaseTemplateFactory.templateId = new AtomicInteger(getTemplateId());
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.putAll(this.nameTemplateMap);
    localBaseTemplateFactory.nameTemplateMap = localArrayMap;
    return localBaseTemplateFactory;
  }
  
  public void createTemplate(int paramInt, String paramString, ViewBean paramViewBean)
  {
    TemplateBean localTemplateBean = new TemplateBean(paramInt, paramString);
    localTemplateBean.setViewBean(paramViewBean);
    this.nameTemplateMap.put(paramString, localTemplateBean);
    onAddTemplate(paramString, localTemplateBean);
  }
  
  public void createViewTemplate(String paramString, ComplementFileStringLoader paramComplementFileStringLoader)
  {
    createViewTemplate(new JSONObject(paramString), paramComplementFileStringLoader);
  }
  
  public void createViewTemplate(JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader)
  {
    this.proteusParser.createViewTemplate(this, paramJSONObject, paramComplementFileStringLoader);
  }
  
  public Map<String, TemplateBean> getNameTemplateMap()
  {
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.putAll(this.nameTemplateMap);
    return localArrayMap;
  }
  
  public ParseData getParseData(String paramString)
  {
    paramString = (TemplateBean)this.nameTemplateMap.get(paramString);
    if (paramString != null) {
      return paramString.parseData;
    }
    return null;
  }
  
  public TemplateBean getTemplate(String paramString)
  {
    paramString = (TemplateBean)this.nameTemplateMap.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.clone();
  }
  
  public TemplateBean getTemplateBean(JSONObject paramJSONObject)
  {
    return ProteusParser.getTemplateBean(this, paramJSONObject);
  }
  
  public int getTemplateId()
  {
    return this.templateId.get();
  }
  
  public boolean hasTemplate(String paramString)
  {
    return this.nameTemplateMap.containsKey(paramString);
  }
  
  public boolean isUsable()
  {
    return getTemplateId() > 0;
  }
  
  protected void onAddTemplate(String paramString, TemplateBean paramTemplateBean) {}
  
  public int size()
  {
    return this.nameTemplateMap.size();
  }
  
  public void updateAllTemplate()
  {
    this.templateId.incrementAndGet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory
 * JD-Core Version:    0.7.0.1
 */