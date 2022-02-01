package com.tencent.comic.hippy.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDImageView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

public class QQCustomViewCreator
  implements HippyCustomViewCreator
{
  public View createCustomView(String paramString, Context paramContext, HippyMap paramHippyMap)
  {
    if (TextUtils.equals("Image", paramString))
    {
      paramString = new HippyTKDImageView(paramContext);
      if (paramHippyMap != null) {
        paramString.setInitProps(paramHippyMap);
      }
      return paramString;
    }
    if (TextUtils.equals("WebView", paramString)) {
      return new QQHippyWebView(paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.hippy.view.QQCustomViewCreator
 * JD-Core Version:    0.7.0.1
 */