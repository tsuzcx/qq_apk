package androidx.core.content.res;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import java.util.List;

final class GradientColorInflaterCompat$ColorStops
{
  final int[] mColors;
  final float[] mOffsets;
  
  GradientColorInflaterCompat$ColorStops(@ColorInt int paramInt1, @ColorInt int paramInt2)
  {
    this.mColors = new int[] { paramInt1, paramInt2 };
    this.mOffsets = new float[] { 0.0F, 1.0F };
  }
  
  GradientColorInflaterCompat$ColorStops(@ColorInt int paramInt1, @ColorInt int paramInt2, @ColorInt int paramInt3)
  {
    this.mColors = new int[] { paramInt1, paramInt2, paramInt3 };
    this.mOffsets = new float[] { 0.0F, 0.5F, 1.0F };
  }
  
  GradientColorInflaterCompat$ColorStops(@NonNull List<Integer> paramList, @NonNull List<Float> paramList1)
  {
    int j = paramList.size();
    this.mColors = new int[j];
    this.mOffsets = new float[j];
    int i = 0;
    while (i < j)
    {
      this.mColors[i] = ((Integer)paramList.get(i)).intValue();
      this.mOffsets[i] = ((Float)paramList1.get(i)).floatValue();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.content.res.GradientColorInflaterCompat.ColorStops
 * JD-Core Version:    0.7.0.1
 */