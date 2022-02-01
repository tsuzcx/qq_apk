package com.tencent.biz.pubaccount.readinjoy.view.proteus.factory;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.IHotReloadChangedObserver;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TemplateWithHotReloadFactory
  extends BaseTemplateFactory
  implements ProteusParserWithHotReload.IHotReloadChangedObserver
{
  public TemplateWithHotReloadFactory()
  {
    if (ProteusParserWithHotReload.getInstance().isSupportHotReload()) {
      ProteusParserWithHotReload.getInstance().addHotReloadChangedObserver(this);
    }
  }
  
  public void createTemplate(int paramInt, String paramString, ViewBean paramViewBean, Map<String, Object> paramMap)
  {
    if (ProteusParserWithHotReload.getInstance().isSupportHotReload())
    {
      paramMap = new TemplateBean(paramInt, paramString, paramMap);
      paramMap.setViewBean(paramViewBean);
      this.nameTemplateMap.put(paramString, paramMap);
      onAddTemplate(paramString, paramMap);
      return;
    }
    super.createTemplate(paramInt, paramString, paramViewBean, paramMap);
  }
  
  public void createViewTemplate(JSONObject paramJSONObject, ComplementFileStringLoader paramComplementFileStringLoader)
  {
    if (ProteusParserWithHotReload.getInstance().isSupportHotReload())
    {
      ProteusParserWithHotReload.getInstance().createViewTemplate(this, paramJSONObject, paramComplementFileStringLoader, null);
      return;
    }
    super.createViewTemplate(paramJSONObject, paramComplementFileStringLoader);
  }
  
  public TemplateBean getTemplateBean(JSONObject paramJSONObject)
  {
    if (ProteusParserWithHotReload.getInstance().isSupportHotReload()) {
      return ProteusParserWithHotReload.getInstance().getTemplateBeanFromJson(this, paramJSONObject);
    }
    return super.getTemplateBean(paramJSONObject);
  }
  
  public void onHotReloadChanged(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      ProteusParserWithHotReload.getInstance().createViewTemplateFromFile(paramContext, this, paramString2);
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateWithHotReloadFactory
 * JD-Core Version:    0.7.0.1
 */