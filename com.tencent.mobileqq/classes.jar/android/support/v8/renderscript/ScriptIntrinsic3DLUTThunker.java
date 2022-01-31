package android.support.v8.renderscript;

class ScriptIntrinsic3DLUTThunker
  extends ScriptIntrinsic3DLUT
{
  android.renderscript.ScriptIntrinsic3DLUT mN;
  
  private ScriptIntrinsic3DLUTThunker(int paramInt, RenderScript paramRenderScript, Element paramElement)
  {
    super(paramInt, paramRenderScript, paramElement);
  }
  
  public static ScriptIntrinsic3DLUTThunker create(RenderScript paramRenderScript, Element paramElement)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    ElementThunker localElementThunker = (ElementThunker)paramElement;
    paramRenderScript = new ScriptIntrinsic3DLUTThunker(0, paramRenderScript, paramElement);
    paramRenderScript.mN = android.renderscript.ScriptIntrinsic3DLUT.create(localRenderScriptThunker.mN, localElementThunker.getNObj());
    return paramRenderScript;
  }
  
  public void forEach(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    paramAllocation1 = (AllocationThunker)paramAllocation1;
    paramAllocation2 = (AllocationThunker)paramAllocation2;
    this.mN.forEach(paramAllocation1.getNObj(), paramAllocation2.getNObj());
  }
  
  public Script.KernelID getKernelID()
  {
    Script.KernelID localKernelID = createKernelID(0, 3, null, null);
    localKernelID.mN = this.mN.getKernelID();
    return localKernelID;
  }
  
  android.renderscript.ScriptIntrinsic3DLUT getNObj()
  {
    return this.mN;
  }
  
  public void setLUT(Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    this.mN.setLUT(paramAllocation.getNObj());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsic3DLUTThunker
 * JD-Core Version:    0.7.0.1
 */