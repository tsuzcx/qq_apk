package com.android.dx.io.instructions;

public abstract class BaseCodeCursor
  implements CodeCursor
{
  private final AddressMap baseAddressMap = new AddressMap();
  private int cursor = 0;
  
  protected final void advance(int paramInt)
  {
    this.cursor += paramInt;
  }
  
  public final int baseAddressForCursor()
  {
    int i = this.baseAddressMap.get(this.cursor);
    if (i >= 0) {
      return i;
    }
    return this.cursor;
  }
  
  public final int cursor()
  {
    return this.cursor;
  }
  
  public final void setBaseAddress(int paramInt1, int paramInt2)
  {
    this.baseAddressMap.put(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.BaseCodeCursor
 * JD-Core Version:    0.7.0.1
 */