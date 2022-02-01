package com.tencent.ilink.tdi;

import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public enum a$d
  implements ProtocolMessageEnum
{
  private static final Internal.EnumLiteMap<d> e = new a.d.1();
  private static final d[] f = values();
  private final int g;
  
  private a$d(int paramInt)
  {
    this.g = paramInt;
  }
  
  public static final Descriptors.EnumDescriptor a()
  {
    return (Descriptors.EnumDescriptor)a.a().h().get(4);
  }
  
  @Deprecated
  public static d a(int paramInt)
  {
    return b(paramInt);
  }
  
  public static d b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return null;
          }
          return d;
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
    return this.g;
  }
  
  public final Descriptors.EnumValueDescriptor getValueDescriptor()
  {
    return (Descriptors.EnumValueDescriptor)a().e().get(ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.a.d
 * JD-Core Version:    0.7.0.1
 */