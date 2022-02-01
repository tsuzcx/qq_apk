package com.tencent.map.sdk.a;

import java.math.BigDecimal;

final class fc$6
  extends ee<BigDecimal>
{
  private static BigDecimal b(fe paramfe)
  {
    if (paramfe.f() == ff.i)
    {
      paramfe.k();
      return null;
    }
    try
    {
      paramfe = new BigDecimal(paramfe.i());
      return paramfe;
    }
    catch (NumberFormatException paramfe)
    {
      throw new eb(paramfe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.6
 * JD-Core Version:    0.7.0.1
 */