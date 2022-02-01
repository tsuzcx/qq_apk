package com.huawei.hms.opendevice;

import android.util.SparseArray;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.Status;

public enum a
{
  private static final SparseArray<a> X;
  private int Y;
  private int Z;
  private String aa;
  
  static
  {
    int i1 = 0;
    a = new a("SUCCESS", 0, 0, 0, "success");
    b = new a("ERROR_NO_TOKEN", 1, 800000000, 907122030, "token missing");
    c = new a("ERROR_NO_TOKENSIGN", 2, 800000001, 907122032, "token invalid");
    d = new a("ERROR_NO_NETWORK", 3, 800000002, 907122031, "no network");
    e = new a("ERROR_SERVICE_NOT_AVAILABLE", 4, 800000003, 907122046, "service not available");
    f = new a("ERROR_PUSH_SERVER", 5, 800000004, 907122047, "push server error");
    g = new a("ERROR_UNKNOWN", 6, 800000005, 907122045, "unknown error");
    h = new a("ERROR_NO_RIGHT", 7, 800100000, 907122036, "no right");
    i = new a("ERROR_NO_CONNECTION_ID", 8, 800100001, 907122037, "get token error");
    j = new a("ERROR_LENGTH", 9, 800100002, 907122037, "get token error");
    k = new a("ERROR_NO_DEVICE_ID_TYPE", 10, 800100003, 907122037, "get token error");
    l = new a("ERROR_NOT_ALLOW_CROSS_APPLY", 11, 800100006, 907122053, "Failed to apply for the token. Cross-region application is not allowed.");
    m = new a("ERROR_TOKEN_DECRYPT", 12, 800200001, 907122032, "token invalid");
    n = new a("ERROR_TOKENSIGN_VALID", 13, 800200002, 907122032, "token invalid");
    o = new a("ERROR_PUSH_ARGUMENTS_INVALID", 14, 807135000, 907135000, "arguments invalid");
    p = new a("ERROR_PUSH_INTERNAL_ERROR", 15, 807135001, 907135001, "internal error");
    q = new a("ERROR_PUSH_NAMING_INVALID", 16, 807135002, 907135002, "naming invalid");
    r = new a("ERROR_PUSH_CLIENT_API_INVALID", 17, 807135003, 907135003, "client api invalid");
    s = new a("ERROR_PUSH_EXECUTE_TIMEOUT", 18, 807135004, 907135004, "execute timeout");
    t = new a("ERROR_PUSH_NOT_IN_SERVICE", 19, 807135005, 907135005, "not int service");
    u = new a("ERROR_SPUSH_ESSION_INVALID", 20, 807135006, 907135006, "session invalid");
    v = new a("ERROR_ARGUMENTS_INVALID", 21, 907135000, 907135000, "arguments invalid");
    w = new a("ERROR_INTERNAL_ERROR", 22, 907135001, 907135001, "internal error");
    x = new a("ERROR_NAMING_INVALID", 23, 907135002, 907135002, "naming invalid");
    y = new a("ERROR_CLIENT_API_INVALID", 24, 907135003, 907135003, "client api invalid");
    z = new a("ERROR_EXECUTE_TIMEOUT", 25, 907135004, 907135004, "execute timeout");
    A = new a("ERROR_NOT_IN_SERVICE", 26, 907135005, 907135005, "not int service");
    B = new a("ERROR_SESSION_INVALID", 27, 907135006, 907135006, "session invalid");
    C = new a("ERROR_API_NOT_SPECIFIED", 28, 1002, 1002, "API not specified");
    D = new a("ERROR_GET_SCOPE_ERROR", 29, 907135700, 907135700, "get scope error");
    E = new a("ERROR_SCOPE_LIST_EMPTY", 30, 907135701, 907135701, "scope list empty");
    F = new a("ERROR_CERT_FINGERPRINT_EMPTY", 31, 907135702, 907135702, "certificate fingerprint empty");
    G = new a("ERROR_PERMISSION_LIST_EMPTY", 32, 907135703, 907135703, "permission list empty");
    H = new a("ERROR_AUTH_INFO_NOT_EXIST", 33, 6002, 6002, "auth info not exist");
    I = new a("ERROR_CERT_FINGERPRINT_ERROR", 34, 6003, 6003, "certificate fingerprint error");
    J = new a("ERROR_PERMISSION_NOT_EXIST", 35, 6004, 6004, "permission not exist");
    K = new a("ERROR_PERMISSION_NOT_AUTHORIZED", 36, 6005, 6005, "permission not authorized");
    L = new a("ERROR_PERMISSION_EXPIRED", 37, 6006, 6006, "permission expired");
    M = new a("ERROR_HMS_CLIENT_API", 38, 907122048, 907122048, "HMS client api invalid");
    N = new a("ERROR_NO_RIGHT_SELF_MAPPING", 39, 907122011, 907122036, "no push right");
    O = new a("ERROR_MAIN_THREAD", 40, 907122050, 907122050, "operation in MAIN thread prohibited");
    P = new a("ERROR_NO_NETWORK_OLD", 41, 907122005, 907122031, "no network");
    Q = new a("ERROR_NO_RIGHT_OLD", 42, 907122011, 907122036, "no right");
    R = new a("ERROR_NO_CONNECTION_ID_OLD", 43, 907122012, 907122037, "get token error");
    S = new a("ERROR_LENGTH_OLD", 44, 907122013, 907122037, "get token error");
    T = new a("ERROR_NO_DEVICE_ID_TYPE_OLD", 45, 907122014, 907122037, "get token error");
    U = new a("ERROR_PUSH_SERVER_OLD", 46, 907122017, 907122047, "push server error");
    V = new a("ERROR_NO_TOKEN_OLD", 47, 907122019, 907122030, "token missing");
    W = new a("ERROR_RESTRICT_GET_TOKEN", 48, 800100014, 907122065, "restrict get token");
    ab = new a[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W };
    X = new SparseArray();
    a[] arrayOfa = values();
    int i2 = arrayOfa.length;
    while (i1 < i2)
    {
      a locala = arrayOfa[i1];
      X.put(locala.Y, locala);
      i1 += 1;
    }
  }
  
  private a(int paramInt1, int paramInt2, String paramString)
  {
    this.Y = paramInt1;
    this.Z = paramInt2;
    this.aa = paramString;
  }
  
  public static ApiException a(a parama)
  {
    return new ApiException(new Status(parama.a(), parama.b()));
  }
  
  public static a a(int paramInt)
  {
    return (a)X.get(paramInt, g);
  }
  
  public int a()
  {
    return this.Z;
  }
  
  public String b()
  {
    return this.aa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.a
 * JD-Core Version:    0.7.0.1
 */