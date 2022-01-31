package com.tencent.component.animation.rebound;

public class SpringConfig
{
  public static SpringConfig defaultConfig = fromOrigamiTensionAndFriction(40.0D, 7.0D);
  public double friction;
  public double tension;
  
  public SpringConfig(double paramDouble1, double paramDouble2)
  {
    this.tension = paramDouble1;
    this.friction = paramDouble2;
  }
  
  public static SpringConfig fromBouncinessAndSpeed(double paramDouble1, double paramDouble2)
  {
    BouncyConversion localBouncyConversion = new BouncyConversion(paramDouble2, paramDouble1);
    return fromOrigamiTensionAndFriction(localBouncyConversion.getBouncyTension(), localBouncyConversion.getBouncyFriction());
  }
  
  public static SpringConfig fromOrigamiTensionAndFriction(double paramDouble1, double paramDouble2)
  {
    return new SpringConfig(OrigamiValueConverter.tensionFromOrigamiValue(paramDouble1), OrigamiValueConverter.frictionFromOrigamiValue(paramDouble2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.animation.rebound.SpringConfig
 * JD-Core Version:    0.7.0.1
 */