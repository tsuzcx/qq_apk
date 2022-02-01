package com.android.dx.dex.code;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.InsnList;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.SourcePosition;

public final class BlockAddresses
{
  private final CodeAddress[] ends;
  private final CodeAddress[] lasts;
  private final CodeAddress[] starts;
  
  public BlockAddresses(RopMethod paramRopMethod)
  {
    int i = paramRopMethod.getBlocks().getMaxLabel();
    this.starts = new CodeAddress[i];
    this.lasts = new CodeAddress[i];
    this.ends = new CodeAddress[i];
    setupArrays(paramRopMethod);
  }
  
  private void setupArrays(RopMethod paramRopMethod)
  {
    paramRopMethod = paramRopMethod.getBlocks();
    int j = paramRopMethod.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramRopMethod.get(i);
      int k = ((BasicBlock)localObject).getLabel();
      Insn localInsn = ((BasicBlock)localObject).getInsns().get(0);
      this.starts[k] = new CodeAddress(localInsn.getPosition());
      localObject = ((BasicBlock)localObject).getLastInsn().getPosition();
      this.lasts[k] = new CodeAddress((SourcePosition)localObject);
      this.ends[k] = new CodeAddress((SourcePosition)localObject);
      i += 1;
    }
  }
  
  public CodeAddress getEnd(int paramInt)
  {
    return this.ends[paramInt];
  }
  
  public CodeAddress getEnd(BasicBlock paramBasicBlock)
  {
    return this.ends[paramBasicBlock.getLabel()];
  }
  
  public CodeAddress getLast(int paramInt)
  {
    return this.lasts[paramInt];
  }
  
  public CodeAddress getLast(BasicBlock paramBasicBlock)
  {
    return this.lasts[paramBasicBlock.getLabel()];
  }
  
  public CodeAddress getStart(int paramInt)
  {
    return this.starts[paramInt];
  }
  
  public CodeAddress getStart(BasicBlock paramBasicBlock)
  {
    return this.starts[paramBasicBlock.getLabel()];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.BlockAddresses
 * JD-Core Version:    0.7.0.1
 */