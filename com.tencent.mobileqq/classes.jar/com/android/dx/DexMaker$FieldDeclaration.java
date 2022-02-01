package com.android.dx;

import com.android.dx.dex.file.EncodedField;

class DexMaker$FieldDeclaration
{
  private final int accessFlags;
  final FieldId<?, ?> fieldId;
  private final Object staticValue;
  
  DexMaker$FieldDeclaration(FieldId<?, ?> paramFieldId, int paramInt, Object paramObject)
  {
    if (((paramInt & 0x8) == 0) && (paramObject != null)) {
      throw new IllegalArgumentException("instance fields may not have a value");
    }
    this.fieldId = paramFieldId;
    this.accessFlags = paramInt;
    this.staticValue = paramObject;
  }
  
  public boolean isStatic()
  {
    return (this.accessFlags & 0x8) != 0;
  }
  
  EncodedField toEncodedField()
  {
    return new EncodedField(this.fieldId.constant, this.accessFlags);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.DexMaker.FieldDeclaration
 * JD-Core Version:    0.7.0.1
 */