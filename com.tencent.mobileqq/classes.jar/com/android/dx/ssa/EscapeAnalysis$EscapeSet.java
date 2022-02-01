package com.android.dx.ssa;

import java.util.ArrayList;
import java.util.BitSet;

class EscapeAnalysis$EscapeSet
{
  ArrayList<EscapeSet> childSets;
  EscapeAnalysis.EscapeState escape;
  ArrayList<EscapeSet> parentSets;
  BitSet regSet;
  boolean replaceableArray;
  
  EscapeAnalysis$EscapeSet(int paramInt1, int paramInt2, EscapeAnalysis.EscapeState paramEscapeState)
  {
    this.regSet = new BitSet(paramInt2);
    this.regSet.set(paramInt1);
    this.escape = paramEscapeState;
    this.childSets = new ArrayList();
    this.parentSets = new ArrayList();
    this.replaceableArray = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.EscapeAnalysis.EscapeSet
 * JD-Core Version:    0.7.0.1
 */