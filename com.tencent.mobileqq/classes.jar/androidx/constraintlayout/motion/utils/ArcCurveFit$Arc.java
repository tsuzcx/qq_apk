package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

class ArcCurveFit$Arc
{
  private static final double EPSILON = 0.001D;
  private static final String TAG = "Arc";
  private static double[] ourPercent = new double[91];
  boolean linear;
  double mArcDistance;
  double mArcVelocity;
  double mEllipseA;
  double mEllipseB;
  double mEllipseCenterX;
  double mEllipseCenterY;
  double[] mLut;
  double mOneOverDeltaTime;
  double mTime1;
  double mTime2;
  double mTmpCosAngle;
  double mTmpSinAngle;
  boolean mVertical;
  double mX1;
  double mX2;
  double mY1;
  double mY2;
  
  ArcCurveFit$Arc(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    boolean bool = false;
    this.linear = false;
    if (paramInt == 1) {
      bool = true;
    }
    this.mVertical = bool;
    this.mTime1 = paramDouble1;
    this.mTime2 = paramDouble2;
    this.mOneOverDeltaTime = (1.0D / (this.mTime2 - this.mTime1));
    if (3 == paramInt) {
      this.linear = true;
    }
    paramDouble2 = paramDouble5 - paramDouble3;
    paramDouble1 = paramDouble6 - paramDouble4;
    if ((!this.linear) && (Math.abs(paramDouble2) >= 0.001D) && (Math.abs(paramDouble1) >= 0.001D))
    {
      this.mLut = new double[101];
      if (this.mVertical) {
        paramInt = -1;
      } else {
        paramInt = 1;
      }
      double d = paramInt;
      Double.isNaN(d);
      this.mEllipseA = (paramDouble2 * d);
      if (this.mVertical) {
        paramInt = 1;
      } else {
        paramInt = -1;
      }
      paramDouble2 = paramInt;
      Double.isNaN(paramDouble2);
      this.mEllipseB = (paramDouble1 * paramDouble2);
      if (this.mVertical) {
        paramDouble1 = paramDouble5;
      } else {
        paramDouble1 = paramDouble3;
      }
      this.mEllipseCenterX = paramDouble1;
      if (this.mVertical) {
        paramDouble1 = paramDouble4;
      } else {
        paramDouble1 = paramDouble6;
      }
      this.mEllipseCenterY = paramDouble1;
      buildTable(paramDouble3, paramDouble4, paramDouble5, paramDouble6);
      this.mArcVelocity = (this.mArcDistance * this.mOneOverDeltaTime);
      return;
    }
    this.linear = true;
    this.mX1 = paramDouble3;
    this.mX2 = paramDouble5;
    this.mY1 = paramDouble4;
    this.mY2 = paramDouble6;
    this.mArcDistance = Math.hypot(paramDouble1, paramDouble2);
    this.mArcVelocity = (this.mArcDistance * this.mOneOverDeltaTime);
    paramDouble3 = this.mTime2;
    paramDouble4 = this.mTime1;
    this.mEllipseCenterX = (paramDouble2 / (paramDouble3 - paramDouble4));
    this.mEllipseCenterY = (paramDouble1 / (paramDouble3 - paramDouble4));
  }
  
  private void buildTable(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    int i = 0;
    double d1 = 0.0D;
    double d2 = 0.0D;
    double d3 = 0.0D;
    double[] arrayOfDouble;
    for (;;)
    {
      arrayOfDouble = ourPercent;
      if (i >= arrayOfDouble.length) {
        break;
      }
      double d4 = i;
      Double.isNaN(d4);
      double d5 = arrayOfDouble.length - 1;
      Double.isNaN(d5);
      d5 = Math.toRadians(d4 * 90.0D / d5);
      d4 = Math.sin(d5);
      d5 = Math.cos(d5);
      d4 *= (paramDouble3 - paramDouble1);
      d5 *= (paramDouble2 - paramDouble4);
      if (i > 0)
      {
        d1 += Math.hypot(d4 - d2, d5 - d3);
        ourPercent[i] = d1;
      }
      i += 1;
      d3 = d5;
      d2 = d4;
    }
    this.mArcDistance = d1;
    i = 0;
    for (;;)
    {
      arrayOfDouble = ourPercent;
      if (i >= arrayOfDouble.length) {
        break;
      }
      arrayOfDouble[i] /= d1;
      i += 1;
    }
    i = 0;
    for (;;)
    {
      arrayOfDouble = this.mLut;
      if (i >= arrayOfDouble.length) {
        break;
      }
      paramDouble1 = i;
      paramDouble2 = arrayOfDouble.length - 1;
      Double.isNaN(paramDouble1);
      Double.isNaN(paramDouble2);
      paramDouble2 = paramDouble1 / paramDouble2;
      int j = Arrays.binarySearch(ourPercent, paramDouble2);
      if (j >= 0)
      {
        this.mLut[i] = (j / (ourPercent.length - 1));
      }
      else if (j == -1)
      {
        this.mLut[i] = 0.0D;
      }
      else
      {
        j = -j;
        int k = j - 2;
        paramDouble1 = k;
        arrayOfDouble = ourPercent;
        paramDouble2 = (paramDouble2 - arrayOfDouble[k]) / (arrayOfDouble[(j - 1)] - arrayOfDouble[k]);
        Double.isNaN(paramDouble1);
        paramDouble3 = arrayOfDouble.length - 1;
        Double.isNaN(paramDouble3);
        paramDouble1 = (paramDouble1 + paramDouble2) / paramDouble3;
        this.mLut[i] = paramDouble1;
      }
      i += 1;
    }
  }
  
  double getDX()
  {
    double d2 = this.mEllipseA * this.mTmpCosAngle;
    double d1 = -this.mEllipseB;
    double d3 = this.mTmpSinAngle;
    d3 = this.mArcVelocity / Math.hypot(d2, d1 * d3);
    d1 = d2;
    if (this.mVertical) {
      d1 = -d2;
    }
    return d1 * d3;
  }
  
  double getDY()
  {
    double d2 = this.mEllipseA;
    double d3 = this.mTmpCosAngle;
    double d1 = -this.mEllipseB * this.mTmpSinAngle;
    d2 = this.mArcVelocity / Math.hypot(d2 * d3, d1);
    if (this.mVertical) {
      return -d1 * d2;
    }
    return d1 * d2;
  }
  
  public double getLinearDX(double paramDouble)
  {
    return this.mEllipseCenterX;
  }
  
  public double getLinearDY(double paramDouble)
  {
    return this.mEllipseCenterY;
  }
  
  public double getLinearX(double paramDouble)
  {
    double d1 = this.mTime1;
    double d2 = this.mOneOverDeltaTime;
    double d3 = this.mX1;
    return d3 + (paramDouble - d1) * d2 * (this.mX2 - d3);
  }
  
  public double getLinearY(double paramDouble)
  {
    double d1 = this.mTime1;
    double d2 = this.mOneOverDeltaTime;
    double d3 = this.mY1;
    return d3 + (paramDouble - d1) * d2 * (this.mY2 - d3);
  }
  
  double getX()
  {
    return this.mEllipseCenterX + this.mEllipseA * this.mTmpSinAngle;
  }
  
  double getY()
  {
    return this.mEllipseCenterY + this.mEllipseB * this.mTmpCosAngle;
  }
  
  double lookup(double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    if (paramDouble >= 1.0D) {
      return 1.0D;
    }
    double[] arrayOfDouble = this.mLut;
    double d = arrayOfDouble.length - 1;
    Double.isNaN(d);
    paramDouble *= d;
    int i = (int)paramDouble;
    d = i;
    Double.isNaN(d);
    return arrayOfDouble[i] + (paramDouble - d) * (arrayOfDouble[(i + 1)] - arrayOfDouble[i]);
  }
  
  void setPoint(double paramDouble)
  {
    if (this.mVertical) {
      paramDouble = this.mTime2 - paramDouble;
    } else {
      paramDouble -= this.mTime1;
    }
    paramDouble = lookup(paramDouble * this.mOneOverDeltaTime) * 1.570796326794897D;
    this.mTmpSinAngle = Math.sin(paramDouble);
    this.mTmpCosAngle = Math.cos(paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.utils.ArcCurveFit.Arc
 * JD-Core Version:    0.7.0.1
 */