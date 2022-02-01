package com.android.dx.dex.file;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.dex.code.DalvCode;
import com.android.dx.dex.code.DalvInsnList;
import com.android.dx.dex.code.LocalList;
import com.android.dx.dex.code.PositionList;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.util.AnnotatedOutput;
import java.io.PrintWriter;

public class DebugInfoItem
  extends OffsettedItem
{
  private static final int ALIGNMENT = 1;
  private static final boolean ENABLE_ENCODER_SELF_CHECK = false;
  private final DalvCode code;
  private byte[] encoded;
  private final boolean isStatic;
  private final CstMethodRef ref;
  
  public DebugInfoItem(DalvCode paramDalvCode, boolean paramBoolean, CstMethodRef paramCstMethodRef)
  {
    super(1, -1);
    if (paramDalvCode == null) {
      throw new NullPointerException("code == null");
    }
    this.code = paramDalvCode;
    this.isStatic = paramBoolean;
    this.ref = paramCstMethodRef;
  }
  
  private byte[] encode(DexFile paramDexFile, String paramString, PrintWriter paramPrintWriter, AnnotatedOutput paramAnnotatedOutput, boolean paramBoolean)
  {
    return encode0(paramDexFile, paramString, paramPrintWriter, paramAnnotatedOutput, paramBoolean);
  }
  
  private byte[] encode0(DexFile paramDexFile, String paramString, PrintWriter paramPrintWriter, AnnotatedOutput paramAnnotatedOutput, boolean paramBoolean)
  {
    PositionList localPositionList = this.code.getPositions();
    LocalList localLocalList = this.code.getLocals();
    DalvInsnList localDalvInsnList = this.code.getInsns();
    paramDexFile = new DebugInfoEncoder(localPositionList, localLocalList, paramDexFile, localDalvInsnList.codeSize(), localDalvInsnList.getRegistersSize(), this.isStatic, this.ref);
    if ((paramPrintWriter == null) && (paramAnnotatedOutput == null)) {
      return paramDexFile.convert();
    }
    return paramDexFile.convertAndAnnotate(paramString, paramPrintWriter, paramAnnotatedOutput, paramBoolean);
  }
  
  public void addContents(DexFile paramDexFile) {}
  
  public void annotateTo(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput, String paramString)
  {
    encode(paramDexFile, paramString, null, paramAnnotatedOutput, false);
  }
  
  public void debugPrint(PrintWriter paramPrintWriter, String paramString)
  {
    encode(null, paramString, paramPrintWriter, null, false);
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_DEBUG_INFO_ITEM;
  }
  
  protected void place0(Section paramSection, int paramInt)
  {
    try
    {
      this.encoded = encode(paramSection.getFile(), null, null, null, false);
      setWriteSize(this.encoded.length);
      return;
    }
    catch (RuntimeException paramSection)
    {
      throw ExceptionWithContext.withContext(paramSection, "...while placing debug info for " + this.ref.toHuman());
    }
  }
  
  public String toHuman()
  {
    throw new RuntimeException("unsupported");
  }
  
  protected void writeTo0(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(offsetString() + " debug info");
      encode(paramDexFile, null, null, paramAnnotatedOutput, true);
    }
    paramAnnotatedOutput.write(this.encoded);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.DebugInfoItem
 * JD-Core Version:    0.7.0.1
 */