package com.tencent.ilink.tdi;

import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public enum a$c
  implements ProtocolMessageEnum
{
  private static final Internal.EnumLiteMap<c> j = new a.c.1();
  private static final c[] k = values();
  private final int l;
  
  private a$c(int paramInt)
  {
    this.l = paramInt;
  }
  
  public static final Descriptors.EnumDescriptor a()
  {
    return (Descriptors.EnumDescriptor)a.a().h().get(2);
  }
  
  @Deprecated
  public static c a(int paramInt)
  {
    return b(paramInt);
  }
  
  public static c b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 1999)
        {
          switch (paramInt)
          {
          default: 
            return null;
          case 1004: 
            return h;
          case 1003: 
            return g;
          case 1002: 
            return f;
          case 1001: 
            return e;
          case 1000: 
            return d;
          }
          return c;
        }
        return i;
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
    return this.l;
  }
  
  public final Descriptors.EnumValueDescriptor getValueDescriptor()
  {
    return (Descriptors.EnumValueDescriptor)a().e().get(ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.a.c
 * JD-Core Version:    0.7.0.1
 */