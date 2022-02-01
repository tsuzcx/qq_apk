package com.tencent.ilive.litepages.room.webmodule.js.interfaces;

import android.content.Context;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.BaseLiteJSModule;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import java.util.Map;

public abstract class BaseLiteUIJavascriptInterface
  extends BaseLiteJSModule
{
  public BaseLiteUIJavascriptInterface(Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramJsBizAdapter);
  }
  
  public abstract void closeCurrentWebView(Map<String, String> paramMap);
  
  public String getName()
  {
    return "ui";
  }
  
  public abstract void openUrl(Map<String, String> paramMap);
  
  public abstract void openUrlInHost(Map<String, String> paramMap);
  
  public abstract void openUrlInWx(Map<String, String> paramMap);
  
  public abstract void savePic(Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.interfaces.BaseLiteUIJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */