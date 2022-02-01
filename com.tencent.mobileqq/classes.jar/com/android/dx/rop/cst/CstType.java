package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import java.util.HashMap;

public final class CstType
  extends TypedConstant
{
  public static final CstType BOOLEAN;
  public static final CstType BOOLEAN_ARRAY;
  public static final CstType BYTE;
  public static final CstType BYTE_ARRAY;
  public static final CstType CHARACTER;
  public static final CstType CHAR_ARRAY;
  public static final CstType DOUBLE;
  public static final CstType DOUBLE_ARRAY;
  public static final CstType FLOAT;
  public static final CstType FLOAT_ARRAY;
  public static final CstType INTEGER;
  public static final CstType INT_ARRAY = intern(Type.INT_ARRAY);
  public static final CstType LONG;
  public static final CstType LONG_ARRAY;
  public static final CstType OBJECT;
  public static final CstType SHORT;
  public static final CstType SHORT_ARRAY = intern(Type.SHORT_ARRAY);
  public static final CstType VOID;
  private static final HashMap<Type, CstType> interns = new HashMap(100);
  private CstString descriptor;
  private final Type type;
  
  static
  {
    OBJECT = intern(Type.OBJECT);
    BOOLEAN = intern(Type.BOOLEAN_CLASS);
    BYTE = intern(Type.BYTE_CLASS);
    CHARACTER = intern(Type.CHARACTER_CLASS);
    DOUBLE = intern(Type.DOUBLE_CLASS);
    FLOAT = intern(Type.FLOAT_CLASS);
    LONG = intern(Type.LONG_CLASS);
    INTEGER = intern(Type.INTEGER_CLASS);
    SHORT = intern(Type.SHORT_CLASS);
    VOID = intern(Type.VOID_CLASS);
    BOOLEAN_ARRAY = intern(Type.BOOLEAN_ARRAY);
    BYTE_ARRAY = intern(Type.BYTE_ARRAY);
    CHAR_ARRAY = intern(Type.CHAR_ARRAY);
    DOUBLE_ARRAY = intern(Type.DOUBLE_ARRAY);
    FLOAT_ARRAY = intern(Type.FLOAT_ARRAY);
    LONG_ARRAY = intern(Type.LONG_ARRAY);
  }
  
  public CstType(Type paramType)
  {
    if (paramType == null) {
      throw new NullPointerException("type == null");
    }
    if (paramType == Type.KNOWN_NULL) {
      throw new UnsupportedOperationException("KNOWN_NULL is not representable");
    }
    this.type = paramType;
    this.descriptor = null;
  }
  
  public static CstType forBoxedPrimitiveType(Type paramType)
  {
    switch (paramType.getBasicType())
    {
    default: 
      throw new IllegalArgumentException("not primitive: " + paramType);
    case 1: 
      return BOOLEAN;
    case 2: 
      return BYTE;
    case 3: 
      return CHARACTER;
    case 4: 
      return DOUBLE;
    case 5: 
      return FLOAT;
    case 6: 
      return INTEGER;
    case 7: 
      return LONG;
    case 8: 
      return SHORT;
    }
    return VOID;
  }
  
  public static CstType intern(Type paramType)
  {
    synchronized (interns)
    {
      CstType localCstType2 = (CstType)interns.get(paramType);
      CstType localCstType1 = localCstType2;
      if (localCstType2 == null)
      {
        localCstType1 = new CstType(paramType);
        interns.put(paramType, localCstType1);
      }
      return localCstType1;
    }
  }
  
  protected int compareTo0(Constant paramConstant)
  {
    return this.type.getDescriptor().compareTo(((CstType)paramConstant).type.getDescriptor());
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CstType)) {}
    while (this.type != ((CstType)paramObject).type) {
      return false;
    }
    return true;
  }
  
  public Type getClassType()
  {
    return this.type;
  }
  
  public CstString getDescriptor()
  {
    if (this.descriptor == null) {
      this.descriptor = new CstString(this.type.getDescriptor());
    }
    return this.descriptor;
  }
  
  public String getPackageName()
  {
    String str = getDescriptor().getString();
    int i = str.lastIndexOf('/');
    int j = str.lastIndexOf('[');
    if (i == -1) {
      return "default";
    }
    return str.substring(j + 2, i).replace('/', '.');
  }
  
  public Type getType()
  {
    return Type.CLASS;
  }
  
  public int hashCode()
  {
    return this.type.hashCode();
  }
  
  public boolean isCategory2()
  {
    return false;
  }
  
  public String toHuman()
  {
    return this.type.toHuman();
  }
  
  public String toString()
  {
    return "type{" + toHuman() + '}';
  }
  
  public String typeName()
  {
    return "type";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstType
 * JD-Core Version:    0.7.0.1
 */