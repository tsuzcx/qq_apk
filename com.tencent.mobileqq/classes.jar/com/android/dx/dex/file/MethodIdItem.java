package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstBaseMethodRef;

public final class MethodIdItem
  extends MemberIdItem
{
  public MethodIdItem(CstBaseMethodRef paramCstBaseMethodRef)
  {
    super(paramCstBaseMethodRef);
  }
  
  public void addContents(DexFile paramDexFile)
  {
    super.addContents(paramDexFile);
    paramDexFile.getProtoIds().intern(getMethodRef().getPrototype());
  }
  
  public CstBaseMethodRef getMethodRef()
  {
    return (CstBaseMethodRef)getRef();
  }
  
  protected int getTypoidIdx(DexFile paramDexFile)
  {
    return paramDexFile.getProtoIds().indexOf(getMethodRef().getPrototype());
  }
  
  protected String getTypoidName()
  {
    return "proto_idx";
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_METHOD_ID_ITEM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.MethodIdItem
 * JD-Core Version:    0.7.0.1
 */