package com.bumptech.glide.request.target;

import android.support.annotation.NonNull;
import com.bumptech.glide.util.Util;

public abstract class SimpleTarget<Z>
  extends BaseTarget<Z>
{
  private final int a;
  private final int b;
  
  public SimpleTarget()
  {
    this(-2147483648, -2147483648);
  }
  
  public SimpleTarget(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public final void a(@NonNull SizeReadyCallback paramSizeReadyCallback)
  {
    if (Util.a(this.a, this.b))
    {
      paramSizeReadyCallback.a(this.a, this.b);
      return;
    }
    paramSizeReadyCallback = new StringBuilder();
    paramSizeReadyCallback.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
    paramSizeReadyCallback.append(this.a);
    paramSizeReadyCallback.append(" and height: ");
    paramSizeReadyCallback.append(this.b);
    paramSizeReadyCallback.append(", either provide dimensions in the constructor or call override()");
    throw new IllegalArgumentException(paramSizeReadyCallback.toString());
  }
  
  public void b(@NonNull SizeReadyCallback paramSizeReadyCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.SimpleTarget
 * JD-Core Version:    0.7.0.1
 */