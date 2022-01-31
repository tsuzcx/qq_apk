import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgReq;

public class axxq
  extends axxu
{
  void a(int paramInt, axyr paramaxyr, cmd0x352.ReqBody paramReqBody)
  {
    paramaxyr = (axyp)paramaxyr;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(paramaxyr.jdField_c_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_file_size.set(paramaxyr.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramaxyr.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramaxyr.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(paramaxyr.jdField_c_of_type_Boolean);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_bu_type.set(1);
    localTryUpImgReq.bool_pic_original.set(paramaxyr.b);
    localTryUpImgReq.uint32_pic_width.set(paramaxyr.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(paramaxyr.d);
    localTryUpImgReq.uint32_pic_type.set(paramaxyr.jdField_a_of_type_Int);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(axub.a()));
    localTryUpImgReq.bool_reject_tryfast.set(true);
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  public void a(axyg paramaxyg)
  {
    if ((paramaxyg != null) && (paramaxyg.jdField_a_of_type_JavaUtilList != null) && (paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      axtb localaxtb = new axtb();
      localaxtb.jdField_a_of_type_JavaLangString = "LongConn.ArtisticFilter";
      localaxtb.jdField_a_of_type_ArrayOfByte = a(paramaxyg.jdField_a_of_type_JavaUtilList);
      localaxtb.jdField_a_of_type_JavaLangObject = paramaxyg;
      localaxtb.jdField_a_of_type_Axta = this;
      a(paramaxyg, localaxtb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxq
 * JD-Core Version:    0.7.0.1
 */