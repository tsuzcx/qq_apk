package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.qw.aq;
import com.tencent.luggage.wxa.qw.ar;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/CgiCheckDemoInfo;", "Lcom/tencent/luggage/login/Cgi;", "Lcom/tencent/mm/protocal/protobuf/CheckDemoInfoRequest;", "Lcom/tencent/mm/protocal/protobuf/CheckDemoInfoResponse;", "()V", "MM_ERR_BIZ_DEMO_HAS_BEEN_DELETED", "", "getMM_ERR_BIZ_DEMO_HAS_BEEN_DELETED", "()I", "MM_ERR_BIZ_USER_NOT_IN_WHITE_LIST", "getMM_ERR_BIZ_USER_NOT_IN_WHITE_LIST", "URL", "", "getURL", "()Ljava/lang/String;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
  extends a<aq, ar>
{
  public static final b a = new b();
  private static final int b = -13002;
  private static final int c = -13003;
  @NotNull
  private static final String d = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
  
  @NotNull
  public String a()
  {
    return d;
  }
  
  public final int b()
  {
    return b;
  }
  
  public final int c()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.b
 * JD-Core Version:    0.7.0.1
 */