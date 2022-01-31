import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgReq;

public class ayxz
  extends ayyd
{
  void a(int paramInt, ayza paramayza, cmd0x352.ReqBody paramReqBody)
  {
    paramayza = (ayyy)paramayza;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(paramayza.jdField_c_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_file_size.set(paramayza.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramayza.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramayza.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(paramayza.jdField_c_of_type_Boolean);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_bu_type.set(1);
    localTryUpImgReq.bool_pic_original.set(paramayza.b);
    localTryUpImgReq.uint32_pic_width.set(paramayza.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(paramayza.d);
    localTryUpImgReq.uint32_pic_type.set(paramayza.jdField_a_of_type_Int);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(ayuk.a()));
    localTryUpImgReq.bool_reject_tryfast.set(true);
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  public void a(ayyp paramayyp)
  {
    if ((paramayyp != null) && (paramayyp.jdField_a_of_type_JavaUtilList != null) && (paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      aytk localaytk = new aytk();
      localaytk.jdField_a_of_type_JavaLangString = "LongConn.ArtisticFilter";
      localaytk.jdField_a_of_type_ArrayOfByte = a(paramayyp.jdField_a_of_type_JavaUtilList);
      localaytk.jdField_a_of_type_JavaLangObject = paramayyp;
      localaytk.jdField_a_of_type_Aytj = this;
      a(paramayyp, localaytk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxz
 * JD-Core Version:    0.7.0.1
 */