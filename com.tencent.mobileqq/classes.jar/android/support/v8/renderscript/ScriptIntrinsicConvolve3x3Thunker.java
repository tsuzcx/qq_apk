package android.support.v8.renderscript;

class ScriptIntrinsicConvolve3x3Thunker
  extends ScriptIntrinsicConvolve3x3
{
  android.renderscript.ScriptIntrinsicConvolve3x3 mN;
  
  ScriptIntrinsicConvolve3x3Thunker(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public static ScriptIntrinsicConvolve3x3Thunker create(RenderScript paramRenderScript, Element paramElement)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    paramElement = (ElementThunker)paramElement;
    paramRenderScript = new ScriptIntrinsicConvolve3x3Thunker(0, paramRenderScript);
    paramRenderScript.mN = android.renderscript.ScriptIntrinsicConvolve3x3.create(localRenderScriptThunker.mN, paramElement.getNObj());
    return paramRenderScript;
  }
  
  public void forEach(Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    this.mN.forEach(paramAllocation.getNObj());
  }
  
  public Script.FieldID getFieldID_Input()
  {
    Script.FieldID localFieldID = createFieldID(1, null);
    localFieldID.mN = this.mN.getFieldID_Input();
    return localFieldID;
  }
  
  public Script.KernelID getKernelID()
  {
    Script.KernelID localKernelID = createKernelID(0, 2, null, null);
    localKernelID.mN = this.mN.getKernelID();
    return localKernelID;
  }
  
  android.renderscript.ScriptIntrinsicConvolve3x3 getNObj()
  {
    return this.mN;
  }
  
  public void setCoefficients(float[] paramArrayOfFloat)
  {
    this.mN.setCoefficients(paramArrayOfFloat);
  }
  
  public void setInput(Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    this.mN.setInput(paramAllocation.getNObj());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicConvolve3x3Thunker
 * JD-Core Version:    0.7.0.1
 */