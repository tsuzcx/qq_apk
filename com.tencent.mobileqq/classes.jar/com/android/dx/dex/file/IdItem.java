package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstType;

public abstract class IdItem
  extends IndexedItem
{
  private final CstType type;
  
  public IdItem(CstType paramCstType)
  {
    if (paramCstType == null) {
      throw new NullPointerException("type == null");
    }
    this.type = paramCstType;
  }
  
  public void addContents(DexFile paramDexFile)
  {
    paramDexFile.getTypeIds().intern(this.type);
  }
  
  public final CstType getDefiningClass()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.IdItem
 * JD-Core Version:    0.7.0.1
 */