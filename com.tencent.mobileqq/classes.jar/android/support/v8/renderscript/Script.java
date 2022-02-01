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
    ScriptCThunker localScriptCThunker = this.mT;
    if (localScriptCThunker != null)
    {
      localScriptCThunker.thunkBindAllocation(paramAllocation, paramInt);
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
      ScriptCThunker localScriptCThunker = this.mT;
      if (localScriptCThunker != null) {
        ((Script.FieldID)localObject).mN = localScriptCThunker.thunkCreateFieldID(paramInt, paramElement);
      }
      this.mFIDs.put(paramInt, localObject);
      return localObject;
    }
    paramElement = (Script.FieldID)this.mFIDs.get(paramInt);
    if (paramElement != null) {
      return paramElement;
    }
    int i = this.mRS.nScriptFieldIDCreate(getID(this.mRS), paramInt);
    if (i != 0)
    {
      paramElement = new Script.FieldID(i, this.mRS, this, paramInt);
      this.mFIDs.put(paramInt, paramElement);
      return paramElement;
    }
    throw new RSDriverException("Failed to create FieldID");
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
      ScriptCThunker localScriptCThunker = this.mT;
      if (localScriptCThunker != null) {
        ((Script.KernelID)localObject).mN = localScriptCThunker.thunkCreateKernelID(paramInt1, paramInt2, paramElement1, paramElement2);
      }
      this.mKIDs.put(paramInt1, localObject);
      return localObject;
    }
    int i = this.mRS.nScriptKernelIDCreate(getID(this.mRS), paramInt1, paramInt2);
    if (i != 0)
    {
      paramElement1 = new Script.KernelID(i, this.mRS, this, paramInt1, paramInt2);
      this.mKIDs.put(paramInt1, paramElement1);
      return paramElement1;
    }
    throw new RSDriverException("Failed to create KernelID");
  }
  
  protected void forEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker)
  {
    ScriptCThunker localScriptCThunker = this.mT;
    if (localScriptCThunker != null)
    {
      localScriptCThunker.thunkForEach(paramInt, paramAllocation1, paramAllocation2, paramFieldPacker);
      return;
    }
    if ((paramAllocation1 == null) && (paramAllocation2 == null)) {
      throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
    }
    int i;
    if (paramAllocation1 != null) {
      i = paramAllocation1.getID(this.mRS);
    } else {
      i = 0;
    }
    int j;
    if (paramAllocation2 != null) {
      j = paramAllocation2.getID(this.mRS);
    } else {
      j = 0;
    }
    paramAllocation1 = null;
    if (paramFieldPacker != null) {
      paramAllocation1 = paramFieldPacker.getData();
    }
    this.mRS.nScriptForEach(getID(this.mRS), paramInt, i, j, paramAllocation1);
  }
  
  protected void forEach(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2, FieldPacker paramFieldPacker, Script.LaunchOptions paramLaunchOptions)
  {
    ScriptCThunker localScriptCThunker = this.mT;
    if (localScriptCThunker != null)
    {
      localScriptCThunker.thunkForEach(paramInt, paramAllocation1, paramAllocation2, paramFieldPacker, paramLaunchOptions);
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
    int i;
    if (paramAllocation1 != null) {
      i = paramAllocation1.getID(this.mRS);
    } else {
      i = 0;
    }
    int j;
    if (paramAllocation2 != null) {
      j = paramAllocation2.getID(this.mRS);
    } else {
      j = 0;
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
    ScriptCThunker localScriptCThunker = this.mT;
    if (localScriptCThunker != null)
    {
      localScriptCThunker.thunkInvoke(paramInt);
      return;
    }
    this.mRS.nScriptInvoke(getID(this.mRS), paramInt);
  }
  
  protected void invoke(int paramInt, FieldPacker paramFieldPacker)
  {
    ScriptCThunker localScriptCThunker = this.mT;
    if (localScriptCThunker != null)
    {
      localScriptCThunker.thunkInvoke(paramInt, paramFieldPacker);
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
    ScriptCThunker localScriptCThunker = this.mT;
    if (localScriptCThunker != null)
    {
      localScriptCThunker.thunkSetTimeZone(paramString);
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
    ScriptCThunker localScriptCThunker = this.mT;
    if (localScriptCThunker != null)
    {
      localScriptCThunker.thunkSetVar(paramInt, paramDouble);
      return;
    }
    this.mRS.nScriptSetVarD(getID(this.mRS), paramInt, paramDouble);
  }
  
  public void setVar(int paramInt, float paramFloat)
  {
    ScriptCThunker localScriptCThunker = this.mT;
    if (localScriptCThunker != null)
    {
      localScriptCThunker.thunkSetVar(paramInt, paramFloat);
      return;
    }
    this.mRS.nScriptSetVarF(getID(this.mRS), paramInt, paramFloat);
  }
  
  public void setVar(int paramInt1, int paramInt2)
  {
    ScriptCThunker localScriptCThunker = this.mT;
    if (localScriptCThunker != null)
    {
      localScriptCThunker.thunkSetVar(paramInt1, paramInt2);
      return;
    }
    this.mRS.nScriptSetVarI(getID(this.mRS), paramInt1, paramInt2);
  }
  
  public void setVar(int paramInt, long paramLong)
  {
    ScriptCThunker localScriptCThunker = this.mT;
    if (localScriptCThunker != null)
    {
      localScriptCThunker.thunkSetVar(paramInt, paramLong);
      return;
    }
    this.mRS.nScriptSetVarJ(getID(this.mRS), paramInt, paramLong);
  }
  
  public void setVar(int paramInt, BaseObj paramBaseObj)
  {
    Object localObject = this.mT;
    if (localObject != null)
    {
      ((ScriptCThunker)localObject).thunkSetVar(paramInt, paramBaseObj);
      return;
    }
    localObject = this.mRS;
    int j = getID(this.mRS);
    int i;
    if (paramBaseObj == null) {
      i = 0;
    } else {
      i = paramBaseObj.getID(this.mRS);
    }
    ((RenderScript)localObject).nScriptSetVarObj(j, paramInt, i);
  }
  
  public void setVar(int paramInt, FieldPacker paramFieldPacker)
  {
    ScriptCThunker localScriptCThunker = this.mT;
    if (localScriptCThunker != null)
    {
      localScriptCThunker.thunkSetVar(paramInt, paramFieldPacker);
      return;
    }
    this.mRS.nScriptSetVarV(getID(this.mRS), paramInt, paramFieldPacker.getData());
  }
  
  public void setVar(int paramInt, FieldPacker paramFieldPacker, Element paramElement, int[] paramArrayOfInt)
  {
    ScriptCThunker localScriptCThunker = this.mT;
    if (localScriptCThunker != null)
    {
      localScriptCThunker.thunkSetVar(paramInt, paramFieldPacker, paramElement, paramArrayOfInt);
      return;
    }
    this.mRS.nScriptSetVarVE(getID(this.mRS), paramInt, paramFieldPacker.getData(), paramElement.getID(this.mRS), paramArrayOfInt);
  }
  
  public void setVar(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.Script
 * JD-Core Version:    0.7.0.1
 */