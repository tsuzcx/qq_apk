package com.qwallet.temp.impl;

import com.qq.wx.voice.embed.recognizer.GrammarNative;
import com.qwallet.temp.IGrammarNativeTemp;

public class GrammarNativeTemp
  implements IGrammarNativeTemp
{
  public float a()
  {
    return GrammarNative.getResultCfd();
  }
  
  public int a()
  {
    return GrammarNative.begin();
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    return GrammarNative.update(paramArrayOfByte);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    return GrammarNative.recognize(paramArrayOfByte, paramInt);
  }
  
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return GrammarNative.init(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
  }
  
  public int b()
  {
    return GrammarNative.end();
  }
  
  public int c()
  {
    return GrammarNative.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.GrammarNativeTemp
 * JD-Core Version:    0.7.0.1
 */