package android.support.v8.renderscript;

import android.content.res.Resources;
import android.renderscript.Script.FieldID;
import android.renderscript.Script.KernelID;
import android.renderscript.ScriptC;

class ScriptCThunker
  extends ScriptC
{
  private static final String TAG = "ScriptC";
  
  protected ScriptCThunker(RenderScriptThunker paramRenderScriptThunker, Resources paramResources, int paramInt)
  {
    super(paramRenderScriptThunker.mN, paramResources, paramInt);
  }
  
  void thunkBindAllocation(Allocation paramAllocation, int paramInt)
  {
    android.renderscript.Allocation localAllocation = null;
    if (paramAllocation != null) {
      localAllocation = ((AllocationThunker)paramAllocation).mN;
    }
    bindAllocation(localAllocation, paramInt);
  }
  
  Script.FieldID thunkCreateFieldID(int paramInt, Element paramElement)
  {
    return createFieldID(paramInt, ((ElementThunker)paramElement).getNObj());
  }
  
  Script.KernelID thunkCreateKernelID(int paramInt1, int paramInt2, Element paramElement1, Element paramElement2)
  {
    android.renderscript.Element localElement = null;
    if (paramElement1 != null) {}
    for (paramElement1 = ((ElementThunker)paramElement1).mN;; paramElement1 = null)
    {
      if (paramElement2 != null) {
        localElement = ((ElementThunker)paramElement2).mN;
      }
      return createKernelID(paramInt1, paramInt2, paramElement1, localElement);
    }
  }
  
  void thunkForEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker)
  {
    android.renderscript.FieldPacker localFieldPacker = null;
    if (paramAllocation1 != null) {}
    for (paramAllocation1 = ((AllocationThunker)paramAllocation1).mN;; paramAllocation1 = null)
    {
      if (paramAllocation2 != null) {}
      for (paramAllocation2 = ((AllocationThunker)paramAllocation2).mN;; paramAllocation2 = null)
      {
        if (paramFieldPacker != null) {
          localFieldPacker = new android.renderscript.FieldPacker(paramFieldPacker.getData());
        }
        forEach(paramInt, paramAllocation1, paramAllocation2, localFieldPacker);
        return;
      }
    }
  }
  
  void thunkForEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker, Script.LaunchOptions paramLaunchOptions)
  {
    Object localObject = null;
    android.renderscript.Script.LaunchOptions localLaunchOptions2;
    if (paramLaunchOptions != null)
    {
      localLaunchOptions2 = new android.renderscript.Script.LaunchOptions();
      if (paramLaunchOptions.getXEnd() > 0) {
        localLaunchOptions2.setX(paramLaunchOptions.getXStart(), paramLaunchOptions.getXEnd());
      }
      if (paramLaunchOptions.getYEnd() > 0) {
        localLaunchOptions2.setY(paramLaunchOptions.getYStart(), paramLaunchOptions.getYEnd());
      }
      localLaunchOptions1 = localLaunchOptions2;
      if (paramLaunchOptions.getZEnd() > 0) {
        localLaunchOptions2.setZ(paramLaunchOptions.getZStart(), paramLaunchOptions.getZEnd());
      }
    }
    for (android.renderscript.Script.LaunchOptions localLaunchOptions1 = localLaunchOptions2;; localLaunchOptions1 = null)
    {
      if (paramAllocation1 != null) {}
      for (paramAllocation1 = ((AllocationThunker)paramAllocation1).mN;; paramAllocation1 = null)
      {
        if (paramAllocation2 != null) {}
        for (paramAllocation2 = ((AllocationThunker)paramAllocation2).mN;; paramAllocation2 = null)
        {
          paramLaunchOptions = localObject;
          if (paramFieldPacker != null) {
            paramLaunchOptions = new android.renderscript.FieldPacker(paramFieldPacker.getData());
          }
          forEach(paramInt, paramAllocation1, paramAllocation2, paramLaunchOptions, localLaunchOptions1);
          return;
        }
      }
    }
  }
  
  void thunkInvoke(int paramInt)
  {
    invoke(paramInt);
  }
  
  void thunkInvoke(int paramInt, FieldPacker paramFieldPacker)
  {
    invoke(paramInt, new android.renderscript.FieldPacker(paramFieldPacker.getData()));
  }
  
  void thunkSetTimeZone(String paramString)
  {
    setTimeZone(paramString);
  }
  
  void thunkSetVar(int paramInt, double paramDouble)
  {
    setVar(paramInt, paramDouble);
  }
  
  void thunkSetVar(int paramInt, float paramFloat)
  {
    setVar(paramInt, paramFloat);
  }
  
  void thunkSetVar(int paramInt1, int paramInt2)
  {
    setVar(paramInt1, paramInt2);
  }
  
  void thunkSetVar(int paramInt, long paramLong)
  {
    setVar(paramInt, paramLong);
  }
  
  void thunkSetVar(int paramInt, BaseObj paramBaseObj)
  {
    if (paramBaseObj == null)
    {
      setVar(paramInt, 0);
      return;
    }
    setVar(paramInt, paramBaseObj.getNObj());
  }
  
  void thunkSetVar(int paramInt, FieldPacker paramFieldPacker)
  {
    setVar(paramInt, new android.renderscript.FieldPacker(paramFieldPacker.getData()));
  }
  
  void thunkSetVar(int paramInt, FieldPacker paramFieldPacker, Element paramElement, int[] paramArrayOfInt)
  {
    setVar(paramInt, new android.renderscript.FieldPacker(paramFieldPacker.getData()), ((ElementThunker)paramElement).mN, paramArrayOfInt);
  }
  
  void thunkSetVar(int paramInt, boolean paramBoolean)
  {
    setVar(paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptCThunker
 * JD-Core Version:    0.7.0.1
 */