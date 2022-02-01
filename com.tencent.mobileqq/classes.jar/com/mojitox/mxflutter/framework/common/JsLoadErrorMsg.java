package com.mojitox.mxflutter.framework.common;

import com.mojitox.mxflutter.MXFlutterPlugin;
import com.mojitox.mxflutter.framework.JsFlutterEngine;
import com.mojitox.mxflutter.framework.executor.UiThread;
import com.mojitox.mxflutter.framework.js.JsEngineProvider;
import com.mojitox.mxflutter.framework.utils.MxLog;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/mojitox/mxflutter/framework/common/JsLoadErrorMsg;", "", "()V", "BUNDLE_JS_TYPE", "", "ERROR_MSG_KEY", "", "JS_FILE_TYPE_KEY", "MAIN_JS_TYPE", "getJsLoadErrorMsg", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "error", "Ljava/lang/Error;", "Lkotlin/Error;", "filePath", "invokeJsErrorMethodChannel", "", "mxflutter_release"}, k=1, mv={1, 1, 11})
public final class JsLoadErrorMsg
{
  public static final JsLoadErrorMsg a = new JsLoadErrorMsg();
  
  private final HashMap<String, Object> a(Error paramError, String paramString)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = paramError.getCause();
    Object localObject3 = "";
    if (localObject1 != null) {
      localObject1 = JsEngineProvider.a((Throwable)localObject1);
    } else {
      localObject1 = "";
    }
    Object localObject4 = paramError.getCause();
    Object localObject2 = localObject3;
    if (localObject4 != null)
    {
      localObject4 = ((Throwable)localObject4).getMessage();
      localObject2 = localObject3;
      if (localObject4 != null) {
        localObject2 = localObject4;
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("fileName:");
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append("\nselfMessage:");
    ((StringBuilder)localObject3).append(paramError.getMessage());
    ((StringBuilder)localObject3).append("\nexceptionMessage:");
    ((StringBuilder)localObject3).append(localObject2);
    ((StringBuilder)localObject3).append("\nexceptionStack:");
    ((StringBuilder)localObject3).append((String)localObject1);
    paramError = ((StringBuilder)localObject3).toString();
    MxLog.a("JsLoadErrorMsg", paramError);
    localObject1 = (Map)localHashMap;
    ((Map)localObject1).put("errorMsg", paramError);
    paramError = (CharSequence)paramString;
    if (StringsKt.contains$default(paramError, (CharSequence)"/main.js", false, 2, null)) {}
    int i;
    for (paramError = Integer.valueOf(0);; paramError = Integer.valueOf(i))
    {
      ((Map)localObject1).put("jsFileType", paramError);
      return localHashMap;
      if (StringsKt.contains$default(paramError, (CharSequence)"bundle-", false, 2, null)) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
  
  public final void a(@NotNull Error paramError, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramError, "error");
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    MXFlutterPlugin localMXFlutterPlugin = MXFlutterPlugin.a();
    Intrinsics.checkExpressionValueIsNotNull(localMXFlutterPlugin, "MXFlutterPlugin.get()");
    if (localMXFlutterPlugin.a() != null)
    {
      if (UiThread.a())
      {
        localMXFlutterPlugin = MXFlutterPlugin.a();
        Intrinsics.checkExpressionValueIsNotNull(localMXFlutterPlugin, "MXFlutterPlugin.get()");
        localMXFlutterPlugin.a().a.invokeMethod("mxflutterJSExceptionHandler", a.a(paramError, paramString));
        return;
      }
      UiThread.a((Runnable)new JsLoadErrorMsg.invokeJsErrorMethodChannel..inlined.run.lambda.1(paramError, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.common.JsLoadErrorMsg
 * JD-Core Version:    0.7.0.1
 */