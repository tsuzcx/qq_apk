package com.android.dx.rop.type;

import com.android.dx.util.FixedSizeList;

public final class StdTypeList
  extends FixedSizeList
  implements TypeList
{
  public static final StdTypeList BOOLEANARR_INT;
  public static final StdTypeList BYTEARR_INT;
  public static final StdTypeList CHARARR_INT;
  public static final StdTypeList DOUBLE;
  public static final StdTypeList DOUBLEARR_INT;
  public static final StdTypeList DOUBLE_DOUBLE;
  public static final StdTypeList DOUBLE_DOUBLEARR_INT;
  public static final StdTypeList DOUBLE_OBJECT;
  public static final StdTypeList EMPTY = new StdTypeList(0);
  public static final StdTypeList FLOAT;
  public static final StdTypeList FLOATARR_INT;
  public static final StdTypeList FLOAT_FLOAT;
  public static final StdTypeList FLOAT_FLOATARR_INT;
  public static final StdTypeList FLOAT_OBJECT;
  public static final StdTypeList INT = make(Type.INT);
  public static final StdTypeList INTARR_INT;
  public static final StdTypeList INT_BOOLEANARR_INT = make(Type.INT, Type.BOOLEAN_ARRAY, Type.INT);
  public static final StdTypeList INT_BYTEARR_INT = make(Type.INT, Type.BYTE_ARRAY, Type.INT);
  public static final StdTypeList INT_CHARARR_INT = make(Type.INT, Type.CHAR_ARRAY, Type.INT);
  public static final StdTypeList INT_INT;
  public static final StdTypeList INT_INTARR_INT;
  public static final StdTypeList INT_OBJECT;
  public static final StdTypeList INT_SHORTARR_INT = make(Type.INT, Type.SHORT_ARRAY, Type.INT);
  public static final StdTypeList LONG = make(Type.LONG);
  public static final StdTypeList LONGARR_INT;
  public static final StdTypeList LONG_INT;
  public static final StdTypeList LONG_LONG;
  public static final StdTypeList LONG_LONGARR_INT;
  public static final StdTypeList LONG_OBJECT;
  public static final StdTypeList OBJECT;
  public static final StdTypeList OBJECTARR_INT;
  public static final StdTypeList OBJECT_OBJECT;
  public static final StdTypeList OBJECT_OBJECTARR_INT;
  public static final StdTypeList RETURN_ADDRESS;
  public static final StdTypeList SHORTARR_INT;
  public static final StdTypeList THROWABLE;
  
  static
  {
    FLOAT = make(Type.FLOAT);
    DOUBLE = make(Type.DOUBLE);
    OBJECT = make(Type.OBJECT);
    RETURN_ADDRESS = make(Type.RETURN_ADDRESS);
    THROWABLE = make(Type.THROWABLE);
    INT_INT = make(Type.INT, Type.INT);
    LONG_LONG = make(Type.LONG, Type.LONG);
    FLOAT_FLOAT = make(Type.FLOAT, Type.FLOAT);
    DOUBLE_DOUBLE = make(Type.DOUBLE, Type.DOUBLE);
    OBJECT_OBJECT = make(Type.OBJECT, Type.OBJECT);
    INT_OBJECT = make(Type.INT, Type.OBJECT);
    LONG_OBJECT = make(Type.LONG, Type.OBJECT);
    FLOAT_OBJECT = make(Type.FLOAT, Type.OBJECT);
    DOUBLE_OBJECT = make(Type.DOUBLE, Type.OBJECT);
    LONG_INT = make(Type.LONG, Type.INT);
    INTARR_INT = make(Type.INT_ARRAY, Type.INT);
    LONGARR_INT = make(Type.LONG_ARRAY, Type.INT);
    FLOATARR_INT = make(Type.FLOAT_ARRAY, Type.INT);
    DOUBLEARR_INT = make(Type.DOUBLE_ARRAY, Type.INT);
    OBJECTARR_INT = make(Type.OBJECT_ARRAY, Type.INT);
    BOOLEANARR_INT = make(Type.BOOLEAN_ARRAY, Type.INT);
    BYTEARR_INT = make(Type.BYTE_ARRAY, Type.INT);
    CHARARR_INT = make(Type.CHAR_ARRAY, Type.INT);
    SHORTARR_INT = make(Type.SHORT_ARRAY, Type.INT);
    INT_INTARR_INT = make(Type.INT, Type.INT_ARRAY, Type.INT);
    LONG_LONGARR_INT = make(Type.LONG, Type.LONG_ARRAY, Type.INT);
    FLOAT_FLOATARR_INT = make(Type.FLOAT, Type.FLOAT_ARRAY, Type.INT);
    DOUBLE_DOUBLEARR_INT = make(Type.DOUBLE, Type.DOUBLE_ARRAY, Type.INT);
    OBJECT_OBJECTARR_INT = make(Type.OBJECT, Type.OBJECT_ARRAY, Type.INT);
  }
  
  public StdTypeList(int paramInt)
  {
    super(paramInt);
  }
  
  public static int compareContents(TypeList paramTypeList1, TypeList paramTypeList2)
  {
    int j = paramTypeList1.size();
    int k = paramTypeList2.size();
    int m = Math.min(j, k);
    int i = 0;
    while (i < m)
    {
      int n = paramTypeList1.getType(i).compareTo(paramTypeList2.getType(i));
      if (n != 0) {
        return n;
      }
      i += 1;
    }
    if (j == k) {
      return 0;
    }
    if (j < k) {
      return -1;
    }
    return 1;
  }
  
  public static boolean equalContents(TypeList paramTypeList1, TypeList paramTypeList2)
  {
    int j = paramTypeList1.size();
    if (paramTypeList2.size() != j) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label53;
      }
      if (!paramTypeList1.getType(i).equals(paramTypeList2.getType(i))) {
        break;
      }
      i += 1;
    }
    label53:
    return true;
  }
  
  public static int hashContents(TypeList paramTypeList)
  {
    int i = 0;
    int k = paramTypeList.size();
    int j = 0;
    while (i < k)
    {
      j = j * 31 + paramTypeList.getType(i).hashCode();
      i += 1;
    }
    return j;
  }
  
  public static StdTypeList make(Type paramType)
  {
    StdTypeList localStdTypeList = new StdTypeList(1);
    localStdTypeList.set(0, paramType);
    return localStdTypeList;
  }
  
  public static StdTypeList make(Type paramType1, Type paramType2)
  {
    StdTypeList localStdTypeList = new StdTypeList(2);
    localStdTypeList.set(0, paramType1);
    localStdTypeList.set(1, paramType2);
    return localStdTypeList;
  }
  
  public static StdTypeList make(Type paramType1, Type paramType2, Type paramType3)
  {
    StdTypeList localStdTypeList = new StdTypeList(3);
    localStdTypeList.set(0, paramType1);
    localStdTypeList.set(1, paramType2);
    localStdTypeList.set(2, paramType3);
    return localStdTypeList;
  }
  
  public static StdTypeList make(Type paramType1, Type paramType2, Type paramType3, Type paramType4)
  {
    StdTypeList localStdTypeList = new StdTypeList(4);
    localStdTypeList.set(0, paramType1);
    localStdTypeList.set(1, paramType2);
    localStdTypeList.set(2, paramType3);
    localStdTypeList.set(3, paramType4);
    return localStdTypeList;
  }
  
  public static String toHuman(TypeList paramTypeList)
  {
    int j = paramTypeList.size();
    if (j == 0) {
      return "<empty>";
    }
    StringBuffer localStringBuffer = new StringBuffer(100);
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append(paramTypeList.getType(i).toHuman());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public Type get(int paramInt)
  {
    return (Type)get0(paramInt);
  }
  
  public Type getType(int paramInt)
  {
    return get(paramInt);
  }
  
  public int getWordCount()
  {
    int i = 0;
    int k = size();
    int j = 0;
    while (i < k)
    {
      j += get(i).getCategory();
      i += 1;
    }
    return j;
  }
  
  public void set(int paramInt, Type paramType)
  {
    set0(paramInt, paramType);
  }
  
  public TypeList withAddedType(Type paramType)
  {
    int j = size();
    StdTypeList localStdTypeList = new StdTypeList(j + 1);
    int i = 0;
    while (i < j)
    {
      localStdTypeList.set0(i, get0(i));
      i += 1;
    }
    localStdTypeList.set(j, paramType);
    localStdTypeList.setImmutable();
    return localStdTypeList;
  }
  
  public StdTypeList withFirst(Type paramType)
  {
    int i = 0;
    int j = size();
    StdTypeList localStdTypeList = new StdTypeList(j + 1);
    localStdTypeList.set0(0, paramType);
    while (i < j)
    {
      localStdTypeList.set0(i + 1, getOrNull0(i));
      i += 1;
    }
    return localStdTypeList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.type.StdTypeList
 * JD-Core Version:    0.7.0.1
 */