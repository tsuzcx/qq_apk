package com.tencent.hippy.qq.tuwen.app;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.tuwen.callback.ITKDTuWenHippyObservable;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TKDTuWenHippyEngine
  extends HippyQQEngine
{
  private static final String HIPPY_COMMENT_URL = "https://viola.qq.com/js/TKDCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react";
  private static final String HIPPY_URL = "https://viola.qq.com/js/TKDCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react";
  private ITKDTuWenHippyObservable tuWenHippyObservable;
  
  public TKDTuWenHippyEngine(Activity paramActivity)
  {
    super(paramActivity, getModuleNameInner(), "https://viola.qq.com/js/TKDCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react");
    this.providers.add(new NSHippyProvider());
    this.viewCreator = new TuWenHippyViewCreator();
  }
  
  private static String getModuleNameInner()
  {
    return Uri.parse("https://viola.qq.com/js/TKDCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react").getQueryParameter("v_bundleName");
  }
  
  public ITKDTuWenHippyObservable getTuWenHippyObservable()
  {
    return this.tuWenHippyObservable;
  }
  
  public void initJsBundleTypeFromUrl()
  {
    super.initJsBundleTypeFromUrl();
    try
    {
      String str = Uri.parse(this.mUrl).getQueryParameter("component");
      if (!TextUtils.isEmpty(str)) {
        this.componentName = str;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("HippyQQEngine", 2, "error : " + localException.getMessage());
    }
  }
  
  public void setTuWenHippyObservable(ITKDTuWenHippyObservable paramITKDTuWenHippyObservable)
  {
    this.tuWenHippyObservable = paramITKDTuWenHippyObservable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.app.TKDTuWenHippyEngine
 * JD-Core Version:    0.7.0.1
 */