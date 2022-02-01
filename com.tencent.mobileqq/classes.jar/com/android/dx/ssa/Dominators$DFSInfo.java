package com.android.dx.ssa;

import java.util.ArrayList;

final class Dominators$DFSInfo
{
  public SsaBasicBlock ancestor;
  public ArrayList<SsaBasicBlock> bucket = new ArrayList();
  public SsaBasicBlock parent;
  public SsaBasicBlock rep;
  public int semidom;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.Dominators.DFSInfo
 * JD-Core Version:    0.7.0.1
 */