package com.tencent.luggage.wxa.du;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/jsapi/component/service/JSContextInterfaceUtils;", "", "()V", "LOAD_JS_FILES_PORT_SCRIPT", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class g
{
  @JvmField
  @Language("javascript")
  @NotNull
  public static final String a = "(function(global) {\n    let loadJsFilesWithOptions = global.WeixinJSContext.loadJsFilesWithOptions\n    global.WeixinJSContext.loadJsFiles = function(contextId, paths, options) {\n        if (!options) {\n            options = '{}'\n        } else if (typeof options !== 'string') {\n            options = JSON.stringify(options)\n        }\n        loadJsFilesWithOptions(contextId, paths, options)\n    }\n})(this);";
  public static final g b = new g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.g
 * JD-Core Version:    0.7.0.1
 */