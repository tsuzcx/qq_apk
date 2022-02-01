package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstLiteral64;
import com.android.dx.rop.cst.CstLiteralBits;
import com.android.dx.rop.cst.CstString;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.BitSet;

public abstract class InsnFormat
{
  public static boolean ALLOW_EXTENDED_OPCODES = true;
  
  protected static int argIndex(DalvInsn paramDalvInsn)
  {
    int i = ((CstInteger)((CstInsn)paramDalvInsn).getConstant()).getValue();
    if (i < 0) {
      throw new IllegalArgumentException("bogus insn");
    }
    return i;
  }
  
  protected static String branchComment(DalvInsn paramDalvInsn)
  {
    int i = ((TargetInsn)paramDalvInsn).getTargetOffset();
    if (i == (short)i) {
      return Hex.s2(i);
    }
    return Hex.s4(i);
  }
  
  protected static String branchString(DalvInsn paramDalvInsn)
  {
    int i = ((TargetInsn)paramDalvInsn).getTargetAddress();
    if (i == (char)i) {
      return Hex.u2(i);
    }
    return Hex.u4(i);
  }
  
  protected static short codeUnit(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0xFF) != paramInt1) {
      throw new IllegalArgumentException("low out of range 0..255");
    }
    if ((paramInt2 & 0xFF) != paramInt2) {
      throw new IllegalArgumentException("high out of range 0..255");
    }
    return (short)(paramInt2 << 8 | paramInt1);
  }
  
  protected static short codeUnit(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 & 0xF) != paramInt1) {
      throw new IllegalArgumentException("n0 out of range 0..15");
    }
    if ((paramInt2 & 0xF) != paramInt2) {
      throw new IllegalArgumentException("n1 out of range 0..15");
    }
    if ((paramInt3 & 0xF) != paramInt3) {
      throw new IllegalArgumentException("n2 out of range 0..15");
    }
    if ((paramInt4 & 0xF) != paramInt4) {
      throw new IllegalArgumentException("n3 out of range 0..15");
    }
    return (short)(paramInt2 << 4 | paramInt1 | paramInt3 << 8 | paramInt4 << 12);
  }
  
  protected static String cstComment(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = (CstInsn)paramDalvInsn;
    if (!paramDalvInsn.hasIndex()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(20);
    int i = paramDalvInsn.getIndex();
    localStringBuilder.append(paramDalvInsn.getConstant().typeName());
    localStringBuilder.append('@');
    if (i < 65536) {
      localStringBuilder.append(Hex.u2(i));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(Hex.u4(i));
    }
  }
  
  protected static String cstString(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = ((CstInsn)paramDalvInsn).getConstant();
    if ((paramDalvInsn instanceof CstString)) {
      return ((CstString)paramDalvInsn).toQuoted();
    }
    return paramDalvInsn.toHuman();
  }
  
  protected static boolean isRegListSequential(RegisterSpecList paramRegisterSpecList)
  {
    int k = paramRegisterSpecList.size();
    if (k < 2) {}
    for (;;)
    {
      return true;
      int j = paramRegisterSpecList.get(0).getReg();
      int i = 0;
      while (i < k)
      {
        RegisterSpec localRegisterSpec = paramRegisterSpecList.get(i);
        if (localRegisterSpec.getReg() != j) {
          return false;
        }
        j += localRegisterSpec.getCategory();
        i += 1;
      }
    }
  }
  
  protected static String literalBitsComment(CstLiteralBits paramCstLiteralBits, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(20);
    localStringBuffer.append("#");
    if ((paramCstLiteralBits instanceof CstLiteral64)) {}
    for (long l = ((CstLiteral64)paramCstLiteralBits).getLongBits();; l = paramCstLiteralBits.getIntBits()) {
      switch (paramInt)
      {
      default: 
        throw new RuntimeException("shouldn't happen");
      }
    }
    localStringBuffer.append(Hex.uNibble((int)l));
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(Hex.u1((int)l));
      continue;
      localStringBuffer.append(Hex.u2((int)l));
      continue;
      localStringBuffer.append(Hex.u4((int)l));
      continue;
      localStringBuffer.append(Hex.u8(l));
    }
  }
  
  protected static String literalBitsString(CstLiteralBits paramCstLiteralBits)
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append('#');
    if ((paramCstLiteralBits instanceof CstKnownNull)) {
      localStringBuffer.append("null");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(paramCstLiteralBits.typeName());
      localStringBuffer.append(' ');
      localStringBuffer.append(paramCstLiteralBits.toHuman());
    }
  }
  
  protected static int makeByte(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0xF) != paramInt1) {
      throw new IllegalArgumentException("low out of range 0..15");
    }
    if ((paramInt2 & 0xF) != paramInt2) {
      throw new IllegalArgumentException("high out of range 0..15");
    }
    return paramInt2 << 4 | paramInt1;
  }
  
  protected static short opcodeUnit(DalvInsn paramDalvInsn)
  {
    int i = paramDalvInsn.getOpcode().getOpcode();
    if ((i < 256) || (i > 65535)) {
      throw new IllegalArgumentException("opcode out of range 0..65535");
    }
    return (short)i;
  }
  
  protected static short opcodeUnit(DalvInsn paramDalvInsn, int paramInt)
  {
    if ((paramInt & 0xFF) != paramInt) {
      throw new IllegalArgumentException("arg out of range 0..255");
    }
    int i = paramDalvInsn.getOpcode().getOpcode();
    if ((i & 0xFF) != i) {
      throw new IllegalArgumentException("opcode out of range 0..255");
    }
    return (short)(i | paramInt << 8);
  }
  
  protected static String regListString(RegisterSpecList paramRegisterSpecList)
  {
    int j = paramRegisterSpecList.size();
    StringBuffer localStringBuffer = new StringBuffer(j * 5 + 2);
    localStringBuffer.append('{');
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append(paramRegisterSpecList.get(i).regString());
      i += 1;
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  protected static String regRangeString(RegisterSpecList paramRegisterSpecList)
  {
    int i = paramRegisterSpecList.size();
    StringBuilder localStringBuilder = new StringBuilder(30);
    localStringBuilder.append("{");
    switch (i)
    {
    default: 
      RegisterSpec localRegisterSpec2 = paramRegisterSpecList.get(i - 1);
      RegisterSpec localRegisterSpec1 = localRegisterSpec2;
      if (localRegisterSpec2.getCategory() == 2) {
        localRegisterSpec1 = localRegisterSpec2.withOffset(1);
      }
      localStringBuilder.append(paramRegisterSpecList.get(0).regString());
      localStringBuilder.append("..");
      localStringBuilder.append(localRegisterSpec1.regString());
    }
    for (;;)
    {
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append(paramRegisterSpecList.get(0).regString());
    }
  }
  
  protected static boolean signedFitsInByte(int paramInt)
  {
    return (byte)paramInt == paramInt;
  }
  
  protected static boolean signedFitsInNibble(int paramInt)
  {
    return (paramInt >= -8) && (paramInt <= 7);
  }
  
  protected static boolean signedFitsInShort(int paramInt)
  {
    return (short)paramInt == paramInt;
  }
  
  protected static boolean unsignedFitsInByte(int paramInt)
  {
    return paramInt == (paramInt & 0xFF);
  }
  
  public static boolean unsignedFitsInNibble(int paramInt)
  {
    return paramInt == (paramInt & 0xF);
  }
  
  protected static boolean unsignedFitsInShort(int paramInt)
  {
    return paramInt == (0xFFFF & paramInt);
  }
  
  protected static void write(AnnotatedOutput paramAnnotatedOutput, short paramShort)
  {
    paramAnnotatedOutput.writeShort(paramShort);
  }
  
  protected static void write(AnnotatedOutput paramAnnotatedOutput, short paramShort, int paramInt)
  {
    write(paramAnnotatedOutput, paramShort, (short)paramInt, (short)(paramInt >> 16));
  }
  
  protected static void write(AnnotatedOutput paramAnnotatedOutput, short paramShort1, int paramInt, short paramShort2)
  {
    write(paramAnnotatedOutput, paramShort1, (short)paramInt, (short)(paramInt >> 16), paramShort2);
  }
  
  protected static void write(AnnotatedOutput paramAnnotatedOutput, short paramShort1, int paramInt, short paramShort2, short paramShort3)
  {
    write(paramAnnotatedOutput, paramShort1, (short)paramInt, (short)(paramInt >> 16), paramShort2, paramShort3);
  }
  
  protected static void write(AnnotatedOutput paramAnnotatedOutput, short paramShort, long paramLong)
  {
    write(paramAnnotatedOutput, paramShort, (short)(int)paramLong, (short)(int)(paramLong >> 16), (short)(int)(paramLong >> 32), (short)(int)(paramLong >> 48));
  }
  
  protected static void write(AnnotatedOutput paramAnnotatedOutput, short paramShort1, short paramShort2)
  {
    paramAnnotatedOutput.writeShort(paramShort1);
    paramAnnotatedOutput.writeShort(paramShort2);
  }
  
  protected static void write(AnnotatedOutput paramAnnotatedOutput, short paramShort1, short paramShort2, short paramShort3)
  {
    paramAnnotatedOutput.writeShort(paramShort1);
    paramAnnotatedOutput.writeShort(paramShort2);
    paramAnnotatedOutput.writeShort(paramShort3);
  }
  
  protected static void write(AnnotatedOutput paramAnnotatedOutput, short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    paramAnnotatedOutput.writeShort(paramShort1);
    paramAnnotatedOutput.writeShort(paramShort2);
    paramAnnotatedOutput.writeShort(paramShort3);
    paramAnnotatedOutput.writeShort(paramShort4);
  }
  
  protected static void write(AnnotatedOutput paramAnnotatedOutput, short paramShort1, short paramShort2, short paramShort3, short paramShort4, short paramShort5)
  {
    paramAnnotatedOutput.writeShort(paramShort1);
    paramAnnotatedOutput.writeShort(paramShort2);
    paramAnnotatedOutput.writeShort(paramShort3);
    paramAnnotatedOutput.writeShort(paramShort4);
    paramAnnotatedOutput.writeShort(paramShort5);
  }
  
  public boolean branchFits(TargetInsn paramTargetInsn)
  {
    return false;
  }
  
  public abstract int codeSize();
  
  public BitSet compatibleRegs(DalvInsn paramDalvInsn)
  {
    return new BitSet();
  }
  
  public abstract String insnArgString(DalvInsn paramDalvInsn);
  
  public abstract String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean);
  
  public abstract boolean isCompatible(DalvInsn paramDalvInsn);
  
  public final String listingString(DalvInsn paramDalvInsn, boolean paramBoolean)
  {
    String str1 = paramDalvInsn.getOpcode().getName();
    String str2 = insnArgString(paramDalvInsn);
    paramDalvInsn = insnCommentString(paramDalvInsn, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(str1);
    if (str2.length() != 0)
    {
      localStringBuilder.append(' ');
      localStringBuilder.append(str2);
    }
    if (paramDalvInsn.length() != 0)
    {
      localStringBuilder.append(" // ");
      localStringBuilder.append(paramDalvInsn);
    }
    return localStringBuilder.toString();
  }
  
  public abstract void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.InsnFormat
 * JD-Core Version:    0.7.0.1
 */