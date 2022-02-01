package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;

public class HyperSpline
{
  double[][] mCtl;
  HyperSpline.Cubic[][] mCurve;
  double[] mCurveLength;
  int mDimensionality;
  int mPoints;
  double mTotalLength;
  
  public HyperSpline() {}
  
  public HyperSpline(double[][] paramArrayOfDouble)
  {
    setup(paramArrayOfDouble);
  }
  
  static HyperSpline.Cubic[] calcNaturalCubic(int paramInt, double[] paramArrayOfDouble)
  {
    Object localObject = new double[paramInt];
    double[] arrayOfDouble2 = new double[paramInt];
    double[] arrayOfDouble1 = new double[paramInt];
    int m = paramInt - 1;
    int i = 0;
    localObject[0] = 0.5D;
    int k = 1;
    paramInt = 1;
    while (paramInt < m)
    {
      localObject[paramInt] = (1.0D / (4.0D - localObject[(paramInt - 1)]));
      paramInt += 1;
    }
    int j = m - 1;
    localObject[m] = (1.0D / (2.0D - localObject[j]));
    arrayOfDouble2[0] = ((paramArrayOfDouble[1] - paramArrayOfDouble[0]) * 3.0D * localObject[0]);
    double d1;
    for (paramInt = k; paramInt < m; paramInt = k)
    {
      k = paramInt + 1;
      d1 = paramArrayOfDouble[k];
      int n = paramInt - 1;
      arrayOfDouble2[paramInt] = (((d1 - paramArrayOfDouble[n]) * 3.0D - arrayOfDouble2[n]) * localObject[paramInt]);
    }
    arrayOfDouble2[m] = (((paramArrayOfDouble[m] - paramArrayOfDouble[j]) * 3.0D - arrayOfDouble2[j]) * localObject[m]);
    arrayOfDouble1[m] = arrayOfDouble2[m];
    paramInt = j;
    while (paramInt >= 0)
    {
      arrayOfDouble2[paramInt] -= localObject[paramInt] * arrayOfDouble1[(paramInt + 1)];
      paramInt -= 1;
    }
    localObject = new HyperSpline.Cubic[m];
    for (paramInt = i; paramInt < m; paramInt = i)
    {
      d1 = (float)paramArrayOfDouble[paramInt];
      double d2 = arrayOfDouble1[paramInt];
      i = paramInt + 1;
      localObject[paramInt] = new HyperSpline.Cubic(d1, d2, (paramArrayOfDouble[i] - paramArrayOfDouble[paramInt]) * 3.0D - arrayOfDouble1[paramInt] * 2.0D - arrayOfDouble1[i], (paramArrayOfDouble[paramInt] - paramArrayOfDouble[i]) * 2.0D + arrayOfDouble1[paramInt] + arrayOfDouble1[i]);
    }
    return localObject;
  }
  
  public double approxLength(HyperSpline.Cubic[] paramArrayOfCubic)
  {
    int i = paramArrayOfCubic.length;
    double[] arrayOfDouble = new double[paramArrayOfCubic.length];
    double d5 = 0.0D;
    double d2 = 0.0D;
    double d3;
    double d4;
    for (double d1 = d2;; d1 = d4)
    {
      i = 0;
      int j = 0;
      d3 = d5;
      if (d2 >= 1.0D) {
        break;
      }
      d3 = 0.0D;
      i = j;
      while (i < paramArrayOfCubic.length)
      {
        d4 = arrayOfDouble[i];
        double d6 = paramArrayOfCubic[i].eval(d2);
        arrayOfDouble[i] = d6;
        d4 -= d6;
        d3 += d4 * d4;
        i += 1;
      }
      d4 = d1;
      if (d2 > 0.0D) {
        d4 = d1 + Math.sqrt(d3);
      }
      d2 += 0.1D;
    }
    while (i < paramArrayOfCubic.length)
    {
      d2 = arrayOfDouble[i];
      d4 = paramArrayOfCubic[i].eval(1.0D);
      arrayOfDouble[i] = d4;
      d2 -= d4;
      d3 += d2 * d2;
      i += 1;
    }
    return d1 + Math.sqrt(d3);
  }
  
  public double getPos(double paramDouble, int paramInt)
  {
    paramDouble *= this.mTotalLength;
    int i = 0;
    for (;;)
    {
      double[] arrayOfDouble = this.mCurveLength;
      if ((i >= arrayOfDouble.length - 1) || (arrayOfDouble[i] >= paramDouble)) {
        break;
      }
      paramDouble -= arrayOfDouble[i];
      i += 1;
    }
    return this.mCurve[paramInt][i].eval(paramDouble / this.mCurveLength[i]);
  }
  
  public void getPos(double paramDouble, double[] paramArrayOfDouble)
  {
    double d = this.mTotalLength;
    int k = 0;
    paramDouble *= d;
    int i = 0;
    int j;
    for (;;)
    {
      double[] arrayOfDouble = this.mCurveLength;
      j = k;
      if (i >= arrayOfDouble.length - 1) {
        break;
      }
      j = k;
      if (arrayOfDouble[i] >= paramDouble) {
        break;
      }
      paramDouble -= arrayOfDouble[i];
      i += 1;
    }
    while (j < paramArrayOfDouble.length)
    {
      paramArrayOfDouble[j] = this.mCurve[j][i].eval(paramDouble / this.mCurveLength[i]);
      j += 1;
    }
  }
  
  public void getPos(double paramDouble, float[] paramArrayOfFloat)
  {
    double d = this.mTotalLength;
    int k = 0;
    paramDouble *= d;
    int i = 0;
    int j;
    for (;;)
    {
      double[] arrayOfDouble = this.mCurveLength;
      j = k;
      if (i >= arrayOfDouble.length - 1) {
        break;
      }
      j = k;
      if (arrayOfDouble[i] >= paramDouble) {
        break;
      }
      paramDouble -= arrayOfDouble[i];
      i += 1;
    }
    while (j < paramArrayOfFloat.length)
    {
      paramArrayOfFloat[j] = ((float)this.mCurve[j][i].eval(paramDouble / this.mCurveLength[i]));
      j += 1;
    }
  }
  
  public void getVelocity(double paramDouble, double[] paramArrayOfDouble)
  {
    double d = this.mTotalLength;
    int k = 0;
    paramDouble *= d;
    int i = 0;
    int j;
    for (;;)
    {
      double[] arrayOfDouble = this.mCurveLength;
      j = k;
      if (i >= arrayOfDouble.length - 1) {
        break;
      }
      j = k;
      if (arrayOfDouble[i] >= paramDouble) {
        break;
      }
      paramDouble -= arrayOfDouble[i];
      i += 1;
    }
    while (j < paramArrayOfDouble.length)
    {
      paramArrayOfDouble[j] = this.mCurve[j][i].vel(paramDouble / this.mCurveLength[i]);
      j += 1;
    }
  }
  
  public void setup(double[][] paramArrayOfDouble)
  {
    this.mDimensionality = paramArrayOfDouble[0].length;
    this.mPoints = paramArrayOfDouble.length;
    this.mCtl = ((double[][])Array.newInstance(Double.TYPE, new int[] { this.mDimensionality, this.mPoints }));
    this.mCurve = new HyperSpline.Cubic[this.mDimensionality][];
    int i = 0;
    int j;
    while (i < this.mDimensionality)
    {
      j = 0;
      while (j < this.mPoints)
      {
        this.mCtl[i][j] = paramArrayOfDouble[j][i];
        j += 1;
      }
      i += 1;
    }
    i = 0;
    Object localObject;
    for (;;)
    {
      j = this.mDimensionality;
      if (i >= j) {
        break;
      }
      paramArrayOfDouble = this.mCurve;
      localObject = this.mCtl;
      paramArrayOfDouble[i] = calcNaturalCubic(localObject[i].length, localObject[i]);
      i += 1;
    }
    this.mCurveLength = new double[this.mPoints - 1];
    this.mTotalLength = 0.0D;
    paramArrayOfDouble = new HyperSpline.Cubic[j];
    i = 0;
    while (i < this.mCurveLength.length)
    {
      j = 0;
      while (j < this.mDimensionality)
      {
        paramArrayOfDouble[j] = this.mCurve[j][i];
        j += 1;
      }
      double d1 = this.mTotalLength;
      localObject = this.mCurveLength;
      double d2 = approxLength(paramArrayOfDouble);
      localObject[i] = d2;
      this.mTotalLength = (d1 + d2);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.utils.HyperSpline
 * JD-Core Version:    0.7.0.1
 */