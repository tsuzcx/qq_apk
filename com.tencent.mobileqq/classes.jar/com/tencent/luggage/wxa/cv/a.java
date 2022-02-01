package com.tencent.luggage.wxa.cv;

import com.tencent.luggage.wxa.dc.k;
import com.tencent.luggage.wxa.qw.bt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/model/CgiWxaGetA8Key;", "Lcom/tencent/luggage/login/TdiCgi;", "Lcom/tencent/luggage/jsapi/webview/model/WxaDefGetA8KeyReq;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "()V", "getCmdId", "", "getUrl", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public class a
  extends k<j, bt>
{
  public static final a.a a = new a.a(null);
  
  @NotNull
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/ilink/ilinkapp/mm/");
    localStringBuilder.append(d.a.a());
    return localStringBuilder.toString();
  }
  
  protected int b()
  {
    return d.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.a
 * JD-Core Version:    0.7.0.1
 */