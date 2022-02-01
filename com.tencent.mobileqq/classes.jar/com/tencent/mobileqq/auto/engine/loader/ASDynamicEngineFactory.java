package com.tencent.mobileqq.auto.engine.loader;

import androidx.annotation.NonNull;

public class ASDynamicEngineFactory
{
  public static ASDynamicEngine a(@NonNull String paramString)
  {
    try
    {
      ASDynamicEngine localASDynamicEngine2 = ASDynamicEngine.b(paramString);
      ASDynamicEngine localASDynamicEngine1 = localASDynamicEngine2;
      if (localASDynamicEngine2 == null) {
        localASDynamicEngine1 = b(paramString);
      }
      return localASDynamicEngine1;
    }
    finally {}
  }
  
  private static ASDynamicEngine b(String paramString)
  {
    int i = paramString.hashCode();
    if (i != -1538620274)
    {
      if ((i == 1990896341) && (paramString.equals("qcircle-app")))
      {
        i = 1;
        break label50;
      }
    }
    else if (paramString.equals("flash-show-app"))
    {
      i = 0;
      break label50;
    }
    i = -1;
    label50:
    if ((i != 0) && (i != 1)) {
      return new ASDynamicEngine.ASDynamicEngineBuilder().a("unKnowBusiness").a(false).b(false).a();
    }
    return new ASDynamicEngine.ASDynamicEngineBuilder().a(paramString).a(true).b(false).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory
 * JD-Core Version:    0.7.0.1
 */