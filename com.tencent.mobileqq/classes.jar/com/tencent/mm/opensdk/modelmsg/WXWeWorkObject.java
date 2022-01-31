package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;

public class WXWeWorkObject
  implements WXMediaMessage.IMediaObject
{
  public static final int SUB_TYPE_MSG_RECORD = 1;
  private static final String TAG = "MicroMsg.SDK.WXWeWorkObject";
  public byte[] data;
  public String extInfo;
  public int subType;
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putByteArray("_wxenterprise_object_data", this.data);
    paramBundle.putString("_wxenterprise_object_extinfo", this.extInfo);
    paramBundle.putInt("_wxenterprise_object_subType", this.subType);
  }
  
  public int type()
  {
    return 49;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.data = paramBundle.getByteArray("_wxenterprise_object_data");
    this.extInfo = paramBundle.getString("_wxenterprise_object_extinfo");
    this.subType = paramBundle.getInt("_wxenterprise_object_subType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXWeWorkObject
 * JD-Core Version:    0.7.0.1
 */