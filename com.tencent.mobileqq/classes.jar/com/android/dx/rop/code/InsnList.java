package com.android.dx.rop.code;

import com.android.dx.util.FixedSizeList;

public final class InsnList
  extends FixedSizeList
{
  public InsnList(int paramInt)
  {
    super(paramInt);
  }
  
  public boolean contentEquals(InsnList paramInsnList)
  {
    if (paramInsnList == null) {}
    int j;
    do
    {
      return false;
      j = size();
    } while (j != paramInsnList.size());
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label49;
      }
      if (!get(i).contentEquals(paramInsnList.get(i))) {
        break;
      }
      i += 1;
    }
    label49:
    return true;
  }
  
  public void forEach(Insn.Visitor paramVisitor)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      get(i).accept(paramVisitor);
      i += 1;
    }
  }
  
  public Insn get(int paramInt)
  {
    return (Insn)get0(paramInt);
  }
  
  public Insn getLast()
  {
    return get(size() - 1);
  }
  
  public void set(int paramInt, Insn paramInsn)
  {
    set0(paramInt, paramInsn);
  }
  
  public InsnList withRegisterOffset(int paramInt)
  {
    int j = size();
    InsnList localInsnList = new InsnList(j);
    int i = 0;
    while (i < j)
    {
      Insn localInsn = (Insn)get0(i);
      if (localInsn != null) {
        localInsnList.set0(i, localInsn.withRegisterOffset(paramInt));
      }
      i += 1;
    }
    if (isImmutable()) {
      localInsnList.setImmutable();
    }
    return localInsnList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.InsnList
 * JD-Core Version:    0.7.0.1
 */