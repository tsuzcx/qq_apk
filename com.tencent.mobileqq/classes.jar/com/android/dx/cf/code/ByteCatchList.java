package com.android.dx.cf.code;

import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.FixedSizeList;
import com.android.dx.util.IntList;

public final class ByteCatchList
  extends FixedSizeList
{
  public static final ByteCatchList EMPTY = new ByteCatchList(0);
  
  public ByteCatchList(int paramInt)
  {
    super(paramInt);
  }
  
  private static boolean typeNotFound(ByteCatchList.Item paramItem, ByteCatchList.Item[] paramArrayOfItem, int paramInt)
  {
    paramItem = paramItem.getExceptionClass();
    int i = 0;
    while (i < paramInt)
    {
      CstType localCstType = paramArrayOfItem[i].getExceptionClass();
      if ((localCstType == paramItem) || (localCstType == CstType.OBJECT)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int byteLength()
  {
    return size() * 8 + 2;
  }
  
  public ByteCatchList.Item get(int paramInt)
  {
    return (ByteCatchList.Item)get0(paramInt);
  }
  
  public ByteCatchList listFor(int paramInt)
  {
    int m = 0;
    int n = size();
    ByteCatchList.Item[] arrayOfItem = new ByteCatchList.Item[n];
    int j = 0;
    int k;
    for (int i = 0; j < n; i = k)
    {
      localObject = get(j);
      k = i;
      if (((ByteCatchList.Item)localObject).covers(paramInt))
      {
        k = i;
        if (typeNotFound((ByteCatchList.Item)localObject, arrayOfItem, i))
        {
          arrayOfItem[i] = localObject;
          k = i + 1;
        }
      }
      j += 1;
    }
    if (i == 0) {
      return EMPTY;
    }
    Object localObject = new ByteCatchList(i);
    paramInt = m;
    while (paramInt < i)
    {
      ((ByteCatchList)localObject).set(paramInt, arrayOfItem[paramInt]);
      paramInt += 1;
    }
    ((ByteCatchList)localObject).setImmutable();
    return localObject;
  }
  
  public void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CstType paramCstType)
  {
    set0(paramInt1, new ByteCatchList.Item(paramInt2, paramInt3, paramInt4, paramCstType));
  }
  
  public void set(int paramInt, ByteCatchList.Item paramItem)
  {
    if (paramItem == null) {
      throw new NullPointerException("item == null");
    }
    set0(paramInt, paramItem);
  }
  
  public TypeList toRopCatchList()
  {
    int j = size();
    if (j == 0) {
      return StdTypeList.EMPTY;
    }
    StdTypeList localStdTypeList = new StdTypeList(j);
    int i = 0;
    while (i < j)
    {
      localStdTypeList.set(i, get(i).getExceptionClass().getClassType());
      i += 1;
    }
    localStdTypeList.setImmutable();
    return localStdTypeList;
  }
  
  public IntList toTargetList(int paramInt)
  {
    int j = 1;
    int k = 0;
    if (paramInt < -1) {
      throw new IllegalArgumentException("noException < -1");
    }
    if (paramInt >= 0) {}
    int m;
    for (int i = 1;; i = 0)
    {
      m = size();
      if (m != 0) {
        break label55;
      }
      if (i == 0) {
        break;
      }
      return IntList.makeImmutable(paramInt);
    }
    return IntList.EMPTY;
    label55:
    if (i != 0) {}
    IntList localIntList;
    for (;;)
    {
      localIntList = new IntList(j + m);
      j = k;
      while (j < m)
      {
        localIntList.add(get(j).getHandlerPc());
        j += 1;
      }
      j = 0;
    }
    if (i != 0) {
      localIntList.add(paramInt);
    }
    localIntList.setImmutable();
    return localIntList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.ByteCatchList
 * JD-Core Version:    0.7.0.1
 */