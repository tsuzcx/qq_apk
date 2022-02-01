package com.android.dx.ssa.back;

import com.android.dx.ssa.BasicRegisterMapper;
import com.android.dx.ssa.RegisterMapper;
import com.android.dx.ssa.SsaMethod;

public class NullRegisterAllocator
  extends RegisterAllocator
{
  public NullRegisterAllocator(SsaMethod paramSsaMethod, InterferenceGraph paramInterferenceGraph)
  {
    super(paramSsaMethod, paramInterferenceGraph);
  }
  
  public RegisterMapper allocateRegisters()
  {
    int j = this.ssaMeth.getRegCount();
    BasicRegisterMapper localBasicRegisterMapper = new BasicRegisterMapper(j);
    int i = 0;
    while (i < j)
    {
      localBasicRegisterMapper.addMapping(i, i * 2, 2);
      i += 1;
    }
    return localBasicRegisterMapper;
  }
  
  public boolean wantsParamsMovedHigh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.NullRegisterAllocator
 * JD-Core Version:    0.7.0.1
 */