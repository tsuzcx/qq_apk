package com.tencent.ilink.tdi;

import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public enum b$y
  implements ProtocolMessageEnum
{
  private static final Internal.EnumLiteMap<y> c = new b.y.1();
  private static final y[] d = values();
  private final int e;
  
  private b$y(int paramInt)
  {
    this.e = paramInt;
  }
  
  public static final Descriptors.EnumDescriptor a()
  {
    return (Descriptors.EnumDescriptor)b.a().h().get(4);
  }
  
  @Deprecated
  public static y a(int paramInt)
  {
    return b(paramInt);
  }
  
  public static y b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
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
    return this.e;
  }
  
  public final Descriptors.EnumValueDescriptor getValueDescriptor()
  {
    return (Descriptors.EnumValueDescriptor)a().e().get(ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.y
 * JD-Core Version:    0.7.0.1
 */