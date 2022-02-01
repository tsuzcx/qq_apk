package com.tencent.avgame.localvoicerecog.engine;

import com.tencent.avgame.localvoicerecog.wx.GrammarNative;
import java.io.UnsupportedEncodingException;

public class WXVoiceRecogEngine
  implements IVoiceRecogEngine
{
  private static volatile WXVoiceRecogEngine a;
  
  public static WXVoiceRecogEngine a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WXVoiceRecogEngine();
        }
      }
      finally {}
    }
    return a;
  }
  
  public int a(String paramString)
  {
    try
    {
      int i = GrammarNative.update(paramString.getBytes("GBK"));
      return i;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int a(String paramString1, String paramString2)
  {
    return GrammarNative.init(paramString1.getBytes(), paramString2.getBytes(), null);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    return GrammarNative.recognize(paramArrayOfByte, paramInt);
  }
  
  public void a(float paramFloat) {}
  
  public int b()
  {
    return GrammarNative.begin();
  }
  
  public int c()
  {
    return GrammarNative.end();
  }
  
  public int e()
  {
    return GrammarNative.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.localvoicerecog.engine.WXVoiceRecogEngine
 * JD-Core Version:    0.7.0.1
 */