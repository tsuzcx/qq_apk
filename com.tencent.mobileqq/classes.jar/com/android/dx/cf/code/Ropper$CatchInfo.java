package com.android.dx.cf.code;

import com.android.dx.rop.type.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Ropper$CatchInfo
{
  private final Map<Type, Ropper.ExceptionHandlerSetup> setups = new HashMap();
  
  private Ropper$CatchInfo(Ropper paramRopper) {}
  
  Ropper.ExceptionHandlerSetup getSetup(Type paramType)
  {
    Ropper.ExceptionHandlerSetup localExceptionHandlerSetup2 = (Ropper.ExceptionHandlerSetup)this.setups.get(paramType);
    Ropper.ExceptionHandlerSetup localExceptionHandlerSetup1 = localExceptionHandlerSetup2;
    if (localExceptionHandlerSetup2 == null)
    {
      localExceptionHandlerSetup1 = new Ropper.ExceptionHandlerSetup(paramType, Ropper.access$000(this.this$0).getNextLabel());
      this.setups.put(paramType, localExceptionHandlerSetup1);
    }
    return localExceptionHandlerSetup1;
  }
  
  Collection<Ropper.ExceptionHandlerSetup> getSetups()
  {
    return this.setups.values();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Ropper.CatchInfo
 * JD-Core Version:    0.7.0.1
 */