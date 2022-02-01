package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

public final class ReedSolomonEncoder
{
  private final GenericGF a;
  private final List<GenericGFPoly> b;
  
  public ReedSolomonEncoder(GenericGF paramGenericGF)
  {
    if (GenericGF.a.equals(paramGenericGF))
    {
      this.a = paramGenericGF;
      this.b = new ArrayList();
      this.b.add(new GenericGFPoly(paramGenericGF, new int[] { 1 }));
      return;
    }
    throw new IllegalArgumentException("Only QR Code is supported at this time");
  }
  
  private GenericGFPoly a(int paramInt)
  {
    if (paramInt >= this.b.size())
    {
      Object localObject = this.b;
      localObject = (GenericGFPoly)((List)localObject).get(((List)localObject).size() - 1);
      int i = this.b.size();
      while (i <= paramInt)
      {
        GenericGF localGenericGF = this.a;
        localObject = ((GenericGFPoly)localObject).b(new GenericGFPoly(localGenericGF, new int[] { 1, localGenericGF.a(i - 1) }));
        this.b.add(localObject);
        i += 1;
      }
    }
    return (GenericGFPoly)this.b.get(paramInt);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt != 0)
    {
      int i = paramArrayOfInt.length - paramInt;
      if (i > 0)
      {
        Object localObject = a(paramInt);
        int[] arrayOfInt = new int[i];
        System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
        localObject = new GenericGFPoly(this.a, arrayOfInt).a(paramInt, 1).c(localObject)[1].a();
        int j = paramInt - localObject.length;
        paramInt = 0;
        while (paramInt < j)
        {
          paramArrayOfInt[(i + paramInt)] = 0;
          paramInt += 1;
        }
        System.arraycopy(localObject, 0, paramArrayOfInt, i + j, localObject.length);
        return;
      }
      throw new IllegalArgumentException("No data bytes provided");
    }
    paramArrayOfInt = new IllegalArgumentException("No error correction bytes");
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.ReedSolomonEncoder
 * JD-Core Version:    0.7.0.1
 */