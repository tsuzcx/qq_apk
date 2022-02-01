package com.google.protobuf.compiler;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;
import java.util.List;

public final class PluginProtos
{
  private static final Descriptors.Descriptor a;
  private static final GeneratedMessageV3.FieldAccessorTable b;
  private static final Descriptors.Descriptor c;
  private static final GeneratedMessageV3.FieldAccessorTable d;
  private static final Descriptors.Descriptor e;
  private static final GeneratedMessageV3.FieldAccessorTable f;
  private static final Descriptors.Descriptor g;
  private static final GeneratedMessageV3.FieldAccessorTable h;
  private static Descriptors.FileDescriptor i;
  
  static
  {
    Descriptors.FileDescriptor localFileDescriptor = DescriptorProtos.a();
    i = Descriptors.FileDescriptor.a(new String[] { "\n%google/protobuf/compiler/plugin.proto\022\030google.protobuf.compiler\032 google/protobuf/descriptor.proto\"F\n\007Version\022\r\n\005major\030\001 \001(\005\022\r\n\005minor\030\002 \001(\005\022\r\n\005patch\030\003 \001(\005\022\016\n\006suffix\030\004 \001(\t\"º\001\n\024CodeGeneratorRequest\022\030\n\020file_to_generate\030\001 \003(\t\022\021\n\tparameter\030\002 \001(\t\0228\n\nproto_file\030\017 \003(\0132$.google.protobuf.FileDescriptorProto\022;\n\020compiler_version\030\003 \001(\0132!.google.protobuf.compiler.Version\"ª\001\n\025CodeGeneratorResponse\022\r\n\005error\030\001 \001(\t\022B\n\004file\030\017 \003(\01324.google.protobuf.compiler.CodeGeneratorResponse.File\032>\n\004File\022\f\n\004name\030\001 \001(\t\022\027\n\017insertion_point\030\002 \001(\t\022\017\n\007content\030\017 \001(\tBg\n\034com.google.protobuf.compilerB\fPluginProtosZ9github.com/golang/protobuf/protoc-gen-go/plugin;plugin_go" }, new Descriptors.FileDescriptor[] { localFileDescriptor });
    a = (Descriptors.Descriptor)a().g().get(0);
    b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Major", "Minor", "Patch", "Suffix" });
    c = (Descriptors.Descriptor)a().g().get(1);
    d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "FileToGenerate", "Parameter", "ProtoFile", "CompilerVersion" });
    e = (Descriptors.Descriptor)a().g().get(2);
    f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "Error", "File" });
    g = (Descriptors.Descriptor)e.i().get(0);
    h = new GeneratedMessageV3.FieldAccessorTable(g, new String[] { "Name", "InsertionPoint", "Content" });
    DescriptorProtos.a();
  }
  
  public static Descriptors.FileDescriptor a()
  {
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.compiler.PluginProtos
 * JD-Core Version:    0.7.0.1
 */