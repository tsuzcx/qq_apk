package com.android.dx.dex.file;

import com.android.dex.Leb128;
import com.android.dex.util.ByteArrayByteInput;
import com.android.dex.util.ByteInput;
import com.android.dex.util.ExceptionWithContext;
import com.android.dx.dex.code.DalvCode;
import com.android.dx.dex.code.DalvInsnList;
import com.android.dx.dex.code.LocalList;
import com.android.dx.dex.code.LocalList.Disposition;
import com.android.dx.dex.code.LocalList.Entry;
import com.android.dx.dex.code.PositionList;
import com.android.dx.dex.code.PositionList.Entry;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DebugInfoDecoder
{
  private int address = 0;
  private final int codesize;
  private final Prototype desc;
  private final byte[] encoded;
  private final DexFile file;
  private final boolean isStatic;
  private final DebugInfoDecoder.LocalEntry[] lastEntryForReg;
  private int line = 1;
  private final ArrayList<DebugInfoDecoder.LocalEntry> locals;
  private final ArrayList<DebugInfoDecoder.PositionEntry> positions;
  private final int regSize;
  private final int thisStringIdx;
  
  DebugInfoDecoder(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean, CstMethodRef paramCstMethodRef, DexFile paramDexFile)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("encoded == null");
    }
    this.encoded = paramArrayOfByte;
    this.isStatic = paramBoolean;
    this.desc = paramCstMethodRef.getPrototype();
    this.file = paramDexFile;
    this.regSize = paramInt2;
    this.positions = new ArrayList();
    this.locals = new ArrayList();
    this.codesize = paramInt1;
    this.lastEntryForReg = new DebugInfoDecoder.LocalEntry[paramInt2];
    paramInt1 = -1;
    try
    {
      paramInt2 = paramDexFile.getStringIds().indexOf(new CstString("this"));
      paramInt1 = paramInt2;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      label116:
      break label116;
    }
    this.thisStringIdx = paramInt1;
  }
  
  private void decode0()
  {
    ByteArrayByteInput localByteArrayByteInput = new ByteArrayByteInput(this.encoded);
    this.line = Leb128.readUnsignedLeb128(localByteArrayByteInput);
    int k = Leb128.readUnsignedLeb128(localByteArrayByteInput);
    StdTypeList localStdTypeList = this.desc.getParameterTypes();
    int j = getParamBase();
    if (k != localStdTypeList.size()) {
      throw new RuntimeException("Mismatch between parameters_size and prototype");
    }
    int i = j;
    DebugInfoDecoder.LocalEntry localLocalEntry1;
    if (!this.isStatic)
    {
      localLocalEntry1 = new DebugInfoDecoder.LocalEntry(0, true, j, this.thisStringIdx, 0, 0);
      this.locals.add(localLocalEntry1);
      this.lastEntryForReg[j] = localLocalEntry1;
      i = j + 1;
    }
    j = 0;
    int m;
    if (j < k)
    {
      Type localType = localStdTypeList.getType(j);
      m = readStringIndex(localByteArrayByteInput);
      if (m == -1) {}
      for (localLocalEntry1 = new DebugInfoDecoder.LocalEntry(0, true, i, -1, 0, 0);; localLocalEntry1 = new DebugInfoDecoder.LocalEntry(0, true, i, m, 0, 0))
      {
        this.locals.add(localLocalEntry1);
        this.lastEntryForReg[i] = localLocalEntry1;
        i += localType.getCategory();
        j += 1;
        break;
      }
      i = Leb128.readUnsignedLeb128(localByteArrayByteInput);
      j = readStringIndex(localByteArrayByteInput);
      k = readStringIndex(localByteArrayByteInput);
      localLocalEntry1 = new DebugInfoDecoder.LocalEntry(this.address, true, i, j, k, 0);
      this.locals.add(localLocalEntry1);
      this.lastEntryForReg[i] = localLocalEntry1;
    }
    for (;;)
    {
      i = localByteArrayByteInput.readByte() & 0xFF;
      DebugInfoDecoder.LocalEntry localLocalEntry2;
      switch (i)
      {
      case 3: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        if (i < 10) {
          throw new RuntimeException("Invalid extended opcode encountered " + i);
        }
      case 4: 
        i = Leb128.readUnsignedLeb128(localByteArrayByteInput);
        j = readStringIndex(localByteArrayByteInput);
        k = readStringIndex(localByteArrayByteInput);
        m = readStringIndex(localByteArrayByteInput);
        localLocalEntry1 = new DebugInfoDecoder.LocalEntry(this.address, true, i, j, k, m);
        this.locals.add(localLocalEntry1);
        this.lastEntryForReg[i] = localLocalEntry1;
        break;
      case 6: 
        i = Leb128.readUnsignedLeb128(localByteArrayByteInput);
        try
        {
          localLocalEntry1 = this.lastEntryForReg[i];
          if (localLocalEntry1.isStart) {
            throw new RuntimeException("nonsensical RESTART_LOCAL on live register v" + i);
          }
        }
        catch (NullPointerException localNullPointerException1)
        {
          throw new RuntimeException("Encountered RESTART_LOCAL on new v" + i);
        }
        localLocalEntry2 = new DebugInfoDecoder.LocalEntry(this.address, true, i, localNullPointerException1.nameIndex, localNullPointerException1.typeIndex, 0);
        this.locals.add(localLocalEntry2);
        this.lastEntryForReg[i] = localLocalEntry2;
        break;
      case 5: 
        i = Leb128.readUnsignedLeb128(localByteArrayByteInput);
        try
        {
          localLocalEntry2 = this.lastEntryForReg[i];
          if (!localLocalEntry2.isStart) {
            throw new RuntimeException("nonsensical END_LOCAL on dead register v" + i);
          }
        }
        catch (NullPointerException localNullPointerException2)
        {
          throw new RuntimeException("Encountered END_LOCAL on new v" + i);
        }
        DebugInfoDecoder.LocalEntry localLocalEntry3 = new DebugInfoDecoder.LocalEntry(this.address, false, i, localNullPointerException2.nameIndex, localNullPointerException2.typeIndex, localNullPointerException2.signatureIndex);
        this.locals.add(localLocalEntry3);
        this.lastEntryForReg[i] = localLocalEntry3;
        break;
      case 1: 
        this.address += Leb128.readUnsignedLeb128(localByteArrayByteInput);
        break;
      case 2: 
        this.line += Leb128.readSignedLeb128(localByteArrayByteInput);
        continue;
        i -= 10;
        this.address += i / 15;
        this.line = (i % 15 - 4 + this.line);
        this.positions.add(new DebugInfoDecoder.PositionEntry(this.address, this.line));
      }
    }
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
  
  private int readStringIndex(ByteInput paramByteInput)
  {
    return Leb128.readUnsignedLeb128(paramByteInput) - 1;
  }
  
  public static void validateEncode(byte[] paramArrayOfByte, DexFile paramDexFile, CstMethodRef paramCstMethodRef, DalvCode paramDalvCode, boolean paramBoolean)
  {
    PositionList localPositionList = paramDalvCode.getPositions();
    LocalList localLocalList = paramDalvCode.getLocals();
    paramDalvCode = paramDalvCode.getInsns();
    int i = paramDalvCode.codeSize();
    int j = paramDalvCode.getRegistersSize();
    try
    {
      validateEncode0(paramArrayOfByte, i, j, paramBoolean, paramCstMethodRef, paramDexFile, localPositionList, localLocalList);
      return;
    }
    catch (RuntimeException paramArrayOfByte)
    {
      System.err.println("instructions:");
      paramDalvCode.debugPrint(System.err, "  ", true);
      System.err.println("local list:");
      localLocalList.debugPrint(System.err, "  ");
      throw ExceptionWithContext.withContext(paramArrayOfByte, "while processing " + paramCstMethodRef.toHuman());
    }
  }
  
  private static void validateEncode0(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean, CstMethodRef paramCstMethodRef, DexFile paramDexFile, PositionList paramPositionList, LocalList paramLocalList)
  {
    paramArrayOfByte = new DebugInfoDecoder(paramArrayOfByte, paramInt1, paramInt2, paramBoolean, paramCstMethodRef, paramDexFile);
    paramArrayOfByte.decode();
    paramCstMethodRef = paramArrayOfByte.getPositionList();
    if (paramCstMethodRef.size() != paramPositionList.size()) {
      throw new RuntimeException("Decoded positions table not same size was " + paramCstMethodRef.size() + " expected " + paramPositionList.size());
    }
    paramCstMethodRef = paramCstMethodRef.iterator();
    int i;
    if (paramCstMethodRef.hasNext())
    {
      paramDexFile = (DebugInfoDecoder.PositionEntry)paramCstMethodRef.next();
      i = 0;
      paramInt1 = paramPositionList.size() - 1;
      for (;;)
      {
        paramInt2 = i;
        if (paramInt1 >= 0)
        {
          PositionList.Entry localEntry = paramPositionList.get(paramInt1);
          if ((paramDexFile.line == localEntry.getPosition().getLine()) && (paramDexFile.address == localEntry.getAddress())) {
            paramInt2 = 1;
          }
        }
        else
        {
          if (paramInt2 != 0) {
            break;
          }
          throw new RuntimeException("Could not match position entry: " + paramDexFile.address + ", " + paramDexFile.line);
        }
        paramInt1 -= 1;
      }
    }
    paramCstMethodRef = paramArrayOfByte.getLocals();
    int j = paramArrayOfByte.thisStringIdx;
    paramInt1 = paramCstMethodRef.size();
    int k = paramArrayOfByte.getParamBase();
    paramInt2 = 0;
    if (paramInt2 < paramInt1)
    {
      paramArrayOfByte = (DebugInfoDecoder.LocalEntry)paramCstMethodRef.get(paramInt2);
      i = paramArrayOfByte.nameIndex;
      if ((i >= 0) && (i != j)) {
        break label753;
      }
      i = paramInt2 + 1;
      label302:
      if (i >= paramInt1) {
        break label753;
      }
      paramDexFile = (DebugInfoDecoder.LocalEntry)paramCstMethodRef.get(i);
      if (paramDexFile.address == 0) {}
    }
    label440:
    label461:
    label609:
    label753:
    for (;;)
    {
      paramInt2 += 1;
      break;
      if ((paramArrayOfByte.reg == paramDexFile.reg) && (paramDexFile.isStart))
      {
        paramCstMethodRef.set(paramInt2, paramDexFile);
        paramCstMethodRef.remove(i);
        paramInt1 -= 1;
      }
      else
      {
        i += 1;
        break label302;
        int m = paramLocalList.size();
        i = 0;
        paramInt2 = 0;
        for (;;)
        {
          if (i < m)
          {
            paramArrayOfByte = paramLocalList.get(i);
            if (paramArrayOfByte.getDisposition() == LocalList.Disposition.END_REPLACED)
            {
              i += 1;
            }
            else
            {
              paramDexFile = (DebugInfoDecoder.LocalEntry)paramCstMethodRef.get(paramInt2);
              if (paramDexFile.nameIndex >= 0)
              {
                j = paramDexFile.address;
                if (paramDexFile.reg == paramArrayOfByte.getRegister()) {
                  break label609;
                }
                System.err.println("local register mismatch at orig " + i + " / decoded " + paramInt2);
                paramInt1 = 1;
              }
            }
          }
        }
        for (;;)
        {
          if (paramInt1 != 0)
          {
            System.err.println("decoded locals:");
            paramArrayOfByte = paramCstMethodRef.iterator();
            for (;;)
            {
              if (paramArrayOfByte.hasNext())
              {
                paramCstMethodRef = (DebugInfoDecoder.LocalEntry)paramArrayOfByte.next();
                System.err.println("  " + paramCstMethodRef);
                continue;
                j = paramInt2 + 1;
                paramInt2 = j;
                if (j < paramInt1) {
                  break label440;
                }
                paramInt2 = j;
                break label461;
                if (paramDexFile.isStart != paramArrayOfByte.isStart())
                {
                  System.err.println("local start/end mismatch at orig " + i + " / decoded " + paramInt2);
                  paramInt1 = 1;
                  break label519;
                }
                if ((j != paramArrayOfByte.getAddress()) && ((j != 0) || (paramDexFile.reg < k)))
                {
                  System.err.println("local address mismatch at orig " + i + " / decoded " + paramInt2);
                  paramInt1 = 1;
                  break label519;
                }
                paramInt2 += 1;
                break;
              }
            }
            throw new RuntimeException("local table problem");
          }
          return;
          paramInt1 = 0;
        }
      }
    }
  }
  
  public void decode()
  {
    try
    {
      decode0();
      return;
    }
    catch (Exception localException)
    {
      throw ExceptionWithContext.withContext(localException, "...while decoding debug info");
    }
  }
  
  public List<DebugInfoDecoder.LocalEntry> getLocals()
  {
    return this.locals;
  }
  
  public List<DebugInfoDecoder.PositionEntry> getPositionList()
  {
    return this.positions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.DebugInfoDecoder
 * JD-Core Version:    0.7.0.1
 */