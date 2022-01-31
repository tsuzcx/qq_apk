package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;

public class WXLocationObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXLocationObject";
  public double lat;
  public double lng;
  
  public WXLocationObject()
  {
    this(0.0D, 0.0D);
  }
  
  public WXLocationObject(double paramDouble1, double paramDouble2)
  {
    this.lat = paramDouble1;
    this.lng = paramDouble2;
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putDouble("_wxlocationobject_lat", this.lat);
    paramBundle.putDouble("_wxlocationobject_lng", this.lng);
  }
  
  public int type()
  {
    return 30;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.lat = paramBundle.getDouble("_wxlocationobject_lat");
    this.lng = paramBundle.getDouble("_wxlocationobject_lng");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXLocationObject
 * JD-Core Version:    0.7.0.1
 */