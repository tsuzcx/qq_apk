package com.android.dx.io.instructions;

import com.android.dex.DexException;
import com.android.dx.io.IndexType;
import com.android.dx.io.OpcodeInfo;
import com.android.dx.io.Opcodes;
import com.android.dx.util.Hex;
import java.io.EOFException;

public abstract class DecodedInstruction
{
  private final InstructionCodec format;
  private final int index;
  private final IndexType indexType;
  private final long literal;
  private final int opcode;
  private final int target;
  
  public DecodedInstruction(InstructionCodec paramInstructionCodec, int paramInt1, int paramInt2, IndexType paramIndexType, int paramInt3, long paramLong)
  {
    if (paramInstructionCodec == null) {
      throw new NullPointerException("format == null");
    }
    if (!Opcodes.isValidShape(paramInt1)) {
      throw new IllegalArgumentException("invalid opcode");
    }
    this.format = paramInstructionCodec;
    this.opcode = paramInt1;
    this.index = paramInt2;
    this.indexType = paramIndexType;
    this.target = paramInt3;
    this.literal = paramLong;
  }
  
  public static DecodedInstruction decode(CodeInput paramCodeInput)
  {
    int i = paramCodeInput.read();
    return OpcodeInfo.getFormat(Opcodes.extractOpcodeFromUnit(i)).decode(i, paramCodeInput);
  }
  
  public static DecodedInstruction[] decodeAll(short[] paramArrayOfShort)
  {
    arrayOfDecodedInstruction = new DecodedInstruction[paramArrayOfShort.length];
    paramArrayOfShort = new ShortArrayCodeInput(paramArrayOfShort);
    try
    {
      while (paramArrayOfShort.hasMore()) {
        arrayOfDecodedInstruction[paramArrayOfShort.cursor()] = decode(paramArrayOfShort);
      }
      return arrayOfDecodedInstruction;
    }
    catch (EOFException paramArrayOfShort)
    {
      throw new DexException(paramArrayOfShort);
    }
  }
  
  public final void encode(CodeOutput paramCodeOutput)
  {
    this.format.encode(this, paramCodeOutput);
  }
  
  public int getA()
  {
    return 0;
  }
  
  public final short getAByte()
  {
    int i = getA();
    if ((i & 0xFFFFFF00) != 0) {
      throw new DexException("Register A out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public final short getANibble()
  {
    int i = getA();
    if ((i & 0xFFFFFFF0) != 0) {
      throw new DexException("Register A out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public final short getAUnit()
  {
    int i = getA();
    if ((0xFFFF0000 & i) != 0) {
      throw new DexException("Register A out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public int getB()
  {
    return 0;
  }
  
  public final short getBByte()
  {
    int i = getB();
    if ((i & 0xFFFFFF00) != 0) {
      throw new DexException("Register B out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public final short getBNibble()
  {
    int i = getB();
    if ((i & 0xFFFFFFF0) != 0) {
      throw new DexException("Register B out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public final short getBUnit()
  {
    int i = getB();
    if ((0xFFFF0000 & i) != 0) {
      throw new DexException("Register B out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public int getC()
  {
    return 0;
  }
  
  public final short getCByte()
  {
    int i = getC();
    if ((i & 0xFFFFFF00) != 0) {
      throw new DexException("Register C out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public final short getCNibble()
  {
    int i = getC();
    if ((i & 0xFFFFFFF0) != 0) {
      throw new DexException("Register C out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public final short getCUnit()
  {
    int i = getC();
    if ((0xFFFF0000 & i) != 0) {
      throw new DexException("Register C out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public int getD()
  {
    return 0;
  }
  
  public final short getDByte()
  {
    int i = getD();
    if ((i & 0xFFFFFF00) != 0) {
      throw new DexException("Register D out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public final short getDNibble()
  {
    int i = getD();
    if ((i & 0xFFFFFFF0) != 0) {
      throw new DexException("Register D out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public final short getDUnit()
  {
    int i = getD();
    if ((0xFFFF0000 & i) != 0) {
      throw new DexException("Register D out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public int getE()
  {
    return 0;
  }
  
  public final short getENibble()
  {
    int i = getE();
    if ((i & 0xFFFFFFF0) != 0) {
      throw new DexException("Register E out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public final InstructionCodec getFormat()
  {
    return this.format;
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final IndexType getIndexType()
  {
    return this.indexType;
  }
  
  public final short getIndexUnit()
  {
    return (short)this.index;
  }
  
  public final long getLiteral()
  {
    return this.literal;
  }
  
  public final int getLiteralByte()
  {
    if (this.literal != (byte)(int)this.literal) {
      throw new DexException("Literal out of range: " + Hex.u8(this.literal));
    }
    return (int)this.literal & 0xFF;
  }
  
  public final int getLiteralInt()
  {
    if (this.literal != (int)this.literal) {
      throw new DexException("Literal out of range: " + Hex.u8(this.literal));
    }
    return (int)this.literal;
  }
  
  public final int getLiteralNibble()
  {
    if ((this.literal < -8L) || (this.literal > 7L)) {
      throw new DexException("Literal out of range: " + Hex.u8(this.literal));
    }
    return (int)this.literal & 0xF;
  }
  
  public final short getLiteralUnit()
  {
    if (this.literal != (short)(int)this.literal) {
      throw new DexException("Literal out of range: " + Hex.u8(this.literal));
    }
    return (short)(int)this.literal;
  }
  
  public final int getOpcode()
  {
    return this.opcode;
  }
  
  public final short getOpcodeUnit()
  {
    return (short)this.opcode;
  }
  
  public abstract int getRegisterCount();
  
  public final short getRegisterCountUnit()
  {
    int i = getRegisterCount();
    if ((0xFFFF0000 & i) != 0) {
      throw new DexException("Register count out of range: " + Hex.u8(i));
    }
    return (short)i;
  }
  
  public final int getTarget()
  {
    return this.target;
  }
  
  public final int getTarget(int paramInt)
  {
    return this.target - paramInt;
  }
  
  public final int getTargetByte(int paramInt)
  {
    paramInt = getTarget(paramInt);
    if (paramInt != (byte)paramInt) {
      throw new DexException("Target out of range: " + Hex.s4(paramInt));
    }
    return paramInt & 0xFF;
  }
  
  public final short getTargetUnit(int paramInt)
  {
    paramInt = getTarget(paramInt);
    if (paramInt != (short)paramInt) {
      throw new DexException("Target out of range: " + Hex.s4(paramInt));
    }
    return (short)paramInt;
  }
  
  public abstract DecodedInstruction withIndex(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.DecodedInstruction
 * JD-Core Version:    0.7.0.1
 */