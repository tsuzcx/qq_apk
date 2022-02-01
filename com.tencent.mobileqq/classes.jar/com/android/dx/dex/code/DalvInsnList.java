package com.android.dx.dex.code;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstBaseMethodRef;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.FixedSizeList;
import com.android.dx.util.IndentingWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public final class DalvInsnList
  extends FixedSizeList
{
  private final int regCount;
  
  public DalvInsnList(int paramInt1, int paramInt2)
  {
    super(paramInt1);
    this.regCount = paramInt2;
  }
  
  public static DalvInsnList makeImmutable(ArrayList<DalvInsn> paramArrayList, int paramInt)
  {
    int i = paramArrayList.size();
    DalvInsnList localDalvInsnList = new DalvInsnList(i, paramInt);
    paramInt = 0;
    while (paramInt < i)
    {
      localDalvInsnList.set(paramInt, (DalvInsn)paramArrayList.get(paramInt));
      paramInt += 1;
    }
    localDalvInsnList.setImmutable();
    return localDalvInsnList;
  }
  
  public int codeSize()
  {
    int i = size();
    if (i == 0) {
      return 0;
    }
    return get(i - 1).getNextAddress();
  }
  
  public void debugPrint(OutputStream paramOutputStream, String paramString, boolean paramBoolean)
  {
    paramOutputStream = new OutputStreamWriter(paramOutputStream);
    debugPrint(paramOutputStream, paramString, paramBoolean);
    try
    {
      paramOutputStream.flush();
      return;
    }
    catch (IOException paramOutputStream)
    {
      throw new RuntimeException(paramOutputStream);
    }
  }
  
  public void debugPrint(Writer paramWriter, String paramString, boolean paramBoolean)
  {
    paramString = new IndentingWriter(paramWriter, 0, paramString);
    int j = size();
    int i = 0;
    if (i < j) {}
    for (;;)
    {
      try
      {
        paramWriter = (DalvInsn)get0(i);
        if ((paramWriter.codeSize() == 0) && (!paramBoolean)) {
          break label93;
        }
        paramWriter = paramWriter.listingString("", 0, paramBoolean);
        if (paramWriter == null) {
          break label84;
        }
        paramString.write(paramWriter);
      }
      catch (IOException paramWriter)
      {
        throw new RuntimeException(paramWriter);
      }
      paramString.flush();
      return;
      label84:
      i += 1;
      break;
      label93:
      paramWriter = null;
    }
  }
  
  public DalvInsn get(int paramInt)
  {
    return (DalvInsn)get0(paramInt);
  }
  
  public int getOutsSize()
  {
    int n = size();
    int k = 0;
    int i = 0;
    if (k < n)
    {
      DalvInsn localDalvInsn = (DalvInsn)get0(k);
      if (!(localDalvInsn instanceof CstInsn)) {}
      Constant localConstant;
      for (int j = i;; j = i)
      {
        k += 1;
        i = j;
        break;
        localConstant = ((CstInsn)localDalvInsn).getConstant();
        if ((localConstant instanceof CstBaseMethodRef)) {
          break label68;
        }
      }
      label68:
      if (localDalvInsn.getOpcode().getFamily() == 113) {}
      for (boolean bool = true;; bool = false)
      {
        int m = ((CstBaseMethodRef)localConstant).getParameterWordCount(bool);
        j = m;
        if (m > i) {
          break;
        }
        j = i;
        break;
      }
    }
    return i;
  }
  
  public int getRegistersSize()
  {
    return this.regCount;
  }
  
  public void set(int paramInt, DalvInsn paramDalvInsn)
  {
    set0(paramInt, paramDalvInsn);
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput)
  {
    int k = 0;
    int m = paramAnnotatedOutput.getCursor();
    int n = size();
    int j = k;
    Object localObject;
    if (paramAnnotatedOutput.annotates())
    {
      boolean bool = paramAnnotatedOutput.isVerbose();
      i = 0;
      j = k;
      if (i < n)
      {
        localObject = (DalvInsn)get0(i);
        j = ((DalvInsn)localObject).codeSize() * 2;
        if ((j != 0) || (bool))
        {
          localObject = ((DalvInsn)localObject).listingString("  ", paramAnnotatedOutput.getAnnotationWidth(), true);
          label91:
          if (localObject == null) {
            break label118;
          }
          paramAnnotatedOutput.annotate(j, (String)localObject);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = null;
          break label91;
          label118:
          if (j != 0) {
            paramAnnotatedOutput.annotate(j, "");
          }
        }
      }
    }
    while (j < n)
    {
      localObject = (DalvInsn)get0(j);
      try
      {
        ((DalvInsn)localObject).writeTo(paramAnnotatedOutput);
        j += 1;
      }
      catch (RuntimeException paramAnnotatedOutput)
      {
        throw ExceptionWithContext.withContext(paramAnnotatedOutput, "...while writing " + localObject);
      }
    }
    int i = (paramAnnotatedOutput.getCursor() - m) / 2;
    if (i != codeSize()) {
      throw new RuntimeException("write length mismatch; expected " + codeSize() + " but actually wrote " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.DalvInsnList
 * JD-Core Version:    0.7.0.1
 */