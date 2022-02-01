package com.tencent.luggage.wxa.de;

import com.tencent.luggage.wxa.qz.c;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/TdiCgiConfig;", "", "()V", "DEFAULT_TIME_OUT", "", "MAPPING", "com/tencent/luggage/login/account/tdi/TdiCgiConfig$MAPPING$1", "Lcom/tencent/luggage/login/account/tdi/TdiCgiConfig$MAPPING$1;", "TDI_TRANSFER_REQ_SCENE", "getTDI_TRANSFER_REQ_SCENE", "()I", "TDI_TRANSFER_REQ_WXA_SDK_VERSION", "getTDI_TRANSFER_REQ_WXA_SDK_VERSION", "getCmdId", "url", "", "mapping", "", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class h
{
  public static final h a = new h();
  private static final h.a b = new h.a();
  
  static
  {
    b.a("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", 1714);
    b.a("/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync", 1192);
    b.a("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", 1345);
    b.a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", 1115);
    b.a("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", 1862);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", 1194);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", 1191);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", 1180);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", 1183);
    b.a("/cgi-bin/mmbiz-bin/js-authorize", 1157);
    b.a("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", 2932);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", 2695);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", 1024);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", 2775);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", 1010);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", 2536);
    b.a("/cgi-bin/mmbiz-bin/js-operatewxdata", 1133);
    b.a("/cgi-bin/mmbiz-bin/js-authorize", 1157);
    b.a("/cgi-bin/mmbiz-bin/js-authorize-confirm", 1158);
    b.a("/cgi-bin/mmbiz-bin/js-login", 1029);
    b.a("/cgi-bin/mmbiz-bin/js-login-confirm", 1117);
    b.a("/cgi-bin/mmbiz-bin/bizattr/subscribemsg", 2920);
    b.a("/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp", 1122);
    b.a("/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync", 1151);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl", 1139);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord", 1149);
    b.a("/cgi-bin/mmbiz-bin/wxaapp_modauth", 1188);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl", 1139);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo", 1718);
    b.a("/cgi-bin/micromsg-bin/rcptinfoquery", 417);
    b.a("/cgi-bin/mmbiz-bin/jsapi-preverify", 1093);
    b.a("/cgi-bin/mmbiz-bin/jsapi-auth", 1095);
    b.a("/cgi-bin/mmbiz-bin/jsapi-setauth", 1096);
    b.a("/cgi-bin/mmbiz-bin/jsapi-realtimeverify", 1094);
    b.a("/cgi-bin/mmbiz-bin/js-refreshsession", 1196);
    b.a("/cgi-bin/mmbiz-bin/wxabusiness/getruntimesession", 3540);
    b.a("/cgi-bin/mmbiz-bin/oauth_authorize", 1254);
    b.a("/cgi-bin/mmbiz-bin/oauth_authorize_confirm", 1373);
    b.a("/cgi-bin/mmbiz-bin/wxartrappsvr/route", 2946);
    b.a("/cgi-bin/mmbiz-bin/wxaruntime/getdeeplinkticket", 1172);
    b.a("/cgi-bin/mmbiz-bin/wxaruntime/getdeeplinkinfo", 1081);
    b.a("/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo", 2921);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo", 1124);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/getwxadebuginfo", 1113);
    b.a("/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent", 1129);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/getpubliclibinfo", 1168);
    b.a("/cgi-bin/mmbiz-bin/wxaruntime/checkwebviewurl", 4759);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord", 1839);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord", 1148);
    b.a("/cgi-bin/mmbiz-bin/wxaruntime/hostattrsync", 5183);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/batchgetwxadownloadurl", 1713);
    b.a("/cgi-bin/mmoc-bin/ad/addatareport", 1295);
    b.a("/cgi-bin/mmbiz-bin/wxaapp/wxaapp_checkshortlink", 4428);
    b.a("/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport", 1009);
    b.a("/cgi-bin/mmbiz-bin/wxabusiness/checkuserstarrecord", 4831);
    b.a("/cgi-bin/mmgame-bin/getwxagameconfig", 2955);
  }
  
  public final int a()
  {
    return c.f;
  }
  
  public final int a(@Nullable String paramString)
  {
    h.a locala = b;
    if (paramString == null) {
      paramString = "";
    }
    return locala.a(paramString);
  }
  
  public final int b()
  {
    return c.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.h
 * JD-Core Version:    0.7.0.1
 */