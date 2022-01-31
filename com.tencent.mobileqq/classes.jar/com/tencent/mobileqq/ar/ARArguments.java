package com.tencent.mobileqq.ar;

import java.io.Serializable;

public class ARArguments
  implements Serializable
{
  public boolean alreadyIsTorchbearer;
  
  public ARArguments(boolean paramBoolean)
  {
    this.alreadyIsTorchbearer = paramBoolean;
  }
  
  public String toString()
  {
    return "ARArguments{alreadyIsTorchbearer =" + this.alreadyIsTorchbearer + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARArguments
 * JD-Core Version:    0.7.0.1
 */