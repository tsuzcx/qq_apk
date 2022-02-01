package com.tencent.av.tips.data;

import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

public class HypeLinkAvTipsItem
  extends NormalAvTipsItem
{
  int g = 0;
  int h = 0;
  int i = -1;
  int j = -1;
  int k = -1;
  WeakReference<View.OnClickListener> l = null;
  
  public HypeLinkAvTipsItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, int paramInt6, View.OnClickListener paramOnClickListener)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramString);
    this.g = paramInt5;
    this.h = paramInt6;
    if (paramOnClickListener != null) {
      this.l = new WeakReference(paramOnClickListener);
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.l = new WeakReference(paramOnClickListener);
      return;
    }
    this.l = null;
  }
  
  public int h()
  {
    return this.g;
  }
  
  public int i()
  {
    return this.h;
  }
  
  public View.OnClickListener j()
  {
    WeakReference localWeakReference = this.l;
    if ((localWeakReference != null) && (!localWeakReference.isEnqueued())) {
      return (View.OnClickListener)this.l.get();
    }
    return null;
  }
  
  public int k()
  {
    return this.i;
  }
  
  public int l()
  {
    return this.j;
  }
  
  public int m()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.data.HypeLinkAvTipsItem
 * JD-Core Version:    0.7.0.1
 */