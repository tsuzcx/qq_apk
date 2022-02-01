package com.android.dx.rop.code;

import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.FixedSizeList;
import java.util.BitSet;

public final class RegisterSpecList
  extends FixedSizeList
  implements TypeList
{
  public static final RegisterSpecList EMPTY = new RegisterSpecList(0);
  
  public RegisterSpecList(int paramInt)
  {
    super(paramInt);
  }
  
  public static RegisterSpecList make(RegisterSpec paramRegisterSpec)
  {
    RegisterSpecList localRegisterSpecList = new RegisterSpecList(1);
    localRegisterSpecList.set(0, paramRegisterSpec);
    return localRegisterSpecList;
  }
  
  public static RegisterSpecList make(RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2)
  {
    RegisterSpecList localRegisterSpecList = new RegisterSpecList(2);
    localRegisterSpecList.set(0, paramRegisterSpec1);
    localRegisterSpecList.set(1, paramRegisterSpec2);
    return localRegisterSpecList;
  }
  
  public static RegisterSpecList make(RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2, RegisterSpec paramRegisterSpec3)
  {
    RegisterSpecList localRegisterSpecList = new RegisterSpecList(3);
    localRegisterSpecList.set(0, paramRegisterSpec1);
    localRegisterSpecList.set(1, paramRegisterSpec2);
    localRegisterSpecList.set(2, paramRegisterSpec3);
    return localRegisterSpecList;
  }
  
  public static RegisterSpecList make(RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2, RegisterSpec paramRegisterSpec3, RegisterSpec paramRegisterSpec4)
  {
    RegisterSpecList localRegisterSpecList = new RegisterSpecList(4);
    localRegisterSpecList.set(0, paramRegisterSpec1);
    localRegisterSpecList.set(1, paramRegisterSpec2);
    localRegisterSpecList.set(2, paramRegisterSpec3);
    localRegisterSpecList.set(3, paramRegisterSpec4);
    return localRegisterSpecList;
  }
  
  public RegisterSpec get(int paramInt)
  {
    return (RegisterSpec)get0(paramInt);
  }
  
  public int getRegistersSize()
  {
    int m = size();
    int j = 0;
    int i = 0;
    if (j < m)
    {
      RegisterSpec localRegisterSpec = (RegisterSpec)get0(j);
      if (localRegisterSpec == null) {
        break label53;
      }
      int k = localRegisterSpec.getNextReg();
      if (k <= i) {
        break label53;
      }
      i = k;
    }
    label53:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  public Type getType(int paramInt)
  {
    return get(paramInt).getType().getType();
  }
  
  public int getWordCount()
  {
    int i = 0;
    int k = size();
    int j = 0;
    while (i < k)
    {
      j += getType(i).getCategory();
      i += 1;
    }
    return j;
  }
  
  public int indexOfRegister(int paramInt)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (get(i).getReg() == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void set(int paramInt, RegisterSpec paramRegisterSpec)
  {
    set0(paramInt, paramRegisterSpec);
  }
  
  public RegisterSpec specForRegister(int paramInt)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      RegisterSpec localRegisterSpec = get(i);
      if (localRegisterSpec.getReg() == paramInt) {
        return localRegisterSpec;
      }
      i += 1;
    }
    return null;
  }
  
  public RegisterSpecList subset(BitSet paramBitSet)
  {
    int i = 0;
    int j = size() - paramBitSet.cardinality();
    if (j == 0) {
      return EMPTY;
    }
    RegisterSpecList localRegisterSpecList = new RegisterSpecList(j);
    int k;
    for (j = 0; i < size(); j = k)
    {
      k = j;
      if (!paramBitSet.get(i))
      {
        localRegisterSpecList.set0(j, get0(i));
        k = j + 1;
      }
      i += 1;
    }
    if (isImmutable()) {
      localRegisterSpecList.setImmutable();
    }
    return localRegisterSpecList;
  }
  
  public TypeList withAddedType(Type paramType)
  {
    throw new UnsupportedOperationException("unsupported");
  }
  
  public RegisterSpecList withExpandedRegisters(int paramInt, boolean paramBoolean, BitSet paramBitSet)
  {
    int i = size();
    if (i == 0) {
      return this;
    }
    paramBitSet = new RegisterSpecList.Expander(this, paramBitSet, paramInt, paramBoolean, null);
    paramInt = 0;
    while (paramInt < i)
    {
      RegisterSpecList.Expander.access$100(paramBitSet, paramInt);
      paramInt += 1;
    }
    return RegisterSpecList.Expander.access$200(paramBitSet);
  }
  
  public RegisterSpecList withFirst(RegisterSpec paramRegisterSpec)
  {
    int j = size();
    RegisterSpecList localRegisterSpecList = new RegisterSpecList(j + 1);
    int i = 0;
    while (i < j)
    {
      localRegisterSpecList.set0(i + 1, get0(i));
      i += 1;
    }
    localRegisterSpecList.set0(0, paramRegisterSpec);
    if (isImmutable()) {
      localRegisterSpecList.setImmutable();
    }
    return localRegisterSpecList;
  }
  
  public RegisterSpecList withOffset(int paramInt)
  {
    int j = size();
    if (j == 0) {
      return this;
    }
    RegisterSpecList localRegisterSpecList = new RegisterSpecList(j);
    int i = 0;
    while (i < j)
    {
      RegisterSpec localRegisterSpec = (RegisterSpec)get0(i);
      if (localRegisterSpec != null) {
        localRegisterSpecList.set0(i, localRegisterSpec.withOffset(paramInt));
      }
      i += 1;
    }
    if (isImmutable()) {
      localRegisterSpecList.setImmutable();
    }
    return localRegisterSpecList;
  }
  
  public RegisterSpecList withoutFirst()
  {
    int j = size() - 1;
    Object localObject;
    if (j == 0) {
      localObject = EMPTY;
    }
    RegisterSpecList localRegisterSpecList;
    do
    {
      return localObject;
      localRegisterSpecList = new RegisterSpecList(j);
      int i = 0;
      while (i < j)
      {
        localRegisterSpecList.set0(i, get0(i + 1));
        i += 1;
      }
      localObject = localRegisterSpecList;
    } while (!isImmutable());
    localRegisterSpecList.setImmutable();
    return localRegisterSpecList;
  }
  
  public RegisterSpecList withoutLast()
  {
    int j = size() - 1;
    Object localObject;
    if (j == 0) {
      localObject = EMPTY;
    }
    RegisterSpecList localRegisterSpecList;
    do
    {
      return localObject;
      localRegisterSpecList = new RegisterSpecList(j);
      int i = 0;
      while (i < j)
      {
        localRegisterSpecList.set0(i, get0(i));
        i += 1;
      }
      localObject = localRegisterSpecList;
    } while (!isImmutable());
    localRegisterSpecList.setImmutable();
    return localRegisterSpecList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.RegisterSpecList
 * JD-Core Version:    0.7.0.1
 */