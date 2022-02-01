package com.tencent.map.sdk.utilities.heatmap;

import android.graphics.Color;
import java.util.HashMap;

public class Gradient
{
  public final int mColorMapSize;
  public int[] mColors;
  public float[] mStartPoints;
  
  public Gradient(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    this(paramArrayOfInt, paramArrayOfFloat, 1000);
  }
  
  public Gradient(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt)
  {
    if (paramArrayOfInt.length == paramArrayOfFloat.length)
    {
      if (paramArrayOfInt.length != 0)
      {
        int i = 1;
        while (i < paramArrayOfFloat.length) {
          if (paramArrayOfFloat[i] > paramArrayOfFloat[(i - 1)]) {
            i += 1;
          } else {
            throw new IllegalArgumentException("startPoints should be in increasing order");
          }
        }
        this.mColorMapSize = paramInt;
        this.mColors = new int[paramArrayOfInt.length];
        this.mStartPoints = new float[paramArrayOfFloat.length];
        System.arraycopy(paramArrayOfInt, 0, this.mColors, 0, paramArrayOfInt.length);
        System.arraycopy(paramArrayOfFloat, 0, this.mStartPoints, 0, paramArrayOfFloat.length);
        return;
      }
      throw new IllegalArgumentException("No colors have been defined");
    }
    paramArrayOfInt = new IllegalArgumentException("colors and startPoints should be same length");
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
  
  private static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = (int)((Color.alpha(paramInt2) - Color.alpha(paramInt1)) * paramFloat + Color.alpha(paramInt1));
    float[] arrayOfFloat1 = new float[3];
    Color.RGBToHSV(Color.red(paramInt1), Color.green(paramInt1), Color.blue(paramInt1), arrayOfFloat1);
    float[] arrayOfFloat2 = new float[3];
    Color.RGBToHSV(Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2), arrayOfFloat2);
    paramInt1 = 0;
    if (arrayOfFloat1[0] - arrayOfFloat2[0] > 180.0F) {
      arrayOfFloat2[0] += 360.0F;
    } else if (arrayOfFloat2[0] - arrayOfFloat1[0] > 180.0F) {
      arrayOfFloat1[0] += 360.0F;
    }
    float[] arrayOfFloat3 = new float[3];
    while (paramInt1 < 3)
    {
      arrayOfFloat3[paramInt1] = ((arrayOfFloat2[paramInt1] - arrayOfFloat1[paramInt1]) * paramFloat + arrayOfFloat1[paramInt1]);
      paramInt1 += 1;
    }
    return Color.HSVToColor(i, arrayOfFloat3);
  }
  
  public final int[] generateColorMap(double paramDouble)
  {
    HashMap localHashMap = new HashMap();
    Object localObject2 = this.mStartPoints;
    int k = 0;
    Object localObject1 = Integer.valueOf(0);
    if (localObject2[0] != 0.0F) {
      localHashMap.put(localObject1, new Gradient.a(this, Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0], (byte)0));
    }
    int i = 1;
    float f;
    while (i < this.mColors.length)
    {
      f = this.mColorMapSize;
      localObject2 = this.mStartPoints;
      j = i - 1;
      int m = (int)(f * localObject2[j]);
      localObject2 = this.mColors;
      int n = localObject2[j];
      int i1 = localObject2[i];
      f = this.mColorMapSize;
      localObject2 = this.mStartPoints;
      localHashMap.put(Integer.valueOf(m), new Gradient.a(this, n, i1, (localObject2[i] - localObject2[j]) * f, (byte)0));
      i += 1;
    }
    localObject2 = this.mStartPoints;
    if (localObject2[(localObject2.length - 1)] != 1.0F)
    {
      i = localObject2.length - 1;
      j = (int)(this.mColorMapSize * localObject2[i]);
      localObject2 = this.mColors;
      localHashMap.put(Integer.valueOf(j), new Gradient.a(this, localObject2[i], localObject2[i], this.mColorMapSize * (1.0F - this.mStartPoints[i]), (byte)0));
    }
    localObject2 = new int[this.mColorMapSize];
    localObject1 = (Gradient.a)localHashMap.get(localObject1);
    i = 0;
    int j = 0;
    while (i < this.mColorMapSize)
    {
      if (localHashMap.containsKey(Integer.valueOf(i)))
      {
        localObject1 = (Gradient.a)localHashMap.get(Integer.valueOf(i));
        j = i;
      }
      f = (i - j) / ((Gradient.a)localObject1).c;
      localObject2[i] = a(((Gradient.a)localObject1).a, ((Gradient.a)localObject1).b, f);
      i += 1;
    }
    if (paramDouble != 1.0D)
    {
      i = k;
      while (i < this.mColorMapSize)
      {
        j = localObject2[i];
        double d = Color.alpha(j);
        Double.isNaN(d);
        localObject2[i] = Color.argb((int)(d * paramDouble), Color.red(j), Color.green(j), Color.blue(j));
        i += 1;
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.heatmap.Gradient
 * JD-Core Version:    0.7.0.1
 */