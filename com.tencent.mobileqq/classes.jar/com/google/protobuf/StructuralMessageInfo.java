package com.google.protobuf;

final class StructuralMessageInfo
  implements MessageInfo
{
  private final ProtoSyntax a;
  private final boolean b;
  private final int[] c;
  private final FieldInfo[] d;
  private final MessageLite e;
  
  StructuralMessageInfo(ProtoSyntax paramProtoSyntax, boolean paramBoolean, int[] paramArrayOfInt, FieldInfo[] paramArrayOfFieldInfo, Object paramObject)
  {
    this.a = paramProtoSyntax;
    this.b = paramBoolean;
    this.c = paramArrayOfInt;
    this.d = paramArrayOfFieldInfo;
    this.e = ((MessageLite)Internal.a(paramObject, "defaultInstance"));
  }
  
  public static StructuralMessageInfo.Builder a(int paramInt)
  {
    return new StructuralMessageInfo.Builder(paramInt);
  }
  
  public ProtoSyntax a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public MessageLite c()
  {
    return this.e;
  }
  
  public int[] d()
  {
    return this.c;
  }
  
  public FieldInfo[] e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.StructuralMessageInfo
 * JD-Core Version:    0.7.0.1
 */