package com.android.dx.rop.cst;

public abstract class CstLiteralBits
  extends TypedConstant
{
  public boolean fitsIn16Bits()
  {
    if (!fitsInInt()) {}
    int i;
    do
    {
      return false;
      i = getIntBits();
    } while ((short)i != i);
    return true;
  }
  
  public boolean fitsIn8Bits()
  {
    if (!fitsInInt()) {}
    int i;
    do
    {
      return false;
      i = getIntBits();
    } while ((byte)i != i);
    return true;
  }
  
  public abstract boolean fitsInInt();
  
  public abstract int getIntBits();
  
  public abstract long getLongBits();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstLiteralBits
 * JD-Core Version:    0.7.0.1
 */