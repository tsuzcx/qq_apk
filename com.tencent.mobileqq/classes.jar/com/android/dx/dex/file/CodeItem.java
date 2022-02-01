package com.android.dx.dex.file;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.dex.code.DalvCode;
import com.android.dx.dex.code.DalvInsnList;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;

public final class CodeItem
  extends OffsettedItem
{
  private static final int ALIGNMENT = 4;
  private static final int HEADER_SIZE = 16;
  private CatchStructs catches;
  private final DalvCode code;
  private DebugInfoItem debugInfo;
  private final boolean isStatic;
  private final CstMethodRef ref;
  private final TypeList throwsList;
  
  public CodeItem(CstMethodRef paramCstMethodRef, DalvCode paramDalvCode, boolean paramBoolean, TypeList paramTypeList)
  {
    super(4, -1);
    if (paramCstMethodRef == null) {
      throw new NullPointerException("ref == null");
    }
    if (paramDalvCode == null) {
      throw new NullPointerException("code == null");
    }
    if (paramTypeList == null) {
      throw new NullPointerException("throwsList == null");
    }
    this.ref = paramCstMethodRef;
    this.code = paramDalvCode;
    this.isStatic = paramBoolean;
    this.throwsList = paramTypeList;
    this.catches = null;
    this.debugInfo = null;
  }
  
  private int getInsSize()
  {
    return this.ref.getParameterWordCount(this.isStatic);
  }
  
  private int getOutsSize()
  {
    return this.code.getInsns().getOutsSize();
  }
  
  private int getRegistersSize()
  {
    return this.code.getInsns().getRegistersSize();
  }
  
  private void writeCodes(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    paramDexFile = this.code.getInsns();
    try
    {
      paramDexFile.writeTo(paramAnnotatedOutput);
      return;
    }
    catch (RuntimeException paramDexFile)
    {
      throw ExceptionWithContext.withContext(paramDexFile, "...while writing instructions for " + this.ref.toHuman());
    }
  }
  
  public void addContents(DexFile paramDexFile)
  {
    Object localObject2 = paramDexFile.getByteData();
    Object localObject1 = paramDexFile.getTypeIds();
    if ((this.code.hasPositions()) || (this.code.hasLocals()))
    {
      this.debugInfo = new DebugInfoItem(this.code, this.isStatic, this.ref);
      ((MixedItemSection)localObject2).add(this.debugInfo);
    }
    if (this.code.hasAnyCatches())
    {
      localObject2 = this.code.getCatchTypes().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((TypeIdsSection)localObject1).intern((Type)((Iterator)localObject2).next());
      }
      this.catches = new CatchStructs(this.code);
    }
    localObject1 = this.code.getInsnConstants().iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramDexFile.internIfAppropriate((Constant)((Iterator)localObject1).next());
    }
  }
  
  public void debugPrint(PrintWriter paramPrintWriter, String paramString, boolean paramBoolean)
  {
    paramPrintWriter.println(this.ref.toHuman() + ":");
    Object localObject = this.code.getInsns();
    paramPrintWriter.println("regs: " + Hex.u2(getRegistersSize()) + "; ins: " + Hex.u2(getInsSize()) + "; outs: " + Hex.u2(getOutsSize()));
    ((DalvInsnList)localObject).debugPrint(paramPrintWriter, paramString, paramBoolean);
    localObject = paramString + "  ";
    if (this.catches != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("catches");
      this.catches.debugPrint(paramPrintWriter, (String)localObject);
    }
    if (this.debugInfo != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("debug info");
      this.debugInfo.debugPrint(paramPrintWriter, (String)localObject);
    }
  }
  
  public CstMethodRef getRef()
  {
    return this.ref;
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_CODE_ITEM;
  }
  
  protected void place0(Section paramSection, int paramInt)
  {
    paramSection = paramSection.getFile();
    this.code.assignIndices(new CodeItem.1(this, paramSection));
    if (this.catches != null) {
      this.catches.encode(paramSection);
    }
    for (paramInt = this.catches.writeSize();; paramInt = 0)
    {
      int j = this.code.getInsns().codeSize();
      int i = j;
      if ((j & 0x1) != 0) {
        i = j + 1;
      }
      setWriteSize(paramInt + (i * 2 + 16));
      return;
    }
  }
  
  public String toHuman()
  {
    return this.ref.toHuman();
  }
  
  public String toString()
  {
    return "CodeItem{" + toHuman() + "}";
  }
  
  protected void writeTo0(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    boolean bool = paramAnnotatedOutput.annotates();
    int m = getRegistersSize();
    int n = getOutsSize();
    int i1 = getInsSize();
    int i2 = this.code.getInsns().codeSize();
    int i;
    int j;
    if ((i2 & 0x1) != 0)
    {
      i = 1;
      if (this.catches != null) {
        break label478;
      }
      j = 0;
      label57:
      if (this.debugInfo != null) {
        break label490;
      }
    }
    label478:
    label490:
    for (int k = 0;; k = this.debugInfo.getAbsoluteOffset())
    {
      if (bool)
      {
        paramAnnotatedOutput.annotate(0, offsetString() + ' ' + this.ref.toHuman());
        paramAnnotatedOutput.annotate(2, "  registers_size: " + Hex.u2(m));
        paramAnnotatedOutput.annotate(2, "  ins_size:       " + Hex.u2(i1));
        paramAnnotatedOutput.annotate(2, "  outs_size:      " + Hex.u2(n));
        paramAnnotatedOutput.annotate(2, "  tries_size:     " + Hex.u2(j));
        paramAnnotatedOutput.annotate(4, "  debug_off:      " + Hex.u4(k));
        paramAnnotatedOutput.annotate(4, "  insns_size:     " + Hex.u4(i2));
        if (this.throwsList.size() != 0) {
          paramAnnotatedOutput.annotate(0, "  throws " + StdTypeList.toHuman(this.throwsList));
        }
      }
      paramAnnotatedOutput.writeShort(m);
      paramAnnotatedOutput.writeShort(i1);
      paramAnnotatedOutput.writeShort(n);
      paramAnnotatedOutput.writeShort(j);
      paramAnnotatedOutput.writeInt(k);
      paramAnnotatedOutput.writeInt(i2);
      writeCodes(paramDexFile, paramAnnotatedOutput);
      if (this.catches != null)
      {
        if (i != 0)
        {
          if (bool) {
            paramAnnotatedOutput.annotate(2, "  padding: 0");
          }
          paramAnnotatedOutput.writeShort(0);
        }
        this.catches.writeTo(paramDexFile, paramAnnotatedOutput);
      }
      if ((bool) && (this.debugInfo != null))
      {
        paramAnnotatedOutput.annotate(0, "  debug info");
        this.debugInfo.annotateTo(paramDexFile, paramAnnotatedOutput, "    ");
      }
      return;
      i = 0;
      break;
      j = this.catches.triesSize();
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.CodeItem
 * JD-Core Version:    0.7.0.1
 */