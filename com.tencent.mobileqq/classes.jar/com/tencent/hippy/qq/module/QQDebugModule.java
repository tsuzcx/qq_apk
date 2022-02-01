package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="QQDebugModule")
public class QQDebugModule
  extends QQBaseModule
{
  static final String CLASSNAME = "QQDebugModule";
  
  public QQDebugModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="detailLog")
  public void detailLog(String paramString)
  {
    Object localObject = getFragment();
    if (localObject == null)
    {
      QLog.e("QQDebugModule", 1, "detailLog fragment is null");
      return;
    }
    localObject = ((Fragment)localObject).getActivity();
    if (!(localObject instanceof BaseActivity))
    {
      QLog.e("QQDebugModule", 1, "detailLog activity isvnot BaseActivity");
      return;
    }
    localObject = (BaseActivity)localObject;
    try
    {
      paramString = new JSONObject(paramString);
      VasCommonJsPlugin.webLog(((BaseActivity)localObject).getAppInterface(), (Activity)localObject, paramString);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QQDebugModule", 1, "detailLog error:" + paramString);
    }
  }
  
  @HippyMethod(name="getPerformanceData")
  public void getPerformanceData(Promise paramPromise)
  {
    Object localObject = getFragment();
    HippyMap localHippyMap = new HippyMap();
    if ((localObject instanceof BaseHippyFragment)) {
      localObject = ((BaseHippyFragment)localObject).getPerformanceData();
    }
    for (;;)
    {
      if ((localObject != null) && (((HashMap)localObject).size() > 0))
      {
        localObject = ((HashMap)localObject).entrySet().iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            localHippyMap.pushLong((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
            continue;
            if (!(localObject instanceof ViolaFragment)) {
              break label142;
            }
            localObject = ((ViolaFragment)localObject).getPerformanceData();
            break;
          }
        }
        localHippyMap.pushInt("retCode", 0);
      }
      for (;;)
      {
        paramPromise.resolve(localHippyMap);
        return;
        localHippyMap.pushInt("retCode", -1);
      }
      label142:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQDebugModule
 * JD-Core Version:    0.7.0.1
 */