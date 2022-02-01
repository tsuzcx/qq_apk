package com.tencent.liteav.basic.structs;

public class a
  implements Cloneable
{
  public int a;
  public int b;
  public int c;
  public int d;
  public long e;
  public byte[] f;
  public int g;
  public int h;
  
  public Object clone()
  {
    try
    {
      a locala = (a)super.clone();
      return locala;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.structs.a
 * JD-Core Version:    0.7.0.1
 */