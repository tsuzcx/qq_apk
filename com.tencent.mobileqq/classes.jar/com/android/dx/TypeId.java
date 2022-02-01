package com.android.dx;

import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import java.util.HashMap;
import java.util.Map;

public final class TypeId<T>
{
  public static final TypeId<Boolean> BOOLEAN = new TypeId(Type.BOOLEAN);
  public static final TypeId<Byte> BYTE = new TypeId(Type.BYTE);
  public static final TypeId<Character> CHAR = new TypeId(Type.CHAR);
  public static final TypeId<Double> DOUBLE = new TypeId(Type.DOUBLE);
  public static final TypeId<Float> FLOAT = new TypeId(Type.FLOAT);
  public static final TypeId<Integer> INT = new TypeId(Type.INT);
  public static final TypeId<Long> LONG = new TypeId(Type.LONG);
  public static final TypeId<Object> OBJECT;
  private static final Map<Class<?>, TypeId<?>> PRIMITIVE_TO_TYPE;
  public static final TypeId<Short> SHORT = new TypeId(Type.SHORT);
  public static final TypeId<String> STRING;
  public static final TypeId<Void> VOID = new TypeId(Type.VOID);
  final CstType constant;
  final String name;
  final Type ropType;
  
  static
  {
    OBJECT = new TypeId(Type.OBJECT);
    STRING = new TypeId(Type.STRING);
    PRIMITIVE_TO_TYPE = new HashMap();
    PRIMITIVE_TO_TYPE.put(Boolean.TYPE, BOOLEAN);
    PRIMITIVE_TO_TYPE.put(Byte.TYPE, BYTE);
    PRIMITIVE_TO_TYPE.put(Character.TYPE, CHAR);
    PRIMITIVE_TO_TYPE.put(Double.TYPE, DOUBLE);
    PRIMITIVE_TO_TYPE.put(Float.TYPE, FLOAT);
    PRIMITIVE_TO_TYPE.put(Integer.TYPE, INT);
    PRIMITIVE_TO_TYPE.put(Long.TYPE, LONG);
    PRIMITIVE_TO_TYPE.put(Short.TYPE, SHORT);
    PRIMITIVE_TO_TYPE.put(Void.TYPE, VOID);
  }
  
  TypeId(Type paramType)
  {
    this(paramType.getDescriptor(), paramType);
  }
  
  TypeId(String paramString, Type paramType)
  {
    if ((paramString == null) || (paramType == null)) {
      throw new NullPointerException();
    }
    this.name = paramString;
    this.ropType = paramType;
    this.constant = CstType.intern(paramType);
  }
  
  public static <T> TypeId<T> get(Class<T> paramClass)
  {
    if (paramClass.isPrimitive()) {
      return (TypeId)PRIMITIVE_TO_TYPE.get(paramClass);
    }
    String str = paramClass.getName().replace('.', '/');
    if (paramClass.isArray()) {}
    for (paramClass = str;; paramClass = 'L' + str + ';') {
      return get(paramClass);
    }
  }
  
  public static <T> TypeId<T> get(String paramString)
  {
    return new TypeId(paramString, Type.internReturnType(paramString));
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof TypeId)) && (((TypeId)paramObject).name.equals(this.name));
  }
  
  public MethodId<T, Void> getConstructor(TypeId<?>... paramVarArgs)
  {
    return new MethodId(this, VOID, "<init>", new TypeList(paramVarArgs));
  }
  
  public <V> FieldId<T, V> getField(TypeId<V> paramTypeId, String paramString)
  {
    return new FieldId(this, paramTypeId, paramString);
  }
  
  public <R> MethodId<T, R> getMethod(TypeId<R> paramTypeId, String paramString, TypeId<?>... paramVarArgs)
  {
    return new MethodId(this, paramTypeId, paramString, new TypeList(paramVarArgs));
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public MethodId<T, Void> getStaticInitializer()
  {
    return new MethodId(this, VOID, "<clinit>", new TypeList(new TypeId[0]));
  }
  
  public int hashCode()
  {
    return this.name.hashCode();
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.TypeId
 * JD-Core Version:    0.7.0.1
 */