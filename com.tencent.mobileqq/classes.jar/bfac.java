import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgReq;

public class bfac
  extends bfag
{
  void a(int paramInt, bfbf parambfbf, cmd0x352.ReqBody paramReqBody)
  {
    parambfbf = (bfbd)parambfbf;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(parambfbf.jdField_c_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_file_size.set(parambfbf.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambfbf.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(parambfbf.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(parambfbf.jdField_c_of_type_Boolean);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_bu_type.set(1);
    localTryUpImgReq.bool_pic_original.set(parambfbf.b);
    localTryUpImgReq.uint32_pic_width.set(parambfbf.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(parambfbf.d);
    localTryUpImgReq.uint32_pic_type.set(parambfbf.jdField_a_of_type_Int);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(bews.a()));
    localTryUpImgReq.bool_reject_tryfast.set(true);
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  public void a(bfau parambfau)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_JavaUtilList != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bevx localbevx = new bevx();
      localbevx.jdField_a_of_type_JavaLangString = "LongConn.ArtisticFilter";
      localbevx.jdField_a_of_type_ArrayOfByte = a(parambfau.jdField_a_of_type_JavaUtilList);
      localbevx.jdField_a_of_type_JavaLangObject = parambfau;
      localbevx.jdField_a_of_type_Bevw = this;
      a(parambfau, localbevx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfac
 * JD-Core Version:    0.7.0.1
 */