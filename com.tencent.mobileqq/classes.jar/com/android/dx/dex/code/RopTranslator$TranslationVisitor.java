package com.android.dx.dex.code;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.FillArrayDataInsn;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.Insn.Visitor;
import com.android.dx.rop.code.InsnList;
import com.android.dx.rop.code.PlainCstInsn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.code.SwitchInsn;
import com.android.dx.rop.code.ThrowingCstInsn;
import com.android.dx.rop.code.ThrowingInsn;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.util.IntList;
import java.util.ArrayList;

class RopTranslator$TranslationVisitor
  implements Insn.Visitor
{
  private BasicBlock block;
  private CodeAddress lastAddress;
  private final OutputCollector output;
  
  public RopTranslator$TranslationVisitor(RopTranslator paramRopTranslator, OutputCollector paramOutputCollector)
  {
    this.output = paramOutputCollector;
  }
  
  private RegisterSpec getNextMoveResultPseudo()
  {
    int i = this.block.getPrimarySuccessor();
    if (i < 0) {}
    Insn localInsn;
    do
    {
      return null;
      localInsn = RopTranslator.access$500(this.this$0).getBlocks().labelToBlock(i).getInsns().get(0);
    } while (localInsn.getOpcode().getOpcode() != 56);
    return localInsn.getResult();
  }
  
  protected void addOutput(DalvInsn paramDalvInsn)
  {
    this.output.add(paramDalvInsn);
  }
  
  protected void addOutputSuffix(DalvInsn paramDalvInsn)
  {
    this.output.addSuffix(paramDalvInsn);
  }
  
  public void setBlock(BasicBlock paramBasicBlock, CodeAddress paramCodeAddress)
  {
    this.block = paramBasicBlock;
    this.lastAddress = paramCodeAddress;
  }
  
  public void visitFillArrayDataInsn(FillArrayDataInsn paramFillArrayDataInsn)
  {
    SourcePosition localSourcePosition = paramFillArrayDataInsn.getPosition();
    Object localObject = paramFillArrayDataInsn.getConstant();
    ArrayList localArrayList = paramFillArrayDataInsn.getInitValues();
    if (paramFillArrayDataInsn.getOpcode().getBranchingness() != 1) {
      throw new RuntimeException("shouldn't happen");
    }
    CodeAddress localCodeAddress = new CodeAddress(localSourcePosition);
    localObject = new ArrayData(localSourcePosition, this.lastAddress, localArrayList, (Constant)localObject);
    paramFillArrayDataInsn = new TargetInsn(Dops.FILL_ARRAY_DATA, localSourcePosition, RopTranslator.access$000(paramFillArrayDataInsn), localCodeAddress);
    addOutput(this.lastAddress);
    addOutput(paramFillArrayDataInsn);
    addOutputSuffix(new OddSpacer(localSourcePosition));
    addOutputSuffix(localCodeAddress);
    addOutputSuffix((DalvInsn)localObject);
  }
  
  public void visitPlainCstInsn(PlainCstInsn paramPlainCstInsn)
  {
    SourcePosition localSourcePosition = paramPlainCstInsn.getPosition();
    Dop localDop = RopToDop.dopFor(paramPlainCstInsn);
    Object localObject = paramPlainCstInsn.getOpcode();
    int i = ((Rop)localObject).getOpcode();
    if (((Rop)localObject).getBranchingness() != 1) {
      throw new RuntimeException("shouldn't happen");
    }
    if (i == 3)
    {
      if (!RopTranslator.access$200(this.this$0))
      {
        localObject = paramPlainCstInsn.getResult();
        addOutput(new SimpleInsn(localDop, localSourcePosition, RegisterSpecList.make((RegisterSpec)localObject, RegisterSpec.make(((CstInteger)paramPlainCstInsn.getConstant()).getValue() + (RopTranslator.access$300(this.this$0) - RopTranslator.access$400(this.this$0)), ((RegisterSpec)localObject).getType()))));
      }
      return;
    }
    addOutput(new CstInsn(localDop, localSourcePosition, RopTranslator.access$000(paramPlainCstInsn), paramPlainCstInsn.getConstant()));
  }
  
  public void visitPlainInsn(PlainInsn paramPlainInsn)
  {
    Rop localRop = paramPlainInsn.getOpcode();
    if (localRop.getOpcode() == 54) {}
    while (localRop.getOpcode() == 56) {
      return;
    }
    SourcePosition localSourcePosition = paramPlainInsn.getPosition();
    Dop localDop = RopToDop.dopFor(paramPlainInsn);
    switch (localRop.getBranchingness())
    {
    case 3: 
    case 5: 
    default: 
      throw new RuntimeException("shouldn't happen");
    }
    int i;
    for (paramPlainInsn = new SimpleInsn(localDop, localSourcePosition, RopTranslator.access$000(paramPlainInsn));; paramPlainInsn = new TargetInsn(localDop, localSourcePosition, RopTranslator.access$000(paramPlainInsn), RopTranslator.access$100(this.this$0).getStart(i)))
    {
      addOutput(paramPlainInsn);
      return;
      i = this.block.getSuccessors().get(1);
    }
  }
  
  public void visitSwitchInsn(SwitchInsn paramSwitchInsn)
  {
    SourcePosition localSourcePosition = paramSwitchInsn.getPosition();
    Object localObject1 = paramSwitchInsn.getCases();
    Object localObject2 = this.block.getSuccessors();
    int j = ((IntList)localObject1).size();
    int i = ((IntList)localObject2).size();
    int k = this.block.getPrimarySuccessor();
    if ((j != i - 1) || (k != ((IntList)localObject2).get(j))) {
      throw new RuntimeException("shouldn't happen");
    }
    Object localObject3 = new CodeAddress[j];
    i = 0;
    while (i < j)
    {
      k = ((IntList)localObject2).get(i);
      localObject3[i] = RopTranslator.access$100(this.this$0).getStart(k);
      i += 1;
    }
    localObject2 = new CodeAddress(localSourcePosition);
    CodeAddress localCodeAddress = new CodeAddress(this.lastAddress.getPosition(), true);
    localObject3 = new SwitchData(localSourcePosition, localCodeAddress, (IntList)localObject1, (CodeAddress[])localObject3);
    if (((SwitchData)localObject3).isPacked()) {}
    for (localObject1 = Dops.PACKED_SWITCH;; localObject1 = Dops.SPARSE_SWITCH)
    {
      paramSwitchInsn = new TargetInsn((Dop)localObject1, localSourcePosition, RopTranslator.access$000(paramSwitchInsn), (CodeAddress)localObject2);
      addOutput(localCodeAddress);
      addOutput(paramSwitchInsn);
      addOutputSuffix(new OddSpacer(localSourcePosition));
      addOutputSuffix((DalvInsn)localObject2);
      addOutputSuffix((DalvInsn)localObject3);
      return;
    }
  }
  
  public void visitThrowingCstInsn(ThrowingCstInsn paramThrowingCstInsn)
  {
    int j = 1;
    SourcePosition localSourcePosition = paramThrowingCstInsn.getPosition();
    Dop localDop = RopToDop.dopFor(paramThrowingCstInsn);
    Rop localRop = paramThrowingCstInsn.getOpcode();
    Constant localConstant = paramThrowingCstInsn.getConstant();
    if (localRop.getBranchingness() != 6) {
      throw new RuntimeException("shouldn't happen");
    }
    addOutput(this.lastAddress);
    if (localRop.isCallLike())
    {
      addOutput(new CstInsn(localDop, localSourcePosition, paramThrowingCstInsn.getSources(), localConstant));
      return;
    }
    RegisterSpec localRegisterSpec = getNextMoveResultPseudo();
    RegisterSpecList localRegisterSpecList = RopTranslator.access$600(paramThrowingCstInsn, localRegisterSpec);
    int i;
    if ((localDop.hasResult()) || (localRop.getOpcode() == 43))
    {
      i = 1;
      if (localRegisterSpec == null) {
        break label161;
      }
    }
    for (;;)
    {
      if (i == j) {
        break label166;
      }
      throw new RuntimeException("Insn with result/move-result-pseudo mismatch " + paramThrowingCstInsn);
      i = 0;
      break;
      label161:
      j = 0;
    }
    label166:
    if ((localRop.getOpcode() == 41) && (localDop.getOpcode() != 35)) {}
    for (paramThrowingCstInsn = new SimpleInsn(localDop, localSourcePosition, localRegisterSpecList);; paramThrowingCstInsn = new CstInsn(localDop, localSourcePosition, localRegisterSpecList, localConstant))
    {
      addOutput(paramThrowingCstInsn);
      return;
    }
  }
  
  public void visitThrowingInsn(ThrowingInsn paramThrowingInsn)
  {
    SourcePosition localSourcePosition = paramThrowingInsn.getPosition();
    Dop localDop = RopToDop.dopFor(paramThrowingInsn);
    if (paramThrowingInsn.getOpcode().getBranchingness() != 6) {
      throw new RuntimeException("shouldn't happen");
    }
    RegisterSpec localRegisterSpec = getNextMoveResultPseudo();
    boolean bool2 = localDop.hasResult();
    if (localRegisterSpec != null) {}
    for (boolean bool1 = true; bool2 != bool1; bool1 = false) {
      throw new RuntimeException("Insn with result/move-result-pseudo mismatch" + paramThrowingInsn);
    }
    addOutput(this.lastAddress);
    addOutput(new SimpleInsn(localDop, localSourcePosition, RopTranslator.access$600(paramThrowingInsn, localRegisterSpec)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.RopTranslator.TranslationVisitor
 * JD-Core Version:    0.7.0.1
 */