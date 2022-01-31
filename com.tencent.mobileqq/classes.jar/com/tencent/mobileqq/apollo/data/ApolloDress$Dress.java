package com.tencent.mobileqq.apollo.data;

import java.util.ArrayList;

public class ApolloDress$Dress
  implements Cloneable
{
  public int a;
  public long a;
  public ArrayList a;
  public int b;
  public int c;
  
  protected Object clone()
  {
    Object localObject = null;
    try
    {
      Dress localDress = (Dress)super.clone();
      localObject = localDress;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
      }
    }
    if (this.a != null) {
      localObject.a = ((ArrayList)this.a.clone());
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.data.ApolloDress.Dress
 * JD-Core Version:    0.7.0.1
 */