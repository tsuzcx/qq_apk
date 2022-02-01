package androidx.constraintlayout.motion.utils;

import android.util.Log;
import java.util.Arrays;

public class Easing
{
  private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
  private static final String ACCELERATE_NAME = "accelerate";
  private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
  private static final String DECELERATE_NAME = "decelerate";
  private static final String LINEAR = "cubic(1, 1, 0, 0)";
  private static final String LINEAR_NAME = "linear";
  public static String[] NAMED_EASING = { "standard", "accelerate", "decelerate", "linear" };
  private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
  private static final String STANDARD_NAME = "standard";
  static Easing sDefault = new Easing();
  String str = "identity";
  
  public static Easing getInterpolator(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("cubic")) {
      return new Easing.CubicEasing(paramString);
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1312628413: 
      if (paramString.equals("standard")) {
        i = 0;
      }
      break;
    case -1102672091: 
      if (paramString.equals("linear")) {
        i = 3;
      }
      break;
    case -1263948740: 
      if (paramString.equals("decelerate")) {
        i = 2;
      }
      break;
    case -1354466595: 
      if (paramString.equals("accelerate")) {
        i = 1;
      }
      break;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            paramString = new StringBuilder();
            paramString.append("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or ");
            paramString.append(Arrays.toString(NAMED_EASING));
            Log.e("ConstraintSet", paramString.toString());
            return sDefault;
          }
          return new Easing.CubicEasing("cubic(1, 1, 0, 0)");
        }
        return new Easing.CubicEasing("cubic(0.0, 0.0, 0.2, 0.95)");
      }
      return new Easing.CubicEasing("cubic(0.4, 0.05, 0.8, 0.7)");
    }
    return new Easing.CubicEasing("cubic(0.4, 0.0, 0.2, 1)");
  }
  
  public double get(double paramDouble)
  {
    return paramDouble;
  }
  
  public double getDiff(double paramDouble)
  {
    return 1.0D;
  }
  
  public String toString()
  {
    return this.str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.utils.Easing
 * JD-Core Version:    0.7.0.1
 */