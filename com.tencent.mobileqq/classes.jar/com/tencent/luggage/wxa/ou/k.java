package com.tencent.luggage.wxa.ou;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/URLEncoder;", "", "()V", "TAG", "", "encode", "s", "enc", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class k
{
  public static final k a = new k();
  
  @JvmStatic
  @JvmOverloads
  @Nullable
  public static final String a(@NotNull String paramString)
  {
    return a(paramString, null, 2, null);
  }
  
  @JvmStatic
  @JvmOverloads
  @Nullable
  public static final String a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "s");
    Intrinsics.checkParameterIsNotNull(paramString2, "enc");
    try
    {
      paramString1 = URLEncoder.encode(paramString1, paramString2);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      label20:
      break label20;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.k
 * JD-Core Version:    0.7.0.1
 */