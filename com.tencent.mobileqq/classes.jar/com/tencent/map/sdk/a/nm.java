package com.tencent.map.sdk.a;

import java.util.ArrayList;

public abstract class nm
  implements Cloneable
{
  ArrayList<Object> a = null;
  
  public nm a()
  {
    try
    {
      nm localnm = (nm)super.clone();
      if (this.a != null)
      {
        ArrayList localArrayList = this.a;
        localnm.a = new ArrayList();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          localnm.a.add(localArrayList.get(i));
          i += 1;
        }
      }
      return localCloneNotSupportedException;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.nm
 * JD-Core Version:    0.7.0.1
 */