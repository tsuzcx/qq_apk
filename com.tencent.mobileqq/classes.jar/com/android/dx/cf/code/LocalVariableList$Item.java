package com.android.dx.cf.code;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.Type;

public class LocalVariableList$Item
{
  private final CstString descriptor;
  private final int index;
  private final int length;
  private final CstString name;
  private final CstString signature;
  private final int startPc;
  
  public LocalVariableList$Item(int paramInt1, int paramInt2, CstString paramCstString1, CstString paramCstString2, CstString paramCstString3, int paramInt3)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("startPc < 0");
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("length < 0");
    }
    if (paramCstString1 == null) {
      throw new NullPointerException("name == null");
    }
    if ((paramCstString2 == null) && (paramCstString3 == null)) {
      throw new NullPointerException("(descriptor == null) && (signature == null)");
    }
    if (paramInt3 < 0) {
      throw new IllegalArgumentException("index < 0");
    }
    this.startPc = paramInt1;
    this.length = paramInt2;
    this.name = paramCstString1;
    this.descriptor = paramCstString2;
    this.signature = paramCstString3;
    this.index = paramInt3;
  }
  
  private CstString getSignature()
  {
    return this.signature;
  }
  
  public CstString getDescriptor()
  {
    return this.descriptor;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public int getLength()
  {
    return this.length;
  }
  
  public LocalItem getLocalItem()
  {
    return LocalItem.make(this.name, this.signature);
  }
  
  public int getStartPc()
  {
    return this.startPc;
  }
  
  public Type getType()
  {
    return Type.intern(this.descriptor.getString());
  }
  
  public boolean matchesAllButType(Item paramItem)
  {
    return (this.startPc == paramItem.startPc) && (this.length == paramItem.length) && (this.index == paramItem.index) && (this.name.equals(paramItem.name));
  }
  
  public boolean matchesPcAndIndex(int paramInt1, int paramInt2)
  {
    return (paramInt2 == this.index) && (paramInt1 >= this.startPc) && (paramInt1 < this.startPc + this.length);
  }
  
  public Item withSignature(CstString paramCstString)
  {
    return new Item(this.startPc, this.length, this.name, this.descriptor, paramCstString, this.index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.LocalVariableList.Item
 * JD-Core Version:    0.7.0.1
 */