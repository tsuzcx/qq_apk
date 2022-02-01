package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.util.AnnotatedOutput;

public final class HighRegisterPrefix
  extends VariableSizeInsn
{
  private SimpleInsn[] insns;
  
  public HighRegisterPrefix(SourcePosition paramSourcePosition, RegisterSpecList paramRegisterSpecList)
  {
    super(paramSourcePosition, paramRegisterSpecList);
    if (paramRegisterSpecList.size() == 0) {
      throw new IllegalArgumentException("registers.size() == 0");
    }
    this.insns = null;
  }
  
  private void calculateInsnsIfNecessary()
  {
    int j = 0;
    if (this.insns != null) {}
    for (;;)
    {
      return;
      RegisterSpecList localRegisterSpecList = getRegisters();
      int k = localRegisterSpecList.size();
      this.insns = new SimpleInsn[k];
      int i = 0;
      while (i < k)
      {
        RegisterSpec localRegisterSpec = localRegisterSpecList.get(i);
        this.insns[i] = moveInsnFor(localRegisterSpec, j);
        j += localRegisterSpec.getCategory();
        i += 1;
      }
    }
  }
  
  private static SimpleInsn moveInsnFor(RegisterSpec paramRegisterSpec, int paramInt)
  {
    return DalvInsn.makeMove(SourcePosition.NO_INFO, RegisterSpec.make(paramInt, paramRegisterSpec.getType()), paramRegisterSpec);
  }
  
  protected String argString()
  {
    return null;
  }
  
  public int codeSize()
  {
    int i = 0;
    calculateInsnsIfNecessary();
    SimpleInsn[] arrayOfSimpleInsn = this.insns;
    int k = arrayOfSimpleInsn.length;
    int j = 0;
    while (i < k)
    {
      j += arrayOfSimpleInsn[i].codeSize();
      i += 1;
    }
    return j;
  }
  
  protected String listingString0(boolean paramBoolean)
  {
    int j = 0;
    RegisterSpecList localRegisterSpecList = getRegisters();
    int k = localRegisterSpecList.size();
    StringBuffer localStringBuffer = new StringBuffer(100);
    int i = 0;
    while (i < k)
    {
      RegisterSpec localRegisterSpec = localRegisterSpecList.get(i);
      SimpleInsn localSimpleInsn = moveInsnFor(localRegisterSpec, j);
      if (i != 0) {
        localStringBuffer.append('\n');
      }
      localStringBuffer.append(localSimpleInsn.listingString0(paramBoolean));
      j += localRegisterSpec.getCategory();
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public DalvInsn withRegisters(RegisterSpecList paramRegisterSpecList)
  {
    return new HighRegisterPrefix(getPosition(), paramRegisterSpecList);
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput)
  {
    calculateInsnsIfNecessary();
    SimpleInsn[] arrayOfSimpleInsn = this.insns;
    int j = arrayOfSimpleInsn.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSimpleInsn[i].writeTo(paramAnnotatedOutput);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.HighRegisterPrefix
 * JD-Core Version:    0.7.0.1
 */