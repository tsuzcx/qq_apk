package android.support.v8.renderscript;

import android.content.Context;

class RenderScriptThunker
  extends RenderScript
{
  android.renderscript.RenderScript mN;
  
  RenderScriptThunker(Context paramContext)
  {
    super(paramContext);
    isNative = true;
  }
  
  public static RenderScript create(Context paramContext, int paramInt)
  {
    RenderScriptThunker localRenderScriptThunker = new RenderScriptThunker(paramContext);
    localRenderScriptThunker.mN = android.renderscript.RenderScript.create(paramContext, paramInt);
    return localRenderScriptThunker;
  }
  
  public void contextDump()
  {
    this.mN.contextDump();
  }
  
  public void destroy()
  {
    this.mN.destroy();
    this.mN = null;
  }
  
  public void finish()
  {
    this.mN.finish();
  }
  
  public void setPriority(RenderScript.Priority paramPriority)
  {
    if (paramPriority == RenderScript.Priority.LOW) {
      this.mN.setPriority(android.renderscript.RenderScript.Priority.LOW);
    }
    if (paramPriority == RenderScript.Priority.NORMAL) {
      this.mN.setPriority(android.renderscript.RenderScript.Priority.NORMAL);
    }
  }
  
  void validate()
  {
    if (this.mN == null) {
      throw new RSInvalidStateException("Calling RS with no Context active.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.RenderScriptThunker
 * JD-Core Version:    0.7.0.1
 */