package android.support.v8.renderscript;

class ScriptGroupThunker
  extends ScriptGroup
{
  android.renderscript.ScriptGroup mN;
  
  ScriptGroupThunker(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  public void execute()
  {
    this.mN.execute();
  }
  
  android.renderscript.ScriptGroup getNObj()
  {
    return this.mN;
  }
  
  public void setInput(Script.KernelID paramKernelID, Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    this.mN.setInput(paramKernelID.mN, paramAllocation.getNObj());
  }
  
  public void setOutput(Script.KernelID paramKernelID, Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    this.mN.setOutput(paramKernelID.mN, paramAllocation.getNObj());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptGroupThunker
 * JD-Core Version:    0.7.0.1
 */