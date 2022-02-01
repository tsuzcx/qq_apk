package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstFieldRef;

public final class FieldIdItem
  extends MemberIdItem
{
  public FieldIdItem(CstFieldRef paramCstFieldRef)
  {
    super(paramCstFieldRef);
  }
  
  public void addContents(DexFile paramDexFile)
  {
    super.addContents(paramDexFile);
    paramDexFile.getTypeIds().intern(getFieldRef().getType());
  }
  
  public CstFieldRef getFieldRef()
  {
    return (CstFieldRef)getRef();
  }
  
  protected int getTypoidIdx(DexFile paramDexFile)
  {
    return paramDexFile.getTypeIds().indexOf(getFieldRef().getType());
  }
  
  protected String getTypoidName()
  {
    return "type_idx";
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_FIELD_ID_ITEM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.FieldIdItem
 * JD-Core Version:    0.7.0.1
 */