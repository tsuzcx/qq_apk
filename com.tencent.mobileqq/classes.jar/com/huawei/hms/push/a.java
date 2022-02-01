package com.huawei.hms.push;

import android.util.SparseArray;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.Status;

public enum a
{
  private static final SparseArray<a> ay;
  private int aA;
  private String aB;
  private int az;
  
  static
  {
    A = new a("ERROR_MSG_CACHE", 26, 800300009, 907122059, "message is cached");
    B = new a("ERROR_APP_SERVER_NOT_ONLINE", 27, 800300010, 907122060, "app server is not online.");
    C = new a("ERROR_OVER_FLOW_CONTROL_SIZE", 28, 800300011, 907122061, "frequency of message is over flow control size.");
    D = new a("ERROR_OVER_FLOW_CONTROL_SIZE_SELF_MAPPING", 29, 907122061, 907122061, "frequency of message is over flow control size.");
    E = new a("ERROR_PUSH_ARGUMENTS_INVALID", 30, 807135000, 907135000, "arguments invalid");
    F = new a("ERROR_PUSH_INTERNAL_ERROR", 31, 807135001, 907135001, "internal error");
    G = new a("ERROR_PUSH_NAMING_INVALID", 32, 807135002, 907135002, "naming invalid");
    H = new a("ERROR_PUSH_CLIENT_API_INVALID", 33, 807135003, 907135003, "client api invalid");
    I = new a("ERROR_PUSH_EXECUTE_TIMEOUT", 34, 807135004, 907135004, "execute timeout");
    J = new a("ERROR_PUSH_NOT_IN_SERVICE", 35, 807135005, 907135005, "not int service");
    K = new a("ERROR_SPUSH_ESSION_INVALID", 36, 807135006, 907135006, "session invalid");
    L = new a("ERROR_ARGUMENTS_INVALID", 37, 907135000, 907135000, "arguments invalid");
    M = new a("ERROR_INTERNAL_ERROR", 38, 907135001, 907135001, "internal error");
    N = new a("ERROR_NAMING_INVALID", 39, 907135002, 907135002, "naming invalid");
    O = new a("ERROR_CLIENT_API_INVALID", 40, 907135003, 907135003, "client api invalid");
    P = new a("ERROR_EXECUTE_TIMEOUT", 41, 907135004, 907135004, "execute timeout");
    Q = new a("ERROR_NOT_IN_SERVICE", 42, 907135005, 907135005, "not int service");
    R = new a("ERROR_SESSION_INVALID", 43, 907135006, 907135006, "session invalid");
    S = new a("ERROR_API_NOT_SPECIFIED", 44, 1002, 1002, "API not specified");
    T = new a("ERROR_GET_SCOPE_ERROR", 45, 907135700, 907135700, "get scope error");
    U = new a("ERROR_SCOPE_LIST_EMPTY", 46, 907135701, 907135701, "scope list empty");
    V = new a("ERROR_CERT_FINGERPRINT_EMPTY", 47, 907135702, 907135702, "certificate fingerprint empty");
    W = new a("ERROR_PERMISSION_LIST_EMPTY", 48, 907135703, 907135703, "permission list empty");
    X = new a("ERROR_AUTH_INFO_NOT_EXIST", 49, 6002, 6002, "auth info not exist");
    Y = new a("ERROR_CERT_FINGERPRINT_ERROR", 50, 6003, 6003, "certificate fingerprint error");
    Z = new a("ERROR_PERMISSION_NOT_EXIST", 51, 6004, 6004, "permission not exist");
    aa = new a("ERROR_PERMISSION_NOT_AUTHORIZED", 52, 6005, 6005, "permission not authorized");
    ab = new a("ERROR_PERMISSION_EXPIRED", 53, 6006, 6006, "permission expired");
    ac = new a("ERROR_HMS_CLIENT_API", 54, 907122048, 907122048, "HMS client api invalid");
    ad = new a("ERROR_OPERATION_NOT_SUPPORTED", 55, 907122049, 907122049, "operation not supported");
    ae = new a("ERROR_NO_RIGHT_SELF_MAPPING", 56, 907122011, 907122036, "no push right");
    af = new a("ERROR_NO_TOKEN_SIGN_SELF_MAPPING", 57, 907122032, 907122032, "token invalid");
    ag = new a("ERROR_INVALID_PARAMETERS_SELF_MAPPING", 58, 907122042, 907122042, "parameter invalid");
    ah = new a("ERROR_SIZE_SELF_MAPPING", 59, 907122041, 907122041, "message size error");
    ai = new a("ERROR_PUSH_SERVER_SELF_MAPPING", 60, 907122047, 907122047, "push server error");
    aj = new a("ERROR_HMS_CLIENT_API_SELF_MAPPING", 61, 907122048, 907122048, "push service not connected");
    ak = new a("ERROR_DEVICE_NOT_IN_GROUP_SELF_MAPPING", 62, 907122057, 907122057, "device not in device group");
    al = new a("ERROR_HMS_DEVICE_AUTH_FAILED_SELF_MAPPING", 63, 907122051, 907122051, "device certificate auth fail");
    am = new a("ERROR_TOPIC_EXCEED_SELF_MAPPING", 64, 907122034, 907122034, "topic exceed");
    an = new a("ERROR_TOPIC_SEND_SELF_MAPPING", 65, 907122035, 907122035, "topic send error");
    ao = new a("ERROR_STORAGE_LOCATION_EMPTY_MAPPING", 66, 907122038, 907122038, "storage location is empty or invalid");
    ap = new a("ERROR_BIND_SERVICE_SELF_MAPPING", 67, 907122052, 907122052, "bind service failed.");
    aq = new a("ERROR_NO_TOKEN_SELF_MAPPING", 68, 907122030, 907122030, "token missing");
    ar = new a("ERROR_AUTO_INITIALIZING", 69, 907122054, 907122054, "push kit initializing, try again later");
    as = new a("ERROR_RETRY_LATER_SELF_MAPPING", 70, 907122055, 907122055, "System busy, please retry later.");
    at = new a("ERROR_SEND_SELF_MAPPING", 71, 907122056, 907122056, "send error.");
    au = new a("ERROR_NO_NETWORK_OLD", 72, 907122005, 907122031, "no network");
    av = new a("ERROR_PUSH_SERVER_OLD", 73, 907122017, 907122047, "push server error");
    aw = new a("ERROR_NO_TOKEN_OLD", 74, 907122019, 907122030, "token missing");
    ax = new a("ERROR_RESTRICT_GET_TOKEN", 75, 800100014, 907122065, "restrict get token");
    aC = new a[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au, av, aw, ax };
    ay = new SparseArray();
    a[] arrayOfa = values();
    int i2 = arrayOfa.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a locala = arrayOfa[i1];
      ay.put(locala.az, locala);
      i1 += 1;
    }
  }
  
  private a(int paramInt1, int paramInt2, String paramString)
  {
    this.az = paramInt1;
    this.aA = paramInt2;
    this.aB = paramString;
  }
  
  public static ApiException a(a parama)
  {
    return new ApiException(new Status(parama.b(), parama.c()));
  }
  
  public static a a(int paramInt)
  {
    return (a)ay.get(paramInt, g);
  }
  
  public int a()
  {
    return this.az;
  }
  
  public int b()
  {
    return this.aA;
  }
  
  public String c()
  {
    return this.aB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.a
 * JD-Core Version:    0.7.0.1
 */