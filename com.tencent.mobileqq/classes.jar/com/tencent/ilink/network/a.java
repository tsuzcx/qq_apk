package com.tencent.ilink.network;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import java.util.List;

public final class a
{
  private static final Descriptors.Descriptor a = (Descriptors.Descriptor)a().g().get(0);
  private static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "ClientRandomKey", "ServerRandomKey", "AutoauthEncKey", "Serverid", "Cookie", "Uin", "IlinkDeviceid", "IlinkProductid" });
  private static final Descriptors.Descriptor c = (Descriptors.Descriptor)a().g().get(1);
  private static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "RealUin", "ShowUin", "ClientSessionKey", "ServerSessionKey", "Serverid", "Cookie" });
  private static final Descriptors.Descriptor e = (Descriptors.Descriptor)a().g().get(2);
  private static final GeneratedMessageV3.FieldAccessorTable f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "ClientSessionKey", "ServerSessionKey", "AutoauthEncKey", "Uin", "Serverid" });
  private static final Descriptors.Descriptor g = (Descriptors.Descriptor)a().g().get(3);
  private static final GeneratedMessageV3.FieldAccessorTable h = new GeneratedMessageV3.FieldAccessorTable(g, new String[] { "Cmdid", "Url", "Body", "TimeoutMs", "RetryCount", "NetType", "CryptoAlgo", "LimitFlow", "LimitFrequency", "LongPolling", "LongPollingTimeout" });
  private static final Descriptors.Descriptor i = (Descriptors.Descriptor)a().g().get(4);
  private static final GeneratedMessageV3.FieldAccessorTable j = new GeneratedMessageV3.FieldAccessorTable(i, new String[] { "Cmdid", "Cmdbuf" });
  private static final Descriptors.Descriptor k = (Descriptors.Descriptor)a().g().get(5);
  private static final GeneratedMessageV3.FieldAccessorTable l = new GeneratedMessageV3.FieldAccessorTable(k, new String[] { "Cmdlist" });
  private static final Descriptors.Descriptor m = (Descriptors.Descriptor)a().g().get(6);
  private static final GeneratedMessageV3.FieldAccessorTable n = new GeneratedMessageV3.FieldAccessorTable(m, new String[] { "FileDir", "DebugNet", "DebugIp", "SelectDomain", "RunningMode" });
  private static final Descriptors.Descriptor o = (Descriptors.Descriptor)a().g().get(7);
  private static final GeneratedMessageV3.FieldAccessorTable p = new GeneratedMessageV3.FieldAccessorTable(o, new String[] { "Ip", "Port", "Username", "Password", "Proxytype" });
  private static final Descriptors.Descriptor q = (Descriptors.Descriptor)a().g().get(8);
  private static final GeneratedMessageV3.FieldAccessorTable r = new GeneratedMessageV3.FieldAccessorTable(q, new String[] { "SvrIplist" });
  private static final Descriptors.Descriptor s = (Descriptors.Descriptor)a().g().get(9);
  private static final GeneratedMessageV3.FieldAccessorTable t = new GeneratedMessageV3.FieldAccessorTable(s, new String[] { "AuthCode", "SessionType" });
  private static final Descriptors.Descriptor u = (Descriptors.Descriptor)a().g().get(10);
  private static final GeneratedMessageV3.FieldAccessorTable v = new GeneratedMessageV3.FieldAccessorTable(u, new String[] { "DeviceModel", "DeviceBrand", "Osname", "Osversion", "LanguageVer" });
  private static final Descriptors.Descriptor w = (Descriptors.Descriptor)a().g().get(11);
  private static final GeneratedMessageV3.FieldAccessorTable x = new GeneratedMessageV3.FieldAccessorTable(w, new String[] { "Logid", "Type", "Value", "ReportNow", "IgnoreFreqCheck" });
  private static Descriptors.FileDescriptor y = Descriptors.FileDescriptor.a(new String[] { "" }, new Descriptors.FileDescriptor[0]);
  
  public static Descriptors.FileDescriptor a()
  {
    return y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.network.a
 * JD-Core Version:    0.7.0.1
 */