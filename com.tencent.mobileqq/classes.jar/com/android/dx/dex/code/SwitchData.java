package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;

public final class SwitchData
  extends VariableSizeInsn
{
  private final IntList cases;
  private final boolean packed;
  private final CodeAddress[] targets;
  private final CodeAddress user;
  
  public SwitchData(SourcePosition paramSourcePosition, CodeAddress paramCodeAddress, IntList paramIntList, CodeAddress[] paramArrayOfCodeAddress)
  {
    super(paramSourcePosition, RegisterSpecList.EMPTY);
    if (paramCodeAddress == null) {
      throw new NullPointerException("user == null");
    }
    if (paramIntList == null) {
      throw new NullPointerException("cases == null");
    }
    if (paramArrayOfCodeAddress == null) {
      throw new NullPointerException("targets == null");
    }
    int i = paramIntList.size();
    if (i != paramArrayOfCodeAddress.length) {
      throw new IllegalArgumentException("cases / targets mismatch");
    }
    if (i > 65535) {
      throw new IllegalArgumentException("too many cases");
    }
    this.user = paramCodeAddress;
    this.cases = paramIntList;
    this.targets = paramArrayOfCodeAddress;
    this.packed = shouldPack(paramIntList);
  }
  
  private static long packedCodeSize(IntList paramIntList)
  {
    int i = paramIntList.size();
    long l = paramIntList.get(0);
    l = (paramIntList.get(i - 1) - l + 1L) * 2L + 4L;
    if (l <= 2147483647L) {
      return l;
    }
    return -1L;
  }
  
  private static boolean shouldPack(IntList paramIntList)
  {
    if (paramIntList.size() < 2) {}
    long l1;
    long l2;
    do
    {
      return true;
      l1 = packedCodeSize(paramIntList);
      l2 = sparseCodeSize(paramIntList);
    } while ((l1 >= 0L) && (l1 <= l2 * 5L / 4L));
    return false;
  }
  
  private static long sparseCodeSize(IntList paramIntList)
  {
    return paramIntList.size() * 4L + 2L;
  }
  
  protected String argString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    int j = this.targets.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append("\n    ");
      localStringBuffer.append(this.cases.get(i));
      localStringBuffer.append(": ");
      localStringBuffer.append(this.targets[i]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public int codeSize()
  {
    if (this.packed) {
      return (int)packedCodeSize(this.cases);
    }
    return (int)sparseCodeSize(this.cases);
  }
  
  public boolean isPacked()
  {
    return this.packed;
  }
  
  protected String listingString0(boolean paramBoolean)
  {
    int j = this.user.getAddress();
    StringBuffer localStringBuffer = new StringBuffer(100);
    int k = this.targets.length;
    if (this.packed) {}
    for (String str = "packed";; str = "sparse")
    {
      localStringBuffer.append(str);
      localStringBuffer.append("-switch-payload // for switch @ ");
      localStringBuffer.append(Hex.u2(j));
      int i = 0;
      while (i < k)
      {
        int m = this.targets[i].getAddress();
        localStringBuffer.append("\n  ");
        localStringBuffer.append(this.cases.get(i));
        localStringBuffer.append(": ");
        localStringBuffer.append(Hex.u4(m));
        localStringBuffer.append(" // ");
        localStringBuffer.append(Hex.s4(m - j));
        i += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  public DalvInsn withRegisters(RegisterSpecList paramRegisterSpecList)
  {
    return new SwitchData(getPosition(), this.user, this.cases, this.targets);
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput)
  {
    int m = 0;
    int k = 0;
    int i1 = this.user.getAddress();
    int n = Dops.PACKED_SWITCH.getFormat().codeSize();
    int i2 = this.targets.length;
    int i;
    int j;
    if (this.packed)
    {
      if (i2 == 0)
      {
        i = 0;
        if (i2 != 0) {
          break label139;
        }
        j = 0;
        label54:
        i2 = j - i + 1;
        paramAnnotatedOutput.writeShort(256);
        paramAnnotatedOutput.writeShort(i2);
        paramAnnotatedOutput.writeInt(i);
        j = 0;
        label87:
        if (j >= i2) {
          return;
        }
        if (this.cases.get(k) <= i + j) {
          break label154;
        }
        m = n;
      }
      for (;;)
      {
        paramAnnotatedOutput.writeInt(m);
        j += 1;
        break label87;
        i = this.cases.get(0);
        break;
        label139:
        j = this.cases.get(i2 - 1);
        break label54;
        label154:
        m = this.targets[k].getAddress() - i1;
        k += 1;
      }
    }
    else
    {
      paramAnnotatedOutput.writeShort(512);
      paramAnnotatedOutput.writeShort(i2);
      i = 0;
      for (;;)
      {
        j = m;
        if (i >= i2) {
          break;
        }
        paramAnnotatedOutput.writeInt(this.cases.get(i));
        i += 1;
      }
      while (j < i2)
      {
        paramAnnotatedOutput.writeInt(this.targets[j].getAddress() - i1);
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.SwitchData
 * JD-Core Version:    0.7.0.1
 */