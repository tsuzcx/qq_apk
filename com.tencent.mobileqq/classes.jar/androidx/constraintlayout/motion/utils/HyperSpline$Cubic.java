package androidx.constraintlayout.motion.utils;

public class HyperSpline$Cubic
{
  public static final double HALF = 0.5D;
  public static final double THIRD = 0.3333333333333333D;
  double mA;
  double mB;
  double mC;
  double mD;
  
  public HyperSpline$Cubic(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.mA = paramDouble1;
    this.mB = paramDouble2;
    this.mC = paramDouble3;
    this.mD = paramDouble4;
  }
  
  public double eval(double paramDouble)
  {
    return ((this.mD * paramDouble + this.mC) * paramDouble + this.mB) * paramDouble + this.mA;
  }
  
  public double vel(double paramDouble)
  {
    return (this.mD * 0.3333333333333333D * paramDouble + this.mC * 0.5D) * paramDouble + this.mB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.utils.HyperSpline.Cubic
 * JD-Core Version:    0.7.0.1
 */