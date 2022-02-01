package com.mojitox.mxflutter.framework.js.x5;

import android.text.TextUtils;
import com.mojitox.mxflutter.framework.utils.FileUtils;
import com.tencent.smtt.sdk.JsContext;

public class X5JsModule
{
  public static void a(String paramString1, String paramString2, JsContext paramJsContext)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramJsContext.evaluateScript(String.format("(function() { var module = { exports: {}}; var exports = module.exports; \n%s\n; return module.exports; })();", new Object[] { FileUtils.c(paramString2) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5JsModule
 * JD-Core Version:    0.7.0.1
 */