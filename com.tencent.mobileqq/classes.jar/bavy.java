import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgReq;

public class bavy
  extends bawc
{
  void a(int paramInt, bawz parambawz, cmd0x352.ReqBody paramReqBody)
  {
    parambawz = (bawx)parambawz;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(parambawz.jdField_c_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_file_size.set(parambawz.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambawz.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(parambawz.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(parambawz.jdField_c_of_type_Boolean);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_bu_type.set(1);
    localTryUpImgReq.bool_pic_original.set(parambawz.b);
    localTryUpImgReq.uint32_pic_width.set(parambawz.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(parambawz.d);
    localTryUpImgReq.uint32_pic_type.set(parambawz.jdField_a_of_type_Int);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(basj.a()));
    localTryUpImgReq.bool_reject_tryfast.set(true);
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  public void a(bawo parambawo)
  {
    if ((parambawo != null) && (parambawo.jdField_a_of_type_JavaUtilList != null) && (parambawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      barh localbarh = new barh();
      localbarh.jdField_a_of_type_JavaLangString = "LongConn.ArtisticFilter";
      localbarh.jdField_a_of_type_ArrayOfByte = a(parambawo.jdField_a_of_type_JavaUtilList);
      localbarh.jdField_a_of_type_JavaLangObject = parambawo;
      localbarh.jdField_a_of_type_Barg = this;
      a(parambawo, localbarh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavy
 * JD-Core Version:    0.7.0.1
 */