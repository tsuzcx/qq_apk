package com.tencent.map.sdk.a;

import java.util.BitSet;

final class fc$12
  extends ee<BitSet>
{
  private static BitSet b(fe paramfe)
  {
    if (paramfe.f() == ff.i)
    {
      paramfe.k();
      return null;
    }
    BitSet localBitSet = new BitSet();
    paramfe.a();
    Object localObject = paramfe.f();
    int i = 0;
    while (localObject != ff.b)
    {
      int j = fc.26.a[localObject.ordinal()];
      boolean bool = true;
      if (j != 1) {
        if (j != 2) {
          if (j == 3) {
            localObject = paramfe.i();
          }
        }
      }
      label96:
      while (paramfe.n() == 0)
      {
        try
        {
          j = Integer.parseInt((String)localObject);
          if (j != 0) {
            break;
          }
          bool = false;
        }
        catch (NumberFormatException paramfe)
        {
          break label96;
        }
        throw new eb("Error: Expecting: bitset number value (1, 0), Found: ".concat(String.valueOf(localObject)));
        throw new eb("Invalid bitset value type: ".concat(String.valueOf(localObject)));
        bool = paramfe.j();
        break;
      }
      if (bool) {
        localBitSet.set(i);
      }
      i += 1;
      localObject = paramfe.f();
    }
    paramfe.b();
    return localBitSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.12
 * JD-Core Version:    0.7.0.1
 */