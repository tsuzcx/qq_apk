package com.huawei.hiar;

import com.huawei.hiar.exceptions.ARFatalException;

 enum i
{
  final int d;
  
  private i(int paramInt)
  {
    this.d = paramInt;
  }
  
  static i a(int paramInt)
  {
    i[] arrayOfi = values();
    int j = arrayOfi.length;
    int i = 0;
    i locali;
    while (i < j)
    {
      locali = arrayOfi[i];
      if (locali.d == paramInt) {
        break label62;
      }
      i += 1;
    }
    throw new ARFatalException("Unexpected value for ConfigAccessRequestEnum, value=" + paramInt);
    label62:
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.i
 * JD-Core Version:    0.7.0.1
 */