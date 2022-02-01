package com.tencent.luggage.wxa.kv;

import com.tencent.luggage.wxa.qz.o;
import java.util.Locale;

public class b
{
  public static double a(int paramInt, double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return -1.0D;
    }
    double d = paramInt;
    Double.isNaN(d);
    paramDouble = paramDouble * 1.0D / d;
    if (paramDouble < 1.0D) {
      return Math.pow(paramDouble, 10.0D);
    }
    return Math.pow(paramDouble, 9.9476D) * 0.92093D + 0.54992D;
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      int i = paramInt;
      if (paramArrayOfByte.length < paramInt)
      {
        o.c("MicroMsg.JsApiBeaconUtil", "data length is shorter then print command length");
        i = paramArrayOfByte.length;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt = 0;
      while (paramInt < i)
      {
        int j = paramArrayOfByte[paramInt] & 0xFF;
        if (j < 16) {
          localStringBuilder.append("0");
        }
        localStringBuilder.append(Integer.toHexString(j));
        paramInt += 1;
      }
      return localStringBuilder.toString().toUpperCase(Locale.US);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kv.b
 * JD-Core Version:    0.7.0.1
 */