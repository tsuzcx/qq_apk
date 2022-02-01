package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

public class Oscillator
{
  public static final int BOUNCE = 6;
  public static final int COS_WAVE = 5;
  public static final int REVERSE_SAW_WAVE = 4;
  public static final int SAW_WAVE = 3;
  public static final int SIN_WAVE = 0;
  public static final int SQUARE_WAVE = 1;
  public static String TAG = "Oscillator";
  public static final int TRIANGLE_WAVE = 2;
  double PI2 = 6.283185307179586D;
  double[] mArea;
  private boolean mNormalized = false;
  float[] mPeriod = new float[0];
  double[] mPosition = new double[0];
  int mType;
  
  public void addPoint(double paramDouble, float paramFloat)
  {
    int k = this.mPeriod.length + 1;
    int j = Arrays.binarySearch(this.mPosition, paramDouble);
    int i = j;
    if (j < 0) {
      i = -j - 1;
    }
    this.mPosition = Arrays.copyOf(this.mPosition, k);
    this.mPeriod = Arrays.copyOf(this.mPeriod, k);
    this.mArea = new double[k];
    double[] arrayOfDouble = this.mPosition;
    System.arraycopy(arrayOfDouble, i, arrayOfDouble, i + 1, k - i - 1);
    this.mPosition[i] = paramDouble;
    this.mPeriod[i] = paramFloat;
    this.mNormalized = false;
  }
  
  double getDP(double paramDouble)
  {
    double d2 = 0.0D;
    double d1;
    if (paramDouble <= 0.0D)
    {
      d1 = 1.E-005D;
    }
    else
    {
      d1 = paramDouble;
      if (paramDouble >= 1.0D) {
        d1 = 0.999999D;
      }
    }
    int i = Arrays.binarySearch(this.mPosition, d1);
    if (i > 0) {
      return 0.0D;
    }
    paramDouble = d2;
    if (i != 0)
    {
      i = -i - 1;
      float[] arrayOfFloat = this.mPeriod;
      float f = arrayOfFloat[i];
      int j = i - 1;
      paramDouble = f - arrayOfFloat[j];
      double[] arrayOfDouble = this.mPosition;
      d2 = arrayOfDouble[i];
      double d3 = arrayOfDouble[j];
      Double.isNaN(paramDouble);
      paramDouble /= (d2 - d3);
      d2 = arrayOfFloat[j];
      d3 = arrayOfDouble[j];
      Double.isNaN(d2);
      paramDouble = d2 - paramDouble * d3 + d1 * paramDouble;
    }
    return paramDouble;
  }
  
  double getP(double paramDouble)
  {
    double d1;
    if (paramDouble < 0.0D)
    {
      d1 = 0.0D;
    }
    else
    {
      d1 = paramDouble;
      if (paramDouble > 1.0D) {
        d1 = 1.0D;
      }
    }
    int i = Arrays.binarySearch(this.mPosition, d1);
    if (i > 0) {
      return 1.0D;
    }
    if (i != 0)
    {
      i = -i - 1;
      float[] arrayOfFloat = this.mPeriod;
      float f = arrayOfFloat[i];
      int j = i - 1;
      paramDouble = f - arrayOfFloat[j];
      double[] arrayOfDouble = this.mPosition;
      double d2 = arrayOfDouble[i];
      double d3 = arrayOfDouble[j];
      Double.isNaN(paramDouble);
      paramDouble /= (d2 - d3);
      d2 = this.mArea[j];
      d3 = arrayOfFloat[j];
      double d4 = arrayOfDouble[j];
      Double.isNaN(d3);
      return d2 + (d3 - d4 * paramDouble) * (d1 - arrayOfDouble[j]) + paramDouble * (d1 * d1 - arrayOfDouble[j] * arrayOfDouble[j]) / 2.0D;
    }
    return 0.0D;
  }
  
  public double getSlope(double paramDouble)
  {
    double d2;
    double d1;
    switch (this.mType)
    {
    default: 
      d2 = this.PI2 * getDP(paramDouble);
      d1 = Math.cos(this.PI2 * getP(paramDouble));
      paramDouble = d2;
      return paramDouble * d1;
    case 6: 
      d2 = getDP(paramDouble) * 4.0D;
      d1 = (getP(paramDouble) * 4.0D + 2.0D) % 4.0D - 2.0D;
      paramDouble = d2;
    case 5: 
    case 4: 
    case 3: 
    case 2: 
      for (;;)
      {
        return paramDouble * d1;
        d1 = -this.PI2 * getDP(paramDouble);
        d2 = Math.sin(this.PI2 * getP(paramDouble));
        paramDouble = d1;
        d1 = d2;
        break;
        for (paramDouble = -getDP(paramDouble);; paramDouble = getDP(paramDouble)) {
          return paramDouble * 2.0D;
        }
        d1 = getDP(paramDouble) * 4.0D;
        d2 = Math.signum((getP(paramDouble) * 4.0D + 3.0D) % 4.0D - 2.0D);
        paramDouble = d1;
        d1 = d2;
      }
    }
    return 0.0D;
  }
  
  public double getValue(double paramDouble)
  {
    switch (this.mType)
    {
    default: 
      return Math.sin(this.PI2 * getP(paramDouble));
    case 6: 
      paramDouble = 1.0D - Math.abs(getP(paramDouble) * 4.0D % 4.0D - 2.0D);
      paramDouble *= paramDouble;
    case 5: 
    case 4: 
    case 3: 
    case 2: 
      for (;;)
      {
        return 1.0D - paramDouble;
        return Math.cos(this.PI2 * getP(paramDouble));
        paramDouble = (getP(paramDouble) * 2.0D + 1.0D) % 2.0D;
        continue;
        return (getP(paramDouble) * 2.0D + 1.0D) % 2.0D - 1.0D;
        paramDouble = Math.abs((getP(paramDouble) * 4.0D + 1.0D) % 4.0D - 2.0D);
      }
    }
    return Math.signum(0.5D - getP(paramDouble) % 1.0D);
  }
  
  public void normalize()
  {
    double d1 = 0.0D;
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = this.mPeriod;
      if (i >= localObject.length) {
        break;
      }
      d2 = localObject[i];
      Double.isNaN(d2);
      d1 += d2;
      i += 1;
    }
    double d2 = 0.0D;
    i = 1;
    int j;
    float f;
    double d3;
    double d4;
    for (;;)
    {
      localObject = this.mPeriod;
      if (i >= localObject.length) {
        break;
      }
      j = i - 1;
      f = (localObject[j] + localObject[i]) / 2.0F;
      localObject = this.mPosition;
      d3 = localObject[i];
      d4 = localObject[j];
      double d5 = f;
      Double.isNaN(d5);
      d2 += (d3 - d4) * d5;
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = this.mPeriod;
      if (i >= localObject.length) {
        break;
      }
      d3 = localObject[i];
      d4 = d1 / d2;
      Double.isNaN(d3);
      localObject[i] = ((float)(d3 * d4));
      i += 1;
    }
    this.mArea[0] = 0.0D;
    i = 1;
    for (;;)
    {
      localObject = this.mPeriod;
      if (i >= localObject.length) {
        break;
      }
      j = i - 1;
      f = (localObject[j] + localObject[i]) / 2.0F;
      localObject = this.mPosition;
      d1 = localObject[i];
      d2 = localObject[j];
      localObject = this.mArea;
      d3 = localObject[j];
      d4 = f;
      Double.isNaN(d4);
      localObject[i] = (d3 + (d1 - d2) * d4);
      i += 1;
    }
    this.mNormalized = true;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pos =");
    localStringBuilder.append(Arrays.toString(this.mPosition));
    localStringBuilder.append(" period=");
    localStringBuilder.append(Arrays.toString(this.mPeriod));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.utils.Oscillator
 * JD-Core Version:    0.7.0.1
 */