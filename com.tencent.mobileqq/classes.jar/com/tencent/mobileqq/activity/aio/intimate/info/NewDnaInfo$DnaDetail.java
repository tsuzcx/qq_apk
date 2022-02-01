package com.tencent.mobileqq.activity.aio.intimate.info;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DnaDetail;

public class NewDnaInfo$DnaDetail
{
  public int a;
  public String a;
  public int b;
  
  public static DnaDetail a(oidb_0xcf4.DnaDetail paramDnaDetail)
  {
    if ((paramDnaDetail != null) && (paramDnaDetail.has()))
    {
      DnaDetail localDnaDetail = new DnaDetail();
      if (paramDnaDetail.bytes_desc.has()) {
        localDnaDetail.jdField_a_of_type_JavaLangString = paramDnaDetail.bytes_desc.get().toStringUtf8();
      }
      if (paramDnaDetail.uint32_bold_index.has()) {
        localDnaDetail.jdField_a_of_type_Int = paramDnaDetail.uint32_bold_index.get();
      }
      if (paramDnaDetail.uint32_bold_len.has()) {
        localDnaDetail.b = paramDnaDetail.uint32_bold_len.get();
      }
      return localDnaDetail;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DnaDetail{description=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", boldIndex=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", boldLen=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo.DnaDetail
 * JD-Core Version:    0.7.0.1
 */