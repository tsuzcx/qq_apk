package com.android.dx.ssa;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;

public final class Dominators
{
  private final ArrayList<SsaBasicBlock> blocks;
  private final DomFront.DomInfo[] domInfos;
  private final Dominators.DFSInfo[] info;
  private final SsaMethod meth;
  private final boolean postdom;
  private final ArrayList<SsaBasicBlock> vertex;
  
  private Dominators(SsaMethod paramSsaMethod, DomFront.DomInfo[] paramArrayOfDomInfo, boolean paramBoolean)
  {
    this.meth = paramSsaMethod;
    this.domInfos = paramArrayOfDomInfo;
    this.postdom = paramBoolean;
    this.blocks = paramSsaMethod.getBlocks();
    this.info = new Dominators.DFSInfo[this.blocks.size() + 2];
    this.vertex = new ArrayList();
  }
  
  private void compress(SsaBasicBlock paramSsaBasicBlock)
  {
    Object localObject = this.info[paramSsaBasicBlock.getIndex()];
    if (this.info[localObject.ancestor.getIndex()].ancestor != null)
    {
      localObject = new ArrayList();
      HashSet localHashSet = new HashSet();
      ((ArrayList)localObject).add(paramSsaBasicBlock);
      while (!((ArrayList)localObject).isEmpty())
      {
        int i = ((ArrayList)localObject).size();
        paramSsaBasicBlock = (SsaBasicBlock)((ArrayList)localObject).get(i - 1);
        paramSsaBasicBlock = this.info[paramSsaBasicBlock.getIndex()];
        SsaBasicBlock localSsaBasicBlock1 = paramSsaBasicBlock.ancestor;
        Dominators.DFSInfo localDFSInfo = this.info[localSsaBasicBlock1.getIndex()];
        if ((localHashSet.add(localSsaBasicBlock1)) && (localDFSInfo.ancestor != null))
        {
          ((ArrayList)localObject).add(localSsaBasicBlock1);
        }
        else
        {
          ((ArrayList)localObject).remove(i - 1);
          if (localDFSInfo.ancestor != null)
          {
            localSsaBasicBlock1 = localDFSInfo.rep;
            SsaBasicBlock localSsaBasicBlock2 = paramSsaBasicBlock.rep;
            if (this.info[localSsaBasicBlock1.getIndex()].semidom < this.info[localSsaBasicBlock2.getIndex()].semidom) {
              paramSsaBasicBlock.rep = localSsaBasicBlock1;
            }
            paramSsaBasicBlock.ancestor = localDFSInfo.ancestor;
          }
        }
      }
    }
  }
  
  private SsaBasicBlock eval(SsaBasicBlock paramSsaBasicBlock)
  {
    Dominators.DFSInfo localDFSInfo = this.info[paramSsaBasicBlock.getIndex()];
    if (localDFSInfo.ancestor == null) {
      return paramSsaBasicBlock;
    }
    compress(paramSsaBasicBlock);
    return localDFSInfo.rep;
  }
  
  private BitSet getPreds(SsaBasicBlock paramSsaBasicBlock)
  {
    if (this.postdom) {
      return paramSsaBasicBlock.getSuccessors();
    }
    return paramSsaBasicBlock.getPredecessors();
  }
  
  private BitSet getSuccs(SsaBasicBlock paramSsaBasicBlock)
  {
    if (this.postdom) {
      return paramSsaBasicBlock.getPredecessors();
    }
    return paramSsaBasicBlock.getSuccessors();
  }
  
  public static Dominators make(SsaMethod paramSsaMethod, DomFront.DomInfo[] paramArrayOfDomInfo, boolean paramBoolean)
  {
    paramSsaMethod = new Dominators(paramSsaMethod, paramArrayOfDomInfo, paramBoolean);
    paramSsaMethod.run();
    return paramSsaMethod;
  }
  
  private void run()
  {
    int m = 2;
    Object localObject1;
    int k;
    int i;
    if (this.postdom)
    {
      localObject1 = this.meth.getExitBlock();
      if (localObject1 != null)
      {
        this.vertex.add(localObject1);
        this.domInfos[localObject1.getIndex()].idom = ((SsaBasicBlock)localObject1).getIndex();
      }
      localObject1 = new Dominators.DfsWalker(this, null);
      this.meth.forEachBlockDepthFirst(this.postdom, (SsaBasicBlock.Visitor)localObject1);
      k = this.vertex.size() - 1;
      i = k;
    }
    int j;
    for (;;)
    {
      j = m;
      if (i < 2) {
        break label400;
      }
      Object localObject2 = (SsaBasicBlock)this.vertex.get(i);
      localObject1 = this.info[localObject2.getIndex()];
      Object localObject3 = getPreds((SsaBasicBlock)localObject2);
      j = ((BitSet)localObject3).nextSetBit(0);
      SsaBasicBlock localSsaBasicBlock;
      for (;;)
      {
        if (j >= 0)
        {
          localSsaBasicBlock = (SsaBasicBlock)this.blocks.get(j);
          if (this.info[localSsaBasicBlock.getIndex()] != null)
          {
            int n = this.info[eval(localSsaBasicBlock).getIndex()].semidom;
            if (n < ((Dominators.DFSInfo)localObject1).semidom) {
              ((Dominators.DFSInfo)localObject1).semidom = n;
            }
          }
          j = ((BitSet)localObject3).nextSetBit(j + 1);
          continue;
          localObject1 = this.meth.getEntryBlock();
          break;
        }
      }
      this.info[((SsaBasicBlock)this.vertex.get(localObject1.semidom)).getIndex()].bucket.add(localObject2);
      ((Dominators.DFSInfo)localObject1).ancestor = ((Dominators.DFSInfo)localObject1).parent;
      localObject2 = this.info[localObject1.parent.getIndex()].bucket;
      while (!((ArrayList)localObject2).isEmpty())
      {
        localObject3 = (SsaBasicBlock)((ArrayList)localObject2).remove(((ArrayList)localObject2).size() - 1);
        localSsaBasicBlock = eval((SsaBasicBlock)localObject3);
        if (this.info[localSsaBasicBlock.getIndex()].semidom < this.info[localObject3.getIndex()].semidom) {
          this.domInfos[localObject3.getIndex()].idom = localSsaBasicBlock.getIndex();
        } else {
          this.domInfos[localObject3.getIndex()].idom = ((Dominators.DFSInfo)localObject1).parent.getIndex();
        }
      }
      i -= 1;
    }
    label400:
    while (j <= k)
    {
      localObject1 = (SsaBasicBlock)this.vertex.get(j);
      if (this.domInfos[localObject1.getIndex()].idom != ((SsaBasicBlock)this.vertex.get(this.info[localObject1.getIndex()].semidom)).getIndex()) {
        this.domInfos[localObject1.getIndex()].idom = this.domInfos[this.domInfos[localObject1.getIndex()].idom].idom;
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.Dominators
 * JD-Core Version:    0.7.0.1
 */