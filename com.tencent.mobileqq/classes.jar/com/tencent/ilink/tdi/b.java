package com.tencent.ilink.tdi;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import java.util.List;

public final class b
{
  private static final Descriptors.Descriptor A;
  private static final GeneratedMessageV3.FieldAccessorTable B;
  private static final Descriptors.Descriptor C;
  private static final GeneratedMessageV3.FieldAccessorTable D;
  private static final Descriptors.Descriptor E;
  private static final GeneratedMessageV3.FieldAccessorTable F;
  private static final Descriptors.Descriptor G;
  private static final GeneratedMessageV3.FieldAccessorTable H;
  private static final Descriptors.Descriptor I;
  private static final GeneratedMessageV3.FieldAccessorTable J;
  private static final Descriptors.Descriptor K;
  private static final GeneratedMessageV3.FieldAccessorTable L;
  private static final Descriptors.Descriptor M;
  private static final GeneratedMessageV3.FieldAccessorTable N;
  private static final Descriptors.Descriptor O;
  private static final GeneratedMessageV3.FieldAccessorTable P;
  private static final Descriptors.Descriptor Q;
  private static final GeneratedMessageV3.FieldAccessorTable R;
  private static final Descriptors.Descriptor S;
  private static final GeneratedMessageV3.FieldAccessorTable T;
  private static Descriptors.FileDescriptor U;
  private static final Descriptors.Descriptor a;
  private static final GeneratedMessageV3.FieldAccessorTable b;
  private static final Descriptors.Descriptor c;
  private static final GeneratedMessageV3.FieldAccessorTable d;
  private static final Descriptors.Descriptor e;
  private static final GeneratedMessageV3.FieldAccessorTable f;
  private static final Descriptors.Descriptor g;
  private static final GeneratedMessageV3.FieldAccessorTable h;
  private static final Descriptors.Descriptor i;
  private static final GeneratedMessageV3.FieldAccessorTable j;
  private static final Descriptors.Descriptor k;
  private static final GeneratedMessageV3.FieldAccessorTable l;
  private static final Descriptors.Descriptor m;
  private static final GeneratedMessageV3.FieldAccessorTable n;
  private static final Descriptors.Descriptor o;
  private static final GeneratedMessageV3.FieldAccessorTable p;
  private static final Descriptors.Descriptor q;
  private static final GeneratedMessageV3.FieldAccessorTable r;
  private static final Descriptors.Descriptor s;
  private static final GeneratedMessageV3.FieldAccessorTable t;
  private static final Descriptors.Descriptor u;
  private static final GeneratedMessageV3.FieldAccessorTable v;
  private static final Descriptors.Descriptor w;
  private static final GeneratedMessageV3.FieldAccessorTable x;
  private static final Descriptors.Descriptor y;
  private static final GeneratedMessageV3.FieldAccessorTable z;
  
  static
  {
    Descriptors.FileDescriptor localFileDescriptor = a.a();
    U = Descriptors.FileDescriptor.a(new String[] { "" }, new Descriptors.FileDescriptor[] { localFileDescriptor });
    a = (Descriptors.Descriptor)a().g().get(0);
    b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "EnableLog", "EnableConsole", "LogLevel" });
    c = (Descriptors.Descriptor)a().g().get(1);
    d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "AppDir", "IlinkProductId", "IlinkSn", "IlinkId", "IlinkToken", "LogConfig", "IosIdfa" });
    e = (Descriptors.Descriptor)a().g().get(2);
    f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "TimeoutMs", "RecoType", "EnvData", "RetryCount" });
    g = (Descriptors.Descriptor)a().g().get(3);
    h = new GeneratedMessageV3.FieldAccessorTable(g, new String[] { "ConfigData" });
    i = (Descriptors.Descriptor)a().g().get(4);
    j = new GeneratedMessageV3.FieldAccessorTable(i, new String[] { "TimeoutMs", "RecgType", "DataType", "FaceData", "WxbaseReq", "WxpayReq", "RetryCount" });
    k = (Descriptors.Descriptor)a().g().get(5);
    l = new GeneratedMessageV3.FieldAccessorTable(k, new String[] { "WxbaseResp", "WxpayResp", "PassType" });
    m = (Descriptors.Descriptor)a().g().get(6);
    n = new GeneratedMessageV3.FieldAccessorTable(m, new String[] { "TimeoutMs", "Type", "BusinessType", "BusinessReq", "RetryCount" });
    o = (Descriptors.Descriptor)a().g().get(7);
    p = new GeneratedMessageV3.FieldAccessorTable(o, new String[] { "Type", "PassType", "BusinessResp" });
    q = (Descriptors.Descriptor)a().g().get(8);
    r = new GeneratedMessageV3.FieldAccessorTable(q, new String[] { "TimeoutMs", "BusinessReq", "AuthCode", "RetryCount", "SessionType", "Vendorid", "Lkid", "SecurityInfo" });
    s = (Descriptors.Descriptor)a().g().get(9);
    t = new GeneratedMessageV3.FieldAccessorTable(s, new String[] { "LoginType", "VerifyBuffer", "DetailRet" });
    u = (Descriptors.Descriptor)a().g().get(10);
    v = new GeneratedMessageV3.FieldAccessorTable(u, new String[] { "QrcodeVerifyScene", "ConfirmBusinessInfo" });
    w = (Descriptors.Descriptor)a().g().get(11);
    x = new GeneratedMessageV3.FieldAccessorTable(w, new String[] { "Path" });
    y = (Descriptors.Descriptor)a().g().get(12);
    z = new GeneratedMessageV3.FieldAccessorTable(y, new String[] { "Status", "Uin", "Nickname", "AvatarUrl", "BusinessConfirmRespBuffer" });
    A = (Descriptors.Descriptor)a().g().get(13);
    B = new GeneratedMessageV3.FieldAccessorTable(A, new String[] { "LoginStatus", "LoginType", "Uin", "Username", "LoginScene" });
    C = (Descriptors.Descriptor)a().g().get(14);
    D = new GeneratedMessageV3.FieldAccessorTable(C, new String[] { "Cmdid", "CryptoAlgo", "TimeoutMs", "Url", "Body", "NetType", "RetryCount", "LimitFlow", "LimitFrequency" });
    E = (Descriptors.Descriptor)a().g().get(15);
    F = new GeneratedMessageV3.FieldAccessorTable(E, new String[] { "Body" });
    G = (Descriptors.Descriptor)a().g().get(16);
    H = new GeneratedMessageV3.FieldAccessorTable(G, new String[] { "Msgid", "CreateTime", "Body" });
    I = (Descriptors.Descriptor)a().g().get(17);
    J = new GeneratedMessageV3.FieldAccessorTable(I, new String[] { "Token", "ExpireTimestamp" });
    K = (Descriptors.Descriptor)a().g().get(18);
    L = new GeneratedMessageV3.FieldAccessorTable(K, new String[] { "IlinkAppid" });
    M = (Descriptors.Descriptor)a().g().get(19);
    N = new GeneratedMessageV3.FieldAccessorTable(M, new String[] { "OauthCode" });
    O = (Descriptors.Descriptor)a().g().get(20);
    P = new GeneratedMessageV3.FieldAccessorTable(O, new String[] { "IlinkAppidList" });
    Q = (Descriptors.Descriptor)a().g().get(21);
    R = new GeneratedMessageV3.FieldAccessorTable(Q, new String[] { "Body" });
    S = (Descriptors.Descriptor)a().g().get(22);
    T = new GeneratedMessageV3.FieldAccessorTable(S, new String[] { "Body" });
    a.a();
  }
  
  public static Descriptors.FileDescriptor a()
  {
    return U;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b
 * JD-Core Version:    0.7.0.1
 */