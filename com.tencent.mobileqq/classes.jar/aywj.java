import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.CustomFace;

public class aywj
  extends ayrd
{
  public im_msg_body.CustomFace a;
  
  public aywj(ayvv paramayvv, aywa paramaywa)
  {
    super(paramayvv, paramaywa);
  }
  
  void t()
  {
    if (this.jdField_a_of_type_Aywa.a != null)
    {
      x();
      auop localauop = new auop();
      localauop.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localauop.d = this.c;
      localauop.c = this.d;
      localauop.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aywa.i;
      localauop.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localauop.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_TencentImMsgIm_msg_body$CustomFace;
      this.jdField_a_of_type_Aywa.a.b(localauop);
      a(true);
    }
  }
  
  protected void x()
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    localCustomFace.uint32_file_id.set((int)this.jdField_a_of_type_Long);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject = (ayuo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localCustomFace.uint32_server_ip.set(a(((ayuo)localObject).jdField_a_of_type_JavaLangString));
      localCustomFace.uint32_server_port.set(((ayuo)localObject).jdField_a_of_type_Int);
    }
    localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
    localCustomFace.uint32_useful.set(1);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    }
    localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
    localCustomFace.str_file_path.set(this.d);
    Object localObject = localCustomFace.uint32_origin;
    if (this.l) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localCustomFace.uint32_width.set(this.p);
      localCustomFace.uint32_height.set(this.jdField_q_of_type_Int);
      localCustomFace.uint32_size.set((int)this.jdField_q_of_type_Long);
      localCustomFace.uint32_source.set(200);
      this.jdField_a_of_type_TencentImMsgIm_msg_body$CustomFace = localCustomFace;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aywj
 * JD-Core Version:    0.7.0.1
 */