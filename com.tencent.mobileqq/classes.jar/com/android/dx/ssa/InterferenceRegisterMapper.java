package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.ssa.back.InterferenceGraph;
import com.android.dx.util.BitIntSet;
import com.android.dx.util.IntSet;
import java.util.ArrayList;

public class InterferenceRegisterMapper
  extends BasicRegisterMapper
{
  private final ArrayList<BitIntSet> newRegInterference = new ArrayList();
  private final InterferenceGraph oldRegInterference;
  
  public InterferenceRegisterMapper(InterferenceGraph paramInterferenceGraph, int paramInt)
  {
    super(paramInt);
    this.oldRegInterference = paramInterferenceGraph;
  }
  
  private void addInterfence(int paramInt1, int paramInt2)
  {
    this.newRegInterference.ensureCapacity(paramInt1 + 1);
    while (paramInt1 >= this.newRegInterference.size()) {
      this.newRegInterference.add(new BitIntSet(paramInt1 + 1));
    }
    this.oldRegInterference.mergeInterferenceSet(paramInt2, (IntSet)this.newRegInterference.get(paramInt1));
  }
  
  public void addMapping(int paramInt1, int paramInt2, int paramInt3)
  {
    super.addMapping(paramInt1, paramInt2, paramInt3);
    addInterfence(paramInt2, paramInt1);
    if (paramInt3 == 2) {
      addInterfence(paramInt2 + 1, paramInt1);
    }
  }
  
  public boolean areAnyPinned(RegisterSpecList paramRegisterSpecList, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    int j = paramRegisterSpecList.size();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        RegisterSpec localRegisterSpec = paramRegisterSpecList.get(i);
        int k = oldToNew(localRegisterSpec.getReg());
        if ((k == paramInt1) || ((localRegisterSpec.getCategory() == 2) && (k + 1 == paramInt1)) || ((paramInt2 == 2) && (k == paramInt1 + 1))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean interferes(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 >= this.newRegInterference.size()) {}
    IntSet localIntSet;
    do
    {
      return false;
      localIntSet = (IntSet)this.newRegInterference.get(paramInt2);
    } while (localIntSet == null);
    if (paramInt3 == 1) {
      return localIntSet.has(paramInt1);
    }
    if ((localIntSet.has(paramInt1)) || (interferes(paramInt1, paramInt2 + 1, paramInt3 - 1))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean interferes(RegisterSpec paramRegisterSpec, int paramInt)
  {
    return interferes(paramRegisterSpec.getReg(), paramInt, paramRegisterSpec.getCategory());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.InterferenceRegisterMapper
 * JD-Core Version:    0.7.0.1
 */