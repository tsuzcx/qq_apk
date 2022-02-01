package com.huawei.hiar;

import com.huawei.hiar.exceptions.ARFatalException;

 enum ARImageMetadata$a$a
{
  final int h;
  
  private ARImageMetadata$a$a(int paramInt)
  {
    this.h = paramInt;
  }
  
  static a a(int paramInt)
  {
    a[] arrayOfa = values();
    int k = arrayOfa.length;
    int j = 0;
    a locala;
    while (j < k)
    {
      locala = arrayOfa[j];
      if (locala.h == paramInt) {
        break label62;
      }
      j += 1;
    }
    throw new ARFatalException("Unexpected value for native DataType, value=" + paramInt);
    label62:
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARImageMetadata.a.a
 * JD-Core Version:    0.7.0.1
 */