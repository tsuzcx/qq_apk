package com.tencent.ilink.tdi;

import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public enum a$a
  implements ProtocolMessageEnum
{
  private static final Internal.EnumLiteMap<a> d = new a.a.1();
  private static final a[] e = values();
  private final int f;
  
  private a$a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public static final Descriptors.EnumDescriptor a()
  {
    return (Descriptors.EnumDescriptor)a.a().h().get(7);
  }
  
  @Deprecated
  public static a a(int paramInt)
  {
    return b(paramInt);
  }
  
  public static a b(int paramInt)
  {
    if (paramInt != -1)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return null;
        }
        return c;
      }
      return b;
    }
    return a;
  }
  
  public final Descriptors.EnumDescriptor getDescriptorForType()
  {
    return a();
  }
  
  public final int getNumber()
  {
    return this.f;
  }
  
  public final Descriptors.EnumValueDescriptor getValueDescriptor()
  {
    return (Descriptors.EnumValueDescriptor)a().e().get(ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.a.a
 * JD-Core Version:    0.7.0.1
 */