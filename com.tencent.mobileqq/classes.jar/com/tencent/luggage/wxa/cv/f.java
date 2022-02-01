package com.tencent.luggage.wxa.cv;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/model/MinorCgiWxaGetA8Key;", "Lcom/tencent/luggage/jsapi/webview/model/CgiWxaGetA8Key;", "()V", "getCmdId", "", "getUrl", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class f
  extends a
{
  @NotNull
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/ilink/ilinkapp/mm/");
    localStringBuilder.append(d.d.a());
    return localStringBuilder.toString();
  }
  
  protected int b()
  {
    return d.d.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.f
 * JD-Core Version:    0.7.0.1
 */