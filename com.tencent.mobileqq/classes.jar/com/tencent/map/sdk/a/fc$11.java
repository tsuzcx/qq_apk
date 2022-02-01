package com.tencent.map.sdk.a;

import java.net.URI;
import java.net.URISyntaxException;

final class fc$11
  extends ee<URI>
{
  private static URI b(fe paramfe)
  {
    if (paramfe.f() == ff.i) {
      paramfe.k();
    }
    for (;;)
    {
      return null;
      try
      {
        paramfe = paramfe.i();
        if ("null".equals(paramfe)) {
          continue;
        }
        paramfe = new URI(paramfe);
        return paramfe;
      }
      catch (URISyntaxException paramfe)
      {
        throw new du(paramfe);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.11
 * JD-Core Version:    0.7.0.1
 */