package com.android.dx.cf.code;

import com.android.dx.cf.iface.ParseException;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstLiteralBits;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.Bits;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import java.util.ArrayList;

public final class BytecodeArray
{
  public static final BytecodeArray.Visitor EMPTY_VISITOR = new BytecodeArray.BaseVisitor();
  private final ByteArray bytes;
  private final ConstantPool pool;
  
  public BytecodeArray(ByteArray paramByteArray, ConstantPool paramConstantPool)
  {
    if (paramByteArray == null) {
      throw new NullPointerException("bytes == null");
    }
    if (paramConstantPool == null) {
      throw new NullPointerException("pool == null");
    }
    this.bytes = paramByteArray;
    this.pool = paramConstantPool;
  }
  
  private int parseLookupswitch(int paramInt, BytecodeArray.Visitor paramVisitor)
  {
    int m = 0;
    int k = paramInt + 4 & 0xFFFFFFFC;
    int j = paramInt + 1;
    int i = 0;
    while (j < k)
    {
      i = i << 8 | this.bytes.getUnsignedByte(j);
      j += 1;
    }
    int n = this.bytes.getInt(k);
    int i1 = this.bytes.getInt(k + 4);
    k += 8;
    SwitchList localSwitchList = new SwitchList(i1);
    j = m;
    while (j < i1)
    {
      m = this.bytes.getInt(k);
      int i2 = this.bytes.getInt(k + 4);
      k += 8;
      localSwitchList.add(m, i2 + paramInt);
      j += 1;
    }
    localSwitchList.setDefaultTarget(paramInt + n);
    localSwitchList.removeSuperfluousDefaults();
    localSwitchList.setImmutable();
    j = k - paramInt;
    paramVisitor.visitSwitch(171, paramInt, j, localSwitchList, i);
    return j;
  }
  
  private int parseNewarray(int paramInt, BytecodeArray.Visitor paramVisitor)
  {
    int i3 = this.bytes.getUnsignedByte(paramInt + 1);
    CstType localCstType;
    int i;
    BytecodeArray.ConstantParserVisitor localConstantParserVisitor;
    switch (i3)
    {
    default: 
      throw new SimException("bad newarray code " + Hex.u1(i3));
    case 4: 
      localCstType = CstType.BOOLEAN_ARRAY;
      i = paramVisitor.getPreviousOffset();
      localConstantParserVisitor = new BytecodeArray.ConstantParserVisitor(this);
      if (i >= 0)
      {
        parseInstruction(i, localConstantParserVisitor);
        if ((!(localConstantParserVisitor.cst instanceof CstInteger)) || (i + localConstantParserVisitor.length != paramInt)) {
          break;
        }
      }
      break;
    }
    for (int m = localConstantParserVisitor.value;; m = 0)
    {
      int k = paramInt + 2;
      ArrayList localArrayList = new ArrayList();
      int n;
      int j;
      ByteArray localByteArray;
      int i2;
      int i1;
      if (m != 0)
      {
        n = k;
        j = 0;
        localByteArray = this.bytes;
        i = n + 1;
        if (localByteArray.getUnsignedByte(n) != 89)
        {
          i2 = j;
          i1 = k;
        }
      }
      for (;;)
      {
        label211:
        if ((i2 < 2) || (i2 != m))
        {
          paramVisitor.visitNewarray(paramInt, 2, localCstType, null);
          return 2;
          localCstType = CstType.CHAR_ARRAY;
          break;
          localCstType = CstType.DOUBLE_ARRAY;
          break;
          localCstType = CstType.FLOAT_ARRAY;
          break;
          localCstType = CstType.BYTE_ARRAY;
          break;
          localCstType = CstType.SHORT_ARRAY;
          break;
          localCstType = CstType.INT_ARRAY;
          break;
          localCstType = CstType.LONG_ARRAY;
          break;
          parseInstruction(i, localConstantParserVisitor);
          i1 = k;
          i2 = j;
          if (localConstantParserVisitor.length == 0) {
            continue;
          }
          i1 = k;
          i2 = j;
          if (!(localConstantParserVisitor.cst instanceof CstInteger)) {
            continue;
          }
          i1 = k;
          i2 = j;
          if (localConstantParserVisitor.value != j) {
            continue;
          }
          i = localConstantParserVisitor.length + i;
          parseInstruction(i, localConstantParserVisitor);
          i1 = k;
          i2 = j;
          if (localConstantParserVisitor.length == 0) {
            continue;
          }
          i1 = k;
          i2 = j;
          if (!(localConstantParserVisitor.cst instanceof CstLiteralBits)) {
            continue;
          }
          i = localConstantParserVisitor.length + i;
          localArrayList.add(localConstantParserVisitor.cst);
          localByteArray = this.bytes;
          n = i + 1;
          i = localByteArray.getUnsignedByte(i);
          switch (i3)
          {
          default: 
            i = 1;
          }
        }
        for (;;)
        {
          i1 = k;
          i2 = j;
          if (i != 0) {
            break label211;
          }
          j += 1;
          k = n;
          break;
          if (i != 84)
          {
            i = 1;
            continue;
            if (i != 85)
            {
              i = 1;
              continue;
              if (i != 82)
              {
                i = 1;
                continue;
                if (i != 81)
                {
                  i = 1;
                  continue;
                  if (i != 86)
                  {
                    i = 1;
                    continue;
                    if (i != 79)
                    {
                      i = 1;
                      continue;
                      if (i != 80)
                      {
                        i = 1;
                        continue;
                        paramVisitor.visitNewarray(paramInt, i1 - paramInt, localCstType, localArrayList);
                        return i1 - paramInt;
                      }
                    }
                  }
                }
              }
            }
          }
          i = 0;
        }
        i2 = 0;
        i1 = k;
      }
    }
  }
  
  private int parseTableswitch(int paramInt, BytecodeArray.Visitor paramVisitor)
  {
    int m = 0;
    int k = paramInt + 4 & 0xFFFFFFFC;
    int j = paramInt + 1;
    int i = 0;
    while (j < k)
    {
      i = i << 8 | this.bytes.getUnsignedByte(j);
      j += 1;
    }
    int n = this.bytes.getInt(k);
    int i1 = this.bytes.getInt(k + 4);
    j = this.bytes.getInt(k + 8);
    int i2 = j - i1 + 1;
    k += 12;
    if (i1 > j) {
      throw new SimException("low / high inversion");
    }
    SwitchList localSwitchList = new SwitchList(i2);
    j = m;
    while (j < i2)
    {
      m = this.bytes.getInt(k);
      k += 4;
      localSwitchList.add(i1 + j, m + paramInt);
      j += 1;
    }
    localSwitchList.setDefaultTarget(paramInt + n);
    localSwitchList.removeSuperfluousDefaults();
    localSwitchList.setImmutable();
    j = k - paramInt;
    paramVisitor.visitSwitch(171, paramInt, j, localSwitchList, i);
    return j;
  }
  
  private int parseWide(int paramInt, BytecodeArray.Visitor paramVisitor)
  {
    int i = this.bytes.getUnsignedByte(paramInt + 1);
    int j = this.bytes.getUnsignedShort(paramInt + 2);
    switch (i)
    {
    default: 
      paramVisitor.visitInvalid(196, paramInt, 1);
      return 1;
    case 21: 
      paramVisitor.visitLocal(21, paramInt, 4, j, Type.INT, 0);
      return 4;
    case 22: 
      paramVisitor.visitLocal(21, paramInt, 4, j, Type.LONG, 0);
      return 4;
    case 23: 
      paramVisitor.visitLocal(21, paramInt, 4, j, Type.FLOAT, 0);
      return 4;
    case 24: 
      paramVisitor.visitLocal(21, paramInt, 4, j, Type.DOUBLE, 0);
      return 4;
    case 25: 
      paramVisitor.visitLocal(21, paramInt, 4, j, Type.OBJECT, 0);
      return 4;
    case 54: 
      paramVisitor.visitLocal(54, paramInt, 4, j, Type.INT, 0);
      return 4;
    case 55: 
      paramVisitor.visitLocal(54, paramInt, 4, j, Type.LONG, 0);
      return 4;
    case 56: 
      paramVisitor.visitLocal(54, paramInt, 4, j, Type.FLOAT, 0);
      return 4;
    case 57: 
      paramVisitor.visitLocal(54, paramInt, 4, j, Type.DOUBLE, 0);
      return 4;
    case 58: 
      paramVisitor.visitLocal(54, paramInt, 4, j, Type.OBJECT, 0);
      return 4;
    case 169: 
      paramVisitor.visitLocal(i, paramInt, 4, j, Type.RETURN_ADDRESS, 0);
      return 4;
    }
    int k = this.bytes.getShort(paramInt + 4);
    paramVisitor.visitLocal(i, paramInt, 6, j, Type.INT, k);
    return 6;
  }
  
  public int byteLength()
  {
    return this.bytes.size() + 4;
  }
  
  public void forEach(BytecodeArray.Visitor paramVisitor)
  {
    int j = this.bytes.size();
    int i = 0;
    while (i < j) {
      i += parseInstruction(i, paramVisitor);
    }
  }
  
  public ByteArray getBytes()
  {
    return this.bytes;
  }
  
  public int[] getInstructionOffsets()
  {
    int j = this.bytes.size();
    int[] arrayOfInt = Bits.makeBitSet(j);
    int i = 0;
    while (i < j)
    {
      Bits.set(arrayOfInt, i, true);
      i += parseInstruction(i, null);
    }
    return arrayOfInt;
  }
  
  public int parseInstruction(int paramInt, BytecodeArray.Visitor paramVisitor)
  {
    int j = 0;
    int i = 0;
    if (paramVisitor == null) {
      paramVisitor = EMPTY_VISITOR;
    }
    for (;;)
    {
      try
      {
        k = this.bytes.getUnsignedByte(paramInt);
        ByteOps.opInfo(k);
        switch (k)
        {
        case 0: 
          paramVisitor.visitInvalid(k, paramInt, 1);
          return 1;
        }
      }
      catch (SimException paramVisitor)
      {
        int k;
        Constant localConstant;
        int m;
        paramVisitor.addContext("...at bytecode offset " + Hex.u4(paramInt));
        throw paramVisitor;
        return parseNewarray(paramInt, paramVisitor);
        return parseWide(paramInt, paramVisitor);
        i = this.bytes.getUnsignedShort(paramInt + 1);
        j = this.bytes.getUnsignedByte(paramInt + 3);
        paramVisitor.visitConstant(k, paramInt, 4, this.pool.get(i), j);
        return 4;
        j = this.bytes.getInt(paramInt + 1);
        if (k != 200) {
          continue;
        }
        i = 167;
        paramVisitor.visitBranch(i, paramInt, 5, j + paramInt);
        return 5;
        i = 168;
        continue;
      }
      catch (RuntimeException paramVisitor)
      {
        paramVisitor = new SimException(paramVisitor);
        paramVisitor.addContext("...at bytecode offset " + Hex.u4(paramInt));
        throw paramVisitor;
      }
      paramVisitor.visitNoArgs(k, paramInt, 1, Type.VOID);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstKnownNull.THE_ONE, 0);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstInteger.VALUE_M1, -1);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstInteger.VALUE_0, 0);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstInteger.VALUE_1, 1);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstInteger.VALUE_2, 2);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstInteger.VALUE_3, 3);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstInteger.VALUE_4, 4);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstInteger.VALUE_5, 5);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstLong.VALUE_0, 0);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstLong.VALUE_1, 0);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstFloat.VALUE_0, 0);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstFloat.VALUE_1, 0);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstFloat.VALUE_2, 0);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstDouble.VALUE_0, 0);
      return 1;
      paramVisitor.visitConstant(18, paramInt, 1, CstDouble.VALUE_1, 0);
      return 1;
      i = this.bytes.getByte(paramInt + 1);
      paramVisitor.visitConstant(18, paramInt, 2, CstInteger.make(i), i);
      return 2;
      i = this.bytes.getShort(paramInt + 1);
      paramVisitor.visitConstant(18, paramInt, 3, CstInteger.make(i), i);
      return 3;
      j = this.bytes.getUnsignedByte(paramInt + 1);
      localConstant = this.pool.get(j);
      if ((localConstant instanceof CstInteger)) {
        i = ((CstInteger)localConstant).getValue();
      }
      paramVisitor.visitConstant(18, paramInt, 2, localConstant, i);
      return 2;
      i = this.bytes.getUnsignedShort(paramInt + 1);
      localConstant = this.pool.get(i);
      i = j;
      if ((localConstant instanceof CstInteger)) {
        i = ((CstInteger)localConstant).getValue();
      }
      paramVisitor.visitConstant(18, paramInt, 3, localConstant, i);
      return 3;
      i = this.bytes.getUnsignedShort(paramInt + 1);
      paramVisitor.visitConstant(20, paramInt, 3, this.pool.get(i), 0);
      return 3;
      paramVisitor.visitLocal(21, paramInt, 2, this.bytes.getUnsignedByte(paramInt + 1), Type.INT, 0);
      return 2;
      paramVisitor.visitLocal(21, paramInt, 2, this.bytes.getUnsignedByte(paramInt + 1), Type.LONG, 0);
      return 2;
      paramVisitor.visitLocal(21, paramInt, 2, this.bytes.getUnsignedByte(paramInt + 1), Type.FLOAT, 0);
      return 2;
      paramVisitor.visitLocal(21, paramInt, 2, this.bytes.getUnsignedByte(paramInt + 1), Type.DOUBLE, 0);
      return 2;
      paramVisitor.visitLocal(21, paramInt, 2, this.bytes.getUnsignedByte(paramInt + 1), Type.OBJECT, 0);
      return 2;
      paramVisitor.visitLocal(21, paramInt, 1, k - 26, Type.INT, 0);
      return 1;
      paramVisitor.visitLocal(21, paramInt, 1, k - 30, Type.LONG, 0);
      return 1;
      paramVisitor.visitLocal(21, paramInt, 1, k - 34, Type.FLOAT, 0);
      return 1;
      paramVisitor.visitLocal(21, paramInt, 1, k - 38, Type.DOUBLE, 0);
      return 1;
      paramVisitor.visitLocal(21, paramInt, 1, k - 42, Type.OBJECT, 0);
      return 1;
      paramVisitor.visitNoArgs(46, paramInt, 1, Type.INT);
      return 1;
      paramVisitor.visitNoArgs(46, paramInt, 1, Type.LONG);
      return 1;
      paramVisitor.visitNoArgs(46, paramInt, 1, Type.FLOAT);
      return 1;
      paramVisitor.visitNoArgs(46, paramInt, 1, Type.DOUBLE);
      return 1;
      paramVisitor.visitNoArgs(46, paramInt, 1, Type.OBJECT);
      return 1;
      paramVisitor.visitNoArgs(46, paramInt, 1, Type.BYTE);
      return 1;
      paramVisitor.visitNoArgs(46, paramInt, 1, Type.CHAR);
      return 1;
      paramVisitor.visitNoArgs(46, paramInt, 1, Type.SHORT);
      return 1;
      paramVisitor.visitLocal(54, paramInt, 2, this.bytes.getUnsignedByte(paramInt + 1), Type.INT, 0);
      return 2;
      paramVisitor.visitLocal(54, paramInt, 2, this.bytes.getUnsignedByte(paramInt + 1), Type.LONG, 0);
      return 2;
      paramVisitor.visitLocal(54, paramInt, 2, this.bytes.getUnsignedByte(paramInt + 1), Type.FLOAT, 0);
      return 2;
      paramVisitor.visitLocal(54, paramInt, 2, this.bytes.getUnsignedByte(paramInt + 1), Type.DOUBLE, 0);
      return 2;
      paramVisitor.visitLocal(54, paramInt, 2, this.bytes.getUnsignedByte(paramInt + 1), Type.OBJECT, 0);
      return 2;
      paramVisitor.visitLocal(54, paramInt, 1, k - 59, Type.INT, 0);
      return 1;
      paramVisitor.visitLocal(54, paramInt, 1, k - 63, Type.LONG, 0);
      return 1;
      paramVisitor.visitLocal(54, paramInt, 1, k - 67, Type.FLOAT, 0);
      return 1;
      paramVisitor.visitLocal(54, paramInt, 1, k - 71, Type.DOUBLE, 0);
      return 1;
      paramVisitor.visitLocal(54, paramInt, 1, k - 75, Type.OBJECT, 0);
      return 1;
      paramVisitor.visitNoArgs(79, paramInt, 1, Type.INT);
      return 1;
      paramVisitor.visitNoArgs(79, paramInt, 1, Type.LONG);
      return 1;
      paramVisitor.visitNoArgs(79, paramInt, 1, Type.FLOAT);
      return 1;
      paramVisitor.visitNoArgs(79, paramInt, 1, Type.DOUBLE);
      return 1;
      paramVisitor.visitNoArgs(79, paramInt, 1, Type.OBJECT);
      return 1;
      paramVisitor.visitNoArgs(79, paramInt, 1, Type.BYTE);
      return 1;
      paramVisitor.visitNoArgs(79, paramInt, 1, Type.CHAR);
      return 1;
      paramVisitor.visitNoArgs(79, paramInt, 1, Type.SHORT);
      return 1;
      paramVisitor.visitNoArgs(k, paramInt, 1, Type.VOID);
      return 1;
      paramVisitor.visitNoArgs(k, paramInt, 1, Type.INT);
      return 1;
      paramVisitor.visitNoArgs(k - 1, paramInt, 1, Type.LONG);
      return 1;
      paramVisitor.visitNoArgs(k - 2, paramInt, 1, Type.FLOAT);
      return 1;
      paramVisitor.visitNoArgs(k - 3, paramInt, 1, Type.DOUBLE);
      return 1;
      i = this.bytes.getUnsignedByte(paramInt + 1);
      j = this.bytes.getByte(paramInt + 2);
      paramVisitor.visitLocal(k, paramInt, 3, i, Type.INT, j);
      return 3;
      paramVisitor.visitNoArgs(k, paramInt, 1, Type.LONG);
      return 1;
      paramVisitor.visitNoArgs(k, paramInt, 1, Type.FLOAT);
      return 1;
      paramVisitor.visitNoArgs(k, paramInt, 1, Type.DOUBLE);
      return 1;
      paramVisitor.visitNoArgs(k, paramInt, 1, Type.INT);
      return 1;
      paramVisitor.visitBranch(k, paramInt, 3, this.bytes.getShort(paramInt + 1) + paramInt);
      return 3;
      paramVisitor.visitLocal(k, paramInt, 2, this.bytes.getUnsignedByte(paramInt + 1), Type.RETURN_ADDRESS, 0);
      return 2;
      return parseTableswitch(paramInt, paramVisitor);
      return parseLookupswitch(paramInt, paramVisitor);
      paramVisitor.visitNoArgs(172, paramInt, 1, Type.INT);
      return 1;
      paramVisitor.visitNoArgs(172, paramInt, 1, Type.LONG);
      return 1;
      paramVisitor.visitNoArgs(172, paramInt, 1, Type.FLOAT);
      return 1;
      paramVisitor.visitNoArgs(172, paramInt, 1, Type.DOUBLE);
      return 1;
      paramVisitor.visitNoArgs(172, paramInt, 1, Type.OBJECT);
      return 1;
      paramVisitor.visitNoArgs(k, paramInt, 1, Type.VOID);
      return 1;
      i = this.bytes.getUnsignedShort(paramInt + 1);
      paramVisitor.visitConstant(k, paramInt, 3, this.pool.get(i), 0);
      return 3;
      i = this.bytes.getUnsignedShort(paramInt + 1);
      j = this.bytes.getUnsignedByte(paramInt + 3);
      m = this.bytes.getUnsignedByte(paramInt + 4);
      paramVisitor.visitConstant(k, paramInt, 5, this.pool.get(i), j | m << 8);
      return 5;
      throw new ParseException("invokedynamic not supported");
    }
  }
  
  public void processWorkSet(int[] paramArrayOfInt, BytecodeArray.Visitor paramVisitor)
  {
    if (paramVisitor == null) {
      throw new NullPointerException("visitor == null");
    }
    int i;
    do
    {
      Bits.clear(paramArrayOfInt, i);
      parseInstruction(i, paramVisitor);
      paramVisitor.setPreviousOffset(i);
      i = Bits.findFirst(paramArrayOfInt, 0);
    } while (i >= 0);
  }
  
  public int size()
  {
    return this.bytes.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.BytecodeArray
 * JD-Core Version:    0.7.0.1
 */