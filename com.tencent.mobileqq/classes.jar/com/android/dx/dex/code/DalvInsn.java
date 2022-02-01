package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.type.Type;
import com.android.dx.ssa.RegisterMapper;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import com.android.dx.util.TwoColumnOutput;
import java.util.BitSet;

public abstract class DalvInsn
{
  private int address;
  private final Dop opcode;
  private final SourcePosition position;
  private final RegisterSpecList registers;
  
  public DalvInsn(Dop paramDop, SourcePosition paramSourcePosition, RegisterSpecList paramRegisterSpecList)
  {
    if (paramDop == null) {
      throw new NullPointerException("opcode == null");
    }
    if (paramSourcePosition == null) {
      throw new NullPointerException("position == null");
    }
    if (paramRegisterSpecList == null) {
      throw new NullPointerException("registers == null");
    }
    this.address = -1;
    this.opcode = paramDop;
    this.position = paramSourcePosition;
    this.registers = paramRegisterSpecList;
  }
  
  public static SimpleInsn makeMove(SourcePosition paramSourcePosition, RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2)
  {
    int i = 1;
    boolean bool;
    int j;
    Dop localDop;
    if (paramRegisterSpec1.getCategory() == 1)
    {
      bool = paramRegisterSpec1.getType().isReference();
      j = paramRegisterSpec1.getReg();
      if ((paramRegisterSpec2.getReg() | j) >= 16) {
        break label88;
      }
      if (!bool) {
        break label68;
      }
      localDop = Dops.MOVE_OBJECT;
    }
    for (;;)
    {
      return new SimpleInsn(localDop, paramSourcePosition, RegisterSpecList.make(paramRegisterSpec1, paramRegisterSpec2));
      i = 0;
      break;
      label68:
      if (i != 0)
      {
        localDop = Dops.MOVE;
      }
      else
      {
        localDop = Dops.MOVE_WIDE;
        continue;
        label88:
        if (j < 256)
        {
          if (bool) {
            localDop = Dops.MOVE_OBJECT_FROM16;
          } else if (i != 0) {
            localDop = Dops.MOVE_FROM16;
          } else {
            localDop = Dops.MOVE_WIDE_FROM16;
          }
        }
        else if (bool) {
          localDop = Dops.MOVE_OBJECT_16;
        } else if (i != 0) {
          localDop = Dops.MOVE_16;
        } else {
          localDop = Dops.MOVE_WIDE_16;
        }
      }
    }
  }
  
  protected abstract String argString();
  
  public abstract int codeSize();
  
  public DalvInsn expandedPrefix(BitSet paramBitSet)
  {
    RegisterSpecList localRegisterSpecList = this.registers;
    boolean bool = paramBitSet.get(0);
    if (hasResult()) {
      paramBitSet.set(0);
    }
    localRegisterSpecList = localRegisterSpecList.subset(paramBitSet);
    if (hasResult()) {
      paramBitSet.set(0, bool);
    }
    if (localRegisterSpecList.size() == 0) {
      return null;
    }
    return new HighRegisterPrefix(this.position, localRegisterSpecList);
  }
  
  public DalvInsn expandedSuffix(BitSet paramBitSet)
  {
    if ((hasResult()) && (!paramBitSet.get(0)))
    {
      paramBitSet = this.registers.get(0);
      return makeMove(this.position, paramBitSet, paramBitSet.withReg(0));
    }
    return null;
  }
  
  public DalvInsn expandedVersion(BitSet paramBitSet)
  {
    return withRegisters(this.registers.withExpandedRegisters(0, hasResult(), paramBitSet));
  }
  
  public final int getAddress()
  {
    if (this.address < 0) {
      throw new RuntimeException("address not yet known");
    }
    return this.address;
  }
  
  public DalvInsn getLowRegVersion()
  {
    return withRegisters(this.registers.withExpandedRegisters(0, hasResult(), null));
  }
  
  public final int getMinimumRegisterRequirement(BitSet paramBitSet)
  {
    boolean bool = hasResult();
    int n = this.registers.size();
    if ((bool) && (!paramBitSet.get(0))) {}
    for (int j = this.registers.get(0).getCategory();; j = 0)
    {
      if (bool) {}
      int k;
      for (int i = 1;; i = 0)
      {
        int m;
        for (k = 0; i < n; k = m)
        {
          m = k;
          if (!paramBitSet.get(i)) {
            m = k + this.registers.get(i).getCategory();
          }
          i += 1;
        }
      }
      return Math.max(k, j);
    }
  }
  
  public final int getNextAddress()
  {
    return getAddress() + codeSize();
  }
  
  public final Dop getOpcode()
  {
    return this.opcode;
  }
  
  public final SourcePosition getPosition()
  {
    return this.position;
  }
  
  public final RegisterSpecList getRegisters()
  {
    return this.registers;
  }
  
  public final boolean hasAddress()
  {
    return this.address >= 0;
  }
  
  public final boolean hasResult()
  {
    return this.opcode.hasResult();
  }
  
  public final String identifierString()
  {
    if (this.address != -1) {
      return String.format("%04x", new Object[] { Integer.valueOf(this.address) });
    }
    return Hex.u4(System.identityHashCode(this));
  }
  
  public final String listingString(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = listingString0(paramBoolean);
    if (str == null) {
      return null;
    }
    paramString = paramString + identifierString() + ": ";
    int i = paramString.length();
    if (paramInt == 0) {
      paramInt = str.length();
    }
    for (;;)
    {
      return TwoColumnOutput.toString(paramString, i, "", str, paramInt);
      paramInt -= i;
    }
  }
  
  protected abstract String listingString0(boolean paramBoolean);
  
  public final void setAddress(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("address < 0");
    }
    this.address = paramInt;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append(identifierString());
    localStringBuffer.append(' ');
    localStringBuffer.append(this.position);
    localStringBuffer.append(": ");
    localStringBuffer.append(this.opcode.getName());
    int i = 0;
    if (this.registers.size() != 0)
    {
      localStringBuffer.append(this.registers.toHuman(" ", ", ", null));
      i = 1;
    }
    String str = argString();
    if (str != null)
    {
      if (i != 0) {
        localStringBuffer.append(',');
      }
      localStringBuffer.append(' ');
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
  
  public DalvInsn withMapper(RegisterMapper paramRegisterMapper)
  {
    return withRegisters(paramRegisterMapper.map(getRegisters()));
  }
  
  public abstract DalvInsn withOpcode(Dop paramDop);
  
  public abstract DalvInsn withRegisterOffset(int paramInt);
  
  public abstract DalvInsn withRegisters(RegisterSpecList paramRegisterSpecList);
  
  public abstract void writeTo(AnnotatedOutput paramAnnotatedOutput);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.DalvInsn
 * JD-Core Version:    0.7.0.1
 */