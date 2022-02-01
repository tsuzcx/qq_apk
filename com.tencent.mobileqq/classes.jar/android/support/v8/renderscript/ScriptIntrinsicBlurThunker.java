package android.support.v8.renderscript;

class ScriptIntrinsicBlurThunker
  extends ScriptIntrinsicBlur
{
  android.renderscript.ScriptIntrinsicBlur mN;
  
  protected ScriptIntrinsicBlurThunker(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public static ScriptIntrinsicBlurThunker create(RenderScript paramRenderScript, Element paramElement)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    paramElement = (ElementThunker)paramElement;
    paramRenderScript = new ScriptIntrinsicBlurThunker(0, paramRenderScript);
    paramRenderScript.mN = android.renderscript.ScriptIntrinsicBlur.create(localRenderScriptThunker.mN, paramElement.getNObj());
    return paramRenderScript;
  }
  
  public void forEach(Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    if (paramAllocation != null) {
      this.mN.forEach(paramAllocation.getNObj());
    }
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
  
  android.renderscript.ScriptIntrinsicBlur getNObj()
  {
    return this.mN;
  }
  
  public void setInput(Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    this.mN.setInput(paramAllocation.getNObj());
  }
  
  public void setRadius(float paramFloat)
  {
    this.mN.setRadius(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicBlurThunker
 * JD-Core Version:    0.7.0.1
 */