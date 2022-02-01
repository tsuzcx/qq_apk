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
    for (;;)
    {
      ScriptGroup.IO[] arrayOfIO = this.mInputs;
      if (i >= arrayOfIO.length) {
        break;
      }
      if (arrayOfIO[i].mKID == paramKernelID)
      {
        this.mInputs[i].mAllocation = paramAllocation;
        this.mRS.nScriptGroupSetInput(getID(this.mRS), paramKernelID.getID(this.mRS), this.mRS.safeID(paramAllocation));
        return;
      }
      i += 1;
    }
    paramKernelID = new RSIllegalArgumentException("Script not found");
    for (;;)
    {
      throw paramKernelID;
    }
  }
  
  public void setOutput(Script.KernelID paramKernelID, Allocation paramAllocation)
  {
    int i = 0;
    for (;;)
    {
      ScriptGroup.IO[] arrayOfIO = this.mOutputs;
      if (i >= arrayOfIO.length) {
        break;
      }
      if (arrayOfIO[i].mKID == paramKernelID)
      {
        this.mOutputs[i].mAllocation = paramAllocation;
        this.mRS.nScriptGroupSetOutput(getID(this.mRS), paramKernelID.getID(this.mRS), this.mRS.safeID(paramAllocation));
        return;
      }
      i += 1;
    }
    paramKernelID = new RSIllegalArgumentException("Script not found");
    for (;;)
    {
      throw paramKernelID;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptGroup
 * JD-Core Version:    0.7.0.1
 */