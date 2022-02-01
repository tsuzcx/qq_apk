package com.android.dx.ssa;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.type.Type;
import com.android.dx.util.IntList;
import java.util.ArrayList;

public class SsaRenamer
  implements Runnable
{
  private static final boolean DEBUG = false;
  private int nextSsaReg;
  private final int ropRegCount;
  private final SsaMethod ssaMeth;
  private final ArrayList<LocalItem> ssaRegToLocalItems;
  private IntList ssaRegToRopReg;
  private final RegisterSpec[][] startsForBlocks;
  private int threshold;
  
  public SsaRenamer(SsaMethod paramSsaMethod)
  {
    this.ropRegCount = paramSsaMethod.getRegCount();
    this.ssaMeth = paramSsaMethod;
    this.nextSsaReg = this.ropRegCount;
    this.threshold = 0;
    this.startsForBlocks = new RegisterSpec[paramSsaMethod.getBlocks().size()][];
    this.ssaRegToLocalItems = new ArrayList();
    RegisterSpec[] arrayOfRegisterSpec = new RegisterSpec[this.ropRegCount];
    while (i < this.ropRegCount)
    {
      arrayOfRegisterSpec[i] = RegisterSpec.make(i, Type.VOID);
      i += 1;
    }
    this.startsForBlocks[paramSsaMethod.getEntryBlockIndex()] = arrayOfRegisterSpec;
  }
  
  public SsaRenamer(SsaMethod paramSsaMethod, int paramInt)
  {
    this(paramSsaMethod);
    this.threshold = paramInt;
  }
  
  private static RegisterSpec[] dupArray(RegisterSpec[] paramArrayOfRegisterSpec)
  {
    RegisterSpec[] arrayOfRegisterSpec = new RegisterSpec[paramArrayOfRegisterSpec.length];
    System.arraycopy(paramArrayOfRegisterSpec, 0, arrayOfRegisterSpec, 0, paramArrayOfRegisterSpec.length);
    return arrayOfRegisterSpec;
  }
  
  private static boolean equalsHandlesNulls(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private LocalItem getLocalForNewReg(int paramInt)
  {
    if (paramInt < this.ssaRegToLocalItems.size()) {
      return (LocalItem)this.ssaRegToLocalItems.get(paramInt);
    }
    return null;
  }
  
  private boolean isBelowThresholdRegister(int paramInt)
  {
    return paramInt < this.threshold;
  }
  
  private boolean isVersionZeroRegister(int paramInt)
  {
    return paramInt < this.ropRegCount;
  }
  
  private void setNameForSsaReg(RegisterSpec paramRegisterSpec)
  {
    int i = paramRegisterSpec.getReg();
    paramRegisterSpec = paramRegisterSpec.getLocalItem();
    this.ssaRegToLocalItems.ensureCapacity(i + 1);
    while (this.ssaRegToLocalItems.size() <= i) {
      this.ssaRegToLocalItems.add(null);
    }
    this.ssaRegToLocalItems.set(i, paramRegisterSpec);
  }
  
  public void run()
  {
    this.ssaMeth.forEachBlockDepthFirstDom(new SsaRenamer.1(this));
    this.ssaMeth.setNewRegCount(this.nextSsaReg);
    this.ssaMeth.onInsnsChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SsaRenamer
 * JD-Core Version:    0.7.0.1
 */