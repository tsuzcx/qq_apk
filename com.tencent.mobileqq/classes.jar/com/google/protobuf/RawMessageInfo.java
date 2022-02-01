package com.google.protobuf;

final class RawMessageInfo
  implements MessageInfo
{
  private final MessageLite a;
  private final String b;
  private final Object[] c;
  private final int d;
  
  public ProtoSyntax a()
  {
    if ((this.d & 0x1) == 1) {
      return ProtoSyntax.PROTO2;
    }
    return ProtoSyntax.PROTO3;
  }
  
  public boolean b()
  {
    return (this.d & 0x2) == 2;
  }
  
  public MessageLite c()
  {
    return this.a;
  }
  
  String d()
  {
    return this.b;
  }
  
  Object[] e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.RawMessageInfo
 * JD-Core Version:    0.7.0.1
 */