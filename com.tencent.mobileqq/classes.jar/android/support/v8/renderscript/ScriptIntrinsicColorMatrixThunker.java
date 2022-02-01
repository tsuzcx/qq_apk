package android.support.v8.renderscript;

class ScriptIntrinsicColorMatrixThunker
  extends ScriptIntrinsicColorMatrix
{
  android.renderscript.ScriptIntrinsicColorMatrix mN;
  
  private ScriptIntrinsicColorMatrixThunker(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public static ScriptIntrinsicColorMatrixThunker create(RenderScript paramRenderScript, Element paramElement)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    paramElement = (ElementThunker)paramElement;
    paramRenderScript = new ScriptIntrinsicColorMatrixThunker(0, paramRenderScript);
    paramRenderScript.mN = android.renderscript.ScriptIntrinsicColorMatrix.create(localRenderScriptThunker.mN, paramElement.getNObj());
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
  
  android.renderscript.ScriptIntrinsicColorMatrix getNObj()
  {
    return this.mN;
  }
  
  public void setColorMatrix(Matrix3f paramMatrix3f)
  {
    this.mN.setColorMatrix(new android.renderscript.Matrix3f(paramMatrix3f.getArray()));
  }
  
  public void setColorMatrix(Matrix4f paramMatrix4f)
  {
    this.mN.setColorMatrix(new android.renderscript.Matrix4f(paramMatrix4f.getArray()));
  }
  
  public void setGreyscale()
  {
    this.mN.setGreyscale();
  }
  
  public void setRGBtoYUV()
  {
    this.mN.setRGBtoYUV();
  }
  
  public void setYUVtoRGB()
  {
    this.mN.setYUVtoRGB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicColorMatrixThunker
 * JD-Core Version:    0.7.0.1
 */