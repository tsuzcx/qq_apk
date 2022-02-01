package com.tencent.mobileqq.apollo;

public abstract class IApolloRunnableTask
  implements Runnable
{
  public int a()
  {
    return hashCode();
  }
  
  public abstract String a();
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    int i = a();
    return (i == 3) || (i == 1) || (i == 2) || (i == 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.IApolloRunnableTask
 * JD-Core Version:    0.7.0.1
 */