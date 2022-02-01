package com.tencent.ilivesdk.linkmicbizserviceinterface;

import java.util.HashMap;
import java.util.Map;

public class LinkMicLocationInfoNative
{
  public double a;
  public Map<Long, LinkMicLocationInfoNative.LocationItem> a;
  public double b;
  
  public LinkMicLocationInfoNative()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LinkMicLocationInfoNative{borderWidth=");
    localStringBuilder.append(this.jdField_a_of_type_Double);
    localStringBuilder.append(", borderHeight=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", userLocations=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.linkmicbizserviceinterface.LinkMicLocationInfoNative
 * JD-Core Version:    0.7.0.1
 */