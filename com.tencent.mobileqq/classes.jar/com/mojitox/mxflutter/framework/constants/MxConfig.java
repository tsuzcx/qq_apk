package com.mojitox.mxflutter.framework.constants;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mojitox.mxflutter.framework.js.JsEngineLoader;
import io.flutter.plugin.common.MethodCall;
import java.io.File;

public class MxConfig
{
  private static String a = "";
  private static String b = "";
  
  public static String a()
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    Object localObject = JsEngineLoader.a().c().getCacheDir();
    if (localObject == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(File.separator);
    if (TextUtils.isEmpty(a)) {
      localObject = "mxflutter_js_bundle";
    } else {
      localObject = a;
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public static void a(@NonNull MethodCall paramMethodCall)
  {
    if (paramMethodCall.hasArgument("jsAppPath")) {
      b = (String)paramMethodCall.argument("jsAppPath");
    }
    if (paramMethodCall.hasArgument("jsAppAssetsKey")) {
      a = (String)paramMethodCall.argument("jsAppAssetsKey");
    }
  }
  
  public static String b()
  {
    String str = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("/main");
    ((StringBuilder)localObject).append("/main.js");
    localObject = ((StringBuilder)localObject).toString();
    if (new File((String)localObject).exists()) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("/main.js");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.constants.MxConfig
 * JD-Core Version:    0.7.0.1
 */