package com.google.android.exoplayer2.extractor.mp4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class Atom$ContainerAtom
  extends Atom
{
  public final List<ContainerAtom> containerChildren;
  public final long endPosition;
  public final List<Atom.LeafAtom> leafChildren;
  
  public Atom$ContainerAtom(int paramInt, long paramLong)
  {
    super(paramInt);
    this.endPosition = paramLong;
    this.leafChildren = new ArrayList();
    this.containerChildren = new ArrayList();
  }
  
  public void add(ContainerAtom paramContainerAtom)
  {
    this.containerChildren.add(paramContainerAtom);
  }
  
  public void add(Atom.LeafAtom paramLeafAtom)
  {
    this.leafChildren.add(paramLeafAtom);
  }
  
  public int getChildAtomOfTypeCount(int paramInt)
  {
    int k = 0;
    int m = this.leafChildren.size();
    int j = 0;
    int i = 0;
    if (j < m)
    {
      if (((Atom.LeafAtom)this.leafChildren.get(j)).type != paramInt) {
        break label111;
      }
      i += 1;
    }
    label108:
    label111:
    for (;;)
    {
      j += 1;
      break;
      m = this.containerChildren.size();
      j = k;
      if (j < m)
      {
        if (((ContainerAtom)this.containerChildren.get(j)).type != paramInt) {
          break label108;
        }
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        return i;
      }
    }
  }
  
  public ContainerAtom getContainerAtomOfType(int paramInt)
  {
    int j = this.containerChildren.size();
    int i = 0;
    while (i < j)
    {
      ContainerAtom localContainerAtom = (ContainerAtom)this.containerChildren.get(i);
      if (localContainerAtom.type == paramInt) {
        return localContainerAtom;
      }
      i += 1;
    }
    return null;
  }
  
  public Atom.LeafAtom getLeafAtomOfType(int paramInt)
  {
    int j = this.leafChildren.size();
    int i = 0;
    while (i < j)
    {
      Atom.LeafAtom localLeafAtom = (Atom.LeafAtom)this.leafChildren.get(i);
      if (localLeafAtom.type == paramInt) {
        return localLeafAtom;
      }
      i += 1;
    }
    return null;
  }
  
  public String toString()
  {
    return getAtomTypeString(this.type) + " leaves: " + Arrays.toString(this.leafChildren.toArray()) + " containers: " + Arrays.toString(this.containerChildren.toArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom
 * JD-Core Version:    0.7.0.1
 */