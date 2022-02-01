package com.google.protobuf;

import java.util.List;

public final class TypeProto
{
  static final Descriptors.Descriptor a;
  static final GeneratedMessageV3.FieldAccessorTable b;
  static final Descriptors.Descriptor c;
  static final GeneratedMessageV3.FieldAccessorTable d;
  static final Descriptors.Descriptor e;
  static final GeneratedMessageV3.FieldAccessorTable f;
  static final Descriptors.Descriptor g;
  static final GeneratedMessageV3.FieldAccessorTable h;
  static final Descriptors.Descriptor i;
  static final GeneratedMessageV3.FieldAccessorTable j;
  private static Descriptors.FileDescriptor k;
  
  static
  {
    Descriptors.FileDescriptor localFileDescriptor1 = AnyProto.a();
    Descriptors.FileDescriptor localFileDescriptor2 = SourceContextProto.a();
    k = Descriptors.FileDescriptor.a(new String[] { "" }, new Descriptors.FileDescriptor[] { localFileDescriptor1, localFileDescriptor2 });
    a = (Descriptors.Descriptor)a().g().get(0);
    b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Name", "Fields", "Oneofs", "Options", "SourceContext", "Syntax" });
    c = (Descriptors.Descriptor)a().g().get(1);
    d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Kind", "Cardinality", "Number", "Name", "TypeUrl", "OneofIndex", "Packed", "Options", "JsonName", "DefaultValue" });
    e = (Descriptors.Descriptor)a().g().get(2);
    f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "Name", "Enumvalue", "Options", "SourceContext", "Syntax" });
    g = (Descriptors.Descriptor)a().g().get(3);
    h = new GeneratedMessageV3.FieldAccessorTable(g, new String[] { "Name", "Number", "Options" });
    i = (Descriptors.Descriptor)a().g().get(4);
    j = new GeneratedMessageV3.FieldAccessorTable(i, new String[] { "Name", "Value" });
    AnyProto.a();
    SourceContextProto.a();
  }
  
  public static Descriptors.FileDescriptor a()
  {
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.TypeProto
 * JD-Core Version:    0.7.0.1
 */