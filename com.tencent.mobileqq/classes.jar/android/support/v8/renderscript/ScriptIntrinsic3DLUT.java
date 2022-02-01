package android.support.v8.renderscript;

public class ScriptIntrinsic3DLUT
  extends ScriptIntrinsic
{
  private Element mElement;
  private Allocation mLUT;
  
  protected ScriptIntrinsic3DLUT(int paramInt, RenderScript paramRenderScript, Element paramElement)
  {
    super(paramInt, paramRenderScript);
    this.mElement = paramElement;
  }
  
  public static ScriptIntrinsic3DLUT create(RenderScript paramRenderScript, Element paramElement)
  {
    if (RenderScript.isNative)
    {
      RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
      return ScriptIntrinsic3DLUTThunker.create(paramRenderScript, paramElement);
    }
    int i = paramRenderScript.nScriptIntrinsicCreate(8, paramElement.getID(paramRenderScript));
    if (paramElement.isCompatible(Element.U8_4(paramRenderScript))) {
      return new ScriptIntrinsic3DLUT(i, paramRenderScript, paramElement);
    }
    throw new RSIllegalArgumentException("Element must be compatible with uchar4.");
  }
  
  public void forEach(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    forEach(0, paramAllocation1, paramAllocation2, null);
  }
  
  public Script.KernelID getKernelID()
  {
    return createKernelID(0, 3, null, null);
  }
  
  public void setLUT(Allocation paramAllocation)
  {
    Type localType = paramAllocation.getType();
    if (localType.getZ() != 0)
    {
      if (localType.getElement().isCompatible(this.mElement))
      {
        this.mLUT = paramAllocation;
        setVar(0, this.mLUT);
        return;
      }
      throw new RSIllegalArgumentException("LUT element type must match.");
    }
    throw new RSIllegalArgumentException("LUT must be 3d.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsic3DLUT
 * JD-Core Version:    0.7.0.1
 */