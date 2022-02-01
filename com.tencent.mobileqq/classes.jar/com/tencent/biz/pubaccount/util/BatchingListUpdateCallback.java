package com.tencent.biz.pubaccount.util;

public class BatchingListUpdateCallback
  implements ListUpdateCallback
{
  final ListUpdateCallback a;
  int b = 0;
  int c = -1;
  int d = -1;
  Object e = null;
  
  public BatchingListUpdateCallback(ListUpdateCallback paramListUpdateCallback)
  {
    this.a = paramListUpdateCallback;
  }
  
  public void a()
  {
    int i = this.b;
    if (i == 0) {
      return;
    }
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          this.a.a(this.c, this.d, this.e);
        }
      }
      else {
        this.a.b(this.c, this.d);
      }
    }
    else {
      this.a.a(this.c, this.d);
    }
    this.e = null;
    this.b = 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.b == 1)
    {
      int i = this.c;
      if (paramInt1 >= i)
      {
        int j = this.d;
        if (paramInt1 <= i + j)
        {
          this.d = (j + paramInt2);
          this.c = Math.min(paramInt1, i);
          return;
        }
      }
    }
    a();
    this.c = paramInt1;
    this.d = paramInt2;
    this.b = 1;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.b == 3)
    {
      int i = this.c;
      int j = this.d;
      if (paramInt1 <= i + j)
      {
        int k = paramInt1 + paramInt2;
        if ((k >= i) && (this.e == paramObject))
        {
          this.c = Math.min(paramInt1, i);
          this.d = (Math.max(j + i, k) - this.c);
          return;
        }
      }
    }
    a();
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramObject;
    this.b = 3;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.b == 2)
    {
      int i = this.c;
      if ((i >= paramInt1) && (i <= paramInt1 + paramInt2))
      {
        this.d += paramInt2;
        this.c = paramInt1;
        return;
      }
    }
    a();
    this.c = paramInt1;
    this.d = paramInt2;
    this.b = 2;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a();
    this.a.c(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.BatchingListUpdateCallback
 * JD-Core Version:    0.7.0.1
 */