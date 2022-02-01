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
    int n = this.leafChildren.size();
    int m = 0;
    int j = 0;
    int k;
    for (int i = 0; j < n; i = k)
    {
      k = i;
      if (((Atom.LeafAtom)this.leafChildren.get(j)).type == paramInt) {
        k = i + 1;
      }
      j += 1;
    }
    n = this.containerChildren.size();
    j = i;
    i = m;
    while (i < n)
    {
      k = j;
      if (((ContainerAtom)this.containerChildren.get(i)).type == paramInt) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getAtomTypeString(this.type));
    localStringBuilder.append(" leaves: ");
    localStringBuilder.append(Arrays.toString(this.leafChildren.toArray()));
    localStringBuilder.append(" containers: ");
    localStringBuilder.append(Arrays.toString(this.containerChildren.toArray()));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom
 * JD-Core Version:    0.7.0.1
 */