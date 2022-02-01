package com.tencent.map.sdk.a;

import java.util.ArrayList;
import java.util.Arrays;

public final class oc
{
  private static oa a = new oa();
  
  public static <D extends nz> ny<D> a(Class<D> paramClass, ny.a... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return null;
    }
    ob localob = new ob();
    int i;
    if (paramVarArgs.length > 1) {
      i = 1;
    } else {
      i = 0;
    }
    int k = paramVarArgs.length;
    Object localObject2 = null;
    int j = 0;
    while (j < k)
    {
      Object localObject3 = paramVarArgs[j];
      Object localObject1;
      if ((localObject3 instanceof og.a))
      {
        localObject1 = (og.a)localObject3;
        localObject1 = a.a(paramClass, (ny.a)localObject1, og.class);
      }
      else
      {
        localObject1 = localObject2;
        if ((localObject3 instanceof of.c))
        {
          localObject3 = (of.c)localObject3;
          if (((of.c)localObject3).g == of.a.a)
          {
            localObject1 = a.a(paramClass, (ny.a)localObject3, oe.class);
          }
          else
          {
            localObject1 = localObject2;
            if (((of.c)localObject3).g == of.a.b) {
              localObject1 = a.a(paramClass, (ny.a)localObject3, od.class);
            }
          }
        }
      }
      if ((i != 0) && (localObject1 != null)) {
        localob.a.addAll(Arrays.asList(new ny[] { localObject1 }));
      }
      j += 1;
      localObject2 = localObject1;
    }
    if (i != 0) {
      return localob;
    }
    return localObject2;
  }
  
  public static <D extends nz> oh<D> a(ny<D> paramny)
  {
    if ((paramny instanceof oh)) {
      return (oh)paramny;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    return a.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.oc
 * JD-Core Version:    0.7.0.1
 */