package com.tencent.ilinkservice;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import java.util.List;

public final class a
{
  private static final Descriptors.Descriptor A = (Descriptors.Descriptor)a().g().get(13);
  private static final GeneratedMessageV3.FieldAccessorTable B = new GeneratedMessageV3.FieldAccessorTable(A, new String[] { "Taskid" });
  private static final Descriptors.Descriptor C = (Descriptors.Descriptor)a().g().get(14);
  private static final GeneratedMessageV3.FieldAccessorTable D = new GeneratedMessageV3.FieldAccessorTable(C, new String[] { "Appid", "Taskid", "Result", "Shadowdata" });
  private static final Descriptors.Descriptor E = (Descriptors.Descriptor)a().g().get(15);
  private static final GeneratedMessageV3.FieldAccessorTable F = new GeneratedMessageV3.FieldAccessorTable(E, new String[] { "Appid", "Taskid", "Result", "Shadowdata" });
  private static final Descriptors.Descriptor G = (Descriptors.Descriptor)a().g().get(16);
  private static final GeneratedMessageV3.FieldAccessorTable H = new GeneratedMessageV3.FieldAccessorTable(G, new String[] { "Appid", "Shadowdata" });
  private static final Descriptors.Descriptor I = (Descriptors.Descriptor)a().g().get(17);
  private static final GeneratedMessageV3.FieldAccessorTable J = new GeneratedMessageV3.FieldAccessorTable(I, new String[] { "Appid", "Ilinktoken" });
  private static final Descriptors.Descriptor K = (Descriptors.Descriptor)a().g().get(18);
  private static final GeneratedMessageV3.FieldAccessorTable L = new GeneratedMessageV3.FieldAccessorTable(K, new String[] { "Appid", "StartTime", "EndTime" });
  private static final Descriptors.Descriptor M = (Descriptors.Descriptor)a().g().get(19);
  private static final GeneratedMessageV3.FieldAccessorTable N = new GeneratedMessageV3.FieldAccessorTable(M, new String[] { "Errcode" });
  private static final Descriptors.Descriptor O = (Descriptors.Descriptor)a().g().get(20);
  private static final GeneratedMessageV3.FieldAccessorTable P = new GeneratedMessageV3.FieldAccessorTable(O, new String[] { "Appid", "Req" });
  private static Descriptors.FileDescriptor Q = Descriptors.FileDescriptor.a(new String[] { "\n\027ilinkservice_aidl.proto\022\020ilinkserviceaidl\"&\n\021setLonglinkIplist\022\021\n\tsvriplist\030\001 \001(\f\"'\n\022setShortlinkIplist\022\021\n\tsvriplist\030\001 \001(\f\"+\n\rthirdAppLogin\022\r\n\005appid\030\001 \001(\t\022\013\n\003req\030\002 \001(\f\"4\n\016setSmcBaseInfo\022\r\n\005appid\030\001 \001(\t\022\023\n\013smcbaseinfo\030\002 \001(\f\"!\n\016startUploadLog\022\017\n\007loginfo\030\001 \001(\f\"-\n\032getIlinkServiceVersionResp\022\017\n\007version\030\001 \001(\t\" \n\017createImSession\022\r\n\005appid\030\001 \001(\t\"!\n\020destroyImSession\022\r\n\005appid\030\001 \001(\t\"\037\n\016loginImSession\022\r\n\005appid\030\001 \001(\t\"2\n\021onImLoginComplete\022\r\n\005appid\030\001 \001(\t\022\016\n\006result\030\002 \001(\005\"#\n\022getDeviceShadowReq\022\r\n\005appid\030\001 \001(\t\"%\n\023getDeviceShadowResp\022\016\n\006taskid\030\001 \001(\r\":\n\025updateDeviceShadowReq\022\r\n\005appid\030\001 \001(\t\022\022\n\nshadowdata\030\002 \001(\f\"(\n\026updateDeviceShadowResp\022\016\n\006taskid\030\001 \001(\r\"V\n\021onGetDeviceShadow\022\r\n\005appid\030\001 \001(\t\022\016\n\006taskid\030\002 \001(\r\022\016\n\006result\030\003 \001(\r\022\022\n\nshadowdata\030\004 \001(\f\"Y\n\024onUpdateDeviceShadow\022\r\n\005appid\030\001 \001(\t\022\016\n\006taskid\030\002 \001(\r\022\016\n\006result\030\003 \001(\r\022\022\n\nshadowdata\030\004 \001(\f\"9\n\024onDeviceShadowUpdate\022\r\n\005appid\030\001 \001(\t\022\022\n\nshadowdata\030\002 \001(\f\"5\n\020updateIlinkToken\022\r\n\005appid\030\001 \001(\t\022\022\n\nilinktoken\030\002 \001(\t\"L\n\025requestUploadLogfiles\022\r\n\005appid\030\001 \001(\t\022\022\n\nstart_time\030\002 \001(\r\022\020\n\bend_time\030\003 \001(\r\"&\n\023onUploadLogComplete\022\017\n\007errcode\030\001 \001(\005\"*\n\fvisitorLogin\022\r\n\005appid\030\001 \001(\t\022\013\n\003req\030\002 \001(\fB%\n\030com.tencent.ilinkserviceB\tAidlProto" }, new Descriptors.FileDescriptor[0]);
  private static final Descriptors.Descriptor a = (Descriptors.Descriptor)a().g().get(0);
  private static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Svriplist" });
  private static final Descriptors.Descriptor c = (Descriptors.Descriptor)a().g().get(1);
  private static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Svriplist" });
  private static final Descriptors.Descriptor e = (Descriptors.Descriptor)a().g().get(2);
  private static final GeneratedMessageV3.FieldAccessorTable f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "Appid", "Req" });
  private static final Descriptors.Descriptor g = (Descriptors.Descriptor)a().g().get(3);
  private static final GeneratedMessageV3.FieldAccessorTable h = new GeneratedMessageV3.FieldAccessorTable(g, new String[] { "Appid", "Smcbaseinfo" });
  private static final Descriptors.Descriptor i = (Descriptors.Descriptor)a().g().get(4);
  private static final GeneratedMessageV3.FieldAccessorTable j = new GeneratedMessageV3.FieldAccessorTable(i, new String[] { "Loginfo" });
  private static final Descriptors.Descriptor k = (Descriptors.Descriptor)a().g().get(5);
  private static final GeneratedMessageV3.FieldAccessorTable l = new GeneratedMessageV3.FieldAccessorTable(k, new String[] { "Version" });
  private static final Descriptors.Descriptor m = (Descriptors.Descriptor)a().g().get(6);
  private static final GeneratedMessageV3.FieldAccessorTable n = new GeneratedMessageV3.FieldAccessorTable(m, new String[] { "Appid" });
  private static final Descriptors.Descriptor o = (Descriptors.Descriptor)a().g().get(7);
  private static final GeneratedMessageV3.FieldAccessorTable p = new GeneratedMessageV3.FieldAccessorTable(o, new String[] { "Appid" });
  private static final Descriptors.Descriptor q = (Descriptors.Descriptor)a().g().get(8);
  private static final GeneratedMessageV3.FieldAccessorTable r = new GeneratedMessageV3.FieldAccessorTable(q, new String[] { "Appid" });
  private static final Descriptors.Descriptor s = (Descriptors.Descriptor)a().g().get(9);
  private static final GeneratedMessageV3.FieldAccessorTable t = new GeneratedMessageV3.FieldAccessorTable(s, new String[] { "Appid", "Result" });
  private static final Descriptors.Descriptor u = (Descriptors.Descriptor)a().g().get(10);
  private static final GeneratedMessageV3.FieldAccessorTable v = new GeneratedMessageV3.FieldAccessorTable(u, new String[] { "Appid" });
  private static final Descriptors.Descriptor w = (Descriptors.Descriptor)a().g().get(11);
  private static final GeneratedMessageV3.FieldAccessorTable x = new GeneratedMessageV3.FieldAccessorTable(w, new String[] { "Taskid" });
  private static final Descriptors.Descriptor y = (Descriptors.Descriptor)a().g().get(12);
  private static final GeneratedMessageV3.FieldAccessorTable z = new GeneratedMessageV3.FieldAccessorTable(y, new String[] { "Appid", "Shadowdata" });
  
  public static Descriptors.FileDescriptor a()
  {
    return Q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.a
 * JD-Core Version:    0.7.0.1
 */