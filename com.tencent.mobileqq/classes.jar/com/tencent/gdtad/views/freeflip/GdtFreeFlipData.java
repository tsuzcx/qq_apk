package com.tencent.gdtad.views.freeflip;

import android.text.TextUtils;
import java.io.Serializable;

public class GdtFreeFlipData
  implements Serializable
{
  public static int TYPE_CIRCLE = 1;
  public static int TYPE_UNKNOWN;
  public int height;
  public GdtFreeFlipData.OneWay oneWayImageUrl;
  public int range;
  public GdtFreeFlipData.RoundTrip roundTripImageUrl;
  public int type = TYPE_UNKNOWN;
  public int width;
  public int y1;
  public int y2;
  
  public int getRange()
  {
    if (this.y2 - this.y1 < this.range) {
      return this.y2 - this.y1;
    }
    return this.range;
  }
  
  public boolean isOneWay()
  {
    return (this.oneWayImageUrl != null) && (!TextUtils.isEmpty(this.oneWayImageUrl.url));
  }
  
  public boolean isRoundTrip()
  {
    return (this.roundTripImageUrl != null) && (!TextUtils.isEmpty(this.roundTripImageUrl.urlTop)) && (!TextUtils.isEmpty(this.roundTripImageUrl.urlBottom));
  }
  
  public boolean isValid()
  {
    return (this.type != TYPE_UNKNOWN) && (this.width > 0) && (this.height > 0) && (getRange() > 0) && (this.y2 > this.y1) && (this.y1 >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.freeflip.GdtFreeFlipData
 * JD-Core Version:    0.7.0.1
 */