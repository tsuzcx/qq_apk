package com.microrapid.opencv;

public class ImageStatisticsData
{
  public double colorfulness;
  public double contrast;
  public double lightness;
  public double overexposure;
  public double saturation;
  public double sharpness;
  public double temperature;
  public double underexposure;
  public double whiteBalance;
  
  public ImageStatisticsData(double[] paramArrayOfDouble)
  {
    if ((paramArrayOfDouble != null) && (paramArrayOfDouble.length == 9))
    {
      this.lightness = paramArrayOfDouble[0];
      this.temperature = paramArrayOfDouble[1];
      this.overexposure = paramArrayOfDouble[2];
      this.underexposure = paramArrayOfDouble[3];
      this.contrast = paramArrayOfDouble[4];
      this.saturation = paramArrayOfDouble[5];
      this.sharpness = paramArrayOfDouble[6];
      this.colorfulness = paramArrayOfDouble[7];
      this.whiteBalance = paramArrayOfDouble[8];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.microrapid.opencv.ImageStatisticsData
 * JD-Core Version:    0.7.0.1
 */