package com.tencent.map.sdk.a;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

final class ix$1
  implements qf
{
  ix$1(ix paramix) {}
  
  public final void a(String paramString)
  {
    if (ix.a(this.a) != null)
    {
      paramString = (qg.a)ix.a(this.a).a.get(paramString);
      if (paramString == null) {
        break label58;
      }
    }
    label58:
    for (paramString = paramString.a;; paramString = null)
    {
      if (paramString != null) {
        ix.b(this.a).remove(paramString);
      }
      return;
    }
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte) {}
  
  public final void b(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ix.1
 * JD-Core Version:    0.7.0.1
 */