package com.android.dx.cf.code;

import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;

public class ValueAwareMachine
  extends BaseMachine
{
  public ValueAwareMachine(Prototype paramPrototype)
  {
    super(paramPrototype);
  }
  
  public void run(Frame paramFrame, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
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
    case 170: 
    case 173: 
    case 174: 
    case 175: 
    case 176: 
    case 186: 
    case 196: 
    default: 
      throw new RuntimeException("shouldn't happen: " + Hex.u1(paramInt2));
    case 0: 
    case 79: 
    case 87: 
    case 88: 
    case 153: 
    case 154: 
    case 155: 
    case 156: 
    case 157: 
    case 158: 
    case 159: 
    case 160: 
    case 161: 
    case 162: 
    case 163: 
    case 164: 
    case 165: 
    case 166: 
    case 167: 
    case 169: 
    case 171: 
    case 172: 
    case 177: 
    case 179: 
    case 181: 
    case 191: 
    case 194: 
    case 195: 
    case 198: 
    case 199: 
      clearResult();
    }
    for (;;)
    {
      storeResults(paramFrame);
      return;
      setResult((TypeBearer)getAuxCst());
      continue;
      setResult(arg(0));
      continue;
      setResult(getAuxType());
      continue;
      clearResult();
      paramInt1 = getAuxInt();
      while (paramInt1 != 0)
      {
        addResult(arg((paramInt1 & 0xF) - 1));
        paramInt1 >>= 4;
      }
      setResult(new ReturnAddress(getAuxTarget()));
      continue;
      Type localType = ((TypeBearer)getAuxCst()).getType();
      if (localType == Type.VOID)
      {
        clearResult();
      }
      else
      {
        setResult(localType);
        continue;
        localType = arg(0).getType();
        if (localType.isUninitialized()) {
          paramFrame.makeInitialized(localType);
        }
        localType = ((TypeBearer)getAuxCst()).getType();
        if (localType == Type.VOID)
        {
          clearResult();
        }
        else
        {
          setResult(localType);
          continue;
          setResult(((CstType)getAuxCst()).getClassType().asUninitialized(paramInt1));
          continue;
          setResult(((CstType)getAuxCst()).getClassType());
          continue;
          setResult(((CstType)getAuxCst()).getClassType().getArrayType());
          continue;
          setResult(Type.INT);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.ValueAwareMachine
 * JD-Core Version:    0.7.0.1
 */