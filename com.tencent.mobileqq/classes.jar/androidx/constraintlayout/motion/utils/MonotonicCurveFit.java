package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;

public class MonotonicCurveFit
  extends CurveFit
{
  private static final String TAG = "MonotonicCurveFit";
  private double[] mT;
  private double[][] mTangent;
  private double[][] mY;
  
  public MonotonicCurveFit(double[] paramArrayOfDouble, double[][] paramArrayOfDouble1)
  {
    int i1 = paramArrayOfDouble.length;
    int m = paramArrayOfDouble1[0].length;
    int n = i1 - 1;
    double[][] arrayOfDouble1 = (double[][])Array.newInstance(Double.TYPE, new int[] { n, m });
    double[][] arrayOfDouble2 = (double[][])Array.newInstance(Double.TYPE, new int[] { i1, m });
    int i = 0;
    int j;
    int k;
    double d1;
    double d2;
    while (i < m)
    {
      for (j = 0; j < n; j = k)
      {
        k = j + 1;
        d1 = paramArrayOfDouble[k];
        d2 = paramArrayOfDouble[j];
        arrayOfDouble1[j][i] = ((paramArrayOfDouble1[k][i] - paramArrayOfDouble1[j][i]) / (d1 - d2));
        if (j == 0) {
          arrayOfDouble2[j][i] = arrayOfDouble1[j][i];
        } else {
          arrayOfDouble2[j][i] = ((arrayOfDouble1[(j - 1)][i] + arrayOfDouble1[j][i]) * 0.5D);
        }
      }
      arrayOfDouble2[n][i] = arrayOfDouble1[(i1 - 2)][i];
      i += 1;
    }
    i = 0;
    while (i < n)
    {
      j = 0;
      while (j < m)
      {
        if (arrayOfDouble1[i][j] == 0.0D)
        {
          arrayOfDouble2[i][j] = 0L;
          arrayOfDouble2[(i + 1)][j] = 0L;
        }
        else
        {
          d1 = arrayOfDouble2[i][j] / arrayOfDouble1[i][j];
          k = i + 1;
          d2 = arrayOfDouble2[k][j] / arrayOfDouble1[i][j];
          double d3 = Math.hypot(d1, d2);
          if (d3 > 9.0D)
          {
            d3 = 3.0D / d3;
            arrayOfDouble2[i][j] = (d1 * d3 * arrayOfDouble1[i][j]);
            arrayOfDouble2[k][j] = (d3 * d2 * arrayOfDouble1[i][j]);
          }
        }
        j += 1;
      }
      i += 1;
    }
    this.mT = paramArrayOfDouble;
    this.mY = paramArrayOfDouble1;
    this.mTangent = arrayOfDouble2;
  }
  
  private static double diff(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    double d1 = paramDouble2 * paramDouble2;
    double d2 = paramDouble2 * 6.0D;
    double d3 = 3.0D * paramDouble1;
    return -6.0D * d1 * paramDouble4 + d2 * paramDouble4 + 6.0D * d1 * paramDouble3 - d2 * paramDouble3 + d3 * paramDouble6 * d1 + d3 * paramDouble5 * d1 - 2.0D * paramDouble1 * paramDouble6 * paramDouble2 - 4.0D * paramDouble1 * paramDouble5 * paramDouble2 + paramDouble1 * paramDouble5;
  }
  
  private static double interpolate(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    double d1 = paramDouble2 * paramDouble2;
    double d2 = d1 * paramDouble2;
    double d3 = 3.0D * d1;
    paramDouble6 = paramDouble1 * paramDouble6;
    double d4 = paramDouble1 * paramDouble5;
    return -2.0D * d2 * paramDouble4 + d3 * paramDouble4 + d2 * 2.0D * paramDouble3 - d3 * paramDouble3 + paramDouble3 + paramDouble6 * d2 + d2 * d4 - paramDouble6 * d1 - paramDouble1 * 2.0D * paramDouble5 * d1 + d4 * paramDouble2;
  }
  
  public double getPos(double paramDouble, int paramInt)
  {
    Object localObject = this.mT;
    int j = localObject.length;
    int i = 0;
    if (paramDouble <= localObject[0]) {
      return this.mY[0][paramInt];
    }
    int k = j - 1;
    if (paramDouble >= localObject[k]) {
      return this.mY[k][paramInt];
    }
    while (i < k)
    {
      localObject = this.mT;
      if (paramDouble == localObject[i]) {
        return this.mY[i][paramInt];
      }
      j = i + 1;
      if (paramDouble < localObject[j])
      {
        double d1 = localObject[j] - localObject[i];
        paramDouble = (paramDouble - localObject[i]) / d1;
        localObject = this.mY;
        double d2 = localObject[i][paramInt];
        double d3 = localObject[j][paramInt];
        localObject = this.mTangent;
        return interpolate(d1, paramDouble, d2, d3, localObject[i][paramInt], localObject[j][paramInt]);
      }
      i = j;
    }
    return 0.0D;
  }
  
  public void getPos(double paramDouble, double[] paramArrayOfDouble)
  {
    Object localObject = this.mT;
    int j = localObject.length;
    double[][] arrayOfDouble = this.mY;
    int k = 0;
    int i = 0;
    int n = arrayOfDouble[0].length;
    if (paramDouble <= localObject[0])
    {
      i = 0;
      while (i < n)
      {
        paramArrayOfDouble[i] = this.mY[0][i];
        i += 1;
      }
      return;
    }
    int i1 = j - 1;
    if (paramDouble >= localObject[i1])
    {
      while (i < n)
      {
        paramArrayOfDouble[i] = this.mY[i1][i];
        i += 1;
      }
      return;
    }
    int m;
    for (i = 0; i < i1; i = m)
    {
      if (paramDouble == this.mT[i])
      {
        j = 0;
        while (j < n)
        {
          paramArrayOfDouble[j] = this.mY[i][j];
          j += 1;
        }
      }
      localObject = this.mT;
      m = i + 1;
      if (paramDouble < localObject[m])
      {
        double d1 = localObject[m] - localObject[i];
        paramDouble = (paramDouble - localObject[i]) / d1;
        j = k;
        while (j < n)
        {
          localObject = this.mY;
          double d2 = localObject[i][j];
          double d3 = localObject[m][j];
          localObject = this.mTangent;
          paramArrayOfDouble[j] = interpolate(d1, paramDouble, d2, d3, localObject[i][j], localObject[m][j]);
          j += 1;
        }
        return;
      }
    }
  }
  
  public void getPos(double paramDouble, float[] paramArrayOfFloat)
  {
    Object localObject = this.mT;
    int j = localObject.length;
    double[][] arrayOfDouble = this.mY;
    int k = 0;
    int i = 0;
    int n = arrayOfDouble[0].length;
    if (paramDouble <= localObject[0])
    {
      i = 0;
      while (i < n)
      {
        paramArrayOfFloat[i] = ((float)this.mY[0][i]);
        i += 1;
      }
      return;
    }
    int i1 = j - 1;
    if (paramDouble >= localObject[i1])
    {
      while (i < n)
      {
        paramArrayOfFloat[i] = ((float)this.mY[i1][i]);
        i += 1;
      }
      return;
    }
    int m;
    for (i = 0; i < i1; i = m)
    {
      if (paramDouble == this.mT[i])
      {
        j = 0;
        while (j < n)
        {
          paramArrayOfFloat[j] = ((float)this.mY[i][j]);
          j += 1;
        }
      }
      localObject = this.mT;
      m = i + 1;
      if (paramDouble < localObject[m])
      {
        double d1 = localObject[m] - localObject[i];
        paramDouble = (paramDouble - localObject[i]) / d1;
        j = k;
        while (j < n)
        {
          localObject = this.mY;
          double d2 = localObject[i][j];
          double d3 = localObject[m][j];
          localObject = this.mTangent;
          paramArrayOfFloat[j] = ((float)interpolate(d1, paramDouble, d2, d3, localObject[i][j], localObject[m][j]));
          j += 1;
        }
        return;
      }
    }
  }
  
  public double getSlope(double paramDouble, int paramInt)
  {
    Object localObject = this.mT;
    int k = localObject.length;
    int i = 0;
    int j;
    if (paramDouble < localObject[0])
    {
      paramDouble = localObject[0];
    }
    else
    {
      j = k - 1;
      if (paramDouble >= localObject[j]) {
        paramDouble = localObject[j];
      }
    }
    while (i < k - 1)
    {
      localObject = this.mT;
      j = i + 1;
      if (paramDouble <= localObject[j])
      {
        double d1 = localObject[j] - localObject[i];
        paramDouble = (paramDouble - localObject[i]) / d1;
        localObject = this.mY;
        double d2 = localObject[i][paramInt];
        double d3 = localObject[j][paramInt];
        localObject = this.mTangent;
        return diff(d1, paramDouble, d2, d3, localObject[i][paramInt], localObject[j][paramInt]) / d1;
      }
      i = j;
    }
    return 0.0D;
  }
  
  public void getSlope(double paramDouble, double[] paramArrayOfDouble)
  {
    Object localObject = this.mT;
    int n = localObject.length;
    double[][] arrayOfDouble = this.mY;
    int j = 0;
    int m = arrayOfDouble[0].length;
    if (paramDouble <= localObject[0])
    {
      paramDouble = localObject[0];
    }
    else
    {
      i = n - 1;
      if (paramDouble >= localObject[i]) {
        paramDouble = localObject[i];
      }
    }
    int k;
    for (int i = 0; i < n - 1; i = k)
    {
      localObject = this.mT;
      k = i + 1;
      if (paramDouble <= localObject[k])
      {
        double d1 = localObject[k] - localObject[i];
        paramDouble = (paramDouble - localObject[i]) / d1;
        while (j < m)
        {
          localObject = this.mY;
          double d2 = localObject[i][j];
          double d3 = localObject[k][j];
          localObject = this.mTangent;
          paramArrayOfDouble[j] = (diff(d1, paramDouble, d2, d3, localObject[i][j], localObject[k][j]) / d1);
          j += 1;
        }
      }
    }
  }
  
  public double[] getTimePoints()
  {
    return this.mT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.utils.MonotonicCurveFit
 * JD-Core Version:    0.7.0.1
 */