package com.google.protobuf;

import java.lang.reflect.Field;

final class FieldInfo
  implements Comparable<FieldInfo>
{
  private final Field a;
  private final FieldType b;
  private final Class<?> c;
  private final int d;
  private final Field e;
  private final int f;
  private final boolean g;
  private final boolean h;
  private final OneofInfo i;
  private final Field j;
  private final Class<?> k;
  private final Object l;
  private final Internal.EnumVerifier m;
  
  private FieldInfo(Field paramField1, int paramInt1, FieldType paramFieldType, Class<?> paramClass1, Field paramField2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, OneofInfo paramOneofInfo, Class<?> paramClass2, Object paramObject, Internal.EnumVerifier paramEnumVerifier, Field paramField3)
  {
    this.a = paramField1;
    this.b = paramFieldType;
    this.c = paramClass1;
    this.d = paramInt1;
    this.e = paramField2;
    this.f = paramInt2;
    this.g = paramBoolean1;
    this.h = paramBoolean2;
    this.i = paramOneofInfo;
    this.k = paramClass2;
    this.l = paramObject;
    this.m = paramEnumVerifier;
    this.j = paramField3;
  }
  
  public static FieldInfo a(int paramInt, FieldType paramFieldType, OneofInfo paramOneofInfo, Class<?> paramClass, boolean paramBoolean, Internal.EnumVerifier paramEnumVerifier)
  {
    a(paramInt);
    Internal.a(paramFieldType, "fieldType");
    Internal.a(paramOneofInfo, "oneof");
    Internal.a(paramClass, "oneofStoredType");
    if (paramFieldType.isScalar()) {
      return new FieldInfo(null, paramInt, paramFieldType, null, null, 0, false, paramBoolean, paramOneofInfo, paramClass, null, paramEnumVerifier, null);
    }
    paramOneofInfo = new StringBuilder();
    paramOneofInfo.append("Oneof is only supported for scalar fields. Field ");
    paramOneofInfo.append(paramInt);
    paramOneofInfo.append(" is of type ");
    paramOneofInfo.append(paramFieldType);
    throw new IllegalArgumentException(paramOneofInfo.toString());
  }
  
  public static FieldInfo a(Field paramField, int paramInt, FieldType paramFieldType, Internal.EnumVerifier paramEnumVerifier)
  {
    a(paramInt);
    Internal.a(paramField, "field");
    return new FieldInfo(paramField, paramInt, paramFieldType, null, null, 0, false, false, null, null, null, paramEnumVerifier, null);
  }
  
  public static FieldInfo a(Field paramField1, int paramInt, FieldType paramFieldType, Internal.EnumVerifier paramEnumVerifier, Field paramField2)
  {
    a(paramInt);
    Internal.a(paramField1, "field");
    return new FieldInfo(paramField1, paramInt, paramFieldType, null, null, 0, false, false, null, null, null, paramEnumVerifier, paramField2);
  }
  
  public static FieldInfo a(Field paramField, int paramInt, FieldType paramFieldType, Class<?> paramClass)
  {
    a(paramInt);
    Internal.a(paramField, "field");
    Internal.a(paramFieldType, "fieldType");
    Internal.a(paramClass, "messageClass");
    return new FieldInfo(paramField, paramInt, paramFieldType, paramClass, null, 0, false, false, null, null, null, null, null);
  }
  
  public static FieldInfo a(Field paramField1, int paramInt, FieldType paramFieldType, Field paramField2)
  {
    a(paramInt);
    Internal.a(paramField1, "field");
    Internal.a(paramFieldType, "fieldType");
    if ((paramFieldType != FieldType.MESSAGE_LIST) && (paramFieldType != FieldType.GROUP_LIST)) {
      return new FieldInfo(paramField1, paramInt, paramFieldType, null, null, 0, false, false, null, null, null, null, paramField2);
    }
    throw new IllegalStateException("Shouldn't be called for repeated message fields.");
  }
  
  public static FieldInfo a(Field paramField1, int paramInt1, FieldType paramFieldType, Field paramField2, int paramInt2, boolean paramBoolean, Internal.EnumVerifier paramEnumVerifier)
  {
    a(paramInt1);
    Internal.a(paramField1, "field");
    Internal.a(paramFieldType, "fieldType");
    Internal.a(paramField2, "presenceField");
    if ((paramField2 != null) && (!b(paramInt2)))
    {
      paramField1 = new StringBuilder();
      paramField1.append("presenceMask must have exactly one bit set: ");
      paramField1.append(paramInt2);
      throw new IllegalArgumentException(paramField1.toString());
    }
    return new FieldInfo(paramField1, paramInt1, paramFieldType, null, paramField2, paramInt2, false, paramBoolean, null, null, null, paramEnumVerifier, null);
  }
  
  public static FieldInfo a(Field paramField, int paramInt, FieldType paramFieldType, boolean paramBoolean)
  {
    a(paramInt);
    Internal.a(paramField, "field");
    Internal.a(paramFieldType, "fieldType");
    if ((paramFieldType != FieldType.MESSAGE_LIST) && (paramFieldType != FieldType.GROUP_LIST)) {
      return new FieldInfo(paramField, paramInt, paramFieldType, null, null, 0, false, paramBoolean, null, null, null, null, null);
    }
    throw new IllegalStateException("Shouldn't be called for repeated message fields.");
  }
  
  public static FieldInfo a(Field paramField, int paramInt, Object paramObject, Internal.EnumVerifier paramEnumVerifier)
  {
    Internal.a(paramObject, "mapDefaultEntry");
    a(paramInt);
    Internal.a(paramField, "field");
    return new FieldInfo(paramField, paramInt, FieldType.MAP, null, null, 0, false, true, null, null, paramObject, paramEnumVerifier, null);
  }
  
  private static void a(int paramInt)
  {
    if (paramInt > 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fieldNumber must be positive: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static FieldInfo b(Field paramField1, int paramInt1, FieldType paramFieldType, Field paramField2, int paramInt2, boolean paramBoolean, Internal.EnumVerifier paramEnumVerifier)
  {
    a(paramInt1);
    Internal.a(paramField1, "field");
    Internal.a(paramFieldType, "fieldType");
    Internal.a(paramField2, "presenceField");
    if ((paramField2 != null) && (!b(paramInt2)))
    {
      paramField1 = new StringBuilder();
      paramField1.append("presenceMask must have exactly one bit set: ");
      paramField1.append(paramInt2);
      throw new IllegalArgumentException(paramField1.toString());
    }
    return new FieldInfo(paramField1, paramInt1, paramFieldType, null, paramField2, paramInt2, true, paramBoolean, null, null, null, paramEnumVerifier, null);
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & paramInt - 1) == 0);
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int a(FieldInfo paramFieldInfo)
  {
    return this.d - paramFieldInfo.d;
  }
  
  public Field b()
  {
    return this.a;
  }
  
  public FieldType c()
  {
    return this.b;
  }
  
  public OneofInfo d()
  {
    return this.i;
  }
  
  public Internal.EnumVerifier e()
  {
    return this.m;
  }
  
  public Field f()
  {
    return this.e;
  }
  
  public Object g()
  {
    return this.l;
  }
  
  public int h()
  {
    return this.f;
  }
  
  public boolean i()
  {
    return this.g;
  }
  
  public boolean j()
  {
    return this.h;
  }
  
  public Field k()
  {
    return this.j;
  }
  
  public Class<?> l()
  {
    int n = FieldInfo.1.a[this.b.ordinal()];
    if ((n != 1) && (n != 2))
    {
      if ((n != 3) && (n != 4)) {
        return null;
      }
      return this.c;
    }
    Field localField = this.a;
    if (localField != null) {
      return localField.getType();
    }
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.FieldInfo
 * JD-Core Version:    0.7.0.1
 */