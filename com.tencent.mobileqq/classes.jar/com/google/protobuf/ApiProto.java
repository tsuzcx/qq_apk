package com.google.protobuf;

import java.util.List;

public final class ApiProto
{
  static final Descriptors.Descriptor a;
  static final GeneratedMessageV3.FieldAccessorTable b;
  static final Descriptors.Descriptor c;
  static final GeneratedMessageV3.FieldAccessorTable d;
  static final Descriptors.Descriptor e;
  static final GeneratedMessageV3.FieldAccessorTable f;
  private static Descriptors.FileDescriptor g;
  
  static
  {
    Descriptors.FileDescriptor localFileDescriptor1 = SourceContextProto.a();
    Descriptors.FileDescriptor localFileDescriptor2 = TypeProto.a();
    g = Descriptors.FileDescriptor.a(new String[] { "\n\031google/protobuf/api.proto\022\017google.protobuf\032$google/protobuf/source_context.proto\032\032google/protobuf/type.proto\"\002\n\003Api\022\f\n\004name\030\001 \001(\t\022(\n\007methods\030\002 \003(\0132\027.google.protobuf.Method\022(\n\007options\030\003 \003(\0132\027.google.protobuf.Option\022\017\n\007version\030\004 \001(\t\0226\n\016source_context\030\005 \001(\0132\036.google.protobuf.SourceContext\022&\n\006mixins\030\006 \003(\0132\026.google.protobuf.Mixin\022'\n\006syntax\030\007 \001(\0162\027.google.protobuf.Syntax\"Õ\001\n\006Method\022\f\n\004name\030\001 \001(\t\022\030\n\020request_type_url\030\002 \001(\t\022\031\n\021request_streaming\030\003 \001(\b\022\031\n\021response_type_url\030\004 \001(\t\022\032\n\022response_streaming\030\005 \001(\b\022(\n\007options\030\006 \003(\0132\027.google.protobuf.Option\022'\n\006syntax\030\007 \001(\0162\027.google.protobuf.Syntax\"#\n\005Mixin\022\f\n\004name\030\001 \001(\t\022\f\n\004root\030\002 \001(\tBu\n\023com.google.protobufB\bApiProtoP\001Z+google.golang.org/genproto/protobuf/api;api¢\002\003GPBª\002\036Google.Protobuf.WellKnownTypesb\006proto3" }, new Descriptors.FileDescriptor[] { localFileDescriptor1, localFileDescriptor2 });
    a = (Descriptors.Descriptor)a().g().get(0);
    b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Name", "Methods", "Options", "Version", "SourceContext", "Mixins", "Syntax" });
    c = (Descriptors.Descriptor)a().g().get(1);
    d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Name", "RequestTypeUrl", "RequestStreaming", "ResponseTypeUrl", "ResponseStreaming", "Options", "Syntax" });
    e = (Descriptors.Descriptor)a().g().get(2);
    f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "Name", "Root" });
    SourceContextProto.a();
    TypeProto.a();
  }
  
  public static Descriptors.FileDescriptor a()
  {
    return g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ApiProto
 * JD-Core Version:    0.7.0.1
 */