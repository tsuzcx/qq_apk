package com.tencent.map.sdk.a;

import java.io.EOFException;
import java.io.IOException;

public final class ep
{
  public static dt a(fe paramfe)
  {
    try
    {
      paramfe.f();
      int i = 0;
      try
      {
        paramfe = (dt)fc.P.a(paramfe);
        return paramfe;
      }
      catch (EOFException paramfe) {}
      if (i == 0) {
        break label65;
      }
    }
    catch (NumberFormatException paramfe)
    {
      throw new eb(paramfe);
    }
    catch (IOException paramfe)
    {
      throw new du(paramfe);
    }
    catch (fh paramfe)
    {
      throw new eb(paramfe);
    }
    catch (EOFException paramfe)
    {
      i = 1;
    }
    return dv.a;
    label65:
    throw new eb(paramfe);
  }
  
  public static void a(dt paramdt, fg paramfg)
  {
    fc.P.a(paramfg, paramdt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ep
 * JD-Core Version:    0.7.0.1
 */