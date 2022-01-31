package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import java.io.Serializable;

public class SelectPositionModule$PositionData
  implements Serializable
{
  public String city = "";
  public String cityCode = "";
  public String cityGPS = "";
  public String country = "";
  public String province = "";
  
  public SelectPositionModule$PositionData() {}
  
  public SelectPositionModule$PositionData(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return;
    }
    this.country = paramSosoLocation.c;
    this.province = paramSosoLocation.d;
    if ((paramSosoLocation.e != null) && (paramSosoLocation.e.endsWith("市")))
    {
      this.city = paramSosoLocation.e.substring(0, paramSosoLocation.e.length() - 1);
      if ((paramSosoLocation.f != null) && (paramSosoLocation.f.length() > 2))
      {
        if (!paramSosoLocation.f.startsWith("11")) {
          break label151;
        }
        this.cityCode = "110000";
      }
    }
    for (;;)
    {
      this.cityGPS = paramSosoLocation.e;
      return;
      this.city = paramSosoLocation.e;
      break;
      label151:
      if (paramSosoLocation.f.startsWith("12")) {
        this.cityCode = "120000";
      } else if (paramSosoLocation.f.startsWith("31")) {
        this.cityCode = "310000";
      } else if (paramSosoLocation.f.startsWith("50")) {
        this.cityCode = "500000";
      } else {
        this.cityCode = (paramSosoLocation.f.substring(0, paramSosoLocation.f.length() - 2) + "00");
      }
    }
  }
  
  public SelectPositionModule$PositionData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.country = paramString1;
    this.province = paramString2;
    this.city = paramString3;
    this.cityCode = paramString4;
    this.cityGPS = paramString3;
  }
  
  public void copy(PositionData paramPositionData)
  {
    this.country = paramPositionData.country;
    this.province = paramPositionData.province;
    this.city = paramPositionData.city;
    this.cityCode = paramPositionData.cityCode;
    this.cityGPS = paramPositionData.cityGPS;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof PositionData)))
    {
      paramObject = (PositionData)paramObject;
      return this.cityCode.equals(paramObject.cityCode);
    }
    return false;
  }
  
  public String toString()
  {
    return "country = " + this.country + " province = " + this.province + " city = " + this.city + " citycode = " + this.cityCode + " cityGPS = " + this.cityGPS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData
 * JD-Core Version:    0.7.0.1
 */