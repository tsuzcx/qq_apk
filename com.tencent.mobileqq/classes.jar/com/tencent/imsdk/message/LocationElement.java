package com.tencent.imsdk.message;

public class LocationElement
  extends MessageBaseElement
{
  private String description;
  private double latitude;
  private double longitude;
  
  public LocationElement()
  {
    setElementType(7);
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setLatitude(double paramDouble)
  {
    this.latitude = paramDouble;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.longitude = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.LocationElement
 * JD-Core Version:    0.7.0.1
 */