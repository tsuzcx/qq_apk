package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.text.TextUtils;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.module.BaseModule;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.utils.ViolaUtils;
import tre;

public class DtReportModule
  extends BaseModule
{
  public static final String MODULE_NAME = "report";
  
  @JSMethod
  public void dtReport(String paramString1, Object paramObject, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (getViolaInstance() != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = ViolaUtils.findComponent(getViolaInstance().getInstanceId(), paramString2);
        localObject1 = localObject2;
        if (paramString2 != null) {
          localObject1 = paramString2.getHostView();
        }
      }
    }
    tre.a(paramString1, paramObject, localObject1);
  }
  
  public String getModuleName()
  {
    return "report";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.DtReportModule
 * JD-Core Version:    0.7.0.1
 */