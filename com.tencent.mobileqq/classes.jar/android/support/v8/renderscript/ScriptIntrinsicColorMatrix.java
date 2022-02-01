package android.support.v8.renderscript;

public class ScriptIntrinsicColorMatrix
  extends ScriptIntrinsic
{
  private Allocation mInput;
  private final Matrix4f mMatrix = new Matrix4f();
  
  protected ScriptIntrinsicColorMatrix(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public static ScriptIntrinsicColorMatrix create(RenderScript paramRenderScript, Element paramElement)
  {
    if (RenderScript.isNative)
    {
      RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
      return ScriptIntrinsicColorMatrixThunker.create(paramRenderScript, paramElement);
    }
    if (!paramElement.isCompatible(Element.U8_4(paramRenderScript))) {
      throw new RSIllegalArgumentException("Unsuported element type.");
    }
    return new ScriptIntrinsicColorMatrix(paramRenderScript.nScriptIntrinsicCreate(2, paramElement.getID(paramRenderScript)), paramRenderScript);
  }
  
  private void setMatrix()
  {
    FieldPacker localFieldPacker = new FieldPacker(64);
    localFieldPacker.addMatrix(this.mMatrix);
    setVar(0, localFieldPacker);
  }
  
  public void forEach(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    forEach(0, paramAllocation1, paramAllocation2, null);
  }
  
  public Script.KernelID getKernelID()
  {
    return createKernelID(0, 3, null, null);
  }
  
  public void setColorMatrix(Matrix3f paramMatrix3f)
  {
    this.mMatrix.load(paramMatrix3f);
    setMatrix();
  }
  
  public void setColorMatrix(Matrix4f paramMatrix4f)
  {
    this.mMatrix.load(paramMatrix4f);
    setMatrix();
  }
  
  public void setGreyscale()
  {
    this.mMatrix.loadIdentity();
    this.mMatrix.set(0, 0, 0.299F);
    this.mMatrix.set(1, 0, 0.587F);
    this.mMatrix.set(2, 0, 0.114F);
    this.mMatrix.set(0, 1, 0.299F);
    this.mMatrix.set(1, 1, 0.587F);
    this.mMatrix.set(2, 1, 0.114F);
    this.mMatrix.set(0, 2, 0.299F);
    this.mMatrix.set(1, 2, 0.587F);
    this.mMatrix.set(2, 2, 0.114F);
    setMatrix();
  }
  
  public void setRGBtoYUV()
  {
    this.mMatrix.loadIdentity();
    this.mMatrix.set(0, 0, 0.299F);
    this.mMatrix.set(1, 0, 0.587F);
    this.mMatrix.set(2, 0, 0.114F);
    this.mMatrix.set(0, 1, -0.14713F);
    this.mMatrix.set(1, 1, -0.28886F);
    this.mMatrix.set(2, 1, 0.436F);
    this.mMatrix.set(0, 2, 0.615F);
    this.mMatrix.set(1, 2, -0.51499F);
    this.mMatrix.set(2, 2, -0.10001F);
    setMatrix();
  }
  
  public void setYUVtoRGB()
  {
    this.mMatrix.loadIdentity();
    this.mMatrix.set(0, 0, 1.0F);
    this.mMatrix.set(1, 0, 0.0F);
    this.mMatrix.set(2, 0, 1.13983F);
    this.mMatrix.set(0, 1, 1.0F);
    this.mMatrix.set(1, 1, -0.39465F);
    this.mMatrix.set(2, 1, -0.5806F);
    this.mMatrix.set(0, 2, 1.0F);
    this.mMatrix.set(1, 2, 2.03211F);
    this.mMatrix.set(2, 2, 0.0F);
    setMatrix();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicColorMatrix
 * JD-Core Version:    0.7.0.1
 */