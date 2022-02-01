package com.android.dx.io.instructions;

import java.util.HashMap;

public final class AddressMap
{
  private final HashMap<Integer, Integer> map = new HashMap();
  
  public int get(int paramInt)
  {
    Integer localInteger = (Integer)this.map.get(Integer.valueOf(paramInt));
    if (localInteger == null) {
      return -1;
    }
    return localInteger.intValue();
  }
  
  public void put(int paramInt1, int paramInt2)
  {
    this.map.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.AddressMap
 * JD-Core Version:    0.7.0.1
 */