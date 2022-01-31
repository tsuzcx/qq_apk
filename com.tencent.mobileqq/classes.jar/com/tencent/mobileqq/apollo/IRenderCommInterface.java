package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.task.OnDressDoneListener;

public abstract interface IRenderCommInterface
{
  public abstract int a(int paramInt1, String paramString, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract int a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3);
  
  public abstract int a(int paramInt, String paramString, int[] paramArrayOfInt, OnDressDoneListener paramOnDressDoneListener);
  
  public abstract void a(int paramInt, String paramString1, String paramString2);
  
  public abstract int b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.IRenderCommInterface
 * JD-Core Version:    0.7.0.1
 */