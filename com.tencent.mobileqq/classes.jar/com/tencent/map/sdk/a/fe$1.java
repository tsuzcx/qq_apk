package com.tencent.map.sdk.a;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class fe$1
  extends ek
{
  public final void a(fe paramfe)
  {
    if ((paramfe instanceof eu))
    {
      paramfe = (eu)paramfe;
      paramfe.a(ff.e);
      localObject = (Map.Entry)((Iterator)paramfe.g()).next();
      paramfe.a.add(((Map.Entry)localObject).getValue());
      paramfe.a.add(new dy((String)((Map.Entry)localObject).getKey()));
      return;
    }
    int j = fe.a(paramfe);
    int i = j;
    if (j == 0) {
      i = fe.b(paramfe);
    }
    if (i == 13)
    {
      fe.a(paramfe, 9);
      return;
    }
    if (i == 12)
    {
      fe.a(paramfe, 8);
      return;
    }
    if (i == 14)
    {
      fe.a(paramfe, 10);
      return;
    }
    Object localObject = new StringBuilder("Expected a name but was ");
    ((StringBuilder)localObject).append(paramfe.f());
    ((StringBuilder)localObject).append("  at line ");
    ((StringBuilder)localObject).append(fe.c(paramfe));
    ((StringBuilder)localObject).append(" column ");
    ((StringBuilder)localObject).append(fe.d(paramfe));
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.fe.1
 * JD-Core Version:    0.7.0.1
 */