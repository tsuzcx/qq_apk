package com.tencent.ilink.tdi;

import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public enum b$w
  implements ProtocolMessageEnum
{
  private static final Internal.EnumLiteMap<w> g = new b.w.1();
  private static final w[] h = values();
  private final int i;
  
  private b$w(int paramInt)
  {
    this.i = paramInt;
  }
  
  public static final Descriptors.EnumDescriptor a()
  {
    return (Descriptors.EnumDescriptor)b.a().h().get(2);
  }
  
  @Deprecated
  public static w a(int paramInt)
  {
    return b(paramInt);
  }
  
  public static w b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6)
            {
              if (paramInt != 7) {
                return null;
              }
              return f;
            }
            return e;
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
    return this.i;
  }
  
  public final Descriptors.EnumValueDescriptor getValueDescriptor()
  {
    return (Descriptors.EnumValueDescriptor)a().e().get(ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.w
 * JD-Core Version:    0.7.0.1
 */