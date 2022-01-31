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
    if (paramArrayOfInt.length != paramArrayOfFloat.length) {
      throw new IllegalArgumentException("colors and startPoints should be same length");
    }
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException("No colors have been defined");
    }
    int i = 1;
    while (i < paramArrayOfFloat.length)
    {
      if (paramArrayOfFloat[i] <= paramArrayOfFloat[(i - 1)]) {
        throw new IllegalArgumentException("startPoints should be in increasing order");
      }
      i += 1;
    }
    this.mColorMapSize = paramInt;
    this.mColors = new int[paramArrayOfInt.length];
    this.mStartPoints = new float[paramArrayOfFloat.length];
    System.arraycopy(paramArrayOfInt, 0, this.mColors, 0, paramArrayOfInt.length);
    System.arraycopy(paramArrayOfFloat, 0, this.mStartPoints, 0, paramArrayOfFloat.length);
  }
  
  private static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = 0;
    int j = (int)((Color.alpha(paramInt2) - Color.alpha(paramInt1)) * paramFloat + Color.alpha(paramInt1));
    float[] arrayOfFloat1 = new float[3];
    Color.RGBToHSV(Color.red(paramInt1), Color.green(paramInt1), Color.blue(paramInt1), arrayOfFloat1);
    float[] arrayOfFloat2 = new float[3];
    Color.RGBToHSV(Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2), arrayOfFloat2);
    if (arrayOfFloat1[0] - arrayOfFloat2[0] > 180.0F) {
      arrayOfFloat2[0] += 360.0F;
    }
    float[] arrayOfFloat3;
    for (;;)
    {
      arrayOfFloat3 = new float[3];
      paramInt1 = i;
      while (paramInt1 < 3)
      {
        arrayOfFloat3[paramInt1] = ((arrayOfFloat2[paramInt1] - arrayOfFloat1[paramInt1]) * paramFloat + arrayOfFloat1[paramInt1]);
        paramInt1 += 1;
      }
      if (arrayOfFloat2[0] - arrayOfFloat1[0] > 180.0F) {
        arrayOfFloat1[0] += 360.0F;
      }
    }
    return Color.HSVToColor(j, arrayOfFloat3);
  }
  
  public final int[] generateColorMap(double paramDouble)
  {
    int k = 0;
    HashMap localHashMap = new HashMap();
    float f;
    if (this.mStartPoints[0] != 0.0F)
    {
      i = Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0]));
      j = this.mColors[0];
      f = this.mColorMapSize;
      localHashMap.put(Integer.valueOf(0), new Gradient.a(this, i, j, this.mStartPoints[0] * f, (byte)0));
    }
    int i = 1;
    while (i < this.mColors.length)
    {
      j = (int)(this.mColorMapSize * this.mStartPoints[(i - 1)]);
      int m = this.mColors[(i - 1)];
      int n = this.mColors[i];
      f = this.mColorMapSize;
      localHashMap.put(Integer.valueOf(j), new Gradient.a(this, m, n, (this.mStartPoints[i] - this.mStartPoints[(i - 1)]) * f, (byte)0));
      i += 1;
    }
    if (this.mStartPoints[(this.mStartPoints.length - 1)] != 1.0F)
    {
      i = this.mStartPoints.length - 1;
      localHashMap.put(Integer.valueOf((int)(this.mColorMapSize * this.mStartPoints[i])), new Gradient.a(this, this.mColors[i], this.mColors[i], this.mColorMapSize * (1.0F - this.mStartPoints[i]), (byte)0));
    }
    int[] arrayOfInt = new int[this.mColorMapSize];
    Gradient.a locala = (Gradient.a)localHashMap.get(Integer.valueOf(0));
    i = 0;
    int j = 0;
    if (i < this.mColorMapSize)
    {
      if (!localHashMap.containsKey(Integer.valueOf(i))) {
        break label477;
      }
      locala = (Gradient.a)localHashMap.get(Integer.valueOf(i));
      j = i;
    }
    label477:
    for (;;)
    {
      f = (i - j) / locala.c;
      arrayOfInt[i] = a(locala.a, locala.b, f);
      i += 1;
      break;
      if (paramDouble != 1.0D)
      {
        i = k;
        while (i < this.mColorMapSize)
        {
          j = arrayOfInt[i];
          arrayOfInt[i] = Color.argb((int)(Color.alpha(j) * paramDouble), Color.red(j), Color.green(j), Color.blue(j));
          i += 1;
        }
      }
      return arrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.heatmap.Gradient
 * JD-Core Version:    0.7.0.1
 */