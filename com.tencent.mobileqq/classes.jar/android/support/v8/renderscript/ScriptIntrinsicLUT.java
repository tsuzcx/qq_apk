package android.support.v8.renderscript;

public class ScriptIntrinsicLUT
  extends ScriptIntrinsic
{
  private final byte[] mCache = new byte[1024];
  private boolean mDirty = true;
  private final Matrix4f mMatrix = new Matrix4f();
  private Allocation mTables;
  
  protected ScriptIntrinsicLUT(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public static ScriptIntrinsicLUT create(RenderScript paramRenderScript, Element paramElement)
  {
    if (RenderScript.isNative)
    {
      RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
      return ScriptIntrinsicLUTThunker.create(paramRenderScript, paramElement);
    }
    paramElement = new ScriptIntrinsicLUT(paramRenderScript.nScriptIntrinsicCreate(3, paramElement.getID(paramRenderScript)), paramRenderScript);
    paramElement.mTables = Allocation.createSized(paramRenderScript, Element.U8(paramRenderScript), 1024);
    int i = 0;
    while (i < 256)
    {
      paramElement.mCache[i] = ((byte)i);
      paramElement.mCache[(i + 256)] = ((byte)i);
      paramElement.mCache[(i + 512)] = ((byte)i);
      paramElement.mCache[(i + 768)] = ((byte)i);
      i += 1;
    }
    paramElement.setVar(0, paramElement.mTables);
    return paramElement;
  }
  
  private void validate(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 255)) {
      throw new RSIllegalArgumentException("Index out of range (0-255).");
    }
    if ((paramInt2 < 0) || (paramInt2 > 255)) {
      throw new RSIllegalArgumentException("Value out of range (0-255).");
    }
  }
  
  public void forEach(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    if (this.mDirty)
    {
      this.mDirty = false;
      this.mTables.copyFromUnchecked(this.mCache);
    }
    forEach(0, paramAllocation1, paramAllocation2, null);
  }
  
  public Script.KernelID getKernelID()
  {
    return createKernelID(0, 3, null, null);
  }
  
  public void setAlpha(int paramInt1, int paramInt2)
  {
    validate(paramInt1, paramInt2);
    this.mCache[(paramInt1 + 768)] = ((byte)paramInt2);
    this.mDirty = true;
  }
  
  public void setBlue(int paramInt1, int paramInt2)
  {
    validate(paramInt1, paramInt2);
    this.mCache[(paramInt1 + 512)] = ((byte)paramInt2);
    this.mDirty = true;
  }
  
  public void setGreen(int paramInt1, int paramInt2)
  {
    validate(paramInt1, paramInt2);
    this.mCache[(paramInt1 + 256)] = ((byte)paramInt2);
    this.mDirty = true;
  }
  
  public void setRed(int paramInt1, int paramInt2)
  {
    validate(paramInt1, paramInt2);
    this.mCache[paramInt1] = ((byte)paramInt2);
    this.mDirty = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicLUT
 * JD-Core Version:    0.7.0.1
 */