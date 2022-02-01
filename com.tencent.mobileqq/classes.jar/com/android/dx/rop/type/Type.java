package com.android.dx.rop.type;

import com.android.dx.util.Hex;
import java.util.HashMap;

public final class Type
  implements TypeBearer, Comparable<Type>
{
  public static final Type ANNOTATION;
  public static final Type BOOLEAN;
  public static final Type BOOLEAN_ARRAY = BOOLEAN.getArrayType();
  public static final Type BOOLEAN_CLASS;
  public static final int BT_ADDR = 10;
  public static final int BT_BOOLEAN = 1;
  public static final int BT_BYTE = 2;
  public static final int BT_CHAR = 3;
  public static final int BT_COUNT = 11;
  public static final int BT_DOUBLE = 4;
  public static final int BT_FLOAT = 5;
  public static final int BT_INT = 6;
  public static final int BT_LONG = 7;
  public static final int BT_OBJECT = 9;
  public static final int BT_SHORT = 8;
  public static final int BT_VOID = 0;
  public static final Type BYTE;
  public static final Type BYTE_ARRAY = BYTE.getArrayType();
  public static final Type BYTE_CLASS;
  public static final Type CHAR;
  public static final Type CHARACTER_CLASS;
  public static final Type CHAR_ARRAY = CHAR.getArrayType();
  public static final Type CLASS;
  public static final Type CLONEABLE;
  public static final Type DOUBLE;
  public static final Type DOUBLE_ARRAY = DOUBLE.getArrayType();
  public static final Type DOUBLE_CLASS;
  public static final Type FLOAT;
  public static final Type FLOAT_ARRAY = FLOAT.getArrayType();
  public static final Type FLOAT_CLASS;
  public static final Type INT;
  public static final Type INTEGER_CLASS;
  public static final Type INT_ARRAY = INT.getArrayType();
  public static final Type KNOWN_NULL;
  public static final Type LONG;
  public static final Type LONG_ARRAY = LONG.getArrayType();
  public static final Type LONG_CLASS;
  public static final Type OBJECT;
  public static final Type OBJECT_ARRAY = OBJECT.getArrayType();
  public static final Type RETURN_ADDRESS;
  public static final Type SERIALIZABLE;
  public static final Type SHORT;
  public static final Type SHORT_ARRAY = SHORT.getArrayType();
  public static final Type SHORT_CLASS;
  public static final Type STRING;
  public static final Type THROWABLE;
  public static final Type VOID;
  public static final Type VOID_CLASS;
  private static final HashMap<String, Type> internTable = new HashMap(500);
  private Type arrayType;
  private final int basicType;
  private String className;
  private Type componentType;
  private final String descriptor;
  private Type initializedType;
  private final int newAt;
  
  static
  {
    BOOLEAN = new Type("Z", 1);
    BYTE = new Type("B", 2);
    CHAR = new Type("C", 3);
    DOUBLE = new Type("D", 4);
    FLOAT = new Type("F", 5);
    INT = new Type("I", 6);
    LONG = new Type("J", 7);
    SHORT = new Type("S", 8);
    VOID = new Type("V", 0);
    KNOWN_NULL = new Type("<null>", 9);
    RETURN_ADDRESS = new Type("<addr>", 10);
    putIntern(BOOLEAN);
    putIntern(BYTE);
    putIntern(CHAR);
    putIntern(DOUBLE);
    putIntern(FLOAT);
    putIntern(INT);
    putIntern(LONG);
    putIntern(SHORT);
    ANNOTATION = intern("Ljava/lang/annotation/Annotation;");
    CLASS = intern("Ljava/lang/Class;");
    CLONEABLE = intern("Ljava/lang/Cloneable;");
    OBJECT = intern("Ljava/lang/Object;");
    SERIALIZABLE = intern("Ljava/io/Serializable;");
    STRING = intern("Ljava/lang/String;");
    THROWABLE = intern("Ljava/lang/Throwable;");
    BOOLEAN_CLASS = intern("Ljava/lang/Boolean;");
    BYTE_CLASS = intern("Ljava/lang/Byte;");
    CHARACTER_CLASS = intern("Ljava/lang/Character;");
    DOUBLE_CLASS = intern("Ljava/lang/Double;");
    FLOAT_CLASS = intern("Ljava/lang/Float;");
    INTEGER_CLASS = intern("Ljava/lang/Integer;");
    LONG_CLASS = intern("Ljava/lang/Long;");
    SHORT_CLASS = intern("Ljava/lang/Short;");
    VOID_CLASS = intern("Ljava/lang/Void;");
  }
  
  private Type(String paramString, int paramInt)
  {
    this(paramString, paramInt, -1);
  }
  
  private Type(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new NullPointerException("descriptor == null");
    }
    if ((paramInt1 < 0) || (paramInt1 >= 11)) {
      throw new IllegalArgumentException("bad basicType");
    }
    if (paramInt2 < -1) {
      throw new IllegalArgumentException("newAt < -1");
    }
    this.descriptor = paramString;
    this.basicType = paramInt1;
    this.newAt = paramInt2;
    this.arrayType = null;
    this.componentType = null;
    this.initializedType = null;
  }
  
  public static Type intern(String paramString)
  {
    synchronized (internTable)
    {
      Type localType = (Type)internTable.get(paramString);
      if (localType != null) {
        return localType;
      }
    }
    try
    {
      i = paramString.charAt(0);
      if (i == 91) {
        return intern(paramString.substring(1)).getArrayType();
      }
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new IllegalArgumentException("descriptor is empty");
    }
    catch (NullPointerException paramString)
    {
      throw new NullPointerException("descriptor == null");
    }
    int j = paramString.length();
    if ((i != 76) || (paramString.charAt(j - 1) != ';')) {
      throw new IllegalArgumentException("bad descriptor: " + paramString);
    }
    int i = 1;
    if (i < j - 1)
    {
      switch (paramString.charAt(i))
      {
      }
      do
      {
        i += 1;
        break;
        throw new IllegalArgumentException("bad descriptor: " + paramString);
      } while ((i != 1) && (i != j - 1) && (paramString.charAt(i - 1) != '/'));
      throw new IllegalArgumentException("bad descriptor: " + paramString);
    }
    return putIntern(new Type(paramString, 9));
  }
  
  public static Type internClassName(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    if (paramString.startsWith("[")) {
      return intern(paramString);
    }
    return intern('L' + paramString + ';');
  }
  
  public static Type internReturnType(String paramString)
  {
    try
    {
      if (paramString.equals("V"))
      {
        paramString = VOID;
        return paramString;
      }
    }
    catch (NullPointerException paramString)
    {
      throw new NullPointerException("descriptor == null");
    }
    return intern(paramString);
  }
  
  private static Type putIntern(Type paramType)
  {
    synchronized (internTable)
    {
      String str = paramType.getDescriptor();
      Type localType = (Type)internTable.get(str);
      if (localType != null) {
        return localType;
      }
      internTable.put(str, paramType);
      return paramType;
    }
  }
  
  public Type asUninitialized(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("newAt < 0");
    }
    if (!isReference()) {
      throw new IllegalArgumentException("not a reference type: " + this.descriptor);
    }
    if (isUninitialized()) {
      throw new IllegalArgumentException("already uninitialized: " + this.descriptor);
    }
    Type localType = new Type('N' + Hex.u2(paramInt) + this.descriptor, 9, paramInt);
    localType.initializedType = this;
    return putIntern(localType);
  }
  
  public int compareTo(Type paramType)
  {
    return this.descriptor.compareTo(paramType.descriptor);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Type)) {
      return false;
    }
    return this.descriptor.equals(((Type)paramObject).descriptor);
  }
  
  public Type getArrayType()
  {
    if (this.arrayType == null) {
      this.arrayType = putIntern(new Type('[' + this.descriptor, 9));
    }
    return this.arrayType;
  }
  
  public int getBasicFrameType()
  {
    switch (this.basicType)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return this.basicType;
    }
    return 6;
  }
  
  public int getBasicType()
  {
    return this.basicType;
  }
  
  public int getCategory()
  {
    switch (this.basicType)
    {
    case 5: 
    case 6: 
    default: 
      return 1;
    }
    return 2;
  }
  
  public String getClassName()
  {
    if (this.className == null)
    {
      if (!isReference()) {
        throw new IllegalArgumentException("not an object type: " + this.descriptor);
      }
      if (this.descriptor.charAt(0) != '[') {
        break label71;
      }
    }
    label71:
    for (this.className = this.descriptor;; this.className = this.descriptor.substring(1, this.descriptor.length() - 1)) {
      return this.className;
    }
  }
  
  public Type getComponentType()
  {
    if (this.componentType == null)
    {
      if (this.descriptor.charAt(0) != '[') {
        throw new IllegalArgumentException("not an array type: " + this.descriptor);
      }
      this.componentType = intern(this.descriptor.substring(1));
    }
    return this.componentType;
  }
  
  public String getDescriptor()
  {
    return this.descriptor;
  }
  
  public Type getFrameType()
  {
    switch (this.basicType)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return this;
    }
    return INT;
  }
  
  public Type getInitializedType()
  {
    if (this.initializedType == null) {
      throw new IllegalArgumentException("initialized type: " + this.descriptor);
    }
    return this.initializedType;
  }
  
  public int getNewAt()
  {
    return this.newAt;
  }
  
  public Type getType()
  {
    return this;
  }
  
  public int hashCode()
  {
    return this.descriptor.hashCode();
  }
  
  public boolean isArray()
  {
    boolean bool = false;
    if (this.descriptor.charAt(0) == '[') {
      bool = true;
    }
    return bool;
  }
  
  public boolean isArrayOrKnownNull()
  {
    return (isArray()) || (equals(KNOWN_NULL));
  }
  
  public boolean isCategory1()
  {
    switch (this.basicType)
    {
    case 5: 
    case 6: 
    default: 
      return true;
    }
    return false;
  }
  
  public boolean isCategory2()
  {
    switch (this.basicType)
    {
    case 5: 
    case 6: 
    default: 
      return false;
    }
    return true;
  }
  
  public boolean isConstant()
  {
    return false;
  }
  
  public boolean isIntlike()
  {
    switch (this.basicType)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return false;
    }
    return true;
  }
  
  public boolean isPrimitive()
  {
    switch (this.basicType)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean isReference()
  {
    return this.basicType == 9;
  }
  
  public boolean isUninitialized()
  {
    return this.newAt >= 0;
  }
  
  public String toHuman()
  {
    switch (this.basicType)
    {
    default: 
      return this.descriptor;
    case 0: 
      return "void";
    case 1: 
      return "boolean";
    case 2: 
      return "byte";
    case 3: 
      return "char";
    case 4: 
      return "double";
    case 5: 
      return "float";
    case 6: 
      return "int";
    case 7: 
      return "long";
    case 8: 
      return "short";
    }
    if (isArray()) {
      return getComponentType().toHuman() + "[]";
    }
    return getClassName().replace("/", ".");
  }
  
  public String toString()
  {
    return this.descriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.type.Type
 * JD-Core Version:    0.7.0.1
 */