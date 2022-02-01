package androidx.constraintlayout.motion.utils;

public abstract class CurveFit
{
  public static final int CONSTANT = 2;
  public static final int LINEAR = 1;
  public static final int SPLINE = 0;
  
  public static CurveFit get(int paramInt, double[] paramArrayOfDouble, double[][] paramArrayOfDouble1)
  {
    if (paramArrayOfDouble.length == 1) {
      paramInt = 2;
    }
    if (paramInt != 0)
    {
      if (paramInt != 2) {
        return new LinearCurveFit(paramArrayOfDouble, paramArrayOfDouble1);
      }
      return new CurveFit.Constant(paramArrayOfDouble[0], paramArrayOfDouble1[0]);
    }
    return new MonotonicCurveFit(paramArrayOfDouble, paramArrayOfDouble1);
  }
  
  public static CurveFit getArc(int[] paramArrayOfInt, double[] paramArrayOfDouble, double[][] paramArrayOfDouble1)
  {
    return new ArcCurveFit(paramArrayOfInt, paramArrayOfDouble, paramArrayOfDouble1);
  }
  
  public abstract double getPos(double paramDouble, int paramInt);
  
  public abstract void getPos(double paramDouble, double[] paramArrayOfDouble);
  
  public abstract void getPos(double paramDouble, float[] paramArrayOfFloat);
  
  public abstract double getSlope(double paramDouble, int paramInt);
  
  public abstract void getSlope(double paramDouble, double[] paramArrayOfDouble);
  
  public abstract double[] getTimePoints();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.utils.CurveFit
 * JD-Core Version:    0.7.0.1
 */