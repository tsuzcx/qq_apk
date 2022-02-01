package com.android.dx.dex.file;

import com.android.dx.dex.code.CatchHandlerList;
import com.android.dx.dex.code.CatchHandlerList.Entry;
import com.android.dx.dex.code.CatchTable;
import com.android.dx.dex.code.CatchTable.Entry;
import com.android.dx.dex.code.DalvCode;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import com.android.dx.util.Hex;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class CatchStructs
{
  private static final int TRY_ITEM_WRITE_SIZE = 8;
  private final DalvCode code;
  private int encodedHandlerHeaderSize;
  private byte[] encodedHandlers;
  private TreeMap<CatchHandlerList, Integer> handlerOffsets;
  private CatchTable table;
  
  public CatchStructs(DalvCode paramDalvCode)
  {
    this.code = paramDalvCode;
    this.table = null;
    this.encodedHandlers = null;
    this.encodedHandlerHeaderSize = 0;
    this.handlerOffsets = null;
  }
  
  private static void annotateAndConsumeHandlers(CatchHandlerList paramCatchHandlerList, int paramInt1, int paramInt2, String paramString, PrintWriter paramPrintWriter, AnnotatedOutput paramAnnotatedOutput)
  {
    paramCatchHandlerList = paramCatchHandlerList.toHuman(paramString, Hex.u2(paramInt1) + ": ");
    if (paramPrintWriter != null) {
      paramPrintWriter.println(paramCatchHandlerList);
    }
    paramAnnotatedOutput.annotate(paramInt2, paramCatchHandlerList);
  }
  
  private void annotateEntries(String paramString, PrintWriter paramPrintWriter, AnnotatedOutput paramAnnotatedOutput)
  {
    int n = 0;
    finishProcessingIfNecessary();
    int j;
    label23:
    int k;
    label31:
    String str;
    label92:
    int m;
    label95:
    Object localObject1;
    if (paramAnnotatedOutput != null)
    {
      i = 1;
      if (i == 0) {
        break label220;
      }
      j = 6;
      if (i == 0) {
        break label226;
      }
      k = 2;
      int i1 = this.table.size();
      str = paramString + "  ";
      if (i == 0) {
        break label232;
      }
      paramAnnotatedOutput.annotate(0, paramString + "tries:");
      m = 0;
      if (m >= i1) {
        break label273;
      }
      localObject2 = this.table.get(m);
      localObject1 = ((CatchTable.Entry)localObject2).getHandlers();
      localObject2 = str + "try " + Hex.u2or4(((CatchTable.Entry)localObject2).getStart()) + ".." + Hex.u2or4(((CatchTable.Entry)localObject2).getEnd());
      localObject1 = ((CatchHandlerList)localObject1).toHuman(str, "");
      if (i == 0) {
        break label258;
      }
      paramAnnotatedOutput.annotate(j, (String)localObject2);
      paramAnnotatedOutput.annotate(k, (String)localObject1);
    }
    for (;;)
    {
      m += 1;
      break label95;
      i = 0;
      break;
      label220:
      j = 0;
      break label23;
      label226:
      k = 0;
      break label31;
      label232:
      paramPrintWriter.println(paramString + "tries:");
      break label92;
      label258:
      paramPrintWriter.println((String)localObject2);
      paramPrintWriter.println((String)localObject1);
    }
    label273:
    if (i == 0) {
      return;
    }
    paramAnnotatedOutput.annotate(0, paramString + "handlers:");
    paramAnnotatedOutput.annotate(this.encodedHandlerHeaderSize, str + "size: " + Hex.u2(this.handlerOffsets.size()));
    paramString = null;
    Object localObject2 = this.handlerOffsets.entrySet().iterator();
    for (int i = n; ((Iterator)localObject2).hasNext(); i = j)
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (CatchHandlerList)localEntry.getKey();
      j = ((Integer)localEntry.getValue()).intValue();
      if (paramString != null) {
        annotateAndConsumeHandlers(paramString, i, j - i, str, paramPrintWriter, paramAnnotatedOutput);
      }
      paramString = (String)localObject1;
    }
    annotateAndConsumeHandlers(paramString, i, this.encodedHandlers.length - i, str, paramPrintWriter, paramAnnotatedOutput);
  }
  
  private void finishProcessingIfNecessary()
  {
    if (this.table == null) {
      this.table = this.code.getCatches();
    }
  }
  
  public void debugPrint(PrintWriter paramPrintWriter, String paramString)
  {
    annotateEntries(paramString, paramPrintWriter, null);
  }
  
  public void encode(DexFile paramDexFile)
  {
    finishProcessingIfNecessary();
    paramDexFile = paramDexFile.getTypeIds();
    int j = this.table.size();
    this.handlerOffsets = new TreeMap();
    int i = 0;
    while (i < j)
    {
      this.handlerOffsets.put(this.table.get(i).getHandlers(), null);
      i += 1;
    }
    if (this.handlerOffsets.size() > 65535) {
      throw new UnsupportedOperationException("too many catch handlers");
    }
    ByteArrayAnnotatedOutput localByteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput();
    this.encodedHandlerHeaderSize = localByteArrayAnnotatedOutput.writeUleb128(this.handlerOffsets.size());
    Iterator localIterator = this.handlerOffsets.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      CatchHandlerList localCatchHandlerList = (CatchHandlerList)((Map.Entry)localObject).getKey();
      i = localCatchHandlerList.size();
      boolean bool = localCatchHandlerList.catchesAll();
      ((Map.Entry)localObject).setValue(Integer.valueOf(localByteArrayAnnotatedOutput.getCursor()));
      if (bool)
      {
        localByteArrayAnnotatedOutput.writeSleb128(-(i - 1));
        i -= 1;
      }
      for (;;)
      {
        j = 0;
        while (j < i)
        {
          localObject = localCatchHandlerList.get(j);
          localByteArrayAnnotatedOutput.writeUleb128(paramDexFile.indexOf(((CatchHandlerList.Entry)localObject).getExceptionType()));
          localByteArrayAnnotatedOutput.writeUleb128(((CatchHandlerList.Entry)localObject).getHandler());
          j += 1;
        }
        localByteArrayAnnotatedOutput.writeSleb128(i);
      }
      if (bool) {
        localByteArrayAnnotatedOutput.writeUleb128(localCatchHandlerList.get(i).getHandler());
      }
    }
    this.encodedHandlers = localByteArrayAnnotatedOutput.toByteArray();
  }
  
  public int triesSize()
  {
    finishProcessingIfNecessary();
    return this.table.size();
  }
  
  public int writeSize()
  {
    return triesSize() * 8 + this.encodedHandlers.length;
  }
  
  public void writeTo(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    finishProcessingIfNecessary();
    if (paramAnnotatedOutput.annotates()) {
      annotateEntries("  ", null, paramAnnotatedOutput);
    }
    int j = this.table.size();
    int i = 0;
    while (i < j)
    {
      paramDexFile = this.table.get(i);
      int k = paramDexFile.getStart();
      int m = paramDexFile.getEnd();
      int n = m - k;
      if (n >= 65536) {
        throw new UnsupportedOperationException("bogus exception range: " + Hex.u4(k) + ".." + Hex.u4(m));
      }
      paramAnnotatedOutput.writeInt(k);
      paramAnnotatedOutput.writeShort(n);
      paramAnnotatedOutput.writeShort(((Integer)this.handlerOffsets.get(paramDexFile.getHandlers())).intValue());
      i += 1;
    }
    paramAnnotatedOutput.write(this.encodedHandlers);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.CatchStructs
 * JD-Core Version:    0.7.0.1
 */