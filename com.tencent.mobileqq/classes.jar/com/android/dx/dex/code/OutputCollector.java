package com.android.dx.dex.code;

import com.android.dx.dex.DexOptions;
import java.util.ArrayList;

public final class OutputCollector
{
  private final OutputFinisher finisher;
  private ArrayList<DalvInsn> suffix;
  
  public OutputCollector(DexOptions paramDexOptions, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.finisher = new OutputFinisher(paramDexOptions, paramInt1, paramInt3, paramInt4);
    this.suffix = new ArrayList(paramInt2);
  }
  
  private void appendSuffixToOutput()
  {
    int j = this.suffix.size();
    int i = 0;
    while (i < j)
    {
      this.finisher.add((DalvInsn)this.suffix.get(i));
      i += 1;
    }
    this.suffix = null;
  }
  
  public void add(DalvInsn paramDalvInsn)
  {
    this.finisher.add(paramDalvInsn);
  }
  
  public void addSuffix(DalvInsn paramDalvInsn)
  {
    this.suffix.add(paramDalvInsn);
  }
  
  public OutputFinisher getFinisher()
  {
    if (this.suffix == null) {
      throw new UnsupportedOperationException("already processed");
    }
    appendSuffixToOutput();
    return this.finisher;
  }
  
  public void reverseBranch(int paramInt, CodeAddress paramCodeAddress)
  {
    this.finisher.reverseBranch(paramInt, paramCodeAddress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.OutputCollector
 * JD-Core Version:    0.7.0.1
 */