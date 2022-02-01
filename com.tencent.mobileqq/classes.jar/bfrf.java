import android.graphics.Color;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.GroupBusinessMsg;

public class bfrf
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  public bfrf()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static bfrf a(im_msg_body.GroupBusinessMsg paramGroupBusinessMsg)
  {
    bfrf localbfrf = new bfrf();
    localbfrf.jdField_a_of_type_Int = paramGroupBusinessMsg.uint32_flags.get();
    localbfrf.jdField_a_of_type_JavaLangString = paramGroupBusinessMsg.bytes_head_url.get().toStringUtf8();
    localbfrf.jdField_b_of_type_JavaLangString = paramGroupBusinessMsg.bytes_head_clk_url.get().toStringUtf8();
    localbfrf.jdField_c_of_type_JavaLangString = paramGroupBusinessMsg.bytes_nick.get().toStringUtf8();
    localbfrf.jdField_d_of_type_JavaLangString = paramGroupBusinessMsg.bytes_rank.get().toStringUtf8();
    try
    {
      localbfrf.jdField_b_of_type_Int = Color.parseColor(paramGroupBusinessMsg.bytes_nick_color.get().toStringUtf8());
      localbfrf.jdField_c_of_type_Int = Color.parseColor(paramGroupBusinessMsg.bytes_rank_color.get().toStringUtf8());
      localbfrf.jdField_d_of_type_Int = Color.parseColor(paramGroupBusinessMsg.bytes_rank_bgcolor.get().toStringUtf8());
      return localbfrf;
    }
    catch (Exception paramGroupBusinessMsg)
    {
      QLog.e(bfre.jdField_a_of_type_JavaLangString, 2, "the color string cannot parse to color. " + paramGroupBusinessMsg.getMessage());
    }
    return localbfrf;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopBusinessMessage");
    localStringBuilder.append(",").append("nick").append("=").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(",").append("flag").append("=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",").append("clk").append("=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",").append("head").append("=").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfrf
 * JD-Core Version:    0.7.0.1
 */