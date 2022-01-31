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
    if (localObject != ff.b)
    {
      boolean bool;
      switch (fc.26.a[localObject.ordinal()])
      {
      default: 
        throw new eb("Invalid bitset value type: ".concat(String.valueOf(localObject)));
      case 1: 
        if (paramfe.n() != 0) {
          bool = true;
        }
        break;
      }
      for (;;)
      {
        if (bool) {
          localBitSet.set(i);
        }
        i += 1;
        localObject = paramfe.f();
        break;
        bool = false;
        continue;
        bool = paramfe.j();
        continue;
        localObject = paramfe.i();
        try
        {
          int j = Integer.parseInt((String)localObject);
          if (j != 0) {
            bool = true;
          } else {
            bool = false;
          }
        }
        catch (NumberFormatException paramfe)
        {
          throw new eb("Error: Expecting: bitset number value (1, 0), Found: ".concat(String.valueOf(localObject)));
        }
      }
    }
    paramfe.b();
    return localBitSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.12
 * JD-Core Version:    0.7.0.1
 */