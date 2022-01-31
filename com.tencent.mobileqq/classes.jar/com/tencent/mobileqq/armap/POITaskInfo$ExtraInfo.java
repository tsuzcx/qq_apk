package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.ExtraInfo;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.PoiStatus;

public class POITaskInfo$ExtraInfo
{
  public long a;
  public String a;
  public List a;
  
  public POITaskInfo$ExtraInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public static ExtraInfo a(oidb_0x7bb.ExtraInfo paramExtraInfo)
  {
    if (paramExtraInfo == null) {
      return new ExtraInfo();
    }
    ExtraInfo localExtraInfo = new ExtraInfo();
    Object localObject;
    if (paramExtraInfo.name.has())
    {
      localObject = paramExtraInfo.name.get().toStringUtf8();
      localExtraInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (!paramExtraInfo.adcode.has()) {
        break label181;
      }
    }
    label181:
    for (long l = paramExtraInfo.adcode.get();; l = 0L)
    {
      localExtraInfo.jdField_a_of_type_Long = l;
      if (!paramExtraInfo.status.has()) {
        break label186;
      }
      localExtraInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramExtraInfo = paramExtraInfo.status.get().iterator();
      while (paramExtraInfo.hasNext())
      {
        localObject = (oidb_0x7bb.PoiStatus)paramExtraInfo.next();
        POITaskInfo.POIStatus localPOIStatus = new POITaskInfo.POIStatus();
        localPOIStatus.jdField_a_of_type_Long = ((oidb_0x7bb.PoiStatus)localObject).poi_id.get();
        localPOIStatus.jdField_a_of_type_Int = ((oidb_0x7bb.PoiStatus)localObject).status.get();
        localExtraInfo.jdField_a_of_type_JavaUtilList.add(localPOIStatus);
      }
      localObject = "";
      break;
    }
    label186:
    return localExtraInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.POITaskInfo.ExtraInfo
 * JD-Core Version:    0.7.0.1
 */