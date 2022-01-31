import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.cs.smartptt.Smartptt.PttUpReq;
import tencent.im.cs.smartptt.Smartptt.ReqBody;

public class ayvj
{
  public static Smartptt.ReqBody a(ayvk paramayvk)
  {
    int j = 0;
    Smartptt.ReqBody localReqBody = new Smartptt.ReqBody();
    localReqBody.uint32_sub_cmd.set(3);
    Smartptt.PttUpReq localPttUpReq = new Smartptt.PttUpReq();
    localPttUpReq.uint32_bits_per_sample.set(16);
    localPttUpReq.uint32_voice_file_type.set(1);
    localPttUpReq.uint32_voice_encode_type.set(paramayvk.jdField_a_of_type_Int);
    localPttUpReq.uint32_samples_per_sec.set(16000);
    localPttUpReq.str_voice_id.set(paramayvk.jdField_a_of_type_JavaLangString);
    PBUInt32Field localPBUInt32Field = localPttUpReq.uint32_is_first;
    if (paramayvk.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localPBUInt32Field = localPttUpReq.uint32_is_end;
      i = j;
      if (paramayvk.jdField_b_of_type_Boolean) {
        i = 1;
      }
      localPBUInt32Field.set(i);
      localPttUpReq.uint32_offset.set(paramayvk.jdField_b_of_type_Int);
      localPttUpReq.str_Filemd5.set(paramayvk.jdField_c_of_type_JavaLangString);
      localPttUpReq.uint32_chat_type.set(paramayvk.e);
      localPttUpReq.uint32_service_id.set(1);
      localPttUpReq.uint32_voice_num.set(paramayvk.jdField_c_of_type_Int);
      localPttUpReq.uint32_voice_offset.set(paramayvk.d);
      localReqBody.msg_ptt_up_req.set(localPttUpReq);
      return localReqBody;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayvj
 * JD-Core Version:    0.7.0.1
 */