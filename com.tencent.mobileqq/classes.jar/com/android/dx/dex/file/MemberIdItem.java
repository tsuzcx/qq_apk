package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstMemberRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;

public abstract class MemberIdItem
  extends IdItem
{
  private final CstMemberRef cst;
  
  public MemberIdItem(CstMemberRef paramCstMemberRef)
  {
    super(paramCstMemberRef.getDefiningClass());
    this.cst = paramCstMemberRef;
  }
  
  public void addContents(DexFile paramDexFile)
  {
    super.addContents(paramDexFile);
    paramDexFile.getStringIds().intern(getRef().getNat().getName());
  }
  
  public final CstMemberRef getRef()
  {
    return this.cst;
  }
  
  protected abstract int getTypoidIdx(DexFile paramDexFile);
  
  protected abstract String getTypoidName();
  
  public int writeSize()
  {
    return 8;
  }
  
  public final void writeTo(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    TypeIdsSection localTypeIdsSection = paramDexFile.getTypeIds();
    StringIdsSection localStringIdsSection = paramDexFile.getStringIds();
    CstNat localCstNat = this.cst.getNat();
    int i = localTypeIdsSection.indexOf(getDefiningClass());
    int j = localStringIdsSection.indexOf(localCstNat.getName());
    int k = getTypoidIdx(paramDexFile);
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(0, indexString() + ' ' + this.cst.toHuman());
      paramAnnotatedOutput.annotate(2, "  class_idx: " + Hex.u2(i));
      paramAnnotatedOutput.annotate(2, String.format("  %-10s %s", new Object[] { getTypoidName() + ':', Hex.u2(k) }));
      paramAnnotatedOutput.annotate(4, "  name_idx:  " + Hex.u4(j));
    }
    paramAnnotatedOutput.writeShort(i);
    paramAnnotatedOutput.writeShort(k);
    paramAnnotatedOutput.writeInt(j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.MemberIdItem
 * JD-Core Version:    0.7.0.1
 */