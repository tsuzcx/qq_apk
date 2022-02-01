package com.android.dx.dex.file;

import com.android.dex.Leb128;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.io.PrintWriter;

public final class EncodedField
  extends EncodedMember
  implements Comparable<EncodedField>
{
  private final CstFieldRef field;
  
  public EncodedField(CstFieldRef paramCstFieldRef, int paramInt)
  {
    super(paramInt);
    if (paramCstFieldRef == null) {
      throw new NullPointerException("field == null");
    }
    this.field = paramCstFieldRef;
  }
  
  public void addContents(DexFile paramDexFile)
  {
    paramDexFile.getFieldIds().intern(this.field);
  }
  
  public int compareTo(EncodedField paramEncodedField)
  {
    return this.field.compareTo(paramEncodedField.field);
  }
  
  public void debugPrint(PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    paramPrintWriter.println(toString());
  }
  
  public int encode(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput, int paramInt1, int paramInt2)
  {
    int i = paramDexFile.getFieldIds().indexOf(this.field);
    paramInt1 = i - paramInt1;
    int j = getAccessFlags();
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(0, String.format("  [%x] %s", new Object[] { Integer.valueOf(paramInt2), this.field.toHuman() }));
      paramAnnotatedOutput.annotate(Leb128.unsignedLeb128Size(paramInt1), "    field_idx:    " + Hex.u4(i));
      paramAnnotatedOutput.annotate(Leb128.unsignedLeb128Size(j), "    access_flags: " + AccessFlags.fieldString(j));
    }
    paramAnnotatedOutput.writeUleb128(paramInt1);
    paramAnnotatedOutput.writeUleb128(j);
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EncodedField)) {}
    while (compareTo((EncodedField)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public CstString getName()
  {
    return this.field.getNat().getName();
  }
  
  public CstFieldRef getRef()
  {
    return this.field;
  }
  
  public int hashCode()
  {
    return this.field.hashCode();
  }
  
  public String toHuman()
  {
    return this.field.toHuman();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append(getClass().getName());
    localStringBuffer.append('{');
    localStringBuffer.append(Hex.u2(getAccessFlags()));
    localStringBuffer.append(' ');
    localStringBuffer.append(this.field);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.EncodedField
 * JD-Core Version:    0.7.0.1
 */