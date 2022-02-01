package com.android.dx.dex.file;

import com.android.dex.Leb128;
import com.android.dx.dex.code.DalvCode;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.io.PrintWriter;

public final class EncodedMethod
  extends EncodedMember
  implements Comparable<EncodedMethod>
{
  private final CodeItem code;
  private final CstMethodRef method;
  
  public EncodedMethod(CstMethodRef paramCstMethodRef, int paramInt, DalvCode paramDalvCode, TypeList paramTypeList)
  {
    super(paramInt);
    if (paramCstMethodRef == null) {
      throw new NullPointerException("method == null");
    }
    this.method = paramCstMethodRef;
    if (paramDalvCode == null)
    {
      this.code = null;
      return;
    }
    if ((paramInt & 0x8) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.code = new CodeItem(paramCstMethodRef, paramDalvCode, bool, paramTypeList);
      return;
    }
  }
  
  public void addContents(DexFile paramDexFile)
  {
    MethodIdsSection localMethodIdsSection = paramDexFile.getMethodIds();
    paramDexFile = paramDexFile.getWordData();
    localMethodIdsSection.intern(this.method);
    if (this.code != null) {
      paramDexFile.add(this.code);
    }
  }
  
  public int compareTo(EncodedMethod paramEncodedMethod)
  {
    return this.method.compareTo(paramEncodedMethod.method);
  }
  
  public void debugPrint(PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (this.code == null)
    {
      paramPrintWriter.println(getRef().toHuman() + ": abstract or native");
      return;
    }
    this.code.debugPrint(paramPrintWriter, "  ", paramBoolean);
  }
  
  public int encode(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput, int paramInt1, int paramInt2)
  {
    int j = paramDexFile.getMethodIds().indexOf(this.method);
    int k = j - paramInt1;
    int m = getAccessFlags();
    int n = OffsettedItem.getAbsoluteOffsetOr0(this.code);
    if (n != 0)
    {
      paramInt1 = 1;
      if ((m & 0x500) != 0) {
        break label74;
      }
    }
    label74:
    for (int i = 1;; i = 0)
    {
      if (paramInt1 == i) {
        break label80;
      }
      throw new UnsupportedOperationException("code vs. access_flags mismatch");
      paramInt1 = 0;
      break;
    }
    label80:
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(0, String.format("  [%x] %s", new Object[] { Integer.valueOf(paramInt2), this.method.toHuman() }));
      paramAnnotatedOutput.annotate(Leb128.unsignedLeb128Size(k), "    method_idx:   " + Hex.u4(j));
      paramAnnotatedOutput.annotate(Leb128.unsignedLeb128Size(m), "    access_flags: " + AccessFlags.methodString(m));
      paramAnnotatedOutput.annotate(Leb128.unsignedLeb128Size(n), "    code_off:     " + Hex.u4(n));
    }
    paramAnnotatedOutput.writeUleb128(k);
    paramAnnotatedOutput.writeUleb128(m);
    paramAnnotatedOutput.writeUleb128(n);
    return j;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EncodedMethod)) {}
    while (compareTo((EncodedMethod)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final CstString getName()
  {
    return this.method.getNat().getName();
  }
  
  public final CstMethodRef getRef()
  {
    return this.method;
  }
  
  public final String toHuman()
  {
    return this.method.toHuman();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append(getClass().getName());
    localStringBuffer.append('{');
    localStringBuffer.append(Hex.u2(getAccessFlags()));
    localStringBuffer.append(' ');
    localStringBuffer.append(this.method);
    if (this.code != null)
    {
      localStringBuffer.append(' ');
      localStringBuffer.append(this.code);
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.EncodedMethod
 * JD-Core Version:    0.7.0.1
 */