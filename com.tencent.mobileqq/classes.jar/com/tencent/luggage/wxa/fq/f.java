package com.tencent.luggage.wxa.fq;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/WxaApiConstants;", "", "()V", "IS_DEBUG_API_ENABLED", "", "getIS_DEBUG_API_ENABLED", "()Z", "IS_DEBUG_WX_ACCEPTABLE", "getIS_DEBUG_WX_ACCEPTABLE", "IS_SNAPSHOT", "IS_TESTKIT_ENABLED", "getIS_TESTKIT_ENABLED", "IS_WEBVIEW_INSPECTOR_ON", "getIS_WEBVIEW_INSPECTOR_ON", "SCOPE", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class f
{
  public static final f a = new f();
  private static final boolean b;
  private static final boolean c = false;
  private static final boolean d = a();
  private static final boolean e = b;
  
  static
  {
    boolean bool2 = a();
    boolean bool1 = false;
    if ((bool2) || (StringsKt.contains$default((CharSequence)"1.5.1", (CharSequence)"-wxg", false, 2, null))) {
      bool1 = true;
    }
    b = bool1;
  }
  
  @JvmStatic
  @JvmName(name="IS_SNAPSHOT")
  public static final boolean a()
  {
    CharSequence localCharSequence1 = (CharSequence)"1.5.1";
    CharSequence localCharSequence2 = (CharSequence)"-SNAPSHOT";
    boolean bool = false;
    if ((StringsKt.contains$default(localCharSequence1, localCharSequence2, false, 2, null)) || (StringsKt.contains$default((CharSequence)"1.5.1", (CharSequence)"-snapshot", false, 2, null))) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean b()
  {
    return b;
  }
  
  public final boolean c()
  {
    return c;
  }
  
  public final boolean d()
  {
    return d;
  }
  
  public final boolean e()
  {
    return e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.f
 * JD-Core Version:    0.7.0.1
 */