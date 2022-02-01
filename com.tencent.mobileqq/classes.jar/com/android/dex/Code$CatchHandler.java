package com.android.dex;

public class Code$CatchHandler
{
  final int[] addresses;
  final int catchAllAddress;
  final int offset;
  final int[] typeIndexes;
  
  public Code$CatchHandler(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    this.typeIndexes = paramArrayOfInt1;
    this.addresses = paramArrayOfInt2;
    this.catchAllAddress = paramInt1;
    this.offset = paramInt2;
  }
  
  public int[] getAddresses()
  {
    return this.addresses;
  }
  
  public int getCatchAllAddress()
  {
    return this.catchAllAddress;
  }
  
  public int getOffset()
  {
    return this.offset;
  }
  
  public int[] getTypeIndexes()
  {
    return this.typeIndexes;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Code.CatchHandler
 * JD-Core Version:    0.7.0.1
 */