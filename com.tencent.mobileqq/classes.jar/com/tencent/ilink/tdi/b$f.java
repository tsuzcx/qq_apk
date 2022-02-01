package com.tencent.ilink.tdi;

import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public enum b$f
  implements ProtocolMessageEnum
{
  private static final Internal.EnumLiteMap<f> p = new b.f.1();
  private static final f[] q = values();
  private final int r;
  
  private b$f(int paramInt)
  {
    this.r = paramInt;
  }
  
  public static final Descriptors.EnumDescriptor a()
  {
    return (Descriptors.EnumDescriptor)b.a().h().get(3);
  }
  
  @Deprecated
  public static f a(int paramInt)
  {
    return b(paramInt);
  }
  
  public static f b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 13: 
      return o;
    case 12: 
      return n;
    case 11: 
      return m;
    case 10: 
      return l;
    case 9: 
      return k;
    case 8: 
      return j;
    case 7: 
      return i;
    case 6: 
      return h;
    case 5: 
      return g;
    case 4: 
      return f;
    case 3: 
      return e;
    case 2: 
      return d;
    case 1: 
      return c;
    case 0: 
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
    return this.r;
  }
  
  public final Descriptors.EnumValueDescriptor getValueDescriptor()
  {
    return (Descriptors.EnumValueDescriptor)a().e().get(ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilink.tdi.b.f
 * JD-Core Version:    0.7.0.1
 */