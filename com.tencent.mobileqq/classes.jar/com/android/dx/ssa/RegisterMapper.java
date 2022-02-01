package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.RegisterSpecSet;

public abstract class RegisterMapper
{
  public abstract int getNewRegisterCount();
  
  public abstract RegisterSpec map(RegisterSpec paramRegisterSpec);
  
  public final RegisterSpecList map(RegisterSpecList paramRegisterSpecList)
  {
    int j = paramRegisterSpecList.size();
    RegisterSpecList localRegisterSpecList = new RegisterSpecList(j);
    int i = 0;
    while (i < j)
    {
      localRegisterSpecList.set(i, map(paramRegisterSpecList.get(i)));
      i += 1;
    }
    localRegisterSpecList.setImmutable();
    if (localRegisterSpecList.equals(paramRegisterSpecList)) {
      return paramRegisterSpecList;
    }
    return localRegisterSpecList;
  }
  
  public final RegisterSpecSet map(RegisterSpecSet paramRegisterSpecSet)
  {
    int j = paramRegisterSpecSet.getMaxSize();
    RegisterSpecSet localRegisterSpecSet = new RegisterSpecSet(getNewRegisterCount());
    int i = 0;
    while (i < j)
    {
      RegisterSpec localRegisterSpec = paramRegisterSpecSet.get(i);
      if (localRegisterSpec != null) {
        localRegisterSpecSet.put(map(localRegisterSpec));
      }
      i += 1;
    }
    localRegisterSpecSet.setImmutable();
    if (localRegisterSpecSet.equals(paramRegisterSpecSet)) {
      return paramRegisterSpecSet;
    }
    return localRegisterSpecSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.RegisterMapper
 * JD-Core Version:    0.7.0.1
 */