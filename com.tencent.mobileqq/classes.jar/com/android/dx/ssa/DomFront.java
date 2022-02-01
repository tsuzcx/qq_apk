package com.android.dx.ssa;

import com.android.dx.util.IntSet;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

public class DomFront
{
  private static boolean DEBUG = false;
  private final DomFront.DomInfo[] domInfos;
  private final SsaMethod meth;
  private final ArrayList<SsaBasicBlock> nodes;
  
  public DomFront(SsaMethod paramSsaMethod)
  {
    this.meth = paramSsaMethod;
    this.nodes = paramSsaMethod.getBlocks();
    int j = this.nodes.size();
    this.domInfos = new DomFront.DomInfo[j];
    int i = 0;
    while (i < j)
    {
      this.domInfos[i] = new DomFront.DomInfo();
      i += 1;
    }
  }
  
  private void buildDomTree()
  {
    int j = this.nodes.size();
    int i = 0;
    if (i < j)
    {
      DomFront.DomInfo localDomInfo = this.domInfos[i];
      if (localDomInfo.idom == -1) {}
      for (;;)
      {
        i += 1;
        break;
        ((SsaBasicBlock)this.nodes.get(localDomInfo.idom)).addDomChild((SsaBasicBlock)this.nodes.get(i));
      }
    }
  }
  
  private void calcDomFronts()
  {
    int m = this.nodes.size();
    int j = 0;
    while (j < m)
    {
      Object localObject = (SsaBasicBlock)this.nodes.get(j);
      DomFront.DomInfo localDomInfo1 = this.domInfos[j];
      localObject = ((SsaBasicBlock)localObject).getPredecessors();
      if (((BitSet)localObject).cardinality() > 1)
      {
        int i = ((BitSet)localObject).nextSetBit(0);
        if (i >= 0)
        {
          DomFront.DomInfo localDomInfo2;
          for (int k = i;; k = localDomInfo2.idom)
          {
            if ((k == localDomInfo1.idom) || (k == -1)) {}
            do
            {
              i = ((BitSet)localObject).nextSetBit(i + 1);
              break;
              localDomInfo2 = this.domInfos[k];
            } while (localDomInfo2.dominanceFrontiers.has(j));
            localDomInfo2.dominanceFrontiers.add(j);
          }
        }
      }
      j += 1;
    }
  }
  
  private void debugPrintDomChildren()
  {
    int k = this.nodes.size();
    int i = 0;
    while (i < k)
    {
      SsaBasicBlock localSsaBasicBlock1 = (SsaBasicBlock)this.nodes.get(i);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append('{');
      Iterator localIterator = localSsaBasicBlock1.getDomChildren().iterator();
      for (int j = 0; localIterator.hasNext(); j = 1)
      {
        SsaBasicBlock localSsaBasicBlock2 = (SsaBasicBlock)localIterator.next();
        if (j != 0) {
          localStringBuffer.append(',');
        }
        localStringBuffer.append(localSsaBasicBlock2);
      }
      localStringBuffer.append('}');
      System.out.println("domChildren[" + localSsaBasicBlock1 + "]: " + localStringBuffer);
      i += 1;
    }
  }
  
  public DomFront.DomInfo[] run()
  {
    int j = this.nodes.size();
    Object localObject;
    if (DEBUG)
    {
      i = 0;
      while (i < j)
      {
        localObject = (SsaBasicBlock)this.nodes.get(i);
        System.out.println("pred[" + i + "]: " + ((SsaBasicBlock)localObject).getPredecessors());
        i += 1;
      }
    }
    Dominators.make(this.meth, this.domInfos, false);
    if (DEBUG)
    {
      i = 0;
      while (i < j)
      {
        localObject = this.domInfos[i];
        System.out.println("idom[" + i + "]: " + ((DomFront.DomInfo)localObject).idom);
        i += 1;
      }
    }
    buildDomTree();
    if (DEBUG) {
      debugPrintDomChildren();
    }
    int i = 0;
    while (i < j)
    {
      this.domInfos[i].dominanceFrontiers = SetFactory.makeDomFrontSet(j);
      i += 1;
    }
    calcDomFronts();
    if (DEBUG)
    {
      i = 0;
      while (i < j)
      {
        System.out.println("df[" + i + "]: " + this.domInfos[i].dominanceFrontiers);
        i += 1;
      }
    }
    return this.domInfos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.DomFront
 * JD-Core Version:    0.7.0.1
 */