package com.tencent.comic.hippy;

import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessForWebPlugin;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.WebSecurityPluginV2;
import com.tencent.mobileqq.webview.swift.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.List;

public class QQHippyCommonJsPluginFactory
  extends CommonJsPluginFactory
{
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new WebSecurityPluginV2());
    localArrayList.add(new EventApiPlugin());
    localArrayList.add(new UiApiPlugin());
    localArrayList.add(new TogetherBusinessForWebPlugin());
    localArrayList.add(new QQApiPlugin());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.hippy.QQHippyCommonJsPluginFactory
 * JD-Core Version:    0.7.0.1
 */