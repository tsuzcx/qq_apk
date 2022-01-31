package android.support.v8.renderscript;

import android.util.SparseArray;
import java.io.UnsupportedEncodingException;

public class Script
  extends BaseObj
{
  private final SparseArray<Script.FieldID> mFIDs = new SparseArray();
  private final SparseArray<Script.KernelID> mKIDs = new SparseArray();
  ScriptCThunker mT;
  
  Script(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public void bindAllocation(Allocation paramAllocation, int paramInt)
  {
    if (this.mT != null)
    {
      this.mT.thunkBindAllocation(paramAllocation, paramInt);
      return;
    }
    this.mRS.validate();
    if (paramAllocation != null)
    {
      this.mRS.nScriptBindAllocation(getID(this.mRS), paramAllocation.getID(this.mRS), paramInt);
      return;
    }
    this.mRS.nScriptBindAllocation(getID(this.mRS), 0, paramInt);
  }
  
  protected Script.FieldID createFieldID(int paramInt, Element paramElement)
  {
    Object localObject = this.mRS;
    if (RenderScript.isNative == true)
    {
      localObject = new Script.FieldID(0, this.mRS, this, paramInt);
      if (this.mT != null) {
        ((Script.FieldID)localObject).mN = this.mT.thunkCreateFieldID(paramInt, paramElement);
      }
      this.mFIDs.put(paramInt, localObject);
      paramElement = (Element)localObject;
    }
    do
    {
      return paramElement;
      localObject = (Script.FieldID)this.mFIDs.get(paramInt);
      paramElement = (Element)localObject;
    } while (localObject != null);
    int i = this.mRS.nScriptFieldIDCreate(getID(this.mRS), paramInt);
    if (i == 0) {
      throw new RSDriverException("Failed to create FieldID");
    }
    paramElement = new Script.FieldID(i, this.mRS, this, paramInt);
    this.mFIDs.put(paramInt, paramElement);
    return paramElement;
  }
  
  protected Script.KernelID createKernelID(int paramInt1, int paramInt2, Element paramElement1, Element paramElement2)
  {
    Object localObject = (Script.KernelID)this.mKIDs.get(paramInt1);
    if (localObject != null) {
      return localObject;
    }
    localObject = this.mRS;
    if (RenderScript.isNative == true)
    {
      localObject = new Script.KernelID(0, this.mRS, this, paramInt1, paramInt2);
      if (this.mT != null) {
        ((Script.KernelID)localObject).mN = this.mT.thunkCreateKernelID(paramInt1, paramInt2, paramElement1, paramElement2);
      }
      this.mKIDs.put(paramInt1, localObject);
      return localObject;
    }
    int i = this.mRS.nScriptKernelIDCreate(getID(this.mRS), paramInt1, paramInt2);
    if (i == 0) {
      throw new RSDriverException("Failed to create KernelID");
    }
    paramElement1 = new Script.KernelID(i, this.mRS, this, paramInt1, paramInt2);
    this.mKIDs.put(paramInt1, paramElement1);
    return paramElement1;
  }
  
  protected void forEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker)
  {
    int j = 0;
    if (this.mT != null)
    {
      this.mT.thunkForEach(paramInt, paramAllocation1, paramAllocation2, paramFieldPacker);
      return;
    }
    if ((paramAllocation1 == null) && (paramAllocation2 == null)) {
      throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
    }
    if (paramAllocation1 != null) {}
    for (int i = paramAllocation1.getID(this.mRS);; i = 0)
    {
      if (paramAllocation2 != null) {
        j = paramAllocation2.getID(this.mRS);
      }
      paramAllocation1 = null;
      if (paramFieldPacker != null) {
        paramAllocation1 = paramFieldPacker.getData();
      }
      this.mRS.nScriptForEach(getID(this.mRS), paramInt, i, j, paramAllocation1);
      return;
    }
  }
  
  protected void forEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker, Script.LaunchOptions paramLaunchOptions)
  {
    if (this.mT != null)
    {
      this.mT.thunkForEach(paramInt, paramAllocation1, paramAllocation2, paramFieldPacker, paramLaunchOptions);
      return;
    }
    if ((paramAllocation1 == null) && (paramAllocation2 == null)) {
      throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
    }
    if (paramLaunchOptions == null)
    {
      forEach(paramInt, paramAllocation1, paramAllocation2, paramFieldPacker);
      return;
    }
    int i = 0;
    if (paramAllocation1 != null) {
      i = paramAllocation1.getID(this.mRS);
    }
    int j = 0;
    if (paramAllocation2 != null) {
      j = paramAllocation2.getID(this.mRS);
    }
    paramAllocation1 = null;
    if (paramFieldPacker != null) {
      paramAllocation1 = paramFieldPacker.getData();
    }
    this.mRS.nScriptForEachClipped(getID(this.mRS), paramInt, i, j, paramAllocation1, Script.LaunchOptions.access$000(paramLaunchOptions), Script.LaunchOptions.access$100(paramLaunchOptions), Script.LaunchOptions.access$200(paramLaunchOptions), Script.LaunchOptions.access$300(paramLaunchOptions), Script.LaunchOptions.access$400(paramLaunchOptions), Script.LaunchOptions.access$500(paramLaunchOptions));
  }
  
  android.renderscript.Script getNObj()
  {
    return this.mT;
  }
  
  protected void invoke(int paramInt)
  {
    if (this.mT != null)
    {
      this.mT.thunkInvoke(paramInt);
      return;
    }
    this.mRS.nScriptInvoke(getID(this.mRS), paramInt);
  }
  
  protected void invoke(int paramInt, FieldPacker paramFieldPacker)
  {
    if (this.mT != null)
    {
      this.mT.thunkInvoke(paramInt, paramFieldPacker);
      return;
    }
    if (paramFieldPacker != null)
    {
      this.mRS.nScriptInvokeV(getID(this.mRS), paramInt, paramFieldPacker.getData());
      return;
    }
    this.mRS.nScriptInvoke(getID(this.mRS), paramInt);
  }
  
  public void setTimeZone(String paramString)
  {
    if (this.mT != null)
    {
      this.mT.thunkSetTimeZone(paramString);
      return;
    }
    this.mRS.validate();
    try
    {
      this.mRS.nScriptSetTimeZone(getID(this.mRS), paramString.getBytes("UTF-8"));
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public void setVar(int paramInt, double paramDouble)
  {
    if (this.mT != null)
    {
      this.mT.thunkSetVar(paramInt, paramDouble);
      return;
    }
    this.mRS.nScriptSetVarD(getID(this.mRS), paramInt, paramDouble);
  }
  
  public void setVar(int paramInt, float paramFloat)
  {
    if (this.mT != null)
    {
      this.mT.thunkSetVar(paramInt, paramFloat);
      return;
    }
    this.mRS.nScriptSetVarF(getID(this.mRS), paramInt, paramFloat);
  }
  
  public void setVar(int paramInt1, int paramInt2)
  {
    if (this.mT != null)
    {
      this.mT.thunkSetVar(paramInt1, paramInt2);
      return;
    }
    this.mRS.nScriptSetVarI(getID(this.mRS), paramInt1, paramInt2);
  }
  
  public void setVar(int paramInt, long paramLong)
  {
    if (this.mT != null)
    {
      this.mT.thunkSetVar(paramInt, paramLong);
      return;
    }
    this.mRS.nScriptSetVarJ(getID(this.mRS), paramInt, paramLong);
  }
  
  public void setVar(int paramInt, BaseObj paramBaseObj)
  {
    if (this.mT != null)
    {
      this.mT.thunkSetVar(paramInt, paramBaseObj);
      return;
    }
    RenderScript localRenderScript = this.mRS;
    int j = getID(this.mRS);
    if (paramBaseObj == null) {}
    for (int i = 0;; i = paramBaseObj.getID(this.mRS))
    {
      localRenderScript.nScriptSetVarObj(j, paramInt, i);
      return;
    }
  }
  
  public void setVar(int paramInt, FieldPacker paramFieldPacker)
  {
    if (this.mT != null)
    {
      this.mT.thunkSetVar(paramInt, paramFieldPacker);
      return;
    }
    this.mRS.nScriptSetVarV(getID(this.mRS), paramInt, paramFieldPacker.getData());
  }
  
  public void setVar(int paramInt, FieldPacker paramFieldPacker, Element paramElement, int[] paramArrayOfInt)
  {
    if (this.mT != null)
    {
      this.mT.thunkSetVar(paramInt, paramFieldPacker, paramElement, paramArrayOfInt);
      return;
    }
    this.mRS.nScriptSetVarVE(getID(this.mRS), paramInt, paramFieldPacker.getData(), paramElement.getID(this.mRS), paramArrayOfInt);
  }
  
  public void setVar(int paramInt, boolean paramBoolean)
  {
    if (this.mT != null)
    {
      this.mT.thunkSetVar(paramInt, paramBoolean);
      return;
    }
    RenderScript localRenderScript = this.mRS;
    int j = getID(this.mRS);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localRenderScript.nScriptSetVarI(j, paramInt, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.Script
 * JD-Core Version:    0.7.0.1
 */