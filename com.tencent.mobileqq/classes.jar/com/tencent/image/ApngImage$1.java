package com.tencent.image;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class ApngImage$1
  extends ArrayList<WeakReference<ApngImage>>
{
  ApngImage$1(int paramInt)
  {
    super(paramInt);
  }
  
  private void ensureCapacity()
  {
    int i = size();
    if (i > 100) {
      removeRange(0, i - 100 - 1);
    }
  }
  
  public boolean add(WeakReference<ApngImage> paramWeakReference)
  {
    boolean bool = super.add(paramWeakReference);
    ensureCapacity();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.ApngImage.1
 * JD-Core Version:    0.7.0.1
 */