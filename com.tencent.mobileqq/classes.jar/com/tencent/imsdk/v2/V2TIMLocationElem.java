package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.LocationElement;

public class V2TIMLocationElem
  extends V2TIMElem
{
  public String getDesc()
  {
    if (getElement() == null) {
      return null;
    }
    return ((LocationElement)getElement()).getDescription();
  }
  
  public double getLatitude()
  {
    if (getElement() == null) {
      return 0.0D;
    }
    return ((LocationElement)getElement()).getLatitude();
  }
  
  public double getLongitude()
  {
    if (getElement() == null) {
      return 0.0D;
    }
    return ((LocationElement)getElement()).getLongitude();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V2TIMLocationElem--->");
    localStringBuilder.append("longitude:");
    localStringBuilder.append(getLongitude());
    localStringBuilder.append(", latitude:");
    localStringBuilder.append(getLatitude());
    localStringBuilder.append(", desc:");
    localStringBuilder.append(getDesc());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMLocationElem
 * JD-Core Version:    0.7.0.1
 */