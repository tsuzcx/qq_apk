package com.tencent.luggage.wxa.ae;

import android.text.Layout.Alignment;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ad.a;

final class b
  extends a
  implements Comparable<b>
{
  public final int m;
  
  public b(CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    super(paramCharSequence, paramAlignment, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramFloat3, paramBoolean, paramInt4);
    this.m = paramInt5;
  }
  
  public int a(@NonNull b paramb)
  {
    int i = paramb.m;
    int j = this.m;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ae.b
 * JD-Core Version:    0.7.0.1
 */