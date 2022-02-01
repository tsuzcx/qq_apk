package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;

public class SocializeFeedsInfo$LocationInfo
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  private static LocationInfo b(feeds_info.LocationInfo paramLocationInfo)
  {
    LocationInfo localLocationInfo = new LocationInfo();
    String str;
    if (paramLocationInfo.bytes_name.has())
    {
      str = paramLocationInfo.bytes_name.get().toStringUtf8();
      localLocationInfo.jdField_a_of_type_JavaLangString = str;
      localLocationInfo.jdField_a_of_type_Int = paramLocationInfo.uint32_longitude.get();
      localLocationInfo.jdField_b_of_type_Int = paramLocationInfo.uint32_latitude.get();
      if (!paramLocationInfo.bytes_icon_url.has()) {
        break label90;
      }
    }
    label90:
    for (paramLocationInfo = paramLocationInfo.bytes_icon_url.get().toStringUtf8();; paramLocationInfo = "")
    {
      localLocationInfo.jdField_b_of_type_JavaLangString = paramLocationInfo;
      return localLocationInfo;
      str = "";
      break;
    }
  }
  
  public LocationInfo a()
  {
    try
    {
      LocationInfo localLocationInfo = (LocationInfo)super.clone();
      return localLocationInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.LocationInfo
 * JD-Core Version:    0.7.0.1
 */