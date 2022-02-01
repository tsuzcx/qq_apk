package com.tencent.aekit.api.standard;

import com.tencent.ttpic.util.Coffee;
import com.tencent.ttpic.util.DecryptListener;

final class AEModule$1
  implements DecryptListener
{
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    return Coffee.drink(paramArrayOfByte, Coffee.getDefaultSign());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.AEModule.1
 * JD-Core Version:    0.7.0.1
 */