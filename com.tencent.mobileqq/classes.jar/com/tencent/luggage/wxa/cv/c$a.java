package com.tencent.luggage.wxa.cv;

import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.luggage.util.i;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/model/HTMLWebViewUrlCheckLogic$Companion;", "", "()V", "JS_API_FILE", "", "TAG", "weChatRedirectPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "checkCanLoadUrl", "", "url", "isUrlContainsLocalIP", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c$a
{
  private final boolean b(@NotNull String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = Uri.parse(paramString);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "Uri.parse(this)");
        localObject1 = ((Uri)localObject1).getHost();
        if (localObject1 != null)
        {
          localObject1 = (CharSequence)localObject1;
          localObject2 = i.a();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "LuggageNetUtil.getSelfIp()");
          boolean bool = StringsKt.contains$default((CharSequence)localObject1, (CharSequence)localObject2, false, 2, null);
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("isUrlContainsLocalIP(");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(") exception=");
        ((StringBuilder)localObject2).append(localThrowable);
        o.b("Luggage.HTMLWebViewUrlCheckLogic", ((StringBuilder)localObject2).toString());
        return false;
      }
      String str = "";
    }
  }
  
  @JvmStatic
  public final boolean a(@Nullable String paramString)
  {
    Object localObject = (CharSequence)paramString;
    boolean bool2 = false;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {}
    for (;;)
    {
      boolean bool1 = true;
      break label151;
      bool1 = bool2;
      if (!URLUtil.isAboutUrl(paramString))
      {
        bool1 = bool2;
        if (!URLUtil.isFileUrl(paramString)) {
          if (c.a.b(paramString)) {
            bool1 = bool2;
          } else if (Intrinsics.areEqual("file:///android_asset/jsapi/wxjs.js", paramString)) {
            bool1 = bool2;
          }
        }
      }
      try
      {
        localObject = Uri.parse(paramString);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "Uri.parse(url)");
        localObject = (CharSequence)((Uri)localObject).getHost();
        if (localObject != null)
        {
          i = ((CharSequence)localObject).length();
          if (i != 0)
          {
            i = 0;
            break label144;
          }
        }
        i = 1;
        label144:
        if (i != 0)
        {
          bool1 = bool2;
          label151:
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkCanLoadUrl url:");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(", canLoad:");
          ((StringBuilder)localObject).append(bool1);
          o.d("Luggage.HTMLWebViewUrlCheckLogic", ((StringBuilder)localObject).toString());
          return bool1;
        }
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.c.a
 * JD-Core Version:    0.7.0.1
 */