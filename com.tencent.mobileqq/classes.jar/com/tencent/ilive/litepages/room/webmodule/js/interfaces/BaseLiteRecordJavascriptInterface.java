package com.tencent.ilive.litepages.room.webmodule.js.interfaces;

import android.content.Context;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.BaseLiteJSModule;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import java.util.Map;

public abstract class BaseLiteRecordJavascriptInterface
  extends BaseLiteJSModule
{
  private static final String TAG = "RecordJavascriptInterface";
  
  public BaseLiteRecordJavascriptInterface(Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramJsBizAdapter);
  }
  
  public String getName()
  {
    return "record";
  }
  
  public abstract void getviderect(Map<String, String> paramMap);
  
  public abstract void playpause(Map<String, String> paramMap);
  
  public abstract void seekto(Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.interfaces.BaseLiteRecordJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */