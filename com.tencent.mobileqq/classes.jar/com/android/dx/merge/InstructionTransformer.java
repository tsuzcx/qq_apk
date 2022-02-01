package com.android.dx.merge;

import com.android.dex.DexIndexOverflowException;
import com.android.dx.io.CodeReader;
import com.android.dx.io.instructions.DecodedInstruction;
import com.android.dx.io.instructions.ShortArrayCodeOutput;

final class InstructionTransformer
{
  private IndexMap indexMap;
  private int mappedAt;
  private DecodedInstruction[] mappedInstructions;
  private final CodeReader reader = new CodeReader();
  
  public InstructionTransformer()
  {
    this.reader.setAllVisitors(new InstructionTransformer.GenericVisitor(this, null));
    this.reader.setStringVisitor(new InstructionTransformer.StringVisitor(this, null));
    this.reader.setTypeVisitor(new InstructionTransformer.TypeVisitor(this, null));
    this.reader.setFieldVisitor(new InstructionTransformer.FieldVisitor(this, null));
    this.reader.setMethodVisitor(new InstructionTransformer.MethodVisitor(this, null));
  }
  
  private static void jumboCheck(boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) && (paramInt > 65535)) {
      throw new DexIndexOverflowException("Cannot merge new index " + paramInt + " into a non-jumbo instruction!");
    }
  }
  
  public short[] transform(IndexMap paramIndexMap, short[] paramArrayOfShort)
  {
    int i = 0;
    paramArrayOfShort = DecodedInstruction.decodeAll(paramArrayOfShort);
    int j = paramArrayOfShort.length;
    this.indexMap = paramIndexMap;
    this.mappedInstructions = new DecodedInstruction[j];
    this.mappedAt = 0;
    this.reader.visitAll(paramArrayOfShort);
    paramIndexMap = new ShortArrayCodeOutput(j);
    paramArrayOfShort = this.mappedInstructions;
    j = paramArrayOfShort.length;
    while (i < j)
    {
      short s = paramArrayOfShort[i];
      if (s != null) {
        s.encode(paramIndexMap);
      }
      i += 1;
    }
    this.indexMap = null;
    return paramIndexMap.getArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.InstructionTransformer
 * JD-Core Version:    0.7.0.1
 */