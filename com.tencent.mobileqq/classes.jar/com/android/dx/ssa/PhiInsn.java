package com.android.dx.ssa;

import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PhiInsn
  extends SsaInsn
{
  private final ArrayList<PhiInsn.Operand> operands = new ArrayList();
  private final int ropResultReg;
  private RegisterSpecList sources;
  
  public PhiInsn(int paramInt, SsaBasicBlock paramSsaBasicBlock)
  {
    super(RegisterSpec.make(paramInt, Type.VOID), paramSsaBasicBlock);
    this.ropResultReg = paramInt;
  }
  
  public PhiInsn(RegisterSpec paramRegisterSpec, SsaBasicBlock paramSsaBasicBlock)
  {
    super(paramRegisterSpec, paramSsaBasicBlock);
    this.ropResultReg = paramRegisterSpec.getReg();
  }
  
  public void accept(SsaInsn.Visitor paramVisitor)
  {
    paramVisitor.visitPhiInsn(this);
  }
  
  public void addPhiOperand(RegisterSpec paramRegisterSpec, SsaBasicBlock paramSsaBasicBlock)
  {
    this.operands.add(new PhiInsn.Operand(paramRegisterSpec, paramSsaBasicBlock.getIndex(), paramSsaBasicBlock.getRopLabel()));
    this.sources = null;
  }
  
  public boolean areAllOperandsEqual()
  {
    if (this.operands.size() == 0) {
      return true;
    }
    int i = ((PhiInsn.Operand)this.operands.get(0)).regSpec.getReg();
    Iterator localIterator = this.operands.iterator();
    while (localIterator.hasNext()) {
      if (i != ((PhiInsn.Operand)localIterator.next()).regSpec.getReg()) {
        return false;
      }
    }
    return true;
  }
  
  public boolean canThrow()
  {
    return false;
  }
  
  public void changeResultType(TypeBearer paramTypeBearer, LocalItem paramLocalItem)
  {
    setResult(RegisterSpec.makeLocalOptional(getResult().getReg(), paramTypeBearer, paramLocalItem));
  }
  
  public PhiInsn clone()
  {
    throw new UnsupportedOperationException("can't clone phi");
  }
  
  public Rop getOpcode()
  {
    return null;
  }
  
  public Insn getOriginalRopInsn()
  {
    return null;
  }
  
  public int getRopResultReg()
  {
    return this.ropResultReg;
  }
  
  public RegisterSpecList getSources()
  {
    if (this.sources != null) {
      return this.sources;
    }
    if (this.operands.size() == 0) {
      return RegisterSpecList.EMPTY;
    }
    int j = this.operands.size();
    this.sources = new RegisterSpecList(j);
    int i = 0;
    while (i < j)
    {
      PhiInsn.Operand localOperand = (PhiInsn.Operand)this.operands.get(i);
      this.sources.set(i, localOperand.regSpec);
      i += 1;
    }
    this.sources.setImmutable();
    return this.sources;
  }
  
  public boolean hasSideEffect()
  {
    return (Optimizer.getPreserveLocals()) && (getLocalAssignment() != null);
  }
  
  public boolean isPhiOrMove()
  {
    return true;
  }
  
  public boolean isRegASource(int paramInt)
  {
    Iterator localIterator = this.operands.iterator();
    while (localIterator.hasNext()) {
      if (((PhiInsn.Operand)localIterator.next()).regSpec.getReg() == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public final void mapSourceRegisters(RegisterMapper paramRegisterMapper)
  {
    Iterator localIterator = this.operands.iterator();
    while (localIterator.hasNext())
    {
      PhiInsn.Operand localOperand = (PhiInsn.Operand)localIterator.next();
      RegisterSpec localRegisterSpec = localOperand.regSpec;
      localOperand.regSpec = paramRegisterMapper.map(localRegisterSpec);
      if (localRegisterSpec != localOperand.regSpec) {
        getBlock().getParent().onSourceChanged(this, localRegisterSpec, localOperand.regSpec);
      }
    }
    this.sources = null;
  }
  
  public int predBlockIndexForSourcesIndex(int paramInt)
  {
    return ((PhiInsn.Operand)this.operands.get(paramInt)).blockIndex;
  }
  
  public List<SsaBasicBlock> predBlocksForReg(int paramInt, SsaMethod paramSsaMethod)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.operands.iterator();
    while (localIterator.hasNext())
    {
      PhiInsn.Operand localOperand = (PhiInsn.Operand)localIterator.next();
      if (localOperand.regSpec.getReg() == paramInt) {
        localArrayList.add(paramSsaMethod.getBlocks().get(localOperand.blockIndex));
      }
    }
    return localArrayList;
  }
  
  public void removePhiRegister(RegisterSpec paramRegisterSpec)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.operands.iterator();
    while (localIterator.hasNext())
    {
      PhiInsn.Operand localOperand = (PhiInsn.Operand)localIterator.next();
      if (localOperand.regSpec.getReg() == paramRegisterSpec.getReg()) {
        localArrayList.add(localOperand);
      }
    }
    this.operands.removeAll(localArrayList);
    this.sources = null;
  }
  
  public String toHuman()
  {
    return toHumanWithInline(null);
  }
  
  protected final String toHumanWithInline(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(80);
    localStringBuffer.append(SourcePosition.NO_INFO);
    localStringBuffer.append(": phi");
    if (paramString != null)
    {
      localStringBuffer.append("(");
      localStringBuffer.append(paramString);
      localStringBuffer.append(")");
    }
    paramString = getResult();
    int j;
    if (paramString == null)
    {
      localStringBuffer.append(" .");
      localStringBuffer.append(" <-");
      j = getSources().size();
      if (j != 0) {
        break label127;
      }
      localStringBuffer.append(" .");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(" ");
      localStringBuffer.append(paramString.toHuman());
      break;
      label127:
      int i = 0;
      while (i < j)
      {
        localStringBuffer.append(" ");
        localStringBuffer.append(this.sources.get(i).toHuman() + "[b=" + Hex.u2(((PhiInsn.Operand)this.operands.get(i)).ropLabel) + "]");
        i += 1;
      }
    }
  }
  
  public Insn toRopInsn()
  {
    throw new IllegalArgumentException("Cannot convert phi insns to rop form");
  }
  
  public void updateSourcesToDefinitions(SsaMethod paramSsaMethod)
  {
    Iterator localIterator = this.operands.iterator();
    while (localIterator.hasNext())
    {
      PhiInsn.Operand localOperand = (PhiInsn.Operand)localIterator.next();
      RegisterSpec localRegisterSpec = paramSsaMethod.getDefinitionForRegister(localOperand.regSpec.getReg()).getResult();
      localOperand.regSpec = localOperand.regSpec.withType(localRegisterSpec.getType());
    }
    this.sources = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.PhiInsn
 * JD-Core Version:    0.7.0.1
 */