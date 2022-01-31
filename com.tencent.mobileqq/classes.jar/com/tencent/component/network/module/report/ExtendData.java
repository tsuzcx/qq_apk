package com.tencent.component.network.module.report;

import android.util.SparseArray;

public class ExtendData
{
  private SparseArray a = new SparseArray(12);
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)this.a.get(0, ""));
    int i = 1;
    while (i < 12)
    {
      localStringBuilder.append("|");
      localStringBuilder.append((String)this.a.get(i, ""));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.put(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.report.ExtendData
 * JD-Core Version:    0.7.0.1
 */