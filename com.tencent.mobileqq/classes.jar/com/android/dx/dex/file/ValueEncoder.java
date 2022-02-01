package com.android.dx.dex.file;

import com.android.dex.EncodedValueCodec;
import com.android.dx.rop.annotation.Annotation;
import com.android.dx.rop.annotation.NameValuePair;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstAnnotation;
import com.android.dx.rop.cst.CstArray;
import com.android.dx.rop.cst.CstArray.List;
import com.android.dx.rop.cst.CstBoolean;
import com.android.dx.rop.cst.CstByte;
import com.android.dx.rop.cst.CstChar;
import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstEnumRef;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstLiteralBits;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstShort;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.Collection;
import java.util.Iterator;

public final class ValueEncoder
{
  private static final int VALUE_ANNOTATION = 29;
  private static final int VALUE_ARRAY = 28;
  private static final int VALUE_BOOLEAN = 31;
  private static final int VALUE_BYTE = 0;
  private static final int VALUE_CHAR = 3;
  private static final int VALUE_DOUBLE = 17;
  private static final int VALUE_ENUM = 27;
  private static final int VALUE_FIELD = 25;
  private static final int VALUE_FLOAT = 16;
  private static final int VALUE_INT = 4;
  private static final int VALUE_LONG = 6;
  private static final int VALUE_METHOD = 26;
  private static final int VALUE_NULL = 30;
  private static final int VALUE_SHORT = 2;
  private static final int VALUE_STRING = 23;
  private static final int VALUE_TYPE = 24;
  private final DexFile file;
  private final AnnotatedOutput out;
  
  public ValueEncoder(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    if (paramDexFile == null) {
      throw new NullPointerException("file == null");
    }
    if (paramAnnotatedOutput == null) {
      throw new NullPointerException("out == null");
    }
    this.file = paramDexFile;
    this.out = paramAnnotatedOutput;
  }
  
  public static void addContents(DexFile paramDexFile, Annotation paramAnnotation)
  {
    Object localObject = paramDexFile.getTypeIds();
    StringIdsSection localStringIdsSection = paramDexFile.getStringIds();
    ((TypeIdsSection)localObject).intern(paramAnnotation.getType());
    paramAnnotation = paramAnnotation.getNameValuePairs().iterator();
    while (paramAnnotation.hasNext())
    {
      localObject = (NameValuePair)paramAnnotation.next();
      localStringIdsSection.intern(((NameValuePair)localObject).getName());
      addContents(paramDexFile, ((NameValuePair)localObject).getValue());
    }
  }
  
  public static void addContents(DexFile paramDexFile, Constant paramConstant)
  {
    if ((paramConstant instanceof CstAnnotation)) {
      addContents(paramDexFile, ((CstAnnotation)paramConstant).getAnnotation());
    }
    for (;;)
    {
      return;
      if (!(paramConstant instanceof CstArray)) {
        break;
      }
      paramConstant = ((CstArray)paramConstant).getList();
      int j = paramConstant.size();
      int i = 0;
      while (i < j)
      {
        addContents(paramDexFile, paramConstant.get(i));
        i += 1;
      }
    }
    paramDexFile.internIfAppropriate(paramConstant);
  }
  
  public static String constantToHuman(Constant paramConstant)
  {
    if (constantToValueType(paramConstant) == 30) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramConstant.typeName());
    localStringBuilder.append(' ');
    localStringBuilder.append(paramConstant.toHuman());
    return localStringBuilder.toString();
  }
  
  private static int constantToValueType(Constant paramConstant)
  {
    if ((paramConstant instanceof CstByte)) {
      return 0;
    }
    if ((paramConstant instanceof CstShort)) {
      return 2;
    }
    if ((paramConstant instanceof CstChar)) {
      return 3;
    }
    if ((paramConstant instanceof CstInteger)) {
      return 4;
    }
    if ((paramConstant instanceof CstLong)) {
      return 6;
    }
    if ((paramConstant instanceof CstFloat)) {
      return 16;
    }
    if ((paramConstant instanceof CstDouble)) {
      return 17;
    }
    if ((paramConstant instanceof CstString)) {
      return 23;
    }
    if ((paramConstant instanceof CstType)) {
      return 24;
    }
    if ((paramConstant instanceof CstFieldRef)) {
      return 25;
    }
    if ((paramConstant instanceof CstMethodRef)) {
      return 26;
    }
    if ((paramConstant instanceof CstEnumRef)) {
      return 27;
    }
    if ((paramConstant instanceof CstArray)) {
      return 28;
    }
    if ((paramConstant instanceof CstAnnotation)) {
      return 29;
    }
    if ((paramConstant instanceof CstKnownNull)) {
      return 30;
    }
    if ((paramConstant instanceof CstBoolean)) {
      return 31;
    }
    throw new RuntimeException("Shouldn't happen");
  }
  
  public void writeAnnotation(Annotation paramAnnotation, boolean paramBoolean)
  {
    int j;
    Object localObject2;
    label187:
    int k;
    if ((paramBoolean) && (this.out.annotates()))
    {
      j = 1;
      StringIdsSection localStringIdsSection = this.file.getStringIds();
      Object localObject1 = this.file.getTypeIds();
      localObject2 = paramAnnotation.getType();
      int i = ((TypeIdsSection)localObject1).indexOf((CstType)localObject2);
      if (j != 0) {
        this.out.annotate("  type_idx: " + Hex.u4(i) + " // " + ((CstType)localObject2).toHuman());
      }
      this.out.writeUleb128(((TypeIdsSection)localObject1).indexOf(paramAnnotation.getType()));
      paramAnnotation = paramAnnotation.getNameValuePairs();
      i = paramAnnotation.size();
      if (j != 0) {
        this.out.annotate("  size: " + Hex.u4(i));
      }
      this.out.writeUleb128(i);
      paramAnnotation = paramAnnotation.iterator();
      i = 0;
      if (!paramAnnotation.hasNext()) {
        break label384;
      }
      localObject2 = (NameValuePair)paramAnnotation.next();
      localObject1 = ((NameValuePair)localObject2).getName();
      k = localStringIdsSection.indexOf((CstString)localObject1);
      localObject2 = ((NameValuePair)localObject2).getValue();
      if (j == 0) {
        break label399;
      }
      this.out.annotate(0, "  elements[" + i + "]:");
      i += 1;
      this.out.annotate("    name_idx: " + Hex.u4(k) + " // " + ((CstString)localObject1).toHuman());
    }
    label384:
    label399:
    for (;;)
    {
      this.out.writeUleb128(k);
      if (j != 0) {
        this.out.annotate("    value: " + constantToHuman((Constant)localObject2));
      }
      writeConstant((Constant)localObject2);
      break label187;
      j = 0;
      break;
      if (j != 0) {
        this.out.endAnnotation();
      }
      return;
    }
  }
  
  public void writeArray(CstArray paramCstArray, boolean paramBoolean)
  {
    int j = 0;
    if ((paramBoolean) && (this.out.annotates())) {}
    for (int i = 1;; i = 0)
    {
      paramCstArray = paramCstArray.getList();
      int k = paramCstArray.size();
      if (i != 0) {
        this.out.annotate("  size: " + Hex.u4(k));
      }
      this.out.writeUleb128(k);
      while (j < k)
      {
        Constant localConstant = paramCstArray.get(j);
        if (i != 0) {
          this.out.annotate("  [" + Integer.toHexString(j) + "] " + constantToHuman(localConstant));
        }
        writeConstant(localConstant);
        j += 1;
      }
    }
    if (i != 0) {
      this.out.endAnnotation();
    }
  }
  
  public void writeConstant(Constant paramConstant)
  {
    int i = constantToValueType(paramConstant);
    long l;
    switch (i)
    {
    case 1: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    default: 
      throw new RuntimeException("Shouldn't happen");
    case 0: 
    case 2: 
    case 4: 
    case 6: 
      l = ((CstLiteralBits)paramConstant).getLongBits();
      EncodedValueCodec.writeSignedIntegralValue(this.out, i, l);
      return;
    case 3: 
      l = ((CstLiteralBits)paramConstant).getLongBits();
      EncodedValueCodec.writeUnsignedIntegralValue(this.out, i, l);
      return;
    case 16: 
      l = ((CstFloat)paramConstant).getLongBits();
      EncodedValueCodec.writeRightZeroExtendedValue(this.out, i, l << 32);
      return;
    case 17: 
      l = ((CstDouble)paramConstant).getLongBits();
      EncodedValueCodec.writeRightZeroExtendedValue(this.out, i, l);
      return;
    case 23: 
      j = this.file.getStringIds().indexOf((CstString)paramConstant);
      EncodedValueCodec.writeUnsignedIntegralValue(this.out, i, j);
      return;
    case 24: 
      j = this.file.getTypeIds().indexOf((CstType)paramConstant);
      EncodedValueCodec.writeUnsignedIntegralValue(this.out, i, j);
      return;
    case 25: 
      j = this.file.getFieldIds().indexOf((CstFieldRef)paramConstant);
      EncodedValueCodec.writeUnsignedIntegralValue(this.out, i, j);
      return;
    case 26: 
      j = this.file.getMethodIds().indexOf((CstMethodRef)paramConstant);
      EncodedValueCodec.writeUnsignedIntegralValue(this.out, i, j);
      return;
    case 27: 
      paramConstant = ((CstEnumRef)paramConstant).getFieldRef();
      j = this.file.getFieldIds().indexOf(paramConstant);
      EncodedValueCodec.writeUnsignedIntegralValue(this.out, i, j);
      return;
    case 28: 
      this.out.writeByte(i);
      writeArray((CstArray)paramConstant, false);
      return;
    case 29: 
      this.out.writeByte(i);
      writeAnnotation(((CstAnnotation)paramConstant).getAnnotation(), false);
      return;
    case 30: 
      this.out.writeByte(i);
      return;
    }
    int j = ((CstBoolean)paramConstant).getIntBits();
    this.out.writeByte(i | j << 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.ValueEncoder
 * JD-Core Version:    0.7.0.1
 */