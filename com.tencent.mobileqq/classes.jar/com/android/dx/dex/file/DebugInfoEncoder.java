package com.android.dx.dex.file;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.dex.code.LocalList;
import com.android.dx.dex.code.LocalList.Disposition;
import com.android.dx.dex.code.LocalList.Entry;
import com.android.dx.dex.code.PositionList;
import com.android.dx.dex.code.PositionList.Entry;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;

public final class DebugInfoEncoder
{
  private static final boolean DEBUG = false;
  private int address = 0;
  private AnnotatedOutput annotateTo;
  private final int codeSize;
  private PrintWriter debugPrint;
  private final Prototype desc;
  private final DexFile file;
  private final boolean isStatic;
  private final LocalList.Entry[] lastEntryForReg;
  private int line = 1;
  private final LocalList locals;
  private final ByteArrayAnnotatedOutput output;
  private final PositionList positions;
  private String prefix;
  private final int regSize;
  private boolean shouldConsume;
  
  public DebugInfoEncoder(PositionList paramPositionList, LocalList paramLocalList, DexFile paramDexFile, int paramInt1, int paramInt2, boolean paramBoolean, CstMethodRef paramCstMethodRef)
  {
    this.positions = paramPositionList;
    this.locals = paramLocalList;
    this.file = paramDexFile;
    this.desc = paramCstMethodRef.getPrototype();
    this.isStatic = paramBoolean;
    this.codeSize = paramInt1;
    this.regSize = paramInt2;
    this.output = new ByteArrayAnnotatedOutput();
    this.lastEntryForReg = new LocalList.Entry[paramInt2];
  }
  
  private void annotate(int paramInt, String paramString)
  {
    String str = paramString;
    if (this.prefix != null) {
      str = this.prefix + paramString;
    }
    if (this.annotateTo != null)
    {
      paramString = this.annotateTo;
      if (!this.shouldConsume) {
        break label74;
      }
    }
    for (;;)
    {
      paramString.annotate(paramInt, str);
      if (this.debugPrint != null) {
        this.debugPrint.println(str);
      }
      return;
      label74:
      paramInt = 0;
    }
  }
  
  private ArrayList<PositionList.Entry> buildSortedPositions()
  {
    int j = 0;
    if (this.positions == null) {}
    ArrayList localArrayList;
    for (int i = 0;; i = this.positions.size())
    {
      localArrayList = new ArrayList(i);
      while (j < i)
      {
        localArrayList.add(this.positions.get(j));
        j += 1;
      }
    }
    Collections.sort(localArrayList, new DebugInfoEncoder.1(this));
    return localArrayList;
  }
  
  private static int computeOpcode(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < -4) || (paramInt1 > 10)) {
      throw new RuntimeException("Parameter out of range");
    }
    return paramInt1 + 4 + paramInt2 * 15 + 10;
  }
  
  private byte[] convert0()
  {
    int j = 0;
    ArrayList localArrayList = buildSortedPositions();
    emitHeader(localArrayList, extractMethodArguments());
    this.output.writeByte(7);
    if ((this.annotateTo != null) || (this.debugPrint != null)) {
      annotate(1, String.format("%04x: prologue end", new Object[] { Integer.valueOf(this.address) }));
    }
    int n = localArrayList.size();
    int i1 = this.locals.size();
    int i = 0;
    int k = emitLocalsAtAddress(j);
    int m = emitPositionsAtAddress(i, localArrayList);
    if (k < i1) {}
    for (i = this.locals.get(k).getAddress();; i = 2147483647)
    {
      if (m < n) {}
      for (j = ((PositionList.Entry)localArrayList.get(m)).getAddress();; j = 2147483647)
      {
        int i2 = Math.min(j, i);
        if (i2 == 2147483647) {}
        while ((i2 == this.codeSize) && (i == 2147483647) && (j == 2147483647))
        {
          emitEndSequence();
          return this.output.toByteArray();
        }
        if (i2 == j) {
          emitPosition((PositionList.Entry)localArrayList.get(m));
        }
        for (i = m + 1;; i = m)
        {
          j = k;
          break;
          emitAdvancePc(i2 - this.address);
        }
      }
    }
  }
  
  private void emitAdvanceLine(int paramInt)
  {
    int i = this.output.getCursor();
    this.output.writeByte(2);
    this.output.writeSleb128(paramInt);
    this.line += paramInt;
    if ((this.annotateTo != null) || (this.debugPrint != null)) {
      annotate(this.output.getCursor() - i, String.format("line = %d", new Object[] { Integer.valueOf(this.line) }));
    }
  }
  
  private void emitAdvancePc(int paramInt)
  {
    int i = this.output.getCursor();
    this.output.writeByte(1);
    this.output.writeUleb128(paramInt);
    this.address += paramInt;
    if ((this.annotateTo != null) || (this.debugPrint != null)) {
      annotate(this.output.getCursor() - i, String.format("%04x: advance pc", new Object[] { Integer.valueOf(this.address) }));
    }
  }
  
  private void emitEndSequence()
  {
    this.output.writeByte(0);
    if ((this.annotateTo != null) || (this.debugPrint != null)) {
      annotate(1, "end sequence");
    }
  }
  
  private void emitHeader(ArrayList<PositionList.Entry> paramArrayList, ArrayList<LocalList.Entry> paramArrayList1)
  {
    int m = 0;
    int j;
    int i;
    StdTypeList localStdTypeList;
    int i1;
    Object localObject;
    if ((this.annotateTo != null) || (this.debugPrint != null))
    {
      j = 1;
      i = this.output.getCursor();
      if (paramArrayList.size() > 0) {
        this.line = ((PositionList.Entry)paramArrayList.get(0)).getPosition().getLine();
      }
      this.output.writeUleb128(this.line);
      if (j != 0) {
        annotate(this.output.getCursor() - i, "line_start: " + this.line);
      }
      i = getParamBase();
      localStdTypeList = this.desc.getParameterTypes();
      i1 = localStdTypeList.size();
      if (this.isStatic) {
        break label502;
      }
      paramArrayList = paramArrayList1.iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (LocalList.Entry)paramArrayList.next();
        if (i == ((LocalList.Entry)localObject).getRegister()) {
          this.lastEntryForReg[i] = localObject;
        }
      }
      i += 1;
    }
    label244:
    label502:
    for (;;)
    {
      int k = this.output.getCursor();
      this.output.writeUleb128(i1);
      if (j != 0) {
        annotate(this.output.getCursor() - k, String.format("parameters_size: %04x", new Object[] { Integer.valueOf(i1) }));
      }
      int n = 0;
      k = i;
      i = n;
      if (i < i1)
      {
        localObject = localStdTypeList.get(i);
        n = this.output.getCursor();
        Iterator localIterator = paramArrayList1.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            paramArrayList = (LocalList.Entry)localIterator.next();
            if (k == paramArrayList.getRegister()) {
              if (paramArrayList.getSignature() != null)
              {
                emitStringIndex(null);
                this.lastEntryForReg[k] = paramArrayList;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (paramArrayList == null) {
          emitStringIndex(null);
        }
        if (j != 0) {
          if ((paramArrayList != null) && (paramArrayList.getSignature() == null)) {
            break label437;
          }
        }
        for (paramArrayList = "<unnamed>";; paramArrayList = paramArrayList.getName().toHuman())
        {
          annotate(this.output.getCursor() - n, "parameter " + paramArrayList + " " + "v" + k);
          k += ((Type)localObject).getCategory();
          i += 1;
          break label244;
          j = 0;
          break;
          emitStringIndex(paramArrayList.getName());
          break label315;
        }
        paramArrayList = this.lastEntryForReg;
        j = paramArrayList.length;
        i = m;
        if (i < j)
        {
          paramArrayList1 = paramArrayList[i];
          if (paramArrayList1 == null) {}
          for (;;)
          {
            i += 1;
            break;
            if (paramArrayList1.getSignature() != null) {
              emitLocalStartExtended(paramArrayList1);
            }
          }
        }
        return;
        paramArrayList = null;
      }
    }
  }
  
  private void emitLocalEnd(LocalList.Entry paramEntry)
  {
    int i = this.output.getCursor();
    this.output.writeByte(5);
    this.output.writeUleb128(paramEntry.getRegister());
    if ((this.annotateTo != null) || (this.debugPrint != null)) {
      annotate(this.output.getCursor() - i, String.format("%04x: -local %s", new Object[] { Integer.valueOf(this.address), entryAnnotationString(paramEntry) }));
    }
  }
  
  private void emitLocalRestart(LocalList.Entry paramEntry)
  {
    int i = this.output.getCursor();
    this.output.writeByte(6);
    emitUnsignedLeb128(paramEntry.getRegister());
    if ((this.annotateTo != null) || (this.debugPrint != null)) {
      annotate(this.output.getCursor() - i, String.format("%04x: +local restart %s", new Object[] { Integer.valueOf(this.address), entryAnnotationString(paramEntry) }));
    }
  }
  
  private void emitLocalStart(LocalList.Entry paramEntry)
  {
    if (paramEntry.getSignature() != null) {
      emitLocalStartExtended(paramEntry);
    }
    int i;
    do
    {
      return;
      i = this.output.getCursor();
      this.output.writeByte(3);
      emitUnsignedLeb128(paramEntry.getRegister());
      emitStringIndex(paramEntry.getName());
      emitTypeIndex(paramEntry.getType());
    } while ((this.annotateTo == null) && (this.debugPrint == null));
    annotate(this.output.getCursor() - i, String.format("%04x: +local %s", new Object[] { Integer.valueOf(this.address), entryAnnotationString(paramEntry) }));
  }
  
  private void emitLocalStartExtended(LocalList.Entry paramEntry)
  {
    int i = this.output.getCursor();
    this.output.writeByte(4);
    emitUnsignedLeb128(paramEntry.getRegister());
    emitStringIndex(paramEntry.getName());
    emitTypeIndex(paramEntry.getType());
    emitStringIndex(paramEntry.getSignature());
    if ((this.annotateTo != null) || (this.debugPrint != null)) {
      annotate(this.output.getCursor() - i, String.format("%04x: +localx %s", new Object[] { Integer.valueOf(this.address), entryAnnotationString(paramEntry) }));
    }
  }
  
  private int emitLocalsAtAddress(int paramInt)
  {
    int j = this.locals.size();
    while ((paramInt < j) && (this.locals.get(paramInt).getAddress() == this.address))
    {
      Object localObject = this.locals;
      int i = paramInt + 1;
      localObject = ((LocalList)localObject).get(paramInt);
      paramInt = ((LocalList.Entry)localObject).getRegister();
      LocalList.Entry localEntry = this.lastEntryForReg[paramInt];
      if (localObject == localEntry)
      {
        paramInt = i;
      }
      else
      {
        this.lastEntryForReg[paramInt] = localObject;
        if (((LocalList.Entry)localObject).isStart()) {
          if ((localEntry != null) && (((LocalList.Entry)localObject).matches(localEntry)))
          {
            if (localEntry.isStart()) {
              throw new RuntimeException("shouldn't happen");
            }
            emitLocalRestart((LocalList.Entry)localObject);
          }
        }
        for (;;)
        {
          paramInt = i;
          break;
          emitLocalStart((LocalList.Entry)localObject);
          continue;
          if (((LocalList.Entry)localObject).getDisposition() != LocalList.Disposition.END_REPLACED) {
            emitLocalEnd((LocalList.Entry)localObject);
          }
        }
      }
    }
    return paramInt;
  }
  
  private void emitPosition(PositionList.Entry paramEntry)
  {
    int j = paramEntry.getPosition().getLine();
    int i = paramEntry.getAddress();
    j -= this.line;
    int m = i - this.address;
    if (m < 0) {
      throw new RuntimeException("Position entries must be in ascending address order");
    }
    if (j >= -4)
    {
      i = j;
      if (j <= 10) {}
    }
    else
    {
      emitAdvanceLine(j);
      i = 0;
    }
    int k = computeOpcode(i, m);
    if ((k & 0xFFFFFF00) > 0)
    {
      emitAdvancePc(m);
      k = computeOpcode(i, 0);
      if ((k & 0xFFFFFF00) > 0)
      {
        emitAdvanceLine(i);
        k = computeOpcode(0, 0);
        j = 0;
        i = 0;
      }
    }
    for (;;)
    {
      this.output.writeByte(k);
      this.line = (j + this.line);
      this.address = (i + this.address);
      if ((this.annotateTo != null) || (this.debugPrint != null)) {
        annotate(1, String.format("%04x: line %d", new Object[] { Integer.valueOf(this.address), Integer.valueOf(this.line) }));
      }
      return;
      j = i;
      i = 0;
      continue;
      j = i;
      i = m;
    }
  }
  
  private int emitPositionsAtAddress(int paramInt, ArrayList<PositionList.Entry> paramArrayList)
  {
    int i = paramArrayList.size();
    while ((paramInt < i) && (((PositionList.Entry)paramArrayList.get(paramInt)).getAddress() == this.address))
    {
      emitPosition((PositionList.Entry)paramArrayList.get(paramInt));
      paramInt += 1;
    }
    return paramInt;
  }
  
  private void emitStringIndex(CstString paramCstString)
  {
    if ((paramCstString == null) || (this.file == null))
    {
      this.output.writeUleb128(0);
      return;
    }
    this.output.writeUleb128(this.file.getStringIds().indexOf(paramCstString) + 1);
  }
  
  private void emitTypeIndex(CstType paramCstType)
  {
    if ((paramCstType == null) || (this.file == null))
    {
      this.output.writeUleb128(0);
      return;
    }
    this.output.writeUleb128(this.file.getTypeIds().indexOf(paramCstType) + 1);
  }
  
  private void emitUnsignedLeb128(int paramInt)
  {
    if (paramInt < 0) {
      throw new RuntimeException("Signed value where unsigned required: " + paramInt);
    }
    this.output.writeUleb128(paramInt);
  }
  
  private String entryAnnotationString(LocalList.Entry paramEntry)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v");
    localStringBuilder.append(paramEntry.getRegister());
    localStringBuilder.append(' ');
    Object localObject = paramEntry.getName();
    if (localObject == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(' ');
      localObject = paramEntry.getType();
      if (localObject != null) {
        break label115;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      paramEntry = paramEntry.getSignature();
      if (paramEntry != null)
      {
        localStringBuilder.append(' ');
        localStringBuilder.append(paramEntry.toHuman());
      }
      return localStringBuilder.toString();
      localStringBuilder.append(((CstString)localObject).toHuman());
      break;
      label115:
      localStringBuilder.append(((CstType)localObject).toHuman());
    }
  }
  
  private ArrayList<LocalList.Entry> extractMethodArguments()
  {
    ArrayList localArrayList = new ArrayList(this.desc.getParameterTypes().size());
    int j = getParamBase();
    BitSet localBitSet = new BitSet(this.regSize - j);
    int k = this.locals.size();
    int i = 0;
    if (i < k)
    {
      LocalList.Entry localEntry = this.locals.get(i);
      int m = localEntry.getRegister();
      if (m < j) {}
      for (;;)
      {
        i += 1;
        break;
        if (!localBitSet.get(m - j))
        {
          localBitSet.set(m - j);
          localArrayList.add(localEntry);
        }
      }
    }
    Collections.sort(localArrayList, new DebugInfoEncoder.2(this));
    return localArrayList;
  }
  
  private int getParamBase()
  {
    int j = this.regSize;
    int k = this.desc.getParameterTypes().getWordCount();
    if (this.isStatic) {}
    for (int i = 0;; i = 1) {
      return j - k - i;
    }
  }
  
  public byte[] convert()
  {
    try
    {
      byte[] arrayOfByte = convert0();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw ExceptionWithContext.withContext(localIOException, "...while encoding debug info");
    }
  }
  
  public byte[] convertAndAnnotate(String paramString, PrintWriter paramPrintWriter, AnnotatedOutput paramAnnotatedOutput, boolean paramBoolean)
  {
    this.prefix = paramString;
    this.debugPrint = paramPrintWriter;
    this.annotateTo = paramAnnotatedOutput;
    this.shouldConsume = paramBoolean;
    return convert();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.DebugInfoEncoder
 * JD-Core Version:    0.7.0.1
 */