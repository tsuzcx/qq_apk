package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;

public final class TypeIdItem
  extends IdItem
{
  public TypeIdItem(CstType paramCstType)
  {
    super(paramCstType);
  }
  
  public void addContents(DexFile paramDexFile)
  {
    paramDexFile.getStringIds().intern(getDefiningClass().getDescriptor());
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_TYPE_ID_ITEM;
  }
  
  public int writeSize()
  {
    return 4;
  }
  
  public void writeTo(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    CstString localCstString = getDefiningClass().getDescriptor();
    int i = paramDexFile.getStringIds().indexOf(localCstString);
    if (paramAnnotatedOutput.annotates())
    {
      paramAnnotatedOutput.annotate(0, indexString() + ' ' + localCstString.toHuman());
      paramAnnotatedOutput.annotate(4, "  descriptor_idx: " + Hex.u4(i));
    }
    paramAnnotatedOutput.writeInt(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.TypeIdItem
 * JD-Core Version:    0.7.0.1
 */