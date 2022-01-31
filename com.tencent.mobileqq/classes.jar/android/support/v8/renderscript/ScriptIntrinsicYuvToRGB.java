package android.support.v8.renderscript;

public class ScriptIntrinsicYuvToRGB
  extends ScriptIntrinsic
{
  private Allocation mInput;
  
  ScriptIntrinsicYuvToRGB(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public static ScriptIntrinsicYuvToRGB create(RenderScript paramRenderScript, Element paramElement)
  {
    if (RenderScript.isNative)
    {
      RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
      return ScriptIntrinsicYuvToRGBThunker.create(paramRenderScript, paramElement);
    }
    return new ScriptIntrinsicYuvToRGB(paramRenderScript.nScriptIntrinsicCreate(6, paramElement.getID(paramRenderScript)), paramRenderScript);
  }
  
  public void forEach(Allocation paramAllocation)
  {
    forEach(0, null, paramAllocation, null);
  }
  
  public Script.FieldID getFieldID_Input()
  {
    return createFieldID(0, null);
  }
  
  public Script.KernelID getKernelID()
  {
    return createKernelID(0, 2, null, null);
  }
  
  public void setInput(Allocation paramAllocation)
  {
    this.mInput = paramAllocation;
    setVar(0, paramAllocation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicYuvToRGB
 * JD-Core Version:    0.7.0.1
 */