package com.android.dx.cf.code;

import com.android.dx.cf.iface.MethodList;
import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlock.Visitor;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.InsnList;
import com.android.dx.rop.code.PlainCstInsn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.code.ThrowingCstInsn;
import com.android.dx.rop.code.ThrowingInsn;
import com.android.dx.rop.code.TranslationAdvice;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.Bits;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;

public final class Ropper
{
  private static final int PARAM_ASSIGNMENT = -1;
  private static final int RETURN = -2;
  private static final int SPECIAL_LABEL_COUNT = 7;
  private static final int SYNCH_CATCH_1 = -6;
  private static final int SYNCH_CATCH_2 = -7;
  private static final int SYNCH_RETURN = -3;
  private static final int SYNCH_SETUP_1 = -4;
  private static final int SYNCH_SETUP_2 = -5;
  private final ByteBlockList blocks;
  private final Ropper.CatchInfo[] catchInfos;
  private final Ropper.ExceptionSetupLabelAllocator exceptionSetupLabelAllocator;
  private boolean hasSubroutines;
  private final RopperMachine machine;
  private final int maxLabel;
  private final int maxLocals;
  private final ConcreteMethod method;
  private final ArrayList<BasicBlock> result;
  private final ArrayList<IntList> resultSubroutines;
  private final Simulator sim;
  private final Frame[] startFrames;
  private final Ropper.Subroutine[] subroutines;
  private boolean synchNeedsExceptionHandler;
  
  private Ropper(ConcreteMethod paramConcreteMethod, TranslationAdvice paramTranslationAdvice, MethodList paramMethodList)
  {
    if (paramConcreteMethod == null) {
      throw new NullPointerException("method == null");
    }
    if (paramTranslationAdvice == null) {
      throw new NullPointerException("advice == null");
    }
    this.method = paramConcreteMethod;
    this.blocks = BasicBlocker.identifyBlocks(paramConcreteMethod);
    this.maxLabel = this.blocks.getMaxLabel();
    this.maxLocals = paramConcreteMethod.getMaxLocals();
    this.machine = new RopperMachine(this, paramConcreteMethod, paramTranslationAdvice, paramMethodList);
    this.sim = new Simulator(this.machine, paramConcreteMethod);
    this.startFrames = new Frame[this.maxLabel];
    this.subroutines = new Ropper.Subroutine[this.maxLabel];
    this.result = new ArrayList(this.blocks.size() * 2 + 10);
    this.resultSubroutines = new ArrayList(this.blocks.size() * 2 + 10);
    this.catchInfos = new Ropper.CatchInfo[this.maxLabel];
    this.synchNeedsExceptionHandler = false;
    this.startFrames[0] = new Frame(this.maxLocals, paramConcreteMethod.getMaxStack());
    this.exceptionSetupLabelAllocator = new Ropper.ExceptionSetupLabelAllocator(this);
  }
  
  private void addBlock(BasicBlock paramBasicBlock, IntList paramIntList)
  {
    if (paramBasicBlock == null) {
      throw new NullPointerException("block == null");
    }
    this.result.add(paramBasicBlock);
    paramIntList.throwIfMutable();
    this.resultSubroutines.add(paramIntList);
  }
  
  private void addExceptionSetupBlocks()
  {
    int j = this.catchInfos.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = this.catchInfos[i];
      if (localObject != null)
      {
        localObject = ((Ropper.CatchInfo)localObject).getSetups().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Ropper.ExceptionHandlerSetup localExceptionHandlerSetup = (Ropper.ExceptionHandlerSetup)((Iterator)localObject).next();
          SourcePosition localSourcePosition = labelToBlock(i).getFirstInsn().getPosition();
          InsnList localInsnList = new InsnList(2);
          localInsnList.set(0, new PlainInsn(Rops.opMoveException(localExceptionHandlerSetup.getCaughtType()), localSourcePosition, RegisterSpec.make(this.maxLocals, localExceptionHandlerSetup.getCaughtType()), RegisterSpecList.EMPTY));
          localInsnList.set(1, new PlainInsn(Rops.GOTO, localSourcePosition, null, RegisterSpecList.EMPTY));
          localInsnList.setImmutable();
          addBlock(new BasicBlock(localExceptionHandlerSetup.getLabel(), localInsnList, IntList.makeImmutable(i), i), this.startFrames[i].getSubroutines());
        }
      }
      i += 1;
    }
  }
  
  private boolean addOrReplaceBlock(BasicBlock paramBasicBlock, IntList paramIntList)
  {
    if (paramBasicBlock == null) {
      throw new NullPointerException("block == null");
    }
    int i = labelToResultIndex(paramBasicBlock.getLabel());
    if (i < 0) {}
    for (boolean bool = false;; bool = true)
    {
      this.result.add(paramBasicBlock);
      paramIntList.throwIfMutable();
      this.resultSubroutines.add(paramIntList);
      return bool;
      removeBlockAndSpecialSuccessors(i);
    }
  }
  
  private boolean addOrReplaceBlockNoDelete(BasicBlock paramBasicBlock, IntList paramIntList)
  {
    if (paramBasicBlock == null) {
      throw new NullPointerException("block == null");
    }
    int i = labelToResultIndex(paramBasicBlock.getLabel());
    if (i < 0) {}
    for (boolean bool = false;; bool = true)
    {
      this.result.add(paramBasicBlock);
      paramIntList.throwIfMutable();
      this.resultSubroutines.add(paramIntList);
      return bool;
      this.result.remove(i);
      this.resultSubroutines.remove(i);
    }
  }
  
  private void addReturnBlock()
  {
    Rop localRop = this.machine.getReturnOp();
    if (localRop == null) {
      return;
    }
    SourcePosition localSourcePosition = this.machine.getReturnPosition();
    int i = getSpecialLabel(-2);
    Object localObject;
    if (isSynchronized())
    {
      localObject = new InsnList(1);
      ((InsnList)localObject).set(0, new ThrowingInsn(Rops.MONITOR_EXIT, localSourcePosition, RegisterSpecList.make(getSynchReg()), StdTypeList.EMPTY));
      ((InsnList)localObject).setImmutable();
      int j = getSpecialLabel(-3);
      addBlock(new BasicBlock(i, (InsnList)localObject, IntList.makeImmutable(j), j), IntList.EMPTY);
      i = j;
    }
    for (;;)
    {
      InsnList localInsnList = new InsnList(1);
      localObject = localRop.getSources();
      if (((TypeList)localObject).size() == 0) {}
      for (localObject = RegisterSpecList.EMPTY;; localObject = RegisterSpecList.make(RegisterSpec.make(0, ((TypeList)localObject).getType(0))))
      {
        localInsnList.set(0, new PlainInsn(localRop, localSourcePosition, null, (RegisterSpecList)localObject));
        localInsnList.setImmutable();
        addBlock(new BasicBlock(i, localInsnList, IntList.EMPTY, -1), IntList.EMPTY);
        return;
      }
    }
  }
  
  private void addSetupBlocks()
  {
    Object localObject3 = this.method.getLocalVariables();
    Object localObject2 = this.method.makeSourcePosistion(0);
    Object localObject4 = this.method.getEffectiveDescriptor().getParameterTypes();
    int k = ((StdTypeList)localObject4).size();
    InsnList localInsnList = new InsnList(k + 1);
    int j = 0;
    int i = 0;
    Object localObject1;
    if (j < k)
    {
      Type localType = ((StdTypeList)localObject4).get(j);
      localObject1 = ((LocalVariableList)localObject3).pcAndIndexToLocal(0, i);
      if (localObject1 == null) {}
      for (localObject1 = RegisterSpec.make(i, localType);; localObject1 = RegisterSpec.makeLocalOptional(i, localType, ((LocalVariableList.Item)localObject1).getLocalItem()))
      {
        localInsnList.set(j, new PlainCstInsn(Rops.opMoveParam(localType), (SourcePosition)localObject2, (RegisterSpec)localObject1, RegisterSpecList.EMPTY, CstInteger.make(i)));
        int m = localType.getCategory();
        j += 1;
        i += m;
        break;
      }
    }
    localInsnList.set(k, new PlainInsn(Rops.GOTO, (SourcePosition)localObject2, null, RegisterSpecList.EMPTY));
    localInsnList.setImmutable();
    boolean bool = isSynchronized();
    if (bool)
    {
      i = getSpecialLabel(-4);
      addBlock(new BasicBlock(getSpecialLabel(-1), localInsnList, IntList.makeImmutable(i), i), IntList.EMPTY);
      if (bool)
      {
        localObject3 = getSynchReg();
        if (!isStatic()) {
          break label443;
        }
        localObject4 = new ThrowingCstInsn(Rops.CONST_OBJECT, (SourcePosition)localObject2, RegisterSpecList.EMPTY, StdTypeList.EMPTY, this.method.getDefiningClass());
        localObject1 = new InsnList(1);
        ((InsnList)localObject1).set(0, (Insn)localObject4);
        label286:
        j = getSpecialLabel(-5);
        ((InsnList)localObject1).setImmutable();
        addBlock(new BasicBlock(i, (InsnList)localObject1, IntList.makeImmutable(j), j), IntList.EMPTY);
        if (!isStatic()) {
          break label504;
        }
        i = 2;
        label329:
        localObject1 = new InsnList(i);
        if (isStatic()) {
          ((InsnList)localObject1).set(0, new PlainInsn(Rops.opMoveResultPseudo((TypeBearer)localObject3), (SourcePosition)localObject2, (RegisterSpec)localObject3, RegisterSpecList.EMPTY));
        }
        localObject2 = new ThrowingInsn(Rops.MONITOR_ENTER, (SourcePosition)localObject2, RegisterSpecList.make((RegisterSpec)localObject3), StdTypeList.EMPTY);
        if (!isStatic()) {
          break label509;
        }
      }
    }
    label443:
    label504:
    label509:
    for (i = 1;; i = 0)
    {
      ((InsnList)localObject1).set(i, (Insn)localObject2);
      ((InsnList)localObject1).setImmutable();
      addBlock(new BasicBlock(j, (InsnList)localObject1, IntList.makeImmutable(0), 0), IntList.EMPTY);
      return;
      i = 0;
      break;
      localObject1 = new InsnList(2);
      ((InsnList)localObject1).set(0, new PlainCstInsn(Rops.MOVE_PARAM_OBJECT, (SourcePosition)localObject2, (RegisterSpec)localObject3, RegisterSpecList.EMPTY, CstInteger.VALUE_0));
      ((InsnList)localObject1).set(1, new PlainInsn(Rops.GOTO, (SourcePosition)localObject2, null, RegisterSpecList.EMPTY));
      break label286;
      i = 1;
      break label329;
    }
  }
  
  private void addSynchExceptionHandlerBlock()
  {
    if (!this.synchNeedsExceptionHandler) {
      return;
    }
    SourcePosition localSourcePosition = this.method.makeSourcePosistion(0);
    RegisterSpec localRegisterSpec = RegisterSpec.make(0, Type.THROWABLE);
    InsnList localInsnList = new InsnList(2);
    localInsnList.set(0, new PlainInsn(Rops.opMoveException(Type.THROWABLE), localSourcePosition, localRegisterSpec, RegisterSpecList.EMPTY));
    localInsnList.set(1, new ThrowingInsn(Rops.MONITOR_EXIT, localSourcePosition, RegisterSpecList.make(getSynchReg()), StdTypeList.EMPTY));
    localInsnList.setImmutable();
    int i = getSpecialLabel(-7);
    addBlock(new BasicBlock(getSpecialLabel(-6), localInsnList, IntList.makeImmutable(i), i), IntList.EMPTY);
    localInsnList = new InsnList(1);
    localInsnList.set(0, new ThrowingInsn(Rops.THROW, localSourcePosition, RegisterSpecList.make(localRegisterSpec), StdTypeList.EMPTY));
    localInsnList.setImmutable();
    addBlock(new BasicBlock(i, localInsnList, IntList.EMPTY, -1), IntList.EMPTY);
  }
  
  public static RopMethod convert(ConcreteMethod paramConcreteMethod, TranslationAdvice paramTranslationAdvice, MethodList paramMethodList)
  {
    try
    {
      paramTranslationAdvice = new Ropper(paramConcreteMethod, paramTranslationAdvice, paramMethodList);
      paramTranslationAdvice.doit();
      paramTranslationAdvice = paramTranslationAdvice.getRopMethod();
      return paramTranslationAdvice;
    }
    catch (SimException paramTranslationAdvice)
    {
      paramTranslationAdvice.addContext("...while working on method " + paramConcreteMethod.getNat().toHuman());
      throw paramTranslationAdvice;
    }
  }
  
  private void deleteUnreachableBlocks()
  {
    IntList localIntList = new IntList(this.result.size());
    this.resultSubroutines.clear();
    forEachNonSubBlockDepthFirst(getSpecialLabel(-1), new Ropper.2(this, localIntList));
    localIntList.sort();
    int i = this.result.size() - 1;
    while (i >= 0)
    {
      if (localIntList.indexOf(((BasicBlock)this.result.get(i)).getLabel()) < 0) {
        this.result.remove(i);
      }
      i -= 1;
    }
  }
  
  private void doit()
  {
    int[] arrayOfInt = Bits.makeBitSet(this.maxLabel);
    Bits.set(arrayOfInt, 0);
    addSetupBlocks();
    setFirstFrame();
    for (;;)
    {
      int i = Bits.findFirst(arrayOfInt, 0);
      if (i < 0)
      {
        addReturnBlock();
        addSynchExceptionHandlerBlock();
        addExceptionSetupBlocks();
        if (this.hasSubroutines) {
          inlineSubroutines();
        }
        return;
      }
      Bits.clear(arrayOfInt, i);
      ByteBlock localByteBlock = this.blocks.labelToBlock(i);
      Frame localFrame = this.startFrames[i];
      try
      {
        processBlock(localByteBlock, localFrame, arrayOfInt);
      }
      catch (SimException localSimException)
      {
        localSimException.addContext("...while working on block " + Hex.u2(i));
        throw localSimException;
      }
    }
  }
  
  private InsnList filterMoveReturnAddressInsns(InsnList paramInsnList)
  {
    int m = 0;
    int n = paramInsnList.size();
    int i = 0;
    int k;
    for (int j = 0; i < n; j = k)
    {
      k = j;
      if (paramInsnList.get(i).getOpcode() != Rops.MOVE_RETURN_ADDRESS) {
        k = j + 1;
      }
      i += 1;
    }
    if (j == n) {
      return paramInsnList;
    }
    InsnList localInsnList = new InsnList(j);
    j = 0;
    i = m;
    if (j < n)
    {
      Insn localInsn = paramInsnList.get(j);
      if (localInsn.getOpcode() == Rops.MOVE_RETURN_ADDRESS) {
        break label129;
      }
      k = i + 1;
      localInsnList.set(i, localInsn);
      i = k;
    }
    label129:
    for (;;)
    {
      j += 1;
      break;
      localInsnList.setImmutable();
      return localInsnList;
    }
  }
  
  private void forEachNonSubBlockDepthFirst(int paramInt, BasicBlock.Visitor paramVisitor)
  {
    forEachNonSubBlockDepthFirst0(labelToBlock(paramInt), paramVisitor, new BitSet(this.maxLabel));
  }
  
  private void forEachNonSubBlockDepthFirst0(BasicBlock paramBasicBlock, BasicBlock.Visitor paramVisitor, BitSet paramBitSet)
  {
    paramVisitor.visitBlock(paramBasicBlock);
    paramBitSet.set(paramBasicBlock.getLabel());
    IntList localIntList = paramBasicBlock.getSuccessors();
    int j = localIntList.size();
    int i = 0;
    if (i < j)
    {
      int k = localIntList.get(i);
      if (paramBitSet.get(k)) {}
      for (;;)
      {
        i += 1;
        break;
        if ((!isSubroutineCaller(paramBasicBlock)) || (i <= 0))
        {
          k = labelToResultIndex(k);
          if (k >= 0) {
            forEachNonSubBlockDepthFirst0((BasicBlock)this.result.get(k), paramVisitor, paramBitSet);
          }
        }
      }
    }
  }
  
  private int getAvailableLabel()
  {
    int i = getMinimumUnreservedLabel();
    Iterator localIterator = this.result.iterator();
    if (localIterator.hasNext())
    {
      int j = ((BasicBlock)localIterator.next()).getLabel();
      if (j < i) {
        break label49;
      }
      i = j + 1;
    }
    label49:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private int getMinimumUnreservedLabel()
  {
    return this.maxLabel + this.method.getCatches().size() + 7;
  }
  
  private int getNormalRegCount()
  {
    return this.maxLocals + this.method.getMaxStack();
  }
  
  private RopMethod getRopMethod()
  {
    int j = this.result.size();
    BasicBlockList localBasicBlockList = new BasicBlockList(j);
    int i = 0;
    while (i < j)
    {
      localBasicBlockList.set(i, (BasicBlock)this.result.get(i));
      i += 1;
    }
    localBasicBlockList.setImmutable();
    return new RopMethod(localBasicBlockList, getSpecialLabel(-1));
  }
  
  private int getSpecialLabel(int paramInt)
  {
    return this.maxLabel + this.method.getCatches().size() + (paramInt ^ 0xFFFFFFFF);
  }
  
  private RegisterSpec getSynchReg()
  {
    int i = 1;
    int j = getNormalRegCount();
    if (j < 1) {}
    for (;;)
    {
      return RegisterSpec.make(i, Type.OBJECT);
      i = j;
    }
  }
  
  private void inlineSubroutines()
  {
    int j = 0;
    IntList localIntList1 = new IntList(4);
    forEachNonSubBlockDepthFirst(0, new Ropper.1(this, localIntList1));
    int k = getAvailableLabel();
    ArrayList localArrayList = new ArrayList(k);
    int i = 0;
    while (i < k)
    {
      localArrayList.add(null);
      i += 1;
    }
    i = 0;
    if (i < this.result.size())
    {
      BasicBlock localBasicBlock = (BasicBlock)this.result.get(i);
      if (localBasicBlock == null) {}
      for (;;)
      {
        i += 1;
        break;
        IntList localIntList2 = (IntList)this.resultSubroutines.get(i);
        localArrayList.set(localBasicBlock.getLabel(), localIntList2);
      }
    }
    k = localIntList1.size();
    i = j;
    while (i < k)
    {
      j = localIntList1.get(i);
      new Ropper.SubroutineInliner(this, new Ropper.LabelAllocator(getAvailableLabel()), localArrayList).inlineSubroutineCalledFrom(labelToBlock(j));
      i += 1;
    }
    deleteUnreachableBlocks();
  }
  
  private boolean isStatic()
  {
    return (this.method.getAccessFlags() & 0x8) != 0;
  }
  
  private boolean isSubroutineCaller(BasicBlock paramBasicBlock)
  {
    boolean bool = true;
    paramBasicBlock = paramBasicBlock.getSuccessors();
    if (paramBasicBlock.size() < 2) {
      return false;
    }
    int i = paramBasicBlock.get(1);
    if ((i < this.subroutines.length) && (this.subroutines[i] != null)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private boolean isSynchronized()
  {
    return (this.method.getAccessFlags() & 0x20) != 0;
  }
  
  private BasicBlock labelToBlock(int paramInt)
  {
    int i = labelToResultIndex(paramInt);
    if (i < 0) {
      throw new IllegalArgumentException("no such label " + Hex.u2(paramInt));
    }
    return (BasicBlock)this.result.get(i);
  }
  
  private int labelToResultIndex(int paramInt)
  {
    int j = this.result.size();
    int i = 0;
    while (i < j)
    {
      if (((BasicBlock)this.result.get(i)).getLabel() == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void mergeAndWorkAsNecessary(int paramInt1, int paramInt2, Ropper.Subroutine paramSubroutine, Frame paramFrame, int[] paramArrayOfInt)
  {
    Frame localFrame = this.startFrames[paramInt1];
    if (localFrame != null)
    {
      if (paramSubroutine != null) {}
      for (paramSubroutine = localFrame.mergeWithSubroutineCaller(paramFrame, paramSubroutine.getStartBlock(), paramInt2);; paramSubroutine = localFrame.mergeWith(paramFrame))
      {
        if (paramSubroutine != localFrame)
        {
          this.startFrames[paramInt1] = paramSubroutine;
          Bits.set(paramArrayOfInt, paramInt1);
        }
        return;
      }
    }
    if (paramSubroutine != null) {
      this.startFrames[paramInt1] = paramFrame.makeNewSubroutineStartFrame(paramInt1, paramInt2);
    }
    for (;;)
    {
      Bits.set(paramArrayOfInt, paramInt1);
      return;
      this.startFrames[paramInt1] = paramFrame;
    }
  }
  
  private void processBlock(ByteBlock paramByteBlock, Frame paramFrame, int[] paramArrayOfInt)
  {
    ByteCatchList localByteCatchList = paramByteBlock.getCatches();
    this.machine.startBlock(localByteCatchList.toRopCatchList());
    Frame localFrame = paramFrame.copy();
    this.sim.simulate(paramByteBlock, localFrame);
    localFrame.setImmutable();
    int i2 = this.machine.getExtraBlockCount();
    ArrayList localArrayList = this.machine.getInsns();
    int i1 = localArrayList.size();
    int i3 = localByteCatchList.size();
    paramFrame = paramByteBlock.getSuccessors();
    Object localObject = null;
    int i;
    int j;
    if (this.machine.hasJsr())
    {
      i = 1;
      j = paramFrame.get(1);
      if (this.subroutines[j] == null) {
        this.subroutines[j] = new Ropper.Subroutine(this, j);
      }
      this.subroutines[j].addCallerBlock(paramByteBlock.getLabel());
      localObject = this.subroutines[j];
    }
    int k;
    for (;;)
    {
      k = paramFrame.size();
      while (i < k)
      {
        j = paramFrame.get(i);
        try
        {
          mergeAndWorkAsNecessary(j, paramByteBlock.getLabel(), (Ropper.Subroutine)localObject, localFrame, paramArrayOfInt);
          i += 1;
        }
        catch (SimException paramByteBlock)
        {
          paramByteBlock.addContext("...while merging to block " + Hex.u2(j));
          throw paramByteBlock;
        }
      }
      if (this.machine.hasRet())
      {
        i = this.machine.getReturnAddress().getSubroutineAddress();
        if (this.subroutines[i] == null) {
          this.subroutines[i] = new Ropper.Subroutine(this, i, paramByteBlock.getLabel());
        }
        for (;;)
        {
          paramFrame = this.subroutines[i].getSuccessors();
          this.subroutines[i].mergeToSuccessors(localFrame, paramArrayOfInt);
          i = paramFrame.size();
          break;
          this.subroutines[i].addRetBlock(paramByteBlock.getLabel());
        }
      }
      if (this.machine.wereCatchesUsed()) {
        i = i3;
      } else {
        i = 0;
      }
    }
    if ((k == 0) && (this.machine.returns()))
    {
      paramFrame = IntList.makeImmutable(getSpecialLabel(-2));
      k = 1;
    }
    label407:
    label793:
    label928:
    label1056:
    for (;;)
    {
      if (k == 0) {
        i = -1;
      }
      label801:
      label1094:
      label1099:
      label1102:
      for (;;)
      {
        int m;
        CstType localCstType;
        int i4;
        if ((isSynchronized()) && (this.machine.canThrow()))
        {
          j = 1;
          if ((j == 0) && (i3 == 0)) {
            break label1099;
          }
          localObject = new IntList(k);
          k = 0;
          m = 0;
          if (m >= i3) {
            break label629;
          }
          paramFrame = localByteCatchList.get(m);
          localCstType = paramFrame.getExceptionClass();
          i4 = paramFrame.getHandlerPc();
          if (localCstType != CstType.OBJECT) {
            break label592;
          }
        }
        for (int n = 1;; n = 0)
        {
          for (;;)
          {
            paramFrame = localFrame.makeExceptionHandlerStartFrame(localCstType);
            try
            {
              mergeAndWorkAsNecessary(i4, paramByteBlock.getLabel(), null, paramFrame, paramArrayOfInt);
              Ropper.CatchInfo localCatchInfo = this.catchInfos[i4];
              paramFrame = localCatchInfo;
              if (localCatchInfo == null)
              {
                paramFrame = new Ropper.CatchInfo(this, null);
                this.catchInfos[i4] = paramFrame;
              }
              ((IntList)localObject).add(paramFrame.getSetup(localCstType.getClassType()).getLabel());
              m += 1;
              k |= n;
            }
            catch (SimException paramByteBlock)
            {
              label592:
              paramByteBlock.addContext("...while merging exception to block " + Hex.u2(i4));
              throw paramByteBlock;
            }
          }
          i = this.machine.getPrimarySuccessorIndex();
          if (i < 0) {
            break label1102;
          }
          i = paramFrame.get(i);
          break;
          j = 0;
          break label407;
        }
        label629:
        if ((j != 0) && (k == 0))
        {
          ((IntList)localObject).add(getSpecialLabel(-6));
          this.synchNeedsExceptionHandler = true;
          j = i1 - i2 - 1;
          while (j < i1)
          {
            paramFrame = (Insn)localArrayList.get(j);
            if (paramFrame.canThrow()) {
              localArrayList.set(j, paramFrame.withAddedCatch(Type.OBJECT));
            }
            j += 1;
          }
        }
        if (i >= 0) {
          ((IntList)localObject).add(i);
        }
        ((IntList)localObject).setImmutable();
        paramFrame = (Frame)localObject;
        for (;;)
        {
          i3 = paramFrame.indexOf(i);
          k = i2;
          m = i1;
          j = i;
          i = m;
          if (k > 0)
          {
            n = i - 1;
            paramArrayOfInt = (Insn)localArrayList.get(n);
            if (paramArrayOfInt.getOpcode().getBranchingness() == 1)
            {
              i = 1;
              if (i == 0) {
                break label928;
              }
              m = 2;
              localObject = new InsnList(m);
              ((InsnList)localObject).set(0, paramArrayOfInt);
              if (i == 0) {
                break label1094;
              }
              ((InsnList)localObject).set(1, new PlainInsn(Rops.GOTO, paramArrayOfInt.getPosition(), null, RegisterSpecList.EMPTY));
            }
          }
          for (paramArrayOfInt = IntList.makeImmutable(j);; paramArrayOfInt = paramFrame)
          {
            ((InsnList)localObject).setImmutable();
            i = getAvailableLabel();
            addBlock(new BasicBlock(i, (InsnList)localObject, paramArrayOfInt, j), localFrame.getSubroutines());
            paramFrame = paramFrame.mutableCopy();
            paramFrame.set(i3, i);
            paramFrame.setImmutable();
            j = i;
            k -= 1;
            i = n;
            break;
            i = 0;
            break label793;
            m = 1;
            break label801;
            if (i == 0)
            {
              paramArrayOfInt = null;
              if (paramArrayOfInt != null)
              {
                k = i;
                if (paramArrayOfInt.getOpcode().getBranchingness() != 1) {}
              }
              else
              {
                if (paramArrayOfInt != null) {
                  break label1056;
                }
              }
            }
            for (paramArrayOfInt = SourcePosition.NO_INFO;; paramArrayOfInt = paramArrayOfInt.getPosition())
            {
              localArrayList.add(new PlainInsn(Rops.GOTO, paramArrayOfInt, null, RegisterSpecList.EMPTY));
              k = i + 1;
              paramArrayOfInt = new InsnList(k);
              i = 0;
              while (i < k)
              {
                paramArrayOfInt.set(i, (Insn)localArrayList.get(i));
                i += 1;
              }
              paramArrayOfInt = (Insn)localArrayList.get(i - 1);
              break;
            }
            paramArrayOfInt.setImmutable();
            addOrReplaceBlock(new BasicBlock(paramByteBlock.getLabel(), paramArrayOfInt, paramFrame, j), localFrame.getSubroutines());
            return;
          }
        }
      }
    }
  }
  
  private void removeBlockAndSpecialSuccessors(int paramInt)
  {
    int i = getMinimumUnreservedLabel();
    IntList localIntList = ((BasicBlock)this.result.get(paramInt)).getSuccessors();
    int j = localIntList.size();
    this.result.remove(paramInt);
    this.resultSubroutines.remove(paramInt);
    paramInt = 0;
    while (paramInt < j)
    {
      int k = localIntList.get(paramInt);
      if (k >= i)
      {
        int m = labelToResultIndex(k);
        if (m < 0) {
          throw new RuntimeException("Invalid label " + Hex.u2(k));
        }
        removeBlockAndSpecialSuccessors(m);
      }
      paramInt += 1;
    }
  }
  
  private void setFirstFrame()
  {
    Prototype localPrototype = this.method.getEffectiveDescriptor();
    this.startFrames[0].initializeWithParameters(localPrototype.getParameterTypes());
    this.startFrames[0].setImmutable();
  }
  
  private Ropper.Subroutine subroutineFromRetBlock(int paramInt)
  {
    int i = this.subroutines.length - 1;
    while (i >= 0)
    {
      if (this.subroutines[i] != null)
      {
        Ropper.Subroutine localSubroutine = this.subroutines[i];
        if (Ropper.Subroutine.access$1300(localSubroutine).get(paramInt)) {
          return localSubroutine;
        }
      }
      i -= 1;
    }
    return null;
  }
  
  int getFirstTempStackReg()
  {
    int j = getNormalRegCount();
    int i = j;
    if (isSynchronized()) {
      i = j + 1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Ropper
 * JD-Core Version:    0.7.0.1
 */