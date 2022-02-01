package com.tencent.mobileqq.ar.arengine;

public class ARMIGObjectClassifyResult$RetrievalClassInfo
{
  public int a;
  public String b;
  public double c;
  public ARMIGObjectClassifyResult.RetrievalItem[] d;
  public int e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject = this.d;
    int i;
    if ((localObject != null) && (localObject.length > 0)) {
      i = 0;
    }
    while (i < this.d.length)
    {
      localStringBuilder.append("\n index:");
      localStringBuilder.append(i);
      localStringBuilder.append(this.d[i].toString());
      localStringBuilder.append('\n');
      i += 1;
      continue;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\n only have one itemContent:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(",prob:");
      ((StringBuilder)localObject).append(this.c);
      localStringBuilder.append(((StringBuilder)localObject).toString());
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.RetrievalClassInfo
 * JD-Core Version:    0.7.0.1
 */