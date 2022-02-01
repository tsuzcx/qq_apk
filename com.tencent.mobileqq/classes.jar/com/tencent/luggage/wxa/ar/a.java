package com.tencent.luggage.wxa.ar;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import java.util.List;

public final class a
{
  private static final Descriptors.Descriptor a = (Descriptors.Descriptor)a().g().get(0);
  private static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "ContactId", "IlinkimId", "Nickname", "Type", "Remark", "BigHeadimg", "SmallHeadimg", "Source", "NicknamePyinit", "NicknameQuanpin", "RemarkPyinit", "RemarkQuanpin", "AntispamTicket", "Sex", "BindType" });
  private static final Descriptors.Descriptor c = (Descriptors.Descriptor)a().g().get(1);
  private static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "IlinkimId", "Verifyuserticket", "Antispamticket", "Nickname", "Friendflag", "Scene", "Opcode", "Content", "Smallheadimgurl", "Bigheadimgurl" });
  private static final Descriptors.Descriptor e = (Descriptors.Descriptor)a().g().get(2);
  private static final GeneratedMessageV3.FieldAccessorTable f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "IlinkimId", "Uin", "Nickname", "Sex", "Province", "City", "Smallheadurl", "Bigheadurl", "Qrcodepath" });
  private static final Descriptors.Descriptor g = (Descriptors.Descriptor)a().g().get(3);
  private static final GeneratedMessageV3.FieldAccessorTable h = new GeneratedMessageV3.FieldAccessorTable(g, new String[] { "Fileid", "Size", "Md5", "Height", "Width", "Thumbfileid", "Thumbheight", "Thumbwidth", "Aeskey", "Videolen", "Content" });
  private static final Descriptors.Descriptor i = (Descriptors.Descriptor)a().g().get(4);
  private static final GeneratedMessageV3.FieldAccessorTable j = new GeneratedMessageV3.FieldAccessorTable(i, new String[] { "FromIlinkImId", "Msgid", "CreateTime", "Content", "Mediatype" });
  private static Descriptors.FileDescriptor k = Descriptors.FileDescriptor.a(new String[] { "\n\025ilink_im_entity.proto\022\007ilinkim\"®\002\n\007Contact\022\021\n\tcontactId\030\001 \001(\004\022\021\n\tilinkimId\030\002 \002(\t\022\020\n\bnickname\030\003 \001(\t\022\f\n\004type\030\004 \001(\r\022\016\n\006remark\030\005 \001(\t\022\022\n\nbigHeadimg\030\006 \001(\t\022\024\n\fsmallHeadimg\030\007 \001(\t\022\016\n\006source\030\b \001(\r\022\026\n\016nicknamePyinit\030\t \001(\t\022\027\n\017nicknameQuanpin\030\n \001(\t\022\024\n\fremarkPyinit\030\013 \001(\t\022\025\n\rremarkQuanpin\030\f \001(\t\022\026\n\016antispamTicket\030\r \001(\t\022\013\n\003sex\030\016 \001(\r\022\020\n\bBindType\030\017 \001(\r\"â\001\n\025VerifyUserRequestData\022\021\n\tilinkimId\030\001 \002(\t\022\030\n\020verifyuserticket\030\002 \002(\t\022\026\n\016antispamticket\030\003 \001(\t\022\020\n\bnickname\030\004 \001(\t\022\022\n\nfriendflag\030\005 \001(\r\022\r\n\005scene\030\006 \001(\r\022\016\n\006opcode\030\007 \001(\r\022\017\n\007content\030\b \001(\t\022\027\n\017smallheadimgurl\030\t \001(\t\022\025\n\rbigheadimgurl\030\n \001(\t\"®\001\n\017UserProfileInfo\022\021\n\tilinkimId\030\001 \001(\t\022\013\n\003uin\030\002 \001(\004\022\020\n\bnickname\030\003 \001(\t\022\013\n\003sex\030\004 \001(\t\022\020\n\bprovince\030\005 \001(\t\022\f\n\004city\030\006 \001(\t\022\024\n\fsmallheadurl\030\007 \001(\t\022\022\n\nbigheadurl\030\b \001(\t\022\022\n\nqrcodepath\030\t \001(\t\"Ò\001\n\025ComplexMessageContent\022\016\n\006fileid\030\001 \002(\t\022\f\n\004size\030\002 \001(\r\022\013\n\003md5\030\003 \001(\t\022\016\n\006height\030\004 \001(\r\022\r\n\005width\030\005 \001(\r\022\023\n\013thumbfileid\030\006 \001(\t\022\023\n\013thumbheight\030\007 \001(\r\022\022\n\nthumbwidth\030\b \001(\r\022\016\n\006aeskey\030\t \001(\t\022\020\n\bvideolen\030\n \001(\r\022\017\n\007content\030\013 \001(\t\"s\n\022ParsedImAppMessage\022\025\n\rfromIlinkImId\030\001 \001(\t\022\r\n\005msgid\030\002 \001(\004\022\023\n\013create_time\030\003 \001(\004\022\017\n\007content\030\004 \001(\t\022\021\n\tmediatype\030\005 \001(\r*=\n\016BindDeviceType\022\024\n\020BIND_DEVICE_ONCE\020\001\022\025\n\021BIND_DEVICE_REUSE\020\002B\035\n\031com.tencent.ilinkim.protoH\003" }, new Descriptors.FileDescriptor[0]);
  
  public static Descriptors.FileDescriptor a()
  {
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ar.a
 * JD-Core Version:    0.7.0.1
 */