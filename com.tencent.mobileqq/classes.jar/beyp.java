import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.CustomFace;

public class beyp
  extends betv
{
  public im_msg_body.CustomFace a;
  
  public beyp(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
  }
  
  void s()
  {
    if (this.jdField_a_of_type_Beyg.a != null)
    {
      v();
      azrh localazrh = new azrh();
      localazrh.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localazrh.jdField_d_of_type_JavaLangString = this.c;
      localazrh.c = this.jdField_d_of_type_JavaLangString;
      localazrh.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Beyg.i;
      localazrh.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localazrh.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_TencentImMsgIm_msg_body$CustomFace;
      this.jdField_a_of_type_Beyg.a.b(localazrh);
      a(true);
    }
  }
  
  protected void v()
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    localCustomFace.uint32_file_id.set((int)this.jdField_a_of_type_Long);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject = (bewy)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localCustomFace.uint32_server_ip.set(a(((bewy)localObject).jdField_a_of_type_JavaLangString));
      localCustomFace.uint32_server_port.set(((bewy)localObject).jdField_a_of_type_Int);
    }
    localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
    localCustomFace.uint32_useful.set(1);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    }
    localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(this.b));
    localCustomFace.str_file_path.set(this.jdField_d_of_type_JavaLangString);
    Object localObject = localCustomFace.uint32_origin;
    if (this.n) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localCustomFace.uint32_width.set(this.jdField_d_of_type_Int);
      localCustomFace.uint32_height.set(this.jdField_q_of_type_Int);
      localCustomFace.uint32_size.set((int)this.jdField_q_of_type_Long);
      localCustomFace.uint32_source.set(200);
      this.jdField_a_of_type_TencentImMsgIm_msg_body$CustomFace = localCustomFace;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyp
 * JD-Core Version:    0.7.0.1
 */