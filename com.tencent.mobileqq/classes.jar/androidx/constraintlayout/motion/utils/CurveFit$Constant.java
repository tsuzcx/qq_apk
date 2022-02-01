package androidx.constraintlayout.motion.utils;

class CurveFit$Constant
  extends CurveFit
{
  double mTime;
  double[] mValue;
  
  CurveFit$Constant(double paramDouble, double[] paramArrayOfDouble)
  {
    this.mTime = paramDouble;
    this.mValue = paramArrayOfDouble;
  }
  
  public double getPos(double paramDouble, int paramInt)
  {
    return this.mValue[paramInt];
  }
  
  public void getPos(double paramDouble, double[] paramArrayOfDouble)
  {
    double[] arrayOfDouble = this.mValue;
    System.arraycopy(arrayOfDouble, 0, paramArrayOfDouble, 0, arrayOfDouble.length);
  }
  
  public void getPos(double paramDouble, float[] paramArrayOfFloat)
  {
    int i = 0;
    for (;;)
    {
      double[] arrayOfDouble = this.mValue;
      if (i >= arrayOfDouble.length) {
        break;
      }
      paramArrayOfFloat[i] = ((float)arrayOfDouble[i]);
      i += 1;
    }
  }
  
  public double getSlope(double paramDouble, int paramInt)
  {
    return 0.0D;
  }
  
  public void getSlope(double paramDouble, double[] paramArrayOfDouble)
  {
    int i = 0;
    while (i < this.mValue.length)
    {
      paramArrayOfDouble[i] = 0.0D;
      i += 1;
    }
  }
  
  public double[] getTimePoints()
  {
    return new double[] { this.mTime };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.utils.CurveFit.Constant
 * JD-Core Version:    0.7.0.1
 */