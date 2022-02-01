package com.android.dx.cf.code;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstInterfaceMethodRef;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;
import java.util.ArrayList;

class Simulator$SimVisitor
  implements BytecodeArray.Visitor
{
  private Frame frame;
  private final Machine machine;
  private int previousOffset;
  
  public Simulator$SimVisitor(Simulator paramSimulator)
  {
    this.machine = Simulator.access$000(paramSimulator);
    this.frame = null;
  }
  
  private void checkReturnType(Type paramType)
  {
    Type localType = this.machine.getPrototype().getReturnType();
    if (!Merger.isPossiblyAssignableFrom(localType, paramType)) {
      throw new SimException("return type mismatch: prototype indicates " + localType.toHuman() + ", but encountered type " + paramType.toHuman());
    }
  }
  
  public int getPreviousOffset()
  {
    return this.previousOffset;
  }
  
  public void setFrame(Frame paramFrame)
  {
    if (paramFrame == null) {
      throw new NullPointerException("frame == null");
    }
    this.frame = paramFrame;
  }
  
  public void setPreviousOffset(int paramInt)
  {
    this.previousOffset = paramInt;
  }
  
  public void visitBranch(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (paramInt1)
    {
    case 169: 
    case 170: 
    case 171: 
    case 172: 
    case 173: 
    case 174: 
    case 175: 
    case 176: 
    case 177: 
    case 178: 
    case 179: 
    case 180: 
    case 181: 
    case 182: 
    case 183: 
    case 184: 
    case 185: 
    case 186: 
    case 187: 
    case 188: 
    case 189: 
    case 190: 
    case 191: 
    case 192: 
    case 193: 
    case 194: 
    case 195: 
    case 196: 
    case 197: 
    default: 
      visitInvalid(paramInt1, paramInt2, paramInt3);
      return;
    case 153: 
    case 154: 
    case 155: 
    case 156: 
    case 157: 
    case 158: 
      this.machine.popArgs(this.frame, Type.INT);
    }
    for (;;)
    {
      this.machine.auxTargetArg(paramInt4);
      this.machine.run(this.frame, paramInt2, paramInt1);
      return;
      this.machine.popArgs(this.frame, Type.OBJECT);
      continue;
      this.machine.popArgs(this.frame, Type.INT, Type.INT);
      continue;
      this.machine.popArgs(this.frame, Type.OBJECT, Type.OBJECT);
      continue;
      this.machine.clearArgs();
    }
  }
  
  public void visitConstant(int paramInt1, int paramInt2, int paramInt3, Constant paramConstant, int paramInt4)
  {
    Object localObject;
    switch (paramInt1)
    {
    case 186: 
    case 187: 
    case 188: 
    case 190: 
    case 191: 
    case 194: 
    case 195: 
    case 196: 
    default: 
      this.machine.clearArgs();
    case 189: 
    case 179: 
    case 180: 
    case 192: 
    case 193: 
    case 181: 
      for (;;)
      {
        this.machine.auxIntArg(paramInt4);
        this.machine.auxCstArg(paramConstant);
        this.machine.run(this.frame, paramInt2, paramInt1);
        return;
        this.machine.popArgs(this.frame, Type.INT);
        continue;
        localObject = ((CstFieldRef)paramConstant).getType();
        this.machine.popArgs(this.frame, (Type)localObject);
        continue;
        this.machine.popArgs(this.frame, Type.OBJECT);
        continue;
        localObject = ((CstFieldRef)paramConstant).getType();
        this.machine.popArgs(this.frame, Type.OBJECT, (Type)localObject);
      }
    case 185: 
      paramConstant = ((CstInterfaceMethodRef)paramConstant).toMethodRef();
    }
    for (;;)
    {
      localObject = ((CstMethodRef)paramConstant).getPrototype(false);
      this.machine.popArgs(this.frame, (Prototype)localObject);
      break;
      localObject = ((CstMethodRef)paramConstant).getPrototype(true);
      this.machine.popArgs(this.frame, (Prototype)localObject);
      break;
      localObject = Prototype.internInts(Type.VOID, paramInt4);
      this.machine.popArgs(this.frame, (Prototype)localObject);
      break;
    }
  }
  
  public void visitInvalid(int paramInt1, int paramInt2, int paramInt3)
  {
    throw new SimException("invalid opcode " + Hex.u1(paramInt1));
  }
  
  public void visitLocal(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Type paramType, int paramInt5)
  {
    LocalItem localLocalItem = null;
    if (paramInt1 == 54) {}
    LocalVariableList.Item localItem;
    for (int i = paramInt2 + paramInt3;; i = paramInt2)
    {
      localItem = Simulator.access$300(this.this$0).pcAndIndexToLocal(i, paramInt4);
      if (localItem == null) {
        break;
      }
      localObject = localItem.getType();
      if (((Type)localObject).getBasicFrameType() == paramType.getBasicFrameType()) {
        break label341;
      }
      BaseMachine.throwLocalMismatch(paramType, (TypeBearer)localObject);
      return;
    }
    Object localObject = paramType;
    label341:
    for (;;)
    {
      switch (paramInt1)
      {
      default: 
        visitInvalid(paramInt1, paramInt2, paramInt3);
        return;
      case 21: 
      case 169: 
        this.machine.localArg(this.frame, paramInt4);
        localObject = this.machine;
        if (localItem != null) {}
        for (boolean bool = true;; bool = false)
        {
          ((Machine)localObject).localInfo(bool);
          this.machine.auxType(paramType);
          this.machine.run(this.frame, paramInt2, paramInt1);
          return;
        }
      case 54: 
        if (localItem == null) {}
        for (localLocalItem = null;; localLocalItem = localItem.getLocalItem())
        {
          this.machine.popArgs(this.frame, paramType);
          this.machine.auxType(paramType);
          this.machine.localTarget(paramInt4, (Type)localObject, localLocalItem);
          break;
        }
      }
      if (localItem == null) {}
      for (;;)
      {
        this.machine.localArg(this.frame, paramInt4);
        this.machine.localTarget(paramInt4, (Type)localObject, localLocalItem);
        this.machine.auxType(paramType);
        this.machine.auxIntArg(paramInt5);
        this.machine.auxCstArg(CstInteger.make(paramInt5));
        break;
        localLocalItem = localItem.getLocalItem();
      }
    }
  }
  
  public void visitNewarray(int paramInt1, int paramInt2, CstType paramCstType, ArrayList<Constant> paramArrayList)
  {
    this.machine.popArgs(this.frame, Type.INT);
    this.machine.auxInitValues(paramArrayList);
    this.machine.auxCstArg(paramCstType);
    this.machine.run(this.frame, paramInt1, 188);
  }
  
  public void visitNoArgs(int paramInt1, int paramInt2, int paramInt3, Type paramType)
  {
    int i = 2;
    switch (paramInt1)
    {
    default: 
      visitInvalid(paramInt1, paramInt2, paramInt3);
      return;
    case 0: 
      this.machine.clearArgs();
      localObject = paramType;
    case 116: 
    case 133: 
    case 134: 
    case 135: 
    case 145: 
    case 146: 
    case 147: 
    case 136: 
    case 137: 
    case 138: 
    case 139: 
    case 140: 
    case 141: 
    case 142: 
    case 143: 
    case 144: 
    case 177: 
      for (;;)
      {
        this.machine.auxType((Type)localObject);
        this.machine.run(this.frame, paramInt2, paramInt1);
        return;
        this.machine.popArgs(this.frame, paramType);
        localObject = paramType;
        continue;
        this.machine.popArgs(this.frame, Type.INT);
        localObject = paramType;
        continue;
        this.machine.popArgs(this.frame, Type.LONG);
        localObject = paramType;
        continue;
        this.machine.popArgs(this.frame, Type.FLOAT);
        localObject = paramType;
        continue;
        this.machine.popArgs(this.frame, Type.DOUBLE);
        localObject = paramType;
        continue;
        this.machine.clearArgs();
        checkReturnType(Type.VOID);
        localObject = paramType;
      }
    case 172: 
      if (paramType != Type.OBJECT) {
        break;
      }
    }
    label1187:
    for (Object localObject = this.frame.getStack().peekType(0);; localObject = paramType)
    {
      this.machine.popArgs(this.frame, paramType);
      checkReturnType((Type)localObject);
      localObject = paramType;
      break;
      if (this.frame.getStack().peekType(0).isCategory2()) {
        throw Simulator.access$100();
      }
      this.machine.popArgs(this.frame, 1);
      localObject = paramType;
      break;
      localObject = this.frame.getStack().peekType(0);
      if (!((Type)localObject).isArrayOrKnownNull()) {
        throw new SimException("type mismatch: expected array type but encountered " + ((Type)localObject).toHuman());
      }
      this.machine.popArgs(this.frame, Type.OBJECT);
      localObject = paramType;
      break;
      this.machine.popArgs(this.frame, Type.OBJECT);
      localObject = paramType;
      break;
      localObject = Simulator.access$200(paramType, this.frame.getStack().peekType(1));
      if (localObject == Type.KNOWN_NULL) {}
      for (paramType = Type.KNOWN_NULL;; paramType = ((Type)localObject).getComponentType())
      {
        this.machine.popArgs(this.frame, (Type)localObject, Type.INT);
        localObject = paramType;
        break;
      }
      this.machine.popArgs(this.frame, paramType, paramType);
      localObject = paramType;
      break;
      this.machine.popArgs(this.frame, paramType, Type.INT);
      localObject = paramType;
      break;
      this.machine.popArgs(this.frame, Type.LONG, Type.LONG);
      localObject = paramType;
      break;
      this.machine.popArgs(this.frame, Type.FLOAT, Type.FLOAT);
      localObject = paramType;
      break;
      this.machine.popArgs(this.frame, Type.DOUBLE, Type.DOUBLE);
      localObject = paramType;
      break;
      localObject = this.frame.getStack();
      if (paramType.isCategory1())
      {
        paramInt3 = i;
        label1004:
        Type localType = ((ExecutionStack)localObject).peekType(paramInt3);
        boolean bool = ((ExecutionStack)localObject).peekLocal(paramInt3);
        localObject = Simulator.access$200(paramType, localType);
        if (!bool) {
          break label1858;
        }
        if (localObject != Type.KNOWN_NULL) {
          break label1079;
        }
        paramType = Type.KNOWN_NULL;
      }
      label1079:
      label1858:
      for (;;)
      {
        this.machine.popArgs(this.frame, (Type)localObject, Type.INT, paramType);
        localObject = paramType;
        break;
        paramInt3 = 3;
        break label1004;
        paramType = ((Type)localObject).getComponentType();
        continue;
        localObject = this.frame.getStack();
        if (((ExecutionStack)localObject).peekType(0).isCategory2()) {
          this.machine.popArgs(this.frame, 1);
        }
        for (paramInt3 = 17;; paramInt3 = 8481)
        {
          localObject = paramType;
          if (paramInt1 != 92) {
            break;
          }
          this.machine.auxIntArg(paramInt3);
          localObject = paramType;
          break;
          if (!((ExecutionStack)localObject).peekType(1).isCategory1()) {
            break label1187;
          }
          this.machine.popArgs(this.frame, 2);
        }
        throw Simulator.access$100();
        if (this.frame.getStack().peekType(0).isCategory2()) {
          throw Simulator.access$100();
        }
        this.machine.popArgs(this.frame, 1);
        this.machine.auxIntArg(17);
        localObject = paramType;
        break;
        localObject = this.frame.getStack();
        if ((!((ExecutionStack)localObject).peekType(0).isCategory1()) || (!((ExecutionStack)localObject).peekType(1).isCategory1())) {
          throw Simulator.access$100();
        }
        this.machine.popArgs(this.frame, 2);
        this.machine.auxIntArg(530);
        localObject = paramType;
        break;
        localObject = this.frame.getStack();
        if (((ExecutionStack)localObject).peekType(0).isCategory2()) {
          throw Simulator.access$100();
        }
        if (((ExecutionStack)localObject).peekType(1).isCategory2())
        {
          this.machine.popArgs(this.frame, 2);
          this.machine.auxIntArg(530);
          localObject = paramType;
          break;
        }
        if (((ExecutionStack)localObject).peekType(2).isCategory1())
        {
          this.machine.popArgs(this.frame, 3);
          this.machine.auxIntArg(12819);
          localObject = paramType;
          break;
        }
        throw Simulator.access$100();
        localObject = this.frame.getStack();
        if (((ExecutionStack)localObject).peekType(0).isCategory2())
        {
          if (((ExecutionStack)localObject).peekType(2).isCategory2()) {
            throw Simulator.access$100();
          }
          this.machine.popArgs(this.frame, 2);
          this.machine.auxIntArg(530);
          localObject = paramType;
          break;
        }
        if ((((ExecutionStack)localObject).peekType(1).isCategory2()) || (((ExecutionStack)localObject).peekType(2).isCategory2())) {
          throw Simulator.access$100();
        }
        this.machine.popArgs(this.frame, 3);
        this.machine.auxIntArg(205106);
        localObject = paramType;
        break;
        localObject = this.frame.getStack();
        if (((ExecutionStack)localObject).peekType(0).isCategory2())
        {
          if (((ExecutionStack)localObject).peekType(2).isCategory2())
          {
            this.machine.popArgs(this.frame, 2);
            this.machine.auxIntArg(530);
            localObject = paramType;
            break;
          }
          if (((ExecutionStack)localObject).peekType(3).isCategory1())
          {
            this.machine.popArgs(this.frame, 3);
            this.machine.auxIntArg(12819);
            localObject = paramType;
            break;
          }
          throw Simulator.access$100();
        }
        if (((ExecutionStack)localObject).peekType(1).isCategory1())
        {
          if (((ExecutionStack)localObject).peekType(2).isCategory2())
          {
            this.machine.popArgs(this.frame, 3);
            this.machine.auxIntArg(205106);
            localObject = paramType;
            break;
          }
          if (((ExecutionStack)localObject).peekType(3).isCategory1())
          {
            this.machine.popArgs(this.frame, 4);
            this.machine.auxIntArg(4399427);
            localObject = paramType;
            break;
          }
          throw Simulator.access$100();
        }
        throw Simulator.access$100();
        localObject = this.frame.getStack();
        if ((!((ExecutionStack)localObject).peekType(0).isCategory1()) || (!((ExecutionStack)localObject).peekType(1).isCategory1())) {
          throw Simulator.access$100();
        }
        this.machine.popArgs(this.frame, 2);
        this.machine.auxIntArg(18);
        localObject = paramType;
        break;
      }
    }
  }
  
  public void visitSwitch(int paramInt1, int paramInt2, int paramInt3, SwitchList paramSwitchList, int paramInt4)
  {
    this.machine.popArgs(this.frame, Type.INT);
    this.machine.auxIntArg(paramInt4);
    this.machine.auxSwitchArg(paramSwitchList);
    this.machine.run(this.frame, paramInt2, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Simulator.SimVisitor
 * JD-Core Version:    0.7.0.1
 */