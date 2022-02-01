package com.android.dx.cf.code;

import com.android.dx.cf.iface.Method;
import com.android.dx.cf.iface.MethodList;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.code.FillArrayDataInsn;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.PlainCstInsn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.code.SwitchInsn;
import com.android.dx.rop.code.ThrowingCstInsn;
import com.android.dx.rop.code.ThrowingInsn;
import com.android.dx.rop.code.TranslationAdvice;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.IntList;
import java.util.ArrayList;

final class RopperMachine
  extends ValueAwareMachine
{
  private static final CstType ARRAY_REFLECT_TYPE = new CstType(Type.internClassName("java/lang/reflect/Array"));
  private static final CstMethodRef MULTIANEWARRAY_METHOD = new CstMethodRef(ARRAY_REFLECT_TYPE, new CstNat(new CstString("newInstance"), new CstString("(Ljava/lang/Class;[I)Ljava/lang/Object;")));
  private final TranslationAdvice advice;
  private boolean blockCanThrow;
  private TypeList catches;
  private boolean catchesUsed;
  private int extraBlockCount;
  private boolean hasJsr;
  private final ArrayList<Insn> insns;
  private final int maxLocals;
  private final ConcreteMethod method;
  private final MethodList methods;
  private int primarySuccessorIndex;
  private ReturnAddress returnAddress;
  private Rop returnOp;
  private SourcePosition returnPosition;
  private boolean returns;
  private final Ropper ropper;
  
  public RopperMachine(Ropper paramRopper, ConcreteMethod paramConcreteMethod, TranslationAdvice paramTranslationAdvice, MethodList paramMethodList)
  {
    super(paramConcreteMethod.getEffectiveDescriptor());
    if (paramMethodList == null) {
      throw new NullPointerException("methods == null");
    }
    if (paramRopper == null) {
      throw new NullPointerException("ropper == null");
    }
    if (paramTranslationAdvice == null) {
      throw new NullPointerException("advice == null");
    }
    this.ropper = paramRopper;
    this.method = paramConcreteMethod;
    this.methods = paramMethodList;
    this.advice = paramTranslationAdvice;
    this.maxLocals = paramConcreteMethod.getMaxLocals();
    this.insns = new ArrayList(25);
    this.catches = null;
    this.catchesUsed = false;
    this.returns = false;
    this.primarySuccessorIndex = -1;
    this.extraBlockCount = 0;
    this.blockCanThrow = false;
    this.returnOp = null;
    this.returnPosition = null;
  }
  
  private RegisterSpecList getSources(int paramInt1, int paramInt2)
  {
    int k = argCount();
    if (k == 0) {
      return RegisterSpecList.EMPTY;
    }
    int i = getLocalIndex();
    RegisterSpecList localRegisterSpecList;
    if (i >= 0)
    {
      localRegisterSpecList = new RegisterSpecList(1);
      localRegisterSpecList.set(0, RegisterSpec.make(i, arg(0)));
    }
    for (;;)
    {
      localRegisterSpecList.setImmutable();
      return localRegisterSpecList;
      localRegisterSpecList = new RegisterSpecList(k);
      int j = 0;
      i = paramInt2;
      paramInt2 = j;
      RegisterSpec localRegisterSpec1;
      while (paramInt2 < k)
      {
        localRegisterSpec1 = RegisterSpec.make(i, arg(paramInt2));
        localRegisterSpecList.set(paramInt2, localRegisterSpec1);
        i += localRegisterSpec1.getCategory();
        paramInt2 += 1;
      }
      switch (paramInt1)
      {
      default: 
        break;
      case 79: 
        if (k != 3) {
          throw new RuntimeException("shouldn't happen");
        }
        localRegisterSpec1 = localRegisterSpecList.get(0);
        RegisterSpec localRegisterSpec2 = localRegisterSpecList.get(1);
        localRegisterSpecList.set(0, localRegisterSpecList.get(2));
        localRegisterSpecList.set(1, localRegisterSpec1);
        localRegisterSpecList.set(2, localRegisterSpec2);
        break;
      case 181: 
        if (k != 2) {
          throw new RuntimeException("shouldn't happen");
        }
        localRegisterSpec1 = localRegisterSpecList.get(0);
        localRegisterSpecList.set(0, localRegisterSpecList.get(1));
        localRegisterSpecList.set(1, localRegisterSpec1);
      }
    }
  }
  
  private int jopToRopOpcode(int paramInt, Constant paramConstant)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 19: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 70: 
    case 71: 
    case 72: 
    case 73: 
    case 74: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 80: 
    case 81: 
    case 82: 
    case 83: 
    case 84: 
    case 85: 
    case 86: 
    case 87: 
    case 88: 
    case 89: 
    case 90: 
    case 91: 
    case 92: 
    case 93: 
    case 94: 
    case 95: 
    case 97: 
    case 98: 
    case 99: 
    case 101: 
    case 102: 
    case 103: 
    case 105: 
    case 106: 
    case 107: 
    case 109: 
    case 110: 
    case 111: 
    case 113: 
    case 114: 
    case 115: 
    case 117: 
    case 118: 
    case 119: 
    case 121: 
    case 123: 
    case 125: 
    case 127: 
    case 129: 
    case 131: 
    case 168: 
    case 169: 
    case 170: 
    case 173: 
    case 174: 
    case 175: 
    case 176: 
    case 186: 
    case 196: 
    case 197: 
    default: 
      throw new RuntimeException("shouldn't happen");
    case 0: 
      return 1;
    case 18: 
    case 20: 
      return 5;
    case 21: 
    case 54: 
      return 2;
    case 46: 
      return 38;
    case 79: 
      return 39;
    case 96: 
    case 132: 
      return 14;
    case 100: 
      return 15;
    case 104: 
      return 16;
    case 108: 
      return 17;
    case 112: 
      return 18;
    case 116: 
      return 19;
    case 120: 
      return 23;
    case 122: 
      return 24;
    case 124: 
      return 25;
    case 126: 
      return 20;
    case 128: 
      return 21;
    case 130: 
      return 22;
    case 133: 
    case 134: 
    case 135: 
    case 136: 
    case 137: 
    case 138: 
    case 139: 
    case 140: 
    case 141: 
    case 142: 
    case 143: 
    case 144: 
      return 29;
    case 145: 
      return 30;
    case 146: 
      return 31;
    case 147: 
      return 32;
    case 148: 
    case 149: 
    case 151: 
      return 27;
    case 150: 
    case 152: 
      return 28;
    case 153: 
    case 159: 
    case 165: 
    case 198: 
      return 7;
    case 154: 
    case 160: 
    case 166: 
    case 199: 
      return 8;
    case 155: 
    case 161: 
      return 9;
    case 156: 
    case 162: 
      return 10;
    case 157: 
    case 163: 
      return 12;
    case 158: 
    case 164: 
      return 11;
    case 167: 
      return 6;
    case 171: 
      return 13;
    case 172: 
    case 177: 
      return 33;
    case 178: 
      return 46;
    case 179: 
      return 48;
    case 180: 
      return 45;
    case 181: 
      return 47;
    case 182: 
      paramConstant = (CstMethodRef)paramConstant;
      if (paramConstant.getDefiningClass().equals(this.method.getDefiningClass()))
      {
        paramInt = 0;
        while (paramInt < this.methods.size())
        {
          Method localMethod = this.methods.get(paramInt);
          if ((AccessFlags.isPrivate(localMethod.getAccessFlags())) && (paramConstant.getNat().equals(localMethod.getNat()))) {
            return 52;
          }
          paramInt += 1;
        }
      }
      return 50;
    case 183: 
      paramConstant = (CstMethodRef)paramConstant;
      if ((paramConstant.isInstanceInit()) || (paramConstant.getDefiningClass().equals(this.method.getDefiningClass())) || (!this.method.getAccSuper())) {
        return 52;
      }
      return 51;
    case 184: 
      return 49;
    case 185: 
      return 53;
    case 187: 
      return 40;
    case 188: 
    case 189: 
      return 41;
    case 190: 
      return 34;
    case 191: 
      return 35;
    case 192: 
      return 43;
    case 193: 
      return 44;
    case 194: 
      return 36;
    }
    return 37;
  }
  
  private void updateReturnOp(Rop paramRop, SourcePosition paramSourcePosition)
  {
    if (paramRop == null) {
      throw new NullPointerException("op == null");
    }
    if (paramSourcePosition == null) {
      throw new NullPointerException("pos == null");
    }
    if (this.returnOp == null)
    {
      this.returnOp = paramRop;
      this.returnPosition = paramSourcePosition;
    }
    do
    {
      return;
      if (this.returnOp != paramRop) {
        throw new SimException("return op mismatch: " + paramRop + ", " + this.returnOp);
      }
    } while (paramSourcePosition.getLine() <= this.returnPosition.getLine());
    this.returnPosition = paramSourcePosition;
  }
  
  public boolean canThrow()
  {
    return this.blockCanThrow;
  }
  
  public int getExtraBlockCount()
  {
    return this.extraBlockCount;
  }
  
  public ArrayList<Insn> getInsns()
  {
    return this.insns;
  }
  
  public int getPrimarySuccessorIndex()
  {
    return this.primarySuccessorIndex;
  }
  
  public ReturnAddress getReturnAddress()
  {
    return this.returnAddress;
  }
  
  public Rop getReturnOp()
  {
    return this.returnOp;
  }
  
  public SourcePosition getReturnPosition()
  {
    return this.returnPosition;
  }
  
  public boolean hasJsr()
  {
    return this.hasJsr;
  }
  
  public boolean hasRet()
  {
    return this.returnAddress != null;
  }
  
  public boolean returns()
  {
    return this.returns;
  }
  
  public void run(Frame paramFrame, int paramInt1, int paramInt2)
  {
    int i = this.maxLocals;
    i = paramFrame.getStack().size() + i;
    Object localObject3 = getSources(paramInt2, i);
    int j = ((RegisterSpecList)localObject3).size();
    super.run(paramFrame, paramInt1, paramInt2);
    SourcePosition localSourcePosition = this.method.makeSourcePosistion(paramInt1);
    boolean bool;
    Object localObject1;
    if (paramInt2 == 54)
    {
      bool = true;
      localObject1 = getLocalTarget(bool);
      paramInt1 = resultCount();
      if (paramInt1 != 0) {
        break label255;
      }
      paramFrame = null;
    }
    label104:
    Object localObject4;
    Object localObject6;
    Object localObject2;
    switch (paramInt2)
    {
    default: 
      if (paramFrame != null) {}
      for (localObject4 = paramFrame;; localObject4 = Type.VOID)
      {
        localObject6 = getAuxCst();
        if (paramInt2 != 197) {
          break label923;
        }
        this.blockCanThrow = true;
        this.extraBlockCount = 6;
        localObject2 = RegisterSpec.make(paramFrame.getNextReg(), Type.INT_ARRAY);
        localObject1 = new ThrowingCstInsn(Rops.opFilledNewArray(Type.INT_ARRAY, j), localSourcePosition, (RegisterSpecList)localObject3, this.catches, CstType.INT_ARRAY);
        this.insns.add(localObject1);
        localObject1 = new PlainInsn(Rops.opMoveResult(Type.INT_ARRAY), localSourcePosition, (RegisterSpec)localObject2, RegisterSpecList.EMPTY);
        this.insns.add(localObject1);
        localObject1 = ((CstType)localObject6).getClassType();
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          localObject1 = ((Type)localObject1).getComponentType();
          paramInt1 += 1;
        }
        bool = false;
        break;
        label255:
        paramFrame = (Frame)localObject1;
        if (localObject1 != null) {
          break label104;
        }
        if (paramInt1 == 1)
        {
          paramFrame = RegisterSpec.make(i, result(0));
          break label104;
        }
        paramInt2 = this.ropper.getFirstTempStackReg();
        paramFrame = new RegisterSpec[j];
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          localObject1 = ((RegisterSpecList)localObject3).get(paramInt1);
          localObject2 = ((RegisterSpec)localObject1).getTypeBearer();
          localObject4 = ((RegisterSpec)localObject1).withReg(paramInt2);
          this.insns.add(new PlainInsn(Rops.opMove((TypeBearer)localObject2), localSourcePosition, (RegisterSpec)localObject4, (RegisterSpec)localObject1));
          paramFrame[paramInt1] = localObject4;
          paramInt2 += ((RegisterSpec)localObject1).getCategory();
          paramInt1 += 1;
        }
        paramInt1 = getAuxInt();
        paramInt2 = i;
        while (paramInt1 != 0)
        {
          localObject1 = paramFrame[((paramInt1 & 0xF) - 1)];
          localObject2 = ((RegisterSpec)localObject1).getTypeBearer();
          this.insns.add(new PlainInsn(Rops.opMove((TypeBearer)localObject2), localSourcePosition, ((RegisterSpec)localObject1).withReg(paramInt2), (RegisterSpec)localObject1));
          paramInt2 += ((TypeBearer)localObject2).getType().getCategory();
          paramInt1 >>= 4;
        }
      }
      localObject3 = RegisterSpec.make(paramFrame.getReg(), Type.CLASS);
      if (((Type)localObject1).isPrimitive())
      {
        localObject1 = CstFieldRef.forPrimitiveType((Type)localObject1);
        localObject1 = new ThrowingCstInsn(Rops.GET_STATIC_OBJECT, localSourcePosition, RegisterSpecList.EMPTY, this.catches, (Constant)localObject1);
        this.insns.add(localObject1);
        localObject1 = new PlainInsn(Rops.opMoveResultPseudo(((RegisterSpec)localObject3).getType()), localSourcePosition, (RegisterSpec)localObject3, RegisterSpecList.EMPTY);
        this.insns.add(localObject1);
        localObject1 = RegisterSpec.make(paramFrame.getReg(), Type.OBJECT);
        localObject2 = new ThrowingCstInsn(Rops.opInvokeStatic(MULTIANEWARRAY_METHOD.getPrototype()), localSourcePosition, RegisterSpecList.make((RegisterSpec)localObject3, (RegisterSpec)localObject2), this.catches, MULTIANEWARRAY_METHOD);
        this.insns.add(localObject2);
        localObject2 = new PlainInsn(Rops.opMoveResult(MULTIANEWARRAY_METHOD.getPrototype().getReturnType()), localSourcePosition, (RegisterSpec)localObject1, RegisterSpecList.EMPTY);
        this.insns.add(localObject2);
        paramInt2 = 192;
        localObject3 = RegisterSpecList.make((RegisterSpec)localObject1);
      }
      break;
    }
    label816:
    label1470:
    label1473:
    label1483:
    label1492:
    for (;;)
    {
      paramInt1 = jopToRopOpcode(paramInt2, (Constant)localObject6);
      Object localObject5 = Rops.ropFor(paramInt1, (TypeBearer)localObject4, (TypeList)localObject3, (Constant)localObject6);
      if ((paramFrame != null) && (((Rop)localObject5).isCallLike()))
      {
        this.extraBlockCount += 1;
        localObject1 = new PlainInsn(Rops.opMoveResult(((CstMethodRef)localObject6).getPrototype().getReturnType()), localSourcePosition, paramFrame, RegisterSpecList.EMPTY);
        localObject2 = null;
      }
      for (;;)
      {
        label733:
        if (paramInt1 == 41)
        {
          localObject4 = CstType.intern(((Rop)localObject5).getResult());
          paramFrame = (Frame)localObject5;
        }
        for (;;)
        {
          localObject6 = getAuxCases();
          localObject5 = getInitValues();
          bool = paramFrame.canThrow();
          this.blockCanThrow |= bool;
          if (localObject6 != null) {
            if (((SwitchList)localObject6).size() == 0)
            {
              paramFrame = new PlainInsn(Rops.GOTO, localSourcePosition, null, RegisterSpecList.EMPTY);
              this.primarySuccessorIndex = 0;
              this.insns.add(paramFrame);
              if (localObject1 != null) {
                this.insns.add(localObject1);
              }
              if (localObject5 != null)
              {
                this.extraBlockCount += 1;
                paramFrame = new FillArrayDataInsn(Rops.FILL_ARRAY_DATA, localSourcePosition, RegisterSpecList.make(((Insn)localObject1).getResult()), (ArrayList)localObject5, (Constant)localObject4);
                this.insns.add(paramFrame);
              }
              return;
              localObject1 = new ThrowingCstInsn(Rops.CONST_OBJECT, localSourcePosition, RegisterSpecList.EMPTY, this.catches, new CstType((Type)localObject1));
              break;
              if (paramInt2 == 168)
              {
                this.hasJsr = true;
                return;
              }
              if (paramInt2 != 169) {
                break label1492;
              }
              try
              {
                this.returnAddress = ((ReturnAddress)arg(0));
                return;
              }
              catch (ClassCastException paramFrame)
              {
                throw new RuntimeException("Argument to RET was not a ReturnAddress", paramFrame);
              }
              if ((paramFrame == null) || (!((Rop)localObject5).canThrow())) {
                break label1483;
              }
              this.extraBlockCount += 1;
              localObject1 = new PlainInsn(Rops.opMoveResultPseudo(paramFrame.getTypeBearer()), localSourcePosition, paramFrame, RegisterSpecList.EMPTY);
              localObject2 = null;
              break label733;
              if ((localObject6 != null) || (j != 2)) {
                break label1473;
              }
              paramFrame = ((RegisterSpecList)localObject3).get(0).getTypeBearer();
              TypeBearer localTypeBearer = ((RegisterSpecList)localObject3).get(1).getTypeBearer();
              if (((!localTypeBearer.isConstant()) && (!paramFrame.isConstant())) || (!this.advice.hasConstantOperation((Rop)localObject5, ((RegisterSpecList)localObject3).get(0), ((RegisterSpecList)localObject3).get(1)))) {
                break label1473;
              }
              if (localTypeBearer.isConstant())
              {
                paramFrame = (Constant)localTypeBearer;
                localObject3 = ((RegisterSpecList)localObject3).withoutLast();
                if (((Rop)localObject5).getOpcode() != 15) {
                  break label1470;
                }
                paramInt1 = 14;
                paramFrame = CstInteger.make(-((CstInteger)localTypeBearer).getValue());
              }
            }
          }
          for (;;)
          {
            localObject5 = Rops.ropFor(paramInt1, (TypeBearer)localObject4, (TypeList)localObject3, paramFrame);
            localObject4 = paramFrame;
            paramFrame = (Frame)localObject5;
            break;
            paramFrame = (Constant)paramFrame;
            localObject3 = ((RegisterSpecList)localObject3).withoutFirst();
            continue;
            localObject6 = ((SwitchList)localObject6).getValues();
            paramFrame = new SwitchInsn(paramFrame, localSourcePosition, (RegisterSpec)localObject2, (RegisterSpecList)localObject3, (IntList)localObject6);
            this.primarySuccessorIndex = ((IntList)localObject6).size();
            break label816;
            if (paramInt1 == 33)
            {
              if (((RegisterSpecList)localObject3).size() != 0)
              {
                localObject2 = ((RegisterSpecList)localObject3).get(0);
                localObject3 = ((RegisterSpec)localObject2).getTypeBearer();
                if (((RegisterSpec)localObject2).getReg() != 0) {
                  this.insns.add(new PlainInsn(Rops.opMove((TypeBearer)localObject3), localSourcePosition, RegisterSpec.make(0, (TypeBearer)localObject3), (RegisterSpec)localObject2));
                }
              }
              localObject2 = new PlainInsn(Rops.GOTO, localSourcePosition, null, RegisterSpecList.EMPTY);
              this.primarySuccessorIndex = 0;
              updateReturnOp(paramFrame, localSourcePosition);
              this.returns = true;
              paramFrame = (Frame)localObject2;
              break label816;
            }
            if (localObject4 != null)
            {
              if (bool)
              {
                paramFrame = new ThrowingCstInsn(paramFrame, localSourcePosition, (RegisterSpecList)localObject3, this.catches, (Constant)localObject4);
                this.catchesUsed = true;
                this.primarySuccessorIndex = this.catches.size();
                break label816;
              }
              paramFrame = new PlainCstInsn(paramFrame, localSourcePosition, (RegisterSpec)localObject2, (RegisterSpecList)localObject3, (Constant)localObject4);
              break label816;
            }
            if (bool)
            {
              paramFrame = new ThrowingInsn(paramFrame, localSourcePosition, (RegisterSpecList)localObject3, this.catches);
              this.catchesUsed = true;
              if (paramInt2 == 191)
              {
                this.primarySuccessorIndex = -1;
                break label816;
              }
              this.primarySuccessorIndex = this.catches.size();
              break label816;
            }
            paramFrame = new PlainInsn(paramFrame, localSourcePosition, (RegisterSpec)localObject2, (RegisterSpecList)localObject3);
            break label816;
          }
          paramFrame = (Frame)localObject5;
          localObject4 = localObject6;
        }
        localObject1 = null;
        localObject2 = paramFrame;
      }
    }
  }
  
  public void startBlock(TypeList paramTypeList)
  {
    this.catches = paramTypeList;
    this.insns.clear();
    this.catchesUsed = false;
    this.returns = false;
    this.primarySuccessorIndex = 0;
    this.extraBlockCount = 0;
    this.blockCanThrow = false;
    this.hasJsr = false;
    this.returnAddress = null;
  }
  
  public boolean wereCatchesUsed()
  {
    return this.catchesUsed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.RopperMachine
 * JD-Core Version:    0.7.0.1
 */