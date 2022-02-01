package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCirclePersonEditUpdateEvent
  extends SimpleBaseEvent
{
  private String mCompany;
  private int mConstellation;
  private String mDesc;
  private int mGender;
  private String mLocation;
  private String mLocationCode;
  private String mNick;
  private String mSchool;
  
  public String getCompany()
  {
    return this.mCompany;
  }
  
  public int getConstellation()
  {
    return this.mConstellation;
  }
  
  public String getDesc()
  {
    return this.mDesc;
  }
  
  public int getGender()
  {
    return this.mGender;
  }
  
  public String getLocation()
  {
    return this.mLocation;
  }
  
  public String getLocationCode()
  {
    return this.mLocationCode;
  }
  
  public String getNick()
  {
    return this.mNick;
  }
  
  public String getSchool()
  {
    return this.mSchool;
  }
  
  public void setCompany(String paramString)
  {
    this.mCompany = paramString;
  }
  
  public void setConstellation(int paramInt)
  {
    this.mConstellation = paramInt;
  }
  
  public void setDesc(String paramString)
  {
    this.mDesc = paramString;
  }
  
  public void setGender(int paramInt)
  {
    this.mGender = paramInt;
  }
  
  public void setLocation(String paramString)
  {
    this.mLocation = paramString;
  }
  
  public void setLocationCode(String paramString)
  {
    this.mLocationCode = paramString;
  }
  
  public void setNick(String paramString)
  {
    this.mNick = paramString;
  }
  
  public void setSchool(String paramString)
  {
    this.mSchool = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCirclePersonEditUpdateEvent
 * JD-Core Version:    0.7.0.1
 */