package android.support.v8.renderscript;

public class ScriptGroup
  extends BaseObj
{
  ScriptGroup.IO[] mInputs;
  ScriptGroup.IO[] mOutputs;
  
  ScriptGroup(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public void execute()
  {
    this.mRS.nScriptGroupExecute(getID(this.mRS));
  }
  
  public void setInput(Script.KernelID paramKernelID, Allocation paramAllocation)
  {
    int i = 0;
    while (i < this.mInputs.length)
    {
      if (this.mInputs[i].mKID == paramKernelID)
      {
        this.mInputs[i].mAllocation = paramAllocation;
        this.mRS.nScriptGroupSetInput(getID(this.mRS), paramKernelID.getID(this.mRS), this.mRS.safeID(paramAllocation));
        return;
      }
      i += 1;
    }
    throw new RSIllegalArgumentException("Script not found");
  }
  
  public void setOutput(Script.KernelID paramKernelID, Allocation paramAllocation)
  {
    int i = 0;
    while (i < this.mOutputs.length)
    {
      if (this.mOutputs[i].mKID == paramKernelID)
      {
        this.mOutputs[i].mAllocation = paramAllocation;
        this.mRS.nScriptGroupSetOutput(getID(this.mRS), paramKernelID.getID(this.mRS), this.mRS.safeID(paramAllocation));
        return;
      }
      i += 1;
    }
    throw new RSIllegalArgumentException("Script not found");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptGroup
 * JD-Core Version:    0.7.0.1
 */