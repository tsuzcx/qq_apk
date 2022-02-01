package androidx.constraintlayout.motion.utils;

class Easing$CubicEasing
  extends Easing
{
  private static double d_error = 0.0001D;
  private static double error = 0.01D;
  double x1;
  double x2;
  double y1;
  double y2;
  
  public Easing$CubicEasing(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    setup(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }
  
  Easing$CubicEasing(String paramString)
  {
    this.str = paramString;
    int i = paramString.indexOf('(');
    int j = paramString.indexOf(',', i);
    this.x1 = Double.parseDouble(paramString.substring(i + 1, j).trim());
    i = j + 1;
    j = paramString.indexOf(',', i);
    this.y1 = Double.parseDouble(paramString.substring(i, j).trim());
    i = j + 1;
    j = paramString.indexOf(',', i);
    this.x2 = Double.parseDouble(paramString.substring(i, j).trim());
    i = j + 1;
    this.y2 = Double.parseDouble(paramString.substring(i, paramString.indexOf(')', i)).trim());
  }
  
  private double getDiffX(double paramDouble)
  {
    double d1 = 1.0D - paramDouble;
    double d2 = this.x1;
    double d3 = this.x2;
    return d1 * 3.0D * d1 * d2 + d1 * 6.0D * paramDouble * (d3 - d2) + 3.0D * paramDouble * paramDouble * (1.0D - d3);
  }
  
  private double getDiffY(double paramDouble)
  {
    double d1 = 1.0D - paramDouble;
    double d2 = this.y1;
    double d3 = this.y2;
    return d1 * 3.0D * d1 * d2 + d1 * 6.0D * paramDouble * (d3 - d2) + 3.0D * paramDouble * paramDouble * (1.0D - d3);
  }
  
  private double getX(double paramDouble)
  {
    double d1 = 1.0D - paramDouble;
    double d2 = 3.0D * d1;
    return this.x1 * (d1 * d2 * paramDouble) + this.x2 * (d2 * paramDouble * paramDouble) + paramDouble * paramDouble * paramDouble;
  }
  
  private double getY(double paramDouble)
  {
    double d1 = 1.0D - paramDouble;
    double d2 = 3.0D * d1;
    return this.y1 * (d1 * d2 * paramDouble) + this.y2 * (d2 * paramDouble * paramDouble) + paramDouble * paramDouble * paramDouble;
  }
  
  public double get(double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return 0.0D;
    }
    if (paramDouble >= 1.0D) {
      return 1.0D;
    }
    double d2 = 0.5D;
    double d1 = d2;
    while (d2 > error)
    {
      d3 = getX(d1);
      d2 *= 0.5D;
      if (d3 < paramDouble) {
        d1 += d2;
      } else {
        d1 -= d2;
      }
    }
    double d4 = d1 - d2;
    double d3 = getX(d4);
    d1 += d2;
    d2 = getX(d1);
    d4 = getY(d4);
    return (getY(d1) - d4) * (paramDouble - d3) / (d2 - d3) + d4;
  }
  
  public double getDiff(double paramDouble)
  {
    double d2 = 0.5D;
    double d1 = d2;
    while (d2 > d_error)
    {
      d3 = getX(d1);
      d2 *= 0.5D;
      if (d3 < paramDouble) {
        d1 += d2;
      } else {
        d1 -= d2;
      }
    }
    double d3 = d1 - d2;
    paramDouble = getX(d3);
    d1 += d2;
    d2 = getX(d1);
    d3 = getY(d3);
    return (getY(d1) - d3) / (d2 - paramDouble);
  }
  
  void setup(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.x1 = paramDouble1;
    this.y1 = paramDouble2;
    this.x2 = paramDouble3;
    this.y2 = paramDouble4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.utils.Easing.CubicEasing
 * JD-Core Version:    0.7.0.1
 */