package com.tencent.ilive.litepages.room.webmodule.js.interfaces;

import android.content.Context;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.BaseLiteJSModule;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import java.util.Map;

public abstract class BaseLiteMiscJavascriptInterface
  extends BaseLiteJSModule
{
  public BaseLiteMiscJavascriptInterface(Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramJsBizAdapter);
  }
  
  public abstract void callCgi(Map<String, String> paramMap);
  
  public String getName()
  {
    return "misc";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.interfaces.BaseLiteMiscJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */