package com.tencent.lbssearch.object.param;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class SearchParam$Region
  implements SearchParam.Boundary
{
  private String a;
  private boolean b = false;
  private LatLng c;
  
  public SearchParam$Region() {}
  
  public SearchParam$Region(String paramString)
  {
    this.a = paramString;
  }
  
  public Region autoExtend(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public Region center(LatLng paramLatLng)
  {
    this.c = paramLatLng;
    return this;
  }
  
  public Region poi(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder("region(").append(this.a).append(",");
    int i;
    StringBuilder localStringBuilder;
    if (this.b)
    {
      i = 1;
      localStringBuilder = ((StringBuilder)localObject).append(i);
      if (this.c == null) {
        break label101;
      }
    }
    label101:
    for (localObject = "," + this.c.latitude + "," + this.c.longitude;; localObject = "")
    {
      return (String)localObject + ")";
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.SearchParam.Region
 * JD-Core Version:    0.7.0.1
 */