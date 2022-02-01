package com.tencent.hippy.qq.view.boodo;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.QLog;

@HippyController(name="WebView")
public class QQHippyWebViewController
  extends HippyViewController<QQHippyWebView>
{
  private static final String TAG = "QQHippyWebViewController";
  
  public View createViewImpl(Context paramContext)
  {
    return new QQHippyWebView(paramContext);
  }
  
  public void dispatchFunction(QQHippyWebView paramQQHippyWebView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramQQHippyWebView, paramString, paramHippyArray);
    if (("loadUrl".equals(paramString)) && (paramHippyArray != null)) {
      loadUrl(paramQQHippyWebView, paramHippyArray.getString(0));
    }
  }
  
  public boolean handleGestureBySelf()
  {
    return true;
  }
  
  @HippyControllerProps(defaultString="", defaultType="string", name="url")
  public void loadUrl(QQHippyWebView paramQQHippyWebView, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramQQHippyWebView.loadUrl(paramString);
    }
  }
  
  public void onViewDestroy(QQHippyWebView paramQQHippyWebView)
  {
    paramQQHippyWebView.onDestroy();
  }
  
  @HippyControllerProps(defaultType="map", name="source")
  public void source(QQHippyWebView paramQQHippyWebView, HippyMap paramHippyMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQHippyWebViewController", 2, new Object[] { "source info:", paramHippyMap });
    }
    if (paramHippyMap != null) {
      paramQQHippyWebView.initSource(paramHippyMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.boodo.QQHippyWebViewController
 * JD-Core Version:    0.7.0.1
 */