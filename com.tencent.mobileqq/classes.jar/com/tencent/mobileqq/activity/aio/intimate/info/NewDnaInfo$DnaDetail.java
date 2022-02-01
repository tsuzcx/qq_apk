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
    Object localObject;
    if ((paramDnaDetail == null) || (!paramDnaDetail.has())) {
      localObject = null;
    }
    DnaDetail localDnaDetail;
    do
    {
      return localObject;
      localDnaDetail = new DnaDetail();
      if (paramDnaDetail.bytes_desc.has()) {
        localDnaDetail.jdField_a_of_type_JavaLangString = paramDnaDetail.bytes_desc.get().toStringUtf8();
      }
      if (paramDnaDetail.uint32_bold_index.has()) {
        localDnaDetail.jdField_a_of_type_Int = paramDnaDetail.uint32_bold_index.get();
      }
      localObject = localDnaDetail;
    } while (!paramDnaDetail.uint32_bold_len.has());
    localDnaDetail.b = paramDnaDetail.uint32_bold_len.get();
    return localDnaDetail;
  }
  
  public String toString()
  {
    return "DnaDetail{description=" + this.jdField_a_of_type_JavaLangString + ", boldIndex=" + this.jdField_a_of_type_Int + ", boldLen=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo.DnaDetail
 * JD-Core Version:    0.7.0.1
 */